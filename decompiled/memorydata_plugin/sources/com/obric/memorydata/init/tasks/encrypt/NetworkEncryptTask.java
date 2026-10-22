package com.obric.memorydata.init.tasks.encrypt;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.lego.init.model.IInitTask;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.MemoryAppLogSettings;
import com.obric.memorydata.utils.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/init/tasks/encrypt/NetworkEncryptTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "<init>", "()V", "isInit", "", "run", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "init_task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NetworkEncryptTask extends IInitTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f9926a;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/init/tasks/encrypt/NetworkEncryptTask$init$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "init_task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends ConnectivityManager.NetworkCallback {
        a() {
        }

        private static final Unit a() {
            com.obric.memorydata.middleware.api.b.a.f11604a.a();
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Unit lambda$OOJg1XnCn1yTe2mIF4st1S4evpU() {
            return a();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r1) {
            Intrinsics.checkNotNullParameter(r1, "network");
            h.a($$Lambda$NetworkEncryptTask$a$OOJg1XnCn1yTe2mIF4st1S4evpU.INSTANCE);
        }
    }

    public NetworkEncryptTask() {
    }

    private static final Unit a(NetworkEncryptTask r0) {
        r0.a();
        return Unit.INSTANCE;
    }

    private final void a() {
        if (this.f9926a == false) goto L5;
        return;
    L5:
        this.f9926a = true;
        Object r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity");
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ((ConnectivityManager) ZeusTransformUtils.preCheckCast(r4, ConnectivityManager.class, "com.obric.memorydata.plugin")).registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), (ConnectivityManager.NetworkCallback) ZeusTransformUtils.preCheckCast(new a(), ConnectivityManager.NetworkCallback.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ Unit lambda$TXWnIT1DiwJjYFFFpPIplsV_pKE(NetworkEncryptTask r0) {
        return a(r0);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (Intrinsics.areEqual(AppContext.INSTANCE.getPackageName(), "com.larus.nova") == true) goto L5;
        return;
    L5:
        MemoryAppLogSettings.INSTANCE.registerDidReadyListener(new $$Lambda$NetworkEncryptTask$TXWnIT1DiwJjYFFFpPIplsV_pKE(this));
    }
}
