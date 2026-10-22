package com.bytedance.android.live.effect.sticker.ui;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class LiveGesturePageItemDecoration extends RecyclerView.ItemDecoration {
    public LiveGesturePageItemDecoration() {
    }

    public final void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
        super.getItemOffsets(r1, r2, r3, r4);
        if (r3.getChildAdapterPosition(r2) != 0) goto L5;
        r1.set(0, s1.f(8.0f), 0, s1.f(4.0f));
        return;
    L5:
        r1.set(0, s1.f(4.0f), 0, s1.f(4.0f));
    }
}
