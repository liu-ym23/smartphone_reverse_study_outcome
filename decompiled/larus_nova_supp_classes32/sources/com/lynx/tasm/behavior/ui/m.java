package com.lynx.tasm.behavior.ui;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m implements IDrawChildHook {
    public com.lynx.tasm.behavior.ui.a a;
    public final View b;
    public int c;
    public int d;
    public float e;
    public float f;
    public i7a.a g;
    public int[] h;
    public boolean i;
    public boolean j;
    public boolean k;
    public Path l;
    public Rect m;
    public Rect n;
    public int o;
    public final ArrayList<a> p;
    public d7a.f q;

    public static class a {
        public final m a;
        public View b;
        public final boolean c;
        public final Rect d;
        public d7a.f e;
        public Layout f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public float o;
        public int p;
        public int q;
        public final com.lynx.tasm.behavior.ui.utils.e r;
        public boolean s;

        public a(boolean r4, Rect r5, com.lynx.tasm.behavior.ui.utils.e r6) {
            this.e = null;
            this.f = null;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.o = 1.0f;
            this.p = 0;
            this.q = 0;
            this.r = null;
            this.s = false;
            this.c = r4;
            this.d = r5;
            this.r = r6;
        }

        public a(Rect r3, m r4, View r5) {
            this(true, r3, null);
            this.a = r4;
            this.b = r5;
        }
    }

    public final void d() {
        Iterator<a> r0 = this.p.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        a r1 = r0.next();
        if (r1.c == false) goto L4;
        if (r1.a == null) goto L4;
        View r2 = r1.b;
        if (r2 == null) goto L4;
        int r3 = r1.g;
        int r4 = r1.h;
        r2.layout(r3, r4, r1.i + r3, r1.j + r4);
        r1.a.d();
        goto L4
    }

    public final void e() {
        Iterator<a> r0 = this.p.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        a r1 = r0.next();
        if (r1.c == false) goto L4;
        if (r1.a == null) goto L4;
        View r2 = r1.b;
        if (r2 == null) goto L4;
        int r3 = r1.i;
        int r4 = r1.j;
        r2.measure(View.MeasureSpec.makeMeasureSpec(r3, 1073741824), View.MeasureSpec.makeMeasureSpec(r4, 1073741824));
        r1.a.e();
        goto L4
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public final void performLayoutChildrenUI() {
        com.lynx.tasm.behavior.ui.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.processLayoutChildren();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public final void performMeasureChildrenUI() {
        com.lynx.tasm.behavior.ui.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.processMeasureChildren();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public final boolean hasOverlappingRendering() {
        return this.i;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public final void afterDispatchDraw(Canvas r3) {
        com.lynx.tasm.behavior.ui.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.afterDispatchProcessViewInfo(this);
    L6:
        if (this.o >= this.p.size()) goto L8;
        b((a) ListProtector.get(this.p, this.o), r3);
        this.o++;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public final void afterDraw(Canvas r1) {
        com.lynx.tasm.behavior.ui.a r2 = this.a;
        if (r2 == null) goto L6;
        r2.afterProcessViewInfo(this);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public final void beforeDispatchDraw(Canvas r2) {
        com.lynx.tasm.behavior.ui.a r0 = this.a;
        if (r0 == null) goto L5;
        r0.beforeDispatchProcessViewInfo(this);
    L5:
        this.o = 0;
        if (this.k == false) goto L13;
        Path r1 = this.l;
        if (r1 == null) goto L10;
        r2.clipPath(r1);
        goto L13
    L10:
        Rect r3 = this.m;
        if (r3 == null) goto L13;
        r2.clipRect(r3);
    L13:
        Rect r4 = this.n;
        if (r4 == null) goto L17;
        r2.clipRect(r4);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public final void beforeDraw(Canvas r4) {
        com.lynx.tasm.behavior.ui.a r0 = this.a;
        if (r0 == null) goto L5;
        r0.beforeProcessViewInfo(this);
    L5:
        d7a.f r1 = this.q;
        if (r1 == null) goto L8;
        r1.i(r4);
    L8:
        float r2 = this.e;
        if (r2 == 0.0f) goto L11;
    L12:
        r4.skew(r2, this.f);
        r4.translate((-this.b.getPivotY()) * this.e, (-this.b.getPivotX()) * this.f);
    L13:
        i7a.a r3 = this.g;
        if (r3 == null) goto L19;
        Path r5 = r3.c(this.c, this.d);
        if (r5 == null) goto L20;
        r4.clipPath(r5);
        return;
    L20:
        return;
    L19:
        return;
    L11:
        if (this.f == 0.0f) goto L13;
        goto L12
    }

    public m(com.lynx.tasm.behavior.ui.a r2, View r3) {
        this.j = false;
        this.o = 0;
        this.p = new ArrayList();
        this.a = r2;
        this.b = r3;
    }

    public static void b(a r10, Canvas r11) {
        Rect r0 = r10.d;
        int r1 = r11.save();
        if (r0 == null) goto L5;
        r11.clipRect(r0);
    L5:
        int r2 = r10.g;
        if (r2 == 0) goto L8;
    L9:
        r11.translate(r2, r10.h);
    L10:
        float r3 = r10.o;
        if (r3 >= 1.0f) goto L13;
        r11.saveLayerAlpha(0.0f, 0.0f, r10.i, r10.j, (int) (r3 * 255.0f), 31);
    L13:
        com.lynx.tasm.behavior.ui.utils.e r4 = r10.r;
        int r5 = 0;
        if (r4 == null) goto L22;
        T r6 = r4.b;
        if (((BackgroundDrawable) r6) == null) goto L22;
        float r7 = r10.m;
        float r8 = r10.l;
        float r9 = r10.n;
        float r12 = r10.k;
        if (r6 == 0) goto L20;
        r6.d(r7, r8, r9, r12);
    L20:
        BackgroundDrawable r13 = (BackgroundDrawable) r10.r.b;
        r13.setBounds(0, 0, r10.i, r10.j);
        r13.draw(r11);
    L22:
        if (r10.f == null) goto L35;
        r11.translate(r10.p, r10.q);
        int r14 = r10.i;
        if (r14 <= 0) goto L28;
        int r15 = r10.j;
        if (r15 <= 0) goto L28;
        r11.clipRect(0, 0, r14, r15);
    L28:
        Spanned r16 = (Spanned) r10.f.getText();
        int r17 = com.lynx.tasm.behavior.ui.text.a.p;
        if (r16 == null) goto L34;
        com.lynx.tasm.behavior.ui.text.a[] r18 = (com.lynx.tasm.behavior.ui.text.a[]) r16.getSpans(0, r16.length(), com.lynx.tasm.behavior.ui.text.a.class);
        int r19 = r18.length;
    L32:
        if (r5 >= r19) goto L34;
        r18[r5].d();
        r5 = r5 + 1;
    L34:
        r10.f.draw(r11);
    L35:
        d7a.f r110 = r10.e;
        if (r110 == null) goto L38;
        r110.i(r11);
    L38:
        r11.restoreToCount(r1);
        return;
    L8:
        if (r10.h == 0) goto L10;
        goto L9
    }

    public final void a(int r4, a r5) {
        if (r4 >= 0) goto L4;
        return;
    L4:
        int r0 = this.p.size();
        if (r4 <= r0) goto L10;
        int r6 = r4 - r0;
        int r1 = 0;
    L7:
        if (r1 >= r6) goto L9;
        this.p.add(null);
        r1 = r1 + 1;
        goto L7
    L9:
        this.p.add(r5);
        return;
    L10:
        ListProtector.add(this.p, r4, r5);
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public final int getChildDrawingOrder(int r2, int r3) {
        int[] r4 = this.h;
        if (r4 != null) goto L5;
    L9:
        return r3;
    L5:
        if (r3 >= r4.length) goto L9;
        return r4[r3];
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public final void afterDrawChild(Canvas r1, View r2, long r3) {
        com.lynx.tasm.behavior.ui.a r4 = this.a;
        if (r4 == null) goto L6;
        r4.afterProcessChildViewInfo(this, r2, r3);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public final Rect beforeDrawChild(Canvas r2, View r3, long r4) {
        com.lynx.tasm.behavior.ui.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.beforeProcessChildViewInfo(this, r3, r4);
    L6:
        if (this.o >= this.p.size()) goto L15;
        a r5 = (a) ListProtector.get(this.p, this.o);
        if (r5 != null) goto L11;
        LLog.e("ViewInfo", "drawWithSubDrawInfo: info is null");
    L14:
        this.o++;
        goto L6
    L11:
        if (r5.c == true) goto L12;
        b(r5, r2);
        goto L14
    L12:
        Rect r6 = r5.d;
        this.o++;
        return r6;
    L15:
        return null;
    }

    public final void c(int r8, int r9, ArrayList<e> r10) {
        View r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.getLeft();
    L6:
        int r11 = r8 + r2;
        View r3 = this.b;
        if (r3 == null) goto L9;
        r1 = r3.getTop();
    L9:
        int r12 = r9 + r1;
        View r4 = this.b;
        if (r4 != null) goto L12;
    L17:
        Iterator<a> r5 = this.p.iterator();
    L19:
        if (r5.hasNext() == false) goto L34;
        a r6 = r5.next();
        if (r6 == null) goto L19;
        KeyEvent.Callback r7 = r6.b;
        if ((r7 instanceof e.a) == true) goto L25;
        if (r6.s == false) goto L19;
        int r13 = r6.g + r11;
        int r14 = r6.h + r12;
        int r15 = r6.i;
        int r16 = r6.j;
        d7a.f r17 = r6.e;
        if (r17 == null) goto L33;
        r17.e().booleanValue();
    L33:
        r10.add(new e(r13, r14, r15, r16));
        goto L19
    L25:
        e.a r18 = (e.a) r7;
        if ((r18.getDrawChildHook() instanceof m) == false) goto L19;
        ((m) r18.getDrawChildHook()).c(r11, r12, r10);
        goto L19
    L34:
        return;
    L12:
        if (this.j == false) goto L17;
        int r19 = r4.getWidth();
        int r20 = this.b.getHeight();
        d7a.f r21 = this.q;
        if (r21 == null) goto L16;
        r21.e().booleanValue();
    L16:
        e r22 = new e(r11, r12, r19, r20);
        this.b.getAlpha();
        this.b.getScaleX();
        this.b.getScaleY();
        this.b.getVisibility();
        r10.add(r22);
        goto L17
    L5:
        r2 = 0;
        goto L6
    }
}
