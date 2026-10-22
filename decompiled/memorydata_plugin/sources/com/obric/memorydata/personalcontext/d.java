package com.obric.memorydata.personalcontext;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.awareness.api.FeatureManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/personalcontext/DeviceFeatureManager;", "Lcom/obric/memorydata/personalcontext/IDeviceFeatureManager;", "<init>", "()V", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "getFeature", "", "featureName", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f12081a = null;

    static {
        f12081a = new d();
    }

    private d() {
    }

    public Object a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "featureName");
        return FeatureManager.INSTANCE.getFeature(r1);
    }

    public void a() {
    }
}
