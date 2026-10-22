package androidx.lifecycle;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c0 implements androidx.savedstate.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.savedstate.a f2137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f2139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final xd.f f2140d;

    public static final class a extends he.j implements ge.a<d0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l0 f2141a;

        public a(l0 r8) {
            this.f2141a = r8;
            super(0);
        }

        @Override // ge.a
        public final d0 f() {
            return b0.c(this.f2141a);
        }
    }

    public c0(androidx.savedstate.a r8, l0 r10) {
        he.i.f(r8, "savedStateRegistry");
        he.i.f(r10, "viewModelStoreOwner");
        this.f2137a = r8;
        this.f2140d = defpackage.c.R(new a(r10));
    }

    @Override // androidx.savedstate.a.b
    public final Bundle a() {
        Bundle r8 = new Bundle();
        Bundle r10 = this.f2139c;
        if (r10 == null) goto L5;
        r8.putAll(r10);
    L5:
        Iterator r11 = ((d0) this.f2140d.getValue()).f2142d.entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        Map.Entry r12 = (Map.Entry) r11.next();
        String r13 = (String) r12.getKey();
        Bundle r14 = ((a0) r12.getValue()).f2125e.a();
        if (he.i.a(r14, Bundle.EMPTY) == true) goto L7;
        r8.putBundle(r13, r14);
        goto L7
    L11:
        this.f2138b = false;
        return r8;
    }
}
