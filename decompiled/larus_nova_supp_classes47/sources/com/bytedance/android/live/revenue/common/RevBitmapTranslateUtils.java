package com.bytedance.android.live.revenue.common;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RevBitmapTranslateUtils {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revenue/common/RevBitmapTranslateUtils$CenterType;", "", "VERTICAL", "HORIZONTAL", "revenue-common_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum CenterType extends Enum<CenterType> {
        public static final CenterType HORIZONTAL = null;
        public static final CenterType VERTICAL = null;
        public static final /* synthetic */ CenterType[] a = null;

        static {
            CenterType r1 = new CenterType("VERTICAL", 0);
            VERTICAL = r1;
            CenterType r2 = new CenterType("HORIZONTAL", 1);
            HORIZONTAL = r2;
            a = new CenterType[]{r1, r2};
        }

        public static CenterType valueOf(String r1) {
            return (CenterType) r27.a.a(CenterType.class, r1);
        }

        public static CenterType[] values() {
            return (CenterType[]) a.clone();
        }

        public CenterType(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
    }

    public static Bitmap a(Bitmap r0) {
        Intrinsics.checkNotNull(r0);     // Catch: OutOfMemoryError -> L4
        return Bitmap.createBitmap(r0);
    L4:
        return null;
    }

    public static Bitmap b(Bitmap r12) {
        Intrinsics.checkNotNullParameter(r12, "bitmap");
        int r0 = Math.min(r12.getWidth(), r12.getHeight()) / 2;     // Catch: OutOfMemoryError -> L13 Exception -> L15
        Point r1 = new Point(r12.getWidth() / 2, r12.getHeight() / 2);     // Catch: OutOfMemoryError -> L13 Exception -> L15
        if (r12.getWidth() <= r12.getHeight()) goto L6;
        CenterType r2 = CenterType.HORIZONTAL;     // Catch: OutOfMemoryError -> L13 Exception -> L15
    L7:
        int r3 = r0 * 2;     // Catch: OutOfMemoryError -> L13 Exception -> L15
        Bitmap r4 = Bitmap.createBitmap(r3, r3, Bitmap.Config.ARGB_8888);     // Catch: OutOfMemoryError -> L13 Exception -> L15
        Canvas r5 = new Canvas(r4);     // Catch: OutOfMemoryError -> L13 Exception -> L15
        Paint r6 = new Paint();     // Catch: OutOfMemoryError -> L13 Exception -> L15
        Rect r7 = new Rect(0, 0, r3, r3);     // Catch: OutOfMemoryError -> L13 Exception -> L15
        RectF r9 = new RectF(new Rect(0, 0, r3, r3));     // Catch: OutOfMemoryError -> L13 Exception -> L15
        float r10 = Math.min(r12.getWidth(), r12.getHeight()) / 2;     // Catch: OutOfMemoryError -> L13 Exception -> L15
        r6.setAntiAlias(true);     // Catch: OutOfMemoryError -> L13 Exception -> L15
        r5.drawARGB(0, 0, 0, 0);     // Catch: OutOfMemoryError -> L13 Exception -> L15
        r6.setColor(-16777216);     // Catch: OutOfMemoryError -> L13 Exception -> L15
        r5.drawRoundRect(r9, r10, r10, r6);     // Catch: OutOfMemoryError -> L13 Exception -> L15
        r6.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));     // Catch: OutOfMemoryError -> L13 Exception -> L15
        if (r2 != CenterType.HORIZONTAL) goto L10;
        int r8 = r1.x;     // Catch: OutOfMemoryError -> L13 Exception -> L15
        Rect r13 = new Rect(r8 - r0, 0, r8 + r0, r3);     // Catch: OutOfMemoryError -> L13 Exception -> L15
    L11:
        r5.drawBitmap(r12, r13, r7, r6);     // Catch: OutOfMemoryError -> L13 Exception -> L15
        goto L19
    L18:
        return r4;
    L10:
        int r14 = r1.y;     // Catch: OutOfMemoryError -> L13 Exception -> L15
        r13 = new Rect(0, r14 - r0, r3, r14 + r0);     // Catch: OutOfMemoryError -> L13 Exception -> L15
        goto L11
    L6:
        r2 = CenterType.VERTICAL;     // Catch: OutOfMemoryError -> L13 Exception -> L15
    L13:
        return null;
    L19:
        return r12;
    }
}
