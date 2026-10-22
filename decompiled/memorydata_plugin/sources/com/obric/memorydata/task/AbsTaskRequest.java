package com.obric.memorydata.task;

import android.security.obric.guard.ObricSecurityGuardStub;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.memorydata.middleware.api.bridge.NetworkBridgeAPI;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.alarm.AlarmTime;
import com.obric.memorydata.task.alarm.Type;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskParameter;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.task.impl.g;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001eJ\r\u0010\u001f\u001a\u00020\u001eH\u0000¢\u0006\u0002\b J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001bH\u0002J\u0017\u0010\"\u001a\u00020\u001e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0002\u0010%J\u0006\u0010&\u001a\u00020\u001eJ\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020\u001eJ\b\u0010*\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006,"}, d2 = {"Lcom/obric/memorydata/task/AbsTaskRequest;", "", "taskParameter", "Lcom/obric/memorydata/task/impl/TaskParameter;", "<init>", "(Lcom/obric/memorydata/task/impl/TaskParameter;)V", "getTaskParameter", "()Lcom/obric/memorydata/task/impl/TaskParameter;", "TAG", "", "parentTaskRequest", "getParentTaskRequest", "()Lcom/obric/memorydata/task/AbsTaskRequest;", "setParentTaskRequest", "(Lcom/obric/memorydata/task/AbsTaskRequest;)V", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "getTaskInfo", "()Lcom/obric/memorydata/task/impl/TaskInfo;", "setTaskInfo", "(Lcom/obric/memorydata/task/impl/TaskInfo;)V", OaidModel.KEY_ID, "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "isInvalid", "", "isCancelled", "setCancelled", "", "setCancelledFromLiveWatch", "setCancelledFromLiveWatch$task_obricRelease", "forceLiveWatch", "setTimeout", "invocationId", "", "(Ljava/lang/Long;)V", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "execute", "Lcom/obric/memorydata/task/impl/TaskResult;", "enqueue", "toString", "Builder", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsTaskRequest {
    private final String TAG;
    private String id;
    private AbsTaskRequest parentTaskRequest;
    private TaskInfo taskInfo;
    private final TaskParameter taskParameter;

    @Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0004\b'\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0000*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B\u0011\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u001f\u0010\u0011\u001a\u00028\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014¢\u0006\u0002\u0010\u0015J\u0019\u0010\u0011\u001a\u00028\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\u0002\u0010\u0017J\u001f\u0010\u0018\u001a\u00028\u00002\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u0013\"\u00020\u001a¢\u0006\u0002\u0010\u001bJ\u0019\u0010\u0018\u001a\u00028\u00002\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016¢\u0006\u0002\u0010\u0017J\u0013\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00028\u00002\u0006\u0010!\u001a\u00020\"¢\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00028\u00002\b\u0010%\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00028\u00002\u0006\u0010(\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0013\u0010)\u001a\u00028\u00002\u0006\u0010*\u001a\u00020+¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00028\u00002\u0006\u0010*\u001a\u00020+¢\u0006\u0002\u0010,J\u0013\u0010.\u001a\u00028\u00002\u0006\u0010/\u001a\u00020+¢\u0006\u0002\u0010,J\u0013\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u000202¢\u0006\u0002\u00103J\u0013\u00104\u001a\u00028\u00002\u0006\u00105\u001a\u000206¢\u0006\u0002\u00107J\u001f\u00108\u001a\u00028\u00002\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020:09¢\u0006\u0002\u0010;J\u0013\u0010<\u001a\u00028\u00002\u0006\u0010=\u001a\u00020\"¢\u0006\u0002\u0010#J\u000b\u0010>\u001a\u00028\u0001¢\u0006\u0002\u0010?J\r\u0010@\u001a\u00028\u0001H&¢\u0006\u0002\u0010?J\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001a0E2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016H\u0002J\u0016\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020\u001a0E2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016H\u0002R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0012\u0010A\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\bB\u0010C¨\u0006I"}, d2 = {"Lcom/obric/memorydata/task/AbsTaskRequest$Builder;", "B", ExifInterface.LONGITUDE_WEST, "Lcom/obric/memorydata/task/AbsTaskRequest;", "", ActivityLifecycle.NAME, "", "<init>", "(Ljava/lang/String;)V", "requestSpec", "Lcom/obric/memorydata/task/impl/TaskParameter;", "getRequestSpec", "()Lcom/obric/memorydata/task/impl/TaskParameter;", "setPriority", "p", "", "(I)Lcom/obric/memorydata/task/AbsTaskRequest$Builder;", "setConditions", "conditions", "", "Lcom/obric/memorydata/task/condition/Condition;", "([Lcom/obric/memorydata/task/condition/Condition;)Lcom/obric/memorydata/task/AbsTaskRequest$Builder;", "", "(Ljava/util/List;)Lcom/obric/memorydata/task/AbsTaskRequest$Builder;", "setAlarmTimes", "alarmTime", "Lcom/obric/memorydata/task/alarm/AlarmTime;", "([Lcom/obric/memorydata/task/alarm/AlarmTime;)Lcom/obric/memorydata/task/AbsTaskRequest$Builder;", "setInputParam", AutoTestConstant.PARAM, "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)Lcom/obric/memorydata/task/AbsTaskRequest$Builder;", "setExecuteImmediately", "executeImmediately", "", "(Z)Lcom/obric/memorydata/task/AbsTaskRequest$Builder;", "setForegroundCallerPkg", "pkg", "(Ljava/lang/String;)Lcom/obric/memorydata/task/AbsTaskRequest$Builder;", "setAutoRetryMaxTimes", OaidModel.KEY_TIME, "setDelay", "type", "Lcom/obric/memorydata/task/impl/TaskTimeUnit;", "(Lcom/obric/memorydata/task/impl/TaskTimeUnit;)Lcom/obric/memorydata/task/AbsTaskRequest$Builder;", "setInterval", "setTimeout", LocationMonitorConst.TIMEOUT, "setExistingTaskPolicy", "existingTaskPolicy", "Lcom/obric/memorydata/task/scheduler/impl/ExistingTaskPolicy;", "(Lcom/obric/memorydata/task/scheduler/impl/ExistingTaskPolicy;)Lcom/obric/memorydata/task/AbsTaskRequest$Builder;", "setTaskInfoCallback", "callBack", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "(Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;)Lcom/obric/memorydata/task/AbsTaskRequest$Builder;", "setProgressCallback", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)Lcom/obric/memorydata/task/AbsTaskRequest$Builder;", "setTriggerExactly", "triggerExactly", "build", "()Lcom/obric/memorydata/task/AbsTaskRequest;", "buildInternal", "this", "getThis", "()Lcom/obric/memorydata/task/AbsTaskRequest$Builder;", "getValidAlarmTimesInner", "", "alarmTimes", "buildAlarmTimeList", "filterAndSortAlarmTimes", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class Builder<B extends Builder<B, W>, W extends AbsTaskRequest> {
        private final TaskParameter requestSpec;

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f12862a = null;

            static {
                int[] r0 = new int[TimeUnit.values().length];
                r0[TimeUnit.HOURS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[TimeUnit.MINUTES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f12862a = r0;
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class b<T> implements Comparator {
            public b() {
            }

            @Override // java.util.Comparator
            public final int compare(T r2, T r3) {
                return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(LocalTime.parse((CharSequence) ZeusTransformUtils.preCheckCast(((AlarmTime) ZeusTransformUtils.preCheckCast(r2, AlarmTime.class, "com.obric.memorydata.plugin")).getTime(), CharSequence.class, "com.obric.memorydata.plugin")), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(LocalTime.parse((CharSequence) ZeusTransformUtils.preCheckCast(((AlarmTime) ZeusTransformUtils.preCheckCast(r3, AlarmTime.class, "com.obric.memorydata.plugin")).getTime(), CharSequence.class, "com.obric.memorydata.plugin")), Comparable.class, "com.obric.memorydata.plugin"));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder(String r25) {
            Intrinsics.checkNotNullParameter(r25, ActivityLifecycle.NAME);
            UUID r0 = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(r0, "randomUUID(...)");
            Object[] r16 = 0 == true ? 1 : 0;
            this.requestSpec = new TaskParameter(r25, r0, 0, null, null, false, 0, null, null, null, false, null, false, null, null, r16, null, 0, false, 524284, null);
        }

        private final List<AlarmTime> buildAlarmTimeList(AlarmTime r12) {
            List<AlarmTime> r11 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            g r0 = r12.getInterval();
            if (r0 != null) goto L5;
        L23:
            return r11;
        L5:
            if (r0.b() != TimeUnit.HOURS) goto L7;
        L9:
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r12.getTime(), CharSequence.class, "com.obric.memorydata.plugin"), new String[]{ParameterizedMessage.ERROR_MSG_SEPARATOR}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r14 = r13.iterator();
        L11:
            if (r14.hasNext() == false) goto L13;
            r2.add(Integer.valueOf(Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin"))));
            goto L11
        L13:
            List r15 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
            LocalTime r16 = LocalTime.of(((Number) ZeusTransformUtils.preCheckCast(r15.get(0), Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r15.get(1), Number.class, "com.obric.memorydata.plugin")).intValue());
            Type r5 = Type.REPEAT;
            String r6 = r16.toString();
            Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
            r11.add(new AlarmTime(r5, r6, null, null, 12, null));
        L15:
            if (r16.compareTo(LocalTime.of(23, 59)) > 0) goto L23;
            Type r7 = Type.REPEAT;
            String r8 = r16.toString();
            Intrinsics.checkNotNullExpressionValue(r8, "toString(...)");
            r11.add(new AlarmTime(r7, r8, null, null, 12, null));
            TimeUnit r1 = r0.b();
            int r3 = a.f12862a[r1.ordinal()];
            if (r3 != 1) goto L19;
            r16 = r16.plusHours(r0.a());
            goto L15
        L19:
            if (r3 != 2) goto L23;
            r16 = r16.plusMinutes(r0.a());
            goto L15
        L7:
            if (r0.b() == TimeUnit.MINUTES) goto L9;
            goto L9
        }

        private final List<AlarmTime> filterAndSortAlarmTimes(List<AlarmTime> r7) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
            Map r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
            Iterator r9 = r8.iterator();
        L4:
            if (r9.hasNext() == false) goto L9;
            Object r2 = r9.next();
            String r3 = ((AlarmTime) ZeusTransformUtils.preCheckCast(r2, AlarmTime.class, "com.obric.memorydata.plugin")).getTime();
            Object r4 = r1.get(r3);
            if (r4 != null) goto L8;
            r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            r1.put(r3, r4);
        L8:
            ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin")).add(r2);
            goto L4
        L9:
            Iterator r10 = r1.entrySet().iterator();
        L11:
            if (r10.hasNext() == false) goto L21;
            Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
            Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r12 = r5.iterator();
        L14:
            if (r12.hasNext() == false) goto L17;
            r11.add(((AlarmTime) ZeusTransformUtils.preCheckCast(r12.next(), AlarmTime.class, "com.obric.memorydata.plugin")).getType());
            goto L14
        L17:
            if (CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).size() <= 1) goto L11;
            throw new IllegalArgumentException("Found AlarmTimes with the same time but different types.");
        L21:
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
            HashSet r14 = new HashSet();
            ArrayList r15 = new ArrayList();
            Iterator r16 = r13.iterator();
        L23:
            if (r16.hasNext() == false) goto L28;
            Object r17 = r16.next();
            if (r14.add(((AlarmTime) ZeusTransformUtils.preCheckCast(r17, AlarmTime.class, "com.obric.memorydata.plugin")).getTime()) == false) goto L23;
            r15.add(r17);
            goto L23
        L28:
            return CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin"));
        }

        private final List<AlarmTime> getValidAlarmTimesInner(List<AlarmTime> r8) {
            Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r10 = r9.iterator();
        L3:
            boolean r3 = true;
            if (r10.hasNext() == false) goto L11;
            Object r2 = r10.next();
            if (((CharSequence) ZeusTransformUtils.preCheckCast(((AlarmTime) ZeusTransformUtils.preCheckCast(r2, AlarmTime.class, "com.obric.memorydata.plugin")).getTime(), CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L9;
            r3 = false;
        L9:
            if (r3 == false) goto L3;
            r0.add(r2);
            goto L3
        L11:
            List<AlarmTime> r11 = TypeIntrinsics.asMutableList((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"));
            Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
            Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r5 = r1.iterator();
        L13:
            if (r5.hasNext() == false) goto L20;
            Object r6 = r5.next();
            if (((AlarmTime) ZeusTransformUtils.preCheckCast(r6, AlarmTime.class, "com.obric.memorydata.plugin")).getInterval() == null) goto L17;
            boolean r7 = true;
        L18:
            if (r7 == false) goto L13;
            r4.add(r6);
            goto L13
        L17:
            r7 = false;
            goto L18
        L20:
            Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L22:
            if (r12.hasNext() == false) goto L25;
            r11.addAll((Collection) ZeusTransformUtils.preCheckCast(buildAlarmTimeList((AlarmTime) ZeusTransformUtils.preCheckCast(r12.next(), AlarmTime.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin"));
            goto L22
        L25:
            return filterAndSortAlarmTimes(r11);
        }

        public final W build() {
            W r4 = (W) buildInternal();
            if (r4.getTaskParameter().getDelay().a() == 0) goto L6;
            r4.getTaskParameter().setSync(false);
        L6:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r4.getTaskParameter().getAlarmTimeList(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L8;
            r4.getTaskParameter().setDelay((g) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.impl.e(), g.class, "com.obric.memorydata.plugin"));
            r4.getTaskParameter().setInterval((g) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.impl.e(), g.class, "com.obric.memorydata.plugin"));
        L8:
            return r4;
        }

        public abstract W buildInternal();

        public final TaskParameter getRequestSpec() {
            return this.requestSpec;
        }

        public abstract B getThis();

        public final B setAlarmTimes(List<AlarmTime> r3) {
            List<AlarmTime> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "alarmTime");
            this.requestSpec.setAlarmTimeList(getValidAlarmTimesInner(r4));
            return (B) getThis();
        }

        public final B setAlarmTimes(AlarmTime... r2) {
            Intrinsics.checkNotNullParameter(r2, "alarmTime");
            this.requestSpec.setAlarmTimeList(getValidAlarmTimesInner(ArraysKt.toList(r2)));
            return (B) getThis();
        }

        public final B setAutoRetryMaxTimes(int r2) {
            this.requestSpec.setAutoRetryMaxTimes(r2);
            return (B) getThis();
        }

        public final B setConditions(List<? extends Condition> r14) {
            List<? extends Condition> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "conditions");
            List<Condition> r0 = com.obric.memorydata.task.condition.vendor.b.f12898a.a(r15);
            if (r15.size() == r0.size()) goto L5;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskManager", '[' + this.requestSpec.getName() + "] Some conflict condition(s) is filtered, origin=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null) + ", final=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null), null, 4, null);
        L5:
            this.requestSpec.setConditions(r0);
            return (B) getThis();
        }

        public final B setConditions(Condition... r2) {
            Intrinsics.checkNotNullParameter(r2, "conditions");
            setConditions(ArraysKt.toList(r2));
            return (B) getThis();
        }

        public final B setDelay(g r2) {
            Intrinsics.checkNotNullParameter(r2, "type");
            this.requestSpec.setDelay(r2);
            return (B) getThis();
        }

        public final B setExecuteImmediately(boolean r2) {
            this.requestSpec.setExecuteImmediately(r2);
            return (B) getThis();
        }

        public final B setExistingTaskPolicy(ExistingTaskPolicy r2) {
            Intrinsics.checkNotNullParameter(r2, "existingTaskPolicy");
            this.requestSpec.setExistingTaskPolicy(r2);
            return (B) getThis();
        }

        public final B setForegroundCallerPkg(String r2) {
            this.requestSpec.setForegroundCallerPkg(r2);
            return (B) getThis();
        }

        public final B setInputParam(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, AutoTestConstant.PARAM);
            this.requestSpec.setInputParams(r2);
            return (B) getThis();
        }

        public final B setInterval(g r2) {
            Intrinsics.checkNotNullParameter(r2, "type");
            this.requestSpec.setInterval(r2);
            return (B) getThis();
        }

        public final B setPriority(int r2) {
            this.requestSpec.setPriority(r2);
            return (B) getThis();
        }

        public final B setProgressCallback(Function1<? super JSONObject, Unit> r3) {
            Function1<? super JSONObject, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "callBack");
            this.requestSpec.setOnProgressCallback(r4);
            return (B) getThis();
        }

        public final B setTaskInfoCallback(com.obric.memorydata.task.scheduler.c r3) {
            com.obric.memorydata.task.scheduler.c r4 = (com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "callBack");
            this.requestSpec.setOnTaskInfoCallBack(r4);
            return (B) getThis();
        }

        public final B setTimeout(g r2) {
            Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TIMEOUT);
            this.requestSpec.setTimeout(r2);
            return (B) getThis();
        }

        public final B setTriggerExactly(boolean r2) {
            this.requestSpec.setTriggerExactly(r2);
            return (B) getThis();
        }
    }

    public AbsTaskRequest(TaskParameter r21) {
        Intrinsics.checkNotNullParameter(r21, "taskParameter");
        this.taskParameter = r21;
        this.TAG = "AbsTaskRequest";
        String r2 = r21.getUuid().toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        this.id = r2;
        TaskInfo r3 = new TaskInfo(r21.getUuid(), null, null, null, null, false, 0, 0, 0, 0, 1022, null);
        this.taskInfo = r3;
        r3.a(r21.getName());
        this.taskInfo.a(r21.getInputParams());
        this.taskInfo.a(r21.getExecuteImmediately());
    }

    private final void setCancelled(boolean r7) {
        if (this.taskInfo.c() != TaskInfo.State.CANCELLED) goto L6;
        return;
    L6:
        if (this.taskInfo.c().isFinished() == false) goto L10;
        if (r7 == true) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.TAG, "failed to setCancelled, task state is " + this.taskInfo.c(), null, 4, null);
        return;
    L10:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.TAG, "setCancelled " + com.obric.memorydata.task.utils.d.a(this), false, 4, null);
        this.taskInfo.a(TaskInfo.State.CANCELLED);
        this.taskInfo.e().setCode(2);
        this.taskInfo.e().setMsg("task " + this.taskInfo.b() + " cancelled");
        com.obric.memorydata.task.scheduler.c r8 = this.taskParameter.getOnTaskInfoCallBack();
        if (r8 == null) goto L13;
        r8.a(this.taskInfo);
    L13:
        com.obric.memorydata.task.scheduler.b r9 = com.obric.memorydata.task.scheduler.impl.c.f12961a.d();
        String r0 = this.taskParameter.getUuid().toString();
        Intrinsics.checkNotNullExpressionValue(r0, "toString(...)");
        r9.g(r0);
        NetworkBridgeAPI r10 = NetworkBridgeAPI.INSTANCE;
        String r6 = this.taskParameter.getUuid().toString();
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        r10.abortSSEByTaskId(r6);
    }

    public static /* synthetic */ void setTimeout$default(AbsTaskRequest r0, Long r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        r0.setTimeout(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTimeout");
    }

    public final void cancel() {
        setCancelled();
        com.obric.memorydata.task.scheduler.b r0 = com.obric.memorydata.task.scheduler.impl.c.f12961a.d();
        String r2 = this.taskParameter.getUuid().toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        r0.e(r2);
    }

    public final void enqueue() {
        com.obric.memorydata.task.scheduler.b r0 = com.obric.memorydata.task.scheduler.impl.c.f12961a.d();
        List<? extends AbsTaskRequest> r2 = Collections.singletonList(this);
        Intrinsics.checkNotNullExpressionValue(r2, "singletonList(...)");
        r0.a(r2);
    }

    public final TaskResult execute() {
        return com.obric.memorydata.task.scheduler.impl.c.f12961a.d().a(this);
    }

    public final String getId() {
        return this.id;
    }

    public final AbsTaskRequest getParentTaskRequest() {
        return this.parentTaskRequest;
    }

    public final TaskInfo getTaskInfo() {
        return this.taskInfo;
    }

    public final TaskParameter getTaskParameter() {
        return this.taskParameter;
    }

    public final boolean isCancelled() {
        if (this.taskInfo.c() != TaskInfo.State.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isInvalid() {
        if (this.taskInfo.c() != TaskInfo.State.CANCELLED) goto L5;
    L8:
        return true;
    L5:
        if (this.taskInfo.c() == TaskInfo.State.TIMEOUT) goto L8;
        return false;
    }

    public final void setCancelled() {
        setCancelled(false);
    }

    public final void setCancelledFromLiveWatch$task_obricRelease() {
        setCancelled(true);
    }

    public final void setId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.id = r2;
    }

    public final void setParentTaskRequest(AbsTaskRequest r1) {
        this.parentTaskRequest = r1;
    }

    public final void setTaskInfo(TaskInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.taskInfo = r2;
    }

    public final void setTimeout(Long r10) {
        boolean r0 = !this.taskInfo.c().isFinished();
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r4 = this.TAG;
        if (r0 == true) goto L5;
        StringBuilder r1 = new StringBuilder();
        IRunLog.a.a(r3, r4, r1.append("failed to setTimeout, task state is ").append(this.taskInfo.c()).toString(), null, 4, null);
    L9:
        if (r10 == null) goto L11;
        NetworkBridgeAPI r2 = NetworkBridgeAPI.INSTANCE;
        String r9 = this.taskParameter.getUuid().toString();
        Intrinsics.checkNotNullExpressionValue(r9, "toString(...)");
        r2.abortSSEByTaskInvocationTimeout(r9, r10.longValue());
        return;
    L11:
        if (r0 == false) goto L15;
        NetworkBridgeAPI r11 = NetworkBridgeAPI.INSTANCE;
        String r12 = this.taskParameter.getUuid().toString();
        Intrinsics.checkNotNullExpressionValue(r12, "toString(...)");
        r11.abortSSEByTaskTimeout(r12);
        return;
    L15:
        return;
    L5:
        r1 = new StringBuilder();
        IRunLog.a.b(r3, r4, r1.append("setTimeout ").append(com.obric.memorydata.task.utils.d.a(this)).toString(), null, 4, null);
        this.taskInfo.a(TaskInfo.State.TIMEOUT);
        this.taskInfo.e().setCode(3);
        this.taskInfo.e().setMsg("task " + this.taskInfo.b() + " run timeout");
        com.obric.memorydata.task.scheduler.c r5 = this.taskParameter.getOnTaskInfoCallBack();
        if (r5 == null) goto L8;
        r5.a(this.taskInfo);
    L8:
        com.obric.memorydata.task.scheduler.b r6 = com.obric.memorydata.task.scheduler.impl.c.f12961a.d();
        String r7 = this.taskParameter.getUuid().toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        r6.g(r7);
        goto L9
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("AbsTaskRequest(taskParameter=").append(this.taskParameter).append(", parentRequest={id:");
        AbsTaskRequest r1 = this.parentTaskRequest;
        String r2 = null;
        if (r1 == null) goto L7;
        TaskParameter r3 = r1.taskParameter;
        if (r3 == null) goto L7;
        UUID r4 = r3.getUuid();
    L8:
        StringBuilder r5 = r0.append(r4).append(" name:");
        AbsTaskRequest r6 = this.parentTaskRequest;
        if (r6 == null) goto L14;
        TaskParameter r7 = r6.taskParameter;
        if (r7 == null) goto L14;
        r2 = r7.getName();
    L14:
        return r5.append(r2).append("})").toString();
    L7:
        r4 = null;
        goto L8
    }
}
