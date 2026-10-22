package com.bytedance.android.live.browser.schema.core;

import com.bytedance.android.live.browser.schema.core.strategy.f;
import com.bytedance.android.live.browser.schema.core.strategy.g;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class RedirectRuleCreator implements b {
    public final d a;
    public final com.bytedance.android.live.browser.schema.core.strategy.d b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.browser.schema.core.b
    public final RedirectRule get(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        JSONObject r1 = this.a.b();
        if (r1 == null) goto L18;
        Object r5 = r1.get(r4);     // Catch: JSONException -> L6
    L8:
        if (r5 == null) goto L19;
        return b(this, r5, RedirectRuleCreator$get$1$1$1.INSTANCE);
    L11:
        e = move-exception;
        com.bytedance.android.live.schema.api.utils.a.b("RedirectRuleCreator", "rule parse error", e);
        return null;
    L19:
        return null;
    L6:
        e = move-exception;
        com.bytedance.android.live.schema.api.utils.a.b("RedirectRuleCreator", "get key error", e);
        r5 = null;
        goto L8
    L18:
        return null;
    }

    public RedirectRuleCreator(d r2, com.bytedance.android.live.browser.schema.core.strategy.d r3) {
        Intrinsics.checkNotNullParameter(r2, "ruleSpec");
        Intrinsics.checkNotNullParameter(r3, "strategyRegister");
        this.a = r2;
        this.b = r3;
    }

    public static /* synthetic */ RedirectRule b(RedirectRuleCreator r1, Object r2, Function1 r3) {
        return r1.a(r2, new g(), r3);
    }

    public final RedirectRule a(Object r7, com.bytedance.android.live.browser.schema.core.strategy.c r8, Function1<Object, Boolean> r9) {
        if (((Boolean) r9.invoke(r7)).booleanValue() == true) goto L7;
        r8 = new com.bytedance.android.live.browser.schema.core.strategy.b(-1, r7.toString());
    L7:
        if ((r7 instanceof String) == false) goto L11;
        return new RedirectRule(r8, (String) r7, null);
    L11:
        if ((r7 instanceof JSONArray) == false) goto L21;
        JSONArray r11 = (JSONArray) r7;
        ArrayList r0 = new ArrayList();
        int r2 = r11.length();
        int r3 = 0;
    L13:
        if (r3 >= r2) goto L19;
        RedirectRule r4 = b(this, r11.get(r3), RedirectRuleCreator$toRedirectRules$1.INSTANCE);
        if (r4 == null) goto L17;
        r0.add(r4);
    L17:
        r3 = r3 + 1;
        goto L13
    L19:
        return new RedirectRule(r8, null, r0);
    L21:
        if ((r7 instanceof JSONObject) == false) goto L32;
        JSONObject r12 = (JSONObject) r7;
        int r1 = JSONObjectProtectorUtils.getInt(r12, "ruleType");
        if (((Boolean) r9.invoke(r7)).booleanValue() == false) goto L29;
        Map<Integer, com.bytedance.android.live.browser.schema.core.strategy.c.b> r13 = this.b.a;
        HashMap r14 = (HashMap) r13;
        com.bytedance.android.live.browser.schema.core.strategy.c.b r15 = (com.bytedance.android.live.browser.schema.core.strategy.c.b) r14.get(Integer.valueOf(r1));
        if (r15 == null) goto L28;
        com.bytedance.android.live.browser.schema.core.strategy.c r16 = r15.a(r12);
        if (r16 == null) goto L28;
    L31:
        return a(r12.get("location"), r16, RedirectRuleCreator$createRedirectRule$1.INSTANCE);
    L28:
        r16 = new f(r1);
        goto L31
    L29:
        r16 = new com.bytedance.android.live.browser.schema.core.strategy.b(r1, r7.toString());
        goto L31
    L32:
        return null;
    }
}
