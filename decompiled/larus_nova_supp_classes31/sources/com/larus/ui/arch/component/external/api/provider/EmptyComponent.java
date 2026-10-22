package com.larus.ui.arch.component.external.api.provider;

import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/ui/arch/component/external/api/provider/EmptyComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "<init>", "()V", "component_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class EmptyComponent extends ComponentFeature {
    public static final EmptyComponent h = null;

    static {
        h = new EmptyComponent();
    }

    private EmptyComponent() {
    }
}
