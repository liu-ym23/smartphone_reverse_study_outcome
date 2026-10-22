package com.bytedance.android.live.effect.beauty.smallitem;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class LiveSmallItemBeautyItemDecoration extends RecyclerView.ItemDecoration {
    public LiveSmallItemBeautyItemDecoration() {
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        super.getItemOffsets(r2, r3, r4, r5);
        int r6 = r4.getChildAdapterPosition(r3);
        if (r6 != 0) goto L6;
        r2.set(s1.f(10.0f), 0, 0, 0);
        return;
    L6:
        if (r6 != (r4.getAdapter().getItemCount() - 1)) goto L10;
        r2.set(0, 0, s1.f(10.0f), 0);
        return;
    }
}
