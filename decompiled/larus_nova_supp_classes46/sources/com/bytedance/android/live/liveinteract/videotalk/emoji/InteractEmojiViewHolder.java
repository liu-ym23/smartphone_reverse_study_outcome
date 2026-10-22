package com.bytedance.android.live.liveinteract.videotalk.emoji;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/emoji/InteractEmojiViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InteractEmojiViewHolder extends RecyclerView.ViewHolder {
    public final HSImageView a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public TalkRoomBaseDynamicEmoji f;

    public InteractEmojiViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.a = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131371532);
        this.b = (ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131371534);
        this.c = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131375509);
        this.d = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131383624);
        this.e = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390803);
    }
}
