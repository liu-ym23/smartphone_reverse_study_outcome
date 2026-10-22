package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l {
    public static final String a(String r3) {
        if (r3 == null) goto L10;
        String r4 = StringsKt.substringBefore(r3, ':', "");
        if (r4 != null) goto L7;
        return null;
    L7:
        if ((!StringsKt.isBlank(r4)) == true) goto L9;
        return null;
    L9:
        return r4;
    L10:
        return null;
    }

    public static final String d(String r2) {
        if (r2 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if ((true ^ r1) == true) goto L13;
        r2 = null;
    L13:
        if (r2 != null) goto L16;
        return "0";
    L16:
        return r2;
    L5:
        if (r2.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    public static void b(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L23;
    L7:
        if (r3 == null) goto L9;
        r0.put("page_token", r3);     // Catch: Exception -> L5
    L9:
        if (r4 == null) goto L11;
        r0.put("feishu_record_generated_type", r4);     // Catch: Exception -> L5
    L11:
        if (r5 == null) goto L13;
        r0.put("message_id", r5);     // Catch: Exception -> L5
    L13:
        if (r6 == null) goto L15;
        r0.put("conversation_id", r6);     // Catch: Exception -> L5
    L15:
        r0.put("is_general_agent", d(r7));     // Catch: Exception -> L5
        if (r8 != null) goto L18;
        r8 = "";
    L18:
        r0.put("chat_id", r8);     // Catch: Exception -> L5
        r0.putOpt("record_scene", r9);     // Catch: Exception -> L5
    L21:
        TrackParams r10 = new TrackParams().merge(r0);
        by7.a r11 = new by7.a("aidoc_artifact_result_card_show");
        r11.a.merge(r10);
        r11.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("AudioRecordEventHelper", e.getMessage(), e);
        goto L21
    L23:
        r0.put("feishu_record_id", r2);     // Catch: Exception -> L5
        goto L7
    }

    public static void c(boolean r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11) {
        JSONObject r2 = new JSONObject();
        Intrinsics.checkNotNullParameter(r2, "params");
        r2.put("card_type", "feishu_record_status_card");     // Catch: Exception -> L20
        if (r5 == null) goto L6;
        r2.put("progress_status", r5);     // Catch: Exception -> L20
    L6:
        if (r4 == false) goto L8;
        String r12 = "status";
    L9:
        r2.put(r12, r6);     // Catch: Exception -> L20
        if (r7 == null) goto L12;
        r2.put("feishu_record_id", r7);     // Catch: Exception -> L20
    L12:
        if (r8 == null) goto L14;
        r2.put("bot_id", r8);     // Catch: Exception -> L20
    L14:
        if (r9 == null) goto L16;
        r2.put("message_id", r9);     // Catch: Exception -> L20
    L16:
        if (r10 == null) goto L18;
        r2.put("conversation_id", r10);     // Catch: Exception -> L20
    L18:
        r2.put("current_page", "chat");     // Catch: Exception -> L20
        r2.putOpt("record_scene", r11);     // Catch: Exception -> L20
    L22:
        TrackParams r13 = new TrackParams().merge(r2);
        if (r4 == false) goto L25;
        String r14 = "show_card";
    L26:
        by7.a r15 = new by7.a(r14);
        r15.a.merge(r13);
        r15.b();
        return;
    L25:
        r14 = "click_card";
        goto L26
    L8:
        r12 = "click_effect";
    L20:
        e = move-exception;
        FLogger.a.e("AudioRecordEventHelper", e.getMessage(), e);
        goto L22
    }
}
