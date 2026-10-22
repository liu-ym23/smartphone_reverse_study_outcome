package com.google.android.material.color;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface ColorResourcesOverride {
    @Nullable
    static ColorResourcesOverride getInstance() {
        int r5 = Build.VERSION.SDK_INT;
        if (r5 > 33) goto L7;
        return ResourcesLoaderColorResourcesOverride.getInstance();
    L7:
        if (r5 >= 34) goto L9;
        return null;
    L9:
        return ResourcesLoaderColorResourcesOverride.getInstance();
    }

    boolean applyIfPossible(@NonNull Context r5, @NonNull Map<Integer, Integer> r10);

    @NonNull
    Context wrapContextIfPossible(@NonNull Context r5, @NonNull Map<Integer, Integer> r10);
}
