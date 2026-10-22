package com.larus.utils;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.business.floatchat.impl.TouchDelegateFrameLayout;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class v0 {
    public static final /* synthetic */ int a = 0;

    public static final class a extends TouchDelegate {
        public final Rect a;
        public final Rect b;
        public final View c;
        public final ViewGroup d;
        public boolean e;
        public final Rect f;
        public final int g;

        @Override // android.view.TouchDelegate
        public final boolean onTouchEvent(MotionEvent r8) {
            Intrinsics.checkNotNullParameter(r8, "event");
            if (8 != this.c.getVisibility()) goto L6;
            return false;
        L6:
            if (this.c.isEnabled() == true) goto L8;
            return false;
        L8:
            ViewGroup r0 = this.d;
            boolean r1 = true;
            if (r0 != null) goto L11;
        L10:
            boolean r2 = true;
        L17:
            if (r2 == true) goto L20;
            this.e = false;
            return false;
        L20:
            ViewGroup r3 = this.d;
            if (r3 != null) goto L23;
            this.c.getHitRect(this.a);
        L24:
            Rect r4 = this.a;
            int r5 = r4.left;
            Rect r6 = this.b;
            r4.left = r5 - r6.left;
            r4.top -= r6.top;
            r4.right += r6.right;
            r4.bottom += r6.bottom;
            this.f.set(r4);
            Rect r7 = this.f;
            int r9 = -this.g;
            r7.inset(r9, r9);
            int r10 = (int) r8.getX();
            int r11 = (int) r8.getY();
            int r12 = r8.getAction();
            if (r12 == 0) goto L39;
            if (r12 == 1) goto L32;
            if (r12 == 2) goto L32;
            if (r12 != 3) goto L42;
            boolean r13 = this.e;
            this.e = false;
        L41:
            boolean r14 = r13;
        L43:
            if (r14 == false) goto L52;
            View r15 = this.c;
            if (r1 == false) goto L47;
            r8.setLocation(r15.getWidth() / 2, r15.getHeight() / 2);
        L49:
            return r15.dispatchTouchEvent(r8);
        L47:
            float r16 = -(this.g * 2);
            r8.setLocation(r16, r16);
            goto L49
        L52:
            return false;
        L42:
            r14 = false;
        L32:
            r14 = this.e;
            if (r14 == true) goto L35;
        L37:
            r13 = r14;
            goto L41
        L35:
            if (this.f.contains(r10, r11) == true) goto L37;
            r1 = false;
            goto L43
        L39:
            if (this.a.contains(r10, r11) == false) goto L42;
            this.e = true;
            r13 = true;
            goto L41
        L23:
            this.c.getDrawingRect(this.a);
            r3.offsetDescendantRectToMyCoords(this.c, this.a);
            goto L24
        L11:
            ViewParent r17 = this.c.getParent();
        L12:
            if (r17 == null) goto L16;
            if (r17 == r0) goto L10;
            r17 = r17.getParent();
            goto L12
        L16:
            r2 = false;
            goto L17
        }

        public a(View r3, Rect r4) {
            Intrinsics.checkNotNullParameter(r3, "delegateView");
            Intrinsics.checkNotNullParameter(r4, "mExpandBounds");
            this(new Rect(), r4, r3, null);
        }

        public a(Rect r1, Rect r2, View r3, TouchDelegateFrameLayout r4) {
            super(r1, r3);
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.f = new Rect(r1);
            this.g = ViewConfiguration.get(r3.getContext()).getScaledTouchSlop();
        }
    }

    public static final class b extends TouchDelegate {
        public static final Rect c = null;
        public final List<a> a;
        public a b;

        public static final class a {
        }

        static {
            c = new Rect();
        }

        public b(View r2) {
            super(c, r2);
            this.a = new LinkedList();
        }

        public final void a(a r2) {
            Intrinsics.checkNotNullParameter(r2, "touchDelegate");
            ((LinkedList) this.a).add(r2);
        }

        @Override // android.view.TouchDelegate
        public final boolean onTouchEvent(MotionEvent r8) {
            Intrinsics.checkNotNullParameter(r8, "event");
            int r0 = r8.getAction();
            a r3 = null;
            if (r0 == 0) goto L12;
            if (r0 != 1) goto L6;
        L11:
            a r1 = this.b;
            this.b = null;
            r3 = r1;
        L31:
            if (r3 != null) goto L33;
            return false;
        L33:
            if (r3.onTouchEvent(r8) == false) goto L46;
            return true;
        L46:
            return false;
        L6:
            if (r0 != 2) goto L8;
            r3 = this.b;
            goto L31
        L8:
            if (r0 == 3) goto L11;
        L12:
            int r2 = 0;
        L14:
            if (r2 >= ((LinkedList) this.a).size()) goto L31;
            a r4 = (a) ListProtector.get(this.a, r2);
            ViewGroup r5 = r4.d;
            if (r5 != null) goto L18;
        L17:
            boolean r6 = true;
        L24:
            if (r6 == false) goto L25;
            if (r4.onTouchEvent(r8) == true) goto L28;
            r2 = r2 + 1;
            goto L14
        L28:
            this.b = r4;
            return true;
        L25:
            ListProtector.remove(this.a, r2);
            goto L14
        L18:
            ViewParent r7 = r4.c.getParent();
        L19:
            if (r7 == null) goto L23;
            if (r7 == r5) goto L17;
            r7 = r7.getParent();
            goto L19
        L23:
            r6 = false;
            goto L24
        }
    }

    static {
    }

    public static void a(View r2, int r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "target");
        Object r0 = r2.getParent();
        if ((r0 instanceof View) == false) goto L5;
        View r1 = (View) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        Rect r7 = new Rect();
        r7.left = c7.b(Integer.valueOf(r3));
        r7.top = c7.b(Integer.valueOf(r4));
        r7.right = c7.b(Integer.valueOf(r5));
        r7.bottom = c7.b(Integer.valueOf(r6));
        TouchDelegate r8 = r1.getTouchDelegate();
        if ((r8 instanceof b) == false) goto L11;
        ((b) r8).a(new a(r2, r7));
        return;
    L11:
        b r9 = new b(r2);
        r1.setTouchDelegate(r9);
        r9.a(new a(r2, r7));
        return;
    L5:
        r1 = null;
        goto L6
    }
}
