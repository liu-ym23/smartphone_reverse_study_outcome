package com.obric.memorydata.intelligence.datalearning.profile.b.b;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.task.impl.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/time/sleepwakeup/SleepWakeupPackageTask;", "Lcom/obric/memorydata/intelligence/datalearning/profile/task/BaseProfileTask;", "profileTaskInfo", "Lcom/obric/memorydata/intelligence/datalearning/profile/task/ProfileTaskInfo;", "<init>", "(Lcom/obric/memorydata/intelligence/datalearning/profile/task/ProfileTaskInfo;)V", "computeMidTermProfile", "", "startTimestamp", "endTimestamp", "computeLongTermProfile", "runPackage", "taskName", "", "Companion", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d extends com.obric.memorydata.intelligence.datalearning.profile.task.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9959a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/time/sleepwakeup/SleepWakeupPackageTask$Companion;", "", "<init>", "()V", "TAG", "", "KEY_TASK_NAME", "KEY_START", "KEY_END", "TASK_DAILY", "TASK_LONG_TERM", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9959a = new a(null);
    }

    public d(com.obric.memorydata.intelligence.datalearning.profile.task.b r2) {
        Intrinsics.checkNotNullParameter(r2, "profileTaskInfo");
        super(r2);
    }

    private final long a(String r10, long r11, long r13) {
        JSONObject r9 = new JSONObject();
        r9.put("taskName", r10);
        r9.put("startTimestamp", r11);
        r9.put("endTimestamp", r13);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SleepWakeupPackageTask", "runPackage start, package=sleepwakeup task=" + r10 + " start=" + r11 + " end=" + r13, false, 4, null);
        TaskResult r12 = ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("sleepwakeup").setInputParam(r9), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTimeout(new g(60, TimeUnit.SECONDS)), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute();
        if (r12.getCode() != 0) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SleepWakeupPackageTask", "runPackage success, task=" + r10, false, 4, null);
        return r13;
    L5:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SleepWakeupPackageTask", "runPackage fail, task=" + r10 + " code=" + r12.getCode(), null, 4, null);
        return -1;
    }

    @Override // com.obric.memorydata.intelligence.datalearning.profile.task.a
    public long a(long r7, long r9) {
        return a("longTerm", r7, r9);
    }

    @Override // com.obric.memorydata.intelligence.datalearning.profile.task.a
    public long b(long r7, long r9) {
        return a("daily", r7, r9);
    }
}
