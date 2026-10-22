package com.obric.assistant.interaction.impl.window.behaviors;

import android.content.ComponentName;
import android.os.SystemClock;
import com.larus.home.api.main.HomeService;
import com.larus.im.FlowRuntime;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.window.IBehavior;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import com.obric.assistant.interaction.impl.window.WindowHost;
import com.obric.assistant.system.ITaskStackService;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u001c\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/TaskStackChangeBehavior;", "Lcom/obric/assistant/interaction/api/window/IBehavior;", "Lcom/obric/assistant/system/ITaskStackListener;", "<init>", "()V", "showTime", "", "init", "", "onWindowShow", "onWindowHide", "onChange", "fromTopActivity", "Landroid/content/ComponentName;", "toTopActivity", "onTaskCreated", DBDefinition.TASK_ID, "", "componentName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskStackChangeBehavior implements IBehavior, lha.g {
    public static final Companion Companion = null;
    private static final long STASH_TIME_THRESHOLD = 500;
    private static final String TAG = "TaskStackChangeBehavior";
    private long showTime;

    static {
        Companion = new Companion(null);
    }

    public TaskStackChangeBehavior() {
    }

    public static /* synthetic */ void a(ComponentName r0, ComponentName r1) {
        onChange$lambda$0(r0, r1);
    }

    public static /* synthetic */ void b() {
        onTaskCreated$lambda$1();
    }

    public void init() {
    }

    private static final void onTaskCreated$lambda$1() {
        if (ActivityStartBehavior.Companion.isWaitingDeferredWindowStash() == false) goto L6;
        FLogger.a.i(TAG, "ignore task created stash because ActivityStartBehavior is waiting");
        return;
    L6:
        WindowHost.INSTANCE.stash(WindowAnimationType.Slide);
    }

    public void onWindowHide() {
        ITaskStackService r0 = (ITaskStackService) ServiceManager.get().getService(ITaskStackService.class);
        if (r0 == null) goto L6;
        r0.a(this);
        return;
    }

    public void onWindowShow() {
        this.showTime = SystemClock.elapsedRealtime();
        ITaskStackService r0 = (ITaskStackService) ServiceManager.get().getService(ITaskStackService.class);
        if (r0 == null) goto L6;
        r0.d(this);
        return;
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

    private static final void onChange$lambda$0(ComponentName r4, ComponentName r5) {
        if (ActivityStartBehavior.Companion.isWaitingDeferredWindowStash() == false) goto L6;
        FLogger.a.i(TAG, "ignore task stack stash because ActivityStartBehavior is waiting");
        return;
    L6:
        FLogger r0 = FLogger.a;
        StringBuilder r2 = new StringBuilder("task stack changed stash window, from ");
        r2.append(r4.getClassName());
        r2.append(" to ");
        if (r5 == null) goto L9;
        String r6 = r5.getClassName();
    L10:
        r2.append(r6);
        r0.i(TAG, r2.toString());
        WindowHost.INSTANCE.stash(WindowAnimationType.Slide);
        return;
    L9:
        r6 = null;
        goto L10
    }

    @Override // lha.g
    public void onChange(ComponentName r8, ComponentName r9) {
        String r0 = null;
        if (r8 != null) goto L10;
        FLogger r10 = FLogger.a;
        StringBuilder r2 = new StringBuilder("ignore initial task stack change to ");
        if (r9 == null) goto L7;
        r0 = r9.getClassName();
    L7:
        r2.append(r0);
        r10.i(TAG, r2.toString());
        return;
    L10:
        if (Intrinsics.areEqual(r8.getClassName(), HomeService.a.P()) == false) goto L16;
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L16;
        FLogger.a.i(TAG, "ignore task stack change from " + r8.getClassName());
        return;
    L16:
        if (WindowHost.INSTANCE.isShowing() == true) goto L18;
        return;
    L18:
        if ((SystemClock.elapsedRealtime() - this.showTime) >= STASH_TIME_THRESHOLD) goto L24;
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("ignore task stack change within show threshold, from ");
        r4.append(r8.getClassName());
        r4.append(" to ");
        if (r9 == null) goto L22;
        r0 = r9.getClassName();
    L22:
        r4.append(r0);
        r3.i(TAG, r4.toString());
        return;
    L24:
        t0.e(new a0(r8, r9));
    }

    public void onScreenRotationChanged(int r1, int r2) {
        IBehavior.DefaultImpls.onScreenRotationChanged(this, r1, r2);
    }

    @Override // lha.g
    public void onTaskCreated(int r3, ComponentName r4) {
        FLogger.a.i(TAG, "onTaskCreated " + r4);
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L9;
        if (r4 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r4.getPackageName(), FlowRuntime.a().getApplication().getPackageName()) == true) goto L11;
        t0.e(new z());
        return;
    L11:
        return;
    }
}
