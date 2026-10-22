package com.bytedance.als.lazy;

import com.bytedance.als.LogicComponent;
import com.bytedance.als.b;
import com.bytedance.objectcontainer.InjectAware;
import com.bytedance.objectcontainer.ObjectContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00022\u00020\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/als/lazy/ALSInternalLazyHelperComponent;", "Lcom/bytedance/als/LogicComponent;", "", "Lcom/bytedance/objectcontainer/InjectAware;", "als_release"}, k = 1, mv = {1, 4, 1})
public final class ALSInternalLazyHelperComponent extends LogicComponent<Object> implements InjectAware, b {
    public final ALSInternalLazyHelperComponent c;
    public final ObjectContainer d;

    public final ObjectContainer a() {
        return this.d;
    }

    @Override // com.bytedance.als.LogicComponent
    public final b i() {
        return this.c;
    }

    public ALSInternalLazyHelperComponent(ObjectContainer r10) {
        Intrinsics.checkNotNullParameter(r10, "diContainer");
        this.d = r10;
        this.c = this;
    }
}
