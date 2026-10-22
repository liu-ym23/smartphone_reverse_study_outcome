package com.lynx.tasm.behavior.ui;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UIGroup f10475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f10476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10477c;
    public int d;
    public float e;
    public float f;
    public in.b g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f10478h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10479i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f10480j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f10481k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Path f10482l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Rect f10483m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10484n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList f10485o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public dn.f f10486p;

    public g0(UIGroup r5, View r10) {
        this.f10480j = false;
        this.f10484n = 0;
        this.f10485o = new ArrayList();
        this.f10475a = r5;
        this.f10476b = r10;
    }

    public static void d(f0 r10, Canvas r11) {
        Rect r5 = r10.d;
        int r12 = r11.save();
        if (r5 == null) goto L5;
        r11.clipRect(r5);
    L5:
        int r13 = r10.g;
        if (r13 == 0) goto L8;
    L9:
        r11.translate(r13, r10.f10463h);
    L10:
        float r14 = r10.f10470o;
        if (r14 >= 1.0f) goto L13;
        r11.saveLayerAlpha(0.0f, 0.0f, r10.f10464i, r10.f10465j, (int) (r14 * 255.0f), 31);
    L13:
        int r15 = 0;
        com.lynx.tasm.behavior.ui.utils.g r16 = r10.f10473r;
        if (r16 == null) goto L22;
        com.lynx.tasm.behavior.ui.utils.f r17 = r16.f10750b;
        if (((BackgroundDrawable) r17) == null) goto L22;
        float r18 = r10.f10468m;
        float r19 = r10.f10467l;
        float r20 = r10.f10469n;
        float r21 = r10.f10466k;
        if (r17 == null) goto L20;
        r17.c(r18, r19, r20, r21);
    L20:
        BackgroundDrawable r22 = (BackgroundDrawable) r16.f10750b;
        r22.setBounds(0, 0, r10.f10464i, r10.f10465j);
        r22.draw(r11);
    L22:
        if (r10.f == null) goto L35;
        r11.translate(r10.f10471p, r10.f10472q);
        int r23 = r10.f10464i;
        if (r23 <= 0) goto L28;
        int r24 = r10.f10465j;
        if (r24 <= 0) goto L28;
        r11.clipRect(0, 0, r23, r24);
    L28:
        Spanned r25 = (Spanned) r10.f.getText();
        int r26 = com.lynx.tasm.behavior.ui.text.a.f10695p;
        if (r25 == null) goto L34;
        com.lynx.tasm.behavior.ui.text.a[] r27 = (com.lynx.tasm.behavior.ui.text.a[]) r25.getSpans(0, r25.length(), com.lynx.tasm.behavior.ui.text.a.class);
        int r28 = r27.length;
    L32:
        if (r15 >= r28) goto L34;
        r27[r15].f();
        r15 = r15 + 1;
    L34:
        r10.f.draw(r11);
    L35:
        dn.f r110 = r10.e;
        if (r110 == null) goto L38;
        r110.d(r11);
    L38:
        r11.restoreToCount(r12);
        return;
    L8:
        if (r10.f10463h == 0) goto L10;
        goto L9
    }

    public final void a() {
        Iterator r10 = this.f10485o.iterator();
    L4:
        if (r10.hasNext() == false) goto L12;
        f0 r5 = (f0) r10.next();
        if (r5.f10462c == false) goto L4;
        if (r5.f10460a == null) goto L4;
        View r11 = r5.f10461b;
        if (r11 == null) goto L4;
        int r12 = r5.g;
        int r13 = r5.f10463h;
        r11.layout(r12, r13, r5.f10464i + r12, r5.f10465j + r13);
        r5.f10460a.a();
        goto L4
    }

    @Override // com.lynx.tasm.behavior.ui.b
    public final void afterDispatchDraw(Canvas r5) {
        UIGroup r10 = this.f10475a;
        if (r10 == null) goto L5;
        r10.afterDispatchProcessViewInfo(this);
    L5:
        int r11 = this.f10484n;
        ArrayList r12 = this.f10485o;
        if (r11 >= r12.size()) goto L8;
        d((f0) r12.get(this.f10484n), r5);
        this.f10484n++;
        goto L5
    }

    @Override // com.lynx.tasm.behavior.ui.b
    public final void afterDraw(Canvas r5) {
        UIGroup r10 = this.f10475a;
        if (r10 == null) goto L6;
        r10.afterProcessViewInfo(this);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.b
    public final void afterDrawChild(Canvas r5, View r10, long r11) {
        UIGroup r12 = this.f10475a;
        if (r12 == null) goto L6;
        r12.afterProcessChildViewInfo(this, r10, r11);
        return;
    }

    public final void b(int r5, int r10, ArrayList r11) {
        int r12 = 0;
        View r13 = this.f10476b;
        if (r13 == null) goto L5;
        int r14 = r13.getLeft();
    L6:
        int r15 = r5 + r14;
        if (r13 == null) goto L9;
        r12 = r13.getTop();
    L9:
        int r16 = r10 + r12;
        if (r13 != null) goto L12;
    L14:
        Iterator r17 = this.f10485o.iterator();
    L16:
        if (r17.hasNext() == false) goto L28;
        f0 r18 = (f0) r17.next();
        if (r18 == null) goto L16;
        KeyEvent.Callback r19 = r18.f10461b;
        if ((r19 instanceof o) == true) goto L22;
        if (r18.s == false) goto L16;
        r11.add(new p());
        goto L16
    L22:
        o r20 = (o) r19;
        if ((r20.getDrawChildHook() instanceof g0) == false) goto L16;
        ((g0) r20.getDrawChildHook()).b(r15, r16, r11);
        goto L16
    L28:
        return;
    L12:
        if (this.f10480j == false) goto L14;
        r13.getWidth();
        r13.getHeight();
        p r21 = new p();
        r13.getAlpha();
        r13.getScaleX();
        r13.getScaleY();
        r13.getVisibility();
        r11.add(r21);
        goto L14
    L5:
        r14 = 0;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.b
    public final void beforeDispatchDraw(Canvas r5) {
        UIGroup r10 = this.f10475a;
        if (r10 == null) goto L5;
        r10.beforeDispatchProcessViewInfo(this);
    L5:
        this.f10484n = 0;
        if (this.f10481k == false) goto L14;
        Path r11 = this.f10482l;
        if (r11 == null) goto L10;
        r5.clipPath(r11);
        return;
    L10:
        Rect r12 = this.f10483m;
        if (r12 == null) goto L16;
        r5.clipRect(r12);
        return;
    L16:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.b
    public final void beforeDraw(Canvas r5) {
        UIGroup r10 = this.f10475a;
        if (r10 == null) goto L5;
        r10.beforeProcessViewInfo(this);
    L5:
        dn.f r11 = this.f10486p;
        if (r11 == null) goto L8;
        r11.d(r5);
    L8:
        float r12 = this.e;
        if (r12 == 0.0f) goto L11;
    L12:
        r5.skew(r12, this.f);
        View r13 = this.f10476b;
        r5.translate((-r13.getPivotY()) * this.e, (-r13.getPivotX()) * this.f);
    L13:
        in.b r14 = this.g;
        if (r14 == null) goto L19;
        Path r15 = r14.b(this.f10477c, this.d);
        if (r15 == null) goto L20;
        r5.clipPath(r15);
        return;
    L20:
        return;
    L19:
        return;
    L11:
        if (this.f == 0.0f) goto L13;
        goto L12
    }

    @Override // com.lynx.tasm.behavior.ui.b
    public final Rect beforeDrawChild(Canvas r5, View r10, long r11) {
        UIGroup r12 = this.f10475a;
        if (r12 == null) goto L5;
        r12.beforeProcessChildViewInfo(this, r10, r11);
    L5:
        int r13 = this.f10484n;
        ArrayList r14 = this.f10485o;
        if (r13 >= r14.size()) goto L16;
        f0 r15 = (f0) r14.get(this.f10484n);
        if (r15 != null) goto L11;
        LynxLog.b(4, "ViewInfo", "drawWithSubDrawInfo: info is null");
    L15:
        this.f10484n++;
        goto L5
    L11:
        if (r15.f10462c == true) goto L12;
        d(r15, r5);
        goto L15
    L12:
        this.f10484n++;
        return r15.d;
    L16:
        return null;
    }

    public final void c(int r5, f0 r10) {
        if (r5 >= 0) goto L4;
        return;
    L4:
        ArrayList r11 = this.f10485o;
        int r12 = r11.size();
        if (r5 <= r12) goto L11;
        int r13 = r5 - r12;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L9;
        r11.add(null);
        r14 = r14 + 1;
        goto L7
    L9:
        r11.add(r10);
        return;
    L11:
        r11.add(r5, r10);
    }

    public final void e() {
        Iterator r5 = this.f10485o.iterator();
    L4:
        if (r5.hasNext() == false) goto L12;
        f0 r10 = (f0) r5.next();
        if (r10.f10462c == false) goto L4;
        if (r10.f10460a == null) goto L4;
        View r11 = r10.f10461b;
        if (r11 == null) goto L4;
        int r12 = r10.f10464i;
        int r13 = r10.f10465j;
        r11.measure(View.MeasureSpec.makeMeasureSpec(r12, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r13, BasicMeasure.EXACTLY));
        r10.f10460a.e();
        goto L4
    }

    @Override // com.lynx.tasm.behavior.ui.b
    public final int getChildDrawingOrder(int r5, int r10) {
        int[] r11 = this.f10478h;
        if (r11 != null) goto L5;
    L9:
        return r10;
    L5:
        if (r10 >= r11.length) goto L9;
        return r11[r10];
    }

    @Override // com.lynx.tasm.behavior.ui.b
    public final boolean hasOverlappingRendering() {
        return this.f10479i;
    }

    @Override // com.lynx.tasm.behavior.ui.b
    public final void performLayoutChildrenUI() {
        UIGroup r5 = this.f10475a;
        if (r5 == null) goto L6;
        r5.processLayoutChildren();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.b
    public final void performMeasureChildrenUI() {
        UIGroup r5 = this.f10475a;
        if (r5 == null) goto L6;
        r5.processMeasureChildren();
        return;
    }
}
