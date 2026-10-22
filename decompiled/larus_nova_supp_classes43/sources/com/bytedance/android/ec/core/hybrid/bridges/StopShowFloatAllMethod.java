package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/StopShowFloatAllMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StopShowFloatAllMethod extends ECBaseBridgeMethod {
    public final String e;

    public static final class a {
    }

    static {
    }

    public StopShowFloatAllMethod() {
        this.e = "stopShowFloatAll";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        int r12 = ECSdk.a;
        IAdapterService r13 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r13 == null) goto L7;
        com.bytedance.android.ec.adapter.api.j r14 = r13.getLiveWindowService();
        if (r14 == null) goto L7;
        r14.stopShowFloat();
    L7:
        r11.onSuccess(new JSONObject());
    }
}
