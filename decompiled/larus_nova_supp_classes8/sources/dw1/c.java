package dw1;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder.SingleDrawTabViewHolder;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.livesdk.viewmodel.SingleDrawViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends me.drakeet.multitype.b<e, SingleDrawTabViewHolder> {
    public final SingleDrawViewModel b;

    public c(SingleDrawViewModel r1) {
        this.b = r1;
    }

    public final void b(RecyclerView.ViewHolder r3, Object r4) {
        SingleDrawTabViewHolder r5 = (SingleDrawTabViewHolder) r3;
        e r6 = (e) r4;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "item");
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "item");
        r5.a.setText(r6.i());
        r5.b.setOnClickListener(new d(r5, r6));
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new SingleDrawTabViewHolder(r3.inflate(2131566005, r4, false), this.b);
    }
}
