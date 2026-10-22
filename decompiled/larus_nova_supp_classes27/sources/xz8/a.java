package xz8;

import com.ixigua.lib.track.TrackParams;
import com.larus.applog.api.IApplog;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final void b(String r4, String r5, String r6, String r7) {
        IApplog.Companion r0 = IApplog.a;
        JSONObject r1 = new JSONObject();
        r1.put("current_page", "login_with_doubao");
        r1.put("trigger_app", r4);
        r1.put("click_from", r5);
        r1.put("account_type", r6);
        r1.put("switch_account_id", r7);
        Unit r8 = Unit.INSTANCE;
        r0.reportEvent("login_with_doubao_switch_account", r1);
    }

    public static final void c(String r4, String r5, String r6, String r7) {
        IApplog.Companion r0 = IApplog.a;
        JSONObject r1 = new JSONObject();
        r1.put("current_page", "login_with_doubao");
        r1.put("trigger_app", r4);
        r1.put("account_type", r5);
        r1.put("switch_account_id", r6);
        r1.put("result", r7);
        Unit r8 = Unit.INSTANCE;
        r0.reportEvent("login_with_doubao_switch_account_result", r1);
    }

    public static void a(Boolean r3, String r4, String r5, String r6, String r7, int r8) {
        JSONObject r1 = null;
        if ((r8 & 1) == 0) goto L5;
        String r0 = null;
    L7:
        if ((r8 & 2) == 0) goto L10;
        r3 = null;
    L10:
        if ((r8 & 4) == 0) goto L13;
        r4 = null;
    L13:
        if ((r8 & 8) == 0) goto L16;
        r5 = null;
    L16:
        if ((r8 & 16) == 0) goto L19;
        r6 = null;
    L19:
        if ((r8 & 32) == 0) goto L22;
        r7 = null;
    L22:
        if ((r8 & 64) == 0) goto L24;
        r1 = new JSONObject();
    L24:
        Intrinsics.checkNotNullParameter(r1, "params");
    L47:
        e = move-exception;
        FLogger.a.e("AuthorizeTraceHelper", "error in AuthorizeTraceHelper enterAddFriendPage " + e.getLocalizedMessage());
    L49:
        TrackParams r9 = new TrackParams().merge(r1);
        by7.a r10 = new by7.a("login_with_doubao_result");
        r10.a.merge(r9);
        r10.b();
        return;
    L26:
        if (o0.d(r0) == false) goto L28;
        r1.put("current_page", r0);     // Catch: JSONException -> L47
    L28:
        if (r3 == null) goto L35;
        if (r3.booleanValue() == false) goto L32;
        int r11 = 1;
    L33:
        r1.put(FlowDoraConnectReason.SUCCESS, r11);     // Catch: JSONException -> L47
        goto L35
    L32:
        r11 = 0;
    L35:
        if (o0.d(r4) == false) goto L38;
        r1.put("trigger_app", r4);     // Catch: JSONException -> L47
    L38:
        if (o0.d(r5) == false) goto L41;
        r1.put("error_code", r5);     // Catch: JSONException -> L47
    L41:
        if (o0.d(r6) == false) goto L44;
        r1.put("origin_error_code", r6);     // Catch: JSONException -> L47
    L44:
        if (o0.d(r7) == false) goto L49;
        r1.put("error_msg", r7);     // Catch: JSONException -> L47
        goto L49
    L5:
        r0 = "login_with_doubao";
        goto L7
    }
}
