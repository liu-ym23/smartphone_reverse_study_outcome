package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public abstract class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Paint f1634a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lock f1635b = null;

    static {
        f1634a = new Paint(6);
        new Paint(7);
        if (new HashSet(Arrays.asList(new String[]{"XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"})).contains(Build.MODEL) == false) goto L5;
        Lock r5 = new ReentrantLock();
    L6:
        f1635b = r5;
        new Paint(7).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        return;
    L5:
        r5 = new t();
        goto L6
    }

    public static void a(Bitmap r5, Bitmap r10, Matrix r11) {
        Lock r12 = f1635b;
        r12.lock();
        Canvas r13 = new Canvas(r10);     // Catch: Throwable -> L6
        r13.drawBitmap(r5, r11, f1634a);     // Catch: Throwable -> L6
        r13.setBitmap(null);     // Catch: Throwable -> L6
        r12.unlock();
        return;
    L6:
        th = move-exception;
        r12.unlock();
        throw th;
    }

    public static Bitmap b(com.bumptech.glide.load.engine.bitmap_recycle.a r10, Bitmap r11, int r12, int r13) {
        if (r11.getWidth() == r12) goto L5;
    L10:
        float r5 = Math.min(r12 / r11.getWidth(), r13 / r11.getHeight());
        int r14 = Math.round(r11.getWidth() * r5);
        int r15 = Math.round(r11.getHeight() * r5);
        if (r11.getWidth() == r14) goto L13;
    L18:
        int r16 = (int) (r11.getWidth() * r5);
        int r17 = (int) (r11.getHeight() * r5);
        if (r11.getConfig() == null) goto L21;
        Bitmap.Config r18 = r11.getConfig();
    L22:
        Bitmap r19 = r10.g(r16, r17, r18);
        r19.setHasAlpha(r11.hasAlpha());
        if (Log.isLoggable("TransformationUtils", 2) == false) goto L25;
        Log.v("TransformationUtils", "request: " + r12 + "x" + r13);
        Log.v("TransformationUtils", "toFit:   " + r11.getWidth() + "x" + r11.getHeight());
        Log.v("TransformationUtils", "toReuse: " + r19.getWidth() + "x" + r19.getHeight());
        StringBuilder r20 = new StringBuilder("minPct:   ");
        r20.append(r5);
        Log.v("TransformationUtils", r20.toString());
    L25:
        Matrix r21 = new Matrix();
        r21.setScale(r5, r5);
        a(r11, r19, r21);
        return r19;
    L21:
        r18 = Bitmap.Config.ARGB_8888;
        goto L22
    L13:
        if (r11.getHeight() != r15) goto L18;
        if (Log.isLoggable("TransformationUtils", 2) == false) goto L17;
        Log.v("TransformationUtils", "adjusted target size matches input, returning input");
    L17:
        return r11;
    L5:
        if (r11.getHeight() != r13) goto L10;
        if (Log.isLoggable("TransformationUtils", 2) == false) goto L9;
        Log.v("TransformationUtils", "requested target size matches input, returning input");
    L9:
        return r11;
    }
}
