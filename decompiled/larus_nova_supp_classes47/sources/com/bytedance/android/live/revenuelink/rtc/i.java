package com.bytedance.android.live.revenuelink.rtc;

import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface i {

    public static final class a {
        public static /* synthetic */ void a(i r6, String r7, String r8) {
            r6.d0(r7, r8, 0, 0, null);
        }
    }

    void A(String r1, String r2);

    void B(JSONObject r1);

    void D1(String r1, boolean r2, String r3);

    boolean F();

    void F1(LiveTracingMonitorKt.EventModule r1, com.bytedance.android.live.revlink.impl.multianchor.connect.m r2);

    boolean G();

    void G1(String r1, boolean r2, String r3);

    void H1(long r1, String r3);

    void I1(vc0.a r1);

    void J(String r1);

    void J0(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5);

    void K();

    p L();

    List<vc0.a> L0();

    void L1();

    long M(String r1, String r2);

    void M1();

    void N0(JSONObject r1);

    void N1(boolean r1);

    String O();

    void O0(String r1);

    void O1();

    com.bytedance.android.live.revenuelink.b P();

    vc0.a P0();

    void P1(boolean r1, String r2, List<String> r3);

    void Q(String r1, String r2);

    boolean Q0();

    void Q1(String r1);

    void R0(String r1);

    void R1(String r1, boolean r2);

    void S1(String r1, vc0.a r2, long r3);

    void T(String r1, String r2);

    void T1(String r1, boolean r2);

    void U();

    String U0();

    void U1(vc0.a r1, j r2, String r3, q r4);

    void V0(List<String> r1);

    void W0(int r1, long r2, long r4, String r6);

    void Z0(String r1);

    Integer a1(Map<Long, String> r1, String r2, String r3);

    void b0(String r1, int r2, String r3);

    void b1(String r1, boolean r2);

    String c0();

    Integer c1(Map<Long, String> r1, String r2, String r3);

    pc0.e createRtcData();

    void d0(String r1, String r2, int r3, int r4, Map<String, ? extends Object> r5);

    pc0.e e();

    void f();

    String f0();

    void g(String r1);

    boolean g0();

    void g1(g r1);

    String getBusinessId();

    vc0.a getLiveCore();

    String getLiveCoreExtInfo();

    int getMixType();

    String getRtcExtInfo();

    void h(String r1, boolean r2, String r3);

    boolean hasLogin();

    void i(boolean r1);

    void i1(g r1);

    boolean isEngineOn();

    void j();

    void j1(vc0.a r1);

    void k(String r1);

    void k1(pc0.e r1, String r2);

    void logout();

    void muteLocalVideo(boolean r1);

    void n();

    void n1();

    void o();

    void o1();

    void onPause();

    void onResume();

    void p0(boolean r1, String r2);

    void q0();

    void q1(String r1);

    void v1(vc0.a r1, int r2, int r3);

    void x(boolean r1);

    void y1(boolean r1, String r2);
}
