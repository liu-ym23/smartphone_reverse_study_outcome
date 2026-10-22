package com.larus.audio.utils;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class l1 {
    public static long a;
    public static long b;
    public static long c;
    public static long d;
    public static boolean e;
    public static boolean f;
    public static String g;
    public static String h;
    public static String i;

    static {
        a = -1;
        b = -1;
        c = -1;
        d = -1;
    }

    public static void b() {
        if (a != (-1)) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis();
        long r4 = a;
        long r6 = r0 - r4;
        long r8 = b;
        if (r8 != (-1)) goto L8;
        return;
    L8:
        if (r8 < r4) goto L81;
        long r5 = r8 - r4;
        boolean r10 = e;
        long r11 = 0;
        if (r10 == true) goto L13;
        long r13 = 0;
    L31:
        boolean r15 = f;
        if (r15 == true) goto L40;
        long r16 = c;
        if (r16 != (-1)) goto L36;
        return;
    L36:
        if (r16 < r8) goto L79;
        long r17 = r16 - r8;
    L41:
        if (r10 == false) goto L43;
        long r2 = d;
    L46:
        long r1 = r0 - r2;
    L47:
        if (r15 == false) goto L49;
        r11 = 1;
    L49:
        String r3 = h;
        String r7 = g;
        String r9 = i;
        Long r12 = Long.valueOf(r6);
        Long r14 = Long.valueOf(r11);
        Long r19 = Long.valueOf(r5);
        Long r20 = Long.valueOf(r17);
        Long r21 = Long.valueOf(r1);
        Long r22 = Long.valueOf(r13);
        JSONObject r23 = new JSONObject();
        Intrinsics.checkNotNullParameter(r23, "params");
        if (r3 != null) goto L74;
    L54:
        if (r12 == null) goto L56;
        r23.put("total", r12.longValue());     // Catch: JSONException -> L52
    L56:
        if (r14 == null) goto L58;
        r23.put("is_hit_cache", r14.longValue());     // Catch: JSONException -> L52
    L58:
        if (r19 == null) goto L60;
        r23.put("request_media", r19.longValue());     // Catch: JSONException -> L52
    L60:
        if (r20 == null) goto L62;
        r23.put("download", r20.longValue());     // Catch: JSONException -> L52
    L62:
        if (r21 == null) goto L64;
        r23.put("play_delay", r21.longValue());     // Catch: JSONException -> L52
    L64:
        if (r22 == null) goto L66;
        r23.put("pitch_speech_process", r22.longValue());     // Catch: JSONException -> L52
    L66:
        if (r7 == null) goto L68;
        r23.put("speaker_id", r7);     // Catch: JSONException -> L52
    L68:
        if (r9 == null) goto L72;
        r23.put("speaker_name", r9);     // Catch: JSONException -> L52
    L52:
        e = move-exception;
        FLogger.a.e("VoiceEventHelper", "error in VoiceEventHelper mobVoiceAuditionDuration " + e.getLocalizedMessage());
    L72:
        TrackParams r24 = new TrackParams().merge(r23);
        by7.a r25 = new by7.a("voice_audition_duration");
        r25.a.merge(r24);
        r25.b();
        return;
    L74:
        r23.put("voice_id", r3);     // Catch: JSONException -> L52
        goto L54
    L43:
        if (r15 == false) goto L45;
        r1 = r0 - r8;
        goto L47
    L45:
        r2 = c;
        goto L46
    L79:
        return;
    L40:
        r17 = 0;
        goto L41
    L13:
        if (f == false) goto L21;
        long r110 = d;
        if (r110 != (-1)) goto L17;
        return;
    L17:
        if (r110 < r8) goto L76;
        r13 = r110 - r8;
        goto L31
    L76:
        return;
    L21:
        long r111 = d;
        if (r111 == (-1)) goto L29;
        long r112 = c;
        if (r112 != (-1)) goto L26;
        return;
    L26:
        if (r111 < r112) goto L78;
        r13 = r111 - r112;
        goto L31
    L78:
        return;
    L29:
        return;
    }

    public static void c() {
        a = -1;
        b = -1;
        c = -1;
        d = -1;
        e = false;
        f = false;
        i = null;
        g = null;
        h = null;
    }

    public static void a(boolean r2) {
        if (r2 == false) goto L4;
        b = System.currentTimeMillis();
        return;
    L4:
        c();
    }
}
