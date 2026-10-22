package tf0;

import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.message.l2;
import com.bytedance.android.live.liveinteract.linkbase.SupportUpdatePlayMode;
import com.bytedance.android.live.liveinteract.plantform.model.s0;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import hh1.t0;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import uf2.d0;
import uf2.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface o {

    public interface a {
        int Aa(SurfaceView r1);

        int Po(String r1);

        HashMap<String, Boolean> Y7();

        j1 Zb();

        z.a c3(String r1);

        void ca(String r1, String r2);

        void d0(p r1, Object r2);

        int dn();

        void f();

        d0 getLiveCore();

        void h(String r1, boolean r2, String r3);

        void kd(String r1, String r2);

        String l6();

        int mc();

        void mk(String r1);

        void n1(boolean r1);

        SurfaceView q1();

        void r1(String r1, boolean r2);

        void v4(String r1, boolean r2);
    }

    void A();

    void B(l2 r1);

    t0 C();

    int C0();

    FrameLayout D();

    j E();

    void F();

    void G();

    List<bd0.b> H(boolean r1);

    boolean J();

    void K();

    void L();

    void M(boolean r1, String r2, int r3);

    void N();

    void O();

    void P();

    void R();

    void S(String r1, int r2, int r3);

    void a(View r1, MotionEvent r2);

    void b(String r1);

    void c(String r1, boolean r2);

    List<e> e();

    void end();

    void exitRoom();

    void f();

    void g(d0 r1);

    ViewGroup getFirstSeatVHShadowContainer();

    ViewGroup getFirstSeatVHShadowFloatContainer();

    List<s0> getHeadPointList();

    j getLinkWindowLayoutConfig();

    sf0.b getLinkmicAreaFrameInfo();

    RecyclerView getMicSeatRecyclerView();

    sf0.c getTopLeftSeatFrameInfo();

    int getUserCount();

    int h(String r1);

    void i();

    boolean isDynamicAnimating();

    void j(int r1, int r2);

    int k(String r1);

    void l(boolean r1, Pair<Integer, Integer> r2, Pair<Integer, Integer> r3);

    void m(@SupportUpdatePlayMode int r1);

    int o();

    void o0();

    void onResume();

    void onSeiUpdated(SeiAppData r1);

    void onTalkStateUpdated(String[] r1, boolean[] r2);

    void p();

    int q0(List<ti6.f> r1, Map<String, Integer> r2);

    void r(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r1, Boolean r2);

    void s();

    void setDynamicAnimatorListener(Function0<Unit> r1);

    void t(String r1);

    void u(Boolean r1);

    FrameLayout v();

    void v3(Map<String, Long> r1);

    void w();

    void y(int r1, int r2);

    void z();

    void z0(boolean r1, String r2);
}
