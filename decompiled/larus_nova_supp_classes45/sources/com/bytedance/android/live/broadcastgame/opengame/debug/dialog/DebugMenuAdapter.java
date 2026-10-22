package com.bytedance.android.live.broadcastgame.opengame.debug.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n10.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/debug/dialog/DebugMenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/broadcastgame/opengame/debug/dialog/DebugMenuViewHolder;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DebugMenuAdapter extends RecyclerView.Adapter<DebugMenuViewHolder> {
    public final List<h> a;

    public final int getItemCount() {
        return this.a.size();
    }

    public DebugMenuAdapter(List<h> r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
        this.a = r2;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        DebugMenuViewHolder r6 = (DebugMenuViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        h r7 = (h) ListProtector.get(this.a, r5);
        r6.a.setText(r7.a);
        View.OnClickListener r0 = r7.b;
        if (r0 == null) goto L6;
        ((RecyclerView.ViewHolder) r6).itemView.setOnClickListener(r0);
    L6:
        if (r7.c == null) goto L8;
        r6.b.setVisibility(0);
        r6.b.setChecked(r7.d);
        r6.b.setOnCheckedChangeListener(null);
        r6.b.setOnCheckedChangeListener(r7.c);
        return;
    L8:
        r6.b.setOnCheckedChangeListener(null);
        r6.b.setVisibility(8);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        return new DebugMenuViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131567091, r3, false));
    }
}
