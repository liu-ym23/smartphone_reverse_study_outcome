package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class r2 {
    public static void a(String r3, Integer r4, Integer r5, Integer r6, String r7, String r8, String r9, JSONObject r10, by7.e r11, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r5 = 0;
    L12:
        if ((r12 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r12 & 16) == 0) goto L18;
        r7 = null;
    L18:
        if ((r12 & 32) == 0) goto L21;
        r8 = null;
    L21:
        if ((r12 & 64) == 0) goto L24;
        r9 = null;
    L24:
        if ((r12 & 4096) == 0) goto L27;
        r10 = new JSONObject();
    L27:
        if ((r12 & 8192) == 0) goto L29;
        r11 = null;
    L29:
        Intrinsics.checkNotNullParameter(r10, "params");
        if (r3 != null) goto L53;
    L34:
        if (r4 == null) goto L36;
        r10.put("file_cnt", r4.intValue());     // Catch: Exception -> L32
    L36:
        if (r5 == null) goto L38;
        r10.put("pic_cnt", r5.intValue());     // Catch: Exception -> L32
    L38:
        if (r6 == null) goto L40;
        r10.put("is_multi_file", r6.intValue());     // Catch: Exception -> L32
    L40:
        if (r7 == null) goto L42;
        r10.put("chat_type", r7);     // Catch: Exception -> L32
    L42:
        if (r8 == null) goto L44;
        r10.put("conversation_id", r8);     // Catch: Exception -> L32
    L44:
        if (r9 == null) goto L48;
        r10.put("message_type", r9);     // Catch: Exception -> L32
    L32:
        e = move-exception;
        FLogger.a.e("PasteContentEventHelper", "error in PasteContentEventHelper " + e.getLocalizedMessage());
    L48:
        TrackParams r13 = new TrackParams().merge(r10);
        by7.a r14 = new by7.a("paste_content");
        if (r11 == null) goto L51;
        r14.b = r11;
    L51:
        r14.a.merge(r13);
        r14.b();
        return;
    L53:
        r10.put("bot_id", r3);     // Catch: Exception -> L32
        goto L34
    }
}
