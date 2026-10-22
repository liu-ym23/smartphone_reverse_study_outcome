package com.obric.assistant.omnidetailpage.viewholder;

import androidx.recyclerview.widget.RecyclerView;
import com.obric.assistant.omnidetailpage.blockview.k0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/omnidetailpage/viewholder/LocalMediaPreviewViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Lcom/obric/assistant/omnidetailpage/blockview/TaskLocalMediaPreviewView;", "<init>", "(Lcom/obric/assistant/omnidetailpage/blockview/TaskLocalMediaPreviewView;)V", "bind", "", "item", "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$LocalMediaPreview;", "onRecycled", "releaseAllVideos", "pauseAllVideos", "checkAutoPlay", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalMediaPreviewViewHolder extends RecyclerView.ViewHolder {
    public final k0 a;

    public LocalMediaPreviewViewHolder(k0 r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.a = r2;
    }
}
