package com.obric.flow.cardlistpage.ui.viewbinder;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.flow.cardlistpage.R$id;
import com.obric.flow.cardlistpage.ui.view.WidgetBox;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"com/obric/flow/cardlistpage/ui/viewbinder/WidgetCardViewBinder$ViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lgq/a;", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WidgetCardViewBinder$ViewHolder extends RecyclerView.ViewHolder implements gq.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f11866c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f11867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f11868b;

    public WidgetCardViewBinder$ViewHolder(h r5, View r10) {
        Intrinsics.checkNotNullParameter(r10, "itemView");
        this.f11868b = r5;
        super(r10);
        this.f11867a = (LinearLayout) r10.findViewById(R$id.widget_content_container);
    }

    @Override // gq.a
    public final void onDestroy() {
        View r5 = this.itemView;
        ku.a r10 = null;
        if ((r5 instanceof WidgetBox) == false) goto L5;
        WidgetBox r11 = (WidgetBox) r5;
    L6:
        if (r11 == null) goto L8;
        View r12 = r11.getWidgetView();
    L10:
        if ((r12 instanceof gu.f) == false) goto L12;
        gu.f r13 = (gu.f) r12;
    L13:
        if (r13 == null) goto L15;
        View r14 = r13.getChildAt(0);
    L17:
        if ((r14 instanceof ku.a) == false) goto L19;
        r10 = (ku.a) r14;
    L19:
        if (r10 == null) goto L22;
        r10.onDestroy();
        return;
    L22:
        return;
    L15:
        r14 = null;
        goto L17
    L12:
        r13 = null;
        goto L13
    L8:
        r12 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }
}
