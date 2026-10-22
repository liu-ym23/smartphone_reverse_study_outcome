package f20;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.AbsOpenFeatureTabListItemViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class g<T, V extends AbsOpenFeatureTabListItemViewHolder<T>> implements a<T, V> {
    public g() {
    }

    public void b(V r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        r2.T3(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f20.a
    public /* bridge */ /* synthetic */ void d(RecyclerView.ViewHolder r1, Object r2) {
        b((AbsOpenFeatureTabListItemViewHolder) r1, r2);
    }
}
