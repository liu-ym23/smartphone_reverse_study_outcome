package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Paint f884a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Paint f885b = null;
    private static final Paint c = null;
    private static final Set<String> d = null;
    private static final Lock e = null;

    private static final class a implements Lock {
        a() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() {
        }

        @Override // java.util.concurrent.locks.Lock
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long r1, TimeUnit r3) {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }
    }

    static {
        f884a = new Paint(6);
        f885b = new Paint(7);
        HashSet r0 = new HashSet(Arrays.asList(new String[]{"XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"}));
        d = r0;
        if (r0.contains(Build.MODEL) == false) goto L5;
        Lock r1 = new ReentrantLock();
    L6:
        e = r1;
        Paint r2 = new Paint(7);
        c = r2;
        r2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        return;
    L5:
        r1 = new a();
        goto L6
    }

    public static int a(int r0) {
        switch(r0) {
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L5;
            case 6: goto L5;
            case 7: goto L4;
            case 8: goto L4;
            default: goto L3;
        };
    L3:
        return 0;
    L4:
        return SubsamplingScaleImageView.ORIENTATION_270;
    L5:
        return 90;
    L6:
        return SubsamplingScaleImageView.ORIENTATION_180;
    }

    private static Bitmap.Config a(Bitmap r1) {
        if (r1.getConfig() == null) goto L6;
        return r1.getConfig();
    L6:
        return Bitmap.Config.ARGB_8888;
    }

    public static Bitmap a(com.bumptech.glide.load.engine.bitmap_recycle.e r4, Bitmap r5, int r6) {
        com.bumptech.glide.load.engine.bitmap_recycle.e r7 = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
        if (b(r6) == true) goto L5;
        return r5;
    L5:
        Matrix r0 = new Matrix();
        a(r6, r0);
        RectF r8 = new RectF(0.0f, 0.0f, r5.getWidth(), r5.getHeight());
        r0.mapRect(r8);
        Bitmap r9 = r7.a(Math.round(r8.width()), Math.round(r8.height()), a(r5));
        r0.postTranslate(-r8.left, -r8.top);
        r9.setHasAlpha(r5.hasAlpha());
        a(r5, r9, r0);
        return r9;
    }

    public static Bitmap a(com.bumptech.glide.load.engine.bitmap_recycle.e r7, Bitmap r8, int r9, int r10) {
        com.bumptech.glide.load.engine.bitmap_recycle.e r11 = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r7, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
        if (r8.getWidth() == r9) goto L5;
    L7:
        Matrix r0 = new Matrix();
        float r3 = 0.0f;
        if ((r8.getWidth() * r10) <= (r8.getHeight() * r9)) goto L10;
        float r1 = r10 / r8.getHeight();
        r3 = (r9 - (r8.getWidth() * r1)) * 0.5f;
        float r2 = 0.0f;
    L11:
        r0.setScale(r1, r1);
        r0.postTranslate((int) (r3 + 0.5f), (int) (r2 + 0.5f));
        Bitmap r12 = r11.a(r9, r10, a(r8));
        a(r8, r12);
        a(r8, r12, r0);
        return r12;
    L10:
        r1 = r9 / r8.getWidth();
        r2 = (r10 - (r8.getHeight() * r1)) * 0.5f;
        goto L11
    L5:
        if (r8.getHeight() != r10) goto L7;
        return r8;
    }

    public static Lock a() {
        return e;
    }

    static void a(int r5, Matrix r6) {
        switch(r5) {
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L18;
        };
    L5:
        r6.setRotate(-90.0f);
        return;
    L6:
        r6.setRotate(-90.0f);
    L10:
        r6.postScale(-1.0f, 1.0f);
        return;
    L7:
        r6.setRotate(90.0f);
        return;
    L8:
        r6.setRotate(90.0f);
        goto L10
    L9:
        r6.setRotate(180.0f);
        goto L10
    L11:
        r6.setRotate(180.0f);
        return;
    L12:
        r6.setScale(-1.0f, 1.0f);
        return;
    }

    public static void a(Bitmap r0, Bitmap r1) {
        r1.setHasAlpha(r0.hasAlpha());
    }

    private static void a(Bitmap r2, Bitmap r3, Matrix r4) {
        Lock r0 = e;
        r0.lock();
        Canvas r1 = new Canvas(r3);     // Catch: Throwable -> L6
        r1.drawBitmap(r2, r4, f884a);     // Catch: Throwable -> L6
        a(r1);     // Catch: Throwable -> L6
        r0.unlock();
        return;
    L6:
        th = move-exception;
        e.unlock();
        throw th;
    }

    private static void a(Canvas r1) {
        r1.setBitmap(null);
    }

    public static boolean b(int r0) {
        switch(r0) {
            case 2: goto L5;
            case 3: goto L5;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            case 7: goto L5;
            case 8: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }
}
