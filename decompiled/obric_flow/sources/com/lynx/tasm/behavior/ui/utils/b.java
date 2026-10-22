package com.lynx.tasm.behavior.ui.utils;

import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.renderscript.Matrix4f;
import androidx.core.view.ViewCompat;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends g {
    public final WeakReference f;
    public n g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PointF f10738h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10739i;

    public b(LynxUI r5, LynxContext r10) {
        super(r10);
        this.f10738h = null;
        this.f10739i = true;
        this.f = new WeakReference(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.utils.g, com.lynx.tasm.behavior.ui.utils.h
    public final /* bridge */ /* synthetic */ f a() {
        return m();
    }

    @Override // com.lynx.tasm.behavior.ui.utils.g
    public final BackgroundDrawable m() {
        LynxUI r5 = (LynxUI) this.f.get();
        if (r5 != null) goto L5;
        return null;
    L5:
        BackgroundDrawable r10 = new BackgroundDrawable(this.f10749a, this.d);
        if (r5.getView() == null) goto L12;
        Drawable r11 = r5.getView().getBackground();
        r5.getView().setBackground(null);
        if (r11 != null) goto L11;
        r5.getView().setBackground(r10);
        return r10;
    L11:
        r5.getView().setBackground(new LayerDrawable(new Drawable[]{r10, r11}));
    L12:
        return r10;
    }

    public final void o(List r21) {
        int r5 = 0;
        WeakReference r10 = this.f;
        LynxUI r11 = (LynxUI) r10.get();
        if (r11 == null) goto L63;
        LynxUI r12 = (LynxUI) r10.get();
        float r13 = 0.0f;
        if (r12 != null) goto L8;
    L11:
        if (r21 != null) goto L13;
        return;
    L13:
        boolean r14 = this.f10739i;
        LynxContext r15 = this.f10749a;
        if (r14 == false) goto L46;
        r15.f10145m.getFontSize();
        r15.f10145m.getLatestWidth();
        r15.f10145m.getLatestHeight();
        int r16 = r11.getLatestWidth();
        int r17 = r11.getLatestHeight();
        n r18 = new n(0);
        if (r21.isEmpty() == true) goto L45;
        Matrix4f r19 = new Matrix4f();
        Iterator r20 = r21.iterator();
    L20:
        if (r20.hasNext() == false) goto L44;
        o r110 = (o) r20.next();
        int r111 = r110.f10762a;
        if (r111 == 1) goto L43;
        if (r111 == 2) goto L42;
        LinkedHashMap r112 = (LinkedHashMap) r18.f10761a;
        float r22 = r110.e;
        float r23 = r110.f10763b;
        switch(r111) {
            case 4: goto L41;
            case 8: goto L40;
            case 16: goto L39;
            case 32: goto L38;
            case 64: goto L37;
            case 128: goto L36;
            case 256: goto L38;
            case 512: goto L35;
            case 1024: goto L34;
            case 2048: goto L33;
            case 4096: goto L32;
            case 8192: goto L31;
            case 16384: goto L30;
            case 32768: goto L27;
            case 65536: goto L27;
            default: goto L26;
        };
    L27:
        r19.multiply(new Matrix4f(r110.f10767j));
    L28:
        r5 = 0;
        goto L20
    L30:
        double r113 = r23;
        double[][] r24 = com.lynx.tasm.utils.f.f11168a;
        r112.put("skewY", Float.valueOf((float) Math.tan((float) ((r113 * 3.141592653589793d) / 180.0d))));
        goto L28
    L31:
        double r114 = r23;
        double[][] r25 = com.lynx.tasm.utils.f.f11168a;
        r112.put("skewX", Float.valueOf((float) Math.tan((float) ((r114 * 3.141592653589793d) / 180.0d))));
        goto L28
    L32:
        double r115 = r23;
        double[][] r26 = com.lynx.tasm.utils.f.f11168a;
        r112.put("skewX", Float.valueOf((float) Math.tan((float) ((r115 * 3.141592653589793d) / 180.0d))));
        r112.put("skewY", Float.valueOf((float) Math.tan((float) ((((double) r22) * 3.141592653589793d) / 180.0d))));
        goto L28
    L33:
        r19.scale(1.0f, r23, 1.0f);
        goto L28
    L34:
        r19.scale(r23, 1.0f, 1.0f);
        goto L28
    L35:
        r19.scale(r23, r22, 1.0f);
        goto L28
    L36:
        r19.rotate(r23, 0.0f, 1.0f, 0.0f);
        goto L28
    L37:
        r19.rotate(r23, 1.0f, 0.0f, 0.0f);
        goto L28
    L38:
        r19.rotate(r23, 0.0f, 0.0f, 1.0f);
        goto L28
    L39:
        r5 = 0;
        goto L43
    L40:
        r5 = 0;
        r19.translate(0.0f, 0.0f, n.g(r110, 0, 0.0f));
        goto L20
    L41:
        r5 = 0;
        r19.translate(0.0f, n.g(r110, 0, r17), 0.0f);
        goto L20
    L26:
        r18 = null;
        goto L45
    L42:
        r19.translate(n.g(r110, r5, r16), 0.0f, 0.0f);
    L43:
        r19.translate(n.g(r110, r5, r16), n.g(r110, 1, r17), n.g(r110, 2, 0.0f));
        goto L20
    L44:
        jk.a r27 = new jk.a(3);
        jk.a.h((double[]) r27.f18349a);
        jk.a.h((double[]) r27.f18350b);
        jk.a.h((double[]) r27.f18351c);
        jk.a.h((double[]) r27.d);
        jk.a.h((double[]) r27.e);
        com.lynx.tasm.utils.f.c(n.r(r19.getArray()), r27);
        r18.q(r27);
    L45:
        this.g = r18;
    L47:
        p();
        r11.getView().setOutlineProvider(null);
        ViewCompat.setTranslationZ(r11.getView(), this.g.w());
        r11.getView().setRotation(this.g.f());
        r11.getView().setRotationX(this.g.s());
        r11.getView().setRotationY(this.g.t());
        r11.getView().setScaleX(this.g.u());
        r11.getView().setScaleY(this.g.v());
        Float r28 = (Float) ((LinkedHashMap) this.g.f10761a).get("skewX");
        if (r28 == null) goto L50;
        float r29 = r28.floatValue();
    L51:
        r11.setSkewX(r29);
        Float r30 = (Float) ((LinkedHashMap) this.g.f10761a).get("skewY");
        if (r30 == null) goto L54;
        r13 = r30.floatValue();
    L54:
        r11.setSkewY(r13);
        r11.getView().invalidate();
        return;
    L50:
        r29 = 0.0f;
        goto L51
    L46:
        r15.f10145m.getFontSize();
        r15.f10145m.getLatestWidth();
        r15.f10145m.getLatestHeight();
        this.g = n.n(r21, r11.getLatestWidth(), r11.getLatestHeight());
        goto L47
    L8:
        if (r12.getView() == null) goto L11;
        r12.getView().setTranslationX(0.0f);
        r12.getView().setTranslationY(0.0f);
        r12.getView().setRotation(0.0f);
        r12.getView().setRotationX(0.0f);
        r12.getView().setRotationY(0.0f);
        r12.getView().setScaleX(1.0f);
        r12.getView().setScaleY(1.0f);
        this.g = null;
        p();
        goto L11
    }

    public final void p() {
        LynxUI r5 = (LynxUI) this.f.get();
        if (r5 == null) goto L24;
        PointF r10 = this.f10738h;
        float r11 = 0.0f;
        if (r10 == null) goto L8;
        float r12 = r10.x + 0.0f;
        float r13 = r10.y + 0.0f;
    L9:
        n r14 = this.g;
        if (r14 == null) goto L20;
        Float r15 = (Float) ((LinkedHashMap) r14.f10761a).get("translateX");
        if (r15 == null) goto L14;
        float r16 = r15.floatValue();
    L15:
        r12 = r12 + r16;
        Float r17 = (Float) ((LinkedHashMap) this.g.f10761a).get("translateY");
        if (r17 == null) goto L18;
        r11 = r17.floatValue();
    L18:
        r13 = r13 + r11;
        goto L20
    L14:
        r16 = 0.0f;
    L20:
        if (r5.getView() == null) goto L23;
        r5.getView().setTranslationX(r12);
        r5.getView().setTranslationY(r13);
        return;
    L23:
        return;
    L8:
        r13 = 0.0f;
        r12 = 0.0f;
        goto L9
    }
}
