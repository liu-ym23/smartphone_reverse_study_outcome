package com.bytedance.android.livesdk.chatroom.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    public int a;
    public final int b;
    public final boolean c;

    public SpaceItemDecoration() {
        throw null;
    }

    public SpaceItemDecoration(int r1, int r2, boolean r3) {
        this.b = r1;
        this.a = r2;
        this.c = r3;
    }

    public final void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
        int r5 = r3.getChildPosition(r2);
        int r6 = this.b;
        if (r6 != 0) goto L7;
        if (r5 == 0) goto L14;
        r1.left = this.a;
        return;
    L14:
        return;
    L7:
        if (1 == r6) goto L9;
        return;
    L9:
        if (this.c == false) goto L12;
        if (r5 == 0) goto L17;
        r1.top = this.a;
        return;
    L17:
        return;
    L12:
        r1.top = this.a;
    }
}
