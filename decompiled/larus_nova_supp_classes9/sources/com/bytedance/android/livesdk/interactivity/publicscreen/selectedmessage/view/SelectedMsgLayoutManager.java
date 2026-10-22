package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.ui.SmoothLinearLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/view/SelectedMsgLayoutManager;", "Lcom/bytedance/android/livesdk/chatroom/ui/SmoothLinearLayoutManager;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SelectedMsgLayoutManager extends SmoothLinearLayoutManager {
    public int b;
    public final SelectedMsgLayoutManager$scrollController$1 c;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.SelectedMsgLayoutManager$scrollController$1] */
    public SelectedMsgLayoutManager(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = Integer.MAX_VALUE;
        this.c = new SelectedMsgLayoutManager$scrollController$1(this, r2);
    }

    public final void smoothScrollToPosition(RecyclerView r1, RecyclerView.State r2, int r3) {
        int r4 = Math.max(0, r3);
        setTargetPosition(r4);
        startSmoothScroll(this.c);
    }
}
