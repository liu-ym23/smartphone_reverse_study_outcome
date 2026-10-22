package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface ViewPropertyAnimatorListener {
    void onAnimationCancel(@NonNull View r10);

    void onAnimationEnd(@NonNull View r10);

    void onAnimationStart(@NonNull View r10);
}
