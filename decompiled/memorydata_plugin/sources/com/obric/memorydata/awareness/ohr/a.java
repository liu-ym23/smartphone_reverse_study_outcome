package com.obric.memorydata.awareness.ohr;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.c;
import com.ss.ugc.clientai.aiservice.d;
import com.ss.ugc.clientai.aiservice.e;
import com.ss.ugc.clientai.aiservice.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/awareness/ohr/OHREngine;", "Lcom/ss/ugc/clientai/aiservice/BaseAIEngine;", "<init>", "()V", "doStop", "", "doFeed", "input", "Lcom/ss/ugc/clientai/aiservice/AIPredictInput;", "doStart", "", "engineType", "", "getEngineType", "()I", "predict", "inputs", "", "handlePredictResult", "code", "result", "Lorg/json/JSONObject;", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0448a f8756a = null;

    /* JADX INFO: renamed from: com.obric.memorydata.awareness.ohr.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/awareness/ohr/OHREngine$Companion;", "", "<init>", "()V", "TAG", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0448a {
        private C0448a() {
        }

        public /* synthetic */ C0448a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/awareness/ohr/OHREngine$predict$2", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f8757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f8758b;

        b(long r1, a r3) {
            this.f8757a = r1;
            this.f8758b = r3;
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r8) {
            Intrinsics.checkNotNullParameter(r8, "taskInfo");
            long r0 = System.currentTimeMillis() - this.f8757a;
            if (r8.c() != TaskInfo.State.SUCCEEDED) goto L6;
            RunLog.INSTANCE.debug("OHREngine", "onTaskResult success, use time " + r0 + " ms, output: " + r8.e().getOutput());
            a.a(this.f8758b, 0, r8.e().getOutput());
            return;
        L6:
            if (r8.c() != TaskInfo.State.FAILED) goto L10;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OHREngine", "onTaskResult failed " + r8.e().getMsg(), null, 4, null);
            a.a(this.f8758b, r8.e().getCode(), null);
            return;
        }
    }

    static {
        f8756a = new C0448a(null);
    }

    public a() {
    }

    private final void a(int r10, JSONObject r11) {
        if (r10 != 0) goto L22;
        if (r11 == null) goto L22;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OHREngine", "OHR predict finished, result=" + r11, false, 4, null);
        JSONObject r12 = r11.optJSONObject("score_map");
        if (r12 != null) goto L9;
        return;
    L9:
        d r13 = new d(0, 1, null);
        Iterator<String> r1 = r12.keys();
        Intrinsics.checkNotNullExpressionValue(r1, "keys(...)");
    L11:
        if (r1.hasNext() == false) goto L20;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r4, "left") == false) goto L16;
        int r5 = 1;
    L19:
        double r6 = r12.optDouble(r4);
        Intrinsics.checkNotNull(r4);
        r13.a(new g(r5, r4, (float) r6));
        goto L11
    L16:
        if (Intrinsics.areEqual(r4, "right") == false) goto L18;
        r5 = 2;
        goto L19
    L18:
        r5 = 0;
        goto L19
    L20:
        b(r13);
        return;
    L22:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OHREngine", "OHR predict failed: code=" + r10, null, 4, null);
    }

    public static final /* synthetic */ void a(a r0, int r1, JSONObject r2) {
        r0.a(r1, r2);
    }

    private final void a(float[] r6) {
        JSONObject r0 = new JSONObject();
        JSONArray r1 = new JSONArray();
        int r2 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r1.put(Float.valueOf(r6[r3]));
        r3 = r3 + 1;
        goto L3
    L5:
        r0.put("inputParams", r1);
        long r4 = System.currentTimeMillis();
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("ohr_predict").setInputParam(r0), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback((c) ZeusTransformUtils.preCheckCast(new b(r4, this), c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    }

    @Override // com.ss.ugc.clientai.aiservice.e
    public void a() {
    }

    @Override // com.ss.ugc.clientai.aiservice.e
    public void a(com.ss.ugc.clientai.aiservice.c r3) {
        Intrinsics.checkNotNullParameter(r3, "input");
        a((float[]) ZeusTransformUtils.preCheckCast(r3.a(), float[].class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.ugc.clientai.aiservice.e
    public boolean b() {
        return true;
    }
}
