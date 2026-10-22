package com.ss.android.lark.imageqrcode.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.imageqrcode.QRCodeContentInfo;
import com.ss.android.lark.imageqrcode.QRCodeShowParam;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ FrameLayout a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ QRCodeShowParam c;
    public final /* synthetic */ ImageQRCodeSelectActivity d;

    /* JADX WARN: Type inference failed for: r3v5, types: [android.content.Context, com.ss.android.lark.imageqrcode.ui.ImageQRCodeSelectActivity, java.lang.Object] */
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.a.removeAllViews();
        int r1 = com.ss.android.lark.imageqrcode.utils.a.a;
        FrameLayout r2 = this.a;
        Bitmap r3 = this.b;
        QRCodeShowParam.ScaleType r4 = this.c.getScaleType();
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "bgBitmap");
        Intrinsics.checkNotNullParameter(r4, "scaleType");
        RectF r5 = new RectF();
        int r6 = r2.getWidth();
        int r7 = r2.getHeight();
        float r8 = r6;
        float r9 = r3.getWidth();
        float r10 = r8 / r9;
        float r11 = r7;
        float r12 = r3.getHeight();
        float r13 = r11 / r12;
        if (r4 != QRCodeShowParam.ScaleType.FIT_CENTER) goto L5;
        float r14 = RangesKt.coerceAtMost(r10, r13);
    L6:
        float r15 = r9 * r14;
        float r16 = r12 * r14;
        float r17 = (r8 - r15) / 2.0f;
        r5.left = r17;
        float r18 = (r11 - r16) / 2.0f;
        r5.top = r18;
        r5.right = r17 + r15;
        r5.bottom = r18 + r16;
        Bitmap r19 = BitmapFactory.decodeResource(this.a.getResources(), 2131247423);
        ArrayList<QRCodeContentInfo> r20 = this.c.getContentList();
        ?? r21 = this.d;
        FrameLayout r22 = this.a;
        Iterator<T> r23 = r20.iterator();
    L8:
        if (r23.hasNext() == false) goto L10;
        QRCodeContentInfo r24 = (QRCodeContentInfo) r23.next();
        Intrinsics.checkNotNull(r19);
        QRCodeShowParam r25 = ImageQRCodeSelectActivity.d;
        r21.getClass();
        RectF r26 = new RectF();
        r26.left = r5.left + (r24.getLeftRatio() * r5.width());
        r26.top = r5.top + (r24.getTopRatio() * r5.height());
        r26.right = r5.left + (r24.getRightRatio() * r5.width());
        r26.bottom = r5.top + (r24.getBottomRatio() * r5.height());
        r26.intersect(r5);
        AppCompatImageView r27 = new AppCompatImageView(r21);
        r27.setImageBitmap(r19);
        int r110 = ImageQRCodeSelectActivity.e;
        FrameLayout.LayoutParams r28 = new FrameLayout.LayoutParams(r110, r110);
        double r111 = ((double) r110) / 2.0d;
        r28.leftMargin = (int) (((double) r26.centerX()) - r111);
        r28.topMargin = (int) (((double) r26.centerY()) - r111);
        r22.addView(r27, r28);
        r27.setOnClickListener(new a(r21, r24));
        AnimatorSet r29 = new AnimatorSet();
        ObjectAnimator r30 = ObjectAnimator.ofFloat(r27, "scaleX", new float[]{1.0f, 0.8f, 1.0f, 0.8f, 1.0f}).setDuration(1320);
        r29.play(r30).with(ObjectAnimator.ofFloat(r27, "scaleY", new float[]{1.0f, 0.8f, 1.0f, 0.8f, 1.0f}).setDuration(1320));
        r29.addListener(new f(r21, r29));
        r21.b.add(r29);
        r29.start();
        goto L8
    L10:
        return;
    L5:
        r14 = RangesKt.coerceAtLeast(r10, r13);
        goto L6
    }

    public e(FrameLayout r1, Bitmap r2, QRCodeShowParam r3, ImageQRCodeSelectActivity r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
