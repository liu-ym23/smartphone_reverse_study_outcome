package androidx.transition;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: loaded from: classes.dex */
public interface TransitionSeekController {
    void addOnProgressChangedListener(@NonNull Consumer<TransitionSeekController> r5);

    void addOnReadyListener(@NonNull Consumer<TransitionSeekController> r5);

    void animateToEnd();

    void animateToStart(@NonNull Runnable r5);

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    float getCurrentFraction();

    @IntRange(from = 0)
    long getCurrentPlayTimeMillis();

    @IntRange(from = 0)
    long getDurationMillis();

    boolean isReady();

    void removeOnProgressChangedListener(@NonNull Consumer<TransitionSeekController> r5);

    void removeOnReadyListener(@NonNull Consumer<TransitionSeekController> r5);

    void setCurrentFraction(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r5);

    void setCurrentPlayTimeMillis(@IntRange(from = 0) long r5);
}
