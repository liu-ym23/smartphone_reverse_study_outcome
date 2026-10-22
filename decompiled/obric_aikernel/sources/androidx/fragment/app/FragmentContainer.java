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
    public Fragment instantiate(@NonNull Context r10, @NonNull String r11, @Nullable Bundle r12) {
        return Fragment.instantiate(r10, r11, r12);
    }

    @Nullable
    public abstract View onFindViewById(@IdRes int r10);

    public abstract boolean onHasView();
}
