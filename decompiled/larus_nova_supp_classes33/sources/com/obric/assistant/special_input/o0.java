package com.obric.assistant.special_input;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class o0 {
    public static final o0 a = null;
    public static final long b = 0;
    public static final Lazy c = null;
    public static final Lazy d = null;

    public o0() {
    }

    static {
        a = new o0();
        b = TimeUnit.DAYS.toMillis(30);
        c = LazyKt.lazy(new m0());
        d = LazyKt.lazy(new n0());
    }

    public static void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        if (StringsKt.isBlank(r4) == false) goto L13;
        return;
    L13:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        ((Keva) d.getValue()).erase("draft_" + r4);     // Catch: Throwable -> L7
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L15;
        FLogger.a.w("PhoneAttachmentDraftStore", "clear failed, conversationId=" + r4, r2);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public static k0 b(String r7) {
        Intrinsics.checkNotNullParameter(r7, "conversationId");
        if (StringsKt.isBlank(r7) == false) goto L41;
        return null;
    L41:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L18
        String r1 = ((Keva) d.getValue()).getString("draft_" + r7, "");     // Catch: Throwable -> L18
        if (r1 != null) goto L8;
    L15:
        k0 r2 = null;
    L16:
        Object r3 = Result.constructor-impl(r2);     // Catch: Throwable -> L18
    L20:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L24;
        FLogger.a.w("PhoneAttachmentDraftStore", "get failed, conversationId=" + r7, r4);
    L24:
        if (Result.isFailure-impl(r3) == false) goto L26;
        r3 = null;
    L26:
        k0 r5 = (k0) r3;
        if (r5 != null) goto L29;
    L39:
        a(r7);
        return null;
    L29:
        if (r5.a == false) goto L39;
        if (r5.e > 0) goto L34;
    L37:
        a(r7);
        return null;
    L34:
        if ((System.currentTimeMillis() - r5.e) >= b) goto L37;
        return r5;
    L8:
        if ((!StringsKt.isBlank(r1)) == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L15;
        l0 r6 = (l0) ((Gson) c.getValue()).fromJson(r1, l0.class);     // Catch: Throwable -> L18
        if (r6 == null) goto L15;
        r2 = r6.a();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }
}
