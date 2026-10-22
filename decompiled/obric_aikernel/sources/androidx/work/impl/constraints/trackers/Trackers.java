package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Trackers {
    private final ConstraintTracker<Boolean> batteryChargingTracker;
    private final BatteryNotLowTracker batteryNotLowTracker;
    private final ConstraintTracker<NetworkState> networkStateTracker;
    private final ConstraintTracker<Boolean> storageNotLowTracker;

    @JvmOverloads
    public Trackers(Context r11, TaskExecutor r12) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "taskExecutor");
        this(r11, r12, null, null, null, null, 60, null);
    }

    @JvmOverloads
    public Trackers(Context r11, TaskExecutor r12, ConstraintTracker<Boolean> r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "taskExecutor");
        Intrinsics.checkNotNullParameter(r13, "batteryChargingTracker");
        this(r11, r12, r13, null, null, null, 56, null);
    }

    @JvmOverloads
    public Trackers(Context r11, TaskExecutor r12, ConstraintTracker<Boolean> r13, BatteryNotLowTracker r14) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "taskExecutor");
        Intrinsics.checkNotNullParameter(r13, "batteryChargingTracker");
        Intrinsics.checkNotNullParameter(r14, "batteryNotLowTracker");
        this(r11, r12, r13, r14, null, null, 48, null);
    }

    @JvmOverloads
    public Trackers(Context r11, TaskExecutor r12, ConstraintTracker<Boolean> r13, BatteryNotLowTracker r14, ConstraintTracker<NetworkState> r15) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "taskExecutor");
        Intrinsics.checkNotNullParameter(r13, "batteryChargingTracker");
        Intrinsics.checkNotNullParameter(r14, "batteryNotLowTracker");
        Intrinsics.checkNotNullParameter(r15, "networkStateTracker");
        this(r11, r12, r13, r14, r15, null, 32, null);
    }

    @JvmOverloads
    public Trackers(Context r10, TaskExecutor r11, ConstraintTracker<Boolean> r12, BatteryNotLowTracker r13, ConstraintTracker<NetworkState> r14, ConstraintTracker<Boolean> r15) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "taskExecutor");
        Intrinsics.checkNotNullParameter(r12, "batteryChargingTracker");
        Intrinsics.checkNotNullParameter(r13, "batteryNotLowTracker");
        Intrinsics.checkNotNullParameter(r14, "networkStateTracker");
        Intrinsics.checkNotNullParameter(r15, "storageNotLowTracker");
        this.batteryChargingTracker = r12;
        this.batteryNotLowTracker = r13;
        this.networkStateTracker = r14;
        this.storageNotLowTracker = r15;
    }

    public /* synthetic */ Trackers(Context r10, TaskExecutor r11, ConstraintTracker r12, BatteryNotLowTracker r13, ConstraintTracker r14, ConstraintTracker r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 4) == 0) goto L5;
        Context r18 = r10.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r18, "context.applicationContext");
        ConstraintTracker r19 = new BatteryChargingTracker(r18, r11);
    L7:
        if ((r16 & 8) == 0) goto L9;
        Context r20 = r10.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r20, "context.applicationContext");
        BatteryNotLowTracker r21 = new BatteryNotLowTracker(r20, r11);
    L11:
        if ((r16 & 16) == 0) goto L13;
        Context r22 = r10.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r22, "context.applicationContext");
        ConstraintTracker r23 = NetworkStateTrackerKt.NetworkStateTracker(r22, r11);
    L15:
        if ((r16 & 32) == 0) goto L17;
        Context r24 = r10.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r24, "context.applicationContext");
        ConstraintTracker r25 = new StorageNotLowTracker(r24, r11);
    L18:
        this(r10, r11, r19, r21, r23, r25);
        return;
    L17:
        r25 = r15;
        goto L18
    L13:
        r23 = r14;
        goto L15
    L9:
        r21 = r13;
        goto L11
    L5:
        r19 = r12;
        goto L7
    }

    public final ConstraintTracker<Boolean> getBatteryChargingTracker() {
        return this.batteryChargingTracker;
    }

    public final BatteryNotLowTracker getBatteryNotLowTracker() {
        return this.batteryNotLowTracker;
    }

    public final ConstraintTracker<NetworkState> getNetworkStateTracker() {
        return this.networkStateTracker;
    }

    public final ConstraintTracker<Boolean> getStorageNotLowTracker() {
        return this.storageNotLowTracker;
    }
}
