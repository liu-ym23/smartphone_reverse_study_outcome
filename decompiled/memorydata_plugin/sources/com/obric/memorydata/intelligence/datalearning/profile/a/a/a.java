package com.obric.memorydata.intelligence.datalearning.profile.a.a;

import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.memorydata.intelligence.datalearning.profile.task.b;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/location/homecompany/HomeCompanyTask;", "Lcom/obric/memorydata/intelligence/datalearning/profile/task/BaseProfileTask;", "profileTaskInfo", "Lcom/obric/memorydata/intelligence/datalearning/profile/task/ProfileTaskInfo;", "<init>", "(Lcom/obric/memorydata/intelligence/datalearning/profile/task/ProfileTaskInfo;)V", "computeLongTermProfile", "", "startTimestamp", "endTimestamp", "computeMidTermProfile", "Companion", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a extends com.obric.memorydata.intelligence.datalearning.profile.task.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0482a f9955a = null;

    /* JADX INFO: renamed from: com.obric.memorydata.intelligence.datalearning.profile.a.a.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/location/homecompany/HomeCompanyTask$Companion;", "", "<init>", "()V", "TAG", "", "KEY_TASK_NAME", "KEY_TIME_STAMP", "KEY_LONGITUDE", "KEY_LATITUDE", "KEY_TRIGGER_SOURCE", "VALUE_DAILY", "VALUE_LONG_TERM", "VALUE_NOON_UPDATE", "VALUE_LOCATION_CHANGE_5KM", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0482a {
        private C0482a() {
        }

        public /* synthetic */ C0482a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9955a = new C0482a(null);
    }

    public a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "profileTaskInfo");
        super(r2);
    }

    @Override // com.obric.memorydata.intelligence.datalearning.profile.task.a
    public long a(long r4, long r6) {
        TaskRequest.Builder r3 = new TaskRequest.Builder("home_company_location_calculate");
        JSONObject r5 = new JSONObject();
        r5.put("taskName", "longTerm");
        r5.put("timestamp", r6 / ((long) 1000));
        r5.put("trigger_source", "noon_update");
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r3.setInputParam(r5), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTimeout(new g(30, TimeUnit.SECONDS)), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute();
        return r6;
    }

    @Override // com.obric.memorydata.intelligence.datalearning.profile.task.a
    public long b(long r8, long r10) {
        long r0 = r10;
    L3:
        TaskRequest.Builder r7 = new TaskRequest.Builder("home_company_location_calculate");
        JSONObject r2 = new JSONObject();
        r2.put("taskName", "daily");
        r2.put("timestamp", r0 / ((long) 1000));
        r2.put("trigger_source", "noon_update");
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r7.setInputParam(r2), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTimeout(new g(30, TimeUnit.SECONDS)), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute();
        r0 = r0 - WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS;
        if ((r0 - WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) >= r8) goto L3;
        return r10;
    }
}
