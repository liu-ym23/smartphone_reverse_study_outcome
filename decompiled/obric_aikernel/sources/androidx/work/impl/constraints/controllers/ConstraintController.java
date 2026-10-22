package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class ConstraintController<T> implements ConstraintListener<T> {
    private OnConstraintUpdatedCallback callback;
    private T currentValue;
    private final List<String> matchingWorkSpecIds;
    private final List<WorkSpec> matchingWorkSpecs;
    private final ConstraintTracker<T> tracker;

    public interface OnConstraintUpdatedCallback {
        void onConstraintMet(List<WorkSpec> r10);

        void onConstraintNotMet(List<WorkSpec> r10);
    }

    public ConstraintController(ConstraintTracker<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "tracker");
        this.tracker = r10;
        this.matchingWorkSpecs = new ArrayList();
        this.matchingWorkSpecIds = new ArrayList();
    }

    private final void updateCallback(OnConstraintUpdatedCallback r10, T r11) {
        if (this.matchingWorkSpecs.isEmpty() == true) goto L13;
        if (r10 == null) goto L15;
        if (r11 != null) goto L8;
    L11:
        r10.onConstraintNotMet(this.matchingWorkSpecs);
        return;
    L8:
        if (isConstrained(r11) == true) goto L11;
        r10.onConstraintMet(this.matchingWorkSpecs);
        return;
    L15:
        return;
    }

    public final OnConstraintUpdatedCallback getCallback() {
        return this.callback;
    }

    public abstract boolean hasConstraint(WorkSpec r10);

    public abstract boolean isConstrained(T r10);

    public final boolean isWorkSpecConstrained(String r10) {
        Intrinsics.checkNotNullParameter(r10, "workSpecId");
        T r11 = this.currentValue;
        if (r11 != null) goto L5;
    L9:
        return false;
    L5:
        if (isConstrained(r11) == false) goto L9;
        if (this.matchingWorkSpecIds.contains(r10) == false) goto L9;
        return true;
    }

    @Override // androidx.work.impl.constraints.ConstraintListener
    public void onConstraintChanged(T r10) {
        this.currentValue = r10;
        updateCallback(this.callback, r10);
    }

    public final void replace(Iterable<WorkSpec> r10) {
        Intrinsics.checkNotNullParameter(r10, "workSpecs");
        this.matchingWorkSpecs.clear();
        this.matchingWorkSpecIds.clear();
        List<WorkSpec> r11 = this.matchingWorkSpecs;
        Iterator<WorkSpec> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        WorkSpec r13 = r12.next();
        if (hasConstraint(r13) == false) goto L4;
        r11.add(r13);
        goto L4
    L8:
        List<WorkSpec> r14 = this.matchingWorkSpecs;
        List<String> r15 = this.matchingWorkSpecIds;
        Iterator<T> r16 = r14.iterator();
    L10:
        if (r16.hasNext() == false) goto L13;
        r15.add(((WorkSpec) r16.next()).id);
        goto L10
    L13:
        if (this.matchingWorkSpecs.isEmpty() == false) goto L15;
        this.tracker.removeListener(this);
    L16:
        updateCallback(this.callback, this.currentValue);
        return;
    L15:
        this.tracker.addListener(this);
        goto L16
    }

    public final void reset() {
        if ((!this.matchingWorkSpecs.isEmpty()) == false) goto L6;
        this.matchingWorkSpecs.clear();
        this.tracker.removeListener(this);
        return;
    }

    public final void setCallback(OnConstraintUpdatedCallback r10) {
        if (this.callback == r10) goto L6;
        this.callback = r10;
        updateCallback(r10, this.currentValue);
        return;
    }
}
