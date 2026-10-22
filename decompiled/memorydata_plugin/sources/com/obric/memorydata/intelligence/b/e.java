package com.obric.memorydata.intelligence.b;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u0007J\u0006\u0010\u0011\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/intelligence/predict/PredictTask;", "", "<init>", "()V", "TAG", "", EventBody.KEY_VALUE, "", "hourJobScheduled", "getHourJobScheduled", "()Z", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "context", "Landroid/content/Context;", "hourJob", "scheduleNext", "dayJob", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f9945a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f9946b;

    static {
        f9945a = new e();
    }

    private e() {
    }

    private static final void c() {
        f9945a.a(true);
    }

    public static /* synthetic */ void lambda$J9kmlyDzhlooRG62aCHVLtVscgg() {
        c();
    }

    public final void a(Context r8) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PredictTask", "PredictTask Init start", false, 4, null);
        b.f9939a.a(r7);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PredictTask", "DataCollector Init done", false, 4, null);
        if (DeviceInfoState.INSTANCE.isObricOsDevice() == false) goto L5;
        new com.obric.memorydata.a.a.a().a();
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PredictTask", "PredictTask Init end", false, 4, null);
    }

    public final void a(boolean r9) {
        f9946b = true;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PredictTask", "hour Job start", false, 4, null);
        b.f9939a.a();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PredictTask", "hour Job end", false, 4, null);
        if (r9 == false) goto L6;
        h.f9949a.a($$Lambda$e$J9kmlyDzhlooRG62aCHVLtVscgg.INSTANCE);
        return;
    }

    public final boolean a() {
        return f9946b;
    }

    public final void b() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PredictTask", "day Job start", false, 4, null);
        b.f9939a.b();
        d.f9943a.a();
        g.f9948a.a();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PredictTask", "day Job end", false, 4, null);
    }
}
