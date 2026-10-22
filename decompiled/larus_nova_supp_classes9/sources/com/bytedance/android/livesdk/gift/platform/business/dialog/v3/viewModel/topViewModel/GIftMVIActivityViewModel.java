package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import android.content.Context;
import android.graphics.Color;
import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.dsl.h;
import com.bytedance.android.anya.j0;
import com.bytedance.android.anya.k0;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.v;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.model.d2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.model.x1;
import com.bytedance.android.livesdk.gift.model.x2;
import com.bytedance.android.livesdk.gift.model.y2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftMVICarnivalDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftTopicDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickActivityBtn;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTabViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopActivityState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PageProgressBarData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.l;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.i;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftInRoomService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.bytedance.android.livesdk.message.model.GiftTouchAction;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import zz0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GIftMVIActivityViewModel extends com.bytedance.android.anya.f<GiftTopViewState, GiftTopActivityState, GiftAction> implements o, l<GiftTopActivityState, GiftAction> {
    public GiftTabViewState u;
    public Pair<Long, ? extends d2> v;
    public final i w;
    public final GiftMVICarnivalDataStore x;
    public final GiftTopicDataStore y;
    public final u1 z;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Set<BaseMVIDataStore<?>> I() {
        return SetsKt.setOf(this.y);
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new GiftTopActivityState();
    }

    public final void d(h<GiftTopViewState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GIftMVIActivityViewModel$bindToParent$1 r0 = GIftMVIActivityViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, GiftAction.class));
    }

    public final void J0(com.bytedance.android.anya.internal.e r3, MVIState r4) {
        final GiftTopActivityState r5 = (GiftTopActivityState) r4;
        Intrinsics.checkNotNullParameter(r3, "$this$reduce");
        Intrinsics.checkNotNullParameter(r5, "state");
        r3.e(this.y.w(), new GIftMVIActivityViewModel$reduce$1(this, r5));
    }

    public final void w0(j0 r7, MVIState r8, p r9) {
        GiftTopActivityState r10 = (GiftTopActivityState) r8;
        Intrinsics.checkNotNullParameter(r7, "$this$postReduce");
        Intrinsics.checkNotNullParameter(r10, "state");
        Intrinsics.checkNotNullParameter((GiftAction) r9, "action");
        com.bytedance.android.anya.internal.p r11 = r7.getContext();
        com.bytedance.android.anya.internal.p.b r13 = r11.b(r11.c(GiftPanelState.class), GIftMVIActivityViewModel$postReduce$1$1.INSTANCE);
        boolean r0 = false;
        Object r1 = 0;
        com.bytedance.android.anya.internal.c r14 = (v) r13.a.invoke();
        if (r14 == null) goto L23;
        com.bytedance.android.anya.internal.c r2 = r14;
        Object r3 = r14.c();     // Catch: Throwable -> L19
        int r4 = r14.c;     // Catch: Throwable -> L19
        Object r5 = ((LinkedHashMap) r7.d).get(r14);     // Catch: Throwable -> L19
        if (r5 == null) goto L11;
        r1 = r5;
    L11:
        if (r4 <= ((Number) r1).intValue()) goto L13;
        r0 = true;
    L13:
        if (r0 == false) goto L15;
        j0.a r6 = j0.a.a;     // Catch: Throwable -> L19
        GiftTabViewState r15 = (GiftTabViewState) r3;     // Catch: Throwable -> L19
        this.u = r15;     // Catch: Throwable -> L19
        l0<GiftTopActivityState> r16 = r7.g;     // Catch: Throwable -> L19
        GiftTopActivityState r17 = (GiftTopActivityState) r16.f();     // Catch: Throwable -> L19
        e1(r16, r15, r10, this.v);     // Catch: Throwable -> L19
    L17:
        r7.c.put(r14, Integer.valueOf(r2.c));
        return;
    L15:
        if (r0 == false) goto L17;
        r7.a();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r7.c.put(r14, Integer.valueOf(r2.c));
        throw th;
    }

    public final void y0(l0 r5, MVIState r6, p r7) {
        GiftTopActivityState r8 = (GiftTopActivityState) r6;
        GiftAction r9 = (GiftAction) r7;
        Intrinsics.checkNotNullParameter(r5, "$this$reduce");
        Intrinsics.checkNotNullParameter(r8, "state");
        Intrinsics.checkNotNullParameter(r9, "action");
        if ((r9 instanceof ClickActivityBtn) == false) goto L36;
        x2 r0 = null;
        Object r1 = null;
        if (com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).isLogin() == true) goto L13;
        i12.e r10 = i12.o.b();
        if (r10 == null) goto L9;
        r1 = m.e.d(r10, GiftInRoomService.class);
    L9:
        GiftInRoomService r2 = (GiftInRoomService) r1;
        if (r2 == null) goto L12;
        r2.a(1001);
        return;
    L12:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.k(1001));
        return;
    L13:
        g r11 = com.bytedance.android.live.revenue.core.util.f.a(g.class);
        Context r3 = s1.getContext();
        r0<GiftTopActivityState, String> r13 = r8.getSchemeUrl();
        r5.getClass();
        r11.S2(r3, (String) com.bytedance.android.anya.h.b(r13));
        k0 r14 = r5.b;
        GiftTabViewState r15 = this.u;
        if (r15 == null) goto L18;
        r0<GiftTabViewState, Integer> r16 = r15.getTabType();
        if (r16 == null) goto L18;
        r14.getClass();
        Integer r17 = (Integer) com.bytedance.android.anya.h.b(r16);
    L19:
        if (r17 == null) goto L21;
        int r18 = r17.intValue();
    L22:
        w1 r19 = this.w.U(r18);
        if (r19 == null) goto L25;
        r0 = r19.getPageInfo();
    L25:
        u1 r20 = this.z;
        if (r0 == null) goto L29;
        String r21 = r0.getTitle();
        if (r21 == null) goto L29;
    L30:
        if (r0 == null) goto L33;
        Map<String, String> r4 = r0.getExtra();
        if (r4 == null) goto L33;
    L34:
        r20.getClass();
        Intrinsics.checkNotNullParameter("doudi", "topSceneType");
        Intrinsics.checkNotNullParameter(r21, "topSceneTitle");
        Intrinsics.checkNotNullParameter(r4, "extra");
        LinkedHashMap r23 = new LinkedHashMap();
        r23.put("top_scene_type", "doudi");
        r23.put("top_scene_title", r21);
        r23.putAll(r4);
        r23.put("top_scene_sub_type", BuildConfig.FLAVOR);
        r23.put("top_scene_icon_gift_id", BuildConfig.FLAVOR);
        r23.put("top_scene_gift_list", BuildConfig.FLAVOR);
        r20.p1("gift_top_scene_click", r23, true);
        return;
    L33:
        r4 = new LinkedHashMap();
    L29:
        r21 = BuildConfig.FLAVOR;
        goto L30
    L21:
        r18 = -1;
    L18:
        r17 = null;
        goto L19
    }

    public final void e1(l0<GiftTopActivityState> r11, GiftTabViewState r13, GiftTopActivityState r14, Pair<Long, ? extends d2> r15) {
        if (r13 == null) goto L5;
        i r1 = this.w;
        r0<GiftTabViewState, Integer> r2 = r13.getTabType();
        r11.getClass();
        w1 r3 = r1.U(((Number) com.bytedance.android.anya.h.b(r2)).intValue());
    L6:
        String r4 = BuildConfig.FLAVOR;
        if (r3 == null) goto L26;
        String r5 = r3.getPageName();
        if (r5 == null) goto L26;
        r0<GiftTopActivityState, String> r6 = r14.getCurrentPageName();
        r11.getClass();
        l0.h(r6, r5);
        x1 r7 = this.x.n();
        if (r7 == null) goto L13;
        int r8 = r7.getTopBarAction();
    L15:
        if (((Number) com.bytedance.android.anya.h.b(r13.getTabType())).intValue() != 23) goto L26;
        if (r8 == GiftTouchAction.Display.getValue()) goto L19;
    L20:
        GiftMVICarnivalDataStore r9 = this.x;
        x2 r10 = r3.getPageInfo();
        if (r10 == null) goto L24;
        String r16 = r10.getText();
        if (r16 == null) goto L24;
    L25:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r16, "noticeText");
        r9.k.X4().onNext(r16);
    L24:
        r16 = BuildConfig.FLAVOR;
        goto L25
    L19:
        if (nz1.a.b().a() == true) goto L26;
    L13:
        r8 = GiftTouchAction.Hide.getValue();
    L26:
        if (r3 == null) goto L28;
        x2 r17 = r3.getPageInfo();
    L29:
        boolean r18 = false;
        if (r15 == null) goto L48;
        long r19 = ((Number) r15.getFirst()).longValue();
        if (r13 == null) goto L38;
        r0<GiftTabViewState, Integer> r110 = r13.getTabType();
        if (r110 == null) goto L38;
        r11.getClass();
        if (r19 != ((Integer) com.bytedance.android.anya.h.b(r110)).intValue()) goto L38;
        boolean r111 = true;
    L39:
        if (r111 == true) goto L42;
        r15 = null;
    L42:
        if (r15 == null) goto L48;
        d2 r112 = (d2) r15.getSecond();
        if (r112 == null) goto L48;
        x2 r113 = r112.getPageInfo();
        if (r113 == null) goto L48;
        r17 = r113;
    L38:
        r111 = false;
    L48:
        if (r17 == null) goto L95;
        r0<GiftTopActivityState, String> r114 = r14.getText();
        String r115 = r17.getText();
        if (r115 != null) goto L52;
        r115 = BuildConfig.FLAVOR;
    L52:
        r11.getClass();
        l0.h(r114, r115);
        r0<GiftTopActivityState, String> r116 = r14.getTitle();
        String r117 = r17.getTitle();
        if (r117 != null) goto L55;
        r117 = BuildConfig.FLAVOR;
    L55:
        l0.h(r116, r117);
        r0<GiftTopActivityState, k> r118 = r14.getTitleImg();
        k r119 = r17.getTitleImg();
        if (r119 != null) goto L58;
        r119 = GiftTopActivityState.Companion.getDefaultImg();
    L58:
        l0.h(r118, r119);
        r0<GiftTopActivityState, String> r120 = r14.getButtonText();
        String r121 = r17.getButtonText();
        if (r121 != null) goto L61;
        r121 = BuildConfig.FLAVOR;
    L61:
        l0.h(r120, r121);
        r0<GiftTopActivityState, String> r122 = r14.getSchemeUrl();
        String r123 = r17.getSchemeUrl();
        if (r123 == null) goto L65;
        r4 = r123;
    L65:
        l0.h(r122, r4);
        r0<GiftTopActivityState, k> r124 = r14.getBackgroundImg();
        k r125 = r17.getBackgroundImg();
        if (r125 != null) goto L68;
        r125 = GiftTopActivityState.Companion.getDefaultImg();
    L68:
        l0.h(r124, r125);
        r0<GiftTopActivityState, k> r126 = r14.getIconImage();
        k r127 = r17.getIconImage();
        if (r127 != null) goto L71;
        r127 = GiftTopActivityState.Companion.getDefaultImg();
    L71:
        l0.h(r126, r127);
        r0<GiftTopActivityState, PageProgressBarData> r128 = r14.getProgressBarData();
        y2 r129 = r17.getPageProgressBar();
        if (r129 != null) goto L74;
        PageProgressBarData r130 = new PageProgressBarData(false, 0.0f, 0, 7, null);
    L91:
        l0.h(r128, r130);
        return;
    L74:
        if (r129.getTargetPercentage() > 0) goto L76;
    L78:
        if (r18 == false) goto L80;
        float r131 = r129.getCurrentPercentage() / r129.getTargetPercentage();
    L93:
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L83
        Object r133 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r129.getBarColor())));     // Catch: Throwable -> L83
    L86:
        if (Result.exceptionOrNull-impl(r133) == null) goto L89;
        r133 = -1;
    L89:
        r130 = new PageProgressBarData(r18, r131, ((Number) r133).intValue());
    L83:
        th = move-exception;
        Result.Companion r134 = Result.Companion;
        r133 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L86
    L80:
        r131 = 0.0f;
        goto L93
    L76:
        if (r129.getTargetPercentage() < r129.getCurrentPercentage()) goto L78;
        r18 = true;
        goto L78
    L95:
        return;
    L28:
        r17 = null;
        goto L29
    L5:
        r3 = null;
        goto L6
    }

    public GIftMVIActivityViewModel(e1 r2, i r3, GiftMVICarnivalDataStore r4, GiftTopicDataStore r5, u1 r6) {
        Intrinsics.checkNotNullParameter(r2, "giftListService");
        Intrinsics.checkNotNullParameter(r3, "giftListRepository");
        Intrinsics.checkNotNullParameter(r4, "giftMVICarnivalDataStore");
        Intrinsics.checkNotNullParameter(r5, "giftTopicDataStore");
        Intrinsics.checkNotNullParameter(r6, "giftPanelLogService");
        this.w = r3;
        this.x = r4;
        this.y = r5;
        this.z = r6;
    }
}
