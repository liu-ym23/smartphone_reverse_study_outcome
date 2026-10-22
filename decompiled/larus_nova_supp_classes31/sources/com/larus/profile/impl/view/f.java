package com.larus.profile.impl.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f extends ay7.a<fs9.m, ProfileBlockUserViewHolder> {
    public f() {
    }

    public final boolean accept(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return r2 instanceof fs9.m;
    }

    public final RecyclerView.ViewHolder a(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r5 = r3.inflate(2131562618, r4, false);
        if (r5 == null) goto L7;
        return new ProfileBlockUserViewHolder((LinearLayout) r5);
    L7:
        throw new NullPointerException("rootView");
    }
}
