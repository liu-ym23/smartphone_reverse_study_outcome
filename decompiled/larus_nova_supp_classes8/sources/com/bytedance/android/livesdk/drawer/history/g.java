package com.bytedance.android.livesdk.drawer.history;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g extends me.drakeet.multitype.b<f, LoadingViewHolder> {
    public g() {
    }

    public final void b(RecyclerView.ViewHolder r3, Object r4) {
        LoadingViewHolder r5 = (LoadingViewHolder) r3;
        f r6 = (f) r4;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "item");
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "item");
        if (Intrinsics.areEqual((Boolean) r6.a.getValue(), Boolean.TRUE) == false) goto L5;
        r5.a.setVisibility(0);
        r5.a.b();
    L6:
        r6.a.observe(r6.b, new h(r5));
        return;
    L5:
        r5.a.setVisibility(8);
        r5.a.c();
        goto L6
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new LoadingViewHolder(r3.inflate(2131566160, r4, false));
    }
}
