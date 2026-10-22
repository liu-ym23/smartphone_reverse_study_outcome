package com.larus.browsertakeover.transport;

import java.nio.ByteBuffer;
import java.nio.charset.CodingErrorAction;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c0 {
    public static final c0 a = null;

    static {
        a = new c0();
    }

    public c0() {
    }

    public static String a(byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "bytes");
        if (r3.length != 0) goto L5;
        boolean r0 = true;
    L6:
        Object r1 = null;
        if (r0 == false) goto L9;
        return null;
    L9:
        if (r3.length > 1048576) goto L24;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        Object r4 = Result.constructor-impl(Charsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(r3)).toString());     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r4) == true) goto L20;
        r1 = r4;
    L20:
        return (String) r1;
    L13:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L24:
        return null;
    L5:
        r0 = false;
        goto L6
    }
}
