package com.obric.flow.cardlistpage.ui.viewbinder;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.flow.cardlistpage.R$id;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/obric/flow/cardlistpage/ui/viewbinder/HeaderWidgetCardViewBinder$ViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHeaderWidgetCardViewBinder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HeaderWidgetCardViewBinder.kt\ncom/obric/flow/cardlistpage/ui/viewbinder/HeaderWidgetCardViewBinder$ViewHolder\n+ 2 OUnitExtension.kt\ncom/obric/oui/common/util/OUnitExtensionKt\n*L\n1#1,37:1\n181#2,3:38\n180#2,5:41\n*S KotlinDebug\n*F\n+ 1 HeaderWidgetCardViewBinder.kt\ncom/obric/flow/cardlistpage/ui/viewbinder/HeaderWidgetCardViewBinder$ViewHolder\n*L\n33#1:38,3\n33#1:41,5\n*E\n"})
public final class HeaderWidgetCardViewBinder$ViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f11858a;

    public HeaderWidgetCardViewBinder$ViewHolder(View r5) {
        Intrinsics.checkNotNullParameter(r5, "itemView");
        super(r5);
        this.f11858a = (LinearLayout) r5.findViewById(R$id.widget_content_container);
    }
}
