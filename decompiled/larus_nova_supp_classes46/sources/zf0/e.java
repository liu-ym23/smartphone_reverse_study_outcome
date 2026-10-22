package zf0;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.linkpanel.viewholder.GuestApplyPaidQueueEmptyViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e extends me.drakeet.multitype.b<a, GuestApplyPaidQueueEmptyViewHolder> {

    public static final class a {
        public a() {
        }
    }

    public e() {
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        Intrinsics.checkNotNullParameter((GuestApplyPaidQueueEmptyViewHolder) r2, "holder");
        Intrinsics.checkNotNullParameter((a) r3, "item");
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new GuestApplyPaidQueueEmptyViewHolder(r3.inflate(2131566339, r4, false));
    }
}
