package com.larus.canvas.feature.component.logic.helper;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.common.apphost.AppHost;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public static final Pair<Integer, Integer> c(Uri r5) {
        Intrinsics.checkNotNullParameter(r5, "uri");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L31
        AppHost.Companion r2 = AppHost.a;     // Catch: Throwable -> L31
        InputStream r3 = ContentResolverWrapper.openInputStream(r2.getApplication().getContentResolver(), r5);     // Catch: Throwable -> L31
        BitmapFactory.Options r4 = new BitmapFactory.Options();     // Catch: Throwable -> L31
        boolean r6 = true;
        r4.inJustDecodeBounds = true;     // Catch: Throwable -> L31
        BitmapFactory.decodeStream(r3, null, r4);     // Catch: Throwable -> L31
        if (r3 == null) goto L6;
        r3.close();     // Catch: Throwable -> L31
    L6:
        InputStream r7 = ContentResolverWrapper.openInputStream(r2.getApplication().getContentResolver(), r5);     // Catch: Throwable -> L31
        if (r7 == null) goto L9;
        ExifInterface r8 = new ExifInterface(r7);     // Catch: Throwable -> L31
    L10:
        if (r8 == null) goto L12;
        Integer r9 = Integer.valueOf(r8.getAttributeInt("Orientation", 1));     // Catch: Throwable -> L31
    L13:
        if (r7 == null) goto L15;
        r7.close();     // Catch: Throwable -> L31
    L15:
        if (r9 != null) goto L18;
    L19:
        if (r9 != null) goto L22;
    L24:
        r6 = false;
    L25:
        int r10 = r4.outWidth;     // Catch: Throwable -> L31
        int r11 = r4.outHeight;     // Catch: Throwable -> L31
        if (r6 == false) goto L28;
        Pair r12 = TuplesKt.to(Integer.valueOf(r11), Integer.valueOf(r10));     // Catch: Throwable -> L31
    L29:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L31
    L34:
        if (Result.isFailure-impl(r13) == true) goto L38;
        r0 = r13;
    L38:
        return (Pair) r0;
    L28:
        r12 = TuplesKt.to(Integer.valueOf(r10), Integer.valueOf(r11));     // Catch: Throwable -> L31
        goto L29
    L22:
        if (r9.intValue() != 8) goto L24;
    L18:
        if (r9.intValue() == 6) goto L25;
    L12:
        r9 = null;
        goto L13
    L9:
        r8 = null;
    L31:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    }

    public static ParcelFileDescriptor a(ContentResolver r20, Uri r21) {
        ArrayList r1 = new ArrayList();
        Object[] r2 = {r21, "r"};
        f06.b r13 = new f06.b();
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
        int r18 = r9;
        f06.a[] r19 = r10;
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
        r9 = r18;
        r10 = r19;
        goto L8
    L15:
        r5 = new f06.d(false, null);
        goto L17
    L5:
        r4 = ApiHookConfig.d;
        goto L6
    }

    public static final Object b(Context r3, String r4, ContinuationImpl r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ImageUtilsKt$downloadImageUrlToLocalPath$2(r4, r3, null), r5);
    }
}
