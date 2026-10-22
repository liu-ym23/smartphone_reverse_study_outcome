package com.larksuite.component.blockit.hashtag.list;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.blockit.hashtag.widget.SwipeLayout;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/larksuite/component/blockit/hashtag/list/HashTagViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "nameTv", "Landroid/widget/TextView;", "getNameTv", "()Landroid/widget/TextView;", "hashTagContainer", "getHashTagContainer", "()Landroid/view/View;", "swipeLayout", "Lcom/larksuite/component/blockit/hashtag/widget/SwipeLayout;", "getSwipeLayout", "()Lcom/larksuite/component/blockit/hashtag/widget/SwipeLayout;", "ivDeleteHashTag", "Landroid/widget/ImageView;", "getIvDeleteHashTag", "()Landroid/widget/ImageView;", "teamWorker", "getTeamWorker", "blockit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class HashTagViewHolder extends RecyclerView.ViewHolder {
    public final TextView a;
    public final View b;
    public final SwipeLayout c;
    public final ImageView d;
    public final TextView e;

    public HashTagViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = (TextView) r2.findViewById(2131390080);
        this.b = r2.findViewById(2131374203);
        this.c = (SwipeLayout) r2.findViewById(2131387810);
        this.d = (ImageView) r2.findViewById(2131375909);
        this.e = (TextView) r2.findViewById(2131390081);
    }
}
