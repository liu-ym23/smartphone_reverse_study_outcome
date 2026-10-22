package com.ss.android.lark.chat.chatwindow.chat;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class TimeLineDecoration extends RecyclerView.ItemDecoration {
    public final void onDrawOver(Canvas r3, RecyclerView r4, RecyclerView.State r5) {
        int r6 = r4.getChildCount();
        int r7 = 0;
    L3:
        if (r7 >= r6) goto L9;
        if (r4.getChildAdapterPosition(r4.getChildAt(r7)) != (-1)) goto L8;
        r7 = r7 + 1;
        goto L3
    L8:
        throw null;
    }

    public final void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
        if (r3.getChildAdapterPosition(r2) != (-1)) goto L7;
        r1.set(0, 0, 0, 0);
        return;
    L7:
        throw null;
    }
}
