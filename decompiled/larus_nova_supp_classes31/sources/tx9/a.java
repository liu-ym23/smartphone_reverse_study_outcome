package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static void a(String r4, String r5, Integer r6, String r7, Integer r8, String r9, String r10, String r11, String r12, String r13) {
        JSONObject r2 = new JSONObject();
        Intrinsics.checkNotNullParameter(r2, "params");
        if (r4 != null) goto L29;
    L7:
        if (r5 == null) goto L9;
        r2.put("resource_id", r5);     // Catch: JSONException -> L5
    L9:
        if (r6 == null) goto L11;
        r2.put("resource_type", r6.intValue());     // Catch: JSONException -> L5
    L11:
        if (r7 == null) goto L13;
        r2.put("artifact_meta_id", r7);     // Catch: JSONException -> L5
    L13:
        if (r8 == null) goto L15;
        r2.put("artifact_type", r8.intValue());     // Catch: JSONException -> L5
    L15:
        if (r9 == null) goto L17;
        r2.put("aippt_task_id", r9);     // Catch: JSONException -> L5
    L17:
        r2.put("current_page", "aippt_new_detail");     // Catch: JSONException -> L5
        if (r10 == null) goto L20;
        r2.put("conversation_id", r10);     // Catch: JSONException -> L5
    L20:
        if (r11 == null) goto L22;
        r2.put("bot_id", r11);     // Catch: JSONException -> L5
    L22:
        if (r12 == null) goto L24;
        r2.put("message_id", r12);     // Catch: JSONException -> L5
    L24:
        r2.put("canvas_type", "aippt_new");     // Catch: JSONException -> L5
        r2.put("button_name", r13);     // Catch: JSONException -> L5
    L27:
        TrackParams r14 = new TrackParams().merge(r2);
        by7.a r15 = new by7.a("aippt_picture_selection_board_click");
        r15.a.merge(r14);
        r15.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("AIPPTGenerateImageHelper", "error in AIPPTGenerateImageHelper mobAIPPTPictureSelectionBoardClick " + e.getLocalizedMessage());
        goto L27
    L29:
        r2.put("presentation_id", r4);     // Catch: JSONException -> L5
        goto L7
    }
}
