package com.obric.assistant.interaction.impl.window.behaviors;

import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.window.IBehavior;
import com.obric.assistant.interaction.impl.window.WindowHost;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0010\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\n\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f\u0018\u00010\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006 "}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/MainBotActivityResumeDestroyBehavior;", "Lcom/obric/assistant/interaction/api/window/IBehavior;", "<init>", "()V", "mainHandler", "Landroid/os/Handler;", "windowOpenGeneration", "Ljava/util/concurrent/atomic/AtomicInteger;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pendingDestroyRunnables", "", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "", "lifecycleCallbacks", "com/obric/assistant/interaction/impl/window/behaviors/MainBotActivityResumeDestroyBehavior$lifecycleCallbacks$1", "Lcom/obric/assistant/interaction/impl/window/behaviors/MainBotActivityResumeDestroyBehavior$lifecycleCallbacks$1;", "init", "", "onWindowPreShow", "onWindowDismiss", "scheduleDestroyIfWindowActive", "activity", "Landroidx/fragment/app/FragmentActivity;", "tryDestroyAfterDelay", "scheduledGeneration", "", "cancelAllPendingDestroy", "reason", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MainBotActivityResumeDestroyBehavior implements IBehavior {
    public static final Companion Companion = null;
    private static final long DESTROY_DELAY_MS = 2000;
    private static final String REASON = "window_auto_destroy_main_bot_resumed";
    private static final String TAG = "MainBotActivityResumeDestroyBehavior";
    private final AtomicBoolean initialized;
    private final lifecycleCallbacks.1 lifecycleCallbacks;
    private final Handler mainHandler;
    private final Set<Runnable> pendingDestroyRunnables;
    private final AtomicInteger windowOpenGeneration;

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(MainBotActivityResumeDestroyBehavior r0, Ref.ObjectRef r1, FragmentActivity r2, int r3) {
        scheduleDestroyIfWindowActive$lambda$2(r0, r1, r2, r3);
    }

    public void init() {
        if (this.initialized.compareAndSet(false, true) == true) goto L14;
        FLogger.a.i(TAG, "init skipped, already initialized");
        return;
    L14:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        AppHost.a.getApplication().registerActivityLifecycleCallbacks(this.lifecycleCallbacks);     // Catch: Throwable -> L8
        FLogger.a.i(TAG, "register ActivityLifecycleCallbacks success");     // Catch: Throwable -> L8
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L16;
        FLogger.a.e(TAG, "register ActivityLifecycleCallbacks failed", r2);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public void onWindowPreShow() {
        int r0 = this.windowOpenGeneration.getAndIncrement();
        cancelAllPendingDestroy("window pre show, oldGeneration=" + r0 + ", newGeneration=" + (r0 + 1));
    }

    public MainBotActivityResumeDestroyBehavior() {
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.windowOpenGeneration = new AtomicInteger(0);
        this.initialized = new AtomicBoolean(false);
        this.pendingDestroyRunnables = Collections.synchronizedSet(new LinkedHashSet());
        this.lifecycleCallbacks = new lifecycleCallbacks.1(this);
    }

    public void onWindowDismiss() {
        cancelAllPendingDestroy("window dismissed");
    }

    public void onAppBackground() {
        IBehavior.DefaultImpls.onAppBackground(this);
    }

    public void onAppForeground() {
        IBehavior.DefaultImpls.onAppForeground(this);
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

    public void onWindowPreloaded() {
        IBehavior.DefaultImpls.onWindowPreloaded(this);
    }

    public void onWindowShow() {
        IBehavior.DefaultImpls.onWindowShow(this);
    }

    private final void cancelAllPendingDestroy(String r6) {
        List r0 = CollectionsKt.toList(this.pendingDestroyRunnables);
        if (r0.isEmpty() == false) goto L6;
        FLogger.a.i(TAG, "cancel pending destroy skipped, no pending task, reason=" + r6);
        return;
    L6:
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        this.mainHandler.removeCallbacks((Runnable) r1.next());
        goto L8
    L10:
        this.pendingDestroyRunnables.clear();
        FLogger.a.i(TAG, "cancel pending destroy, count=" + r0.size() + ", reason=" + r6);
    }

    private final void scheduleDestroyIfWindowActive(FragmentActivity r11) {
        WindowHost r0 = WindowHost.INSTANCE;
        boolean r1 = r0.isShowing();
        boolean r2 = r0.isStashed();
        boolean r3 = r0.isPreloaded();
        int r4 = this.windowOpenGeneration.get();
        FLogger r5 = FLogger.a;
        r5.i(TAG, "onActivityResumed: activity=" + r11.getClass().getName() + ", isShowing=" + r1 + ", isStashed=" + r2 + ", isPreloaded=" + r3 + ", generation=" + r4);
        if (r1 == true) goto L8;
        if (r2 == true) goto L8;
        if (r3 == true) goto L8;
        r5.i(TAG, "skip schedule, no active window, activity=".concat(r11.getClass().getName()));
        return;
    L8:
        Ref.ObjectRef r6 = new Ref.ObjectRef();
        Runnable r7 = new q(this, r6, r11, r4);
        r6.element = r7;
        this.pendingDestroyRunnables.add(r7);
        Handler r8 = this.mainHandler;
        Object r9 = r6.element;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("runnable");
        Runnable r10 = null;
    L12:
        r8.postDelayed(r10, DESTROY_DELAY_MS);
        r5.i(TAG, "schedule destroy after 2000ms, activity=" + r11.getClass().getName() + ", generation=" + r4);
        return;
    L11:
        r10 = (Runnable) r9;
        goto L12
    }

    public static final /* synthetic */ void access$scheduleDestroyIfWindowActive(MainBotActivityResumeDestroyBehavior r0, FragmentActivity r1) {
        r0.scheduleDestroyIfWindowActive(r1);
    }

    private final void tryDestroyAfterDelay(FragmentActivity r12, int r13) {
        int r1 = this.windowOpenGeneration.get();
        WindowHost r2 = WindowHost.INSTANCE;
        boolean r3 = r2.isShowing();
        boolean r4 = r2.isStashed();
        boolean r5 = r2.isPreloaded();
        boolean r6 = r12.isDestroyed();
        FLogger r7 = FLogger.a;
        r7.i(TAG, "tryDestroyAfterDelay: activity=" + r12.getClass().getName() + ", scheduledGeneration=" + r13 + ", currentGeneration=" + r1 + ", isShowing=" + r3 + ", isStashed=" + r4 + ", isPreloaded=" + r5 + ", activityDestroyed=" + r6 + ", activityFinishing=" + r12.isFinishing());
        if (r13 == r1) goto L6;
        r7.i(TAG, "skip destroy, window opened during delay, scheduledGeneration=" + r13 + ", currentGeneration=" + r1);
        return;
    L6:
        if (r3 == false) goto L9;
        r7.i(TAG, "skip destroy, window is showing after delay");
        return;
    L9:
        if (r4 == true) goto L13;
        if (r5 == true) goto L13;
        r7.i(TAG, "skip destroy, no active window after delay");
        return;
    L13:
        if (r6 == false) goto L16;
        r7.i(TAG, "skip destroy, activity already destroyed: ".concat(r12.getClass().getName()));
        return;
    L16:
        boolean r14 = WindowUtils.INSTANCE.isMainBotActivity(r12);
        r7.i(TAG, "main bot check result=" + r14 + ", activity=" + r12.getClass().getName());
        if (r14 == true) goto L28;
        r7.i(TAG, "skip destroy, activity is not main bot: ".concat(r12.getClass().getName()));
        return;
    L28:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L22
        r2.dismissWithReason(REASON);     // Catch: Throwable -> L22
        r7.i(TAG, "destroy window success, reason=window_auto_destroy_main_bot_resumed, activity=".concat(r12.getClass().getName()));     // Catch: Throwable -> L22
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L30;
        FLogger.a.e(TAG, "destroy window failed, reason=window_auto_destroy_main_bot_resumed, activity=".concat(r12.getClass().getName()), r17);
        return;
    L30:
        return;
    L22:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    }

    public void onScreenRotationChanged(int r1, int r2) {
        IBehavior.DefaultImpls.onScreenRotationChanged(this, r1, r2);
    }

    private static final void scheduleDestroyIfWindowActive$lambda$2(MainBotActivityResumeDestroyBehavior r1, Ref.ObjectRef r2, FragmentActivity r3, int r4) {
        Set<Runnable> r0 = r1.pendingDestroyRunnables;
        Object r5 = r2.element;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("runnable");
        Runnable r6 = null;
    L6:
        r0.remove(r6);
        r1.tryDestroyAfterDelay(r3, r4);
        return;
    L5:
        r6 = (Runnable) r5;
        goto L6
    }
}
