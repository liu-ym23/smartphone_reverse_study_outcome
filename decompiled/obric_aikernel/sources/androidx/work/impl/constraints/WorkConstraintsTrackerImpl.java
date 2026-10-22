package androidx.work.impl.constraints;

import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredController;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class WorkConstraintsTrackerImpl implements WorkConstraintsTracker, ConstraintController.OnConstraintUpdatedCallback {
    private final WorkConstraintsCallback callback;
    private final ConstraintController<?>[] constraintControllers;
    private final Object lock;

    @VisibleForTesting
    public WorkConstraintsTrackerImpl(WorkConstraintsCallback r10, ConstraintController<?>[] r11) {
        Intrinsics.checkNotNullParameter(r11, "constraintControllers");
        this.callback = r10;
        this.constraintControllers = r11;
        this.lock = new Object();
    }

    public WorkConstraintsTrackerImpl(Trackers r10, WorkConstraintsCallback r11) {
        Intrinsics.checkNotNullParameter(r10, "trackers");
        this(r11, new ConstraintController[]{new BatteryChargingController(r10.getBatteryChargingTracker()), new BatteryNotLowController(r10.getBatteryNotLowTracker()), new StorageNotLowController(r10.getStorageNotLowTracker()), new NetworkConnectedController(r10.getNetworkStateTracker()), new NetworkUnmeteredController(r10.getNetworkStateTracker()), new NetworkNotRoamingController(r10.getNetworkStateTracker()), new NetworkMeteredController(r10.getNetworkStateTracker())});
    }

    public final boolean areAllConstraintsMet(String r10) {
        Intrinsics.checkNotNullParameter(r10, "workSpecId");
        Object r11 = this.lock;
        monitor-enter(r11);
        ConstraintController<?>[] r12 = this.constraintControllers;     // Catch: Throwable -> L17
        int r13 = r12.length;     // Catch: Throwable -> L17
        boolean r14 = false;
        int r15 = 0;
    L5:
        if (r15 >= r13) goto L10;
        ConstraintController<?> r16 = r12[r15];     // Catch: Throwable -> L17
        if (r16.isWorkSpecConstrained(r10) == true) goto L11;
        r15 = r15 + 1;     // Catch: Throwable -> L17
    L11:
        if (r16 == null) goto L13;
        Logger.get().debug(WorkConstraintsTrackerKt.access$getTAG$p(), "Work " + r10 + " constrained by " + r16.getClass().getSimpleName());     // Catch: Throwable -> L17
    L13:
        if (r16 != null) goto L15;
        r14 = true;
    L15:
        monitor-exit(r11);
        return r14;
    L10:
        r16 = null;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController.OnConstraintUpdatedCallback
    public void onConstraintMet(List<WorkSpec> r10) {
        Intrinsics.checkNotNullParameter(r10, "workSpecs");
        Object r11 = this.lock;
        monitor-enter(r11);
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L19
        Iterator<T> r13 = r10.iterator();     // Catch: Throwable -> L19
    L6:
        if (r13.hasNext() == false) goto L10;
        Object r14 = r13.next();     // Catch: Throwable -> L19
        if (areAllConstraintsMet(((WorkSpec) r14).id) == false) goto L6;
        r12.add(r14);     // Catch: Throwable -> L19
        goto L6
    L10:
        Iterator r15 = r12.iterator();     // Catch: Throwable -> L19
    L12:
        if (r15.hasNext() == false) goto L14;
        WorkSpec r16 = (WorkSpec) r15.next();     // Catch: Throwable -> L19
        Logger.get().debug(WorkConstraintsTrackerKt.access$getTAG$p(), "Constraints met for " + r16);     // Catch: Throwable -> L19
        goto L12
    L14:
        WorkConstraintsCallback r17 = this.callback;     // Catch: Throwable -> L19
        if (r17 == null) goto L17;
        r17.onAllConstraintsMet(r12);     // Catch: Throwable -> L19
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L17:
        monitor-exit(r11);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController.OnConstraintUpdatedCallback
    public void onConstraintNotMet(List<WorkSpec> r10) {
        Intrinsics.checkNotNullParameter(r10, "workSpecs");
        Object r11 = this.lock;
        monitor-enter(r11);
        WorkConstraintsCallback r12 = this.callback;     // Catch: Throwable -> L9
        if (r12 == null) goto L7;
        r12.onAllConstraintsNotMet(r10);     // Catch: Throwable -> L9
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r11);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsTracker
    public void replace(Iterable<WorkSpec> r10) {
        Intrinsics.checkNotNullParameter(r10, "workSpecs");
        Object r11 = this.lock;
        monitor-enter(r11);
        ConstraintController<?>[] r12 = this.constraintControllers;     // Catch: Throwable -> L16
        int r13 = r12.length;     // Catch: Throwable -> L16
        int r14 = 0;
        int r15 = 0;
    L5:
        if (r15 >= r13) goto L7;
        r12[r15].setCallback(null);     // Catch: Throwable -> L16
        r15 = r15 + 1;     // Catch: Throwable -> L16
        goto L5
    L7:
        ConstraintController<?>[] r16 = this.constraintControllers;     // Catch: Throwable -> L16
        int r17 = r16.length;     // Catch: Throwable -> L16
        int r18 = 0;
    L8:
        if (r18 >= r17) goto L10;
        r16[r18].replace(r10);     // Catch: Throwable -> L16
        r18 = r18 + 1;     // Catch: Throwable -> L16
        goto L8
    L10:
        ConstraintController<?>[] r19 = this.constraintControllers;     // Catch: Throwable -> L16
        int r20 = r19.length;     // Catch: Throwable -> L16
    L11:
        if (r14 >= r20) goto L13;
        r19[r14].setCallback(this);     // Catch: Throwable -> L16
        r14 = r14 + 1;     // Catch: Throwable -> L16
        goto L11
    L13:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r11);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsTracker
    public void reset() {
        Object r10 = this.lock;
        monitor-enter(r10);
        ConstraintController<?>[] r11 = this.constraintControllers;     // Catch: Throwable -> L10
        int r12 = 0;
        int r13 = r11.length;     // Catch: Throwable -> L10
    L5:
        if (r12 >= r13) goto L7;
        r11[r12].reset();     // Catch: Throwable -> L10
        r12 = r12 + 1;     // Catch: Throwable -> L10
        goto L5
    L7:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r10);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
