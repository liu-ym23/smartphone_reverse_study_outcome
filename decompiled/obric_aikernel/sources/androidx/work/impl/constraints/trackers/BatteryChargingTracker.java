package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class BatteryChargingTracker extends BroadcastReceiverConstraintTracker<Boolean> {
    public BatteryChargingTracker(Context r10, TaskExecutor r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "taskExecutor");
        super(r10, r11);
    }

    private final boolean isBatteryChangedIntentCharging(Intent r10) {
        if (Build.VERSION.SDK_INT < 23) goto L10;
        int r11 = r10.getIntExtra("status", -1);
        if (r11 != 2) goto L7;
        return true;
    L7:
        if (r11 != 5) goto L13;
        return true;
    L13:
        return false;
    L10:
        if (r10.getIntExtra("plugged", 0) == 0) goto L13;
        return true;
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public Boolean getInitialState() {
        IntentFilter r10 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Intent r11 = getAppContext().registerReceiver(null, r10);
        if (r11 != null) goto L7;
        Logger.get().error(BatteryChargingTrackerKt.access$getTAG$p(), "getInitialState - null intent received");
        return Boolean.FALSE;
    L7:
        return Boolean.valueOf(isBatteryChangedIntentCharging(r11));
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public /* bridge */ /* synthetic */ Object getInitialState() {
        return getInitialState();
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public IntentFilter getIntentFilter() {
        IntentFilter r10 = new IntentFilter();
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r10.addAction("android.os.action.CHARGING");
        String r11 = "android.os.action.DISCHARGING";
    L6:
        r10.addAction(r11);
        return r10;
    L5:
        r10.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        r11 = "android.intent.action.ACTION_POWER_DISCONNECTED";
        goto L6
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public void onBroadcastReceive(Intent r10) {
        Intrinsics.checkNotNullParameter(r10, "intent");
        String r11 = r10.getAction();
        if (r11 != null) goto L5;
        return;
    L5:
        Logger.get().debug(BatteryChargingTrackerKt.access$getTAG$p(), "Received " + r11);
        switch(r11.hashCode()) {
            case -1886648615: goto L19;
            case -54942926: goto L16;
            case 948344062: goto L12;
            case 1019184907: goto L9;
            default: goto L24;
        };
    L24:
        return;
    L9:
        if (r11.equals("android.intent.action.ACTION_POWER_CONNECTED") == false) goto L25;
    L14:
        Boolean r12 = Boolean.TRUE;
    L22:
        setState(r12);
        return;
    L25:
        return;
    L12:
        if (r11.equals("android.os.action.CHARGING") == true) goto L14;
        return;
    L16:
        if (r11.equals("android.os.action.DISCHARGING") == false) goto L27;
    L21:
        r12 = Boolean.FALSE;
        goto L22
    L27:
        return;
    L19:
        if (r11.equals("android.intent.action.ACTION_POWER_DISCONNECTED") == true) goto L21;
    }
}
