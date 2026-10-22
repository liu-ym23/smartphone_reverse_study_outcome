package com.obric.memorydata.task.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.Api;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.cron.CronJobRunnerTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u0010J\f\u0010\u0019\u001a\u00020\u0010*\u00020\u0015H\u0002J\u001a\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\u0010H\u0002J\u0006\u0010\u001d\u001a\u00020\u000eJ\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010\u0005J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/memorydata/task/utils/TaskAlarmUtils;", "", "<init>", "()V", "TAG", "", "ALARM_REQUEST_CODE_SET", "TRIGGER_INTERVAL_MS", "", "TEA_ALARM_FAILED_EVENT", "scope", "Lkotlinx/coroutines/CoroutineScope;", "clearAlarmReady", "Lkotlinx/coroutines/CompletableDeferred;", "", "isClearAlarmInitiated", "", "scheduleAlarm", "context", "Landroid/content/Context;", Ext.KEY_REQUEST, "Lcom/obric/memorydata/task/AbsTaskRequest;", "triggerTime", "isDelay", "triggerAlarm", "canScheduleAutoTrigger", "calculateAlignedTriggerTime", "delayTime", "isTriggerAlarm", "tryClearExistedAlarmOnFirstSchedule", "saveAlarmRequestCode", "requestCode", "", "removeAlarmInfo", Api.KEY_UUID, "clearAlarmByRequestCode", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12969a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f12970b = null;
    private static final w<Unit> c = null;
    private static boolean d;

    static {
        f12969a = new b();
        f12970b = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
        c = y.a(null, 1, null);
    }

    private b() {
    }

    private final long a(long r9, boolean r11) {
        long r0 = System.currentTimeMillis();
        long r2 = r0 - SystemClock.elapsedRealtime();
        if (r11 == true) goto L7;
        r9 = r9 + r0;
    L7:
        return Math.max(r2 + (((((r9 - r2) + 300000) - 1) / 300000) * 300000), r9);
    }

    public static final /* synthetic */ long a(b r0, long r1, boolean r3) {
        return r0.a(r1, r3);
    }

    static /* synthetic */ long a(b r0, long r1, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r3 = false;
    L6:
        return r0.a(r1, r3);
    }

    private final void a(int r9) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskAlarmUtils", "saveAlarmRequestCode code: " + r9, false, 4, null);
        HashSet r8 = new HashSet();
        r8.addAll((Collection) ZeusTransformUtils.preCheckCast(IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getStringSet("ALARM_REQUEST_CODE_SET", SetsKt.emptySet()), Collection.class, "com.obric.memorydata.plugin"));
        r8.add(String.valueOf(r9));
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).saveStringSet("ALARM_REQUEST_CODE_SET", (Set) ZeusTransformUtils.preCheckCast(r8, Set.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(b r0, int r1) {
        r0.a(r1);
    }

    public static /* synthetic */ void a(b r7, Context r8, AbsTaskRequest r9, long r10, boolean r12, boolean r13, int r14, Object r15) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        if ((r14 & 8) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r14 & 16) == 0) goto L9;
        boolean r6 = false;
    L10:
        r7.a(r1, r9, r10, r5, r6);
        return;
    L9:
        r6 = r13;
        goto L10
    L5:
        r5 = r12;
        goto L7
    }

    private final boolean a(AbsTaskRequest r6) {
        String r5 = r6.getTaskParameter().getInputParams().optString("trigger_source");
        if (StringsKt.startsWith$default(r6.getTaskParameter().getName(), CronJobRunnerTask.TASK_NAME_PREFIX, false, 2, null) == false) goto L6;
        String r7 = r6.getTaskParameter().getInputParams().optString(CronJobRunnerTask.KEY_TARGET_TASK);
    L12:
        Intrinsics.checkNotNull(r7);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L17;
        if (AwarenessManager.INSTANCE.isPackageAutoTriggerEnabled(r7) == true) goto L17;
        return false;
    L17:
        return true;
    L6:
        if (Intrinsics.areEqual(r5, CommonConsts.TIMER_TYPE) == false) goto L8;
    L11:
        r7 = r6.getTaskParameter().getName();
        goto L12
    L8:
        if (Intrinsics.areEqual(r5, CronJobRunnerTask.KEY_TRIGGER_SOURCE_VALUE) == true) goto L11;
        return true;
    }

    public static final /* synthetic */ boolean a(b r0, AbsTaskRequest r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ w b() {
        return c;
    }

    private final void b(int r9) {
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Object r1 = r8.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.AlarmManager");
        AlarmManager r2 = (AlarmManager) ZeusTransformUtils.preCheckCast(r1, AlarmManager.class, "com.obric.memorydata.plugin");
        Intent r3 = new Intent("com.obric.memorydata.task.action.TASK_ALARM").setPackage(r8.getPackageName());
        Intrinsics.checkNotNullExpressionValue(r3, "setPackage(...)");
        PendingIntent r10 = PendingIntent.getBroadcast(r8, r9, r3, 603979776);
        if (r10 == null) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskAlarmUtils", "cancel requestCode " + r9, false, 4, null);
        r2.cancel(r10);     // Catch: RuntimeException -> L7
    L9:
        r10.cancel();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public static final /* synthetic */ void b(b r0, int r1) {
        r0.b(r1);
    }

    public final void a() {
        if (d == false) goto L5;
        return;
    L5:
        d = true;
        i.a(f12970b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new TaskAlarmUtils$tryClearExistedAlarmOnFirstSchedule$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void a(Context r10, AbsTaskRequest r11, long r12, boolean r14, boolean r15) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r11, Ext.KEY_REQUEST);
        i.a(f12970b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new TaskAlarmUtils$scheduleAlarm$1(r11, r3, r12, r14, r15, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void a(String r15) {
        if (r15 != null) goto L4;
        return;
    L4:
        String r14 = String.valueOf(r15.hashCode());
        Set<String> r0 = CollectionsKt.toMutableSet((Iterable) ZeusTransformUtils.preCheckCast(IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getStringSet("ALARM_REQUEST_CODE_SET", SetsKt.emptySet()), Iterable.class, "com.obric.memorydata.plugin"));
        if (r0.remove(r14) == false) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskAlarmUtils", "remove alarm task uuid " + r15, false, 4, null);
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).saveStringSet("ALARM_REQUEST_CODE_SET", r0);
        return;
    }
}
