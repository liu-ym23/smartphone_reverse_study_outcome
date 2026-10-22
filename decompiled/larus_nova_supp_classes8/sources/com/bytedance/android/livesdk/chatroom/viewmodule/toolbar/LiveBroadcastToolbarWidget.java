package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.GameDataReportHelper;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.AnchorMainPostOptUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.largefont.IHostLargeFontService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.ic;
import com.bytedance.android.livesdk.config.um;
import com.bytedance.android.livesdk.config.wx;
import com.bytedance.android.livesdk.config.xx;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomExtra;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveOpenFeatureChooseConfig;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/LiveBroadcastToolbarWidget;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/LiveToolbarWidget;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBroadcastToolbarWidget extends LiveToolbarWidget {
    public static final /* synthetic */ int f = 0;
    public final List<ToolbarButton> a;
    public ViewGroup b;
    public ViewGroup c;
    public boolean d;
    public final Lazy e;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ToolbarButton a;
        public final /* synthetic */ LiveBroadcastToolbarWidget b;
        public final /* synthetic */ LayoutInflater c;

        public b(ToolbarButton r1, LiveBroadcastToolbarWidget r2, LayoutInflater r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            LiveBroadcastToolbarWidget r0 = this.b;
            View r1 = r0.configToView(this.c, this.a, r0.b);
            ExtendedToolbarButton.a r2 = ExtendedToolbarButton.h;
            ToolbarButton r3 = this.a;
            r2.getClass();
            ExtendedToolbarButton.b r4 = ExtendedToolbarButton.a.a(r3);
            this.b.mViewMap.put(r4, r1);
            ViewParent r5 = r1.getParent();
            if ((r5 instanceof ViewGroup) == false) goto L5;
            ((ViewGroup) r5).removeView(r1);
        L5:
            ViewGroup r6 = this.b.b;
            if (r6 == null) goto L8;
            r6.addView(r1);
        L8:
            this.b.mUnfoldedToolbarManager.D(r4, r1);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ LiveBroadcastToolbarWidget a;

        public c(LiveBroadcastToolbarWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LiveBroadcastToolbarWidget r0 = this.a;     // Catch: Throwable -> L4
            int r1 = LiveBroadcastToolbarWidget.f;     // Catch: Throwable -> L4
            r0.Rq();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LiveToolbarWidget
    public final int getLayoutId() {
        return 2131567763;
    }

    public final String getSpm() {
        return "a100.a100.a138";
    }

    public final void Rq() {
        if (jc1.k.n(IInteractGameService.class).getGameGuideHelper() == null) goto L165;
        com.bytedance.android.live.broadcastgame.api.interactgame.d r9 = jc1.k.n(IInteractGameService.class).getGameGuideHelper();
        if (r9 == null) goto L166;
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r0 = AnchorGameContext.a.a();
        if (r0 == null) goto L9;
        ((Boolean) r0.isGuideBubbleShowed().getValue()).booleanValue();
    L9:
        int r1 = com.bytedance.android.live.broadcastgame.api.interactgame.j.a;
        com.bytedance.android.live.broadcastgame.api.interactgame.c r2 = r9.a;
        Long r3 = null;
        if (r2 == null) goto L13;
        List r4 = r2.g();
        if (r4 == null) goto L13;
    L14:
        DataCenter r5 = ((Widget) this).dataCenter;
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        List r6 = r4;
        if (r6 != null) goto L17;
    L20:
        boolean r7 = true;
    L21:
        if (r7 == true) goto L29;
        Iterator r8 = r4.iterator();
    L25:
        if (r8.hasNext() == false) goto L29;
        if (LiveMode.Companion.valueOf(((Number) r8.next()).intValue()) != com.bytedance.android.live.core.utils.z.c(r5)) goto L25;
        boolean r10 = true;
    L30:
        if (r10 == true) goto L32;
        return;
    L32:
        if (r9.b == false) goto L55;
        com.bytedance.android.live.broadcastgame.api.interactgame.c r11 = r9.a;
        if (r11 == null) goto L55;
        if (r11.f() != 1) goto L55;
        com.bytedance.android.live.broadcastgame.api.interactgame.c r12 = r9.a;
        if (r12 == null) goto L55;
        if (r12.c() != 1) goto L55;
        com.bytedance.android.live.broadcastgame.api.interactgame.c r13 = r9.a;
        if (r13 == null) goto L44;
        String r14 = r13.b();
    L45:
        if (r14 != null) goto L47;
    L50:
        boolean r15 = true;
    L51:
        if (r15 == true) goto L55;
        if (r9.c == true) goto L55;
        boolean r16 = true;
    L56:
        if (r16 == false) goto L62;
        DataCenter r17 = ((Widget) this).dataCenter;
        if (r17 == null) goto L60;
        r17.put("data_id_guide_popup_need_show", Boolean.TRUE);
    L60:
        View r18 = this.mViewMap.get(new ExtendedToolbarButton.b(ToolbarButton.INTERACT_GAME));
        Object r19 = "interact";
        boolean r20 = true;
    L88:
        DataCenter r21 = ((Widget) this).dataCenter;
        Intrinsics.checkNotNullParameter(r21, "dataCenter");
        if (r9.b == false) goto L104;
        com.bytedance.android.live.broadcastgame.api.interactgame.c r22 = r9.a;
        if (r22 == null) goto L94;
        Long r23 = r22.a();
    L95:
        if (r23 == null) goto L105;
        com.bytedance.android.live.broadcastgame.api.model.u r24 = com.bytedance.android.live.broadcastgame.api.interactgame.j.c(r23.longValue(), r21);
        if (r24 == null) goto L104;
        List r25 = r24.supportiveEntrance;
        if (r25 == null) goto L104;
        List r26 = r25;
        com.bytedance.android.live.broadcastgame.api.interactgame.c r27 = r9.a;
        if (r27 == null) goto L103;
        r3 = Long.valueOf(r27.f());
    L103:
        boolean r28 = CollectionsKt.contains(r26, r3);
    L106:
        if (r28 == true) goto L108;
    L156:
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r29 = AnchorGameContext.a.a();
        if (r29 == null) goto L169;
        r29.isGuideBubbleShowed().setValue(Boolean.TRUE);
        return;
    L169:
        return;
    L108:
        if (((Widget) this).isViewValid == false) goto L156;
        if (r18 == null) goto L156;
        View r30 = ((Widget) this).contentView;
        Context r31 = ((Widget) this).context;
        Intrinsics.checkNotNullParameter(r30, "contentView");
        Intrinsics.checkNotNullParameter(r18, "parentView");
        Intrinsics.checkNotNullParameter(r31, "context");
        if (r9.b == true) goto L160;
    L131:
        int r32 = GameDataReportHelper.a;
        if (r9.b == false) goto L139;
        com.bytedance.android.live.broadcastgame.api.interactgame.c r33 = r9.a;
        if (r33 == null) goto L139;
        Long r34 = r33.a();
        if (r34 == null) goto L139;
        long r35 = r34.longValue();
    L140:
        DataCenter r36 = ((Widget) this).dataCenter;
        Intrinsics.checkNotNullParameter(r19, "requestPage");
        Intrinsics.checkNotNullParameter(r36, "dataCenter");
        com.bytedance.android.live.broadcastgame.api.model.u r37 = com.bytedance.android.live.broadcastgame.api.interactgame.j.c(r35, r36);
        String r38 = "";
        if (r37 == null) goto L144;
        String r39 = r37.name;
        if (r39 == null) goto L144;
    L145:
        int r40 = com.bytedance.android.live.broadcastgame.api.interactgame.a.a[com.bytedance.android.live.core.utils.z.c(r36).ordinal()];
        if (r40 == 1) goto L154;
        if (r40 == 2) goto L153;
        if (r40 == 3) goto L152;
        if (r40 != 4) goto L155;
        r38 = "third_party";
    L155:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_game_guide_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("live_type", r38), TuplesKt.to("event_page", "live_take_detail"), TuplesKt.to("request_page", r19), TuplesKt.to("game_id", String.valueOf(r35)), TuplesKt.to("game_name", r39)}), new Object[]{Room.class});
        goto L156
    L152:
        r38 = "game";
        goto L155
    L153:
        r38 = "voice_live";
        goto L155
    L154:
        r38 = "video_live";
    L144:
        r39 = "";
    L139:
        r35 = 0;
        goto L140
    L160:
        com.bytedance.android.live.broadcastgame.api.interactgame.c r41 = r9.a;     // Catch: Exception -> L129
        if (r41 == null) goto L119;
        Long r42 = r41.d();     // Catch: Exception -> L129
        if (r42 == null) goto L119;
        long r43 = r42.longValue();     // Catch: Exception -> L129
    L118:
        long r44 = r43;
        com.bytedance.android.live.broadcastgame.api.interactgame.c r45 = r9.a;     // Catch: Exception -> L129
        if (r45 == null) goto L126;
        Long r46 = r45.e();     // Catch: Exception -> L129
        if (r46 == null) goto L126;
        long r47 = r46.longValue();     // Catch: Exception -> L129
    L127:
        r30.postDelayed(new com.bytedance.android.live.broadcastgame.api.interactgame.e(r9, r31, r44, r18, r20), r47);     // Catch: Exception -> L129
        r9.c = true;     // Catch: Exception -> L129
    L126:
        r47 = xx.a.getValue().intValue();     // Catch: Exception -> L129
    L119:
        r43 = wx.a.getValue().intValue();     // Catch: Exception -> L129
    L129:
        e = move-exception;
        ALogger.e("GameGuideHelper", e.getMessage(), e);
        goto L131
    L105:
        r28 = true;
        goto L106
    L94:
        r23 = null;
    L104:
        r28 = false;
        goto L106
    L62:
        if (r9.b == false) goto L85;
        com.bytedance.android.live.broadcastgame.api.interactgame.c r48 = r9.a;
        if (r48 == null) goto L85;
        if (r48.f() != 2) goto L85;
        com.bytedance.android.live.broadcastgame.api.interactgame.c r49 = r9.a;
        if (r49 == null) goto L85;
        if (r49.c() != 1) goto L85;
        com.bytedance.android.live.broadcastgame.api.interactgame.c r50 = r9.a;
        if (r50 == null) goto L74;
        String r51 = r50.b();
    L75:
        if (r51 != null) goto L77;
    L80:
        boolean r52 = true;
    L81:
        if (r52 == true) goto L85;
        if (r9.c == true) goto L85;
        boolean r53 = true;
    L86:
        if (r53 == false) goto L168;
        r18 = this.mViewMap.get(new ExtendedToolbarButton.b(ToolbarButton.PK));
        r19 = "pk";
        r20 = false;
        goto L88
    L168:
        return;
    L77:
        if (r51.length() == 0) goto L80;
        r52 = false;
        goto L81
    L74:
        r51 = null;
    L85:
        r53 = false;
        goto L86
    L47:
        if (r14.length() == 0) goto L50;
        r15 = false;
        goto L51
    L44:
        r14 = null;
    L55:
        r16 = false;
    L29:
        r10 = false;
        goto L30
    L17:
        if (r6.isEmpty() == true) goto L20;
        r7 = false;
    L13:
        r4 = null;
        goto L14
    L166:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LiveToolbarWidget
    public final void onUnload() {
        ((ArrayList) this.a).clear();
        ((Widget) this).dataCenter.removeObserver("data_broadcast_game_list", this);
        ((Widget) this).dataCenter.removeObserver("data_pk_entrance_text", this);
        x3 r0 = this.mUnfoldedToolbarManager;
        if (r0 == null) goto L5;
        r0.n = false;
    L5:
        super.onUnload();
    }

    public LiveBroadcastToolbarWidget() {
        this.a = new ArrayList();
        this.e = LazyKt.lazy(new LiveBroadcastToolbarWidget$toolbarDisableController$2(this));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LiveToolbarWidget
    public final void configToolbarViews() {
        super.configToolbarViews();
        LayoutInflater r0 = LayoutInflater.from(((Widget) this).context);
        Iterator<T> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ToolbarButton r2 = (ToolbarButton) r1.next();
        AnchorMainPostOptUtils.b("left-configview-" + r2.name(), new b(r2, this, r0));
        goto L4
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LiveToolbarWidget
    public final void removeButtonsFromContainer() {
        super.removeButtonsFromContainer();
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        ToolbarButton r1 = (ToolbarButton) r0.next();
        ExtendedToolbarButton.h.getClass();
        ExtendedToolbarButton.b r2 = ExtendedToolbarButton.a.a(r1);
        View r3 = this.mViewMap.get(r2);
        if (r3 == null) goto L4;
        ViewGroup r4 = this.b;
        if (r4 == null) goto L10;
        r4.removeView(r3);
    L10:
        this.mUnfoldedToolbarManager.C(r2, r3);
        goto L4
    }

    public final String Pq(ToolbarButton r5) {
        String r0 = null;
        if (r5 == null) goto L48;
        int r2 = 2131917969;
        int r3 = 2131917970;
        switch(q0.a[r5.ordinal()]) {
            case 1: goto L47;
            case 2: goto L44;
            case 3: goto L40;
            case 4: goto L33;
            case 5: goto L31;
            case 6: goto L30;
            case 7: goto L29;
            case 8: goto L28;
            case 9: goto L27;
            case 10: goto L26;
            case 11: goto L25;
            case 12: goto L24;
            case 13: goto L23;
            case 14: goto L22;
            case 15: goto L21;
            case 16: goto L20;
            case 17: goto L19;
            case 18: goto L18;
            case 19: goto L17;
            case 20: goto L16;
            case 21: goto L12;
            case 22: goto L10;
            case 23: goto L9;
            case 24: goto L8;
            default: goto L48;
        };
    L8:
        Integer r1 = 2131918849;
    L50:
        if (r1 == null) goto L56;
        String r6 = com.bytedance.android.live.core.utils.s1.B(r1.intValue());
        if (r6 != null) goto L55;
        return "";
    L55:
        return r6;
    L56:
        if (r5 == null) goto L65;
        int r7 = q0.b[r5.ordinal()];
        if (r7 != 1) goto L61;
        r0 = jc1.k.n(IInteractService.class).getVideoTalkService().s();
        goto L65
    L61:
        if (r7 != 2) goto L65;
        r0 = jc1.k.n(ILinkServiceExternal.class).getControlService().g();
    L65:
        if (r0 != null) goto L68;
        return "";
    L68:
        return r0;
    L9:
        r1 = 2131923203;
        goto L50
    L10:
        r1 = 2131914886;
        goto L50
    L16:
        r1 = 2131914889;
        goto L50
    L17:
        r1 = 2131914892;
        goto L50
    L18:
        r1 = 2131918108;
        goto L50
    L19:
        r1 = 2131914875;
        goto L50
    L20:
        r1 = 2131914883;
        goto L50
    L21:
        r1 = 2131914882;
        goto L50
    L22:
        r1 = 2131914890;
        goto L50
    L23:
        r1 = 2131914881;
        goto L50
    L24:
        r1 = 2131914880;
        goto L50
    L25:
        r1 = 2131914893;
        goto L50
    L26:
        r1 = 2131914891;
        goto L50
    L27:
        r1 = 2131914877;
        goto L50
    L28:
        r1 = 2131914887;
        goto L50
    L29:
        r1 = 2131914876;
        goto L50
    L30:
        r1 = 2131915403;
        goto L50
    L31:
        r1 = 2131915392;
        goto L50
    L47:
        r1 = 2131914884;
        goto L50
    L12:
        if (LiveOpenFeatureChooseConfig.useV3() == true) goto L15;
        r3 = 2131914885;
    L15:
        r1 = Integer.valueOf(r3);
        goto L50
    L33:
        if (com.bytedance.android.live.core.utils.z.i(((Widget) this).dataCenter) == true) goto L35;
    L37:
        int r4 = 2131914873;
    L38:
        r1 = Integer.valueOf(r4);
        goto L50
    L35:
        if (um.a.getValue().booleanValue() == false) goto L37;
        r4 = 2131914874;
        goto L38
    L40:
        if (LiveOpenFeatureChooseConfig.useV3() == false) goto L42;
        r2 = 2131917970;
    L42:
        r1 = Integer.valueOf(r2);
        goto L50
    L44:
        if (LiveOpenFeatureChooseConfig.useV3() == false) goto L46;
        r2 = 2131917970;
    L46:
        r1 = Integer.valueOf(r2);
    L48:
        r1 = null;
        goto L50
    }

    public final void Qq(boolean r5) {
        if (this.isAnchor == true) goto L6;
        return;
    L6:
        if (((Widget) this).isViewValid == true) goto L8;
        return;
    L8:
        final LiveMode r0 = (LiveMode) ((Widget) this).dataCenter.get("data_live_mode");
        List<ToolbarButton> r1 = this.mUnfoldedList;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        r2.add(((ToolbarButton) r3.next()).extended());
        goto L10
    L12:
        if (r5 == false) goto L14;
        ((ToolbarDisableController) this.e.getValue()).a(this.mUnfoldedToolbarManager, r2, new LiveBroadcastToolbarWidget$handleClickStateOnPause$1(r0));
        return;
    L14:
        ((ToolbarDisableController) this.e.getValue()).b(this.mUnfoldedToolbarManager);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LiveToolbarWidget
    public final void hideOtherView(boolean r4) {
        hideVisibleView(r4, CollectionsKt.plus(this.mUnfoldedList, this.a));
        ViewGroup.LayoutParams r0 = null;
        if (r4 == false) goto L27;
        View r5 = this.mViewMap.get(new ExtendedToolbarButton.b(ToolbarButton.GAME_EXIT));
        if (r5 == null) goto L7;
        ViewParent r1 = r5.getParent();
    L9:
        if (Intrinsics.areEqual(r1, this.mToolbarContainer) == false) goto L16;
        if (r5 == null) goto L12;
        ViewGroup.LayoutParams r2 = r5.getLayoutParams();
    L13:
        this.mToolbarContainer.removeView(r5);
        ViewGroup r3 = this.b;
        if (r3 == null) goto L16;
        r3.addView(r5, r2);
        goto L16
    L12:
        r2 = null;
    L16:
        View r6 = this.mViewMap.get(ToolbarButton.MORE.extended());
        if (r6 == null) goto L19;
        ViewParent r7 = r6.getParent();
    L21:
        if (Intrinsics.areEqual(r7, this.mToolbarContainer) == false) goto L40;
        if (r6 == null) goto L24;
        r0 = r6.getLayoutParams();
    L24:
        this.mToolbarContainer.removeView(r6);
        ViewGroup r8 = this.b;
        if (r8 == null) goto L41;
        r8.addView(r6, r0);
        return;
    L41:
        return;
    L40:
        return;
    L19:
        r7 = null;
        goto L21
    L7:
        r1 = null;
        goto L9
    L27:
        View r9 = this.mViewMap.get(ToolbarButton.MORE.extended());
        if (r9 == null) goto L30;
        ViewParent r10 = r9.getParent();
    L32:
        if (Intrinsics.areEqual(r10, this.b) == false) goto L43;
        if (r9 == null) goto L35;
        r0 = r9.getLayoutParams();
    L35:
        ViewGroup r11 = this.b;
        if (r11 == null) goto L38;
        r11.removeView(r9);
    L38:
        this.mToolbarContainer.addView(r9, r0);
        return;
    L43:
        return;
    L30:
        r10 = null;
        goto L32
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LiveToolbarWidget
    public final void initUnfoldedList(List<ToolbarButton> r9) {
        Intrinsics.checkNotNullParameter(r9, "list");
        if (com.bytedance.android.live.core.utils.z.k(((Widget) this).dataCenter) == false) goto L5;
    L12:
        r9.clear();
        com.bytedance.android.livesdk.service.l.d().getClass();
        r9.addAll(((v) com.bytedance.android.livesdk.service.k.b(v.class)).c(((Widget) this).dataCenter));
        ((ArrayList) this.a).clear();
        List<ToolbarButton> r1 = this.a;
        com.bytedance.android.livesdk.service.l.d().getClass();
        ((ArrayList) r1).addAll(((v) com.bytedance.android.livesdk.service.k.b(v.class)).b(((Widget) this).dataCenter));
        Intrinsics.checkNotNullParameter(r9, "list");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        Boolean r2 = null;
        if (r0 == null) goto L21;
        com.bytedance.live.datacontext.m r3 = r0.getRoom();
        if (r3 == null) goto L21;
        Room r4 = (Room) r3.getValue();
        if (r4 == null) goto L21;
        RoomExtra r5 = r4.getExtra();
        if (r5 == null) goto L21;
        Boolean r6 = Boolean.valueOf(r5.isGroupLiveScene());
    L23:
        if (((Boolean) com.bytedance.android.live.core.setting.x3.a.getValue()).booleanValue() == true) goto L25;
    L48:
        List<ToolbarButton> r10 = this.a;
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r7 == null) goto L58;
        com.bytedance.live.datacontext.m r8 = r7.getRoom();
        if (r8 == null) goto L58;
        Room r11 = (Room) r8.getValue();
        if (r11 == null) goto L58;
        RoomExtra r12 = r11.getExtra();
        if (r12 == null) goto L58;
        r2 = Boolean.valueOf(r12.isGroupLiveScene());
    L58:
        if (((Boolean) com.bytedance.android.live.core.setting.x3.a.getValue()).booleanValue() == true) goto L60;
        return;
    L60:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L94;
        com.bytedance.android.livesdk.chatroom.o r13 = z51.a.h(((Widget) this).dataCenter, 2);
        if (r13 == null) goto L95;
        com.bytedance.live.datacontext.m r14 = r13.getRoom();
        if (r14 == null) goto L96;
        IRoom r15 = (IRoom) r14.getValue();
        if (r15 != null) goto L68;
        return;
    L68:
        if (r15.isPrivatePlay() != true) goto L98;
        ArrayList r16 = (ArrayList) r10;
        r16.clear();
        List r17 = (List) com.bytedance.android.live.core.setting.l.a.getValue();
        if ((!r17.isEmpty()) == false) goto L99;
        Iterator r18 = r17.iterator();
    L73:
        if (r18.hasNext() == false) goto L100;
        ToolbarButton r19 = ToolbarButton.fromName((String) r18.next());
        if (r19 == null) goto L73;
        r16.add(r19);
        goto L73
    L100:
        return;
    L99:
        return;
    L98:
        return;
    L96:
        return;
    L95:
        return;
    L94:
        return;
    L25:
        if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L48;
        com.bytedance.android.livesdk.chatroom.o r20 = z51.a.h(((Widget) this).dataCenter, 2);
        if (r20 == null) goto L48;
        com.bytedance.live.datacontext.m r21 = r20.getRoom();
        if (r21 == null) goto L48;
        IRoom r22 = (IRoom) r21.getValue();
        if (r22 == null) goto L48;
        if (r22.isPrivatePlay() != true) goto L48;
        List r23 = (List) com.bytedance.android.live.core.setting.n.a.getValue();
        if ((!r23.isEmpty()) == false) goto L48;
        ArrayList r24 = new ArrayList();
        Iterator r25 = r23.iterator();
    L38:
        if (r25.hasNext() == false) goto L42;
        ToolbarButton r26 = ToolbarButton.fromName((String) r25.next());
        if (r26 == null) goto L38;
        r24.add(r26);
        goto L38
    L42:
        Iterator<ToolbarButton> r27 = r9.iterator();
    L44:
        if (r27.hasNext() == false) goto L48;
        if (r24.contains(r27.next()) == true) goto L44;
        r27.remove();
    L21:
        r6 = null;
        goto L23
    L5:
        if (com.bytedance.android.live.core.utils.z.g(((Widget) this).dataCenter) == true) goto L12;
        if (com.bytedance.android.live.core.utils.z.i(((Widget) this).dataCenter) == true) goto L12;
        if (com.bytedance.android.live.core.utils.z.j(((Widget) this).dataCenter) == true) goto L12;
        if (com.bytedance.android.live.core.utils.z.h(((Widget) this).dataCenter) == true) goto L12;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LiveToolbarWidget
    public final void onChanged(KVData r5) {
        super.onChanged(r5);
        zg1.m r0 = null;
        if (r5 == null) goto L5;
        String r1 = r5.getKey();
    L6:
        if (r1 == null) goto L52;
        int r2 = r1.hashCode();
        if (r2 == (-2135400523)) goto L26;
        if (r2 == (-1802015048)) goto L23;
        if (r2 == (-79069753)) goto L16;
        return;
    L16:
        if (r1.equals("data_pk_entrance_text") == false) goto L42;
        ExtendedToolbarButton.a r6 = ExtendedToolbarButton.h;
        ToolbarButton r3 = ToolbarButton.PK;
        r6.getClass();
        View r7 = this.mViewMap.get(ExtendedToolbarButton.a.a(r3));
        if (r7 == null) goto L43;
        TextView r8 = (TextView) r7.findViewById(2131389066);
        if (r8 == null) goto L44;
        r8.setText(Pq(r3));
        return;
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L23:
        if (r1.equals("data_broadcast_game_list") == false) goto L46;
        Rq();
        return;
    L46:
        return;
    L26:
        if (r1.equals("data_broadcast_pause_state") == false) goto L48;
        if (r5 == null) goto L30;
        r0 = (zg1.m) r5.getData();
    L30:
        if (r0 != null) goto L32;
    L33:
        if (r0 != null) goto L35;
    L37:
        if (r0 != null) goto L39;
        return;
    L39:
        if (r0.a != 3) goto L51;
        Qq(false);
        return;
    L51:
        return;
    L35:
        if (r0.a != 2) goto L37;
    L36:
        Qq(true);
        return;
    L32:
        if (r0.a == 1) goto L36;
    L48:
        return;
    L52:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LiveToolbarWidget
    public final void onInit(Object[] r3) {
        super.onInit(r3);
        this.b = (ViewGroup) ((Widget) this).contentView.findViewById(2131362106);
        if (com.bytedance.android.livesdk.chatroom.utils.x.a() == false) goto L12;
        IHostLargeFontService r4 = jc1.k.n(IHostBusiness.class).getLiveLargeFontService();
        if (r4 == null) goto L7;
        r4.noZoomAll(this.mToolbarContainer, 0);
    L7:
        ViewGroup r5 = this.b;
        if (r5 == null) goto L12;
        IHostLargeFontService r1 = jc1.k.n(IHostBusiness.class).getLiveLargeFontService();
        if (r1 == null) goto L12;
        r1.noZoomAll(r5, 0);
    L12:
        boolean r6 = ic.a.getValue().booleanValue();
        this.d = r6;
        if (r6 == false) goto L24;
        ViewGroup r7 = (ViewGroup) ((Widget) this).contentView.findViewById(2131362605);
        this.c = r7;
        if (r7 == null) goto L17;
        com.bytedance.android.live.core.utils.a1.k(r7, UtilityKotlinExtentionsKt.i(52));
    L17:
        ViewGroup r8 = this.b;
        if (r8 == null) goto L20;
        com.bytedance.android.live.core.utils.a1.k(r8, UtilityKotlinExtentionsKt.i(52));
    L20:
        ViewGroup r9 = this.mToolbarContainer;
        if (r9 == null) goto L25;
        com.bytedance.android.live.core.utils.a1.k(r9, UtilityKotlinExtentionsKt.i(52));
        return;
    L25:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LiveToolbarWidget
    public final void onLoad(Object[] r2) {
        super.onLoad(r2);
        ((Widget) this).dataCenter.observe("data_broadcast_game_list", this);
        ((Widget) this).dataCenter.observe("data_pk_entrance_text", this);
        ((Widget) this).containerView.post(new c(this));
        x3 r3 = this.mUnfoldedToolbarManager;
        if (r3 == null) goto L6;
        r3.n = true;
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LiveToolbarWidget
    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        onChanged((KVData) r1);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LiveToolbarWidget
    public final View configToView(LayoutInflater r9, ToolbarButton r10, ViewGroup r11) {
        View r3 = null;
        boolean r4 = false;
        if (this.d == true) goto L5;
        View r0 = this.mCachedViewMap.get(r10);
        if (r0 != null) goto L85;
        if (r9 == null) goto L80;
        if (r10 == null) goto L78;
        int r1 = r10.getBroadcastLayoutId();
    L79:
        r0 = r9.inflate(r1, r11, false);
    L81:
        if (r10 == null) goto L85;
        if (r10.getBroadcastLayoutId() != 2131567861) goto L85;
        this.mCachedViewMap.put(r10, r0);
        goto L85
    L78:
        r1 = 0;
        goto L79
    L80:
        r0 = null;
    L85:
        if (r10 != null) goto L87;
    L95:
        if (r0 == null) goto L97;
        r0.setTag(r10);
    L97:
        if (r0 == null) goto L99;
        r0.setVisibility(8);
    L99:
        com.bytedance.android.livesdk.r3.i(r0, r10);
        Intrinsics.checkNotNull(r0);
        return r0;
    L87:
        if (r10.getBroadcastLayoutId() != 2131567861) goto L95;
        if (r0 == null) goto L91;
        r3 = r0.findViewById(2131374718);
    L91:
        if ((r3 instanceof ImageView) == false) goto L93;
        ((ImageView) r3).setImageResource(r10.getBroadcastDrawableUnfolded());
        goto L95
    L93:
        if (r3 == null) goto L95;
        r3.setBackgroundResource(r10.getBroadcastDrawableUnfolded());
        goto L95
    L5:
        if (r10 == null) goto L13;
        int r5 = q0.c[r10.ordinal()];
        if (r5 != 1) goto L10;
        Integer r6 = 2131251047;
    L17:
        if (r6 == null) goto L23;
        int r7 = r6.intValue();
        if (r10 == null) goto L21;
        r10.setBroadcastLayoutId(0);
    L21:
        if (r10 == null) goto L23;
        r10.setBroadcastDrawableUnfolded(r7);
    L23:
        if (r9 == null) goto L26;
        View r12 = r9.inflate(2131567522, r11, false);
        if (r12 == null) goto L26;
    L28:
        if ((r12 instanceof ViewGroup) == false) goto L71;
        ViewGroup r8 = (ViewGroup) r12;
        if (r10 == null) goto L32;
        int r13 = r10.getTrueBroadcastLayoutId();
    L34:
        if (r13 == 0) goto L52;
        if (r13 == 2131567861) goto L52;
        if (r10 == null) goto L39;
        String r2 = r10.name();
        if (r2 == null) goto L39;
    L40:
        ALogger.i("broadcast toolbar", r2);
        if (r9 == null) goto L43;
        r3 = r9.inflate(r13, r8, false);
    L43:
        UIUtils.updateLayoutMargin(r3, 0, 0, 0, 0);
        ViewGroup r14 = (ViewGroup) r8.findViewById(2131374744);
        UtilityKotlinExtentionsKt.w(r14);
        r14.addView(r3);
        if (r10 != ToolbarButton.INTERACTION_ROOM) goto L51;
        if (r3 == null) goto L51;
        ViewGroup.LayoutParams r15 = r3.getLayoutParams();
        if (r15 == null) goto L51;
        if ((r15 instanceof FrameLayout.LayoutParams) == false) goto L51;
        ((FrameLayout.LayoutParams) r15).gravity = 80;
    L51:
        r4 = true;
    L57:
        if (r4 == true) goto L62;
        View r16 = r12.findViewById(2131367577);
        if (r16 == null) goto L62;
        if (r10 == null) goto L62;
        int r17 = r10.getBroadcastDrawableUnfolded();
        UtilityKotlinExtentionsKt.w(r16);
        r16.setBackgroundResource(r17);
    L62:
        View r18 = r12.findViewById(2131362960);
        if (r18 == null) goto L65;
        r18.setVisibility(8);
    L65:
        View r19 = r12.findViewById(2131392581);
        if (r19 == null) goto L68;
        r19.setVisibility(8);
    L68:
        TextView r20 = (TextView) r12.findViewById(2131389066);
        if (r20 == null) goto L71;
        r20.setText(Pq(r10));
    L39:
        r2 = "use custom view";
    L52:
        if (r10 == null) goto L55;
        String r21 = r10.name();
        if (r21 == null) goto L55;
    L56:
        ALogger.i("broadcast toolbar", r21);
    L55:
        r21 = "default view";
        goto L56
    L32:
        r13 = 0;
    L71:
        r12.setTag(r10);
        r12.setVisibility(8);
        com.bytedance.android.livesdk.r3.i(r12, r10);
        return r12;
    L26:
        r12 = new View(getContext());
        goto L28
    L10:
        if (r5 != 2) goto L12;
        r6 = 2131251597;
        goto L17
    L12:
        if (r5 != 3) goto L13;
        r6 = 2131251200;
    L13:
        r6 = null;
        goto L17
    }
}
