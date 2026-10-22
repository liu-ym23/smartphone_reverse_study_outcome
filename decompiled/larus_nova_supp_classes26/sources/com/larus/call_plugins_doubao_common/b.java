package com.larus.call_plugins_doubao_common;

import android.media.AudioManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final a a = null;
    public static final a b = null;
    public static final a c = null;

    static {
        Intrinsics.checkNotNullParameter("dora_appease.mp3", "fileName");
        Intrinsics.checkNotNullParameter("8e5221a2c7e863216f3151d00d59f26e", "md5");
        a = new a("switch_micro_voice.mp3", "8baf3cfcf4c9a1de73b74cfc13e92b4b", false, 3, null, 200);
        b = new a("dora_nature_comfort.mp3", "2b0b0b9c8d9da82cb5a1c0a5deb7742f", true, 3, "dora_appease_engine", 800);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(Integer.valueOf(AudioManager.class.getField("STREAM_ASSISTANT").getInt(null)));     // Catch: Throwable -> L5
    L8:
        if (Result.exceptionOrNull-impl(r1) == null) goto L11;
        r1 = 3;
    L11:
        c = new a("obric_dora_appease.mp3", "a572f45b2adb93d9b5452e6c09dc152a", true, ((Number) r1).intValue(), "o_appease_engine", 1000);
        return;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
