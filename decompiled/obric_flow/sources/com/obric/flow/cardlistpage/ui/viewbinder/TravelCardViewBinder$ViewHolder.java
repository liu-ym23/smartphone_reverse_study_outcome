package com.obric.flow.cardlistpage.ui.viewbinder;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.flow.cardlistpage.R$id;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import obric.flow.externalcard.travel.TravelWidgetView;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"com/obric/flow/cardlistpage/ui/viewbinder/TravelCardViewBinder$ViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lgq/a;", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TravelCardViewBinder$ViewHolder extends RecyclerView.ViewHolder implements gq.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f11864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TravelWidgetView f11865b;

    public TravelCardViewBinder$ViewHolder(View r5) {
        Intrinsics.checkNotNullParameter(r5, "itemView");
        super(r5);
        this.f11864a = (LinearLayout) r5.findViewById(R$id.widget_content_container);
    }

    @Override // gq.a
    public final void onDestroy() {
        TravelWidgetView r5 = this.f11865b;
        if (r5 == null) goto L6;
        r5.onDestroy();
        return;
    }
}
