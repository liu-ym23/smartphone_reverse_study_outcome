package androidx.core.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface WindowInsetsAnimationControlListenerCompat {
    void onCancelled(@Nullable WindowInsetsAnimationControllerCompat r5);

    void onFinished(@NonNull WindowInsetsAnimationControllerCompat r5);

    void onReady(@NonNull WindowInsetsAnimationControllerCompat r5, int r10);
}
