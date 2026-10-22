package com.obric.memorydata.task.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.bytedance.crash.Ensure;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.logging.e;
import com.obric.memorydata.middleware.api.logging.g;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.task.AbsTaskRequest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.w;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.task.utils.TaskAlarmUtils$scheduleAlarm$1", f = "TaskAlarmUtils.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
final class TaskAlarmUtils$scheduleAlarm$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isDelay;
    final /* synthetic */ AbsTaskRequest $request;
    final /* synthetic */ boolean $triggerAlarm;
    final /* synthetic */ long $triggerTime;
    int label;

    TaskAlarmUtils$scheduleAlarm$1(AbsTaskRequest r3, Context r4, long r5, boolean r7, boolean r8, Continuation<? super TaskAlarmUtils$scheduleAlarm$1> r9) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.$request = r3;
        this.$context = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.$triggerTime = r5;
        this.$isDelay = r7;
        this.$triggerAlarm = r8;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new TaskAlarmUtils$scheduleAlarm$1(this.$request, this.$context, this.$triggerTime, this.$isDelay, this.$triggerAlarm, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((TaskAlarmUtils$scheduleAlarm$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), TaskAlarmUtils$scheduleAlarm$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r20) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r20);
    L12:
        if (b.a(b.f12969a, this.$request) == true) goto L18;
        o r1 = (o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.b.f11611a, o.class, "com.obric.memorydata.plugin");
        AbsTaskRequest r3 = this.$request;
        e r9 = new e(null, null, null, 7, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L17;
        g r4 = new g();
        r4.a("package_name", r3.getTaskParameter().getName());
        Unit r5 = Unit.INSTANCE;
        r1.a("Alarm 自动触发调度已被 Feature 开关拦截", r9, r4.a());
    L17:
        return Unit.INSTANCE;
    L18:
        Object r6 = this.$context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.app.AlarmManager");
        AlarmManager r7 = (AlarmManager) ZeusTransformUtils.preCheckCast(r6, AlarmManager.class, "com.obric.memorydata.plugin");
        String r8 = this.$request.getTaskParameter().getUuid().toString();
        Intrinsics.checkNotNullExpressionValue(r8, "toString(...)");
        Intent r10 = new Intent("com.obric.memorydata.task.action.TASK_ALARM").setPackage(this.$context.getPackageName()).putExtra("task_request", r8);
        Intrinsics.checkNotNullExpressionValue(r10, "putExtra(...)");
        int r11 = this.$request.getTaskParameter().getUuid().hashCode();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskAlarmUtils", "send requestCode: " + r11 + " task: " + this.$request.getTaskParameter().getName(), false, 4, null);
        PendingIntent r12 = PendingIntent.getBroadcast(this.$context, r11, r10, 201326592);
        ((Map) ZeusTransformUtils.preCheckCast(com.obric.memorydata.task.scheduler.impl.c.f12961a.a(), Map.class, "com.obric.memorydata.plugin")).put(r8, new Pair(this.$request, r12));
        if (b.a(b.f12969a, this.$request) == true) goto L25;
        com.obric.memorydata.task.scheduler.impl.c.f12961a.a().remove(r8);
        r12.cancel();
        o r13 = (o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.b.f11611a, o.class, "com.obric.memorydata.plugin");
        AbsTaskRequest r14 = this.$request;
        e r15 = new e(null, null, null, 7, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L24;
        g r16 = new g();
        r16.a("package_name", r14.getTaskParameter().getName());
        Unit r17 = Unit.INSTANCE;
        r13.a("并发关闭后的 Alarm 自动触发载体已撤销", r15, r16.a());
    L24:
        return Unit.INSTANCE;
    L25:
        Integer r18 = (Integer) ZeusTransformUtils.preCheckCast(com.obric.memorydata.task.scheduler.impl.c.f12961a.b().get(this.$request.getTaskParameter().getName()), Integer.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L28;
        int r19 = r18.intValue();
    L30:
        if (r19 <= com.obric.memorydata.task.scheduler.impl.c.f12961a.c()) goto L33;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EnqueueRunnable", "send uuid: " + r8 + " request " + this.$request + " reach max count", null, 4, null);
        Ensure.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("定时任务设置过多，检查定时任务逻辑是否符合预期: " + this.$request.getTaskParameter().getName()), Throwable.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    L33:
        b.a(b.f12969a, r11);
        ((Map) ZeusTransformUtils.preCheckCast(com.obric.memorydata.task.scheduler.impl.c.f12961a.b(), Map.class, "com.obric.memorydata.plugin")).put(this.$request.getTaskParameter().getName(), Boxing.boxInt(r19 + 1));
    L53:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskAlarmUtils", "scheduleAlarm failed, error: " + e, null, 4, null);
        Tracker r21 = Tracker.INSTANCE;
        JSONObject r22 = new JSONObject();
        AbsTaskRequest r23 = this.$request;
        r22.put("error", ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));
        r22.put(Ext.KEY_REQUEST, r23.getTaskParameter().getName());
        Unit r24 = Unit.INSTANCE;
        r21.reportEvent("task_alarm_schedule_failed", r22);
    L56:
        return Unit.INSTANCE;
    L36:
        if (this.$request.getTaskParameter().getTriggerExactly() == false) goto L45;
        if (r7.canScheduleExactAlarms() == false) goto L45;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskAlarmUtils", "trigger setExactAndAllowWhileIdle send uuid: " + r8 + " trigger: " + this.$triggerTime + " request " + this.$request, false, 4, null);     // Catch: Exception -> L53
        if (this.$isDelay == false) goto L42;
        this.$request.getTaskParameter().setDelay((com.obric.memorydata.task.impl.g) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.impl.e(), com.obric.memorydata.task.impl.g.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L53
    L42:
        long r25 = this.$triggerTime;     // Catch: Exception -> L53
    L43:
        r7.setExactAndAllowWhileIdle(0, r25, r12);     // Catch: Exception -> L53
    L45:
        if (this.$isDelay == false) goto L48;
        long r110 = this.$request.getTaskParameter().getDelay().b().toMillis(this.$request.getTaskParameter().getDelay().a());     // Catch: Exception -> L53
        this.$request.getTaskParameter().setDelay((com.obric.memorydata.task.impl.g) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.impl.e(), com.obric.memorydata.task.impl.g.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L53
        r25 = b.a(b.f12969a, r110, false, 2, null);     // Catch: Exception -> L53
    L51:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskAlarmUtils", "trigger setAndAllowWhileIdle send uuid: " + r8 + " trigger: " + r25 + " request " + this.$request, false, 4, null);     // Catch: Exception -> L53
        goto L43
    L48:
        if (this.$triggerAlarm == false) goto L50;
        r25 = b.a(b.f12969a, this.$triggerTime, true);     // Catch: Exception -> L53
        goto L51
    L50:
        r25 = b.a(b.f12969a, this.$request.getTaskParameter().getInterval().b().toMillis(this.$request.getTaskParameter().getInterval().a()), false, 2, null);     // Catch: Exception -> L53
        goto L51
    L28:
        r19 = 0;
        goto L30
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        w r26 = b.b();
        Continuation r27 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r26.a(r27) != r0) goto L12;
        return r0;
    }
}
