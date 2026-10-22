package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k extends RecyclerView.ItemDecoration {
    public k() {
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        super.getItemOffsets(r2, r3, r4, r5);
        if (r4.getChildAdapterPosition(r3) != 0) goto L6;
        r2.top = (int) UtilityKotlinExtentionsKt.h(58);
        return;
    }
}
