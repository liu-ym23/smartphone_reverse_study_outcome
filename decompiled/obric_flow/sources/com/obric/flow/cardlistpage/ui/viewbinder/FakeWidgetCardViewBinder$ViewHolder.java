package com.obric.flow.cardlistpage.ui.viewbinder;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.flow.cardlistpage.R$id;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/obric/flow/cardlistpage/ui/viewbinder/FakeWidgetCardViewBinder$ViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FakeWidgetCardViewBinder$ViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f11857a;

    public FakeWidgetCardViewBinder$ViewHolder(View r5) {
        Intrinsics.checkNotNullParameter(r5, "itemView");
        super(r5);
        this.f11857a = (LinearLayout) r5.findViewById(R$id.widget_content_container);
    }
}
