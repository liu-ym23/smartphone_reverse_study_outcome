package com.obric.assistant.interaction.impl.window.behaviors;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Looper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.window.IBehavior;
import com.obric.assistant.interaction.impl.window.WindowHost;
import com.obric.assistant.system.ITaskStackService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/AutoDelayedDestroyBehavior;", "Lcom/obric/assistant/interaction/api/window/IBehavior;", "<init>", "()V", "mainHandler", "Landroid/os/Handler;", "isAppInBackground", "", "tryAutoDestroy", "", "autoDestroyRunnable", "Ljava/lang/Runnable;", "init", "onAppBackground", "onAppForeground", "onWindowPreloaded", "scheduleAutoDestroy", "reason", "", "cancelAutoDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoDelayedDestroyBehavior implements IBehavior {
    private static final long AUTO_DESTROY_DELAY_MS = 300000;
    public static final Companion Companion = null;
    private static final String REASON = "window_auto_destroy_app_background";
    private static final String TAG = "AutoDelayedDestroyBehavior";
    private static Function2<? super Handler, ? super Runnable, Unit> cancelAction;
    private static Function3<? super Handler, ? super Runnable, ? super Long, Unit> scheduleAction;
    private final Runnable autoDestroyRunnable;
    private volatile boolean isAppInBackground;
    private final Handler mainHandler;

    public static /* synthetic */ Unit a(Handler r0, Runnable r1) {
        return cancelAction$lambda$1(r0, r1);
    }

    public static /* synthetic */ void b(AutoDelayedDestroyBehavior r0) {
        autoDestroyRunnable$lambda$0(r0);
    }

    public static /* synthetic */ Unit c(Handler r0, Runnable r1, long r2) {
        return scheduleAction$lambda$2(r0, r1, r2);
    }

    public void init() {
    }

    static {
        Companion = new Companion(null);
        cancelAction = new g();
        scheduleAction = new h();
    }

    private final void tryAutoDestroy() {
        if (this.isAppInBackground == true) goto L5;
        return;
    L5:
        ITaskStackService r0 = (ITaskStackService) ServiceManager.get().getService(ITaskStackService.class);
        String r1 = null;
        if (r0 == null) goto L8;
        ComponentName r2 = r0.c();
    L9:
        if (r2 == null) goto L11;
        String r3 = r2.getPackageName();
    L12:
        boolean r4 = Intrinsics.areEqual(r3, AppHost.a.getApplication().getPackageName());
        if (r2 == null) goto L20;
        if (r4 == true) goto L20;
        FLogger.a.i(TAG, "autoDestroy triggered, top=" + r2.flattenToShortString());
        WindowHost.INSTANCE.dismissWithReason(REASON);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        FLogger.a.e(TAG, "WindowHost.dismiss failed", th);
        return;
    L20:
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("autoDestroy skipped, top=");
        if (r2 == null) goto L23;
        r1 = r2.flattenToShortString();
    L23:
        r6.append(r1);
        r6.append(", isTopSelf=");
        r6.append(r4);
        r5.i(TAG, r6.toString());
        return;
    L11:
        r3 = null;
        goto L12
    L8:
        r2 = null;
        goto L9
    }

    public void onAppBackground() {
        scheduleAutoDestroy("app_background");
    }

    public void onAppForeground() {
        cancelAutoDestroy("app_foreground");
    }

    public void onWindowPreloaded() {
        boolean r0 = AppHost.a.a().isAppBackground();
        FLogger.a.i(TAG, "onWindowPreloaded, isAppBackground=" + r0);
        if (r0 == false) goto L6;
        scheduleAutoDestroy("window_preloaded");
        return;
    }

    public AutoDelayedDestroyBehavior() {
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.autoDestroyRunnable = new i(this);
    }

    public static final /* synthetic */ Function2 access$getCancelAction$cp() {
        return cancelAction;
    }

    public static final /* synthetic */ Function3 access$getScheduleAction$cp() {
        return scheduleAction;
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

    public void onWindowShow() {
        IBehavior.DefaultImpls.onWindowShow(this);
    }

    public static final /* synthetic */ void access$setCancelAction$cp(Function2 r0) {
        cancelAction = r0;
    }

    public static final /* synthetic */ void access$setScheduleAction$cp(Function3 r0) {
        scheduleAction = r0;
    }

    private static final void autoDestroyRunnable$lambda$0(AutoDelayedDestroyBehavior r0) {
        r0.tryAutoDestroy();
    }

    private final void cancelAutoDestroy(String r4) {
        this.isAppInBackground = false;
        cancelAction.invoke(this.mainHandler, this.autoDestroyRunnable);
        FLogger.a.i(TAG, "autoDestroy canceled, reason=" + r4);
    }

    private final void scheduleAutoDestroy(String r6) {
        this.isAppInBackground = true;
        scheduleAction.invoke(this.mainHandler, this.autoDestroyRunnable, Long.valueOf(AUTO_DESTROY_DELAY_MS));
        FLogger.a.i(TAG, "autoDestroy scheduled, reason=" + r6 + ", delayMs=300000");
    }

    private static final Unit cancelAction$lambda$1(Handler r1, Runnable r2) {
        Intrinsics.checkNotNullParameter(r1, "handler");
        Intrinsics.checkNotNullParameter(r2, "runnable");
        r1.removeCallbacks(r2);
        return Unit.INSTANCE;
    }

    public void onScreenRotationChanged(int r1, int r2) {
        IBehavior.DefaultImpls.onScreenRotationChanged(this, r1, r2);
    }

    private static final Unit scheduleAction$lambda$2(Handler r1, Runnable r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "handler");
        Intrinsics.checkNotNullParameter(r2, "runnable");
        cancelAction.invoke(r1, r2);
        r1.postDelayed(r2, r3);
        return Unit.INSTANCE;
    }
}
