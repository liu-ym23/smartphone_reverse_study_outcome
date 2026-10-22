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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "itemListData", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ItemListData;", "pagerIndex", BuildConfig.FLAVOR, "index", "counterPosition", "topicPagerPosition", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 128)
public final class GiftListVMUtilsKt$modifyListDataWithRule$modifyAction$1 extends Lambda implements Function5<ItemListData, Integer, Integer, Integer, Integer, Unit> {
    final /* synthetic */ Function2 $action;
    final /* synthetic */ GiftVerticalState $state;
    final /* synthetic */ com.bytedance.android.anya.l0 $this_modifyListDataWithRule;

    public GiftListVMUtilsKt$modifyListDataWithRule$modifyAction$1(com.bytedance.android.anya.l0 r1, GiftVerticalState r2, Function2 r3) {
        this.$this_modifyListDataWithRule = r1;
        this.$state = r2;
        this.$action = r3;
        super(5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r7, Object r8, Object r9, Object r10, Object r11) {
        invoke((ItemListData) r7, ((Number) r8).intValue(), ((Number) r9).intValue(), ((Number) r10).intValue(), ((Number) r11).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ItemListData r8, int r9, int r10, int r11, int r13) {
        Intrinsics.checkNotNullParameter(r8, "itemListData");
        com.bytedance.android.anya.l0 r14 = this.$this_modifyListDataWithRule;
        t0<GiftVerticalState, PagerListData> r0 = this.$state.getPanelList();
        r14.getClass();
        if (com.bytedance.android.anya.h.a(r0) <= r9) goto L74;
        com.bytedance.android.anya.internal.u r15 = this.$state.getPanelList();
        MVIState r1 = (MVIState) ((s0) r15.c()).get(r9);
        new com.bytedance.android.anya.k0.a();     // Catch: Throwable -> L69
        PagerListData r2 = (PagerListData) r1;     // Catch: Throwable -> L69
        if (r11 != (-1)) goto L8;
        if (r13 == (-1)) goto L55;
        if (((s0) r2.getTopicPagerListData().c()).size() <= r13) goto L67;
        com.bytedance.android.anya.internal.u r16 = r2.getTopicPagerListData();     // Catch: Throwable -> L69
        com.bytedance.android.anya.internal.u r3 = r16;     // Catch: Throwable -> L69
        MVIState r4 = (MVIState) ((s0) r16.c()).get(r13);     // Catch: Throwable -> L69
        new com.bytedance.android.anya.k0.a();     // Catch: Throwable -> L49
        TopicPagerListData r5 = (TopicPagerListData) r4;     // Catch: Throwable -> L49
        if (((s0) r5.getItemDataList().c()).size() <= r10) goto L47;
        com.bytedance.android.anya.internal.u r6 = r5.getItemDataList();     // Catch: Throwable -> L49
        com.bytedance.android.anya.internal.u r7 = r6;     // Catch: Throwable -> L49
        MVIState r17 = (MVIState) ((s0) r6.c()).get(r10);     // Catch: Throwable -> L49
        com.bytedance.android.anya.l0 r18 = new com.bytedance.android.anya.l0(0);     // Catch: Throwable -> L41
        r18.a = r17;     // Catch: Throwable -> L41
        this.$action.invoke(r18, (ItemListData) r17);     // Catch: Throwable -> L41
    L39:
        if ((!r17.modifiedProperties.isEmpty()) == false) goto L47;
        ((com.bytedance.android.anya.internal.t) r6.c()).d(r10);     // Catch: Throwable -> L49
    L41:
        th = move-exception;
        if ((!r17.modifiedProperties.isEmpty()) == false) goto L45;
        ((com.bytedance.android.anya.internal.t) r6.c()).d(r10);     // Catch: Throwable -> L49
    L45:
        throw th;     // Catch: Throwable -> L49
    L47:
        if ((!r4.modifiedProperties.isEmpty()) == false) goto L67;
        ((com.bytedance.android.anya.internal.t) r16.c()).d(r13);     // Catch: Throwable -> L69
    L49:
        th = move-exception;
        if ((!r4.modifiedProperties.isEmpty()) == false) goto L53;
        ((com.bytedance.android.anya.internal.t) r16.c()).d(r13);     // Catch: Throwable -> L69
    L53:
        throw th;     // Catch: Throwable -> L69
    L67:
        if ((!r1.modifiedProperties.isEmpty()) == false) goto L84;
        ((com.bytedance.android.anya.internal.t) r15.c()).d(r9);
        return;
    L84:
        return;
    L55:
        if (((s0) r2.getItemDataList().c()).size() <= r10) goto L67;
        com.bytedance.android.anya.internal.u r19 = r2.getItemDataList();     // Catch: Throwable -> L69
        com.bytedance.android.anya.internal.u r110 = r19;     // Catch: Throwable -> L69
        MVIState r111 = (MVIState) ((s0) r19.c()).get(r10);     // Catch: Throwable -> L69
        com.bytedance.android.anya.l0 r20 = new com.bytedance.android.anya.l0(0);     // Catch: Throwable -> L61
        r20.a = r111;     // Catch: Throwable -> L61
        this.$action.invoke(r20, (ItemListData) r111);     // Catch: Throwable -> L61
    L59:
        if ((!r111.modifiedProperties.isEmpty()) == false) goto L67;
        ((com.bytedance.android.anya.internal.t) r19.c()).d(r10);     // Catch: Throwable -> L69
    L61:
        th = move-exception;
        if ((!r111.modifiedProperties.isEmpty()) == false) goto L65;
        ((com.bytedance.android.anya.internal.t) r19.c()).d(r10);     // Catch: Throwable -> L69
    L65:
        throw th;     // Catch: Throwable -> L69
    L8:
        if (((s0) r2.getCounterDataList().c()).size() <= r11) goto L67;
        com.bytedance.android.anya.internal.u r112 = r2.getCounterDataList();     // Catch: Throwable -> L69
        com.bytedance.android.anya.internal.u r21 = r112;     // Catch: Throwable -> L69
        MVIState r23 = (MVIState) ((s0) r112.c()).get(r11);     // Catch: Throwable -> L69
        new com.bytedance.android.anya.k0.a();     // Catch: Throwable -> L25
        CounterData r24 = (CounterData) r23;     // Catch: Throwable -> L25
        if (((s0) r24.getItemDataList().c()).size() <= r10) goto L23;
        com.bytedance.android.anya.internal.u r25 = r24.getItemDataList();     // Catch: Throwable -> L25
        com.bytedance.android.anya.internal.u r26 = r25;     // Catch: Throwable -> L25
        MVIState r27 = (MVIState) ((s0) r25.c()).get(r10);     // Catch: Throwable -> L25
        com.bytedance.android.anya.l0 r28 = new com.bytedance.android.anya.l0(0);     // Catch: Throwable -> L17
        r28.a = r27;     // Catch: Throwable -> L17
        this.$action.invoke(r28, (ItemListData) r27);     // Catch: Throwable -> L17
    L15:
        if ((!r27.modifiedProperties.isEmpty()) == false) goto L23;
        ((com.bytedance.android.anya.internal.t) r25.c()).d(r10);     // Catch: Throwable -> L25
    L17:
        th = move-exception;
        if ((!r27.modifiedProperties.isEmpty()) == false) goto L21;
        ((com.bytedance.android.anya.internal.t) r25.c()).d(r10);     // Catch: Throwable -> L25
    L21:
        throw th;     // Catch: Throwable -> L25
    L23:
        if ((!r23.modifiedProperties.isEmpty()) == false) goto L67;
        ((com.bytedance.android.anya.internal.t) r112.c()).d(r11);     // Catch: Throwable -> L69
    L25:
        th = move-exception;
        if ((!r23.modifiedProperties.isEmpty()) == false) goto L29;
        ((com.bytedance.android.anya.internal.t) r112.c()).d(r11);     // Catch: Throwable -> L69
    L29:
        throw th;     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        if ((!r1.modifiedProperties.isEmpty()) == false) goto L73;
        ((com.bytedance.android.anya.internal.t) r15.c()).d(r9);
    L73:
        throw th;
    }
}
