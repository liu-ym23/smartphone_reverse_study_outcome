package com.obric.flow.cardlistpage.ui.viewbinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.flow.cardlistpage.R$layout;
import com.obric.flow.cardlistpage.data.TravelCardModel;
import com.obric.flow.cardlistpage.ui.view.WidgetBox;
import kotlin.jvm.internal.Intrinsics;
import obric.flow.externalcard.travel.TravelWidgetView;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends um.a {
    @Override // um.a
    public final void u(RecyclerView.ViewHolder r5, Object r10) {
        TravelCardViewBinder$ViewHolder r11 = (TravelCardViewBinder$ViewHolder) r5;
        TravelCardModel r12 = (TravelCardModel) r10;
        Intrinsics.checkNotNullParameter(r11, "holder");
        Intrinsics.checkNotNullParameter(r12, "item");
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "item");
        View r13 = r11.itemView;
        if ((r13 instanceof WidgetBox) == false) goto L5;
        WidgetBox r14 = (WidgetBox) r13;
    L6:
        if (r14 == null) goto L8;
        r14.setWidgetView(null);
        r14.setAnchorView(null);
    L8:
        LinearLayout r15 = r11.f11864a;
        r15.removeAllViews();
        r15.getLayoutParams().height = -2;
        Context r16 = r11.itemView.getContext();
        Intrinsics.checkNotNullParameter(r16, "context");
        TravelWidgetView r17 = k5.d.f18603h;
        if (r17 != null) goto L11;
        r17 = new TravelWidgetView(r16, null, 6, 0);
    L11:
        k5.d.f18603h = r17;
        Intrinsics.checkNotNull(r17);
        r11.f11865b = r17;
        kk.a.j(r17);
        r15.addView(r11.f11865b);
        return;
    L5:
        r14 = null;
        goto L6
    }

    @Override // um.a
    public final RecyclerView.ViewHolder v(LayoutInflater r5, ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        Intrinsics.checkNotNullParameter(r10, "parent");
        return new TravelCardViewBinder$ViewHolder(r5.inflate(R$layout.item_remote_view, r10, false));
    }
}
