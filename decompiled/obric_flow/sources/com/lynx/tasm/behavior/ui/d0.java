package com.lynx.tasm.behavior.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 extends com.lynx.tasm.behavior.ui.view.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f10447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b0 f10448c;
    public final WeakReference d;

    public d0(UIShadowProxy r5, Context r10) {
        super(r10);
        this.d = new WeakReference(r5);
        setWillNotDraw(false);
    }

    @Override // com.lynx.tasm.behavior.ui.view.b, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r12) {
        WeakReference r5 = this.d;
        UIShadowProxy r10 = (UIShadowProxy) r5.get();
        if (r10 != null) goto L5;
    L7:
        ArrayList r11 = this.f10447b;
        if (r11 == null) goto L12;
        if (r11.isEmpty() == true) goto L12;
    L14:
        UIShadowProxy r13 = (UIShadowProxy) r5.get();
        if (r13 == null) goto L17;
        float r14 = r13.getAlpha();
    L19:
        if (r14 > 0.001f) goto L22;
    L47:
        super.dispatchDraw(r12);
        b0 r15 = this.f10448c;
        if (r15 == null) goto L55;
        r15.a(r12);
        return;
    L55:
        return;
    L22:
        if (r14 >= 1.0f) goto L24;
        r12.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), (int) (r14 * 255.0f), 31);
    L25:
        if (r13 == null) goto L36;
        UIShadowProxy r16 = (UIShadowProxy) r5.get();
        r16.d.reset();
        LynxBaseUI r17 = r16.f10388a;
        boolean r18 = r17 instanceof LynxUI;
        Matrix r19 = r16.d;
        if (r18 == false) goto L33;
        View r20 = ((LynxUI) r17).getView();
        if (r20 == null) goto L33;
        float r21 = r20.getPivotX() + r17.getLeft();
        float r22 = r20.getPivotY() + r17.getTop();
        r19.preTranslate(r20.getTranslationX(), r20.getTranslationY());
        r19.preScale(r20.getScaleX(), r20.getScaleY(), r21, r22);
        r19.preRotate(r20.getRotation(), r21, r22);
    L33:
        if (r19.isIdentity() == true) goto L35;
        r12.concat(r19);
    L35:
        setTranslationZ(((UIShadowProxy) r5.get()).getTranslationZ());
    L36:
        ArrayList r23 = this.f10447b;
        if (r23 == null) goto L46;
        int r24 = r23.size() - 1;
    L39:
        if (r24 < 0) goto L46;
        c0 r25 = (c0) this.f10447b.get(r24);
        if (r25 == null) goto L45;
        if (r25.f10434k.b() == true) goto L45;
        r25.d(r12);
    L45:
        r24 = r24 - 1;
    L46:
        r12.restore();
        goto L47
    L24:
        r12.save();
        goto L25
    L17:
        r14 = 1.0f;
    L12:
        if (this.f10448c != null) goto L14;
    L5:
        if (r10.e == false) goto L7;
        r10.j();
        r10.e = false;
        goto L7
    }

    @Override // com.lynx.tasm.behavior.ui.view.b, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
    }
}
