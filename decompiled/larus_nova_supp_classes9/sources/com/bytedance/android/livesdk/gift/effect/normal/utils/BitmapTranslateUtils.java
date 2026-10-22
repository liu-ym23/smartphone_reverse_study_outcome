package com.bytedance.android.livesdk.gift.effect.normal.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class BitmapTranslateUtils {

    public static final enum CenterType extends Enum<CenterType> {
        public static final CenterType HORIZONTAL = null;
        public static final CenterType VERTICAL = null;
        public static final /* synthetic */ CenterType[] a = null;

        static {
            CenterType r0 = new CenterType("VERTICAL", 0);
            VERTICAL = r0;
            CenterType r1 = new CenterType("HORIZONTAL", 1);
            HORIZONTAL = r1;
            a = new CenterType[]{r0, r1};
        }

        public static CenterType[] values() {
            return (CenterType[]) a.clone();
        }

        public static CenterType valueOf(String r1) {
            return (CenterType) a.a(CenterType.class, r1);
        }

        public CenterType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static Bitmap a(View r4) {
        r4.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        r4.layout(0, 0, r4.getMeasuredWidth(), r4.getMeasuredHeight());
        r4.setDrawingCacheEnabled(true);
        Bitmap r2 = r4.getDrawingCache();     // Catch: Exception -> L7
        if (r2 != null) goto L8;
        r2 = d(r4);     // Catch: Exception -> L7
    L8:
        Bitmap r1 = r2.copy(Bitmap.Config.ARGB_8888, true);
        r4.destroyDrawingCache();
        r4.setDrawingCacheEnabled(false);
        return r1;
    L7:
        r2 = d(r4);
        goto L8
    }

    public static Bitmap b(Bitmap r13) {
        int r0 = Math.min(r13.getWidth(), r13.getHeight()) / 2;     // Catch: OutOfMemoryError -> L12 Exception -> L14
        Point r1 = new Point(r13.getWidth() / 2, r13.getHeight() / 2);     // Catch: OutOfMemoryError -> L12 Exception -> L14
        if (r13.getWidth() <= r13.getHeight()) goto L5;
        CenterType r2 = CenterType.HORIZONTAL;     // Catch: OutOfMemoryError -> L12 Exception -> L14
    L6:
        int r3 = r0 * 2;     // Catch: OutOfMemoryError -> L12 Exception -> L14
        Bitmap r4 = Bitmap.createBitmap(r3, r3, Bitmap.Config.ARGB_8888);     // Catch: OutOfMemoryError -> L12 Exception -> L14
        Canvas r5 = new Canvas(r4);     // Catch: OutOfMemoryError -> L12 Exception -> L14
        Paint r6 = new Paint();     // Catch: OutOfMemoryError -> L12 Exception -> L14
        Rect r7 = new Rect(0, 0, r3, r3);     // Catch: OutOfMemoryError -> L12 Exception -> L14
        RectF r9 = new RectF(new Rect(0, 0, r3, r3));     // Catch: OutOfMemoryError -> L12 Exception -> L14
        float r10 = Math.min(r13.getWidth(), r13.getHeight()) / 2;     // Catch: OutOfMemoryError -> L12 Exception -> L14
        r6.setAntiAlias(true);     // Catch: OutOfMemoryError -> L12 Exception -> L14
        r5.drawARGB(0, 0, 0, 0);     // Catch: OutOfMemoryError -> L12 Exception -> L14
        r6.setColor(-16777216);     // Catch: OutOfMemoryError -> L12 Exception -> L14
        r5.drawRoundRect(r9, r10, r10, r6);     // Catch: OutOfMemoryError -> L12 Exception -> L14
        r6.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));     // Catch: OutOfMemoryError -> L12 Exception -> L14
        if (r2 != CenterType.HORIZONTAL) goto L9;
        int r8 = r1.x;     // Catch: OutOfMemoryError -> L12 Exception -> L14
        Rect r11 = new Rect(r8 - r0, 0, r8 + r0, r3);     // Catch: OutOfMemoryError -> L12 Exception -> L14
    L10:
        r5.drawBitmap(r13, r11, r7, r6);     // Catch: OutOfMemoryError -> L12 Exception -> L14
        return r4;
        goto L17
    L9:
        int r14 = r1.y;     // Catch: OutOfMemoryError -> L12 Exception -> L14
        r11 = new Rect(0, r14 - r0, r3, r14 + r0);     // Catch: OutOfMemoryError -> L12 Exception -> L14
        goto L10
    L5:
        r2 = CenterType.VERTICAL;     // Catch: OutOfMemoryError -> L12 Exception -> L14
    L12:
        return null;
    L17:
        return r13;
    }

    public static Bitmap c(View r3) {
        Bitmap r0 = Bitmap.createBitmap(r3.getWidth(), r3.getHeight(), Bitmap.Config.ARGB_8888);
        r3.draw(new Canvas(r0));
        if (r3.isDirty() == false) goto L5;
        r3.postInvalidate();
    L5:
        return r0;
    }

    public static Bitmap d(View r5) {
        Bitmap r0 = Bitmap.createBitmap(r5.getWidth(), r5.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r1 = new Canvas(r0);
        r5.layout(0, 0, r5.getMeasuredWidth(), r5.getMeasuredHeight());
        r5.draw(r1);
        return r0;
    }
}
