package com.obric.flow.cardlistpage.ui.viewbinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.flow.cardlistpage.R$layout;
import com.obric.flow.cardlistpage.data.HeaderWidgetCardModel;
import com.obric.flow.cardlistpage.ui.view.WidgetBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends um.a {
    @Override // um.a
    public final void u(RecyclerView.ViewHolder r5, Object r10) {
        HeaderWidgetCardViewBinder$ViewHolder r11 = (HeaderWidgetCardViewBinder$ViewHolder) r5;
        HeaderWidgetCardModel r12 = (HeaderWidgetCardModel) r10;
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
        LinearLayout r17 = r11.f11858a;
        r17.removeAllViews();
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        if (r12.getHeight() <= 0) goto L17;
        int r19 = r12.getHeight();
    L18:
        r18.height = r19;
        return;
    L17:
        r19 = androidx.room.jarjarred.org.antlr.runtime.a.a(92, 1);
        goto L18
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
        return new HeaderWidgetCardViewBinder$ViewHolder(r5.inflate(R$layout.item_remote_view, r10, false));
    }
}
