package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class ECLottieAnimationView extends LottieAnimationView {
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelAnimation();
    }

    public ECLottieAnimationView(Context r1) {
        super(r1);
        setImageFolder("images");
    }

    private void setImageFolder(String r1) {
        setImageAssetsFolder(r1);
    }

    public ECLottieAnimationView(Context r1, AttributeSet r10) {
        super(r1, r10);
        setImageFolder("images");
    }

    public ECLottieAnimationView(Context r1, AttributeSet r10, int r11) {
        super(r1, r10, r11);
        setImageFolder("images");
    }
}
