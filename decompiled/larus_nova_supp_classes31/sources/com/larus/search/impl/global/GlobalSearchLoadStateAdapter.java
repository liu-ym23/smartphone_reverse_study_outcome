package com.larus.search.impl.global;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.business.search.impl.databinding.LarusItemSearchLoadMoreBinding;
import com.larus.paging.LoadStateAdapter;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/search/impl/global/GlobalSearchLoadStateAdapter;", "Lcom/larus/paging/LoadStateAdapter;", "Lcom/larus/search/impl/global/LoadMoreViewHolder;", "retry", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "onBindViewHolder", "holder", "loadState", "Lcom/larus/paging/LoadState;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class GlobalSearchLoadStateAdapter extends LoadStateAdapter<LoadMoreViewHolder> {
    public final Function0<Unit> b;

    public GlobalSearchLoadStateAdapter(j r2) {
        Intrinsics.checkNotNullParameter(r2, "retry");
        this.b = r2;
    }

    public final LoadMoreViewHolder A2(ViewGroup r4, com.larus.paging.u r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "loadState");
        ConstraintLayout r6 = LayoutInflater.from(r4.getContext()).inflate(2131562649, r4, false);
        int r7 = 2131371759;
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(r6, 2131371759);
        if (r1 == null) goto L9;
        r7 = 2131378977;
        ProgressBar r2 = (ProgressBar) ViewBindings.findChildViewById(r6, 2131378977);
        if (r2 == null) goto L9;
        return new LoadMoreViewHolder(new LarusItemSearchLoadMoreBinding(r6, r1, r2));
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }

    public final void z2(RecyclerView.ViewHolder r4, com.larus.paging.u r5) {
        LoadMoreViewHolder r6 = (LoadMoreViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r5, "loadState");
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "status");
        if ((r5 instanceof com.larus.paging.u.b) == false) goto L6;
        r6.a.c.setVisibility(0);
        r6.a.b.setVisibility(8);
        r6.a.c.startAnimation(r6.b);
    L8:
        e1.d(r6.a.b, new t(this));
        return;
    L6:
        if ((r5 instanceof com.larus.paging.u.a) == false) goto L8;
        r6.a.c.setVisibility(8);
        r6.a.b.setVisibility(0);
        r6.a.c.clearAnimation();
        goto L8
    }
}
