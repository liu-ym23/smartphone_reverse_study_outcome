package com.bytedance.android.livesdk.interactivity.interactive.dialog.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/adapter/VSMsgBoardBadgeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSMsgBoardBadgeViewHolder extends RecyclerView.ViewHolder {
    public final ImageView a;
    public final HSImageView b;
    public final TextView c;
    public final ImageView d;

    public VSMsgBoardBadgeViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = (ImageView) r2.findViewById(2131389898);
        this.b = r2.findViewById(2131389897);
        this.c = (TextView) r2.findViewById(2131363841);
        RoundCornerConstraintLayout r0 = r2.findViewById(2131363836);
        this.d = (ImageView) r2.findViewById(2131389867);
    }
}
