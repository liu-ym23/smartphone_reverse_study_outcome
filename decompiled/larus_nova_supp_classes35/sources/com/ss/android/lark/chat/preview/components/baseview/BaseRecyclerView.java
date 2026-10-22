package com.ss.android.lark.chat.preview.components.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class BaseRecyclerView extends RecyclerView {
    public final boolean onTouchEvent(MotionEvent r1) {
        return false;
    }

    public BaseRecyclerView(Context r1) {
        super(r1);
    }

    public BaseRecyclerView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public BaseRecyclerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
