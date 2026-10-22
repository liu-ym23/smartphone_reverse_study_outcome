package com.bytedance.android.livesdk.chatroom.widget.unionlive;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.widget.UnionLiveAvatarImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/unionlive/UnionLiveAvatarHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UnionLiveAvatarHolder extends RecyclerView.ViewHolder {
    public final UnionLiveAvatarImageView a;

    public UnionLiveAvatarHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = (UnionLiveAvatarImageView) r2.findViewById(2131392880);
    }
}
