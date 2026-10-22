package com.obric.memorydata;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.middleware.api.IBuildTypeFlavor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0000H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/BuildTypeFlavor;", "Lcom/obric/memorydata/middleware/api/IBuildTypeFlavor;", "<init>", "()V", "TAG", "", "getInst", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "checkPrivacyData", LocationMonitorConst.TAG, "message", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BuildTypeFlavor implements IBuildTypeFlavor {
    public static final BuildTypeFlavor INSTANCE = null;
    public static final String TAG = "FlavorAPI-release";

    static {
        INSTANCE = new BuildTypeFlavor();
    }

    private BuildTypeFlavor() {
    }

    @JvmStatic
    public static final BuildTypeFlavor getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.middleware.api.IBuildTypeFlavor
    public void checkPrivacyData(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    @Override // com.obric.memorydata.middleware.api.IBuildTypeFlavor
    public void init() {
    }
}
