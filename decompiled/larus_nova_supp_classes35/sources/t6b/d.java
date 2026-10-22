package t6b;

import com.ss.android.lark.biz.im.api.b1;
import com.ss.android.lark.biz.im.api.f0;
import com.ss.android.lark.biz.im.api.u0;
import com.ss.android.lark.biz.im.api.v0;
import com.ss.android.lark.biz.im.api.z0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends c {
    public final z0 j;
    public final int k;
    public final List<b1> l;
    public final f0 m;
    public final List<u0> n;
    public final Class<?> o;
    public final Boolean p;
    public final y6b.e<y6b.c<?>> q;
    public boolean r;

    @Override // t6b.c
    public final v0 e() {
        return null;
    }

    @Override // t6b.c
    public final jya.b i() {
        return null;
    }

    @Override // t6b.c
    public final boolean c() {
        return this.r;
    }

    @Override // t6b.c
    public final List<u0> d() {
        return this.n;
    }

    @Override // t6b.c
    public final z0 f() {
        return this.j;
    }

    @Override // t6b.c
    public final List<b1> g() {
        return this.l;
    }

    @Override // t6b.c
    public final f0 h() {
        return this.m;
    }

    @Override // t6b.c
    public final int j() {
        return this.k;
    }

    @Override // t6b.c
    public final y6b.e<y6b.c<?>> k() {
        return this.q;
    }

    @Override // t6b.c
    public final Boolean l() {
        return this.p;
    }

    @Override // t6b.c
    public final Class<?> m() {
        return this.o;
    }

    public d(c r10) {
        Intrinsics.checkNotNullParameter(r10, "base");
        super(null, 0, null, null, null, null, 2047);
        this.j = r10.f();
        this.k = r10.j();
        this.l = CollectionsKt.toMutableList(r10.g());
        this.m = r10.h();
        this.n = CollectionsKt.toMutableList(r10.d());
        r10.e();
        this.o = r10.m();
        this.p = r10.l();
        this.q = r10.k();
        this.r = r10.c();
        r10.i();
    }
}
