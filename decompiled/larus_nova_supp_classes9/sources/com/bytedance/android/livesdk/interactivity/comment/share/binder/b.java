package com.bytedance.android.livesdk.interactivity.comment.share.binder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends me.drakeet.multitype.b<a, DividerViewHolder> {
    public b() {
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        Intrinsics.checkNotNullParameter((DividerViewHolder) r2, "holder");
        Intrinsics.checkNotNullParameter((a) r3, "item");
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new DividerViewHolder(r3.inflate(2131567935, r4, false));
    }
}
