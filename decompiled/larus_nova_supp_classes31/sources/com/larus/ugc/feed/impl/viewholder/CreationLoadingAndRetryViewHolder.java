package com.larus.ugc.feed.impl.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.ugc.feed.impl.widget.CreationLoadingAndRetryView;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\n2\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\fJ\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/ugc/feed/impl/viewholder/CreationLoadingAndRetryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "loadingAndRetryView", "Lcom/larus/ugc/feed/impl/widget/CreationLoadingAndRetryView;", "kotlin.jvm.PlatformType", "setOnRetryClickListener", "", "onRetryClickListener", "Lkotlin/Function0;", "bindItemDecoration", "itemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "setEmptyCreator", "emptyViewCreator", "updateStatus", "state", "Lcom/larus/ugc/feed/api/state/PageState;", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationLoadingAndRetryViewHolder extends RecyclerView.ViewHolder {
    public final CreationLoadingAndRetryView a;

    public CreationLoadingAndRetryViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = (CreationLoadingAndRetryView) r2.findViewById(2131378995);
    }
}
