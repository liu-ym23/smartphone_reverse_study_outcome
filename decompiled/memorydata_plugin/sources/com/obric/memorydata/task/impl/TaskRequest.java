package com.obric.memorydata.task.impl;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 \u00062\u00020\u0001:\u0002\u0006\u0007B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/task/impl/TaskRequest;", "Lcom/obric/memorydata/task/AbsTaskRequest;", "taskParameter", "Lcom/obric/memorydata/task/impl/TaskParameter;", "<init>", "(Lcom/obric/memorydata/task/impl/TaskParameter;)V", "Companion", "Builder", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class TaskRequest extends AbsTaskRequest {
    public static final a Companion = null;
    private static final String TAG = "TaskRequest";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\u0002H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/task/impl/TaskRequest$Builder;", "Lcom/obric/memorydata/task/AbsTaskRequest$Builder;", "Lcom/obric/memorydata/task/impl/TaskRequest;", ActivityLifecycle.NAME, "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "buildInternal", "this", "getThis", "()Lcom/obric/memorydata/task/impl/TaskRequest$Builder;", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class Builder extends AbsTaskRequest.Builder<Builder, TaskRequest> {
        private final String name;

        public Builder(String r2) {
            Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
            super(r2);
            this.name = r2;
        }

        @Override // com.obric.memorydata.task.AbsTaskRequest.Builder
        public /* synthetic */ AbsTaskRequest buildInternal() {
            return (AbsTaskRequest) ZeusTransformUtils.preCheckCast(buildInternal(), AbsTaskRequest.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.memorydata.task.AbsTaskRequest.Builder
        public TaskRequest buildInternal() {
            TaskRequest r0 = new TaskRequest(getRequestSpec());
            Function1<JSONObject, Unit> r4 = r0.getTaskParameter().getOnProgressCallback();
            if (r4 == null) goto L5;
            com.obric.memorydata.task.scheduler.b r1 = com.obric.memorydata.task.scheduler.impl.c.f12961a.d();
            String r2 = r0.getTaskParameter().getUuid().toString();
            Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
            r1.a(r2, r4);
        L5:
            RunLog.INSTANCE.debug(TaskRequest.TAG, r0.toString());
            return r0;
        }

        public final String getName() {
            return this.name;
        }

        @Override // com.obric.memorydata.task.AbsTaskRequest.Builder
        public /* synthetic */ AbsTaskRequest.Builder getThis() {
            return (AbsTaskRequest.Builder) ZeusTransformUtils.preCheckCast(getThis(), AbsTaskRequest.Builder.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.memorydata.task.AbsTaskRequest.Builder
        public Builder getThis() {
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/task/impl/TaskRequest$Companion;", "", "<init>", "()V", "TAG", "", "create", "Lcom/obric/memorydata/task/impl/TaskRequest;", "taskJson", "Lorg/json/JSONObject;", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final TaskRequest a(JSONObject r10) {
            Intrinsics.checkNotNullParameter(r10, "taskJson");
            String r0 = r10.optString(ActivityLifecycle.NAME);
            Intrinsics.checkNotNullExpressionValue(r0, "optString(...)");
            int r2 = 0;
            Builder r9 = (Builder) ZeusTransformUtils.preCheckCast(((Builder) ZeusTransformUtils.preCheckCast(((Builder) ZeusTransformUtils.preCheckCast(((Builder) ZeusTransformUtils.preCheckCast(new Builder(r0).setPriority(r10.optInt("priority")), Builder.class, "com.obric.memorydata.plugin")).setDelay(new g(r10.optLong("delay_time"), TimeUnit.MILLISECONDS)), Builder.class, "com.obric.memorydata.plugin")).setInterval(new g(r10.optLong("interval"), TimeUnit.MILLISECONDS)), Builder.class, "com.obric.memorydata.plugin")).setExecuteImmediately(r10.optBoolean("execute_immediately", false)), Builder.class, "com.obric.memorydata.plugin");
            JSONArray r1 = r10.optJSONArray("condition_list");
            if (r1 == null) goto L11;
            ArrayList r3 = new ArrayList();
            int r4 = r1.length();
            int r5 = 0;
        L5:
            if (r5 >= r4) goto L10;
            Condition.a r6 = Condition.Companion;
            String r7 = r1.getString(r5);
            Intrinsics.checkNotNullExpressionValue(r7, "getString(...)");
            Condition r8 = r6.a(r7);
            if (r8 == null) goto L9;
            r3.add(r8);
        L9:
            r5 = r5 + 1;
            goto L5
        L10:
            Builder r11 = (Builder) ZeusTransformUtils.preCheckCast(r9.setConditions((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin")), Builder.class, "com.obric.memorydata.plugin");
        L11:
            String r12 = r10.optString("existing_task_policy");
            ExistingTaskPolicy.a r13 = ExistingTaskPolicy.Companion;
            Intrinsics.checkNotNull(r12);
            ExistingTaskPolicy r14 = r13.a(r12);
            if (r14 == null) goto L14;
            Builder r15 = (Builder) ZeusTransformUtils.preCheckCast(r9.setExistingTaskPolicy(r14), Builder.class, "com.obric.memorydata.plugin");
        L14:
            r9.setTriggerExactly(r10.optBoolean("trigger_exactly"));
            Object r16 = r10.opt("input_params");
            if (r16 != null) goto L17;
        L19:
            JSONArray r17 = r10.optJSONArray("alarm_times");
            if (r17 == null) goto L28;
            if (r17.length() <= 0) goto L28;
            ArrayList r18 = new ArrayList();
            int r19 = r17.length();
        L24:
            if (r2 >= r19) goto L26;
            com.obric.memorydata.task.alarm.a r20 = com.obric.memorydata.task.alarm.a.f12865a;
            Object r21 = r17.get(r2);
            Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type org.json.JSONObject");
            r18.add(r20.a((JSONObject) ZeusTransformUtils.preCheckCast(r21, JSONObject.class, "com.obric.memorydata.plugin")));
            r2 = r2 + 1;
            goto L24
        L26:
            r9.setAlarmTimes((List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin"));
        L28:
            return (TaskRequest) ZeusTransformUtils.preCheckCast(r9.build(), TaskRequest.class, "com.obric.memorydata.plugin");
        L17:
            if (ZeusTransformUtils.instanceOf(r16, JSONObject.class) == false) goto L19;
            r9.setInputParam((JSONObject) ZeusTransformUtils.preCheckCast(r16, JSONObject.class, "com.obric.memorydata.plugin"));
            goto L19
        }
    }

    static {
        Companion = new a(null);
    }

    public TaskRequest(TaskParameter r2) {
        Intrinsics.checkNotNullParameter(r2, "taskParameter");
        super(r2);
    }
}
