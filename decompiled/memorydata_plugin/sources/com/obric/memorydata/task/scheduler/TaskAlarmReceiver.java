package com.obric.memorydata.task.scheduler;

import android.content.Context;
import android.content.Intent;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.utils.d;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/task/scheduler/TaskAlarmReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "Companion", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TaskAlarmReceiver extends PluginBroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12952a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/task/scheduler/TaskAlarmReceiver$Companion;", "", "<init>", "()V", "TAG", "", "ACTION_TASK_ALARM", "TASK_ID_KEY", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12952a = new a(null);
    }

    public TaskAlarmReceiver() {
    }

    private static final Integer a(String r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.intValue() > 0) goto L8;
        return null;
    L8:
        if (r3.intValue() != 1) goto L11;
        return null;
    L11:
        return Integer.valueOf(r3.intValue() - 1);
    }

    private static final Integer a(Function2 r2, Object r3, Object r4) {
        return (Integer) ZeusTransformUtils.preCheckCast(((Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin")).invoke(r3, r4), Integer.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$TdQPx4vJRtp6-mWwfCwjFI7w-uE, reason: not valid java name */
    public static /* synthetic */ Integer m1195lambda$TdQPx4vJRtp6mWwfCwjFI7wuE(String r0, Integer r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Integer lambda$Y_ibwxa9GaFL46lqG_ZnetbjDkE(Function2 r0, Object r1, Object r2) {
        return a(r0, r1, r2);
    }

    public void onReceive(Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin"), "context");
        Intrinsics.checkNotNullParameter(r9, MemorySourceLinkType.INTENT);
        String r7 = r9.getStringExtra("task_request");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskAlarmReceiver", "alarm received taskId=" + r7, false, 4, null);
        if (r7 != null) goto L5;
    L12:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskAlarmReceiver", "alarm request missing taskId=" + r7, null, 4, null);
    L13:
        com.obric.memorydata.task.utils.b.f12969a.a(r7);
        return;
    L5:
        if (com.obric.memorydata.task.scheduler.impl.c.f12961a.a().get(r7) == null) goto L12;
        Pair r10 = (Pair) ZeusTransformUtils.preCheckCast(com.obric.memorydata.task.scheduler.impl.c.f12961a.a().remove(r7), Pair.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L9;
        AbsTaskRequest r11 = (AbsTaskRequest) ZeusTransformUtils.preCheckCast(r10.getFirst(), AbsTaskRequest.class, "com.obric.memorydata.plugin");
    L10:
        if (r11 == null) goto L13;
        ConcurrentHashMap<String, Integer> r12 = com.obric.memorydata.task.scheduler.impl.c.f12961a.b();
        String r1 = r11.getTaskParameter().getName();
        final $$Lambda$TaskAlarmReceiver$TdQPx4vJRtp6mWwfCwjFI7wuE r2 = $$Lambda$TaskAlarmReceiver$TdQPx4vJRtp6mWwfCwjFI7wuE.INSTANCE;
        r12.compute(r1, new $$Lambda$TaskAlarmReceiver$Y_ibwxa9GaFL46lqG_ZnetbjDkE(r2));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskAlarmReceiver", "alarm enqueue " + d.a(r11), false, 4, null);
        com.obric.memorydata.task.scheduler.impl.c.f12961a.d().b(r11);
        goto L13
    L9:
        r11 = null;
        goto L10
    }
}
