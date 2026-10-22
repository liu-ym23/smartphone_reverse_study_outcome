package m58;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import c68.b;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class y {
    public static final y a = null;

    static {
        a = new y();
    }

    public y() {
    }

    public static int c() {
        p r0 = h.o;
        if (r0 == null) goto L7;
        Integer r1 = r0.c();
        if (r1 == null) goto L7;
        return r1.intValue();
    L7:
        return 3;
    }

    public static String e(Context r5) {
        JSONObject r0 = new JSONObject();
        r0.put("currentMusicVolume", d(r5, 3, false));
        r0.put("maxMusicVolume", d(r5, 3, true));
        r0.put("currentSystemVolume", d(r5, 1, false));
        r0.put("maxSystemVolume", d(r5, 1, true));
        r0.put("currentVoiceCallVolume", d(r5, 0, false));
        r0.put("maxVoiceCallVolume", d(r5, 0, true));
        return r0.toString();
    }

    public final boolean a(Context r6) {
        Integer r0 = b(r6);
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        if (r6 == null) goto L8;
        Object r7 = r6.getSystemService("audio");
    L9:
        AudioManager r8 = (AudioManager) r7;
        if (Build.VERSION.SDK_INT >= 28) goto L30;
        int r9 = 0;
    L27:
        if (r1 != r9) goto L32;
        return true;
    L32:
        return false;
    L30:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L17
        if (r8 == null) goto L14;
        int r10 = r8.getStreamMinVolume(3);     // Catch: Throwable -> L17
    L15:
        Object r11 = Result.constructor-impl(Integer.valueOf(r10));     // Catch: Throwable -> L17
    L19:
        Throwable r3 = Result.exceptionOrNull-impl(r11);
        if (r3 == null) goto L23;
        int r4 = b.a;
        b.c("VolumeUtils", "getMinStreamMusicVolume: error " + r3.getMessage(), r3);
    L23:
        if (Result.isFailure-impl(r11) == false) goto L25;
        r11 = 0;
    L25:
        r9 = ((Number) r11).intValue();
        goto L27
    L14:
        r10 = 0;
    L17:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L8:
        r7 = null;
        goto L9
    L5:
        r1 = 0;
        goto L6
    }

    public final synchronized Integer b(Context r3) {
        monitor-enter(this);
        Integer r0 = null;
        if (r3 != null) goto L16;
        Object r4 = null;
    L9:
        AudioManager r5 = (AudioManager) r4;     // Catch: Throwable -> L6
        if (r5 == null) goto L12;
        r0 = Integer.valueOf(r5.getStreamVolume(c()));     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    L12:
        monitor-exit(this);
        return r0;
    L16:
        r4 = r3.getSystemService("audio");     // Catch: Throwable -> L6
        goto L9
    }

    public final synchronized boolean f(Context r2) {
        monitor-enter(this);
        if (r2 != null) goto L18;
        Object r3 = null;
    L8:
        AudioManager r4 = (AudioManager) r3;     // Catch: Throwable -> L5
        if (r4 == null) goto L13;
        if (r4.getStreamVolume(c()) != 0) goto L13;
        boolean r5 = true;
    L14:
        monitor-exit(this);
        return r5;
    L5:
        th = move-exception;
        throw th;
    L13:
        r5 = false;
        goto L14
    L18:
        r3 = r2.getSystemService("audio");     // Catch: Throwable -> L5
        goto L8
    }

    public static Integer d(Context r2, int r3, boolean r4) {
        if (r2 == null) goto L5;
        Object r5 = r2.getSystemService("audio");
    L6:
        AudioManager r6 = (AudioManager) r5;
        if (r4 == false) goto L11;
        if (r6 != null) goto L10;
        return null;
    L10:
        return Integer.valueOf(r6.getStreamMaxVolume(r3));
    L11:
        if (r6 != null) goto L13;
        return null;
    L13:
        return Integer.valueOf(r6.getStreamVolume(r3));
    L5:
        r5 = null;
        goto L6
    }
}
