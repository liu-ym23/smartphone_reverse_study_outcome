package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.ImageView;
import com.bytedance.android.live.revenue.common.RevBitmapTranslateUtils;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ TogetherComboView a;
    public final /* synthetic */ ImageView b;

    public k(TogetherComboView r1, ImageView r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r13) {
        Bitmap r14 = (Bitmap) r13;
        if (r14 == null) goto L20;
        float r0 = Math.min(r14.getWidth(), r14.getHeight()) / 2.0f;
        float r2 = 1.2f * r0;
        PointF r3 = new PointF(-r2, (r0 * 2) - r2);
        int r1 = RevBitmapTranslateUtils.a;
        Intrinsics.checkNotNullParameter(r14, "bitmap");
        Intrinsics.checkNotNullParameter(r3, "maskPoint");
        Bitmap r4 = RevBitmapTranslateUtils.b(r14);     // Catch: OutOfMemoryError -> L11 Exception -> L12
        if (r4 == null) goto L13;
        Bitmap r5 = Bitmap.createBitmap(r4.getWidth(), r4.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: OutOfMemoryError -> L11 Exception -> L12
        Canvas r6 = new Canvas(r5);     // Catch: OutOfMemoryError -> L11 Exception -> L12
        Paint r7 = new Paint();     // Catch: OutOfMemoryError -> L11 Exception -> L12
        r7.setAntiAlias(true);     // Catch: OutOfMemoryError -> L11 Exception -> L12
        r6.drawARGB(0, 0, 0, 0);     // Catch: OutOfMemoryError -> L11 Exception -> L12
        r7.setColor(-16777216);     // Catch: OutOfMemoryError -> L11 Exception -> L12
        r7.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));     // Catch: OutOfMemoryError -> L11 Exception -> L12
        float r9 = r3.x;     // Catch: OutOfMemoryError -> L11 Exception -> L12
        float r8 = r3.y;     // Catch: OutOfMemoryError -> L11 Exception -> L12
        float r10 = 2.0f * r2;     // Catch: OutOfMemoryError -> L11 Exception -> L12
        r6.drawRoundRect(new RectF(r9, r8, r9 + r10, r10 + r8), r2, r2, r7);     // Catch: OutOfMemoryError -> L11 Exception -> L12
        Rect r11 = new Rect(0, 0, r4.getWidth(), r4.getHeight());     // Catch: OutOfMemoryError -> L11 Exception -> L12
        r6.drawBitmap(r4, r11, r11, r7);     // Catch: OutOfMemoryError -> L11 Exception -> L12
        r14 = r5;
        goto L13
    L11:
        r14 = null;
    L13:
        ImageView r15 = this.b;
        if (r15 == null) goto L16;
        r15.setImageBitmap(r14);
    L16:
        this.a.invalidate();
        return;
    }
}
