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
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "itemListData", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ItemListData;", "pagerIndex", BuildConfig.FLAVOR, "index", "counterPos", "topicPos", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 128)
public final class GiftListVMUtilsKt$modifyListDataWithRuleIndexed$modifyAction$1 extends Lambda implements Function5<ItemListData, Integer, Integer, Integer, Integer, Unit> {
    final /* synthetic */ Function6 $action;
    final /* synthetic */ GiftVerticalState $state;
    final /* synthetic */ com.bytedance.android.anya.l0 $this_modifyListDataWithRuleIndexed;

    public GiftListVMUtilsKt$modifyListDataWithRuleIndexed$modifyAction$1(com.bytedance.android.anya.l0 r1, GiftVerticalState r2, Function6 r3) {
        this.$this_modifyListDataWithRuleIndexed = r1;
        this.$state = r2;
        this.$action = r3;
        super(5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r7, Object r8, Object r9, Object r10, Object r11) {
        invoke((ItemListData) r7, ((Number) r8).intValue(), ((Number) r9).intValue(), ((Number) r10).intValue(), ((Number) r11).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ItemListData r23, int r24, int r25, int r26, int r27) {
        Intrinsics.checkNotNullParameter(r23, "itemListData");
        com.bytedance.android.anya.l0 r0 = this.$this_modifyListDataWithRuleIndexed;
        t0<GiftVerticalState, PagerListData> r6 = this.$state.getPanelList();
        r0.getClass();
        if (com.bytedance.android.anya.h.a(r6) <= r24) goto L73;
        com.bytedance.android.anya.internal.u r7 = this.$state.getPanelList();
        MVIState r8 = (MVIState) ((s0) r7.c()).get(r24);
        new com.bytedance.android.anya.k0.a();     // Catch: Throwable -> L68
        PagerListData r1 = (PagerListData) r8;     // Catch: Throwable -> L68
        if (((s0) r1.getItemDataList().c()).size() <= r25) goto L18;
        com.bytedance.android.anya.internal.u r9 = r1.getItemDataList();     // Catch: Throwable -> L68
        com.bytedance.android.anya.internal.u r10 = r9;     // Catch: Throwable -> L68
        MVIState r11 = (MVIState) ((s0) r9.c()).get(r25);     // Catch: Throwable -> L68
        com.bytedance.android.anya.l0 r13 = new com.bytedance.android.anya.l0(0);     // Catch: Throwable -> L12
        r13.a = r11;     // Catch: Throwable -> L12
        this.$action.invoke(r13, (ItemListData) r11, Integer.valueOf(r24), Integer.valueOf(r25), Integer.valueOf(r26), Integer.valueOf(r27));     // Catch: Throwable -> L12
    L10:
        if ((!r11.modifiedProperties.isEmpty()) == false) goto L18;
        ((com.bytedance.android.anya.internal.t) r9.c()).d(r25);     // Catch: Throwable -> L68
    L12:
        th = move-exception;
        if ((!r11.modifiedProperties.isEmpty()) == false) goto L16;
        ((com.bytedance.android.anya.internal.t) r9.c()).d(r25);     // Catch: Throwable -> L68
    L16:
        throw th;     // Catch: Throwable -> L68
    L18:
        if (((s0) r1.getCounterDataList().c()).size() <= r26) goto L41;
        if (r26 == (-1)) goto L41;
        com.bytedance.android.anya.internal.u r14 = r1.getCounterDataList();     // Catch: Throwable -> L68
        com.bytedance.android.anya.internal.u r15 = r14;     // Catch: Throwable -> L68
        MVIState r16 = (MVIState) ((s0) r14.c()).get(r26);     // Catch: Throwable -> L68
        new com.bytedance.android.anya.k0.a();     // Catch: Throwable -> L36
        CounterData r17 = (CounterData) r16;     // Catch: Throwable -> L36
        if (((s0) r17.getItemDataList().c()).size() <= r25) goto L34;
        com.bytedance.android.anya.internal.u r18 = r17.getItemDataList();     // Catch: Throwable -> L36
        com.bytedance.android.anya.internal.u r19 = r18;     // Catch: Throwable -> L36
        MVIState r110 = (MVIState) ((s0) r18.c()).get(r25);     // Catch: Throwable -> L36
        com.bytedance.android.anya.l0 r111 = new com.bytedance.android.anya.l0(0);     // Catch: Throwable -> L28
        r111.a = r110;     // Catch: Throwable -> L28
        this.$action.invoke(r111, (ItemListData) r110, Integer.valueOf(r24), Integer.valueOf(r25), Integer.valueOf(r26), Integer.valueOf(r27));     // Catch: Throwable -> L28
    L26:
        if ((!r110.modifiedProperties.isEmpty()) == false) goto L34;
        ((com.bytedance.android.anya.internal.t) r18.c()).d(r25);     // Catch: Throwable -> L36
    L28:
        th = move-exception;
        if ((!r110.modifiedProperties.isEmpty()) == false) goto L32;
        ((com.bytedance.android.anya.internal.t) r18.c()).d(r25);     // Catch: Throwable -> L36
    L32:
        throw th;     // Catch: Throwable -> L36
    L34:
        if ((!r16.modifiedProperties.isEmpty()) == false) goto L41;
        ((com.bytedance.android.anya.internal.t) r14.c()).d(r26);     // Catch: Throwable -> L68
    L36:
        th = move-exception;
        if ((!r16.modifiedProperties.isEmpty()) == false) goto L40;
        ((com.bytedance.android.anya.internal.t) r14.c()).d(r26);     // Catch: Throwable -> L68
    L40:
        throw th;     // Catch: Throwable -> L68
    L41:
        if (r27 == (-1)) goto L66;
        if (((s0) r1.getTopicPagerListData().c()).size() <= r27) goto L66;
        com.bytedance.android.anya.internal.u r20 = r1.getTopicPagerListData();     // Catch: Throwable -> L68
        com.bytedance.android.anya.internal.u r2 = r20;     // Catch: Throwable -> L68
        MVIState r112 = (MVIState) ((s0) r20.c()).get(r27);     // Catch: Throwable -> L68
        new com.bytedance.android.anya.k0.a();     // Catch: Throwable -> L60
        TopicPagerListData r3 = (TopicPagerListData) r112;     // Catch: Throwable -> L60
        if (((s0) r3.getItemDataList().c()).size() <= r25) goto L58;
        com.bytedance.android.anya.internal.u r113 = r3.getItemDataList();     // Catch: Throwable -> L60
        com.bytedance.android.anya.internal.u r4 = r113;     // Catch: Throwable -> L60
        MVIState r114 = (MVIState) ((s0) r113.c()).get(r25);     // Catch: Throwable -> L60
        com.bytedance.android.anya.l0 r115 = new com.bytedance.android.anya.l0(0);     // Catch: Throwable -> L52
        r115.a = r114;     // Catch: Throwable -> L52
        this.$action.invoke(r115, (ItemListData) r114, Integer.valueOf(r24), Integer.valueOf(r25), Integer.valueOf(r26), Integer.valueOf(r27));     // Catch: Throwable -> L52
    L50:
        if ((!r114.modifiedProperties.isEmpty()) == false) goto L58;
        ((com.bytedance.android.anya.internal.t) r113.c()).d(r25);     // Catch: Throwable -> L60
    L52:
        th = move-exception;
        if ((!r114.modifiedProperties.isEmpty()) == false) goto L56;
        ((com.bytedance.android.anya.internal.t) r113.c()).d(r25);     // Catch: Throwable -> L60
    L56:
        throw th;     // Catch: Throwable -> L60
    L58:
        if ((!r112.modifiedProperties.isEmpty()) == false) goto L66;
        ((com.bytedance.android.anya.internal.t) r20.c()).d(r27);     // Catch: Throwable -> L68
    L60:
        th = move-exception;
        if ((!r112.modifiedProperties.isEmpty()) == false) goto L64;
        ((com.bytedance.android.anya.internal.t) r20.c()).d(r27);     // Catch: Throwable -> L68
    L64:
        throw th;     // Catch: Throwable -> L68
    L66:
        if ((!r8.modifiedProperties.isEmpty()) == false) goto L83;
        ((com.bytedance.android.anya.internal.t) r7.c()).d(r24);
        return;
    L83:
        return;
    L68:
        th = move-exception;
        if ((!r8.modifiedProperties.isEmpty()) == false) goto L72;
        ((com.bytedance.android.anya.internal.t) r7.c()).d(r24);
    L72:
        throw th;
    }
}
