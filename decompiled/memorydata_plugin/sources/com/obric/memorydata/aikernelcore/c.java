package com.obric.memorydata.aikernelcore;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.controller.NetworkController;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/aikernelcore/PaPayaNetworkChangeReceiver;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "networkCallback", "com/obric/memorydata/aikernelcore/PaPayaNetworkChangeReceiver$networkCallback$1", "Lcom/obric/memorydata/aikernelcore/PaPayaNetworkChangeReceiver$networkCallback$1;", "refreshAikernelPackageInfo", "", "registerNetworkCallback", "Companion", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8478a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f8479b;
    private final ConnectivityManager c;
    private final b d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/aikernelcore/PaPayaNetworkChangeReceiver$Companion;", "", "<init>", "()V", "TAG", "", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/aikernelcore/PaPayaNetworkChangeReceiver$networkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f8480a;

        b(c r1) {
            this.f8480a = r1;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r2) {
            Intrinsics.checkNotNullParameter(r2, "network");
            if (UserSettings.INSTANCE.hasAgreePrivacy() == false) goto L6;
            c.a(this.f8480a);
            return;
        }
    }

    static {
        f8478a = new a(null);
    }

    public c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        Context r5 = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
        this.f8479b = r5;
        Object r6 = r5.getSystemService("connectivity");
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.c = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r6, ConnectivityManager.class, "com.obric.memorydata.plugin");
        this.d = new b(this);
    }

    public static final /* synthetic */ void a(c r0) {
        r0.b();
    }

    private final void b() {
        if (NetworkController.INSTANCE.isNetworkPolicySatisfied() == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PaPayaNetworkChangeReceiver", "refreshAikernelPackageInfo execute", false, 4, null);
        h.f8481a.b();
        return;
    }

    public final void a() {
        NetworkRequest r0 = new NetworkRequest.Builder().addCapability(12).build();
        this.c.registerNetworkCallback(r0, (ConnectivityManager.NetworkCallback) ZeusTransformUtils.preCheckCast(this.d, ConnectivityManager.NetworkCallback.class, "com.obric.memorydata.plugin"));
    }
}
