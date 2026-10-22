package com.ss.android.lark.player.widget;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import v0c.f;
import v0c.g;
import v0c.h;
import v0c.i;
import v0c.k;
import v0c.l;
import v0c.m;
import v0c.n;
import v0c.o;
import v0c.p;
import v0c.q;
import v0c.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class SuperContainer extends FrameLayout {
    public FrameLayout a;
    public v0c.c b;
    public x0c.c c;
    public q d;
    public t e;
    public g f;
    public p g;
    public y0c.a h;
    public GestureDetector i;
    public final a j;
    public final b k;

    public class a implements q {
        public final /* synthetic */ SuperContainer a;

        public a(SuperContainer r1) {
            this.a = r1;
        }

        @Override // v0c.q
        public final void a(int r3, Bundle r4) {
            q r0 = this.a.d;
            if (r0 == null) goto L5;
            r0.a(r3, r4);
        L5:
            g r1 = this.a.f;
            if (r1 == null) goto L11;
            r1.a.b(null, new k(r3, r4));
            if (r4 == null) goto L12;
            r4.clear();
            return;
        L12:
            return;
        }
    }

    public class b implements p.b {
        public final /* synthetic */ SuperContainer a;

        public b(SuperContainer r1) {
            this.a = r1;
        }

        @Override // v0c.p.b
        public final void a(v0c.a r2) {
            SuperContainer.a(this.a, r2);
        }
    }

    public class c implements y0c.b {
        public final /* synthetic */ SuperContainer a;

        @Override // y0c.b
        public final void f() {
            g r0 = this.a.f;
            if (r0 == null) goto L6;
            r0.a(new v0c.e());
            return;
        }

        public c(SuperContainer r1) {
            this.a = r1;
        }

        @Override // y0c.b
        public final void onDoubleTap(MotionEvent r3) {
            g r0 = this.a.f;
            if (r0 == null) goto L6;
            r0.a(new m(r3));
            return;
        }

        @Override // y0c.b
        public final void onDown(MotionEvent r3) {
            g r0 = this.a.f;
            if (r0 == null) goto L6;
            r0.a(new n(r3));
            return;
        }

        @Override // y0c.b
        public final void onLongPress(MotionEvent r3) {
            g r0 = this.a.f;
            if (r0 == null) goto L6;
            r0.a(new f(r3));
            return;
        }

        @Override // y0c.b
        public final void onSingleTapUp(MotionEvent r3) {
            g r0 = this.a.f;
            if (r0 == null) goto L6;
            r0.a(new l(r3));
            return;
        }

        @Override // y0c.b
        public final void onScroll(MotionEvent r3, MotionEvent r4, float r5, float r6) {
            g r0 = this.a.f;
            if (r0 == null) goto L6;
            r0.a(new v0c.d(r3, r4, r5, r6));
            return;
        }
    }

    public class d {
        public d() {
        }
    }

    public class e implements p.a {
        public final /* synthetic */ SuperContainer a;

        public e(SuperContainer r1) {
            this.a = r1;
        }

        @Override // v0c.p.a
        public final void a(o r2) {
            SuperContainer.a(this.a, r2);
        }
    }

    public final void c() {
        measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        layout(getLeft(), getTop(), getRight(), getBottom());
    }

    public q getOnReceiverEventListener() {
        return this.d;
    }

    public t getStateGetter() {
        return this.e;
    }

    public SuperContainer(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r3) {
        if (r3.getAction() != 1) goto L8;
        y0c.b r0 = this.h.a;
        if (r0 == null) goto L8;
        r0.f();
    L8:
        return this.i.onTouchEvent(r3);
    }

    public void setOnReceiverEventListener(q r1) {
        this.d = r1;
    }

    public final void setReceiverGroup(p r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.equals(this.g) == true) goto L12;
        v0c.c r0 = this.b;
        ((ArrayList) r0.b).clear();
        r0.a.removeAllViews();
        p r1 = this.g;
        if (r1 == null) goto L9;
        r1.c(this.k);
    L9:
        this.g = r3;
        this.f = new g(r3);
        r3.d(new e(this));
        this.g.a(this.k);
        return;
    }

    public final void setRenderView(View r4) {
        FrameLayout r0 = this.a;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, -2, 17);
        this.a.addView(r4, r1);
    }

    public void setStateGetter(t r1) {
        this.e = r1;
    }

    public SuperContainer(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public static void a(SuperContainer r3, o r4) {
        r4.b(r3.j);
        r4.c(r3.e);
        if ((r4 instanceof v0c.a) == false) goto L12;
        v0c.a r5 = (v0c.a) r4;
        v0c.c r6 = r3.b;
        r6.getClass();
        if (r5.d == null) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        ((ArrayList) r6.b).add(r5);
        r6.a.addView(r5.d, new ViewGroup.LayoutParams(-1, -1));
    L10:
        Log.d("SuperContainer", "on cover attach : " + r5.getClass().getSimpleName() + " ,0");
        return;
    L7:
        r0 = false;
        goto L8
    }

    public final void b(int r3, Bundle r4) {
        g r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 == (-99019)) goto L7;
        r0.a.d(new i(r3, r4));
    L8:
        if (r4 == null) goto L12;
        r4.clear();
        return;
    L12:
        return;
    L7:
        r0.a.d(new h(r4, r3));
        goto L8
    }

    public SuperContainer(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.j = new a(this);
        this.k = new b(this);
        c r5 = new c(this);
        new d();
        this.c = new x0c.c();
        this.h = new y0c.a(r5);
        this.i = new GestureDetector(r2, this.h);
        FrameLayout r6 = new FrameLayout(r2);
        this.a = r6;
        addView(r6, new ViewGroup.LayoutParams(-1, -1));
        v0c.c r7 = new v0c.c();
        this.b = r7;
        FrameLayout r8 = new FrameLayout(r2);
        r7.a = r8;
        r8.setBackgroundColor(0);
        addView(r7.a, new ViewGroup.LayoutParams(-1, -1));
    }
}
