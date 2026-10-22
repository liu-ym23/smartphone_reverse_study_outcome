package com.larus.ui.arch.component.external.delegate;

import com.larus.list.arch.IFlowListCell;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.tencent.open.log.TraceLevel;
import ei9.f;
import kotlin.Metadata;
import m1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/ui/arch/component/external/delegate/BaseComponentComposeCard;", "STATE", "Lcom/larus/list/arch/IFlowListCellState;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentComposableCard;", "<init>", "()V", "component_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public abstract class BaseComponentComposeCard<STATE extends f> extends ComponentFeature implements b {
    public BaseComponentComposeCard() {
    }

    public final Class<? extends IFlowListCell<?>> l1() {
        return IFlowListCell.class;
    }
}
