package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class t3 {
    public static void a(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, Integer r11, String r12, String r13, JSONObject r14, int r15) {
        if ((r15 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r15 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r15 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r15 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r15 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r15 & 256) == 0) goto L30;
        r10 = null;
    L30:
        if ((r15 & 512) == 0) goto L33;
        r11 = null;
    L33:
        if ((r15 & 1024) == 0) goto L36;
        r12 = null;
    L36:
        if ((r15 & 2048) == 0) goto L39;
        r13 = null;
    L39:
        if ((r15 & 4096) == 0) goto L41;
        r14 = new JSONObject();
    L41:
        Intrinsics.checkNotNullParameter(r14, "params");
        if (r2 != null) goto L72;
    L46:
        if (r3 == null) goto L48;
        r14.put("show_way", r3);     // Catch: JSONException -> L44
    L48:
        if (r4 == null) goto L50;
        r14.put("tab_name", r4);     // Catch: JSONException -> L44
    L50:
        if (r5 == null) goto L52;
        r14.put("chat_type", r5);     // Catch: JSONException -> L44
    L52:
        if (r6 == null) goto L54;
        r14.put("title", r6);     // Catch: JSONException -> L44
    L54:
        if (r7 == null) goto L56;
        r14.put("prompt_type", r7);     // Catch: JSONException -> L44
    L56:
        if (r8 == null) goto L58;
        r14.put("prompt_position", r8);     // Catch: JSONException -> L44
    L58:
        if (r9 == null) goto L60;
        r14.put("prompt_position_row", r9);     // Catch: JSONException -> L44
    L60:
        if (r10 == null) goto L62;
        r14.put("show_scene", r10);     // Catch: JSONException -> L44
    L62:
        if (r11 == null) goto L64;
        r14.put("attachment_cnt", r11.intValue());     // Catch: JSONException -> L44
    L64:
        if (r12 == null) goto L66;
        r14.put("bot_id", r12);     // Catch: JSONException -> L44
    L66:
        if (r13 == null) goto L70;
        r14.put("click_from", r13);     // Catch: JSONException -> L44
    L44:
        e = move-exception;
        FLogger.a.e("SuggestedActionEventHelper", "error in SuggestedActionEventHelper mobAttachmentSuggestPromptClick " + e.getLocalizedMessage());
    L70:
        TrackParams r16 = new TrackParams().merge(r14);
        by7.a r17 = new by7.a("attachment_suggest_prompt_click");
        r17.a.merge(r16);
        r17.b();
        return;
    L72:
        r14.put("current_page", r2);     // Catch: JSONException -> L44
        goto L46
    }

    public static void b(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, Integer r11, String r12, String r13, JSONObject r14, int r15) {
        if ((r15 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r15 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r15 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r15 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r15 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r15 & 256) == 0) goto L30;
        r10 = null;
    L30:
        if ((r15 & 512) == 0) goto L33;
        r11 = null;
    L33:
        if ((r15 & 1024) == 0) goto L36;
        r12 = null;
    L36:
        if ((r15 & 2048) == 0) goto L39;
        r13 = null;
    L39:
        if ((r15 & 4096) == 0) goto L41;
        r14 = new JSONObject();
    L41:
        Intrinsics.checkNotNullParameter(r14, "params");
        if (r2 != null) goto L80;
    L46:
        if (r3 == null) goto L48;
        r14.put("show_way", r3);     // Catch: JSONException -> L44
    L48:
        if (r4 == null) goto L50;
        r14.put("tab_name", r4);     // Catch: JSONException -> L44
    L50:
        if (r5 == null) goto L52;
        r14.put("chat_type", r5);     // Catch: JSONException -> L44
    L52:
        if (r6 == null) goto L54;
        r14.put("title", r6);     // Catch: JSONException -> L44
    L54:
        if (r7 == null) goto L56;
        r14.put("prompt_type", r7);     // Catch: JSONException -> L44
    L56:
        if (r8 == null) goto L58;
        r14.put("prompt_position", r8);     // Catch: JSONException -> L44
    L58:
        if (r9 == null) goto L60;
        r14.put("prompt_position_row", r9);     // Catch: JSONException -> L44
    L60:
        if (r10 == null) goto L62;
        r14.put("show_scene", r10);     // Catch: JSONException -> L44
    L62:
        if (r11 == null) goto L64;
        r14.put("attachment_cnt", r11.intValue());     // Catch: JSONException -> L44
    L64:
        if (r12 == null) goto L66;
        r14.put("bot_id", r12);     // Catch: JSONException -> L44
    L66:
        if (r13 == null) goto L70;
        r14.put("click_from", r13);     // Catch: JSONException -> L44
    L44:
        e = move-exception;
        FLogger.a.e("SuggestedActionEventHelper", "error in SuggestedActionEventHelper mobAttachmentSuggestPromptShow " + e.getLocalizedMessage());
    L70:
        TrackParams r16 = new TrackParams().merge(r14);
        by7.a r17 = new by7.a("attachment_suggest_prompt_show");
        r17.a.merge(r16);
        r17.b();
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L73
        com.larus.platform.service.g.a.monitorEventForSlardar("attachment_suggest_prompt_show", r14, null, null);     // Catch: Throwable -> L73
        Object r19 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L73
    L75:
        Throwable r20 = Result.exceptionOrNull-impl(r19);
        if (r20 == null) goto L84;
        FLogger.a.e("SuggestedActionEventHelper", "slardar report error, attachmentSuggestPromptShow " + r20.getLocalizedMessage());
        return;
    L84:
        return;
    L73:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L75
    L80:
        r14.put("current_page", r2);     // Catch: JSONException -> L44
        goto L46
    }
}
