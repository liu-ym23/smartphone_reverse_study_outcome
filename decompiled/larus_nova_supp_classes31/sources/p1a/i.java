package p1a;

import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseSlotWidget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i extends f<BaseSlotWidget> {
    public int c;

    public i() {
    }

    public final void b(ComponentFeature r2) {
        BaseSlotWidget r3 = (BaseSlotWidget) r2;
        Intrinsics.checkNotNullParameter(r3, "feature");
        r3.k = this.c;
    }
}
