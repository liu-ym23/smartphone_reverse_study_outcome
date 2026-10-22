package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class CircleImageView extends SimpleDraweeView {
    public void f() {
        RoundingParams r0 = new RoundingParams();
        r0.setRoundAsCircle(true);
        getHierarchy().setRoundingParams(r0);
        getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
    }

    public CircleImageView(Context r1) {
        super(r1);
        f();
    }

    public CircleImageView(Context r1, AttributeSet r10) {
        super(r1, r10);
        f();
    }

    public CircleImageView(Context r1, AttributeSet r10, int r11) {
        super(r1, r10, r11);
        f();
    }
}
