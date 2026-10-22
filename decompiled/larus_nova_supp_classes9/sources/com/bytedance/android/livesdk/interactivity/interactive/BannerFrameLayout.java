package com.bytedance.android.livesdk.interactivity.interactive;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class BannerFrameLayout extends FrameLayout {
    public BannerFrameLayout(Context r1) {
        super(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        requestDisallowInterceptTouchEvent(true);
        super.dispatchTouchEvent(r2);
        return true;
    }

    public BannerFrameLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public BannerFrameLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
