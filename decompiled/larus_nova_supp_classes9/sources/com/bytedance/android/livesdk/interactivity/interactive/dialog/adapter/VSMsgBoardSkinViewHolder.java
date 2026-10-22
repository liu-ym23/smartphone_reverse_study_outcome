package com.bytedance.android.livesdk.interactivity.interactive.dialog.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.LiveRoundImageView;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/adapter/VSMsgBoardSkinViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSMsgBoardSkinViewHolder extends RecyclerView.ViewHolder {
    public final ImageView a;
    public final HSImageView b;
    public final LiveRoundImageView c;
    public final TextView d;
    public final TextView e;
    public final ImageView f;

    public VSMsgBoardSkinViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = (ImageView) r2.findViewById(2131389933);
        RoundCornerConstraintLayout r0 = r2.findViewById(2131386823);
        this.b = r2.findViewById(2131389931);
        RoundCornerConstraintLayout r1 = r2.findViewById(2131389934);
        this.c = r2.findViewById(2131389932);
        this.d = (TextView) r2.findViewById(2131389935);
        this.e = (TextView) r2.findViewById(2131386825);
        this.f = (ImageView) r2.findViewById(2131389868);
    }
}
