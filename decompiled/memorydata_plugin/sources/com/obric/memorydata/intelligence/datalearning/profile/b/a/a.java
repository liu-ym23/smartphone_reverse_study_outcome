package com.obric.memorydata.intelligence.datalearning.profile.b.a;

import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.intelligence.datalearning.profile.task.b;
import com.obric.memorydata.task.impl.TaskRequest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/time/arriveleavemoment/ArriveLeaveMomentTask;", "Lcom/obric/memorydata/intelligence/datalearning/profile/task/BaseProfileTask;", "profileTaskInfo", "Lcom/obric/memorydata/intelligence/datalearning/profile/task/ProfileTaskInfo;", "<init>", "(Lcom/obric/memorydata/intelligence/datalearning/profile/task/ProfileTaskInfo;)V", "computeMidTermProfile", "", "startTimestamp", "endTimestamp", "computeLongTermProfile", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a extends com.obric.memorydata.intelligence.datalearning.profile.task.a {
    public a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "profileTaskInfo");
        super(r2);
    }

    @Override // com.obric.memorydata.intelligence.datalearning.profile.task.a
    public long a(long r4, long r6) {
        Object r3 = FeatureManager.INSTANCE.getFeature("location_home_gps");
        if (r3 != null) goto L5;
    L17:
        return r6;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, List.class) == false) goto L17;
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).size() != 2) goto L17;
        Object r5 = FeatureManager.INSTANCE.getFeature("location_company_gps");
        if (r5 == null) goto L17;
        if (ZeusTransformUtils.instanceOf(r5, List.class) == false) goto L17;
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).size() != 2) goto L17;
        TaskRequest.Builder r7 = new TaskRequest.Builder("commute_track_and_check");
        JSONObject r0 = new JSONObject();
        r0.put("taskName", "longTerm");
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r7.setInputParam(r0), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute();
        TaskRequest.Builder r8 = new TaskRequest.Builder("commute_track_and_check");
        JSONObject r9 = new JSONObject();
        r9.put("taskName", "routeLearn");
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r8.setInputParam(r9), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute();
        goto L17
    }

    @Override // com.obric.memorydata.intelligence.datalearning.profile.task.a
    public long b(long r7, long r9) {
        long r6 = Math.max(r7, r9 - 2592000000L);
        long r0 = r9;
    L3:
        TaskRequest.Builder r8 = new TaskRequest.Builder("commute_track_and_check");
        JSONObject r2 = new JSONObject();
        r2.put("taskName", "daily");
        r2.put("timestamp", r0 / ((long) 1000));
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r8.setInputParam(r2), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute();
        r0 = r0 - WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS;
        if ((r0 - WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) >= r6) goto L3;
        return r9;
    }
}
