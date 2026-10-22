package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import android.content.SharedPreferences;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.j0;
import com.bytedance.android.anya.k0;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.v;
import com.bytedance.android.live.gift.GiftType;
import com.bytedance.android.live.revenue.common.s0;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.live.revenue.model.extension.main.IMainGiftRoom;
import com.bytedance.android.livesdk.gift.configmodel.s1;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickMinorsNoticeCloseButton;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftListBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftMinorsNoticeState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftReceiverViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftSearchBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftSearchViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.MinorsNoticeChangeLayoutAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.StickerEffectClosed;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIMinorsNoticeViewModel extends com.bytedance.android.anya.f<GiftPanelState, GiftMinorsNoticeState, GiftAction> implements o {
    public long u;
    public boolean v;
    public String w;
    public final u1 x;
    public final yz0.k y;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final MVIState F(l0 r17) {
        Intrinsics.checkNotNullParameter(r17, "$this$createState");
        GiftMinorsNoticeState r0 = new GiftMinorsNoticeState();
        s1 r2 = nz1.a.p();
        if (r2.a() == false) goto L51;
        IMainGiftRoom r4 = this.y.getRoom().castToOrNull(IMainGiftRoom.class);
        if (r4 == null) goto L11;
        com.bytedance.android.live.revenue.model.extension.main.c r5 = r4.getOthers();
        if (r5 == null) goto L11;
        com.bytedance.android.live.revenue.model.extension.main.b r6 = r5.getGiftPanelTopperTray();
        if (r6 == null) goto L11;
        String r7 = r6.getPanelSchema();
    L13:
        if (r7 != null) goto L15;
    L18:
        boolean r8 = true;
    L20:
        if ((!r8) == true) goto L51;
        SharedPreferences r9 = com.bytedance.android.live.core.utils.s1.getContext().getSharedPreferences("MinorsConsumeNoticeWidget", 0);
        int r10 = r9.getInt("sp_panel_open_times_key", 0);
        long r13 = r9.getLong("sp_panel_last_open_date_long_key", 0);
        int r15 = r9.getInt("sp_notice_show_times_int_key", 0);
        long r11 = r9.getLong("sp_notice_until_long_key", 0);
        int r14 = r10 + 1;
        if (new Date().before(new Date(r11)) == false) goto L28;
        if (s0.c(new u0(r11)) == true) goto L28;
        r0<GiftMinorsNoticeState, Boolean> r3 = r0.getBlockShow();
        Boolean r16 = Boolean.TRUE;
        r17.getClass();
        l0.h(r3, r16);
    L52:
        return r0;
    L28:
        if (s0.c(new u0(r13)) == true) goto L31;
        r14 = 1;
        r15 = 0;
    L31:
        if (nz1.a.f().b() == false) goto L34;
    L35:
        boolean r18 = true;
    L37:
        if (r18 == false) goto L40;
        r15 = r15 + 1;
    L40:
        if (r15 > r2.d()) goto L42;
        boolean r19 = true;
    L43:
        r0<GiftMinorsNoticeState, Boolean> r20 = r0.getBlockShow();
        if (r18 == false) goto L48;
        if (r19 == false) goto L48;
        boolean r21 = false;
    L49:
        Boolean r23 = Boolean.valueOf(r21);
        r17.getClass();
        l0.h(r20, r23);
        SharedPreferences.Editor r1 = r9.edit();
        r1.putInt("sp_panel_open_times_key", r14);
        r1.putInt("sp_notice_show_times_int_key", r15);
        r1.putLong("sp_panel_last_open_date_long_key", new Date().getTime());
        r1.apply();
    L48:
        r21 = true;
        goto L49
    L42:
        r19 = false;
        goto L43
    L34:
        if (((r14 - 1) % (r2.c() + 1)) == 0) goto L35;
        r18 = false;
        goto L37
    L15:
        if (r7.length() == 0) goto L18;
        r8 = false;
    L11:
        r7 = null;
    L51:
        r0<GiftMinorsNoticeState, Boolean> r24 = r0.getBlockShow();
        Boolean r25 = Boolean.TRUE;
        r17.getClass();
        l0.h(r24, r25);
        goto L52
    }

    public final void d(com.bytedance.android.anya.dsl.h<GiftPanelState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIMinorsNoticeViewModel$bindToParent$1 r0 = GiftMVIMinorsNoticeViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, GiftAction.class));
    }

    public GiftMVIMinorsNoticeViewModel(u1 r2, yz0.k r3) {
        Intrinsics.checkNotNullParameter(r2, "giftPanelLogService");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        this.x = r2;
        this.y = r3;
        this.w = BuildConfig.FLAVOR;
    }

    public final void w0(j0 r19, MVIState r20, p r21) {
        GiftMinorsNoticeState r0 = (GiftMinorsNoticeState) r20;
        Intrinsics.checkNotNullParameter(r19, "$this$postReduce");
        Intrinsics.checkNotNullParameter(r0, "state");
        Intrinsics.checkNotNullParameter((GiftAction) r21, "action");
        com.bytedance.android.anya.internal.p r3 = r19.getContext();
        Integer r5 = 0;
        com.bytedance.android.anya.internal.c r4 = (v) r3.a(r3.b(r3.c(GiftPanelState.class), GiftMVIMinorsNoticeViewModel$postReduce$1$tmp$1.INSTANCE), GiftMVIMinorsNoticeViewModel$postReduce$1$tmp$2.INSTANCE).a.invoke();
        boolean r7 = true;
        String r9 = null;
        if (r4 != null) goto L5;
        r5 = r5;
    L76:
        com.bytedance.android.anya.internal.p r6 = r19.getContext();
        com.bytedance.android.anya.internal.c r8 = (v) r6.b(r6.c(GiftPanelState.class), GiftMVIMinorsNoticeViewModel$postReduce$3$1.INSTANCE).a.invoke();
        if (r8 == null) goto L148;
        com.bytedance.android.anya.internal.c r10 = r8;
        Object r11 = r8.c();     // Catch: Throwable -> L174
        int r13 = r8.c;     // Catch: Throwable -> L174
        Object r14 = ((LinkedHashMap) r19.d).get(r8);     // Catch: Throwable -> L174
        if (r14 != null) goto L84;
        r14 = r5;
    L84:
        if (r13 <= ((Number) r14).intValue()) goto L86;
        boolean r15 = true;
    L87:
        if (r15 == false) goto L145;
        k0 r16 = j0.a.a;     // Catch: Throwable -> L174
        GiftSearchViewState r17 = (GiftSearchViewState) r11;     // Catch: Throwable -> L174
        r0<GiftMinorsNoticeState, Boolean> r18 = r0.getBlockShow();     // Catch: Throwable -> L174
        r16.getClass();     // Catch: Throwable -> L174
        if (((Boolean) com.bytedance.android.anya.h.b(r18)).booleanValue() == true) goto L91;
    L93:
        r r23 = r17.toBusinessState(r16);     // Catch: Throwable -> L174
        if ((r23 instanceof GiftSearchBusinessState.GiftSelected) == true) goto L96;
        r23 = null;
    L96:
        GiftSearchBusinessState.GiftSelected r24 = (GiftSearchBusinessState.GiftSelected) r23;     // Catch: Throwable -> L174
        if (r24 == null) goto L144;
        vz1.e r25 = r24.getIconModel();     // Catch: Throwable -> L174
        if (r25 == null) goto L144;
        h1 r26 = r25.a;     // Catch: Throwable -> L174
        if (r26 == null) goto L144;
        GiftMinorsNoticeState r110 = (GiftMinorsNoticeState) r19.g.f();     // Catch: Throwable -> L174
        String r111 = r26.getBannerScheme();     // Catch: Throwable -> L174
        if (r111 != null) goto L106;
    L109:
        boolean r112 = true;
    L110:
        if (r112 == true) goto L112;
        boolean r113 = true;
    L114:
        if (((Boolean) com.bytedance.android.anya.h.b(r0.getHasReceiverWidget())).booleanValue() == true) goto L118;
        if (r113 == true) goto L118;
        boolean r114 = false;
    L120:
        if (((Boolean) com.bytedance.android.anya.h.b(r0.getBlockShow())).booleanValue() == true) goto L123;
        if (r114 == true) goto L123;
        boolean r115 = true;
    L125:
        if (this.u == r26.getId()) goto L128;
        if (r115 == false) goto L128;
        u1 r116 = this.x;     // Catch: Throwable -> L174
        r116.getClass();     // Catch: Throwable -> L174
        r116.p1("livesdk_minor_reward_toast_show", new LinkedHashMap(), true);     // Catch: Throwable -> L174
        this.u = r26.getId();     // Catch: Throwable -> L174
    L128:
        l0.h(r0.getShouldShow(), Boolean.valueOf(r115));     // Catch: Throwable -> L174
        if (GiftManagerKt.u(Integer.valueOf(r26.getType())) != GiftType.STICKER_GIFT) goto L131;
        boolean r27 = true;
    L133:
        if (this.v == false) goto L142;
        if (r114 == true) goto L142;
        if (r27 == false) goto L142;
        String r28 = this.w;     // Catch: Throwable -> L174
        if ((!StringsKt.isBlank(r28)) == false) goto L139;
        r9 = r28;
    L139:
        if (r9 == null) goto L145;
        l0.h(r0.getShowAnchorEffectCloseNotice(), Boolean.TRUE);     // Catch: Throwable -> L174
        l0.h(r0.getAnchorEffectCloseNotice(), r9);     // Catch: Throwable -> L174
        this.x.d1(r26.getId());     // Catch: Throwable -> L174
    L142:
        l0.h(r0.getShowAnchorEffectCloseNotice(), Boolean.FALSE);     // Catch: Throwable -> L174
        l0.h(r0.getAnchorEffectCloseNotice(), BuildConfig.FLAVOR);     // Catch: Throwable -> L174
        goto L145
    L131:
        r27 = false;
    L123:
        r115 = false;
    L118:
        r114 = true;
        goto L120
    L112:
        r113 = false;
        goto L114
    L106:
        if (r111.length() == 0) goto L109;
        r112 = false;
    L144:
        r19.c.put(r8, Integer.valueOf(r10.c));
        return;
    L91:
        if (this.v == true) goto L93;
    L145:
        if (r15 == false) goto L147;
        r19.a();     // Catch: Throwable -> L174
    L147:
        r19.c.put(r8, Integer.valueOf(r10.c));
        goto L148
    L86:
        r15 = false;
    L174:
        th = move-exception;
        r19.c.put(r8, Integer.valueOf(r10.c));
        throw th;
    L148:
        com.bytedance.android.anya.internal.p r29 = r19.getContext();
        com.bytedance.android.anya.internal.c r30 = (v) r29.a(r29.b(r29.c(GiftPanelState.class), GiftMVIMinorsNoticeViewModel$postReduce$5$tmp$1.INSTANCE), GiftMVIMinorsNoticeViewModel$postReduce$5$tmp$2.INSTANCE).a.invoke();
        if (r30 == null) goto L188;
        com.bytedance.android.anya.internal.c r31 = r30;
        Object r33 = r30.c();     // Catch: Throwable -> L171
        int r34 = r30.c;     // Catch: Throwable -> L171
        Object r35 = ((LinkedHashMap) r19.d).get(r30);     // Catch: Throwable -> L171
        if (r35 != null) goto L156;
        r35 = r5;
    L156:
        if (r34 <= ((Number) r35).intValue()) goto L158;
        boolean r36 = true;
    L159:
        if (r36 == false) goto L167;
        j0.a r37 = j0.a.a;     // Catch: Throwable -> L171
        GiftReceiverViewState.Mode r38 = (GiftReceiverViewState.Mode) r33;     // Catch: Throwable -> L171
        GiftMinorsNoticeState r39 = (GiftMinorsNoticeState) r19.g.f();     // Catch: Throwable -> L171
        r0<GiftMinorsNoticeState, Boolean> r40 = r0.getHasReceiverWidget();     // Catch: Throwable -> L171
        GiftReceiverViewState.Mode r41 = GiftReceiverViewState.Mode.IDLE;     // Catch: Throwable -> L171
        if (r38 != r41) goto L164;
        r7 = false;
    L164:
        l0.h(r40, Boolean.valueOf(r7));     // Catch: Throwable -> L171
        if (r38 == r41) goto L167;
        l0.h(r0.getShouldShow(), Boolean.FALSE);     // Catch: Throwable -> L171
    L167:
        if (r36 == false) goto L169;
        r19.a();     // Catch: Throwable -> L171
    L169:
        r19.c.put(r30, Integer.valueOf(r31.c));
        return;
    L158:
        r36 = false;
    L171:
        th = move-exception;
        r19.c.put(r30, Integer.valueOf(r31.c));
        throw th;
    L188:
        return;
    L5:
        com.bytedance.android.anya.internal.c r117 = r4;
        Object r118 = r4.c();     // Catch: Throwable -> L177
        int r119 = r4.c;     // Catch: Throwable -> L177
        Object r120 = ((LinkedHashMap) r19.d).get(r4);     // Catch: Throwable -> L177
        if (r120 != null) goto L10;
        r120 = r5;
    L10:
        if (r119 <= ((Number) r120).intValue()) goto L12;
        boolean r121 = true;
    L13:
        if (r121 == false) goto L72;
        k0 r122 = j0.a.a;     // Catch: Throwable -> L177
        GiftVerticalState r123 = (GiftVerticalState) r118;     // Catch: Throwable -> L177
        r0<GiftMinorsNoticeState, Boolean> r124 = r0.getBlockShow();     // Catch: Throwable -> L177
        r122.getClass();     // Catch: Throwable -> L177
        if (((Boolean) com.bytedance.android.anya.h.b(r124)).booleanValue() == true) goto L17;
    L19:
        r r125 = r123.toBusinessState(r122);     // Catch: Throwable -> L177
        if ((r125 instanceof GiftListBusinessState.GiftSelected) == true) goto L22;
        r125 = null;
    L22:
        GiftListBusinessState.GiftSelected r126 = (GiftListBusinessState.GiftSelected) r125;     // Catch: Throwable -> L177
        if (r126 == null) goto L71;
        vz1.e r127 = r126.getIconModel();     // Catch: Throwable -> L177
        if (r127 == null) goto L71;
        h1 r128 = r127.a;     // Catch: Throwable -> L177
        if (r128 == null) goto L71;
        GiftMinorsNoticeState r129 = (GiftMinorsNoticeState) r19.g.f();     // Catch: Throwable -> L177
        String r130 = r128.getBannerScheme();     // Catch: Throwable -> L177
        if (r130 != null) goto L32;
    L35:
        boolean r131 = true;
    L36:
        if (r131 == true) goto L38;
        boolean r132 = true;
    L40:
        if (((Boolean) com.bytedance.android.anya.h.b(r0.getHasReceiverWidget())).booleanValue() == true) goto L44;
        if (r132 == true) goto L44;
        boolean r133 = false;
    L46:
        if (((Boolean) com.bytedance.android.anya.h.b(r0.getBlockShow())).booleanValue() == true) goto L49;
        if (r133 == true) goto L49;
        boolean r134 = true;
    L51:
        if (this.u == r128.getId()) goto L54;
        if (r134 == false) goto L54;
        u1 r43 = this.x;     // Catch: Throwable -> L177
        r43.getClass();     // Catch: Throwable -> L177
        r43.p1("livesdk_minor_reward_toast_show", new LinkedHashMap(), true);     // Catch: Throwable -> L177
        this.u = r128.getId();     // Catch: Throwable -> L177
    L54:
        l0.h(r0.getShouldShow(), Boolean.valueOf(r134));     // Catch: Throwable -> L177
        if (GiftManagerKt.u(Integer.valueOf(r128.getType())) != GiftType.STICKER_GIFT) goto L57;
        boolean r44 = true;
    L59:
        if (this.v == false) goto L69;
        if (r133 == true) goto L69;
        if (r44 == false) goto L69;
        String r45 = this.w;     // Catch: Throwable -> L177
        if ((!StringsKt.isBlank(r45)) == true) goto L66;
        r45 = null;
    L66:
        if (r45 == null) goto L73;
        l0.h(r0.getShowAnchorEffectCloseNotice(), Boolean.TRUE);     // Catch: Throwable -> L177
        l0.h(r0.getAnchorEffectCloseNotice(), r45);     // Catch: Throwable -> L177
        this.x.d1(r128.getId());     // Catch: Throwable -> L177
    L73:
        if (r121 == false) goto L75;
        r19.a();     // Catch: Throwable -> L177
    L75:
        r19.c.put(r4, Integer.valueOf(r117.c));
    L69:
        l0.h(r0.getShowAnchorEffectCloseNotice(), Boolean.FALSE);     // Catch: Throwable -> L177
        l0.h(r0.getAnchorEffectCloseNotice(), BuildConfig.FLAVOR);     // Catch: Throwable -> L177
        goto L73
    L57:
        r44 = false;
    L49:
        r134 = false;
    L44:
        r133 = true;
        goto L46
    L38:
        r132 = false;
        goto L40
    L32:
        if (r130.length() == 0) goto L35;
        r131 = false;
    L71:
        r19.c.put(r4, Integer.valueOf(r117.c));
        return;
    L17:
        if (this.v == true) goto L19;
    L72:
        r5 = r5;
        goto L73
    L12:
        r121 = false;
    L177:
        th = move-exception;
        r19.c.put(r4, Integer.valueOf(r117.c));
        throw th;
    }

    public final void y0(l0 r18, MVIState r19, p r20) {
        GiftMinorsNoticeState r1 = (GiftMinorsNoticeState) r19;
        GiftAction r2 = (GiftAction) r20;
        Intrinsics.checkNotNullParameter(r18, "$this$reduce");
        Intrinsics.checkNotNullParameter(r1, "state");
        Intrinsics.checkNotNullParameter(r2, "action");
        if ((r2 instanceof ClickMinorsNoticeCloseButton) == false) goto L6;
        s1 r3 = nz1.a.p();
        SharedPreferences.Editor r6 = com.bytedance.android.live.core.utils.s1.getContext().getSharedPreferences("MinorsConsumeNoticeWidget", 0).edit();
        int r4 = r3.b();
        Calendar r7 = Calendar.getInstance();
        r7.set(r7.get(1), r7.get(2), r7.get(5), 0, 0, 0);
        r7.add(5, r4);
        r6.putLong("sp_notice_until_long_key", r7.getTimeInMillis()).apply();
        r0<GiftMinorsNoticeState, Boolean> r5 = r1.getShouldShow();
        Boolean r8 = Boolean.FALSE;
        r18.getClass();
        l0.h(r5, r8);
        l0.h(r1.getBlockShow(), Boolean.TRUE);
        u1 r9 = this.x;
        r9.getClass();
        r9.p1("livesdk_minor_reward_toast_click", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click_button", "1")}), true);
    L6:
        if ((r2 instanceof MinorsNoticeChangeLayoutAction) == false) goto L9;
        r0<GiftMinorsNoticeState, Boolean> r10 = r1.getNeedChangeLayout();
        Boolean r11 = Boolean.TRUE;
        r18.getClass();
        l0.h(r10, r11);
    L9:
        if ((r2 instanceof StickerEffectClosed) == false) goto L12;
        this.v = true;
        this.w = ((StickerEffectClosed) r2).getNoticeText();
        return;
    }
}
