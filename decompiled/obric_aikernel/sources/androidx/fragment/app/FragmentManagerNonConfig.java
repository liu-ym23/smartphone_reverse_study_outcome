package androidx.fragment.app;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelStore;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FragmentManagerNonConfig {

    @Nullable
    private final Map<String, FragmentManagerNonConfig> mChildNonConfigs;

    @Nullable
    private final Collection<Fragment> mFragments;

    @Nullable
    private final Map<String, ViewModelStore> mViewModelStores;

    FragmentManagerNonConfig(@Nullable Collection<Fragment> r10, @Nullable Map<String, FragmentManagerNonConfig> r11, @Nullable Map<String, ViewModelStore> r12) {
        this.mFragments = r10;
        this.mChildNonConfigs = r11;
        this.mViewModelStores = r12;
    }

    @Nullable
    Map<String, FragmentManagerNonConfig> getChildNonConfigs() {
        return this.mChildNonConfigs;
    }

    @Nullable
    Collection<Fragment> getFragments() {
        return this.mFragments;
    }

    @Nullable
    Map<String, ViewModelStore> getViewModelStores() {
        return this.mViewModelStores;
    }

    boolean isRetaining(Fragment r10) {
        Collection<Fragment> r11 = this.mFragments;
        if (r11 != null) goto L7;
        return false;
    L7:
        return r11.contains(r10);
    }
}
