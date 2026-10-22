package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECSetMegaObjectMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSetMegaObjectMethod extends ECBaseBridgeMethod {
    public final String e;
    public String f;
    public JSONObject g;

    public static final class a {
    }

    static {
    }

    public ECSetMegaObjectMethod() {
        this.e = "setMegaObject";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        this.f = r10.optString("id");
        this.g = r10.optJSONObject("object");
        JSONObject r12 = new JSONObject();
        String r0 = this.f;
        if (r0 == null) goto L6;
        HashMap<String, JSONObject> r13 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        com.bytedance.android.ec.core.hybrid.utils.j.h(r0, this.g);
        if (r12.put("code", 0) == null) goto L6;
    L7:
        r11.a(r12);
        return;
    L6:
        r12.put("code", 1);
        goto L7
    }
}
