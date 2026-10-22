package com.bytedance.android.ec.common.impl.hybrid.bridges;

import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s83.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/common/impl/hybrid/bridges/CoverSearchHistoryMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CoverSearchHistoryMethod extends ECBaseBridgeMethod {
    public final String getName() {
        return "coverSearchHistory";
    }

    public CoverSearchHistoryMethod() {
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        boolean r0 = ECServiceManager.a;
        JSONObject r12 = ((g) ECServiceManager.c(g.class)).K(r10);
        if (r12 == null) goto L5;
        r11.a(r12);
        return;
    L5:
        r11.onFailed(0, "data parse failed");
    }
}
