package com.larus.profile.impl;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.profile.impl.databinding.LarusItemProfileBotBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b extends ay7.a<fs9.n, ProfileBotViewHolder> {
    public b() {
    }

    public final boolean accept(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return r2 instanceof fs9.n;
    }

    public final RecyclerView.ViewHolder a(LayoutInflater r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new ProfileBotViewHolder(LarusItemProfileBotBinding.a(r2, r3).a);
    }
}
