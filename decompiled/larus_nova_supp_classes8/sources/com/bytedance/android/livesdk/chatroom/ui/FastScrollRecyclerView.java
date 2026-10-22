package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class FastScrollRecyclerView extends RecyclerView {
    public FastScrollRecyclerView(Context r1) {
        super(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        if (getScrollState() != 2) goto L5;
        boolean r0 = true;
    L6:
        boolean r1 = super.onInterceptTouchEvent(r5);
        if (r5.getActionMasked() != 0) goto L15;
        if (r0 == false) goto L15;
        getParent().requestDisallowInterceptTouchEvent(false);
        if (canScrollVertically(-1) == true) goto L12;
    L13:
        stopScroll();
        return false;
    L12:
        if (canScrollVertically(1) == false) goto L13;
    L15:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    public FastScrollRecyclerView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public FastScrollRecyclerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
