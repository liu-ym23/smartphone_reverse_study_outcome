package com.bytedance.android.live.liveinteract.revenue.guestlink;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.message.guestlink.LinkChannelMessageType;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget;
import com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.GuestLinkMainPageDialogForAudience;
import com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.GuestLinkMainPageDialogForLinker;
import com.bytedance.android.live.liveinteract.revenue.guestlink.model.GuestLinkJsbType;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.kmp.live.livelink.api.guestlink.model.ChannelFinishReason;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rj0.l;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/guestlink/GuestLinkWidget;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/playmode/AbsPlayModeWidget;", "Lcom/bytedance/android/live/liveinteract/revenue/guestlink/j;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GuestLinkWidget extends AbsPlayModeWidget implements j {
    public static final /* synthetic */ int j = 0;
    public final CompositeDisposable a;
    public GuestLinkMainPageDialogForLinker b;
    public GuestLinkMainPageDialogForAudience c;
    public boolean d;
    public int e;
    public int f;
    public String g;
    public final b h;
    public Dialog i;

    public static final class a {
    }

    public static final class b extends lb6.a {
        public final /* synthetic */ GuestLinkWidget a;

        public final void a() {
            ALogger.e("GuestLinkWidget", "onInitFailed");
            GuestLinkWidget r0 = this.a;
            int r2 = GuestLinkWidget.j;
            r0.yq("onInitFailed", true);
        }

        public final void g() {
            ALogger.i("GuestLinkWidget", "onBothJoinRtcRoomSuccess");
        }

        public final void m() {
            ALogger.e("GuestLinkWidget", "onSelfConnectionStateLostOrFailed");
            GuestLinkWidget r0 = this.a;
            int r2 = GuestLinkWidget.j;
            r0.yq("onSelfConnectionStateLostOrFailed", true);
        }

        public final void n() {
            ALogger.i("GuestLinkWidget", "onCountDownEnd");
            GuestLinkWidget r0 = this.a;
            int r2 = GuestLinkWidget.j;
            r0.yq("onCountDownEnd", true);
            this.a.xq("onCountDownEnd");
        }

        public final void onInitSuccess() {
            ALogger.i("GuestLinkWidget", "onInitSuccess");
        }

        public b(GuestLinkWidget r1) {
            this.a = r1;
        }

        public final void d(String r3) {
            ALogger.i("GuestLinkWidget", "onRemoteRtcUserJoined, rtcUserId: " + r3);
        }

        public final void f(com.bytedance.android.live.base.model.message.guestlink.i r13) {
            Intrinsics.checkNotNullParameter(r13, "msg");
            GuestLinkWidget r0 = this.a;
            int r1 = GuestLinkWidget.j;
            r0.getClass();
            if (r13 == null) goto L61;
            com.bytedance.android.live.liveinteract.multianchor.model.g r14 = (com.bytedance.android.live.liveinteract.multianchor.model.g) r13;
            ALogger.i("GuestLinkWidget", "handleLinkmicGuestLinkMessage, msgType: " + r14.getMsgType());
            int r2 = r14.getMsgType();
            if (r2 != LinkChannelMessageType.LinkmicGuestLink_JoinLinkedChannel.getValue()) goto L41;
            GuestLinkMainPageDialogForAudience r3 = r0.c;
            if (r3 == null) goto L21;
            ALogger.i("GuestLinkMainPageDialogForAudience", "dismissAndLeaveChannel");
            if (r3.isShowing() == false) goto L21;
            com.bytedance.android.live.base.model.message.guestlink.a r4 = r3.T90();
            if (r4 == null) goto L62;
            ALogger.i("GuestLinkMainPageDialogForAudience", "leaveChannel, channelId: " + r4.getChannelId());
            lb6.g r5 = r3.D;
            if (r5 == null) goto L62;
            r5.g(je0.d.a0(), r4.getChannelId(), "dismissAndLeaveChannel", true);
        L62:
            r3.dismiss();     // Catch: Exception -> L17
        L17:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r6 = DialogFragmentLancet.sLastShowStack;
            if (r6 == null) goto L21;
            com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        L21:
            com.bytedance.android.live.base.model.message.guestlink.g r7 = r14.getJoinChannelContent();
            if (r7 == null) goto L64;
            int r8 = vi0.b.a;
            String r9 = String.valueOf(r7.getChannelId());
            String r10 = String.valueOf(yh6.d.a(r14));
            Intrinsics.checkNotNullParameter(r9, "channelId");
            Intrinsics.checkNotNullParameter(r10, "msgId");
            JSONObject r11 = new JSONObject();
            r11.put("channel_id", r9);
            r11.put("msg_id", r10);
            int r12 = rd0.a.a;
            rd0.a.b(MultiTraceData$TraceBusiness.GuestLink, MultiTraceData$TraceEvent.GuestLinkerLink, "guest_link_join_linked_channel_msg_receive", 0, null, r11, 88);
            r0.d = hd0.c.f().h();
            r0.e = hd0.c.f().g;
            cg6.a r15 = r0.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
            if (r15 == null) goto L39;
            hg6.g r16 = r15.getRtcManager();
            if (r16 == null) goto L39;
            ji6.c r17 = r16.o();
            if (r17 == null) goto L39;
            Intrinsics.checkNotNullParameter(r17, "$this$toMain");
            d0 r18 = null;
            if ((r17 instanceof ji6.a) == true) goto L32;
            r17 = null;
        L32:
            ji6.a r19 = (ji6.a) r17;
            if (r19 == null) goto L35;
            r18 = r19.a;
        L35:
            if (r18 == null) goto L39;
            d0.a r20 = r18.getBuilder();
            if (r20 == null) goto L39;
            int r21 = r20.g();
        L40:
            r0.f = r21;
            Observer<Integer> r22 = vi0.c.a;
            MainThreadPostUtils.b(new vi0.e(new f(r7, r0, r14)));
            return;
        L39:
            r21 = 0;
            goto L40
        L64:
            return;
        L41:
            String r23 = "";
            if (r2 != LinkChannelMessageType.LinkmicGuestLink_ChannelFinish.getValue()) goto L51;
            r0.yq("LinkmicGuestLink_ChannelFinish", true);
            r0.xq("LinkmicGuestLink_ChannelFinish");
            int r24 = vi0.b.a;
            String r25 = String.valueOf(yh6.d.a(r14));
            com.bytedance.android.live.base.model.message.guestlink.d r110 = r14.getFinishChannelContent();
            if (r110 == null) goto L49;
            String r111 = r110.getLinkerToast();
            if (r111 == null) goto L49;
            r23 = r111;
        L49:
            vi0.b.c(r25, "LinkmicGuestLink_ChannelFinish", r23);
            return;
        L51:
            if (r2 != LinkChannelMessageType.LinkmicGuestLink_Finish.getValue()) goto L67;
            r0.yq("LinkmicGuestLink_Finish", true);
            r0.xq("LinkmicGuestLink_Finish");
            int r26 = vi0.b.a;
            String r27 = String.valueOf(yh6.d.a(r14));
            com.bytedance.android.live.base.model.message.guestlink.d r112 = r14.getFinishChannelContent();
            if (r112 == null) goto L58;
            String r113 = r112.getLinkerToast();
            if (r113 == null) goto L58;
            r23 = r113;
        L58:
            vi0.b.c(r27, "LinkmicGuestLink_Finish", r23);
            return;
        L67:
            return;
        L61:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.multianchor.model.IMultiLinkmicGuestLinkMessage");
        }

        public final void p(String r9) {
            Intrinsics.checkNotNullParameter(r9, "rtcRoomId");
            ALogger.i("GuestLinkWidget", "onSelfLeaveRtcRoomSuccess");
            int r0 = vi0.b.a;
            Intrinsics.checkNotNullParameter(r9, "channelId");
            JSONObject r6 = new JSONObject();
            r6.put("channel_id", r9);
            int r10 = rd0.a.a;
            rd0.a.b(MultiTraceData$TraceBusiness.GuestLink, MultiTraceData$TraceEvent.GuestLinkerLink, "guest_link_leave_rtc_room_finish", 0, null, r6, 88);
        }

        public final void C2(long r11, ExtraResponse<? extends com.bytedance.android.livesdk.multilink.base.model.guestlink.c, Extra> r13) {
            Intrinsics.checkNotNullParameter(r13, "response");
            super.C2(r11, r13);
            ALogger.i("GuestLinkWidget", "onJoinChannelSuccess");
            int r12 = vi0.b.a;
            com.bytedance.android.live.base.model.message.guestlink.a r14 = ((com.bytedance.android.livesdk.multilink.base.model.guestlink.c) r13.data).getChannelInfo();
            if (r14 == null) goto L6;
            String r15 = String.valueOf(r14.getChannelId());
            if (r15 == null) goto L6;
        L7:
            String r16 = String.valueOf(je0.d.a0());
            int r17 = this.a.e;
            long r0 = System.currentTimeMillis();
            Intrinsics.checkNotNullParameter(r15, "channelId");
            Intrinsics.checkNotNullParameter(r16, "roomId");
            JSONObject r8 = new JSONObject();
            r8.put("channel_id", r15);
            r8.put("room_id", r16);
            r8.put("link_type", r17);
            r8.put("duration", r0);
            int r18 = rd0.a.a;
            rd0.a.b(MultiTraceData$TraceBusiness.GuestLink, MultiTraceData$TraceEvent.GuestLinkerLink, "guest_link_join_linked_channel_api_call", 0, null, r8, 88);
            return;
        L6:
            r15 = "";
            goto L7
        }

        public final void b(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "rtcRoomId");
            Intrinsics.checkNotNullParameter(r4, "rtcUserId");
            ALogger.i("GuestLinkWidget", "onSelfJoinRtcRoomSuccess, rtcRoomId: " + r3 + ", rtcUserId: " + r4);
            int r5 = vi0.b.a;
            System.currentTimeMillis();
            vi0.b.a(r3, "");
        }

        public final void k(String r3, int r4) {
            ALogger.i("GuestLinkWidget", "onRemoteRtcUserLeave, rtcUserId: " + r3 + ", reason:" + r4);
            GuestLinkWidget r5 = this.a;
            int r6 = GuestLinkWidget.j;
            r5.yq("onRemoteRtcUserLeave", true);
        }

        public final void l(String r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "rtcRoomId");
            ALogger.e("GuestLinkWidget", "onSelfJoinRtcRoomFailed: " + r5);
            GuestLinkWidget r0 = this.a;
            int r1 = GuestLinkWidget.j;
            r0.yq("onSelfJoinRtcRoomFailed", true);
            int r2 = vi0.b.a;
            String r6 = String.valueOf(r5);
            System.currentTimeMillis();
            vi0.b.a(r4, r6);
        }

        public final void o1(long r2, Throwable r4) {
            Intrinsics.checkNotNullParameter(r4, "throwable");
            super.o1(r2, r4);
            ALogger.e("GuestLinkWidget", "onJoinChannelFailed", r4);
            GuestLinkWidget r3 = this.a;
            int r5 = GuestLinkWidget.j;
            r3.yq("onJoinChannelFailed", true);
        }

        public final void q(long r2, ExtraResponse<? extends com.bytedance.android.livesdk.multilink.base.model.guestlink.d, Extra> r4) {
            Intrinsics.checkNotNullParameter(r4, "response");
            super.q(r2, r4);
            ALogger.i("GuestLinkWidget", "onLeaveChannelSuccess");
            GuestLinkWidget r3 = this.a;
            int r5 = GuestLinkWidget.j;
            r3.xq("onLeaveChannelSuccess");
        }

        public final void r(long r3, Throwable r5) {
            Intrinsics.checkNotNullParameter(r5, "throwable");
            ALogger.e("GuestLinkWidget", "onFinishChanneFailed", r5);
            super.r(r3, r5);
            GuestLinkWidget r4 = this.a;
            int r6 = GuestLinkWidget.j;
            r4.yq("onFinishChanneFailed", true);
        }

        public final void h(long r3, ExtraResponse<? extends com.bytedance.android.livesdk.multilink.base.model.guestlink.b, Extra> r5, long r6) {
            Intrinsics.checkNotNullParameter(r5, "response");
            Intrinsics.checkNotNullParameter(r5, "response");
            Intrinsics.checkNotNullParameter(r5, "response");
            Intrinsics.checkNotNullParameter(r5, "response");
            ALogger.i("GuestLinkWidget", "onEnterChannelSuccess");
            if (r6 != 3) goto L21;
            GuestLinkWidget r4 = this.a;
            com.bytedance.android.livesdk.multilink.base.model.guestlink.b r7 = (com.bytedance.android.livesdk.multilink.base.model.guestlink.b) r5.data;
            int r8 = GuestLinkWidget.j;
            r4.getClass();
            ALogger.i("GuestLinkWidget", "showMainPageForAudience");
            GuestLinkMainPageDialogForAudience r9 = r4.c;
            if (r9 != null) goto L25;
        L12:
            int r10 = GuestLinkMainPageDialogForAudience.S;
            lb6.g r11 = r4.wq();
            DataCenter r12 = ((Widget) r4).dataCenter;
            Intrinsics.checkNotNullParameter(r7, "enterChannelResponse");
            Intrinsics.checkNotNullParameter(r4, "outerScopeProvider");
            GuestLinkMainPageDialogForAudience r13 = new GuestLinkMainPageDialogForAudience(r4, r12);
            r13.D = r11;
            r13.K = r7;
            r13.L = r12;
            r4.c = r13;
            FragmentActivity r14 = ((Widget) r4).context;
            if (r14 == null) goto L20;
            FragmentManager r15 = r14.getSupportFragmentManager();
            LandscapeRestrictionOperation r16 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r13, "GuestLinkMainPageDialogForAudience", r16);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r15, r13, r16) == true) goto L28;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L22
        L18:
            r13.show(r15, "GuestLinkMainPageDialogForAudience");
            return;
        L28:
            return;
        L20:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        L25:
            r9.dismiss();     // Catch: Exception -> L8
        L8:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r17 = DialogFragmentLancet.sLastShowStack;
            if (r17 == null) goto L12;
            com.bytedance.crash.d.d(r17, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L12
        }

        public final void j(long r3, String r5, ExtraResponse<? extends com.bytedance.android.livesdk.multilink.base.model.guestlink.a, Extra> r6) {
            Intrinsics.checkNotNullParameter(r5, "requestSource");
            Intrinsics.checkNotNullParameter(r6, "response");
            ALogger.i("GuestLinkWidget", "onFinishChannelSuccess, requestSource: " + r5);
            super.j(r3, r5, r6);
            GuestLinkWidget r4 = this.a;
            int r7 = GuestLinkWidget.j;
            r4.yq("onFinishChanneSuccess", true);
            if (Intrinsics.areEqual(ChannelFinishReason.ANCHOR.getRequestSource(), r5) == false) goto L6;
            f2.b(2131917275, 0);
            return;
        L6:
            if (Intrinsics.areEqual(ChannelFinishReason.CLIENT_TIME_OUT.getRequestSource(), r5) == false) goto L9;
            f2.b(2131917278, 0);
            return;
        L9:
            if (Intrinsics.areEqual(ChannelFinishReason.SELF_RTC_EXCEPTION.getRequestSource(), r5) == false) goto L12;
            f2.b(2131917277, 0);
            return;
        L12:
            if (Intrinsics.areEqual(ChannelFinishReason.REMOTE_USER_LEAVE.getRequestSource(), r5) == false) goto L18;
            f2.b(2131917276, 0);
            return;
        }

        public final void o(long r3, Throwable r5, long r6) {
            Intrinsics.checkNotNullParameter(r5, "throwable");
            ALogger.e("GuestLinkWidget", "onEnterChannelFailed", r5);
            super.o(r3, r5, r6);
        }
    }

    static {
    }

    @Override // xh0.b
    public final ArrayList<xh0.f> getIncompatibleSourceList() {
        return null;
    }

    @Override // xh0.b
    public final boolean isOpen() {
        return false;
    }

    @Override // xh0.b
    public final void tryStartPlayMode(HashMap<String, Object> r1) {
    }

    @Override // xh0.b
    public final void tryStopPlayMode(HashMap<String, Object> r1) {
    }

    public static void zq() {
        ALogger.i("GuestLinkWidget", "onApplyTalkRoom");
        sf0.a r1 = new sf0.a(-1, 117, LinkApplyType.GUEST_LINK_AGAIN.getValue(), 0, LinkMatchType.NONE, "", "guest_link_again", 0, 0, 0, false, false, 0, null, null, 0, 524032);
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r2 = IVoiceChatGuestService.a.a();
        if (r2 == null) goto L5;
        ALogger.i("GuestLinkWidget", "onApplyTalkRoom, voiceTalkRoom");
        r2.apply(r1);
    L5:
        l.n2.getClass();
        l r3 = l.a.a();
        if (r3 == null) goto L9;
        ALogger.i("GuestLinkWidget", "onApplyTalkRoom, videoTalkRoom");
        r3.apply(r1);
        return;
    }

    @Override // xh0.b
    public final xh0.h getPlayModeInfo() {
        return new xh0.h(37, s1.B(2131917264));
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        ALogger.i("GuestLinkWidget", "onCreate");
        super.onCreate();
        lb6.g r1 = wq();
        if (r1 == null) goto L5;
        r1.d(this.h, false);
    L5:
        Pair r2 = com.bytedance.live.datacontext.d.a(GuestLinkWidget$initDataContext$pair$1.INSTANCE);
        GuestLinkContext r3 = (GuestLinkContext) r2.getFirst();
        r3.getWidget().d(this);
        com.bytedance.live.datacontext.b.a(r3, i.class);
        this.a.add((Disposable) r2.getSecond());
        lb6.g r4 = wq();
        if (r4 == null) goto L15;
        sb6.a r5 = r4.getLinkState();
        if (r5 == null) goto L15;
        PublishSubject r6 = r5.e;
        if (r6 == null) goto L15;
        Disposable r7 = r6.subscribe(new g(this), h.a);
        if (r7 == null) goto L15;
        RxUtilKt.c(r7, this.a);
    L15:
        if (je0.d.r() == false) goto L17;
        return;
    L17:
        if (vm2.i.e().getNeedToastAfterEnterRoom() == false) goto L32;
        Room r8 = m.j(this).getCurrentRoom();
        if (r8 == null) goto L33;
        z5 r9 = r8.getLinkerDetail();
        if (r9 == null) goto L34;
        List r10 = r9.getPlayModes();
        if (r10 != null) goto L25;
        return;
    L25:
        if (r10.contains(Long.valueOf(37)) != true) goto L36;
        ALogger.i("GuestLinkWidget", "onEnterRoom, show guest link open toast");
        String r0 = vm2.i.e().getEnterRoomToast();
        if (r0 != null) goto L29;
        r0 = s1.B(2131917272);
    L29:
        f2.c(r0, 0);
        return;
    L36:
        return;
    L34:
        return;
    L33:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        ALogger.i("GuestLinkWidget", "onDestroy");
        super.onDestroy();
        yq("onDestroy", false);
        xq("onDestroy");
        Dialog r0 = this.i;
        if (r0 != null) goto L5;
    L25:
        this.a.clear();
        lb6.g r1 = wq();
        if (r1 == null) goto L28;
        r1.b(this.h);
    L28:
        ((Widget) this).dataCenter.put("data_guest_link_changed_list", null);
        return;
    L5:
        if (r0.isShowing() != true) goto L25;
        Dialog r2 = this.i;
        if (r2 == null) goto L25;
        Handler r3 = DialogLancet.resolveDialogHandler(r2);
        if (r3 != null) goto L11;
    L13:
        DialogLancet.beforeDialogDismiss(r2);
        r2.dismiss();     // Catch: Throwable -> L16 Exception -> L18
    L22:
        DialogLancet.afterDialogDismiss(r2);
        goto L25
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
        Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
        if (r4 == null) goto L22;
        com.bytedance.crash.d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r2);
        throw th;
    L11:
        if (Looper.myLooper() == r3.getLooper()) goto L13;
        r3.post(DialogLancet.createDismissRunnable(r2));
        goto L25
    }

    public final lb6.g wq() {
        cg6.a r0 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.W8();
    }

    public GuestLinkWidget() {
        this.a = new CompositeDisposable();
        this.e = 2;
        this.h = new b(this);
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.j
    public final sb6.a getLinkState() {
        lb6.g r0 = wq();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkState();
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.j
    public final void Nk(JsonObject r14) {
        ALogger.i("GuestLinkWidget", "bizExtUpdate, extraInfo: " + r14);
        String r2 = r14.get("type").getAsString();     // Catch: Exception -> L21
        Locale r4 = Locale.ROOT;     // Catch: Exception -> L21
        if (r2 == null) goto L20;
        int r3 = d.a[GuestLinkJsbType.valueOf(r2.toUpperCase(r4)).ordinal()];     // Catch: Exception -> L21
        if (r3 != 1) goto L8;
        long r9 = CastLongProtector.parseLong(r14.get("channel_id_str").getAsString());     // Catch: Exception -> L21
        lb6.g r5 = wq();     // Catch: Exception -> L21
        if (r5 == null) goto L27;
        r5.i(je0.d.a0(), 0, r9, 3);     // Catch: Exception -> L21
        return;
    L27:
        return;
    L8:
        if (r3 != 2) goto L15;
        JsonObject r15 = r14.getAsJsonObject("response");     // Catch: Exception -> L21
        int r6 = r15.getAsJsonObject("raw").get("status_code").getAsInt();     // Catch: Exception -> L21
        String r7 = r15.getAsJsonObject("raw").get("extra").toString();     // Catch: Exception -> L21
        String r16 = r15.getAsJsonObject("raw").getAsJsonObject("data").get("prompts").getAsString();     // Catch: Exception -> L21
        ALogger.i("GuestLinkWidget", "handleServerException: errorCode: " + r6 + ", extra: " + r7 + ", prompt: " + r16);     // Catch: Exception -> L21
        if (r6 != 30010) goto L12;
    L13:
        Throwable r0 = new ApiServerException(r6);     // Catch: Exception -> L21
        r0.setExtra(r7);     // Catch: Exception -> L21
        r0.setPrompt(r16);     // Catch: Exception -> L21
        new qh0.h(2, GuestLinkWidget$bizExtUpdate$1$1.INSTANCE, GuestLinkWidget$bizExtUpdate$1$2.INSTANCE).c(r0);     // Catch: Exception -> L21
        return;
    L12:
        if (r6 == 4004272) goto L13;
        return;
    L15:
        throw new NoWhenBranchMatchedException();     // Catch: Exception -> L21
    L20:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L21
    L21:
        e = move-exception;
        ALogger.e("GuestLinkWidget", "bizExtUpdate, parse error", e);
    }

    public final void xq(String r3) {
        GuestLinkMainPageDialogForAudience r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() != true) goto L19;
        ALogger.i("GuestLinkWidget", "hideMainPageForAudience, source: ".concat(r3));
        GuestLinkMainPageDialogForAudience r4 = this.c;
        if (r4 != null) goto L16;
    L14:
        this.c = null;
        return;
    L16:
        r4.dismiss();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L14;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L14
    }

    public final void yq(String r3, boolean r4) {
        GuestLinkMainPageDialogForLinker r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() != true) goto L33;
        ALogger.i("GuestLinkWidget", "hideMainPageForLinker, source: " + r3 + ", needApplyTalkRoom: " + r4);
        GuestLinkMainPageDialogForLinker r5 = this.b;
        if (r5 != null) goto L30;
    L14:
        this.b = null;
        if (r4 == false) goto L34;
        sb6.a r6 = GuestLinkContext.Companion.a();
        if (r6 == null) goto L20;
        r6.b = false;
    L20:
        if (je0.d.r() == false) goto L23;
        return;
    L23:
        if (this.d == true) goto L25;
        ALogger.i("GuestLinkWidget", "applyTalkRoom return, cause: IsGuestBeforeJoinChannel false");
        return;
    L25:
        this.d = false;
        if (((Boolean) vm2.d.G5.getValue(null, vm2.d.a[342(0x156, float:4.79E-43)])).booleanValue() == false) goto L28;
        MainThreadPostUtils.b(new e(this));
        return;
    L28:
        zq();
        return;
    L34:
        return;
    L30:
        r5.dismiss();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r7 = DialogFragmentLancet.sLastShowStack;
        if (r7 == null) goto L14;
        com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L14
    }
}
