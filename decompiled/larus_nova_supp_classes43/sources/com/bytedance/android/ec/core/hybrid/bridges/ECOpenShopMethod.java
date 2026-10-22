package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECOpenShopMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECOpenShopMethod extends ECBaseBridgeMethod {
    public final String e;

    public static final class a {
    }

    static {
    }

    public ECOpenShopMethod() {
        this.e = "openShop";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        boolean r0 = false;
        Integer r12 = Integer.valueOf(r10.optInt("tab", 0));
        if (r12.intValue() == 0) goto L5;
        boolean r1 = true;
    L6:
        String r13 = null;
        if (r1 == true) goto L10;
        r12 = null;
    L10:
        if (r12 == null) goto L12;
        int r14 = r12.intValue();
    L13:
        String r15 = r10.optString("product_tab_params");
        if (r15 != null) goto L16;
    L18:
        if (r0 == false) goto L20;
        r13 = r15;
    L20:
        if (r13 != null) goto L23;
        r13 = "";
    L23:
        if (r14 == 0) goto L26;
        s0.a(new ah.d(r14, r13));
        return;
    L26:
        return;
    L16:
        if (r15.length() <= 0) goto L18;
        r0 = true;
        goto L18
    L12:
        r14 = 0;
        goto L13
    L5:
        r1 = false;
        goto L6
    }
}
