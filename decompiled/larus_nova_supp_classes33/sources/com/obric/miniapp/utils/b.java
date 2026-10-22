package com.obric.miniapp.utils;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.LruCache;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.io.ByteArrayOutputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final b a = null;
    public static final Lazy b = null;

    public b() {
    }

    static {
        a = new b();
        b = LazyKt.lazy(new a());
    }

    public final String a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "packageName");
        String r0 = (String) ((LruCache) b.getValue()).get(r6);
        if (r0 == null) goto L27;
        return r0;
    L27:
        Bitmap r1 = b(this, AppHost.a.getApplication().getPackageManager().getApplicationIcon(r6));     // Catch: PackageManager.NameNotFoundException -> L17
        if (r1 == null) goto L19;
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();     // Catch: PackageManager.NameNotFoundException -> L17
        r1.compress(Bitmap.CompressFormat.PNG, 100, r2);     // Catch: Throwable -> L12
        String r3 = Base64.encodeToString(r2.toByteArray(), 2);     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r2, null);     // Catch: PackageManager.NameNotFoundException -> L17
    L20:
        if (r3 == null) goto L28;
        ((LruCache) b.getValue()).put(r6, r3);
        return r3;
    L28:
        return null;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: PackageManager.NameNotFoundException -> L17
        throw th;     // Catch: PackageManager.NameNotFoundException -> L17
    L19:
        r3 = null;
    L17:
        e = move-exception;
        FLogger.a.e("AppIconManager", e.getMessage());
        goto L19
    }

    public static Bitmap b(b r7, Drawable r8) {
        int r0 = r8.getIntrinsicWidth();
        int r1 = r8.getIntrinsicHeight();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "<this>");
        boolean r2 = r8 instanceof BitmapDrawable;
        if (r2 == true) goto L5;
    L7:
        Intrinsics.checkNotNullParameter(r8, "<this>");
        if (r2 == false) goto L19;
        BitmapDrawable r9 = (BitmapDrawable) r8;
        if (r9.getBitmap() == null) goto L18;
        if (r0 != r9.getBitmap().getWidth()) goto L23;
        if (r1 != r9.getBitmap().getHeight()) goto L23;
        return r9.getBitmap();
    L23:
        return Bitmap.createScaledBitmap(r9.getBitmap(), r0, r1, true);
    L18:
        throw new IllegalArgumentException("bitmap is null");
    L19:
        int r10 = r8.getBounds().left;
        int r3 = r8.getBounds().top;
        int r4 = r8.getBounds().right;
        int r5 = r8.getBounds().bottom;
        Bitmap r6 = Bitmap.createBitmap(r0, r1, Bitmap.Config.ARGB_8888);
        r8.setBounds(0, 0, r0, r1);
        r8.draw(new Canvas(r6));
        r8.setBounds(r10, r3, r4, r5);
        return r6;
    L5:
        if (((BitmapDrawable) r8).getBitmap() != null) goto L7;
        return null;
    }
}
