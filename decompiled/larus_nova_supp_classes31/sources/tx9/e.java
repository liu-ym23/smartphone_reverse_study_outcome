package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.trace.CopyContentTypeString;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public static void a(String r2, String r3, int r4) {
        JSONObject r1 = null;
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r1 = new JSONObject();
    L11:
        Intrinsics.checkNotNullParameter(r1, "params");
        if (r2 != null) goto L22;
    L16:
        if (r3 == null) goto L20;
        r1.put("age_verification_type", r3);     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        FLogger.a.e("AgeEventHelper", "error in AgeEventHelper ageBlockLoginWindowShow " + e.getLocalizedMessage());
    L20:
        TrackParams r5 = new TrackParams().merge(r1);
        by7.a r6 = new by7.a("age_block_login_window_show");
        r6.a.merge(r5);
        r6.b();
        return;
    L22:
        r1.put("type", r2);     // Catch: JSONException -> L14
        goto L16
    }

    public static void b(long r1, int r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = -1;
    L9:
        if ((r4 & 4) == 0) goto L11;
        JSONObject r5 = new JSONObject();
    L12:
        Intrinsics.checkNotNullParameter(r5, "params");
        r5.put(CopyContentTypeString.CODE, r1);     // Catch: JSONException -> L15
        r5.put("decision", r3);     // Catch: JSONException -> L15
    L17:
        TrackParams r2 = new TrackParams().merge(r5);
        by7.a r6 = new by7.a("age_check_result");
        r6.a.merge(r2);
        r6.b();
        return;
    L15:
        e = move-exception;
        FLogger.a.e("AgeEventHelper", "error in AgeEventHelper mobAgeCheckResult " + e.getLocalizedMessage());
        goto L17
    L11:
        r5 = null;
        goto L12
    }

    public static void c(String r2, String r3, String r4, String r5, int r6) {
        JSONObject r1 = null;
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r6 & 16) == 0) goto L17;
        r1 = new JSONObject();
    L17:
        Intrinsics.checkNotNullParameter(r1, "params");
        if (r2 != null) goto L32;
    L22:
        if (r3 == null) goto L24;
        r1.put("type", r3);     // Catch: JSONException -> L20
    L24:
        if (r4 == null) goto L26;
        r1.put("age_verification_type", r4);     // Catch: JSONException -> L20
    L26:
        if (r5 == null) goto L30;
        r1.put("page_hierarchy", r5);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        FLogger.a.e("AgeEventHelper", "error in AgeEventHelper ageVerificationWindowClick " + e.getLocalizedMessage());
    L30:
        TrackParams r7 = new TrackParams().merge(r1);
        by7.a r8 = new by7.a("age_verification_window_click");
        r8.a.merge(r7);
        r8.b();
        return;
    L32:
        r1.put("click_from", r2);     // Catch: JSONException -> L20
        goto L22
    }

    public static void d(String r2, String r3, String r4, String r5, int r6) {
        JSONObject r1 = null;
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r6 & 16) == 0) goto L17;
        r1 = new JSONObject();
    L17:
        Intrinsics.checkNotNullParameter(r1, "params");
        if (r3 != null) goto L32;
    L22:
        if (r2 == null) goto L24;
        r1.put("type", r2);     // Catch: JSONException -> L20
    L24:
        if (r4 == null) goto L26;
        r1.put("age_verification_type", r4);     // Catch: JSONException -> L20
    L26:
        if (r5 == null) goto L30;
        r1.put("page_hierarchy", r5);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        FLogger.a.e("AgeEventHelper", "error in AgeEventHelper ageVerificationWindowShow " + e.getLocalizedMessage());
    L30:
        TrackParams r7 = new TrackParams().merge(r1);
        by7.a r8 = new by7.a("age_verification_window_show");
        r8.a.merge(r7);
        r8.b();
        return;
    L32:
        r1.put("current_page", r3);     // Catch: JSONException -> L20
        goto L22
    }
}
