package androidx.fragment.app;

import androidx.lifecycle.ViewModelStore;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FragmentManagerNonConfig {
    private final Map<String, FragmentManagerNonConfig> mChildNonConfigs;
    private final Collection<Fragment> mFragments;
    private final Map<String, ViewModelStore> mViewModelStores;

    FragmentManagerNonConfig(Collection<Fragment> r3, Map<String, FragmentManagerNonConfig> r4, Map<String, ViewModelStore> r5) {
        Collection<Fragment> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Map<String, FragmentManagerNonConfig> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Map<String, ViewModelStore> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        this.mFragments = r6;
        this.mChildNonConfigs = r7;
        this.mViewModelStores = r8;
    }

    Map<String, FragmentManagerNonConfig> getChildNonConfigs() {
        return this.mChildNonConfigs;
    }

    Collection<Fragment> getFragments() {
        return this.mFragments;
    }

    Map<String, ViewModelStore> getViewModelStores() {
        return this.mViewModelStores;
    }

    boolean isRetaining(Fragment r1) {
        Collection<Fragment> r0 = this.mFragments;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.contains(r1);
    }
}
