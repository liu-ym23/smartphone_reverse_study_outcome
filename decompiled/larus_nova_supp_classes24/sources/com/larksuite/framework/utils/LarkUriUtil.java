package com.larksuite.framework.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import f06.b;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LarkUriUtil {
    public static final LarkUriUtil a = null;
    public static final Function2<Cursor, Integer, String> b = null;
    public static final Function2<Cursor, Integer, Long> c = null;
    public static final a<String> d = null;
    public static final a<Long> e = null;
    public static final a<Long> f = null;
    public static final a<String> g = null;

    public static final class a<T> {
        public final String a;
        public final Function2<Cursor, Integer, T> b;
        public final String c;

        public a() {
            throw null;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
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
            return "Query(projection=" + this.a + ", result=" + this.b + ", column=" + this.c + ')';
        }

        public final T a(Cursor r3) {
            Intrinsics.checkNotNullParameter(r3, "cursor");
            int r0 = r3.getColumnIndex(this.c);
            if (r0 >= 0) goto L5;
            return null;
        L5:
            if (r3.isNull(r0) == false) goto L7;
            return null;
        L7:
            return (T) this.b.invoke(r3, Integer.valueOf(r0));
        }

        public a(String r2, Function2 r3) {
            Intrinsics.checkNotNullParameter(r2, "projection");
            Intrinsics.checkNotNullParameter(r3, "result");
            Intrinsics.checkNotNullParameter(r2, "column");
            this.a = r2;
            this.b = r3;
            this.c = r2;
        }
    }

    public LarkUriUtil() {
    }

    static {
        a = new LarkUriUtil();
        LarkUriUtil$GET_STRING$1 r0 = LarkUriUtil$GET_STRING$1.INSTANCE;
        b = r0;
        LarkUriUtil$GET_LONG$1 r1 = LarkUriUtil$GET_LONG$1.INSTANCE;
        c = r1;
        d = new a("_display_name", r0);
        e = new a("_size", r1);
        f = new a("date_modified", r1);
        g = new a("_data", r0);
    }

    @JvmStatic
    public static final String f(Cursor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r0 = d.a(r1);
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r2 = g.a(r1);
        if (r2 != null) goto L8;
        return null;
    L8:
        return new PolarisFileWrapper(r2).getName();
    }

    @JvmStatic
    public static final long i(Cursor r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Long r3 = e.a(r2);
        if (r3 != null) goto L7;
        return 0;
    L7:
        return r3.longValue();
    }

    public static ParcelFileDescriptor a(ContentResolver r20, Uri r21) {
        ArrayList r1 = new ArrayList();
        Object[] r2 = {r21, "r"};
        b r13 = new b();
        g06.a r3 = (g06.a) ApiHookConfig.b.get(240020);
        if (r3 == null) goto L5;
        f06.a[] r4 = r3.i;
    L6:
        f06.a[] r10 = r4;
        int r9 = r10.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r10[r8];
        int r17 = r8;
        int r19 = r9;
        f06.a[] r110 = r10;
        f06.d r5 = r7.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r20, r2, "android.os.ParcelFileDescriptor", r13);     // Catch: Exception -> L22
        if (r5.a == true) goto L17;
        r1.add(r7);     // Catch: Exception -> L22
    L17:
        if (r5.a == false) goto L21;
        return (ParcelFileDescriptor) r5.b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r20, r21, "r");
    L14:
        r8 = r17 + 1;
        r9 = r19;
        r10 = r110;
        goto L8
    L15:
        r5 = new f06.d(false, null);
        goto L17
    L5:
        r4 = ApiHookConfig.d;
        goto L6
    }

    public static Cursor b(ContentResolver r12, Uri r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, null, null, null, null};
        b r10 = new b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r14 = r12.query(r13, null, null, null, null);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r14, r10, true);
        return r14;
    }

    public static PolarisFileWrapper c(Context r2, Uri r3) {
        PolarisFileWrapper r4 = m0.b(r2, r3, false);
        if (r4 != null) goto L11;
    L9:
        Log.e("LarkUriUtil", "Failed to convert uri: " + r3 + " to file, or file does not exists");
        return null;
    L11:
        if (r4.exists() == false) goto L9;
        return r4;
    L7:
        e = move-exception;
        Log.e("LarkUriUtil", e.getMessage());
        goto L9
    }

    public static Cursor d(Context r4, Uri r5) {
        Cursor r6 = b(r4.getContentResolver(), r5);     // Catch: Exception -> L12
        if (r6 != null) goto L6;
        Log.w("LarkUriUtil", "failed to get cursor for uri: " + r5);     // Catch: Exception -> L12
        return null;
    L6:
        if (r6.moveToFirst() == true) goto L27;
        r6.close();     // Catch: Exception -> L23
    L9:
        Log.w("LarkUriUtil", "cannot move cursor to first for uri: " + r5);     // Catch: Exception -> L12
        return null;
    L27:
        return r6;
    L12:
        e = move-exception;
        if ((e instanceof IllegalArgumentException) == false) goto L16;
    L21:
        Log.w("LarkUriUtil", e + " caught");
    L22:
        return null;
    L16:
        if ((e instanceof SecurityException) == true) goto L21;
        if ((e instanceof UnsupportedOperationException) == true) goto L21;
        Log.e("LarkUriUtil", "unknown exception: " + e);
        goto L22
    }

    @JvmStatic
    public static final String e(Context r3, Uri r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "uri");
        Cursor r0 = d(r3, r4);
        if (r0 == null) goto L5;
        String r2 = f(r0);
    L6:
        if (r0 != null) goto L17;
    L10:
        if (r2 != null) goto L16;
        PolarisFileWrapper r5 = c(r3, r4);
        if (r5 != null) goto L19;
        Log.e("LarkUriUtil", "failed to get filename from uri");
        return null;
    L19:
        return r5.getName();
    L16:
        return r2;
    L17:
        r0.close();     // Catch: Exception -> L9
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @JvmStatic
    public static final Pair<String, Long> g(Context r4, Uri r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "uri");
        Cursor r0 = d(r4, r5);
        if (r0 == null) goto L19;
        Cursor r1 = r0;
        Cursor r2 = r1;     // Catch: Throwable -> L14
        if (r2.moveToFirst() == false) goto L12;
        String r3 = f(r2);     // Catch: Throwable -> L14
        if (r3 == null) goto L12;
        Pair<String, Long> r6 = TuplesKt.to(r3, Long.valueOf(i(r2)));     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r1, null);
        return r6;
    L12:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r1, null);
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    L19:
        String r8 = e(r4, r5);
        long r9 = h(r4, r5);
        if (r8 != null) goto L22;
        Log.e("LarkUriUtil", "failed to get filename and size");
        return null;
    L22:
        return TuplesKt.to(r8, Long.valueOf(r9));
    }

    @JvmStatic
    public static final long h(Context r3, Uri r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "uri");
        Cursor r0 = d(r3, r4);
        if (r0 == null) goto L5;
        Long r1 = Long.valueOf(i(r0));
    L6:
        if (r0 != null) goto L17;
    L10:
        if (r1 != null) goto L16;
        PolarisFileWrapper r5 = c(r3, r4);
        if (r5 != null) goto L19;
        Log.e("LarkUriUtil", "failed to get file size from uri");
        return 0;
    L19:
        return r5.length();
    L16:
        return r1.longValue();
    L17:
        r0.close();     // Catch: Exception -> L9
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @JvmStatic
    public static final long j(ContentResolver r9, Uri r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "uri");
        int r0 = Build.VERSION.SDK_INT;
        if (r0 != 24) goto L5;
    L52:
        ParcelFileDescriptor r1 = a(r9, r10);     // Catch: Exception -> L37
        if (r1 == null) goto L66;
        long r2 = r1.getStatSize();     // Catch: Throwable -> L32
        if (r2 == (-1)) goto L29;
        CloseableKt.closeFinally(r1, null);     // Catch: Exception -> L37
        return r2;
    L29:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L32
        CloseableKt.closeFinally(r1, null);     // Catch: Exception -> L37
        goto L66
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);     // Catch: Exception -> L37
        throw th;     // Catch: Exception -> L37
    L66:
        InputStream r11 = ContentResolverWrapper.openInputStream(r9, r10);     // Catch: Exception -> L49
        if (r11 == null) goto L67;
        long r4 = r11.available();     // Catch: Throwable -> L44
        CloseableKt.closeFinally(r11, null);     // Catch: Exception -> L49
        return r4;
    L44:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);     // Catch: Exception -> L49
        throw th;     // Catch: Exception -> L49
    L67:
        return 0;
    L49:
        Log.e("LarkUriUtil", "Unexpected Exception Caught for " + r10);
        return 0;
    L37:
        Log.e("LarkUriUtil", "Unexpected Exception Caught for " + r10);
        goto L66
    L5:
        if (r0 == 25) goto L52;
        AssetFileDescriptor r5 = ContentResolverWrapper.openAssetFileDescriptor(r9, r10, "r");     // Catch: Exception -> L21
        if (r5 == null) goto L52;
        long r6 = r5.getDeclaredLength();     // Catch: Throwable -> L16
        if (r6 == (-1)) goto L13;
        CloseableKt.closeFinally(r5, null);     // Catch: Exception -> L21
        return r6;
    L13:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r5, null);     // Catch: Exception -> L21
        goto L52
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);     // Catch: Exception -> L21
        throw th;     // Catch: Exception -> L21
    L21:
        Log.e("LarkUriUtil", "Unexpected Exception Caught for " + r10);
        Unit r8 = Unit.INSTANCE;
        goto L52
    }

    @JvmStatic
    public static final Long k(Context r2, Uri r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "uri");
        Long r0 = (Long) a.query(r2, r3, f);
        if (r0 != null) goto L10;
        PolarisFileWrapper r4 = c(r2, r3);
        if (r4 != null) goto L7;
        Log.e("LarkUriUtil", "failed to get file last modified from uri");
        return null;
    L7:
        return Long.valueOf(r4.lastModified());
    L10:
        return r0;
    }

    @JvmStatic
    public static final String l(Context r3, Uri r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "uri");
        String r0 = r3.getContentResolver().getType(r4);
        if (r0 != null) goto L5;
    L6:
        PolarisFileWrapper r5 = c(r3, r4);
        if (r5 == null) goto L13;
        String r6 = FilesKt.getExtension(r5);
        String[] r7 = FileUtils.a;
        String r8 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r6);
        if (r8 == null) goto L13;
        return r8;
    L13:
        return "*/*";
    L5:
        if (Intrinsics.areEqual(r0, "*/*") == true) goto L6;
        return r0;
    }

    @JvmStatic
    public static final boolean m(Context r2, Uri r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "uri");
        AssetFileDescriptor r0 = ContentResolverWrapper.openAssetFileDescriptor(r2.getContentResolver(), r3, "r");     // Catch: Exception -> L10
        if (r0 == null) goto L8;
        CloseableKt.closeFinally(r0, null);     // Catch: Exception -> L10
        return true;
    L8:
        if (c(r2, r3) == null) goto L20;
        return true;
    L20:
        return false;
    L10:
        e = move-exception;
        if ((e instanceof FileNotFoundException) == false) goto L14;
        return false;
    L14:
        if ((e instanceof SecurityException) == true) goto L22;
        Log.e("LarkUriUtil", e.getMessage());
        return false;
    L22:
        return false;
    }

    private final <T> T query(Context r4, Uri r5, a<T> r6) {
        Cursor r7 = b(r4.getContentResolver(), r5);     // Catch: SecurityException -> L20 UnsupportedOperationException -> L23 IllegalArgumentException -> L26
        if (r7 == null) goto L19;
        Cursor r8 = r7;     // Catch: SecurityException -> L20 UnsupportedOperationException -> L23 IllegalArgumentException -> L26
        Cursor r1 = r8;     // Catch: Throwable -> L14
        if (r1.moveToFirst() == false) goto L11;
        T r9 = r6.a(r1);     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r8, null);     // Catch: SecurityException -> L20 UnsupportedOperationException -> L23 IllegalArgumentException -> L26
        return r9;
    L11:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r8, null);     // Catch: SecurityException -> L20 UnsupportedOperationException -> L23 IllegalArgumentException -> L26
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: SecurityException -> L20 UnsupportedOperationException -> L23 IllegalArgumentException -> L26
        throw th;     // Catch: SecurityException -> L20 UnsupportedOperationException -> L23 IllegalArgumentException -> L26
    L19:
        return null;
    L26:
        e = move-exception;
        Log.e("LarkUriUtil", e);
        throw e;
    L20:
        e = move-exception;
        Log.e("LarkUriUtil", e);
        throw e;
    L23:
        e = move-exception;
        Log.e("LarkUriUtil", e);
        throw e;
    }
}
