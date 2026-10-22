package com.bytedance.android.live.liveinteract.interact.audience;

import am2.x;
import android.content.Context;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.chatroom.model.OpenPanelType;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.LinkDialog;
import com.bytedance.android.live.liveinteract.interact.audience.context.InteractAnchorContext;
import com.bytedance.android.live.liveinteract.interact.audience.fragment.v2.InteractAudienceContainerFragmentV2;
import com.bytedance.android.live.liveinteract.interact.audience.ui.InteractAudienceAlertWindow;
import com.bytedance.android.live.liveinteract.plantform.core.RtcManager;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.plantform.widgt.BaseAnchorLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.widgt.s;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.utils.r;
import com.bytedance.android.livesdk.chatroom.interact.model.v;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.utils.g0;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.y0;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.link.model.l6;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo;
import com.bytedance.android.livesdkapi.interact.data.LinkConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.livelink.kmp.api.base.config.Character;
import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;
import com.bytedance.live.livelink.kmp.api.base.config.StreamType;
import com.bytedance.live.livelink.kmp.api.base.video.ViewType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import hh1.v0;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import uf2.m1;
import uf2.z;
import zg1.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u00052\u00020\u00062\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/InteractAudienceAnchorWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/widgt/BaseAnchorLinkWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lhe0/a$a;", "Lcom/bytedance/android/live/liveinteract/plantform/base/d;", "Lvlc/l;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractAudienceAnchorWidget extends BaseAnchorLinkWidget<ILinkPlayerInfoBridge> implements Observer<KVData>, he0.a.InterfaceC0218a, com.bytedance.android.live.liveinteract.plantform.base.d, vlc.l {
    public y n;
    public InteractAudienceVideoWindowManager o;
    public boolean p;
    public qi6.g q;
    public he0.a r;
    public final CompositeDisposable s;
    public final com.bytedance.android.live.liveinteract.interact.audience.a t;
    public gd0.d u;
    public boolean v;
    public vlc.d w;
    public long x;
    public int y;
    public final v0 z;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ InteractAudienceAnchorWidget a;

        public a(InteractAudienceAnchorWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.showInviteAndPermitDialog();
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ InteractAudienceAnchorWidget a;

        public b(InteractAudienceAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            a1 r2 = (a1) r1;
            this.a.getClass();
        }
    }

    public final int getLayoutId() {
        return 2131567748;
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return 4;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseAnchorLinkWidget, uf0.a
    public final void onPermitSuccess(String r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseAnchorLinkWidget
    public final int zq() {
        return 1;
    }

    public final void Eq() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L8;
        Boolean r1 = Boolean.FALSE;
        if (((Boolean) r0.get("data_talk_room_admin_allowed_flag", r1)).booleanValue() == false) goto L9;
        TalkRoomLogUtils.q1("interact_chat", ((Boolean) com.bytedance.android.livesdk.sharedpref.c.v1.getValue()).booleanValue());
        r0.put("data_talk_room_admin_allowed_flag", r1);
        return;
    L9:
        return;
    }

    public final void Fq() {
        int r0 = jf0.b.a;
        IRoom r1 = getRoom();
        if (r1 == null) goto L5;
        ICircleInfo r2 = r1.getCircleInfo();
    L6:
        jf0.b.k("", r2);
        y r3 = this.n;
        if (r3 == null) goto L16;
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L11;
        String r5 = (String) r4.get("data_room_unique_id", "");
    L12:
        l6 r6 = tc0.c.i(r5).O;
        if ((r6 instanceof l6) == true) goto L15;
        r6 = null;
    L15:
        r3.K(r6);
        goto L16
    L11:
        r5 = null;
    L16:
        boolean r7 = ((com.bytedance.android.live.liveinteract.service.f) ((IInteractService) jc1.k.n(IInteractService.class)).getInteractAudienceService()).P();
        ALogger.w("ttlive_link_audience", "updateFirstVideoFrame isLinkAudience = " + r7);
        if (r7 == true) goto L19;
        return;
    L19:
        pc0.e r8 = jc1.k.n(IMultiLinkServiceExternal.class).createRevRtcData();
        if (r8 == null) goto L105;
        StringBuilder r9 = new StringBuilder("updateFirstVideoFrame isEngineOn = ");
        r9.append(r8.b);
        r9.append(", size = ");
        DataCenter r10 = ((Widget) this).dataCenter;
        if (r10 == null) goto L24;
        String r11 = (String) r10.get("data_room_unique_id", "");
    L25:
        l6 r12 = tc0.c.i(r11).O;
        if (r12 == null) goto L30;
        List r13 = r12.getMLinkUsers();
        if (r13 == null) goto L30;
        Integer r14 = Integer.valueOf(r13.size());
    L31:
        r9.append(r14);
        ALogger.w("ttlive_link_audience", r9.toString());
        if (r8.b == true) goto L44;
        DataCenter r15 = ((Widget) this).dataCenter;
        if (r15 == null) goto L36;
        String r16 = (String) r15.get("data_room_unique_id", "");
    L37:
        l6 r17 = tc0.c.i(r16).O;
        if (r17 == null) goto L42;
        List r18 = r17.getMLinkUsers();
        if (r18 == null) goto L42;
        int r19 = r18.size();
    L43:
        if (r19 <= 1) goto L105;
    L42:
        r19 = 0;
        goto L43
    L36:
        r16 = null;
    L44:
        RtcManager r20 = yq();
        if (r20 == null) goto L47;
        fi6.a r21 = r20.getInteractConfig();
    L48:
        p2(r21);
        RtcManager r22 = this.c;
        if (r22 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("rtcManager");
    L51:
        if (r22 == null) goto L53;
        Intrinsics.checkNotNullParameter(this, "rtcListener");
        r22.c = this;
    L53:
        RtcManager r23 = yq();
        if (r23 == null) goto L56;
        r23.a0(pg6.a.a(s.a(r8)), this.r);
    L56:
        RtcManager r24 = yq();
        if (r24 == null) goto L59;
        r24.d0(true);
    L59:
        RtcManager r25 = yq();
        if (r25 == null) goto L62;
        r25.f();
    L62:
        RtcManager r26 = yq();
        if (r26 == null) goto L73;
        DataCenter r27 = ((Widget) this).dataCenter;
        if (r27 == null) goto L67;
        String r28 = (String) r27.get("data_room_unique_id", "");
    L68:
        l6 r29 = tc0.c.i(r28).O;
        if (r29 == null) goto L71;
        String r30 = r29.getRtcExtInfo();
    L72:
        r26.c(r30);
        goto L73
    L71:
        r30 = null;
        goto L72
    L67:
        r28 = null;
    L73:
        RtcManager r31 = yq();
        if (r31 == null) goto L84;
        DataCenter r32 = ((Widget) this).dataCenter;
        if (r32 == null) goto L78;
        String r33 = (String) r32.get("data_room_unique_id", "");
    L79:
        l6 r34 = tc0.c.i(r33).O;
        if (r34 == null) goto L82;
        String r35 = r34.getLiveCoreExtInfo();
    L83:
        r31.J(r35);
        goto L84
    L82:
        r35 = null;
        goto L83
    L78:
        r33 = null;
    L84:
        RtcManager r36 = yq();
        if (r36 == null) goto L93;
        ei6.a r37 = r36.a;
        if (r37 == null) goto L91;
        ri6.b r38 = r37.r();
        if (r38 == null) goto L91;
        boolean r39 = r38.C();
    L92:
        Boolean r40 = Boolean.valueOf(r39);
    L95:
        if (Intrinsics.areEqual(r40, Boolean.TRUE) == false) goto L100;
        RtcManager r41 = yq();
        if (r41 == null) goto L100;
        r41.N0(true, "pk switch normal");
    L100:
        if (vm2.f.a() == false) goto L104;
        com.bytedance.android.live.pushstream.d r42 = this.z.getLiveStream();
        if (r42 == null) goto L105;
        r42.I();
        goto L105
    L104:
        yq().b.M();
    L91:
        r39 = false;
        goto L92
    L93:
        r40 = null;
        goto L95
    L47:
        r21 = null;
    L30:
        r14 = null;
        goto L31
    L24:
        r11 = null;
    L105:
        RtcManager r43 = yq();
        if (r43 == null) goto L109;
        Map<String, yb6.j> r44 = r43.z;
        if (r44 == null) goto L109;
    L110:
        Iterator<Map.Entry<String, yb6.j>> r45 = r44.entrySet().iterator();
    L112:
        if (r45.hasNext() == false) goto L142;
        Map.Entry<String, yb6.j> r46 = r45.next();
        String r47 = r46.getKey();
        yb6.j r48 = r46.getValue();
        if (TextUtils.equals(r47, jc1.k.n(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().y()) == true) goto L112;
        DataCenter r49 = ((Widget) this).dataCenter;
        if (r49 == null) goto L118;
        String r50 = (String) r49.get("data_room_unique_id", "");
    L119:
        l6 r51 = tc0.c.i(r50).O;
        if (r51 == null) goto L129;
        List r52 = r51.getMLinkUsers();
        if (r52 == null) goto L129;
        Iterator r53 = r52.iterator();
    L125:
        if (r53.hasNext() == false) goto L129;
        if (TextUtils.equals(((com.bytedance.android.livesdk.link.model.bridge.k) r53.next()).getInteractId(), r47) == false) goto L125;
        boolean r54 = true;
    L130:
        if (r54 == false) goto L112;
        if ((r48 instanceof SurfaceView) == true) goto L133;
        if ((r48 instanceof TextureView) == true) goto L136;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r55 = ILiveWrappedLivePusher.a.b();
        if (r55 == null) goto L140;
        z.a r56 = r55.buildLayerControlLayer(r48);
    L141:
        b4(r47, r56, 0, 0);
        goto L112
    L140:
        r56 = null;
        goto L141
    L136:
        L0(r47, (TextureView) r48, 0, 0);
        goto L112
    L133:
        h1(r47, (SurfaceView) r48, 0, 0);
    L129:
        r54 = false;
        goto L130
    L118:
        r50 = null;
        goto L119
    L142:
        return;
    L109:
        r44 = MapsKt.emptyMap();
        goto L110
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.d
    public final int H() {
        y r0 = this.n;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.b();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void M1() {
        he0.a r0 = this.r;
        if ((r0 instanceof he0.a) == true) goto L5;
        r0 = null;
    L5:
        if (r0 == null) goto L12;
        j1 r1 = r0.i;
        if (r1 == null) goto L12;
        dn0.c r2 = (dn0.c) r1.getScopeServiceOrNullInMultiLinkRoom(dn0.c.class);
        if (r2 == null) goto L12;
        r2.H4("InteractAudienceAnchorWidget onEndSuccess");
    L12:
        if (this.v == false) goto L16;
        this.v = false;
        gd0.d r3 = this.u;
        if (r3 == null) goto L18;
        r3.onSuccess();
        return;
    L18:
        return;
    L16:
        super.M1();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.d
    public final com.bytedance.android.live.liveinteract.plantform.core.f X4() {
        com.bytedance.android.live.liveinteract.plantform.core.f r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.base.d
    public final y getLinkUserCenter() {
        if (this.n == null) goto L5;
    L14:
        y r0 = this.n;
        if (r0 == null) goto L18;
        return r0;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.core.LinkUserInfoCenterV2");
    L5:
        if (vm2.d.q0().isUserInfoCenterForwardInit() == false) goto L13;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r1 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if ((r1 instanceof y) == true) goto L9;
        r1 = null;
    L9:
        y r2 = (y) r1;
        if (r2 != null) goto L12;
        r2 = new y(getRoom(), ((Widget) this).dataCenter);
    L12:
        this.n = r2;
        goto L14
    L13:
        this.n = new y(getRoom(), ((Widget) this).dataCenter);
        goto L14
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        int r0 = jf0.b.a;
        TalkRoomLogUtils.J(null, 11);
        DataCenter r1 = ((Widget) this).dataCenter;
        long r2 = this.x;
        int r4 = this.y;
        ICircleInfo r5 = getRoom().getCircleInfo();
        String r6 = "off";
        Intrinsics.checkNotNullParameter("off", "actionModeStatus");
        HashMap r7 = new HashMap();
        r7.put("live_type", "video_live");
        r7.put("function_type", "audience");
        r7.put("shoot_way", "null");
        r7.put("auction_mode_status", "off");
        Integer r8 = (Integer) com.bytedance.android.livesdk.sharedpref.c.t0.getValue();
        if (r8 != null) goto L6;
    L8:
        Object r9 = "on";
    L9:
        r7.put("reminder_type", r9);
        r7.put("duration", String.valueOf((System.currentTimeMillis() - r2) / ((long) 1000)));
        if (r4 == 0) goto L12;
        int r10 = r4 - 1;
    L13:
        r7.put("connect_pcu", String.valueOf(r10));
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.v1.getValue()).booleanValue() == false) goto L16;
        Object r11 = "on";
    L17:
        r7.put("admin_switch_type", r11);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.m1.getValue()).booleanValue() == false) goto L20;
        Object r12 = "on";
    L21:
        r7.put("fans_apply_switch_type", r12);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.K0.getValue()).booleanValue() == false) goto L24;
        r6 = "on";
    L24:
        r7.put("apply_approve_switch_type", r6);
        if (r5 == null) goto L29;
        String r13 = r5.getCircleName();
        if (r13 == null) goto L29;
        r7.put("circle_name", r13);
    L29:
        TalkRoomLogUtils.b1(r7, Integer.valueOf(je0.d.f()));
        r7.put("play_mode", u0.b());
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == false) goto L32;
        String r14 = "1";
    L33:
        r7.put("is_invite_only", r14);
        TalkRoomLogUtils.H0(r7);
        if (r1 == null) goto L37;
        String r15 = (String) r1.get("data_room_video_talk_log_over_for_over_path", "");
        if (r15 == null) goto L37;
    L39:
        if (TextUtils.isEmpty(r15) == true) goto L43;
        r7.put("over_path", r15);
        if (r1 == null) goto L44;
        r1.put("data_room_video_talk_log_over_for_over_path", "");
    L44:
        j0.l().sendLog("anchor_audience_connection_over", r7, new Object[]{IRoom.class, x.class});
        vlc.d r3 = this.w;
        if (r3 == null) goto L47;
        r3.removeMessageListener(this);
    L47:
        super.onDestroy();
        throw null;
    L43:
        r7.put("over_path", "live_over");
    L37:
        r15 = "";
        goto L39
    L32:
        r14 = "0";
        goto L33
    L20:
        r12 = "off";
        goto L21
    L16:
        r11 = "off";
        goto L17
    L12:
        r10 = 0;
        goto L13
    L6:
        if (r8.intValue() != 2) goto L8;
        r9 = "off";
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.d
    public final void showInviteAndPermitDialog() {
        DataCenter r0 = ((Widget) this).dataCenter;
        int r1 = LinkDialog.v;
        LinkDialog r2 = new LinkDialog.a(r0, this).a();
        r2.e = InteractAudienceContainerFragmentV2.aa0(r2, ((Widget) this).dataCenter);
        FragmentActivity r3 = ((Widget) this).context;
        if ((r3 instanceof FragmentActivity) == false) goto L8;
        if (r3 == null) goto L7;
        Cq(r2, r3.getSupportFragmentManager());
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.d
    public final com.bytedance.android.live.pushstream.d xd() {
        return this.z.getLiveStream();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.d
    public final void Zn() {
        u r0 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        StringBuilder r1 = new StringBuilder("params : openPanelType = ");
        com.bytedance.live.datacontext.m r2 = r0.c();
        String r3 = null;
        if (r2 == null) goto L5;
        Integer r4 = (Integer) r2.getValue();
    L6:
        r1.append(r4);
        r1.append(", platformActivityId = ");
        com.bytedance.live.datacontext.m r5 = r0.p();
        if (r5 == null) goto L9;
        String r6 = (String) r5.getValue();
    L10:
        r1.append(r6);
        ALogger.d("open_panel_for_schema", r1.toString());
        com.bytedance.live.datacontext.m r7 = r0.c();
        if (r7 == null) goto L13;
        Integer r8 = (Integer) r7.getValue();
    L14:
        com.bytedance.live.datacontext.m r9 = r0.p();
        if (r9 == null) goto L17;
        String r10 = (String) r9.getValue();
    L18:
        com.bytedance.android.live.liveinteract.plantform.utils.x.P(r8, r10);
        if (fj0.e.h() == false) goto L37;
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.e() == false) goto L32;
        qd0.b r11 = ((IInteractService) jc1.k.n(IInteractService.class)).getInteractAudienceService();
        Context r12 = ((Widget) this).context;
        com.bytedance.live.datacontext.m r13 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).p();
        if (r13 == null) goto L25;
        r3 = (String) r13.getValue();
    L25:
        ((com.bytedance.android.live.liveinteract.service.f) r11).getClass();
        if (fj0.c.a() == false) goto L29;
        if (r12 == null) goto L29;
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r3, "source");
        cj0.h.b(r12, r3);
    L29:
        com.bytedance.live.datacontext.m r14 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).c();
        if (r14 == null) goto L41;
        r14.setValue(Integer.valueOf(OpenPanelType.NONE.getValue()));
        return;
    L41:
        return;
    L32:
        DataCenter r15 = ((Widget) this).dataCenter;
        int r16 = LinkDialog.v;
        LinkDialog r17 = new LinkDialog.a(r15, this).b(15);
        FragmentActivity r18 = ((Widget) this).context;
        if (r18 == null) goto L36;
        Cq(r17, r18.getSupportFragmentManager());
        return;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L37:
        com.bytedance.live.datacontext.m r19 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).c();
        if (r19 == null) goto L44;
        r19.setValue(Integer.valueOf(OpenPanelType.NONE.getValue()));
        return;
    L44:
        return;
    L17:
        r10 = null;
        goto L18
    L13:
        r8 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.d
    public final boolean isEngineOn() {
        return yq().l;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void o() {
        super.o();
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.put("data_interact_debug_info", new jd0.e());
    L5:
        com.bytedance.android.live.liveinteract.plantform.base.g r1 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r1 == null) goto L15;
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L12;
        Boolean r3 = (Boolean) r2.get("data_is_anchor", Boolean.FALSE);
        if (r3 == null) goto L12;
        boolean r4 = r3.booleanValue();
    L13:
        r1.o6("normal", r4);
        return;
    L12:
        r4 = false;
        goto L13
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        if (yq().I.getStreamUrlExtraSafely().getAnchorInteractProfile() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        qi6.g r1 = qi6.g.k;
    L9:
        this.q = r1;
        this.r = new he0.a(r1, this, this);
        this.m.setScene(4);
        Pair r2 = com.bytedance.live.datacontext.d.a(AnonymousClass1.INSTANCE);
        InteractAnchorContext r3 = (InteractAnchorContext) r2.component1();
        Disposable r4 = (Disposable) r2.component2();
        com.bytedance.live.datacontext.b.a(r3, "interact_anchor_service");
        r3.getService().d(this);
        this.s.add(r4);
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r5 = MultiRevenueDataContext.a.d();
        if (r5 == null) goto L12;
        r5.m(this, SceneType.SCENE_INTERACT_AUDIENCE);
    L12:
        ((Widget) this).dataCenter.observe("cmd_force_close_linkin", this);
        ((Widget) this).dataCenter.observe("cmd_force_close_linkin_before_videotalk", this);
        getLinkUserCenter().Q4(this.t);
        IRoom r6 = getRoom();
        ViewGroup r7 = ((Widget) this).containerView;
        if (r7 == null) goto L64;
        FrameLayout r8 = (FrameLayout) r7;
        y r9 = this.n;
        FragmentActivity r10 = ((Widget) this).context;
        if (r10 == null) goto L62;
        InteractAudienceVideoWindowManager r11 = new InteractAudienceVideoWindowManager(r6, true, r8, r9, r10, this);
        this.o = r11;
        r11.y(((Widget) this).dataCenter);
        InteractAudienceVideoWindowManager r12 = this.o;
        if (r12 == null) goto L19;
        r12.l = new a(this);
    L19:
        if (r12 == null) goto L21;
        r12.a = this.p;
        r12.i(true);
    L21:
        InteractAudienceVideoWindowManager r13 = this.o;
        if (r13 == null) goto L25;
        r13.z(false);
    L25:
        if (tb1.d.a == true) goto L29;
        tc0.c.h().getClass();
        if (vm2.d.S() == true) goto L29;
        f2.b(2131919344, 1);
    L29:
        tc0.c.h().getClass();
        vlc.d r14 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager");
        this.w = r14;
        if (r14 == null) goto L32;
        r14.addMessageListener(MessageType.LINK_OFFICIAL_KICK_OUT.getKey(), this);
    L32:
        vlc.d r15 = this.w;
        if (r15 == null) goto L35;
        r15.addMessageListener(MessageType.LINKER.getKey(), this);
    L35:
        this.x = System.currentTimeMillis();
        this.s.add(xs2.b.a().b(a1.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this)));
        if (this.p == false) goto L38;
    L42:
        StringBuilder r16 = new StringBuilder("onCreate resumeAudienceContent = ");
        DataCenter r17 = ((Widget) this).dataCenter;
        String r18 = null;
        if (r17 == null) goto L45;
        String r19 = (String) r17.get("data_room_unique_id", "");
    L46:
        r16.append(tc0.c.i(r19).O);
        ALogger.w("ttlive_link_audience", r16.toString());
        int r20 = jf0.b.a;
        TalkRoomLogUtils.H(null, null, false, null, 23);
        DataCenter r21 = ((Widget) this).dataCenter;
        if (r21 == null) goto L53;
        jd0.c r22 = (jd0.c) r21.get("data_gift_message_board_linkmic_event", new jd0.c(0));
        if (r22 == null) goto L53;
        if (r2.a(r22.a) == false) goto L53;
        xs2.b.a().post(r22);
        ((Widget) this).dataCenter.put("data_gift_message_board_linkmic_event", null);
    L53:
        DataCenter r23 = ((Widget) this).dataCenter;
        if (r23 == null) goto L57;
        r18 = (String) r23.get("data_room_unique_id", "");
    L57:
        if (tc0.c.i(r18).O == null) goto L59;
        Fq();
    L59:
        com.bytedance.android.live.liveinteract.linksecurity.a r24 = com.bytedance.android.live.liveinteract.linksecurity.a.g;
        r24.j();
        r24.k(((Widget) this).dataCenter);
        return;
    L45:
        r19 = null;
        goto L46
    L38:
        if (PaidLinkMicContext.Companion.a() == null) goto L42;
        DataCenter r25 = ((Widget) this).dataCenter;
        if (r25 == null) goto L42;
        r25.put("data_paid_link_profile_show", Boolean.FALSE);
        goto L42
    L62:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L64:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    L8:
        r1 = qi6.g.j;
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    public final void onPause() {
        if (yq().l == false) goto L5;
        yq().onPause();
        getLinkUserCenter().v();
    L5:
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        if (yq().l == false) goto L5;
        yq().onResume();
        getLinkUserCenter().r0();
    L5:
        g0.c(4);
        g0.b();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.d
    public final InteractAudienceVideoWindowManager windowManager() {
        return this.o;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseAnchorLinkWidget
    public final v0 wq() {
        return this.z;
    }

    @Override // he0.a.InterfaceC0218a
    public final boolean B7(String r3) {
        y r0 = this.n;
        if (r0 == null) goto L8;
        ILinkPlayerInfoBridge r4 = r0.o("", r3);
        if (r4 != null) goto L10;
        return true;
    L10:
        return true ^ r4.isBackground();
    L8:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseAnchorLinkWidget, uf0.a
    public final void Ff(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
        super.Ff(r2);
    }

    @Override // he0.a.InterfaceC0218a
    public final String Kn(String r2) {
        y r0 = this.n;
        if (r0 == null) goto L8;
        IBaseUser r3 = r0.U4(r2);
        if (r3 == null) goto L8;
        String r4 = r3.getIdString();
        if (r4 == null) goto L8;
        return r4;
    L8:
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseAnchorLinkWidget, uf0.a
    public final void eo(z0 r3) {
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        IBaseUser r0 = (IBaseUser) vh7.f.c(IBaseUser.class);
        r0.setIdString(r3.getFromUserIdStr());
        String r4 = r3.getSecFromUserId();
        Intrinsics.checkNotNullParameter(r0, "$this$secUidExt");
        r0.setCastSecUid(r4);
        g0(r0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.d
    public final void finishInteract(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reqFrom");
        ((Widget) this).dataCenter.put("data_interact_number_dot_show", "");
        xq(this.d, r4);
        Eq();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.d
    public final void g0(IBaseUser r11) {
        Intrinsics.checkNotNullParameter(r11, "user");
        boolean r5 = false;
        if (jc1.k.n(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().getChannelId() == 0) goto L6;
        f2.b(2131917544, 0);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r11, "user");
        if (vm2.g.a() == false) goto L24;
        RtcManager r0 = this.c;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rtcManager");
    L11:
        if (r0 != null) goto L13;
    L15:
        if (r5 == true) goto L20;
        long r1 = System.currentTimeMillis();
        this.h.put(r11.getIdString(), Long.valueOf(r1));
        this.i.put(r11.getIdString(), Long.valueOf(r1));
        this.j = "apply";
        com.bytedance.android.live.liveinteract.plantform.core.f r2 = this.b;
        if (r2 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L19:
        r2.d();
    L20:
        com.bytedance.android.live.liveinteract.plantform.core.f r3 = this.b;
        if (r3 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L23:
        String r4 = r11.getIdString();
        Intrinsics.checkNotNullParameter(r11, "$this$secUidExt");
        r3.f(r4, r11.getCastSecUid());
        return;
    L13:
        if (r0.l != true) goto L15;
        r5 = true;
        goto L15
    L24:
        RtcManager r6 = this.c;
        if (r6 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("rtcManager");
    L27:
        if (r6 != null) goto L29;
    L31:
        boolean r7 = false;
    L32:
        if (r7 == true) goto L53;
        long r8 = System.currentTimeMillis();
        this.h.put(r11.getIdString(), Long.valueOf(r8));
        this.i.put(r11.getIdString(), Long.valueOf(r8));
        this.j = "apply";
        Iterator<IBaseUser> r9 = this.f.iterator();
    L35:
        if (r9.hasNext() == false) goto L44;
        IBaseUser r10 = r9.next();
        IBaseUser r12 = r10;
        if (Intrinsics.areEqual(r12.getIdString(), r11.getIdString()) == false) goto L41;
        Intrinsics.checkNotNullParameter(r12, "$this$secUidExt");
        String r13 = r12.getCastSecUid();
        Intrinsics.checkNotNullParameter(r11, "$this$secUidExt");
        if (Intrinsics.areEqual(r13, r11.getCastSecUid()) == false) goto L41;
        boolean r14 = true;
    L42:
        if (r14 == false) goto L35;
    L45:
        IBaseUser r15 = r10;
        if (r15 == null) goto L48;
        ALogger.e("ttlive_link", "user already in permitting list " + r15.getIdString());
    L49:
        com.bytedance.android.live.liveinteract.plantform.core.f r16 = this.b;
        if (r16 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L52:
        r16.d();
        return;
    L48:
        this.f.add(r11);
    L41:
        r14 = false;
        goto L42
    L44:
        r10 = null;
        goto L45
    L53:
        this.i.put(r11.getIdString(), Long.valueOf(System.currentTimeMillis()));
        this.j = "apply";
        com.bytedance.android.live.liveinteract.plantform.core.f r17 = this.b;
        if (r17 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L56:
        String r18 = r11.getIdString();
        Intrinsics.checkNotNullParameter(r11, "$this$secUidExt");
        r17.f(r18, r11.getCastSecUid());
        return;
    L29:
        if (r6.l != true) goto L31;
        r7 = true;
        goto L32
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.d
    public final void h2(gd0.d r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.u = r2;
    }

    @Override // he0.a.InterfaceC0218a
    public final boolean isMicRoomHost(String r3) {
        y r0 = this.n;
        if (r0 == null) goto L8;
        ILinkPlayerInfoBridge r4 = r0.o("", r3);
        if (r4 != null) goto L7;
        return false;
    L7:
        return r4.isHost();
    L8:
        return false;
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 == null) goto L16;
        String r5 = r4.getKey();
        int r0 = r5.hashCode();
        if (r0 == (-95319361)) goto L13;
        if (r0 == 1715701863) goto L10;
        return;
    L10:
        if (r5.equals("cmd_force_close_linkin_before_videotalk") == false) goto L17;
        xq(this.d, "stop_intimate_before_big_party");
        return;
    L17:
        return;
    L13:
        if (r5.equals("cmd_force_close_linkin") == false) goto L19;
        xq(this.d, "forbidden_notice");
        return;
    L19:
        return;
    }

    public final void onMessage(tlc.d r15) {
        if (r15 != null) goto L5;
        return;
    L5:
        if ((r15 instanceof y0) == false) goto L10;
        y0 r16 = (y0) r15;
        f2.c(r16.getToastMsg(), 0);
        kickOut(r16.getUserId(), "", "msequence_msg");
        InteractAudienceVideoWindowManager r0 = this.o;
        if (r0 == null) goto L83;
        ((ArrayList) r0.L).add(r16.getUserId());
        return;
    L83:
        return;
    L10:
        if ((r15 instanceof h1) == false) goto L85;
        h1 r17 = (h1) r15;
        String r4 = null;
        if (r17.getMType() != 23) goto L63;
        final InteractAudienceVideoWindowManager r1 = this.o;
        if (r1 != null) goto L16;
        return;
    L16:
        if (r17.getApplyStrongReminderContent() != null) goto L18;
        return;
    L18:
        if (r17.getApplyStrongReminderContent().getUser() == null) goto L92;
        int r3 = r17.getApplyStrongReminderContent().getSource();
        IBaseUser r5 = r17.getApplyStrongReminderContent().getUser();
        if (r3 == 0) goto L93;
        Iterator r6 = ((ArrayList) r1.g).iterator();
    L25:
        if (r6.hasNext() == false) goto L32;
        InteractAudienceAlertWindow r7 = (InteractAudienceAlertWindow) r6.next();
        if (r7.getUser() == null) goto L25;
        if (Objects.equals(r7.getUser().getIdString(), r5.getIdString()) == false) goto L25;
        if (r3 != 2) goto L88;
        r6.remove();
        r1.c.removeView(r7);
        r1.h();
        return;
    L88:
        return;
    L32:
        if (r3 != 2) goto L35;
        return;
    L35:
        if (((ArrayList) r1.f).size() < 2) goto L38;
        return;
    L38:
        if (r.a() == false) goto L96;
        final IBaseUser r18 = r17.getApplyStrongReminderContent().getUser();
        final InteractAudienceAlertWindow r8 = new InteractAudienceAlertWindow(r1.c.getContext());
        if (((ArrayList) r1.g).size() > 0) goto L43;
    L47:
        r8.setAcceptClickListener(new j(r1, r8));
        r8.b = r18;
        r8.a(2131363187).setAnimation("connect_loading.json");
        ImageView r9 = (ImageView) r8.a(2131363623);
        if (r18 == null) goto L50;
        py.k r10 = r18.getAvatarThumbKt();
    L51:
        ImageUtil.loadRoundImage(r9, r10);
        TextView r11 = (TextView) r8.a(2131380902);
        if (r18 == null) goto L54;
        r4 = r18.getNickName();
    L54:
        r11.setText(r4);
        ((TextView) r8.a(2131361963)).setOnClickListener(new lf0.a(r8, r18));
        int r12 = jf0.b.a;
        if (r18 == null) goto L60;
        String r13 = r18.getIdString();
        if (r13 == null) goto L60;
        String r14 = r13;
    L61:
        jf0.b.l(r14, true, null, "seat", true, null, null, null, 8160);
        r8.setCloseListener(new k(r1, r8, r18));
        r1.c.addView(r8);
        ((ArrayList) r1.g).add(r8);
        r1.i(false);
        r1.h();
        return;
    L60:
        r14 = "";
        goto L61
    L50:
        r10 = null;
        goto L51
    L43:
        if (((ArrayList) r1.g).size() != (2 - ((ArrayList) r1.f).size())) goto L47;
        InteractAudienceAlertWindow r19 = (InteractAudienceAlertWindow) ListProtector.remove(r1.g, 0);
        ViewParent r20 = r19.getParent();
        FrameLayout r21 = r1.c;
        if (r20 != r21) goto L47;
        r21.removeView(r19);
        goto L47
    L96:
        return;
    L93:
        return;
    L92:
        return;
    L63:
        if (r17.getMType() != 46) goto L91;
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L67;
        String r22 = (String) r2.get("data_room_unique_id", "");
    L68:
        tc0.c.i(r22).O = r17.getLinkerResumeAudienceContent();
        tc0.c r23 = tc0.c.h();
        l6 r24 = r17.getLinkerResumeAudienceContent();
        if (r24 == null) goto L71;
        String r25 = r24.getRtcExtInfo();
    L72:
        r23.k = r25;
        tc0.c r26 = tc0.c.h();
        l6 r110 = r17.getLinkerResumeAudienceContent();
        if (r110 == null) goto L75;
        r4 = r110.getLiveCoreExtInfo();
    L75:
        r26.m = r4;
        Fq();
        return;
    L71:
        r25 = null;
        goto L72
    L67:
        r22 = null;
        goto L68
    L91:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.t
    public final void p2(fi6.a r5) {
        he0.a r0 = null;
        if (r5 == null) goto L10;
        r5.f = this.r;
        r5.f(LinkConstant.STREAM_BACKGROUND);
        IBaseStreamUrl r2 = getRoom().getStreamUrl();
        if (r2 == null) goto L7;
        String r3 = r2.getRtmpPushUrl();
    L8:
        r5.e = r3;
        r5.h(((Widget) this).context);
        r5.o(this.q);
        r5.i(InteractMode.NORMAL);
        r5.g(Character.ANCHOR);
        r5.d = 1;
        ViewType r4 = ViewType.TEXTURE_VIEW;
        Intrinsics.checkNotNullParameter(r4, "viewType");
        r5.E = r4;
        r5.N = 1000;
        r5.n(StreamType.VIDEO);
        r5.R = true;
        r5.Q = 1000;
        goto L10
    L7:
        r3 = null;
    L10:
        if (vm2.i.k().getEnable() == false) goto L15;
        if (r5 == null) goto L13;
        r5.m = true;
    L13:
        if (r5 == null) goto L15;
        r5.n = vm2.i.k().q7();
    L15:
        he0.a r1 = this.r;
        if ((r1 instanceof he0.a) == false) goto L19;
        r0 = r1;
    L19:
        if (r0 == null) goto L26;
        r0.g = r5;
        j1 r6 = r0.i;
        if (r6 == null) goto L27;
        dn0.c r7 = (dn0.c) r6.getScopeServiceOrNullInMultiLinkRoom(dn0.c.class);
        if (r7 == null) goto L28;
        r7.Se("rtc_init", "NormalStreamMixer_setConfig", false);
        return;
    L28:
        return;
    L27:
        return;
    }

    @Override // he0.a.InterfaceC0218a
    public final int tc(String r3) {
        y r0 = this.n;
        if (r0 == null) goto L8;
        ILinkPlayerInfoBridge r4 = r0.o("", r3);
        if (r4 != null) goto L10;
        return 1;
    L10:
        return r4.getLinkType();
    L8:
        return 0;
    }

    public InteractAudienceAnchorWidget(v0 r2, tc0.c r3) {
        Intrinsics.checkNotNullParameter(r2, "videoClientFactory");
        Intrinsics.checkNotNullParameter(r3, "dataHolder");
        super(r3);
        this.z = r2;
        this.q = qi6.g.j;
        this.s = new CompositeDisposable();
        this.t = new com.bytedance.android.live.liveinteract.interact.audience.a(this);
    }

    public static void Cq(LinkDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "LinkDialog", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "LinkDialog");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void G9(long r3, Exception r5) {
        he0.a r0 = this.r;
        if ((r0 instanceof he0.a) == true) goto L5;
        r0 = null;
    L5:
        if (r0 == null) goto L12;
        j1 r1 = r0.i;
        if (r1 == null) goto L12;
        dn0.c r2 = (dn0.c) r1.getScopeServiceOrNullInMultiLinkRoom(dn0.c.class);
        if (r2 == null) goto L12;
        r2.H4("InteractAudienceAnchorWidget onEndFailed");
    L12:
        if (this.v == false) goto L17;
        this.v = false;
        gd0.d r4 = this.u;
        if (r4 == null) goto L19;
        r4.onFailed(2);
        return;
    L19:
        return;
    L17:
        super.G9(r3, r5);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseAnchorLinkWidget, uf0.a
    public final void L2(String r1, Throwable r2) {
        if ((r2 instanceof ApiServerException) == false) goto L6;
        f2.c(((ApiServerException) r2).getPrompt(), 0);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void R(long r1, Exception r3) {
        super.R(r1, r3);
        f2.h(getContext(), 2131919334, 0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void e1(String r4, long r5) {
        super.e1(r4, r5);
        InteractAudienceVideoWindowManager r6 = this.o;
        if (r6 == null) goto L5;
        r6.a("", r4);
    L5:
        RtcManager r7 = yq();
        if (r7 == null) goto L26;
        Map<String, yb6.j> r8 = r7.z;
        if (r8 == null) goto L36;
        Iterator r9 = ((LinkedHashMap) r8).entrySet().iterator();
    L11:
        if (r9.hasNext() == false) goto L37;
        Map.Entry r10 = (Map.Entry) r9.next();
        String r11 = (String) r10.getKey();
        yb6.j r12 = (yb6.j) r10.getValue();
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r13 = ILiveWrappedLivePusher.a.b();
        if (r13 == null) goto L15;
        z.a r14 = r13.buildLayerControlLayer(r12.a);
    L16:
        if (r14 == null) goto L11;
        InteractAudienceVideoWindowManager r15 = this.o;
        if (r15 == null) goto L11;
        if (r15.F == null) goto L11;
        m1.b r0 = r14.Y();
        DataCenter r16 = r15.F;
        Boolean r1 = Boolean.FALSE;
        ((Boolean) ((android.util.Pair) r16.get("data_broadcast_stream_size_adjusted", android.util.Pair.create(r1, r1))).second).booleanValue();
        s1.w();
        s1.f(8.0f);
        s1.f(36.0f);
        if (r0 == null) goto L25;
        r0.b();
        r0.f();
    L25:
        r14.b();
        goto L11
    L15:
        r14 = null;
        goto L16
    L37:
        return;
    L36:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void f0(long r1, Exception r3) {
        super.f0(r1, r3);
        f2.b(2131919447, 0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseAnchorLinkWidget, uf0.a
    public final void l(String r1, Throwable r2) {
        if ((r2 instanceof ApiServerException) == false) goto L6;
        f2.c(((ApiServerException) r2).getPrompt(), 0);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseAnchorLinkWidget, uf0.a
    public final void e6(String r2, IBaseUser r3, v r4) {
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "result");
        super.e6(r2, r3, r4);
        f2.b(2131918074, 0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.d
    public final void kickOut(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "reqFrom");
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        r5 = "anchor_stop_normal";
    L8:
        com.bytedance.android.live.liveinteract.plantform.core.f r1 = this.b;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L11:
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        r1.e(r3, r4, r5);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void L0(String r2, TextureView r3, int r4, int r5) {
        super.L0(r2, r3, r4, r5);
        y r0 = this.n;
        if (r0 == null) goto L5;
        r0.r(r2);
    L5:
        InteractAudienceVideoWindowManager r1 = this.o;
        if (r1 == null) goto L9;
        r1.w(r2, r3, r4, r5);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void b4(String r24, z.a r25, int r26, int r27) {
        super.b4(r24, r25, r26, r27);
        y r3 = this.n;
        if (r3 == null) goto L5;
        String r4 = r3.r(r24);
    L6:
        y r5 = this.n;
        if (r5 == null) goto L9;
        int r6 = r5.O4(r4);
    L10:
        he0.a r7 = this.r;
        o r8 = null;
        if ((r7 instanceof he0.a) == true) goto L14;
        r7 = null;
    L14:
        if (r7 == null) goto L22;
        int r9 = r6 - 1;
        if (r9 < 0) goto L22;
        int r10 = r9 + 1;
        double r11 = 1.0d - r7.d;
        double r12 = r7.b;
        double r13 = r11 - (((double) r10) * r12);
        if (r10 <= 1) goto L21;
        r13 = r13 - (((double) (r10 - 1)) * r7.e);
    L21:
        double r19 = r13;
        double r14 = r7.c;
        gd0.s r15 = new gd0.s(r14, r14 + r7.a, r19, r19 + r12);
    L23:
        if (r25 == null) goto L26;
        if (r15 == null) goto L26;
        r8 = new o(r15, r25);
    L26:
        if (r8 == null) goto L74;
        InteractAudienceVideoWindowManager r2 = this.o;
        if (r2 != null) goto L30;
        return;
    L30:
        if (r2.D == false) goto L32;
        return;
    L32:
        if (r2.A == true) goto L35;
        return;
    L35:
        if (TextUtils.equals(r24, tc0.c.h().e) == true) goto L78;
        ((HashMap) r2.O).put(r24, r8);
        f r16 = r2.q("", r24);
        if (r16 == null) goto L40;
        r2.v(r24);
        r2.x(r16);
    L40:
        f r17 = r2.o(r24);
        if (r17 != null) goto L44;
        return;
    L44:
        if (r2.B == false) goto L46;
    L48:
        IBaseUser r18 = r2.o.U4(r24);
        Iterator r20 = ((ArrayList) r2.g).iterator();
    L50:
        if (r20.hasNext() == false) goto L58;
        InteractAudienceAlertWindow r21 = (InteractAudienceAlertWindow) r20.next();
        if (r18 == null) goto L50;
        if (r21.getUser() == null) goto L50;
        if (r21.getUser().getIdString().equals(r18.getIdString()) == false) goto L50;
        r20.remove();
        r21.b();
        goto L50
    L58:
        r2.u(r24, r17);
        r2.f(r17);
        if (r2.B == true) goto L61;
    L63:
        r2.onOnlineListChanged(r2.o.getOnlineUserList());
        r2.i(true);
        return;
    L61:
        if (r.a() == false) goto L63;
        r17.c();
        goto L63
    L46:
        if (TextUtils.equals(r24, tc0.c.h().f) == false) goto L48;
        r2.n = r17;
        goto L48
    L78:
        return;
    L74:
        return;
    L22:
        r15 = null;
        goto L23
    L9:
        r6 = -1;
        goto L10
    L5:
        r4 = "";
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void h1(String r2, SurfaceView r3, int r4, int r5) {
        super.h1(r2, r3, r4, r5);
        y r0 = this.n;
        if (r0 == null) goto L5;
        r0.r(r2);
    L5:
        InteractAudienceVideoWindowManager r1 = this.o;
        if (r1 == null) goto L9;
        r1.w(r2, r3, r4, r5);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.d
    public final void invite(long r9, String r11, String r12, int r13, long r14) {
        Intrinsics.checkNotNullParameter(r11, "uid");
        Intrinsics.checkNotNullParameter(r12, "secUid");
        com.bytedance.android.live.liveinteract.plantform.core.f r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L5:
        com.bytedance.android.live.liveinteract.plantform.core.e.c(r0, r9, r11, r12, r14, 320);
    }
}
