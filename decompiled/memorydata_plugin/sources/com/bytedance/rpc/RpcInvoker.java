package com.bytedance.rpc;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.security.obric.guard.ObricSecurityGuardStub;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.callback.RpcCallback;
import com.bytedance.rpc.callback.RpcInterceptor;
import com.bytedance.rpc.callback.RpcInvokeInterceptor;
import com.bytedance.rpc.internal.RpcUtils;
import com.bytedance.rpc.internal.TypeUtils;
import com.bytedance.rpc.internal.WeakHandler;
import com.bytedance.rpc.log.Logger;
import com.bytedance.rpc.serialize.AbstractSerializer;
import com.bytedance.rpc.serialize.ByteType;
import com.bytedance.rpc.serialize.Deserializer;
import com.bytedance.rpc.serialize.SerializeFactory;
import com.bytedance.rpc.serialize.SerializeManager;
import com.bytedance.rpc.serialize.SerializeType;
import com.bytedance.rpc.serialize.Serializer;
import com.bytedance.rpc.transport.TransportClient;
import com.bytedance.rpc.transport.TransportClientFactory;
import com.bytedance.rpc.transport.TransportManager;
import com.bytedance.rpc.transport.TransportRequest;
import com.bytedance.rpc.transport.TransportRequestInterceptor;
import com.bytedance.rpc.transport.TransportResponse;
import com.bytedance.rpc.transport.TransportResult;
import com.bytedance.rpc.transport.TransportResultInterceptor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
class RpcInvoker implements RpcCaller.RpcInvoke, WeakHandler.IHandler {
    private static final ThreadLocal<RequestModifier> EXPORT_REQUEST_MODIFIER = null;
    private static final int MSG_CALLBACK = 5;
    private static final int MSG_DESERIALIZE = 4;
    private static final int MSG_SERIALIZE = 2;
    private static final int MSG_TIMEOUT = 1;
    private static final int MSG_TRANSPORT = 3;
    private static final ThreadLocal<Object> REQUEST_ID = null;
    private static final ThreadLocal<RpcRequestModifier> REQUEST_MODIFIER = null;
    private static final ThreadLocal<Object> RETURN_VALUE = null;
    private final Map<Integer, RpcRecorder> mRpcRecorder;
    private final SerializeManager mSerializeManager;
    private final WeakHandler mSerializerHandler;
    private final TransportManager mTransportManager;
    private final WeakHandler mUiHandler;

    static {
        REQUEST_ID = new ThreadLocal();
        RETURN_VALUE = new ThreadLocal();
        REQUEST_MODIFIER = new AnonymousClass1();
        EXPORT_REQUEST_MODIFIER = new AnonymousClass2();
    }

    public RpcInvoker(RpcContext r3) {
        this.mRpcRecorder = new ConcurrentHashMap();
        HandlerThread r0 = new HandlerThread("RpcSerialize");
        r0.start();
        this.mSerializeManager = new SerializeManager();
        this.mTransportManager = new TransportManager(r3);
        this.mUiHandler = new WeakHandler(Looper.getMainLooper(), this);
        this.mSerializerHandler = new WeakHandler(r0.getLooper(), this);
    }

    static /* synthetic */ WeakHandler access$000(RpcInvoker r0) {
        return r0.mSerializerHandler;
    }

    static /* synthetic */ WeakHandler access$100(RpcInvoker r0) {
        return r0.mUiHandler;
    }

    private Object invoke(RpcCaller r3, RpcRequest r4) {
        RpcCaller r5 = (RpcCaller) ZeusTransformUtils.wrapperContextForParams(r3, RpcCaller.class, "com.obric.memorydata.plugin");
        recordRequest(r4);
        return r5.invoke(this, r4);
    }

