package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public interface Animatable2Compat extends Animatable {

    public static abstract class AnimationCallback {
        Animatable2.AnimationCallback mPlatformCallback;

        public AnimationCallback() {
        }

        @RequiresApi(23)
        Animatable2.AnimationCallback getPlatformCallback() {
            if (this.mPlatformCallback != null) goto L6;
            this.mPlatformCallback = new AnonymousClass1(this);
        L6:
            return this.mPlatformCallback;
        }

        public void onAnimationEnd(Drawable r10) {
        }

        public void onAnimationStart(Drawable r10) {
        }
    }

    void clearAnimationCallbacks();

    void registerAnimationCallback(@NonNull AnimationCallback r10);

    boolean unregisterAnimationCallback(@NonNull AnimationCallback r10);
}
