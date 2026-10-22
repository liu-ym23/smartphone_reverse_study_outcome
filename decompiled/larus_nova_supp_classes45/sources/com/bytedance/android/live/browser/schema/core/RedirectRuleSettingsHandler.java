package com.bytedance.android.live.browser.schema.core;

import com.bytedance.android.live.schema.api.WebcastRedirectReportInfo;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class RedirectRuleSettingsHandler {
    public final JSONObject a;
    public String b;
    public final c c;
    public final WebcastRedirectReportInfo d;

    public final com.bytedance.android.live.schema.api.a a(final String r8) {
        Intrinsics.checkNotNullParameter(r8, "key");
        RedirectRule r1 = this.c.get(r8);
        String r2 = "";
        String r3 = null;
        if (r1 == null) goto L13;
        JSONObject r4 = this.a;
        JSONObject r5 = this.c.a.b();
        if (r5 == null) goto L9;
        Object r6 = r5.opt(r8);
        if (r6 == null) goto L9;
        String r7 = r6.toString();
    L10:
        if (r7 != null) goto L12;
        r7 = "";
    L12:
        r4.put("setting_value", r7);
        com.bytedance.android.live.schema.api.a r9 = r1.a(this.a, new RedirectRuleSettingsHandler$getFinalSchemaWithEntryKey$$inlined$let$lambda$1(this, r8));
    L14:
        WebcastRedirectReportInfo r11 = this.d;
        r11.a("rule_type", this.b);
        JSONObject r12 = this.c.a.a.optJSONObject("common_config");
        if (r12 == null) goto L17;
        r3 = r12.optString("config_version");
    L17:
        if (r3 == null) goto L20;
        r2 = r3;
    L20:
        r11.a("config_version", r2);
        String r13 = this.a.toString();
        Intrinsics.checkNotNullParameter("extra_env_info", "key");
        Intrinsics.checkNotNullParameter(r13, "value");
        r11.c().put("extra_env_info", r13);
        return r9;
    L9:
        r7 = null;
        goto L10
    L13:
        r9 = null;
        goto L14
    }

    public RedirectRuleSettingsHandler(c r2, WebcastRedirectReportInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "settings");
        Intrinsics.checkNotNullParameter(r3, "reportInfo");
        this.c = r2;
        this.d = r3;
        this.a = new JSONObject();
        this.b = "-1";
    }
}
