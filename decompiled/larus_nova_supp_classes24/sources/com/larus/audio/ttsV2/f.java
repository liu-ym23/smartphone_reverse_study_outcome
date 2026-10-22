package com.larus.audio.ttsV2;

import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public static boolean a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "userId");
        if (r5.length() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L22;
        FLogger.a.i("TtsBackgroundPlayLocalStore", "[contains] userId is empty");
        return false;
    L22:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        Object r0 = Result.constructor-impl(Boolean.valueOf(((Keva) m78.c.b.getValue()).contains("key_tts_play_background_".concat(r5))));     // Catch: Throwable -> L12
    L14:
        Throwable r3 = Result.exceptionOrNull-impl(r0);
        if (r3 == null) goto L17;
        FLogger.a.e("TtsBackgroundPlayLocalStore", "[contains] check failed, userId=".concat(r5), r3);
    L17:
        Boolean r6 = Boolean.FALSE;
        if (Result.isFailure-impl(r0) == false) goto L21;
        r0 = r6;
    L21:
        return ((Boolean) r0).booleanValue();
    L12:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L5:
        r1 = false;
        goto L7
    }

    public static boolean b(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "userId");
        if (r5.length() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L22;
        FLogger.a.i("TtsBackgroundPlayLocalStore", "[isEnabled] userId is empty, use defaultValue=" + r6);
        return r6;
    L22:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        Object r0 = Result.constructor-impl(Boolean.valueOf(((Keva) m78.c.b.getValue()).getBoolean("key_tts_play_background_".concat(r5), r6)));     // Catch: Throwable -> L12
    L14:
        Throwable r3 = Result.exceptionOrNull-impl(r0);
        if (r3 == null) goto L17;
        FLogger.a.e("TtsBackgroundPlayLocalStore", "[isEnabled] load failed, userId=".concat(r5), r3);
    L17:
        Boolean r7 = Boolean.valueOf(r6);
        if (Result.isFailure-impl(r0) == false) goto L21;
        r0 = r7;
    L21:
        return ((Boolean) r0).booleanValue();
    L12:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L5:
        r1 = false;
        goto L7
    }

    public static boolean c(boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "userId");
        if (r7.length() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L22;
        FLogger.a.i("TtsBackgroundPlayLocalStore", "[setEnabled] userId is empty, skip");
        return false;
    L22:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        ((Keva) m78.c.b.getValue()).storeBoolean("key_tts_play_background_".concat(r7), r6);     // Catch: Throwable -> L12
        Object r0 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L12
    L14:
        Throwable r3 = Result.exceptionOrNull-impl(r0);
        if (r3 == null) goto L17;
        FLogger.a.e("TtsBackgroundPlayLocalStore", "[setEnabled] save failed, userId=" + r7 + ", enabled=" + r6, r3);
    L17:
        Boolean r8 = Boolean.FALSE;
        if (Result.isFailure-impl(r0) == false) goto L21;
        r0 = r8;
    L21:
        return ((Boolean) r0).booleanValue();
    L12:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L5:
        r1 = false;
        goto L7
    }
}
