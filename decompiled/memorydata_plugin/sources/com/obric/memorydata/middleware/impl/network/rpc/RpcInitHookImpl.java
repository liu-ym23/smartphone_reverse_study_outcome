package com.obric.memorydata.middleware.impl.network.rpc;

import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.rpc.RpcService;
import com.bytedance.rpc.callback.RpcInterceptor;
import com.bytedance.rpc.transport.TransportResultInterceptor;
import com.bytedance.rpc.transport.ttnet.DefaultTransportClient;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.env.EnvManager;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.rpc.AppNetConfig;
import com.obric.memorydata.middleware.api.rpc.RpcInitHook;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0016\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bH\u0016J\u0016\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/rpc/RpcInitHookImpl;", "Lcom/obric/memorydata/middleware/api/rpc/RpcInitHook;", "<init>", "()V", "globalRpcInterceptor", "Lcom/obric/memorydata/middleware/impl/network/rpc/GlobalRpcInterceptor;", "beforeInitRpc", "", "rpcBaseUrl", "", "addRpcCommonQuery", "", "addRpcHeader", "addRpcInterceptors", "", "Lcom/bytedance/rpc/callback/RpcInterceptor;", "afterInitRpc", "Companion", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RpcInitHookImpl implements RpcInitHook {
    public static final a Companion = null;
    private static final String TAG = "RpcInitHookImpl";
    private final GlobalRpcInterceptor globalRpcInterceptor;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/rpc/RpcInitHookImpl$Companion;", "", "<init>", "()V", "TAG", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public RpcInitHookImpl() {
        this.globalRpcInterceptor = new GlobalRpcInterceptor();
    }

    @Override // com.obric.memorydata.middleware.api.rpc.RpcInitHook
    public Map<String, String> addRpcCommonQuery() {
        return null;
    }

    @Override // com.obric.memorydata.middleware.api.rpc.RpcInitHook
    public Map<String, String> addRpcHeader() {
        String r9 = EnvManager.INSTANCE.getAdminTTEnvHeader();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "ppe env " + r9, false, 4, null);
        if (AppContext.INSTANCE.isDebug() == true) goto L5;
    L10:
        return null;
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("X-TT-Env", r9), TuplesKt.to("X-Use-PPE", "1")});
    L7:
        r0 = false;
        goto L8
    }

    @Override // com.obric.memorydata.middleware.api.rpc.RpcInitHook
    public List<RpcInterceptor> addRpcInterceptors() {
        List<RpcInterceptor> r2 = CollectionsKt.mutableListOf(new RpcInterceptor[]{this.globalRpcInterceptor});
        if (AppContext.INSTANCE.isAdminMode() == false) goto L5;
        r2.add(new b());
    L5:
        return r2;
    }

    @Override // com.obric.memorydata.middleware.api.rpc.RpcInitHook
    public void afterInitRpc() {
        RpcService.addTransportResultInterceptor((TransportResultInterceptor) ZeusTransformUtils.preCheckCast(this.globalRpcInterceptor, TransportResultInterceptor.class, "com.obric.memorydata.plugin"));
        DefaultTransportClient.addOkInterceptor((Interceptor) ZeusTransformUtils.preCheckCast(this.globalRpcInterceptor, Interceptor.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.middleware.api.rpc.RpcInitHook
    public void beforeInitRpc() {
    }

    @Override // com.obric.memorydata.middleware.api.rpc.RpcInitHook
    public String rpcBaseUrl() {
        return AppNetConfig.INSTANCE.getBaseUrl();
    }
}
