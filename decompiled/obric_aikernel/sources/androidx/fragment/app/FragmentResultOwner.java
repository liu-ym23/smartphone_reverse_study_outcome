package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
public interface FragmentResultOwner {
    void clearFragmentResult(@NonNull String r10);

    void clearFragmentResultListener(@NonNull String r10);

    void setFragmentResult(@NonNull String r10, @NonNull Bundle r11);

    void setFragmentResultListener(@NonNull String r10, @NonNull LifecycleOwner r11, @NonNull FragmentResultListener r12);
}