    private RpcRecorder recordRequest(RpcRequest r5) {
        int r0 = r5.getRequestId();
        REQUEST_ID.set(Integer.valueOf(r0));
        RpcRecorder r1 = (RpcRecorder) ZeusTransformUtils.preCheckCast(this.mRpcRecorder.get(Integer.valueOf(r0)), RpcRecorder.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        r1 = new RpcRecorder(r5);
        this.mRpcRecorder.put(Integer.valueOf(r0), r1);
        r1.watchTimeout(this.mUiHandler, 1);
        ThreadLocal<RequestModifier> r4 = EXPORT_REQUEST_MODIFIER;
        if (((RequestModifier) ZeusTransformUtils.preCheckCast(r4.get(), RequestModifier.class, "com.obric.memorydata.plugin")).hasOperate() == false) goto L8;
        r5.mRequestModify = (RequestModifier) ZeusTransformUtils.preCheckCast(r4.get(), RequestModifier.class, "com.obric.memorydata.plugin");
        r4.remove();
    L8:
        return r1;
    L7:
        r1.updateRequest(r5);
        goto L8
    }

    void cancelRequest(int r3) {
        cancelRequest(r3, false, null);
    }

    void cancelRequest(int r5, boolean r6, Throwable r7) {
        if (isRequestAlive(r5) == false) goto L18;
        RpcRecorder r0 = getRecorder(r5);
        this.mTransportManager.getTransport(r0).cancel(r5);
        if (r6 == false) goto L7;
        int r1 = RpcException.ErrorCode.CANCEL_TIMEOUT;
    L8:
        boolean r2 = r0.getRpcRequest().isAsyncRequest();
        r0.cancel();
        if (r6 == false) goto L11;
        String r8 = "请求超时";
    L13:
        if (r7 != null) goto L15;
        RpcException.Builder r9 = RpcException.fromNew(r1, r8);
    L16:
        catchException(r9.setSource(ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL).setRequestId(r5).build(), true, r2);
        return;
    L15:
        r9 = RpcException.from(r7).setInfo(r1, r8);
        goto L16
    L11:
        r8 = "";
        goto L13
    L7:
        r1 = RpcException.ErrorCode.CANCEL_USER;
        goto L8
    }

    void catchException(RpcException r4, boolean r5, boolean r6) {
        int r0 = r4.getRequestId();
        RpcRecorder r1 = getRecorder(r0);
        if (r1 == null) goto L26;
        r1.setLastException(r4);
        if (r5 == true) goto L11;
        if (r1.isCanceled() == true) goto L11;
        if (retryTransportAllowed(r1, r0, r6) == false) goto L11;
        return;
    L11:
        if (r5 == true) goto L13;
    L17:
        boolean r7 = false;
    L18:
        if (r7 == true) goto L22;
        if (r4.isCanceled() == false) goto L22;
        return;
    L22:
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L24;
        reportResult(r1, r4);
        return;
    L24:
        this.mUiHandler.obtainMessage(5, r0, 0, r4).sendToTarget();
        return;
    L13:
        if (r4.isCanceled() == false) goto L15;
    L16:
        r7 = true;
        goto L18
    L15:
        if (r4.isTimeout() == false) goto L17;
    }

    Object deserialize(RpcRequest r7, TransportResponse r8) {
        if (r8.isSuccessful() == true) goto L10;
        if (r8.getBody() == null) goto L8;
        RpcUtils.closeSilently(r8.getBody().in());
    L8:
        throw RpcException.fromHttp(r8.getHttpCode(), r8.getHttpMsg()).setSource(NotificationCompat.CATEGORY_TRANSPORT).setRequestId(r7.getRequestId()).build();
    L10:
        if (r8.getBody() == null) goto L41;
        Type r0 = r7.getRequiredResponseType();
        String r1 = r8.getContentType();
        Deserializer r3 = null;
        SerializeType r2 = this.mSerializeManager.parserDeserializerType(r1, r0, null);
        boolean r5 = false;
        if (r0 != InputStream.class) goto L15;
        Object r4 = r8.getBody().in();
    L28:
        Map<String, String> r6 = r8.getHeaders();
        if (r4 == null) goto L34;
        if (r5 == false) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, InputStream.class) == true) goto L34;
        SerializeManager.fillResult(r4, r6);
    L34:
        RpcRecorder r9 = getRecorder(r7.getRequestId());
        r9.mRequestFinishedTime = System.currentTimeMillis();
        RETURN_VALUE.set(r4);
        Object r10 = postHandle(r7, r4, r6);
        if (r10 == null) goto L38;
        r4 = r10;
    L38:
        interceptTransportResult(r9, r4, r8);
        return r4;
    L15:
        if (TypeUtils.isByteArrayType(r0) == false) goto L17;
        r4 = RpcUtils.toBytes(r8.getBody().in());
        goto L28
    L17:
        SerializeFactory r11 = this.mSerializeManager.getSerializeFactory(r2);
        if (r11 == null) goto L21;
        r3 = r11.getDeserializer(r8.getBody(), r0);
    L21:
        if (r3 == null) goto L23;
        r5 = r11.isReflectSupported();
        r4 = r3.parser();
        goto L28
    L23:
        if (r8.getBody() == null) goto L26;
        RpcUtils.closeSilently(r8.getBody().in());
    L26:
        throw new RuntimeException(String.format("could not found Deserializer with mineType %s to handle %s", new Object[]{r1, r0}));
    L41:
        throw RpcException.fromNew(RpcException.ErrorCode.NULL_RESPONSE_BODY, "response body is null").setSource(NotificationCompat.CATEGORY_TRANSPORT).setRequestId(r7.getRequestId()).build();
    }

    void exceptionHandle(RpcRequest r6, RpcException r7) {
        int r0 = 0;
        if (Logger.isLoggableE() == false) goto L5;
        Logger.e(String.format("rpc: exception exception=%s,request=%s", new Object[]{r7, r6}));
    L5:
        RpcInterceptor[] r5 = r6.getRpcInvokeContext().getRpcInterceptors();
        if (r5.length <= 0) goto L10;
        Class r1 = r6.getServiceClass();
        Method r2 = r6.getMethod();
        String r8 = r6.getOperationType();
        int r3 = r5.length;
    L8:
        if (r0 >= r3) goto L12;
        r5[r0].exceptionHandle(r1, r2, r7, r8);
        r0 = r0 + 1;
        goto L8
    L12:
        return;
    }

    Object execute(RpcRecorder r8, RpcRequest r9) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            Method dump skipped, instruction units count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.rpc.RpcInvoker.execute(com.bytedance.rpc.RpcRecorder, com.bytedance.rpc.RpcRequest):java.lang.Object");
    }

    void executeDeserialize(RpcRecorder r6, TransportResponse r7) {
        RpcRequest r8 = r6.getRpcRequest();
        Object r0 = deserialize(r8, r7);     // Catch: Exception -> L5
        this.mUiHandler.obtainMessage(5, r8.getRequestId(), 0, r0).sendToTarget();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        catchException(RpcException.from(e).setRequestId(r8.getRequestId()).setSource("deserialize").setTag(TransportResponse.class, r7).build(), true, true);
    }

    void executeSerialize(RpcRecorder r5) {
        RpcRequest r0 = r5.getRpcRequest();
        r5.recordRequest(serialize(r0));     // Catch: Exception -> L5
        this.mSerializerHandler.obtainMessage(3, r0.getRequestId(), 0).sendToTarget();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        catchException(RpcException.from(e).setRequestId(r0.getRequestId()).setSource("serialize").build(), true, true);
    }

    void executeTransport(final RpcRecorder r5) {
        TransportClient r0 = this.mTransportManager.getTransport(r5);
        final int r1 = r5.getRpcRequest().getRequestId();
        r0.transport(interceptTransportRequest(r5), new AnonymousClass3(this, r5, r1));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        catchException(RpcException.from(e).setRequestId(r1).setSource(NotificationCompat.CATEGORY_TRANSPORT).build(), false, true);
    }

    int getLatestRequestId() {
        Object r2 = REQUEST_ID.get();
        if (ZeusTransformUtils.instanceOf(r2, Integer.class) == true) goto L7;
        return 0;
    L7:
        return ((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    public RpcRecorder getRecorder(int r2) {
        return (RpcRecorder) ZeusTransformUtils.preCheckCast(this.mRpcRecorder.get(Integer.valueOf(r2)), RpcRecorder.class, "com.obric.memorydata.plugin");
    }

    RequestModifier getRequestModifier() {
        return (RequestModifier) ZeusTransformUtils.preCheckCast(EXPORT_REQUEST_MODIFIER.get(), RequestModifier.class, "com.obric.memorydata.plugin");
    }

    SerializeManager getSerializeManager() {
        return this.mSerializeManager;
    }

    @Override // com.bytedance.rpc.internal.WeakHandler.IHandler
    public void handleMsg(Message r7) {
        int r0 = r7.what;
        int r1 = r7.arg1;
        Handler r2 = r7.getTarget();
        RpcRecorder r3 = (RpcRecorder) ZeusTransformUtils.preCheckCast(this.mRpcRecorder.get(Integer.valueOf(r7.arg1)), RpcRecorder.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L28;
        if (r2 != null) goto L7;
        return;
    L7:
        if (this.mSerializerHandler != r2) goto L20;
        if (r3.isCanceled() == true) goto L20;
        if (2 != r0) goto L14;
        executeSerialize(r3);
        return;
    L14:
        if (3 != r0) goto L17;
        executeTransport(r3);
        return;
    L17:
        if (4 != r0) goto L31;
        executeDeserialize(r3, (TransportResponse) ZeusTransformUtils.preCheckCast(r7.obj, TransportResponse.class, "com.obric.memorydata.plugin"));
        return;
    L31:
        return;
    L20:
        if (this.mUiHandler == r2) goto L22;
        return;
    L22:
        if (1 != r0) goto L25;
        cancelRequest(r1, true, null);
        return;
    L25:
        if (5 != r0) goto L35;
        reportResult(r3, r7.obj);
        return;
    L35:
        return;
    }

    TransportRequest interceptTransportRequest(RpcRecorder r4) {
        TransportRequest r3 = r4.getTransportRequest();
        TransportRequestInterceptor[] r5 = r4.getRpcRequest().getRpcInvokeContext().getTransportRequestInterceptors();
        if (r5 != null) goto L5;
    L12:
        return r3;
    L5:
        if (r5.length <= 0) goto L12;
        int r0 = r5.length;
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L12;
        TransportRequest r2 = r5[r1].interceptRequest(r3);
        if (r2 == null) goto L11;
        r3 = r2;
    L11:
        r1 = r1 + 1;
        goto L7
    }

    void interceptTransportResult(RpcRecorder r6, Object r7, TransportResponse r8) {
        RpcRequest r5 = r6.getRpcRequest();
        if (r5 != null) goto L5;
        return;
    L5:
        if (r8 == null) goto L7;
    L9:
        int r1 = 0;
        if (Logger.isLoggableD() == false) goto L19;
        int r0 = r5.getRequestId();
        if (r8 != null) goto L14;
        String r2 = String.format("rpc: result (requestId=%d,error=%s)", new Object[]{Integer.valueOf(r0), r7});
    L16:
        if (ZeusTransformUtils.instanceOf(r7, RpcException.class) == false) goto L18;
        Logger.e(r2);
        goto L19
    L18:
        Logger.d(r2);
        goto L19
    L14:
        r2 = String.format("rpc: result (requestId=%d,code=%d,msg=%s,data=%s,headers=%s)", new Object[]{Integer.valueOf(r0), Integer.valueOf(r8.getHttpCode()), r8.getHttpMsg(), r7, r8.getHeaders()});
    L19:
        TransportResultInterceptor[] r3 = r5.getRpcInvokeContext().getTransportResultInterceptors();
        if (r3 != null) goto L22;
        return;
    L22:
        if (r3.length <= 0) goto L46;
        TransportResult.Builder r4 = new TransportResult.Builder();
        r4.setResult(r7);
        r4.setRequestId(r5.getRequestId());
        r4.setRequestReceivedTime(r6.getRequestReceivedTime());
        r4.setRequestTransformTime(r6.getRequestTransformTime());
        r4.setRequestSerializeTime(r6.getRequestSerializeTime());
        r4.setRequestFinishedTime(r6.getRequestFinishedTime());
        if (r8 == null) goto L26;
        r4.setHttpCode(r8.getHttpCode());
        r4.setHttpMsg(r8.getHttpMsg());
        r4.setHeaders(r8.getHeaders());
        r4.setContentType(r8.getContentType());
        r4.setContentLength(r8.getContentLength());
    L26:
        TransportResult r9 = r4.build();
        TransportRequest r10 = r6.getTransportRequest();
        if (r10 != null) goto L29;
        r10 = TransportRequest.newBuilder(r5.getRequestId()).build();
    L29:
        int r11 = r3.length;
    L30:
        if (r1 >= r11) goto L47;
        r3[r1].interceptResult(r9, r10);     // Catch: Throwable -> L34
    L38:
        r1 = r1 + 1;
    L34:
        th = move-exception;
        if (Logger.isLoggableE() == false) goto L38;
        th.printStackTrace();
        goto L38
    L47:
        return;
    L46:
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r7, RpcException.class) == false) goto L9;
        r8 = (TransportResponse) ZeusTransformUtils.preCheckCast(((RpcException) ZeusTransformUtils.preCheckCast(r7, RpcException.class, "com.obric.memorydata.plugin")).getTag(TransportResponse.class), TransportResponse.class, "com.obric.memorydata.plugin");
        goto L9
    }

    @Override // com.bytedance.rpc.RpcCaller.RpcInvoke
    public Object invoke(RpcRequest r3) {
        RpcRecorder r0 = recordRequest(r3);
        if (r3.isAsyncRequest() == false) goto L6;
        this.mSerializerHandler.obtainMessage(2, r3.getRequestId(), 0).sendToTarget();
        return null;
    L6:
        return execute(r0, r3);
    }

    Object invokeWithIntercept(RpcRequest r7) {
        int r1 = 0;
        if (RpcUtils.isInvisible(this.mSerializeManager.getAcceptContentTypes()) == true) goto L22;
        RpcCaller r0 = null;
        RpcInvokeInterceptor[] r2 = r7.getRpcInvokeContext().getRpcInvokeInterceptors();
        if (r2 != null) goto L7;
    L17:
        if (r0 != null) goto L20;
        return invoke(r7);
    L20:
        return invoke(r0, r7);
    L7:
        if (r2.length <= 0) goto L17;
        int r3 = r2.length;
    L9:
        if (r1 >= r3) goto L17;
        RpcInvokeInterceptor r4 = r2[r1];
        RpcCaller r5 = r4.invoke(r7.getServiceClass(), r7);     // Catch: Throwable -> L14
        if (r5 == null) goto L16;
        r0 = r5;
    L16:
        r1 = r1 + 1;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L16
    L22:
        throw new RuntimeException(String.format("did you add any rpc-adapter in your dependence ,no serialize factory found", new Object[0]));
    }

    boolean isRequestAlive(int r1) {
        RpcRecorder r0 = getRecorder(r1);
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.getRpcRequest() == null) goto L9;
        if (r0.isCanceled() == true) goto L9;
        return true;
    }

    Object postHandle(RpcRequest r17, Object r18, Map<String, String> r19) {
        Map<String, String> r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.memorydata.plugin");
        RpcInterceptor[] r8 = r17.getRpcInvokeContext().getRpcInterceptors();
        if (r8.length <= 0) goto L11;
        Class r9 = r17.getServiceClass();
        Method r10 = r17.getMethod();
        ThreadLocal<Object> r11 = RETURN_VALUE;
        String r12 = r17.getOperationType();
        int r13 = r17.getRequestId();
        int r14 = r8.length;
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L11;
        if (r8[r15].postHandle(r9, r10, r18, r11, r0, r12) == false) goto L8;
        r15 = r15 + 1;
        goto L5
    L8:
        throwWhenHandleIntercepted(r13, "postHandle");
    L11:
        return RETURN_VALUE.get();
    }

    void preHandle(RpcInvokeContext r13, RpcRequest r14, RpcRequestModifier r15) {
        RpcInterceptor[] r16 = r13.getRpcInterceptors();
        if (r16.length <= 0) goto L10;
        Class r0 = r14.getServiceClass();
        Method r7 = r14.getMethod();
        Object[] r8 = r14.getArguments();
        String r9 = r14.getOperationType();
        int r17 = r14.getRequestId();
        int r10 = r16.length;
        int r11 = 0;
    L5:
        if (r11 >= r10) goto L14;
        if (r16[r11].preHandle(r0, r7, r8, r15, r9) == false) goto L8;
        r11 = r11 + 1;
        goto L5
    L8:
        throwWhenHandleIntercepted(r17, "preHandle");
        return;
    L14:
        return;
    }

    void registerSerializeFactory(SerializeFactory r3) {
        SerializeFactory r4 = (SerializeFactory) ZeusTransformUtils.wrapperContextForParams(r3, SerializeFactory.class, "com.obric.memorydata.plugin");
        this.mSerializeManager.registerSerializeFactory(r4);
    }

    void removeSerializeFactory(SerializeType r1) {
        this.mSerializeManager.removeSerializeFactory(r1);
    }

    void reportResult(RpcRecorder r6, Object r7) {
        RpcRequest r0 = r6.getRpcRequest();
        if (r0 != null) goto L25;
        return;
    L25:
        RpcCallback r1 = r0.getCallback();     // Catch: Throwable -> L21
        if (r1 == null) goto L17;
        if (r0.isAsyncRequest() == false) goto L17;
        if (r1 != null) goto L12;
    L20:
        r6.clear();
        this.mRpcRecorder.remove(Integer.valueOf(r0.getRequestId()));
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r7, RpcException.class) == false) goto L15;
        RpcException r8 = (RpcException) ZeusTransformUtils.preCheckCast(r7, RpcException.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        r6.mRequestFinishedTime = System.currentTimeMillis();     // Catch: Throwable -> L21
        r1.onFailure(r8);     // Catch: Throwable -> L21
        exceptionHandle(r0, r8);     // Catch: Throwable -> L21
    L14:
        interceptTransportResult(r6, r8, null);     // Catch: Throwable -> L21
        goto L20
    L15:
        r1.onSuccess(r7);     // Catch: Throwable -> L21
    L17:
        if (ZeusTransformUtils.instanceOf(r7, RpcException.class) == false) goto L20;
        r8 = (RpcException) ZeusTransformUtils.preCheckCast(r7, RpcException.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        r6.mRequestFinishedTime = System.currentTimeMillis();     // Catch: Throwable -> L21
        exceptionHandle(r0, r8);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        r6.clear();
        this.mRpcRecorder.remove(Integer.valueOf(r0.getRequestId()));
        throw th;
    }

    boolean retryTransportAllowed(RpcRecorder r2, int r3, boolean r4) {
        boolean r5 = this.mTransportManager.isRetryTransportAllowed(r2);
        if (r5 == false) goto L6;
        if (r4 == false) goto L6;
        this.mSerializerHandler.obtainMessage(3, r3, 0).sendToTarget();
    L6:
        return r5;
    }

    TransportRequest serialize(RpcRequest r17) {
        HashMap r3 = new HashMap(4);
        RpcRequestModifier r4 = (RpcRequestModifier) ZeusTransformUtils.preCheckCast(REQUEST_MODIFIER.get(), RpcRequestModifier.class, "com.obric.memorydata.plugin");
        RpcDataBuilder r5 = new RpcDataBuilder();
        TransportRequest.Builder r7 = TransportRequest.newBuilder(r17.getRequestId());
        r4.reset(r17);
        if (r17.mRequestModify == null) goto L5;
        r17.mRequestModify.apply(r4);
    L5:
        r17.collectCommonParams(r5.getHeaders(), r5.getQueries());
        r5.addHeader("Accept", this.mSerializeManager.getAcceptContentTypes());
        preHandle(r17.getRpcInvokeContext(), r17, r4);
        r7.setBaseUrl(r4.getBaseUrl()).setPath(r4.getPathUrl()).setMethod(r17.isPostRequest()).setParamsNeed(r4.isParamsNeed()).setConnectTimeout(r4.getConnectTimeout()).setReadTimeout(r4.getReadTimeout()).setWriteTimeout(r4.getWriteTimeout());
        Object[] r8 = r4.filterArgs(r17.getArguments(), r17.getRpcMethod().getParameterAnnotations(), r5.getQueries());
        SerializeType r9 = r4.getSerializeType();
        SerializeFactory r0 = this.mSerializeManager.getSerializeFactory(r9);
        if (r0 != null) goto L8;
        boolean r11 = false;
    L10:
        if (r11 == false) goto L36;
        int r12 = r8.length;
        int r15 = 0;
    L12:
        if (r15 >= r12) goto L21;
        Object r13 = r8[r15];
        if (r13 == null) goto L19;
        if (r13.getClass().getAnnotation(RpcFieldModify.class) == null) goto L19;
        SerializeManager.dump(r13, r5.getHeaders(), r5.getQueries(), r3);
    L19:
        r15 = r15 + 1;
        goto L12
    L21:
        if (r3.size() <= 0) goto L36;
        Iterator r6 = r3.entrySet().iterator();
        boolean r10 = true;
    L24:
        if (r6.hasNext() == false) goto L37;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r16 = (String) ZeusTransformUtils.preCheckCast(r14.getKey(), String.class, "com.obric.memorydata.plugin");
        Object r18 = r14.getValue();
        if ((r18 instanceof byte[]) == false) goto L28;
        r5.addDataType((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r18, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"), "multipart/form-data", r16);
    L33:
        r10 = false;
        goto L24
    L28:
        if (r0 != null) goto L30;
        Serializer r19 = null;
    L31:
        if (r19 == null) goto L35;
        r5.setDataType(r19.packet());
        goto L33
    L35:
        throw new RuntimeException(String.format("could not found Serializer with mineType %s", new Object[]{r9.getContentType()}));
    L30:
        r19 = r0.getSerializer(r8, r9);
    L37:
        if (r10 == false) goto L58;
        RpcDataBuilder.SerializerData r2 = AbstractSerializer.getSerializerData(r8);
        if (r2 == null) goto L41;
        r5.apply(r2);
        goto L58
    L41:
        if (r17.isPostRequest() == true) goto L43;
        Map<String, String> r1 = r5.getQueries();
    L56:
        SerializeManager.dumpQuery(r8, r1);
        goto L58
    L43:
        if (r9 != SerializeType.FORM) goto L45;
        r1 = r5.getFields();
        goto L56
    L45:
        if (r0 != null) goto L47;
        Serializer r110 = null;
    L48:
        if (r110 == null) goto L54;
        ByteType r20 = r110.packet();
        if (r4.isRequestGzip() == false) goto L52;
        r5.setDataType(RpcUtils.gzip(r20.getData()), r20.getContentType());
        r5.addHeader(NetConst.KEY_CONTENT_ENCODING, NetConst.GZIP);
        goto L58
    L52:
        r5.setDataType(r20);
        goto L58
    L54:
        throw new RuntimeException(String.format("could not found Serializer with mineType %s", new Object[]{r9.getContentType()}));
    L47:
        r110 = r0.getSerializer(r8, r9);
    L58:
        r4.applyHeader(r5.getHeaders());
        r4.applyQuery(r5.getQueries());
        r4.applyField(r5.getFields());
        TransportRequest r21 = r7.setSerializerData(r5.build()).build();
        if (Logger.isLoggableD() == false) goto L61;
        Logger.d(String.format("rpc: request %s", new Object[]{r21}));
    L61:
        return r21;
    L36:
        r10 = true;
        goto L37
    L8:
        r11 = r0.isReflectSupported();
        goto L10
    }

    void setTransportFactory(TransportClientFactory r3) {
        TransportClientFactory r4 = (TransportClientFactory) ZeusTransformUtils.wrapperContextForParams(r3, TransportClientFactory.class, "com.obric.memorydata.plugin");
        this.mTransportManager.setTransportFactory(r4);
    }

    void throwWhenHandleIntercepted(int r2, String r3) {
        throw RpcException.from(new RuntimeException("this request intercepted by your RpcInterceptor")).setCode(RpcException.ErrorCode.RPCINTERCEPTED).setRequestId(r2).setSource(r3).build();
    }

    TransportResponse transport(RpcRecorder r2) {
        return this.mTransportManager.getTransport(r2).transport(interceptTransportRequest(r2));
    }

    void updateConfig(RpcConfig r1) {
        this.mTransportManager.updateConfig(r1);
    }
}
