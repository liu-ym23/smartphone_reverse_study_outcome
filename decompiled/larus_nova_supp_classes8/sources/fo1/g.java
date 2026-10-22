package fo1;

import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.livesdk.chatroom.ui.framework.InteractionComponentInfos;
import com.bytedance.android.livesdk.chatroom.ui.framework.base.SceneType;
import com.bytedance.android.livesdk.widgetdescriptor.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements com.bytedance.android.livesdk.chatroom.ui.framework.base.f {
    public final SceneType a;
    public final m b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final int g;
    public final int h;

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final void i() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final LayerDescriptorList a() {
        ArrayList r0 = new ArrayList();
        if (this.c == true) goto L5;
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.I);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.P0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.S0);
    L5:
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.A0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.w0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.D0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.B0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.C0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.J0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.L0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.j0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.N0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.M0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.B);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.x0);
        Map<j70.f, com.bytedance.android.livesdk.chatroom.ui.framework.base.e> r1 = InteractionComponentInfos.a;
        return InteractionComponentInfos.a(this.a, r0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final LayerDescriptorList b() {
        ArrayList r0 = new ArrayList();
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.G0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.r0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.c);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.a);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.K);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.b);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.d0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.f0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.b0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.u0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.E0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.z);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.A);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.C);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.y0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.y);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.s0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.I0);
        Map<j70.f, com.bytedance.android.livesdk.chatroom.ui.framework.base.e> r1 = InteractionComponentInfos.a;
        return InteractionComponentInfos.a(this.a, r0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final LayerDescriptorList c() {
        ArrayList r0 = new ArrayList();
        if (this.f == false) goto L6;
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.U);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.a0);
    L6:
        if (this.g != 2) goto L12;
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.c0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.X);
        if (this.d == true) goto L10;
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.Q0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.V);
    L11:
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.N);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.U0);
        goto L12
    L10:
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.Y);
    L12:
        Map<j70.f, com.bytedance.android.livesdk.chatroom.ui.framework.base.e> r1 = InteractionComponentInfos.a;
        LayerDescriptorList r2 = InteractionComponentInfos.a(this.a, r0);
        if (this.h != 0) goto L15;
        int r3 = com.bytedance.android.livesdk.castscreen.api.b.a;
        LayerDescriptorList r4 = new LayerDescriptorList();
        r4.add(new com.bytedance.android.livesdk.castscreen.descriptor.e());
        r4.add(new com.bytedance.android.livesdk.castscreen.descriptor.h());
        r4.add(new com.bytedance.android.livesdk.castscreen.descriptor.d());
        r4.add(new com.bytedance.android.livesdk.castscreen.descriptor.c());
        r4.add(new com.bytedance.android.livesdk.castscreen.descriptor.g());
        r4.add(new com.bytedance.android.livesdk.castscreen.descriptor.f());
        r2.addAll(r4);
    L15:
        r2.addAll(this.b.a());
        return r2;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final LayerDescriptorList d() {
        ArrayList r0 = new ArrayList();
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.H0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.z0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.v0);
        Map<j70.f, com.bytedance.android.livesdk.chatroom.ui.framework.base.e> r1 = InteractionComponentInfos.a;
        return InteractionComponentInfos.a(this.a, r0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final LayerDescriptorList f() {
        ArrayList r0 = new ArrayList();
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.J);
        if (this.f == true) goto L5;
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.U);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.a0);
    L5:
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.L);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.M);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.R0);
        Map<j70.f, com.bytedance.android.livesdk.chatroom.ui.framework.base.e> r1 = InteractionComponentInfos.a;
        LayerDescriptorList r2 = InteractionComponentInfos.a(this.a, r0);
        if (this.h != 1) goto L8;
        int r3 = com.bytedance.android.livesdk.castscreen.api.b.a;
        LayerDescriptorList r4 = new LayerDescriptorList();
        r4.add(new com.bytedance.android.livesdk.castscreen.descriptor.e());
        r4.add(new com.bytedance.android.livesdk.castscreen.descriptor.h());
        r4.add(new com.bytedance.android.livesdk.castscreen.descriptor.d());
        r4.add(new com.bytedance.android.livesdk.castscreen.descriptor.c());
        r4.add(new com.bytedance.android.livesdk.castscreen.descriptor.g());
        r4.add(new com.bytedance.android.livesdk.castscreen.descriptor.f());
        r2.addAll(r4);
    L8:
        return r2;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final LayerDescriptorList getPreload() {
        if (this.c == false) goto L9;
        ArrayList r0 = new ArrayList();
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.k0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.l0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.F0);
        if (this.d == false) goto L7;
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.T);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.Q);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.R);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.S);
    L7:
        Map<j70.f, com.bytedance.android.livesdk.chatroom.ui.framework.base.e> r1 = InteractionComponentInfos.a;
        LayerDescriptorList r2 = InteractionComponentInfos.a(this.a, r0);
        r2.addAll(com.bytedance.android.livesdk.chatroom.ui.framework.base.g.c(this.b));
        return r2;
    L9:
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final LayerDescriptorList h() {
        LayerDescriptorList r0 = new LayerDescriptorList();
        if (this.c == false) goto L6;
        ArrayList r1 = new ArrayList();
        r1.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.I);
        r1.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.P0);
        r1.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.S0);
        Map<j70.f, com.bytedance.android.livesdk.chatroom.ui.framework.base.e> r2 = InteractionComponentInfos.a;
        r0.addAll(InteractionComponentInfos.a(this.a, r1));
    L6:
        if (this.e == false) goto L24;
        ArrayList r3 = new ArrayList();
        if (this.c == true) goto L10;
        r3.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.k0);
        r3.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.l0);
        r3.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.F0);
    L10:
        r3.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.T0);
        if (this.g != 0) goto L21;
        if (this.d == false) goto L15;
        r3.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.W);
    L15:
        r3.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.c0);
        r3.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.X);
        if (this.d == true) goto L18;
        r3.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.Q0);
        r3.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.V);
    L19:
        r3.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.N);
        r3.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.U0);
        goto L21
    L18:
        r3.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.Y);
    L21:
        if (this.c == true) goto L23;
        r0.addAll(com.bytedance.android.livesdk.chatroom.ui.framework.base.g.c(this.b));
    L23:
        Map<j70.f, com.bytedance.android.livesdk.chatroom.ui.framework.base.e> r4 = InteractionComponentInfos.a;
        r0.addAll(InteractionComponentInfos.a(this.a, r3));
        r0.addAll(com.bytedance.android.livesdk.chatroom.ui.framework.base.g.b(this.b));
    L24:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final LayerDescriptorList j() {
        ArrayList r0 = new ArrayList();
        if (this.g != 3) goto L9;
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.c0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.X);
        if (this.d == false) goto L7;
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.Y);
    L8:
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.N);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.U0);
        goto L9
    L7:
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.V);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.Q0);
    L9:
        Map<j70.f, com.bytedance.android.livesdk.chatroom.ui.framework.base.e> r1 = InteractionComponentInfos.a;
        return InteractionComponentInfos.a(this.a, r0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final LayerDescriptorList k() {
        ArrayList r0 = new ArrayList();
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.o0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.O0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.G);
        if (this.e == true) goto L8;
        if (this.c == true) goto L8;
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.k0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.l0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.F0);
    L8:
        if (this.g != 1) goto L14;
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.c0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.X);
        if (this.d == true) goto L12;
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.Q0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.V);
    L13:
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.N);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.U0);
        goto L14
    L12:
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.Y);
    L14:
        Map<j70.f, com.bytedance.android.livesdk.chatroom.ui.framework.base.e> r1 = InteractionComponentInfos.a;
        return InteractionComponentInfos.a(this.a, r0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final LinkedHashMap<f70.b, LayerDescriptorList> l() {
        return com.bytedance.android.livesdk.chatroom.ui.framework.base.g.a(this.b, this.c, this.e);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final LayerDescriptorList m() {
        ArrayList r0 = new ArrayList();
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.h0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.i0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.m0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.n0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.g0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.p0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.q0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.p);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.q);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.r);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.s);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.t);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.H);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.u);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.v);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.Z);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.D);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.n1);
        Map<j70.f, com.bytedance.android.livesdk.chatroom.ui.framework.base.e> r1 = InteractionComponentInfos.a;
        LayerDescriptorList r2 = InteractionComponentInfos.a(this.a, r0);
        if (this.h != 2) goto L5;
        int r3 = com.bytedance.android.livesdk.castscreen.api.b.a;
        LayerDescriptorList r4 = new LayerDescriptorList();
        r4.add(new com.bytedance.android.livesdk.castscreen.descriptor.e());
        r4.add(new com.bytedance.android.livesdk.castscreen.descriptor.h());
        r4.add(new com.bytedance.android.livesdk.castscreen.descriptor.d());
        r4.add(new com.bytedance.android.livesdk.castscreen.descriptor.c());
        r4.add(new com.bytedance.android.livesdk.castscreen.descriptor.g());
        r4.add(new com.bytedance.android.livesdk.castscreen.descriptor.f());
        r2.addAll(r4);
    L5:
        return r2;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final m g() {
        return this.b;
    }

    public g(boolean r1, boolean r2, boolean r3, boolean r4, int r5, int r6, DataCenter r7) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.a = SceneType.AUDIENCE_PORTRAIT;
        m r8 = new m();
        r8.l = r1;
        r8.m = r3;
        Unit r9 = Unit.INSTANCE;
        this.b = r8;
    }
}
