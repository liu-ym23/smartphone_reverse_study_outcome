package gs0;

import com.bytedance.android.live.platformplayer.layout.n1;
import com.bytedance.android.live.room.h;
import com.bytedance.android.livesdk.chatroom.ui.q6;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.android.livesdkapi.eventbus.ChangeCameraStreamEvent;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import is2.g;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface c extends g {
    void A70();

    void Ap(String r1);

    boolean BE();

    void E(cy0.a r1);

    void HI(boolean r1);

    void Jy();

    void M30(int r1, String r2);

    void Mu(AbsLivePlayerView r1);

    void On();

    AbsLivePlayerView R8();

    void Rl(h r1);

    void Rz(boolean r1);

    void Tk(cs0.a r1);

    void Wu(String r1, boolean r2);

    void Xk(String r1);

    void Z70(boolean r1);

    void ZW(ChangeCameraStreamEvent r1);

    void a4(VSCameraInfo r1, boolean r2, boolean r3, boolean r4);

    boolean cn();

    void dG(Function0<? extends com.bytedance.android.live.platformplayer.b> r1);

    void ep(boolean r1);

    void gV(boolean r1);

    void hG(boolean r1);

    void hI(boolean r1);

    boolean isInteracting();

    void ji(a r1);

    void l60(boolean r1);

    com.bytedance.android.live.platformplayer.layout.c ly();

    void mj(String r1);

    void qQ();

    void rz(xj1.a r1);

    void setNestedOutside(boolean r1);

    void setUserVisibleHint(boolean r1);

    void stopRoomWithoutReleasePlayer(boolean r1);

    void tX(n1 r1);

    void tp(q6 r1);

    void uZ(cs0.c r1);

    void uu();

    void vR(boolean r1);

    void we(AbsLivePlayerView r1, String r2);

    void x6(VSCameraInfo r1, boolean r2);

    void zS(cs0.b r1);
}
