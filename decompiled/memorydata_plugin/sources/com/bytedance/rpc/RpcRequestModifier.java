package com.bytedance.rpc;

import com.bytedance.rpc.annotation.RpcPath;
import com.bytedance.rpc.internal.RpcUtils;
import com.bytedance.rpc.serialize.SerializeType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class RpcRequestModifier {
    protected long mConnectTimeout;
    protected final Map<Integer, Map<String, String>> mOperatorField;
    protected final Map<Integer, Map<String, String>> mOperatorHeader;
    protected final Map<Integer, Map<String, String>> mOperatorQuery;
    protected boolean mParamsNeed;
    protected long mReadTimeout;
    protected boolean mRequestGzip;
    protected SerializeType mSerializeType;
    protected final String[] mUrls;
    protected long mWriteTimeout;

    RpcRequestModifier(RpcContext r3) {
        this.mParamsNeed = true;
        this.mRequestGzip = true;
        this.mUrls = new String[2];
        this.mOperatorHeader = new HashMap(2);
        this.mOperatorQuery = new HashMap(2);
        this.mOperatorField = new HashMap(2);
        if (r3 != null) goto L5;
        RpcConfig r4 = null;
    L6:
        if (r4 == null) goto L9;
        updateConfig(r4);
        return;
    L9:
        return;
    L5:
        r4 = r3.getRpcConfig();
        goto L6
    }

    private Map<String, String> apply(Map<Integer, Map<String, String>> r3, Map<String, String> r4) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        r5 = new HashMap();
    L5:
        Map<? extends String, ? extends String> r6 = (Map) ZeusTransformUtils.preCheckCast(r2.get(1), Map.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L8;
    L10:
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(r2.get(0), Map.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L13;
    L18:
        return r5;
    L13:
        if (r7.isEmpty() == true) goto L18;
        Iterator r8 = r7.keySet().iterator();
    L16:
        if (r8.hasNext() == false) goto L18;
        r5.remove((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin"));
        goto L16
    L8:
        if (r6.isEmpty() == true) goto L10;
        r5.putAll(r6);
        goto L10
    }

    private void resetOperator(Map<Integer, Map<String, String>> r3, Map<Integer, Map<String, String>> r4, int r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Map<Integer, Map<String, String>> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Map<? extends String, ? extends String> r8 = (Map) ZeusTransformUtils.preCheckCast(r6.get(Integer.valueOf(r5)), Map.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
    L8:
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(r7.get(Integer.valueOf(r5)), Map.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L13;
        r2.clear();
        return;
    L13:
        return;
    L5:
        if (r8.isEmpty() == true) goto L8;
        Map<String, String> r9 = get(Integer.valueOf(r5), r7);
        r9.clear();
        r9.putAll(r8);
    }

    public void addField(String r2, String r3) {
        put(this.mOperatorField, r2, r3);
    }

    public void addHeader(String r2, String r3) {
        put(this.mOperatorHeader, r2, r3);
    }

    public void addQuery(String r2, String r3) {
        put(this.mOperatorQuery, r2, r3);
    }

    Map<String, String> applyField(Map<String, String> r3) {
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        return apply(this.mOperatorField, r4);
    }

    Map<String, String> applyHeader(Map<String, String> r3) {
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        return apply(this.mOperatorHeader, r4);
    }

    Map<String, String> applyQuery(Map<String, String> r3) {
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        return apply(this.mOperatorQuery, r4);
    }

    Object[] filterArgs(Object[] r8, Annotation[][] r9, Map<String, String> r10) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        int r11 = r9.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r11) goto L15;
        Annotation[] r4 = r9[r2];
        if (r4 == null) goto L12;
        if (r4.length <= 0) goto L12;
        if (ZeusTransformUtils.instanceOf(r4[0], RpcPath.class) == false) goto L12;
        r7.put(((RpcPath) ZeusTransformUtils.preCheckCast(r4[0], RpcPath.class, "com.obric.memorydata.plugin")).value(), String.valueOf(r8[r2]));
    L14:
        r2 = r2 + 1;
    L12:
        if (ZeusTransformUtils.instanceOf(r8[r2], Class.class) == true) goto L14;
        r8[r3] = r8[r2];
        r3 = r3 + 1;
        goto L14
    L15:
        if (r3 > r11) goto L20;
        Object[] r12 = new Object[r3];
        if (r3 <= 0) goto L19;
        System.arraycopy(r8, 0, r12, 0, r3);
    L19:
        return r12;
    L20:
        return r8;
    }

    public Map<String, String> get(Integer r3, Map<Integer, Map<String, String>> r4) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Map<String, String> r5 = (Map) ZeusTransformUtils.preCheckCast(r2.get(r3), Map.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        HashMap r6 = new HashMap(4);
        r2.put(r3, r6);
        return r6;
    L6:
        return r5;
    }

    String getBaseUrl() {
        return this.mUrls[0];
    }

    long getConnectTimeout() {
        return this.mConnectTimeout;
    }

    String getPathUrl() {
        return this.mUrls[1];
    }

    long getReadTimeout() {
        return this.mReadTimeout;
    }

    SerializeType getSerializeType() {
        return this.mSerializeType;
    }

    long getWriteTimeout() {
        return this.mWriteTimeout;
    }

    boolean isParamsNeed() {
        return this.mParamsNeed;
    }

    boolean isRequestGzip() {
        return this.mRequestGzip;
    }

    public void put(Map<Integer, Map<String, String>> r3, String r4, String r5) {
        Map<Integer, Map<String, String>> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (RpcUtils.isVisible(r4) == false) goto L9;
        Map<String, String> r0 = get(1, r6);
        Map<String, String> r2 = get(0, r6);
        if (r5 != null) goto L7;
        r0.remove(r4);
        r2.put(r4, "");
        return;
    L7:
        r2.remove(r4);
        r0.put(r4, r5);
        return;
    }

    RpcRequestModifier reset(RpcRequest r6) {
        RpcRequestModifier r0 = r6.getRpcInvokeContext().getModifier();
        this.mConnectTimeout = r0.getConnectTimeout();
        this.mReadTimeout = r0.getReadTimeout();
        this.mWriteTimeout = r0.getWriteTimeout();
        this.mUrls[0] = r0.getBaseUrl();
        this.mUrls[1] = r6.getPath();
        this.mParamsNeed = r6.isParamsNeed();
        this.mSerializeType = r6.getSerializeType();
        this.mRequestGzip = r6.getRpcInvokeContext().getRpcConfig().isRequestGzip();
        resetOperator(r0.mOperatorHeader, this.mOperatorHeader, 0);
        resetOperator(r0.mOperatorHeader, this.mOperatorHeader, 1);
        resetOperator(r0.mOperatorQuery, this.mOperatorQuery, 0);
        resetOperator(r0.mOperatorQuery, this.mOperatorQuery, 1);
        resetOperator(r0.mOperatorField, this.mOperatorField, 0);
        resetOperator(r0.mOperatorField, this.mOperatorField, 1);
        return this;
    }

    public void setBaseUrl(String r2) {
        this.mUrls[0] = r2;
    }

    public void setParamsNeed(boolean r1) {
        this.mParamsNeed = r1;
    }

    public void setPathUrl(String r2) {
        this.mUrls[1] = r2;
    }

    public void setRequestGzip(boolean r1) {
        this.mRequestGzip = r1;
    }

    public void setSerializeType(SerializeType r1) {
        if (r1 == null) goto L5;
        this.mSerializeType = r1;
        return;
    }

    public void setTimeout(long r1, long r3, long r5) {
        this.mConnectTimeout = r1;
        this.mReadTimeout = r3;
        this.mWriteTimeout = r5;
    }

    void updateConfig(RpcConfig r3) {
        this.mConnectTimeout = r3.getConnectTimeout();
        this.mReadTimeout = r3.getReadTimeout();
        this.mWriteTimeout = r3.getWriteTimeout();
        this.mRequestGzip = r3.isRequestGzip();
        this.mUrls[0] = r3.getBaseUrl();
    }
}
