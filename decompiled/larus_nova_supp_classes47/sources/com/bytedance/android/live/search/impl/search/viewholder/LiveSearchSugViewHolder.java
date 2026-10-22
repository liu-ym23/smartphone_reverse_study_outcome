package com.bytedance.android.live.search.impl.search.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qa1.c;
import ra1.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/viewholder/LiveSearchSugViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchSugViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int g = 0;
    public final TextView a;
    public g b;
    public String c;
    public final View d;
    public String e;
    public final c f;

    public static final class a {
    }

    static {
    }

    public LiveSearchSugViewHolder(View r2, c r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.f = r3;
        this.c = "";
        this.e = "";
        boolean r4 = ((RecyclerView.ViewHolder) this).itemView.getContext() instanceof FragmentActivity;
        this.a = (TextView) r2.findViewById(2131391534);
        this.d = r2.findViewById(2131376585);
    }
}
