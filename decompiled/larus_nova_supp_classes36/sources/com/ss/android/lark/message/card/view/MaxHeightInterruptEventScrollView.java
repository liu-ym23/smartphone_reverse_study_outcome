package com.ss.android.lark.message.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class MaxHeightInterruptEventScrollView extends ScrollView {
    public int a;

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        return true;
    }

    public int getMaxHeight() {
        return this.a;
    }

    public MaxHeightInterruptEventScrollView(Context r1) {
        super(r1);
        this.a = UIHelper.dp2px(280.0f);
    }

    public void setMaxHeight(int r1) {
        this.a = r1;
        invalidate();
    }

    public MaxHeightInterruptEventScrollView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = UIHelper.dp2px(280.0f);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r2, int r3) {
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(this.a, Target.SIZE_ORIGINAL));
    }

    public MaxHeightInterruptEventScrollView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = UIHelper.dp2px(280.0f);
    }
}
