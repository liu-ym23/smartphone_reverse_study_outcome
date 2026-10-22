package com.bytedance.android.livesdk.drawer.history;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.follow.PlaceHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i extends me.drakeet.multitype.b<PlaceHolder, PlaceViewHolder> {
    public final boolean b;

    public i(boolean r1) {
        this.b = r1;
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        PlaceViewHolder r4 = (PlaceViewHolder) r2;
        PlaceHolder r5 = (PlaceHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "item");
        r4.a.setText(r5.getMsg());
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new PlaceViewHolder(r3.inflate(2131566161, r4, false), this.b);
    }
}
