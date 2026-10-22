package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UnknownNullness"})
public abstract class f0 {
    public f0() {
    }

    public static void d(View r10, List r11) {
        int r8 = r11.size();
        int r12 = 0;
    L4:
        if (r12 >= r8) goto L9;
        if (r11.get(r12) == r10) goto L7;
        r12 = r12 + 1;
        goto L4
    L7:
        boolean r13 = true;
    L10:
        if (r13 == false) goto L12;
        return;
    L12:
        WeakHashMap<View, j0.h0> r14 = j0.w.f8437a;
        if (j0.w.i.k(r10) == null) goto L15;
        r11.add(r10);
    L15:
        int r15 = r8;
    L17:
        if (r15 >= r11.size()) goto L35;
        View r16 = (View) r11.get(r15);
        if ((r16 instanceof ViewGroup) == false) goto L34;
        ViewGroup r17 = (ViewGroup) r16;
        int r18 = r17.getChildCount();
        int r19 = 0;
    L21:
        if (r19 >= r18) goto L34;
        View r20 = r17.getChildAt(r19);
        int r21 = 0;
    L23:
        if (r21 >= r8) goto L28;
        if (r11.get(r21) == r20) goto L26;
        r21 = r21 + 1;
        goto L23
    L26:
        boolean r22 = true;
    L29:
        if (r22 == true) goto L33;
        if (j0.w.i.k(r20) == null) goto L33;
        r11.add(r20);
    L33:
        r19 = r19 + 1;
        goto L21
    L28:
        r22 = false;
    L34:
        r15 = r15 + 1;
        goto L17
    L35:
        return;
    L9:
        r13 = false;
        goto L10
    }

    public static void g(View r8, Rect r10) {
        WeakHashMap<View, j0.h0> r11 = j0.w.f8437a;
        if (j0.w.g.b(r8) == true) goto L5;
        return;
    L5:
        RectF r12 = new RectF();
        r12.set(0.0f, 0.0f, r8.getWidth(), r8.getHeight());
        r8.getMatrix().mapRect(r12);
        r12.offset(r8.getLeft(), r8.getTop());
        Object r13 = r8.getParent();
    L7:
        if ((r13 instanceof View) == false) goto L9;
        View r14 = (View) r13;
        r12.offset(-r14.getScrollX(), -r14.getScrollY());
        r14.getMatrix().mapRect(r12);
        r12.offset(r14.getLeft(), r14.getTop());
        r13 = r14.getParent();
        goto L7
    L9:
        int[] r15 = new int[2];
        r8.getRootView().getLocationOnScreen(r15);
        r12.offset(r15[0], r15[1]);
        r10.set(Math.round(r12.left), Math.round(r12.top), Math.round(r12.right), Math.round(r12.bottom));
    }

    public static boolean h(List r8) {
        if (r8 != null) goto L4;
    L7:
        return true;
    L4:
        if (r8.isEmpty() == true) goto L7;
        return false;
    }

    public static ArrayList k(ArrayList r8) {
        ArrayList r10 = new ArrayList();
        int r11 = r8.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        View r13 = (View) r8.get(r12);
        WeakHashMap<View, j0.h0> r14 = j0.w.f8437a;
        r10.add(j0.w.i.k(r13));
        j0.w.i.v(r13, null);
        r12 = r12 + 1;
        goto L3
    L5:
        return r10;
    }

    public static void q(ViewGroup r8, ArrayList r10, ArrayList r11, ArrayList r12, n.b r13) {
        int r14 = r11.size();
        ArrayList r15 = new ArrayList();
        int r16 = 0;
    L3:
        if (r16 >= r14) goto L14;
        View r17 = (View) r10.get(r16);
        WeakHashMap<View, j0.h0> r18 = j0.w.f8437a;
        String r19 = j0.w.i.k(r17);
        r15.add(r19);
        if (r19 == null) goto L13;
        j0.w.i.v(r17, null);
        String r20 = (String) r13.getOrDefault(r19, null);
        int r21 = 0;
    L8:
        if (r21 >= r14) goto L13;
        if (r20.equals(r12.get(r21)) == true) goto L11;
        r21 = r21 + 1;
        goto L8
    L11:
        j0.w.i.v((View) r11.get(r21), r19);
    L13:
        r16 = r16 + 1;
        goto L3
    L14:
        j0.r.a(r8, new e0(r14, r11, r12, r10, r15));
    }

    public abstract void a(View r8, Object r10);

    public abstract void b(Object r8, ArrayList<View> r10);

    public abstract void c(ViewGroup r8, Object r10);

    public abstract boolean e(Object r8);

    public abstract Object f(Object r8);

    public abstract Object i(Object r8, Object r10, Object r11);

    public abstract Object j(Object r8, Object r10, Object r11);

    public abstract void l(Object r8, View r10, ArrayList<View> r11);

    public abstract void m(Object r8, Object r10, ArrayList<View> r11, Object r12, ArrayList<View> r13, Object r14, ArrayList<View> r15);

    public abstract void n(View r8, Object r10);

    public abstract void o(Object r8, Rect r10);

    public void p(Object r8, Runnable r10) {
        r10.run();
    }

    public abstract void r(Object r8, View r10, ArrayList<View> r11);

    public abstract void s(Object r8, ArrayList<View> r10, ArrayList<View> r11);

    public abstract Object t(Object r8);
}
