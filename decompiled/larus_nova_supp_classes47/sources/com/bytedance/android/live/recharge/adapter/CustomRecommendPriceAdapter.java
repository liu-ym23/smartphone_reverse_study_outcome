package com.bytedance.android.live.recharge.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.viewholder.CustomRecommendPriceViewHolder;
import com.bytedance.android.live.revenue.common.l;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/recharge/adapter/CustomRecommendPriceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/recharge/viewholder/CustomRecommendPriceViewHolder;", "<init>", "()V", "a", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CustomRecommendPriceAdapter extends RecyclerView.Adapter<CustomRecommendPriceViewHolder> {
    public List<Long> a;
    public a b;

    public interface a {
        void Yq(long r1);
    }

    public final int getItemCount() {
        List<Long> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public CustomRecommendPriceAdapter() {
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        CustomRecommendPriceViewHolder r12 = (CustomRecommendPriceViewHolder) r9;
        Intrinsics.checkNotNullParameter(r12, "viewHolder");
        List<Long> r0 = this.a;
        if (r0 == null) goto L15;
        Long r13 = (Long) ListProtector.get(r0, r10);
        if (r13 == null) goto L16;
        long r1 = r13.longValue();
        TextView r14 = r12.a;
        int r2 = (int) (r1 / 100.0f);
        float r3 = r2;
        if (r3 >= 10000.0f) goto L9;
        String r4 = s1.C(2131921889, new Object[]{Integer.valueOf(r2)});
    L13:
        r14.setText(r4);
        ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(new xv0.a(r1, this));
        return;
    L9:
        float r5 = r3 / 10000.0f;
        if ((r2 % ((int) 10000.0f)) != 0) goto L12;
        r4 = s1.C(2131921891, new Object[]{Integer.valueOf((int) r5)});
        goto L13
    L12:
        r4 = s1.C(2131921891, new Object[]{l.a("%.1f", new Object[]{Float.valueOf(r5)})});
        goto L13
    L16:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new CustomRecommendPriceViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131566250, r4, false));
    }
}
