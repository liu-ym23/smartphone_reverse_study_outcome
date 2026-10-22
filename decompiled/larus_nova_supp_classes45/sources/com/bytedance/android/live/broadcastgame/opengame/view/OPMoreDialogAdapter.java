package com.bytedance.android.live.broadcastgame.opengame.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/view/OPMoreDialogAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/broadcastgame/opengame/view/OPMoreDialogViewHolder;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class OPMoreDialogAdapter extends RecyclerView.Adapter<OPMoreDialogViewHolder> {
    public final OPPluginMoreDialog a;
    public final List<n> b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ OPMoreDialogAdapter a;
        public final /* synthetic */ n b;

        public a(OPMoreDialogAdapter r1, n r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            n r0 = this.b;
            r0.d.a(this.a.a, r4, r0);
        }
    }

    public final int getItemCount() {
        return this.b.size();
    }

    public final void z2(List<n> r2) {
        Intrinsics.checkNotNullParameter(r2, "newList");
        this.b.clear();
        this.b.addAll(r2);
        notifyDataSetChanged();
    }

    public OPMoreDialogAdapter(OPPluginMoreDialog r2, List<n> r3) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        Intrinsics.checkNotNullParameter(r3, "items");
        this.a = r2;
        this.b = r3;
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        y2((OPMoreDialogViewHolder) r1, r2);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        return new OPMoreDialogViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131567114, r3, false));
    }

    public void y2(OPMoreDialogViewHolder r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        n r5 = (n) ListProtector.get(this.b, r4);
        int r0 = r5.a;
        if (r0 != 8) goto L5;
    L8:
        r3.a.setTextColor(ColorProtector.parseColor("#FE2C55"));
    L9:
        r3.a.setText(r5.b);
        r3.b.setImageResource(r5.c);
        ((RecyclerView.ViewHolder) r3).itemView.setOnClickListener(new a(this, r5));
        return;
    L5:
        if (r0 == 12) goto L8;
        r3.a.setTextColor(ColorProtector.parseColor("#000000"));
        goto L9
    }
}
