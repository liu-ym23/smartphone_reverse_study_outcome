package com.larus.profile.impl.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.profile.impl.databinding.LarusItemProfileBotListEmptyBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g extends ay7.a<fs9.q, ProfileBotListEmptyViewHolder> {
    public g() {
    }

    public final boolean accept(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return r2 instanceof fs9.q;
    }

    public final RecyclerView.ViewHolder a(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ProfileBotListEmptyViewHolder(LarusItemProfileBotListEmptyBinding.a(r3.inflate(2131562620, r4, false)).a);
    }
}
