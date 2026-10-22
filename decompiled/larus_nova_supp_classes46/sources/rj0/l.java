package rj0;

import android.content.Context;
import android.view.SurfaceView;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videolink.VideoTalkGuestContext;
import com.bytedance.android.live.liveinteract.voicechat.MuteStateChecker;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.SongListItemViewHolder;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerChangeMediaInfoContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerClientUIInfoChangeContent;
import com.bytedance.live.datacontext.DataContext;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;
import uf2.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface l extends f {
    public static final a n2 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static l a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("guest_video_talk");
            if ((r0 instanceof VideoTalkGuestContext) == true) goto L5;
            r0 = null;
        L5:
            VideoTalkGuestContext r1 = (VideoTalkGuestContext) r0;
            if (r1 == null) goto L11;
            com.bytedance.live.datacontext.j<l> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (l) r2.getValue();
        L11:
            return null;
        }
    }

    public static final class b {
        public static /* synthetic */ void c(l r2, String r3, int r4) {
            if ((r4 & 2) == 0) goto L5;
            boolean r0 = true;
        L7:
            if ((r4 & 4) == 0) goto L9;
            r3 = null;
        L9:
            r2.cancelApply(null, r0, r3);
            return;
        L5:
            r0 = false;
            goto L7
        }

        public static /* synthetic */ void a(l r6, int r7, int r8, String r9) {
            r6.M8(r7, r8, r9, null, null);
        }

        public static /* synthetic */ void d(l r0, int r1, boolean r2, boolean r3, int r4) {
            if ((r4 & 4) == 0) goto L5;
            r3 = true;
        L5:
            r0.Cb(r1, r2, r3, null);
        }

        public static /* synthetic */ void b(l r10, int r11, int r12, String r13, String r14, Integer r15, LinkApplyType r16, int r17) {
            if ((r17 & 16) == 0) goto L5;
            Integer r7 = null;
        L7:
            if ((r17 & 32) == 0) goto L9;
            LinkApplyType r8 = null;
        L10:
            r10.kc(r11, r12, r13, r14, r7, r8, null);
            return;
        L9:
            r8 = r16;
            goto L10
        L5:
            r7 = r15;
            goto L7
        }
    }

    static {
        n2 = a.a;
    }

    void Cb(int r1, boolean r2, boolean r3, c r4);

    MuteStateChecker Hg();

    void Hi();

    void M8(int r1, int r2, String r3, LinkApplyType r4, tf0.b r5);

    SurfaceView R0();

    void S8(String r1, int r2, String r3);

    void Sj();

    void So(int r1, rj0.a r2, String r3, boolean r4);

    boolean T2();

    void Td(String r1, MediaOperation.a r2);

    zj0.d U1();

    void Wg(z0 r1);

    void X3(long r1, String r3, String r4, int r5);

    ei6.a Z0();

    void a2(boolean r1, List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r2, ClientUIInfo r3, long r4, Map<Long, ? extends g2> r6);

    void apply(sf0.a r1);

    void b3();

    z.a c3(String r1);

    void cancelApply(h80.a<Boolean> r1, boolean r2, String r3);

    void commonWMUpdateLiveCoreAndRtcInfo(String r1);

    String currentCPositionChangeTrackData();

    int currentCPositionOpenSource();

    ILinkPlayerInfoBridge currentCPositionUser();

    String currentCPositionUserType();

    void ec(LinkApplyType r1, LinkMatchType r2, String r3);

    void exitRoom();

    void forceReverseCamera();

    void g2(int r1, int r2);

    List<ILinkPlayerInfoBridge> getCrossRoomFightLinkUserInfoList();

    tf0.h getInteractAnimationService();

    com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> getLinkUserInfoCenter();

    JsonObject getLinkmicAreaFrameInfo();

    tf0.k getLinkmicReturnRoomParams();

    JsonObject getLinkmicSeatListInfo();

    com.bytedance.android.live.pushstream.d getLiveStream();

    int getSelfSilenceType();

    tf0.m getSwitchLayoutStatisticsUtils();

    m00.g hh();

    boolean isCurrentLinkPaid();

    boolean isEngineOn();

    void j1(int r1, Integer r2, String r3, Boolean r4);

    void j3(long r1);

    void kc(int r1, int r2, String r3, String r4, Integer r5, LinkApplyType r6, tf0.b r7);

    void li(String r1, MediaOperation.a r2);

    void n4(SurfaceView r1);

    void o2(boolean r1, SongListItemViewHolder.bindClickListener.3.c r2, sf0.a r3);

    void onChangeMediaInfo(ILinkerChangeMediaInfoContent r1, int r2);

    void onProfileCardClick(String r1, int r2, String r3);

    cj0.e paidLinkManager();

    void r0(Context r1, IRoom r2, rj0.b r3);

    void replyCPosition(long r1, String r3, boolean r4);

    void se();

    void tm(String r1, String r2);

    void tryAutoFastMatch();

    void u5(ILinkerClientUIInfoChangeContent r1);

    void updateFullScreenDialogShowStatus(boolean r1);

    boolean userIsCPosition(String r1);

    void w4();

    tf0.o windowManager();

    void z0(boolean r1, String r2);
}
