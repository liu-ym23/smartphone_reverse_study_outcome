package com.lynx.tasm.behavior.ui.utils;

import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.renderscript.Matrix4f;
import androidx.core.view.ViewCompat;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends e {
    public final WeakReference<LynxUI> f;
    public m g;
    public PointF h;
    public PointF i;
    public boolean j;

    @Override // com.lynx.tasm.behavior.ui.utils.e
    public final BackgroundDrawable l() {
        LynxUI r0 = this.f.get();
        if (r0 != null) goto L5;
        return null;
    L5:
        BackgroundDrawable r2 = super.l();
        if (r0.getView() == null) goto L11;
        Drawable r3 = r0.getView().getBackground();
        r0.getView().setBackground(null);
        if (r3 != null) goto L10;
        r0.getView().setBackground(r2);
        goto L11
    L10:
        r0.getView().setBackground(new LayerDrawable(new Drawable[]{r2, r3}));
    L11:
        return r2;
    }

    public final void u() {
        LynxUI r0 = this.f.get();
        if (r0 != null) goto L5;
        return;
    L5:
        PointF r1 = this.h;
        float r2 = 0.0f;
        if (r1 == null) goto L8;
        float r3 = r1.x + 0.0f;
        float r4 = 0.0f + r1.y;
        r2 = r3;
    L9:
        PointF r5 = this.i;
        if (r5 == null) goto L12;
        r2 = r2 + r5.x;
        r4 = r4 + r5.y;
    L12:
        m r6 = this.g;
        if (r6 == null) goto L16;
        r2 = r2 + r6.h();
        r4 = r4 + this.g.i();
    L16:
        if (r0.getView() == null) goto L19;
        r0.getView().setTranslationX(r2);
        r0.getView().setTranslationY(r4);
        return;
    L19:
        return;
    L8:
        r4 = 0.0f;
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.utils.e, com.lynx.tasm.behavior.ui.utils.f
    public final /* bridge */ /* synthetic */ d a() {
        return l();
    }

    public final void t(List<n> r14) {
        LynxUI r0 = this.f.get();
        if (r0 != null) goto L5;
        return;
    L5:
        LynxUI r1 = this.f.get();
        float r2 = 0.0f;
        if (r1 != null) goto L8;
    L11:
        if (r14 != null) goto L14;
        return;
    L14:
        if (this.j == false) goto L42;
        this.a.getUIBody().getFontSize();
        this.a.getUIBody().getLatestWidth();
        this.a.getUIBody().getLatestHeight();
        int r3 = r0.getLatestWidth();
        int r5 = r0.getLatestHeight();
        m r6 = new m();
        if (r14.isEmpty() == true) goto L41;
        Matrix4f r7 = new Matrix4f();
        Iterator<n> r15 = r14.iterator();
    L20:
        if (r15.hasNext() == false) goto L40;
        n r8 = r15.next();
        int r9 = r8.a;
        if (r9 == 1) goto L39;
        if (r9 != 2) goto L24;
        r7.translate(m.a(r8, 0, r3), 0.0f, 0.0f);
        goto L20
    L24:
        switch(r9) {
            case 4: goto L37;
            case 8: goto L36;
            case 16: goto L39;
            case 32: goto L35;
            case 64: goto L34;
            case 128: goto L33;
            case 256: goto L35;
            case 512: goto L32;
            case 1024: goto L31;
            case 2048: goto L30;
            case 4096: goto L29;
            case 8192: goto L28;
            case 16384: goto L27;
            case 32768: goto L26;
            case 65536: goto L26;
            default: goto L25;
        };
    L25:
        LLog.DTHROW();
        r6 = null;
        goto L41
    L27:
        r6.n((float) com.lynx.tasm.utils.h.b(r8.b));
        goto L20
    L28:
        r6.m((float) com.lynx.tasm.utils.h.b(r8.b));
        goto L20
    L29:
        r6.m((float) com.lynx.tasm.utils.h.b(r8.b));
        r6.n((float) com.lynx.tasm.utils.h.b(r8.e));
        goto L20
    L30:
        r7.scale(1.0f, r8.b, 1.0f);
        goto L20
    L31:
        r7.scale(r8.b, 1.0f, 1.0f);
        goto L20
    L32:
        r7.scale(r8.b, r8.e, 1.0f);
        goto L20
    L33:
        r7.rotate(r8.b, 0.0f, 1.0f, 0.0f);
        goto L20
    L34:
        r7.rotate(r8.b, 1.0f, 0.0f, 0.0f);
        goto L20
    L35:
        r7.rotate(r8.b, 0.0f, 0.0f, 1.0f);
        goto L20
    L36:
        r7.translate(0.0f, 0.0f, m.a(r8, 0, 0.0f));
        goto L20
    L37:
        r7.translate(0.0f, m.a(r8, 0, r5), 0.0f);
        goto L20
    L26:
        r7.multiply(new Matrix4f(r8.j));
    L39:
        r7.translate(m.a(r8, 0, r3), m.a(r8, 1, r5), m.a(r8, 2, 0.0f));
        goto L20
    L40:
        com.lynx.tasm.utils.h.a r16 = new com.lynx.tasm.utils.h.a();
        r16.a();
        com.lynx.tasm.utils.h.a(m.b(r7.getArray()), r16);
        r6.l(r16);
    L41:
        this.g = r6;
    L43:
        u();
        r0.getView().setOutlineProvider(null);
        ViewCompat.setTranslationZ(r0.getView(), this.g.j());
        r0.getView().setRotation(this.g.c());
        r0.getView().setRotationX(this.g.d());
        r0.getView().setRotationY(this.g.e());
        r0.getView().setScaleX(this.g.f());
        r0.getView().setScaleY(this.g.g());
        Float r17 = this.g.c.get("skewX");
        if (r17 == null) goto L46;
        float r18 = r17.floatValue();
    L47:
        r0.setSkewX(r18);
        Float r19 = this.g.c.get("skewY");
        if (r19 == null) goto L50;
        r2 = r19.floatValue();
    L50:
        r0.setSkewY(r2);
        r0.getView().invalidate();
        return;
    L46:
        r18 = 0.0f;
        goto L47
    L42:
        this.a.getUIBody().getFontSize();
        this.a.getUIBody().getLatestWidth();
        this.a.getUIBody().getLatestHeight();
        this.g = m.k(r14, r0.getLatestWidth(), r0.getLatestHeight());
        goto L43
    L8:
        if (r1.getView() == null) goto L11;
        r1.getView().setTranslationX(0.0f);
        r1.getView().setTranslationY(0.0f);
        r1.getView().setRotation(0.0f);
        r1.getView().setRotationX(0.0f);
        r1.getView().setRotationY(0.0f);
        r1.getView().setScaleX(1.0f);
        r1.getView().setScaleY(1.0f);
        this.g = null;
        u();
        goto L11
    }

    public a(LynxUI r1, LynxContext r2) {
        super(r2);
        this.h = null;
        this.i = null;
        this.j = true;
        this.f = new WeakReference(r1);
    }
}
