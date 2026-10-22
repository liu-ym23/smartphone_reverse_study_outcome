package com.bytedance.android.live.openplatform.impl.miniappanchor.debug;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/debug/DebugMenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/debug/DebugMenuViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DebugMenuAdapter extends RecyclerView.Adapter<DebugMenuViewHolder> {
    public final List<c> a;

    public final int getItemCount() {
        return this.a.size();
    }

    public DebugMenuAdapter(List<c> r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
        this.a = r2;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        DebugMenuViewHolder r5 = (DebugMenuViewHolder) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        c r6 = (c) ListProtector.get(this.a, r4);
        r5.a.setText(r6.a);
        View.OnClickListener r7 = r6.b;
        if (r7 == null) goto L5;
        ((RecyclerView.ViewHolder) r5).itemView.setOnClickListener(r7);
    L5:
        r5.b.setOnCheckedChangeListener(null);
        r5.b.setVisibility(8);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        return new DebugMenuViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131567091, r3, false));
    }
}
