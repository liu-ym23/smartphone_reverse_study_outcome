package com.larus.bmhome.view.actionbar.edit.fragment;

import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.view.FlowLayout;
import com.larus.bmhome.view.actionbar.edit.component.m1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/fragment/FeatureSelectorHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "callback", "Lcom/larus/bmhome/view/actionbar/edit/component/FeatureItemSelectorCallback;", "initInputText", "", "<init>", "(Landroid/view/View;Lcom/larus/bmhome/view/actionbar/edit/component/FeatureItemSelectorCallback;Ljava/lang/String;)V", "getCallback", "()Lcom/larus/bmhome/view/actionbar/edit/component/FeatureItemSelectorCallback;", "subTitle", "Landroid/widget/TextView;", "tagContainer", "Lcom/larus/bmhome/chat/view/FlowLayout;", "getFlowLayout", "bindData", "", "data", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionFeatureOptionPanel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeatureSelectorHolder extends RecyclerView.ViewHolder {
    public final m1 a;
    public final String b;
    public final TextView c;
    public final FlowLayout d;

    public FeatureSelectorHolder(ConstraintLayout r2, m1 r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = r3;
        this.b = r4;
        this.c = (TextView) r2.findViewById(2131390607);
        this.d = (FlowLayout) r2.findViewById(2131388092);
    }
}
