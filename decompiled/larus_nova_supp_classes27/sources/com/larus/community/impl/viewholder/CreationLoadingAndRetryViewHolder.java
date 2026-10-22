package com.larus.community.impl.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.larus.community.impl.adapter.LoadingItemDecoration;
import com.larus.community.impl.widget.CreationLoadingAndRetryView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\n2\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\fJ\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/community/impl/viewholder/CreationLoadingAndRetryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "loadingAndRetryView", "Lcom/larus/community/impl/widget/CreationLoadingAndRetryView;", "kotlin.jvm.PlatformType", "setOnRetryClickListener", "", "onRetryClickListener", "Lkotlin/Function0;", "bindItemDecoration", "itemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "updateSpanCount", "spanCount", "", "setEmptyCreator", "emptyViewCreator", "updateStatus", "state", "Lcom/larus/community/impl/view/PageState;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationLoadingAndRetryViewHolder extends RecyclerView.ViewHolder {
    public final CreationLoadingAndRetryView a;

    public CreationLoadingAndRetryViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = (CreationLoadingAndRetryView) r2.findViewById(2131378995);
    }

    public final void T3(int r5) {
        CreationLoadingAndRetryView r0 = this.a;
        StaggeredGridLayoutManager r1 = r0.a.b.getLayoutManager();
        LoadingItemDecoration r3 = null;
        if ((r1 instanceof StaggeredGridLayoutManager) == false) goto L5;
        StaggeredGridLayoutManager r2 = r1;
    L6:
        if (r2 == null) goto L8;
        r2.setSpanCount(r5);
    L8:
        RecyclerView.ItemDecoration r4 = r0.e;
        if ((r4 instanceof LoadingItemDecoration) == false) goto L11;
        r3 = (LoadingItemDecoration) r4;
    L11:
        if (r3 == null) goto L13;
        r3.a = r5;
    L13:
        r0.a.b.invalidateItemDecorations();
        return;
    L5:
        r2 = null;
        goto L6
    }
}
