package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface ViewPropertyAnimatorListener {
    void onAnimationCancel(@NonNull View r5);

    void onAnimationEnd(@NonNull View r5);

    void onAnimationStart(@NonNull View r5);
}
