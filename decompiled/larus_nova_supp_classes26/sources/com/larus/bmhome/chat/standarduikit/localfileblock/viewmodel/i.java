package com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.larus.bmhome.utils.FileMimeTypeUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i {
    public static final Set<String> a = null;

    public static final class a {
    }

    public static final class b {
        public final Uri a;
        public final String b;
        public final List<String> c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "ResolvedLocalFile(uri=" + this.a + ", fileName=" + this.b + ", mimeTypes=" + this.c + ')';
        }

        public b(Uri r2, String r3, List<String> r4) {
            Intrinsics.checkNotNullParameter(r2, "uri");
            Intrinsics.checkNotNullParameter(r3, "fileName");
            Intrinsics.checkNotNullParameter(r4, "mimeTypes");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public i() {
    }

    static {
        a = SetsKt.setOf(new String[]{"json", "md", "xml"});
    }

    public static b b(Context r6, Uri r7, String r8) {
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        String r2 = null;
        if (StringsKt.isBlank(r8) == false) goto L38;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L29
        Cursor r3 = a(r6.getContentResolver(), r7, new String[]{"_display_name"}, null, null);     // Catch: Throwable -> L29
        if (r3 == null) goto L26;
        Cursor r4 = r3;     // Catch: Throwable -> L29
        Cursor r5 = r4;     // Catch: Throwable -> L21
        if (r5.moveToFirst() == false) goto L18;
        int r9 = r5.getColumnIndex("_display_name");     // Catch: Throwable -> L21
        if (r9 < 0) goto L18;
        String r10 = r5.getString(r9);     // Catch: Throwable -> L21
    L19:
        CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L29
    L27:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L29
    L32:
        if (Result.isFailure-impl(r11) == false) goto L34;
        r11 = null;
    L34:
        r8 = (String) r11;
        if (r8 != null) goto L38;
        r8 = "";
        goto L38
    L18:
        r10 = null;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L26:
        r10 = null;
    L29:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L38:
        if (StringsKt.isBlank(r8) == false) goto L42;
        r8 = r7.getLastPathSegment();
        if (r8 != null) goto L42;
        r8 = "";
    L42:
        String r0 = StringsKt.substringAfterLast(r8, '.', "").toLowerCase(Locale.ROOT);
        ArrayList r13 = new ArrayList();
        if (Intrinsics.areEqual(r0, "json") == false) goto L45;
        String r14 = "application/json";
    L46:
        if (r14 == null) goto L49;
        r13.add(r14);
    L49:
        if (Intrinsics.areEqual(r7.getScheme(), "content") == false) goto L70;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L52
        Object r16 = Result.constructor-impl(r6.getContentResolver().getType(r7));     // Catch: Throwable -> L52
    L55:
        if (Result.isFailure-impl(r16) == false) goto L57;
        r16 = null;
    L57:
        String r17 = (String) r16;
        if (r17 == null) goto L70;
        boolean r18 = true;
        if ((!StringsKt.isBlank(r17)) == true) goto L62;
    L64:
        r18 = false;
    L65:
        if (r18 == false) goto L67;
        r2 = r17;
    L67:
        if (r2 == null) goto L70;
        r13.add(r2);
        goto L70
    L62:
        if (Intrinsics.areEqual(r17, "*/*") == true) goto L64;
    L52:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L70:
        if (a.contains(r0) == false) goto L73;
        r13.add("text/plain");
    L73:
        return new b(r7, r8, CollectionsKt.distinct(r13));
    L45:
        r14 = FileMimeTypeUtils.c(r0);
        goto L46
    }

    public static Uri c(Context r3, File r4, String r5) {
        Object r1 = null;
        if (r4.isFile() == true) goto L15;
        return null;
    L15:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r6 = Result.constructor-impl(FileProvider.getUriForFile(r3, r3.getPackageName() + r5, r4));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r6) == true) goto L14;
        r1 = r6;
    L14:
        return (Uri) r1;
    L7:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static Cursor a(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r14, r15, r16, r17, null};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r13, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r12 = r13.query(r14, r15, r16, r17, null);
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, r12, r10, true);
        return r12;
    }
}
