package com.larus.bmhome.upload;

import android.content.Context;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.nova.NovaApplication;
import com.larus.utils.logger.FLogger;
import java.io.InputStream;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class UploadImageMetaResolver {
    public static final UploadImageMetaResolver a = null;
    public static final float b = 0.0f;

    public UploadImageMetaResolver() {
    }

    static {
        a = new UploadImageMetaResolver();
        b = c7.b(Float.valueOf(286.0f)) / c7.c(Float.valueOf(390.0f));
    }

    public final Object b(mr9.j r7, Continuation<? super mr9.d> r8) {
        if ((r8 instanceof UploadImageMetaResolver$resolveLocalImageResult$1) == false) goto L7;
        UploadImageMetaResolver$resolveLocalImageResult$1 r0 = (UploadImageMetaResolver$resolveLocalImageResult$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L20:
        Pair r10 = (Pair) r9;
        int r11 = ((Number) r10.component1()).intValue();
        return new mr9.d(((Number) r10.component2()).intValue(), r11);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        NovaApplication r12 = r7.getContext();
        if (r12 != null) goto L17;
        gd9.i r13 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r13);
        r12 = r13.getApplication();
    L17:
        String r4 = r7.a;
        boolean r14 = r7.g;
        r0.label = 1;
        r9 = BuildersKt.withContext(Dispatchers.getIO(), new UploadImageMetaResolver$resolveLocalImageSize$2(r14, r4, r12, null), r0);
        if (r9 != r2) goto L20;
        return r2;
    L7:
        r0 = new UploadImageMetaResolver$resolveLocalImageResult$1(this, r8);
        goto L8
    }

    public static final boolean a(UploadImageMetaResolver r2, Context r3, Uri r4) {
        r2.getClass();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L22
        InputStream r6 = ContentResolverWrapper.openInputStream(r3.getContentResolver(), r4);     // Catch: Throwable -> L22
        boolean r7 = false;
        if (r6 != null) goto L30;
    L20:
        Object r8 = Result.constructor-impl(Boolean.valueOf(r7));     // Catch: Throwable -> L22
    L24:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L29;
        FLogger.a.e("UploadImageMetaResolver", "[needSwapWidthHeight] parse exif failed", r9);
        r8 = Boolean.FALSE;
    L29:
        return ((Boolean) r8).booleanValue();
    L30:
        int r10 = new ExifInterface(r6).getAttributeInt("Orientation", 1);     // Catch: Throwable -> L15
    L8:
        if (r10 != 6) goto L10;
    L11:
        r7 = true;
    L13:
        CloseableKt.closeFinally(r6, null);     // Catch: Throwable -> L22
        goto L20
    L10:
        if (r10 != 8) goto L13;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    }
}
