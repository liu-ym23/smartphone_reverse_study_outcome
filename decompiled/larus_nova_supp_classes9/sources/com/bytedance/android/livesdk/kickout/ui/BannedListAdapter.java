package com.bytedance.android.livesdk.kickout.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.uikit.recyclerview.LoadMoreRecyclerViewAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class BannedListAdapter extends LoadMoreRecyclerViewAdapter {

    public static class a extends RecyclerView.ViewHolder {
        public final TextView a;

        public a(View r2) {
            super(r2);
            this.a = (TextView) r2.findViewById(2131390209);
        }
    }

    public final int getBasicItemCount() {
        throw null;
    }

    public final int getBasicItemViewType(int r1) {
        return super/*com.bytedance.android.live.uikit.recyclerview.RecyclerViewWithFooterAdapter*/.getBasicItemViewType(r1);
    }

    public final void onBindBasicViewHolder(RecyclerView.ViewHolder r2, int r3) {
        if (getItemViewType(r3) != 4099) goto L9;
        a r4 = (a) r2;
        if (r4 == null) goto L11;
        TextView r5 = r4.a;
        throw null;
    L11:
        return;
    L9:
        BannedViewHolder r6 = (BannedViewHolder) r2;
    }

    public final RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r8, int r9) {
        if (r9 != 4099) goto L7;
        return new a(LayoutInflater.from(null).inflate(2131566235, r8, false));
    L7:
        return new BannedViewHolder(null, LayoutInflater.from(null).inflate(2131566236, r8, false), null, 0, null);
    }
}
