package com.obric.assistant.interaction.impl.window.behaviors;

import android.os.Handler;
import android.os.Looper;
import com.larus.bmhome.auth.LaunchBiz;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.chat.api.IAuthModelService;
import com.larus.bmhome.chat.api.e0;
import com.larus.im.b;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.window.IBehavior;
import com.obric.assistant.network.api.IObricNetworkService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import gd9.i;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/WindowLaunchRecoveryBehavior;", "Lcom/obric/assistant/interaction/api/window/IBehavior;", "<init>", "()V", "mainHandler", "Landroid/os/Handler;", "recoveryRunnable", "Ljava/lang/Runnable;", "init", "", "onAppForeground", "scheduleRecovery", "recoverLaunchIfNeeded", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowLaunchRecoveryBehavior implements IBehavior {
    public static final Companion Companion = null;
    private static final String TAG = "WindowLaunchRecovery";
    private final Handler mainHandler;
    private final Runnable recoveryRunnable;

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(WindowLaunchRecoveryBehavior r0) {
        recoveryRunnable$lambda$0(r0);
    }

    public void init() {
    }

    private final void recoverLaunchIfNeeded() {
        i r0 = b.a;
        Intrinsics.checkNotNull(r0);
        boolean r1 = r0.a().e;
        boolean r2 = AccountService.a.isLogin().booleanValue();
        if (r1 == true) goto L39;
        if (r2 == false) goto L39;
        IAuthModelService r3 = (IAuthModelService) ServiceManager.get().getService(IAuthModelService.class);
        if (r3 != null) goto L10;
        FLogger.a.w(TAG, "skip Launch recovery, auth service is missing");
        return;
    L10:
        c1 r4 = (c1) r3.i().getValue();
        Integer r5 = null;
        if (r4 == null) goto L13;
        Integer r6 = Integer.valueOf(r4.b);
    L14:
        e0 r7 = (e0) r3.e().getValue();
        if (r7 == null) goto L18;
        r5 = Integer.valueOf(r7.b);
    L18:
        if (r6 != null) goto L21;
    L22:
        if (r5 != null) goto L25;
    L26:
        FLogger.a.i(TAG, "skip Launch recovery, imStatus=" + r6 + ", fullStatus=" + r5);
        return;
    L25:
        if (r5.intValue() != 3) goto L26;
    L28:
        IObricNetworkService r8 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        if (r8 == null) goto L33;
        boolean r9 = true;
        if (r8.isNetworkAvailable() != true) goto L33;
    L34:
        if (r9 == true) goto L37;
        FLogger.a.i(TAG, "skip Launch recovery, networkAvailable=false, imStatus=" + r6 + ", fullStatus=" + r5);
        return;
    L37:
        FLogger.a.i(TAG, "request Launch recovery, imStatus=" + r6 + ", fullStatus=" + r5);
        r3.t(TAG, SetsKt.setOf(LaunchBiz.IM), false);
        return;
    L33:
        r9 = false;
        goto L34
    L21:
        if (r6.intValue() == 3) goto L28;
    L13:
        r6 = null;
    L39:
        FLogger.a.i(TAG, "skip Launch recovery, appBackground=" + r1 + ", isLogin=" + r2);
    }

    private final void scheduleRecovery() {
        this.mainHandler.removeCallbacks(this.recoveryRunnable);
        this.mainHandler.post(this.recoveryRunnable);
        FLogger.a.i(TAG, "Launch recovery scheduled, reason=app_foreground");
    }

    public WindowLaunchRecoveryBehavior() {
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.recoveryRunnable = new c0(this);
    }

    public void onAppBackground() {
        IBehavior.DefaultImpls.onAppBackground(this);
    }

    public void onAppForeground() {
        scheduleRecovery();
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

    private static final void recoveryRunnable$lambda$0(WindowLaunchRecoveryBehavior r0) {
        r0.recoverLaunchIfNeeded();
    }

    public void onScreenRotationChanged(int r1, int r2) {
        IBehavior.DefaultImpls.onScreenRotationChanged(this, r1, r2);
    }
}
