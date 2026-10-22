package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class NetworkStateTrackerPre24 extends BroadcastReceiverConstraintTracker<NetworkState> {
    private final ConnectivityManager connectivityManager;

    public NetworkStateTrackerPre24(Context r10, TaskExecutor r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "taskExecutor");
        super(r10, r11);
        Object r12 = getAppContext().getSystemService("connectivity");
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.connectivityManager = (ConnectivityManager) r12;
    }

    public static /* synthetic */ void getIntentFilter$annotations() {
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public NetworkState getInitialState() {
        return NetworkStateTrackerKt.getActiveNetworkState(this.connectivityManager);
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public /* bridge */ /* synthetic */ Object getInitialState() {
        return getInitialState();
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public IntentFilter getIntentFilter() {
        return new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public void onBroadcastReceive(Intent r10) {
        Intrinsics.checkNotNullParameter(r10, "intent");
        if (Intrinsics.areEqual(r10.getAction(), "android.net.conn.CONNECTIVITY_CHANGE") == false) goto L6;
        Logger.get().debug(NetworkStateTrackerKt.access$getTAG$p(), "Network broadcast received");
        setState(NetworkStateTrackerKt.getActiveNetworkState(this.connectivityManager));
        return;
    }
}
