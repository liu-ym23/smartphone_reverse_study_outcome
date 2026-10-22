package com.bytedance.android.live.revlink.impl.pk.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FixedForAppBarLayoutManager extends LinearLayoutManager {
    public final int findLastCompletelyVisibleItemPosition() {
        int r0 = getChildCount() - 1;
        if ((-1) <= r0) goto L5;
        int r3 = 1;
    L6:
        if (r0 == (-1)) goto L22;
        View r4 = getChildAt(r0);
        int[] r5 = new int[2];
        r4.getLocationOnScreen(r5);
        Rect r6 = new Rect();
        r4.getGlobalVisibleRect(r6);
        boolean r8 = false;
        if ((r6.bottom - r6.top) != r4.getHeight()) goto L10;
        boolean r7 = true;
    L11:
        View r9 = (View) r4.getParent();
        Rect r10 = new Rect();
        r9.getGlobalVisibleRect(r10);
        if (getOrientation() != 0) goto L18;
        int r12 = r5[0];
        int r13 = r4.getWidth() + r12;
        if (r12 >= r10.left) goto L16;
    L19:
        if (r8 == true) goto L23;
        r0 = r0 + r3;
    L23:
        if (r4 != null) goto L26;
        return -1;
    L26:
        return getPosition(r4);
    L16:
        if (r13 > r10.right) goto L19;
        r8 = true;
        goto L19
    L18:
        r4.getHeight();
        r8 = r7;
        goto L19
    L10:
        r7 = false;
        goto L11
    L22:
        r4 = null;
        goto L23
    L5:
        r3 = -1;
        goto L6
    }

    public FixedForAppBarLayoutManager(Context r1) {
        super(r1);
    }

    public final void onLayoutChildren(RecyclerView.Recycler r1, RecyclerView.State r2) {
        super.onLayoutChildren(r1, r2);     // Catch: Exception -> L4
        return;
    }

    public final int scrollHorizontallyBy(int r1, RecyclerView.Recycler r2, RecyclerView.State r3) {
        return super.scrollHorizontallyBy(r1, r2, r3);
    L4:
        return 0;
    }

    public final int scrollVerticallyBy(int r1, RecyclerView.Recycler r2, RecyclerView.State r3) {
        return super.scrollVerticallyBy(r1, r2, r3);
    L4:
        return 0;
    }
}
