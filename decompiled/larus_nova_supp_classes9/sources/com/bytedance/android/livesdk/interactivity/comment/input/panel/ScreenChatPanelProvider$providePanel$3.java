package com.bytedance.android.livesdk.interactivity.comment.input.panel;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/livesdk/interactivity/comment/input/panel/ScreenChatPanelProvider$providePanel$3", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScreenChatPanelProvider$providePanel$3 extends RecyclerView.ItemDecoration {
    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        int r6 = r5.getItemCount() - 1;
        if (r4.getChildAdapterPosition(r3) == 0) goto L10;
        if (r4.getChildAdapterPosition(r3) != r6) goto L7;
        r2.left = s1.f(8.0f);
        r2.right = s1.f(16.0f);
        return;
    L7:
        r2.left = s1.f(8.0f);
        return;
    L10:
        throw null;
    }
}
