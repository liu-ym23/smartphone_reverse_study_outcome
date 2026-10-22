package t6b;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.biz.im.api.FirstMessagePaddingType;
import com.ss.android.lark.biz.im.api.a1;
import com.ss.android.lark.biz.im.api.d0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l extends k {
    public final FirstMessagePaddingType A;
    public final a1 B;
    public final v4b.d C;
    public final v4b.c D;
    public final Map<Class<? extends com.ss.android.lark.biz.im.api.message.params.l>, com.ss.android.lark.biz.im.api.message.params.l> E;
    public o3b.a F;
    public final Boolean G;
    public final y6b.e<y6b.c<?>> H;
    public d0 I;
    public Map<Class<? extends mya.g>, List<mya.g>> J;
    public final boolean s;
    public boolean t;
    public v4b.e u;
    public final long v;
    public final Map<com.ss.android.lark.blueprint.j, wza.b<y6b.a<?>, Object>> w;
    public final List<RecyclerView.ItemDecoration> x;
    public Function1<? super y6b.c<?>, Unit> y;
    public final Function1<? super y6b.c<?>, Boolean> z;

    @Override // t6b.k
    public final void r() {
    }

    @Override // t6b.k
    public final Map<com.ss.android.lark.blueprint.j, wza.b<y6b.a<?>, Object>> c() {
        return this.w;
    }

    @Override // t6b.k
    public final boolean d() {
        return this.t;
    }

    @Override // t6b.k
    public final boolean e() {
        return this.s;
    }

    @Override // t6b.k
    public final FirstMessagePaddingType f() {
        return this.A;
    }

    @Override // t6b.k
    public final List<RecyclerView.ItemDecoration> g() {
        return this.x;
    }

    @Override // t6b.k
    public final Map<Class<? extends mya.g>, List<mya.g>> h() {
        return this.J;
    }

    @Override // t6b.k
    public final v4b.c i() {
        return this.D;
    }

    @Override // t6b.k
    public final v4b.d j() {
        return this.C;
    }

    @Override // t6b.k
    public final Map<Class<? extends com.ss.android.lark.biz.im.api.message.params.l>, com.ss.android.lark.biz.im.api.message.params.l> k() {
        return this.E;
    }

    @Override // t6b.k
    public final o3b.a l() {
        return this.F;
    }

    @Override // t6b.k
    public final a1 m() {
        return this.B;
    }

    @Override // t6b.k
    public final long n() {
        return this.v;
    }

    @Override // t6b.k
    public final Function1<y6b.c<?>, Unit> o() {
        return this.y;
    }

    @Override // t6b.k
    public final Function1<y6b.c<?>, Boolean> p() {
        return this.z;
    }

    @Override // t6b.k
    public final y6b.e<y6b.c<?>> q() {
        return this.H;
    }

    @Override // t6b.k
    public final Boolean s() {
        return this.G;
    }

    @Override // t6b.k
    public final v4b.e t() {
        return this.u;
    }

    @Override // t6b.k
    public final d0 u() {
        return this.I;
    }

    public l(k r21) {
        Intrinsics.checkNotNullParameter(r21, "base");
        super(false, false, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287);
        this.s = r21.e();
        this.t = r21.d();
        this.u = r21.t();
        this.v = r21.n();
        this.w = MapsKt.toMutableMap(r21.c());
        this.x = CollectionsKt.toMutableList(r21.g());
        this.y = r21.o();
        this.z = r21.p();
        this.A = r21.f();
        r21.r();
        this.B = r21.m();
        this.C = r21.j();
        this.D = r21.i();
        this.E = MapsKt.toMutableMap(r21.k());
        this.F = r21.l();
        this.G = r21.s();
        this.H = r21.q();
        this.I = r21.u();
        Map<Class<? extends mya.g>, List<mya.g>> r0 = r21.h();
        if (r0 == null) goto L5;
        Map<Class<? extends mya.g>, List<mya.g>> r1 = MapsKt.toMutableMap(r0);
    L6:
        this.J = r1;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void v(Class<? extends mya.g> r3, mya.g r4) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        Intrinsics.checkNotNullParameter(r4, "handler");
        if (this.J != null) goto L5;
        this.J = new LinkedHashMap();
    L5:
        Map<Class<? extends mya.g>, List<mya.g>> r0 = this.J;
        if (r0 == null) goto L12;
        List<mya.g> r1 = r0.get(r3);
        if (r1 != null) goto L10;
        r1 = new ArrayList();
        r0.put(r3, r1);
    L10:
        r1.add(r4);
        return;
    }

    public final void w(Class<? extends com.ss.android.lark.biz.im.api.message.params.l> r2, com.ss.android.lark.biz.im.api.message.params.l r3) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r3, "param");
        this.E.put(r2, r3);
    }
}
