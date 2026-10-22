package q21;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder.AnchorLinkNoFollowedViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends me.drakeet.multitype.b<a, AnchorLinkNoFollowedViewHolder> {

    public static final class a {
        public a() {
        }
    }

    public c() {
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        AnchorLinkNoFollowedViewHolder r4 = (AnchorLinkNoFollowedViewHolder) r2;
        a r5 = (a) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        r5.getClass();
        r4.a.setText(null);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new AnchorLinkNoFollowedViewHolder(r4.inflate(2131566228, r5, false));
    }
}
