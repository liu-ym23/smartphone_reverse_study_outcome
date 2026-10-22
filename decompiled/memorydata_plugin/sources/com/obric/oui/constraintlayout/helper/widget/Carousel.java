package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.obric.memorydata.plugin.R;
import com.obric.oui.constraintlayout.motion.widget.MotionHelper;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.obric.oui.constraintlayout.motion.widget.q;
import com.obric.oui.constraintlayout.widget.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class Carousel extends MotionHelper {
    private float A;
    private int B;
    private int C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f13645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Runnable f13646b;
    private a d;
    private final ArrayList<View> e;
    private int f;
    private int g;
    private MotionLayout h;
    private int i;
    private boolean r;
    private int s;
    private int t;
    private int u;
    private int v;
    private float w;
    private int x;
    private int y;
    private int z;

    public interface a {
        int a();

        void a(int r1);

        void a(View r1, int r2);
    }

    public Carousel(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        this.d = null;
        this.e = new ArrayList();
        this.f = 0;
        this.g = 0;
        this.i = -1;
        this.r = false;
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = 0.9f;
        this.x = 0;
        this.y = 4;
        this.z = 1;
        this.A = 2.0f;
        this.B = -1;
        this.C = 200;
        this.f13645a = -1;
        this.f13646b = new AnonymousClass1(this);
    }

    public Carousel(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7);
        this.d = null;
        this.e = new ArrayList();
        this.f = 0;
        this.g = 0;
        this.i = -1;
        this.r = false;
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = 0.9f;
        this.x = 0;
        this.y = 4;
        this.z = 1;
        this.A = 2.0f;
        this.B = -1;
        this.C = 200;
        this.f13645a = -1;
        this.f13646b = new AnonymousClass1(this);
        a(r6, r7);
    }

    public Carousel(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
        this.d = null;
        this.e = new ArrayList();
        this.f = 0;
        this.g = 0;
        this.i = -1;
        this.r = false;
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = 0.9f;
        this.x = 0;
        this.y = 4;
        this.z = 1;
        this.A = 2.0f;
        this.B = -1;
        this.C = 200;
        this.f13645a = -1;
        this.f13646b = new AnonymousClass1(this);
        a(r6, r7);
    }

    static /* synthetic */ MotionLayout a(Carousel r0) {
        return r0.h;
    }

    private void a(Context r6, AttributeSet r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L51;
        TypedArray r10 = r8.obtainStyledAttributes(r9, R.styleable.Carousel);
        int r11 = r10.getIndexCount();
        int r0 = 0;
    L5:
        if (r0 >= r11) goto L37;
        int r1 = r10.getIndex(r0);
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_firstView, "styleable", "Carousel_carousel_firstView")) goto L10;
        this.i = r10.getResourceId(r1, this.i);
    L36:
        r0 = r0 + 1;
        goto L5
    L10:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_backwardTransition, "styleable", "Carousel_carousel_backwardTransition")) goto L13;
        this.s = r10.getResourceId(r1, this.s);
        goto L36
    L13:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_forwardTransition, "styleable", "Carousel_carousel_forwardTransition")) goto L16;
        this.t = r10.getResourceId(r1, this.t);
        goto L36
    L16:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_emptyViewsBehavior, "styleable", "Carousel_carousel_emptyViewsBehavior")) goto L19;
        this.y = r10.getInt(r1, this.y);
        goto L36
    L19:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_previousState, "styleable", "Carousel_carousel_previousState")) goto L22;
        this.u = r10.getResourceId(r1, this.u);
        goto L36
    L22:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_nextState, "styleable", "Carousel_carousel_nextState")) goto L25;
        this.v = r10.getResourceId(r1, this.v);
        goto L36
    L25:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_touchUp_dampeningFactor, "styleable", "Carousel_carousel_touchUp_dampeningFactor")) goto L28;
        this.w = r10.getFloat(r1, this.w);
        goto L36
    L28:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_touchUpMode, "styleable", "Carousel_carousel_touchUpMode")) goto L31;
        this.z = r10.getInt(r1, this.z);
        goto L36
    L31:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_touchUp_velocityThreshold, "styleable", "Carousel_carousel_touchUp_velocityThreshold")) goto L34;
        this.A = r10.getFloat(r1, this.A);
        goto L36
    L34:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_infinite, "styleable", "Carousel_carousel_infinite")) goto L36;
        this.r = r10.getBoolean(r1, this.r);
        goto L36
    L37:
        r10.recycle();
        return;
    }

    private boolean a(int r2, View r3, int r4) {
        b r1 = this.h.getConstraintSet(r2);
        if (r1 != null) goto L5;
        return false;
    L5:
        b.a r5 = r1.f(r3.getId());
        if (r5 != null) goto L8;
        return false;
    L8:
        r5.c.c = 1;
        r3.setVisibility(r4);
        return true;
    }

    private boolean a(int r3, boolean r4) {
        if (r3 != (-1)) goto L5;
        return false;
    L5:
        MotionLayout r2 = this.h;
        if (r2 != null) goto L8;
        return false;
    L8:
        q.a r5 = r2.getTransition(r3);
        if (r5 != null) goto L12;
        return false;
    L12:
        if (r4 != r5.f()) goto L14;
        return false;
    L14:
        r5.a(r4);
        return true;
    }

    private boolean a(View r5, int r6) {
        MotionLayout r0 = this.h;
        int r1 = 0;
        if (r0 != null) goto L5;
        return false;
    L5:
        int[] r2 = r0.getConstraintSetIds();
        boolean r3 = false;
    L7:
        if (r1 >= r2.length) goto L9;
        r3 = r3 | a(r2[r1], r5, r6);
        r1 = r1 + 1;
        goto L7
    L9:
        return r3;
    }

    static /* synthetic */ void b(Carousel r0) {
        r0.f();
    }

    static /* synthetic */ int c(Carousel r0) {
        return r0.g;
    }

    static /* synthetic */ a d(Carousel r0) {
        return r0.d;
    }

    static /* synthetic */ int e(Carousel r0) {
        return r0.z;
    }

    static /* synthetic */ float f(Carousel r0) {
        return r0.A;
    }

    private void f() {
        a r0 = this.d;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.h != null) goto L9;
        return;
    L9:
        if (r0.a() != 0) goto L11;
        return;
    L11:
        int r1 = this.e.size();
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L44;
        View r3 = (View) ZeusTransformUtils.preCheckCast(this.e.get(r2), View.class, "com.obric.memorydata.plugin");
        int r4 = (this.g + r2) - this.x;
        if (this.r == true) goto L16;
        if (r4 >= 0) goto L39;
    L37:
        a(r3, this.y);
    L43:
        r2 = r2 + 1;
        goto L12
    L39:
        if (r4 >= this.d.a()) goto L37;
    L41:
        a(r3, 0);
    L42:
        this.d.a(r3, r4);
        goto L43
    L16:
        if (r4 >= 0) goto L26;
        int r6 = this.y;
        if (r6 == 4) goto L20;
        a(r3, r6);
    L22:
        if ((r4 % this.d.a()) != 0) goto L24;
        this.d.a(r3, 0);
        goto L43
    L24:
        a r5 = this.d;
        r5.a(r3, r5.a() + (r4 % this.d.a()));
        goto L43
    L20:
        a(r3, 0);
        goto L22
    L26:
        if (r4 < this.d.a()) goto L41;
        if (r4 != this.d.a()) goto L31;
        r4 = 0;
    L33:
        int r7 = this.y;
        if (r7 == 4) goto L41;
        a(r3, r7);
        goto L42
    L31:
        if (r4 <= this.d.a()) goto L33;
        r4 = r4 % this.d.a();
        goto L33
    L44:
        int r8 = this.B;
        if (r8 == (-1)) goto L50;
        if (r8 == this.g) goto L50;
        this.h.post(new $$Lambda$Carousel$vm3Qup2md6ANzoMbYH9y2p_T4o(this));
    L53:
        if (this.s != (-1)) goto L55;
    L69:
        Log.w("Carousel", "No backward or forward transitions defined for Carousel!");
        return;
    L55:
        if (this.t == (-1)) goto L69;
        if (this.r == false) goto L60;
        return;
    L60:
        int r9 = this.d.a();
        if (this.g != 0) goto L63;
        a(this.s, false);
    L65:
        if (this.g != (r9 - 1)) goto L67;
        a(this.t, false);
        return;
    L67:
        a(this.t, true);
        this.h.setTransition(this.t);
        return;
    L63:
        a(this.s, true);
        this.h.setTransition(this.s);
    L50:
        if (r8 != this.g) goto L53;
        this.B = -1;
        goto L53
    }

    static /* synthetic */ float g(Carousel r0) {
        return r0.w;
    }

    private /* synthetic */ void g() {
        this.h.setTransitionDuration(this.C);
        if (this.B >= this.g) goto L5;
        MotionLayout r0 = this.h;
        int r1 = this.u;
    L6:
        r0.transitionToState(r1, this.C);
        return;
    L5:
        r0 = this.h;
        r1 = this.v;
        goto L6
    }

    static /* synthetic */ int h(Carousel r0) {
        return r0.f;
    }

    /* JADX INFO: renamed from: lambda$vm3Qup2md6ANzoMbYH9y2p-_T4o, reason: not valid java name */
    public static /* synthetic */ void m1278lambda$vm3Qup2md6ANzoMbYH9y2p_T4o(Carousel r0) {
        r0.g();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionHelper, com.obric.oui.constraintlayout.motion.widget.MotionLayout.g
    public void a(MotionLayout r2, int r3) {
        int r4 = this.g;
        this.f = r4;
        if (r3 != this.v) goto L7;
        int r5 = r4 + 1;
    L5:
        this.g = r5;
    L10:
        if (this.r == false) goto L18;
        if (this.g < this.d.a()) goto L15;
        this.g = 0;
    L15:
        if (this.g >= 0) goto L24;
        this.g = this.d.a() - 1;
    L24:
        if (this.f == this.g) goto L27;
        this.h.post(this.f13646b);
        return;
    L27:
        return;
    L18:
        if (this.g < this.d.a()) goto L21;
        this.g = this.d.a() - 1;
    L21:
        if (this.g >= 0) goto L24;
        this.g = 0;
        goto L24
    L7:
        if (r3 != this.u) goto L10;
        r5 = r4 - 1;
        goto L5
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionHelper, com.obric.oui.constraintlayout.motion.widget.MotionLayout.g
    public void a(MotionLayout r1, int r2, int r3, float r4) {
        this.f13645a = r2;
    }

    public int getCount() {
        a r0 = this.d;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.a();
    }

    public int getCurrentIndex() {
        return this.g;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (ZeusTransformUtils.instanceOf(getParent(), MotionLayout.class) == false) goto L24;
        MotionLayout r0 = (MotionLayout) ZeusTransformUtils.preCheckCast(getParent(), MotionLayout.class, "com.obric.memorydata.plugin");
        this.e.clear();
        int r1 = 0;
    L6:
        if (r1 >= this.k) goto L11;
        int r2 = this.j[r1];
        View r3 = r0.getViewById(r2);
        if (this.i != r2) goto L10;
        this.x = r1;
    L10:
        this.e.add(r3);
        r1 = r1 + 1;
        goto L6
    L11:
        this.h = r0;
        if (this.z != 2) goto L19;
        q.a r4 = r0.getTransition(this.t);
        if (r4 == null) goto L16;
        r4.d(5);
    L16:
        q.a r5 = this.h.getTransition(this.s);
        if (r5 == null) goto L19;
        r5.d(5);
    L19:
        f();
        return;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.e.clear();
    }

    public void setAdapter(a r3) {
        this.d = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
    }

    public void setInfinite(boolean r1) {
        this.r = r1;
    }
}
