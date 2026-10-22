package com.larus.voice_setting.voice.editvoice;

import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d1 {
    public static final d1 a = null;
    public static final Gson b = null;
    public static final Lazy c = null;

    public d1() {
    }

    static {
        a = new d1();
        b = new Gson();
        c = LazyKt.lazy(new c1());
    }

    public final b1 query(String r7) {
        if (r7 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        Object r1 = null;
        if (r0 == false) goto L11;
        return null;
    L11:
        com.larus.cache.f r2 = (com.larus.cache.f) c.getValue();
        if (r2 != null) goto L33;
        return null;
    L33:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L22
        com.larus.cache.f.e r4 = r2.e(r7);     // Catch: Throwable -> L22
        if (r4 != null) goto L17;
        return null;
    L17:
        String r5 = r4.a();     // Catch: Throwable -> L22
        if (r5 != null) goto L20;
        return null;
    L20:
        Object r6 = Result.constructor-impl((b1) b.fromJson(r5, b1.class));     // Catch: Throwable -> L22
    L24:
        Throwable r8 = Result.exceptionOrNull-impl(r6);
        if (r8 == null) goto L28;
        FLogger.a.e("VoicePitchAndRateRepo", "[query] key(" + r7 + ") failed", r8);
    L28:
        if (Result.isFailure-impl(r6) == true) goto L32;
        r1 = r6;
    L32:
        return (b1) r1;
    L22:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L4:
        if (r7.length() == 0) goto L7;
        r0 = false;
        goto L8
    }
}
