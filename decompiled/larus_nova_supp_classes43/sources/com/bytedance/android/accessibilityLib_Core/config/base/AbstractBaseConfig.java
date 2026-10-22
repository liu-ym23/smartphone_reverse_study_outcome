package com.bytedance.android.accessibilityLib_Core.config.base;

import com.bytedance.android.accessibilityLib_Core.base.AccessiblityScope;
import com.bytedance.android.accessibilityLib_Core.config.bean.ViewVirtualNode;
import com.bytedance.android.accessibilityLib_Core.config.bean.b;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class AbstractBaseConfig implements IBaseConfig {
    public final Lazy a;
    public final b b;

    @Override // com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig
    public boolean enableLargeTouchArea() {
        return true;
    }

    @Override // com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig
    public final ViewVirtualNode getVirtualNode() {
        return (ViewVirtualNode) this.a.getValue();
    }

    @Override // com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig
    public int layoutRoot() {
        return -1;
    }

    @Override // com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig
    public String name() {
        return "default";
    }

    public AbstractBaseConfig() {
        this.a = LazyKt.lazy(AbstractBaseConfig$virtualNode$2.INSTANCE);
        this.b = new b(this);
    }

    @Override // com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig
    public final void build() {
        int r0 = layoutRoot();
        ViewVirtualNode r1 = getVirtualNode();
        r1.a = Integer.valueOf(r0);
        config(getVirtualNode());
    }

    @Override // com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig
    public AccessiblityScope getScope() {
        return AccessiblityScope.View;
    }
}
