package com.obric.widget.host.runtime;

import androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\tJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\tJ\u0006\u0010\u0014\u001a\u00020\u0011J\u0006\u0010\u0015\u001a\u00020\tJ\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0019J>\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u00192\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00192\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00110\u001eJ\u0006\u0010\u001f\u001a\u00020\u0011J\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00070!R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRenderScheduler;", "", "<init>", "()V", "activeRenderJob", "Lkotlinx/coroutines/Job;", "pendingRenderReason", "", "pendingRenderAllowHidden", "", "renderSequence", "", BaseRecognizer.NEXT_TOKEN_RULE_NAME, "isLatestToken", "renderToken", "hasActiveRender", "queuePending", "", "reason", "allowHidden", "clearPending", "pendingAllowHidden", "consumePending", "Lcom/obric/widget/host/runtime/WidgetPendingRender;", "canRenderNow", "Lkotlin/Function0;", "register", "job", "shouldClearPending", "onDrainPending", "Lkotlin/Function1;", "cancelActiveAndClearPending", "debugState", "Lkotlin/Pair;", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetRenderScheduler {
    private Job activeRenderJob;
    private boolean pendingRenderAllowHidden;
    private String pendingRenderReason;
    private long renderSequence;

    public WidgetRenderScheduler() {
    }

    public static /* synthetic */ Unit a(WidgetRenderScheduler r5, Function1 r10, Job r11, Function0 r12, Function0 r13, Throwable r14) {
        return register$lambda$3(r5, r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ void queuePending$default(WidgetRenderScheduler r5, String r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = false;
    L5:
        r5.queuePending(r10, r11);
    }

    private static final Unit register$lambda$3(WidgetRenderScheduler r5, Function1 r10, Job r11, Function0 r12, Function0 r13, Throwable r14) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r10, "$onDrainPending");
        Intrinsics.checkNotNullParameter(r11, "$job");
        Intrinsics.checkNotNullParameter(r12, "$shouldClearPending");
        Intrinsics.checkNotNullParameter(r13, "$canRenderNow");
        monitor-enter(r5);
        WidgetPendingRender r15 = null;
        if (r5.activeRenderJob != r11) goto L10;
        r5.activeRenderJob = null;     // Catch: Throwable -> L7
    L10:
        if (((Boolean) r12.invoke()).booleanValue() == false) goto L12;
        r5.pendingRenderReason = null;     // Catch: Throwable -> L7
        r5.pendingRenderAllowHidden = false;     // Catch: Throwable -> L7
    L13:
        monitor-exit(r5);
        if (r15 == null) goto L17;
        r10.invoke(r15);
    L17:
        return Unit.INSTANCE;
    L12:
        r15 = r5.consumePending(r13);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public final void cancelActiveAndClearPending() {
        monitor-enter(this);
        this.renderSequence++;     // Catch: Throwable -> L9
        Job r5 = this.activeRenderJob;     // Catch: Throwable -> L9
        if (r5 == null) goto L6;
        r5.cancel(null);     // Catch: Throwable -> L9
    L6:
        this.activeRenderJob = null;     // Catch: Throwable -> L9
        this.pendingRenderReason = null;     // Catch: Throwable -> L9
        this.pendingRenderAllowHidden = false;     // Catch: Throwable -> L9
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void clearPending() {
        monitor-enter(this);
        this.pendingRenderReason = null;     // Catch: Throwable -> L7
        this.pendingRenderAllowHidden = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final WidgetPendingRender consumePending(Function0<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "canRenderNow");
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r5.invoke().booleanValue() == false) goto L7;
    L12:
        String r10 = this.pendingRenderReason;     // Catch: Throwable -> L10
        if (r10 != null) goto L16;
        monitor-exit(this);
        return null;
    L16:
        WidgetPendingRender r11 = new WidgetPendingRender(r10, this.pendingRenderAllowHidden);     // Catch: Throwable -> L10
        this.pendingRenderReason = null;     // Catch: Throwable -> L10
        this.pendingRenderAllowHidden = false;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r11;
    L7:
        if (this.pendingRenderAllowHidden == true) goto L12;
        monitor-exit(this);
        return null;
    }

    public final synchronized Pair<Boolean, String> debugState() {
        monitor-enter(this);
        Job r5 = this.activeRenderJob;     // Catch: Throwable -> L8
        boolean r10 = false;
        if (r5 != null) goto L6;
    L10:
        Pair<Boolean, String> r11 = TuplesKt.to(Boolean.valueOf(r10), this.pendingRenderReason);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r11;
    L6:
        if (r5.isActive() != true) goto L10;
        r10 = true;
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean hasActiveRender() {
        monitor-enter(this);
        Job r5 = this.activeRenderJob;     // Catch: Throwable -> L9
        boolean r10 = false;
        if (r5 == null) goto L11;
        if (r5.isActive() != true) goto L11;
        r10 = true;
    L11:
        monitor-exit(this);
        return r10;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean isLatestToken(long r5) {
        monitor-enter(this);
        if (this.renderSequence != r5) goto L7;
        boolean r10 = true;
    L8:
        monitor-exit(this);
        return r10;
    L7:
        r10 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized long nextToken() {
        monitor-enter(this);
        long r5 = this.renderSequence + 1;     // Catch: Throwable -> L6
        this.renderSequence = r5;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean pendingAllowHidden() {
        monitor-enter(this);
        boolean r5 = this.pendingRenderAllowHidden;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void queuePending(String r5, boolean r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "reason");     // Catch: Throwable -> L7
        this.pendingRenderReason = r5;     // Catch: Throwable -> L7
        if (r10 == false) goto L9;
        this.pendingRenderAllowHidden = true;     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void register(final Job r10, final Function0<Boolean> r11, final Function0<Boolean> r12, final Function1<? super WidgetPendingRender, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "job");
        Intrinsics.checkNotNullParameter(r11, "shouldClearPending");
        Intrinsics.checkNotNullParameter(r12, "canRenderNow");
        Intrinsics.checkNotNullParameter(r13, "onDrainPending");
        monitor-enter(this);
        this.activeRenderJob = r10;     // Catch: Throwable -> L8
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(this);
        r10.invokeOnCompletion(new d(this, r13, r10, r11, r12));
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
