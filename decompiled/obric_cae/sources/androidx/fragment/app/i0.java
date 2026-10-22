package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.obric.cae.R;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f1973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<d> f1974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<d> f1975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1977e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f1978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i0 f1979b;

        public a(i0 r8, c r10) {
            this.f1979b = r8;
            this.f1978a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrayList<d> r8 = this.f1979b.f1974b;
            c r10 = this.f1978a;
            if (r8.contains(r10) == false) goto L6;
            r10.f1983a.a(r10.f1985c.mView);
            return;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f1980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i0 f1981b;

        public b(i0 r8, c r10) {
            this.f1981b = r8;
            this.f1980a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i0 r8 = this.f1981b;
            ArrayList<d> r10 = r8.f1974b;
            c r11 = this.f1980a;
            r10.remove(r11);
            r8.f1975c.remove(r11);
        }
    }

    public static class c extends d {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final x f1982h;

        public c(d.c r8, d.b r10, x r11, f0.d r12) {
            super(r8, r10, r11.f2060c, r12);
            this.f1982h = r11;
        }

        @Override // androidx.fragment.app.i0.d
        public final void b() {
            super.b();
            this.f1982h.k();
        }

        @Override // androidx.fragment.app.i0.d
        public final void d() {
            if (this.f1984b != d.b.f1992b) goto L19;
            x r8 = this.f1982h;
            Fragment r10 = r8.f2060c;
            View r11 = r10.mView.findFocus();
            if (r11 == null) goto L9;
            r10.setFocusedView(r11);
            if (FragmentManager.G(2) == false) goto L9;
            Log.v("FragmentManager", "requestFocus: Saved focused view " + r11 + " for Fragment " + r10);
        L9:
            View r12 = this.f1985c.requireView();
            if (r12.getParent() != null) goto L13;
            r8.b();
            r12.setAlpha(0.0f);
        L13:
            if (r12.getAlpha() == 0.0f) goto L15;
        L17:
            r12.setAlpha(r10.getPostOnViewCreatedAlpha());
            return;
        L15:
            if (r12.getVisibility() != 0) goto L17;
            r12.setVisibility(4);
            goto L17
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f1983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f1984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Fragment f1985c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ArrayList f1986d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final HashSet<f0.d> f1987e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f1988f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f1989g;

        public class a implements f0.d.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f1990a;

            public a(c r8) {
                this.f1990a = r8;
            }

            @Override // f0.d.a
            public final void onCancel() {
                this.f1990a.a();
            }
        }

        public static final enum b extends Enum<b> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f1991a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final b f1992b = null;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public static final b f1993m = null;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public static final /* synthetic */ b[] f1994n = null;

            static {
                b r8 = new b(BdimCategoryConstants.VALUE_NONE, 0);
                f1991a = r8;
                b r10 = new b("ADDING", 1);
                f1992b = r10;
                b r11 = new b("REMOVING", 2);
                f1993m = r11;
                f1994n = new b[]{r8, r10, r11};
            }

            public b(String r8, int r10) {
                super(r8, r10);
            }

            public static b valueOf(String r8) {
                return (b) Enum.valueOf(b.class, r8);
            }

            public static b[] values() {
                return (b[]) f1994n.clone();
            }
        }

        public static final enum c extends Enum<c> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f1995a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final c f1996b = null;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public static final c f1997m = null;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public static final c f1998n = null;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public static final /* synthetic */ c[] f1999o = null;

            static {
                c r8 = new c("REMOVED", 0);
                f1995a = r8;
                c r10 = new c("VISIBLE", 1);
                f1996b = r10;
                c r11 = new c("GONE", 2);
                f1997m = r11;
                c r12 = new c("INVISIBLE", 3);
                f1998n = r12;
                f1999o = new c[]{r8, r10, r11, r12};
            }

            public c(String r8, int r10) {
                super(r8, r10);
            }

            public static c b(int r8) {
                if (r8 == 0) goto L14;
                if (r8 == 4) goto L12;
                if (r8 != 8) goto L10;
                return f1997m;
            L10:
                throw new IllegalArgumentException(defpackage.a.d("Unknown visibility ", r8));
            L12:
                return f1998n;
            L14:
                return f1996b;
            }

            public static c c(View r8) {
                if (r8.getAlpha() != 0.0f) goto L9;
                if (r8.getVisibility() != 0) goto L9;
                return f1998n;
            L9:
                return b(r8.getVisibility());
            }

            public static c valueOf(String r8) {
                return (c) Enum.valueOf(c.class, r8);
            }

            public static c[] values() {
                return (c[]) f1999o.clone();
            }

            public final void a(View r8) {
                int r10 = ordinal();
                if (r10 != 0) goto L5;
                ViewGroup r11 = (ViewGroup) r8.getParent();
                if (r11 != null) goto L26;
                return;
            L26:
                if (FragmentManager.G(2) == false) goto L28;
                Log.v("FragmentManager", "SpecialEffectsController: Removing view " + r8 + " from container " + r11);
            L28:
                r11.removeView(r8);
                return;
            L5:
                if (r10 == 1) goto L19;
                if (r10 == 2) goto L15;
                if (r10 == 3) goto L11;
                return;
            L11:
                if (FragmentManager.G(2) == false) goto L13;
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + r8 + " to INVISIBLE");
            L13:
                int r12 = 4;
            L22:
                r8.setVisibility(r12);
                return;
            L15:
                if (FragmentManager.G(2) == false) goto L17;
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + r8 + " to GONE");
            L17:
                r12 = 8;
                goto L22
            L19:
                if (FragmentManager.G(2) == false) goto L21;
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + r8 + " to VISIBLE");
            L21:
                r12 = 0;
                goto L22
            }
        }

        public d(c r8, b r10, Fragment r11, f0.d r12) {
            this.f1986d = new ArrayList();
            this.f1987e = new HashSet();
            this.f1988f = false;
            this.f1989g = false;
            this.f1983a = r8;
            this.f1984b = r10;
            this.f1985c = r11;
            r12.b(new a((c) this));
        }

        public final void a() {
            if (this.f1988f == false) goto L5;
            return;
        L5:
            this.f1988f = true;
            HashSet<f0.d> r8 = this.f1987e;
            if (r8.isEmpty() == false) goto L8;
            b();
            return;
        L8:
            Iterator r10 = new ArrayList(r8).iterator();
        L10:
            if (r10.hasNext() == false) goto L14;
            ((f0.d) r10.next()).a();
            goto L10
        }

        public void b() {
            if (this.f1989g == false) goto L6;
            return;
        L6:
            if (FragmentManager.G(2) == false) goto L8;
            Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
        L8:
            this.f1989g = true;
            Iterator r8 = this.f1986d.iterator();
        L10:
            if (r8.hasNext() == false) goto L12;
            ((Runnable) r8.next()).run();
            goto L10
        }

        public final void c(c r8, b r10) {
            int r11 = r10.ordinal();
            Fragment r12 = this.f1985c;
            if (r11 == 0) goto L20;
            if (r11 == 1) goto L13;
            if (r11 == 2) goto L9;
            return;
        L9:
            if (FragmentManager.G(2) == false) goto L11;
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + r12 + " mFinalState = " + this.f1983a + " -> REMOVED. mLifecycleImpact  = " + this.f1984b + " to REMOVING.");
        L11:
            this.f1983a = c.f1995a;
            b r13 = b.f1993m;
        L18:
            this.f1984b = r13;
            return;
        L13:
            if (this.f1983a == c.f1995a) goto L15;
            return;
        L15:
            if (FragmentManager.G(2) == false) goto L17;
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + r12 + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f1984b + " to ADDING.");
        L17:
            this.f1983a = c.f1996b;
            r13 = b.f1992b;
            goto L18
        L20:
            if (this.f1983a != c.f1995a) goto L22;
            return;
        L22:
            if (FragmentManager.G(2) == false) goto L24;
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + r12 + " mFinalState = " + this.f1983a + " -> " + r8 + ". ");
        L24:
            this.f1983a = r8;
        }

        public void d() {
        }

        public final String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f1983a + "} {mLifecycleImpact = " + this.f1984b + "} {mFragment = " + this.f1985c + "}";
        }
    }

    public i0(ViewGroup r8) {
        this.f1974b = new ArrayList();
        this.f1975c = new ArrayList();
        this.f1976d = false;
        this.f1977e = false;
        this.f1973a = r8;
    }

    public static i0 f(ViewGroup r8, FragmentManager r10) {
        return g(r8, r10.E());
    }

    public static i0 g(ViewGroup r8, j0 r10) {
        Object r11 = r8.getTag(R.id.special_effects_controller_view_tag);
        if ((r11 instanceof i0) == true) goto L5;
        ((FragmentManager.f) r10).getClass();
        k r12 = new k(r8);
        r8.setTag(R.id.special_effects_controller_view_tag, r12);
        return r12;
    L5:
        return (i0) r11;
    }

    public final void a(d.c r8, d.b r10, x r11) {
        ArrayList<d> r12 = this.f1974b;
        monitor-enter(r12);
        f0.d r13 = new f0.d();     // Catch: Throwable -> L12
        d r14 = d(r11.f2060c);     // Catch: Throwable -> L12
        if (r14 == null) goto L9;
        r14.c(r8, r10);     // Catch: Throwable -> L12
        monitor-exit(r12);     // Catch: Throwable -> L12
        return;
    L9:
        c r15 = new c(r8, r10, r11, r13);     // Catch: Throwable -> L12
        this.f1974b.add(r15);     // Catch: Throwable -> L12
        a r16 = new a(this, r15);     // Catch: Throwable -> L12
        r15.f1986d.add(r16);     // Catch: Throwable -> L12
        b r17 = new b(this, r15);     // Catch: Throwable -> L12
        r15.f1986d.add(r17);     // Catch: Throwable -> L12
        monitor-exit(r12);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public abstract void b(ArrayList r8, boolean r10);

    public final void c() {
        if (this.f1977e == false) goto L5;
        return;
    L5:
        ViewGroup r8 = this.f1973a;
        WeakHashMap<View, j0.h0> r10 = j0.w.f8437a;
        if (j0.w.g.b(r8) == true) goto L9;
        e();
        this.f1976d = false;
        return;
    L9:
        ArrayList<d> r11 = this.f1974b;
        monitor-enter(r11);
    L29:
        th = move-exception;
        throw th;
    L12:
        if (this.f1974b.isEmpty() == true) goto L27;
        ArrayList r12 = new ArrayList(this.f1975c);     // Catch: Throwable -> L29
        this.f1975c.clear();     // Catch: Throwable -> L29
        Iterator r13 = r12.iterator();     // Catch: Throwable -> L29
    L15:
        if (r13.hasNext() == false) goto L22;
        d r14 = (d) r13.next();     // Catch: Throwable -> L29
        if (FragmentManager.G(2) == false) goto L19;
        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + r14);     // Catch: Throwable -> L29
    L19:
        r14.a();     // Catch: Throwable -> L29
        if (r14.f1989g == true) goto L15;
        this.f1975c.add(r14);     // Catch: Throwable -> L29
        goto L15
    L22:
        i();     // Catch: Throwable -> L29
        ArrayList r15 = new ArrayList(this.f1974b);     // Catch: Throwable -> L29
        this.f1974b.clear();     // Catch: Throwable -> L29
        this.f1975c.addAll(r15);     // Catch: Throwable -> L29
        Iterator r16 = r15.iterator();     // Catch: Throwable -> L29
    L24:
        if (r16.hasNext() == false) goto L26;
        ((d) r16.next()).d();     // Catch: Throwable -> L29
        goto L24
    L26:
        b(r15, this.f1976d);     // Catch: Throwable -> L29
        this.f1976d = false;     // Catch: Throwable -> L29
    L27:
        monitor-exit(r11);     // Catch: Throwable -> L29
    }

    public final d d(Fragment r8) {
        Iterator<d> r10 = this.f1974b.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        d r11 = r10.next();
        if (r11.f1985c.equals(r8) == false) goto L4;
        if (r11.f1988f == true) goto L4;
        return r11;
    L10:
        return null;
    }

    public final void e() {
        ViewGroup r8 = this.f1973a;
        WeakHashMap<View, j0.h0> r10 = j0.w.f8437a;
        boolean r11 = j0.w.g.b(r8);
        ArrayList<d> r12 = this.f1974b;
        monitor-enter(r12);
        i();     // Catch: Throwable -> L32
        Iterator<d> r13 = this.f1974b.iterator();     // Catch: Throwable -> L32
    L6:
        if (r13.hasNext() == false) goto L8;
        r13.next().d();     // Catch: Throwable -> L32
        goto L6
    L8:
        Iterator r14 = new ArrayList(this.f1975c).iterator();     // Catch: Throwable -> L32
    L10:
        if (r14.hasNext() == false) goto L19;
        d r15 = (d) r14.next();     // Catch: Throwable -> L32
        if (FragmentManager.G(2) == false) goto L18;
        StringBuilder r16 = new StringBuilder();     // Catch: Throwable -> L32
        r16.append("SpecialEffectsController: ");     // Catch: Throwable -> L32
        if (r11 == false) goto L16;
        String r17 = "";
    L17:
        r16.append(r17);     // Catch: Throwable -> L32
        r16.append("Cancelling running operation ");     // Catch: Throwable -> L32
        r16.append(r15);     // Catch: Throwable -> L32
        Log.v("FragmentManager", r16.toString());     // Catch: Throwable -> L32
        goto L18
    L16:
        r17 = "Container " + this.f1973a + " is not attached to window. ";     // Catch: Throwable -> L32
    L18:
        r15.a();     // Catch: Throwable -> L32
        goto L10
    L19:
        Iterator r18 = new ArrayList(this.f1974b).iterator();     // Catch: Throwable -> L32
    L21:
        if (r18.hasNext() == false) goto L30;
        d r19 = (d) r18.next();     // Catch: Throwable -> L32
        if (FragmentManager.G(2) == false) goto L29;
        StringBuilder r20 = new StringBuilder();     // Catch: Throwable -> L32
        r20.append("SpecialEffectsController: ");     // Catch: Throwable -> L32
        if (r11 == false) goto L27;
        String r21 = "";
    L28:
        r20.append(r21);     // Catch: Throwable -> L32
        r20.append("Cancelling pending operation ");     // Catch: Throwable -> L32
        r20.append(r19);     // Catch: Throwable -> L32
        Log.v("FragmentManager", r20.toString());     // Catch: Throwable -> L32
        goto L29
    L27:
        r21 = "Container " + this.f1973a + " is not attached to window. ";     // Catch: Throwable -> L32
    L29:
        r19.a();     // Catch: Throwable -> L32
        goto L21
    L30:
        monitor-exit(r12);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        throw th;
    }

    public final void h() {
        ArrayList<d> r8 = this.f1974b;
        monitor-enter(r8);
        i();     // Catch: Throwable -> L13
        this.f1977e = false;     // Catch: Throwable -> L13
        int r10 = this.f1974b.size() - 1;     // Catch: Throwable -> L13
    L5:
        if (r10 < 0) goto L11;
        d r11 = this.f1974b.get(r10);     // Catch: Throwable -> L13
        d.c r12 = d.c.c(r11.f1985c.mView);     // Catch: Throwable -> L13
        d.c r13 = r11.f1983a;     // Catch: Throwable -> L13
        d.c r14 = d.c.f1996b;     // Catch: Throwable -> L13
        if (r13 != r14) goto L10;
        if (r12 == r14) goto L10;
        this.f1977e = r11.f1985c.isPostponed();     // Catch: Throwable -> L13
    L10:
        r10 = r10 - 1;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r8);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void i() {
        Iterator<d> r8 = this.f1974b.iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        d r10 = r8.next();
        if (r10.f1984b != d.b.f1992b) goto L4;
        r10.c(d.c.b(r10.f1985c.requireView().getVisibility()), d.b.f1991a);
        goto L4
    }
}
