package com.obric.memorydata.task.impl;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.task.alarm.AlarmTime;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\bU\b\u0087\b\u0018\u00002\u00020\u0001Bã\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020 \u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\"\u0012\b\b\u0002\u0010#\u001a\u00020\u000e¢\u0006\u0004\b$\u0010%J\b\u0010_\u001a\u00020\u0003H\u0016J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\t\u0010a\u001a\u00020\u0005HÆ\u0003J\t\u0010b\u001a\u00020\u0007HÆ\u0003J\u000f\u0010c\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010d\u001a\u00020\fHÆ\u0003J\t\u0010e\u001a\u00020\u000eHÆ\u0003J\t\u0010f\u001a\u00020\u0007HÆ\u0003J\t\u0010g\u001a\u00020\fHÆ\u0003J\t\u0010h\u001a\u00020\fHÆ\u0003J\u000f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0003J\t\u0010j\u001a\u00020\u000eHÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\t\u0010l\u001a\u00020\u000eHÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010n\u001a\u00020\u001bHÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u0017\u0010p\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020 \u0018\u00010\u001fHÆ\u0003J\t\u0010q\u001a\u00020\"HÆ\u0003J\t\u0010r\u001a\u00020\u000eHÆ\u0003Jç\u0001\u0010s\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\f2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000eHÆ\u0001J\u0013\u0010t\u001a\u00020\u000e2\b\u0010u\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010v\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010+\"\u0004\b;\u0010-R\u001a\u0010\u0010\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00103\"\u0004\b=\u00105R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00103\"\u0004\b?\u00105R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010/\"\u0004\bA\u00101R\u001a\u0010\u0015\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00107\"\u0004\bC\u00109R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010\u0018\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u00107\"\u0004\bI\u00109R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010'\"\u0004\bK\u0010LR\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR(\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001a\u0010#\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u00107\"\u0004\b^\u00109¨\u0006w"}, d2 = {"Lcom/obric/memorydata/task/impl/TaskParameter;", "", ActivityLifecycle.NAME, "", Api.KEY_UUID, "Ljava/util/UUID;", "priority", "", "conditions", "", "Lcom/obric/memorydata/task/condition/Condition;", "delay", "Lcom/obric/memorydata/task/impl/TaskTimeUnit;", "sync", "", "autoRetryMaxTimes", "interval", LocationMonitorConst.TIMEOUT, "alarmTimeList", "", "Lcom/obric/memorydata/task/alarm/AlarmTime;", "alarmAutoTrigger", "existingTaskPolicy", "Lcom/obric/memorydata/task/scheduler/impl/ExistingTaskPolicy;", "executeImmediately", "foregroundCallerPkg", "inputParams", "Lorg/json/JSONObject;", "onTaskInfoCallBack", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onProgressCallback", "Lkotlin/Function1;", "", "taskEnqueueTime", "", "triggerExactly", "<init>", "(Ljava/lang/String;Ljava/util/UUID;ILjava/util/List;Lcom/obric/memorydata/task/impl/TaskTimeUnit;ZILcom/obric/memorydata/task/impl/TaskTimeUnit;Lcom/obric/memorydata/task/impl/TaskTimeUnit;Ljava/util/List;ZLcom/obric/memorydata/task/scheduler/impl/ExistingTaskPolicy;ZLjava/lang/String;Lorg/json/JSONObject;Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;Lkotlin/jvm/functions/Function1;JZ)V", "getName", "()Ljava/lang/String;", "getUuid", "()Ljava/util/UUID;", "getPriority", "()I", "setPriority", "(I)V", "getConditions", "()Ljava/util/List;", "setConditions", "(Ljava/util/List;)V", "getDelay", "()Lcom/obric/memorydata/task/impl/TaskTimeUnit;", "setDelay", "(Lcom/obric/memorydata/task/impl/TaskTimeUnit;)V", "getSync", "()Z", "setSync", "(Z)V", "getAutoRetryMaxTimes", "setAutoRetryMaxTimes", "getInterval", "setInterval", "getTimeout", "setTimeout", "getAlarmTimeList", "setAlarmTimeList", "getAlarmAutoTrigger", "setAlarmAutoTrigger", "getExistingTaskPolicy", "()Lcom/obric/memorydata/task/scheduler/impl/ExistingTaskPolicy;", "setExistingTaskPolicy", "(Lcom/obric/memorydata/task/scheduler/impl/ExistingTaskPolicy;)V", "getExecuteImmediately", "setExecuteImmediately", "getForegroundCallerPkg", "setForegroundCallerPkg", "(Ljava/lang/String;)V", "getInputParams", "()Lorg/json/JSONObject;", "setInputParams", "(Lorg/json/JSONObject;)V", "getOnTaskInfoCallBack", "()Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "setOnTaskInfoCallBack", "(Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;)V", "getOnProgressCallback", "()Lkotlin/jvm/functions/Function1;", "setOnProgressCallback", "(Lkotlin/jvm/functions/Function1;)V", "getTaskEnqueueTime", "()J", "setTaskEnqueueTime", "(J)V", "getTriggerExactly", "setTriggerExactly", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "equals", "other", "hashCode", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TaskParameter {
    private boolean alarmAutoTrigger;
    private List<AlarmTime> alarmTimeList;
    private int autoRetryMaxTimes;
    private List<? extends Condition> conditions;
    private g delay;
    private boolean executeImmediately;
    private ExistingTaskPolicy existingTaskPolicy;
    private String foregroundCallerPkg;
    private JSONObject inputParams;
    private g interval;
    private final String name;
    private Function1<? super JSONObject, Unit> onProgressCallback;
    private com.obric.memorydata.task.scheduler.c onTaskInfoCallBack;
    private int priority;
    private boolean sync;
    private long taskEnqueueTime;
    private g timeout;
    private boolean triggerExactly;
    private final UUID uuid;

    public TaskParameter(String r14, UUID r15, int r16, List<? extends Condition> r17, g r18, boolean r19, int r20, g r21, g r22, List<AlarmTime> r23, boolean r24, ExistingTaskPolicy r25, boolean r26, String r27, JSONObject r28, com.obric.memorydata.task.scheduler.c r29, Function1<? super JSONObject, Unit> r30, long r31, boolean r33) {
        List<? extends Condition> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        List<AlarmTime> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.task.scheduler.c r10 = (com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.wrapperContextForParams(r29, com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin");
        Function1<? super JSONObject, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r30, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r15, Api.KEY_UUID);
        Intrinsics.checkNotNullParameter(r7, "conditions");
        Intrinsics.checkNotNullParameter(r18, "delay");
        Intrinsics.checkNotNullParameter(r21, "interval");
        Intrinsics.checkNotNullParameter(r22, LocationMonitorConst.TIMEOUT);
        Intrinsics.checkNotNullParameter(r9, "alarmTimeList");
        Intrinsics.checkNotNullParameter(r28, "inputParams");
        this.name = r14;
        this.uuid = r15;
        this.priority = r16;
        this.conditions = r7;
        this.delay = r18;
        this.sync = r19;
        this.autoRetryMaxTimes = r20;
        this.interval = r21;
        this.timeout = r22;
        this.alarmTimeList = r9;
        this.alarmAutoTrigger = r24;
        this.existingTaskPolicy = r25;
        this.executeImmediately = r26;
        this.foregroundCallerPkg = r27;
        this.inputParams = r28;
        this.onTaskInfoCallBack = r10;
        this.onProgressCallback = r8;
        this.taskEnqueueTime = r31;
        this.triggerExactly = r33;
    }

    public /* synthetic */ TaskParameter(String r29, UUID r30, int r31, List r32, g r33, boolean r34, int r35, g r36, g r37, List r38, boolean r39, ExistingTaskPolicy r40, boolean r41, String r42, JSONObject r43, com.obric.memorydata.task.scheduler.c r44, Function1 r45, long r46, boolean r48, int r49, DefaultConstructorMarker r50) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r32, List.class, "com.obric.memorydata.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r38, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.task.scheduler.c r4 = (com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.wrapperContextForParams(r44, com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin");
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r45, Function1.class, "com.obric.memorydata.plugin");
        if ((r49 & 1) == 0) goto L5;
        String r8 = "";
    L7:
        if ((r49 & 4) == 0) goto L9;
        int r10 = 5;
    L11:
        if ((r49 & 8) == 0) goto L13;
        r1 = CollectionsKt.emptyList();
    L13:
        List r11 = r1;
        if ((r49 & 16) == 0) goto L16;
        g r12 = (g) ZeusTransformUtils.preCheckCast(new e(), g.class, "com.obric.memorydata.plugin");
    L18:
        if ((r49 & 32) == 0) goto L20;
        boolean r13 = false;
    L22:
        if ((r49 & 64) == 0) goto L24;
        int r14 = 0;
    L26:
        if ((r49 & 128) == 0) goto L28;
        g r15 = new g(0, TimeUnit.MILLISECONDS);
    L30:
        if ((r49 & 256) == 0) goto L32;
        g r16 = new g(0, TimeUnit.MILLISECONDS);
    L34:
        if ((r49 & 512) == 0) goto L36;
        r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    L36:
        List r17 = r3;
        if ((r49 & 1024) == 0) goto L39;
        boolean r18 = false;
    L41:
        if ((r49 & 2048) == 0) goto L43;
        ExistingTaskPolicy r19 = null;
    L45:
        if ((r49 & 4096) == 0) goto L47;
        boolean r20 = false;
    L49:
        if ((r49 & 8192) == 0) goto L51;
        String r21 = null;
    L53:
        if ((r49 & 16384) == 0) goto L55;
        JSONObject r22 = new JSONObject();
    L57:
        if ((32768 & r49) == 0) goto L59;
        com.obric.memorydata.task.scheduler.c r23 = null;
    L61:
        if ((65536 & r49) == 0) goto L63;
        Function1 r24 = null;
    L65:
        if ((131072 & r49) == 0) goto L67;
        long r25 = -1;
    L69:
        if ((r49 & 262144) == 0) goto L71;
        boolean r27 = false;
    L72:
        this(r8, r30, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r27);
        return;
    L71:
        r27 = r48;
        goto L72
    L67:
        r25 = r46;
        goto L69
    L63:
        r24 = r5;
        goto L65
    L59:
        r23 = r4;
        goto L61
    L55:
        r22 = r43;
        goto L57
    L51:
        r21 = r42;
        goto L53
    L47:
        r20 = r41;
        goto L49
    L43:
        r19 = r40;
        goto L45
    L39:
        r18 = r39;
        goto L41
    L32:
        r16 = r37;
        goto L34
    L28:
        r15 = r36;
        goto L30
    L24:
        r14 = r35;
        goto L26
    L20:
        r13 = r34;
        goto L22
    L16:
        r12 = r33;
        goto L18
    L9:
        r10 = r31;
        goto L11
    L5:
        r8 = r29;
        goto L7
    }

    public static /* synthetic */ TaskParameter copy$default(TaskParameter r17, String r18, UUID r19, int r20, List r21, g r22, boolean r23, int r24, g r25, g r26, List r27, boolean r28, ExistingTaskPolicy r29, boolean r30, String r31, JSONObject r32, com.obric.memorydata.task.scheduler.c r33, Function1 r34, long r35, boolean r37, int r38, Object r39) {
        List<? extends Condition> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        List<AlarmTime> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.task.scheduler.c r5 = (com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.wrapperContextForParams(r33, com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin");
        Function1<? super JSONObject, Unit> r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r34, Function1.class, "com.obric.memorydata.plugin");
        if ((r38 & 1) == 0) goto L5;
        String r6 = r17.name;
    L7:
        if ((r38 & 2) == 0) goto L9;
        UUID r7 = r17.uuid;
    L11:
        if ((r38 & 4) == 0) goto L13;
        int r8 = r17.priority;
    L15:
        if ((r38 & 8) == 0) goto L18;
        r2 = r17.conditions;
    L18:
        if ((r38 & 16) == 0) goto L20;
        g r9 = r17.delay;
    L22:
        if ((r38 & 32) == 0) goto L24;
        boolean r10 = r17.sync;
    L26:
        if ((r38 & 64) == 0) goto L28;
        int r11 = r17.autoRetryMaxTimes;
    L30:
        if ((r38 & 128) == 0) goto L32;
        g r12 = r17.interval;
    L34:
        if ((r38 & 256) == 0) goto L36;
        g r13 = r17.timeout;
    L38:
        if ((r38 & 512) == 0) goto L41;
        r4 = r17.alarmTimeList;
    L41:
        if ((r38 & 1024) == 0) goto L43;
        boolean r14 = r17.alarmAutoTrigger;
    L45:
        if ((r38 & 2048) == 0) goto L47;
        ExistingTaskPolicy r15 = r17.existingTaskPolicy;
    L49:
        if ((r38 & 4096) == 0) goto L51;
        boolean r16 = r17.executeImmediately;
    L53:
        if ((r38 & 8192) == 0) goto L55;
        String r36 = r17.foregroundCallerPkg;
    L56:
        String r310 = r36;
        if ((r38 & 16384) == 0) goto L59;
        JSONObject r40 = r17.inputParams;
    L60:
        JSONObject r311 = r40;
        if ((r38 & 32768) == 0) goto L63;
        com.obric.memorydata.task.scheduler.c r41 = r17.onTaskInfoCallBack;
    L64:
        com.obric.memorydata.task.scheduler.c r312 = r41;
        if ((r38 & 65536) == 0) goto L67;
        Function1<? super JSONObject, Unit> r42 = r17.onProgressCallback;
    L68:
        boolean r210 = r14;
        ExistingTaskPolicy r211 = r15;
        if ((r38 & 131072) == 0) goto L71;
        long r110 = r17.taskEnqueueTime;
    L73:
        if ((r38 & 262144) == 0) goto L75;
        boolean r1 = r17.triggerExactly;
    L77:
        return r17.copy(r6, r7, r8, r2, r9, r10, r11, r12, r13, r4, r210, r211, r16, r310, r311, r312, r42, r110, r1);
    L75:
        r1 = r37;
        goto L77
    L71:
        r110 = r35;
        goto L73
    L67:
        r42 = r3;
        goto L68
    L63:
        r41 = r5;
        goto L64
    L59:
        r40 = r32;
        goto L60
    L55:
        r36 = r31;
        goto L56
    L51:
        r16 = r30;
        goto L53
    L47:
        r15 = r29;
        goto L49
    L43:
        r14 = r28;
        goto L45
    L36:
        r13 = r26;
        goto L38
    L32:
        r12 = r25;
        goto L34
    L28:
        r11 = r24;
        goto L30
    L24:
        r10 = r23;
        goto L26
    L20:
        r9 = r22;
        goto L22
    L13:
        r8 = r20;
        goto L15
    L9:
        r7 = r19;
        goto L11
    L5:
        r6 = r18;
        goto L7
    }

    public final String component1() {
        return this.name;
    }

    public final List<AlarmTime> component10() {
        return this.alarmTimeList;
    }

    public final boolean component11() {
        return this.alarmAutoTrigger;
    }

    public final ExistingTaskPolicy component12() {
        return this.existingTaskPolicy;
    }

    public final boolean component13() {
        return this.executeImmediately;
    }

    public final String component14() {
        return this.foregroundCallerPkg;
    }

    public final JSONObject component15() {
        return this.inputParams;
    }

    public final com.obric.memorydata.task.scheduler.c component16() {
        return this.onTaskInfoCallBack;
    }

    public final Function1<JSONObject, Unit> component17() {
        return this.onProgressCallback;
    }

    public final long component18() {
        return this.taskEnqueueTime;
    }

    public final boolean component19() {
        return this.triggerExactly;
    }

    public final UUID component2() {
        return this.uuid;
    }

    public final int component3() {
        return this.priority;
    }

    public final List<Condition> component4() {
        return this.conditions;
    }

    public final g component5() {
        return this.delay;
    }

    public final boolean component6() {
        return this.sync;
    }

    public final int component7() {
        return this.autoRetryMaxTimes;
    }

    public final g component8() {
        return this.interval;
    }

    public final g component9() {
        return this.timeout;
    }

    public final TaskParameter copy(String r24, UUID r25, int r26, List<? extends Condition> r27, g r28, boolean r29, int r30, g r31, g r32, List<AlarmTime> r33, boolean r34, ExistingTaskPolicy r35, boolean r36, String r37, JSONObject r38, com.obric.memorydata.task.scheduler.c r39, Function1<? super JSONObject, Unit> r40, long r41, boolean r43) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.memorydata.plugin");
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r33, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.task.scheduler.c r16 = (com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.wrapperContextForParams(r39, com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin");
        Function1 r17 = (Function1) ZeusTransformUtils.wrapperContextForParams(r40, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r24, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r25, Api.KEY_UUID);
        Intrinsics.checkNotNullParameter(r0, "conditions");
        Intrinsics.checkNotNullParameter(r28, "delay");
        Intrinsics.checkNotNullParameter(r31, "interval");
        Intrinsics.checkNotNullParameter(r32, LocationMonitorConst.TIMEOUT);
        Intrinsics.checkNotNullParameter(r1, "alarmTimeList");
        Intrinsics.checkNotNullParameter(r38, "inputParams");
        return new TaskParameter(r24, r25, r26, r0, r28, r29, r30, r31, r32, r1, r34, r35, r36, r37, r38, r16, r17, r41, r43);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, TaskParameter.class) == true) goto L8;
        return false;
    L8:
        TaskParameter r10 = (TaskParameter) ZeusTransformUtils.preCheckCast(r9, TaskParameter.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.name, r10.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uuid, r10.uuid) == true) goto L15;
        return false;
    L15:
        if (this.priority == r10.priority) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.conditions, r10.conditions) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.delay, r10.delay) == true) goto L24;
        return false;
    L24:
        if (this.sync == r10.sync) goto L27;
        return false;
    L27:
        if (this.autoRetryMaxTimes == r10.autoRetryMaxTimes) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.interval, r10.interval) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.timeout, r10.timeout) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.alarmTimeList, r10.alarmTimeList) == true) goto L39;
        return false;
    L39:
        if (this.alarmAutoTrigger == r10.alarmAutoTrigger) goto L42;
        return false;
    L42:
        if (this.existingTaskPolicy == r10.existingTaskPolicy) goto L45;
        return false;
    L45:
        if (this.executeImmediately == r10.executeImmediately) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.foregroundCallerPkg, r10.foregroundCallerPkg) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.inputParams, r10.inputParams) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.onTaskInfoCallBack, r10.onTaskInfoCallBack) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.onProgressCallback, r10.onProgressCallback) == true) goto L60;
        return false;
    L60:
        if (this.taskEnqueueTime == r10.taskEnqueueTime) goto L63;
        return false;
    L63:
        if (this.triggerExactly == r10.triggerExactly) goto L65;
        return false;
    L65:
        return true;
    }

    public final boolean getAlarmAutoTrigger() {
        return this.alarmAutoTrigger;
    }

    public final List<AlarmTime> getAlarmTimeList() {
        return this.alarmTimeList;
    }

    public final int getAutoRetryMaxTimes() {
        return this.autoRetryMaxTimes;
    }

    public final List<Condition> getConditions() {
        return this.conditions;
    }

    public final g getDelay() {
        return this.delay;
    }

    public final boolean getExecuteImmediately() {
        return this.executeImmediately;
    }

    public final ExistingTaskPolicy getExistingTaskPolicy() {
        return this.existingTaskPolicy;
    }

    public final String getForegroundCallerPkg() {
        return this.foregroundCallerPkg;
    }

    public final JSONObject getInputParams() {
        return this.inputParams;
    }

    public final g getInterval() {
        return this.interval;
    }

    public final String getName() {
        return this.name;
    }

    public final Function1<JSONObject, Unit> getOnProgressCallback() {
        return this.onProgressCallback;
    }

    public final com.obric.memorydata.task.scheduler.c getOnTaskInfoCallBack() {
        return this.onTaskInfoCallBack;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final boolean getSync() {
        return this.sync;
    }

    public final long getTaskEnqueueTime() {
        return this.taskEnqueueTime;
    }

    public final g getTimeout() {
        return this.timeout;
    }

    public final boolean getTriggerExactly() {
        return this.triggerExactly;
    }

    public final UUID getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        int r0 = ((((((((((((((((((((this.name.hashCode() * 31) + this.uuid.hashCode()) * 31) + Integer.hashCode(this.priority)) * 31) + this.conditions.hashCode()) * 31) + this.delay.hashCode()) * 31) + Boolean.hashCode(this.sync)) * 31) + Integer.hashCode(this.autoRetryMaxTimes)) * 31) + this.interval.hashCode()) * 31) + this.timeout.hashCode()) * 31) + this.alarmTimeList.hashCode()) * 31) + Boolean.hashCode(this.alarmAutoTrigger)) * 31;
        ExistingTaskPolicy r1 = this.existingTaskPolicy;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + Boolean.hashCode(this.executeImmediately)) * 31;
        String r5 = this.foregroundCallerPkg;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.inputParams.hashCode()) * 31;
        com.obric.memorydata.task.scheduler.c r8 = this.onTaskInfoCallBack;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Function1<? super JSONObject, Unit> r11 = this.onProgressCallback;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return ((((r10 + r2) * 31) + Long.hashCode(this.taskEnqueueTime)) * 31) + Boolean.hashCode(this.triggerExactly);
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final void setAlarmAutoTrigger(boolean r1) {
        this.alarmAutoTrigger = r1;
    }

    public final void setAlarmTimeList(List<AlarmTime> r3) {
        List<AlarmTime> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.alarmTimeList = r4;
    }

    public final void setAutoRetryMaxTimes(int r1) {
        this.autoRetryMaxTimes = r1;
    }

    public final void setConditions(List<? extends Condition> r3) {
        List<? extends Condition> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.conditions = r4;
    }

    public final void setDelay(g r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.delay = r2;
    }

    public final void setExecuteImmediately(boolean r1) {
        this.executeImmediately = r1;
    }

    public final void setExistingTaskPolicy(ExistingTaskPolicy r1) {
        this.existingTaskPolicy = r1;
    }

    public final void setForegroundCallerPkg(String r1) {
        this.foregroundCallerPkg = r1;
    }

    public final void setInputParams(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.inputParams = r2;
    }

    public final void setInterval(g r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.interval = r2;
    }

    public final void setOnProgressCallback(Function1<? super JSONObject, Unit> r3) {
        this.onProgressCallback = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
    }

    public final void setOnTaskInfoCallBack(com.obric.memorydata.task.scheduler.c r3) {
        this.onTaskInfoCallBack = (com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin");
    }

    public final void setPriority(int r1) {
        this.priority = r1;
    }

    public final void setSync(boolean r1) {
        this.sync = r1;
    }

    public final void setTaskEnqueueTime(long r1) {
        this.taskEnqueueTime = r1;
    }

    public final void setTimeout(g r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.timeout = r2;
    }

    public final void setTriggerExactly(boolean r1) {
        this.triggerExactly = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("TaskParameter(");
        r0.append("name='" + this.name + "', ");
        r0.append("uuid=" + this.uuid);
        if (this.priority == 5) goto L6;
        r0.append(", priority=" + this.priority);
    L6:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.conditions, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L9;
        r0.append(", conditions=" + this.conditions);
    L9:
        if (this.delay.c() == 0) goto L12;
        r0.append(", delay=" + this.delay);
    L12:
        if (this.sync == false) goto L15;
        r0.append(", sync=" + this.sync);
    L15:
        if (this.autoRetryMaxTimes == 0) goto L18;
        r0.append(", autoRetryMaxTimes=" + this.autoRetryMaxTimes);
    L18:
        if (this.interval.c() == 0) goto L21;
        r0.append(", interval=" + this.interval);
    L21:
        if (this.timeout.c() == 0) goto L24;
        r0.append(", timeout=" + this.timeout);
    L24:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.alarmTimeList, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L27;
        r0.append(", alarmTimeList=" + this.alarmTimeList);
    L27:
        if (this.alarmAutoTrigger == false) goto L30;
        r0.append(", alarmAutoTrigger=" + this.alarmAutoTrigger);
    L30:
        if (this.existingTaskPolicy == null) goto L33;
        r0.append(", existingTaskPolicy=" + this.existingTaskPolicy);
    L33:
        if (this.executeImmediately == false) goto L36;
        r0.append(", executeImmediately=" + this.executeImmediately);
    L36:
        if (this.foregroundCallerPkg == null) goto L39;
        r0.append(", foregroundCallerPkg=" + this.foregroundCallerPkg);
    L39:
        if (this.onTaskInfoCallBack == null) goto L42;
        r0.append(", onTaskInfoCallBack=" + this.onTaskInfoCallBack);
    L42:
        if (this.onProgressCallback == null) goto L45;
        r0.append(", onProgressCallback=<callback>");
    L45:
        if (this.taskEnqueueTime == (-1)) goto L48;
        r0.append(", taskEnqueueTime=" + this.taskEnqueueTime);
    L48:
        if (this.triggerExactly == false) goto L50;
        r0.append(", triggerExactly=" + this.triggerExactly);
    L50:
        r0.append(")");
        String r6 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        return r6;
    }
}
