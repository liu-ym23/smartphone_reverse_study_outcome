package com.bytedance.android.livesdk.chatroom.viewmodule.welfare.utils;

import am2.n;
import am2.x;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.config.sy0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class WelfareAppLogger {
    @JvmStatic
    public static final void g() {
        final boolean r1 = true;
        j("livesdk_anchor_welfare_click", new WelfareAppLogger$sendAnchorWelfareIconClickEvent$1(r1));
    }

    @JvmStatic
    public static final void h() {
        final boolean r1 = true;
        j("livesdk_anchor_welfare_show", new WelfareAppLogger$sendAnchorWelfareIconShowEvent$1(r1));
    }

    public static String c() {
        String r0 = n.f().d();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L22;
        JSONObject r3 = new JSONObject(r0);     // Catch: Exception -> L14
    L16:
        if (r3 != null) goto L18;
        return null;
    L18:
        return r3.optString("clickid");
    L14:
        e = move-exception;
        SafetyGuard.a(null, e, "parse LiveAd extra fail by welfareAppLog");
        r3 = null;
        goto L16
    L22:
        return null;
    L7:
        r2 = false;
        goto L8
    }

    static {
    }

    public static void a(Map r2) {
        if (sy0.a.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        if (n.f().g() == false) goto L7;
    L10:
        String r0 = "1";
    L11:
        HashMap r3 = (HashMap) r2;
        r3.put("is_live_ad", r0);
        r3.put("ad_id", n.f().a());
        String r1 = c();
        if (r1 == null) goto L16;
        r3.put("clickid", r1);
        return;
    L16:
        return;
    L7:
        if (n.f().h() == true) goto L10;
        r0 = "0";
        goto L11
    }

    @JvmStatic
    public static final String b(String r6) {
        Intrinsics.checkNotNullParameter(r6, "schema");
        Uri r7 = UriProtector.parse(r6);
        String r1 = UriProtector.getQueryParameter(r7, "url");
        boolean r2 = TextUtils.isEmpty(r1);
        if (sy0.a.getValue().booleanValue() == false) goto L36;
        if (r2 == false) goto L6;
        Uri.Builder r3 = r7.buildUpon();     // Catch: Exception -> L33
    L8:
        if (n.f().g() == false) goto L10;
    L13:
        String r4 = "1";
    L14:
        Uri.Builder r5 = r3.appendQueryParameter("is_live_ad", r4);     // Catch: Exception -> L33
        String r8 = n.f().a();     // Catch: Exception -> L33
        String r9 = "";
        if (r8 != null) goto L18;
        r8 = "";
    L18:
        Uri.Builder r10 = r5.appendQueryParameter("ad_id", r8);     // Catch: Exception -> L33
        String r11 = c();     // Catch: Exception -> L33
        if (r11 == null) goto L22;
        r9 = r11;
    L22:
        Uri r12 = r10.appendQueryParameter("click_id", r9).build();     // Catch: Exception -> L33
        if (r2 == false) goto L25;
        r7 = r12;
        goto L36
    L25:
        String r13 = r12.toString();     // Catch: Exception -> L33
        Uri.Builder r14 = r7.buildUpon().clearQuery();     // Catch: Exception -> L33
        Iterator r15 = UriProtector.getQueryParameterNames(r7).iterator();     // Catch: Exception -> L33
    L27:
        if (r15.hasNext() == false) goto L31;
        String r16 = (String) r15.next();     // Catch: Exception -> L33
        if ((!Intrinsics.areEqual(r16, "url")) == false) goto L27;
        r14.appendQueryParameter(r16, UriProtector.getQueryParameter(r7, r16));     // Catch: Exception -> L33
        goto L27
    L31:
        r14.appendQueryParameter("url", r13);     // Catch: Exception -> L33
        r7 = r14.build();     // Catch: Exception -> L33
        goto L36
    L10:
        if (n.f().h() == true) goto L13;
        r4 = "0";
        goto L14
    L6:
        r3 = UriProtector.parse(r1).buildUpon();     // Catch: Exception -> L33
    L33:
        e = move-exception;
        SafetyGuard.a(null, null, e.getMessage());
    L36:
        return r7.toString();
    }

    @JvmStatic
    public static final void e(final long r1) {
        j("livesdk_anchor_welfare_delete", new WelfareAppLogger$sendAnchorWelfareDeleteEvent$1(r1));
    }

    @JvmStatic
    public static final void f(final long r1) {
        j("livesdk_anchor_welfare_frequency", new WelfareAppLogger$sendAnchorWelfareFrequencyEvent$1(r1));
    }

    @JvmStatic
    public static final void i(final boolean r1) {
        j("livesdk_user_welfare_click", new WelfareAppLogger$sendAudienceClickEvent$1(r1));
    }

    @JvmStatic
    public static final void k(final long r1) {
        j("livesdk_user_welfare_card_show", new WelfareAppLogger$sendWelfareProjectCardShowEvent$1(r1));
    }

    @JvmStatic
    public static final void d(final long r2, final String r4) {
        Intrinsics.checkNotNullParameter(r4, "listPage");
        final boolean r1 = true;
        j("livesdk_anchor_welfare_confirm", new WelfareAppLogger$sendAnchorWelfareConfirmEvent$1(r2, r1, r4));
    }

    public static void j(String r4, Function1 r5) {
        HashMap r0 = new HashMap();     // Catch: Exception -> L4
        r5.invoke(r0);     // Catch: Exception -> L4
        a(r0);     // Catch: Exception -> L4
        u.l().sendLog(r4, r0, new Object[]{new x(), Room.class});     // Catch: Exception -> L4
        return;
    }
}
