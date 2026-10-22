package gn0;

import android.util.Log;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.revenue.guestlink.GuestLinkContext;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.g0;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.s;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.t;
import com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.interact.model.y;
import com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkmicSubtitleStyle;
import com.bytedance.android.livesdk.chatroom.model.interact.SwitchStatus;
import com.bytedance.android.livesdk.chatroom.model.interact.q2;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.config.sj1;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import rj0.l;
import us1.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface a {

    /* JADX INFO: renamed from: gn0.a$a, reason: collision with other inner class name */
    public static final class C0215a {
        public static void a(a r18, String r19, Integer r20, y r21, boolean r22, String r23, int r24) {
            if ((r24 & 1) == 0) goto L5;
            String r1 = null;
        L7:
            if ((r24 & 2) == 0) goto L9;
            Integer r3 = null;
        L11:
            if ((r24 & 4) == 0) goto L13;
            y r4 = null;
        L15:
            if ((r24 & 16) == 0) goto L17;
            String r5 = "";
        L18:
            LinkMultiControlPresenter r7 = (LinkMultiControlPresenter) r18;
            if (r1 != null) goto L21;
        L41:
            if (r3 != null) goto L43;
            return;
        L43:
            if (r3.intValue() != 24) goto L53;
            if (r7.j == false) goto L49;
            if (r22 == false) goto L49;
            ((n) r7).c.put("data_talk_room_admin_allowed_flag", Boolean.TRUE);
        L49:
            if (k.f(IMiddlewareUserService.class).user().isAdmin() == false) goto L53;
            if (r22 == true) goto L53;
            ((n) r7).c.put("data_interact_number_dot_show", "");
            ((n) r7).c.put("data_audio_talk_dot_with_number_show", "");
            ((n) r7).c.put("data_video_talk_dot_with_number_show", "");
            boolean r2 = us1.e.a;
            Intrinsics.checkNotNullParameter("", "<set-?>");
            us1.e.e = "";
        L53:
            if (r3.intValue() != 24) goto L59;
            if (r7.j == false) goto L59;
            if (r22 == false) goto L59;
            ((n) r7).c.put("data_talk_room_admin_allowed_flag", Boolean.TRUE);
        L59:
            if (r3.intValue() != 34) goto L64;
            DigitAvatarContext.a r6 = DigitAvatarContext.Companion;
            if (r6.getContext() == null) goto L64;
            r6.getContext().checkEnsureSingMode();
        L64:
            if (r3.intValue() != 33) goto L69;
            DigitAvatarContext.a r8 = DigitAvatarContext.Companion;
            if (r8.getContext() == null) goto L69;
            r8.getContext().checkEnsureVideoShowMode();
        L69:
            if (r3.intValue() != 52) goto L76;
            l.n2.getClass();
            if (l.a.a() == null) goto L76;
            if (sj1.c() == false) goto L76;
            l.a.a().Hi();
        L76:
            if (r3.intValue() != 72) goto L83;
            if (r4.getContent() == null) goto L83;
            MultiRevenueDataContext.Companion.getClass();
            com.bytedance.android.live.liveinteract.revenuebase.a r9 = MultiRevenueDataContext.a.a();
            if (r9 == null) goto L83;
            r9.d0(ji0.c.b, new ji0.b(r4.getContent().getGuestBattleConfigContent(), r5));
        L83:
            if (r3.intValue() != 73) goto L92;
            if (r4.getContent() == null) goto L92;
            if (r4.getContent().getTeamFightConfigContent() == null) goto L92;
            int r10 = (int) r4.getContent().getTeamFightConfigContent().getLast_fight_duration_by_anchor();
            if (r10 <= 0) goto L92;
            com.bytedance.android.livesdk.sharedpref.e r11 = com.bytedance.android.livesdk.sharedpref.c.Z0;
            Integer r12 = Integer.valueOf(r10);
            r11.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r11, r12);
        L92:
            if (r3.intValue() != 53) goto L99;
            if (r7.x0() == false) goto L99;
            IKtvService r13 = k.f(IKtvService.class);
            if (r13 == null) goto L99;
            r13.enableAtmosphere(r22);
        L99:
            if (r3.intValue() != 54) goto L106;
            if (r7.x0() == false) goto L106;
            IKtvService r14 = k.f(IKtvService.class);
            if (r14 == null) goto L106;
            r14.enablePreviewSong(r22);
        L106:
            if (r3.intValue() != 55) goto L113;
            if (r7.x0() == false) goto L113;
            DigitAvatarContext.a r15 = DigitAvatarContext.Companion;
            if (r15.getContext() == null) goto L113;
            r15.getContext().checkEnsureSingMode();
        L113:
            if (r3.intValue() != 62) goto L116;
            r7.L0(r22);
        L116:
            if (r3.intValue() != 61) goto L136;
            int r0 = g.a;
            IRoom r16 = r7.i;
            DataCenter r17 = ((n) r7).c;
            int r25 = r4.getValue();
            ALogger.d("VideoTalkIntegrationUtils", "updateAnchorEnableIntegrationLink " + r25);
            com.bytedance.android.livesdk.sharedpref.e r26 = b6.k;
            y.Companion.getClass();
            if (r25 == 0) goto L122;
            if (r25 == 1) goto L122;
            boolean r110 = false;
        L123:
            Boolean r111 = Boolean.valueOf(r110);
            r26.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r26, r111);
            if (r16 == null) goto L133;
            z5 r27 = r16.getLinkerDetail();
            if (r27 == null) goto L133;
            if (r25 == 0) goto L131;
            if (r25 == 1) goto L131;
            int r28 = 0;
        L132:
            r27.setIntegrationAnchorEnableAudienceLinkmic(r28);
        L131:
            r28 = 1;
        L133:
            if (r17 == null) goto L136;
            r17.put("data_room_video_talk_integration_anchor_enable_link", Integer.valueOf(r25));
        L122:
            r110 = true;
        L136:
            if (r3.intValue() != 76) goto L139;
            SelfDisciplineContext.Companion.getClass();
            SelfDisciplineContext.a.g(r4);
        L139:
            if (r3.intValue() != 69) goto L149;
            if (r4 == null) goto L149;
            if (r4.getContent() == null) goto L149;
            if (r4.getContent().getRoomBattleSettingContent() == null) goto L149;
            com.bytedance.android.livesdk.sharedpref.e r29 = com.bytedance.android.livesdk.sharedpref.c.Q0;
            Long r30 = Long.valueOf(r4.getContent().getRoomBattleSettingContent().getBattleDuration());
            r29.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r29, r30);
            com.bytedance.android.livesdk.sharedpref.e r31 = com.bytedance.android.livesdk.sharedpref.c.S0;
            Boolean r32 = Boolean.valueOf(r4.getContent().getRoomBattleSettingContent().getAcceptInvite());
            r31.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r31, r32);
            com.bytedance.android.livesdk.sharedpref.e r33 = com.bytedance.android.livesdk.sharedpref.c.U0;
            Boolean r34 = Boolean.valueOf(r4.getContent().getRoomBattleSettingContent().getOnlyAcceptFollowingInvite());
            r33.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r33, r34);
            com.bytedance.android.livesdk.sharedpref.e r35 = com.bytedance.android.livesdk.sharedpref.c.V0;
            Boolean r36 = Boolean.valueOf(r4.getContent().getRoomBattleSettingContent().getAcceptInviteLessThanThreeUser());
            r35.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r35, r36);
            com.bytedance.android.livesdk.sharedpref.e r37 = b6.O;
            String r38 = r4.getContent().getRoomBattleSettingContent().getIntroContent();
            r37.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r37, r38);
            ALogger.i("LinkControlPresenter", "handleRoomBattleConfig content " + r4.getContent().getRoomBattleSettingContent() + "stack " + Log.getStackTraceString(new Throwable()));
            if (r4.getContent().getRoomBattleSettingContent().getRoomBattleThemeParam() == null) goto L149;
            long r39 = r4.getContent().getRoomBattleSettingContent().getRoomBattleThemeParam().getThemeId();
            com.bytedance.android.livesdk.sharedpref.e r40 = com.bytedance.android.livesdk.sharedpref.c.W0;
            Long r41 = Long.valueOf(r39);
            r40.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r40, r41);
            String r42 = r4.getContent().getRoomBattleSettingContent().getRoomBattleThemeParam().getThemeTitle();
            com.bytedance.android.livesdk.sharedpref.e r43 = com.bytedance.android.livesdk.sharedpref.c.X0;
            r43.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r43, r42);
        L149:
            if (r3.intValue() != 90) goto L168;
            if (r7.o == true) goto L153;
        L155:
            if (r4 == null) goto L168;
            if (r4.getContent() == null) goto L168;
            if (r7.x0() == true) goto L168;
            if (r4.getContent().getKtvComponentContent() == null) goto L168;
            if (r4.getContent().getKtvComponentContent().getStatus() != SwitchStatus.SWITCH_ON.getValue()) goto L168;
            if (Boolean.valueOf(k.f(IKtvService.class).isKtvComponentV2Enable()).booleanValue() == false) goto L168;
            k.f(IKtvService.class).sendKtvComponentV2Command(k.f(IKtvService.class).createKtvCommand(1, null, "auto", null, Boolean.FALSE, null, 2));
            goto L168
        L153:
            if (r7.z0() == false) goto L155;
        L168:
            if (r3.intValue() != 94) goto L202;
            if (r4 == null) goto L202;
            if (r4.getContent() == null) goto L202;
            if (r4.getContent().getAudioSubtitleContent() == null) goto L202;
            if (r7.j == false) goto L202;
            ALogger.i("LinkControlPresenter", "[AudioSubtitle] anchorSetting=" + r4.getContent().getAudioSubtitleContent().getStatus());
            int r44 = g0.a;
            if (g0.a(r7.i) == true) goto L179;
            q2 r45 = vh7.f.c(q2.class);
            r45.setSubtitleStyle(LinkmicSubtitleStyle.UNKNOWN.ordinal());
            r4.getContent().getAudioSubtitleContent().setSubtitleStatus(r45);
        L197:
            com.bytedance.android.livesdk.sharedpref.e r46 = b6.p0;
            IAudioSubtitleContent r47 = r4.getContent().getAudioSubtitleContent();
            r46.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r46, r47);
            s r48 = t.a;
            IAudioSubtitleContent r49 = r4.getContent().getAudioSubtitleContent();
            LinkedHashMap r50 = new LinkedHashMap();
            TalkRoomLogUtils.B0(r50, null, null, 6);
            if (r49 == null) goto L200;
            r50.put("permission_state", String.valueOf(r49.getStatus()));
        L200:
            j0.l().sendLog("livesdk_anchor_caption_permission_state", r50, new Object[]{IRoom.class});
            goto L202
        L179:
            if (vm2.c.b().getSubtitleUseDefaultStyleAndPosition() == false) goto L181;
            r4.getContent().getAudioSubtitleContent().setSubtitleStatus(vh7.f.c(q2.class));
        L181:
            int r51 = g0.c(r7.i);
            if (r51 == 1) goto L186;
            if (r51 == 2) goto L186;
            boolean r52 = false;
        L187:
            if (r52 == false) goto L189;
            LinkmicSubtitleStyle r53 = LinkmicSubtitleStyle.LONG;
        L190:
            int r54 = r53.ordinal();
            if (r4.getContent().getAudioSubtitleContent().getSubtitleStatus() != null) goto L194;
            q2 r55 = vh7.f.c(q2.class);
            r55.setSubtitleStyle(r54);
            r4.getContent().getAudioSubtitleContent().setSubtitleStatus(r55);
            goto L197
        L194:
            if (r4.getContent().getAudioSubtitleContent().getSubtitleStatus().getSubtitleStyle() != LinkmicSubtitleStyle.UNKNOWN.ordinal()) goto L197;
            r4.getContent().getAudioSubtitleContent().getSubtitleStatus().setSubtitleStyle(r54);
            goto L197
        L189:
            r53 = LinkmicSubtitleStyle.SHORT;
        L186:
            r52 = true;
        L202:
            if (r3.intValue() != 107) goto L213;
            if (r4.getContent() != null) goto L206;
        L208:
            ALogger.e("LinkControlPresenter", "handleGuestLinkSetting failed");
            Boolean r56 = Boolean.FALSE;
            Boolean r57 = r56;
        L209:
            com.bytedance.android.livesdk.sharedpref.e r58 = com.bytedance.android.livesdk.sharedpref.c.z1;
            r58.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r58, r56);
            com.bytedance.android.livesdk.sharedpref.e r59 = com.bytedance.android.livesdk.sharedpref.c.A1;
            r59.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r59, r57);
            if (GuestLinkContext.getContext() == null) goto L213;
            GuestLinkContext.getContext().isOpen().setValue(r56);
            goto L213
        L206:
            if (r4.getContent().getGuestLinkContent() == null) goto L208;
            com.bytedance.android.livesdk.chatroom.model.interact.d r60 = r4.getContent().getGuestLinkContent();
            ALogger.i("LinkControlPresenter", "handleGuestLinkSetting: " + r60);
            r56 = Boolean.valueOf(r60.b());
            r57 = Boolean.valueOf(r60.a());
        L213:
            if (r3.intValue() != 66) goto L227;
            if (r7.j == true) goto L222;
            if (fj0.c.a() == true) goto L222;
            if (fj0.e.i() == false) goto L222;
            fj0.b.g(fj0.b.b);
        L222:
            if (r7.j == true) goto L227;
            if (fj0.c.a() == true) goto L227;
            fj0.a r61 = fj0.b.a;
            fj0.b.e(null);
        L227:
            if (r3.intValue() != 63) goto L244;
            if (r7.j == true) goto L239;
            if (fj0.c.a() == true) goto L239;
            if (fj0.e.l() == false) goto L235;
            fj0.b.g(fj0.b.b);
        L235:
            com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
            if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().c == false) goto L239;
            fj0.b.g(fj0.b.b);
        L239:
            if (r7.j == true) goto L244;
            if (fj0.c.a() == true) goto L244;
            fj0.a r62 = fj0.b.a;
            fj0.b.e(null);
        L244:
            if (r3.intValue() == 89) goto L246;
            return;
        L246:
            if (k.f(IInteractService.class) != null) goto L248;
            return;
        L248:
            if (((IInteractService) k.f(IInteractService.class)).paidLinkMicContext() == null) goto L254;
            ((IInteractService) k.f(IInteractService.class)).paidLinkMicContext().setPaidQueueState(r4.getValue());
            return;
        L254:
            return;
        L21:
            if (r1.equals("data_big_party_support_send_gift_to_linker") == false) goto L24;
            ((q46.b) r7).a.cj("data_big_party_support_send_gift_to_linker", r22);
        L24:
            if (r1.equals("data_intimate_chat_support_send_gift_to_linker") == false) goto L27;
            ((q46.b) r7).a.cj("data_intimate_chat_support_send_gift_to_linker", r22);
        L27:
            if (r1.equals("data_audio_chat_support_send_gift_to_linker") == false) goto L30;
            ((q46.b) r7).a.cj("data_audio_chat_support_send_gift_to_linker", r22);
        L30:
            if (r1.equals("data_support_send_gift_to_official_channel_host") == false) goto L33;
            ((q46.b) r7).a.cj("data_support_send_gift_to_official_channel_host", r22);
        L33:
            if (r1.equals("data_voice_chat_pre_online_on") == false) goto L36;
            ((q46.b) r7).a.cj("data_voice_chat_pre_online_on", r22);
        L36:
            if (r1.equals("data_voice_talk_apply_need_verify") == false) goto L39;
            ((q46.b) r7).a.cj("data_voice_talk_apply_need_verify", r22);
        L39:
            if (r1.equals("data_video_talk_apply_need_verify") == false) goto L41;
            ((q46.b) r7).a.cj("data_video_talk_apply_need_verify", r22);
            goto L41
        L17:
            r5 = r23;
            goto L18
        L13:
            r4 = r21;
            goto L15
        L9:
            r3 = r20;
            goto L11
        L5:
            r1 = r19;
            goto L7
        }
    }
}
