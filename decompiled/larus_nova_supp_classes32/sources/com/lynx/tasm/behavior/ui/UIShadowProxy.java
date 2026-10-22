package com.lynx.tasm.behavior.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.BorderRadius;
import com.lynx.tasm.behavior.ui.utils.BorderStyle;
import com.lynx.tasm.behavior.x0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIShadowProxy extends UIGroup<d> {
    public final LynxBaseUI a;
    public List<g> b;
    public b c;
    public final Matrix d;
    public boolean e;

    public static class a {
        public final d a;
        public float b;
        public float c;

        public a(d r1) {
            this.a = r1;
        }
    }

    public static class b {
        public BorderStyle a;
        public Integer b;
        public float c;
        public Rect d;
        public Paint e;
        public Path f;

        public b() {
            this.b = null;
            this.c = 0.0f;
            this.a = BorderStyle.NONE;
            this.b = -16777216;
        }

        public final void b(Canvas r40) {
            BorderStyle r0 = this.a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.equals(BorderStyle.NONE) == false) goto L7;
            return;
        L7:
            if (this.a.equals(BorderStyle.HIDDEN) == false) goto L10;
            return;
        L10:
            if (this.c >= 0.001d) goto L12;
            return;
        L12:
            Rect r1 = this.d;
            if (r1 != null) goto L15;
            return;
        L15:
            if (r1.width() >= 1) goto L17;
            return;
        L17:
            if (this.d.height() < 1) goto L34;
            int r12 = r40.save();
            Rect r2 = this.d;
            int r3 = r2.left;
            int r13 = r2.top;
            int r14 = r2.width();
            int r15 = r2.height();
            float r4 = this.c;
            if (r4 >= 1.0f) goto L22;
            int r9 = 1;
        L23:
            Paint r5 = new Paint();
            this.e = r5;
            r5.setAntiAlias(false);
            this.e.setStyle(Paint.Style.STROKE);
            Integer r6 = this.b;
            if (r6 == null) goto L26;
            int r28 = r6.intValue();
        L27:
            float r8 = r3;
            float r7 = r13;
            float r10 = r3 - r9;
            float r11 = r13 - r9;
            int r16 = r3 + r14;
            float r17 = r16 + r9;
            float r18 = r16;
            float r19 = r9;
            float r29 = r19 * 0.5f;
            float r25 = r7 - r29;
            r40.save();
            int r37 = r9;
            a(r40, r8, r7, r10, r11, r17, r11, r18, r7);
            int r38 = r37 * 2;
            float r110 = r14 + r38;
            int r21 = r28;
            this.a.strokeBorderLine(r40, this.e, 1, this.c, r21, r10, r25, r17, r25, r110, r19);
            r40.restore();
            int r111 = r13 + r15;
            float r20 = r111;
            float r112 = r111 + r37;
            float r24 = r18 + r29;
            r40.save();
            a(r40, r18, r7, r18, r20, r17, r112, r17, r11);
            float r113 = r15 + r38;
            this.a.strokeBorderLine(r40, this.e, 2, this.c, r21, r24, r11, r24, r112, r113, r19);
            r40.restore();
            float r26 = r20 + r29;
            r40.save();
            a(r40, r8, r20, r18, r20, r17, r112, r10, r112);
            this.a.strokeBorderLine(r40, this.e, 3, this.c, r21, r17, r26, r10, r26, r110, r19);
            r40.restore();
            float r27 = r8 - r29;
            r40.save();
            a(r40, r8, r7, r10, r11, r10, r112, r8, r20);
            this.a.strokeBorderLine(r40, this.e, 0, this.c, r21, r27, r112, r27, r11, r113, r19);
            r40.restore();
            this.e.setAntiAlias(true);
            r40.restoreToCount(r12);
            return;
        L26:
            r28 = -16777216;
            goto L27
        L22:
            r9 = Math.round(r4);
            goto L23
        }

        public final void a(Canvas r2, float r3, float r4, float r5, float r6, float r7, float r8, float r9, float r10) {
            if (this.f != null) goto L5;
            this.f = new Path();
        L5:
            this.f.reset();
            this.f.moveTo(r3, r4);
            this.f.lineTo(r5, r6);
            this.f.lineTo(r7, r8);
            this.f.lineTo(r9, r10);
            this.f.lineTo(r3, r4);
            r2.clipPath(this.f);
        }
    }

    public static class c {
        public static final double[] w = null;
        public final Paint a;
        public final Paint b;
        public final Paint c;
        public final Paint d;
        public final Paint e;
        public final Paint f;
        public final RectF g;
        public final RectF h;
        public final float[] i;
        public final float[] j;
        public g k;
        public final Path l;
        public final Path m;
        public final Path n;
        public final Path o;
        public final Path p;
        public final Path q;
        public final Path r;
        public final Path s;
        public final Path t;
        public final Path u;
        public boolean v;

        static {
            w = new double[]{1.0d, 0.8027415617602307d, 0.6443940149772542d, 0.5172818579717866d, 0.41524364653850576d, 0.3333333333333333d, 0.2075805205867436d, 0.1147980049924181d, 0.0424272859905955d, 0.0d};
        }

        public c() {
            this.l = new Path();
            this.m = new Path();
            this.n = new Path();
            this.o = new Path();
            this.p = new Path();
            this.q = new Path();
            this.r = new Path();
            this.s = new Path();
            this.t = new Path();
            this.u = new Path();
            this.v = false;
            this.a = new Paint(5);
            Paint r0 = new Paint(5);
            this.b = r0;
            r0.setStyle(Paint.Style.FILL);
            r0.setDither(true);
            this.c = new Paint(r0);
            this.d = new Paint(r0);
            this.e = new Paint(r0);
            this.g = new RectF();
            this.h = new RectF();
            this.f = new Paint(r0);
            this.i = new float[8];
            this.j = new float[8];
        }

        public final void c(Canvas r4) {
            if (this.k != null) goto L5;
            return;
        L5:
            int r0 = r4.save();
            RectF r1 = this.g;
            r4.translate(r1.left, r1.top);
            r4.drawPath(this.n, this.b);
            r4.drawPath(this.r, this.f);
            r4.restoreToCount(r0);
            int r2 = r4.save();
            RectF r3 = this.g;
            r4.translate(r3.right, r3.bottom);
            r4.rotate(180.0f);
            r4.drawPath(this.o, this.e);
            r4.drawPath(this.s, this.f);
            r4.restoreToCount(r2);
            int r5 = r4.save();
            RectF r6 = this.g;
            r4.translate(r6.left, r6.bottom);
            r4.rotate(270.0f);
            r4.drawPath(this.p, this.d);
            r4.drawPath(this.t, this.f);
            r4.restoreToCount(r5);
            int r7 = r4.save();
            RectF r8 = this.g;
            r4.translate(r8.right, r8.top);
            r4.rotate(90.0f);
            r4.drawPath(this.q, this.c);
            r4.drawPath(this.u, this.f);
            r4.restoreToCount(r7);
        }

        public final void d(Canvas r5) {
            if (this.k != null) goto L5;
            return;
        L5:
            int r0 = r5.save();
            if (this.v == false) goto L12;
            Path r1 = this.m;
            if (this.k.a() == false) goto L10;
            Region.Op r2 = Region.Op.INTERSECT;
        L11:
            r5.clipPath(r1, r2);
            goto L12
        L10:
            r2 = Region.Op.DIFFERENCE;
        L12:
            r5.drawPath(this.l, this.a);
            c(r5);     // Catch: Exception -> L15
        L17:
            r5.restoreToCount(r0);
            return;
        L15:
            e = move-exception;
            LLog.e("UIShadowProxy", "Exception occurred while drawing shadow: " + e.getStackTrace().toString());
            goto L17
        }

        public final void b(Path r7, float r8, float r9) {
            r7.reset();
            if (this.k.a() == false) goto L5;
            float r0 = this.k.f;
        L6:
            RectF r1 = new RectF(0.0f, 0.0f, r8 * 2.0f, r9 * 2.0f);
            RectF r10 = new RectF(r1);
            if (r0 <= 0.0f) goto L12;
            float r3 = Math.min(r10.width(), r10.height()) / 2.0f;
            if (r0 <= r3) goto L12;
            r0 = r3;
        L12:
            if (r0 > (-0.1f)) goto L14;
        L16:
            r10.inset(r0, r0);
            r7.setFillType(Path.FillType.EVEN_ODD);
            r7.moveTo(0.0f, r9);
            r7.rLineTo(r0, 0.0f);
            r7.arcTo(r10, 180.0f, 90.0f, false);
            r7.arcTo(r1, 270.0f, -90.0f, false);
            r7.close();
            return;
        L14:
            if (r0 >= 0.1f) goto L16;
            return;
        L5:
            r0 = -this.k.f;
            goto L6
        }

        public final void a(Paint r22, int[] r23, float r24, float r25) {
            g r2 = this.k;
            float r3 = r2.f;
            float r7 = (r24 + r25) / 2.0f;
            boolean r4 = r2.a();
            double[] r5 = w;
            int r6 = 9;
            float r14 = 1.0f;
            if (r4 == true) goto L5;
            float r8 = r3 + r7;
            if (r8 > 1.0E-6d) goto L16;
            r22.setShader(null);
            return;
        L16:
            float r9 = r7 / r8;
            float[] r10 = new float[11];
            int[] r11 = new int[11];
            r10[0] = 0.0f;
            r10[1] = r9;
            int r12 = this.k.a;
            r11[0] = r12;
            r11[1] = r12;
            int r13 = 2;
        L17:
            if (r13 > 10) goto L19;
            int r15 = r13 - 1;
            r10[r13] = (((1.0f - r9) * r15) / 9) + r9;
            r11[r13] = Color.argb((int) (((double) r23[0]) * r5[r15]), r23[1], r23[2], r23[3]);
            r13 = r13 + 1;
            goto L17
        L19:
            r22.setShader(new RadialGradient(r24, r25, r8, r11, r10, Shader.TileMode.CLAMP));
            return;
        L5:
            if (r7 > 1.0E-6d) goto L8;
            r22.setShader(null);
            return;
        L8:
            float r16 = r3 / r7;
            float[] r17 = new float[11];
            int[] r18 = new int[11];
            r17[10] = 1.0f;
            r18[10] = this.k.a;
            int r19 = 1;
        L9:
            if (r19 >= 10) goto L11;
            int r110 = 10 - r19;
            r17[r110] = Math.max(r14 - ((r19 * r16) / r6), 0.0f);
            r18[r110] = Color.argb((int) (((double) r23[0]) * r5[r19]), r23[1], r23[2], r23[3]);
            r19 = r19 + 1;
            r6 = 9;
            r14 = 1.0f;
            goto L9
        L11:
            r17[0] = 0.0f;
            r18[0] = Color.argb(0, r23[1], r23[2], r23[3]);
            r22.setShader(new RadialGradient(r24, r25, r7, r18, r17, Shader.TileMode.CLAMP));
        }
    }

    public static class d extends com.lynx.tasm.behavior.ui.view.a {
        public boolean a;
        public ArrayList<c> b;
        public b c;
        public final WeakReference<UIShadowProxy> d;

        @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
        public /* bridge */ /* synthetic */ int getRendererHostHeight() {
            return x6a.d.e(this);
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
        public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
            return x6a.d.f(this);
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
        public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
            return x6a.d.g(this);
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
        public /* bridge */ /* synthetic */ int getRendererHostWidth() {
            return x6a.d.h(this);
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
        public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
            x6a.d.k(this, r1);
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
        public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
            x6a.d.l(this, r1);
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
        public final void dispatchDraw(Canvas r11) {
            UIShadowProxy r0 = this.d.get();
            if (r0 != null) goto L5;
        L7:
            ArrayList<c> r1 = this.b;
            if (r1 == null) goto L12;
            if (r1.isEmpty() == true) goto L12;
        L14:
            UIShadowProxy r2 = this.d.get();
            if (r2 == null) goto L17;
            float r3 = r2.getAlpha();
        L19:
            if (r3 > 0.001f) goto L22;
        L48:
            super.dispatchDraw(r11);
            b r4 = this.c;
            if (r4 == null) goto L59;
            r4.b(r11);
            return;
        L59:
            return;
        L22:
            if (r3 >= 1.0f) goto L24;
            r11.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), (int) (r3 * 255.0f), 31);
        L25:
            if (r2 == null) goto L37;
            UIShadowProxy r5 = this.d.get();
            r5.d.reset();
            LynxBaseUI r6 = r5.a;
            if ((r6 instanceof LynxUI) == true) goto L29;
            Matrix r7 = r5.d;
        L34:
            if (r7.isIdentity() == true) goto L36;
            r11.concat(r7);
        L36:
            setTranslationZ(this.d.get().getTranslationZ());
            goto L37
        L29:
            View r8 = ((LynxUI) r6).getView();
            if (r8 == null) goto L32;
            float r9 = r8.getPivotX() + r5.getLeft();
            float r10 = r8.getPivotY() + r5.getTop();
            r5.d.preTranslate(r8.getTranslationX(), r8.getTranslationY());
            r5.d.preScale(r8.getScaleX(), r8.getScaleY(), r9, r10);
            r5.d.preRotate(r8.getRotation(), r9, r10);
        L32:
            r7 = r5.d;
        L37:
            ArrayList<c> r12 = this.b;
            if (r12 == null) goto L47;
            int r13 = r12.size();
        L40:
            r13 = r13 - 1;
            if (r13 < 0) goto L47;
            c r14 = (c) ListProtector.get(this.b, r13);
            if (r14 == null) goto L40;
            if (r14.k.a() == true) goto L40;
            r14.d(r11);
        L47:
            r11.restore();
            goto L48
        L24:
            r11.save();
            goto L25
        L17:
            r3 = 1.0f;
        L12:
            if (this.c != null) goto L14;
        L5:
            if (r0.e == false) goto L7;
            r0.O();
            r0.e = false;
            goto L7
        }

        public d(UIShadowProxy r1, Context r2) {
            super(r2);
            this.d = new WeakReference(r1);
            setWillNotDraw(false);
        }
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final Rect getBoundRectForOverflow() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        this.e = true;
    }

    public final b M() {
        if (this.c != null) goto L8;
        b r0 = new b();
        this.c = r0;
        T r1 = this.mView;
        if (r1 == 0) goto L8;
        ((d) r1).c = r0;
    L8:
        return this.c;
    }

    public final void O() {
        BorderRadius r1 = this.a.getLynxBackground().m();
        int r2 = this.a.getWidth();
        int r3 = this.a.getHeight();
        if (r2 == 0) goto L157;
        if (r3 == 0) goto L157;
        if (r1 == null) goto L11;
        if (r2 <= 0) goto L10;
        if (r3 <= 0) goto L10;
        r1.d(r2, r3);
    L10:
        float[] r4 = r1.a();
    L12:
        if (r2 <= 0) goto L143;
        if (r3 <= 0) goto L143;
        Rect r5 = new Rect(this.a.getLeft(), this.a.getTop(), this.a.getLeft() + this.a.getWidth(), this.a.getTop() + this.a.getHeight());
        b r6 = this.c;
        if (r6 == null) goto L17;
        r6.d = r5;
    L17:
        T r7 = this.mView;
        ((d) r7).c = r6;
        d r8 = (d) r7;
        List<g> r9 = this.b;
        r8.b = null;
        if (r9 == null) goto L143;
        if (r9.isEmpty() == true) goto L143;
        r8.b = new ArrayList();
        Iterator<g> r10 = r9.iterator();
    L24:
        if (r10.hasNext() == false) goto L141;
        g r11 = r10.next();
        c r12 = new c();
        r12.k = r11;
        if (r4 != null) goto L28;
    L30:
        Arrays.fill(r12.j, 0.0f);
    L31:
        System.arraycopy(r12.j, 0, r12.i, 0, 8);
        r12.g.set(r5);
        r12.h.set(r5);
        g r13 = r12.k;
        if (r13 == null) goto L77;
        float r14 = r13.e - (r13.d / 2.0f);
        if (r13.a() == false) goto L36;
        int r15 = 1;
    L37:
        float r16 = r14 * r15;
        if (r16 <= 0.0f) goto L42;
        float r17 = Math.min(r12.g.width(), r12.g.height()) / 2.0f;
        if (r16 <= r17) goto L42;
        r16 = r17;
    L42:
        r12.g.inset(r16, r16);
        RectF r18 = r12.g;
        g r19 = r12.k;
        r18.offset(r19.b, r19.c);
        int r110 = 0;
    L43:
        if (r110 >= 8) goto L45;
        float[] r111 = r12.i;
        r111[r110] = Math.max(r111[r110] - r16, 0.0f);
        r110 = r110 + 1;
        goto L43
    L45:
        RectF r112 = r12.g;
        float[] r113 = r12.i;
        if (com.lynx.tasm.utils.b.a(r112.width(), 0.0f) == true) goto L77;
        if (com.lynx.tasm.utils.b.a(r112.height(), 0.0f) == true) goto L77;
        if ((r113[0] + r113[2]) <= r112.width()) goto L55;
        float r114 = r112.width() / (r113[0] + r113[2]);
        if (r114 >= 1.0f) goto L55;
    L57:
        if ((r113[4] + r113[6]) <= r112.width()) goto L62;
        float r115 = r112.width() / (r113[4] + r113[6]);
        if (r115 >= r114) goto L62;
        r114 = r115;
    L62:
        if ((r113[1] + r113[7]) <= r112.height()) goto L67;
        float r116 = r112.height() / (r113[1] + r113[7]);
        if (r116 >= r114) goto L67;
        r114 = r116;
    L67:
        if ((r113[3] + r113[5]) <= r112.height()) goto L72;
        float r117 = r112.height() / (r113[3] + r113[5]);
        if (r117 >= r114) goto L72;
        r114 = r117;
    L72:
        if (r114 >= 1.0f) goto L77;
        int r118 = 0;
    L74:
        if (r118 >= 8) goto L77;
        r113[r118] = r113[r118] * r114;
        r118 = r118 + 1;
    L55:
        r114 = 1.0f;
        goto L57
    L36:
        r15 = -1;
    L77:
        if (r12.k == null) goto L133;
        float[] r20 = r12.i;
        r12.b(r12.n, r20[0], r20[1]);
        r12.b(r12.q, r20[2], r20[3]);
        r12.b(r12.o, r20[4], r20[5]);
        r12.b(r12.p, r20[6], r20[7]);
        g r21 = r12.k;
        float r119 = r21.f;
        int[] r120 = {Color.alpha(r21.a), Color.red(r12.k.a), Color.green(r12.k.a), Color.blue(r12.k.a)};
        r12.a.setColor(r12.k.a);
        int r22 = 10;
        int[] r121 = new int[10];
        int r122 = 0;
    L79:
        if (r122 >= r22) goto L81;
        r121[r122] = Color.argb((int) (((double) r120[0]) * c.w[r122]), r120[1], r120[2], r120[3]);
        r122 = r122 + 1;
        r8 = r8;
        r22 = 10;
        goto L79
    L81:
        d r29 = r8;
        Paint r23 = r12.f;
        if (r12.k.a() == true) goto L85;
        r119 = -r119;
    L85:
        r23.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, r119, r121, null, Shader.TileMode.CLAMP));
        float[] r24 = r12.i;
        r12.a(r12.b, r120, r24[0], r24[1]);
        r12.a(r12.c, r120, r24[2], r24[3]);
        r12.a(r12.e, r120, r24[4], r24[5]);
        r12.a(r12.d, r120, r24[6], r24[7]);
        Path r25 = new Path();
        Path r26 = new Path();
        Path r27 = new Path();
        Path r28 = new Path();
        r12.l.reset();
        r12.m.reset();
        r12.l.addRoundRect(r12.g, r12.i, Path.Direction.CW);
        r12.m.addRoundRect(r12.h, r12.j, Path.Direction.CW);
        if (Build.VERSION.SDK_INT >= 26) goto L88;
        r12.v = true;
        r12.l.addRoundRect(r12.h, r12.j, Path.Direction.CCW);
    L93:
        r12.a.setColor(r12.k.a);
        r25.reset();
        r25.set(r12.m);
        RectF r123 = r12.g;
        r25.offset(-r123.left, -r123.top);
        Matrix r124 = new Matrix();
        r26.reset();
        r26.set(r12.m);
        r124.reset();
        r124.preRotate(-180.0f);
        RectF r125 = r12.g;
        r124.preTranslate(-r125.right, -r125.bottom);
        r26.transform(r124);
        r27.reset();
        r27.set(r12.m);
        r124.reset();
        r124.preRotate(-270.0f);
        RectF r126 = r12.g;
        r124.preTranslate(-r126.left, -r126.bottom);
        r27.transform(r124);
        r28.reset();
        r28.set(r12.m);
        r124.reset();
        r124.preRotate(-90.0f);
        RectF r127 = r12.g;
        r124.preTranslate(-r127.right, -r127.top);
        r28.transform(r124);
        if (r12.k.a() == false) goto L96;
        Path.Op r128 = Path.Op.INTERSECT;
    L98:
        if (r12.n.isEmpty() == true) goto L101;
        r12.n.op(r25, r128);
    L101:
        if (r12.o.isEmpty() == true) goto L104;
        r12.o.op(r26, r128);
    L104:
        if (r12.p.isEmpty() == true) goto L107;
        r12.p.op(r27, r128);
    L107:
        if (r12.q.isEmpty() == true) goto L109;
        r12.q.op(r28, r128);
    L109:
        r12.r.reset();
        r12.s.reset();
        r12.t.reset();
        r12.u.reset();
        float[] r129 = r12.i;
        if (r12.k.a() == false) goto L112;
        float r130 = 0.0f;
    L114:
        if (r12.k.a() == false) goto L116;
        float r210 = r12.k.f;
    L117:
        float r211 = r130;
        float r212 = r210;
        r12.r.addRect(r129[0], r211, r12.g.width() - r129[2], r212, Path.Direction.CW);
        r12.s.addRect(r129[4], r211, r12.g.width() - r129[6], r212, Path.Direction.CW);
        r12.t.addRect(r129[7], r211, r12.g.height() - r129[1], r212, Path.Direction.CW);
        r12.u.addRect(r129[3], r211, r12.g.height() - r129[5], r212, Path.Direction.CW);
        if (r12.k.a() == false) goto L120;
        Path.Op r30 = Path.Op.INTERSECT;
    L122:
        if (r12.r.isEmpty() == true) goto L125;
        r12.r.op(r25, r30);
    L125:
        if (r12.s.isEmpty() == true) goto L128;
        r12.s.op(r26, r30);
    L128:
        if (r12.t.isEmpty() == true) goto L131;
        r12.t.op(r27, r30);
    L131:
        if (r12.u.isEmpty() == true) goto L134;
        r12.u.op(r28, r30);
    L134:
        g r31 = r12.k;
        if (r31 != null) goto L137;
    L139:
        r8 = r29;
    L140:
        r8.b.add(r12);
        goto L24
    L137:
        if (r31.a() == false) goto L139;
        r8 = r29;
        r8.a = true;
        goto L140
    L120:
        r30 = Path.Op.DIFFERENCE;
        goto L122
    L116:
        r210 = 0.0f;
        goto L117
    L112:
        r130 = -r12.k.f;
        goto L114
    L96:
        r128 = Path.Op.DIFFERENCE;
        goto L98
    L88:
        if (r12.k.a() == false) goto L90;
        Path.Op r131 = Path.Op.REVERSE_DIFFERENCE;
    L91:
        r12.l.op(r12.m, r131);
        goto L93
    L90:
        r131 = Path.Op.DIFFERENCE;
        goto L91
    L133:
        r29 = r8;
        goto L134
    L28:
        if (r4.length != 8) goto L30;
        System.arraycopy(r4, 0, r12.j, 0, 8);
        goto L31
    L141:
        r8.invalidate();
    L143:
        if (((d) this.mView).a == false) goto L155;
        LynxBaseUI r32 = this.a;
        if (r32 != null) goto L147;
    L151:
        a r33 = null;
    L152:
        if (r33 != null) goto L154;
        r33 = new a((d) this.mView);
        this.a.getLynxBackground().b().B = r33;
    L154:
        float r34 = this.a.getLeft();
        float r35 = this.a.getTop();
        r33.b = r34;
        r33.c = r35;
        goto L155
    L147:
        if (r32.getLynxBackground() == null) goto L151;
        T r36 = this.a.getLynxBackground().b;
        if (r36 == 0) goto L151;
        r33 = ((BackgroundDrawable) r36).B;
    L155:
        ((d) this.mView).invalidate();
        return;
    L11:
        r4 = null;
    L157:
        d r37 = (d) this.mView;
        ArrayList<c> r38 = r37.b;
        if (r38 == null) goto L160;
        r38.clear();
    L160:
        r37.invalidate();
        ((d) this.mView).c = null;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean enableLayoutAnimation() {
        return this.a.enableLayoutAnimation();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final float getAlpha() {
        LynxBaseUI r0 = this.a;
        if ((r0 instanceof LynxUI) == true) goto L7;
        return 1.0f;
    L7:
        return ((LynxUI) r0).getView().getAlpha();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final Rect getBound() {
        return this.a.getBound();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final int getChildCount() {
        LynxBaseUI r0 = this.a;
        if ((r0 instanceof UIGroup) == true) goto L5;
        return 0;
    L5:
        return ((UIGroup) r0).getChildCount();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final List<LynxBaseUI> getChildren() {
        return this.a.getChildren();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getHeight() {
        return this.a.getHeight();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final String getIdSelector() {
        LynxBaseUI r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getIdSelector();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final t6a.c getLayoutAnimator() {
        return this.a.getLayoutAnimator();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getLeft() {
        return this.a.getLeft();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getOriginLeft() {
        return this.a.getOriginLeft();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getOriginTop() {
        return this.a.getOriginTop();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final JavaOnlyMap getProps() {
        return this.a.getProps();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final float getRealTimeTranslationZ() {
        LynxBaseUI r0 = this.a;
        if ((r0 instanceof LynxUI) == true) goto L7;
        return 0.0f;
    L7:
        return ((LynxUI) r0).getRealTimeTranslationZ();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final String getRefIdSelector() {
        LynxBaseUI r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRefIdSelector();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final String getTagName() {
        LynxBaseUI r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTagName();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getTop() {
        return this.a.getTop();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final u6a.a getTransitionAnimator() {
        return this.a.getTransitionAnimator();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final float getTranslationZ() {
        LynxBaseUI r0 = this.a;
        if ((r0 instanceof LynxUI) == true) goto L7;
        return 0.0f;
    L7:
        return ((LynxUI) r0).getTranslationZ();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getWidth() {
        return this.a.getWidth();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isFirstAnimatedReady() {
        return this.a.isFirstAnimatedReady();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isFlatten() {
        return this.a.isFlatten();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final boolean isInsertViewCalled() {
        LynxBaseUI r0 = this.a;
        if ((r0 instanceof UIGroup) == false) goto L7;
        return ((UIGroup) r0).isInsertViewCalled();
    L7:
        return super.isInsertViewCalled();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void layout() {
        View r0 = (View) ((d) this.mView).getParent();
        if (r0 != null) goto L5;
        return;
    L5:
        ((d) this.mView).layout(0, 0, r0.getWidth(), r0.getHeight());
        if ((((d) this.mView).getParent() instanceof ViewGroup) == false) goto L8;
        ((ViewGroup) ((d) this.mView).getParent()).setClipChildren(false);
        ViewCompat.setClipBounds(this.mView, getBoundRectForOverflow());
    L8:
        LynxBaseUI r1 = this.a;
        if ((r1 instanceof LynxUI) == false) goto L12;
        ((LynxUI) r1).layout();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void measure() {
        this.a.measure();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        LynxBaseUI r0 = this.a;
        if (r0 == null) goto L6;
        r0.onNodeReady();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        LynxBaseUI r0 = this.a;
        if (r0 == null) goto L5;
        r0.onPropsUpdated();
    L5:
        super.onPropsUpdated();
        this.e = true;
    }

    public final void N() {
        invalidate();
        this.e = true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final void initAccessibilityDelegate() {
        super.initAccessibilityDelegate();
        ViewCompat.setImportantForAccessibility(this.mView, 1);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onDrawingPositionChanged() {
        super.onDrawingPositionChanged();
        this.e = true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r2) {
        return new d(this, r2);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final LynxBaseUI getChildAt(int r2) {
        return (LynxBaseUI) ListProtector.get(this.a.mChildren, r2);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void insertView(LynxUI r2) {
        ((UIGroup) this.a).insertView(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeChild(LynxBaseUI r2) {
        this.a.removeChild(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void removeView(LynxBaseUI r2) {
        ((UIGroup) this.a).removeView(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setBound(Rect r2) {
        this.a.setBound(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setBoxShadow(ReadableArray r3) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return;
    L5:
        this.b = g.b(r3);
        O();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setLeft(int r2) {
        this.a.setLeft(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setOutlineColor(int r2) {
        b r0 = M();
        r0.b = Integer.valueOf(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setOutlineWidth(float r2) {
        M().c = r2;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setStickyTranslate(PointF r2) {
        this.a.setStickyTranslate(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setTop(int r2) {
        this.a.setTop(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateExtraData(Object r2) {
        this.a.updateExtraData(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateLayoutInfo(LynxBaseUI r2) {
        this.a.updateLayoutInfo(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updatePropertiesInterval(x0 r2) {
        this.a.updateProperties(r2);
        onPropsUpdated();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateSticky(float[] r2) {
        this.a.updateSticky(r2);
        invalidate();
    }

    public UIShadowProxy(LynxContext r3, LynxBaseUI r4) {
        super(r3);
        this.d = new Matrix();
        int r5 = 0;
        this.e = false;
        this.mOverflow = 3;
        this.a = r4;
        r4.setParent(this);
        setSign(r4.getSign(), r4.getTagName());
        initialize();
        onInsertChild(r4, 0);
        super.insertDrawList(null, r4);
        super.insertView((LynxUI) r4);
        r4.getTransformRaws();
        if (r4.getVisibility() == true) goto L6;
        r5 = 4;
    L6:
        setVisibilityForView(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean checkStickyOnParentScroll(int r2, int r3) {
        boolean r4 = this.a.checkStickyOnParentScroll(r2, r3);
        if (r4 == false) goto L5;
        invalidate();
    L5:
        return r4;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean childrenContainPoint(float r2, float r3) {
        LynxBaseUI r0 = this.a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.childrenContainPoint(r2, r3);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final boolean containsPoint(float r2, float r3) {
        return containsPoint(r2, r3, false);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final EventTarget hitTest(float r2, float r3) {
        return hitTest(r2, r3, false);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r2, int r3) {
        this.a.insertChild(r2, r3);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final void insertDrawList(LynxBaseUI r2, LynxBaseUI r3) {
        ((LynxUI) this.a).insertDrawList(r2, r3);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutFinish(long r2, LynxBaseUI r4) {
        LynxBaseUI r0 = this.a;
        if (r0 == null) goto L6;
        r0.onLayoutFinish(r2, r4);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final boolean containsPoint(float r2, float r3, boolean r4) {
        LynxBaseUI r0 = this.a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.containsPoint(r2, r3, r4);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final EventTarget hitTest(float r2, float r3, boolean r4) {
        LynxBaseUI r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.hitTest(r2, r3, r4);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean updateDrawingLayoutInfo(int r2, int r3, Rect r4) {
        if (this.a.updateDrawingLayoutInfo(r2, r3, r4) == false) goto L6;
        this.e = true;
        invalidate();
        return true;
    L6:
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean calculateStickyTranslateWithOffset(int r2, boolean r3, int r4, int r5) {
        boolean r6 = this.a.calculateStickyTranslateWithOffset(r2, r3, r4, r5);
        if (r6 == false) goto L5;
        invalidate();
    L5:
        return r6;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final LynxBaseUI.TransOffset getTransformValue(float r2, float r3, float r4, float r5) {
        return this.a.getTransformValue(r2, r3, r4, r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateLayout(int r19, int r20, int r21, int r22, int r23, int r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32, int r33, int r34, Rect r35) {
        this.a.updateLayout(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35);
        onLayoutUpdated();
    }
}
