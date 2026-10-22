package com.ss.android.lark.guide.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class BubbleLayout extends FrameLayout {
    public ConstraintLayout a;
    public RoundRectLayout b;
    public ArrowView c;
    public ConstraintLayout d;
    public int e;
    public int f;
    public float g;
    public int h;
    public float i;
    public float j;
    public float k;
    public boolean l;

    public static class a {
        public final BubbleLayout a;

        public a(BubbleLayout r1) {
            this.a = r1;
        }
    }

    public static class b {
        public final BubbleLayout a;

        public b(BubbleLayout r1) {
            this.a = r1;
        }
    }

    public a getArrowOffsetSetter() {
        return new a(this);
    }

    public b getConfigSetter() {
        return new b(this);
    }

    public final void i() {
        ConstraintLayout r0 = new ConstraintLayout(getContext());
        this.a = r0;
        r0.setId(2131364904);
        addView(this.a, new FrameLayout.LayoutParams(-2, -2));
        ConstraintLayout r1 = this.a;
        RoundRectLayout r2 = new RoundRectLayout(getContext());
        this.b = r2;
        r2.setId(2131364903);
        r1.addView(this.b, new ConstraintLayout.LayoutParams(-2, -2));
        ConstraintLayout r3 = this.a;
        ArrowView r4 = new ArrowView(getContext());
        this.c = r4;
        r4.setId(2131364888);
        ConstraintLayout r5 = new ConstraintLayout(getContext());
        this.d = r5;
        r5.setId(2131364889);
        this.d.addView(this.c);
        r3.addView(this.d);
    }

    public float getArrowMainLen() {
        return this.j;
    }

    public BubbleLayout(Context r1) {
        super(r1);
        this.e = 8388613;
        this.l = true;
        i();
    }

    private void setAnchorGravity(int r1) {
        this.e = r1;
    }

    private void setArrowColor(int r1) {
        this.h = r1;
    }

    private void setArrowCrossLength(float r1) {
        this.k = r1;
    }

    private void setArrowMainLength(float r1) {
        this.j = r1;
    }

    private void setArrowOffset(float r1) {
        this.i = r1;
    }

    private void setCardCornerRadius(float r1) {
        this.g = r1;
    }

    private void setCardFillColor(int r1) {
        this.f = r1;
    }

    private void setContentView(int r4) {
        View r5 = LayoutInflater.from(getContext()).inflate(r4, this.b, false);
        this.b.addView(r5, -2, -2);
    }

    private void setEnforceCornerForArrow(boolean r1) {
        this.l = r1;
    }

    private void setContentView(View r3) {
        this.b.addView(r3, -2, -2);
    }

    public BubbleLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.e = 8388613;
        this.l = true;
        i();
    }

    public static /* synthetic */ void a(BubbleLayout r0, boolean r1) {
        r0.setEnforceCornerForArrow(r1);
    }

    public static /* synthetic */ void b(BubbleLayout r0, float r1) {
        r0.setCardCornerRadius(r1);
    }

    public static /* synthetic */ void c(BubbleLayout r0, float r1) {
        r0.setArrowMainLength(r1);
    }

    public static /* synthetic */ void d(BubbleLayout r0, float r1) {
        r0.setArrowCrossLength(r1);
    }

    public static /* synthetic */ void e(BubbleLayout r0, View r1) {
        r0.setContentView(r1);
    }

    public static /* synthetic */ void f(BubbleLayout r0, int r1) {
        r0.setArrowColor(r1);
    }

    public static /* synthetic */ void g(BubbleLayout r0, float r1) {
        r0.setArrowOffset(r1);
    }

    public static /* synthetic */ void h(BubbleLayout r0, int r1) {
        r0.setAnchorGravity(r1);
    }

    public BubbleLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.e = 8388613;
        this.l = true;
        i();
    }
}
