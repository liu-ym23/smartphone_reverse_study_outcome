package com.larus.camera.impl.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.utils.logger.FLogger;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public final Fragment a;
    public CameraData b;
    public boolean c;
    public List<String> d;
    public String e;
    public String f;
    public int g;
    public int h;
    public boolean i;
    public int j;
    public final List<String> k;
    public final Lazy l;
    public final Lazy m;
    public Uri n;

    public static final class a {
    }

    static {
    }

    public final boolean f() {
        String r0 = this.e;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L13;
        dr9.g r2 = dr9.g.a;
        if (dr9.g.d(this.e) != null) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public f(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
        this.d = CollectionsKt.emptyList();
        this.f = "";
        this.j = -1;
        this.k = CollectionsKt.listOf("CAPTURE_MODE_PHOTO");
        this.l = LazyKt.lazy(new d());
        this.m = LazyKt.lazy(new e());
    }

    public static int a(int r6, int r7) {
        int r0 = Math.min(r6, r7);
        int r8 = Math.max(r6, r7);
        FLogger r9 = FLogger.a;
        r9.i("AlbumManager", "calculateInSampleSize originWidth:" + r0 + ", originHeight:" + r8);
        int r1 = Build.VERSION.SDK_INT;
        if (r1 >= 28) goto L6;
        Pair r2 = TuplesKt.to(720, 1280);
    L9:
        int r4 = r0 * r8;
        int r3 = ((Number) r2.getFirst()).intValue() * ((Number) r2.getSecond()).intValue();
        if (r4 <= r3) goto L12;
        float r5 = (float) Math.sqrt(r4 / r3);
        Pair r10 = TuplesKt.to(Integer.valueOf((int) (r0 / r5)), Integer.valueOf((int) (r8 / r5)));
    L13:
        int r11 = ((Number) r10.getFirst()).intValue();
        int r12 = ((Number) r10.getSecond()).intValue();
        r9.i("AlbumManager", "calculateInSampleSize targetWidth:" + r11 + ", targetHeight:" + r12);
        int r13 = 1;
        if (r8 > r12) goto L16;
        if (r0 > r11) goto L16;
    L22:
        FLogger.a.i("AlbumManager", "calculateInSampleSize inSampleSize:" + r13);
        return r13;
    L16:
        int r14 = r8 / 2;
        int r15 = r0 / 2;
    L18:
        if ((r14 / r13) < r12) goto L22;
        if ((r15 / r13) < r11) goto L22;
        r13 = r13 * 2;
        goto L18
    L12:
        r10 = TuplesKt.to(Integer.valueOf(r0), Integer.valueOf(r8));
        goto L13
    L6:
        if (r1 <= 30) goto L8;
        r2 = TuplesKt.to(1440, 2560);
        goto L9
    L8:
        r2 = TuplesKt.to(1080, 1920);
        goto L9
    }

    public static Bitmap c(Context r9, Uri r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Object r3 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        ImFileUtil.a.getClass();
        if (ImFileUtil.y(r10) == true) goto L8;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L61
        InputStream r5 = ContentResolverWrapper.openInputStream(r9.getContentResolver(), r10);     // Catch: Throwable -> L61
        if (r5 != null) goto L75;
        BitmapFactory.Options r6 = null;
    L21:
        InputStream r7 = ContentResolverWrapper.openInputStream(r9.getContentResolver(), r10);     // Catch: Throwable -> L61
        if (r7 != null) goto L69;
        Bitmap r8 = null;
    L32:
        FLogger r11 = FLogger.a;     // Catch: Throwable -> L61
        r11.i("AlbumManager", "getBitmapFromContentUri decode bitmap complete: " + r8);     // Catch: Throwable -> L61
        InputStream r12 = ContentResolverWrapper.openInputStream(r9.getContentResolver(), r10);     // Catch: Throwable -> L61
        if (r12 != null) goto L73;
        Integer r13 = null;
    L43:
        r11.i("AlbumManager", "getBitmapFromContentUri read orientation complete: " + r13);     // Catch: Throwable -> L61
        if (r13 != null) goto L47;
    L49:
        if (r13 != null) goto L52;
    L54:
        if (r13 != null) goto L57;
    L59:
        r11.i("AlbumManager", "getBitmapFromContentUri return bitmap complete");     // Catch: Throwable -> L61
        Object r14 = Result.constructor-impl(r8);     // Catch: Throwable -> L61
    L64:
        if (Result.exceptionOrNull-impl(r14) != null) goto L66;
        r3 = r14;
    L68:
        return (Bitmap) r3;
    L66:
        FLogger.a.e("AlbumManager", "getBitmapFromContentUri fail");
        goto L68
    L57:
        if (r13.intValue() != 8) goto L59;
        r8 = g(r8, 270.0f);     // Catch: Throwable -> L61
        goto L59
    L52:
        if (r13.intValue() != 3) goto L54;
        r8 = g(r8, 180.0f);     // Catch: Throwable -> L61
        goto L59
    L47:
        if (r13.intValue() != 6) goto L49;
        r8 = g(r8, 90.0f);     // Catch: Throwable -> L61
        goto L59
    L73:
        r13 = Integer.valueOf(new ExifInterface(r12).getAttributeInt("Orientation", 0));     // Catch: Throwable -> L37
        CloseableKt.closeFinally(r12, null);     // Catch: Throwable -> L61
        goto L43
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);     // Catch: Throwable -> L61
        throw th;     // Catch: Throwable -> L61
    L69:
        r8 = BitmapFactory.decodeStream(r7, null, r6);     // Catch: Throwable -> L26
        CloseableKt.closeFinally(r7, null);     // Catch: Throwable -> L61
        goto L32
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);     // Catch: Throwable -> L61
        throw th;     // Catch: Throwable -> L61
    L75:
        r6 = new BitmapFactory.Options();     // Catch: Throwable -> L15
        r6.inJustDecodeBounds = true;     // Catch: Throwable -> L15
        BitmapFactory.decodeStream(r5, null, r6);     // Catch: Throwable -> L15
        r6.inSampleSize = a(r6.outWidth, r6.outHeight);     // Catch: Throwable -> L15
        r6.inJustDecodeBounds = false;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r5, null);     // Catch: Throwable -> L61
        goto L21
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);     // Catch: Throwable -> L61
        throw th;     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L64
    L8:
        return d(r9, r10);
    }

    public static Bitmap d(Context r8, Uri r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "uri");
        FLogger.a.i("AlbumManager", "[getFirstFrameBitmap] uri:" + r9);
        MediaMetadataRetriever r1 = new MediaMetadataRetriever();
        r1.setDataSource(r8, r9);     // Catch: Throwable -> L5 Exception -> L7
        Bitmap r10 = r1.getFrameAtTime(0);     // Catch: Throwable -> L5 Exception -> L7
    L17:
        r1.release();
        return r10;
    L5:
        th = move-exception;
        r1.release();
        throw th;
    L7:
        e = move-exception;
        FLogger.a.e("AlbumManager", "[getFirstFrameBitmap] e:" + e.getMessage());     // Catch: Throwable -> L5
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        r1.setDataSource(r8, r9);     // Catch: Throwable -> L11
        Object r11 = Result.constructor-impl(r1.getFrameAtTime(0));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r11) == false) goto L16;
        r11 = null;
    L16:
        r10 = (Bitmap) r11;     // Catch: Throwable -> L5
    L11:
        th = move-exception;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L5
        r11 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L5
        goto L14
    }

    public static Uri e(Context r13, boolean r14) {
        ArrayList r0 = new ArrayList();
        Uri r1 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor r4 = b(r13.getContentResolver(), r1, new String[]{"_id", "date_added"});
        if (r4 == null) goto L16;
        Cursor r5 = r4;
        Cursor r6 = r5;     // Catch: Throwable -> L11
        int r7 = r6.getColumnIndexOrThrow("_id");     // Catch: Throwable -> L11
        int r8 = r6.getColumnIndexOrThrow("date_added");     // Catch: Throwable -> L11
    L7:
        if (r6.moveToNext() == false) goto L9;
        r0.add(new Pair(Uri.withAppendedPath(r1, String.valueOf(r6.getLong(r7))), Long.valueOf(r6.getLong(r8))));     // Catch: Throwable -> L11
        goto L7
    L9:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r5, null);
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    L16:
        if (r14 == false) goto L31;
        Uri r15 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        Cursor r16 = b(r13.getContentResolver(), r15, new String[]{"_id", "date_added"});
        if (r16 == null) goto L31;
        Cursor r17 = r16;
        Cursor r3 = r17;     // Catch: Throwable -> L26
        int r9 = r3.getColumnIndexOrThrow("_id");     // Catch: Throwable -> L26
        int r10 = r3.getColumnIndexOrThrow("date_added");     // Catch: Throwable -> L26
    L22:
        if (r3.moveToNext() == false) goto L24;
        r0.add(new Pair(Uri.withAppendedPath(r15, String.valueOf(r3.getLong(r9))), Long.valueOf(r3.getLong(r10))));     // Catch: Throwable -> L26
        goto L22
    L24:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L26
        CloseableKt.closeFinally(r17, null);
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r17, th);
        throw th;
    L31:
        Iterator r19 = r0.iterator();
        if (r19.hasNext() == true) goto L34;
        Object r110 = null;
    L43:
        Pair r111 = (Pair) r110;
        if (r111 != null) goto L46;
        return null;
    L46:
        return (Uri) r111.getFirst();
    L34:
        r110 = r19.next();
        if (r19.hasNext() == false) goto L43;
        long r11 = ((Number) ((Pair) r110).getSecond()).longValue();
    L38:
        Object r12 = r19.next();
        long r20 = ((Number) ((Pair) r12).getSecond()).longValue();
        if (r11 >= r20) goto L42;
        r110 = r12;
        r11 = r20;
    L42:
        if (r19.hasNext() == true) goto L38;
        goto L43
    }

    public static Bitmap g(Bitmap r7, float r8) {
        if (r7 != null) goto L5;
        return null;
    L5:
        Matrix r5 = new Matrix();
        r5.postRotate(r8);
        return Bitmap.createBitmap(r7, 0, 0, r7.getWidth(), r7.getHeight(), r5, true);
    }

    public static Cursor b(ContentResolver r17, Uri r18, String[] r19) {
        f06.c r14 = new f06.c();
        Object[] r15 = {r18, r19, null, null, "date_added DESC"};
        f06.b r16 = new f06.b();
        f06.d r0 = r14.b(240004, "android/content/ContentResolver", "query", r17, r15, "android.database.Cursor", r16);
        if (r0.a == false) goto L6;
        r14.a(240004, "android/content/ContentResolver", "query", r17, r15, null, r16, false);
        return (Cursor) r0.b;
    L6:
        Cursor r1 = r17.query(r18, r19, null, null, "date_added DESC");
        r14.a(240004, "android/content/ContentResolver", "query", r17, r15, r1, r16, true);
        return r1;
    }
}
