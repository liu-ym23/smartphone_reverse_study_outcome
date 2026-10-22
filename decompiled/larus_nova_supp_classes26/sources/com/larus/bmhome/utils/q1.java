package com.larus.bmhome.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.io.InputStream;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import v19.c;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q1 {
    public static final q1 a = null;
    public static final String b = null;
    public static final float c = 0.0f;

    public q1() {
    }

    static {
        a = new q1();
        b = "ImageUtils";
        c = c7.b(Float.valueOf(286.0f)) / c7.c(Float.valueOf(390.0f));
    }

    public static Pair e(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        int r2 = (int) (com.larus.utils.m0.b(r1) * c);
        return TuplesKt.to(Integer.valueOf(r2), Integer.valueOf(r2));
    }

    public static boolean g(Uri r3) {
        Intrinsics.checkNotNullParameter(r3, "uri");
        InputStream r4 = ContentResolverWrapper.openInputStream(AppHost.a.getApplication().getContentResolver(), r3);
        Integer r0 = null;
        if (r4 == null) goto L5;
        ExifInterface r1 = new ExifInterface(r4);
    L7:
        if (r1 == null) goto L9;
        r0 = Integer.valueOf(r1.getAttributeInt("Orientation", 1));
    L9:
        if (r4 == null) goto L11;
        r4.close();
    L11:
        if (r0 != null) goto L14;
    L15:
        if (r0 != null) goto L18;
    L20:
        return false;
    L18:
        if (r0.intValue() != 8) goto L20;
        return true;
    L14:
        if (r0.intValue() != 6) goto L15;
        return true;
    L5:
        r1 = null;
        goto L7
    }

    public static final Pair<Integer, Integer> d(Pair<Integer, Integer> r6, Integer r7) {
        if (r7 != null) goto L4;
        return r6;
    L4:
        if (r7.intValue() <= 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L10;
        r7 = null;
    L10:
        if (r7 == null) goto L19;
        int r8 = r7.intValue();
        if (((Number) r6.getFirst()).intValue() > r8) goto L14;
        return r6;
    L14:
        if (((Number) r6.getFirst()).intValue() <= 0) goto L21;
        double r2 = ((double) r8) / ((double) ((Number) r6.getFirst()).intValue());
        return TuplesKt.to(Integer.valueOf(r8), Integer.valueOf(RangesKt.coerceAtLeast(MathKt.roundToInt(((Number) r6.getSecond()).doubleValue() * r2), 1)));
    L21:
        return r6;
    L19:
        return r6;
    L6:
        r0 = false;
        goto L7
    }

    public static Pair f(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "filePath");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L9
        BitmapFactory.Options r6 = new BitmapFactory.Options();     // Catch: Throwable -> L9
        r6.inJustDecodeBounds = true;     // Catch: Throwable -> L9
        BitmapFactory.decodeFile(r4, r6);     // Catch: Throwable -> L9
        int r0 = r6.outWidth;     // Catch: Throwable -> L9
        int r7 = r6.outHeight;     // Catch: Throwable -> L9
        if (g(Uri.fromFile(new PolarisFileWrapper(r4))) == false) goto L6;
        Pair r8 = TuplesKt.to(Integer.valueOf(r7), Integer.valueOf(r0));     // Catch: Throwable -> L9
    L7:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L9
    L11:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L16;
        FLogger.a.e(b, "getLocalImageSize fail msg=" + com.larus.utils.u0.a(r10));
        r9 = null;
    L16:
        return (Pair) r9;
    L6:
        r8 = TuplesKt.to(Integer.valueOf(r0), Integer.valueOf(r7));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public static /* synthetic */ Pair b(q1 r0, Context r1, Image r2, boolean r3) {
        r0.getClass();
        return a(r1, r2, r3, null, null);
    }

    public static Pair a(Context r2, Image r3, boolean r4, Pair r5, Integer r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (r3 == null) goto L8;
        String r0 = r3.localResPath;
        if (r0 == null) goto L8;
        a.getClass();
        Pair r1 = f(r2, r0);
        if (r1 == null) goto L8;
    L26:
        return c(r2, ((Number) r1.getFirst()).intValue(), ((Number) r1.getSecond()).intValue(), r4, r6);
    L8:
        if (r3 == null) goto L22;
        ImageObj r7 = r3.imageOri;
        if (r7 == null) goto L22;
        int r8 = r7.width;
        if (r8 != 0) goto L14;
    L17:
        if (r5 != null) goto L20;
        Pair r9 = e(r2);
    L19:
        r1 = r9;
    L21:
        if (r1 != null) goto L26;
    L20:
        r1 = r5;
        goto L21
    L14:
        if (r7.height == 0) goto L17;
        r9 = TuplesKt.to(Integer.valueOf(r8), Integer.valueOf(r7.height));
    L22:
        if (r5 != null) goto L24;
        r5 = e(r2);
    L24:
        r1 = r5;
        goto L26
    }

    public static Pair c(Context r10, int r11, int r12, boolean r13, Integer r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        int r0 = ((Number) e(r10).getFirst()).intValue();
        com.larus.platform.service.e2 r1 = com.larus.platform.service.e2.a;
        if (r1.isPad() == false) goto L5;
        int r15 = Math.min((int) (((double) r1.g()) / 2.5d), AppHost.a.getApplication().getResources().getDimensionPixelSize(c.b(2130971482, null, 2131167333)));
    L8:
        int r16 = Math.min(r0, r15);
        if (r11 == 0) goto L23;
        if (r12 == 0) goto L23;
        double r2 = r11;
        double r3 = r12;
        double r5 = r2 / r3;
        if (r5 < 5.0d) goto L16;
        Pair r4 = new Pair(Integer.valueOf(r16), Integer.valueOf((int) (((double) r16) / 5.0d)));
    L21:
        FLogger.a.d(b, "calculateScaledDimensions targetSize = " + r16 + " origin width =" + r11 + " height=" + r12 + " scale width =" + ((Number) r4.getFirst()).intValue() + " height=" + ((Number) r4.getSecond()).intValue());
        return d(r4, r14);
    L16:
        if (r5 > 0.4d) goto L18;
        r4 = new Pair(Integer.valueOf((int) (((double) r16) * 0.4d)), Integer.valueOf(r16));
        goto L21
    L18:
        if (r11 <= r12) goto L20;
        r4 = new Pair(Integer.valueOf(r16), Integer.valueOf((int) ((r3 / r2) * ((double) r16))));
        goto L21
    L20:
        r4 = new Pair(Integer.valueOf((int) (r5 * ((double) r16))), Integer.valueOf(r16));
    L23:
        FLogger.a.d(b, "origin width =" + r11 + " height=" + r12 + " scale width =" + r16 + " height=" + r16);
        return d(TuplesKt.to(Integer.valueOf(r16), Integer.valueOf(r16)), r14);
    L5:
        if (r13 == false) goto L7;
        Resources r17 = r10.getResources();
        r15 = RangesKt.coerceAtMost((WindowDisplayMetricsOverride.apply(r17, r17.getDisplayMetrics()).widthPixels * 200) / 390, i5.a0());
        goto L8
    L7:
        r15 = AppHost.a.getApplication().getResources().getDimensionPixelSize(c.b(2130971482, null, 2131167333));
        goto L8
    }
}
