package androidx.core.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class GestureDetectorCompat {
    private final GestureDetector mDetector;

    public GestureDetectorCompat(@NonNull Context r5, @NonNull GestureDetector.OnGestureListener r10) {
        this(r5, r10, null);
    }

    public boolean isLongpressEnabled() {
        return this.mDetector.isLongpressEnabled();
    }

    public boolean onTouchEvent(@NonNull MotionEvent r5) {
        return this.mDetector.onTouchEvent(r5);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setIsLongpressEnabled(boolean r5) {
        this.mDetector.setIsLongpressEnabled(r5);
    }

    public void setOnDoubleTapListener(@Nullable GestureDetector.OnDoubleTapListener r5) {
        this.mDetector.setOnDoubleTapListener(r5);
    }

    public GestureDetectorCompat(@NonNull Context r5, @NonNull GestureDetector.OnGestureListener r10, @Nullable Handler r11) {
        this.mDetector = new GestureDetector(r5, r10, r11);
    }
}
