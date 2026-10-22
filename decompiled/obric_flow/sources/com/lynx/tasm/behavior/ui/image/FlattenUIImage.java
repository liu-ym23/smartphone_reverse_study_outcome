package com.lynx.tasm.behavior.ui.image;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.lynx.animax.player.b;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.f0;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.g0;
import com.lynx.tasm.behavior.ui.p;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.y0;
import com.lynx.tasm.service.ILynxImageService;
import dn.f;
import g8.g;
import java.util.Map;
import wn.e;

/* JADX INFO: loaded from: classes2.dex */
public class FlattenUIImage extends LynxFlattenUI {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f10488a;

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final p convertToMeaningfulPaintingArea(int r5, int r10) {
        f r11 = this.f10488a;
        if (r11 == null) goto L8;
        b r12 = r11.g0;
        if (r12 == null) goto L8;
        r12.d();
    L8:
        getOriginLeft();
        getOriginTop();
        getWidth();
        getHeight();
        p r13 = new p();
        getAlpha();
        getScaleX();
        getScaleY();
        return r13;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        f r5 = this.f10488a;
        if (r5 != null) goto L5;
        return;
    L5:
        r5.m();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxFlattenUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void detachWithViewInfo(g0 r5) {
        f r10 = this.f10488a;
        if (r10 == null) goto L5;
        r10.Q = null;
        r10.R = r5;
        getLynxContext().l().registerImageAccordingToNodeIndex(this.mNodeIndex, this.f10488a);
    L5:
        this.f10488a = null;
        super.detachWithViewInfo(r5);
    }

    public final void i() {
        if (this.f10488a == null) goto L5;
        return;
    L5:
        f r5 = new f(getLynxContext());
        this.f10488a = r5;
        r5.Q = this;
        r5.j(this.mEvents);
        this.f10488a.g(this.mProps);
        this.f10488a.c(getWidth(), getHeight(), getPaddingLeft(), getPaddingRight(), getPaddingTop(), getPaddingBottom());
        f r10 = this.f10488a;
        r10.q();
        r10.n();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean needGenerateMeaningfulPaintingArea() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxFlattenUI
    public final void onDraw(Canvas r5) {
        i();
        super.onDraw(r5);
        this.f10488a.d(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        i();
        super.onLayoutUpdated();
        this.f10488a.c(getWidth(), getHeight(), getPaddingLeft(), getPaddingRight(), getPaddingTop(), getPaddingBottom());
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        i();
        onAnimationNodeReady();
        afterAnimationNodeReady();
        BackgroundDrawable r5 = (BackgroundDrawable) this.mLynxBackground.f10750b;
        if (r5 == null) goto L11;
        this.f10488a.e(r5.d());
        if (this.mLynxBackground.n() == null) goto L11;
        boolean r10 = this.mLynxBackground.n().a(getWidth(), getHeight());
        f r11 = this.f10488a;
        float[] r12 = this.mLynxBackground.n().c();
        if (r11.K == null) goto L9;
        if (r10 == true) goto L9;
    L10:
        r11.K = r12;
    L9:
        r11.f16675a |= 4096;
    L11:
        f r13 = this.f10488a;
        r13.q();
        r13.n();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        i();
        super.onPropsUpdated();
        this.f10488a.getClass();
    }

    @f0
    public void pauseAnimation(ReadableMap r5, Callback r10) {
        i();
        f r11 = this.f10488a;
        e r12 = r11.f16687j;
        if (r12 == null) goto L12;
        wn.b r13 = r12.f;
        if (r13 == null) goto L7;
        Drawable r14 = r13.f22876c;
    L8:
        g r15 = r11.f16679c;
        r15.getClass();
        if (((ILynxImageService) r15.f17073b).pauseAnimation(r14) == false) goto L12;
        r10.invoke(new Object[]{0, "Animation paused."});
        return;
    L7:
        r14 = null;
    L12:
        r10.invoke(new Object[]{4, "Not support pause yet"});
    }

    @f0
    public void resumeAnimation(ReadableMap r5, Callback r10) {
        i();
        f r11 = this.f10488a;
        e r12 = r11.f16687j;
        if (r12 == null) goto L12;
        wn.b r13 = r12.f;
        if (r13 == null) goto L7;
        Drawable r14 = r13.f22876c;
    L8:
        g r15 = r11.f16679c;
        r15.getClass();
        if (((ILynxImageService) r15.f17073b).resumeAnimation(r14) == false) goto L12;
        r10.invoke(new Object[]{0, "Animation resumed."});
        return;
    L7:
        r14 = null;
    L12:
        r10.invoke(new Object[]{4, "Not support resume yet"});
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map r5) {
        i();
        super.setEvents(r5);
        this.f10488a.j(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setImageRendering(int r5) {
        i();
        super.setImageRendering(r5);
        f r10 = this.f10488a;
        if (r5 != 2) goto L5;
        boolean r11 = true;
    L6:
        r10.f16683f0 = r11;
        return;
    L5:
        r11 = false;
        goto L6
    }

    @f0
    public void startAnimate(ReadableMap r5, Callback r10) {
        i();
        f r11 = this.f10488a;
        e r12 = r11.f16687j;
        if (r12 == null) goto L12;
        wn.b r13 = r12.f;
        if (r13 == null) goto L7;
        Drawable r14 = r13.f22876c;
    L8:
        g r15 = r11.f16679c;
        r15.getClass();
        if (((ILynxImageService) r15.f17073b).startAnimation(r14) == false) goto L12;
        r10.invoke(new Object[]{0, "Animation started."});
        return;
    L7:
        r14 = null;
    L12:
        r10.invoke(new Object[]{4, "Not support start yet"});
    }

    @f0
    public void stopAnimation(ReadableMap r5, Callback r10) {
        i();
        f r11 = this.f10488a;
        e r12 = r11.f16687j;
        if (r12 == null) goto L12;
        wn.b r13 = r12.f;
        if (r13 == null) goto L7;
        Drawable r14 = r13.f22876c;
    L8:
        g r15 = r11.f16679c;
        r15.getClass();
        if (((ILynxImageService) r15.f17073b).stopAnimation(r14) == false) goto L12;
        r10.invoke(new Object[]{0, "Animation stopped."});
        return;
    L7:
        r14 = null;
    L12:
        r10.invoke(new Object[]{4, "Not support stop yet"});
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updatePropertiesInterval(y0 r5) {
        i();
        super.updatePropertiesInterval(r5);
        this.f10488a.g(r5.f10815a);
    }
}
