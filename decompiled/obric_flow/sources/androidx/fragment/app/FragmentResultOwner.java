package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
public interface FragmentResultOwner {
    void clearFragmentResult(@NonNull String r5);

    void clearFragmentResultListener(@NonNull String r5);

    void setFragmentResult(@NonNull String r5, @NonNull Bundle r10);

    void setFragmentResultListener(@NonNull String r5, @NonNull LifecycleOwner r10, @NonNull FragmentResultListener r11);
}
