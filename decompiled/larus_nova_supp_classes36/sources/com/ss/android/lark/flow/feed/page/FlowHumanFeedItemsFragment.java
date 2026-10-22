package com.ss.android.lark.flow.feed.page;

import android.os.Bundle;
import android.view.View;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/flow/feed/page/FlowHumanFeedItemsFragment;", "Lcom/ss/android/lark/feed/shared/page/FeedItemsFragment;", "<init>", "()V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowHumanFeedItemsFragment extends Hilt_FlowHumanFeedItemsFragment {

    public static final class a {
    }

    static {
    }

    public FlowHumanFeedItemsFragment() {
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        W90().setFilterDoubaoConversation(true);
    }
}
