package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class ConstraintTracker<T> {
    private final Context appContext;
    private T currentState;
    private final LinkedHashSet<ConstraintListener<T>> listeners;
    private final Object lock;
    private final TaskExecutor taskExecutor;

    protected ConstraintTracker(Context r10, TaskExecutor r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "taskExecutor");
        this.taskExecutor = r11;
        Context r12 = r10.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r12, "context.applicationContext");
        this.appContext = r12;
        this.lock = new Object();
        this.listeners = new LinkedHashSet();
    }

    private static final void _set_state_$lambda$4$lambda$3(List r10, ConstraintTracker r11) {
        Intrinsics.checkNotNullParameter(r10, "$listenersList");
        Intrinsics.checkNotNullParameter(r11, "this$0");
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((ConstraintListener) r12.next()).onConstraintChanged(r11.currentState);
        goto L4
    }

    public static /* synthetic */ void a(List r10, ConstraintTracker r11) {
        _set_state_$lambda$4$lambda$3(r10, r11);
    }

    public final void addListener(ConstraintListener<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        Object r11 = this.lock;
        monitor-enter(r11);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.listeners.add(r10) == true) goto L7;
    L10:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r11);
        return;
    L7:
        if (this.listeners.size() != 1) goto L9;
        this.currentState = getInitialState();     // Catch: Throwable -> L13
        Logger.get().debug(ConstraintTrackerKt.access$getTAG$p(), getClass().getSimpleName() + ": initial state = " + this.currentState);     // Catch: Throwable -> L13
        startTracking();     // Catch: Throwable -> L13
    L9:
        r10.onConstraintChanged(this.currentState);     // Catch: Throwable -> L13
        goto L10
    }

    protected final Context getAppContext() {
        return this.appContext;
    }

    public abstract T getInitialState();

    public final T getState() {
        T r10 = this.currentState;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return getInitialState();
    }

    public final void removeListener(ConstraintListener<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        Object r11 = this.lock;
        monitor-enter(r11);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.listeners.remove(r10) == true) goto L7;
    L9:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r11);
        return;
    L7:
        if (this.listeners.isEmpty() == false) goto L9;
        stopTracking();     // Catch: Throwable -> L12
        goto L9
    }

    public final void setState(T r10) {
        Object r11 = this.lock;
        monitor-enter(r11);
        T r12 = this.currentState;     // Catch: Throwable -> L13
        if (r12 != null) goto L7;
    L10:
        this.currentState = r10;     // Catch: Throwable -> L13
        final List r13 = CollectionsKt.toList(this.listeners);     // Catch: Throwable -> L13
        this.taskExecutor.getMainThreadExecutor().execute(new a(r13, this));     // Catch: Throwable -> L13
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r11);
        return;
    L7:
        if (Intrinsics.areEqual(r12, r10) == false) goto L10;
        monitor-exit(r11);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public abstract void startTracking();

    public abstract void stopTracking();
}
