package f1;

import android.animation.Animator;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.obric.cae.R;
import j0.h0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f1.a f7286a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<WeakReference<n.b<ViewGroup, ArrayList<h>>>> f7287b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList<ViewGroup> f7288c = null;

    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f7289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewGroup f7290b;

        /* JADX INFO: renamed from: f1.l$a$a, reason: collision with other inner class name */
        public class C0071a extends k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n.b f7291a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f7292b;

            public C0071a(a r8, n.b r10) {
                this.f7292b = r8;
                this.f7291a = r10;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // f1.h.d
            public final void d(h r8) {
                ViewGroup r10 = this.f7292b.f7290b;
                ((ArrayList) this.f7291a.getOrDefault(r10, null)).remove(r8);
                r8.v(this);
            }
        }

        public a(ViewGroup r8, h r10) {
            this.f7289a = r10;
            this.f7290b = r8;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            ViewGroup r8 = this.f7290b;
            r8.getViewTreeObserver().removeOnPreDrawListener(this);
            r8.removeOnAttachStateChangeListener(this);
            int r10 = 1;
            if (l.f7288c.remove(r8) == true) goto L5;
            return true;
        L5:
            n.b<ViewGroup, ArrayList<h>> r11 = l.b();
            ArrayList<h> r12 = r11.getOrDefault(r8, null);
            if (r12 != null) goto L9;
            r12 = new ArrayList();
            r11.put(r8, r12);
        L11:
            ArrayList r13 = null;
        L12:
            h r14 = this.f7289a;
            r12.add(r14);
            r14.a(new C0071a(this, r11));
            int r15 = 0;
            r14.h(r8, false);
            if (r13 == null) goto L18;
            Iterator r16 = r13.iterator();
        L16:
            if (r16.hasNext() == false) goto L18;
            ((h) r16.next()).x(r8);
        L18:
            r14.f7272u = new ArrayList();
            r14.f7273v = new ArrayList();
            p.c r17 = r14.f7268q;
            p.c r18 = r14.f7269r;
            n.b r19 = new n.b((n.b) r17.f9866a);
            n.b r20 = new n.b((n.b) r18.f9866a);
            int r21 = 0;
        L19:
            int[] r110 = r14.f7271t;
            if (r21 >= r110.length) goto L95;
            int r111 = r110[r21];
            if (r111 != r10) goto L24;
            ViewGroup r112 = r8;
            int r22 = r19.f9401m;
        L83:
            r22 = r22 - 1;
            if (r22 < 0) goto L94;
            View r23 = (View) r19.i(r22);
            if (r23 == null) goto L83;
            if (r14.s(r23) == false) goto L83;
            n r24 = (n) r20.remove(r23);
            if (r24 == null) goto L83;
            if (r14.s(r24.f7296b) == false) goto L83;
            r14.f7272u.add((n) r19.j(r22));
            r14.f7273v.add(r24);
        L94:
            r21 = r21 + 1;
            r8 = r112;
            r15 = 0;
            r10 = 1;
            goto L19
        L24:
            if (r111 != 2) goto L26;
            r112 = r8;
            n.b r25 = (n.b) r17.f9869d;
            n.b r26 = (n.b) r18.f9869d;
            int r27 = r25.f9401m;
            int r113 = 0;
        L68:
            if (r113 >= r27) goto L94;
            View r114 = (View) r25.k(r113);
            if (r114 == null) goto L81;
            if (r14.s(r114) == false) goto L81;
            View r115 = (View) r26.getOrDefault(r25.i(r113), null);
            if (r115 == null) goto L81;
            if (r14.s(r115) == false) goto L81;
            n r116 = (n) r19.getOrDefault(r114, null);
            n r117 = (n) r20.getOrDefault(r115, null);
            if (r116 == null) goto L81;
            if (r117 == null) goto L81;
            r14.f7272u.add(r116);
            r14.f7273v.add(r117);
            r19.remove(r114);
            r20.remove(r115);
        L81:
            r113 = r113 + 1;
            goto L68
        L26:
            if (r111 != 3) goto L28;
            r112 = r8;
            SparseArray r28 = (SparseArray) r17.f9867b;
            SparseArray r29 = (SparseArray) r18.f9867b;
            int r30 = r28.size();
            int r118 = 0;
        L53:
            if (r118 >= r30) goto L94;
            View r119 = (View) r28.valueAt(r118);
            if (r119 == null) goto L66;
            if (r14.s(r119) == false) goto L66;
            View r120 = (View) r29.get(r28.keyAt(r118));
            if (r120 == null) goto L66;
            if (r14.s(r120) == false) goto L66;
            n r121 = (n) r19.getOrDefault(r119, null);
            n r122 = (n) r20.getOrDefault(r120, null);
            if (r121 == null) goto L66;
            if (r122 == null) goto L66;
            r14.f7272u.add(r121);
            r14.f7273v.add(r122);
            r19.remove(r119);
            r20.remove(r120);
        L66:
            r118 = r118 + 1;
            goto L53
        L28:
            if (r111 == 4) goto L30;
        L29:
            r112 = r8;
            goto L94
        L30:
            n.e r123 = (n.e) r17.f9868c;
            n.e r124 = (n.e) r18.f9868c;
            if (r123.f9371a == false) goto L33;
            r123.c();
        L33:
            int r125 = r123.f9374n;
            int r126 = r15;
        L34:
            if (r126 >= r125) goto L29;
            View r127 = (View) r123.h(r126);
            if (r127 != null) goto L38;
        L50:
            ViewGroup r128 = r8;
        L51:
            r126 = r126 + 1;
            r8 = r128;
            goto L34
        L38:
            if (r14.s(r127) == false) goto L50;
            if (r123.f9371a == false) goto L42;
            r123.c();
        L42:
            r128 = r8;
            View r31 = (View) r124.e(r123.f9372b[r126], null);
            if (r31 == null) goto L51;
            if (r14.s(r31) == false) goto L51;
            n r32 = (n) r19.getOrDefault(r127, null);
            n r129 = (n) r20.getOrDefault(r31, null);
            if (r32 == null) goto L51;
            if (r129 == null) goto L51;
            r14.f7272u.add(r32);
            r14.f7273v.add(r129);
            r19.remove(r127);
            r20.remove(r31);
            goto L51
        L95:
            ViewGroup r130 = r8;
            int r33 = 0;
        L97:
            if (r33 >= r19.f9401m) goto L102;
            n r34 = (n) r19.k(r33);
            if (r14.s(r34.f7296b) == false) goto L101;
            r14.f7272u.add(r34);
            r14.f7273v.add(null);
        L101:
            r33 = r33 + 1;
            goto L97
        L102:
            int r35 = 0;
        L104:
            if (r35 >= r20.f9401m) goto L109;
            n r36 = (n) r20.k(r35);
            if (r14.s(r36.f7296b) == false) goto L108;
            r14.f7273v.add(r36);
            r14.f7272u.add(null);
        L108:
            r35 = r35 + 1;
            goto L104
        L109:
            n.b<Animator, h.b> r37 = h.o();
            int r38 = r37.f9401m;
            o.a r39 = o.f7298a;
            w r40 = new w(r130);
            int r41 = r38 - 1;
        L110:
            if (r41 < 0) goto L138;
            Animator r42 = r37.i(r41);
            if (r42 == null) goto L137;
            h.b r43 = r37.getOrDefault(r42, null);
            if (r43 == null) goto L137;
            View r44 = r43.f7278a;
            if (r44 == null) goto L137;
            if (r40.equals(r43.f7281d) == false) goto L137;
            n r131 = r14.q(r44, true);
            n r132 = r14.n(r44, true);
            if (r131 != null) goto L123;
            if (r132 != null) goto L123;
            r132 = (n) ((n.b) r14.f7269r.f9866a).getOrDefault(r44, null);
        L123:
            if (r131 != null) goto L126;
            if (r132 != null) goto L126;
        L128:
            boolean r45 = false;
        L129:
            if (r45 == false) goto L137;
            if (r42.isRunning() == false) goto L133;
        L136:
            r42.cancel();
            goto L137
        L133:
            if (r42.isStarted() == true) goto L136;
            r37.remove(r42);
        L126:
            if (r43.f7282e.r(r43.f7280c, r132) == false) goto L128;
            r45 = true;
        L137:
            r41 = r41 - 1;
            goto L110
        L138:
            r14.l(r130, r14.f7268q, r14.f7269r, r14.f7272u, r14.f7273v);
            r14.y();
            return true;
        L9:
            if (r12.size() <= 0) goto L11;
            r13 = new ArrayList(r12);
            goto L12
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r8) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r8) {
            ViewGroup r10 = this.f7290b;
            r10.getViewTreeObserver().removeOnPreDrawListener(this);
            r10.removeOnAttachStateChangeListener(this);
            l.f7288c.remove(r10);
            ArrayList<h> r11 = l.b().getOrDefault(r10, null);
            if (r11 != null) goto L5;
        L10:
            this.f7289a.i(true);
            return;
        L5:
            if (r11.size() <= 0) goto L10;
            Iterator<h> r12 = r11.iterator();
        L8:
            if (r12.hasNext() == false) goto L10;
            r12.next().x(r10);
            goto L8
        }
    }

    static {
        f7286a = new f1.a();
        f7287b = new ThreadLocal();
        f7288c = new ArrayList();
    }

    public static void a(ViewGroup r8, h r10) {
        ArrayList<ViewGroup> r11 = f7288c;
        if (r11.contains(r8) == true) goto L25;
        WeakHashMap<View, h0> r12 = j0.w.f8437a;
        if (j0.w.g.c(r8) == false) goto L27;
        r11.add(r8);
        if (r10 != null) goto L9;
        r10 = f7286a;
    L9:
        h r13 = r10.j();
        ArrayList<h> r14 = b().getOrDefault(r8, null);
        if (r14 != null) goto L12;
    L17:
        if (r13 == null) goto L20;
        r13.h(r8, true);
    L20:
        if (((g) r8.getTag(R.id.transition_current_scene)) != null) goto L24;
        r8.setTag(R.id.transition_current_scene, null);
        if (r13 == null) goto L28;
        a r15 = new a(r8, r13);
        r8.addOnAttachStateChangeListener(r15);
        r8.getViewTreeObserver().addOnPreDrawListener(r15);
        return;
    L28:
        return;
    L24:
        throw null;
    L12:
        if (r14.size() <= 0) goto L17;
        Iterator<h> r16 = r14.iterator();
    L15:
        if (r16.hasNext() == false) goto L17;
        r16.next().u(r8);
        goto L15
    L27:
        return;
    }

    public static n.b<ViewGroup, ArrayList<h>> b() {
        ThreadLocal<WeakReference<n.b<ViewGroup, ArrayList<h>>>> r8 = f7287b;
        WeakReference<n.b<ViewGroup, ArrayList<h>>> r10 = r8.get();
        if (r10 == null) goto L7;
        n.b<ViewGroup, ArrayList<h>> r11 = r10.get();
        if (r11 == null) goto L7;
        return r11;
    L7:
        n.b<ViewGroup, ArrayList<h>> r12 = new n.b();
        r8.set(new WeakReference(r12));
        return r12;
    }
}
