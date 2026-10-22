package com.bytedance.android.live.liveinteract.plantform.datamerge;

import android.view.SurfaceView;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.v;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.link.model.l6;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface d extends b {
    void A0(boolean r1);

    void B0(boolean r1);

    void C0(com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a r1);

    void D0(ch0.m r1);

    void E0(boolean r1);

    BehaviorSubject<Boolean> F0();

    BehaviorSubject<IVoiceLiveTheme> G0();

    BehaviorSubject<Boolean> H0();

    BehaviorSubject<ch0.i> I0();

    void J0(Map<String, Boolean> r1);

    void K0(String r1);

    void L0(IVoiceLiveTheme r1);

    void M0(com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a r1);

    BehaviorSubject<List<ILinkPlayerInfoBridge>> N0();

    void O0(ch0.b r1);

    BehaviorSubject<ch0.m> P0();

    BehaviorSubject<Map<String, Boolean>> Q0();

    SurfaceView R0();

    BehaviorSubject<Map<String, Boolean>> S0();

    void T0(List<? extends LinkmicPositionItem> r1);

    void U0(Map<String, Long> r1);

    BehaviorSubject<Boolean> V0();

    void W0(ch0.c r1);

    ILinkPlayerInfoBridge X0(String r1);

    void Y0(ch0.k r1);

    void Z0(List<ILinkPlayerInfoBridge> r1);

    void a(List<? extends ILinkPlayerInfoBridge> r1);

    BehaviorSubject<ch0.d> a1();

    BehaviorSubject<wg0.a> b();

    BehaviorSubject<ch0.d> b1();

    void c(wg0.a r1);

    void c1(boolean r1);

    void d1(com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a r1);

    BehaviorSubject<ch0.k> e1();

    BehaviorSubject<List<ch0.e>> f();

    BehaviorSubject<Boolean> f1();

    BehaviorSubject<List<LinkmicPositionItem>> g();

    void g1(com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a r1);

    void h1(Map<String, Boolean> r1);

    void i1(l6 r1);

    BehaviorSubject<Map<String, Boolean>> j1();

    void k1(ch0.l r1);

    ch0.d l1();

    BehaviorSubject<Map<String, Long>> m1();

    void n0(v r1);

    ch0.e n1();

    BehaviorSubject<ch0.b> o1();

    BehaviorSubject<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a> p1();

    v s0();

    void t0(SeiAppData r1);

    BehaviorSubject<List<ILinkPlayerInfoBridge>> u0();

    void v0(com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a r1);

    BehaviorSubject<ch0.l> w0();

    BehaviorSubject<ch0.c> x0();

    void y0(ch0.i r1);

    void z0(ch0.d r1);
}
