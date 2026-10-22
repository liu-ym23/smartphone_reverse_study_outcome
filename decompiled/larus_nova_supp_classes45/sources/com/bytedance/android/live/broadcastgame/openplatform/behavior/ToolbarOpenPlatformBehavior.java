package com.bytedance.android.live.broadcastgame.openplatform.behavior;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcast.api.BubblePosition;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.GameDataReportHelper;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.live.broadcastgame.api.interactgame.g;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.g0;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.broadcastgame.api.model.z;
import com.bytedance.android.live.broadcastgame.behavior.BaseToolbarInteractBehavior;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.LiveOpenFeaturePanelViewModel;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.animator.LiveAnimator;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.q2;
import com.bytedance.android.livesdk.config.ah;
import com.bytedance.android.livesdk.config.b61;
import com.bytedance.android.livesdk.config.dg1;
import com.bytedance.android.livesdk.config.gg;
import com.bytedance.android.livesdk.config.hf1;
import com.bytedance.android.livesdk.config.nc;
import com.bytedance.android.livesdk.config.p6;
import com.bytedance.android.livesdk.config.ua0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.LinkMicGuideMessage;
import com.bytedance.android.livesdk.message.model.if;
import com.bytedance.android.livesdk.message.model.m;
import com.bytedance.android.livesdk.message.model.q3;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ItemBubbleInfo;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.multicamera.IMultiCameraLiveRtcManager;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.n;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import nz.h;
import org.json.JSONObject;
import vlc.l;
import zg1.a2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/behavior/ToolbarOpenPlatformBehavior;", "Lcom/bytedance/android/live/broadcastgame/behavior/BaseToolbarInteractBehavior;", "La20/b;", "Lvlc/l;", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarOpenPlatformBehavior extends BaseToolbarInteractBehavior implements a20.b, l {
    public static final /* synthetic */ int s = 0;
    public LiveOpenFeaturePanelViewModel m;
    public View n;
    public LiveAnimator o;
    public Function0<Unit> p;
    public vlc.d q;
    public final Function2<InteractEntranceCell, z, c0.b> r;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ToolbarOpenPlatformBehavior a;
        public final /* synthetic */ View b;

        public b(ToolbarOpenPlatformBehavior r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            IBroadcastService r6 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
            if (r6 == null) goto L8;
            h r7 = r6.getBroadcastBubbleManager();
            if (r7 == null) goto L9;
            ToolbarOpenPlatformBehavior r0 = this.a;
            int r1 = ToolbarOpenPlatformBehavior.s;
            r7.b(r0.getContext(), this.b, String.valueOf(39));
            return;
        L9:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ToolbarOpenPlatformBehavior a;

        public c(ToolbarOpenPlatformBehavior r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            d10.f r3 = (d10.f) r2;
            ALogger.i("ToolbarOpenPlatformBehavior", "received OpenLiveOpenFeatureChoosePage");
            this.a.onClick(null);
        }
    }

    static {
    }

    @Override // a20.b
    public final void e() {
        if (((Boolean) nc.a.getValue()).booleanValue() == false) goto L17;
        View r0 = this.d;
        if (r0 == null) goto L9;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L9;
        r1.width = s1.f(8.0f);
    L9:
        View r2 = this.d;
        if (r2 == null) goto L14;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L14;
        r3.height = s1.f(8.0f);
    L14:
        View r4 = this.d;
        if (r4 == null) goto L17;
        r4.setBackgroundResource(2131249474);
    L17:
        ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).getBroadcastDotManager();
        String.valueOf(39);
        new WeakReference(this);
        throw null;
    }

    @Override // com.bytedance.android.live.broadcastgame.behavior.BaseToolbarInteractBehavior
    public final void h() {
        if (((b61) ua0.a.getValue()).b() == true) goto L16;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.k, 0, 2);
        if (r0 == null) goto L11;
        n r1 = r0.getMultiCameraRtcManager();
        if (r1 == null) goto L11;
        IMultiCameraLiveRtcManager r2 = (IMultiCameraLiveRtcManager) r1.getValue();
        if (r2 == null) goto L11;
        boolean r3 = r2.isEngineOn();
    L12:
        if (r3 == false) goto L16;
        com.bytedance.android.livesdk.padutils.c.a("本场已开启多机位直播，无法使用互动工具功能");
        return;
    L11:
        r3 = false;
    L16:
        if (((dg1) hf1.a.getValue()).a() == false) goto L21;
        Function0<Unit> r4 = this.p;
        if (r4 == null) goto L21;
        Unit r5 = (Unit) r4.invoke();
        return;
    L21:
        int r6 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, this.k, 0, 2);
        if (r7 == null) goto L26;
        i r8 = r7.getLiveMode();
        if (r8 == null) goto L26;
        LiveMode r9 = (LiveMode) r8.getValue();
    L27:
        int r11 = h1.a;
        String r12 = i1.a(r9);
        Intrinsics.checkNotNullParameter(r12, "liveType");
        Intrinsics.checkNotNullParameter("", "eventPage");
        u.l().sendLog("livesdk_live_function_icon_click", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("live_type", r12)}), new Object[]{Room.class});
        e();
        throw null;
    L26:
        r9 = null;
        goto L27
    }

    public final boolean showRedDot() {
        if (((Boolean) ah.a.getValue()).booleanValue() == true) goto L6;
        return false;
    L6:
        e();
        throw null;
    }

    @Override // a20.b
    public final Context c() {
        return getContext();
    }

    @Override // a20.b
    public final DataCenter d() {
        return this.k;
    }

    @Override // a20.b
    public final Function2<InteractEntranceCell, z, c0.b> f() {
        return this.r;
    }

    @Override // com.bytedance.android.live.broadcastgame.behavior.BaseToolbarInteractBehavior
    public final void b(KVData r8) {
        a0 r0 = null;
        if (r8 == null) goto L5;
        String r1 = r8.getKey();
    L7:
        if (Intrinsics.areEqual(r1, "cmd_update_income_dot") == true) goto L127;
        if (r8 == null) goto L10;
        String r2 = r8.getKey();
    L12:
        if (Intrinsics.areEqual(r2, "cmd_hide_other_toolbar") == false) goto L30;
        Boolean r3 = Boolean.FALSE;
        Boolean r9 = (Boolean) r8.getData(r3);
        if (r9 == null) goto L18;
        r3 = r9;
    L18:
        if (r3.booleanValue() == false) goto L25;
        ImageView r11 = this.e;
        if (r11 == null) goto L22;
        r11.setImageResource(2131251026);
    L22:
        View r12 = this.d;
        if (r12 == null) goto L129;
        r12.setVisibility(4);
        return;
    L129:
        return;
    L25:
        ImageView r13 = this.e;
        if (r13 == null) goto L28;
        r13.setImageResource(2131252553);
    L28:
        e();
        throw null;
    L30:
        if (r8 == null) goto L32;
        String r4 = r8.getKey();
    L34:
        if (Intrinsics.areEqual(r4, "cmd_broadcast_game_finish") == false) goto L36;
        this.k.put("cmd_hide_other_toolbar", Boolean.FALSE);
        return;
    L36:
        if (r8 == null) goto L38;
        String r5 = r8.getKey();
    L40:
        if (Intrinsics.areEqual(r5, "cmd_income_more_pop") == false) goto L42;
        i((String) r8.getData(null));
        return;
    L42:
        if (r8 == null) goto L44;
        String r6 = r8.getKey();
    L46:
        if (Intrinsics.areEqual(r6, "data_broadcast_game_list") == true) goto L125;
        if (r8 == null) goto L49;
        String r7 = r8.getKey();
    L51:
        if (Intrinsics.areEqual(r7, "data_link_state") == true) goto L123;
        if (r8 == null) goto L54;
        String r14 = r8.getKey();
    L56:
        if (Intrinsics.areEqual(r14, "data_join_channel_finished") == true) goto L123;
        if (r8 != null) goto L59;
    L61:
        if (r8 == null) goto L63;
        String r15 = r8.getKey();
    L65:
        if (Intrinsics.areEqual(r15, "cmd_show_self_bubble_on_openplatform_behavior") == false) goto L78;
        if (r8 == null) goto L133;
        final pp1.c r16 = (pp1.c) r8.getData();
        if (r16 == null) goto L134;
        final View r17 = this.c;
        if (r17 == null) goto L135;
        RoomContext r18 = RoomContext.a.c(RoomContext.Companion, this.k, 0, 2);
        if (r18 == null) goto L76;
        j r19 = r18.getToolbarBubbleManager();
        if (r19 == null) goto L76;
        r0 = (a0) r19.getValue();
    L76:
        if (r0 == null) goto L136;
        r0.addBubbleLocal(r16, r16.k, new q2(this.k, getContext(), r17), new ToolbarOpenPlatformBehavior$showBubbleBindClickOpenSelf$$inlined$let$lambda$1(r17, this, r16));
        return;
    L136:
        return;
    L135:
        return;
    L134:
        return;
    L133:
        return;
    L78:
        if (r8 == null) goto L80;
        String r21 = r8.getKey();
    L82:
        if (Intrinsics.areEqual(r21, "cmd_show_self_waiting_behavior") == false) goto L138;
        Map r22 = (Map) r8.getData();
        if (r22 == null) goto L86;
        Object r23 = r22.get("play_mode");
    L88:
        if ((r23 instanceof String) == true) goto L90;
        r23 = null;
    L90:
        final String r24 = (String) r23;
        Boolean r25 = (Boolean) this.k.get("cmd_multi_scene_game_behavior_shown");
        if (r25 == null) goto L93;
        boolean r26 = r25.booleanValue();
    L94:
        if (r22 == null) goto L96;
        Object r27 = r22.get("ringing");
    L98:
        if ((r27 instanceof Boolean) == true) goto L101;
        r27 = null;
    L101:
        if (Intrinsics.areEqual((Boolean) r27, Boolean.TRUE) == false) goto L112;
        if (r26 == false) goto L104;
        return;
    L104:
        if (this.o != null) goto L140;
        ALogger.e("ToolbarOpenPlatformBehavior", "playRingAnimation.小雪花播放等待动画");
        ImageView r28 = this.f;
        if (r28 == null) goto L108;
        UtilityKotlinExtentionsKt.w(r28);
    L108:
        fd0.f r29 = LiveAnimator.a(new View[]{this.f});
        r29.a.b = 1000;
        r29.c(LiveDegradeFpsAnimator.ROTATION, new float[]{0.0f, 360.0f});
        LiveAnimator r31 = r29.a;
        r31.f = 1;
        r31.e = -1;
        this.o = r31;
        r31.d = new PathInterpolator(0.53f, 0.15f, 0.48f, 0.81f);
        LiveAnimator r32 = this.o;
        if (r32 == null) goto L111;
        r32.c();
    L111:
        this.p = new AnonymousClass2(this, r24);
        return;
    L140:
        return;
    L112:
        if (r26 == false) goto L114;
        return;
    L114:
        if (this.o == null) goto L143;
        this.p = null;
        ALogger.e("ToolbarOpenPlatformBehavior", "cancelRingAnimation.小雪花结束等待动画");
        ImageView r33 = this.f;
        if (r33 == null) goto L118;
        UtilityKotlinExtentionsKt.t(r33);
    L118:
        LiveAnimator r34 = this.o;
        if (r34 == null) goto L121;
        r34.b();
    L121:
        this.o = null;
        this.p = null;
        return;
    L143:
        return;
    L96:
        r27 = null;
        goto L98
    L93:
        r26 = false;
        goto L94
    L86:
        r23 = null;
        goto L88
    L138:
        return;
    L80:
        r21 = null;
        goto L82
    L63:
        r15 = null;
        goto L65
    L59:
        if (TextUtils.equals(r8.getKey(), "cmd_live_toolbarmore_dialog_dismiss") == false) goto L61;
        return;
    L54:
        r14 = null;
    L123:
        e();
        throw null;
    L49:
        r7 = null;
        goto L51
    L125:
        e();
        throw null;
    L44:
        r6 = null;
        goto L46
    L38:
        r5 = null;
        goto L40
    L32:
        r4 = null;
        goto L34
    L10:
        r2 = null;
        goto L12
    L127:
        e();
        throw null;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.broadcastgame.behavior.BaseToolbarInteractBehavior
    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r5) {
        Intrinsics.checkNotNullParameter(r5, "command");
        super.dv(r5);
        if ((r5 instanceof pp1.e) == false) goto L10;
        if (((Boolean) this.k.get("cmd_hide_other_toolbar", Boolean.FALSE)).booleanValue() == true) goto L10;
        e();
        throw null;
    L10:
        if ((r5 instanceof pp1.j) == true) goto L12;
        return;
    L12:
        if (((Boolean) ah.a.getValue()).booleanValue() == false) goto L17;
        e();
        throw null;
    }

    @Override // com.bytedance.android.live.broadcastgame.behavior.BaseToolbarInteractBehavior
    public final void g(final Object r19) {
        if ((r19 instanceof b30.l) == false) goto L11;
        b30.l r1 = (b30.l) r19;
        View r2 = this.c;
        if (r2 == null) goto L7;
        r2.performClick();
    L7:
        ArrayList r3 = new ArrayList();
        r3.addAll(r1.a);
        LiveOpenFeaturePanelViewModel r4 = this.m;
        if (r4 == null) goto L78;
        r4.setHighLightArray(r3);
        return;
    L78:
        return;
    L11:
        if ((r19 instanceof a2) == false) goto L56;
        a2 r5 = (a2) r19;
        Function1<r, Boolean> r6 = new ToolbarOpenPlatformBehavior$onEvent$2(r19);
        LiveOpenFeaturePanelViewModel r7 = this.m;
        if (r7 == null) goto L15;
        List<InteractEntranceCell> r8 = r7.getGameDisplayItemList();
    L16:
        if (r8 == null) goto L90;
        Iterator<T> r9 = r8.iterator();
    L20:
        if (r9.hasNext() == false) goto L54;
        InteractEntranceCell r11 = (InteractEntranceCell) r9.next();
        r r12 = r11.e();
        if (r12 == null) goto L20;
        if (((Boolean) r6.invoke(r12)).booleanValue() == false) goto L20;
        JSONObject r13 = new JSONObject();
        BaseMonitor.add(r13, "source", "evoke_game");
        int r14 = r11.interactType;
        String r15 = r11.title;
        if (r15 != null) goto L28;
        String r16 = "";
    L29:
        ImageModel r17 = r11.icon;
        if (r17 == null) goto L33;
        List r18 = r17.mUrls;
        if (r18 == null) goto L33;
    L34:
        List r110 = r18;
        long r111 = Long.valueOf(r11.groupType).longValue();
        r r21 = r11.e();
        if (r21 == null) goto L37;
        List<Long> r112 = r21.supportiveEntrance;
    L38:
        String r22 = r11.extra;
        if (r22 != null) goto L41;
        String r113 = "";
    L42:
        com.bytedance.android.live.broadcastgame.api.model.u r23 = new com.bytedance.android.live.broadcastgame.api.model.u(r14, r16, r110, 0, r111, r112, r113);
        ((IInteractGameMonitorService) k.n(IInteractGameMonitorService.class)).logInteractGameItemClick(0, r23, r13);
        GameDataReportHelper.b(r23, null);
        String r24 = r5.b;
        if (r24 != null) goto L45;
        boolean r25 = false;
    L46:
        if (r25 == false) goto L48;
        xs2.b.a().post(new com.bytedance.android.live.broadcastgame.api.openplatform.f(0));
        return;
    L48:
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r26 = AnchorGameContext.a.a();
        if (r26 == null) goto L53;
        n<String> r27 = r26.getTempStoreGuideLaunchInfo();
        if (r27 == null) goto L53;
        r27.setValue(r5.c);
    L53:
        this.k.put("cmd_interact_game_startup", r11.i());
        return;
    L45:
        r25 = InteractGameContext.Companion.h(r24);
        goto L46
    L41:
        r113 = r22;
        goto L42
    L37:
        r112 = null;
    L33:
        r18 = new ArrayList();
        goto L34
    L28:
        r16 = r15;
        goto L29
    L54:
        f2.b(2131920840, 0);
        ALogger.e("ToolbarOpenPlatformBehavior", "can't find target game: " + r5);
        return;
    L90:
        return;
    L15:
        r8 = null;
        goto L16
    L56:
        if ((r19 instanceof g0) == false) goto L83;
        g0 r28 = (g0) r19;
        if (r28.a == false) goto L66;
        InteractEntranceCell r29 = r28.b;
        if (r29 == null) goto L84;
        LiveOpenFeaturePanelViewModel r31 = this.m;
        if (r31 == null) goto L85;
        a20.i r32 = r31.getFeatureListHandler();
        if (r32 == null) goto L86;
        r32.b(r29);
        return;
    L86:
        return;
    L85:
        return;
    L84:
        return;
    L66:
        LiveOpenFeaturePanelViewModel r33 = this.m;
        if (r33 == null) goto L88;
        a20.i r34 = r33.getFeatureListHandler();
        if (r34 == null) goto L89;
        r34.k();
        return;
    L89:
        return;
    L88:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.behavior.BaseToolbarInteractBehavior
    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        b((KVData) r1);
    }

    public final void onMessage(tlc.d r9) {
        ItemBubbleInfo r0 = null;
        if (r9 == null) goto L5;
        Integer r1 = Integer.valueOf(r9.getIntType());
    L6:
        int r2 = MessageType.LINKER.getIntType();
        if (r1 != null) goto L10;
    L22:
        int r3 = MessageType.ANCHOR_COMMON_BUBBLE_MESSAGE.getIntType();
        if (r1 != null) goto L26;
    L48:
        boolean r4 = r9 instanceof LinkMicGuideMessage;
        if (r4 == true) goto L51;
    L53:
        if (r4 == false) goto L70;
        LinkMicGuideMessage r11 = (LinkMicGuideMessage) r9;
        if (r11.guidelineType != 16) goto L71;
        StringBuilder r5 = new StringBuilder("received guide audio bubble animation msg showTime is ");
        q3 r12 = r11.crossLinkGuideAudioBubbleAnimationContent;
        if (r12 == null) goto L59;
        r0 = r12.a();
    L59:
        r5.append(r0);
        ALogger.i("ToolbarOpenPlatformBehavior", r5.toString());
        return;
    L71:
        return;
    L70:
        return;
    L51:
        if (((LinkMicGuideMessage) r9).guidelineType != 15) goto L53;
        return;
    L26:
        if (r1.intValue() != r3) goto L48;
        if ((r9 instanceof m) == true) goto L30;
        r9 = null;
    L30:
        m r13 = (m) r9;
        if (r13 == null) goto L64;
        ItemBubbleInfo r14 = r13.E();
        if (r14 != null) goto L35;
        return;
    L35:
        if (this.c != null) goto L37;
    L39:
        boolean r6 = false;
    L40:
        if (r6 == false) goto L42;
        r0 = r14;
    L42:
        if (r0 == null) goto L66;
        IBroadcastService r15 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r15 == null) goto L67;
        h r16 = r15.getBroadcastBubbleManager();
        if (r16 == null) goto L68;
        Context r7 = getContext();
        View r8 = this.c;
        Intrinsics.checkNotNull(r8);
        r16.a(r7, r8, r0, BubblePosition.Top);
        return;
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L37:
        if (Intrinsics.areEqual(r14.getShowItemId(), String.valueOf(39)) == false) goto L39;
        r6 = true;
        goto L40
    L64:
        return;
    L10:
        if (r1.intValue() != r2) goto L22;
        if ((r9 instanceof if) == true) goto L14;
        return;
    L14:
        if (((if) r9).getMType() != 2) goto L62;
        ALogger.e("ToolbarOpenPlatformBehavior", "cancelRingAnimation.小雪花结束等待动画");
        ImageView r17 = this.f;
        if (r17 == null) goto L18;
        UtilityKotlinExtentionsKt.t(r17);
    L18:
        LiveAnimator r18 = this.o;
        if (r18 == null) goto L21;
        r18.b();
    L21:
        this.o = null;
        this.p = null;
        return;
    L62:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.broadcastgame.behavior.BaseToolbarInteractBehavior
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super.R9(r2, r3);
        vlc.d r4 = this.q;
        if (r4 == null) goto L5;
        r4.removeMessageListener(this);
    L5:
        LiveOpenFeaturePanelViewModel r5 = this.m;
        if (r5 == null) goto L8;
        r5.onDestroy();
    L8:
        r3.put("cmd_multi_interact_behavior_shown", Boolean.FALSE);
        r3.removeObserver("cmd_show_self_waiting_behavior", this);
        ALogger.e("ToolbarOpenPlatformBehavior", "onUnload.小雪花icon卸载");
    }

    @Override // com.bytedance.android.live.broadcastgame.behavior.BaseToolbarInteractBehavior
    public final void p4(View r6, DataCenter r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        super.p4(r6, r7);
        this.n = r6;
        Context r0 = getContext();
        if ((r0 instanceof FragmentActivity) == true) goto L5;
        r0 = null;
    L5:
        FragmentActivity r1 = (FragmentActivity) r0;
        if (r1 == null) goto L8;
        LiveOpenFeaturePanelViewModel r2 = (LiveOpenFeaturePanelViewModel) ViewModelProviders.of(r1).get(LiveOpenFeaturePanelViewModel.class);
        r2.onBehaviorCallbackInit(this);
        List<String> r3 = d20.b.a;
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business.j r4 = r2.getOpenFeatureSearchPageCacheHelper();
        List<InteractEntranceCell> r5 = d20.b.b;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "cellList");
        ((ArrayList) r4.a).addAll(r5);
        ((ArrayList) d20.b.a).clear();
        ((ArrayList) r5).clear();
        Unit r8 = Unit.INSTANCE;
        this.m = r2;
    L8:
        r7.observe("cmd_live_toolbarmore_dialog_dismiss", this);
        r7.observe("cmd_show_self_bubble_on_openplatform_behavior", this);
        r7.observe("data_broadcast_game_list", this);
        r7.observe("cmd_show_self_waiting_behavior", this);
        r7.put("cmd_multi_interact_behavior_shown", Boolean.TRUE);
        gg r9 = gg.a;
        if (((p6) r9.getValue()).b() == false) goto L11;
    L37:
        LiveOpenFeaturePanelViewModel r11 = this.m;     // Catch: UnsatisfiedLinkError -> L24
        if (r11 == null) goto L26;
        a20.i r12 = r11.getFeatureListHandler();     // Catch: UnsatisfiedLinkError -> L24
        if (r12 == null) goto L26;
        r12.l();     // Catch: UnsatisfiedLinkError -> L24
    L26:
        vlc.d r13 = (vlc.d) r7.get("data_message_manager", null);
        this.q = r13;
        if (r13 == null) goto L29;
        r13.addMessageListener(MessageType.LINKER.getIntType(), this);
    L29:
        vlc.d r14 = this.q;
        if (r14 == null) goto L32;
        r14.addMessageListener(MessageType.ANCHOR_COMMON_BUBBLE_MESSAGE.getIntType(), this);
    L32:
        vlc.d r15 = this.q;
        if (r15 == null) goto L35;
        r15.addMessageListener(MessageType.LINK_MIC_GUIDE_MESSAGE.getIntType(), this);
    L35:
        ALogger.e("ToolbarOpenPlatformBehavior", "onLoad.小雪花icon可见");
        this.g.add(((SingleSubscribeProxy) Single.timer(5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(getContext()))).subscribe(new b(this, r6)));
        RxUtilKt.c(xs2.b.a().b(d10.f.class).subscribe(new c(this)), this.g);
        return;
    L24:
        e = move-exception;
        Logger.e("ToolbarInteractGamBehavior#onLoad : " + e);
        goto L26
    L11:
        if (((p6) r9.getValue()).a() == true) goto L37;
        LiveOpenFeaturePanelViewModel r16 = this.m;
        if (r16 == null) goto L26;
        a20.i r17 = r16.getFeatureListHandler();
        if (r17 == null) goto L26;
        r17.l();
        goto L26
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ToolbarOpenPlatformBehavior(Context r2, DataCenter r3, g r4, Function2<? super InteractEntranceCell, ? super z, ? extends c0.b> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "createFactory");
        Intrinsics.checkNotNullParameter(r5, "behaviorFactory");
        super(r2, r3, r4);
        this.r = r5;
    }
}
