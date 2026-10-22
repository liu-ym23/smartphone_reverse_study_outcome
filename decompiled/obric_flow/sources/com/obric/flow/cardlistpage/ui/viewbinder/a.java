package com.obric.flow.cardlistpage.ui.viewbinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.flow.cardlistpage.R$layout;
import com.obric.flow.cardlistpage.data.FakeWidgetCardModel;
import com.obric.flow.cardlistpage.ui.view.WidgetBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends um.a {
    @Override // um.a
    public final void u(RecyclerView.ViewHolder r5, Object r10) {
        FakeWidgetCardViewBinder$ViewHolder r11 = (FakeWidgetCardViewBinder$ViewHolder) r5;
        FakeWidgetCardModel r12 = (FakeWidgetCardModel) r10;
        Intrinsics.checkNotNullParameter(r11, "holder");
        Intrinsics.checkNotNullParameter(r12, "item");
        View r13 = r11.itemView;
        if ((r13 instanceof WidgetBox) == false) goto L5;
        WidgetBox r14 = (WidgetBox) r13;
    L6:
        if (r14 == null) goto L8;
        r14.b();
    L8:
        Intrinsics.checkNotNullParameter(r12, "item");
        View r15 = r11.itemView;
        if ((r15 instanceof WidgetBox) == false) goto L11;
        WidgetBox r16 = (WidgetBox) r15;
    L12:
        if (r16 == null) goto L14;
        r16.setWidgetView(null);
    L14:
        LinearLayout r17 = r11.f11857a;
        r17.getLayoutParams().height = -2;
        Context r18 = r11.itemView.getContext();
        r12.getSpanX();
        com.obric.flow.cardlistpage.ui.view.a r19 = new com.obric.flow.cardlistpage.ui.view.a(r18, r12.getSpanY());
        r19.setVisibility(4);
        r17.removeAllViews();
        r17.addView(r19, -1, -2);
        return;
    L11:
        r16 = null;
        goto L12
    L5:
        r14 = null;
        goto L6
    }

    @Override // um.a
    public final RecyclerView.ViewHolder v(LayoutInflater r5, ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        Intrinsics.checkNotNullParameter(r10, "parent");
        return new FakeWidgetCardViewBinder$ViewHolder(r5.inflate(R$layout.item_remote_view, r10, false));
    }
}
