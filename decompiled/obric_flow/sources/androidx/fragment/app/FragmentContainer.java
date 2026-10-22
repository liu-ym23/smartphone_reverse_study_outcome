package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentContainer {
    public FragmentContainer() {
    }

    @NonNull
    @Deprecated
    public Fragment instantiate(@NonNull Context r5, @NonNull String r10, @Nullable Bundle r11) {
        return Fragment.instantiate(r5, r10, r11);
    }

    @Nullable
    public abstract View onFindViewById(@IdRes int r5);

    public abstract boolean onHasView();
}
