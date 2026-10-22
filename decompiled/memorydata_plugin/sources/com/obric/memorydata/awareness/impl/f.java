package com.obric.memorydata.awareness.impl;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.runtime.AIInferRuntime;
import com.obric.memorydata.awareness.api.Recommender;
import com.obric.memorydata.awareness.impl.data.PapayaConfig;
import com.obric.memorydata.awareness.impl.data.TaskConfig;
import com.obric.memorydata.awareness.impl.data.TimerConfig;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0007J\u0016\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/awareness/impl/AwarenessPackageScheduler;", "", "<init>", "()V", "scheduledPackages", "", "", "Lcom/obric/aikernel/res/metadata/config/PackageConfig;", "markScheduledPackage", "", "papayaPackage", "forgetScheduledPackage", ObricMemoryConstants.KEY_PACKAGE_NAME, "needSchedule", "", "schedule", "timerConfig", "Lcom/obric/memorydata/awareness/impl/data/TimerConfig;", "timeUntil", "", OaidModel.KEY_TIME, "durationFromNow", "date", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8666a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, com.obric.aikernel.res.metadata.config.i> f8667b;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/awareness/impl/AwarenessPackageScheduler$Companion;", "", "<init>", "()V", "TAG", "", "KEY_TYPE", "KEY_INTERVAL", "KEY_TIME", "TYPE_PERIODIC", "TYPE_ONESHOT", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/awareness/impl/AwarenessPackageScheduler$schedule$3", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.task.scheduler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8668a;

        b(String r1) {
            this.f8668a = r1;
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r4) {
            Intrinsics.checkNotNullParameter(r4, "taskInfo");
            if (r4.e().getCode() != 0) goto L11;
            RunLog.INSTANCE.debug("AwarenessPackageScheduler", "package " + this.f8668a + " return " + r4.e().getOutput());
            Object r3 = r4.e().getOutput().opt("recommend");
            if (ZeusTransformUtils.instanceOf(r3, JSONArray.class) == false) goto L9;
            Recommender r5 = Recommender.INSTANCE;
            JSONArray r6 = (JSONArray) ZeusTransformUtils.preCheckCast(r3, JSONArray.class, "com.obric.memorydata.plugin");
        L7:
            r5.recommend(r6);
            return;
        L9:
            if (ZeusTransformUtils.instanceOf(r3, JSONObject.class) == false) goto L13;
            r5 = Recommender.INSTANCE;
            r6 = new JSONArray().put(r3);
            Intrinsics.checkNotNullExpressionValue(r6, "put(...)");
            goto L7
        L13:
            return;
        }
    }

    static {
        f8666a = new a(null);
    }

    public f() {
        this.f8667b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    private final long b(String r15) {
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L5;
    L8:
        boolean r16 = true;
    L9:
        if (r16 == false) goto L12;
        return 0;
    L12:
        DateTimeFormatter r17 = DateTimeFormatter.ofPattern("HH:mm");
        ZonedDateTime r2 = ZonedDateTime.now(ZoneId.systemDefault());
    L26:
        e = move-exception;
        e.printStackTrace();
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AwarenessPackageScheduler", "invalid time format " + r15, null, 4, null);
        return -1;
    L14:
        if (StringsKt.startsWith$default(r15, "xx", false, 2, null) == false) goto L19;
        LocalTime r3 = LocalTime.parse((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.replace$default(r15, "xx", StringsKt.padStart(String.valueOf(r2.getHour()), 2, '0'), false, 4, null), CharSequence.class, "com.obric.memorydata.plugin"), r17);     // Catch: DateTimeParseException -> L26
        if (r3.getMinute() > r2.getMinute()) goto L20;
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.replace$default(r15, "xx", StringsKt.padStart(String.valueOf(r2.plusHours(1).getHour()), 2, '0'), false, 4, null), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: DateTimeParseException -> L26
    L18:
        r3 = LocalTime.parse(r4, r17);     // Catch: DateTimeParseException -> L26
    L20:
        Intrinsics.checkNotNull(r3);     // Catch: DateTimeParseException -> L26
        RunLog.INSTANCE.debug("AwarenessPackageScheduler", "next time " + r15 + " is " + r3);
        ZonedDateTime r18 = r2.withHour(r3.getHour()).withMinute(r3.getMinute()).withSecond(0).withNano(0);
        if (r2.compareTo((ChronoZonedDateTime) ZeusTransformUtils.preCheckCast(r18, ChronoZonedDateTime.class, "com.obric.memorydata.plugin")) <= 0) goto L25;
        r18 = r18.plusDays(1);
    L25:
        return Duration.between((Temporal) ZeusTransformUtils.preCheckCast(r2, Temporal.class, "com.obric.memorydata.plugin"), (Temporal) ZeusTransformUtils.preCheckCast(r18, Temporal.class, "com.obric.memorydata.plugin")).toMillis();
    L19:
        r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: DateTimeParseException -> L26
        goto L18
    L5:
        if (StringsKt.isBlank(r14) == true) goto L8;
        r16 = false;
        goto L9
    }

    private final long c(String r3) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        DateTimeFormatter r2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime r4 = LocalDateTime.parse((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), r2);
        LocalDateTime r5 = LocalDateTime.now(ZoneId.systemDefault());
        if (r4.isAfter((ChronoLocalDateTime) ZeusTransformUtils.preCheckCast(r5, ChronoLocalDateTime.class, "com.obric.memorydata.plugin")) == false) goto L9;
        return Duration.between((Temporal) ZeusTransformUtils.preCheckCast(r5, Temporal.class, "com.obric.memorydata.plugin"), (Temporal) ZeusTransformUtils.preCheckCast(r4, Temporal.class, "com.obric.memorydata.plugin")).toMillis();
    L9:
        return -Duration.between((Temporal) ZeusTransformUtils.preCheckCast(r4, Temporal.class, "com.obric.memorydata.plugin"), (Temporal) ZeusTransformUtils.preCheckCast(r5, Temporal.class, "com.obric.memorydata.plugin")).toMillis();
    }

    public final void a(com.obric.aikernel.res.metadata.config.i r2) {
        Intrinsics.checkNotNullParameter(r2, "papayaPackage");
        this.f8667b.put(r2.a(), r2);
    }

    public final void a(com.obric.aikernel.res.metadata.config.i r11, TimerConfig r12) {
        Intrinsics.checkNotNullParameter(r11, "papayaPackage");
        Intrinsics.checkNotNullParameter(r12, "timerConfig");
        String r0 = r11.a();
        String r1 = r12.getType();
        String r2 = r12.getTime();
        JSONObject r3 = new JSONObject();
        r3.put("trigger_source", CommonConsts.TIMER_TYPE);
        TaskRequest.Builder r4 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(r0).setInputParam(r3), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
        PapayaConfig r5 = com.obric.memorydata.awareness.impl.data.a.a(r11);
        if (r5 == null) goto L16;
        TaskConfig r6 = r5.getTaskConfig();
        if (r6 == null) goto L16;
        List<String> r7 = r6.getConditions();
        if (r7 == null) goto L16;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L10:
        if (r10.hasNext() == false) goto L14;
        Condition r13 = Condition.Companion.a((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin"));
        if (r13 == null) goto L10;
        r9.add(r13);
        goto L10
    L14:
        List<? extends Condition> r14 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("AwarenessPackageScheduler", "trigger task " + r11.a() + " with conditions " + r14);
        TaskRequest.Builder r15 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r4.setConditions(r14), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
    L16:
        if (Intrinsics.areEqual(r1, "periodic") == false) goto L29;
        Long r16 = r12.getIntervalSec();
        if (r16 != null) goto L20;
    L26:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AwarenessPackageScheduler", "package " + r0 + " timer config error: interval = " + r16, null, 4, null);
        return;
    L20:
        if (r16.longValue() <= 0) goto L26;
        long r17 = b(r2);
        if (r17 <= 0) goto L25;
        r4.setDelay(new com.obric.memorydata.task.impl.g(r17, TimeUnit.MILLISECONDS));
    L25:
        TaskRequest.Builder r18 = r4.setInterval(new com.obric.memorydata.task.impl.g(r16.longValue(), TimeUnit.SECONDS));
    L35:
        TaskRequest.Builder r19 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r18, TaskRequest.Builder.class, "com.obric.memorydata.plugin");
        PapayaConfig r20 = com.obric.memorydata.awareness.impl.data.a.a(r11);
        if (r20 == null) goto L44;
        TaskConfig r21 = r20.getTaskConfig();
        if (r21 == null) goto L44;
        String r22 = r21.getExistingTaskPolicy();
        if (r22 == null) goto L44;
        ExistingTaskPolicy r23 = ExistingTaskPolicy.Companion.a(r22);
        if (r23 == null) goto L44;
        TaskRequest.Builder r24 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r4.setExistingTaskPolicy(r23), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
    L44:
        r4.setTriggerExactly(r12.getTriggerExactly());
        this.f8667b.put(r0, r11);
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r4.setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new b(r0), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
        return;
    L29:
        if (Intrinsics.areEqual(r1, "oneshot") == false) goto L46;
        long r25 = c(r2);
        if (r25 > 0) goto L34;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AwarenessPackageScheduler", "expire time " + r2, null, 4, null);
        return;
    L34:
        r18 = r4.setDelay(new com.obric.memorydata.task.impl.g(r25, TimeUnit.MILLISECONDS));
        goto L35
    L46:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AwarenessPackageScheduler", "unknown timer type " + r1, null, 4, null);
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        this.f8667b.remove(r2);
    }

    public final boolean b(com.obric.aikernel.res.metadata.config.i r3) {
        Intrinsics.checkNotNullParameter(r3, "papayaPackage");
        com.obric.aikernel.res.metadata.config.i r2 = (com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(this.f8667b.get(r3.a()), com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L12;
        PapayaConfig r4 = com.obric.memorydata.awareness.impl.data.a.a(r3);
        if (r4 == null) goto L10;
        if (r4.hasValidTimer() != true) goto L10;
        return true;
    L10:
        return false;
    L12:
        return !Intrinsics.areEqual(String.valueOf(AIInferRuntime.f6160a.a(r2)), String.valueOf(AIInferRuntime.f6160a.a(r3)));
    }
}
