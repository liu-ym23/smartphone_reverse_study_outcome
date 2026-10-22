package com.bytedance.android.ec.common.impl.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/common/impl/view/RoundCornerLinearlayout;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/ec/common/impl/view/b;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RoundCornerLinearlayout extends LinearLayout implements b {
    public final c a;

    public RoundCornerLinearlayout(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public RoundCornerLinearlayout(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    @Override // com.bytedance.android.ec.common.impl.view.b
    public final void h() {
        invalidate();
    }

    @Override // android.view.View
    public final void draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        c r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "canvas");
        if (r1.a == 0) goto L5;
    L11:
        int r0 = r10.saveLayer(r1.e, r1.h);
        r1.g.reset();
        r1.g.addRoundRect(r1.e, r1.f, Path.Direction.CW);
        r10.drawPath(r1.g, r1.h);
        r1.h.setXfermode(r1.i);
        r10.saveLayer(r1.e, r1.h);
        r1.j.g(r10);
        r1.h.setXfermode(null);
        r1.h.setColorFilter(null);
        r10.restoreToCount(r0);
        return;
    L5:
        if (r1.c != 0) goto L11;
        if (r1.b != 0) goto L11;
        if (r1.d != 0) goto L11;
        r1.j.g(r10);
    }

    @Override // com.bytedance.android.ec.common.impl.view.b
    public final void g(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.draw(r10);
    }

    public RoundCornerLinearlayout(Context r12, AttributeSet r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, r14);
        c r1 = new c(this);
        this.a = r1;
        Intrinsics.checkNotNullParameter(r12, "context");
        TypedArray r15 = r12.obtainStyledAttributes(r13, new int[]{2130969905, 2130969911, 2130969912, 2130969921, 2130969922}, r14, 0);
        if (r15 == null) goto L17;
        int r16 = r15.getDimensionPixelSize(0, 0);
        int r10 = r15.getDimensionPixelSize(2, r16);
        int r11 = r15.getDimensionPixelSize(1, r16);
        int r17 = r15.getDimensionPixelSize(4, r16);
        int r18 = r15.getDimensionPixelSize(3, r16);
        r1.a = r10;
        r1.b = r11;
        r1.c = r17;
        r1.d = r18;
        float[] r19 = r1.f;
        float r110 = r10;
        r19[0] = r110;
        r19[1] = r110;
        float r20 = r17;
        r19[2] = r20;
        r19[3] = r20;
        float r111 = r18;
        r19[4] = r111;
        r19[5] = r111;
        float r112 = r11;
        r19[6] = r112;
        r19[7] = r112;
        if (r11 > 0) goto L9;
        if (r10 > 0) goto L9;
        if (r17 > 0) goto L9;
        if (r18 > 0) goto L9;
    L15:
        r1.j.h();
        r15.recycle();
        return;
    L9:
        Object r113 = r1.j;
        if ((r113 instanceof ViewGroup) == true) goto L12;
        r113 = null;
    L12:
        ViewGroup r114 = (ViewGroup) r113;
        if (r114 == null) goto L15;
        r114.setWillNotDraw(false);
        goto L15
    }

    public /* synthetic */ RoundCornerLinearlayout(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r10, int r11, int r12) {
        super.onSizeChanged(r1, r10, r11, r12);
        c r13 = this.a;
        int r14 = getWidth();
        int r15 = getHeight();
        if (r13.a == 0) goto L5;
    L10:
        if (r14 == 0) goto L16;
        if (r15 == 0) goto L17;
        r13.e.set(0.0f, 0.0f, r14, r15);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        if (r13.c != 0) goto L10;
        if (r13.d != 0) goto L10;
        if (r13.b != 0) goto L10;
    }
}
