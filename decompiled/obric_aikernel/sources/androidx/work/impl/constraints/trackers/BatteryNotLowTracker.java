package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class BatteryNotLowTracker extends BroadcastReceiverConstraintTracker<Boolean> {
    public BatteryNotLowTracker(Context r10, TaskExecutor r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "taskExecutor");
        super(r10, r11);
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public Boolean getInitialState() {
        Intent r10 = getAppContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r10 != null) goto L6;
        Logger.get().error(BatteryNotLowTrackerKt.access$getTAG$p(), "getInitialState - null intent received");
        return Boolean.FALSE;
    L6:
        int r11 = r10.getIntExtra("status", -1);
        float r12 = r10.getIntExtra("level", -1) / r10.getIntExtra("scale", -1);
        boolean r13 = true;
        if (r11 == 1) goto L13;
        if (r12 > 0.15f) goto L13;
        r13 = false;
    L13:
        return Boolean.valueOf(r13);
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public /* bridge */ /* synthetic */ Object getInitialState() {
        return getInitialState();
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public IntentFilter getIntentFilter() {
        IntentFilter r10 = new IntentFilter();
        r10.addAction("android.intent.action.BATTERY_OKAY");
        r10.addAction("android.intent.action.BATTERY_LOW");
        return r10;
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public void onBroadcastReceive(Intent r10) {
        Intrinsics.checkNotNullParameter(r10, "intent");
        if (r10.getAction() != null) goto L5;
        return;
    L5:
        Logger.get().debug(BatteryNotLowTrackerKt.access$getTAG$p(), "Received " + r10.getAction());
        String r11 = r10.getAction();
        if (r11 == null) goto L22;
        int r12 = r11.hashCode();
        if (r12 == (-1980154005)) goto L17;
        if (r12 == 490310653) goto L13;
        return;
    L13:
        if (r11.equals("android.intent.action.BATTERY_LOW") == false) goto L24;
        Boolean r13 = Boolean.FALSE;
    L20:
        setState(r13);
        return;
    L24:
        return;
    L17:
        if (r11.equals("android.intent.action.BATTERY_OKAY") == false) goto L25;
        r13 = Boolean.TRUE;
        goto L20
    L25:
        return;
    }
}
