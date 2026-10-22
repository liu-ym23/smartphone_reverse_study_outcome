package com.obric.memorydata.awareness;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007J:\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00012\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J0\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00072\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J \u0010\u0011\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/awareness/ContextAwarenessReporter;", "", "<init>", "()V", "reportRegisteredFeature", "", "featureName", "", AILabCheckPermissionTask.KEY_SOURCE, "reportRegisteredGeoFence", "fenceId", "reportFeatureChanged", "newValue", WsConstants.KEY_EXTRA, "", "reportEventChanged", "eventName", "reportGeoFenceChanged", "status", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8503a = null;

    static {
        f8503a = new a();
    }

    private a() {
    }

    public final void a(String r3, Object r4, Map<String, ? extends Object> r5, String r6) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "featureName");
        Tracker r7 = Tracker.INSTANCE;
        JSONObject r0 = new JSONObject();
        r0.put("feature_name", r3);
        if (r4 == null) goto L5;
        r0.put("feature_value", r4.toString());
    L5:
        if (r2 == null) goto L7;
        r0.put(TrackerImpl.PARAMS, new JSONObject(r2).toString());
    L7:
        if (r6 != null) goto L9;
        r6 = "";
    L9:
        r0.put(AILabCheckPermissionTask.KEY_SOURCE, r6);
        Unit r8 = Unit.INSTANCE;
        r7.reportEvent("register_feature_change2", r0);
    }

    public final void a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "featureName");
        Tracker r2 = Tracker.INSTANCE;
        JSONObject r0 = new JSONObject();
        r0.put("feature_name", r3);
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r0.put(AILabCheckPermissionTask.KEY_SOURCE, r4);
        Unit r5 = Unit.INSTANCE;
        r2.reportEvent("register_feature", r0);
    }

    public final void a(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "fenceId");
        Intrinsics.checkNotNullParameter(r4, "status");
        Tracker r2 = Tracker.INSTANCE;
        JSONObject r0 = new JSONObject();
        r0.put("fence_name", r3);
        r0.put("fence_status", r4);
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r0.put(AILabCheckPermissionTask.KEY_SOURCE, r5);
        Unit r6 = Unit.INSTANCE;
        r2.reportEvent("register_location_fence_change", r0);
    }

    public final void a(String r3, Map<String, ? extends Object> r4, String r5) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Tracker r6 = Tracker.INSTANCE;
        JSONObject r0 = new JSONObject();
        r0.put("event_name", r3);
        if (r2 == null) goto L5;
        boolean r7 = true;
    L6:
        r0.put("has_extra", r7);
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        r0.put(AILabCheckPermissionTask.KEY_SOURCE, r5);
        Unit r8 = Unit.INSTANCE;
        r6.reportEvent("register_event_change2", r0);
        return;
    L5:
        r7 = false;
        goto L6
    }

    public final void b(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "fenceId");
        Tracker r2 = Tracker.INSTANCE;
        JSONObject r0 = new JSONObject();
        r0.put("fence_name", r3);
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r0.put(AILabCheckPermissionTask.KEY_SOURCE, r4);
        Unit r5 = Unit.INSTANCE;
        r2.reportEvent("register_location_fence", r0);
    }
}
