package com.ss.android.lark.picker.base.view;

import android.view.View;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/picker/base/view/ColdAndHotViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "iconFrontTextView", "Lcom/ss/android/lark/picker/base/view/CommonIconFrontTextView;", "getIconFrontTextView", "()Lcom/ss/android/lark/picker/base/view/CommonIconFrontTextView;", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ColdAndHotViewHolder extends RecyclerView.ViewHolder {
    private final CommonIconFrontTextView iconFrontTextView;
    private final ProgressBar progressBar;
    private final View view;

    public final CommonIconFrontTextView getIconFrontTextView() {
        return this.iconFrontTextView;
    }

    public final ProgressBar getProgressBar() {
        return this.progressBar;
    }

    public final View getView() {
        return this.view;
    }

    public ColdAndHotViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.view = r2;
        this.iconFrontTextView = (CommonIconFrontTextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131367108);
        this.progressBar = (ProgressBar) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131367106);
    }
}
