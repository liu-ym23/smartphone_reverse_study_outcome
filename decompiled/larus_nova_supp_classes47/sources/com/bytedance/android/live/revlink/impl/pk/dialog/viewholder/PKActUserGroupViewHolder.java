package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.AnchorInteractContainerFragment;
import com.bytedance.android.live.revlink.impl.pk.flexactivity.ActUserGroupView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/viewholder/PKActUserGroupViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKActUserGroupViewHolder extends RecyclerView.ViewHolder {
    public final AnchorInteractContainerFragment.b a;

    /* JADX WARN: Multi-variable type inference failed */
    public PKActUserGroupViewHolder(ActUserGroupView r2, AnchorInteractContainerFragment.b r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.a = r3;
    }
}
