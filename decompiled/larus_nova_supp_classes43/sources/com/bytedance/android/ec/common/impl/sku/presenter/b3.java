package com.bytedance.android.ec.common.impl.sku.presenter;

import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.model.sku.TradeModeSelection;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b3<T> implements Observer {
    public final /* synthetic */ d3 a;

    public b3(d3 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        Integer r11 = (Integer) r10;
        d3 r12 = this.a;
        LinearLayout r0 = r12.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L5:
        int r1 = r0.getChildCount();
        boolean r13 = false;
        int r14 = 0;
    L6:
        if (r14 >= r1) goto L14;
        LinearLayout r15 = r12.g;
        if (r15 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L10:
        View r16 = r15.getChildAt(r14);
        if ((r16 instanceof com.bytedance.android.ec.common.impl.sku.view.j) == false) goto L13;
        ((com.bytedance.android.ec.common.impl.sku.view.j) r16).setSelectStatus(r14);
    L13:
        r14 = r14 + 1;
        goto L6
    L14:
        SkuViewModel r17 = this.a.f;
        if (r17 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        SkuViewModel r18 = this.a.f;
        if (r18 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L20:
        TradeModeSelection r19 = (TradeModeSelection) r18.getCurrentTradeModeItem().a();
        if (r19 == null) goto L23;
        Integer r20 = r19.getType();
    L24:
        if (r20 != null) goto L27;
    L29:
        r17.setSelectTradeIn(r13);
        d3.d0(this.a);
        return;
    L27:
        if (r20.intValue() != 2) goto L29;
        r13 = true;
        goto L29
    L23:
        r20 = null;
        goto L24
    }
}
