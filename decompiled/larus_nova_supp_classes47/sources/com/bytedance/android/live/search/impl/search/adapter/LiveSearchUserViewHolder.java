package com.bytedance.android.live.search.impl.search.adapter;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/adapter/LiveSearchUserViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchUserViewHolder extends RecyclerView.ViewHolder {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;

    public final ImageView T3() {
        return (ImageView) this.f.getValue();
    }

    public LiveSearchUserViewHolder(final View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = LazyKt.lazy(new LiveSearchUserViewHolder$userSelectLayout$2(r2));
        this.b = LazyKt.lazy(new LiveSearchUserViewHolder$ivAvatar$2(r2));
        this.c = LazyKt.lazy(new LiveSearchUserViewHolder$tvUserTitle$2(r2));
        this.d = LazyKt.lazy(new LiveSearchUserViewHolder$tvRelationLabel$2(r2));
        this.e = LazyKt.lazy(new LiveSearchUserViewHolder$tvUserSubTitle$2(r2));
        this.f = LazyKt.lazy(new LiveSearchUserViewHolder$ivUserCheckBox$2(r2));
    }
}
