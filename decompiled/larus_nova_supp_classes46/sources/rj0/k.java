package rj0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videolink.VideoTalkAnchorContext;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerChangeMediaInfoContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerClientUIInfoChangeContent;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface k extends e {
    public static final a m2 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static k a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("anchor_video_talk");
            if ((r0 instanceof VideoTalkAnchorContext) == true) goto L5;
            r0 = null;
        L5:
            VideoTalkAnchorContext r1 = (VideoTalkAnchorContext) r0;
            if (r1 == null) goto L11;
            com.bytedance.live.datacontext.j<k> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (k) r2.getValue();
        L11:
            return null;
        }
    }

    public static final class b {
        public static /* synthetic */ void a(k r1) {
            r1.finishVideoTalk("stop_normally");
        }

        public static /* synthetic */ void d(k r2, String r3) {
            r2.im(r3, false, null);
        }

        public static /* synthetic */ void c(k r1, String r2, int r3, int r4) {
            if ((r4 & 4) == 0) goto L5;
            r3 = -1;
        L5:
            r1.v0(0, r2, r3, null);
        }

        public static /* synthetic */ void b(k r7, long r8, String r10, boolean r11, String r12) {
            r7.Ub(r8, r10, r11, r12, null);
        }

        public static /* synthetic */ void e(k r1, int r2, Integer r3, String r4, int r5) {
            if ((r5 & 2) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r5 & 4) == 0) goto L8;
            r4 = null;
        L8:
            r1.T1(r2, r3, r4);
        }

        public static /* synthetic */ void f(k r6, int r7, Integer r8, String r9, boolean r10) {
            r6.Cl(r7, r8, r9, r10, false);
        }

        public static /* synthetic */ void g(k r8, long r9, String r11, long r12, String r14) {
            r8.vl(r9, r11, r12, r14, null);
        }
    }

    static {
        m2 = a.a;
    }

    void Cl(int r1, Integer r2, String r3, boolean r4, boolean r5);

    void Kh(String r1, String r2);

    void Q();

    void Q5(String r1, boolean r2, MediaOperation.a r3);

    void Qj(String r1, String r2);

    void T1(int r1, Integer r2, String r3);

    zj0.d U1();

    void Ub(long r1, String r3, boolean r4, String r5, Function1<? super Boolean, Unit> r6);

    ei6.a Z0();

    void a2(boolean r1, List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r2, ClientUIInfo r3, long r4, Map<Long, ? extends g2> r6);

    void closeMultiEnlargePosition(long r1, List<String> r3);

    void commonWMUpdateLiveCoreAndRtcInfo(String r1);

    String currentCPositionChangeTrackData();

    int currentCPositionOpenSource();

    ILinkPlayerInfoBridge currentCPositionUser();

    String currentCPositionUserType();

    void finishVideoTalk(String r1);

    void forceReverseCamera();

    void g0(IBaseUser r1);

    void g2(int r1, int r2);

    List<ILinkPlayerInfoBridge> getCrossRoomFightLinkUserInfoList();

    tf0.h getInteractAnimationService();

    com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> getLinkUserInfoCenter();

    JsonObject getLinkmicAreaFrameInfo();

    JsonObject getLinkmicSeatListInfo();

    com.bytedance.android.live.pushstream.d getLiveStream();

    MixStreamType getMixStreamType();

    ArrayList<ILinkPlayerInfoBridge> getOnlineList();

    tf0.m getSwitchLayoutStatisticsUtils();

    void h2(gd0.d r1);

    void im(String r1, boolean r2, MediaOperation.a r3);

    void invite(com.bytedance.android.live.liveinteract.videolink.a r1);

    boolean isEngineOn();

    void j3(long r1);

    void j6(boolean r1, String r2);

    void lm(boolean r1);

    void onChangeMediaInfo(ILinkerChangeMediaInfoContent r1, int r2);

    void onSwitchSceneMessage(z0 r1);

    cj0.e paidLinkManager();

    void permit(ILinkPlayerInfoBridge r1);

    void pm();

    void replyCPosition(long r1, String r3, boolean r4);

    void s3();

    void setInviteCallback(uf0.c r1);

    void setPermitCallback(uf0.d r1);

    void u5(ILinkerClientUIInfoChangeContent r1);

    void updateFullScreenDialogShowStatus(boolean r1);

    boolean userIsCPosition(String r1);

    void v0(int r1, String r2, int r3, String r4);

    void vl(long r1, String r3, long r4, String r6, Function1<? super Boolean, Unit> r7);

    void w5();

    tf0.o windowManager();

    void z0(boolean r1, String r2);
}
