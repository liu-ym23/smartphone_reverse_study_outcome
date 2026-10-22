package com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.viewmodel.SingleDrawViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/singledraw/viewholder/SingleDrawTabViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SingleDrawTabViewHolder extends RecyclerView.ViewHolder {
    public final TextView a;
    public final View b;
    public final SingleDrawViewModel c;

    public SingleDrawTabViewHolder(View r2, SingleDrawViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "itemview");
        super(r2);
        this.b = r2;
        this.c = r3;
        this.a = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131386648);
    }
}
