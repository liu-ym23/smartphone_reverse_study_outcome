package com.bytedance.android.live.liveinteract.awemeplay.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/awemeplay/view/LiveVideoCommentSelectPanelVideoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveVideoCommentSelectPanelVideoViewHolder extends RecyclerView.ViewHolder {
    public final HSImageView a;
    public final ImageView b;
    public final TextView c;
    public final View d;
    public final boolean e;
    public final l f;

    public LiveVideoCommentSelectPanelVideoViewHolder(View r2, boolean r3, l r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.e = r3;
        this.f = r4;
        this.a = r2.findViewById(2131375721);
        this.b = (ImageView) r2.findViewById(2131375839);
        this.c = (TextView) r2.findViewById(2131375796);
        this.d = r2.findViewById(2131375842);
    }
}
