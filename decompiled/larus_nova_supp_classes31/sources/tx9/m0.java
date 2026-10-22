package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m0 {
    public static void c(String r2, String r3, String r4, String r5) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r2, "itemName");
        Intrinsics.checkNotNullParameter(r3, "currentStatus");
        Intrinsics.checkNotNullParameter(r4, "currentPage");
        Intrinsics.checkNotNullParameter(r0, "params");
    L16:
        e = move-exception;
        FLogger.a.e("CreationEventHelper", "error in CreationEventHelper cueBot " + e.getLocalizedMessage());
    L18:
        TrackParams r6 = new TrackParams().merge(r0);
        by7.a r7 = new by7.a("creation_function_show");
        r7.a.merge(r6);
        r7.b();
        return;
    L4:
        if (com.larus.utils.o0.d(r2) == false) goto L7;
        r0.put("item_name", r2);     // Catch: JSONException -> L16
    L7:
        if (com.larus.utils.o0.d(r3) == false) goto L10;
        r0.put("current_status", r3);     // Catch: JSONException -> L16
    L10:
        if (com.larus.utils.o0.d(r4) == false) goto L13;
        r0.put("current_page", r4);     // Catch: JSONException -> L16
    L13:
        if (com.larus.utils.o0.d(r5) == false) goto L18;
        r0.put("previous_page", r5);     // Catch: JSONException -> L16
        goto L18
    }

    public static void a(String r2, String r3, String r4, String r5, String r6, boolean r7, String r8, String r9, String r10, int r11) {
        JSONObject r1 = null;
        if ((r11 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r11 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r11 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r11 & 32) == 0) goto L21;
        r7 = false;
    L21:
        if ((r11 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r11 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r11 & 256) == 0) goto L30;
        r10 = "manual";
    L30:
        if ((r11 & 512) == 0) goto L32;
        r1 = new JSONObject();
    L32:
        Intrinsics.checkNotNullParameter(r1, "params");
    L63:
        e = move-exception;
        FLogger.a.e("CreationEventHelper", "error in CreationEventHelper cueBot " + e.getLocalizedMessage());
    L65:
        TrackParams r12 = new TrackParams().merge(r1);
        by7.a r13 = new by7.a("add_creation");
        r13.a.merge(r12);
        r13.b();
        return;
    L34:
        if (com.larus.utils.o0.d(r2) == false) goto L37;
        r1.put("message_id", r2);     // Catch: JSONException -> L63
    L37:
        if (com.larus.utils.o0.d(r3) == false) goto L40;
        r1.put("bot_id", r3);     // Catch: JSONException -> L63
    L40:
        if (com.larus.utils.o0.d(r4) == false) goto L43;
        r1.put("chat_type", r4);     // Catch: JSONException -> L63
    L43:
        if (com.larus.utils.o0.d(r5) == false) goto L46;
        r1.put("previous_page", r5);     // Catch: JSONException -> L63
    L46:
        if (com.larus.utils.o0.d(r6) == false) goto L49;
        r1.put("current_page", r6);     // Catch: JSONException -> L63
    L49:
        if (com.larus.utils.o0.d(r8) == false) goto L52;
        r1.put("creation_id", r8);     // Catch: JSONException -> L63
    L52:
        if (com.larus.utils.o0.d(r9) == false) goto L55;
        r1.put("type", r9);     // Catch: JSONException -> L63
    L55:
        if (com.larus.utils.o0.d(r10) == false) goto L58;
        r1.put("add_method", r10);     // Catch: JSONException -> L63
    L58:
        if (r7 == false) goto L60;
        String r14 = "1";
    L61:
        r1.put("success", r14);     // Catch: JSONException -> L63
        goto L65
    L60:
        r14 = "0";
        goto L61
    }

    public static void b(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, JSONObject r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r11 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r11 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r11 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r11 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r11 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r11 & 256) == 0) goto L29;
        r10 = new JSONObject();
    L29:
        Intrinsics.checkNotNullParameter(r10, "params");
        r10.putOpt("creation_id", r9);     // Catch: JSONException -> L49
        r10.putOpt("sub_type", r8);     // Catch: JSONException -> L49
        if (com.larus.utils.o0.d(r2) == false) goto L34;
        r10.put("message_id", r2);     // Catch: JSONException -> L49
    L34:
        if (com.larus.utils.o0.d(r3) == false) goto L37;
        r10.put("bot_id", r3);     // Catch: JSONException -> L49
    L37:
        if (com.larus.utils.o0.d(r4) == false) goto L40;
        r10.put("chat_type", r4);     // Catch: JSONException -> L49
    L40:
        if (com.larus.utils.o0.d(r5) == false) goto L43;
        r10.put("previous_page", r5);     // Catch: JSONException -> L49
    L43:
        if (com.larus.utils.o0.d(r6) == false) goto L46;
        r10.put("current_page", r6);     // Catch: JSONException -> L49
    L46:
        if (com.larus.utils.o0.d(r7) == false) goto L51;
        r10.put("type", r7);     // Catch: JSONException -> L49
    L51:
        TrackParams r12 = new TrackParams().merge(r10);
        by7.a r13 = new by7.a("click_add_creation");
        r13.a.merge(r12);
        r13.b();
        return;
    L49:
        e = move-exception;
        FLogger.a.e("CreationEventHelper", "error in CreationEventHelper cueBot " + e.getLocalizedMessage());
        goto L51
    }
}
