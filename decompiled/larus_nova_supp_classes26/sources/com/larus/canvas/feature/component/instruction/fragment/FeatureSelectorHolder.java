package com.larus.canvas.feature.component.instruction.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.view.FlowLayout;
import iy8.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u000fJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/canvas/feature/component/instruction/fragment/FeatureSelectorHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "callback", "Lcom/larus/canvas/feature/component/instruction/fragment/FeatureItemSelectorCallback;", "<init>", "(Landroid/view/View;Lcom/larus/canvas/feature/component/instruction/fragment/FeatureItemSelectorCallback;)V", "getItemView", "()Landroid/view/View;", "getCallback", "()Lcom/larus/canvas/feature/component/instruction/fragment/FeatureItemSelectorCallback;", "subTitle", "Landroid/widget/TextView;", "tagContainer", "Lcom/larus/bmhome/chat/view/FlowLayout;", "getFlowLayout", "bindData", "", "data", "Lcom/larus/canvas/feature/component/instruction/fragment/FeatureSelectorOptionPanelItem;", "initInputText", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeatureSelectorHolder extends RecyclerView.ViewHolder {
    public final View a;
    public final a b;
    public final TextView c;
    public final FlowLayout d;

    public FeatureSelectorHolder(ConstraintLayout r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = r2;
        this.b = r3;
        this.c = (TextView) r2.findViewById(2131390607);
        this.d = (FlowLayout) r2.findViewById(2131388092);
    }
}
