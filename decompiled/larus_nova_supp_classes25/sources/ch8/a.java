package ch8;

import android.content.Intent;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static b a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "rawPath");
        if (StringsKt.isBlank(r5) == false) goto L32;
        return null;
    L32:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        if (StringsKt.startsWith$default(r5, "intent:", false, 2, null) == false) goto L9;
        Uri r3 = Intent.parseUri(r5, 1).getData();     // Catch: Throwable -> L12
    L10:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r4) == false) goto L17;
        r4 = null;
    L17:
        Uri r6 = (Uri) r4;
        if (r6 != null) goto L21;
        return null;
    L21:
        if (StringsKt.equals("content", r6.getScheme(), true) == false) goto L24;
        return new b.a(r6);
    L24:
        if (StringsKt.equals("file", r6.getScheme(), true) == false) goto L29;
        String r7 = r6.getPath();
        if (r7 != null) goto L36;
        return null;
    L36:
        return new b.C0003b(new PolarisFileWrapper(r7));
    L29:
        if (r6.getScheme() == null) goto L31;
        return null;
    L31:
        return new b.C0003b(new PolarisFileWrapper(r5));
    L9:
        r3 = UriProtector.parse(r5);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }
}
