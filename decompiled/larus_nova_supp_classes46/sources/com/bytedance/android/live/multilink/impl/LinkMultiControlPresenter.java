package com.bytedance.android.live.multilink.impl;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.message.ILinkMicBigEventMessage;
import com.bytedance.android.live.base.model.message.b4;
import com.bytedance.android.live.base.model.message.v4;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.InteractGroupDialog;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.videotalk.dialog.LinkmicBePrepareInvitedDialog;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.live.liveinteract.videotalk.ui.theme.VideoLiveThemeReporter;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.liveinteract.widget.widget.LinkUserFollowGuideDialog;
import com.bytedance.android.live.multilink.impl.control.MultiControlService;
import com.bytedance.android.live.multilink.impl.control.anchor.MultiControlAnchorService;
import com.bytedance.android.live.multilink.impl.control.setting.FetchSettingType;
import com.bytedance.android.live.multilink.impl.control.setting.PaidLinkConfigType;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.live.user.api.IUserServiceV2;
import com.bytedance.android.live.user.api.UserSetting;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.model.FastStartKtvVideoModel;
import com.bytedance.android.livesdk.chatroom.model.LinkerPrepareInviteContent;
import com.bytedance.android.livesdk.chatroom.model.LinkerPrepareReplyContent;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.h30;
import com.bytedance.android.livesdk.config.ib0;
import com.bytedance.android.livesdk.config.m20;
import com.bytedance.android.livesdk.config.ue;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.message.model.ILinkmicProfitMessage;
import com.bytedance.android.livesdk.message.model.LinkMicBigEventMessage;
import com.bytedance.android.livesdk.message.model.c7;
import com.bytedance.android.livesdk.message.model.d8;
import com.bytedance.android.livesdk.message.model.gc;
import com.bytedance.android.livesdk.message.model.i9;
import com.bytedance.android.livesdk.message.model.j9;
import com.bytedance.android.livesdk.message.model.k9;
import com.bytedance.android.livesdk.message.model.nj;
import com.bytedance.android.livesdk.message.model.oj;
import com.bytedance.android.livesdk.message.model.y8;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.ILinkerDetailKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerChangeMediaInfoContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerClientUIInfoChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerFollowStrongGuideContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerInvitePrepareContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerInitChatRoomContent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import zg1.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LinkMultiControlPresenter extends com.bytedance.android.livesdk.chatroom.presenter.n<IView> implements vlc.l, LinkUserFollowGuideDialog.a, com.bytedance.android.live.multilink.impl.control.b, com.bytedance.android.live.multilink.impl.control.anchor.d, gn0.a {
    public boolean A;
    public final in0.b e;
    public final in0.a f;
    public final CompositeDisposable g;
    public final MultiControlService h;
    public IRoom i;
    public final boolean j;
    public final LiveMode k;
    public boolean l;
    public final com.bytedance.android.livesdk.chatroom.u m;
    public final gd0.u n;
    public final boolean o;
    public boolean p;
    public FastStartKtvVideoModel q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public final com.bytedance.android.livesdk.chatroom.o w;
    public final com.bytedance.android.livesdk.chatroom.widget.j1 x;
    public final b y;
    public final c z;

    public interface IView extends IWidget {
        void E1(ILinkerClientUIInfoChangeContent r1);

        void Gl(int r1, List<Integer> r2, int r3);

        void I80();

        void JT(com.bytedance.android.livesdk.message.linker.h r1);

        void MV(com.bytedance.android.live.liveinteract.api.data.a r1);

        void Q10(Throwable r1);

        void WO(boolean r1);

        void Wj();

        void Zi(int r1);

        void cj(String r1, boolean r2);

        void d1(com.bytedance.android.livesdk.link.model.bridge.z0 r1);

        void eU(com.bytedance.android.live.liveinteract.api.data.a r1);

        void fV(com.bytedance.android.livesdk.link.model.bridge.z0 r1);

        /* synthetic */ Context getContext();

        int getCurrentMode();

        void nC();

        void wu(int r1, String r2);
    }

    public class a extends com.bytedance.android.live.multilink.impl.control.anchor.a {
        public final /* synthetic */ LinkMultiControlPresenter a;

        public a(LinkMultiControlPresenter r1) {
            this.a = r1;
        }
    }

    public class b implements Observer<Integer> {
        public final /* synthetic */ LinkMultiControlPresenter a;

        public b(LinkMultiControlPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r12) {
            if (((Integer) r12).intValue() != 0) goto L22;
            ALogger.e("ttlive_link", "close video interact and open video talk");
            ((com.bytedance.android.livesdk.chatroom.presenter.n) this.a).c.put("data_need_restore_video_interact", Boolean.TRUE);
            hd0.c.f().e(this.a.y);
            LinkMultiControlPresenter r1 = this.a;
            FastStartKtvVideoModel r13 = r1.q;
            if (r13 != null) goto L7;
            r1.g0(false, 3, false, "", true);
            return;
        L7:
            if (r13.getScene() == null) goto L9;
            int r9 = this.a.q.getScene().intValue();
        L11:
            if (this.a.q.getUiLayout() == null) goto L13;
            int r8 = this.a.q.getUiLayout().intValue();
        L15:
            if (vm2.e.j() == false) goto L17;
        L19:
            this.a.h0(false, false, -1, false, "", true, r8, r9, 0);
            return;
        L17:
            if (com.bytedance.android.livesdk.chatroom.paidlive.e.f(((com.bytedance.android.livesdk.chatroom.presenter.n) this.a).c) == false) goto L19;
            com.bytedance.android.live.core.utils.f2.b(2131921184, 0);
            TalkRoomBusinessFullLinkMonitor.a.getClass();
            TalkRoomBusinessFullLinkMonitor.g0("during_paid_live");
            return;
        L13:
            r8 = -1;
            goto L15
        L9:
            r9 = -1;
            goto L11
        }
    }

    public class c implements Observer<Integer> {
        public final /* synthetic */ LinkMultiControlPresenter a;

        public c(LinkMultiControlPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            if (((Integer) r8).intValue() != 0) goto L6;
            ALogger.e("ttlive_link", "close video interact and open video ktv");
            ((com.bytedance.android.livesdk.chatroom.presenter.n) this.a).c.put("data_need_restore_video_interact", Boolean.TRUE);
            hd0.c.f().e(this.a.z);
            this.a.g0(false, 4, false, "", false);
            return;
        }
    }

    public class d extends com.bytedance.android.live.multilink.impl.control.anchor.b {
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ Runnable b;
        public final /* synthetic */ LinkMultiControlPresenter c;

        public d(LinkMultiControlPresenter r1, Runnable r2, Runnable r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class e implements qh0.d<rh0.a> {
        public final /* synthetic */ long a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ LinkMultiControlPresenter e;

        @Override // qh0.d
        public final void b(BaseCheckException r7) {
            this.e.G0(this.a, this.b, 2, true);
            InteractLinkFullLinkMonitor.e(OperateType.PRE_REPLY.ordinal(), 2, r7);
            TalkRoomBusinessFullLinkMonitor.a.getClass();
            TalkRoomBusinessFullLinkMonitor.U(r7);
            com.bytedance.android.live.liveinteract.plantform.utils.x.K(r7);
        }

        @Override // qh0.d
        public final void onResult(rh0.a r7) {
            this.e.G0(this.a, this.b, this.c, true);
            if (this.c != 1) goto L5;
            ((com.bytedance.android.livesdk.chatroom.presenter.n) this.e).c.put("data_linkmic_close_invite_apply_source", this.d);
        L5:
            InteractLinkFullLinkMonitor.f(OperateType.PRE_REPLY.ordinal(), 2);
            TalkRoomBusinessFullLinkMonitor.a.getClass();
            TalkRoomBusinessFullLinkMonitor.V();
            com.bytedance.android.live.liveinteract.plantform.utils.x.L();
        }

        public e(LinkMultiControlPresenter r1, long r2, String r4, int r5, String r6) {
            this.e = r1;
            this.a = r2;
            this.b = r4;
            this.c = r5;
            this.d = r6;
        }
    }

    public final void t0() {
        g0(true, 0, false, "", false);
    }

    public final void A0() {
        DataCenter r0 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r0 != null) goto L6;
        return;
    L6:
        if (((Integer) r0.get("cmd_init_video_talk_room_with_pending_play_mode", -1)).intValue() < 0) goto L9;
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c.put("cmd_init_video_talk_room_with_pending_play_mode", -1);
        return;
    }

    public final void E0() {
        if (this.A == false) goto L5;
        return;
    L5:
        this.A = true;
        ((SingleSubscribeProxy) ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).getPrepareApplyList(this.i.getRoomId(), "", 8).as(e0())).subscribe(new c0(this), new e0(this));
    }

    public final void I0() {
        ArrayList r3 = new ArrayList();
        com.bytedance.live.datacontext.j r0 = this.m.s();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getValue() == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r1 = ((com.bytedance.android.livesdk.chatroom.viewmodel.f) r0.getValue()).t();
        if (r1 == null) goto L13;
        int r2 = r1.a;
        int r4 = r1.b;
        List r5 = r1.c;
        if (r5 == null) goto L12;
        r3.addAll(r5);
    L12:
        ClientUIInfo r6 = r1.a();
        int r7 = r2;
        int r8 = r4;
    L14:
        ((com.bytedance.android.livesdk.chatroom.viewmodel.f) r0.getValue()).c(new com.bytedance.android.livesdk.chatroom.viewmodel.i(r7, r8, r3, false, false, r6));
        return;
    L13:
        r7 = 0;
        r6 = null;
        r8 = 0;
        goto L14
    }

    public final boolean x0() {
        if (this.m.s() != null) goto L5;
    L11:
        return false;
    L5:
        if (this.m.s().getValue() == null) goto L11;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) this.m.s().getValue()).t() == null) goto L11;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) this.m.s().getValue()).t().a != 9) goto L11;
        return true;
    }

    public final boolean y0() {
        if (this.m.s() != null) goto L5;
    L11:
        return false;
    L5:
        if (this.m.getVideoTalkRoomSubScene().getValue() == null) goto L11;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.e) this.m.getVideoTalkRoomSubScene().getValue()).t() == null) goto L11;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.e) this.m.getVideoTalkRoomSubScene().getValue()).t().a != 0) goto L11;
        return true;
    }

    public final boolean z0() {
        if (this.m.s() != null) goto L5;
    L11:
        return false;
    L5:
        if (this.m.s().getValue() == null) goto L11;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) this.m.s().getValue()).t() == null) goto L11;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) this.m.s().getValue()).t().a != 0) goto L11;
        return true;
    }

    public final void detachView() {
        hd0.c.f().e(this.z);
        hd0.c.f().e(this.y);
        this.g.clear();
        MultiControlService r0 = this.h;
        r0.l.clear();
        gn0.b r1 = r0.j;
        r1.d.clear();
        r1.b = null;
        super.detachView();
    }

    public static void j0(LinkMultiControlPresenter r6) {
        DataCenter r0 = ((com.bytedance.android.livesdk.chatroom.presenter.n) r6).c;
        if (r0 == null) goto L17;
        int r1 = ((Integer) r0.get("cmd_init_video_talk_room_with_pending_play_mode", -1)).intValue();
        if (r1 >= 0) goto L12;
        FastStartKtvVideoModel r2 = r6.q;
        if (r2 == null) goto L12;
        if (r2.getKtvType() == null) goto L12;
        r1 = r6.q.getKtvType().intValue();
        String r3 = r6.q.getEnterMethod();
    L13:
        if (r1 < 0) goto L16;
        ((com.bytedance.android.livesdk.chatroom.presenter.n) r6).c.put("cmd_open_play_mode_after_linkin", new Pair(Integer.valueOf(r1), r3));
        ((com.bytedance.android.livesdk.chatroom.presenter.n) r6).c.put("cmd_init_video_talk_room_with_pending_play_mode", -1);
        return;
    L16:
        return;
    L12:
        r3 = null;
        goto L13
    }

    public static void l0(Throwable r1) {
        if ((r1 instanceof CustomApiServerException) == false) goto L10;
        String r2 = ((CustomApiServerException) r1).getPrompt();
        if (r2 != null) goto L7;
        return;
    L7:
        if (r2.isEmpty() == true) goto L12;
        com.bytedance.android.live.core.utils.f2.c(r2, 0);
        return;
    L12:
        return;
    }

    public final void B0(long r14) {
        if (((q46.b) this).a != null) goto L5;
        return;
    L5:
        a r0 = new a(this);
        MultiControlAnchorService r1 = this.h.d;
        Long r15 = Long.valueOf(r14);
        if (r1.a == true) goto L21;
        r1.a = true;
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.c0("resume_live", 0, 0);
        i97.a r16 = i97.a.a;
        long r2 = System.currentTimeMillis();
        int r17 = eg0.a.a;
        if (r15 != null) goto L14;
        IRoomBase r18 = (IRoom) r1.b.getValue();
        if (r18 == null) goto L13;
        r15 = Long.valueOf(IRoomKtKt.getId(r18));
        goto L14
    L13:
        r15 = null;
    L14:
        an0.b r19 = an0.b.a;
        uz0.c r4 = new uz0.c();
        r19.getClass();
        Intrinsics.checkNotNullParameter(r4, "$this$beforeConfigureRequest");
        Map r110 = ((uz0.a) r4).b;
        Intrinsics.checkNotNullParameter(r110, "queriesMap");
        if (r15 == null) goto L19;
        String r111 = Long.valueOf(r15.longValue()).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r111 == null) goto L19;
        r110.put("room_id", r111);
    L19:
        Intrinsics.checkNotNullParameter(r4, "$this$afterConfigureRequest");
        Observable r112 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).x0(INetworkService.Biz.MultiLink, "/webcast/linkmic_audience/get_linkmic_info_with_rtc_info/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.livesdk.message.linker.h.class)), Extra.class, ((uz0.a) r4).d, ((uz0.a) r4).a, ((uz0.a) r4).b, ((uz0.a) r4).c);
        int r113 = com.bytedance.revenue.platform.api.core.rx.p.a;
        r112.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.multilink.impl.control.anchor.g(r1, r2, r0), new com.bytedance.android.live.multilink.impl.control.anchor.h(r1, r2, r0));
        return;
    }

    public final void C0(PaidLinkConfigType r4) {
        if (((q46.b) this).a == null) goto L14;
        PaidLinkConfigType r0 = PaidLinkConfigType.All;
        if (r4 != r0) goto L7;
    L8:
        com.bytedance.android.live.liveinteract.api.data.a r1 = com.bytedance.android.live.liveinteract.api.data.a.a();
        ((q46.b) this).a.eU(r1);
    L9:
        if (r4 != r0) goto L11;
    L12:
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        com.bytedance.android.live.liveinteract.api.data.a r5 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.k();
        ((q46.b) this).a.MV(r5);
        return;
    L11:
        if (r4 == PaidLinkConfigType.VideoTalk) goto L12;
        return;
    L7:
        if (r4 != PaidLinkConfigType.InteractAudience) goto L9;
    }

    public final void D0(com.bytedance.android.livesdk.link.model.bridge.h1 r13) {
        LinkerInitChatRoomContent r14 = r13.getLinkerInitChatRoomContent();
        ALogger.i("LinkControlPresenter", String.format("onReceivedInitChatRoomMessage, message: %s", new Object[]{r14}));
        if (r14 == null) goto L6;
        h0(false, true, 0, false, "init_chat_room_by_server", false, r14.getUiLayout(), r14.getScene(), r14.getInitSource());
        return;
    }

    public final void L0(boolean r5) {
        boolean r0 = us1.e.a;
        if (us1.e.a(this.i) == true) goto L6;
        return;
    L6:
        if (this.j == false) goto L13;
        IRoom r1 = this.i;
        ALogger.d("VideoRoomPreApplyLinkUtils", "updateAnchorPreApplyLink " + r5);
        if (r1 == null) goto L12;
        z5 r2 = r1.getLinkerDetail();
        if (r2 == null) goto L12;
        r2.setAnchorAcceptAudiencePreApply(r5);
    L12:
        com.bytedance.android.livesdk.sharedpref.e r3 = b6.d;
        Boolean r6 = Boolean.valueOf(r5);
        r3.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r3, r6);
        return;
    L13:
        DataCenter r4 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        IRoom r7 = this.i;
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        if (r7 == null) goto L18;
        z5 r8 = r7.getLinkerDetail();
        if (r8 == null) goto L18;
        r8.setAnchorAcceptAudiencePreApply(r5);
    L18:
        r4.put("data_room_video_talk_integration_accept_audience_prepare_apply", Boolean.valueOf(r5));
        DataCenter r9 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        Boolean r10 = Boolean.FALSE;
        boolean r11 = ((Boolean) r9.get("data_audience_pre_linkmic_waiting", r10)).booleanValue();
        if (r5 == false) goto L21;
        return;
    L21:
        if (((Integer) ((ge1.a) hd0.c.f()).b).intValue() != 1) goto L27;
        if (r11 == false) goto L28;
        hd0.c.f().k(0);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c.put("data_audience_pre_linkmic_waiting", r10);
        return;
    L28:
        return;
    }

    public final /* bridge */ /* synthetic */ void c0(IWidget r1) {
        m0((IView) r1);
    }

    public final void m0(IView r21) {
        super.c0(r21);
        ((ObservableSubscribeProxy) xs2.b.a().b(com.bytedance.android.live.liveinteract.d.class).as(d0())).subscribe(new g(this));
        vlc.d r0 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d;
        if (r0 == null) goto L8;
        r0.addMessageListener(MessageType.LINK_MIC.getWsMethod(), this);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener(MessageType.LINK_SETTING_NOTIFY_MESSAGE.getWsMethod(), this);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener(MessageType.LINKMIC_CHANNEL_NOTIFY.getWsMethod(), this);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener(MessageType.LINK_MIC_GUIDE_MESSAGE.getWsMethod(), this);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener(MessageType.LINKER.getWsMethod(), this);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener(MessageType.VOICE_LIVE_THEME_MESSAGE.getWsMethod(), this);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener(MessageType.LINK_MIC_BIG_EVENT.getWsMethod(), this);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener(MessageType.ROOM_INTRO_MESSAGE.getWsMethod(), this);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener(MessageType.CONTROL.getWsMethod(), this);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener(MessageType.LINK_MIC_PROFIT.getWsMethod(), this);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener(MessageType.LIVE_MATRIX_ENTRANCE_MESSAGE.getWsMethod(), this);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener(MessageType.LINK_MIC_ANNOUNCE.getWsMethod(), this);
        xlc.a r1 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d;
        if ((r1 instanceof xlc.a) == false) goto L8;
        r1.y(MessageType.RESIDENT_GUEST_MESSAGE.getIntType(), this);
    L8:
        if (((Boolean) ib0.a.getValue()).booleanValue() == false) goto L10;
    L20:
        int r9 = 1;
        if (((Boolean) com.bytedance.android.live.core.setting.r2.a.getValue()).booleanValue() == true) goto L23;
    L25:
        boolean r2 = false;
    L26:
        IRoom r3 = this.i;
        if (this.k == LiveMode.THIRD_PARTY) goto L29;
    L34:
        if (r2 == false) goto L36;
    L35:
        boolean r4 = true;
    L37:
        int r5 = J0(r3, r4);
        if (this.j == true) goto L42;
        DataCenter r6 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r6 == null) goto L42;
        r6.put("cmd_enter_room_multil_link_room_mode_sysnc", Integer.valueOf(r5));
    L42:
        this.h.c();
        if (this.j == true) goto L45;
    L47:
        boolean r7 = this.j;
        if (r7 == true) goto L50;
    L52:
        if (r7 == false) goto L54;
    L60:
        ALogger.i("ttlive_link", "room linkMap=" + this.i.getLinkMap() + " " + this.i.getLinkerDetail());
        if (this.i.getLinkMap() == null) goto L68;
        if (this.i.getLinkMap().containsKey(String.valueOf(9)) == false) goto L68;
        if (this.m.I1() == null) goto L68;
        this.m.I1().setValue(Boolean.TRUE);
    L68:
        if (this.j == false) goto L73;
        if (this.i.getLinkInitResult() == null) goto L73;
        com.bytedance.android.live.liveinteract.plantform.utils.i.d(this.i.getLinkInitResult(), "from fast live");
    L73:
        if (this.i.getLinkerDetail() == null) goto L76;
        com.bytedance.android.live.liveinteract.plantform.utils.i.f(this.i.getLinkerDetail());
    L76:
        if (this.j == true) goto L91;
        IRoom r8 = this.i;
        if (r8 != null) goto L80;
    L82:
        String r10 = "";
        String r11 = r10;
    L84:
        if (jc1.k.f(IInteractService.class) == null) goto L87;
        ((IInteractService) jc1.k.f(IInteractService.class)).updateVideoTalkRoomOpenSource(r10);
    L87:
        if ("pre_apply_chat_room".equals(r11) == false) goto L89;
        us1.e.a = true;
        goto L91
    L89:
        us1.e.a = false;
        goto L91
    L80:
        if (r8.getLinkerDetail() == null) goto L82;
        r10 = this.i.getLinkerDetail().getFunctionType2();
        r11 = this.i.getLinkerDetail().getInitSource();
    L91:
        if (this.i.getLinkMap() == null) goto L137;
        boolean r12 = this.i.getLinkMap().containsKey(String.valueOf(5));
        ArrayList r13 = new ArrayList();
        com.bytedance.android.livesdk.chatroom.viewmodel.f.a.getClass();
        Iterator r14 = com.bytedance.android.livesdk.chatroom.viewmodel.f.a.a.iterator();
        int r15 = 0;
    L94:
        if (r14.hasNext() == false) goto L100;
        int r16 = ((Integer) r14.next()).intValue();
        if (r16 == 5) goto L94;
        if (this.i.getLinkMap().containsKey(String.valueOf(r16)) == false) goto L94;
        r15 = r16;
        goto L94
    L100:
        if (r15 != 0) goto L103;
        if (r12 == false) goto L103;
        int r17 = 5;
    L104:
        com.bytedance.android.livesdk.chatroom.u r18 = this.m;
        if (r18 == null) goto L137;
        if (r18.s() == null) goto L137;
        if (this.m.s().getValue() == null) goto L137;
        if (this.i.getLinkInitResult() == null) goto L113;
        long r19 = this.i.getLinkInitResult().getUiLayout();
    L115:
        if (this.i.getLinkerDetail() == null) goto L118;
        r19 = this.i.getLinkerDetail().getUiLayout();
    L118:
        if (this.i.getLinkerDetail() == null) goto L126;
        if (this.i.getLinkerDetail().getPlayModes() == null) goto L126;
        Iterator r20 = this.i.getLinkerDetail().getPlayModes().iterator();
    L123:
        if (r20.hasNext() == false) goto L126;
        r13.add(Integer.valueOf(((Long) r20.next()).intValue()));
    L126:
        if (this.i.getLinkerDetail() == null) goto L132;
        ClientUIInfo r22 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.a.a(this.i.getLinkerDetail().getClientUiInfo());
        StringBuilder r110 = new StringBuilder("attachView, get room clientUIInfo#ui_feature_list data: ");
        if (r22 == null) goto L130;
        List r111 = r22.getUiFeatureList();
    L131:
        r110.append(r111);
        ALogger.d("LinkControlPresenter", r110.toString());
        ClientUIInfo r112 = r22;
    L133:
        I0();
        if (this.m.s() == null) goto L137;
        ((com.bytedance.android.livesdk.chatroom.viewmodel.f) this.m.s().getValue()).d(new com.bytedance.android.livesdk.chatroom.viewmodel.i(r17, (int) r19, r13, false, false, r112));
        goto L137
    L130:
        r111 = null;
        goto L131
    L132:
        r112 = null;
        goto L133
    L113:
        r19 = 0;
    L103:
        r17 = r15;
    L137:
        if (this.i.getLinkInitResult() == null) goto L162;
        com.bytedance.android.livesdk.chatroom.model.interact.j0 r23 = this.i.getLinkInitResult();
        int r24 = this.i.getLinkMicScene();
        com.bytedance.android.live.liveinteract.plantform.utils.i.d(r23, "");
        MultiControlService r25 = this.h;
        r25.getClass();
        Intrinsics.checkNotNullParameter(r23, "initResult");
        jy0.b.c("ttlive_link", "attach initResult=" + r23.getLinkMicId() + " accessToken=" + r23.getAccessToken() + " initScene=" + r24, null, 4);
        String r26 = r23.getAccessToken();
        if (r26 == null) goto L162;
        if (r26.length() <= 0) goto L143;
        boolean r27 = true;
    L144:
        if (r27 != true) goto L162;
        if (r23.getLinkMicId() > 0) goto L154;
        String r28 = r23.getLinkMicIdStr();
        if (r28 == null) goto L162;
        if (r28.length() <= 0) goto L152;
        boolean r29 = true;
    L153:
        if (r29 != true) goto L162;
    L152:
        r29 = false;
    L154:
        MultiControlAnchorService r30 = r25.d;
        r30.getClass();
        Intrinsics.checkNotNullParameter(r23, "initResult");
        if (r24 == 5) goto L159;
        if (r24 == 9) goto L159;
        boolean r31 = false;
    L160:
        r30.c(r23, r31, r24, true, false);
        k0(this, r23, r31, r24, true, false, "", r30.b(r24));
        r25.j.c(FetchSettingType.handleLinkInitResult);
    L159:
        r31 = true;
        goto L160
    L143:
        r27 = false;
    L162:
        if (this.i.getLinkInitResult() == null) goto L164;
    L193:
        IKtvService r32 = jc1.k.f(IKtvService.class);
        if (r32 != null) goto L196;
        return;
    L196:
        if (r32.getKtvComponentStatusChangedObservable() != null) goto L198;
        return;
    L198:
        if (r32.getKtvComponentStatusChangedObservable().a() == null) goto L211;
        this.g.add(r32.getKtvComponentStatusChangedObservable().a().subscribe(new m(this)));
        return;
    L211:
        return;
    L164:
        if (this.w.s2() == null) goto L193;
        if (this.w.s2().getValue() == null) goto L193;
        if (((com.bytedance.android.live.broadcast.api.model.z0) this.w.s2().getValue()).a != null) goto L172;
        if (((com.bytedance.android.live.broadcast.api.model.z0) this.w.s2().getValue()).c == false) goto L193;
    L172:
        if (this.w.s2() == null) goto L193;
        if (this.w.s2().getValue() == null) goto L193;
        if (((com.bytedance.android.live.broadcast.api.model.z0) this.w.s2().getValue()).a == null) goto L178;
    L179:
        Throwable r33 = ((com.bytedance.android.live.broadcast.api.model.z0) this.w.s2().getValue()).a;
        ((com.bytedance.android.live.broadcast.api.model.z0) this.w.s2().getValue()).getClass();
        ((com.bytedance.android.live.broadcast.api.model.z0) this.w.s2().getValue()).getClass();
        ((com.bytedance.android.live.broadcast.api.model.z0) this.w.s2().getValue()).getClass();
        ((com.bytedance.android.live.broadcast.api.model.z0) this.w.s2().getValue()).getClass();
        ((com.bytedance.android.live.broadcast.api.model.z0) this.w.s2().getValue()).getClass();
        LiveMode r34 = LiveMode.AUDIO;
        if (r34 != null) goto L182;
        final int r35 = 0;
    L184:
        if (((com.bytedance.android.live.broadcast.api.model.z0) this.w.s2().getValue()).c == false) goto L190;
        if (r34 != null) goto L187;
        boolean r36 = true;
    L188:
        g0(r36, r35, false, "", false);
        ((com.bytedance.android.live.broadcast.api.model.z0) this.w.s2().getValue()).c = false;
        goto L193
    L187:
        r36 = false;
        goto L188
    L190:
        if (r34 != null) goto L192;
        r9 = 2;
    L192:
        new qh0.h(r9, new m0(this, r35), new n0()).c(r33);
        ((com.bytedance.android.live.broadcast.api.model.z0) this.w.s2().getValue()).a = null;
        goto L193
    L182:
        r35 = 3;
        goto L184
    L178:
        if (((com.bytedance.android.live.broadcast.api.model.z0) this.w.s2().getValue()).c == false) goto L193;
    L54:
        if (gd0.v.a(r5, 2) == false) goto L56;
    L59:
        this.h.j.c(FetchSettingType.Attach);
        goto L60
    L56:
        if (gd0.v.a(r5, 8) == true) goto L59;
        if (gd0.v.a(r5, 32) == false) goto L60;
    L50:
        if (this.k != LiveMode.AUDIO) goto L52;
        this.h.j.b(FetchSettingType.AnchorAudioAttach);
        goto L60
    L45:
        if (vm2.c.e() == false) goto L47;
        this.h.j.b(FetchSettingType.AnchorAttach);
        goto L47
    L36:
        r4 = false;
        goto L37
    L29:
        if (this.w.v1() == null) goto L34;
        if (this.w.v1().getValue() == null) goto L34;
        if (((Boolean) this.w.v1().getValue()).booleanValue() == true) goto L35;
    L23:
        if (this.j == false) goto L25;
        r2 = true;
        goto L26
    L10:
        if (((com.bytedance.android.livesdk.chatroom.presenter.n) this).c == null) goto L20;
        IRoom r37 = this.i;
        if (r37 == null) goto L20;
        if (r37.getLinkerDetail() == null) goto L20;
        if (this.i.getLinkerDetail().getPlayModes() == null) goto L20;
        if (this.i.getLinkerDetail().getPlayModes().size() <= 0) goto L20;
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c.put("key_order_song_first_load", Boolean.valueOf(this.i.getLinkerDetail().getPlayModes().contains(19L)));
        goto L20
    }

    public void onEvent(com.bytedance.android.live.liveinteract.d r3) {
        IView r0 = ((q46.b) this).a;
        if (r0 != null) goto L5;
        return;
    L5:
        int r4 = r3.a;
        if (r4 != 1) goto L8;
        r0.Wj();
        return;
    L8:
        if (r4 == 4) goto L11;
        return;
    L11:
        if (this.j == true) goto L13;
        return;
    L13:
        if (r0.getCurrentMode() != 0) goto L22;
        boolean r5 = us1.e.a;
        if (us1.e.c(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, this.i, this.j) == true) goto L17;
        return;
    L17:
        if (this.k != LiveMode.VIDEO) goto L24;
        u0("pre_apply");
        return;
    L24:
        return;
    }

    public final void onMessage(tlc.d r23) {
        if (((q46.b) this).a != null) goto L5;
        return;
    L5:
        boolean r6 = false;
        boolean r7 = false;
        r7 = false;
        r7 = false;
        r7 = false;
        boolean r8 = false;
        int r9 = 0;
        r9 = 0;
        r9 = 0;
        if ((r23 instanceof com.bytedance.android.livesdk.link.model.bridge.z0) == false) goto L14;
        com.bytedance.android.livesdk.link.model.bridge.z0 r0 = (com.bytedance.android.livesdk.link.model.bridge.z0) r23;
        int r1 = (int) r0.getType2();
        if (r1 != 18) goto L10;
    L12:
        ALogger.i("LinkControlPresenter", String.format("onReceivedGameRtcRoomMessage, messageType: %s", new Object[]{Long.valueOf(r0.getType2())}));
        r0.getType2();
        r0.getType2();
        return;
    L10:
        if (r1 == 19) goto L12;
        return;
    L14:
        if ((r23 instanceof y8) == false) goto L42;
        int r2 = ((y8) r23).getIntType();
        ALogger.d("ttlive_multi_mic_room", "received mic room channel notify msg : type " + r2);
        if (r2 == 1) goto L18;
        return;
    L18:
        if (this.j == true) goto L20;
        return;
    L20:
        if (jc1.k.f(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().getChannelId() != 0) goto L552;
        int r3 = ((q46.b) this).a.getCurrentMode();
        ALogger.d("ttlive_multi_mic_room", "current mode is " + r3);
        if (r3 == 0) goto L40;
        if (r3 != 32) goto L689;
        com.bytedance.live.datacontext.j r4 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r4 == null) goto L34;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r4.getValue();
        if (r5 == null) goto L34;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r10 = r5.t();
        if (r10 == null) goto L34;
        if (r10.c != 7) goto L34;
        r7 = true;
    L34:
        int r11 = je0.d.R();
        ALogger.d("ttlive_multi_mic_room", "onlineGuestCount " + r11 + " isDynamicFloatWindow " + r7);
        if (r11 != 0) goto L553;
        if (r7 == true) goto L554;
        rj0.k.m2.getClass();
        rj0.k r12 = rj0.k.a.a();
        if (r12 == null) goto L555;
        tc0.c.h().g = true;
        r12.Cl(8, 7, "mic_room", true, true);
        ALogger.d("ttlive_multi_mic_room", "switch to dynamic window in video talk");
        return;
    L555:
        return;
    L554:
        return;
    L553:
        return;
    L689:
        return;
    L40:
        tc0.c.h().g = true;
        ALogger.d("ttlive_multi_mic_room", "init video talk room with dynamic window");
        h0(false, true, 3, false, "auto", true, 7, 8, 0);
        return;
    L552:
        return;
    L42:
        if ((r23 instanceof ILinkMicGuideMessageBridge) == false) goto L66;
        ILinkMicGuideMessageBridge r13 = (ILinkMicGuideMessageBridge) r23;
        long r14 = r13.getGuidelineType();
        if (r14 != 3) goto L50;
        if (this.j == false) goto L48;
        return;
    L48:
        ((q46.b) this).a.nC();
        return;
    L50:
        if (r14 != 5) goto L57;
        c7 r15 = r13.getCreateGroupChatGuideContent();
        InteractGroupDialog r16 = new InteractGroupDialog(((q46.b) this).a.getContext(), true, r15.getHeaderText(), r15.getBodyText(), null, "", "");
        if (DialogLancet.shouldBlockDialogShow(r16) == false) goto L547;
        DialogLancet.handleBlockedDialogShow(r16);
        return;
    L547:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L538
    L55:
        DialogLancet.beforeDialogShow(r16);
        r16.show();
        DialogLancet.afterDialogShow(r16);
        return;
    L57:
        if (r14 != 6) goto L561;
        d8 r17 = r13.getJoinGroupChatGuideContent();
        if (r17.getGroup_type() != ILinkMicGuideMessageBridge.GroupType.KtvGroup.getValue()) goto L61;
        return;
    L61:
        InteractGroupDialog r18 = new InteractGroupDialog(((q46.b) this).a.getContext(), false, r17.getHeaderText(), r17.getBodyText(), r17.getIconsList(), r17.getConversationID(), r17.getConversationShortID().toString());
        if (DialogLancet.shouldBlockDialogShow(r18) == false) goto L541;
        DialogLancet.handleBlockedDialogShow(r18);
        return;
    L541:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L539
    L65:
        DialogLancet.beforeDialogShow(r18);
        r18.show();
        DialogLancet.afterDialogShow(r18);
        return;
    L561:
        return;
    L66:
        MultiControlAnchorService r19 = null;
        if ((r23 instanceof com.bytedance.android.livesdk.link.model.bridge.h1) == false) goto L252;
        com.bytedance.android.livesdk.link.model.bridge.h1 r110 = (com.bytedance.android.livesdk.link.model.bridge.h1) r23;
        int r20 = (int) r110.getType2();
        if (this.j == true) goto L83;
        String r21 = jc1.k.f(IMiddlewareUserService.class).user().n();
        if (r20 == 2) goto L79;
        if (r20 == 13) goto L79;
        if (r20 == 7) goto L76;
    L78:
        boolean r22 = false;
    L80:
        if (r22 == false) goto L83;
        xs2.b.a().post(new k42.d());
        goto L83
    L76:
        if (r110.getLeave() == null) goto L78;
        r22 = Objects.equals(r21, r110.getLeave().getUserIdStr());
    L79:
        r22 = true;
    L83:
        if (r110.getType2() != 27) goto L95;
        if (((Boolean) vm2.c.l.getValue(null, vm2.c.a[10])).booleanValue() == true) goto L87;
        return;
    L87:
        if (this.p == true) goto L565;
        this.p = true;
        LinkUserFollowGuideDialog r24 = new LinkUserFollowGuideDialog(((q46.b) this).a.getContext(), ((q46.b) this).a, r110.getMFollowStrongGuideContent(), this.n, this);
        if (DialogLancet.shouldBlockDialogShow(r24) == false) goto L545;
        DialogLancet.handleBlockedDialogShow(r24);
    L93:
        ILinkerFollowStrongGuideContent r25 = r110.getMFollowStrongGuideContent();
        HashMap r26 = new HashMap();
        int r27 = ((IInteractService) jc1.k.f(IInteractService.class)).getCurrentScene();
        TalkRoomLogUtils.I0(r26, r27);
        TalkRoomLogUtils.z0(r26, Integer.valueOf(r27));
        TalkRoomLogUtils.f1(r26, r25.getFromUserType());
        r26.put("action_type", "click");
        r26.put("to_user_id", r25.getUser().getIdString());
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_guest_connection_follow_popup_show", r26, new Object[]{new am2.x(), IRoom.class});
        return;
    L545:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L540
    L92:
        DialogLancet.beforeDialogShow(r24);
        r24.show();
        DialogLancet.afterDialogShow(r24);
        goto L93
    L565:
        return;
    L95:
        if (r110.getType2() == 35) goto L97;
    L109:
        String r28 = "";
        if (r110.getType2() != 39) goto L112;
    L238:
        ILinkerInvitePrepareContent r29 = r110.getLinkerInvitePrepareContent();
        if (r29 == null) goto L614;
        boolean r30 = this.j;
        if (r30 == false) goto L615;
        boolean r31 = us1.e.a;
        if (us1.e.c(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, this.i, r30) == true) goto L245;
        return;
    L245:
        if (r29.getCount() > 0) goto L247;
    L250:
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c.put("data_video_talk_dot_with_number_show", r28);
        Intrinsics.checkNotNullParameter(r28, "<set-?>");
        us1.e.e = r28;
        return;
    L247:
        if (r29.getCount() <= 99) goto L249;
        r28 = "99+";
        goto L250
    L249:
        r28 = String.valueOf(r29.getCount());
        goto L250
    L615:
        return;
    L614:
        return;
    L112:
        if (r110.getType2() == 40) goto L238;
        if (r110.getType2() != 46) goto L125;
        int r32 = ((q46.b) this).a.getCurrentMode();
        if (gd0.v.a(r32, 32) == false) goto L119;
    L120:
        DataCenter r33 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r33 == null) goto L123;
        tc0.c.i((String) r33.get("data_room_unique_id", "")).O = r110.getLinkerResumeAudienceContent();
        return;
    L123:
        tc0.c.h().O = r110.getLinkerResumeAudienceContent();
        return;
    L119:
        if (gd0.v.a(r32, 2) == true) goto L120;
        return;
    L125:
        if (r110.getType2() != 53) goto L196;
        ILinkerChangeMediaInfoContent r34 = r110.getLinkerChangeMediaInfoContent();
        if (r34 == null) goto L691;
        boolean r35 = r34.getPlayModeList().contains(21);
        LiveMode r36 = this.k;
        if (r36 != LiveMode.AUDIO) goto L162;
        if (z0() == false) goto L152;
        com.bytedance.android.livesdk.chatroom.o r37 = this.w;
        if (r37 != null) goto L136;
        return;
    L136:
        if (r37.getLiveStream() != null) goto L138;
        return;
    L138:
        if (this.j == false) goto L576;
        if (r35 == true) goto L141;
        return;
    L141:
        if (r34.getLinkmicMediaParam() != null) goto L143;
        return;
    L143:
        if (r34.getLinkmicMediaParam().getKtvComponentMediaInfo() != null) goto L145;
        return;
    L145:
        if (r34.getLinkmicMediaParam().getKtvComponentMediaInfo().getLiveCoreExtInfo() == null) goto L580;
        com.bytedance.android.live.pushstream.d r38 = (com.bytedance.android.live.pushstream.d) this.w.getLiveStream().getValue();
        if (r38.A() != null) goto L149;
        return;
    L149:
        if (r38.A().getBuilder() == null) goto L582;
        this.r = r38.A().getBuilder().f0();
        uf2.d0 r39 = r38.A();
        r34.getLinkmicMediaParam().getKtvComponentMediaInfo().getLiveCoreExtInfo();
        r39.A();
        return;
    L582:
        return;
    L580:
        return;
    L576:
        return;
    L152:
        if (this.j == false) goto L157;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() == null) goto L156;
        com.bytedance.android.live.liveinteract.voicechat.d.a.a().onChangeMediaInfo(r34, this.r);
        this.r = -1;
    L156:
        jc1.k.f(IKtvService.class).onChangeMediaInfo(r34, this.r);
        return;
    L157:
        IVoiceChatGuestService.Companion.getClass();
        if (IVoiceChatGuestService.a.a() == null) goto L160;
        IVoiceChatGuestService.a.a().onChangeMediaInfo(r34, this.r);
        this.r = -1;
    L160:
        jc1.k.f(IKtvService.class).onChangeMediaInfo(r34, this.r);
        return;
    L162:
        if (r36 == LiveMode.VIDEO) goto L164;
        return;
    L164:
        if (y0() == false) goto L188;
        com.bytedance.android.livesdk.chatroom.o r40 = this.w;
        if (r40 != null) goto L168;
        return;
    L168:
        if (r40.getLiveStream() != null) goto L170;
        return;
    L170:
        if (this.j == false) goto L589;
        if (r35 == true) goto L173;
        return;
    L173:
        if (r34.getLinkmicMediaParam() != null) goto L175;
        return;
    L175:
        if (r34.getLinkmicMediaParam().getKtvComponentMediaInfo() != null) goto L177;
        return;
    L177:
        if (r34.getLinkmicMediaParam().getKtvComponentMediaInfo().getLiveCoreExtInfo() == null) goto L593;
        com.bytedance.android.live.pushstream.d r41 = (com.bytedance.android.live.pushstream.d) this.w.getLiveStream().getValue();
        if (r41 != null) goto L181;
        return;
    L181:
        if (r41.A() != null) goto L183;
        return;
    L183:
        if (r41.A().getBuilder() == null) goto L596;
        this.r = r41.A().getBuilder().f0();
        uf2.d0 r42 = r41.A();
        r34.getLinkmicMediaParam().getKtvComponentMediaInfo().getLiveCoreExtInfo();
        r42.A();
        IFeatureService r43 = jc1.k.f(IFeatureService.class);
        if (r43 == null) goto L597;
        r43.getFeatureManager().i("is_strategy_support_scene", Boolean.FALSE, FeatureType.MONITOR);
        return;
    L597:
        return;
    L596:
        return;
    L593:
        return;
    L589:
        return;
    L188:
        if (this.j == false) goto L192;
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L599;
        rj0.k.a.a().onChangeMediaInfo(r34, this.r);
        this.r = -1;
        return;
    L599:
        return;
    L192:
        rj0.l.n2.getClass();
        if (rj0.l.a.a() == null) goto L601;
        rj0.l.a.a().onChangeMediaInfo(r34, this.r);
        this.r = -1;
        return;
    L601:
        return;
    L691:
        return;
    L196:
        if (r110.getType2() != 57) goto L199;
        q0(r110);
        return;
    L199:
        if (r110.getType2() != 58) goto L202;
        r0(r110);
        return;
    L202:
        if (r110.getType2() != 67) goto L205;
        D0(r110);
        return;
    L205:
        if (r110.getType2() != 68) goto L213;
        if (r110.getAudienceWaitingListChangeContent() == null) goto L606;
        tc0.c r44 = tc0.c.h();
        int r45 = r110.getAudienceWaitingListChangeContent().getTotalWaitingCount();
        if ("waiting_list_change_message" != "apply") goto L211;
        r44.i = r45;
    L211:
        r44.h = r45;
        return;
    L606:
        return;
    L213:
        if (r110.getType2() == 71) goto L215;
        return;
    L215:
        if (((Boolean) h30.a.getValue()).booleanValue() == true) goto L220;
        if (((Boolean) m20.a.getValue()).booleanValue() == true) goto L220;
        return;
    L220:
        if (r110.getLinkerClientUIInfoChangeContent() != null) goto L222;
    L226:
        ALogger.e("LinkControlPresenter", "CLIENT_UI_INFO_CHANGE, new data is null");
    L228:
        if (this.i.isLiveTypeAudio() == false) goto L231;
        ((q46.b) this).a.E1(r110.getLinkerClientUIInfoChangeContent());
        return;
    L231:
        if (this.j == false) goto L235;
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L610;
        rj0.k.a.a().u5(r110.getLinkerClientUIInfoChangeContent());
        return;
    L610:
        return;
    L235:
        rj0.l.n2.getClass();
        if (rj0.l.a.a() == null) goto L612;
        rj0.l.a.a().u5(r110.getLinkerClientUIInfoChangeContent());
        return;
    L612:
        return;
    L222:
        if (r110.getLinkerClientUIInfoChangeContent().getClientUIInfo() == null) goto L226;
        if (r110.getLinkerClientUIInfoChangeContent().getClientUIInfo().getUiFeatureList() == null) goto L226;
        ALogger.d("LinkControlPresenter", "CLIENT_UI_INFO_CHANGE, new clientUIInfo#uiFeatureList data: " + r110.getLinkerClientUIInfoChangeContent().getClientUIInfo().getUiFeatureList());
        goto L228
    L97:
        if (this.j == false) goto L99;
    L100:
        com.bytedance.android.livesdk.message.linker.j r46 = r110.getLinkerDegradeAlertContent();
        if (r46 == null) goto L567;
        String r47 = r46.getDegrade_content();
        if (TextUtils.isEmpty(r47) == true) goto L568;
    L108:
        ALogger.e(LinkMultiControlPresenter.class.getName(), "strDegradeContent parse json error");
        return;
    L105:
        if ("ktv_singing_alert".equals(new JSONObject(r47).optString("key")) == false) goto L569;
        com.bytedance.android.live.core.utils.f2.c("检测到当前演唱嘉宾卡顿严重，是否先切歌并提醒他稍后再试？", 0);     // Catch: JSONException -> L108
        return;
    L569:
        return;
    L568:
        return;
    L567:
        return;
    L99:
        if (jc1.k.f(IMiddlewareUserService.class).user().c() == false) goto L109;
    L252:
        if ((r23 instanceof gc) == false) goto L275;
        gc r48 = (gc) r23;
        if (r48.getVoiceLiveTheme() != null) goto L256;
    L260:
        x00.a r49 = ((IInteractService) jc1.k.f(IInteractService.class)).getThemeManager(this.j, ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c);
        if (r49 != null) goto L263;
        return;
    L263:
        if (r48.getVoiceLiveTheme() != null) goto L265;
        return;
    L265:
        if (r48.getBgType() != 3) goto L267;
    L268:
        ALogger.i("[VideoTalk]LinkControlPresenter", "IM,type:" + r48.getBgType() + ",theme:" + r48.getVoiceLiveTheme());
        IVoiceLiveTheme r50 = r48.getVoiceLiveTheme();
        if (r50 == null) goto L621;
        r50.setFromPush(true);
        r49.c(r48.getVoiceLiveTheme(), r48.getBgType());
        if (this.j == false) goto L273;
        r49.l(r48.getBgType());
    L273:
        this.i.setVoiceLiveTheme(r50);
        return;
    L621:
        return;
    L267:
        if (r48.getBgType() == 4) goto L268;
        return;
    L256:
        if (r48.getVoiceLiveTheme().isRealTimeChorusTheme() == false) goto L260;
        if (vm2.c.k() == false) goto L260;
        r48.setBgType(100);
        r48.getVoiceLiveTheme().setBgType(100);
        goto L260
    L275:
        if ((r23 instanceof com.bytedance.android.live.base.model.message.d2) == false) goto L471;
        com.bytedance.android.live.base.model.message.d2 r51 = (com.bytedance.android.live.base.model.message.d2) r23;
        if (vm2.e.f() == true) goto L692;
        int r52 = nd0.g.a;
        Intrinsics.checkNotNullParameter(r51, MultiLinkOpenSource.MESSAGE);
        JSONObject r53 = new JSONObject();
        r53.put("msg_id", r51.getMessageId());
        int r54 = r51.getMsgType();
        Object r55 = "null";
        if (r54 == 1) goto L289;
        if (r54 == 2) goto L288;
        if (r54 != 3) goto L293;
        r53.put("big_event_type", "switch");
        v4 r56 = r51.getSwitch_scene_content();
        if (r56 == null) goto L287;
        r55 = Integer.valueOf(r56.getTargetMode());
    L287:
        r53.put("switch_target_mode", r55);
        nd0.c.o(nd0.c.a, LinkMonitorData.ReceiveBigEventMsgMonitorData, r53, 0, null, false, 28);
    L293:
        int r57 = r51.getMsgType();
        if (r57 == 1) goto L422;
        if (r57 == 2) goto L406;
        if (r57 == 3) goto L347;
        if (r57 == 4) goto L340;
        if (r57 == 13) goto L336;
        switch(r57) {
            case 17: goto L325;
            case 18: goto L321;
            case 19: goto L302;
            default: goto L693;
        };
    L302:
        LinkMicBigEventMessage.b r58 = r51.getSendSignalContent();
        if (r58 == null) goto L623;
        int r59 = r58.type;
        ALogger.e("ttlive_link", "handleSendSignalBigEvent");
        cg6.a r60 = this.x.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r60 == null) goto L624;
        hg6.g r61 = r60.getRtcManager();
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r62 = ((IInteractService) jc1.k.f(IInteractService.class)).getLinkUserInfoCenter();
        if (r61 != null) goto L309;
        return;
    L309:
        if (r59 != LinkMicBigEventMessage.BigEventSendSignalType.BigEventSendSignalTypeBackground.getValue()) goto L315;
        if (r61.isEngineOn() == false) goto L626;
        if (r62 == null) goto L627;
        r62.v();
        return;
    L627:
        return;
    L626:
        return;
    L315:
        if (r59 == LinkMicBigEventMessage.BigEventSendSignalType.BigEventSendSignalTypeFrondend.getValue()) goto L317;
        return;
    L317:
        if (r61.isEngineOn() == false) goto L630;
        r61.onResume();
        if (r62 == null) goto L631;
        r62.r0();
        return;
    L631:
        return;
    L630:
        return;
    L624:
        return;
    L623:
        return;
    L321:
        ALogger.e("ttlive_link", "handleTurnOverCameraBigEvent");
        IInteractService r63 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r63 == null) goto L633;
        r63.forceReverseCamera();
        return;
    L633:
        return;
    L693:
        return;
    L325:
        if (r51.getSwitch_user_status_content() == null) goto L635;
        long r65 = this.i.getRoomId();
        final String r66 = jc1.k.f(IMiddlewareUserService.class).user().n();
        if (r51.getSwitch_user_status_content().getUserStatusType() != LinkMicBigEventMessage.SwitchUserStatusContent.UserStatusType.Silence.getValue()) goto L333;
        if (this.v == true) goto L694;
        this.v = true;
        final long r67 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.V(r66);
        ((SingleSubscribeProxy) ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).silence(r65, r66, r66).as(e0())).subscribe(new p(this, r66, r67), new q(this, r66, r67));
        return;
    L694:
        return;
    L333:
        if (r51.getSwitch_user_status_content().getUserStatusType() != LinkMicBigEventMessage.SwitchUserStatusContent.UserStatusType.UnSilence.getValue()) goto L637;
        K0(r65, r66);
        return;
    L637:
        return;
    L635:
        return;
    L336:
        if (jc1.k.f(IKtvService.class) != null) goto L338;
        return;
    L338:
        if (r51.getPrepareDownloadSongMaterialsContent() == null) goto L640;
        jc1.k.f(IKtvService.class).prepareDownloadSongMaterials(r51.getPrepareDownloadSongMaterialsContent().getMusicList());
        return;
    L640:
        return;
    L340:
        IKtvService r68 = jc1.k.f(IKtvService.class);
        if (r68 != null) goto L343;
        return;
    L343:
        if (r51.getSwitch_earphone_monitor_content().getTo_status() == 2) goto L345;
        r8 = true;
    L345:
        r68.enableHardwareEcho(r8);
        return;
    L347:
        if (this.j == true) goto L350;
        return;
    L350:
        if (r51.getSwitch_scene_content() == null) goto L644;
        int r69 = r51.getSwitch_scene_content().getTargetMode();
        Pair r70 = ILinkMicBigEventMessage.-CC.targetModeTransParam(r69);
        int r71 = ((Integer) r70.getFirst()).intValue();
        int r72 = ((Integer) r70.getSecond()).intValue();
        ALogger.d("ttlive_link", "big_event switch scene target_mode:" + r69 + " toScene:" + r71 + " toUILayout:" + r72);
        LiveMode r73 = this.k;
        if (r73 != LiveMode.VIDEO) goto L376;
        rj0.k.m2.getClass();
        rj0.k r74 = rj0.k.a.a();
        if (r74 != null) goto L357;
        return;
    L357:
        if (r72 == 63) goto L697;
        DataCenter r75 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r75 == null) goto L363;
        r75.put("cmd_enable_video_chorus_in_critical", Boolean.FALSE);
    L363:
        if (this.m.s() != null) goto L365;
    L374:
        r74.T1(r71, null, "bigevent");
        return;
    L365:
        if (this.m.getVideoTalkRoomSubScene().hasValue() == false) goto L374;
        if (this.m.getVideoTalkRoomSubScene().getValue() == null) goto L374;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.e) this.m.getVideoTalkRoomSubScene().getValue()).t() == null) goto L374;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.e) this.m.getVideoTalkRoomSubScene().getValue()).t().a != r71) goto L373;
        r74.j6(Arrays.asList(new Integer[]{3, 16}).contains(Integer.valueOf(r69)), "bigEventMsg");
        return;
    L373:
        r74.T1(r71, Integer.valueOf(r72), "bigevent");
        return;
    L697:
        return;
    L376:
        if (r73 == LiveMode.AUDIO) goto L378;
        return;
    L378:
        if (this.m.s() == null) goto L393;
        if (this.m.s().hasValue() == false) goto L393;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) this.m.s().getValue()).t() == null) goto L393;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) this.m.s().getValue()).t().a != 5) goto L393;
        if (r71 != 5) goto L393;
        if (r69 != 15) goto L388;
        int r76 = 22;
    L390:
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L649;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().ld(5, 5, r76, "bigevent");
        return;
    L649:
        return;
    L388:
        r76 = je0.d.o();
    L393:
        if (this.m.s() == null) goto L400;
        if (this.m.s().getValue() == null) goto L400;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) this.m.s().getValue()).t() == null) goto L400;
        r9 = ((com.bytedance.android.livesdk.chatroom.viewmodel.f) this.m.s().getValue()).t().a;
    L400:
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L402;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().ld(r9, r71, r72, "bigevent");
    L402:
        IKtvService r77 = jc1.k.f(IKtvService.class);
        if (r77 == null) goto L651;
        r77.switchScene(r9, r71, r72, "bigevent");
        return;
    L651:
        return;
    L644:
        return;
    L406:
        if (this.j == false) goto L698;
        LiveMode r78 = this.k;
        if (r78 != LiveMode.VIDEO) goto L414;
        rj0.k.m2.getClass();
        rj0.k r79 = rj0.k.a.a();
        if (r79 == null) goto L653;
        r79.finishVideoTalk("bigEvent");
        return;
    L653:
        return;
    L414:
        if (r78 != LiveMode.AUDIO) goto L655;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r80 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r80 == null) goto L418;
        r80.finishAudioTalk("link_icon");
    L418:
        IKtvService r81 = jc1.k.f(IKtvService.class);
        if (r81 == null) goto L656;
        r81.finishAudioTalk();
        return;
    L656:
        return;
    L655:
        return;
    L698:
        return;
    L422:
        if (this.j == true) goto L425;
        return;
    L425:
        if (r51.getInit_linkmic_content() == null) goto L658;
        LiveMode r82 = this.k;
        if (r82 != LiveMode.VIDEO) goto L459;
        int r83 = r51.getInit_linkmic_content().getTargetMode();
        if (r83 == 1) goto L445;
        if (r83 == 2) goto L445;
        if (r83 == 3) goto L445;
        if (r83 == 16) goto L445;
        if (r83 != 18) goto L700;
        Pair<Integer, Integer> r84 = ILinkMicBigEventMessage.-CC.targetModeTransParam(r51.getInit_linkmic_content().getTargetMode());
        MultiControlService r85 = this.h;
        r85.getClass();
        Intrinsics.checkNotNullParameter(r84, "init_BigEventPair");
        MultiControlAnchorService r86 = r85.d;
        if ((r86 instanceof MultiControlAnchorService) == false) goto L439;
        r19 = r86;
    L439:
        if (r19 == null) goto L441;
        r19.g = r84;
    L441:
        DataCenter r87 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r87 == null) goto L444;
        r87.put("cmd_enable_video_chorus_in_critical", Boolean.TRUE);
        return;
    L444:
        ALogger.i("LinkControlPresenter", "Failed to enable video chorus in critical scenario: mDataCenter is null ");
        return;
    L700:
        return;
    L445:
        int r88 = r51.getInit_linkmic_content().getTargetMode();
        Pair<Integer, Integer> r89 = ILinkMicBigEventMessage.-CC.targetModeTransParam(r88);
        MultiControlService r90 = this.h;
        r90.getClass();
        Intrinsics.checkNotNullParameter(r89, "init_BigEventPair");
        MultiControlAnchorService r91 = r90.d;
        if ((r91 instanceof MultiControlAnchorService) == false) goto L449;
        r19 = r91;
    L449:
        if (r19 == null) goto L451;
        r19.g = r89;
    L451:
        if (r88 == 16) goto L453;
        if (3 == r88) goto L453;
    L454:
        DataCenter r92 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r92 == null) goto L457;
        r92.put("cmd_enable_video_chorus_in_critical", Boolean.FALSE);
    L457:
        v0(r6);
        return;
    L453:
        r6 = true;
        goto L454
    L459:
        if (r82 != LiveMode.AUDIO) goto L662;
        int r93 = r51.getInit_linkmic_content().getTargetMode();
        if (r93 == 4) goto L469;
        if (r93 == 10) goto L468;
        if (r93 == 15) goto L468;
        if (r93 != 17) goto L701;
        g0(true, 5, true, "", false);
        return;
    L701:
        return;
    L468:
        t0();
        return;
    L469:
        g0(true, 1, false, "", false);
        return;
    L662:
        return;
    L658:
        return;
    L288:
        r53.put("big_event_type", "finish");
        nd0.c.o(nd0.c.a, LinkMonitorData.ReceiveBigEventMsgMonitorData, r53, 0, null, false, 28);
        goto L293
    L289:
        r53.put("big_event_type", "init");
        com.bytedance.android.live.base.model.message.j1 r94 = r51.getInit_linkmic_content();
        if (r94 == null) goto L292;
        r55 = Integer.valueOf(r94.getTargetMode());
    L292:
        r53.put("init_target_mode", r55);
        nd0.c.o(nd0.c.a, LinkMonitorData.ReceiveBigEventMsgMonitorData, r53, 0, null, false, 28);
        goto L293
    L692:
        return;
    L471:
        if ((r23 instanceof b4) == false) goto L474;
        SelfDisciplineContext.a r95 = SelfDisciplineContext.Companion;
        String r96 = ((b4) r23).g();
        r95.getClass();
        SelfDisciplineContext.access$setRoomIntro$cp(r96);
        return;
    L474:
        if ((r23 instanceof com.bytedance.android.live.base.model.message.o0) == false) goto L486;
        if (this.j == true) goto L702;
        x00.a r97 = ((IInteractService) jc1.k.f(IInteractService.class)).getThemeManager(false, ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c);
        if (r97 == null) goto L703;
        VideoLiveThemeReporter.g.getClass();
        Lazy r98 = VideoLiveThemeReporter.f;
        ((VideoLiveThemeReporter) r98.getValue()).d = false;
        VideoLiveThemeReporter r99 = (VideoLiveThemeReporter) r98.getValue();
        IVoiceLiveTheme r100 = r97.q(3);
        if (r100 == null) goto L704;
        r100.setChangeByAnchor(true);
        r99.onThemeEnd(r100);
        return;
    L704:
        return;
    L703:
        return;
    L702:
        return;
    L486:
        if ((r23 instanceof ILinkmicProfitMessage) == false) goto L514;
        ILinkmicProfitMessage r101 = (ILinkmicProfitMessage) r23;
        if (r101.getMsgType() != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_GiftRecipient.getValue()) goto L494;
        k9 r102 = r101.getLinkmicGiftRecipientContent();
        int r103 = s0.a;
        StringCompanionObject r104 = StringCompanionObject.INSTANCE;
        ALogger.i("LinkControlPresenter", String.format("handleGiftRecipientContent: %s", Arrays.copyOf(new Object[]{r102}, 1)));
        if (r102 == null) goto L705;
        g50.c r105 = jc1.k.n(g50.c.class);
        Intrinsics.checkNotNullParameter(r102, "$this$giftRecipientUserIdStr");
        com.bytedance.android.live.base.model.user.o0.a r106 = com.bytedance.android.live.base.model.user.o0.a;
        Long r107 = Long.valueOf(r102.get_giftRecipientUserId());
        String r108 = r102.get_giftRecipientOpenId();
        r106.getClass();
        r105.registerRecommendReceiver(com.bytedance.android.live.base.model.user.o0.a.g(r107, r108), String.valueOf(r102.getReason()), r102.getExtra(), r102.getExtra());
        return;
    L705:
        return;
    L494:
        if (r101.getMsgType() != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_GameBarrageStart.getValue()) goto L501;
        i9 r109 = r101.getGameBarrageStartContent();
        if (r109 != null) goto L498;
        return;
    L498:
        if (r109.getGameInfo() == null) goto L670;
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c.put("data_linkmic_game_state", new com.bytedance.android.live.liveinteract.revenue.game.e(true, r109.getGameInfo().getGameId(), r109.getGameInfo().getGameCategory(), Integer.valueOf(r109.getGameInfo().getRunningType()), Integer.valueOf(r109.getGameInfo().getPublicStreamType()), r109.getAudienceToast(), r109.getKickOutUserIds(), r109.getTargetUiLayout(), 1));
        return;
    L670:
        return;
    L501:
        if (r101.getMsgType() != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_GameBarrageStop.getValue()) goto L508;
        j9 r111 = r101.getGameBarrageStopContent();
        if (r111 != null) goto L505;
        return;
    L505:
        if (r111.getGameInfo() == null) goto L673;
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c.put("data_linkmic_game_state", new com.bytedance.android.live.liveinteract.revenue.game.e(false, r111.getGameInfo().getGameId(), r111.getGameInfo().getGameCategory(), Integer.valueOf(r111.getGameInfo().getRunningType()), Integer.valueOf(r111.getGameInfo().getPublicStreamType()), null, null, 0, 2));
        return;
    L673:
        return;
    L508:
        if (r101.getMsgType() != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_LeaveLiveRoom.getValue()) goto L511;
        ALogger.i("LinkControlPresenter", "received TypeProfit_LeaveLiveRoom");
        xs2.b.a().post(new zg1.h1(6));
        return;
    L511:
        if (r101.getMsgType() != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_AudioSubtitleCheckIn.getValue()) goto L676;
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c.put("link_audio_subtitle_receive_check_in_message", Boolean.TRUE);
        return;
    L676:
        return;
    L514:
        if ((r23 instanceof oj) == false) goto L678;
        oj r112 = (oj) r23;
        Integer r113 = r112.getMsgType();
        if (r113 != null) goto L518;
        return;
    L518:
        if (r113.intValue() != 1) goto L528;
        nj r114 = r112.E();
        if (r114 == null) goto L680;
        Boolean r115 = r114.a();
        if (r115 == null) goto L681;
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c.put("data_has_resident_guest_allow", r115);
        if (r115.booleanValue() == false) goto L526;
        y3.f(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c).k(ToolbarButton.PERMANENT_CHAT_GUEST, this.e);
        return;
    L526:
        y3.f(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c).d(ToolbarButton.PERMANENT_CHAT_GUEST, this.e);
        return;
    L681:
        return;
    L680:
        return;
    L528:
        if (r113.intValue() != 2) goto L684;
        nj r116 = r112.G();
        if (r116 == null) goto L685;
        Boolean r117 = r116.a();
        if (r117 == null) goto L686;
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c.put("data_has_resident_chat_room_allow", r117);
        if (r117.booleanValue() == false) goto L536;
        y3.f(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c).k(ToolbarButton.PERMANENT_CHAT_ROOM, this.f);
        return;
    L536:
        y3.f(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c).d(ToolbarButton.PERMANENT_CHAT_ROOM, this.f);
        return;
    L686:
        return;
    L685:
        return;
    L684:
        return;
    }

    public final void q0(com.bytedance.android.livesdk.link.model.bridge.h1 r9) {
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        Intrinsics.checkNotNullParameter(r9, "linkerMessage");
        LinkerPrepareInviteContent r0 = r9.getLinkerPrepareInviteContent();
        if (r0 == null) goto L6;
        JSONObject r3 = new JSONObject();
        Intrinsics.checkNotNullParameter(r9, "$this$messageId");
        r3.put("msg_id", r9.getMessageId3());
        r3.put("from_room_id", r0.getFromRoomId());
        Intrinsics.checkNotNullParameter(r0, "$this$fromUserId");
        com.bytedance.android.live.base.model.user.o0.a r1 = com.bytedance.android.live.base.model.user.o0.a;
        Long r2 = Long.valueOf(r0.get_fromUserId());
        String r4 = r0.get_fromOpenId();
        r1.getClass();
        r3.put("from_user_id", com.bytedance.android.live.base.model.user.o0.a.g(r2, r4));
        Intrinsics.checkNotNullParameter(r0, "$this$toUserId");
        Long r5 = Long.valueOf(r0.get_toUserId());
        String r6 = r0.get_toOpenId();
        r1.getClass();
        r3.put("to_user_id", com.bytedance.android.live.base.model.user.o0.a.g(r5, r6));
        r3.put("source", r0.getSource());
        nd0.c.o(nd0.c.a, LinkMonitorData.ReceivePrepareInviteMsgMonitorData, r3, 0, null, false, 28);
    L6:
        int r7 = LinkmicBePrepareInvitedDialog.v;
        IRoom r8 = this.i;
        LinkmicBePrepareInvitedDialog r10 = new LinkmicBePrepareInvitedDialog();
        r10.i = r8;
        r10.k = r9;
        int r11 = com.bytedance.android.live.broadcastgame.api.g.a;
        if (com.bytedance.android.live.broadcastgame.api.g.a(((q46.b) this).a.getContext()) == null) goto L19;
        FragmentManager r12 = com.bytedance.android.live.broadcastgame.api.g.a(((q46.b) this).a.getContext()).getSupportFragmentManager();
        if (r12 == null) goto L20;
        LandscapeRestrictionOperation r13 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r10, "LinkmicBePrepareInvitedDialog", r13);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r12, r10, r13) == true) goto L21;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L14:
        r10.show(r12, "LinkmicBePrepareInvitedDialog");
        return;
    L21:
        return;
    L20:
        return;
    }

    public final void r0(com.bytedance.android.livesdk.link.model.bridge.h1 r9) {
        if (r9.getLinkerPrepareReplyContent() == null) goto L28;
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        Intrinsics.checkNotNullParameter(r9, "linkerMessage");
        LinkerPrepareReplyContent r0 = r9.getLinkerPrepareReplyContent();
        if (r0 == null) goto L9;
        JSONObject r3 = new JSONObject();
        Intrinsics.checkNotNullParameter(r9, "$this$messageId");
        r3.put("msg_id", r9.getMessageId3());
        Intrinsics.checkNotNullParameter(r0, "$this$fromUserId");
        com.bytedance.android.live.base.model.user.o0.a r1 = com.bytedance.android.live.base.model.user.o0.a;
        Long r2 = Long.valueOf(r0.get_fromUserId());
        String r4 = r0.get_fromOpenId();
        r1.getClass();
        r3.put("from_user_id", com.bytedance.android.live.base.model.user.o0.a.g(r2, r4));
        r3.put("from_room_id", r0.getFromRoomId());
        Intrinsics.checkNotNullParameter(r0, "$this$toUserId");
        r3.put("to_user_id", com.bytedance.android.live.base.model.user.o0.a.g(Long.valueOf(r0.get_toUserId()), r0.get_toOpenId()));
        r3.put("reply_type", r0.getReplyType());
        nd0.c.o(nd0.c.a, LinkMonitorData.ReceivePrepareReplyMonitorData, r3, 0, null, false, 28);
    L9:
        if (r9.getLinkerPrepareReplyContent().getReplyType() != 1) goto L25;
        if (this.j == false) goto L18;
        if (((q46.b) this).a.getCurrentMode() != 0) goto L18;
        if (this.k != LiveMode.VIDEO) goto L18;
        u0("pre_apply");
        return;
    L18:
        if (this.j == true) goto L20;
        return;
    L20:
        if (je0.d.f() == 0) goto L22;
        return;
    L22:
        if (this.k != LiveMode.AUDIO) goto L32;
        s0(null, null);
        return;
    L32:
        return;
    L25:
        if (r9.getLinkerPrepareReplyContent().getReplyType() != 2) goto L34;
        com.bytedance.android.live.core.utils.f2.c(r9.getLinkerPrepareReplyContent().getToast(), 0);
        return;
    L34:
        return;
    }

    public final void u0(String r7) {
        g0(false, 0, false, r7, false);
    }

    public final void v0(boolean r8) {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() != null) goto L5;
    L7:
        g0(false, 3, r8, "", false);
        return;
    L5:
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a().k0(2) == false) goto L7;
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c.put("cmd_force_close_linkin_before_videotalk", Boolean.TRUE);
        hd0.c.f().c(this.y);
    }

    public static void H0(String r2, String r3) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        r0.put("apply_state", r2);     // Catch: Exception -> L4
        r0.put("display_text", r3);     // Catch: Exception -> L4
        jc1.k.n(IBaseBrowserService.class).sendEventToAllJsBridges("PrepareApplyStatusChange", r0);     // Catch: Exception -> L4
        return;
    }

    public final int J0(IRoom r21, boolean r22) {
        this.i = r21;
        if (r22 == false) goto L6;
        return 0;
    L6:
        if (r21.getLinkMap() != null) goto L9;
    L17:
        boolean r3 = true;
    L20:
        if (this.i.getLinkMap().containsKey(String.valueOf(8)) == false) goto L22;
    L26:
        boolean r6 = false;
    L27:
        Lazy r10 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, "LinkMultiControlPresenter", "syncRoomStatus, linkMap = " + this.i.getLinkMap() + ", linkMapSizeException = " + r3 + ", notContainVideoTalkRoom = " + r6);
        if (this.i.isLiveTypeAudio() == true) goto L36;
        if (r3 == true) goto L32;
        if (r6 == false) goto L36;
    L32:
        if (gd0.v.a(((q46.b) this).a.getCurrentMode(), 32) == false) goto L34;
        ((q46.b) this).a.I80();
    L34:
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c.put("cmd_video_talkroom_state_change", new l3(1));
    L36:
        if (r21.getLinkerDetail() == null) goto L38;
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r4 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.t1(r21.getLinkerDetail());
    L38:
        MultiControlService r5 = this.h;
        r5.getClass();
        Map r7 = MapsKt.toMap(IRoomKt_androidKt.getLinkMapKt(r21));
        ClientUIInfo r12 = null;
        if (r21.isLiveTypeAudio() == false) goto L41;
    L76:
        int r8 = com.bytedance.android.live.liveinteract.videotalk.utils.a0.b(r21);
        ArrayList r9 = new ArrayList();
        if (IRoomKt_androidKt.getLinkerDetailKt(r21) == null) goto L91;
        z5 r14 = IRoomKt_androidKt.getLinkerDetailKt(r21);
        if (r14 == null) goto L81;
        List r15 = ILinkerDetailKt.getPlayModesEx(r14);
    L82:
        if (r15 == null) goto L91;
        z5 r16 = IRoomKt_androidKt.getLinkerDetailKt(r21);
        if (r16 == null) goto L91;
        List r17 = ILinkerDetailKt.getPlayModesEx(r16);
        if (r17 == null) goto L91;
        Iterator r18 = r17.iterator();
    L89:
        if (r18.hasNext() == false) goto L91;
        r9.add(Integer.valueOf((int) ((Number) r18.next()).longValue()));
        goto L89
    L81:
        r15 = null;
    L91:
        fn0.a r11 = new fn0.a(0);
        if (r21.isLiveTypeAudio() == true) goto L100;
        int r13 = vh0.a.a;
        if (((List) vm2.e.W.getValue(null, vm2.e.a[47])).contains(String.valueOf(r8)) == true) goto L100;
        if (r8 < 109) goto L100;
        if (r8 > 112) goto L100;
        r11.b = 12;
        r11.c = r8;
        r11.d = r9;
    L100:
        jy0.b.d("ttlive_link", "syncRoomStats isWithLinkMic " + IRoomKt_androidKt.getWithLinkmic(r21));
        if (IRoomKt_androidKt.getWithLinkmic(r21) == true) goto L107;
        if (r21.isLiveTypeAudio() == true) goto L105;
    L117:
        r5.a(r11);
        fn0.a r19 = r11;
    L119:
        if (this.i.getLinkMap() == null) goto L165;
        Map r20 = this.i.getLinkMap();
        int r23 = MultiSceneEnterRoomStatisticsUtils.u;
        if (MultiSceneEnterRoomStatisticsUtils.a.a(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, Long.valueOf(this.i.getId())) == null) goto L127;
        MultiSceneEnterRoomStatisticsUtils.a.a(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, Long.valueOf(this.i.getId())).n(com.bytedance.android.live.liveinteract.videotalk.utils.a0.b(r21));
        MultiSceneEnterRoomStatisticsUtils r24 = MultiSceneEnterRoomStatisticsUtils.a.a(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, Long.valueOf(this.i.getId()));
        if (r24.g() == false) goto L127;
        r24.startObserveBaseElementLoadEnd("link_mic");
    L127:
        if (r19.a != 32) goto L147;
        if (this.m.s() != null) goto L131;
    L144:
        tc0.c.h().j(Boolean.TRUE);
        tc0.c.h().E = this.i.isSupportCamera();
        ((q46.b) this).a.wu(32, MultiLinkOpenSource.SYNC_ROOM);
        return 32;
    L131:
        if (this.m.getVideoTalkRoomSubScene().getValue() == null) goto L144;
        ArrayList r2 = new ArrayList();
        if (r21.getLinkerDetail() == null) goto L141;
        if (r21.getLinkerDetail().getPlayModes() == null) goto L141;
        Iterator r25 = r21.getLinkerDetail().getPlayModes().iterator();
    L138:
        if (r25.hasNext() == false) goto L141;
        r2.add(Integer.valueOf((int) ((Long) r25.next()).longValue()));
    L141:
        if (r21.getLinkerDetail() == null) goto L143;
        r12 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.a.a(r21.getLinkerDetail().getClientUiInfo());
    L143:
        ((com.bytedance.android.livesdk.chatroom.viewmodel.e) this.m.getVideoTalkRoomSubScene().getValue()).e(new com.bytedance.android.livesdk.chatroom.viewmodel.j(r19.b, r19.d, r19.c, false, r12));
        ((q46.b) this).a.Gl(r19.b, r19.d, r19.c);
        ALogger.w("ttlive_link", "syncRoomStats " + ((com.bytedance.android.livesdk.chatroom.viewmodel.e) this.m.getVideoTalkRoomSubScene().getValue()).t());
        goto L144
    L147:
        if (r19.b != 12) goto L150;
        ((q46.b) this).a.Gl(12, r19.d, r19.c);
    L150:
        if (r20.containsKey(String.valueOf(5)) == false) goto L165;
        if (r21.getLinkerDetail() == null) goto L165;
        if (r21.getLinkerDetail().getPlayModes() == null) goto L165;
        Iterator r1 = r21.getLinkerDetail().getPlayModes().iterator();
    L157:
        if (r1.hasNext() == false) goto L165;
        long r26 = ((Long) r1.next()).longValue();
        com.bytedance.android.livesdk.chatroom.u r27 = this.m;
        if (r27 == null) goto L157;
        if (r27.J() == null) goto L157;
        LivePlayModeLogContext r28 = (LivePlayModeLogContext) this.m.J().getValue();
        if (r28 == null) goto L157;
        r28.addPlayMode((int) r26);
    L165:
        int r29 = r19.a;
        if (r29 == 8) goto L168;
        if (r29 == 2) goto L168;
        return 0;
    L168:
        tc0.c.h().j(Boolean.TRUE);
        int r30 = r19.a;
        int r31 = 0 | r30;
        ((q46.b) this).a.wu(r30, MultiLinkOpenSource.SYNC_ROOM);
        return r31;
    L105:
        if (IRoomKt_androidKt.getLinkMapKt(r21).containsKey(String.valueOf(16)) == false) goto L117;
    L107:
        if (r21.isLiveTypeAudio() == false) goto L109;
        r11.a = 8;
    L110:
        String r32 = (String) CollectionsKt.firstOrNull(CollectionsKt.toList(IRoomKt_androidKt.getLinkMapKt(r21).keySet()));
        if (r32 == null) goto L115;
        Integer r33 = StringsKt.toIntOrNull(r32);
        if (r33 == null) goto L115;
        int r34 = r33.intValue();
    L116:
        r11.b = r34;
        r11.c = r8;
    L115:
        r34 = 0;
        goto L116
    L109:
        r11.a = 2;
        goto L110
    L41:
        if (r7.containsKey(String.valueOf(8)) == false) goto L43;
    L50:
        ArrayList r35 = new ArrayList();
        if (IRoomKt_androidKt.getLinkerDetailKt(r21) == null) goto L65;
        z5 r110 = IRoomKt_androidKt.getLinkerDetailKt(r21);
        if (r110 == null) goto L55;
        List r111 = ILinkerDetailKt.getPlayModesEx(r110);
    L56:
        if (r111 == null) goto L65;
        z5 r112 = IRoomKt_androidKt.getLinkerDetailKt(r21);
        if (r112 == null) goto L65;
        List r113 = ILinkerDetailKt.getPlayModesEx(r112);
        if (r113 == null) goto L65;
        Iterator r114 = r113.iterator();
    L63:
        if (r114.hasNext() == false) goto L65;
        r35.add(Integer.valueOf((int) ((Number) r114.next()).longValue()));
        goto L63
    L55:
        r111 = null;
    L65:
        r19 = new fn0.a(32);
        if (r7.containsKey(String.valueOf(16)) == false) goto L69;
        r19.b = 16;
        r19.c = com.bytedance.android.live.liveinteract.videotalk.utils.a0.a(16, r21);
        r19.d = r35;
    L72:
        tc0.b r36 = r5.e;
        if (r36 == null) goto L75;
        r36.v6(IRoomKt_androidKt.isSupportCameraExt(r21));
    L75:
        r5.a(r19);
        goto L119
    L69:
        if (r7.containsKey(String.valueOf(12)) == false) goto L71;
        r19.b = 12;
        r19.c = com.bytedance.android.live.liveinteract.videotalk.utils.a0.a(12, r21);
        r19.d = r35;
        goto L72
    L71:
        r19.b = 8;
        r19.c = com.bytedance.android.live.liveinteract.videotalk.utils.a0.a(8, r21);
        r19.d = r35;
        goto L72
    L43:
        if (r7.containsKey(String.valueOf(12)) == false) goto L47;
        int r37 = com.bytedance.android.live.liveinteract.videotalk.utils.a0.a(12, r21);
        if (((ArrayList) com.bytedance.android.livesdk.chatroom.interact.model.f0.a).contains(Integer.valueOf(r37)) == true) goto L50;
    L47:
        if (r7.containsKey(String.valueOf(16)) == true) goto L50;
        int r38 = vh0.a.a;
        if (((List) vm2.e.W.getValue(null, vm2.e.a[47])).contains(String.valueOf(com.bytedance.android.live.liveinteract.videotalk.utils.a0.b(r21))) == false) goto L76;
    L22:
        if (this.i.getLinkMap().containsKey(String.valueOf(12)) == true) goto L26;
        if (this.i.getLinkMap().containsKey(String.valueOf(16)) == true) goto L26;
        r6 = true;
        goto L27
    L9:
        if (this.i.getLinkMap().size() != 2) goto L16;
        if (vm2.h.W().enableLinkMapSizeExceptionOpt() == false) goto L17;
        if (this.i.getLinkMap().containsKey(String.valueOf(1)) == false) goto L17;
    L18:
        r3 = false;
        goto L20
    L16:
        if (this.i.getLinkMap().size() <= 2) goto L18;
        goto L17
    }

    public final void K0(long r5, final String r7) {
        if (this.u == false) goto L5;
        return;
    L5:
        this.u = true;
        final long r0 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.n0(r7);
        ((SingleSubscribeProxy) ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).unSilence(r5, r7, r7).as(e0())).subscribe(new t(this, r7, r0), new u(this, r7, r0));
    }

    public final void p0(final IRoom r13, final Runnable r14) {
        final long r4 = System.currentTimeMillis();
        Disposable r15 = ((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).prepareApply(r13.getId(), 4, 2, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new n(this, r14, r4), new o(this, r13, r14, r4));
        this.g.add(r15);
    }

    public final void s0(Runnable r13, Runnable r14) {
        i0(true, false, 0, false, "", false, 29, 5, 1, r13, r14);
    }

    public final void F0(final long r15, final IBaseUser r17, final String r18) {
        if (this.t == true) goto L8;
        if (r17 == null) goto L9;
        this.t = true;
        final long r9 = System.currentTimeMillis();
        ((ObservableSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).prepareInvite(r15, d5.c(r17.getIdString()), r17.getIdString(), r18).as(e0())).subscribe(new q0(this, r17, r15, r9, r18), new h(this, r15, r17, r18, r9));
        return;
    L9:
        return;
    }

    public final void n0(Context r6, IRoom r7, LinkMultiControlWidget.e r8) {
        if (r7 == null) goto L5;
        OperateType r0 = OperateType.PRE_APPLY;
        ArrayList r1 = new ArrayList();
        r1.add(qh0.g.a(r0, 2));
        r1.add(new qh0.f.g(r6, r0, 2));
        r1.add(new qh0.f.c(r6, r0, 2));
        r1.add(new qh0.f.a(r6));
        r1.add(new qh0.f.C0257f(r6, r0, 2, true));
        r1.add(new qh0.f.e(r6, r0));
        qh0.f.a(r1).a(new r0(this, r7, r8));
        return;
    }

    public final void G0(final long r14, final String r16, final int r17, final boolean r18) {
        final long r8 = System.currentTimeMillis();
        ((SingleSubscribeProxy) ((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).prepareReply(r14, d5.c(r16), r16, r17).as(e0())).subscribe(new k(this, r16, r14, r17, r8), new l(this, r18, r14, r16, r17, r8));
    }

    public final void o0(long r10, String r12, int r13, String r14) {
        if (r13 != 1) goto L5;
        OperateType r2 = OperateType.PRE_REPLY;
        ArrayList r3 = new ArrayList();
        r3.add(qh0.g.a(r2, 2));
        r3.add(new qh0.f.g(((q46.b) this).a.getContext(), r2, 2));
        r3.add(new qh0.f.c(((q46.b) this).a.getContext(), r2, 2));
        r3.add(new qh0.f.a(((q46.b) this).a.getContext()));
        r3.add(new qh0.f.d(((q46.b) this).a.getContext(), r2, 2, true));
        r3.add(new qh0.f.C0257f(((q46.b) this).a.getContext(), r2, 2, true));
        r3.add(new qh0.f.e(((q46.b) this).a.getContext(), r2));
        qh0.f.a(r3).a(new e(this, r10, r12, r13, r14));
        return;
    L5:
        if (r13 != 2) goto L9;
        G0(r10, r12, r13, true);
        return;
    }

    public final void g0(boolean r13, int r14, boolean r15, String r16, boolean r17) {
        i0(r13, false, r14, r15, r16, r17, 0, 0, 0, null, null);
    }

    public final void w0(final IRoom r18, final IBaseUser r19, final boolean r20, boolean r21, final boolean r22, final boolean r23, IMessageBoardInfo r24) {
        ArrayList r7 = new ArrayList();
        r7.add(r19.getIdString());
        if (r24 == null) goto L5;
        String r0 = "gift_message_panel";
    L6:
        String r3 = r0;
        if (r24 == null) goto L9;
        long r1 = r24.getId();
    L10:
        final long r12 = r1;
        int r2 = com.bytedance.android.live.liveinteract.chatroom.chatroom.util.b.a;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.util.b.d(r22, r19.getIdString(), r20, r3, r21, null, r24);
        ((SingleSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).inviteFriends(r18.getId(), new JSONArray(r7).toString(), 0, r12).as(e0())).subscribe(new g0(this, r19, r18, r22, r20, r23, r12), new h0(r12));
        return;
    L9:
        r1 = 0;
        goto L10
    L5:
        r0 = "";
        goto L6
    }

    public LinkMultiControlPresenter(IRoom r3, boolean r4, boolean r5, LiveMode r6, com.bytedance.android.livesdk.chatroom.u r7, com.bytedance.android.livesdk.chatroom.o r8, LinkMultiControlWidget.a r9, com.bytedance.android.livesdk.chatroom.widget.j1 r10) {
        this.e = new in0.b();
        this.f = new in0.a();
        this.g = new CompositeDisposable();
        this.o = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.y = new b(this);
        this.z = new c(this);
        this.A = false;
        this.i = r3;
        this.j = r4;
        this.o = r5;
        this.k = r6;
        this.m = r7;
        this.w = r8;
        this.n = r9;
        this.x = r10;
        MultiControlService r11 = new MultiControlService(this, r10.getMultiLinkRoomScope());
        this.h = r11;
        Intrinsics.checkNotNullParameter(this, "multiControlMsgListener");
        r11.c = this;
        gn0.b r12 = r11.j;
        r12.getClass();
        Intrinsics.checkNotNullParameter(this, "multiControlSettingListener");
        r12.b = this;
    }

    public static void k0(LinkMultiControlPresenter r29, com.bytedance.android.livesdk.chatroom.model.interact.j0 r30, boolean r31, int r32, boolean r33, boolean r34, String r35, int r36) {
        r29.getClass();
        if (r32 != 4) goto L8;
        boolean r1 = us1.e.a;
        if (((Boolean) ue.a.getValue()).booleanValue() == false) goto L7;
        us1.e.b = true;
        goto L8
    L7:
        us1.e.b = false;
    L8:
        SelfDisciplineContext.Companion.getClass();
        SelfDisciplineContext.access$setContinue$cp(r34);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) r29).c.put("data_audience_pre_linkmic_waiting", Boolean.FALSE);
        if (r33 == true) goto L11;
        ((com.bytedance.android.livesdk.chatroom.presenter.n) r29).c.put("data_voice_chat_room_shoot_way", "null");
    L34:
        if (r29.m.u() != null) goto L36;
    L42:
        com.bytedance.android.livesdk.chatroom.u r2 = r29.m;
        if (r2 != null) goto L45;
    L51:
        int r17 = 10;
    L52:
        com.bytedance.android.livesdk.chatroom.u r3 = r29.m;
        if (r3 == null) goto L63;
        if (r3.s() == null) goto L63;
        if (r29.m.s().getValue() == null) goto L63;
        if (r29.i.isLiveTypeAudio() == false) goto L63;
        r29.I0();
        ((com.bytedance.android.livesdk.chatroom.viewmodel.f) r29.m.s().getValue()).d(new com.bytedance.android.livesdk.chatroom.viewmodel.h(r32, r30.getUiLayout(), r30.getPlayModes(), r33, r30.getRtcExtInfo(), r30.getLiveCoreExtInfo(), r30.getMultiLiveCoreInfo(), r30.getClientUIInfo()));
    L63:
        if (r32 != 9) goto L65;
        boolean r4 = true;
    L66:
        if (r4 == false) goto L72;
        com.bytedance.android.livesdk.chatroom.u r5 = r29.m;
        if (r5 == null) goto L72;
        if (r5.I1() == null) goto L72;
        ALogger.i("ttlive_link", "initV2 set ktv true");
        r29.m.I1().setValue(Boolean.TRUE);
    L72:
        String r6 = MultiLinkOpenSource.INIT_V2;
        if (r36 != 8) goto L79;
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r7 = TalkRoomLogUtils.a;
        if (TalkRoomLogUtils.b.a == r30.getUiLayout()) goto L77;
        TalkRoomLogUtils.s1(r30.getUiLayout(), false);
        ALogger.i("AnchorManualUiLayout", "initV2 roomInit, currentAnchorManualUiLayout" + r30.getUiLayout());
    L77:
        ((q46.b) r29).a.wu(8, MultiLinkOpenSource.INIT_V2);
    L93:
        if (UserSetting.b() == false) goto L97;
        IUserServiceV2 r8 = jc1.k.f(IUserServiceV2.class);
        if (r8 == null) goto L98;
        r8.updateCurrentUser(((com.bytedance.android.livesdk.chatroom.presenter.n) r29).c, "LinkMultiControlPresenter").subscribe(new com.bytedance.android.livesdk.user.h());
    L98:
        us1.e.a = false;
        if (r31 == false) goto L156;
        HashMap r11 = new HashMap();
        if (r29.i.getLinkInitResult() == null) goto L104;
        TalkRoomLogUtils.b(r11);
    L104:
        if (9 != r32) goto L111;
        com.bytedance.android.livesdk.log.j0.l().sendLog("anchor_ktv_open_success", r11, new Object[]{IRoom.class, am2.x.class});
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.R0.getValue()).booleanValue() == false) goto L108;
        Object r9 = "on";
    L109:
        r11.put("is_camera_allow", r9);
        goto L111
    L108:
        r9 = "off";
    L111:
        r11.put("live_type", "voice_live");
        r11.put("room_type", "radio");
        if (r34 == false) goto L114;
        r11.put("is_continue", "continue");
    L114:
        TalkRoomLogUtils.z0(r11, Integer.valueOf(r32));
        TalkRoomLogUtils.Q0(r11);
        if (r33 == false) goto L117;
        r11.put("shoot_way", (String) ((com.bytedance.android.livesdk.chatroom.presenter.n) r29).c.get("data_voice_chat_room_shoot_way", ""));
    L119:
        if (r29.i.getCircleInfo() != null) goto L121;
    L123:
        String r10 = TalkRoomLogUtils.d;
        if (r10 == null) goto L127;
        r11.put("source", r10);
    L127:
        if (com.bytedance.android.livesdk.log.j0.l().c(am2.x.class) == null) goto L138;
        if (com.bytedance.android.livesdk.log.j0.l().c(am2.x.class).getMap() == null) goto L138;
        if (com.bytedance.android.livesdk.log.j0.l().c(am2.x.class).getMap().containsKey("enter_from") == false) goto L138;
        if (com.bytedance.android.livesdk.log.j0.l().c(am2.x.class).getMap().get("enter_from") == null) goto L138;
        if (com.bytedance.android.livesdk.log.j0.l().c(am2.x.class).getMap().get("enter_from").equals("solo_ktv") == false) goto L138;
        r11.put("source", "solo_ktv");
    L138:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == false) goto L140;
        r11.put("is_invite_only", "1");
    L141:
        com.bytedance.android.livesdk.chatroom.u r12 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r33 == true) goto L151;
        if (r12 == null) goto L151;
        if (r12.s() == null) goto L151;
        if (r12.s().getValue() == null) goto L151;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) r12.s().getValue()).g() == null) goto L151;
        r11.put("before_function", com.bytedance.android.live.liveinteract.plantform.utils.u0.a(Integer.valueOf(((com.bytedance.android.livesdk.chatroom.viewmodel.f) r12.s().getValue()).g().a), Integer.valueOf(((com.bytedance.android.livesdk.chatroom.viewmodel.f) r12.s().getValue()).g().b)));
    L151:
        r11.put("layout_type", com.bytedance.android.live.liveinteract.plantform.utils.u0.i(Integer.valueOf(r30.getUiLayout()), r30.getPlayModes(), Integer.valueOf(TalkRoomLogUtils.b.a)));
        TalkRoomLogUtils.H0(r11);
        if (TalkRoomLogUtils.n.isEmpty() == true) goto L154;
        r11.put("source", TalkRoomLogUtils.n);
        r11.put("game_id", TalkRoomLogUtils.o);
        r11.put("game_name", TalkRoomLogUtils.p);
    L154:
        String r13 = qi0.c.b;
        qi0.c.k("source", r11);
        com.bytedance.android.livesdk.log.j0 r14 = com.bytedance.android.livesdk.log.j0.l();
        am2.x r15 = new am2.x();
        r15.b = "live_detail";
        r15.a = "live";
        r15.e = "click";
        r14.sendLog("anchor_audience_connection_open_success", r11, new Object[]{r15, IRoom.class});
    L162:
        Object r16 = "live_take_page";
    L229:
        if (r33 == false) goto L232;
        ((com.bytedance.android.livesdk.chatroom.presenter.n) r29).c.put("data_room_shoot_way_exact", r16);
        return;
    L232:
        return;
    L140:
        r11.put("is_invite_only", "0");
        goto L141
    L121:
        if (r29.i.getCircleInfo().getCircleId() <= 0) goto L123;
        r11.put("circle_name", r29.i.getCircleInfo().getCircleName());
        goto L123
    L117:
        r11.put("shoot_way", "null");
        goto L119
    L156:
        if (r32 != 4) goto L159;
        int r18 = jf0.b.a;
        jf0.b.k(r35, r29.i.getCircleInfo());
        goto L162
    L159:
        if (r32 == 8) goto L163;
        if (r32 != 12) goto L162;
    L163:
        HashMap r19 = new HashMap();
        r19.put("live_type", "video_live");
        r19.put("function_type", "radio");
        if (r32 != 12) goto L167;
        r19.put("function_type", "party");
    L167:
        if (r30.getPlayModes() == null) goto L172;
        if (r30.getPlayModes().contains(1) == false) goto L172;
        r19.put("play_type", "video_friend");
    L172:
        if (((Boolean) b6.h.getValue()).booleanValue() == false) goto L174;
        Object r20 = "on";
    L175:
        r19.put("is_camera_allow", r20);
        if (r29.i.getCircleInfo() != null) goto L178;
    L180:
        r16 = "live_take_page";
        r19.put("shoot_way", r16);
        TalkRoomLogUtils.X0(r19, r30.getPlayModes());
        String r21 = (String) ((com.bytedance.android.livesdk.chatroom.presenter.n) r29).c.get("data_room_video_talk_log_open_success_for_enter_from", "");
        if (TextUtils.isEmpty(r21) == true) goto L183;
        r19.put("enter_from", r21);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) r29).c.put("data_room_video_talk_log_open_success_for_enter_from", "");
    L183:
        DataCenter r22 = ((com.bytedance.android.livesdk.chatroom.presenter.n) r29).c;
        if (r22 == null) goto L196;
        Object r23 = r22.get("cmd_init_video_talk_room_with_pending_play_mode");
        if ((r23 instanceof Integer) == false) goto L196;
        if (r23.equals(Integer.valueOf(r17)) == false) goto L196;
        com.bytedance.android.livesdk.chatroom.u r24 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r24 == null) goto L196;
        if (r24.J() == null) goto L196;
        if (r24.J().getValue() == null) goto L196;
        int r25 = 10;
        ((LivePlayModeLogContext) r24.J().getValue()).addPlayMode(10);
    L197:
        boolean r26 = ((IInteractService) jc1.k.f(IInteractService.class)).dynamicFromAudience();
        if (r26 == false) goto L202;
        r19.put("function_type", "new_audience");
        r19.put("function_type2", "new_audience");
        if ("pre_apply".equals(r35) == false) goto L202;
        us1.e.a = true;
    L202:
        if (r26 == true) goto L204;
    L206:
        DataCenter r27 = ((com.bytedance.android.livesdk.chatroom.presenter.n) r29).c;
        if (r27 != null) goto L209;
    L211:
        String r28 = TalkRoomLogUtils.d;
        if (r28 == null) goto L215;
        r19.put("source", r28);
    L215:
        if (r19.containsKey("enter_from") == false) goto L222;
        if (r19.get("enter_from") == null) goto L222;
        if (((String) r19.get("enter_from")).equals("solo_ktv") == false) goto L222;
        r19.put("source", "solo_ktv");
    L222:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == false) goto L224;
        r19.put("is_invite_only", "1");
    L225:
        TalkRoomLogUtils.H0(r19);
        TalkRoomLogUtils.P0(r19, Integer.valueOf(((IInteractService) jc1.k.f(IInteractService.class)).getCurrentScene()));
        if (TalkRoomLogUtils.n.isEmpty() == true) goto L228;
        r19.put("source", TalkRoomLogUtils.n);
        r19.put("game_id", TalkRoomLogUtils.o);
        r19.put("game_name", TalkRoomLogUtils.p);
    L228:
        com.bytedance.android.livesdk.log.j0.l().sendLog("anchor_audience_connection_open_success", r19, new Object[]{IRoom.class, am2.x.class});
        goto L229
    L224:
        r19.put("is_invite_only", "0");
        goto L225
    L209:
        if (((Integer) r27.get("cmd_init_video_talk_room_with_pending_play_mode", -1)).intValue() != r25) goto L211;
        r19.put("source", "ksong_element");
        goto L215
    L204:
        if ("pre_apply".equals(r35) == false) goto L206;
        r19.put("source", "pre_apply");
    L196:
        r25 = 10;
        goto L197
    L178:
        if (r29.i.getCircleInfo().getCircleId() <= 0) goto L180;
        r19.put("circle_name", r29.i.getCircleInfo().getCircleName());
        goto L180
    L174:
        r20 = "off";
        goto L175
    L97:
        jc1.k.f(IMiddlewareUserService.class).user().j().subscribe(new com.bytedance.android.livesdk.user.h());
        goto L98
    L79:
        if (r36 != 32) goto L81;
        ((q46.b) r29).a.wu(32, MultiLinkOpenSource.INIT_V2);
        goto L93
    L81:
        if (r36 != 2) goto L93;
        if ("auto".equals(r35) == false) goto L85;
        r6 = MultiLinkOpenSource.AUTO;
    L85:
        ((q46.b) r29).a.wu(2, r6);
        if (((q46.b) r29).a.getCurrentMode() != 2) goto L88;
    L91:
        xs2.b.a().post(new zg1.a1(14));
        goto L93
    L88:
        if (gd0.v.a(((q46.b) r29).a.getCurrentMode(), 4) == false) goto L93;
        if (us1.b.a() == false) goto L93;
    L65:
        r4 = false;
        goto L66
    L45:
        if (r2.s() == null) goto L51;
        if (r29.m.getVideoTalkRoomSubScene().getValue() == null) goto L51;
        if (r29.i.isLiveTypeAudio() == true) goto L51;
        r17 = 10;
        ((com.bytedance.android.livesdk.chatroom.viewmodel.e) r29.m.getVideoTalkRoomSubScene().getValue()).e(new com.bytedance.android.livesdk.chatroom.viewmodel.j(r32, r30.getPlayModes(), r30.getUiLayout(), r33, r30.getClientUIInfo()));
        goto L52
    L36:
        if (((Integer) r29.m.u().getValue()).intValue() != 10) goto L42;
        ((com.bytedance.android.livesdk.chatroom.presenter.n) r29).c.put("cmd_toast_when_open_ktv_by_schema", com.bytedance.android.live.core.utils.s1.B(2131920863));
        if (r29.m.J() == null) goto L42;
        if (r29.m.J().getValue() == null) goto L42;
        ((LivePlayModeLogContext) r29.m.J().getValue()).addPlayMode(10);
        goto L42
    L11:
        if (r29.w.s2() != null) goto L13;
    L27:
        String r37 = "";
    L29:
        if (TextUtils.isEmpty(r37) == true) goto L31;
        ((com.bytedance.android.livesdk.chatroom.presenter.n) r29).c.put("data_voice_chat_room_shoot_way", r37);
        goto L34
    L31:
        ((com.bytedance.android.livesdk.chatroom.presenter.n) r29).c.put("data_voice_chat_room_shoot_way", "direct_shoot");
        goto L34
    L13:
        if (r29.w.s2().getValue() == null) goto L27;
        ((com.bytedance.android.live.broadcast.api.model.z0) r29.w.s2().getValue()).getClass();
        if (LiveMode.AUDIO != null) goto L27;
        ((com.bytedance.android.live.broadcast.api.model.z0) r29.w.s2().getValue()).getClass();
        if (r30.getScene() != 0) goto L27;
        if (com.bytedance.android.livesdk.log.j0.l().c(am2.x.class).getMap() == null) goto L27;
        if (com.bytedance.android.livesdk.log.j0.l().c(am2.x.class).getMap().containsKey("enter_from") == false) goto L27;
        if (com.bytedance.android.livesdk.log.j0.l().c(am2.x.class).getMap().get("enter_from") == null) goto L27;
        r37 = "convenient_page";
        if (com.bytedance.android.livesdk.log.j0.l().c(am2.x.class).getMap().get("enter_from").equals("convenient_page") == false) goto L27;
        goto L27
    }

    public final void h0(boolean r13, boolean r14, int r15, boolean r16, String r17, boolean r18, int r19, int r20, int r21) {
        i0(r13, r14, r15, r16, r17, r18, r19, r20, r21, null, null);
    }

    public final void i0(boolean r14, boolean r15, int r16, boolean r17, String r18, boolean r19, int r20, int r21, int r22, Runnable r23, Runnable r24) {
        if (((q46.b) this).a != null) goto L6;
        A0();
        return;
    L6:
        d r1 = new d(this, r23, r24);
        com.bytedance.android.live.multilink.impl.control.anchor.f r12 = new com.bytedance.android.live.multilink.impl.control.anchor.f(r14, r15, r16, r17, r18, r19, Integer.valueOf(r20), Integer.valueOf(r21), Integer.valueOf(r22));
        this.h.d.a(r12, r1);
    }
}
