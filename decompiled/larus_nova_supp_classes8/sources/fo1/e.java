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
public final class e implements com.bytedance.android.livesdk.chatroom.ui.framework.base.f {
    public final SceneType a;
    public final m b;
    public final boolean c;

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final LayerDescriptorList getPreload() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final void i() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final LayerDescriptorList j() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final LayerDescriptorList a() {
        ArrayList r0 = new ArrayList();
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.I);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.w0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.D0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.A0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.B0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.P0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.S0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.C0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.J0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.L0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.j0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.N0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.M0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.F);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.x0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.y);
        Map<j70.f, com.bytedance.android.livesdk.chatroom.ui.framework.base.e> r1 = InteractionComponentInfos.a;
        return InteractionComponentInfos.a(this.a, r0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final LayerDescriptorList b() {
        ArrayList r0 = new ArrayList();
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.G0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.r0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.k);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.h);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.U0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.Q0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.N);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.O);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.U);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.a0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.L);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.M);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.f);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.c0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.d0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.d);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.g);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.e);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.i);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.j);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.f0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.u0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.b0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.I0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.y0);
        Map<j70.f, com.bytedance.android.livesdk.chatroom.ui.framework.base.e> r1 = InteractionComponentInfos.a;
        return InteractionComponentInfos.a(this.a, r0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final LayerDescriptorList c() {
        LayerDescriptorList r0 = new LayerDescriptorList();
        r0.addAll(this.b.a());
        return r0;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final LayerDescriptorList d() {
        ArrayList r0 = new ArrayList();
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.o);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.H0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.z0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.v0);
        Map<j70.f, com.bytedance.android.livesdk.chatroom.ui.framework.base.e> r1 = InteractionComponentInfos.a;
        return InteractionComponentInfos.a(this.a, r0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final LayerDescriptorList f() {
        ArrayList r0 = new ArrayList();
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.R0);
        Map<j70.f, com.bytedance.android.livesdk.chatroom.ui.framework.base.e> r1 = InteractionComponentInfos.a;
        return InteractionComponentInfos.a(this.a, r0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final LayerDescriptorList h() {
        if (this.c == false) goto L6;
        ArrayList r0 = new ArrayList();
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.k0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.l0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.F0);
        Map<j70.f, com.bytedance.android.livesdk.chatroom.ui.framework.base.e> r1 = InteractionComponentInfos.a;
        LayerDescriptorList r2 = InteractionComponentInfos.a(this.a, r0);
        r2.addAll(com.bytedance.android.livesdk.chatroom.ui.framework.base.g.c(this.b));
        r2.addAll(com.bytedance.android.livesdk.chatroom.ui.framework.base.g.b(this.b));
        return r2;
    L6:
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final LayerDescriptorList k() {
        ArrayList r0 = new ArrayList();
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.o0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.w);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.m);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.n);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.O0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.G);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.T0);
        if (this.c == true) goto L5;
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.k0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.l0);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.F0);
    L5:
        Map<j70.f, com.bytedance.android.livesdk.chatroom.ui.framework.base.e> r1 = InteractionComponentInfos.a;
        return InteractionComponentInfos.a(this.a, r0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final LinkedHashMap<f70.b, LayerDescriptorList> l() {
        return com.bytedance.android.livesdk.chatroom.ui.framework.base.g.a(this.b, false, this.c);
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
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.l);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.x);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.E);
        r0.add(com.bytedance.android.livesdk.chatroom.ui.framework.f.n1);
        Map<j70.f, com.bytedance.android.livesdk.chatroom.ui.framework.base.e> r1 = InteractionComponentInfos.a;
        return InteractionComponentInfos.a(this.a, r0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.f
    public final m g() {
        return this.b;
    }

    public e(boolean r2, DataCenter r3) {
        this.c = r2;
        this.a = SceneType.AUDIENCE_LANDSCAPE;
        m r4 = new m();
        r4.l = false;
        r4.m = r2;
        Unit r5 = Unit.INSTANCE;
        this.b = r4;
    }
}
