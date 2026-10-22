package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/HeightChangedMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeightChangedMethod extends ECBaseBridgeMethod {
    public final String e;

    public HeightChangedMethod() {
        this.e = "shopAdjustHybridContainerHeight";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        boolean r0 = false;
        Integer r12 = Integer.valueOf(r10.optInt("height", 0));
        if (r12.intValue() == 0) goto L5;
        r0 = true;
    L5:
        if (r0 == true) goto L8;
        r12 = null;
    L8:
        if (r12 == null) goto L11;
        s0.a(new ah.e(r12.intValue(), r10.optString("targetContainer", "")));
        return;
    }
}
