package androidx.core.view;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
public interface MenuHost {
    void addMenuProvider(@NonNull MenuProvider r5);

    void addMenuProvider(@NonNull MenuProvider r5, @NonNull LifecycleOwner r10);

    @SuppressLint({"LambdaLast"})
    void addMenuProvider(@NonNull MenuProvider r5, @NonNull LifecycleOwner r10, @NonNull Lifecycle.State r11);

    void invalidateMenu();

    void removeMenuProvider(@NonNull MenuProvider r5);
}
