package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Drawable f3956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Rect f3957b;
    private Rect c;
    private boolean d;
    private boolean e;

    public ScrimInsetsFrameLayout(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public ScrimInsetsFrameLayout(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), 0);
    }

    public ScrimInsetsFrameLayout(Context r9, AttributeSet r10, int r11) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r2, r3, r11);
        this.c = new Rect();
        this.d = true;
        this.e = true;
        TypedArray r12 = k.a(r2, r3, R.styleable.ScrimInsetsFrameLayout, r11, ZeusTransformUtils.mapRes(R.style.Widget_Design_ScrimInsetsFrameLayout, "style", "Widget_Design_ScrimInsetsFrameLayout"), new int[0]);
        this.f3956a = r12.getDrawable(ZeusTransformUtils.mapRes(R.styleable.ScrimInsetsFrameLayout_insetForeground, "styleable", "ScrimInsetsFrameLayout_insetForeground"));
        r12.recycle();
        setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(this, new AnonymousClass1(this));
    }

    public void a(WindowInsetsCompat r1) {
    }

    @Override // android.view.View
    public void draw(Canvas r9) {
        super.draw(r9);
        int r0 = getWidth();
        int r1 = getHeight();
        if (this.f3957b != null) goto L5;
        return;
    L5:
        if (this.f3956a == null) goto L15;
        int r2 = r9.save();
        r9.translate(getScrollX(), getScrollY());
        if (this.d == false) goto L10;
        this.c.set(0, 0, r0, this.f3957b.top);
        this.f3956a.setBounds(this.c);
        this.f3956a.draw(r9);
    L10:
        if (this.e == false) goto L12;
        this.c.set(0, r1 - this.f3957b.bottom, r0, r1);
        this.f3956a.setBounds(this.c);
        this.f3956a.draw(r9);
    L12:
        this.c.set(0, this.f3957b.top, this.f3957b.left, r1 - this.f3957b.bottom);
        this.f3956a.setBounds(this.c);
        this.f3956a.draw(r9);
        this.c.set(r0 - this.f3957b.right, this.f3957b.top, r0, r1 - this.f3957b.bottom);
        this.f3956a.setBounds(this.c);
        this.f3956a.draw(r9);
        r9.restoreToCount(r2);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable r0 = this.f3956a;
        if (r0 == null) goto L6;
        r0.setCallback(this);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable r1 = this.f3956a;
        if (r1 == null) goto L6;
        r1.setCallback(null);
        return;
    }

    public void setDrawBottomInsetForeground(boolean r1) {
        this.e = r1;
    }

    public void setDrawTopInsetForeground(boolean r1) {
        this.d = r1;
    }

    public void setScrimInsetForeground(Drawable r1) {
        this.f3956a = r1;
    }
}
