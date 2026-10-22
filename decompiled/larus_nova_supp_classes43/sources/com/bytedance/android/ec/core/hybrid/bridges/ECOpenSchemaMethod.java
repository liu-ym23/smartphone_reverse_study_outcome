package com.bytedance.android.ec.core.hybrid.bridges;

import android.content.Context;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECOpenSchemaMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECOpenSchemaMethod extends ECBaseBridgeMethod {
    public final String e;

    public static final class a {
    }

    static {
    }

    public ECOpenSchemaMethod() {
        this.e = "ecOpenSchema";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r12, ECBaseBridgeMethod.a r13) {
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r13, "iReturn");
        String r14 = r12.optString(com.bytedance.android.ec.core.event.a.KEY_URL, "");
        JSONObject r0 = new JSONObject();
        if (r14.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r14 = null;
    L9:
        String r10 = r14;
        if (r10 == null) goto L15;
        Context r11 = getContext();
        if (r11 == null) goto L14;
        ECLiveHybridUtil.k(r11, r10, false, false, false, null, 252);
    L14:
        r0.put("code", 1);
    L16:
        r13.a(r0);
        return;
    L15:
        r0.put("code", 0);
        goto L16
    L5:
        r1 = false;
        goto L6
    }
}
