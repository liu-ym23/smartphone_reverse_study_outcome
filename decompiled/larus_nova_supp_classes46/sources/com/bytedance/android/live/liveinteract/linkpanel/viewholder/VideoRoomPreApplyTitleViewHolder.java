package com.bytedance.android.live.liveinteract.linkpanel.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/viewholder/VideoRoomPreApplyTitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoRoomPreApplyTitleViewHolder extends RecyclerView.ViewHolder {
    public final Lazy a;
    public final Lazy b;

    public VideoRoomPreApplyTitleViewHolder(final View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = LazyKt.lazy(new VideoRoomPreApplyTitleViewHolder$currentOrder$2(r2));
        this.b = LazyKt.lazy(new VideoRoomPreApplyTitleViewHolder$tvSortType$2(r2));
    }
}
