package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c0 extends f0 {

    public class a implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f1937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1938b;

        public a(View r8, ArrayList r10) {
            this.f1937a = r8;
            this.f1938b = r10;
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionCancel(Transition r8) {
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionEnd(Transition r8) {
            r8.removeListener(this);
            this.f1937a.setVisibility(8);
            ArrayList r10 = this.f1938b;
            int r11 = r10.size();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            ((View) r10.get(r12)).setVisibility(0);
            r12 = r12 + 1;
            goto L3
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionPause(Transition r8) {
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionResume(Transition r8) {
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionStart(Transition r8) {
            r8.removeListener(this);
            r8.addListener(this);
        }
    }

    public class b implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f1939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1940b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f1941c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1942d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f1943e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1944f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ c0 f1945g;

        public b(c0 r8, Object r10, ArrayList r11, Object r12, ArrayList r13, Object r14, ArrayList r15) {
            this.f1945g = r8;
            this.f1939a = r10;
            this.f1940b = r11;
            this.f1941c = r12;
            this.f1942d = r13;
            this.f1943e = r14;
            this.f1944f = r15;
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionCancel(Transition r8) {
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionEnd(Transition r8) {
            r8.removeListener(this);
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionPause(Transition r8) {
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionResume(Transition r8) {
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionStart(Transition r8) {
            c0 r10 = this.f1945g;
            Object r11 = this.f1939a;
            if (r11 == null) goto L5;
            r10.v(r11, this.f1940b, null);
        L5:
            Object r12 = this.f1941c;
            if (r12 == null) goto L8;
            r10.v(r12, this.f1942d, null);
        L8:
            Object r13 = this.f1943e;
            if (r13 == null) goto L12;
            r10.v(r13, this.f1944f, null);
            return;
        }
    }

    public class c extends Transition.EpicenterCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f1946a;

        public c(Rect r8) {
            this.f1946a = r8;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public final Rect onGetEpicenter(Transition r8) {
            Rect r10 = this.f1946a;
            if (r10 != null) goto L5;
            return null;
        L5:
            if (r10.isEmpty() == true) goto L10;
            return r10;
        L10:
            return null;
        }
    }

    public static boolean u(Transition r8) {
        if (f0.h(r8.getTargetIds()) == true) goto L5;
    L10:
        return true;
    L5:
        if (f0.h(r8.getTargetNames()) == false) goto L10;
        if (f0.h(r8.getTargetTypes()) == false) goto L10;
        return false;
    }

    @Override // androidx.fragment.app.f0
    public final void a(View r8, Object r10) {
        if (r10 == null) goto L5;
        ((Transition) r10).addTarget(r8);
        return;
    }

    @Override // androidx.fragment.app.f0
    public final void b(Object r8, ArrayList<View> r10) {
        Transition r11 = (Transition) r8;
        if (r11 != null) goto L5;
        return;
    L5:
        int r12 = 0;
        if ((r11 instanceof TransitionSet) == false) goto L11;
        TransitionSet r13 = (TransitionSet) r11;
        int r14 = r13.getTransitionCount();
    L8:
        if (r12 >= r14) goto L21;
        b(r13.getTransitionAt(r12), r10);
        r12 = r12 + 1;
        goto L8
    L21:
        return;
    L11:
        if (u(r11) == false) goto L13;
        return;
    L13:
        if (f0.h(r11.getTargets()) == false) goto L20;
        int r15 = r10.size();
    L15:
        if (r12 >= r15) goto L22;
        r11.addTarget(r10.get(r12));
        r12 = r12 + 1;
        goto L15
    L22:
        return;
    }

    @Override // androidx.fragment.app.f0
    public final void c(ViewGroup r8, Object r10) {
        TransitionManager.beginDelayedTransition(r8, (Transition) r10);
    }

    @Override // androidx.fragment.app.f0
    public final boolean e(Object r8) {
        return r8 instanceof Transition;
    }

    @Override // androidx.fragment.app.f0
    public final Object f(Object r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        return ((Transition) r8).clone();
    }

    @Override // androidx.fragment.app.f0
    public final Object i(Object r8, Object r10, Object r11) {
        Transition r12 = (Transition) r8;
        Transition r13 = (Transition) r10;
        Transition r14 = (Transition) r11;
        if (r12 == null) goto L6;
        if (r13 == null) goto L6;
        r12 = new TransitionSet().addTransition(r12).addTransition(r13).setOrdering(1);
    L11:
        if (r14 == null) goto L17;
        TransitionSet r15 = new TransitionSet();
        if (r12 == null) goto L15;
        r15.addTransition(r12);
    L15:
        r15.addTransition(r14);
        return r15;
    L17:
        return r12;
    L6:
        if (r12 != null) goto L11;
        if (r13 == null) goto L10;
        r12 = r13;
        goto L11
    L10:
        r12 = null;
        goto L11
    }

    @Override // androidx.fragment.app.f0
    public final Object j(Object r8, Object r10, Object r11) {
        TransitionSet r12 = new TransitionSet();
        if (r8 == null) goto L5;
        r12.addTransition((Transition) r8);
    L5:
        if (r10 == null) goto L7;
        r12.addTransition((Transition) r10);
    L7:
        if (r11 == null) goto L9;
        r12.addTransition((Transition) r11);
    L9:
        return r12;
    }

    @Override // androidx.fragment.app.f0
    public final void l(Object r8, View r10, ArrayList<View> r11) {
        ((Transition) r8).addListener(new a(r10, r11));
    }

    @Override // androidx.fragment.app.f0
    public final void m(Object r11, Object r12, ArrayList<View> r13, Object r14, ArrayList<View> r15, Object r16, ArrayList<View> r17) {
        ((Transition) r11).addListener(new b(this, r12, r13, r14, r15, r16, r17));
    }

    @Override // androidx.fragment.app.f0
    public final void n(View r8, Object r10) {
        if (r8 == null) goto L5;
        Rect r11 = new Rect();
        f0.g(r8, r11);
        ((Transition) r10).setEpicenterCallback(new b0(r11));
        return;
    }

    @Override // androidx.fragment.app.f0
    public final void o(Object r8, Rect r10) {
        if (r8 == null) goto L5;
        ((Transition) r8).setEpicenterCallback(new c(r10));
        return;
    }

    @Override // androidx.fragment.app.f0
    public final void p(Object r8, Runnable r10) {
        ((Transition) r8).addListener(new d0(r10));
    }

    @Override // androidx.fragment.app.f0
    public final void r(Object r8, View r10, ArrayList<View> r11) {
        TransitionSet r12 = (TransitionSet) r8;
        List<View> r13 = r12.getTargets();
        r13.clear();
        int r14 = r11.size();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L5;
        f0.d(r11.get(r15), r13);
        r15 = r15 + 1;
        goto L3
    L5:
        r13.add(r10);
        r11.add(r10);
        b(r12, r11);
    }

    @Override // androidx.fragment.app.f0
    public final void s(Object r8, ArrayList<View> r10, ArrayList<View> r11) {
        TransitionSet r12 = (TransitionSet) r8;
        if (r12 == null) goto L6;
        r12.getTargets().clear();
        r12.getTargets().addAll(r11);
        v(r12, r10, r11);
        return;
    }

    @Override // androidx.fragment.app.f0
    public final Object t(Object r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        TransitionSet r10 = new TransitionSet();
        r10.addTransition((Transition) r8);
        return r10;
    }

    public final void v(Object r8, ArrayList<View> r10, ArrayList<View> r11) {
        Transition r12 = (Transition) r8;
        int r13 = 0;
        if ((r12 instanceof TransitionSet) == false) goto L8;
        TransitionSet r14 = (TransitionSet) r12;
        int r15 = r14.getTransitionCount();
    L5:
        if (r13 >= r15) goto L31;
        v(r14.getTransitionAt(r13), r10, r11);
        r13 = r13 + 1;
        goto L5
    L31:
        return;
    L8:
        if (u(r12) == true) goto L23;
        List<View> r16 = r12.getTargets();
        if (r16 != null) goto L12;
        return;
    L12:
        if (r16.size() == r10.size()) goto L14;
        return;
    L14:
        if (r16.containsAll(r10) == false) goto L30;
        if (r11 != null) goto L17;
        int r17 = 0;
    L18:
        if (r13 >= r17) goto L20;
        r12.addTarget(r11.get(r13));
        r13 = r13 + 1;
        goto L18
    L20:
        int r18 = r10.size() - 1;
    L21:
        if (r18 < 0) goto L32;
        r12.removeTarget(r10.get(r18));
        r18 = r18 - 1;
        goto L21
    L32:
        return;
    L17:
        r17 = r11.size();
        goto L18
    L30:
        return;
    }
}
