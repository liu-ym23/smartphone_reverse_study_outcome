package u0;

import androidx.lifecycle.h0;
import androidx.lifecycle.i0;
import androidx.lifecycle.k0;
import androidx.lifecycle.m;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import java.io.PrintWriter;
import n.i;

/* JADX INFO: loaded from: classes.dex */
public final class b extends u0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f12416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0169b f12417b;

    public static class a<D> extends t<D> {
        @Override // androidx.lifecycle.LiveData
        public final void e() {
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        public final void f() {
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public final void h(u<? super D> r8) {
            super.h(r8);
        }

        @Override // androidx.lifecycle.t, androidx.lifecycle.LiveData
        public final void i(D r8) {
            super.i(r8);
        }

        public final String toString() {
            StringBuilder r8 = new StringBuilder(64);
            r8.append("LoaderInfo{");
            r8.append(Integer.toHexString(System.identityHashCode(this)));
            r8.append(" #0 : ");
            t2.b.k(null, r8);
            r8.append("}}");
            return r8.toString();
        }
    }

    /* JADX INFO: renamed from: u0.b$b, reason: collision with other inner class name */
    public static class C0169b extends h0 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f12418e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final i<a> f12419d;

        /* JADX INFO: renamed from: u0.b$b$a */
        public static class a implements i0.b {
            @Override // androidx.lifecycle.i0.b
            public final <T extends h0> T a(Class<T> r8) {
                return new C0169b();
            }
        }

        static {
            f12418e = new a();
        }

        public C0169b() {
            this.f12419d = new i();
        }

        @Override // androidx.lifecycle.h0
        public final void b() {
            i<a> r8 = this.f12419d;
            int r10 = r8.f9405m;
            if (r10 > 0) goto L9;
            Object[] r11 = r8.f9404b;
            int r12 = 0;
        L5:
            if (r12 >= r10) goto L7;
            r11[r12] = null;
            r12 = r12 + 1;
            goto L5
        L7:
            r8.f9405m = 0;
            return;
        L9:
            ((a) r8.f9404b[0]).getClass();
            throw null;
        }
    }

    public b(m r8, k0 r10) {
        this.f12416a = r8;
        this.f12417b = (C0169b) new i0(r10, C0169b.f12418e).a(C0169b.class);
    }

    @Deprecated
    public final void b(String r8, PrintWriter r10) {
        i<a> r11 = this.f12417b.f12419d;
        if (r11.f9405m <= 0) goto L9;
        r10.print(r8);
        r10.println("Loaders:");
        String r12 = r8 + "    ";
        if (r11.f9405m <= 0) goto L10;
        a r13 = (a) r11.f9404b[0];
        r10.print(r8);
        r10.print("  #");
        r10.print(r11.f9403a[0]);
        r10.print(": ");
        r10.println(r13.toString());
        r10.print(r12);
        r10.print("mId=");
        r10.print(0);
        r10.print(" mArgs=");
        r10.println(null);
        r10.print(r12);
        r10.print("mLoader=");
        r10.println(null);
        throw null;
    L10:
        return;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder(128);
        r8.append("LoaderManager{");
        r8.append(Integer.toHexString(System.identityHashCode(this)));
        r8.append(" in ");
        t2.b.k(this.f12416a, r8);
        r8.append("}}");
        return r8.toString();
    }
}
