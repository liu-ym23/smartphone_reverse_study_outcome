package com.ss.android.lark.forwardv3.confirmdialog;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\"\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/forwardv3/confirmdialog/ForwardConfirmDialogViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "value", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView;", "avatar", "getAvatar", "()Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView;", "icon", "getIcon", "Landroid/widget/FrameLayout;", "container", "getContainer", "()Landroid/widget/FrameLayout;", "bindClick", "", "onItemClickListener", "Lcom/ss/android/lark/forwardv3/confirmdialog/ForwardConfirmDialogAdapter$OnItemClickListener;", "data", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardConfirmDialogViewHolder extends RecyclerView.ViewHolder {
    public final LKUIRoundedImageView a;
    public final LKUIRoundedImageView b;
    public final FrameLayout c;

    public ForwardConfirmDialogViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.a = r2.findViewById(2131367645);
        this.b = r2.findViewById(2131367664);
        this.c = (FrameLayout) r2.findViewById(2131367658);
    }
}
