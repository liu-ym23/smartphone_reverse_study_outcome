package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.NetworkApi21;
import androidx.work.impl.utils.NetworkApi24;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
public final class NetworkStateTracker24 extends ConstraintTracker<NetworkState> {
    private final ConnectivityManager connectivityManager;
    private final NetworkStateTracker24$networkCallback$1 networkCallback;

    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.work.impl.constraints.trackers.NetworkStateTracker24$networkCallback$1] */
    public NetworkStateTracker24(Context r10, TaskExecutor r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "taskExecutor");
        super(r10, r11);
        Object r12 = getAppContext().getSystemService("connectivity");
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.connectivityManager = (ConnectivityManager) r12;
        this.networkCallback = new NetworkStateTracker24$networkCallback$1(this);
    }

    public static final /* synthetic */ ConnectivityManager access$getConnectivityManager$p(NetworkStateTracker24 r10) {
        return r10.connectivityManager;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public NetworkState getInitialState() {
        return NetworkStateTrackerKt.getActiveNetworkState(this.connectivityManager);
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public /* bridge */ /* synthetic */ NetworkState getInitialState() {
        return getInitialState();
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void startTracking() {
        Logger.get().debug(NetworkStateTrackerKt.access$getTAG$p(), "Registering network callback");     // Catch: Throwable -> L5
        NetworkApi24.registerDefaultNetworkCallbackCompat(this.connectivityManager, this.networkCallback);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        Logger.get().error(NetworkStateTrackerKt.access$getTAG$p(), "Received exception while registering network callback", e);
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void stopTracking() {
        Logger.get().debug(NetworkStateTrackerKt.access$getTAG$p(), "Unregistering network callback");     // Catch: Throwable -> L5
        NetworkApi21.unregisterNetworkCallbackCompat(this.connectivityManager, this.networkCallback);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        Logger.get().error(NetworkStateTrackerKt.access$getTAG$p(), "Received exception while unregistering network callback", e);
    }
}
