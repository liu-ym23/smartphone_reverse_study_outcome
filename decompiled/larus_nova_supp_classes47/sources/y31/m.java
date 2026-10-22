package y31;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.PKNoMutualFollowedViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m extends me.drakeet.multitype.b<a, PKNoMutualFollowedViewHolder> {

    public static final class a {
        public a() {
        }
    }

    public m() {
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        PKNoMutualFollowedViewHolder r4 = (PKNoMutualFollowedViewHolder) r2;
        a r5 = (a) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        r5.getClass();
        r4.a.setText(null);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new PKNoMutualFollowedViewHolder(r4.inflate(2131566287, r5, false));
    }
}
