package t6a;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.Animation;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public WeakReference<LynxUI> a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public Rect r;
    public ViewOnAttachStateChangeListenerC0111c s;
    public d t;
    public g u;
    public e v;
    public final SparseArray<f> w;
    public float x;
    public boolean y;

    public static class a implements Animation.AnimationListener {
        public final WeakReference<c> a;
        public final String b;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r22) {
            c r2 = this.a.get();
            if (r2 != null) goto L5;
            return;
        L5:
            LynxUI r3 = r2.h();
            if (r3 != null) goto L8;
            return;
        L8:
            View r4 = r3.getView();
            c.a(r2, this.b);
            String r5 = this.b;
            if (r5 == "layout-animation-create") goto L22;
            if (r5 == "layout-animation-update") goto L22;
            if (r5 == "layout-animation-delete") goto L16;
            return;
        L16:
            if ((r22 instanceof h) == true) goto L18;
        L20:
            r3.updateLayout(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, new Rect());
            return;
        L18:
            if (r2.y == false) goto L20;
            r4.setLayerType(0, null);
            r2.y = false;
        L22:
            if ((r22 instanceof f) == false) goto L25;
            r2.w.remove(r3.getSign());
            return;
        L25:
            if ((r22 instanceof h) == true) goto L27;
            return;
        L27:
            if (r2.y == false) goto L36;
            if (r4 == null) goto L30;
            r4.setLayerType(0, null);
        L30:
            r2.y = false;
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r9) {
            c r0 = this.a.get();
            if (r0 != null) goto L5;
            return;
        L5:
            LynxUI r1 = r0.h();
            if (r1 != null) goto L8;
            return;
        L8:
            View r2 = r1.getView();
            b.a(r1, "animationstart", this.b);
            String r3 = this.b;
            if (r3 == "layout-animation-create") goto L21;
            if (r3 == "layout-animation-update") goto L21;
            if (r3 == "layout-animation-delete") goto L16;
            return;
        L16:
            if ((r9 instanceof h) == true) goto L18;
            return;
        L18:
            if (r2.getLayerType() != 0) goto L31;
            r0.y = true;
            r2.setLayerType(2, null);
            return;
        L31:
            return;
        L21:
            if ((r9 instanceof f) == false) goto L24;
            r0.w.put(r1.getSign(), (f) r9);
            return;
        L24:
            if ((r9 instanceof h) == true) goto L26;
            return;
        L26:
            if (r2.getLayerType() != 0) goto L35;
            r0.y = true;
            r2.setLayerType(2, null);
            return;
        }

        public a(c r2, String r3) {
            this.a = new WeakReference(r2);
            this.b = r3;
        }
    }

    public static class b {
        public static final Map<String, Object> a = null;

        static {
            HashMap r0 = new HashMap();
            a = r0;
            r0.put("animation_type", NameKeys.UnloadStrategy_No_Strategy);
        }

        public static void a(LynxUI r3, String r4, String r5) {
            if (r3.getEvents() != null) goto L5;
            return;
        L5:
            if (r3.getEvents().containsKey(r4) == false) goto L9;
            Map<String, Object> r0 = a;
            ((HashMap) r0).put("animation_type", r5);
            r3.getLynxContext().getEventEmitter().sendCustomEvent(new com.lynx.tasm.event.a(r3.getSign(), r4, r0));
            return;
        }
    }

    /* JADX INFO: renamed from: t6a.c$c, reason: collision with other inner class name */
    public static class ViewOnAttachStateChangeListenerC0111c implements View.OnAttachStateChangeListener {
        public final WeakReference<c> a;
        public final String b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r1) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            c r3 = this.a.get();
            if (r3 == null) goto L6;
            c.a(r3, this.b);
            return;
        }

        public ViewOnAttachStateChangeListenerC0111c(c r2, String r3) {
            this.a = new WeakReference(r2);
            this.b = r3;
        }
    }

    public final void c() {
        WeakReference<LynxUI> r1 = this.a;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.get() == null) goto L9;
        this.a.get().updateLayout(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.n, this.o, this.p, this.q, this.j, this.k, this.l, this.m, this.r);
        return;
    }

    public final t6a.a e() {
        if (this.t != null) goto L6;
        this.t = new d();
    L6:
        return this.t;
    }

    public final t6a.a f() {
        if (this.v != null) goto L6;
        this.v = new e();
    L6:
        return this.v;
    }

    public final t6a.a g() {
        if (this.u != null) goto L6;
        this.u = new g();
    L6:
        return this.u;
    }

    public final LynxUI h() {
        WeakReference<LynxUI> r0 = this.a;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.get();
    }

    public c() {
        this.w = new SparseArray(0);
        this.x = -1.0f;
        this.y = false;
    }

    public final void d(String r2) {
        ViewOnAttachStateChangeListenerC0111c r0 = this.s;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.b.equals(r2) == false) goto L22;
        WeakReference<LynxUI> r3 = this.a;
        if (r3 != null) goto L10;
        return;
    L10:
        if (r3.get() == null) goto L19;
        View r4 = this.a.get().getView();
        if (r4 != null) goto L14;
        return;
    L14:
        if (r4.getAnimation() == null) goto L21;
        r4.clearAnimation();
        c();
        return;
    L21:
        return;
    L19:
        return;
    }

    public static void a(c r3, String r4) {
        LynxUI r0 = r3.h();
        if (r0 == null) goto L12;
        View r1 = r0.getView();
        ViewOnAttachStateChangeListenerC0111c r2 = r3.s;
        if (r2 == null) goto L10;
        if (r1 == null) goto L9;
        r1.removeOnAttachStateChangeListener(r2);
    L9:
        r3.s = null;
    L10:
        r3.c();
        b.a(r0, "animationend", r4);
        return;
    }

    public final void b(View r2, String r3) {
        if (h() != null) goto L5;
        return;
    L5:
        ViewOnAttachStateChangeListenerC0111c r0 = this.s;
        if (r0 != null) goto L8;
    L10:
        View.OnAttachStateChangeListener r1 = this.s;
        if (r1 == null) goto L13;
        r2.removeOnAttachStateChangeListener(r1);
    L13:
        ViewOnAttachStateChangeListenerC0111c r4 = new ViewOnAttachStateChangeListenerC0111c(this, r3);
        this.s = r4;
        r2.addOnAttachStateChangeListener(r4);
        return;
    L8:
        if (r0.b.equals(r3) == false) goto L10;
    }

    public final void i(int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, Rect r19) {
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.n = r11;
        this.o = r12;
        this.p = r13;
        this.q = r14;
        this.j = r15;
        this.k = r16;
        this.l = r17;
        this.m = r18;
        this.r = r19;
    }
}
