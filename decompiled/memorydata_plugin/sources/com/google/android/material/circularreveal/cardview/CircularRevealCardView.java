package com.google.android.material.circularreveal.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.circularreveal.b;
import com.google.android.material.circularreveal.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class CircularRevealCardView extends MaterialCardView implements c {
    private final b helper;

    public CircularRevealCardView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public CircularRevealCardView(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        this.helper = new b(this);
    }

    @Override // com.google.android.material.circularreveal.b.a
    public void actualDraw(Canvas r1) {
        super.draw(r1);
    }

    @Override // com.google.android.material.circularreveal.b.a
    public boolean actualIsOpaque() {
        return super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.c
    public void buildCircularRevealCache() {
        this.helper.a();
    }

    @Override // com.google.android.material.circularreveal.c
    public void destroyCircularRevealCache() {
        this.helper.b();
    }

    @Override // android.view.View
    public void draw(Canvas r2) {
        b r0 = this.helper;
        if (r0 == null) goto L5;
        r0.a(r2);
        return;
    L5:
        super.draw(r2);
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.helper.e();
    }

    @Override // com.google.android.material.circularreveal.c
    public int getCircularRevealScrimColor() {
        return this.helper.d();
    }

    @Override // com.google.android.material.circularreveal.c
    public c.d getRevealInfo() {
        return this.helper.c();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        b r0 = this.helper;
        if (r0 == null) goto L7;
        return r0.f();
    L7:
        return super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealOverlayDrawable(Drawable r1) {
        this.helper.a(r1);
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealScrimColor(int r1) {
        this.helper.a(r1);
    }

    @Override // com.google.android.material.circularreveal.c
    public void setRevealInfo(c.d r1) {
        this.helper.a(r1);
    }
}
