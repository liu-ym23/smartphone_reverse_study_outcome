package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class v2 {
    public static void c(boolean r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        TrackParams r3 = new TrackParams().merge(r2);
        if (r1 == false) goto L5;
        String r4 = "pin_no_chat_cell";
    L6:
        by7.a r0 = new by7.a(r4);
        r0.a.merge(r3);
        r0.b();
        return;
    L5:
        r4 = "unpin_no_chat_cell";
        goto L6
    }

    public static final void a(String r1, String r2, String r3, String r4, String r5, JSONObject r6, by7.e r7, String r8, String r9, String r10, String r11, Integer r12, String r13) {
        Intrinsics.checkNotNullParameter(r6, "params");
        if (r1 != null) goto L45;
    L7:
        if (r2 == null) goto L9;
        r6.put("click_from", r2);     // Catch: JSONException -> L5
    L9:
        if (r3 == null) goto L11;
        r6.put("current_page", r3);     // Catch: JSONException -> L5
    L11:
        if (r4 == null) goto L13;
        r6.put("chat_type", r4);     // Catch: JSONException -> L5
    L13:
        if (r5 == null) goto L15;
        r6.put("is_immersive_background", r5);     // Catch: JSONException -> L5
    L15:
        if (r9 == null) goto L17;
        r6.put("is_call_bot", r9);     // Catch: JSONException -> L5
    L17:
        boolean r14 = true;
        if (r8 != null) goto L20;
    L22:
        boolean r15 = false;
    L23:
        if (r15 == false) goto L25;
        r6.put("recommend_from", r8);     // Catch: JSONException -> L5
    L25:
        if (r10 != null) goto L27;
    L29:
        r14 = false;
    L30:
        if (r14 == false) goto L32;
        r6.put("request_id", r10);     // Catch: JSONException -> L5
    L32:
        if (r11 == null) goto L34;
        r6.put("is_navigation_sidebar", r11);     // Catch: JSONException -> L5
    L34:
        if (r12 == null) goto L36;
        r6.put("bot_type", r12.intValue());     // Catch: JSONException -> L5
    L36:
        if (r13 == null) goto L40;
        r6.put("conversation_id", r13);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("PinEventHelper", "error in PinEventHelper pinChat " + e.getLocalizedMessage());
    L40:
        TrackParams r16 = new TrackParams().merge(r6);
        by7.a r17 = new by7.a("pin_chat");
        if (r7 == null) goto L43;
        r17.b = r7;
    L43:
        r17.a.merge(r16);
        r17.b();
        return;
    L27:
        if (com.larus.utils.o0.d(r10) != true) goto L29;
    L20:
        if (com.larus.utils.o0.d(r8) != true) goto L22;
        r15 = true;
        goto L23
    L45:
        r6.put("bot_id", r1);     // Catch: JSONException -> L5
        goto L7
    }

    public static /* synthetic */ void b(String r2, String r3, String r4, String r5, String r6, JSONObject r7, by7.e r8, String r9, String r10, String r11, String r12, Integer r13, int r14) {
        if ((r14 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r14 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r14 & 32) == 0) goto L21;
        r7 = new JSONObject();
    L21:
        if ((r14 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r14 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r14 & 256) == 0) goto L30;
        r10 = null;
    L30:
        if ((r14 & 512) == 0) goto L33;
        r11 = null;
    L33:
        if ((r14 & 1024) == 0) goto L36;
        r12 = null;
    L36:
        if ((r14 & 2048) == 0) goto L38;
        r13 = null;
    L38:
        a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, null);
    }

    public static final void d(String r1, String r2, String r3, String r4, String r5, JSONObject r6, by7.e r7, String r8, String r9, String r10, String r11, Integer r12, String r13) {
        Intrinsics.checkNotNullParameter(r6, "params");
        if (r1 != null) goto L45;
    L7:
        if (r2 == null) goto L9;
        r6.put("click_from", r2);     // Catch: JSONException -> L5
    L9:
        if (r3 == null) goto L11;
        r6.put("current_page", r3);     // Catch: JSONException -> L5
    L11:
        if (r4 == null) goto L13;
        r6.put("chat_type", r4);     // Catch: JSONException -> L5
    L13:
        if (r5 == null) goto L15;
        r6.put("is_immersive_background", r5);     // Catch: JSONException -> L5
    L15:
        if (r8 == null) goto L17;
        r6.put("is_call_bot", r8);     // Catch: JSONException -> L5
    L17:
        boolean r14 = true;
        if (r9 != null) goto L20;
    L22:
        boolean r15 = false;
    L23:
        if (r15 == false) goto L25;
        r6.put("recommend_from", r9);     // Catch: JSONException -> L5
    L25:
        if (r10 != null) goto L27;
    L29:
        r14 = false;
    L30:
        if (r14 == false) goto L32;
        r6.put("request_id", r10);     // Catch: JSONException -> L5
    L32:
        if (r11 == null) goto L34;
        r6.put("is_navigation_sidebar", r11);     // Catch: JSONException -> L5
    L34:
        if (r12 == null) goto L36;
        r6.put("bot_type", r12.intValue());     // Catch: JSONException -> L5
    L36:
        if (r13 == null) goto L40;
        r6.put("conversation_id", r13);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("PinEventHelper", "error in PinEventHelper pinChat " + e.getLocalizedMessage());
    L40:
        TrackParams r16 = new TrackParams().merge(r6);
        by7.a r17 = new by7.a("unpin_chat");
        if (r7 == null) goto L43;
        r17.b = r7;
    L43:
        r17.a.merge(r16);
        r17.b();
        return;
    L27:
        if (com.larus.utils.o0.d(r10) != true) goto L29;
    L20:
        if (com.larus.utils.o0.d(r9) != true) goto L22;
        r15 = true;
        goto L23
    L45:
        r6.put("bot_id", r1);     // Catch: JSONException -> L5
        goto L7
    }

    public static /* synthetic */ void e(String r2, String r3, String r4, String r5, String r6, JSONObject r7, by7.e r8, String r9, String r10, String r11, String r12, Integer r13, int r14) {
        if ((r14 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r14 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r14 & 32) == 0) goto L21;
        r7 = new JSONObject();
    L21:
        if ((r14 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r14 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r14 & 256) == 0) goto L30;
        r10 = null;
    L30:
        if ((r14 & 512) == 0) goto L33;
        r11 = null;
    L33:
        if ((r14 & 1024) == 0) goto L36;
        r12 = null;
    L36:
        if ((r14 & 2048) == 0) goto L38;
        r13 = null;
    L38:
        d(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, null);
    }
}
