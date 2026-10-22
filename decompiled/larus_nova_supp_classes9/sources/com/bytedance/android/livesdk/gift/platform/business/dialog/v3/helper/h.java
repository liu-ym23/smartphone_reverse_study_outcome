package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import android.text.TextUtils;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.t0;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftTabDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.CounterData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftListBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PagerListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.TopicPagerListData;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h {
    public l0 a;
    public int b;
    public boolean c;
    public int d;
    public final String e;
    public final LocateGiftInfo f;
    public final Integer g;
    public final Function8<com.bytedance.android.anya.l0<GiftVerticalState>, GiftVerticalState, Integer, Integer, Integer, Integer, String, Boolean, Unit> h;

    public static final class a {
    }

    static {
    }

    public static LocateGiftInfo c(LocateGiftInfo r19, int r20) {
        Intrinsics.checkNotNullParameter(r19, "origin");
        if (r19.getTargetPageType() == 0) goto L6;
        return LocateGiftInfo.copy$default(r19, r19.getTargetPageType(), 0, null, 0, false, 0, false, false, null, null, 0, null, 0, 8190, null);
    L6:
        return LocateGiftInfo.copy$default(r19, r20, 0, null, 0, false, 0, false, false, null, null, 0, null, 0, 8190, null);
    }

    public final boolean a(com.bytedance.android.anya.l0<GiftVerticalState> r4, GiftVerticalState r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$checkNeedLocate");
        Intrinsics.checkNotNullParameter(r5, "state");
        if ((r4.i(r5) instanceof GiftListBusinessState.Idle) == false) goto L19;
        int r6 = ((Number) com.bytedance.android.anya.h.b(r5.getCurrentPagePosition())).intValue();
        Integer r7 = this.g;
        if (r7 != null) goto L14;
        i12.d r8 = i12.m.e2.a();
        if (r8 == null) goto L9;
        Object r9 = com.bytedance.android.scope.m.e.d(r8, GiftTabDataStore.class);
    L10:
        GiftTabDataStore r10 = (GiftTabDataStore) r9;
        if (r10 == null) goto L13;
        r7 = Integer.valueOf(r10.w());
        goto L14
    L13:
        r7 = null;
        goto L14
    L9:
        r9 = null;
    L14:
        if (r7 == null) goto L19;
        if (r6 != r7.intValue()) goto L19;
        return true;
    L19:
        return false;
    }

    public final void b(com.bytedance.android.anya.l0<GiftVerticalState> r14, GiftVerticalState r15) {
        Intrinsics.checkNotNullParameter(r14, "$this$checkNeedSelected");
        Intrinsics.checkNotNullParameter(r15, "state");
        if (this.c == false) goto L5;
        return;
    L5:
        this.c = true;
        int r0 = this.b;
        if (r0 != 0) goto L8;
        return;
    L8:
        if (r0 != 2) goto L10;
        return;
    L10:
        if (a(r14, r15) == true) goto L13;
        return;
    L13:
        if (f(this, r14, r15, this.f.getTargetGiftId(), this.f.getBuffLevel(), this.f.getTargetPageType(), "checkNeedSelected", this.f.getTargetPropDefId(), 80) == false) goto L16;
        this.b = 2;
        return;
    L16:
        int r16 = ToastUtil.a;
        ToastUtil.b(this.f.getTipsWhenNotExist(), 0);
    }

    public h(LocateGiftInfo r2, Integer r3, Function8<? super com.bytedance.android.anya.l0<GiftVerticalState>, ? super GiftVerticalState, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super String, ? super Boolean, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "locateGiftInfo");
        Intrinsics.checkNotNullParameter(r4, "selectGiftFun");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.a = new l0(0);
        int r5 = com.bytedance.android.livesdk.gift.platform.core.h.n().d();
        this.d = r5;
        String r6 = BuildConfig.FLAVOR;
        this.e = BuildConfig.FLAVOR;
        if (r5 >= 0) goto L5;
    L6:
        this.d = 0;
    L8:
        if (com.bytedance.android.livesdk.gift.platform.core.h.n().o() == false) goto L19;
        IFeatureService r7 = jc1.k.f(IFeatureService.class);
        if (r7 == null) goto L17;
        z90.a r8 = r7.getFeatureManager();
        if (r8 == null) goto L17;
        String r9 = (String) r8.getFeature("solaria_features_top1_gift_id_pv", BuildConfig.FLAVOR);
        if (r9 == null) goto L17;
        r6 = r9;
    L17:
        this.e = r6;
        return;
    L19:
        return;
    L5:
        if (r5 <= 12) goto L8;
        goto L6
    }

    public final void d(com.bytedance.android.anya.l0<GiftVerticalState> r23, GiftVerticalState r24, LocateGiftInfo r25, String r26) {
        Intrinsics.checkNotNullParameter(r23, "$this$locateGift");
        Intrinsics.checkNotNullParameter(r24, "state");
        Intrinsics.checkNotNullParameter(r25, "locateGiftInfo");
        Intrinsics.checkNotNullParameter(r26, "source");
        if (f(this, r23, r24, r25.getTargetGiftId(), r25.getBuffLevel(), r25.getTargetPageType(), r26, r25.getTargetPropDefId(), 64) == false) goto L5;
        return;
    L5:
        int r0 = r25.getActionWhenNotExist();
        if (r0 == 1) goto L69;
        if (r0 == 2) goto L11;
    L71:
        this.b = 1;
    L72:
        GiftContext r1 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r1 == null) goto L82;
        com.bytedance.live.datacontext.n<GiftContext.a> r2 = r1.getLastClickRechargeSelectGift();
        if (r2 == null) goto L83;
        r2.setValue(null);
        return;
    L83:
        return;
    L82:
        return;
    L11:
        if (this.f.getTargetPageType() != 0) goto L13;
    L19:
        boolean r3 = false;
    L21:
        if (r3 == false) goto L35;
        com.bytedance.android.anya.k0 r4 = r23.b;
        t0<GiftVerticalState, PagerListData> r5 = r24.getPanelList();
        r4.getClass();
        Iterator r6 = com.bytedance.android.anya.k0.c(r5).iterator();
        int r7 = 0;
    L24:
        if (r6.hasNext() == false) goto L32;
        if (((Number) com.bytedance.android.anya.h.b(((PagerListData) r6.next()).getTabType())).intValue() != r25.getTargetPageType()) goto L28;
        boolean r8 = true;
    L29:
        if (r8 == true) goto L33;
        r7 = r7 + 1;
    L33:
        g(r23, r24, Math.max(r7, 0), r26);
        this.b = 2;
        goto L72
    L28:
        r8 = false;
        goto L29
    L32:
        r7 = -1;
        goto L33
    L35:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.R.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[42])).booleanValue() == false) goto L46;
        GiftContext r9 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r9 == null) goto L46;
        com.bytedance.live.datacontext.n<GiftContext.a> r10 = r9.getLastClickRechargeSelectGift();
        if (r10 == null) goto L46;
        GiftContext.a r11 = (GiftContext.a) r10.getValue();
        if (r11 == null) goto L46;
        if (f(this, r23, r24, r11.a, r11.b, r11.c, r26 + "_lastRechargeSelectGift", 0, 208) == false) goto L46;
        this.b = 2;
    L46:
        GiftContext r13 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r13 == null) goto L55;
        com.bytedance.live.datacontext.m<GiftContext.a> r14 = r13.getLastSendGiftId();
        if (r14 == null) goto L55;
        GiftContext.a r15 = (GiftContext.a) r14.getValue();
        if (r15 == null) goto L55;
        int r16 = 2;
        if (f(this, r23, r24, r15.a, r15.b, r15.c, r26 + "_lastSendGift", 0, 208) == false) goto L56;
        this.b = 2;
    L56:
        com.bytedance.android.anya.k0 r17 = r23.b;
        t0<GiftVerticalState, PagerListData> r18 = r24.getPanelList();
        r17.getClass();
        Iterator r19 = com.bytedance.android.anya.k0.c(r18).iterator();
        int r20 = 0;
    L58:
        if (r19.hasNext() == false) goto L66;
        if (((Number) com.bytedance.android.anya.h.b(((PagerListData) r19.next()).getTabType())).intValue() != r25.getTargetPageType()) goto L62;
        boolean r21 = true;
    L63:
        if (r21 == true) goto L64;
        r20 = r20 + 1;
        goto L58
    L64:
        int r27 = 0;
    L67:
        g(r23, r24, Math.max(r20, r27), r26);
        this.b = r16;
        goto L72
    L62:
        r21 = false;
        goto L63
    L66:
        r27 = 0;
        r20 = -1;
    L55:
        r16 = 2;
        goto L56
    L13:
        if (this.f.getTargetPageType() == 1) goto L19;
        if (this.f.getTargetGiftId() != (-1)) goto L19;
        if (this.f.getTargetPropDefId() != (-1)) goto L19;
        r3 = true;
        goto L21
    L69:
        if (this.c == false) goto L71;
        int r28 = ToastUtil.a;
        ToastUtil.b(r25.getTipsWhenNotExist(), 0);
        goto L71
    }

    public final void g(com.bytedance.android.anya.l0<GiftVerticalState> r19, GiftVerticalState r20, int r21, String r23) {
        Intrinsics.checkNotNullParameter(r19, "$this$selectFirstGift");
        Intrinsics.checkNotNullParameter(r20, "state");
        Intrinsics.checkNotNullParameter(r23, "source");
        if (com.bytedance.android.livesdk.gift.platform.core.h.n().o() == true) goto L5;
    L57:
        boolean r10 = false;
    L58:
        t0<GiftVerticalState, PagerListData> r2 = r20.getPanelList();
        r19.getClass();
        if (r21 >= com.bytedance.android.anya.h.a(r2)) goto L69;
        com.bytedance.android.anya.k0 r3 = r19.b;
        t0<GiftVerticalState, PagerListData> r4 = r20.getPanelList();
        r3.getClass();
        if (((Number) com.bytedance.android.anya.h.b(((PagerListData) com.bytedance.android.anya.k0.d(r4, r21)).getTabType())).intValue() == 17) goto L63;
    L65:
        boolean r6 = false;
    L66:
        if (r6 == false) goto L69;
        if (r10 == true) goto L69;
        this.d++;
        goto L69
    L63:
        if (((Boolean) com.bytedance.android.anya.h.b(((PagerListData) com.bytedance.android.anya.k0.d(r20.getPanelList(), r21)).getHasHeader())).booleanValue() == false) goto L65;
        r6 = true;
    L69:
        this.h.invoke(r19, r20, Integer.valueOf(r21), Integer.valueOf(this.d), -1, -1, r23 + "_selectFirstGift", Boolean.TRUE);
        return;
    L5:
        if (b.a(this.e) == false) goto L57;
        com.bytedance.android.anya.internal.u r5 = r20.getPanelList();
        Iterator r8 = ((Iterable) r5.c()).iterator();
        int r9 = 0;
        r10 = false;
        int r11 = 0;
    L8:
        if (r8.hasNext() == false) goto L58;
        Object r13 = r8.next();
        int r14 = r9 + 1;
        if (r9 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        MVIState r15 = (MVIState) r13;
        new com.bytedance.android.anya.k0.a();     // Catch: Throwable -> L52
        com.bytedance.android.anya.internal.u r16 = ((PagerListData) r15).getItemDataList();     // Catch: Throwable -> L52
        com.bytedance.android.anya.internal.u r17 = r16;     // Catch: Throwable -> L52
        Iterator r18 = ((Iterable) r16.c()).iterator();     // Catch: Throwable -> L52
        int r7 = 0;
    L15:
        if (r18.hasNext() == false) goto L49;
        Object r110 = r18.next();     // Catch: Throwable -> L52
        int r111 = r7 + 1;     // Catch: Throwable -> L52
        if (r7 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L52
    L19:
        MVIState r24 = (MVIState) r110;     // Catch: Throwable -> L52
        new com.bytedance.android.anya.k0.a();     // Catch: Throwable -> L43
        if (String.valueOf(((vz1.e) ((ItemListData) r24).getItemData().c()).b).equals(this.e) == false) goto L33;
        if (r11 < 0) goto L29;
        if (7 < r11) goto L29;
        this.d = r11;     // Catch: Throwable -> L43
        r10 = true;
    L40:
        if ((!r24.modifiedProperties.isEmpty()) == false) goto L42;
        ((com.bytedance.android.anya.internal.t) r16.c()).d(r7);     // Catch: Throwable -> L52
    L42:
        r7 = r111;
        goto L15
    L29:
        if ((!r24.modifiedProperties.isEmpty()) == false) goto L49;
        Object r25 = r16.c();     // Catch: Throwable -> L52
    L37:
        ((com.bytedance.android.anya.internal.t) r25).d(r7);     // Catch: Throwable -> L52
        goto L49
    L33:
        if (r11 >= 8) goto L35;
        r11 = r11 + 1;     // Catch: Throwable -> L52
        goto L40
    L35:
        if ((!r24.modifiedProperties.isEmpty()) == false) goto L49;
        r25 = r16.c();     // Catch: Throwable -> L52
    L43:
        th = move-exception;
        if ((!r24.modifiedProperties.isEmpty()) == false) goto L47;
        ((com.bytedance.android.anya.internal.t) r16.c()).d(r7);     // Catch: Throwable -> L52
    L47:
        throw th;     // Catch: Throwable -> L52
    L49:
        if ((!r15.modifiedProperties.isEmpty()) == false) goto L51;
        ((com.bytedance.android.anya.internal.t) r5.c()).d(r9);
    L51:
        r9 = r14;
    L52:
        th = move-exception;
        if ((!r15.modifiedProperties.isEmpty()) == false) goto L56;
        ((com.bytedance.android.anya.internal.t) r5.c()).d(r9);
    L56:
        throw th;
    }

    public final boolean e(final com.bytedance.android.anya.l0 r33, final GiftVerticalState r34, long r35, int r36, boolean r37, String r38, String r39, long r40) {
        String r9 = r39;
        final Ref.BooleanRef r10 = new Ref.BooleanRef();
        r10.element = false;
        final Ref.IntRef r13 = new Ref.IntRef();
        r13.element = 0;
        final Ref.IntRef r14 = new Ref.IntRef();
        r14.element = 0;
        final Ref.IntRef r15 = new Ref.IntRef();
        r15.element = -1;
        final Ref.IntRef r8 = new Ref.IntRef();
        r8.element = -1;
        if (r37 == false) goto L5;
        boolean r17 = a(r33, r34);
    L7:
        if (com.bytedance.android.livesdk.gift.platform.core.h.n().q() == true) goto L108;
        Function5<ItemListData, Integer, Integer, Integer, Integer, Unit> r20 = new GiftDefaultSelectHelper$searchPropPanel$$inlined$modifyListDataWithRuleIndexed$1(r33, r34, r10, r13, r14, r15, r8);
        com.bytedance.android.anya.k0 r1 = r33.b;
        t0<GiftVerticalState, PagerListData> r2 = r34.getPanelList();
        r1.getClass();
        Iterator r7 = com.bytedance.android.anya.k0.c(r2).iterator();
        int r11 = 0;
    L10:
        if (r7.hasNext() == false) goto L107;
        Object r3 = r7.next();
        int r21 = r11 + 1;
        if (r11 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        PagerListData r23 = (PagerListData) r3;
        Iterator r24 = com.bytedance.android.anya.k0.c(r23.getItemDataList()).iterator();
        int r4 = 0;
    L16:
        if (r24.hasNext() == false) goto L40;
        Object r5 = r24.next();
        int r25 = r4 + 1;
        if (r4 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        ItemListData r6 = (ItemListData) r5;
        if (r40 <= 0) goto L28;
        if (((vz1.e) com.bytedance.android.anya.h.b(r6.getItemData())).f() == true) goto L25;
    L32:
        boolean r16 = false;
    L33:
        if (r16 == false) goto L36;
        if (r17 == false) goto L36;
        boolean r18 = true;
    L37:
        if (r18 == false) goto L39;
        r20.invoke(r6, Integer.valueOf(r11), Integer.valueOf(r4), -1, -1);
    L39:
        r4 = r25;
    L36:
        r18 = false;
        goto L37
    L25:
        if (((vz1.e) com.bytedance.android.anya.h.b(r6.getItemData())).d() != r40) goto L32;
    L31:
        r16 = true;
        goto L33
    L28:
        if (((vz1.e) com.bytedance.android.anya.h.b(r6.getItemData())).c().getId() != r35) goto L32;
        if (r35 <= 0) goto L32;
    L40:
        Iterator r26 = com.bytedance.android.anya.k0.c(r23.getCounterDataList()).iterator();
        int r27 = 0;
    L42:
        if (r26.hasNext() == false) goto L73;
        Object r19 = r26.next();
        int r28 = r27 + 1;
        if (r27 >= 0) goto L46;
        CollectionsKt.throwIndexOverflow();
    L46:
        Iterator r29 = com.bytedance.android.anya.k0.c(((CounterData) r19).getItemDataList()).iterator();
        int r30 = 0;
    L48:
        if (r29.hasNext() == false) goto L72;
        Object r31 = r29.next();
        int r210 = r30 + 1;
        if (r30 >= 0) goto L52;
        CollectionsKt.throwIndexOverflow();
    L52:
        ItemListData r41 = (ItemListData) r31;
        if (r40 <= 0) goto L60;
        if (((vz1.e) com.bytedance.android.anya.h.b(r41.getItemData())).f() == true) goto L57;
    L64:
        boolean r43 = false;
    L65:
        if (r43 == false) goto L68;
        if (r17 == false) goto L68;
        boolean r44 = true;
    L69:
        if (r44 == false) goto L71;
        r20.invoke(r41, Integer.valueOf(r11), Integer.valueOf(r30), Integer.valueOf(r27), -1);
    L71:
        r30 = r210;
    L68:
        r44 = false;
        goto L69
    L57:
        if (((vz1.e) com.bytedance.android.anya.h.b(r41.getItemData())).d() != r40) goto L64;
    L63:
        r43 = true;
        goto L65
    L60:
        if (((vz1.e) com.bytedance.android.anya.h.b(r41.getItemData())).c().getId() != r35) goto L64;
        if (r35 <= 0) goto L64;
    L72:
        r27 = r28;
        goto L42
    L73:
        Iterator r211 = com.bytedance.android.anya.k0.c(r23.getTopicPagerListData()).iterator();
        int r212 = 0;
    L75:
        if (r211.hasNext() == false) goto L106;
        Object r45 = r211.next();
        int r213 = r212 + 1;
        if (r212 >= 0) goto L79;
        CollectionsKt.throwIndexOverflow();
    L79:
        Iterator r214 = com.bytedance.android.anya.k0.c(((TopicPagerListData) r45).getItemDataList()).iterator();
        int r46 = 0;
    L81:
        if (r214.hasNext() == false) goto L105;
        Object r47 = r214.next();
        int r215 = r46 + 1;
        if (r46 >= 0) goto L85;
        CollectionsKt.throwIndexOverflow();
    L85:
        ItemListData r48 = (ItemListData) r47;
        if (r40 <= 0) goto L93;
        if (((vz1.e) com.bytedance.android.anya.h.b(r48.getItemData())).f() == true) goto L90;
    L97:
        boolean r49 = false;
    L98:
        if (r49 == false) goto L101;
        if (r17 == false) goto L101;
        boolean r50 = true;
    L102:
        if (r50 == false) goto L104;
        r20.invoke(r48, Integer.valueOf(r11), Integer.valueOf(r46), -1, Integer.valueOf(r212));
    L104:
        r46 = r215;
    L101:
        r50 = false;
        goto L102
    L90:
        if (((vz1.e) com.bytedance.android.anya.h.b(r48.getItemData())).d() != r40) goto L97;
    L96:
        r49 = true;
        goto L98
    L93:
        if (((vz1.e) com.bytedance.android.anya.h.b(r48.getItemData())).c().getId() != r35) goto L97;
        if (r35 <= 0) goto L97;
    L105:
        r212 = r213;
        goto L75
    L106:
        r11 = r21;
        goto L10
    L107:
        Unit r51 = Unit.INSTANCE;
    L233:
        com.bytedance.android.anya.internal.u r53 = r34.getPanelList();
        Iterator r54 = ((Iterable) r53.c()).iterator();
        boolean r55 = false;
        int r56 = 0;
        boolean r57 = false;
    L235:
        if (r54.hasNext() == false) goto L393;
        Object r58 = r54.next();
        int r59 = r56 + 1;
        if (r56 >= 0) goto L239;
        CollectionsKt.throwIndexOverflow();
    L239:
        MVIState r60 = (MVIState) r58;
        r0<PagerListData, Integer> r61 = ((PagerListData) r60).getTabType();
        r33.getClass();
        if (((Number) com.bytedance.android.anya.h.b(r61)).intValue() != r36) goto L242;
        boolean r63 = true;
    L243:
        if (r63 == false) goto L244;
        new com.bytedance.android.anya.k0.a();     // Catch: Throwable -> L388
        PagerListData r64 = (PagerListData) r60;     // Catch: Throwable -> L388
        com.bytedance.android.anya.internal.u r110 = r64.getItemDataList();     // Catch: Throwable -> L388
        com.bytedance.android.anya.internal.u r216 = r110;     // Catch: Throwable -> L388
        Iterator r217 = ((Iterable) r110.c()).iterator();     // Catch: Throwable -> L388
        int r111 = 0;
    L247:
        if (r217.hasNext() == false) goto L278;
        Object r218 = r217.next();     // Catch: Throwable -> L388
        int r219 = r111 + 1;     // Catch: Throwable -> L388
        if (r111 >= 0) goto L251;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L388
    L251:
        Iterator r220 = r54;
        MVIState r65 = (MVIState) r218;     // Catch: Throwable -> L388
        ItemListData r221 = (ItemListData) r65;     // Catch: Throwable -> L388
        if (r40 <= 0) goto L259;
        if (((vz1.e) r221.getItemData().c()).f() == true) goto L256;
    L265:
        boolean r0 = false;
    L266:
        if (r0 == false) goto L272;
        new com.bytedance.android.anya.k0.a();     // Catch: Throwable -> L273
        ItemListData r66 = (ItemListData) r65;     // Catch: Throwable -> L273
        r13.element = r56;     // Catch: Throwable -> L273
        r14.element = r111;     // Catch: Throwable -> L273
    L270:
        if ((!r65.modifiedProperties.isEmpty()) == false) goto L272;
        ((com.bytedance.android.anya.internal.t) r110.c()).d(r111);     // Catch: Throwable -> L388
    L273:
        th = move-exception;
        if ((!r65.modifiedProperties.isEmpty()) == false) goto L277;
        ((com.bytedance.android.anya.internal.t) r110.c()).d(r111);     // Catch: Throwable -> L388
    L277:
        throw th;     // Catch: Throwable -> L388
    L272:
        r111 = r219;
        r54 = r220;
        goto L247
    L256:
        if (((vz1.e) r221.getItemData().c()).d() != r40) goto L265;
    L264:
        r0 = true;
        goto L266
    L259:
        if (((vz1.e) r221.getItemData().c()).c().getId() != r35) goto L265;
        if (TextUtils.isEmpty(r39) == true) goto L264;
        if (Intrinsics.areEqual(r9, ((vz1.e) r221.getItemData().c()).e().a()) == false) goto L265;
    L278:
        Iterator r222 = r54;
        com.bytedance.android.anya.internal.u r67 = r64.getCounterDataList();     // Catch: Throwable -> L388
        com.bytedance.android.anya.internal.u r68 = r67;     // Catch: Throwable -> L388
        Iterator r69 = ((Iterable) r67.c()).iterator();     // Catch: Throwable -> L388
        int r112 = 0;
    L280:
        if (r69.hasNext() == false) goto L327;
        Object r113 = r69.next();     // Catch: Throwable -> L388
        int r223 = r112 + 1;     // Catch: Throwable -> L388
        if (r112 >= 0) goto L284;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L388
    L284:
        int r224 = r59;
        MVIState r70 = (MVIState) r113;     // Catch: Throwable -> L388
        new com.bytedance.android.anya.k0.a();     // Catch: Throwable -> L322
        com.bytedance.android.anya.internal.u r114 = ((CounterData) r70).getItemDataList();     // Catch: Throwable -> L322
        com.bytedance.android.anya.internal.u r225 = r114;     // Catch: Throwable -> L322
        Iterator r226 = ((Iterable) r114.c()).iterator();     // Catch: Throwable -> L322
        int r115 = 0;
    L287:
        if (r226.hasNext() == false) goto L317;
        Object r227 = r226.next();     // Catch: Throwable -> L322
        int r228 = r115 + 1;     // Catch: Throwable -> L322
        if (r115 >= 0) goto L291;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L322
    L291:
        boolean r229 = r57;
        MVIState r71 = (MVIState) r227;     // Catch: Throwable -> L322
        ItemListData r230 = (ItemListData) r71;     // Catch: Throwable -> L322
        if (((vz1.e) r230.getItemData().c()).c().getId() == r35) goto L294;
        Iterator r231 = r69;
    L301:
        boolean r73 = false;
    L302:
        if (r73 == true) goto L411;
        r115 = r228;
        r57 = r229;
        r69 = r231;
        goto L287
    L411:
        new com.bytedance.android.anya.k0.a();     // Catch: Throwable -> L312
        ItemListData r74 = (ItemListData) r71;     // Catch: Throwable -> L312
        r13.element = r56;     // Catch: Throwable -> L312
        r15.element = r112;     // Catch: Throwable -> L312
        r14.element = r115;     // Catch: Throwable -> L312
        r10.element = true;     // Catch: Throwable -> L312
    L306:
        if ((!r71.modifiedProperties.isEmpty()) == false) goto L309;
        ((com.bytedance.android.anya.internal.t) r114.c()).d(r115);     // Catch: Throwable -> L322
    L309:
        if ((!r70.modifiedProperties.isEmpty()) == false) goto L311;
        ((com.bytedance.android.anya.internal.t) r67.c()).d(r112);     // Catch: Throwable -> L388
    L311:
        Ref.IntRef r75 = r8;
        r57 = r229;
        r55 = true;
    L385:
        if ((!r60.modifiedProperties.isEmpty()) == false) goto L387;
        ((com.bytedance.android.anya.internal.t) r53.c()).d(r56);
    L387:
        r9 = r39;
        r8 = r75;
        r56 = r224;
        r54 = r222;
    L312:
        th = move-exception;
        if ((!r71.modifiedProperties.isEmpty()) == false) goto L316;
        ((com.bytedance.android.anya.internal.t) r114.c()).d(r115);     // Catch: Throwable -> L322
    L316:
        throw th;     // Catch: Throwable -> L322
    L294:
        if (TextUtils.isEmpty(r39) == true) goto L298;
        r231 = r69;
        if (Intrinsics.areEqual(r9, ((vz1.e) r230.getItemData().c()).e().a()) == false) goto L301;
    L299:
        r73 = true;
        goto L302
    L298:
        r231 = r69;
        goto L299
    L317:
        Iterator r232 = r69;
        boolean r233 = r57;
        if ((!r70.modifiedProperties.isEmpty()) == false) goto L321;
        ((com.bytedance.android.anya.internal.t) r67.c()).d(r112);     // Catch: Throwable -> L388
    L321:
        r112 = r223;
        r59 = r224;
        r57 = r233;
        r69 = r232;
    L322:
        th = move-exception;
        if ((!r70.modifiedProperties.isEmpty()) == false) goto L326;
        ((com.bytedance.android.anya.internal.t) r67.c()).d(r112);     // Catch: Throwable -> L388
    L326:
        throw th;     // Catch: Throwable -> L388
    L327:
        r224 = r59;
        boolean r234 = r57;
        com.bytedance.android.anya.internal.u r76 = r64.getTopicPagerListData();     // Catch: Throwable -> L388
        com.bytedance.android.anya.internal.u r77 = r76;     // Catch: Throwable -> L388
        Iterator r78 = ((Iterable) r76.c()).iterator();     // Catch: Throwable -> L388
        int r79 = 0;
    L329:
        if (r78.hasNext() == false) goto L383;
        Object r80 = r78.next();     // Catch: Throwable -> L388
        int r81 = r79 + 1;     // Catch: Throwable -> L388
        if (r79 >= 0) goto L333;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L388
    L333:
        MVIState r83 = (MVIState) r80;     // Catch: Throwable -> L388
        new com.bytedance.android.anya.k0.a();     // Catch: Throwable -> L378
        com.bytedance.android.anya.internal.u r116 = ((TopicPagerListData) r83).getItemDataList();     // Catch: Throwable -> L378
        com.bytedance.android.anya.internal.u r117 = r116;     // Catch: Throwable -> L378
        Iterator r118 = ((Iterable) r116.c()).iterator();     // Catch: Throwable -> L378
        int r84 = 0;
    L336:
        if (r118.hasNext() == false) goto L373;
        Object r235 = r118.next();     // Catch: Throwable -> L378
        int r236 = r84 + 1;     // Catch: Throwable -> L378
        if (r84 >= 0) goto L340;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L378
    L340:
        Iterator r237 = r118;
        MVIState r119 = (MVIState) r235;     // Catch: Throwable -> L378
        ItemListData r238 = (ItemListData) r119;     // Catch: Throwable -> L378
        if (r40 <= 0) goto L349;
        if (((vz1.e) r238.getItemData().c()).f() == true) goto L345;
    L347:
        Iterator r239 = r78;
    L357:
        boolean r85 = false;
    L358:
        if (r85 == true) goto L407;
        r84 = r236;
        r118 = r237;
        r78 = r239;
        goto L336
    L407:
        new com.bytedance.android.anya.k0.a();     // Catch: Throwable -> L368
        ItemListData r86 = (ItemListData) r119;     // Catch: Throwable -> L368
        r13.element = r56;     // Catch: Throwable -> L368
        r75 = r8;
        r75.element = r79;     // Catch: Throwable -> L368
        r14.element = r84;     // Catch: Throwable -> L368
        r10.element = true;     // Catch: Throwable -> L368
    L362:
        if ((!r119.modifiedProperties.isEmpty()) == false) goto L365;
        ((com.bytedance.android.anya.internal.t) r116.c()).d(r84);     // Catch: Throwable -> L378
    L365:
        if ((!r83.modifiedProperties.isEmpty()) == false) goto L367;
        ((com.bytedance.android.anya.internal.t) r76.c()).d(r79);     // Catch: Throwable -> L388
    L367:
        r57 = true;
    L368:
        th = move-exception;
        if ((!r119.modifiedProperties.isEmpty()) == false) goto L372;
        ((com.bytedance.android.anya.internal.t) r116.c()).d(r84);     // Catch: Throwable -> L378
    L372:
        throw th;     // Catch: Throwable -> L378
    L345:
        if (((vz1.e) r238.getItemData().c()).d() != r40) goto L347;
    L355:
        r239 = r78;
    L356:
        r85 = true;
        goto L358
    L349:
        if (((vz1.e) r238.getItemData().c()).c().getId() != r35) goto L347;
        if (TextUtils.isEmpty(r39) == true) goto L355;
        r239 = r78;
        if (Intrinsics.areEqual(r9, ((vz1.e) r238.getItemData().c()).e().a()) == false) goto L357;
    L373:
        Iterator r240 = r78;
        Ref.IntRef r87 = r8;
        if ((!r83.modifiedProperties.isEmpty()) == false) goto L377;
        ((com.bytedance.android.anya.internal.t) r76.c()).d(r79);     // Catch: Throwable -> L388
    L377:
        r9 = r39;
        r8 = r87;
        r79 = r81;
        r78 = r240;
    L378:
        th = move-exception;
        if ((!r83.modifiedProperties.isEmpty()) == false) goto L382;
        ((com.bytedance.android.anya.internal.t) r76.c()).d(r79);     // Catch: Throwable -> L388
    L382:
        throw th;     // Catch: Throwable -> L388
    L383:
        r75 = r8;
        r57 = r234;
    L388:
        th = move-exception;
        if ((!r60.modifiedProperties.isEmpty()) == false) goto L392;
        ((com.bytedance.android.anya.internal.t) r53.c()).d(r56);
    L392:
        throw th;
    L244:
        r56 = r59;
        goto L235
    L242:
        r63 = false;
        goto L243
    L393:
        Ref.IntRef r88 = r8;
        boolean r241 = r57;
        if (r55 == true) goto L396;
        r15.element = -1;
    L396:
        if (r241 == true) goto L399;
        r88.element = -1;
    L399:
        if (r10.element == false) goto L403;
        this.h.invoke(r33, r34, Integer.valueOf(r13.element), Integer.valueOf(r14.element), Integer.valueOf(r15.element), Integer.valueOf(r88.element), r38 + "_searchPropPanel", Boolean.FALSE);
    L403:
        return r10.element;
    L108:
        Function5<ItemListData, Integer, Integer, Integer, Integer, Boolean> r242 = new GiftDefaultSelectHelper$searchPropPanel$$inlined$modifyListDataWithRuleIndexedOpt$1(r33, r34, r10, r13, r14, r15, r8);
        com.bytedance.android.anya.k0 r89 = r33.b;
        t0<GiftVerticalState, PagerListData> r90 = r34.getPanelList();
        r89.getClass();
        Iterator r91 = com.bytedance.android.anya.k0.c(r90).iterator();
        boolean r93 = false;
        int r94 = 0;
    L110:
        if (r91.hasNext() == false) goto L232;
        Object r95 = r91.next();
        int r243 = r94 + 1;
        if (r94 >= 0) goto L114;
        CollectionsKt.throwIndexOverflow();
    L114:
        PagerListData r244 = (PagerListData) r95;
        if (r93 == true) goto L231;
        Iterator r245 = com.bytedance.android.anya.k0.c(r244.getItemDataList()).iterator();
        boolean r246 = r93;
        int r96 = 0;
    L119:
        if (r245.hasNext() == false) goto L148;
        Object r97 = r245.next();
        int r247 = r96 + 1;
        if (r96 >= 0) goto L123;
        CollectionsKt.throwIndexOverflow();
    L123:
        ItemListData r98 = (ItemListData) r97;
        if (r246 == true) goto L147;
        if (r40 <= 0) goto L134;
        if (((vz1.e) com.bytedance.android.anya.h.b(r98.getItemData())).f() == true) goto L131;
    L138:
        boolean r99 = false;
    L139:
        if (r99 == false) goto L142;
        if (r17 == false) goto L142;
        boolean r100 = true;
    L143:
        if (r100 == false) goto L147;
        if (((Boolean) r242.invoke(r98, Integer.valueOf(r94), Integer.valueOf(r96), -1, -1)).booleanValue() == false) goto L147;
        r246 = true;
    L142:
        r100 = false;
        goto L143
    L131:
        if (((vz1.e) com.bytedance.android.anya.h.b(r98.getItemData())).d() != r40) goto L138;
    L137:
        r99 = true;
        goto L139
    L134:
        if (((vz1.e) com.bytedance.android.anya.h.b(r98.getItemData())).c().getId() != r35) goto L138;
        if (r35 <= 0) goto L138;
    L147:
        r96 = r247;
        goto L119
    L148:
        Iterator r248 = com.bytedance.android.anya.k0.c(r244.getCounterDataList()).iterator();
        int r249 = 0;
    L150:
        if (r248.hasNext() == false) goto L189;
        Object r101 = r248.next();
        int r250 = r249 + 1;
        if (r249 >= 0) goto L154;
        CollectionsKt.throwIndexOverflow();
    L154:
        CounterData r102 = (CounterData) r101;
        if (r246 == true) goto L188;
        Iterator r251 = com.bytedance.android.anya.k0.c(r102.getItemDataList()).iterator();
        int r103 = 0;
    L159:
        if (r251.hasNext() == false) goto L188;
        Object r104 = r251.next();
        int r252 = r103 + 1;
        if (r103 >= 0) goto L163;
        CollectionsKt.throwIndexOverflow();
    L163:
        ItemListData r105 = (ItemListData) r104;
        if (r246 == true) goto L187;
        if (r40 <= 0) goto L174;
        if (((vz1.e) com.bytedance.android.anya.h.b(r105.getItemData())).f() == true) goto L171;
    L178:
        boolean r106 = false;
    L179:
        if (r106 == false) goto L182;
        if (r17 == false) goto L182;
        boolean r107 = true;
    L183:
        if (r107 == false) goto L187;
        if (((Boolean) r242.invoke(r105, Integer.valueOf(r94), Integer.valueOf(r103), Integer.valueOf(r249), -1)).booleanValue() == false) goto L187;
        r246 = true;
    L182:
        r107 = false;
        goto L183
    L171:
        if (((vz1.e) com.bytedance.android.anya.h.b(r105.getItemData())).d() != r40) goto L178;
    L177:
        r106 = true;
        goto L179
    L174:
        if (((vz1.e) com.bytedance.android.anya.h.b(r105.getItemData())).c().getId() != r35) goto L178;
        if (r35 <= 0) goto L178;
    L187:
        r103 = r252;
    L188:
        r249 = r250;
        goto L150
    L189:
        Iterator r253 = com.bytedance.android.anya.k0.c(r244.getTopicPagerListData()).iterator();
        r93 = r246;
        int r254 = 0;
    L191:
        if (r253.hasNext() == false) goto L231;
        Object r108 = r253.next();
        int r255 = r254 + 1;
        if (r254 >= 0) goto L195;
        CollectionsKt.throwIndexOverflow();
    L195:
        TopicPagerListData r109 = (TopicPagerListData) r108;
        if (r93 == true) goto L230;
        Iterator r256 = com.bytedance.android.anya.k0.c(r109.getItemDataList()).iterator();
        boolean r257 = r93;
        int r120 = 0;
    L200:
        if (r256.hasNext() == false) goto L229;
        Object r121 = r256.next();
        int r258 = r120 + 1;
        if (r120 >= 0) goto L204;
        CollectionsKt.throwIndexOverflow();
    L204:
        ItemListData r122 = (ItemListData) r121;
        if (r257 == true) goto L228;
        if (r40 <= 0) goto L215;
        if (((vz1.e) com.bytedance.android.anya.h.b(r122.getItemData())).f() == true) goto L212;
    L219:
        boolean r123 = false;
    L220:
        if (r123 == false) goto L223;
        if (r17 == false) goto L223;
        boolean r124 = true;
    L224:
        if (r124 == false) goto L228;
        if (((Boolean) r242.invoke(r122, Integer.valueOf(r94), Integer.valueOf(r120), -1, Integer.valueOf(r254))).booleanValue() == false) goto L228;
        r257 = true;
    L223:
        r124 = false;
        goto L224
    L212:
        if (((vz1.e) com.bytedance.android.anya.h.b(r122.getItemData())).d() != r40) goto L219;
    L218:
        r123 = true;
        goto L220
    L215:
        if (((vz1.e) com.bytedance.android.anya.h.b(r122.getItemData())).c().getId() != r35) goto L219;
        if (r35 <= 0) goto L219;
    L228:
        r120 = r258;
        goto L200
    L229:
        r93 = r257;
    L230:
        r254 = r255;
    L231:
        r94 = r243;
        goto L110
    L232:
        Unit r125 = Unit.INSTANCE;
        goto L233
    L5:
        r17 = true;
        goto L7
    }

    public static /* synthetic */ boolean f(h r13, com.bytedance.android.anya.l0 r14, GiftVerticalState r15, long r16, int r18, int r19, String r20, long r21, int r23) {
        if ((r23 & 16) == 0) goto L5;
        boolean r8 = true;
    L7:
        if ((r23 & 32) == 0) goto L9;
        String r9 = BuildConfig.FLAVOR;
    L11:
        if ((r23 & 64) == 0) goto L13;
        String r10 = BuildConfig.FLAVOR;
    L15:
        if ((r23 & 128) == 0) goto L17;
        long r11 = -1;
    L19:
        return r13.e(r14, r15, r16, r19, r8, r9, r10, r11);
    L17:
        r11 = r21;
        goto L19
    L13:
        r10 = null;
        goto L15
    L9:
        r9 = r20;
        goto L11
    L5:
        r8 = false;
        goto L7
    }
}
