package mx;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.simple.SimpleViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d extends me.drakeet.multitype.b<Object, RecyclerView.ViewHolder> {
    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "item");
    }

    public d() {
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new SimpleViewHolder(r3.inflate(2131566272, r4, false));
    }
}
