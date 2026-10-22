package com.obric.memorydata.intelligence.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.database.entity.ds;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.handler.GlobalHandlerUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u000b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0005J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/intelligence/predict/StatisticsNetwork;", "", "<init>", "()V", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "context", "Landroid/content/Context;", "requestNetworkStat", "registerConnectivityChange", "networkCallback", "com/obric/memorydata/intelligence/predict/StatisticsNetwork$networkCallback$1", "Lcom/obric/memorydata/intelligence/predict/StatisticsNetwork$networkCallback$1;", "updateNetworkState", "networkType", "", "Companion", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9950a = null;
    private static final String c = null;
    private static int d;
    private static long e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f9951b;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\tR\u0018\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/intelligence/predict/StatisticsNetwork$Companion;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "WIFI", "", "MOBILE", "NONE", "TYPE_COUNT", "lastNetworkType", "lastUpdateTime", "", "getLastNetworkType", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final int a() {
            return i.b();
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/intelligence/predict/StatisticsNetwork$networkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "onLost", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f9952a;

        b(i r1) {
            this.f9952a = r1;
        }

        private static final void a(i r0) {
            r0.a();
        }

        private static final void b(i r0) {
            r0.a();
        }

        public static /* synthetic */ void lambda$HWX0JAtCRDvsVuwI6aOPYva354g(i r0) {
            a(r0);
        }

        /* JADX INFO: renamed from: lambda$M-QKs4QGdCjQUrdCoXmjHgBTXhM, reason: not valid java name */
        public static /* synthetic */ void m672lambda$MQKs4QGdCjQUrdCoXmjHgBTXhM(i r0) {
            b(r0);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r4) {
            Intrinsics.checkNotNullParameter(r4, "network");
            super.onAvailable(r4);
            RunLog r5 = RunLog.INSTANCE;
            String r0 = i.c();
            Intrinsics.checkNotNullExpressionValue(r0, "access$getTAG$cp(...)");
            r5.debug(r0, "onAvailable");
            GlobalHandlerUtil r6 = GlobalHandlerUtil.Companion.getInstance();
            final i r3 = this.f9952a;
            r6.sendMsgDelay(new $$Lambda$i$b$HWX0JAtCRDvsVuwI6aOPYva354g(r3), 1000);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r4) {
            Intrinsics.checkNotNullParameter(r4, "network");
            RunLog r0 = RunLog.INSTANCE;
            String r1 = i.c();
            Intrinsics.checkNotNullExpressionValue(r1, "access$getTAG$cp(...)");
            r0.debug(r1, "onLost");
            super.onLost(r4);
            GlobalHandlerUtil r5 = GlobalHandlerUtil.Companion.getInstance();
            final i r3 = this.f9952a;
            r5.sendMsgDelay(new $$Lambda$i$b$MQKs4QGdCjQUrdCoXmjHgBTXhM(r3), 1000);
        }
    }

    static {
        f9950a = new a(null);
        c = i.class.getSimpleName();
        d = -1;
        e = -1;
    }

    public i() {
        this.f9951b = new b(this);
    }

    private final void a(int r9) {
        if (d != r9) goto L5;
        return;
    L5:
        RunLog r8 = RunLog.INSTANCE;
        String r0 = c;
        Intrinsics.checkNotNullExpressionValue(r0, "TAG");
        r8.debug(r0, "update network state");
        long r4 = System.currentTimeMillis();
        d = r9;
        e = r4;
        ds r10 = new ds(d, r4, 0);
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getNetworkTypeDao().insert(r10);
    }

    public static final /* synthetic */ int b() {
        return d;
    }

    private final void b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        NetworkRequest r0 = new NetworkRequest.Builder().addTransportType(1).addTransportType(0).build();
        Object r6 = r5.getSystemService("connectivity");
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ((ConnectivityManager) ZeusTransformUtils.preCheckCast(r6, ConnectivityManager.class, "com.obric.memorydata.plugin")).requestNetwork(r0, (ConnectivityManager.NetworkCallback) ZeusTransformUtils.preCheckCast(this.f9951b, ConnectivityManager.NetworkCallback.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ String c() {
        return c;
    }

    public final void a() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager r1 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r0, ConnectivityManager.class, "com.obric.memorydata.plugin");
        Network r2 = r1.getActiveNetwork();
        if (r2 != null) goto L7;
        RunLog r3 = RunLog.INSTANCE;
        String r4 = c;
        Intrinsics.checkNotNullExpressionValue(r4, "TAG");
        String r5 = " requestNetworkStat: network is null.";
    L5:
        r3.debug(r4, r5);
        a(0);
        return;
    L7:
        NetworkCapabilities r6 = r1.getNetworkCapabilities(r2);
        if (r6 != null) goto L11;
        r3 = RunLog.INSTANCE;
        r4 = c;
        Intrinsics.checkNotNullExpressionValue(r4, "TAG");
        r5 = " requestNetworkStat: networkCapabilities is null.";
        goto L5
    L11:
        if (r6.hasTransport(1) == false) goto L14;
        RunLog r7 = RunLog.INSTANCE;
        String r8 = c;
        Intrinsics.checkNotNullExpressionValue(r8, "TAG");
        r7.debug(r8, " requestNetworkStat: networkCapabilities is wifi.");
        a(1);
        return;
    L14:
        if (r6.hasTransport(0) == false) goto L16;
        RunLog r9 = RunLog.INSTANCE;
        String r10 = c;
        Intrinsics.checkNotNullExpressionValue(r10, "TAG");
        r9.debug(r10, " requestNetworkStat: networkCapabilities is cellular.");
        a(2);
        return;
    L16:
        RunLog r11 = RunLog.INSTANCE;
        String r12 = c;
        Intrinsics.checkNotNullExpressionValue(r12, "TAG");
        r11.debug(r12, " requestNetworkStat: networkCapabilities is NONE.");
        a(0);
    }

    public final void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        b(r4);
    }
}
