package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.s0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftSearchViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "itemListData", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ItemListData;", "index", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 4, 3}, xi = 128)
public final class GiftSearchVMUtilsKt$modifyListDataWithRule$modifyAction$1 extends Lambda implements Function2<ItemListData, Integer, Unit> {
    final /* synthetic */ Function2 $action;
    final /* synthetic */ GiftSearchViewState $state;
    final /* synthetic */ com.bytedance.android.anya.l0 $this_modifyListDataWithRule;

    public GiftSearchVMUtilsKt$modifyListDataWithRule$modifyAction$1(com.bytedance.android.anya.l0 r1, GiftSearchViewState r2, Function2 r3) {
        this.$this_modifyListDataWithRule = r1;
        this.$state = r2;
        this.$action = r3;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((ItemListData) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ItemListData r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "itemListData");
        com.bytedance.android.anya.internal.u r7 = this.$state.getSearchItemDataList();
        MVIState r0 = (MVIState) ((s0) r7.c()).get(r6);
        com.bytedance.android.anya.l0 r1 = new com.bytedance.android.anya.l0(0);     // Catch: Throwable -> L8
        r1.a = r0;     // Catch: Throwable -> L8
        this.$action.invoke(r1, (ItemListData) r0);     // Catch: Throwable -> L8
        if ((!r0.modifiedProperties.isEmpty()) == false) goto L15;
        ((com.bytedance.android.anya.internal.t) r7.c()).d(r6);
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if ((!r0.modifiedProperties.isEmpty()) == false) goto L12;
        ((com.bytedance.android.anya.internal.t) r7.c()).d(r6);
    L12:
        throw th;
    }
}
