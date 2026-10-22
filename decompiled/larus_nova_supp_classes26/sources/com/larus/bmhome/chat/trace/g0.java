package com.larus.bmhome.chat.trace;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g0 {
    public static String a;
    public static String b;
    public static String c;
    public static long d;

    static {
    }

    public static void a(boolean r8, long r9) {
        long r0 = System.currentTimeMillis() - d;
        if (r8 == false) goto L5;
        String r10 = ReeditType.IMAGE;
    L6:
        float r11 = r9 / 1024.0f;
        String r12 = a;
        String r2 = b;
        String r3 = c;
        JSONObject r4 = new JSONObject();
        Intrinsics.checkNotNullParameter(r4, "params");
        if (r12 == null) goto L12;
        r4.put("click_from", r12);     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        FLogger.a.e("UploadEventHelper", "error in UploadEventHelper clickCamera " + e.getLocalizedMessage());
    L24:
        TrackParams r13 = new TrackParams().merge(r4);
        by7.a r14 = new by7.a("upload_duration");
        r14.a.merge(r13);
        r14.b();
        a = null;
        b = null;
        c = null;
        d = 0;
        return;
    L12:
        if (r0 <= 0) goto L15;
        r4.put("duration", r0);     // Catch: JSONException -> L9
    L15:
        if (r11 <= 0.0f) goto L17;
        r4.put("size", Float.valueOf(r11));     // Catch: JSONException -> L9
    L17:
        r4.put("type", r10);     // Catch: JSONException -> L9
        if (r2 == null) goto L20;
        r4.put("action_bar_template_id", r2);     // Catch: JSONException -> L9
    L20:
        if (r3 == null) goto L24;
        r4.put("action_bar_template_type", r3);     // Catch: JSONException -> L9
        goto L24
    L5:
        r10 = ShareType.FILE;
        goto L6
    }
}
