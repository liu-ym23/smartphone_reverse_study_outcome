package com.obric.assistant.component;

import com.larus.minor.api.IMinorService;
import com.larus.ui.arch.component.external.delegate.BaseComponentWidget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/assistant/component/ObricLegacyComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseComponentWidget;", "Lcom/larus/ui/arch/context/external/EmptyVWidgetData;", "<init>", "()V", "onCreateView", "", "onStart", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricLegacyComponent extends BaseComponentWidget<Object> {
    public final void S1() {
    }

    public final void onStart() {
        if (IMinorService.a.a() == false) goto L8;
        ry8.b r0 = s1a.d.a(this).getAbility(ry8.b.class);
        if (r0 == null) goto L9;
        r0.va();
        return;
    L9:
        return;
    }

    public ObricLegacyComponent() {
    }
}
