package com.obric.assistant.interaction.impl.window.behaviors;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.api.window.IBehavior;
import com.obric.assistant.interaction.impl.window.WindowHost;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0007\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/MemoryPressureDestroyBehavior;", "Lcom/obric/assistant/interaction/api/window/IBehavior;", "<init>", "()V", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "componentCallbacks", "com/obric/assistant/interaction/impl/window/behaviors/MemoryPressureDestroyBehavior$componentCallbacks$1", "Lcom/obric/assistant/interaction/impl/window/behaviors/MemoryPressureDestroyBehavior$componentCallbacks$1;", "init", "", "shouldDestroyOnTrimMemory", "", "level", "", "destroyWindowIfNeeded", "reason", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MemoryPressureDestroyBehavior implements IBehavior {
    public static final Companion Companion = null;
    private static final String REASON_LOW_MEMORY = "window_auto_destroy_low_memory";
    private static final String REASON_TRIM_MEMORY_PREFIX = "window_auto_destroy_trim_memory_";
    private static final String TAG = "MemoryPressureDestroyBehavior";
    private final componentCallbacks.1 componentCallbacks;
    private final AtomicBoolean initialized;

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(String r0, MemoryPressureDestroyBehavior r1) {
        destroyWindowIfNeeded$lambda$4(r0, r1);
    }

    private final boolean shouldDestroyOnTrimMemory(int r2) {
        if (r2 != 10) goto L5;
    L10:
        return true;
    L5:
        if (r2 == 15) goto L10;
        if (r2 >= 40) goto L10;
        return false;
    }

    public void init() {
        if (this.initialized.compareAndSet(false, true) == true) goto L14;
        FLogger.a.i(TAG, "init skipped, already initialized");
        return;
    L14:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        AppHost.a.getApplication().registerComponentCallbacks(this.componentCallbacks);     // Catch: Throwable -> L8
        FLogger.a.i(TAG, "register ComponentCallbacks2 success");     // Catch: Throwable -> L8
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L16;
        FLogger.a.e(TAG, "register ComponentCallbacks2 failed", r2);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public MemoryPressureDestroyBehavior() {
        this.initialized = new AtomicBoolean(false);
        this.componentCallbacks = new componentCallbacks.1(this);
    }

    public void onAppBackground() {
        IBehavior.DefaultImpls.onAppBackground(this);
    }

    public void onAppForeground() {
        IBehavior.DefaultImpls.onAppForeground(this);
    }

    public void onWindowDismiss() {
        IBehavior.DefaultImpls.onWindowDismiss(this);
    }

    public void onWindowHide() {
        IBehavior.DefaultImpls.onWindowHide(this);
    }

    public void onWindowPreDismiss() {
        IBehavior.DefaultImpls.onWindowPreDismiss(this);
    }

    public void onWindowPreHide() {
        IBehavior.DefaultImpls.onWindowPreHide(this);
    }

    public void onWindowPreOpenClear() {
        IBehavior.DefaultImpls.onWindowPreOpenClear(this);
    }

    public void onWindowPreShow() {
        IBehavior.DefaultImpls.onWindowPreShow(this);
    }

    public void onWindowPreloaded() {
        IBehavior.DefaultImpls.onWindowPreloaded(this);
    }

    public void onWindowShow() {
        IBehavior.DefaultImpls.onWindowShow(this);
    }

    private final void destroyWindowIfNeeded(String r2) {
        t0.c(new r(r2, this));
    }

    public static final /* synthetic */ void access$destroyWindowIfNeeded(MemoryPressureDestroyBehavior r0, String r1) {
        r0.destroyWindowIfNeeded(r1);
    }

    public static final /* synthetic */ boolean access$shouldDestroyOnTrimMemory(MemoryPressureDestroyBehavior r0, int r1) {
        return r0.shouldDestroyOnTrimMemory(r1);
    }

    private static final void destroyWindowIfNeeded$lambda$4(String r7, MemoryPressureDestroyBehavior r8) {
        WindowHost r0 = WindowHost.INSTANCE;
        boolean r1 = r0.isShowing();
        boolean r2 = r0.isStashed();
        boolean r3 = r0.isPreloaded();
        FLogger r4 = FLogger.a;
        r4.i(TAG, "try destroy window, reason=" + r7 + ", isShowing=" + r1 + ", isStashed=" + r2 + ", isPreloaded=" + r3);
        if (r1 == false) goto L6;
        r4.i(TAG, "skip destroy window, window is showing, reason=" + r7);
        return;
    L6:
        if (r2 == true) goto L18;
        if (r3 == true) goto L18;
        r4.i(TAG, "skip destroy window, no active window, reason=" + r7);
        return;
    L18:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L12
        r0.dismissWithReason(r7);     // Catch: Throwable -> L12
        r4.i(TAG, "destroy window success, reason=" + r7);     // Catch: Throwable -> L12
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L20;
        FLogger.a.e(TAG, "destroy window failed, reason=" + r7, r10);
        return;
    L20:
        return;
    L12:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public void onScreenRotationChanged(int r1, int r2) {
        IBehavior.DefaultImpls.onScreenRotationChanged(this, r1, r2);
    }
}
