package ld;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.List;
import kc0.u;
import kotlin.Pair;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements o, a {
    public final NextLiveData<gt1.b> A;
    public final NextLiveData<Boolean> B;
    public final NextLiveData<gt1.d> C;
    public final NextLiveData<Boolean> D;
    public final NextLiveData<Boolean> E;
    public final NextLiveData<Boolean> F;
    public final NextLiveData<Unit> G;
    public final NextLiveData<String> H;
    public final NextLiveData<oq2.e> H0;
    public final NextLiveData<Long> I;
    public final NextLiveData<Integer> J;
    public final NextLiveData<Integer> K;
    public final NextLiveData<Long> L;
    public final NextLiveData<oq2.b> L0;
    public final NextLiveData<oq2.a> M;
    public final NextLiveData<Long> N;
    public final NextLiveData<Long> O;
    public final NextLiveData<Integer> P;
    public final NextLiveData<Boolean> P0;
    public final NextLiveData<Integer> Q;
    public final NextLiveData<LiveMode> R;
    public final NextLiveData<Boolean> S;
    public final NextLiveData<Pair<Integer, Integer>> T;
    public final NextLiveData<Integer> U;
    public final NextLiveData<Unit> V;
    public final NextLiveData<String> V0;
    public final NextLiveData<String> W;
    public final NextLiveData<Integer> X;
    public final NextLiveData<g> Y;
    public final NextLiveData<Integer> Z;
    public final NextLiveData<Boolean> a;
    public final NextLiveData<Integer> b;
    public final NextLiveData<Integer> b1;
    public final NextLiveData<Long> c;
    public final NextLiveData<Unit> d;
    public final NextLiveData<Boolean> e;
    public final NextLiveData<zg1.d> f;
    public final NextLiveData<Unit> g;
    public final NextLiveData<u> g1;
    public final NextLiveData<Integer> h;
    public final NextLiveData<Boolean> h1;
    public final NextLiveData<Boolean> i;
    public final NextLiveData<Boolean> j;
    public final NextLiveData<Boolean> k;
    public final NextLiveData<Integer> k0;
    public final NextLiveData<Unit> k1;
    public final NextLiveData<String> l;
    public final NextLiveData<Integer> m;
    public final NextLiveData<g90.a> n;
    public final NextLiveData<Integer> o;
    public final NextLiveData<Boolean> p;
    public final NextLiveData<Boolean> p0;
    public final NextLiveData<List<com.bytedance.android.livesdk.link.model.e>> p1;
    public final NextLiveData<Long> q;
    public final NextLiveData<Boolean> r;
    public final NextLiveData<IRoom> s;
    public final NextLiveData<Integer> t;
    public final NextLiveData<Boolean> u;
    public final NextLiveData<Boolean> v;
    public final NextLiveData<List<m11.b>> v1;
    public final NextLiveData<Boolean> w;
    public final NextLiveData<Boolean> x;
    public final NextLiveData<List<com.bytedance.android.livesdk.link.model.e>> x1;
    public final NextLiveData<Integer> y;
    public final NextLiveData<Boolean> y1;
    public final NextLiveData<Boolean> z;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public e() {
        this.a = new NextLiveData();
        NextLiveData<Integer> r0 = new NextLiveData();
        r0.setValue(0);
        Unit r10 = Unit.INSTANCE;
        this.b = r0;
        this.c = new NextLiveData();
        this.d = new NextLiveData();
        this.e = new NextLiveData();
        this.f = new NextLiveData();
        this.g = new NextLiveData();
        this.h = new NextLiveData();
        this.i = new NextLiveData();
        this.j = new NextLiveData();
        this.k = new NextLiveData();
        NextLiveData<String> r1 = new NextLiveData();
        r1.setValue("");
        this.l = r1;
        this.m = new NextLiveData();
        this.n = new NextLiveData();
        this.o = new NextLiveData();
        new NextLiveData();
        this.p = new NextLiveData();
        this.q = new NextLiveData();
        this.r = new NextLiveData();
        this.s = new NextLiveData();
        NextLiveData<Integer> r11 = new NextLiveData();
        r11.setValue(0);
        this.t = r11;
        NextLiveData<Boolean> r12 = new NextLiveData();
        Boolean r13 = Boolean.FALSE;
        r12.setValue(r13);
        this.u = r12;
        this.v = new NextLiveData();
        NextLiveData<Boolean> r14 = new NextLiveData();
        r14.setValue(r13);
        this.w = r14;
        this.x = new NextLiveData();
        NextLiveData<Integer> r15 = new NextLiveData();
        r15.setValue(0);
        this.y = r15;
        NextLiveData<Boolean> r16 = new NextLiveData();
        r16.setValue(r13);
        this.z = r16;
        this.A = new NextLiveData();
        NextLiveData<Boolean> r17 = new NextLiveData();
        r17.setValue(r13);
        this.B = r17;
        this.C = new NextLiveData();
        NextLiveData<Boolean> r18 = new NextLiveData();
        r18.setValue(r13);
        this.D = r18;
        NextLiveData<Boolean> r19 = new NextLiveData();
        r19.setValue(r13);
        this.E = r19;
        NextLiveData<Boolean> r20 = new NextLiveData();
        r20.setValue(r13);
        this.F = r20;
        NextLiveData<Unit> r21 = new NextLiveData();
        r21.setValue(Unit.INSTANCE);
        this.G = r21;
        NextLiveData<String> r22 = new NextLiveData();
        r22.setValue("");
        this.H = r22;
        this.I = new NextLiveData();
        this.J = new NextLiveData();
        this.K = new NextLiveData();
        NextLiveData<Long> r23 = new NextLiveData();
        r23.setValue(0L);
        this.L = r23;
        this.M = new NextLiveData();
        new NextLiveData();
        NextLiveData<Long> r24 = new NextLiveData();
        r24.setValue(0L);
        this.N = r24;
        NextLiveData<Long> r25 = new NextLiveData();
        r25.setValue(0L);
        this.O = r25;
        this.P = new NextLiveData();
        NextLiveData<Integer> r26 = new NextLiveData();
        r26.setValue(0);
        this.Q = r26;
        NextLiveData<LiveMode> r27 = new NextLiveData();
        r27.setValue(LiveMode.VIDEO);
        this.R = r27;
        NextLiveData<Boolean> r28 = new NextLiveData();
        Boolean r29 = Boolean.TRUE;
        r28.setValue(r29);
        this.S = r28;
        NextLiveData<Pair<Integer, Integer>> r30 = new NextLiveData();
        r30.setValue(new Pair(0, 0));
        this.T = r30;
        this.U = new NextLiveData();
        this.V = new NextLiveData();
        this.W = new NextLiveData();
        this.X = new NextLiveData();
        NextLiveData<g> r31 = new NextLiveData();
        r31.setValue(new g());
        this.Y = r31;
        this.Z = new NextLiveData();
        NextLiveData<Integer> r32 = new NextLiveData();
        r32.setValue(0);
        this.k0 = r32;
        NextLiveData<Boolean> r33 = new NextLiveData();
        r33.setValue(r13);
        this.p0 = r33;
        this.H0 = new NextLiveData();
        this.L0 = new NextLiveData();
        this.P0 = new NextLiveData();
        this.V0 = new NextLiveData();
        this.b1 = new NextLiveData();
        this.g1 = new NextLiveData();
        NextLiveData<Boolean> r34 = new NextLiveData();
        r34.setValue(r29);
        this.h1 = r34;
        this.k1 = new NextLiveData();
        this.p1 = new NextLiveData();
        this.v1 = new NextLiveData();
        this.x1 = new NextLiveData();
        NextLiveData<Boolean> r35 = new NextLiveData();
        r35.setValue(r13);
        this.y1 = r35;
    }

    @Override // ld.a
    public final NextLiveData<String> A4() {
        return this.l;
    }

    @Override // ld.a
    public final NextLiveData<Boolean> A6() {
        return this.P0;
    }

    @Override // ld.a
    public final NextLiveData<Boolean> Am() {
        return this.v;
    }

    @Override // ld.a
    public final NextLiveData<Integer> B3() {
        return this.y;
    }

    @Override // ld.a
    public final NextLiveData<String> B5() {
        return this.V0;
    }

    @Override // ld.a
    public final NextLiveData<Boolean> Cb() {
        return this.F;
    }

    @Override // ld.a
    public final NextLiveData<Long> Cn() {
        return this.L;
    }

    @Override // ld.a
    public final NextLiveData<Integer> Dc() {
        return this.U;
    }

    @Override // ld.a
    public final NextLiveData<oq2.a> Ed() {
        return this.M;
    }

    @Override // ld.a
    public final NextLiveData<Unit> F1() {
        return this.d;
    }

    @Override // ld.a
    public final NextLiveData<Boolean> Fc() {
        return this.D;
    }

    @Override // ld.a
    public final NextLiveData<Integer> Gc() {
        return this.Z;
    }

    @Override // ld.a
    public final NextLiveData<Pair<Integer, Integer>> Ii() {
        return this.T;
    }

    @Override // ld.a
    public final NextLiveData<Boolean> Jb() {
        return this.B;
    }

    @Override // ld.a
    public final NextLiveData<Boolean> Jj() {
        return this.e;
    }

    @Override // ld.a
    public final NextLiveData<Boolean> Lc() {
        return this.k;
    }

    @Override // ld.a
    public final NextLiveData<u> Le() {
        return this.g1;
    }

    @Override // ld.a
    public final NextLiveData<Long> Md() {
        return this.N;
    }

    @Override // ld.a
    public final NextLiveData<Unit> N5() {
        return this.g;
    }

    @Override // ld.a
    public final NextLiveData<Boolean> O1() {
        return this.p0;
    }

    @Override // ld.a
    public final NextLiveData<Boolean> Oi() {
        return this.p;
    }

    @Override // ld.a
    public final NextLiveData<Unit> Pc() {
        return this.V;
    }

    @Override // ld.a
    public final NextLiveData<Integer> Q2() {
        return this.P;
    }

    @Override // ld.a
    public final NextLiveData<Integer> Qk() {
        return this.K;
    }

    @Override // ld.a
    public final NextLiveData<oq2.e> Rm() {
        return this.H0;
    }

    @Override // ld.a
    public final NextLiveData<IRoom> Sh() {
        return this.s;
    }

    @Override // ld.a
    public final NextLiveData<List<com.bytedance.android.livesdk.link.model.e>> T4() {
        return this.x1;
    }

    @Override // ld.a
    public final NextLiveData<Boolean> Un() {
        return this.i;
    }

    @Override // ld.a
    public final NextLiveData<gt1.d> Y1() {
        return this.C;
    }

    @Override // ld.a
    public final NextLiveData<Boolean> Y8() {
        return this.h1;
    }

    @Override // ld.a
    public final NextLiveData<Integer> Ze() {
        return this.t;
    }

    @Override // ld.a
    public final NextLiveData<Integer> a2() {
        return this.k0;
    }

    @Override // ld.a
    public final NextLiveData<Boolean> c7() {
        return this.w;
    }

    @Override // ld.a
    public final NextLiveData<Boolean> cn() {
        return this.z;
    }

    @Override // ld.a
    public final NextLiveData<Integer> d0() {
        return this.Q;
    }

    @Override // ld.a
    public final NextLiveData<String> e() {
        return this.W;
    }

    @Override // ld.a
    public final NextLiveData<Integer> f8() {
        return this.X;
    }

    @Override // ld.a
    public final NextLiveData<Integer> getCleanMode() {
        return this.b;
    }

    @Override // ld.a
    public final NextLiveData<Integer> getEnterRoomLinkmicScene() {
        return this.h;
    }

    @Override // ld.a
    public final NextLiveData<Long> getEnterRoomTime() {
        return this.c;
    }

    @Override // ld.a
    public final NextLiveData<LiveMode> getLiveMode() {
        return this.R;
    }

    @Override // ld.a
    public final NextLiveData<Long> getRevLinkControlLoadTs() {
        return this.q;
    }

    @Override // ld.a
    public final NextLiveData<g> getVideoHeight() {
        return this.Y;
    }

    @Override // ld.a
    public final NextLiveData<Boolean> go() {
        return this.y1;
    }

    @Override // ld.a
    public final NextLiveData<String> h4() {
        return this.H;
    }

    @Override // ld.a
    public final NextLiveData<gt1.b> ho() {
        return this.A;
    }

    @Override // ld.a
    public final NextLiveData<Integer> i2() {
        return this.J;
    }

    @Override // ld.a
    public final NextLiveData<Boolean> io() {
        return this.x;
    }

    @Override // ld.a
    public final NextLiveData<Boolean> isCleanMode() {
        return this.a;
    }

    @Override // ld.a
    public final NextLiveData<Boolean> isHugeRewardPk() {
        return this.j;
    }

    @Override // ld.a
    public final NextLiveData<Boolean> isPortrait() {
        return this.S;
    }

    @Override // ld.a
    public final NextLiveData<Long> jm() {
        return this.I;
    }

    @Override // ld.a
    public final NextLiveData<Integer> ke() {
        return this.o;
    }

    @Override // ld.a
    public final NextLiveData<List<com.bytedance.android.livesdk.link.model.e>> lj() {
        return this.p1;
    }

    @Override // ld.a
    public final NextLiveData<List<m11.b>> q2() {
        return this.v1;
    }

    @Override // ld.a
    public final NextLiveData<Boolean> qe() {
        return this.u;
    }

    @Override // ld.a
    public final NextLiveData<g90.a> s9() {
        return this.n;
    }

    @Override // ld.a
    public final NextLiveData<zg1.d> so() {
        return this.f;
    }

    @Override // ld.a
    public final NextLiveData<Unit> tb() {
        return this.k1;
    }

    @Override // ld.a
    public final NextLiveData<Long> u3() {
        return this.O;
    }

    @Override // ld.a
    public final NextLiveData<Integer> uf() {
        return this.m;
    }

    @Override // ld.a
    public final NextLiveData<Boolean> v1() {
        return this.r;
    }

    @Override // ld.a
    public final NextLiveData<Integer> wh() {
        return this.b1;
    }

    @Override // ld.a
    public final NextLiveData<Unit> y5() {
        return this.G;
    }

    @Override // ld.a
    public final NextLiveData<Boolean> z9() {
        return this.E;
    }

    @Override // ld.a
    public final NextLiveData<oq2.b> zn() {
        return this.L0;
    }
}
