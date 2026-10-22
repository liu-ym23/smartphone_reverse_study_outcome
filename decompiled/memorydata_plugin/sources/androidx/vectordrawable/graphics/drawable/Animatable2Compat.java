package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public interface Animatable2Compat extends Animatable {

    public static abstract class AnimationCallback {
        Animatable2.AnimationCallback mPlatformCallback;

        public AnimationCallback() {
        }

        Animatable2.AnimationCallback getPlatformCallback() {
            if (this.mPlatformCallback != null) goto L6;
            this.mPlatformCallback = new AnonymousClass1(this);
        L6:
            return this.mPlatformCallback;
        }

        public void onAnimationEnd(Drawable r1) {
        }

        public void onAnimationStart(Drawable r1) {
        }
    }

    void clearAnimationCallbacks();

    void registerAnimationCallback(AnimationCallback r1);

    boolean unregisterAnimationCallback(AnimationCallback r1);
}
