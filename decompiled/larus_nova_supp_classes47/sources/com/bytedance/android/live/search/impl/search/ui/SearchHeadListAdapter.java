package com.bytedance.android.live.search.impl.search.ui;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/ui/SearchHeadListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/search/impl/search/ui/SearchViewHolder;", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchHeadListAdapter extends RecyclerView.Adapter<SearchViewHolder> {
    public final String a;
    public final int b;
    public final List<? extends User> c;
    public final Function1<User, Unit> d;

    public final int getItemCount() {
        List<? extends User> r0 = this.c;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        SearchViewHolder r6 = (SearchViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        ALogger.i("SearchHeadListAdapter", "SearchHeadListAdapter: onBindViewHolder");
        List<? extends User> r0 = this.c;
        if (r0 == null) goto L5;
        User r1 = (User) ListProtector.get(r0, r5);
    L6:
        if (r1 == null) goto L8;
        ImageUtil.loadRoundImage(r6.a, r1.getAvatarThumb());
    L9:
        RecyclerView.LayoutParams r7 = ((RecyclerView.ViewHolder) r6).itemView.getLayoutParams();
        if (r7 == null) goto L17;
        RecyclerView.LayoutParams r8 = r7;
        if (r5 != (getItemCount() - 1)) goto L14;
        r8.setMargins(this.b, ((ViewGroup.MarginLayoutParams) r8).topMargin, ((ViewGroup.MarginLayoutParams) r8).rightMargin, ((ViewGroup.MarginLayoutParams) r8).bottomMargin);
        r8.setMarginStart(this.b);
        return;
    L14:
        r8.setMargins(0, ((ViewGroup.MarginLayoutParams) r8).topMargin, ((ViewGroup.MarginLayoutParams) r8).rightMargin, ((ViewGroup.MarginLayoutParams) r8).bottomMargin);
        r8.setMarginStart(0);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L8:
        r6.getClass();
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        return new SearchViewHolder(r2, new AnonymousClass1(this));
    }

    public SearchHeadListAdapter(LifecycleOwner r2, List<? extends User> r3, Function1<? super User, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        this.c = r3;
        this.d = r4;
        this.a = "SearchHeadListAdapter[" + hashCode() + ']';
        this.b = (int) UIUtils.dip2Px((Context) r2, 16.0f);
    }
}
