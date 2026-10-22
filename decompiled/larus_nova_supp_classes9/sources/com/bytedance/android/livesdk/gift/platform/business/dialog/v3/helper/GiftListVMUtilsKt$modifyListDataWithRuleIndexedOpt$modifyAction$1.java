package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.s0;
import com.bytedance.android.anya.t0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.CounterData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PagerListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.TopicPagerListData;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "itemListData", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ItemListData;", "pagerIndex", BuildConfig.FLAVOR, "index", "counterPos", "topicPos", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 128)
public final class GiftListVMUtilsKt$modifyListDataWithRuleIndexedOpt$modifyAction$1 extends Lambda implements Function5<ItemListData, Integer, Integer, Integer, Integer, Boolean> {
    final /* synthetic */ Function6 $action;
    final /* synthetic */ GiftVerticalState $state;
    final /* synthetic */ com.bytedance.android.anya.l0 $this_modifyListDataWithRuleIndexedOpt;

    public GiftListVMUtilsKt$modifyListDataWithRuleIndexedOpt$modifyAction$1(com.bytedance.android.anya.l0 r1, GiftVerticalState r2, Function6 r3) {
        this.$this_modifyListDataWithRuleIndexedOpt = r1;
        this.$state = r2;
        this.$action = r3;
        super(5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r7, Object r8, Object r9, Object r10, Object r11) {
        return Boolean.valueOf(invoke((ItemListData) r7, ((Number) r8).intValue(), ((Number) r9).intValue(), ((Number) r10).intValue(), ((Number) r11).intValue()));
    }

    public final boolean invoke(ItemListData r23, int r24, int r25, int r26, int r27) {
        Intrinsics.checkNotNullParameter(r23, "itemListData");
        com.bytedance.android.anya.l0 r0 = this.$this_modifyListDataWithRuleIndexedOpt;
        t0<GiftVerticalState, PagerListData> r6 = this.$state.getPanelList();
        r0.getClass();
        if (com.bytedance.android.anya.h.a(r6) <= r24) goto L78;
        com.bytedance.android.anya.internal.u r7 = this.$state.getPanelList();
        MVIState r8 = (MVIState) ((s0) r7.c()).get(r24);
        new com.bytedance.android.anya.k0.a();     // Catch: Throwable -> L72
        PagerListData r1 = (PagerListData) r8;     // Catch: Throwable -> L72
        if (((s0) r1.getItemDataList().c()).size() <= r25) goto L18;
        com.bytedance.android.anya.internal.u r10 = r1.getItemDataList();     // Catch: Throwable -> L72
        com.bytedance.android.anya.internal.u r11 = r10;     // Catch: Throwable -> L72
        MVIState r13 = (MVIState) ((s0) r10.c()).get(r25);     // Catch: Throwable -> L72
        com.bytedance.android.anya.l0 r14 = new com.bytedance.android.anya.l0(0);     // Catch: Throwable -> L13
        r14.a = r13;     // Catch: Throwable -> L13
        this.$action.invoke(r14, (ItemListData) r13, Integer.valueOf(r24), Integer.valueOf(r25), Integer.valueOf(r26), Integer.valueOf(r27));     // Catch: Throwable -> L13
    L10:
        if ((!r13.modifiedProperties.isEmpty()) == false) goto L12;
        ((com.bytedance.android.anya.internal.t) r10.c()).d(r25);     // Catch: Throwable -> L72
    L12:
        boolean r15 = true;
    L20:
        if (((s0) r1.getCounterDataList().c()).size() <= r26) goto L44;
        if (r26 == (-1)) goto L44;
        com.bytedance.android.anya.internal.u r16 = r1.getCounterDataList();     // Catch: Throwable -> L72
        com.bytedance.android.anya.internal.u r17 = r16;     // Catch: Throwable -> L72
        MVIState r18 = (MVIState) ((s0) r16.c()).get(r26);     // Catch: Throwable -> L72
        new com.bytedance.android.anya.k0.a();     // Catch: Throwable -> L39
        CounterData r19 = (CounterData) r18;     // Catch: Throwable -> L39
        if (((s0) r19.getItemDataList().c()).size() <= r25) goto L37;
        com.bytedance.android.anya.internal.u r110 = r19.getItemDataList();     // Catch: Throwable -> L39
        com.bytedance.android.anya.internal.u r111 = r110;     // Catch: Throwable -> L39
        MVIState r112 = (MVIState) ((s0) r110.c()).get(r25);     // Catch: Throwable -> L39
        com.bytedance.android.anya.l0 r113 = new com.bytedance.android.anya.l0(0);     // Catch: Throwable -> L31
        r113.a = r112;     // Catch: Throwable -> L31
        this.$action.invoke(r113, (ItemListData) r112, Integer.valueOf(r24), Integer.valueOf(r25), Integer.valueOf(r26), Integer.valueOf(r27));     // Catch: Throwable -> L31
    L28:
        if ((!r112.modifiedProperties.isEmpty()) == false) goto L30;
        ((com.bytedance.android.anya.internal.t) r110.c()).d(r25);     // Catch: Throwable -> L39
    L30:
        r15 = true;
    L31:
        th = move-exception;
        if ((!r112.modifiedProperties.isEmpty()) == false) goto L35;
        ((com.bytedance.android.anya.internal.t) r110.c()).d(r25);     // Catch: Throwable -> L39
    L35:
        throw th;     // Catch: Throwable -> L39
    L37:
        if ((!r18.modifiedProperties.isEmpty()) == false) goto L44;
        ((com.bytedance.android.anya.internal.t) r16.c()).d(r26);     // Catch: Throwable -> L72
    L39:
        th = move-exception;
        if ((!r18.modifiedProperties.isEmpty()) == false) goto L43;
        ((com.bytedance.android.anya.internal.t) r16.c()).d(r26);     // Catch: Throwable -> L72
    L43:
        throw th;     // Catch: Throwable -> L72
    L44:
        if (r27 != (-1)) goto L46;
    L69:
        boolean r9 = r15;
        if ((!r8.modifiedProperties.isEmpty()) == false) goto L88;
        ((com.bytedance.android.anya.internal.t) r7.c()).d(r24);
        return r9;
    L88:
        return r9;
    L46:
        if (((s0) r1.getTopicPagerListData().c()).size() <= r27) goto L69;
        com.bytedance.android.anya.internal.u r20 = r1.getTopicPagerListData();     // Catch: Throwable -> L72
        com.bytedance.android.anya.internal.u r2 = r20;     // Catch: Throwable -> L72
        MVIState r114 = (MVIState) ((s0) r20.c()).get(r27);     // Catch: Throwable -> L72
        new com.bytedance.android.anya.k0.a();     // Catch: Throwable -> L64
        TopicPagerListData r3 = (TopicPagerListData) r114;     // Catch: Throwable -> L64
        if (((s0) r3.getItemDataList().c()).size() <= r25) goto L62;
        com.bytedance.android.anya.internal.u r115 = r3.getItemDataList();     // Catch: Throwable -> L64
        com.bytedance.android.anya.internal.u r4 = r115;     // Catch: Throwable -> L64
        MVIState r116 = (MVIState) ((s0) r115.c()).get(r25);     // Catch: Throwable -> L64
        com.bytedance.android.anya.l0 r117 = new com.bytedance.android.anya.l0(0);     // Catch: Throwable -> L56
        r117.a = r116;     // Catch: Throwable -> L56
        this.$action.invoke(r117, (ItemListData) r116, Integer.valueOf(r24), Integer.valueOf(r25), Integer.valueOf(r26), Integer.valueOf(r27));     // Catch: Throwable -> L56
    L53:
        if ((!r116.modifiedProperties.isEmpty()) == false) goto L55;
        ((com.bytedance.android.anya.internal.t) r115.c()).d(r25);     // Catch: Throwable -> L64
    L55:
        r15 = true;
    L56:
        th = move-exception;
        if ((!r116.modifiedProperties.isEmpty()) == false) goto L60;
        ((com.bytedance.android.anya.internal.t) r115.c()).d(r25);     // Catch: Throwable -> L64
    L60:
        throw th;     // Catch: Throwable -> L64
    L62:
        if ((!r114.modifiedProperties.isEmpty()) == false) goto L69;
        ((com.bytedance.android.anya.internal.t) r20.c()).d(r27);     // Catch: Throwable -> L72
    L64:
        th = move-exception;
        if ((!r114.modifiedProperties.isEmpty()) == false) goto L68;
        ((com.bytedance.android.anya.internal.t) r20.c()).d(r27);     // Catch: Throwable -> L72
    L68:
        throw th;     // Catch: Throwable -> L72
    L13:
        th = move-exception;
        if ((!r13.modifiedProperties.isEmpty()) == false) goto L17;
        ((com.bytedance.android.anya.internal.t) r10.c()).d(r25);     // Catch: Throwable -> L72
    L17:
        throw th;     // Catch: Throwable -> L72
    L18:
        r15 = false;
    L72:
        th = move-exception;
        if ((!r8.modifiedProperties.isEmpty()) == false) goto L76;
        ((com.bytedance.android.anya.internal.t) r7.c()).d(r24);
    L76:
        throw th;
    L78:
        return false;
    }
}
