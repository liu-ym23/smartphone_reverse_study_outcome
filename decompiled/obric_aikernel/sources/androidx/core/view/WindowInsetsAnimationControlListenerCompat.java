package androidx.core.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface WindowInsetsAnimationControlListenerCompat {
    void onCancelled(@Nullable WindowInsetsAnimationControllerCompat r10);

    void onFinished(@NonNull WindowInsetsAnimationControllerCompat r10);

    void onReady(@NonNull WindowInsetsAnimationControllerCompat r10, int r11);
}
