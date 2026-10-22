package com.bytedance.rpc.transport.ttnet;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.f;
import com.bytedance.frameworks.baselib.network.http.util.k;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.IMetricsCollect;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.mime.TypedString;
import com.bytedance.rpc.RpcContext;
import com.bytedance.rpc.RpcDataBuilder;
import com.bytedance.rpc.internal.RpcUtils;
import com.bytedance.rpc.log.Logger;
import com.bytedance.rpc.serialize.ByteType;
import com.bytedance.rpc.transport.StreamClosedCallback;
import com.bytedance.rpc.transport.TransportCallback;
import com.bytedance.rpc.transport.TransportClient;
import com.bytedance.rpc.transport.TransportRequest;
import com.bytedance.rpc.transport.TransportResponse;
import com.bytedance.ttnet.b.b;
import com.bytedance.ttnet.b.d;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultTransportClient implements TransportClient {
    private static volatile List<Interceptor> sOkInterceptor;
    private Map<String, WeakReference<RetrofitApi>> mApiMap;
    private Map<Integer, WeakReference<Call<TypedInput>>> mCalls;

    static {
    }

    public DefaultTransportClient(RpcContext r2) {
        this.mApiMap = new ConcurrentHashMap(4);
        this.mCalls = new ConcurrentHashMap(4);
    }

    static /* synthetic */ TransportResponse access$000(DefaultTransportClient r2, Call r3, SsResponse r4) {
        return r2.convert((Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin"), r4);
    }

    static /* synthetic */ void access$100(DefaultTransportClient r2, Call r3, Throwable r4) {
        r2.reportError((Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin"), r4);
    }

    static /* synthetic */ Map access$200(DefaultTransportClient r0) {
        return r0.mCalls;
    }

    static /* synthetic */ void access$300(DefaultTransportClient r2, Call r3, Response r4, long r5) {
        r2.reportOK((Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    public static void addOkInterceptor(Interceptor r3) {
        Interceptor r4 = (Interceptor) ZeusTransformUtils.wrapperContextForParams(r3, Interceptor.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (sOkInterceptor != null) goto L17;
        monitor-enter(DefaultTransportClient.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (sOkInterceptor != null) goto L11;
        sOkInterceptor = Collections.synchronizedList(new ArrayList(2));     // Catch: Throwable -> L13
    L11:
        monitor-exit(DefaultTransportClient.class);     // Catch: Throwable -> L13
    L17:
        if (sOkInterceptor.contains(r4) == true) goto L23;
        sOkInterceptor.add(r4);
        return;
    }

    private TransportResponse convert(Call<TypedInput> r11, SsResponse<TypedInput> r12) {
        final Call r4 = (Call) ZeusTransformUtils.wrapperContextForParams(r11, Call.class, "com.obric.memorydata.plugin");
        final long r6 = System.currentTimeMillis();
        final Response r13 = r12.raw();
        TypedInput r0 = (TypedInput) ZeusTransformUtils.preCheckCast(r12.body(), TypedInput.class, "com.obric.memorydata.plugin");
        LinkedHashMap r8 = new LinkedHashMap();
        StreamClosedCallback r9 = new AnonymousClass2(this, r4, r13, r6);
        if (r0 != null) goto L5;
        DefaultTransportInput r10 = null;
    L7:
        if (r13.getHeaders() == null) goto L12;
        Iterator<Header> r14 = r13.getHeaders().iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        Header r1 = (Header) ZeusTransformUtils.preCheckCast(r14.next(), Header.class, "com.obric.memorydata.plugin");
        r8.put(r1.getName(), r1.getValue());
    L12:
        String r15 = r12.raw().getReason();
        if (TextUtils.isEmpty(r15) == true) goto L15;
    L17:
        int r16 = r12.code();
        if (r10 != null) goto L21;
        r9.onClosed();
    L21:
        return TransportResponse.newBuilder(r16).setHttpMsg(r15).setHeaders(r8).setBody(r10).build();
    L15:
        if (r12.isSuccessful() == true) goto L17;
        r15 = (String) ZeusTransformUtils.preCheckCast(r8.get("Reason-Phrase"), String.class, "com.obric.memorydata.plugin");
        goto L17
    L5:
        r10 = new DefaultTransportInput(r0, r9);
        goto L7
    }

    private TypedOutput createTypedOutput(RpcDataBuilder.SerializerData r9) {
        if (r9.isMutiData() == false) goto L25;
        MultipartTypedOutput r8 = new MultipartTypedOutput();
        Iterator<Map.Entry<String, String>> r3 = r9.getFields().entrySet().iterator();
    L6:
        if (r3.hasNext() == false) goto L12;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4.getValue(), String.class, "com.obric.memorydata.plugin");
        if (RpcUtils.isVisible(r5) == false) goto L6;
        if (RpcUtils.isVisible(r6) == false) goto L6;
        r8.addPart(r5, new TypedString(r6));
        goto L6
    L12:
        Iterator<Map.Entry<String, File>> r7 = r9.getFiles().entrySet().iterator();
    L14:
        if (r7.hasNext() == false) goto L21;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.getKey(), String.class, "com.obric.memorydata.plugin");
        File r12 = (File) ZeusTransformUtils.preCheckCast(r10.getValue(), File.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L14;
        if (RpcUtils.isInvisible(r11) == false) goto L20;
        r11 = r12.getName();
    L20:
        r8.addPart(r11, new TypedFile(null, r12));
        goto L14
    L21:
        Iterator<ByteType> r13 = r9.getData().iterator();
    L23:
        if (r13.hasNext() == false) goto L44;
        ByteType r0 = (ByteType) ZeusTransformUtils.preCheckCast(r13.next(), ByteType.class, "com.obric.memorydata.plugin");
        r8.addPart(r0.getName(), new TypedByteArray(r0.getContentType(), r0.getData(), new String[]{r0.getFileName()}));
        goto L23
    L44:
        return r8;
    L25:
        List<ByteType> r14 = r9.getData();
        if (r14.size() != 0) goto L29;
        return new TypedByteArray(null, RpcUtils.EMPTY_BYTE_ARR, new String[0]);
    L29:
        return new TypedByteArray(((ByteType) ZeusTransformUtils.preCheckCast(r14.get(0), ByteType.class, "com.obric.memorydata.plugin")).getContentType(), ((ByteType) ZeusTransformUtils.preCheckCast(r14.get(0), ByteType.class, "com.obric.memorydata.plugin")).getData(), new String[0]);
    }

    private RetrofitApi getApi(String r5) {
        WeakReference r0 = (WeakReference) ZeusTransformUtils.preCheckCast(this.mApiMap.get(r5), WeakReference.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        RetrofitApi r1 = null;
    L6:
        if (r1 != null) goto L9;
        RetrofitApi r2 = (RetrofitApi) ZeusTransformUtils.preCheckCast(RetrofitUtils.a(r5, sOkInterceptor, null).create(RetrofitApi.class), RetrofitApi.class, "com.obric.memorydata.plugin");
        this.mApiMap.put(r5, new WeakReference(r2));
        return r2;
    L9:
        return r1;
    L5:
        r1 = (RetrofitApi) ZeusTransformUtils.preCheckCast(r0.get(), RetrofitApi.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public static void removeOkInterceptor(Interceptor r2) {
        Interceptor r3 = (Interceptor) ZeusTransformUtils.wrapperContextForParams(r2, Interceptor.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        if (sOkInterceptor == null) goto L9;
        sOkInterceptor.remove(r3);
        return;
    }

    private void reportError(Call<TypedInput> r8, Throwable r9) {
        reportInner((Call) ZeusTransformUtils.wrapperContextForParams(r8, Call.class, "com.obric.memorydata.plugin"), null, System.currentTimeMillis(), false, r9);
    }

    private void reportInner(Call<TypedInput> r14, Response r15, long r16, boolean r18, Throwable r19) {
        Call r0 = (Call) ZeusTransformUtils.wrapperContextForParams(r14, Call.class, "com.obric.memorydata.plugin");
        long r2 = System.currentTimeMillis();
        if (ZeusTransformUtils.instanceOf(r0, IMetricsCollect.class) == false) goto L5;
        ((IMetricsCollect) ZeusTransformUtils.preCheckCast(r0, IMetricsCollect.class, "com.obric.memorydata.plugin")).doCollect();
    L5:
        b r4 = null;
        if (r15 == null) goto L8;
        Object r5 = r15.getExtraInfo();
    L10:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == false) goto L12;
        r4 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        Logger.d(r4.f2361J);
    L12:
        b r11 = r4;
        if (r11 == null) goto L18;
        r11.i = r16;
        r11.j = r2;
        long r7 = r11.g;
        long r6 = r11.j - r7;
        String r9 = r15.getUrl();
        String r10 = RetrofitUtils.a(r15.getHeaders(), "X-TT-LOGID");
        if (r18 == false) goto L17;
        f.a(r6, r7, r9, r10, r11);
        goto L18
    L17:
        f.a(r6, r7, r9, r10, r11, r19);
    L18:
        if (r0 != null) goto L20;
        return;
    L20:
        if (r0.isCanceled() == true) goto L24;
        r0.cancel();
        return;
    L24:
        return;
    L8:
        r5 = null;
        goto L10
    }

    private void reportOK(Call<TypedInput> r8, Response r9, long r10) {
        reportInner((Call) ZeusTransformUtils.wrapperContextForParams(r8, Call.class, "com.obric.memorydata.plugin"), r9, r10, true, null);
    }

    private Call<TypedInput> visitApi(TransportRequest r13) {
        int r0 = r13.getRequestId();
        String r1 = r13.getUrl();
        boolean r3 = r13.isParamsNeed();
        RpcDataBuilder.SerializerData r2 = r13.getRequestData();
        LinkedList r7 = new LinkedList();
        LinkedHashMap r5 = new LinkedHashMap(r2.getQueries());
        d r8 = new d();
        r8.c = r13.getConnectTimeout();
        r8.d = r13.getReadTimeout();
        r8.e = r13.getWriteTimeout();
        Iterator<Map.Entry<String, String>> r4 = r2.getHeaders().entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r6.getValue(), String.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L4;
        if (r9 == null) goto L4;
        r7.add(new Header(r10, r9));
        goto L4
    L9:
        Pair<String, String> r11 = k.a(r1, r5);
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11.first, String.class, "com.obric.memorydata.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r11.second, String.class, "com.obric.memorydata.plugin");
        RetrofitApi r15 = getApi(r12);
        if (r13.isPostMethod() == true) goto L12;
        Call<TypedInput> r16 = r15.get(r3, r14, r5, r7, r8);
    L16:
        this.mCalls.put(Integer.valueOf(r0), new WeakReference(r16));
        return r16;
    L12:
        if (r2.isFormData() == false) goto L14;
        r16 = r15.form(r3, r14, r5, new LinkedHashMap(r2.getFields()), r7, r8);
        goto L16
    L14:
        r16 = r15.post(r3, r14, r5, createTypedOutput(r2), r7, r8);
        goto L16
    }

    @Override // com.bytedance.rpc.transport.TransportClient
    public void cancel(int r5) {
        WeakReference r0 = (WeakReference) ZeusTransformUtils.preCheckCast(this.mCalls.get(Integer.valueOf(r5)), WeakReference.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L9:
        this.mCalls.remove(Integer.valueOf(r5));
        return;
    L5:
        if (r0.get() == null) goto L9;
        if (((Call) ZeusTransformUtils.preCheckCast(r0.get(), Call.class, "com.obric.memorydata.plugin")).isCanceled() == true) goto L9;
        ((Call) ZeusTransformUtils.preCheckCast(r0.get(), Call.class, "com.obric.memorydata.plugin")).cancel();
        goto L9
    }

    @Override // com.bytedance.rpc.transport.TransportClient
    public void destroy() {
        this.mApiMap.clear();
        this.mCalls.clear();
    }

    @Override // com.bytedance.rpc.transport.TransportClient
    public TransportResponse transport(TransportRequest r3) {
        Call<TypedInput> r0 = visitApi(r3);     // Catch: Throwable -> L8
        TransportResponse r1 = convert(r0, r0.execute());     // Catch: Throwable -> L6
        this.mCalls.remove(Integer.valueOf(r3.getRequestId()));
        return r1;
    L6:
        th = th;
    L15:
        reportError(r0, th);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        this.mCalls.remove(Integer.valueOf(r3.getRequestId()));
        throw th;
    L8:
        th = th;
        r0 = null;
        goto L15
    }

    @Override // com.bytedance.rpc.transport.TransportClient
    public void transport(TransportRequest r3, TransportCallback r4) {
        final TransportCallback r5 = (TransportCallback) ZeusTransformUtils.wrapperContextForParams(r4, TransportCallback.class, "com.obric.memorydata.plugin");
        final int r0 = r3.getRequestId();
        visitApi(r3).enqueue(new AnonymousClass1(this, r5, r0));
    }
}
