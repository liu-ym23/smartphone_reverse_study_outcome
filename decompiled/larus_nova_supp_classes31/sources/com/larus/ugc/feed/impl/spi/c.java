package com.larus.ugc.feed.impl.spi;

import com.ixigua.lib.track.TrackParams;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import g0a.e;
import g0a.h;
import g0a.i;
import g0a.j;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.x2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c implements e {
    public final String a;
    public final String b;

    public static final class a {
    }

    static {
    }

    @Override // g0a.e
    public final void JA(h r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        JSONObject r1 = new JSONObject();
        r1.put("current_page", r6.a);     // Catch: JSONException -> L5
    L7:
        by7.a r7 = new by7.a("click_create_button");
        r7.a.merge(new TrackParams().merge(r1));
        r7.b();
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L10
        g.a.monitorEventForSlardar("click_create_button", r1, null, null);     // Catch: Throwable -> L10
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L20;
        FLogger.a.e("TemplateCreationTrackerAndroidImpl", "slardar report failed: " + r10.getMessage());
        return;
    L20:
        return;
    L10:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L5:
        e = move-exception;
        FLogger.a.e("TemplateCreationTrackerAndroidImpl", "mobClickCreateButton json error: " + e.getMessage());
        goto L7
    }

    @Override // g0a.e
    public final void wF(j r11) {
        Intrinsics.checkNotNullParameter(r11, "params");
        String r1 = r11.a;
        String r2 = r11.b;
        String r3 = r11.c;
        String r4 = r11.d;
        String r5 = r11.e;
        String r6 = r11.f;
        String r7 = r11.g;
        long r8 = r11.h;
        x2.e(r1, r2, r3, r4, r5, r6, r7, this.b, Long.valueOf(r8));
    }

    @Override // g0a.e
    public final void zh(i r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        JSONObject r0 = new JSONObject();
        r0.putOpt("template_page_type", this.b);     // Catch: JSONException -> L5
        r0.put("current_page", r5.a);     // Catch: JSONException -> L5
        r0.put("bot_id", this.a);     // Catch: JSONException -> L5
        r0.put("tab_id", r5.b);     // Catch: JSONException -> L5
        r0.put("tab_name", r5.c);     // Catch: JSONException -> L5
        r0.put("from_tab_id", r5.d);     // Catch: JSONException -> L5
        r0.put("tab_type", r5.e);     // Catch: JSONException -> L5
        r0.put("enter_method", r5.f);     // Catch: JSONException -> L5
    L7:
        by7.a r6 = new by7.a("enter_ai_generate_tab_category_page");
        r6.a.merge(new TrackParams().merge(r0));
        r6.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("TemplateCreationTrackerAndroidImpl", "mobEnterTab json error: " + e.getMessage());
        goto L7
    }

    public c(String r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
