package com.bytedance.android.livesdk.feed.ui;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class OpenItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public final void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
        super.getItemOffsets(r1, r2, r3, r4);
        int r5 = r3.getChildAdapterPosition(r2);
        int r6 = this.e;
        if (r6 <= 0) goto L8;
        if (r5 != 0) goto L6;
    L7:
        r1.top = r6;
    L10:
        if ((r5 % 2) != 0) goto L12;
        r1.right = this.c;
    L13:
        r1.bottom = this.d;
        return;
    L12:
        r1.left = this.a;
        goto L13
    L6:
        if (r5 == 1) goto L7;
    L8:
        r1.top = this.b;
        goto L10
    }

    public OpenItemDecoration(int r2, int r3, int r4, int r5, int r6) {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
