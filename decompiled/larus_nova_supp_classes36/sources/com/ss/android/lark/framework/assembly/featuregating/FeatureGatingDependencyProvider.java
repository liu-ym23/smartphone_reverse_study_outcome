package com.ss.android.lark.framework.assembly.featuregating;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.android.EntryPointAccessors;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(fdb.a.class)
public class FeatureGatingDependencyProvider implements fdb.a {

    public interface a {
        fdb.b getDependency();
    }

    public FeatureGatingDependencyProvider() {
    }

    public fdb.b getDependency() {
        return ((a) EntryPointAccessors.fromApplication(LarkContext.getApplication(), a.class)).getDependency();
    }
}
