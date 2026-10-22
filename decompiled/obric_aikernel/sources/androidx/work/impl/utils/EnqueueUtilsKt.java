package androidx.work.impl.utils;

import android.os.Build;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.impl.workers.ConstraintTrackingWorkerKt;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class EnqueueUtilsKt {
    public static final WorkSpec tryDelegateConstrainedWorkSpec(WorkSpec r30) {
        Intrinsics.checkNotNullParameter(r30, "workSpec");
        Constraints r10 = r30.constraints;
        String r11 = r30.workerClassName;
        if (Intrinsics.areEqual(r11, ConstraintTrackingWorker.class.getName()) == false) goto L5;
        return r30;
    L5:
        if (r10.requiresBatteryNotLow() == false) goto L7;
    L8:
        Data r12 = new Data.Builder().putAll(r30.input).putString(ConstraintTrackingWorkerKt.ARGUMENT_CLASS_NAME, r11).build();
        Intrinsics.checkNotNullExpressionValue(r12, "Builder().putAll(workSpe…ame)\n            .build()");
        String r13 = ConstraintTrackingWorker.class.getName();
        Intrinsics.checkNotNullExpressionValue(r13, ActivityLifecycle.NAME);
        return WorkSpec.copy$default(r30, null, null, r13, null, r12, null, 0, 0, 0, null, 0, null, 0, 0, 0, 0, false, null, 0, 0, 1048555, null);
    L7:
        if (r10.requiresStorageNotLow() == true) goto L8;
        return r30;
    }

    private static final boolean usesScheduler(List<? extends Scheduler> r10, String r11) {
        Class<?> r12 = Class.forName(r11);     // Catch: ClassNotFoundException -> L15
        if ((r10 instanceof Collection) == true) goto L6;
    L8:
        Iterator<T> r13 = r10.iterator();     // Catch: ClassNotFoundException -> L15
    L9:
        if (r13.hasNext() == false) goto L23;
        if (r12.isAssignableFrom(((Scheduler) r13.next()).getClass()) == false) goto L9;
        return true;
    L23:
        return false;
    L6:
        if (r10.isEmpty() == false) goto L8;
        return false;
    L22:
        return false;
    }

    public static final WorkSpec wrapInConstraintTrackingWorkerIfNeeded(List<? extends Scheduler> r10, WorkSpec r11) {
        Intrinsics.checkNotNullParameter(r10, "schedulers");
        Intrinsics.checkNotNullParameter(r11, "workSpec");
        int r12 = Build.VERSION.SDK_INT;
        boolean r13 = false;
        if (23 <= r12) goto L5;
    L7:
        if (r13 == false) goto L10;
    L14:
        return tryDelegateConstrainedWorkSpec(r11);
    L10:
        if (r12 <= 22) goto L12;
        return r11;
    L12:
        if (usesScheduler(r10, Schedulers.GCM_SCHEDULER) == true) goto L14;
        return r11;
    L5:
        if (r12 >= 26) goto L7;
        r13 = true;
        goto L7
    }
}
