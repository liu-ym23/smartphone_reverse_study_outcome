package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import androidx.core.content.ContextCompat;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t extends g {
    public boolean A;
    public boolean B;
    public boolean C;
    public CompositeBoxType D;
    public int E;
    public final float r;
    public final float s;
    public final int t;
    public final double u;
    public final Paint v;
    public final Path w;
    public final RectF x;
    public boolean y;
    public boolean z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CompositeBoxType.values().length];
            r0[CompositeBoxType.CompositeTopBox.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CompositeBoxType.CompositeBottomBox.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final Pair<Boolean, Boolean> getItemSpace() {
        return new Pair(Boolean.valueOf(this.y), Boolean.valueOf(this.z));
    }

    @Override // com.larus.bmhome.chat.layout.item.g, com.larus.bmhome.chat.layout.item.i
    public Integer getImmerseBgColor() {
        return super.getImmerseBgColor();
    }

    @Override // com.larus.bmhome.chat.layout.item.g, com.larus.bmhome.chat.layout.item.i
    public boolean getUseSubscribedColor() {
        return super.getUseSubscribedColor();
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public int getBoxType() {
        return this.E;
    }

    public t(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6);
        float r7 = i5.Y();
        this.r = r7;
        float r0 = i5.q();
        this.s = r0;
        this.t = i5.h();
        this.u = r0 - Math.sqrt((r0 * r0) - (r7 * r7));
        Paint r8 = new Paint();
        r8.setColor(-16776961);
        r8.setStrokeWidth(1.0f);
        r8.setStyle(Paint.Style.FILL);
        r8.setAntiAlias(true);
        this.v = r8;
        this.w = new Path();
        this.x = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.y = true;
        this.z = true;
        this.D = CompositeBoxType.CompositeTopBox;
        setWillNotDraw(false);
        setBackground(null);
        this.E = super.getBoxType();
    }

    @Override // android.view.View
    public final void draw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        if (getImmerseBgColor() == null) goto L7;
        Integer r0 = getImmerseBgColor();
        if (r0 == null) goto L8;
        int r1 = r0.intValue();
        this.v.setColor(r1);
    L8:
        setBackground(null);
        super.draw(r6);
        return;
    L7:
        this.v.setColor(ContextCompat.getColor(getContext(), v19.c.b(2130970533, getContext(), 2131102542)));
        goto L8
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r15) {
        Intrinsics.checkNotNullParameter(r15, "canvas");
        int r0 = b.a[this.D.ordinal()];
        if (r0 == 1) goto L25;
        if (r0 != 2) goto L6;
        this.v.setStyle(Paint.Style.FILL);
        RectF r1 = this.x;
        r1.left = 0.0f;
        float r2 = getHeight();
        float r4 = 2;
        float r7 = this.s * r4;
        r1.top = r2 - r7;
        r1.right = r7;
        r1.bottom = getHeight();
        this.w.reset();
        this.w.moveTo(0.0f, 0.0f);
        this.w.arcTo(this.x, 90.0f, 90.0f, true);
        this.w.lineTo(getWidth(), getHeight() - this.s);
        RectF r3 = this.x;
        r3.left = getWidth() - (this.s * r4);
        r3.top = getHeight() - (r4 * this.s);
        r3.right = getWidth();
        r3.bottom = getHeight();
        this.w.arcTo(this.x, 0.0f, 90.0f, false);
        if (getHeight() <= i5.h()) goto L24;
        this.w.moveTo(getWidth(), getHeight() - this.s);
        this.w.lineTo(getWidth(), 0.0f);
        this.w.lineTo(0.0f, 0.0f);
        this.w.lineTo(0.0f, getHeight() - this.s);
    L24:
        this.w.close();
        r15.drawPath(this.w, this.v);
    L29:
        super.onDraw(r15);
        return;
    L6:
        if (this.B == true) goto L8;
        r15.drawRect(0.0f, 0.0f, getWidth(), this.r, this.v);
    L9:
        this.w.reset();
        this.v.setStyle(Paint.Style.FILL);
        if (this.B == false) goto L12;
        float r9 = this.r;
    L14:
        if (this.C == false) goto L16;
        float r5 = this.r;
    L17:
        r15.drawRect(0.0f, r9, getWidth(), getHeight() - r5, this.v);
        if (this.C == true) goto L20;
        r15.drawRect(0.0f, getHeight() - this.r, getWidth(), getHeight(), this.v);
        goto L29
    L20:
        this.v.setStyle(Paint.Style.FILL);
        RectF r6 = this.x;
        r6.left = 0.0f;
        float r8 = getHeight();
        float r10 = this.s;
        r6.top = (r8 - r10) - this.r;
        float r11 = 2;
        r6.right = r10 * r11;
        r6.bottom = (getHeight() + this.s) - this.r;
        this.w.reset();
        this.w.arcTo(this.x, 165.5225f, 14.4775f, true);
        this.w.lineTo(getWidth(), getHeight() - this.r);
        RectF r12 = this.x;
        r12.left = getWidth() - (r11 * this.s);
        r12.top = (getHeight() - this.s) - this.r;
        r12.right = getWidth();
        r12.bottom = (getHeight() + this.s) - this.r;
        this.w.arcTo(this.x, 0.0f, 14.4775f, false);
        this.w.close();
        r15.drawPath(this.w, this.v);
        goto L29
    L16:
        r5 = 0.0f;
        goto L17
    L12:
        r9 = 0.0f;
        goto L14
    L8:
        this.v.setStyle(Paint.Style.FILL);
        RectF r13 = this.x;
        r13.left = 0.0f;
        float r14 = this.r;
        float r16 = this.s;
        r13.top = r14 - r16;
        float r17 = 2;
        r13.right = r16 * r17;
        r13.bottom = r16 + r14;
        this.w.reset();
        this.w.moveTo(0.0f, 0.0f);
        this.w.arcTo(this.x, 180.0f, 14.4775f, true);
        this.w.lineTo((float) (((double) getWidth()) - (((double) 2) * this.u)), 0.0f);
        RectF r18 = this.x;
        float r19 = getWidth();
        float r20 = this.s;
        r18.left = r19 - (r17 * r20);
        r18.top = this.r - r20;
        r18.right = getWidth();
        r18.bottom = this.r + this.s;
        this.w.arcTo(this.x, -14.4775f, 14.4775f, false);
        this.w.moveTo(getWidth(), this.r);
        this.w.close();
        r15.drawPath(this.w, this.v);
        goto L9
    L25:
        this.v.setStyle(Paint.Style.FILL);
        RectF r21 = this.x;
        r21.left = 0.0f;
        r21.top = 0.0f;
        float r22 = 2;
        float r23 = this.s * r22;
        r21.right = r23;
        r21.bottom = r23;
        this.w.reset();
        this.w.moveTo(0.0f, 0.0f);
        this.w.arcTo(this.x, 180.0f, 90.0f, true);
        this.w.lineTo(getWidth(), 0.0f);
        RectF r24 = this.x;
        r24.left = getWidth() - (this.s * r22);
        r24.top = 0.0f;
        r24.right = getWidth();
        r24.bottom = r22 * this.s;
        this.w.arcTo(this.x, -90.0f, 90.0f, false);
        if (getHeight() <= i5.h()) goto L28;
        this.w.lineTo(getWidth(), getHeight());
        this.w.lineTo(0.0f, getHeight());
        this.w.lineTo(0.0f, getHeight() - i5.q());
    L28:
        this.w.close();
        r15.drawPath(this.w, this.v);
        goto L29
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public void setBoxType(int r1) {
        super.setBoxType(r1);
        this.E = r1;
    }

    @Override // com.larus.bmhome.chat.layout.item.g, com.larus.bmhome.chat.layout.item.i
    public void setImmerseBgColor(Integer r1) {
        super.setImmerseBgColor(r1);
    }

    public final void setNeedKeepWidthToMaxWidth(boolean r1) {
        this.A = r1;
    }

    public final void setUpCompositeBoxType(CompositeBoxType r2) {
        Intrinsics.checkNotNullParameter(r2, "compositeBoxType");
        this.D = r2;
    }

    public final void setUpMiddleNeedBottomRadius(boolean r1) {
        this.C = r1;
    }

    public final void setUpMiddleNeedTopRadius(boolean r1) {
        this.B = r1;
    }

    @Override // com.larus.bmhome.chat.layout.item.g, com.larus.bmhome.chat.layout.item.i
    public void setUseSubscribedColor(boolean r1) {
        super.setUseSubscribedColor(r1);
    }

    @Override // com.larus.bmhome.chat.layout.item.g, com.larus.bmhome.chat.layout.item.i
    public final void l(boolean r1, boolean r2) {
        super.l(r1, r2);
    }

    @Override // com.larus.bmhome.chat.layout.item.i, android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        CompositeBoxType r3 = this.D;
        if (r3 != CompositeBoxType.CompositeTopBox) goto L5;
    L6:
        int r4 = getMeasuredHeight();
        int r5 = this.t;
        if (r4 >= r5) goto L9;
        r4 = r5;
    L9:
        setMeasuredDimension(getMaxWidth(), r4);
        return;
    L5:
        if (r3 == CompositeBoxType.CompositeBottomBox) goto L6;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public final void i(int r4, int r5, int[] r6) {
        Intrinsics.checkNotNullParameter(r6, "outSpec");
        if (this.A == false) goto L5;
        r6[0] = View.MeasureSpec.makeMeasureSpec(getMaxWidth(), 1073741824);
        r6[1] = r5;
        return;
    L5:
        r6[0] = View.MeasureSpec.makeMeasureSpec(getMaxWidth(), Integer.MIN_VALUE);
        r6[1] = r5;
    }
}
