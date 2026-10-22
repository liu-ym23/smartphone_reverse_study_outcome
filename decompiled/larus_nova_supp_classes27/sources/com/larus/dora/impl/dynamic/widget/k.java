package com.larus.dora.impl.dynamic.widget;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k extends ReplacementSpan {
    public final /* synthetic */ int a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ NewcomerGuideAdapter c;
    public final /* synthetic */ TextView d;

    public static final class a implements Drawable.Callback {
        public final /* synthetic */ TextView a;

        public a(TextView r1) {
            this.a = r1;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable r2) {
            Intrinsics.checkNotNullParameter(r2, "who");
            this.a.invalidate();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable r2, Runnable r3) {
            Intrinsics.checkNotNullParameter(r2, "who");
            Intrinsics.checkNotNullParameter(r3, "what");
            this.a.removeCallbacks(r3);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable r2, Runnable r3, long r4) {
            Intrinsics.checkNotNullParameter(r2, "who");
            Intrinsics.checkNotNullParameter(r3, "what");
            this.a.postDelayed(r3, r4);
        }
    }

    public k(int r1, boolean r2, NewcomerGuideAdapter r3, TextView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Intrinsics.checkNotNullParameter(r1, "paint");
        return ((int) r1.measureText(" ")) + this.a;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r2, CharSequence r3, int r4, int r5, float r6, int r7, int r8, int r9, Paint r10) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        Intrinsics.checkNotNullParameter(r10, "paint");
        float r11 = r6 + r10.measureText(" ");
        if (this.b == false) goto L17;
        NewcomerGuideAdapter r12 = this.c;
        int r13 = NewcomerGuideAdapter.f;
        final Drawable r14 = (Drawable) r12.c.getValue();
        if (r14 == null) goto L19;
        int r15 = this.a;
        NewcomerGuideAdapter r16 = this.c;
        r14.setCallback(new a(this.d));
        int r17 = (r7 + r9) / 2;
        int r18 = r15 / 2;
        r14.setBounds((int) r11, r17 - r18, (int) (r11 + r15), r17 + r18);
        r14.draw(r2);
        ValueAnimator r20 = r16.e;
        if (r20 != null) goto L9;
    L13:
        ValueAnimator r21 = r16.e;
        if (r21 == null) goto L16;
        r21.cancel();
    L16:
        ValueAnimator r22 = ValueAnimator.ofInt(new int[]{0, 10000});
        r22.setDuration(1000);
        r22.setRepeatCount(-1);
        r22.setInterpolator(new LinearInterpolator());
        r22.addUpdateListener(new j(r14));
        r22.start();
        r16.e = r22;
        g49.d.a("NewcomerGuideAdapter", "setTextWithIcon() started loading animation");
        return;
    L9:
        if (r20.isRunning() == true) goto L11;
        boolean r23 = true;
    L12:
        if (r23 == true) goto L13;
        return;
    L11:
        r23 = false;
        goto L12
    L19:
        return;
    L17:
        Paint.FontMetricsInt r24 = r10.getFontMetricsInt();
        r2.drawText(">", r11, ((r7 + r9) / 2) - ((r24.bottom + r24.top) / 2), r10);
    }
}
