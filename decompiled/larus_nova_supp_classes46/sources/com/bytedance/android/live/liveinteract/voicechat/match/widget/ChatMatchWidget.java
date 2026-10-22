package com.bytedance.android.live.liveinteract.voicechat.match.widget;

import am2.x;
import android.hardware.SensorManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.setting.k6;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.revenue.guestlink.GuestLinkContext;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.liveinteract.voicechat.match.utils.ShakeUtils;
import com.bytedance.android.live.liveinteract.voicechat.match.view.ChatMatchDialog;
import com.bytedance.android.live.liveinteract.voicechat.match.view.ChatMatchDialog$startMatch$$inlined$let$lambda$1;
import com.bytedance.android.live.liveinteract.voicechat.match.viewmodel.ChatMatchViewModel;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.IApplyResult;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.r;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.KtvRoomUserLabel;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rj0.l;
import vb6.g;
import vh7.f;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/match/widget/ChatMatchWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChatMatchWidget extends LiveWidget {
    public static String o;
    public static boolean p;
    public ChatMatchViewModel a;
    public ChatMatchDialog b;
    public Disposable c;
    public vlc.d d;
    public ShakeUtils e;
    public final CompositeDisposable f;
    public boolean g;
    public boolean h;
    public fk0.a i;
    public String j;
    public boolean k;
    public final b l;
    public final boolean m;
    public final j1 n;

    public static final class a {
    }

    public static final class b extends vb6.a {
        public final /* synthetic */ ChatMatchWidget a;

        public b(ChatMatchWidget r1) {
            this.a = r1;
        }

        public final void U8(long r3, ExtraResponse<IApplyResult, Extra> r5) {
            Intrinsics.checkNotNullParameter(r5, "response");
            super.U8(r3, r5);
            tc0.c r4 = tc0.c.h();
            int r6 = (int) r5.data.getWaitingListOffset();
            r4.i = r6;
            r4.h = r6;
            ChatMatchWidget r7 = this.a;
            if (r5.data.getLinkType() != LinkApplyType.MATCH.getValue()) goto L5;
            boolean r8 = true;
        L6:
            r7.k = r8;
            return;
        L5:
            r8 = false;
            goto L6
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ChatMatchWidget a;

        public c(ChatMatchWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Boolean r5 = (Boolean) r4;
            if (r5 != null) goto L5;
            return;
        L5:
            if (r5.booleanValue() == false) goto L7;
            ChatMatchWidget.Aq(this.a, null, false, null, 14);
            return;
        L7:
            ChatMatchDialog r6 = this.a.b;
            if (r6 != null) goto L10;
            return;
        L10:
            if (r6.isShowing() == false) goto L16;
            ChatMatchWidget.wq(r6);
            return;
        }
    }

    public static final class d implements ShakeUtils.a {
        public final /* synthetic */ ChatMatchWidget a;
        public final /* synthetic */ boolean b;

        public d(ChatMatchWidget r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.android.live.liveinteract.voicechat.match.utils.ShakeUtils.a
        public final void a() {
            fk0.a r0 = this.a.i;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mShakeFilter");
        L5:
            r0.getClass();
            long r3 = 0;
            IRoom r5 = null;
            if (je0.d.f() != 0) goto L9;
        L100:
            boolean r1 = false;
        L101:
            if (r1 == true) goto L103;
            return;
        L103:
            if (this.b == false) goto L133;
            ChatMatchWidget r2 = this.a;
            r2.getClass();
            sb6.a r4 = GuestLinkContext.Companion.a();
            if (r4 != null) goto L107;
        L109:
            ALogger.d("ChatMatchWidget", "showMatchDialogForShake " + ((Widget) r2).isViewValid + ' ' + ((Widget) r2).isDestroyed + " : " + r2);
            ChatMatchDialog r6 = r2.b;
            if (r6 != null) goto L112;
        L114:
            ChatMatchWidget.o = "pop_panel";
            TalkRoomBusinessFullLinkMonitor r7 = TalkRoomBusinessFullLinkMonitor.a;
            String r8 = ChatMatchWidget.o;
            r7.getClass();
            TalkRoomBusinessFullLinkMonitor.x(r8);
            DataCenter r9 = ((Widget) r2).dataCenter;
            if (r9 == null) goto L117;
            IRoom r10 = (IRoom) r9.get("data_room", f.c(IRoom.class));
        L118:
            int r11 = ChatMatchDialog.V;
            ChatMatchDialog r12 = ChatMatchDialog.a.a(r10, ((Widget) r2).dataCenter, null, false, null, Boolean.FALSE);
            r2.b = r12;
            FragmentActivity r13 = ContextUtil.contextToFragmentActivity(r2.getContext());
            if (r13 == null) goto L123;
            FragmentManager r14 = r13.getSupportFragmentManager();
            if (r14 == null) goto L123;
            ChatMatchWidget.xq(r12, r14);
            r12.X90();
        L123:
            e r15 = b6.n0;
            if (((Boolean) r15.getValue()).booleanValue() == false) goto L136;
            com.bytedance.android.livesdk.sharedpref.f.d(r15, Boolean.FALSE);
            DataCenter r16 = ((Widget) r2).dataCenter;
            if (r16 == null) goto L128;
            r5 = (IRoom) r16.get("data_room");
        L128:
            if (r5 == null) goto L130;
            r3 = r5.getRoomId();
        L130:
            String r17 = ((Widget) r2).context.getString(2131916655);
            c4 r18 = f.c(c4.class);
            MessageType r19 = MessageType.ROOM;
            r18.setMessageMethod(r19.getWsMethod());
            m0 r20 = f.c(m0.class);
            r20.setRoomId(r3);
            r20.setShowMsg(true);
            r20.setMethod(r19.getWsMethod());
            r18.setBaseMessage(r20);
            r18.setContent(r17);
            r.d(r18, PSMessageAction.CHAT);
            vlc.d r21 = r2.d;
            if (r21 == null) goto L137;
            r21.B(r18);
            return;
        L137:
            return;
        L136:
            return;
        L117:
            r10 = null;
            goto L118
        L112:
            if (r6.isShowing() == false) goto L114;
            r6.X90();
            goto L123
        L107:
            if (r4.a != true) goto L109;
            ALogger.i("ChatMatchWidget", "showMatchDialogForShake return, cause: guestlink");
            goto L123
        L133:
            f2.b(2131918795, 0);
            return;
        L9:
            if (FoldScreenUtils.e() == true) goto L16;
            if (PadConfigUtils.c() == true) goto L16;
            if (Intrinsics.areEqual(m.i().isPortraitInteraction(), Boolean.FALSE) == true) goto L100;
        L16:
            if (((Boolean) b6.V.getValue()).booleanValue() == false) goto L100;
            if (((Boolean) b6.W.getValue()).booleanValue() == true) goto L100;
            if (k.n(IMiddlewareUserService.class).user().isAdmin() == true) goto L22;
        L23:
            IKtvService r22 = k.n(IKtvService.class);
            User r23 = m.i().getUser();
            if (r23 == null) goto L27;
            String r24 = r23.getIdString();
            if (r24 == null) goto L27;
        L29:
            if (r22.getUserKtvRoomLabel(r24) == KtvRoomUserLabel.SINGER) goto L100;
            if (fj0.c.a() == false) goto L80;
            IInteractService r25 = (IInteractService) k.f(IInteractService.class);
            if (r25 == null) goto L38;
            i<ILinkPlayerInfoBridge> r26 = r25.getLinkUserInfoCenter();
            if (r26 == null) goto L38;
            ILinkPlayerInfoBridge r27 = (ILinkPlayerInfoBridge) r26.a5(je0.d.b0(), tc0.c.h().f);
        L39:
            if (r27 == null) goto L41;
            long r28 = r27.getPaidCount();
        L43:
            if (hd0.c.f().h() == false) goto L47;
            if (r28 <= 0) goto L47;
        L81:
            boolean r29 = true;
        L82:
            if (r29 == true) goto L100;
            com.bytedance.live.datacontext.m r30 = m.i().P1();
            if (r30 == null) goto L88;
            Boolean r31 = (Boolean) r30.getValue();
            if (r31 == null) goto L88;
            boolean r32 = r31.booleanValue();
        L89:
            if (r32 == true) goto L100;
            if (((Boolean) vm2.d.c4.getValue(null, vm2.d.a[260(0x104, float:3.64E-43)])).booleanValue() == true) goto L93;
        L97:
            boolean r33 = true;
        L98:
            if (r33 == false) goto L100;
            r1 = true;
            goto L101
        L93:
            if (hd0.c.f().h() == false) goto L95;
        L96:
            r33 = false;
            goto L98
        L95:
            if (hd0.c.f().j() == false) goto L97;
        L88:
            r32 = false;
        L47:
            if (hd0.c.f().j() == false) goto L53;
            cj0.c r34 = PaidLinkMicContext.Companion.a();
            if (r34 == null) goto L53;
            if (r34.isPaidLinkOn() != true) goto L53;
            boolean r35 = true;
        L54:
            if (r35 == true) goto L81;
            if (hd0.c.f().j() == false) goto L64;
            IInteractService r36 = (IInteractService) k.f(IInteractService.class);
            if (r36 == null) goto L60;
            long r37 = r36.getGuestApplyPaidAmount();
        L62:
            if (r37 <= 0) goto L64;
            boolean r38 = true;
        L65:
            if (r38 == true) goto L81;
            if (hd0.c.f().h() == false) goto L77;
            l.n2.getClass();
            l r39 = l.a.a();
            if (r39 != null) goto L71;
        L72:
            IVoiceChatGuestService.Companion.getClass();
            IVoiceChatGuestService r40 = IVoiceChatGuestService.a.a();
            if (r40 == null) goto L77;
            if (r40.isCurrentLinkPaid() != true) goto L77;
        L76:
            boolean r41 = true;
        L78:
            if (r41 == false) goto L80;
        L71:
            if (r39.isCurrentLinkPaid() == true) goto L76;
        L77:
            r41 = false;
            goto L78
        L60:
            r37 = 0;
        L64:
            r38 = false;
        L53:
            r35 = false;
            goto L54
        L41:
            r28 = 0;
        L38:
            r27 = null;
        L80:
            r29 = false;
        L27:
            r24 = "";
            goto L29
        L22:
            if (hd0.c.f().h() == true) goto L100;
            goto L23
        }
    }

    public /* synthetic */ ChatMatchWidget() {
        throw null;
    }

    static {
        o = "pop_panel";
    }

    public final void H1() {
        if (this.k == true) goto L5;
        return;
    L5:
        boolean r0 = false;
        this.k = false;
        StringBuilder r1 = new StringBuilder("match link success, isFirstMatch: ");
        e r2 = b6.k0;
        r1.append((Boolean) r2.getValue());
        r1.append(" , current match type: ");
        r1.append(this.j);
        ALogger.i("ChatMatchWidget", r1.toString());
        String r3 = this.j;
        if ((!StringsKt.isBlank(r3)) == true) goto L9;
        r3 = null;
    L9:
        if (r3 != null) goto L11;
        return;
    L11:
        if (((Boolean) r2.getValue()).booleanValue() == false) goto L14;
        com.bytedance.android.livesdk.sharedpref.f.d(r2, Boolean.FALSE);
    L15:
        r0 = true;
    L16:
        ALogger.i("ChatMatchWidget", "showToast " + r0);
        if (r0 == false) goto L21;
        UtilityKotlinExtentionsKt.s(1000, false, false, ChatMatchWidget$onLinkSuccess$2$1.INSTANCE, 6);
        return;
    L21:
        return;
    L14:
        if (Intrinsics.areEqual(ChatMatchViewModel.ENTER_METHOD_SHAKE, this.j) == false) goto L16;
        goto L15
    }

    public final void onCreate() {
        ALogger.d("ChatMatchWidget", "onCreate");
        super.onCreate();
        Pair r1 = com.bytedance.live.datacontext.d.a(new ChatMatchWidget$onCreate$pair$1(this));
        this.a = (ChatMatchViewModel) r1.getFirst();
        this.c = (Disposable) r1.getSecond();
        com.bytedance.live.datacontext.b.a((DataContext) r1.getFirst(), "ChatMatchWidget");
        this.h = ((Boolean) ((Widget) this).dataCenter.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        ChatMatchViewModel r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r0.setAnchor(this.h);
        ChatMatchViewModel r2 = this.a;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        r2.getMatchDialogState().observeForever(new c(this));
        o r3 = j0.l().c(x.class);
        if ((r3 instanceof t) == true) goto L11;
        r3 = null;
    L11:
        t r4 = (t) r3;
        String r5 = "";
        boolean r6 = true;
        if (r4 == null) goto L56;
        ChatMatchViewModel r7 = this.a;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        if (r7.getHasAutoApply() == true) goto L56;
        if (TextUtils.equals("draw", (String) r4.getMap().get("action_type")) == true) goto L56;
        if (Intrinsics.areEqual(r4.B(), ChatMatchViewModel.ENTER_METHOD_MATCH) == false) goto L25;
    L28:
        ChatMatchViewModel r8 = this.a;
        if (r8 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L31:
        r8.setHasAutoApply(true);
        cg6.a r9 = this.n.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r9 == null) goto L37;
        g r10 = r9.O5();
        if (r10 == null) goto L37;
        r10.X0(this.l, false);
    L37:
        if (je0.d.O() == false) goto L44;
        l.n2.getClass();
        l r11 = l.a.a();
        if (r11 == null) goto L56;
        int r12 = bh0.a.a;
        LinkApplyType r13 = LinkApplyType.MATCH;
        LinkMatchType.a r14 = LinkMatchType.Companion;
        String r15 = r4.getMatchType();
        if (r15 != null) goto L43;
        r15 = "";
    L43:
        r14.getClass();
        r11.ec(r13, LinkMatchType.a.a(r15), "chat_match_auto_apply__" + r4.B());
        goto L56
    L44:
        IVoiceChatGuestService.Companion.getClass();
        if (IVoiceChatGuestService.a.a() == null) goto L52;
        IVoiceChatGuestService r16 = IVoiceChatGuestService.a.a();
        if (r16 == null) goto L56;
        int r17 = bh0.a.a;
        String r18 = String.valueOf(com.bytedance.android.live.liveinteract.multianchor.model.b.TYPE_CANCELED_BY_SERVER);
        int r19 = LinkApplyType.MATCH.getValue();
        LinkMatchType.a r20 = LinkMatchType.Companion;
        String r21 = r4.getMatchType();
        if (r21 != null) goto L51;
        r21 = "";
    L51:
        r20.getClass();
        r16.checkAndApply(-1, r18, r19, LinkMatchType.a.a(r21), "chat_match_auto_apply__" + r4.B(), "");
        goto L56
    L52:
        IKtvService r22 = k.n(IKtvService.class);
        int r23 = bh0.a.a;
        String r110 = String.valueOf(com.bytedance.android.live.liveinteract.multianchor.model.b.TYPE_CANCELED_BY_SERVER);
        int r111 = LinkApplyType.MATCH.getValue();
        LinkMatchType.a r24 = LinkMatchType.Companion;
        String r25 = r4.getMatchType();
        if (r25 != null) goto L55;
        r25 = "";
    L55:
        r24.getClass();
        r22.checkMatchAndApply(-1, r110, r111, LinkMatchType.a.a(r25), "chat_match_auto_apply__" + r4.B(), "");
        goto L56
    L25:
        if (Intrinsics.areEqual(r4.B(), ChatMatchViewModel.ENTER_METHOD_SHAKE) == true) goto L28;
        if (Intrinsics.areEqual(r4.B(), ChatMatchViewModel.ENTER_METHOD_CONNECTION_MATCH_RESULT) == true) goto L28;
    L56:
        this.i = new fk0.a();
        this.d = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager");
        if (this.h == false) goto L59;
    L71:
        t r26 = j0.l().c(x.class);
        if (r26 == null) goto L90;
        if ((r26 instanceof t) == false) goto L90;
        t r27 = r26;
        String r28 = r27.getMatchType();
        if (r28 != null) goto L78;
    L81:
        if (r6 == true) goto L87;
        String r29 = r27.B();
        if (r29 == null) goto L86;
        r5 = r29;
    L86:
        this.j = r5;
    L88:
        hk0.a.a = hk0.a.b;
        hk0.a.c = hk0.a.d;
        goto L90
    L87:
        hk0.a.a.clear();
        hk0.a.b.clear();
        hk0.a.c = 0;
        hk0.a.d = 0;
        goto L88
    L78:
        if (r28.length() == 0) goto L81;
        r6 = false;
    L90:
        if (this.m == false) goto L96;
        ChatMatchViewModel r30 = this.a;
        if (r30 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L94:
        r30.loadShakeSetting();
        return;
    L96:
        return;
    L59:
        if (vm2.d.e().c() == false) goto L71;
        if (this.m == false) goto L71;
        this.e = new ShakeUtils(((Widget) this).context, h.b0().a());
        IMiddlewareUserService r31 = k.f(IMiddlewareUserService.class);
        if (r31 == null) goto L67;
        com.bytedance.android.livesdk.user.e r32 = r31.user();
        if (r32 == null) goto L67;
        boolean r33 = r32.isLogin();
    L68:
        ShakeUtils r34 = this.e;
        if (r34 == null) goto L71;
        r34.b = new d(this, r33);
    L67:
        r33 = false;
        goto L68
    }

    public final void onDestroy() {
        ALogger.d("ChatMatchWidget", "onDestroy");
        super.onDestroy();
        ChatMatchViewModel r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        if (r0 == null) goto L7;
        r0.release();
    L7:
        Disposable r1 = this.c;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("disposable");
    L10:
        if (r1 == null) goto L12;
        r1.dispose();
    L12:
        this.f.clear();
        ChatMatchDialog r2 = this.b;
        if (r2 != null) goto L15;
    L17:
        ShakeUtils r3 = this.e;
        if (r3 == null) goto L20;
        r3.b = null;
    L20:
        if (r3 == null) goto L23;
        r3.a = null;
    L23:
        if (((Boolean) k6.a.getValue()).booleanValue() == false) goto L26;
        ((Widget) this).widgetCallback = null;
        return;
    L26:
        return;
    L15:
        if (r2.isShowing() == false) goto L17;
        wq(r2);
        goto L17
    }

    public final void yq() {
        ChatMatchViewModel r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r0.release();
        ChatMatchDialog r1 = this.b;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.isShowing() == false) goto L12;
        wq(r1);
        return;
    }

    public final void onPause() {
        super.onPause();
        ShakeUtils r0 = this.e;
        if (r0 == null) goto L13;
        r0.c = true;
        if (r0.m.isEnableChatMatchShakeRegisterOpt() == true) goto L10;
        SensorManager r2 = r0.a;
        if (fna.g.d() == true) goto L9;
        r2.unregisterListener(r0);
        goto L13
    L9:
        r2.unregisterListener(r0);
        ona.b.c(new ona.a(r0.hashCode(), null));
        goto L13
    L10:
        Disposable r1 = r0.n;
        if (r1 == null) goto L13;
        r1.dispose();
    L13:
        ChatMatchDialog r3 = this.b;
        if (r3 != null) goto L16;
    L18:
        yq();
        return;
    L16:
        if (r3.isShowing() == false) goto L18;
        this.g = true;
        goto L18
    }

    public final void onResume() {
        super.onResume();
        final ShakeUtils r0 = this.e;
        if (r0 == null) goto L12;
        r0.c = false;
        if (r0.m.isEnableChatMatchShakeRegisterOpt() == false) goto L15;
        TokenCert r2 = ik0.b.a;
        SensorManager r3 = r0.a;
        Intrinsics.checkNotNullParameter(r3, "sensorManager");
        r0.n = Flowable.create(new ik0.a(r3), BackpressureStrategy.LATEST).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ik0.c(r0), new ik0.d());
        goto L12
    L15:
        SensorManager r4 = r0.a;     // Catch: BPEAException -> L8
        r4.registerListener(r0, g80.f.b(r4, ShakeUtils.o), 2);     // Catch: BPEAException -> L8
    L8:
        e = move-exception;
        ALogger.e("ShakeUtils", e);
    L12:
        if (this.g == false) goto L17;
        this.g = false;
        f2.b(2131916554, 0);
        return;
    }

    public final void onStop() {
        super.onStop();
        ChatMatchDialog r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        wq(r0);
        return;
    }

    public static void wq(ChatMatchDialog r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public ChatMatchWidget(boolean r2, j1 r3) {
        Intrinsics.checkNotNullParameter(r3, "multiLinkRoomScopeProvider");
        this.m = r2;
        this.n = r3;
        this.f = new CompositeDisposable();
        this.j = "";
        this.l = new b(this);
    }

    public static void xq(ChatMatchDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "ChatMatchWidget", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "ChatMatchWidget");
    }

    public final void zq(a5 r10, boolean r11, String r12, Boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "requestPage");
        sb6.a r0 = GuestLinkContext.Companion.a();
        if (r0 != null) goto L5;
    L8:
        ALogger.d("ChatMatchWidget", "showMatchDialog " + ((Widget) this).isViewValid + ' ' + ((Widget) this).isDestroyed + " : " + this);
        ChatMatchDialog r1 = this.b;
        if (r1 == null) goto L19;
        if (r1.isShowing() == false) goto L19;
        r1.j = r10;
        if (r10 == null) goto L86;
        TextView r14 = r1.x;
        if (r14 == null) goto L87;
        r14.setText(sb2.a.h(r10, "", false));
        return;
    L87:
        return;
    L86:
        return;
    L19:
        if (TextUtils.isEmpty(r12) == true) goto L21;
    L31:
        TalkRoomBusinessFullLinkMonitor r15 = TalkRoomBusinessFullLinkMonitor.a;
        String r2 = o;
        r15.getClass();
        TalkRoomBusinessFullLinkMonitor.x(r2);
        DataCenter r16 = ((Widget) this).dataCenter;
        if (r16 == null) goto L34;
        IRoom r17 = (IRoom) r16.get("data_room", f.c(IRoom.class));
    L35:
        IRoom r3 = r17;
        int r18 = ChatMatchDialog.V;
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r11 == true) goto L44;
        ChatMatchViewModel r5 = this.a;
        if (r5 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L41:
        if (r5.getFromApplyReason() == true) goto L44;
        boolean r6 = false;
    L45:
        ChatMatchViewModel r7 = this.a;
        if (r7 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L48:
        this.b = ChatMatchDialog.a.a(r3, r4, r10, r6, r7, r13);
        FragmentActivity r19 = ContextUtil.contextToFragmentActivity(getContext());
        if (r19 == null) goto L55;
        FragmentManager r110 = r19.getSupportFragmentManager();
        if (r110 == null) goto L55;
        ChatMatchDialog r111 = this.b;
        if (r111 == null) goto L55;
        xq(r111, r110);
    L55:
        if (r11 == true) goto L68;
        ChatMatchViewModel r112 = this.a;
        if (r112 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L60:
        if (r112.getFromApplyReason() == true) goto L68;
        if (TextUtils.equals("pop_guide", o) == false) goto L88;
        ChatMatchViewModel r113 = this.a;
        if (r113 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L67:
        r113.startAutoDismissCount();
        return;
    L88:
        return;
    L68:
        final ChatMatchDialog r114 = this.b;
        if (r114 != null) goto L71;
        return;
    L71:
        if (hd0.c.f().j() == false) goto L73;
        Integer r115 = (Integer) ((ge1.a) hd0.c.f()).b;
    L74:
        r114.Z90(r115.intValue());
        final ChatMatchViewModel r8 = r114.h;
        if (r8 != null) goto L77;
        return;
    L77:
        if (Intrinsics.areEqual((Boolean) r8.getMatchingState().getValue(), Boolean.TRUE) == false) goto L80;
        return;
    L80:
        if (r8.getWaitingCount().getValue() == null) goto L84;
        View r116 = r114.getView();
        if (r116 == null) goto L92;
        r116.post(new ChatMatchDialog$startMatch$$inlined$let$lambda$1(r8, r114));
        return;
    L92:
        return;
    L84:
        ChatMatchViewModel.startMatch$default(r8, r114.g, false, 0, 2, null);
        return;
    L73:
        r115 = -1;
    L44:
        r6 = true;
        goto L45
    L34:
        r17 = null;
        goto L35
    L21:
        if (Intrinsics.areEqual(Boolean.valueOf(this.h), Boolean.TRUE) == true) goto L29;
        Integer r117 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r117 == null) goto L29;
        if (r117.intValue() != 2) goto L29;
        String r118 = "normal_panel";
    L30:
        o = r118;
    L29:
        r118 = "pop_panel";
        goto L30
    L5:
        if (r0.a != true) goto L8;
        ALogger.i("ChatMatchWidget", "showMatchDialogForShake return, cause: guestlink");
    }

    public static /* synthetic */ void Aq(ChatMatchWidget r1, a5 r2, boolean r3, String r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = "";
    L9:
        if ((r5 & 8) == 0) goto L11;
        Boolean r6 = Boolean.FALSE;
    L12:
        r1.zq(r2, r3, r4, r6);
        return;
    L11:
        r6 = null;
        goto L12
    }
}
