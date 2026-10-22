package bz0;

import android.view.View;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import com.bytedance.android.live.revenue.platform.hybrid.impl.util.CompositeListenerUpTo6Args;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j extends a {
    public final CompositeListenerUpTo6Args<Unit, Function2<Integer, String, Unit>> A;
    public final CompositeListenerUpTo6Args<Unit, Function1<View, Unit>> B;
    public final CompositeListenerUpTo6Args<Unit, Function3<View, String, String, Unit>> C;
    public final CompositeListenerUpTo6Args<Boolean, Function2<Integer, String, Boolean>> D;
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> E;
    public final CompositeListenerUpTo6Args<Unit, Function4<String, AnnieResType, HybridType, Map<String, Object>, Unit>> F;
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> a;
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> b;
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> c;
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> d;
    public final CompositeListenerUpTo6Args<Unit, Function3<String, String, Boolean, Unit>> e;
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> f;
    public final CompositeListenerUpTo6Args<Unit, Function1<View, Unit>> g;
    public final CompositeListenerUpTo6Args<Unit, Function2<View, Set<String>, Unit>> h;
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> i;
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> j;
    public final CompositeListenerUpTo6Args<Unit, Function1<Boolean, Unit>> k;
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> l;
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> m;
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> n;
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> o;
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> p;
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> q;
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> r;
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> s;
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> t;
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> u;
    public final CompositeListenerUpTo6Args<Unit, Function3<View, HybridType, String, Unit>> v;
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> w;
    public final CompositeListenerUpTo6Args<Unit, Function2<Boolean, String, Unit>> x;
    public final CompositeListenerUpTo6Args<Unit, Function3<View, Integer, String, Unit>> y;
    public final CompositeListenerUpTo6Args<Unit, Function2<View, Boolean, Unit>> z;

    public j() {
        this.a = new CompositeListenerUpTo6Args();
        this.b = new CompositeListenerUpTo6Args();
        this.c = new CompositeListenerUpTo6Args();
        this.d = new CompositeListenerUpTo6Args();
        this.e = new CompositeListenerUpTo6Args();
        this.f = new CompositeListenerUpTo6Args();
        this.g = new CompositeListenerUpTo6Args();
        this.h = new CompositeListenerUpTo6Args();
        this.i = new CompositeListenerUpTo6Args();
        this.j = new CompositeListenerUpTo6Args();
        this.k = new CompositeListenerUpTo6Args();
        this.l = new CompositeListenerUpTo6Args();
        this.m = new CompositeListenerUpTo6Args();
        this.n = new CompositeListenerUpTo6Args();
        this.o = new CompositeListenerUpTo6Args();
        this.p = new CompositeListenerUpTo6Args();
        this.q = new CompositeListenerUpTo6Args();
        this.r = new CompositeListenerUpTo6Args();
        this.s = new CompositeListenerUpTo6Args();
        this.t = new CompositeListenerUpTo6Args();
        this.u = new CompositeListenerUpTo6Args();
        this.v = new CompositeListenerUpTo6Args();
        this.w = new CompositeListenerUpTo6Args();
        this.x = new CompositeListenerUpTo6Args();
        this.y = new CompositeListenerUpTo6Args();
        this.z = new CompositeListenerUpTo6Args();
        this.A = new CompositeListenerUpTo6Args();
        this.B = new CompositeListenerUpTo6Args();
        this.C = new CompositeListenerUpTo6Args();
        this.D = new CompositeListenerUpTo6Args();
        this.E = new CompositeListenerUpTo6Args();
        this.F = new CompositeListenerUpTo6Args();
    }

    @Override // yy0.g
    public final void d(Function3<? super View, ? super Integer, ? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.y.a(r2);
    }

    @Override // yy0.g
    public final void e(Function2<? super Integer, ? super String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.D.a(r2);
    }

    @Override // yy0.g
    public final void g(Function2<? super Integer, ? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.A.a(r2);
    }

    @Override // yy0.g
    public final void h(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.j.a(r2);
    }
}
