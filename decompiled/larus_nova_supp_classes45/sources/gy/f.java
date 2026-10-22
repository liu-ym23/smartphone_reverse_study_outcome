package gy;

import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;
import com.bytedance.live.livelink.kmp.api.core.mixer.RTCWaterMarkRegion;
import hh1.v0;
import java.util.List;
import java.util.Map;
import nc0.s;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface f {

    public static final class a {
        public static /* synthetic */ void a(f r1, String r2) {
            r1.T(r2, "");
        }
    }

    boolean F();

    boolean G();

    void J(String r1);

    void K();

    s L();

    List<ui6.a> L0();

    String O();

    com.bytedance.android.live.revenuelink.e P();

    void Q(String r1, String r2);

    void T(String r1, String r2);

    void a(InteractMode r1);

    Integer b(Map r1);

    void c(v0 r1, g r2, String r3, i r4);

    String c0();

    void d(f92.c r1);

    void d0(String r1, String r2, int r3, int r4, Map<String, ? extends Object> r5);

    void e(d r1);

    void f();

    String f0();

    Integer g(Map<Long, String> r1, String r2);

    boolean g0();

    d0 getLiveCore();

    void h(String r1, boolean r2, String r3);

    void i(String r1, RTCWaterMarkRegion r2, long r3);

    boolean isEngineOn();

    void j(String r1);

    void k(String r1);

    void l(long r1);

    void m(d r1);

    void muteLocalVideo(boolean r1);

    void n();

    void o();

    void onPause();

    void onResume();

    void u1(boolean r1);
}
