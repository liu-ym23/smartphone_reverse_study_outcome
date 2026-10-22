package com.larus.profile.impl.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x extends ay7.a<fs9.v, ProfileUserViewHolder> {
    public x() {
    }

    public final boolean accept(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return r2 instanceof fs9.v;
    }

    public final RecyclerView.ViewHolder a(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        ConstraintLayout r5 = r3.inflate(2131562026, r4, false);
        if (((ProfileHeaderUserInfoView) ViewBindings.findChildViewById(r5, 2131374317)) == null) goto L7;
        return new ProfileUserViewHolder(r5);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(2131374317)));
    }
}
