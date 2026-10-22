package com.bytedance.android.live.browser.schema.core;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public final JSONObject a;
    public final String b;

    public static final class a {
    }

    static {
    }

    public /* synthetic */ d() {
        throw null;
    }

    public final long a() {
        JSONObject r0 = this.a.optJSONObject("common_config");
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.optLong("limit_second");
    }

    public final JSONObject b() {
        return JSONObjectProtectorUtils.getJSONObject(this.a, "redirect_rules");
    L4:
        StringBuilder r0 = new StringBuilder("redirectRuleJsonObj get failed, geckoVersion: ");
        r0.append(this.b);
        r0.append(", settingVersion: ");
        JSONObject r1 = this.a.optJSONObject("common_config");
        if (r1 == null) goto L7;
        String r2 = r1.optString("config_version");
    L8:
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        r0.append(r2);
        com.bytedance.android.live.schema.api.utils.a.b("RedirectRuleSpec", r0.toString(), null);
        return null;
    L7:
        r2 = null;
        goto L8
    }

    public d(JSONObject r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "raw");
        this.a = r2;
        this.b = r3;
    }
}
