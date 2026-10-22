package com.bytedance.android.live.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class HSImageView extends SimpleDraweeView {
    public boolean isAnimating() {
        if (getController() != null) goto L5;
        return false;
    L5:
        if (getController().getAnimatable() != null) goto L7;
        return false;
    L7:
        return getController().getAnimatable().isRunning();
    }

    public HSImageView(Context r1) {
        super(r1);
    }

    public HSImageView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public HSImageView(Context r1, GenericDraweeHierarchy r2) {
        super(r1, r2);
    }

    public HSImageView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    public HSImageView(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }
}
