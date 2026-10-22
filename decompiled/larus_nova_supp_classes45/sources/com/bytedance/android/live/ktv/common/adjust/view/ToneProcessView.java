package com.bytedance.android.live.ktv.common.adjust.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/ktv/common/adjust/view/ToneProcessView;", "Landroid/view/View;", "", "color", "", "setHighLightColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ToneProcessView extends View {
    public final Paint a;
    public final Paint b;
    public final float c;
    public final int d;
    public int e;
    public final int f;
    public final float g;
    public final float h;
    public final RectF i;
    public int j;

    public ToneProcessView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ToneProcessView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        super.onDraw(r7);
        int r0 = getWidth();
        int r1 = this.f;
        this.e = (r0 - (this.d * r1)) / (r1 - 1);
        int r2 = 1;
        if (1 > r1) goto L12;
    L4:
        float r3 = r2 - 1;
        int r4 = this.d;
        float r5 = (this.e + r4) * r3;
        RectF r6 = this.i;
        r6.left = r5;
        r6.right = r5 + r4;
        r6.top = (getHeight() - this.c) - (r3 * this.h);
        this.i.bottom = getHeight();
        if (r2 != this.j) goto L8;
        if (r7 == null) goto L10;
        RectF r8 = this.i;
        float r9 = this.g;
        r7.drawRoundRect(r8, r9, r9, this.a);
    L10:
        if (r2 == r1) goto L14;
        r2 = r2 + 1;
        goto L4
    L14:
        return;
    L8:
        if (r7 == null) goto L10;
        RectF r11 = this.i;
        float r12 = this.g;
        r7.drawRoundRect(r11, r12, r12, this.b);
        goto L10
    }

    public final void setHighLightColor(int r2) {
        this.a.setColor(r2);
        invalidate();
    }

    public ToneProcessView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        Paint r7 = new Paint();
        r7.setDither(true);
        r7.setAntiAlias(true);
        r7.setStyle(Paint.Style.FILL_AND_STROKE);
        Unit r1 = Unit.INSTANCE;
        this.a = r7;
        Paint r2 = new Paint();
        r2.setDither(true);
        r2.setAntiAlias(true);
        r2.setStyle(Paint.Style.FILL_AND_STROKE);
        this.b = r2;
        this.i = new RectF();
        TypedArray r8 = r4.obtainStyledAttributes(r5, new int[]{2130968959, 2130970215, 2130972708, 2130972761, 2130972837, 2130974313, 2130974602, 2130974603});
        r7.setColor(r8.getColor(1, s1.h(2131107726)));
        r2.setColor(r8.getColor(4, ColorProtector.parseColor("#898A8F")));
        int r9 = r8.getInteger(7, 9);
        this.f = r9;
        this.d = r8.getDimensionPixelSize(5, s1.f(3.0f));
        this.g = r8.getDimensionPixelSize(0, s1.f(22.0f));
        float r11 = r8.getDimensionPixelSize(3, s1.f(3.0f));
        this.c = r11;
        float r3 = r8.getDimensionPixelSize(2, s1.f(18.0f));
        r8.recycle();
        this.j = (r9 / 2) + 1;
        this.h = (r3 - r11) / (r9 - 1);
    }

    public /* synthetic */ ToneProcessView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
