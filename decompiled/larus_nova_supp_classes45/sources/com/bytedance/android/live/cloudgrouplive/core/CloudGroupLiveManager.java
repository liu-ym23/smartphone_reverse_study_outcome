package com.bytedance.android.live.cloudgrouplive.core;

import a40.g;
import a40.h;
import a40.i;
import a40.j;
import a40.k;
import a40.l;
import a40.n;
import a40.p;
import android.content.Context;
import android.os.SystemClock;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.cloudgrouplive.api.CloudGroupLiveApi;
import com.bytedance.android.live.cloudgrouplive.datacontext.CloudGroupContext;
import com.bytedance.android.live.cloudgrouplive.im.CloudGroupLiveMsgManager;
import com.bytedance.android.live.cloudgrouplive.im.CloudGroupLiveMsgManager$mOnMessageListener$2;
import com.bytedance.android.live.cloudgrouplive.model.CloudGroupLivePipelineStatus;
import com.bytedance.android.live.cloudgrouplive.rtc.AnchorGroupLiveStatus;
import com.bytedance.android.live.cloudgrouplive.rtc.CloudGroupLiveRTCManager;
import com.bytedance.android.live.cloudgrouplive.rtc.GroupLiveStreamStatus;
import com.bytedance.android.live.cloudgrouplive.utils.AnchorExitGroupLiveType;
import com.bytedance.android.live.cloudgrouplive.utils.CloudGroupLiveTraceEvent;
import com.bytedance.android.live.cloudgrouplive.utils.GroupLiveStatus;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.d0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.q1;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.y0;
import com.bytedance.android.livesdk.config.il;
import com.bytedance.android.livesdk.message.model.d3;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.model.CloudGroupLiveBeInvitedDialogConfig;
import com.bytedance.android.livesdkapi.model.CloudGroupLiveDeviceScoreConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.livelink.kmp.api.base.config.Character;
import com.bytedance.live.livelink.kmp.api.base.config.StreamType;
import com.bytedance.live.livelink.kmp.api.base.video.ViewType;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class CloudGroupLiveManager implements z30.b {
    public Context a;
    public ViewGroup b;
    public DataCenter c;
    public CloudGroupLivePipelineStatus d;
    public CloudGroupLiveRTCManager e;
    public CloudGroupLiveMsgManager f;
    public e40.f g;
    public c40.a h;
    public k i;
    public d40.a j;
    public d3 k;
    public com.bytedance.android.live.cloudgrouplive.core.d l;
    public boolean m;
    public long n;
    public long o;
    public final f p;
    public final c q;

    public static final class a {
    }

    public static final class b implements n {
        public final /* synthetic */ CloudGroupLiveManager a;

        @Override // a40.n
        public final void I3() {
            ALogger.i("CloudGroupLiveManager", "onLeaveSuccess");
            this.a.g(CloudGroupLivePipelineStatus.END);
            CloudGroupLiveRTCManager r0 = this.a.e;
            if (r0 == null) goto L5;
            r0.f("leave_api_success");
        L5:
            d40.a r1 = this.a.j;
            if (r1 == null) goto L8;
            r1.b();
        L8:
            e40.f r2 = this.a.g;
            if (r2 == null) goto L11;
            r2.a();
        L11:
            int r3 = f40.a.a;
            d3 r4 = this.a.k;
            Long r5 = null;
            if (r4 == null) goto L16;
            IBaseUser r6 = r4.getFromUser();
            if (r6 == null) goto L16;
            String r7 = r6.getUserId();
        L17:
            String r8 = String.valueOf(r7);
            d3 r9 = this.a.k;
            if (r9 == null) goto L20;
            r5 = r9.E();
        L20:
            f40.a.a(r8, String.valueOf(r5), AnchorExitGroupLiveType.SELF_EXIT);
            return;
        L16:
            r7 = null;
            goto L17
        }

        public b(CloudGroupLiveManager r1) {
            this.a = r1;
        }

        @Override // a40.n
        public final void F2(long r3, Throwable r5) {
            Intrinsics.checkNotNullParameter(r5, "throwable");
            ALogger.i("CloudGroupLiveManager", "onLeaveFailed duration " + r3 + " error " + r5);
            if ((r5 instanceof ApiServerException) == false) goto L13;
            String r4 = ((ApiServerException) r5).getPrompt();
            if (r4 != null) goto L7;
            return;
        L7:
            if ((!StringsKt.isBlank(r4)) == true) goto L10;
            r4 = null;
        L10:
            if (r4 == null) goto L15;
            f2.c(r4, 0);
            return;
        L15:
            return;
        }
    }

    public static final class c implements com.bytedance.android.live.cloudgrouplive.im.a {
        public final /* synthetic */ CloudGroupLiveManager a;

        public c(CloudGroupLiveManager r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.cloudgrouplive.im.a
        public final void a(d3 r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        @Override // com.bytedance.android.live.cloudgrouplive.im.a
        public final void b(d3 r6) {
            Intrinsics.checkNotNullParameter(r6, "msg");
            ALogger.i("CloudGroupLiveManager", "onKickOutMsg msg=" + r6);
            int r0 = f40.a.a;
            f40.a.d(CloudGroupLiveTraceEvent.LIVE_MANAGER, "onKickOutMsg", 0, "msg=" + r6, 20);
            CloudGroupLiveManager.c(this.a, s1.B(2131915850), "receive_kick_out_msg");
            IBaseUser r7 = r6.getFromUser();
            Long r1 = null;
            if (r7 == null) goto L5;
            String r8 = r7.getUserId();
        L6:
            String r9 = String.valueOf(r8);
            d3 r2 = this.a.k;
            if (r2 == null) goto L9;
            r1 = r2.E();
        L9:
            f40.a.a(r9, String.valueOf(r1), AnchorExitGroupLiveType.KICK_OUT);
            return;
        L5:
            r8 = null;
            goto L6
        }

        @Override // com.bytedance.android.live.cloudgrouplive.im.a
        public final void c(d3 r5) {
            Intrinsics.checkNotNullParameter(r5, "msg");
            ALogger.i("CloudGroupLiveManager", "onStartMsg msg=" + r5);
            int r0 = f40.a.a;
            f40.a.d(CloudGroupLiveTraceEvent.LIVE_MANAGER, "onStartMsg", 0, "msg=" + r5, 20);
            CloudGroupLiveManager r6 = this.a;
            r6.m = true;
            CloudGroupLiveRTCManager r1 = r6.e;
            if (r1 == null) goto L10;
            f r7 = r6.p;
            if (r1.h == false) goto L7;
            GroupLiveStreamStatus r2 = GroupLiveStreamStatus.STARTED;
        L8:
            r7.a(r2);
            this.a.p.d(r1.i);
            return;
        L7:
            r2 = GroupLiveStreamStatus.STOPPED;
            goto L8
        }

        @Override // com.bytedance.android.live.cloudgrouplive.im.a
        public final void d(d3 r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        @Override // com.bytedance.android.live.cloudgrouplive.im.a
        public final void e(d3 r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        @Override // com.bytedance.android.live.cloudgrouplive.im.a
        public final void f(d3 r6) {
            Intrinsics.checkNotNullParameter(r6, "msg");
            ALogger.i("CloudGroupLiveManager", "onEndMsg msg=" + r6);
            int r0 = f40.a.a;
            f40.a.d(CloudGroupLiveTraceEvent.LIVE_MANAGER, "onEndMsg", 0, "msg=" + r6, 20);
            CloudGroupLiveManager r1 = this.a;
            r1.m = false;
            CloudGroupLiveManager.c(r1, s1.B(2131915848), "receive_end_msg");
            IBaseUser r7 = r6.getFromUser();
            Long r2 = null;
            if (r7 == null) goto L5;
            String r8 = r7.getUserId();
        L6:
            String r9 = String.valueOf(r8);
            d3 r3 = this.a.k;
            if (r3 == null) goto L9;
            r2 = r3.E();
        L9:
            f40.a.a(r9, String.valueOf(r2), AnchorExitGroupLiveType.HOST_END);
            return;
        L5:
            r8 = null;
            goto L6
        }

        @Override // com.bytedance.android.live.cloudgrouplive.im.a
        public final void g(d3 r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        @Override // com.bytedance.android.live.cloudgrouplive.im.a
        public final void h(d3 r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        @Override // com.bytedance.android.live.cloudgrouplive.im.a
        public final void i(d3 r13) {
            Intrinsics.checkNotNullParameter(r13, "msg");
            ALogger.i("CloudGroupLiveManager", "receive invite msg, msg=" + r13);
            int r0 = f40.a.a;
            CloudGroupLiveTraceEvent r1 = CloudGroupLiveTraceEvent.LIVE_MANAGER;
            StringBuilder r2 = new StringBuilder("isPkInviting=");
            ILinkServiceExternal r3 = (ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class);
            String r4 = null;
            if (r3 == null) goto L7;
            lc0.d r5 = r3.getPkService();
            if (r5 == null) goto L7;
            Boolean r6 = Boolean.valueOf(r5.F());
        L8:
            r2.append(r6);
            r2.append(", isPlayingGame=");
            InteractGameContext.Companion r7 = InteractGameContext.Companion;
            InteractGameContext r8 = r7.getContext();
            if (r8 == null) goto L15;
            m<Boolean> r9 = r8.isPlayingGame();
            if (r9 == null) goto L15;
            if (((Boolean) r9.getValue()).booleanValue() != true) goto L15;
        L16:
            boolean r11 = true;
        L18:
            r2.append(r11);
            r2.append(", msg=");
            r2.append(r13);
            f40.a.d(r1, "onInviteMsg", 0, r2.toString(), 20);
            this.a.k = r13;
            if (z0.b(true) < ((CloudGroupLiveDeviceScoreConfig) il.a.getValue()).getDeviceScoreThreshold()) goto L21;
            boolean r12 = true;
        L22:
            if (r12 == true) goto L25;
            f40.a.d(r1, "RejectInvite", 0, "device record score not support cloud group live", 20);
            this.a.a(false, s1.B(2131915856));
            return;
        L25:
            InteractGameContext r14 = r7.getContext();
            if (r14 == null) goto L32;
            m<Boolean> r15 = r14.isPlayingGame();
            if (r15 == null) goto L32;
            if (((Boolean) r15.getValue()).booleanValue() != true) goto L32;
        L33:
            this.a.a(false, s1.B(2131915855));
            return;
        L32:
            if (com.bytedance.android.live.broadcastgame.api.xplay.n.b.l() == true) goto L33;
            d0 r16 = d0.a;
            if (((CloudGroupLiveBeInvitedDialogConfig) r16.getValue()).getDisablePK() == false) goto L45;
            ILinkServiceExternal r17 = (ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class);
            if (r17 == null) goto L45;
            lc0.d r18 = r17.getPkService();
            if (r18 == null) goto L45;
            if (r18.F() != true) goto L45;
            ALogger.i("CloudGroupLiveManager", "receive PK inviting, reject cloud group live invite");
            this.a.a(false, "主播正在连线或PK中，无法接受邀请");
            return;
        L45:
            this.a.g(CloudGroupLivePipelineStatus.INVITING);
            Context r19 = this.a.getContext();
            if (r19 == null) goto L99;
            IBaseUser r21 = r13.getFromUser();
            if (r21 == null) goto L54;
            py.k r22 = r21.getAvatarThumbKt();
            if (r22 == null) goto L54;
            List<String> r23 = r22.getUrls();
            if (r23 == null) goto L54;
            int r24 = r23.size();
        L55:
            String r25 = "";
            if (r24 <= 0) goto L65;
            IBaseUser r26 = r13.getFromUser();
            if (r26 == null) goto L64;
            py.k r27 = r26.getAvatarThumbKt();
            if (r27 == null) goto L64;
            List<String> r28 = r27.getUrls();
            if (r28 == null) goto L64;
            String r29 = (String) ListProtector.get(r28, 0);
        L67:
            if (this.a.h == null) goto L100;
            if (r29 != null) goto L70;
            r29 = "";
        L70:
            IBaseUser r31 = r13.getFromUser();
            if (r31 == null) goto L76;
            String r32 = r31.getRealNickName();
            if (r32 == null) goto L76;
            r25 = r32;
        L76:
            IBaseUser r110 = r13.getFromUser();
            if (r110 == null) goto L79;
            String r111 = r110.getUserId();
        L80:
            String r112 = String.valueOf(r111);
            d3 r33 = this.a.k;
            if (r33 == null) goto L83;
            Long r34 = r33.E();
        L84:
            String r35 = String.valueOf(r34);
            d3 r36 = this.a.k;
            if (r36 == null) goto L89;
            Long r37 = r36.P();
            if (r37 == null) goto L89;
            long r38 = r37.longValue();
        L90:
            Intrinsics.checkNotNullParameter(r19, "context");
            Intrinsics.checkNotNullParameter(r29, "avatarUrl");
            Intrinsics.checkNotNullParameter(r25, "nickName");
            Intrinsics.checkNotNullParameter(r112, "hostAnchorId");
            Intrinsics.checkNotNullParameter(r35, "hostRoomId");
            CloudGroupLiveBeInvitedDialogConfig r39 = (CloudGroupLiveBeInvitedDialogConfig) r16.getValue();
            StringBuilder r41 = new StringBuilder();
            if (r39 == null) goto L93;
            String r113 = r39.getSchema();
        L94:
            r41.append(r113);
            r41.append("&url=");
            if (r39 == null) goto L97;
            r4 = r39.getUrl();
        L97:
            r41.append(r4);
            String r42 = r41.toString();
            LinkedHashMap r43 = new LinkedHashMap();
            r43.put("user_avatar", r29);
            r43.put("user_name", r25);
            r43.put("count_down_time", String.valueOf(r38));
            r43.put("host_anchor_id", r112);
            r43.put("host_room_id", r35);
            String r114 = y0.b(r42, r43);
            ALogger.i("CloudGroupLiveJSBManager", "openBeInvitedDialog context=" + r19 + ", openDialogSchema=" + r114);
            CloudGroupLiveTraceEvent r44 = CloudGroupLiveTraceEvent.JSB_MANAGER;
            StringBuilder r45 = new StringBuilder("openDialogSchema=");
            r45.append(r114);
            f40.a.d(r44, "openBeInvitedDialog", 0, r45.toString(), 20);
            jc1.k.n(IBaseLiveActionHandler.class).handle(r19, r114);
            return;
        L93:
            r113 = null;
        L89:
            r38 = 0;
            goto L90
        L83:
            r34 = null;
            goto L84
        L79:
            r111 = null;
            goto L80
        L100:
            return;
        L64:
            r29 = null;
            goto L67
        L65:
            r29 = "";
        L54:
            r24 = 0;
            goto L55
        L99:
            return;
        L21:
            r12 = false;
        L15:
            if (com.bytedance.android.live.broadcastgame.api.xplay.n.b.l() == true) goto L16;
            r11 = false;
        L7:
            r6 = null;
            goto L8
        }
    }

    public static final class d implements l {
        public final /* synthetic */ CloudGroupLiveManager a;

        public d(CloudGroupLiveManager r1) {
            this.a = r1;
        }

        @Override // a40.l
        public final void a(long r3, Throwable r5) {
            Intrinsics.checkNotNullParameter(r5, "throwable");
            ALogger.i("CloudGroupLiveManager", "onAcceptFailed");
            this.a.g(CloudGroupLivePipelineStatus.END);
            com.bytedance.android.live.cloudgrouplive.core.d r0 = this.a.l;
            if (r0 == null) goto L5;
            String r6 = String.valueOf(r5.getMessage());
            Intrinsics.checkNotNullParameter(r6, "<set-?>");
            r0.a = r6;
        L5:
            com.bytedance.android.live.cloudgrouplive.core.d r7 = this.a.l;
            if (r7 == null) goto L8;
            r7.b = r3;
        L8:
            if (r7 == null) goto L11;
            int r4 = f40.a.a;
            f40.a.c(r7);
            return;
        }

        @Override // a40.l
        public final void b(long r17, com.bytedance.android.live.network.response.e<com.bytedance.android.live.cloudgrouplive.model.a> r19) {
            Intrinsics.checkNotNullParameter(r19, "response");
            ALogger.i("CloudGroupLiveManager", "onAcceptSuccess");
            com.bytedance.android.live.cloudgrouplive.core.d r2 = this.a.l;
            if (r2 == null) goto L5;
            Intrinsics.checkNotNullParameter("success", "<set-?>");
            r2.a = "success";
        L5:
            CloudGroupLiveManager r3 = this.a;
            com.bytedance.android.live.cloudgrouplive.core.d r4 = r3.l;
            if (r4 == null) goto L8;
            r4.b = r17;
        L8:
            CloudGroupLiveRTCManager r5 = r3.e;
            if (r5 == null) goto L11;
            f r6 = r3.p;
            Intrinsics.checkNotNullParameter(r6, "listener");
            r5.d = r6;
        L11:
            com.bytedance.android.live.cloudgrouplive.model.c r1 = ((com.bytedance.android.live.cloudgrouplive.model.a) ((ExtraResponse) r19).data).a();
            if (r1 == null) goto L88;
            com.bytedance.android.live.cloudgrouplive.model.b r7 = r1.a();
            if (r7 == null) goto L89;
            this.a.n = System.currentTimeMillis();
            CloudGroupLiveManager r8 = this.a;
            CloudGroupLiveRTCManager r9 = r8.e;
            if (r9 == null) goto L90;
            d3 r11 = r8.k;
            if (r11 == null) goto L20;
            Long r12 = r11.E();
        L21:
            String r13 = String.valueOf(r12);
            Intrinsics.checkNotNullParameter(r13, "rtcRoomId");
            Intrinsics.checkNotNullParameter(r7, "rtcInfo");
            ALogger.i("CloudGroupLiveRTCManager", "startLink rtcRoomId=" + r13 + ", rtcInfo=" + r7.a());
            int r14 = f40.a.a;
            CloudGroupLiveTraceEvent r15 = CloudGroupLiveTraceEvent.RTC_MANAGER;
            f40.a.d(r15, "startLink", 0, "rtcRoomId=" + r13 + ", rtcInfo=" + r7.a(), 20);
            String r16 = String.valueOf(r7.a());
            r9.e = r13;
            r9.f = r7.b();
            com.bytedance.android.live.pushstream.d r18 = r9.b;
            if (r18 == null) goto L25;
            String r21 = r18.j1();
            if (r21 == null) goto L25;
        L26:
            JSONObject r22 = new JSONObject(r21).optJSONObject("PushBase");
            if (r22 == null) goto L29;
            int r110 = r22.optInt("width", 0);
        L30:
            Integer r111 = Integer.valueOf(r110);
            if (r22 == null) goto L33;
            int r112 = r22.optInt("height", 0);
        L34:
            Integer r113 = Integer.valueOf(r112);
            if (r22 == null) goto L37;
            int r114 = r22.optInt("fps", 0);
        L38:
            Integer r115 = Integer.valueOf(r114);
            if (r22 == null) goto L41;
            int r23 = r22.optInt("maxBitrate", 0) / 1000;
        L42:
            Integer r24 = Integer.valueOf(r23);
            q1 r25 = new q1(r111, r113, r115, r24);
            ALogger.i("CloudGroupLiveRTCManager", "startLink cdnPushVideoParam " + r25);
            f40.a.d(r15, "getCdnPushVideoParam", 0, "cdnPushVideoParam " + r25, 20);
            int r26 = r111.intValue();
            int r27 = r113.intValue();
            int r28 = r115.intValue();
            int r29 = r24.intValue();
            JSONObject r116 = new JSONObject(r16);
            JSONObject r31 = new JSONObject();
            r31.put("rtc_video_param_mode", 1);
            JSONObject r117 = new JSONObject();
            if (r26 <= 0) goto L45;
            r117.put("width", r26);
        L45:
            if (r27 <= 0) goto L47;
            r117.put("height", r27);
        L47:
            if (r28 <= 0) goto L49;
            r117.put("fps", r28);
        L49:
            if (r29 <= 0) goto L51;
            r117.put("bitrate_kbps", r29);
        L51:
            Unit r32 = Unit.INSTANCE;
            r31.put("rtc_video_param_server_define", r117);
            r116.put("live_rtc_video_param", r31);
            String r33 = r116.toString();
            ALogger.i("CloudGroupLiveRTCManager", "startLink updateRtcExtInfo " + r33);
            f40.a.d(r15, "updateRtcExtInfo", 0, "updateRtcExtInfo " + r33, 20);
            fi6.a r34 = new fi6.a();
            r34.f = new com.bytedance.android.live.cloudgrouplive.rtc.a(String.valueOf(r9.f));
            Room r35 = r9.a;
            if (r35 == null) goto L56;
            StreamUrl r36 = r35.getStreamUrl();
            if (r36 == null) goto L56;
            String r37 = r36.getRtmpPushUrl();
        L57:
            r34.e = r37;
            r34.h(TTMiddlewareLiveSDK.getContext());
            r34.m(r33);
            r34.S = 5;
            Intrinsics.checkNotNullParameter("douyin_live", "key");
            r34.w = "douyin_live";
            r34.g(Character.ANCHOR);
            r34.n(StreamType.VIDEO);
            r34.Z = false;
            ViewType r38 = ViewType.SURFACE_VIEW;
            Intrinsics.checkNotNullParameter(r38, "viewType");
            r34.E = r38;
            r34.O = false;
            r34.P = false;
            IMiddleWareHostContext r39 = jc1.k.f(IMiddleWareHostContext.class);
            if (r39 == null) goto L60;
            String r41 = r39.getChannel();
        L61:
            String r42 = String.valueOf(r41);
            Intrinsics.checkNotNullParameter(r42, "channel");
            r34.y = r42;
            IMiddleWareHostContext r43 = jc1.k.f(IMiddleWareHostContext.class);
            if (r43 == null) goto L64;
            Integer r44 = Integer.valueOf(r43.appId());
        L65:
            String r45 = String.valueOf(r44);
            Intrinsics.checkNotNullParameter(r45, "id");
            r34.z = r45;
            IMiddleWareHostContext r46 = jc1.k.f(IMiddleWareHostContext.class);
            if (r46 == null) goto L68;
            String r47 = r46.getVersionCode();
        L69:
            String r48 = String.valueOf(r47);
            Intrinsics.checkNotNullParameter(r48, "version");
            r34.A = r48;
            IMiddleWareHostContext r49 = jc1.k.f(IMiddleWareHostContext.class);
            if (r49 == null) goto L72;
            Integer r51 = Integer.valueOf(r49.getUpdateVersionCode());
        L73:
            String r52 = String.valueOf(r51);
            Intrinsics.checkNotNullParameter(r52, "version");
            r34.B = r52;
            r34.j(MixStreamType.SERVER_MIX);
            r34.W = false;
            r34.r = true;
            com.bytedance.android.live.pushstream.d r53 = r9.b;
            if (r53 == null) goto L76;
            ei6.a r54 = r53.g1(r34);
        L77:
            r9.c = r54;
            ALogger.i("CloudGroupLiveRTCManager", "startLink create client " + r9.c);
            ei6.a r55 = r9.c;
            if (r55 == null) goto L82;
            gi6.e r56 = r55.getEventManager();
            if (r56 == null) goto L82;
            r56.b((ii6.a) r9.j.getValue());
        L82:
            ei6.a r57 = r9.c;
            if (r57 == null) goto L91;
            si6.b r58 = r57.b();
            if (r58 == null) goto L92;
            si6.a.a(r58, String.valueOf(r9.e), false, 8);
            return;
        L92:
            return;
        L91:
            return;
        L76:
            r54 = null;
            goto L77
        L72:
            r51 = null;
            goto L73
        L68:
            r47 = null;
            goto L69
        L64:
            r44 = null;
            goto L65
        L60:
            r41 = null;
        L56:
            r37 = null;
            goto L57
        L41:
            r23 = 0;
            goto L42
        L37:
            r114 = 0;
            goto L38
        L33:
            r112 = 0;
            goto L34
        L29:
            r110 = 0;
        L25:
            r21 = "{}";
            goto L26
        L20:
            r12 = null;
            goto L21
        L90:
            return;
        L89:
            return;
        }
    }

    public static final class e implements p {
        public e() {
        }

        @Override // a40.p
        public final void b() {
            ALogger.i("CloudGroupLiveManager", "onRejectSuccess");
        }

        @Override // a40.p
        public final void a(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "throwable");
            ALogger.i("CloudGroupLiveManager", "onRejectFailed");
        }
    }

    public static final class f implements com.bytedance.android.live.cloudgrouplive.rtc.c {
        public final /* synthetic */ CloudGroupLiveManager a;

        @Override // com.bytedance.android.live.cloudgrouplive.rtc.c
        public final void b() {
            ALogger.i("CloudGroupLiveManager", "receive onLinkStartSuccess");
            int r1 = f40.a.a;
            f40.a.d(CloudGroupLiveTraceEvent.LIVE_MANAGER, "onLinkStartSuccess", 0, null, 28);
            com.bytedance.android.live.cloudgrouplive.core.d r2 = this.a.l;
            if (r2 == null) goto L5;
            Intrinsics.checkNotNullParameter("success", "<set-?>");
            r2.c = "success";
        L5:
            com.bytedance.android.live.cloudgrouplive.core.d r3 = this.a.l;
            if (r3 == null) goto L8;
            r3.d = System.currentTimeMillis() - this.a.n;
        L8:
            CloudGroupLiveManager r4 = this.a;
            r4.getClass();
            ALogger.i("CloudGroupLiveManager", "start joinCloudGroupLive api");
            k r0 = r4.i;
            if (r0 == null) goto L18;
            d3 r5 = r4.k;
            if (r5 == null) goto L15;
            Long r6 = r5.E();
            if (r6 == null) goto L15;
            long r7 = r6.longValue();
        L16:
            long r8 = r4.d();
            com.bytedance.android.live.cloudgrouplive.core.c r9 = new com.bytedance.android.live.cloudgrouplive.core.c(r4);
            long r11 = SystemClock.elapsedRealtime();
            f40.a.d(CloudGroupLiveTraceEvent.API_MANAGER, "startJoinCloudGroupLive", 0, "cloudGroupLiveRoomId=" + r7 + ", userRoomId=" + r8, 20);
            RxUtilKt.c(((CloudGroupLiveApi) com.bytedance.android.live.network.c.b().e(CloudGroupLiveApi.class)).joinCloudGroupLive(r7, r8).compose(RxUtil.rxSchedulerHelper()).subscribe(new a40.e(r9, r11), new a40.f(r9, r11)), r0.a);
            return;
        L15:
            r7 = 0;
            goto L16
        }

        @Override // com.bytedance.android.live.cloudgrouplive.rtc.c
        public final void e() {
            ALogger.i("CloudGroupLiveManager", "receive onLinkEnd");
            int r0 = f40.a.a;
            f40.a.d(CloudGroupLiveTraceEvent.LIVE_MANAGER, "onLinkEnd", 0, null, 28);
            xs2.b r1 = xs2.b.a();
            d3 r3 = this.a.k;
            if (r3 == null) goto L7;
            Long r4 = r3.E();
            if (r4 == null) goto L7;
            long r5 = r4.longValue();
        L8:
            d3 r6 = this.a.k;
            if (r6 == null) goto L12;
            IBaseUser r7 = r6.getFromUser();
            if (r7 == null) goto L12;
        L13:
            r1.post(new dh1.b(2, new dh1.a(r5, r7, null)));
            return;
        L12:
            r7 = new User();
        L7:
            r5 = 0;
            goto L8
        }

        public f(CloudGroupLiveManager r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.cloudgrouplive.rtc.c
        public final void a(GroupLiveStreamStatus r12) {
            Intrinsics.checkNotNullParameter(r12, "status");
            ALogger.i("CloudGroupLiveManager", "receive onGroupLiveStreamStatusChanged status=" + r12 + " isCloudGroupLiveStart " + this.a.m);
            int r1 = f40.a.a;
            f40.a.d(CloudGroupLiveTraceEvent.LIVE_MANAGER, "onGroupLiveStreamStatusChanged", 0, "status=" + r12 + ", isCloudGroupLiveStart=" + this.a.m, 20);
            CloudGroupLiveManager r2 = this.a;
            if (r2.m == true) goto L5;
            return;
        L5:
            e40.f r3 = r2.g;
            if (r3 == null) goto L34;
            Intrinsics.checkNotNullParameter(r12, "status");
            StringBuilder r0 = new StringBuilder("onGroupLiveStreamStatusChanged status=");
            r0.append(r12);
            r0.append(", status == GroupLiveStreamStatus.STARTED ? ");
            GroupLiveStreamStatus r6 = GroupLiveStreamStatus.STARTED;
            if (r12 != r6) goto L10;
            boolean r7 = true;
        L11:
            r0.append(r7);
            ALogger.i("CloudGroupLiveWindowManager", r0.toString());
            CloudGroupLiveTraceEvent r4 = CloudGroupLiveTraceEvent.WINDOW_MANAGER;
            StringBuilder r8 = new StringBuilder("new stream status = ");
            r8.append(r12);
            r8.append(", group live surfaceview =");
            CloudGroupLiveRTCManager r9 = r3.g;
            SurfaceView r11 = null;
            if (r9 == null) goto L14;
            SurfaceView r13 = r9.g;
        L15:
            r8.append(r13);
            f40.a.d(r4, "onGroupLiveStreamStatusChanged", 0, r8.toString(), 20);
            if (r12 != r6) goto L30;
            StringBuilder r5 = new StringBuilder("onGroupLiveStreamStatusChanged status=");
            r5.append(r12);
            r5.append(", surfaceView=");
            CloudGroupLiveRTCManager r14 = r3.g;
            if (r14 == null) goto L20;
            r11 = r14.g;
        L20:
            r5.append(r11);
            ALogger.i("CloudGroupLiveWindowManager", r5.toString());
            CloudGroupLiveRTCManager r15 = r3.g;
            if (r15 == null) goto L35;
            SurfaceView r16 = r15.g;
            if (r16 == null) goto L36;
            ViewGroup r17 = r3.a;
            if (r17 == null) goto L27;
            r17.removeAllViews();
        L27:
            ViewGroup r18 = r3.a;
            if (r18 == null) goto L37;
            r18.addView(r16);
            return;
        L37:
            return;
        L36:
            return;
        L35:
            return;
        L30:
            ViewGroup r19 = r3.a;
            if (r19 == null) goto L39;
            r19.removeAllViews();
            return;
        L39:
            return;
        L14:
            r13 = null;
            goto L15
        L10:
            r7 = false;
            goto L11
        }

        @Override // com.bytedance.android.live.cloudgrouplive.rtc.c
        public final void d(AnchorGroupLiveStatus r13) {
            Intrinsics.checkNotNullParameter(r13, "status");
            ALogger.i("CloudGroupLiveManager", "receive onAnchorGroupLiveStatusChanged status=" + r13 + " isCloudGroupLiveStart=" + this.a.m);
            int r1 = f40.a.a;
            f40.a.d(CloudGroupLiveTraceEvent.LIVE_MANAGER, "onAnchorGroupLiveStatusChanged", 0, "status=" + r13 + ", isCloudGroupLiveStart=" + this.a.m, 20);
            CloudGroupLiveManager r2 = this.a;
            if (r2.m == true) goto L5;
            return;
        L5:
            e40.f r3 = r2.g;
            if (r3 == null) goto L32;
            Intrinsics.checkNotNullParameter(r13, "status");
            ALogger.i("CloudGroupLiveWindowManager", "onAnchorGroupLiveStatusChanged status=" + r13);
            f40.a.d(CloudGroupLiveTraceEvent.WINDOW_MANAGER, "onAnchorGroupLiveStatusChanged", 0, "new anchor group live status = " + r13, 20);
            e40.a r4 = r3.c;
            if (r4 == null) goto L32;
            Intrinsics.checkNotNullParameter(r13, "status");
            ALogger.i("CloudGroupLivePreviewView", "onAnchorGroupLiveStatusChanged status=" + r13 + ", statusIcon=" + r4.b + ", statusText=" + r4.c);
            int r0 = e40.b.a[r13.ordinal()];
            if (r0 == 1) goto L26;
            if (r0 == 2) goto L20;
            if (r0 != 3) goto L32;
            ImageView r5 = r4.b;
            if (r5 == null) goto L17;
            r5.setImageResource(2131248993);
        L17:
            TextView r6 = r4.c;
            if (r6 == null) goto L32;
            r6.setText(2131915858);
            goto L32
        L20:
            ImageView r7 = r4.b;
            if (r7 == null) goto L23;
            r7.setImageResource(2131248995);
        L23:
            TextView r8 = r4.c;
            if (r8 == null) goto L32;
            r8.setText(2131915859);
            goto L32
        L26:
            ImageView r9 = r4.b;
            if (r9 == null) goto L29;
            r9.setImageResource(2131248994);
        L29:
            TextView r11 = r4.c;
            if (r11 == null) goto L32;
            r11.setText(2131915860);
        L32:
            int r14 = com.bytedance.android.live.cloudgrouplive.core.a.a[r13.ordinal()];
            Long r12 = null;
            if (r14 == 1) goto L57;
            if (r14 == 2) goto L47;
            if (r14 != 3) goto L70;
            d3 r15 = this.a.k;
            if (r15 == null) goto L42;
            IBaseUser r16 = r15.getFromUser();
            if (r16 == null) goto L42;
            String r17 = r16.getUserId();
        L43:
            String r18 = String.valueOf(r17);
            d3 r19 = this.a.k;
            if (r19 == null) goto L46;
            r12 = r19.E();
        L46:
            f40.a.b(r18, String.valueOf(r12), GroupLiveStatus.ING);
            return;
        L42:
            r17 = null;
            goto L43
        L70:
            return;
        L47:
            d3 r110 = this.a.k;
            if (r110 == null) goto L52;
            IBaseUser r111 = r110.getFromUser();
            if (r111 == null) goto L52;
            String r112 = r111.getUserId();
        L53:
            String r113 = String.valueOf(r112);
            d3 r21 = this.a.k;
            if (r21 == null) goto L56;
            r12 = r21.E();
        L56:
            f40.a.b(r113, String.valueOf(r12), GroupLiveStatus.PRE);
            return;
        L52:
            r112 = null;
            goto L53
        L57:
            d3 r114 = this.a.k;
            if (r114 == null) goto L62;
            IBaseUser r115 = r114.getFromUser();
            if (r115 == null) goto L62;
            String r116 = r115.getUserId();
        L63:
            String r117 = String.valueOf(r116);
            d3 r22 = this.a.k;
            if (r22 == null) goto L66;
            r12 = r22.E();
        L66:
            f40.a.b(r117, String.valueOf(r12), GroupLiveStatus.WAIT);
            return;
        L62:
            r116 = null;
            goto L63
        }

        @Override // com.bytedance.android.live.cloudgrouplive.rtc.c
        public final void c(long r5, String r7) {
            ALogger.i("CloudGroupLiveManager", "receive onLinkError, errorCode=" + r5 + ", errorMsg=" + r7);
            int r0 = f40.a.a;
            f40.a.d(CloudGroupLiveTraceEvent.LIVE_MANAGER, "onLinkEnd", 0, "errorCode=" + r5 + ", errorMsg=" + r7, 20);
            f2.b(2131915843, 0);
            this.a.f();
        }

        @Override // com.bytedance.android.live.cloudgrouplive.rtc.c
        public final void f(long r8, String r11) {
            ALogger.i("CloudGroupLiveManager", "receive onLinkStartFail, errorCode=" + r8 + ", errorMsg=" + r11);
            com.bytedance.android.live.cloudgrouplive.core.d r0 = this.a.l;
            if (r0 == null) goto L5;
            String r3 = "errorCode=" + r8 + ", errorMsg=" + r11;
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            r0.c = r3;
        L5:
            com.bytedance.android.live.cloudgrouplive.core.d r1 = this.a.l;
            if (r1 == null) goto L8;
            r1.d = System.currentTimeMillis() - this.a.n;
        L8:
            com.bytedance.android.live.cloudgrouplive.core.d r2 = this.a.l;
            if (r2 == null) goto L11;
            int r4 = f40.a.a;
            f40.a.c(r2);
        L11:
            int r5 = f40.a.a;
            f40.a.d(CloudGroupLiveTraceEvent.LIVE_MANAGER, "onLinkStartFail", 0, "errorCode=" + r8 + ", errorMsg=" + r11, 20);
            f2.b(2131915843, 0);
            this.a.g(CloudGroupLivePipelineStatus.END);
        }
    }

    static {
    }

    public final long d() {
        o r0 = o3.j(this.c);
        if (r0 == null) goto L9;
        m r1 = r0.getRoom();
        if (r1 == null) goto L9;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L9;
        return r2.getRoomId();
    L9:
        return 0;
    }

    public final void f() {
        ALogger.i("CloudGroupLiveManager", "start leaveCloudGroupLive api");
        IMiddlewareUserService r0 = jc1.k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 == null) goto L7;
        IBaseUser r2 = r1.b();
    L8:
        k r3 = this.i;
        if (r3 == null) goto L22;
        d3 r4 = this.k;
        long r5 = 0;
        if (r4 == null) goto L15;
        Long r6 = r4.E();
        if (r6 == null) goto L15;
        long r8 = r6.longValue();
    L16:
        if (r2 == null) goto L20;
        String r7 = r2.getUserId();
        if (r7 == null) goto L20;
        r5 = CastLongProtector.parseLong(r7);
    L20:
        long r11 = r5;
        long r12 = d();
        b r9 = new b(this);
        long r13 = SystemClock.elapsedRealtime();
        int r14 = f40.a.a;
        f40.a.d(CloudGroupLiveTraceEvent.API_MANAGER, "startLeaveCloudGroupLive", 0, "cloudGroupLiveRoomId=" + r8 + ", toUserId=" + r11 + ", toUserRoomId=" + r12, 20);
        RxUtilKt.c(((CloudGroupLiveApi) com.bytedance.android.live.network.c.b().e(CloudGroupLiveApi.class)).leaveCloudGroupLive(r8, r11, r12).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(r9, r13), new h(r9, r13)), r3.a);
        return;
    L15:
        r8 = 0;
        goto L16
    L22:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public CloudGroupLiveManager() {
        this.d = CloudGroupLivePipelineStatus.END;
        this.p = new f(this);
        this.q = new c(this);
    }

    @Override // z30.b
    public final CloudGroupLivePipelineStatus b() {
        return this.d;
    }

    public final Context getContext() {
        return this.a;
    }

    public final void g(CloudGroupLivePipelineStatus r6) {
        ALogger.i("CloudGroupLiveManager", "updateCloudGroupLiveStatus oldStatus=" + this.d + ", newStatus=" + r6);
        int r0 = f40.a.a;
        f40.a.d(CloudGroupLiveTraceEvent.LIVE_MANAGER, "updateCloudGroupLiveStatus", 0, "oldStatus=" + this.d + ", newStatus=" + r6, 20);
        if (this.d != r6) goto L5;
        return;
    L5:
        this.d = r6;
        DataCenter r1 = this.c;
        if (r1 == null) goto L9;
        r1.put("data_cloud_group_live_pipeline_status", r6);
        return;
    }

    @Override // z30.b
    public final void a(boolean r25, String r26) {
        Intrinsics.checkNotNullParameter(r26, "reason");
        ALogger.i("CloudGroupLiveManager", "replyCloudGroupLiveInvite isAccept=" + r25);
        int r3 = f40.a.a;
        f40.a.d(CloudGroupLiveTraceEvent.LIVE_MANAGER, "replyCloudGroupLiveInvite", 0, "isAccept=" + r25, 20);
        if (r25 == false) goto L27;
        this.o = System.currentTimeMillis();
        k r1 = this.i;
        if (r1 == null) goto L51;
        d3 r2 = this.k;
        if (r2 == null) goto L13;
        IBaseUser r4 = r2.getFromUser();
        if (r4 == null) goto L13;
        String r5 = r4.getUserId();
        if (r5 == null) goto L13;
        long r14 = CastLongProtector.parseLong(r5);
    L14:
        d3 r6 = this.k;
        if (r6 == null) goto L19;
        Long r7 = r6.E();
        if (r7 == null) goto L19;
        long r9 = r7.longValue();
    L20:
        d3 r8 = this.k;
        if (r8 == null) goto L25;
        Long r11 = r8.G();
        if (r11 == null) goto L25;
        long r12 = r11.longValue();
    L26:
        long r13 = d();
        d r15 = new d(this);
        long r0 = SystemClock.elapsedRealtime();
        f40.a.d(CloudGroupLiveTraceEvent.API_MANAGER, "startAcceptCloudGroupLive", 0, "invitedUserId=" + r14 + ", cloudGroupLiveRoomId=" + r9 + ", inviteId=" + r12 + ", userRoomId=" + r13, 20);
        RxUtilKt.c(((CloudGroupLiveApi) com.bytedance.android.live.network.c.b().e(CloudGroupLiveApi.class)).acceptCloudGroupLive(r14, r9, r12, r13).compose(RxUtil.rxSchedulerHelper()).subscribe(new a40.a(r15, r0), new a40.b(r15, r0)), r1.a);
        return;
    L25:
        r12 = 0;
    L19:
        r9 = 0;
    L13:
        r14 = 0;
        goto L14
    L51:
        return;
    L27:
        g(CloudGroupLivePipelineStatus.END);
        k r16 = this.i;
        if (r16 == null) goto L53;
        d3 r17 = this.k;
        if (r17 == null) goto L36;
        IBaseUser r18 = r17.getFromUser();
        if (r18 == null) goto L36;
        String r19 = r18.getUserId();
        if (r19 == null) goto L36;
        long r21 = CastLongProtector.parseLong(r19);
    L37:
        d3 r22 = this.k;
        if (r22 == null) goto L42;
        Long r23 = r22.E();
        if (r23 == null) goto L42;
        long r110 = r23.longValue();
    L43:
        d3 r24 = this.k;
        if (r24 == null) goto L48;
        Long r27 = r24.G();
        if (r27 == null) goto L48;
        long r111 = r27.longValue();
    L49:
        long r28 = d();
        e r29 = new e();
        Intrinsics.checkNotNullParameter(r26, "reason");
        long r31 = SystemClock.elapsedRealtime();
        f40.a.d(CloudGroupLiveTraceEvent.API_MANAGER, "startRejectCloudGroupLive", 0, "invitedUserId=" + r21 + ", cloudGroupLiveRoomId=" + r110 + ", inviteId=" + r111 + ", userRoomId=" + r28 + ", reason=" + r26, 20);
        RxUtilKt.c(((CloudGroupLiveApi) com.bytedance.android.live.network.c.b().e(CloudGroupLiveApi.class)).rejectCloudGroupLive(r21, r110, r111, r28, r26).compose(RxUtil.rxSchedulerHelper()).subscribe(new i(r29, r31), new j(r29, r31)), r16.a);
        return;
    L48:
        r111 = 0;
    L42:
        r110 = 0;
    L36:
        r21 = 0;
        goto L37
    }

    public static final void c(CloudGroupLiveManager r3, String r4, String r5) {
        r3.getClass();
        x0.b r0 = new x0.b(r3.a, 4);
        String r1 = s1.B(2131915854);
        x0.d r2 = r0.a;
        r2.c = r1;
        r2.d = r4;
        r0.i(0, 2131915849, com.bytedance.android.live.cloudgrouplive.core.b.a);
        r0.k(0, true);
        r0.n();
        r3.g(CloudGroupLivePipelineStatus.END);
        CloudGroupLiveRTCManager r6 = r3.e;
        if (r6 == null) goto L5;
        r6.f(r5);
    L5:
        d40.a r7 = r3.j;
        if (r7 == null) goto L8;
        r7.b();
    L8:
        e40.f r8 = r3.g;
        if (r8 == null) goto L12;
        r8.a();
        return;
    }

    public final void e(Context r8, DataCenter r9, ViewGroup r11) {
        ALogger.i("CloudGroupLiveManager", "init context=" + r8 + ", dataCenter=" + r9 + ", parentView=" + r11);
        int r0 = f40.a.a;
        f40.a.d(CloudGroupLiveTraceEvent.LIVE_MANAGER, "init", 0, "context=" + r8 + ", dataCenter=" + r9 + ", parentView=" + r11, 20);
        this.a = r8;
        this.b = r11;
        this.c = r9;
        CloudGroupContext r1 = (CloudGroupContext) com.bytedance.live.datacontext.d.a(CloudGroupLiveManager$init$pair$1.INSTANCE).getFirst();
        r1.m536getService().d(this);
        com.bytedance.live.datacontext.b.a(r1, z30.a.class);
        this.f = new CloudGroupLiveMsgManager();
        this.h = new c40.a();
        this.e = new CloudGroupLiveRTCManager();
        this.g = new e40.f(r8, r9, r11, this.e, this);
        this.i = new k();
        this.j = new d40.a(this.i);
        CloudGroupLiveMsgManager r12 = this.f;
        ViewGroup r13 = null;
        if (r12 == null) goto L10;
        if (r9 == null) goto L6;
        Void r14 = (Void) r9.get("data_message_manager", null);
    L7:
        vlc.d r15 = (vlc.d) r14;
        r12.a = r15;
        if (r15 == null) goto L10;
        r15.addMessageListener(MessageType.CLOUD_GROUP_LIVE_MEMBER_ACTION.getKey(), (CloudGroupLiveMsgManager$mOnMessageListener$2.a) r12.c.getValue());
        goto L10
    L6:
        r14 = null;
    L10:
        CloudGroupLiveMsgManager r16 = this.f;
        if (r16 == null) goto L13;
        c r17 = this.q;
        Intrinsics.checkNotNullParameter(r17, "listener");
        r16.b.add(r17);
    L13:
        c40.a r18 = this.h;
        if (r18 == null) goto L22;
        IBaseBrowserService r19 = (IBaseBrowserService) jc1.k.f(IBaseBrowserService.class);
        if (r19 == null) goto L22;
        Observable<Unit> r21 = r19.registerExternalMethodFactory(new c40.b());
        if (r21 == null) goto L22;
        Disposable r22 = r21.subscribe();
        if (r22 == null) goto L22;
        RxUtilKt.c(r22, r18.a);
    L22:
        e40.f r23 = this.g;
        if (r23 == null) goto L36;
        ViewGroup r24 = r23.f;
        if (r24 == null) goto L27;
        ViewGroup r25 = (ViewGroup) r24.findViewById(2131367025);
    L28:
        r23.a = r25;
        ViewGroup r26 = r23.f;
        if (r26 == null) goto L31;
        r13 = (ViewGroup) r26.findViewById(2131367018);
    L31:
        r23.b = r13;
        Context r27 = r23.d;
        if (r27 == null) goto L36;
        e40.a r110 = new e40.a(r27, r23.h);
        r23.c = r110;
        ViewGroup r28 = r23.b;
        if (r28 == null) goto L36;
        r28.addView(r110);
        goto L36
    L27:
        r25 = null;
    L36:
        this.l = new com.bytedance.android.live.cloudgrouplive.core.d();
    }
}
