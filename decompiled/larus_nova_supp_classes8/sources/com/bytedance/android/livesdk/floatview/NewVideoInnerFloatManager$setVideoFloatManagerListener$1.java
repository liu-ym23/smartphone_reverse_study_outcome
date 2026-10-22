package com.bytedance.android.livesdk.floatview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.ax;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.schema.interfaces.IRoomActionHandler;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerFrameLayout;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherRoomEvent;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.android.livesdkapi.floatview.FloatWindowRevisitParam;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowWidgetAbility;
import com.bytedance.android.livesdkapi.util.LiveMultiTabFloatWindowStore;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import com.bytedance.router.SmartRouter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class NewVideoInnerFloatManager$setVideoFloatManagerListener$1 implements e {
    public final /* synthetic */ NewVideoInnerFloatManager a;

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void a(int r1, int r2) {
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void b() {
        NewVideoInnerFloatManager r0 = this.a;
        VideoFloatWindowView r1 = r0.b;
        if (r1 == null) goto L9;
        InnerContextEntity r2 = r1.getContainContext();
        if (r2 == null) goto L7;
        FrameLayout r3 = r2.getRootView();
    L8:
        r0.f(r3);
        goto L9
    L7:
        r3 = null;
    L9:
        this.a.e();
        this.a.f = 0;
        LiveMultiTabFloatWindowStore r4 = LiveMultiTabFloatWindowStore.INSTANCE;
        r4.resetBackRoomInfo();
        r4.setTabChange(false);
        r4.setMoreLiveToLiveTab(false);
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void onClick() {
        NewVideoInnerFloatManager r1 = this.a;
        r1.getClass();
        StringBuilder r2 = new StringBuilder("userCustomJump = ");
        InnerContextEntity.InnerFloatExtra r3 = r1.j;
        b r4 = null;
        if (r3 == null) goto L7;
        InnerContextEntity.UserCustomJump r5 = r3.getUserCustomJump();
        if (r5 == null) goto L7;
        String r6 = r5.toString();
    L8:
        r2.append(r6);
        ALogger.i("FloatViewSmoothEnter", r2.toString());
        if (os1.b.b().b() == false) goto L40;
        InnerContextEntity.InnerFloatExtra r7 = r1.j;
        if (r7 == null) goto L40;
        InnerContextEntity.UserCustomJump r8 = r7.getUserCustomJump();
        if (r8 == null) goto L40;
        if (r8.getEnable() != true) goto L40;
        InnerContextEntity.InnerFloatExtra r9 = r1.j;
        if (r9 == null) goto L40;
        InnerContextEntity.UserCustomJump r10 = r9.getUserCustomJump();
        if (r10 == null) goto L40;
        Function0 r11 = r10.getEnableClickAnimPredict();
        if (r11 == null) goto L40;
        if (((Boolean) r11.invoke()).booleanValue() != true) goto L40;
        InnerContextEntity.InnerFloatExtra r12 = r1.j;
        if (r12 == null) goto L40;
        InnerContextEntity.UserCustomJump r13 = r12.getUserCustomJump();
        if (r13 == null) goto L40;
        Function0 r14 = r13.getEnableClickActionPredict();
        if (r14 == null) goto L40;
        if (((Boolean) r14.invoke()).booleanValue() != true) goto L40;
        InnerContextEntity.InnerFloatExtra r15 = r1.j;
        if (r15 == null) goto L37;
        InnerContextEntity.UserCustomJump r16 = r15.getUserCustomJump();
        if (r16 == null) goto L37;
        Function0 r17 = r16.getAction();
    L38:
        if (r17 == null) goto L40;
        boolean r18 = true;
    L41:
        if (r18 == false) goto L83;
        NewVideoInnerFloatManager r19 = this.a;
        VideoFloatWindowView r20 = r19.b;
        if (r20 == null) goto L85;
        InnerContextEntity.InnerFloatExtra r21 = r19.j;
        if (r21 == null) goto L51;
        InnerContextEntity.UserCustomJump r22 = r21.getUserCustomJump();
        if (r22 == null) goto L51;
        if (r22.isImmersed() != true) goto L51;
        boolean r23 = true;
    L52:
        final Function0<Unit> r24 = new NewVideoInnerFloatManager$setVideoFloatManagerListener$1$onClick$1(this);
        Intrinsics.checkNotNullParameter(r24, "onAnimationEnd");
        r20.C = null;
        int r25 = b.g;
        FrameLayout r26 = r20.getVideoContainer();
        if (r26 == null) goto L56;
        r4 = new b(r20, r26, r23);
    L56:
        r20.C = r4;
        if (r4 != null) goto L59;
        r24.invoke();
    L59:
        b r27 = r20.C;
        if (r27 == null) goto L86;
        Function0<Unit> r28 = new VideoFloatWindowView$startFullScreenAnim$1(r24);
        Intrinsics.checkNotNullParameter(r28, "onAnimationEnd");
        Animator r29 = r27.c;
        if (r29 != null) goto L64;
    L66:
        r27.a = new j(a1.f(r27.e), a1.h(r27.e), a1.g(r27.e), a1.e(r27.e));
        RoundCornerFrameLayout r30 = r27.d.getFloatContentRootView();
        if (r30 == null) goto L69;
        r27.b = new j(a1.f(r30), a1.h(r30), a1.g(r30), a1.e(r30));
        a1.m(r30, 0);
        a1.o(r30, 0);
        a1.n(r30, 0);
        a1.l(r30, 0);
        r30.J(0, 0, 0, 0);
    L69:
        FrameLayout r31 = r27.d.getFloatEdge();
        if (r31 == null) goto L72;
        r31.setVisibility(8);
    L72:
        View r32 = r27.d.getCloseView();
        if (r32 == null) goto L75;
        r32.setVisibility(8);
    L75:
        View r33 = r27.d.getMuteView();
        if (r33 == null) goto L78;
        r33.setVisibility(8);
    L78:
        int r34 = r27.e.getWidth();
        int r35 = r27.e.getHeight();
        int r110 = r27.d.getWidth();
        int r36 = r27.d.getHeight();
        if (r27.f == false) goto L81;
        int r111 = 0;
    L82:
        int r112 = r36 - r111;
        double r113 = ((double) r34) / ((double) r35);
        int r37 = r27.e.getLeft();
        int r38 = r27.e.getTop();
        int r39 = (r27.d.getWidth() - r27.e.getLeft()) - r27.e.getWidth();
        int r40 = (r27.d.getHeight() - r27.e.getTop()) - r27.e.getHeight();
        a1.m(r27.e, r37);
        a1.o(r27.e, r38);
        a1.n(r27.e, r39);
        a1.l(r27.e, r40);
        ValueAnimator r41 = ValueAnimator.ofInt(new int[]{r35, r112});
        r41.setDuration(300);
        r41.addUpdateListener(new c(r27, r113, r110, r112, ((double) r37) / ((double) (r37 + r39)), ((double) r40) / ((double) ((r38 + r40) - r111)), r111, r28));
        r41.addListener(new d(r28));
        r41.start();
        r27.c = r41;
        return;
    L81:
        r111 = s1.A();
        goto L82
    L64:
        if (r29.isRunning() != true) goto L66;
        return;
    L86:
        return;
    L51:
        r23 = false;
        goto L52
    L85:
        return;
    L83:
        e(false);
        return;
    L37:
        r17 = null;
    L40:
        r18 = false;
    L7:
        r6 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void onClose() {
        NewVideoInnerFloatManager r0 = this.a;
        VideoFloatWindowView r1 = r0.b;
        if (r1 == null) goto L10;
        InnerContextEntity r2 = r1.getContainContext();
        if (r2 == null) goto L7;
        FrameLayout r3 = r2.getRootView();
    L8:
        r0.f(r3);
        goto L10
    L7:
        r3 = null;
    L10:
        if (ax.a.getValue().booleanValue() == false) goto L12;
        this.a.q();
    L12:
        NewVideoInnerFloatManager r4 = this.a;
        r4.f = 4;
        NewVideoInnerFloatManager.t(r4.d, NewVideoInnerFloatManager.ActionType.CLOSE, true);
        LiveMultiTabFloatWindowStore r5 = LiveMultiTabFloatWindowStore.INSTANCE;
        r5.resetBackRoomInfo();
        r5.setTabChange(false);
        r5.setMoreLiveToLiveTab(false);
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void onReturnClick() {
        NewVideoInnerFloatManager r0 = this.a;
        VideoFloatWindowView r1 = r0.b;
        if (r1 == null) goto L9;
        InnerContextEntity r2 = r1.getContainContext();
        if (r2 == null) goto L7;
        FrameLayout r3 = r2.getRootView();
    L8:
        r0.f(r3);
        goto L9
    L7:
        r3 = null;
    L9:
        NewVideoInnerFloatManager.a(this.a);
        this.a.e();
        NewVideoInnerFloatManager.t(this.a.d, NewVideoInnerFloatManager.ActionType.RETURNCLICK, false);
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void onShow() {
        NewVideoInnerFloatManager.t(this.a.d, NewVideoInnerFloatManager.ActionType.SHOW, false);
    }

    public NewVideoInnerFloatManager$setVideoFloatManagerListener$1(NewVideoInnerFloatManager r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void c(View r2) {
        Intrinsics.checkNotNullParameter(r2, "releasedChild");
        Iterator r3 = ((ArrayList) this.a.d).iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        IVideoFloatManager.VideoFloatManagerListener r0 = (IVideoFloatManager.VideoFloatManagerListener) r3.next();
        if (r0 == null) goto L4;
        r0.onViewReleased();
        goto L4
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void d(View r8) {
        Intrinsics.checkNotNullParameter(r8, "changedView");
        int[] r0 = new int[2];
        r8.getLocationOnScreen(r0);
        Iterator r1 = ((ArrayList) this.a.d).iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        IVideoFloatManager.VideoFloatManagerListener r2 = (IVideoFloatManager.VideoFloatManagerListener) r1.next();
        if (r2 == null) goto L4;
        r2.onViewPositionChanged(r0[0], r0[1], r8.getMeasuredWidth(), r8.getMeasuredHeight());
        goto L4
    }

    public final void e(boolean r20) {
        AbsLiveBizWindowWidgetAbility r1 = this.a.n.getCurWidgetAbility();
        if (r1 == null) goto L5;
        r1.onBizInteractViewClick();
    L5:
        VideoFloatWindowView r2 = this.a.b;
        FrameLayout r3 = null;
        if (r2 == null) goto L8;
        InnerContextEntity r4 = r2.getContainContext();
    L9:
        LiveMultiTabFloatWindowStore r5 = LiveMultiTabFloatWindowStore.INSTANCE;
        String r6 = r5.getEnterFromMerge();
        String r7 = r6 + '-' + r5.getEnterMethod();
        Map<String, String> r8 = this.a.a.b();
        if (this.a.a.a() == false) goto L41;
        if (r8 == null) goto L41;
        if ((!r8.isEmpty()) != true) goto L41;
        boolean r9 = r8.containsKey(r7);
        if (r9 == false) goto L17;
        String r10 = r8.get(r7);
    L18:
        Set<String> r11 = r8.keySet();
        if ((r11 instanceof Collection) == true) goto L21;
    L23:
        Iterator<T> r12 = r11.iterator();
    L25:
        if (r12.hasNext() == false) goto L34;
        String r13 = (String) r12.next();
        if (StringsKt.endsWith$default(r13, "-*", false, 2, null) == true) goto L29;
    L31:
        boolean r14 = false;
    L32:
        if (r14 == false) goto L25;
        boolean r15 = true;
    L35:
        if (r15 == false) goto L38;
        if (r9 == true) goto L38;
        r10 = r8.get(r6 + "-*");
    L38:
        if (r9 == true) goto L40;
        if (r15 == true) goto L40;
    L42:
        boolean r16 = false;
    L44:
        if (this.a.a.a() == false) goto L65;
        if (r16 == false) goto L65;
        if (LiveMultiTabFloatWindowStore.INSTANCE.isTabChange() == true) goto L65;
        VideoFloatWindowView r17 = this.a.b;
        if (r17 == null) goto L64;
        InnerContextEntity r18 = r17.getContainContext();
        if (r18 == null) goto L258;
        WeakReference r19 = r18.getActivityRef();
        if (r19 == null) goto L259;
        Activity r21 = (Activity) r19.get();
        if (r21 == null) goto L260;
        StringBuilder r22 = new StringBuilder("aweme://land_tab?tabid=");
        r22.append(r10);
        Map r23 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("enter_from", "homepage_tablive"), TuplesKt.to("enter_method", "pip_back_to_source")});
        if ((!r23.isEmpty()) == false) goto L63;
        Iterator r24 = r23.entrySet().iterator();
    L61:
        if (r24.hasNext() == false) goto L63;
        Map.Entry r25 = (Map.Entry) r24.next();
        String r26 = (String) r25.getKey();
        String r27 = (String) r25.getValue();
        r22.append("&");
        r22.append(r26);
        r22.append("=");
        r22.append(r27);
    L63:
        SmartRouter.buildRoute(r21, r22.toString()).d();
        LiveMultiTabFloatWindowStore r28 = LiveMultiTabFloatWindowStore.INSTANCE;
        r28.clearEnterFromMerge();
        r28.clearEnterMethod();
        goto L65
    L260:
        return;
    L259:
        return;
    L258:
        return;
    L64:
        return;
    L65:
        LiveMultiTabFloatWindowStore r29 = LiveMultiTabFloatWindowStore.INSTANCE;
        r29.setTabChange(false);
        r29.setMoreLiveToLiveTab(false);
        RoomContext r30 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r30 == null) goto L70;
        com.bytedance.live.datacontext.m r31 = r30.getRoom();
        if (r31 == null) goto L70;
        Room r32 = (Room) r31.getValue();
    L71:
        if (r4 == null) goto L75;
        InnerContextEntity.FloatWindowDataSource r33 = r4.getDataSource();
        if (r33 == null) goto L75;
        IRoom r34 = r33.getRoomData();
    L77:
        if ((r34 instanceof Room) == true) goto L79;
        r34 = null;
    L79:
        Room r35 = (Room) r34;
        if (r35 == null) goto L227;
        InnerContextEntity.InnerFloatExtra r110 = r4.getEnterExtra();
        if (r110 != null) goto L85;
    L87:
        boolean r111 = false;
    L88:
        if (r111 == true) goto L95;
        long r112 = r35.id;
        if (r112 == 0) goto L227;
        if (r32 == null) goto L95;
        if (r112 == r32.id) goto L227;
    L95:
        InnerContextEntity.InnerFloatExtra r113 = r4.getEnterExtra();
        if (r113 == null) goto L117;
        InnerContextEntity.UserCustomJump r114 = r113.getUserCustomJump();
        if (r114 == null) goto L117;
        if (r114.getEnable() == true) goto L103;
        r114 = null;
    L103:
        if (r114 == null) goto L117;
        Function0 r115 = r114.getEnableClickActionPredict();
        if (r115 != null) goto L107;
    L109:
        boolean r116 = false;
    L110:
        if (r116 == true) goto L113;
        r114 = null;
    L113:
        if (r114 == null) goto L117;
        Function0 r36 = r114.getAction();
        if (r36 == null) goto L226;
        Unit r37 = (Unit) r36.invoke();
    L226:
        boolean r38 = true;
    L228:
        if (r38 == true) goto L236;
        InnerContextEntity.InnerFloatExtra r39 = this.a.j;
        if (r39 != null) goto L232;
    L233:
        NewVideoInnerFloatManager.a(this.a);
        this.a.q();
        RoomContext r40 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r40 == null) goto L236;
        r40.setFloatWindowRevisitParam(new FloatWindowRevisitParam("in", SystemClock.elapsedRealtime(), "business", "1", null, 16, null));
        goto L236
    L232:
        if (r39.getFinishOnClick() == true) goto L233;
    L236:
        if (r20 == true) goto L244;
        NewVideoInnerFloatManager r41 = this.a;
        VideoFloatWindowView r42 = r41.b;
        if (r42 == null) goto L243;
        InnerContextEntity r43 = r42.getContainContext();
        if (r43 == null) goto L242;
        r3 = r43.getRootView();
    L242:
        r41.f(r3);
    L243:
        this.a.e();
    L244:
        InnerContextEntity.InnerFloatExtra r44 = this.a.j;
        if (r44 == null) goto L249;
        Function0 r45 = r44.getOnClickListener();
        if (r45 == null) goto L249;
        Unit r46 = (Unit) r45.invoke();
    L249:
        NewVideoInnerFloatManager.t(this.a.d, NewVideoInnerFloatManager.ActionType.CLICK, false);
        return;
    L107:
        if (((Boolean) r115.invoke()).booleanValue() != true) goto L109;
        r116 = true;
    L117:
        Bundle r117 = new Bundle();
        HashMap r118 = r4.getMobParams();
        if (r118 == null) goto L123;
        Iterator r119 = r118.entrySet().iterator();
    L121:
        if (r119.hasNext() == false) goto L123;
        Map.Entry r120 = (Map.Entry) r119.next();
        r117.putString((String) r120.getKey(), (String) r120.getValue());
    L123:
        IHostBusiness r121 = jc1.k.f(IHostBusiness.class);
        if (r121 == null) goto L126;
        String r122 = r121.createJumpSourceBtmToken("c486697.d415351");
    L127:
        if (r32 == null) goto L129;
        Bundle r47 = ArgumentsBuilder.buildRoomArgs(r35);
        r47.putAll(r117);
        JumpToOtherRoomEvent r48 = new JumpToOtherRoomEvent(r35.id, r47);
        r48.forceNewActivityWhenJumpRoom = r111;
        r48.sourceBtmToken = r122;
        xs2.b.a().post(r48);
        goto L226
    L129:
        InnerContextEntity.InnerFloatExtra r49 = r4.getEnterExtra();
        if (r49 != null) goto L132;
    L180:
        Activity r50 = r4.getActivity();
        if (r50 != null) goto L183;
        r50 = jc1.k.n(IHostApp.class).getCurrentActivity();
    L183:
        Activity r123 = r50;
        if (r123 == null) goto L227;
        ILiveActionHandler r124 = com.bytedance.android.livesdk.service.l.d().a();
        IRoomActionHandler.Params r51 = new IRoomActionHandler.Params().setRoomId(r35.id).setRequestId(r35.getRequestId()).setLogPb(r35.getLog_pb()).setEnterFrom("live_product_card");
        HashMap r52 = r4.getMobParams();
        if (r52 == null) goto L188;
        String r53 = (String) r52.get("search_params");
    L189:
        String r54 = "";
        if (r53 != null) goto L192;
        r53 = "";
    L192:
        IRoomActionHandler.Params r55 = r51.setSearchParams(r53).setLogExtras(r117).setRoom(r35).setForceNewActivityWhenJumpRoom(r111);
        HashMap r56 = r4.getMobParams();
        if (r56 == null) goto L195;
        String r57 = (String) r56.get("click_order");
    L196:
        if (r57 == null) goto L199;
        r54 = r57;
    L199:
        IRoomActionHandler.Params r58 = r55.setClickOrder(r54).setSourceBtmToken(r122);
        InnerContextEntity.InnerFloatExtra r59 = r4.getEnterExtra();
        if (r59 == null) goto L204;
        InnerContextEntity.RoomEnterConfig r60 = r59.getRoomEnterConfig();
        if (r60 == null) goto L204;
        String r61 = r60.getEventParams();
    L205:
        IRoomActionHandler.Params r62 = r58.setEventParams(r61);
        InnerContextEntity.InnerFloatExtra r63 = r4.getEnterExtra();
        if (r63 == null) goto L210;
        InnerContextEntity.RoomEnterConfig r64 = r63.getRoomEnterConfig();
        if (r64 == null) goto L210;
        String r65 = r64.getBusinessLiveParams();
    L211:
        IRoomActionHandler.Params r66 = r62.setBusinessLiveParams(r65);
        InnerContextEntity.InnerFloatExtra r67 = r4.getEnterExtra();
        if (r67 == null) goto L214;
        String r68 = r67.getEnterMethod();
    L215:
        IRoomActionHandler.Params r69 = r66.setEnterMethod(r68);
        InnerContextEntity.InnerFloatExtra r70 = r4.getEnterExtra();
        if (r70 == null) goto L218;
        String r71 = r70.getEnterFromMerge();
    L219:
        IRoomActionHandler.Params r72 = r69.setEnterFromMerge(r71);
        InnerContextEntity.InnerFloatExtra r73 = r4.getEnterExtra();
        if (r73 == null) goto L224;
        InnerContextEntity.RoomEnterConfig r75 = r73.getRoomEnterConfig();
        if (r75 == null) goto L224;
        String r76 = r75.getLocalLifeParams();
    L225:
        IBaseLiveActionHandler.DefaultImpls.openRoom$default(r124, r123, r72.setLocalLifeParams(r76), null, 4, null);
    L224:
        r76 = null;
        goto L225
    L218:
        r71 = null;
        goto L219
    L214:
        r68 = null;
    L210:
        r65 = null;
    L204:
        r61 = null;
        goto L205
    L195:
        r57 = null;
        goto L196
    L188:
        r53 = null;
        goto L189
    L132:
        if (r49.getUseNormalMode() != true) goto L180;
        Activity r77 = r4.getActivity();
        if (r77 != null) goto L136;
        r77 = jc1.k.n(IHostApp.class).getCurrentActivity();
    L136:
        Activity r125 = r77;
        if (r125 == null) goto L227;
        ILiveActionHandler r126 = com.bytedance.android.livesdk.service.l.d().a();
        IRoomActionHandler.Params r78 = new IRoomActionHandler.Params().setRoomId(r35.id).setRequestId(r35.getRequestId()).setLogPb(r35.getLog_pb());
        InnerContextEntity.InnerFloatExtra r79 = r4.getEnterExtra();
        if (r79 == null) goto L141;
        String r80 = r79.getEnterFromMerge();
    L142:
        IRoomActionHandler.Params r81 = r78.setEnterFromMerge(r80);
        InnerContextEntity.InnerFloatExtra r82 = r4.getEnterExtra();
        if (r82 == null) goto L145;
        String r83 = r82.getEnterMethod();
    L146:
        IRoomActionHandler.Params r84 = r81.setEnterMethod(r83).setLogExtras(r117).setRoom(r35).setForceNewActivityWhenJumpRoom(r111).setSourceBtmToken(r122);
        InnerContextEntity.InnerFloatExtra r85 = r4.getEnterExtra();
        if (r85 == null) goto L151;
        InnerContextEntity.RoomEnterConfig r86 = r85.getRoomEnterConfig();
        if (r86 == null) goto L151;
        String r87 = r86.getEventParams();
    L152:
        IRoomActionHandler.Params r88 = r84.setEventParams(r87);
        InnerContextEntity.InnerFloatExtra r89 = r4.getEnterExtra();
        if (r89 == null) goto L157;
        InnerContextEntity.RoomEnterConfig r90 = r89.getRoomEnterConfig();
        if (r90 == null) goto L157;
        String r91 = r90.getLocalLifeParams();
    L158:
        IRoomActionHandler.Params r92 = r88.setLocalLifeParams(r91);
        InnerContextEntity.InnerFloatExtra r93 = r4.getEnterExtra();
        if (r93 == null) goto L163;
        InnerContextEntity.RoomEnterConfig r94 = r93.getRoomEnterConfig();
        if (r94 == null) goto L163;
        String r95 = r94.getBusinessLiveParams();
    L164:
        IRoomActionHandler.Params r96 = r92.setBusinessLiveParams(r95);
        InnerContextEntity.InnerFloatExtra r97 = r4.getEnterExtra();
        if (r97 == null) goto L169;
        InnerContextEntity.RoomEnterConfig r98 = r97.getRoomEnterConfig();
        if (r98 == null) goto L169;
        String r99 = r98.getBusinessExtra();
    L170:
        IRoomActionHandler.Params r127 = r96.setBusinessExtra(r99);
        InnerContextEntity.InnerFloatExtra r100 = r4.getEnterExtra();
        if (r100 == null) goto L179;
        InnerContextEntity.RoomEnterConfig r101 = r100.getRoomEnterConfig();
        if (r101 == null) goto L179;
        Bundle r102 = r101.getEnterBundleParams();
        if (r102 == null) goto L179;
        long[] r103 = r102.getLongArray("live.intent.extra.ENTER_ROOM_IDS");
        if (r103 == null) goto L179;
        r127.setRoomIds(r103);
    L179:
        Unit r104 = Unit.INSTANCE;
        IBaseLiveActionHandler.DefaultImpls.openRoom$default(r126, r125, r127, null, 4, null);
    L169:
        r99 = null;
    L163:
        r95 = null;
    L157:
        r91 = null;
    L151:
        r87 = null;
        goto L152
    L145:
        r83 = null;
        goto L146
    L141:
        r80 = null;
        goto L142
    L126:
        r122 = null;
        goto L127
    L85:
        if (r110.getForceNewActivityWhenJumpRoom() != true) goto L87;
        r111 = true;
    L227:
        r38 = false;
    L75:
        r34 = null;
    L70:
        r32 = null;
    L40:
        r16 = true;
        goto L44
    L29:
        if (Intrinsics.areEqual(r6, r13.substring(0, r13.length() - 2)) == false) goto L31;
        r14 = true;
    L34:
        r15 = false;
        goto L35
    L21:
        if (r11.isEmpty() == false) goto L23;
    L17:
        r10 = null;
    L41:
        r10 = null;
        goto L42
    L8:
        r4 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void onMuteButtonClick(boolean r3) {
        NewVideoInnerFloatManager.t(this.a.d, NewVideoInnerFloatManager.ActionType.MUTECLICK, r3);
        InnerContextEntity.InnerFloatExtra r0 = this.a.j;
        if (r0 == null) goto L6;
        r0.setMute(r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void onShow(int r3, int r4, int r5, int r6) {
        Iterator r0 = ((ArrayList) this.a.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        IVideoFloatManager.VideoFloatManagerListener r1 = (IVideoFloatManager.VideoFloatManagerListener) r0.next();
        if (r1 == null) goto L4;
        r1.onShow(r3, r4, r5, r6);
        goto L4
    }
}
