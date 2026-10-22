package com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class ChannelMemberListHeaderViewBinder extends b<a, ItemViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/adapter/viewbinder/ChannelMemberListHeaderViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        public ItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public ChannelMemberListHeaderViewBinder() {
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        Intrinsics.checkNotNullParameter((ItemViewHolder) r2, "holder");
        Intrinsics.checkNotNullParameter((a) r3, "item");
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ItemViewHolder(r3.inflate(2131566389, r4, false));
    }
}
