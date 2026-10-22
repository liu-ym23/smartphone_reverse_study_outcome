package erb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.mention.base.impl.atselector.IItemContainer;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.BottomSearchTipBean;
import com.ss.android.lark.mention.base.impl.atselector.view.adapter.holder.BottomSearchTipViewHolder;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements drb.a<BottomSearchTipBean, BottomSearchTipViewHolder> {
    public f(IItemContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
    }

    @Override // drb.a
    public final /* bridge */ /* synthetic */ long a(BottomSearchTipBean r3) {
        return -1;
    }

    @Override // drb.a
    public final RecyclerView.ViewHolder b(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r5 = LayoutInflater.from(r4.getContext()).inflate(2131561506, r4, false);
        Intrinsics.checkNotNull(r5);
        return new BottomSearchTipViewHolder(r5);
    }

    @Override // drb.a
    public final /* bridge */ /* synthetic */ void c(RecyclerView.ViewHolder r1, BaseAtBean r2, int r3) {
        BottomSearchTipViewHolder r4 = (BottomSearchTipViewHolder) r1;
        BottomSearchTipBean r5 = (BottomSearchTipBean) r2;
    }

    @Override // drb.a
    public final void d(RecyclerView.ViewHolder r1, BaseAtBean r2, int r3, List r4) {
        BottomSearchTipViewHolder r5 = (BottomSearchTipViewHolder) r1;
        BottomSearchTipBean r6 = (BottomSearchTipBean) r2;
        Intrinsics.checkNotNullParameter(r4, "payloads");
    }
}
