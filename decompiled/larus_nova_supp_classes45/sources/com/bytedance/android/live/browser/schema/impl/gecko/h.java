package com.bytedance.android.live.browser.schema.impl.gecko;

import android.content.SharedPreferences;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements g {

    public static final class a {
    }

    static {
    }

    public h() {
    }

    @Override // com.bytedance.android.live.browser.schema.impl.gecko.g
    public final com.bytedance.android.live.browser.schema.core.d restore() {
        boolean r2 = false;
        SharedPreferences r0 = k.n(IMiddleWareHostContext.class).context().getSharedPreferences("webcast_redirect", 0);
        String r1 = r0.getString("redirect_rules", "");
        if (r1 != null) goto L5;
    L6:
        r2 = true;
    L7:
        Object r4 = null;
        if (r2 == false) goto L23;
        return null;
    L23:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L12
        JSONObject r5 = new JSONObject(r1);     // Catch: Throwable -> L12
        Object r6 = Result.constructor-impl(new com.bytedance.android.live.browser.schema.core.d(r5.optJSONObject("raw"), r5.optString("version")));     // Catch: Throwable -> L12
    L15:
        if (Result.exceptionOrNull-impl(r6) == null) goto L18;
        r0.edit().remove("redirect_rules").apply();
    L18:
        if (Result.isFailure-impl(r6) == true) goto L22;
        r4 = r6;
    L22:
        return (com.bytedance.android.live.browser.schema.core.d) r4;
    L12:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L5:
        if (r1.length() != 0) goto L7;
        goto L6
    }

    @Override // com.bytedance.android.live.browser.schema.impl.gecko.g
    public final void a(com.bytedance.android.live.browser.schema.core.d r5) {
        Intrinsics.checkNotNullParameter(r5, "spec");
        SharedPreferences r0 = k.n(IMiddleWareHostContext.class).context().getSharedPreferences("webcast_redirect", 0);
        JSONObject r1 = new JSONObject();
        r1.put("raw", r5.a);
        String r6 = r5.b;
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        r1.put("version", r6);
        if (r0 == null) goto L13;
        SharedPreferences.Editor r7 = r0.edit();
        if (r7 == null) goto L14;
        SharedPreferences.Editor r8 = r7.putString("redirect_rules", r1.toString());
        if (r8 == null) goto L15;
        r8.apply();
        return;
    L15:
        return;
    L14:
        return;
    }
}
