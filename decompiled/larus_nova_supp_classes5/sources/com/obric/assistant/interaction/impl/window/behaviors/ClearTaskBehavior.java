package com.obric.assistant.interaction.impl.window.behaviors;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.window.IBehavior;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0002J$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0003J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0003J\"\u0010\u0015\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/ClearTaskBehavior;", "Lcom/obric/assistant/interaction/api/window/IBehavior;", "<init>", "()V", "zombieTasksCleared", "", "init", "", "onAppBackground", "onAppForeground", "clearHistoricalRecentTasks", "isMainProcessTask", "packageManager", "Landroid/content/pm/PackageManager;", "baseActivity", "Landroid/content/ComponentName;", "topActivity", "getTaskBaseActivity", "taskInfo", "Landroid/app/ActivityManager$RecentTaskInfo;", "getTaskTopActivity", "isMainProcessActivity", "activity", "allowEmpty", "isMainProcessName", "processName", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClearTaskBehavior implements IBehavior {
    public static final Companion Companion = null;
    public static final String TAG = "ClearTaskBehavior";
    private boolean zombieTasksCleared;

    static {
        Companion = new Companion(null);
    }

    public ClearTaskBehavior() {
    }

    public void init() {
    }

    public void onAppBackground() {
    }

    private final void clearHistoricalRecentTasks() {
        AppHost.Companion r0 = AppHost.a;
        Activity r1 = r0.a().getCurrentActivity();
        if (r1 == null) goto L18;
        this.zombieTasksCleared = true;
        Object r2 = r0.getApplication().getSystemService("activity");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.app.ActivityManager");
        PackageManager r3 = r0.getApplication().getPackageManager();
        List<ActivityManager.AppTask> r4 = ((ActivityManager) r2).getAppTasks();
        if (r4 != null) goto L7;
        return;
    L7:
        FLogger.a.i(TAG, "appTasks.size = " + r4.size());
        int r5 = r1.getTaskId();
        Iterator<ActivityManager.AppTask> r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L26;
        ActivityManager.AppTask r7 = r6.next();
        ActivityManager.RecentTaskInfo r8 = r7.getTaskInfo();
        if (Build.VERSION.SDK_INT < 29) goto L13;
        int r9 = r8.taskId;
    L14:
        Intrinsics.checkNotNull(r8);
        ComponentName r10 = getTaskBaseActivity(r8);
        ComponentName r11 = getTaskTopActivity(r8);
        Intrinsics.checkNotNull(r3);
        boolean r12 = isMainProcessTask(r3, r10, r11);
        FLogger.a.i(TAG, "taskId = " + r9 + ", currentTaskId = " + r5 + ", baseActivity = " + r10 + ", topActivity = " + r11 + ", isMainProcessTask = " + r12);
        if (r9 == r5) goto L9;
        if (r12 == false) goto L9;
        r7.finishAndRemoveTask();
        goto L9
    L13:
        r9 = r8.id;
        goto L14
    L26:
        return;
    }

    public void onAppForeground() {
        if (this.zombieTasksCleared == false) goto L5;
        return;
    L5:
        clearHistoricalRecentTasks();
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

    private final ComponentName getTaskBaseActivity(ActivityManager.RecentTaskInfo r3) {
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        return null;
    L7:
        return r3.baseActivity;
    }

    private final ComponentName getTaskTopActivity(ActivityManager.RecentTaskInfo r3) {
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        return null;
    L7:
        return r3.topActivity;
    }

    private final boolean isMainProcessName(String r7) {
        AppHost.Companion r0 = AppHost.a;
        ApplicationInfo r1 = r0.getApplication().getApplicationInfo();
        if (r1 == null) goto L6;
        String r2 = r1.processName;
        if (r2 == null) goto L6;
    L8:
        if (r7 != null) goto L10;
    L13:
        boolean r3 = true;
    L14:
        if (r3 == false) goto L17;
        r7 = r2;
    L20:
        return Intrinsics.areEqual(r7, r2);
    L17:
        if (StringsKt.startsWith$default(r7, ":", false, 2, null) == false) goto L20;
        r7 = r0.getApplication().getPackageName() + r7;
        goto L20
    L10:
        if (r7.length() == 0) goto L13;
        r3 = false;
    L6:
        r2 = r0.getApplication().getPackageName();
        goto L8
    }

    public void onScreenRotationChanged(int r1, int r2) {
        IBehavior.DefaultImpls.onScreenRotationChanged(this, r1, r2);
    }

    private final boolean isMainProcessActivity(PackageManager r4, ComponentName r5, boolean r6) {
        if (r5 != null) goto L22;
        return r6;
    L22:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L12
        ActivityInfo r8 = r4.getActivityInfo(r5, 0);     // Catch: Throwable -> L12
        String r9 = r8.processName;     // Catch: Throwable -> L12
        if (r9 != null) goto L10;
        ApplicationInfo r10 = r8.applicationInfo;     // Catch: Throwable -> L12
        if (r10 == null) goto L9;
        r9 = r10.processName;     // Catch: Throwable -> L12
        goto L10
    L9:
        r9 = null;
    L10:
        Object r11 = Result.constructor-impl(Boolean.valueOf(isMainProcessName(r9)));     // Catch: Throwable -> L12
    L14:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L17;
        FLogger.a.w(TAG, "resolve activity process failed, activity = " + r5, r12);
    L17:
        Boolean r13 = Boolean.FALSE;
        if (Result.isFailure-impl(r11) == false) goto L21;
        r11 = r13;
    L21:
        return ((Boolean) r11).booleanValue();
    L12:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    private final boolean isMainProcessTask(PackageManager r2, ComponentName r3, ComponentName r4) {
        boolean r5 = isMainProcessActivity(r2, r3, false);
        boolean r6 = isMainProcessActivity(r2, r4, false);
        if (r5 == false) goto L7;
        if (r6 == false) goto L8;
        return true;
    L8:
        return false;
    L7:
        return false;
    }
}
