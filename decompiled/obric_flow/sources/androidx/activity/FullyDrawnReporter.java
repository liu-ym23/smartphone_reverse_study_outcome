package androidx.activity;

import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0014\u0010\u0014\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0006\u0010\u0016\u001a\u00020\u0006J\b\u0010\u0017\u001a\u00020\u0006H\u0007J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\u0014\u0010\u0019\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0006\u0010\u001a\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\r8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/activity/FullyDrawnReporter;", "", "executor", "Ljava/util/concurrent/Executor;", "reportFullyDrawn", "Lkotlin/Function0;", "", "(Ljava/util/concurrent/Executor;Lkotlin/jvm/functions/Function0;)V", "isFullyDrawnReported", "", "()Z", "lock", "onReportCallbacks", "", "reportPosted", "reportRunnable", "Ljava/lang/Runnable;", "reportedFullyDrawn", "reporterCount", "", "addOnReportDrawnListener", "callback", "addReporter", "fullyDrawnReported", "postWhenReportersAreDone", "removeOnReportDrawnListener", "removeReporter", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFullyDrawnReporter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FullyDrawnReporter.kt\nandroidx/activity/FullyDrawnReporter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,190:1\n1#2:191\n1855#3,2:192\n*S KotlinDebug\n*F\n+ 1 FullyDrawnReporter.kt\nandroidx/activity/FullyDrawnReporter\n*L\n154#1:192,2\n*E\n"})
public final class FullyDrawnReporter {
    private final Executor executor;
    private final Object lock;

    @GuardedBy("lock")
    private final List<Function0<Unit>> onReportCallbacks;
    private final Function0<Unit> reportFullyDrawn;

    @GuardedBy("lock")
    private boolean reportPosted;
    private final Runnable reportRunnable;

    @GuardedBy("lock")
    private boolean reportedFullyDrawn;

    @GuardedBy("lock")
    private int reporterCount;

    public FullyDrawnReporter(Executor r5, Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r5, "executor");
        Intrinsics.checkNotNullParameter(r10, "reportFullyDrawn");
        this.executor = r5;
        this.reportFullyDrawn = r10;
        this.lock = new Object();
        this.onReportCallbacks = new ArrayList();
        this.reportRunnable = new d(this, 3);
    }

    public static /* synthetic */ void a(FullyDrawnReporter r5) {
        reportRunnable$lambda$2(r5);
    }

    private final void postWhenReportersAreDone() {
        if (this.reportPosted == false) goto L5;
        return;
    L5:
        if (this.reporterCount != 0) goto L9;
        this.reportPosted = true;
        this.executor.execute(this.reportRunnable);
        return;
    }

    private static final void reportRunnable$lambda$2(FullyDrawnReporter r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Object r10 = r5.lock;
        monitor-enter(r10);
        r5.reportPosted = false;     // Catch: Throwable -> L10
        if (r5.reporterCount == 0) goto L8;
    L12:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r10);
        return;
    L8:
        if (r5.reportedFullyDrawn == true) goto L12;
        r5.reportFullyDrawn.invoke();     // Catch: Throwable -> L10
        r5.fullyDrawnReported();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public final void addOnReportDrawnListener(Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        Object r10 = this.lock;
        monitor-enter(r10);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.reportedFullyDrawn == false) goto L7;
        boolean r11 = true;
    L9:
        monitor-exit(r10);
        if (r11 == false) goto L18;
        r5.invoke();
        return;
    L18:
        return;
    L7:
        this.onReportCallbacks.add(r5);     // Catch: Throwable -> L13
        r11 = false;
        goto L9
    }

    public final void addReporter() {
        Object r5 = this.lock;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.reportedFullyDrawn == true) goto L9;
        this.reporterCount++;     // Catch: Throwable -> L7
    L9:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void fullyDrawnReported() {
        Object r5 = this.lock;
        monitor-enter(r5);
        this.reportedFullyDrawn = true;     // Catch: Throwable -> L9
        Iterator<T> r10 = this.onReportCallbacks.iterator();     // Catch: Throwable -> L9
    L7:
        if (r10.hasNext() == false) goto L11;
        ((Function0) r10.next()).invoke();     // Catch: Throwable -> L9
        goto L7
    L11:
        this.onReportCallbacks.clear();     // Catch: Throwable -> L9
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r5);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final boolean isFullyDrawnReported() {
        Object r5 = this.lock;
        monitor-enter(r5);
        boolean r10 = this.reportedFullyDrawn;     // Catch: Throwable -> L7
        monitor-exit(r5);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public final void removeOnReportDrawnListener(Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        Object r10 = this.lock;
        monitor-enter(r10);
        this.onReportCallbacks.remove(r5);     // Catch: Throwable -> L7
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r10);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void removeReporter() {
        Object r5 = this.lock;
        monitor-enter(r5);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.reportedFullyDrawn == true) goto L11;
        int r10 = this.reporterCount;     // Catch: Throwable -> L9
        if (r10 <= 0) goto L11;
        this.reporterCount = r10 - 1;     // Catch: Throwable -> L9
        postWhenReportersAreDone();     // Catch: Throwable -> L9
    L11:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r5);
    }
}
