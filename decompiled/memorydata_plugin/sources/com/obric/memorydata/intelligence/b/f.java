package com.obric.memorydata.intelligence.b;

import android.content.Context;
import android.provider.Settings;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskRequest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J\u0006\u0010\r\u001a\u00020\u0005¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/intelligence/predict/PredictTop5App;", "", "<init>", "()V", "dailyTimingTrigger", "", "taskName", "", TrackerImpl.PARAMS, "Lorg/json/JSONObject;", "hour", "", "minute", CommonConsts.APM_INNER_EVENT_COST_INIT, "Companion", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9947a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/intelligence/predict/PredictTop5App$Companion;", "", "<init>", "()V", "TAG", "", "PREDICT_TODAY_TOP_5_APP", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/intelligence/predict/PredictTop5App$dailyTimingTrigger$intervalWithDelayRequest$1", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.task.scheduler.c {
        b() {
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r3) {
            Intrinsics.checkNotNullParameter(r3, "taskInfo");
            if (r3.c() == TaskInfo.State.SUCCEEDED) goto L5;
            return;
        L5:
            Object r2 = r3.e().getOutput().get("predictResult");
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type org.json.JSONArray");
            JSONArray r4 = (JSONArray) ZeusTransformUtils.preCheckCast(r2, JSONArray.class, "com.obric.memorydata.plugin");
            Settings.Global.putString(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "predict_today_top_5_app", r4.toString());
        }
    }

    static {
        f9947a = new a(null);
    }

    public f() {
    }

    private final void a(String r8, JSONObject r9, int r10, int r11) {
        long r0 = System.currentTimeMillis();
        Calendar r7 = Calendar.getInstance();
        r7.setTimeInMillis(r0);
        int r3 = r7.get(12);
        int r4 = r7.get(11);
        int r5 = (((r10 - r4) - 1) + 24) % 24;
        int r6 = (60 - r3) + r11;
        if (r10 != r4) goto L6;
        if (r11 <= r3) goto L6;
        r5 = 0;
        r6 = r11 - r3;
    L6:
        r7.add(10, r5);
        r7.add(12, r6);
        RunLog.INSTANCE.debug("PredictTop5App", "===>task: " + r8 + " schedule next time " + new Date(r7.getTimeInMillis()));
        long r12 = r7.getTimeInMillis() - r0;
        TaskRequest.Builder r13 = new TaskRequest.Builder(r8);
        if (r9 != null) goto L9;
        r9 = new JSONObject();
    L9:
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r13.setInputParam(r9), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setDelay(new com.obric.memorydata.task.impl.g(r12, TimeUnit.MILLISECONDS)), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setInterval((com.obric.memorydata.task.impl.g) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.impl.a(1), com.obric.memorydata.task.impl.g.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new b(), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    }

    public final void a() {
        if (DeviceInfoState.INSTANCE.isObricOsDevice() == true) goto L5;
        return;
    L5:
        a("predict_top_5_app", null, 3, 5);
    }
}
