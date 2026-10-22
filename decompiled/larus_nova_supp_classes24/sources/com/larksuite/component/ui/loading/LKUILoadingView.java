package com.larksuite.component.ui.loading;

import android.content.Context;
import android.util.AttributeSet;
import com.larksuite.component.ui.imageview.LKUILottieAnimationView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LKUILoadingView extends LKUILottieAnimationView {
    private void init() {
        setAnimation(2131820626);
        setRepeatCount(-1);
    }

    public LKUILoadingView(Context r2) {
        this(r2, null);
    }

    public LKUILoadingView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public LKUILoadingView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init();
    }
}
