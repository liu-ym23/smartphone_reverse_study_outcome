package w2a;

import android.os.Bundle;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import ouc.v;
import ouc.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h {
    public static final v a = null;

    static {
        a = w.a(new g());
    }

    public static final f a(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter("mix_voice_result", "key");
        String r4 = r3.getString("mix_voice_result");
        Object r0 = null;
        if (r4 == null) goto L16;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L6
        v r2 = a;     // Catch: Throwable -> L6
        r2.getClass();     // Catch: Throwable -> L6
        Object r5 = Result.constructor-impl((f) r2.c(f.Companion.serializer(), r4));     // Catch: Throwable -> L6
    L9:
        if (Result.isFailure-impl(r5) == true) goto L13;
        r0 = r5;
    L13:
        return (f) r0;
    L6:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L16:
        return null;
    }

    public static final void b(Bundle r3, f r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter("mix_voice_result", "key");
        if (r4 == null) goto L5;
        v r0 = a;
        r0.getClass();
        String r5 = r0.a(f.Companion.serializer(), r4);
    L6:
        r3.putString("mix_voice_result", r5);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
