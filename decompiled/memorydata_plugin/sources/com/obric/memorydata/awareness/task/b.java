package com.obric.memorydata.awareness.task;

import com.obric.aikernel.res.metadata.config.i;
import com.obric.memorydata.awareness.api.Recommender;
import com.obric.memorydata.awareness.impl.data.PapayaConfig;
import com.obric.memorydata.awareness.impl.data.TaskConfig;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.logging.e;
import com.obric.memorydata.middleware.api.logging.g;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.c;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/awareness/task/TaskRunner;", "", "<init>", "()V", "TAG", "", "runAutoTriggeredTask", "", "papayaPkg", "Lcom/obric/aikernel/res/metadata/config/PackageConfig;", TrackerImpl.PARAMS, "Lorg/json/JSONObject;", "shouldRun", "Lkotlin/Function0;", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8794a = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/awareness/task/TaskRunner$runAutoTriggeredTask$packageTaskRequestBuilder$1", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8795a;

        a(String r1) {
            this.f8795a = r1;
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r4) {
            Intrinsics.checkNotNullParameter(r4, "taskInfo");
            if (r4.e().getCode() != 0) goto L11;
            RunLog.INSTANCE.debug("TaskRunner", "package " + this.f8795a + " return " + r4.e().getOutput());
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
        f8794a = new b();
    }

    private b() {
    }

    public final void a(i r10, JSONObject r11, Function0<Boolean> r12) {
        Function0 r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "papayaPkg");
        Intrinsics.checkNotNullParameter(r11, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r9, "shouldRun");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r9.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L8;
        o r13 = (o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.b.f11611a, o.class, "com.obric.memorydata.plugin");
        e r14 = new e(null, null, null, 7, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L40;
        g r0 = new g();
        r0.a("package_name", r10.a());
        Unit r15 = Unit.INSTANCE;
        r13.a("自动触发任务已被 Feature 开关拦截", r14, r0.a());
        return;
    L40:
        return;
    L8:
        String r16 = r10.a();
        o r1 = (o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.b.f11611a, o.class, "com.obric.memorydata.plugin");
        e r8 = new e(null, null, null, 7, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L11;
        g r2 = new g();
        r2.a("package_name", r16);
        Unit r17 = Unit.INSTANCE;
        r1.a("自动触发任务开始入队", r8, r2.a());
    L11:
        TaskRequest.Builder r18 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(r16).setInputParam(r11), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback((c) ZeusTransformUtils.preCheckCast(new a(r16), c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
        PapayaConfig r19 = com.obric.memorydata.awareness.impl.data.a.a(r10);
        if (r19 == null) goto L24;
        TaskConfig r110 = r19.getTaskConfig();
        if (r110 == null) goto L24;
        List<String> r111 = r110.getConditions();
        if (r111 == null) goto L24;
        Iterable r112 = (Iterable) ZeusTransformUtils.preCheckCast(r111, Iterable.class, "com.obric.memorydata.plugin");
        Collection r113 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r114 = r112.iterator();
    L19:
        if (r114.hasNext() == false) goto L23;
        Condition r3 = Condition.Companion.a((String) ZeusTransformUtils.preCheckCast(r114.next(), String.class, "com.obric.memorydata.plugin"));
        if (r3 == null) goto L19;
        r113.add(r3);
        goto L19
    L23:
        List<? extends Condition> r115 = (List) ZeusTransformUtils.preCheckCast(r113, List.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("TaskRunner", "trigger task " + r10.a() + " with conditions " + r115);
        TaskRequest.Builder r116 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r18.setConditions(r115), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
    L24:
        PapayaConfig r117 = com.obric.memorydata.awareness.impl.data.a.a(r10);
        if (r117 == null) goto L33;
        TaskConfig r118 = r117.getTaskConfig();
        if (r118 == null) goto L33;
        String r119 = r118.getExistingTaskPolicy();
        if (r119 == null) goto L33;
        ExistingTaskPolicy r120 = ExistingTaskPolicy.Companion.a(r119);
        if (r120 == null) goto L33;
        TaskRequest.Builder r121 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r18.setExistingTaskPolicy(r120), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
    L33:
        ((TaskRequest) ZeusTransformUtils.preCheckCast(r18.build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    }
}
