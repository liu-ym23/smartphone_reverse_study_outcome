package uh8;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public static boolean d(PolarisFileWrapper r4) {
        if (r4.exists() == true) goto L5;
    L7:
        return false;
    L5:
        if (r4.length() <= 0) goto L7;
        return true;
    }

    public static Uri f(String r4) {
        String r5 = StringsKt.trim(r4).toString();
        if (r5 != null) goto L5;
    L21:
        return null;
    L5:
        if (r5.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r5 = null;
    L11:
        if (r5 == null) goto L21;
        if (StringsKt.startsWith$default(r5, "content://", false, 2, null) == true) goto L20;
        if (StringsKt.startsWith$default(r5, "file://", false, 2, null) == true) goto L20;
        return Uri.fromFile(new PolarisFileWrapper(r5));
    L20:
        return UriProtector.parse(r5);
    L7:
        r1 = false;
        goto L8
    }

    public static InputStream e(Context r3, Uri r4) {
        String r0 = r4.getScheme();
        if (r0 == null) goto L23;
        int r1 = r0.hashCode();
        if (r1 == 0) goto L21;
        if (r1 == 3143036) goto L15;
        if (r1 == 951530617) goto L12;
    L27:
        return null;
    L12:
        if (r0.equals("content") == false) goto L27;
        return ContentResolverWrapper.openInputStream(r3.getContentResolver(), r4);
    L15:
        if (r0.equals("file") == false) goto L27;
        String r5 = r4.getPath();
        if (r5 == null) goto L27;
        PolarisFileInputStreamWrapper r6 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r5));
    L30:
        return r6;
    L21:
        if (r0.equals("") == false) goto L27;
    L23:
        String r7 = r4.getPath();
        if (r7 == null) goto L27;
        r6 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r7));
        goto L30
    }

    public static boolean g(Bitmap r4, PolarisFileWrapper r5) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r5.getAbsolutePath() + ".tmp");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L19
        PolarisFileOutputStreamWrapper r2 = new PolarisFileOutputStreamWrapper(r0);     // Catch: Throwable -> L19
        r4.compress(Bitmap.CompressFormat.JPEG, 85, r2);     // Catch: Throwable -> L14
    L6:
        CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L19
        if (r5.exists() == false) goto L9;
        r5.delete();     // Catch: Throwable -> L19
    L9:
        boolean r6 = r0.renameTo(r5);     // Catch: Throwable -> L19
        if (r6 == true) goto L12;
        r0.delete();     // Catch: Throwable -> L19
    L12:
        Object r7 = Result.constructor-impl(Boolean.valueOf(r6));     // Catch: Throwable -> L19
    L22:
        if (Result.exceptionOrNull-impl(r7) == null) goto L24;
        r0.delete();
    L24:
        Boolean r8 = Boolean.FALSE;
        if (Result.isFailure-impl(r7) == false) goto L28;
        r7 = r8;
    L28:
        return ((Boolean) r7).booleanValue();
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }

    public static Bitmap b(Context r7, Uri r8, int r9) {
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        int r1 = 1;
        r0.inJustDecodeBounds = true;
        InputStream r2 = e(r7, r8);
        if (r2 == null) goto L12;
        BitmapFactory.decodeStream(r2, null, r0);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r2, null);
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    L12:
        if (r0.outWidth > 0) goto L14;
        return null;
    L14:
        if (r0.outHeight <= 0) goto L41;
        BitmapFactory.Options r3 = new BitmapFactory.Options();
        r3.inJustDecodeBounds = false;
        r3.inPreferredConfig = Bitmap.Config.RGB_565;
        b r4 = a;
        int r5 = r0.outWidth;
        int r6 = r0.outHeight;
        r4.getClass();
    L18:
        if (Math.max(r5 / r1, r6 / r1) <= r9) goto L20;
        r1 = r1 * 2;
        goto L18
    L20:
        r3.inSampleSize = r1;
        InputStream r10 = e(r7, r8);
        if (r10 == null) goto L39;
        Bitmap r11 = BitmapFactory.decodeStream(r10, null, r3);     // Catch: Throwable -> L24
        CloseableKt.closeFinally(r10, null);
        return r11;
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    L39:
        return null;
    L41:
        return null;
    }

    public static String c(b r6, Context r7, String r8) {
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "context");
        String r9 = StringsKt.trim(r8).toString();
        if (r9 == null) goto L32;
        boolean r1 = true;
        if (r9.length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        r9 = null;
    L11:
        if (r9 == null) goto L34;
        Uri r2 = f(r9);
        if (r2 == null) goto L35;
        int r3 = 1440;
        Integer r4 = 1440;
        if (r4.intValue() > 0) goto L20;
        r1 = false;
    L20:
        if (r1 == true) goto L23;
        r4 = null;
    L23:
        if (r4 == null) goto L25;
        r3 = r4.intValue();
    L25:
        File r10 = a(r7, r9, r2, r3);
        a.getClass();
        if (d(r10) == true) goto L29;
        r10 = null;
    L29:
        if (r10 != null) goto L31;
        return null;
    L31:
        return r10.getAbsolutePath();
    L35:
        return null;
    L34:
        return null;
    L7:
        r0 = false;
        goto L8
    L32:
        return null;
    }

    public static PolarisFileWrapper a(Context r11, String r12, Uri r13, int r14) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r11.getCacheDir(), "local_image_preview");
        r0.mkdirs();
        String r1 = r13.getScheme();
        if (r1 == null) goto L18;
        int r3 = r1.hashCode();
        if (r3 == 0) goto L16;
        if (r3 == 3143036) goto L10;
    L21:
        PolarisFileWrapper r4 = null;
    L22:
        long r5 = 0;
        if (r4 != null) goto L25;
    L30:
        long r6 = 0;
    L32:
        if (r4 == null) goto L40;
        if (r4.exists() == true) goto L37;
        r4 = null;
    L37:
        if (r4 == null) goto L40;
        long r2 = r4.length();
    L72:
        byte[] r7 = MessageDigest.getInstance("SHA-256").digest(CollectionsKt.joinToString$default(CollectionsKt.listOf(new Object[]{r12, Long.valueOf(r6), Long.valueOf(r2), Integer.valueOf(r14)}), "#", null, null, 0, null, null, 62, null).getBytes(Charsets.UTF_8));
        Intrinsics.checkNotNull(r7);
        return new PolarisFileWrapper(r0, "preview_" + ArraysKt.joinToString$default(r7, "", null, null, 0, null, new a(), 30, null) + ".jpg");
    L40:
        if (Intrinsics.areEqual(r13.getScheme(), "content") == true) goto L76;
    L71:
        r2 = r5;
        goto L72
    L76:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L65
        AssetFileDescriptor r15 = ContentResolverWrapper.openAssetFileDescriptor(r11.getContentResolver(), r13, "r");     // Catch: Throwable -> L65
        if (r15 != null) goto L74;
        long r9 = 0;
    L63:
        Object r16 = Result.constructor-impl(Long.valueOf(r9));     // Catch: Throwable -> L65
    L68:
        if (Result.isFailure-impl(r16) == false) goto L70;
        r16 = 0L;
    L70:
        r5 = ((Number) r16).longValue();
        goto L71
    L74:
        Long r17 = Long.valueOf(r15.getLength());     // Catch: Throwable -> L57
        if (r17.longValue() <= 0) goto L47;
        boolean r10 = true;
    L48:
        if (r10 == true) goto L51;
        r17 = null;
    L51:
        if (r17 == null) goto L54;
        r9 = r17.longValue();     // Catch: Throwable -> L57
    L55:
        CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L65
        goto L63
    L54:
        r9 = 0;
        goto L55
    L47:
        r10 = false;
    L57:
        th = move-exception;
        throw th;     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);     // Catch: Throwable -> L65
        throw th;     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L68
    L25:
        if (r4.exists() == false) goto L27;
        PolarisFileWrapper r19 = r4;
    L28:
        if (r19 == null) goto L30;
        r6 = r19.lastModified();
        goto L32
    L27:
        r19 = null;
        goto L28
    L10:
        if (r1.equals("file") == false) goto L21;
        String r20 = r13.getPath();
        if (r20 == null) goto L21;
        r4 = new PolarisFileWrapper(r20);
        goto L22
    L16:
        if (r1.equals("") == false) goto L21;
    L18:
        String r21 = r13.getPath();
        if (r21 == null) goto L21;
        r4 = new PolarisFileWrapper(r21);
        goto L22
    }
}
