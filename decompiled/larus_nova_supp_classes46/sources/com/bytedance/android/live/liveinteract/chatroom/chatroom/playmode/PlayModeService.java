package com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode;

import android.view.ViewGroup;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.animation.universalwidget.MultiLinkUniversalAnimWidget;
import com.bytedance.android.live.liveinteract.api.BaseLinkMultiControlWidget;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongWidget;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u;
import com.bytedance.android.live.liveinteract.playmode.IncompatibleTag;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleWidget;
import com.bytedance.android.live.liveinteract.revenue.fight.dynamic.DynamicTeamFightWidget;
import com.bytedance.android.live.liveinteract.revenue.game.LinkMicGameWidget;
import com.bytedance.android.live.liveinteract.revenue.guestlink.GuestLinkWidget;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.dynamic.DynamicLinkRoomFightWidget;
import com.bytedance.android.live.liveinteract.revenue.starwish.StarWishWidget;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.utils.w0;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.ib0;
import com.bytedance.android.livesdk.config.nb1;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.y;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.android.livesdk.message.model.eb;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class PlayModeService implements com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a, l {
    public static final /* synthetic */ int g = 0;
    public final ConcurrentHashMap<Integer, xh0.b> a;
    public final ConcurrentHashMap<Integer, c> b;
    public final ConcurrentHashMap<Integer, c> c;
    public final ConcurrentHashMap<Integer, c> d;
    public final Lazy e;
    public WidgetManager f;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a
    public final void clear() {
        this.a.clear();
        this.d.clear();
        this.b.clear();
        this.c.clear();
        this.f = null;
        vlc.d r0 = (vlc.d) this.e.getValue();
        if (r0 == null) goto L6;
        r0.removeMessageListener(this);
        return;
    }

    public PlayModeService(WidgetManager r3) {
        this.f = r3;
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.e = LazyKt.lazy(PlayModeService$messageManager$2.INSTANCE);
        WidgetManager r4 = this.f;
        if (r4 == null) goto L5;
        List r5 = r4.widgets;
    L6:
        if (r5 == null) goto L13;
        Iterator r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L13;
        Widget r0 = (Widget) r6.next();
        if ((r0 instanceof xh0.b) == false) goto L9;
        c((xh0.b) r0);
    L13:
        Map<Integer, xh0.b> r7 = jh0.d.a;
        List r8 = CollectionsKt.toList(((LinkedHashMap) jh0.d.a).values());
        if (r8 == null) goto L19;
        Iterator r9 = r8.iterator();
    L17:
        if (r9.hasNext() == false) goto L26;
        c((xh0.b) r9.next());
        goto L17
    L26:
        return;
    L19:
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a
    public final boolean b(int r4) {
        Iterator<Map.Entry<Integer, xh0.b>> r0 = this.a.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        xh0.b r1 = r0.next().getValue();
        if (r1.isOpen() == false) goto L4;
        Pair<Boolean, String> r2 = r1.isSupportSceneChange(r4);
        if (r2 == null) goto L4;
        if (((Boolean) r2.getFirst()).booleanValue() == true) goto L4;
        f2.c((String) r2.getSecond(), 0);
        return false;
    L13:
        return true;
    }

    @Override // xh0.d
    public final void c(xh0.b r11) {
        Intrinsics.checkNotNullParameter(r11, "playMode");
        int r0 = r11.getPlayModeInfo().a;
        j.a("registerPlayMode: " + r0);
        this.a.put(Integer.valueOf(r0), r11);
        int r1 = d.a;
        c r2 = d.a(IncompatibleTag.SCENE, r11.getPlayModeInfo(), r11.getIncompatibleSourceList());
        c r3 = d.a(IncompatibleTag.UI_LAYOUT, r11.getPlayModeInfo(), r11.getIncompatibleSourceList());
        c r12 = d.a(IncompatibleTag.PLAY_MODE, r11.getPlayModeInfo(), r11.getIncompatibleSourceList());
        if (r12 == null) goto L18;
        j.a("registerPlayMode: " + r0 + " playModeChecker rule : " + r12.c());
        Iterator<Map.Entry<Integer, c>> r4 = this.d.entrySet().iterator();
    L6:
        if (r4.hasNext() == false) goto L17;
        Map.Entry<Integer, c> r5 = r4.next();
        HashMap<Integer, String> r6 = r5.getValue().c;
        if (r6.containsKey(Integer.valueOf(r0)) == false) goto L13;
        if (r12.c.containsKey(r5.getKey()) == true) goto L13;
        r12.a(new Pair(r5.getKey(), null));
    L13:
        if (r6.containsKey(Integer.valueOf(r0)) == true) goto L6;
        if (r12.c.containsKey(r5.getKey()) == false) goto L6;
        r5.getValue().a(new Pair(Integer.valueOf(r0), null));
        goto L6
    L17:
        this.d.put(Integer.valueOf(r0), r12);
    L18:
        if (r2 == null) goto L20;
        j.a("registerPlayMode: " + r0 + " sceneChecker rule : " + r2.c());
        this.b.put(Integer.valueOf(r0), r2);
    L20:
        if (r3 == null) goto L30;
        j.a("registerPlayMode: " + r0 + " uiLayoutChecker rule : " + r3.c());
        this.c.put(Integer.valueOf(r0), r3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a
    public final void d(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        MultiLinkLoadWidgetUtils.n(r3, "MultiLinkDynamicWidget-PlayModeService-startDynamicWidget", "PlayModeService startDynamicWidget true");
        r3.put("data_multi_lick_dynamic_widget_start", Boolean.TRUE);
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a
    public final void f(DataCenter r14) {
        if (r14 == null) goto L4;
        r14.put("data_multi_lick_dynamic_widget_start", Boolean.FALSE);
    L4:
        if (r14 == null) goto L6;
        IRoom r0 = a0.o(r14);
    L7:
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.isLiveTypeAudio() == true) goto L13;
        r14.put("data_multi_lick_dynamic_event_change", new nh0.f("linkmic", new nh0.e(0, 0, null, 0, 0, null, null, null, 252), null, null, null, null, false, 224));
        return;
    L13:
        return;
    L6:
        r0 = null;
        goto L7
    }

    @Override // xh0.d
    public final void i(xh0.b r3) {
        Intrinsics.checkNotNullParameter(r3, "playMode");
        int r4 = r3.getPlayModeInfo().a;
        j.a("unregisterPlayModeWidget " + r4);
        if (this.d.containsKey(Integer.valueOf(r4)) == false) goto L6;
        this.d.remove(Integer.valueOf(r4));
    L6:
        if (this.b.containsKey(Integer.valueOf(r4)) == false) goto L9;
        this.b.remove(Integer.valueOf(r4));
    L9:
        if (this.c.containsKey(Integer.valueOf(r4)) == false) goto L12;
        this.c.remove(Integer.valueOf(r4));
    L12:
        if (this.a.containsKey(Integer.valueOf(r4)) == false) goto L15;
        this.a.remove(Integer.valueOf(r4));
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a
    public final boolean l(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        if (com.bytedance.android.live.liveinteract.plantform.multiroom.e.b(r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a
    public final boolean n(int r4) {
        Iterator<Map.Entry<Integer, xh0.b>> r0 = this.a.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        xh0.b r1 = r0.next().getValue();
        if (r1.isOpen() == false) goto L4;
        Pair<Boolean, String> r2 = r1.isSupportUiLayoutChang(r4);
        if (r2 == null) goto L4;
        if (((Boolean) r2.getFirst()).booleanValue() == true) goto L4;
        f2.c((String) r2.getSecond(), 0);
        return false;
    L13:
        return true;
    }

    public final void onMessage(tlc.d r15) {
        if ((r15 instanceof ILinkMicGuideMessageBridge) == true) goto L5;
        return;
    L5:
        WidgetManager r0 = this.f;
        if (r0 == null) goto L45;
        List r1 = r0.widgets;
        if (r1 == null) goto L51;
        Iterator r2 = r1.iterator();
        boolean r3 = false;
        boolean r4 = false;
    L12:
        if (r2.hasNext() == false) goto L18;
        AbsPlayModeWidget r5 = (Widget) r2.next();
        if ((r5 instanceof AbsPlayModeWidget) == false) goto L12;
        r4 = r5.handleGuideMessage((ILinkMicGuideMessageBridge) r15);
        if (r4 == false) goto L12;
    L18:
        if (r4 == true) goto L46;
        ILinkMicGuideMessageBridge r16 = (ILinkMicGuideMessageBridge) r15;
        Intrinsics.checkNotNullParameter(r16, MultiLinkOpenSource.MESSAGE);
        eb r17 = r16.getPlayModeGuideBubbleContent();
        com.bytedance.live.datacontext.j r6 = o3.f().A2();
        String r7 = null;
        if (r6 == null) goto L22;
        DataCenter r8 = (DataCenter) r6.getValue();
    L23:
        if (r17 == null) goto L25;
        a5 r9 = r17.getRichText();
    L26:
        if (r9 == null) goto L28;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        r.g.d(r17.getRichText(), null, new y(0.0f), new h(r17, r8));
        return;
    L28:
        if (r17 == null) goto L30;
        r7 = r17.getToast();
    L30:
        if (r7 != null) goto L32;
        return;
    L32:
        if (r17.getToast().length() <= 0) goto L34;
        r3 = true;
    L34:
        if (r3 == false) goto L49;
        pp1.c r10 = new pp1.c(r17.getToast(), null, null, 0, null, null, 1001, 0, null, 0, 8126);
        if (r8 == null) goto L50;
        r8.put("cmd_show_self_bubble_on_openplatform_behavior", r10);
        return;
    L50:
        return;
    L49:
        return;
    L25:
        r9 = null;
        goto L26
    L22:
        r8 = null;
        goto L23
    L46:
        return;
    L51:
        return;
    }

    @Override // xh0.d
    public final xh0.g a(int r8, HashMap<String, Object> r9) {
        c r0 = this.b.get(Integer.valueOf(r8));
        boolean r2 = false;
        if (r0 == null) goto L7;
        int r4 = ((IInteractService) k.n(IInteractService.class)).getCurrentScene();
        ConcurrentHashMap<Integer, xh0.b> r5 = this.a;
        Intrinsics.checkNotNullParameter(r5, "loadedPlayModes");
        xh0.g r1 = r0.b(CollectionsKt.arrayListOf(new Integer[]{Integer.valueOf(r4)}), r5);
        if (r1.c == true) goto L7;
        return r1;
    L7:
        c r3 = this.c.get(Integer.valueOf(r8));
        if (r3 == null) goto L13;
        int r6 = ((IInteractService) k.n(IInteractService.class)).getCurrentUiLayout();
        ConcurrentHashMap<Integer, xh0.b> r7 = this.a;
        Intrinsics.checkNotNullParameter(r7, "loadedPlayModes");
        xh0.g r10 = r3.b(CollectionsKt.arrayListOf(new Integer[]{Integer.valueOf(r6)}), r7);
        if (r10.c == true) goto L13;
        return r10;
    L13:
        if (this.d.containsKey(Integer.valueOf(r8)) == false) goto L45;
        c r11 = this.d.get(Integer.valueOf(r8));
        if (r11 == null) goto L45;
        xh0.b r12 = this.a.get(Integer.valueOf(r8));
        if (r12 == null) goto L19;
        ArrayList<Integer> r13 = r12.getOverlayWhiteList();
    L20:
        if (r13 != null) goto L22;
    L23:
        r2 = true;
    L24:
        if (r2 == true) goto L32;
        Iterator<Integer> r14 = r13.iterator();
    L27:
        if (r14.hasNext() == false) goto L31;
        Integer r15 = r14.next();
        if (r11.c.containsKey(r15) == false) goto L27;
        r11.c.remove(r15);
        goto L27
    L31:
        j.a("playModeOpenCheck : " + r8 + " after  filter white list rule : " + r11.c());
    L32:
        ArrayList r16 = new ArrayList();
        Iterator<Map.Entry<Integer, xh0.b>> r17 = this.a.entrySet().iterator();
    L34:
        if (r17.hasNext() == false) goto L42;
        Map.Entry<Integer, xh0.b> r18 = r17.next();
        if (r18 == null) goto L34;
        xh0.b r19 = r18.getValue();
        if (r19 == null) goto L34;
        if (r19.isOpen() != true) goto L34;
        r16.add(r18.getKey());
        goto L34
    L42:
        xh0.g r20 = r11.b(r16, this.a);
        if (r20.c == true) goto L45;
        return r20;
    L22:
        if (r13.isEmpty() == false) goto L24;
    L19:
        r13 = null;
    L45:
        xh0.b r21 = this.a.get(Integer.valueOf(r8));
        if (r21 == null) goto L48;
        xh0.g r22 = r21.isCanOpen(r9);
        if (r22.c == true) goto L53;
        return r22;
    L53:
        return new xh0.g(IncompatibleTag.PLAY_MODE, r8, true, null, 24);
    L48:
        return new xh0.g(IncompatibleTag.PLAY_MODE, r8, false, "unloadedPlayMode_" + r8, 16);
    }

    @Override // xh0.d
    public final void d4(int r2, int r3) {
        com.bytedance.android.live.liveinteract.animation.universalwidget.a.f0.getClass();
        com.bytedance.android.live.liveinteract.animation.universalwidget.a r0 = com.bytedance.android.live.liveinteract.animation.universalwidget.a.C0014a.a();
        if (r0 == null) goto L6;
        r0.d4(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a
    public final void g(DataCenter r2, BaseLinkMultiControlWidget.a r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        if (w0.c(null) == false) goto L5;
        return;
    L5:
        IInteractService r0 = (IInteractService) k.f(IInteractService.class);
        if (r0 == null) goto L9;
        r0.removePreloadDynamicWidget(r2, r3);
        return;
    }

    @Override // xh0.d
    public final xh0.g h(int r8, HashMap<String, Object> r9) {
        xh0.b r0 = this.a.get(Integer.valueOf(r8));
        if (r0 == null) goto L5;
        r0.beforeOpen();
        xh0.g r1 = a(r8, r9);
        j.a("tryStartPlayMode checkResult " + xh0.c.a(r1));
        if (r1.c == false) goto L11;
        xh0.b r10 = this.a.get(Integer.valueOf(r8));
        if (r10 == null) goto L20;
        r10.tryStartPlayMode(r9);
    L20:
        return r1;
    L11:
        String r11 = r1.e;
        if (r11 != null) goto L14;
    L17:
        boolean r12 = true;
    L18:
        if (r12 == true) goto L20;
        f2.c(r1.e, 0);
        goto L20
    L14:
        if (r11.length() == 0) goto L17;
        r12 = false;
        goto L18
    L5:
        return new xh0.g(IncompatibleTag.PLAY_MODE, r8, false, "unloadedPlayMode_" + r8, 16);
    }

    @Override // xh0.d
    public final boolean k(int r3, HashMap<String, Object> r4) {
        xh0.b r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isOpen() != true) goto L12;
        xh0.b r5 = this.a.get(Integer.valueOf(r3));
        if (r5 == null) goto L13;
        r5.tryStopPlayMode(r4);
        return true;
    L13:
        return false;
    L12:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a
    public final void m(Widget r9, SceneType r10) {
        Intrinsics.checkNotNullParameter(r9, "sceneWidget");
        Intrinsics.checkNotNullParameter(r10, "sceneType");
        ALogger.d("PlayModeService", "loadPlayModes, sceneType = " + r10);
        r9.enableSubWidgetManager();
        PlayModeConfig[] r0 = PlayModeConfig.values();
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L10;
        PlayModeConfig r4 = r0[r3];
        if (r4.isEnable(r10) == false) goto L9;
        Widget r5 = r4.createPlayModeWidget(r10);
        if (r5 == null) goto L9;
        ALogger.d("PlayModeService", "loadPlayMode, playModeConfig = " + r4 + ", playModeWidget = " + r5.getClass().getSimpleName());
        r9.subWidgetManager.load(r5);
    L9:
        r3 = r3 + 1;
        goto L3
    }

    @Override // xh0.d
    public final MultiLinkUniversalAnimWidget e(Widget r4, SceneType r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r4, "sceneWidget");
        Intrinsics.checkNotNullParameter(r5, "sceneType");
        Intrinsics.checkNotNullParameter(r6, "rootView");
        if (((nb1) vm2.k.d.getValue(null, vm2.k.a[2])).a() == true) goto L6;
        ALogger.i("PlayModeService", "loadRenderAnimWidget, not enable");
        return null;
    L6:
        Widget.WidgetCallback r0 = r4.widgetCallback;
        if (r0 == null) goto L9;
        WidgetManager r1 = r0.getWidgetManager();
    L10:
        if (r1 != null) goto L13;
        ALogger.e("PlayModeService", "widgetCallback not ready");
        return null;
    L13:
        r4.enableSubWidgetManager();
        MultiLinkUniversalAnimWidget r2 = new MultiLinkUniversalAnimWidget(r6, r5);
        WidgetManager r7 = r4.subWidgetManager;
        if (r7 == null) goto L16;
        r7.load(r2);
    L16:
        return r2;
    L9:
        r1 = null;
        goto L10
    }

    @Override // xh0.d
    public final void j(int r4, boolean r5, HashMap<String, Object> r6) {
        StringBuilder r0 = new StringBuilder("notifyPlayModeStatus ");
        xh0.b r1 = this.a.get(Integer.valueOf(r4));
        if (r1 == null) goto L7;
        xh0.h r2 = r1.getPlayModeInfo();
        if (r2 == null) goto L7;
        String r3 = r2.b;
    L8:
        r0.append(r3);
        r0.append(" playMode: ");
        r0.append(r4);
        r0.append(" isOpen: ");
        r0.append(r5);
        j.a(r0.toString());
        if (r5 == false) goto L14;
        xh0.g r7 = a(r4, r6);
        if (r7.c == true) goto L15;
        j.a("notifyPlayModeStatus checkResult " + xh0.c.a(r7));
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a
    public final void o(DataCenter r5, Widget r6, SceneType r7, ViewGroup r8) {
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        Intrinsics.checkNotNullParameter(r6, "sceneWidget");
        Intrinsics.checkNotNullParameter(r7, "sceneType");
        Intrinsics.checkNotNullParameter(r8, "rootView");
        ALogger.i("MultiLinkDynamicWidget-AdvanceLoad", "PlayModeService loadDynamicWidget sceneWidget " + r6 + " sceneType " + r7);
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a == true) goto L5;
        return;
    L5:
        if (w0.c(null) == true) goto L16;
        int r9 = u.b;
        int r10 = MultiSceneEnterRoomStatisticsUtils.u;
        long r0 = 0;
        MultiSceneEnterRoomStatisticsUtils r11 = MultiSceneEnterRoomStatisticsUtils.a.a(r5, 0L);
        if (r11 == null) goto L10;
        r0 = r11.c();
    L10:
        u.a = r0;
        ALogger.e("MultiLinkDynamicWidget-Time", "talk room widget start: " + (System.currentTimeMillis() - u.a));
        r6.enableSubWidgetManager();
        IInteractService r12 = (IInteractService) k.f(IInteractService.class);
        if (r12 == null) goto L15;
        r12.preloadDynamicWidget(r5, r6.subWidgetManager, null);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a
    public final void p(Widget r12, SceneType r13, ne0.c r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r12, "sceneWidget");
        Intrinsics.checkNotNullParameter(r13, "sceneType");
        if (r15 == true) goto L5;
        m(r12, r13);
    L5:
        if (r14 == null) goto L105;
        int r0 = g.a;
        ArrayList r1 = new ArrayList();
        r1.add(new gj0.g());
        r1.add(new ji0.i());
        r1.add(new bj0.g());
        r1.add(new mi0.i());
        r1.add(new ti0.d());
        r1.add(new com.bytedance.android.live.liveinteract.revenue.guestlink.c());
        if (((Boolean) ib0.a.getValue()).booleanValue() == false) goto L9;
        r1.add(new qf0.c());
    L9:
        WidgetManager r2 = r12.subWidgetManager;
        if (r2 == null) goto L73;
        List r3 = r2.widgets;
        if (r3 == null) goto L73;
        Iterator r4 = r3.iterator();
    L15:
        if (r4.hasNext() == false) goto L73;
        Widget r5 = (Widget) r4.next();
        if ((r5 instanceof StarWishWidget) == true) goto L18;
        if ((r5 instanceof GuestBattleWidget) == true) goto L27;
        if ((r5 instanceof DynamicLinkRoomFightWidget) == true) goto L35;
        if ((r5 instanceof DynamicTeamFightWidget) == true) goto L43;
        if ((r5 instanceof LinkMicGameWidget) == true) goto L51;
        if ((r5 instanceof GuestLinkWidget) == true) goto L59;
        if ((r5 instanceof InteractiveSongWidget) == false) goto L15;
        ArrayList r6 = new ArrayList();
        Iterator r7 = r1.iterator();
    L69:
        if (r7.hasNext() == false) goto L24;
        Object r8 = r7.next();
        if ((!(((xh0.e) r8) instanceof qf0.c)) == false) goto L69;
        r6.add(r8);
    L24:
        r1 = r6;
        goto L15
    L59:
        r6 = new ArrayList();
        Iterator r9 = r1.iterator();
    L61:
        if (r9.hasNext() == false) goto L24;
        Object r10 = r9.next();
        if ((!(((xh0.e) r10) instanceof com.bytedance.android.live.liveinteract.revenue.guestlink.c)) == false) goto L61;
        r6.add(r10);
        goto L61
    L51:
        r6 = new ArrayList();
        Iterator r11 = r1.iterator();
    L53:
        if (r11.hasNext() == false) goto L24;
        Object r16 = r11.next();
        if ((!(((xh0.e) r16) instanceof ti0.d)) == false) goto L53;
        r6.add(r16);
        goto L53
    L43:
        r6 = new ArrayList();
        Iterator r17 = r1.iterator();
    L45:
        if (r17.hasNext() == false) goto L24;
        Object r18 = r17.next();
        if ((!(((xh0.e) r18) instanceof mi0.i)) == false) goto L45;
        r6.add(r18);
        goto L45
    L35:
        r6 = new ArrayList();
        Iterator r19 = r1.iterator();
    L37:
        if (r19.hasNext() == false) goto L24;
        Object r20 = r19.next();
        if ((!(((xh0.e) r20) instanceof bj0.g)) == false) goto L37;
        r6.add(r20);
        goto L37
    L27:
        r6 = new ArrayList();
        Iterator r21 = r1.iterator();
    L29:
        if (r21.hasNext() == false) goto L24;
        Object r22 = r21.next();
        if ((!(((xh0.e) r22) instanceof ji0.i)) == false) goto L29;
        r6.add(r22);
        goto L29
    L18:
        r6 = new ArrayList();
        Iterator r23 = r1.iterator();
    L20:
        if (r23.hasNext() == false) goto L24;
        Object r24 = r23.next();
        if ((!(((xh0.e) r24) instanceof gj0.g)) == false) goto L20;
        r6.add(r24);
    L73:
        ALogger.d("PlayModeService", "loadPlayModePlugins, loadPlayModePlugins: " + r15 + ", plugins: " + r1 + "， plugins#size: " + r1.size());
        Iterator r110 = r1.iterator();
    L75:
        if (r110.hasNext() == false) goto L105;
        xh0.e r25 = (xh0.e) r110.next();
        if (r25.c(r13) == false) goto L75;
        AbsPlayModeWidget r26 = r25.b(r13);
        if (r26 == null) goto L104;
        AbsPlayModeWidget r27 = r26;
        ne0.c r28 = r27.getStore();
        if (r28 == null) goto L105;
        ne0.e r29 = (ne0.e) r14;
        String r30 = r27.getClass().getName();
        Intrinsics.checkNotNullParameter(r30, "key");
        if (r29.g != null) goto L87;
        r29.g = new HashMap();
    L87:
        r28.c(r29);
        Map<String, ne0.c> r31 = r29.g;
        Intrinsics.checkNotNull(r31);
        ((HashMap) r31).put(r30, r28);
        ne0.d r32 = r25.a(r13);
        if (r32 == null) goto L102;
        r14.a();
        r32.b();
        HashMap<String, String> r33 = new HashMap();
        r32.a(r33);
        Iterator<String> r34 = r33.keySet().iterator();
    L91:
        if (r34.hasNext() == false) goto L102;
        String r35 = r34.next();
        String r36 = r33.get(r35);
        if (r36 == null) goto L91;
        if (r36.length() <= 0) goto L97;
        boolean r37 = true;
    L98:
        if (r37 != true) goto L91;
        ne0.g r38 = r28.a();
        if (r38 == null) goto L91;
        r38.b(r36, new i(r36, r35, r28, r14));
        goto L91
    L97:
        r37 = false;
    L102:
        ALogger.d("PlayModeService", "loadPlayModePlugin, playModePlugin = " + r25 + ", playModeWidget = " + r27.getClass().getSimpleName());
        r12.subWidgetManager.load(r27);
        goto L75
    L104:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget");
    L105:
        vlc.d r111 = (vlc.d) this.e.getValue();
        if (r111 == null) goto L171;
        r111.addMessageListener(MessageType.LINK_MIC_GUIDE_MESSAGE.getKey(), this);
        return;
    }
}
