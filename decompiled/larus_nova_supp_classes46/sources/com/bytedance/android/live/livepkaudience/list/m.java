package com.bytedance.android.live.livepkaudience.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m extends me.drakeet.multitype.b<a, PkPreApplyTitleViewHolder> {

    public static final class a {
        public a() {
        }
    }

    public m() {
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        PkPreApplyTitleViewHolder r4 = (PkPreApplyTitleViewHolder) r2;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter((a) r3, "item");
        ((TextView) r4.a.getValue()).setText(2131894405);
        ((TextView) r4.b.getValue()).setText(2131923706);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new PkPreApplyTitleViewHolder(r3.inflate(2131566358, r4, false));
    }
}
