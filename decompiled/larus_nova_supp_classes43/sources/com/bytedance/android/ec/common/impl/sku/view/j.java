package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.model.sku.TradeModeComponent;
import com.bytedance.android.ec.model.sku.TradeModeSelection;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j extends FrameLayout {
    public final View a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final View e;
    public final SkuViewModel f;

    private final void setItemSelectBackground(boolean r10) {
        if (r10 == false) goto L4;
        int r0 = ColorProtector.parseColor("#FF3B52");
        GradientDrawable r1 = new GradientDrawable();
        r1.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(4));
        r1.setColor(com.bytedance.android.ec.common.impl.sku.utils.m.a(r0, 0.05f));
        r1.setStroke(vf4.a.b(1), com.bytedance.android.ec.common.impl.sku.utils.m.a(r0, 0.5f));
        this.e.setBackgroundDrawable(r1);
    L5:
        this.e.setSelected(r10);
        return;
    L4:
        this.e.setBackgroundResource(2131247934);
        goto L5
    }

    private final void setSelectedStatus(boolean r10) {
        if (r10 == true) goto L4;
        this.b.setTextColor(th.a.a(getContext(), 2131105908));
        this.b.setTypeface(Typeface.defaultFromStyle(0));
        this.c.setTextColor(th.a.a(getContext(), 2131105943));
    L5:
        setItemSelectBackground(r10);
        return;
    L4:
        this.b.setTextColor(th.a.a(getContext(), 2131101672));
        this.b.setTypeface(Typeface.defaultFromStyle(1));
        this.c.setTextColor(th.a.a(getContext(), 2131101652));
        goto L5
    }

    public final void setSelectStatus(int r10) {
        setSelectedStatus(false);
        TradeModeSelection r1 = null;
        this.f.getCurrentTradeModeItem().g(null);
        Integer r0 = (Integer) this.f.getCurrentTradeModeIndex().a();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r10 != r0.intValue()) goto L16;
        setSelectedStatus(true);
        SkuInfoVO r11 = (SkuInfoVO) this.f.getSkuInfo().a();
        if (r11 == null) goto L14;
        TradeModeComponent r12 = r11.getTradeModeComponent();
        if (r12 == null) goto L14;
        List r13 = r12.getSelections();
        if (r13 == null) goto L14;
        r1 = (TradeModeSelection) CollectionsKt.getOrNull(r13, r10);
    L14:
        this.f.getCurrentTradeModeItem().g(r1);
        return;
    }

    public j(SkuViewModel r10, Context r11) {
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, null, 0);
        this.f = r10;
        View r12 = th.a.c(r11, 2131564795, this, true);
        this.a = r12;
        this.b = (TextView) r12.findViewById(2131391473);
        this.c = (TextView) r12.findViewById(2131391472);
        this.d = (TextView) r12.findViewById(2131391471);
        this.e = r12.findViewById(2131366899);
    }
}
