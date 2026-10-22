package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class StorageNotLowController extends ConstraintController<Boolean> {
    public StorageNotLowController(ConstraintTracker<Boolean> r10) {
        Intrinsics.checkNotNullParameter(r10, "tracker");
        super(r10);
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean hasConstraint(WorkSpec r10) {
        Intrinsics.checkNotNullParameter(r10, "workSpec");
        return r10.constraints.requiresStorageNotLow();
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public /* bridge */ /* synthetic */ boolean isConstrained(Boolean r10) {
        return isConstrained(r10.booleanValue());
    }

    public boolean isConstrained(boolean r10) {
        return !r10;
    }
}
