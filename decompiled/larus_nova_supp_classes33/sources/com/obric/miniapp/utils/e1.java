package com.obric.miniapp.utils;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Base64;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParser;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e1 {
    public static final e1 a = null;

    static {
        a = new e1();
    }

    public e1() {
    }

    public static Drawable a(Context r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "rawPath");
        List r10 = CollectionsKt.distinct(CollectionsKt.listOf(new String[]{StringsKt.trim(r9).toString(), StringsKt.removePrefix(StringsKt.trim(r9).toString(), "file:///android_asset/"), StringsKt.removePrefix(StringsKt.removePrefix(StringsKt.trim(r9).toString(), "@assets/"), "assets/"), StringsKt.removePrefix(StringsKt.removePrefix(StringsKt.trim(r9).toString(), "@drawable/"), "drawable/")}));
        ArrayList r0 = new ArrayList();
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L19;
        String r1 = (String) r11.next();
        a.getClass();
        if ((r8.getResources().getConfiguration().uiMode & 48) != 32) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == true) goto L11;
    L17:
        List r2 = CollectionsKt.listOf(r1);
    L18:
        CollectionsKt.addAll(r0, r2);
        goto L4
    L11:
        if (StringsKt.endsWith(r1, ".svg", true) == false) goto L17;
        String r6 = new Regex("\\.svg$", RegexOption.IGNORE_CASE).replace(r1, "_dark.svg");
        if (Intrinsics.areEqual(r6, r1) == false) goto L16;
        r2 = CollectionsKt.listOf(r1);
        goto L18
    L16:
        r2 = CollectionsKt.listOf(new String[]{r6, r1});
        goto L18
    L8:
        r5 = false;
        goto L9
    L19:
        Iterator r12 = CollectionsKt.distinct(r0).iterator();
    L20:
        BitmapDrawable r3 = null;
        Object r4 = null;
        if (r12.hasNext() == false) goto L40;
        String r7 = (String) r12.next();
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L32
        InputStream r14 = r8.getAssets().open(r7);     // Catch: Throwable -> L32
        o0 r15 = f1.a(SVG.d(r14), r8);     // Catch: Throwable -> L27
        CloseableKt.closeFinally(r14, null);     // Catch: Throwable -> L32
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L32
    L35:
        if (Result.isFailure-impl(r16) == true) goto L38;
        r4 = r16;
    L38:
        r3 = (BitmapDrawable) r4;
        if (r3 == null) goto L20;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L40:
        return r3;
    }

    public static Drawable b(Context r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "rawValue");
        boolean r0 = true;
        String r14 = StringsKt.trimStart(StringsKt.trim(r13).toString(), new char[]{65279});
        Object r10 = null;
        if (StringsKt.isBlank(r14) == false) goto L6;
    L56:
        r14 = null;
    L57:
        if (r14 != null) goto L73;
        return null;
    L73:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L61
        Object r15 = Result.constructor-impl(f1.a(new SVGParser().g(new ByteArrayInputStream(r14.getBytes())), r12));     // Catch: Throwable -> L61
    L64:
        if (Result.isFailure-impl(r15) == true) goto L68;
        r10 = r15;
    L68:
        return (Drawable) r10;
    L61:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L64
    L6:
        if (StringsKt.startsWith(r14, "<svg", true) == true) goto L57;
        if (StringsKt.startsWith(r14, "<?xml", true) == false) goto L14;
        if (StringsKt.contains(r14, "<svg", true) == true) goto L57;
    L14:
        if (StringsKt.startsWith(r14, "data:", true) == false) goto L56;
        int r4 = StringsKt.indexOf$default(r14, ',', 0, false, 6, null);
        if (r4 <= 5) goto L56;
        String r5 = r14.substring(5, r4);
        if (StringsKt.contains(r5, "image/svg+xml", true) == false) goto L56;
        String r17 = r14.substring(r4 + 1);
        if (StringsKt.contains(r5, ";base64", true) == true) goto L71;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L34
        Object r18 = Result.constructor-impl(Uri.decode(r17));     // Catch: Throwable -> L34
    L37:
        if (Result.isFailure-impl(r18) == false) goto L39;
        r18 = null;
    L39:
        String r19 = (String) r18;
    L40:
        if (r19 == null) goto L44;
        String r110 = StringsKt.trim(r19).toString();
        if (r110 == null) goto L44;
        r14 = StringsKt.trimStart(r110, new char[]{65279});
    L45:
        if (r14 == null) goto L56;
        if (StringsKt.startsWith(r14, "<svg", true) == false) goto L49;
    L54:
        if (r0 == false) goto L56;
    L49:
        if (StringsKt.startsWith(r14, "<?xml", true) == true) goto L51;
    L53:
        r0 = false;
        goto L54
    L51:
        if (StringsKt.contains(r14, "<svg", true) == false) goto L53;
    L44:
        r14 = null;
    L34:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L37
    L71:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L26
        Object r111 = Result.constructor-impl(new String(Base64.decode(r17, 0), Charsets.UTF_8));     // Catch: Throwable -> L26
    L29:
        if (Result.isFailure-impl(r111) == false) goto L31;
        r111 = null;
    L31:
        r19 = (String) r111;
    L26:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r111 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    }
}
