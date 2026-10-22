package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f2 {
    public static void a(String r3, String r4) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.put("notice_category", r3);     // Catch: JSONException -> L7
        r1.put("notice_type", "number_dot");     // Catch: JSONException -> L7
        if (r4 == null) goto L9;
        r1.put("show_cnt", r4);     // Catch: JSONException -> L7
    L9:
        TrackParams r5 = new TrackParams().merge(r1);
        by7.a r6 = new by7.a("msg_notice_change");
        r6.a.merge(r5);
        r6.b();
        return;
    L7:
        e = move-exception;
        FLogger.a.e("MsgEventHelper", "error in MsgEventHelper msgNoticeChange " + e.getLocalizedMessage());
        goto L9
    }

    public static void b(String r2, String r3, String r4, int r5) {
        JSONObject r1 = null;
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r5 & 8) == 0) goto L14;
        r1 = new JSONObject();
    L14:
        Intrinsics.checkNotNullParameter(r1, "params");
        if (r2 != null) goto L27;
    L19:
        if (r3 == null) goto L21;
        r1.put("notice_type", r3);     // Catch: JSONException -> L17
    L21:
        if (r4 == null) goto L25;
        r1.put("show_cnt", r4);     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        FLogger.a.e("MsgEventHelper", "error in MsgEventHelper msgNoticeShow " + e.getLocalizedMessage());
    L25:
        TrackParams r6 = new TrackParams().merge(r1);
        by7.a r7 = new by7.a("msg_notice_show");
        r7.a.merge(r6);
        r7.b();
        return;
    L27:
        r1.put("notice_category", r2);     // Catch: JSONException -> L17
        goto L19
    }
}
