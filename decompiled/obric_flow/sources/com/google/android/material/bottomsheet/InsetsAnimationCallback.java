package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.animation.AnimationUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class InsetsAnimationCallback extends WindowInsetsAnimationCompat.Callback {
    private int startTranslationY;
    private int startY;
    private final int[] tmpLocation;
    private final View view;

    public InsetsAnimationCallback(View r5) {
        super(0);
        this.tmpLocation = new int[2];
        this.view = r5;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onEnd(@NonNull WindowInsetsAnimationCompat r5) {
        this.view.setTranslationY(0.0f);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onPrepare(@NonNull WindowInsetsAnimationCompat r5) {
        this.view.getLocationOnScreen(this.tmpLocation);
        this.startY = this.tmpLocation[1];
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    @NonNull
    public WindowInsetsCompat onProgress(@NonNull WindowInsetsCompat r5, @NonNull List<WindowInsetsAnimationCompat> r10) {
        Iterator<WindowInsetsAnimationCompat> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        WindowInsetsAnimationCompat r12 = r11.next();
        if ((r12.getTypeMask() & WindowInsetsCompat.Type.ime()) == 0) goto L4;
        this.view.setTranslationY(AnimationUtils.lerp(this.startTranslationY, 0, r12.getInterpolatedFraction()));
    L8:
        return r5;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    @NonNull
    public WindowInsetsAnimationCompat.BoundsCompat onStart(@NonNull WindowInsetsAnimationCompat r5, @NonNull WindowInsetsAnimationCompat.BoundsCompat r10) {
        this.view.getLocationOnScreen(this.tmpLocation);
        int r11 = this.startY - this.tmpLocation[1];
        this.startTranslationY = r11;
        this.view.setTranslationY(r11);
        return r10;
    }
}
