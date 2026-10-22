package com.bytedance.android.live.broadcastgame.xplay;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/OPMoreDialogAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/broadcastgame/xplay/OPMoreDialogViewHolder;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class OPMoreDialogAdapter extends RecyclerView.Adapter<OPMoreDialogViewHolder> {
    public final CommonStandardBottomDialog a;
    public final List<i> b;

    public final int getItemCount() {
        return this.b.size();
    }

    public OPMoreDialogAdapter(CommonStandardBottomDialog r2, List<i> r3) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        Intrinsics.checkNotNullParameter(r3, "items");
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        OPMoreDialogViewHolder r5 = (OPMoreDialogViewHolder) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        i r6 = (i) ListProtector.get(this.b, r4);
        r5.a.setTextColor(ColorProtector.parseColor("#000000"));
        r5.a.setText(r6.b);
        r5.b.setImageResource(r6.c);
        ((RecyclerView.ViewHolder) r5).itemView.setOnClickListener(new h(this, r6));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        return new OPMoreDialogViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131567114, r3, false));
    }
}
