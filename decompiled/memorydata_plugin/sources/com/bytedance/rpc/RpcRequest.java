package com.bytedance.rpc;

import com.bytedance.rpc.callback.RpcCallback;
import com.bytedance.rpc.internal.RequestIdMonitor;
import com.bytedance.rpc.internal.TypeUtils;
import com.bytedance.rpc.serialize.SerializeType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Map;
import org.threeten.bp.Year;

/* JADX INFO: loaded from: classes2.dex */
public class RpcRequest {
    private static RequestIdMonitor sSeqIdProducer;
    private Object[] mArgs;
    private RpcCallback mCallback;
    private RpcInvokeContext mInvokeContext;
    private int mRequestId;
    RequestModifier mRequestModify;
    protected Type mRequiredResponseType;
    protected Type mReturnType;
    private RpcMethod mRpcMethod;

    static {
        sSeqIdProducer = new RequestIdMonitor(1, Year.MAX_VALUE);
    }

    RpcRequest(RpcInvokeContext r3, RpcMethod r4, Object[] r5, RpcCallback r6, Type r7) {
        RpcCallback r8 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r6, RpcCallback.class, "com.obric.memorydata.plugin");
        Type r9 = (Type) ZeusTransformUtils.wrapperContextForParams(r7, Type.class, "com.obric.memorydata.plugin");
        this.mInvokeContext = r3;
        this.mRpcMethod = r4;
        this.mArgs = r5;
        this.mCallback = r8;
        this.mRequestId = sSeqIdProducer.generateRingId();
        this.mReturnType = TypeUtils.normalizeType(this.mRpcMethod.getReturnType());
        if (isAsyncRequest() == false) goto L5;
        Type r10 = parserRequiredResponseType(r8, r9);
    L6:
        this.mRequiredResponseType = r10;
        return;
    L5:
        r10 = parserResponseTypeFromArguments(r5, this.mReturnType);
        goto L6
    }

    public RpcRequest(RpcRequest r2) {
        if (r2 == null) goto L6;
        this.mInvokeContext = r2.mInvokeContext;
        this.mRpcMethod = r2.mRpcMethod;
        this.mArgs = r2.mArgs;
        this.mCallback = r2.mCallback;
        this.mRequiredResponseType = r2.mRequiredResponseType;
        this.mReturnType = r2.mReturnType;
        this.mRequestId = r2.mRequestId;
        this.mRequestModify = r2.mRequestModify;
        return;
    }

    private Type parserRequiredResponseType(RpcCallback r4, Type r5) {
        RpcCallback r3 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r4, RpcCallback.class, "com.obric.memorydata.plugin");
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r5, Type.class, "com.obric.memorydata.plugin");
        Type[] r1 = null;
        if (ZeusTransformUtils.instanceOf(r6, ParameterizedType.class) == false) goto L10;
        Type[] r7 = ((ParameterizedType) ZeusTransformUtils.preCheckCast(r6, ParameterizedType.class, "com.obric.memorydata.plugin")).getActualTypeArguments();
        if (r7 == null) goto L10;
        if (r7.length == 0) goto L10;
        Type r8 = r7[0];
    L12:
        if (ZeusTransformUtils.instanceOf(r8, WildcardType.class) == false) goto L23;
        if (r3 == null) goto L16;
        r1 = r3.getClass().getGenericInterfaces();
    L16:
        if (r1 != null) goto L18;
        return r8;
    L18:
        if (r1.length > 0) goto L20;
        return r8;
    L20:
        if (ZeusTransformUtils.instanceOf(r1[0], ParameterizedType.class) == true) goto L22;
        return r8;
    L22:
        return ((ParameterizedType) ZeusTransformUtils.preCheckCast(r1[0], ParameterizedType.class, "com.obric.memorydata.plugin")).getActualTypeArguments()[0];
    L23:
        return r8;
    L10:
        r8 = null;
        goto L12
    }

    private Type parserResponseTypeFromArguments(Object[] r6, Type r7) {
        Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r7, Type.class, "com.obric.memorydata.plugin");
        Type r1 = null;
        if (r5 == Object.class) goto L5;
    L12:
        if (r1 != null) goto L15;
        return r5;
    L15:
        return r1;
    L5:
        if (r6.length <= 0) goto L12;
        int r8 = r6.length;
        int r2 = 0;
    L7:
        if (r2 >= r8) goto L12;
        Object r3 = r6[r2];
        if (ZeusTransformUtils.instanceOf(r3, Class.class) == false) goto L11;
        r1 = (Type) ZeusTransformUtils.preCheckCast(r3, Type.class, "com.obric.memorydata.plugin");
    L11:
        r2 = r2 + 1;
        goto L7
    }

    boolean collectCommonParams(Map<String, String> r8, Map<String, String> r9) {
        Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        String[] r0 = this.mRpcMethod.getBizParams();
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        if (r2 == 0) goto L8;
        int r3 = 0;
        int r4 = 0;
    L10:
        if (r3 >= r2) goto L15;
        if (this.mInvokeContext.collectCommonParams(r0[r3], r10, r11) == false) goto L14;
        r4 = r4 + 1;
    L14:
        r3 = r3 + 1;
        goto L10
    L15:
        if (r4 != r2) goto L21;
        return true;
    L21:
        return false;
    L8:
        return this.mInvokeContext.collectCommonParams(null, r10, r11);
    L5:
        r2 = r0.length;
        goto L6
    }

    public Object[] getArguments() {
        return this.mArgs;
    }

    public String getBaseUrl() {
        return this.mInvokeContext.getRpcConfig().getBaseUrl();
    }

    public RpcCallback getCallback() {
        return this.mCallback;
    }

    public Method getMethod() {
        return this.mRpcMethod.getMethod();
    }

    public String getOperationType() {
        return this.mRpcMethod.getOperationType();
    }

    public String getPath() {
        return this.mRpcMethod.getPath();
    }

    public int getRequestId() {
        return this.mRequestId;
    }

    public Type getRequiredResponseType() {
        return this.mRequiredResponseType;
    }

    public Type getReturnType() {
        return this.mReturnType;
    }

    public RpcInvokeContext getRpcInvokeContext() {
        return this.mInvokeContext;
    }

    public RpcMethod getRpcMethod() {
        return this.mRpcMethod;
    }

    public SerializeType getSerializeType() {
        return this.mRpcMethod.getSerializeType();
    }

    public Class getServiceClass() {
        return this.mRpcMethod.getServiceClass();
    }

    public boolean isAsyncRequest() {
        return this.mRpcMethod.isAsyncRequest();
    }

    public boolean isParamsNeed() {
        return this.mRpcMethod.isParamsNeed();
    }

    public boolean isPostRequest() {
        return this.mRpcMethod.isPostRequest();
    }
}
