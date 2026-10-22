package com.bytedance.rpc;

import android.app.Application;
import com.bytedance.rpc.callback.RpcInterceptor;
import com.bytedance.rpc.callback.RpcInvokeInterceptor;
import com.bytedance.rpc.serialize.SerializeManager;
import com.bytedance.rpc.transport.TransportRequestInterceptor;
import com.bytedance.rpc.transport.TransportResultInterceptor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class RpcContext {
    private final Application mApplicationContext;
    private final Map<String, Map<String, String>> mCommonHeaders;
    private final Map<String, Object> mCommonParams;
    private final Map<String, Map<String, String>> mCommonQueries;
    private RpcConfig mConfig;
    private final List<RpcInterceptor> mRpcInterceptorList;
    private final List<RpcInvokeInterceptor> mRpcInvokeInterceptor;
    private final List<TransportRequestInterceptor> mTransportRequestInterceptorList;
    private final List<TransportResultInterceptor> mTransportResultInterceptorList;

    RpcContext(Application r4, RpcConfig r5) {
        Application r6 = (Application) ZeusTransformUtils.wrapperContextForParams(r4, Application.class, "com.obric.memorydata.plugin");
        this.mRpcInterceptorList = new ArrayList(4);
        this.mTransportRequestInterceptorList = new ArrayList(2);
        this.mTransportResultInterceptorList = new ArrayList(2);
        this.mRpcInvokeInterceptor = new ArrayList(2);
        this.mCommonParams = new HashMap(4);
        this.mCommonHeaders = new HashMap(2);
        this.mCommonQueries = new HashMap(2);
        this.mApplicationContext = r6;
        this.mConfig = r5;
    }

    private void loadCommonParams(String r4, Object r5) {
        HashMap r0 = new HashMap(8);
        HashMap r2 = new HashMap(8);
        SerializeManager.dump(r5, r0, r2, null);
        this.mCommonHeaders.put(r4, r0);
        this.mCommonQueries.put(r4, r2);
    }

    public void addRpcInterceptor(RpcInterceptor r3) {
        RpcInterceptor r4 = (RpcInterceptor) ZeusTransformUtils.wrapperContextForParams(r3, RpcInterceptor.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L14;
        List<RpcInterceptor> r0 = this.mRpcInterceptorList;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.mRpcInterceptorList.contains(r4) == true) goto L9;
        this.mRpcInterceptorList.add(r4);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    }

    public void addRpcInvokeInterceptor(RpcInvokeInterceptor r3) {
        RpcInvokeInterceptor r4 = (RpcInvokeInterceptor) ZeusTransformUtils.wrapperContextForParams(r3, RpcInvokeInterceptor.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.mRpcInvokeInterceptor.contains(r4) == true) goto L9;
        this.mRpcInvokeInterceptor.add(r4);
        return;
    }

    public void addTransportRequestInterceptor(TransportRequestInterceptor r3) {
        TransportRequestInterceptor r4 = (TransportRequestInterceptor) ZeusTransformUtils.wrapperContextForParams(r3, TransportRequestInterceptor.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L14;
        List<TransportRequestInterceptor> r0 = this.mTransportRequestInterceptorList;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.mTransportRequestInterceptorList.contains(r4) == true) goto L9;
        this.mTransportRequestInterceptorList.add(r4);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    }

    public void addTransportResultInterceptor(TransportResultInterceptor r3) {
        TransportResultInterceptor r4 = (TransportResultInterceptor) ZeusTransformUtils.wrapperContextForParams(r3, TransportResultInterceptor.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L14;
        List<TransportResultInterceptor> r0 = this.mTransportResultInterceptorList;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.mTransportResultInterceptorList.contains(r4) == true) goto L9;
        this.mTransportResultInterceptorList.add(r4);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    }

    boolean collectCommonParams(String r6, Map<String, String> r7, Map<String, String> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Map<String, Object> r0 = this.mCommonParams;
        monitor-enter(r0);
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(this.mCommonHeaders.get(r6), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(this.mCommonQueries.get(r6), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r1 == null) goto L7;
        if (r2 == null) goto L7;
    L10:
        if (r1 == null) goto L16;
        if (r2 == null) goto L16;
        r9.putAll(r1);     // Catch: Throwable -> L18
        r10.putAll(r2);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return true;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return false;
    L7:
        Object r3 = this.mCommonParams.remove(r6);     // Catch: Throwable -> L18
        if (r3 == null) goto L10;
        loadCommonParams(r6, r3);     // Catch: Throwable -> L18
        r1 = (Map) ZeusTransformUtils.preCheckCast(this.mCommonHeaders.get(r6), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        r2 = (Map) ZeusTransformUtils.preCheckCast(this.mCommonQueries.get(r6), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public Application getApplicationContext() {
        return this.mApplicationContext;
    }

    public RpcConfig getRpcConfig() {
        return this.mConfig;
    }

    List<RpcInterceptor> getRpcInterceptors() {
        return this.mRpcInterceptorList;
    }

    List<RpcInvokeInterceptor> getRpcInvokeInterceptors() {
        return this.mRpcInvokeInterceptor;
    }

    List<TransportRequestInterceptor> getTransportRequestInterceptors() {
        return this.mTransportRequestInterceptorList;
    }

    List<TransportResultInterceptor> getTransportResultInterceptors() {
        return this.mTransportResultInterceptorList;
    }

    void registerBizModel(String r4, Object r5) {
        Map<String, Object> r0 = this.mCommonParams;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mCommonParams.put(r4, r5) == null) goto L11;
        Map r6 = (Map) ZeusTransformUtils.preCheckCast(this.mCommonHeaders.remove(r4), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(this.mCommonQueries.remove(r4), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (r6 == null) goto L9;
        r6.clear();     // Catch: Throwable -> L13
    L9:
        if (r3 == null) goto L11;
        r3.clear();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    public void removeRpcInterceptor(RpcInterceptor r3) {
        RpcInterceptor r4 = (RpcInterceptor) ZeusTransformUtils.wrapperContextForParams(r3, RpcInterceptor.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L12;
        List<RpcInterceptor> r0 = this.mRpcInterceptorList;
        monitor-enter(r0);
        this.mRpcInterceptorList.remove(r4);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void removeRpcInvokeInterceptor(RpcInvokeInterceptor r3) {
        RpcInvokeInterceptor r4 = (RpcInvokeInterceptor) ZeusTransformUtils.wrapperContextForParams(r3, RpcInvokeInterceptor.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.mRpcInvokeInterceptor.remove(r4);
        return;
    }

    public void removeTransportRequestInterceptor(TransportRequestInterceptor r3) {
        TransportRequestInterceptor r4 = (TransportRequestInterceptor) ZeusTransformUtils.wrapperContextForParams(r3, TransportRequestInterceptor.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L12;
        List<TransportRequestInterceptor> r0 = this.mTransportRequestInterceptorList;
        monitor-enter(r0);
        this.mTransportRequestInterceptorList.remove(r4);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void removeTransportResultInterceptor(TransportResultInterceptor r3) {
        TransportResultInterceptor r4 = (TransportResultInterceptor) ZeusTransformUtils.wrapperContextForParams(r3, TransportResultInterceptor.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L12;
        List<TransportResultInterceptor> r0 = this.mTransportResultInterceptorList;
        monitor-enter(r0);
        this.mTransportResultInterceptorList.remove(r4);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    void updateRpcConfig(RpcConfig r1) {
        this.mConfig = r1;
    }
}
