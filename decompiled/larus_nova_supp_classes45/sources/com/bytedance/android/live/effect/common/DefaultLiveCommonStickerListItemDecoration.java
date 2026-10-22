package com.bytedance.android.live.effect.common;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/effect/common/DefaultLiveCommonStickerListItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DefaultLiveCommonStickerListItemDecoration extends RecyclerView.ItemDecoration {
    public DefaultLiveCommonStickerListItemDecoration() {
    }

    public final void getItemOffsets(Rect r4, View r5, RecyclerView r6, RecyclerView.State r7) {
        Intrinsics.checkNotNullParameter(r4, "outRect");
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "parent");
        Intrinsics.checkNotNullParameter(r7, "state");
        super.getItemOffsets(r4, r5, r6, r7);
        if (r6.getChildAdapterPosition(r5) != 0) goto L5;
        r4.set(s1.f(14.0f), 0, s1.f(2.0f), 0);
        return;
    L5:
        int r8 = r6.getChildAdapterPosition(r5);
        RecyclerView.Adapter r9 = r6.getAdapter();
        if (r9 != null) goto L8;
    L10:
        r4.set(s1.f(2.0f), 0, s1.f(2.0f), 0);
        return;
    L8:
        if (r8 != (r9.getItemCount() - 1)) goto L10;
        r4.set(s1.f(2.0f), 0, s1.f(14.0f), 0);
    }
}
