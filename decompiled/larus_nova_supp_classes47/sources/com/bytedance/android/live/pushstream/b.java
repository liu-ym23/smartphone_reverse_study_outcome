package com.bytedance.android.live.pushstream;

import android.os.Bundle;
import android.view.View;
import com.bytedance.android.live.liveinteract.plantform.core.RtcManager;
import fr2.q0;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import uf2.b1;
import uf2.d0;
import uf2.h0;
import uf2.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface b {

    public static class a {
        public int a;
        public int b;

        public a() {
            this.a = 0;
            this.b = 0;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.pushstream.b$b, reason: collision with other inner class name */
    public static class C0058b {
        public int a;

        public C0058b() {
            this.a = 0;
        }
    }

    d0 A();

    void A0(String r1);

    void B(String r1);

    void B0(String r1, uv0.a r2);

    z C();

    void C0(uv0.a r1);

    void D();

    void D0(h0.b r1);

    void E0();

    void F0(Bundle r1, com.bytedance.android.live.broadcastgame.opengame.service.g r2);

    void G0();

    void H0(String r1, sk0.a.a r2);

    void I();

    void I0(h0.c r1);

    void J();

    void J0(String r1, uv0.a r2);

    void K0(View r1);

    void L();

    void L0(h0.b r1);

    void M();

    void M0(String r1, uv0.a r2);

    boolean N();

    void N0();

    void O(boolean r1);

    void O0(com.bytedance.android.live.broadcast.api.camera.b r1, String r2);

    void P0(int r1, String r2);

    void Q0(boolean r1, String r2, uv0.a r3);

    void R0(boolean r1, String r2, uv0.a r3);

    void S0(h0.e r1);

    int T0();

    void U0(uv0.a r1);

    ei6.a V0();

    int W0();

    void X0(List<String> r1, uv0.a r2);

    void Y0(int r1);

    void Z0(int r1, uv0.a r2);

    boolean a();

    void a1(float r1);

    uf2.x b();

    void b1(String r1);

    int c1(String r1, Object r2, int r3, boolean r4, boolean r5);

    void d1();

    void e1(h0.b r1);

    void f1(String r1, uv0.a r2);

    ei6.a g1(fi6.a r1);

    JSONObject getClientInfo();

    Map<String, String> getFpsInfo();

    d0 getLiveCore();

    C0058b getStatus();

    View getSurfaceView();

    void h1(h0.c r1);

    void i1(uv0.a r1);

    String j1();

    void k1(uv0.a r1);

    void l1(b1 r1);

    void m1(String r1);

    void n1(int r1);

    void o1(q0 r1);

    void p1(float r1);

    void q1(String r1, uv0.a r2);

    void r1();

    void release();

    void s();

    a s1();

    void startZoom(float r1);

    void t(boolean r1);

    boolean t0();

    void t1(boolean r1);

    void u();

    boolean u1();

    void v1(RtcManager.g r1);

    boolean w0();

    void x0();

    void y(String r1);

    d0.a y0();

    void z0(int r1, int r2);
}
