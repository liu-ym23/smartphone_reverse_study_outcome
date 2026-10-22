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

    public FragmentManagerNonConfig(@Nullable Collection<Fragment> r5, @Nullable Map<String, FragmentManagerNonConfig> r10, @Nullable Map<String, ViewModelStore> r11) {
        this.mFragments = r5;
        this.mChildNonConfigs = r10;
        this.mViewModelStores = r11;
    }

    @Nullable
    public Map<String, FragmentManagerNonConfig> getChildNonConfigs() {
        return this.mChildNonConfigs;
    }

    @Nullable
    public Collection<Fragment> getFragments() {
        return this.mFragments;
    }

    @Nullable
    public Map<String, ViewModelStore> getViewModelStores() {
        return this.mViewModelStores;
    }

    public boolean isRetaining(Fragment r5) {
        Collection<Fragment> r10 = this.mFragments;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.contains(r5);
    }
}
