package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class NoTouchRecyclerView extends RecyclerView {
    public final boolean onTouchEvent(MotionEvent r1) {
        return false;
    }

    public NoTouchRecyclerView(Context r1) {
        super(r1);
    }

    public NoTouchRecyclerView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public NoTouchRecyclerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
