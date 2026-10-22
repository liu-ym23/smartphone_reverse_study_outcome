package p1a;

import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d extends f<BaseContentWidget> {
    public int c;

    public d() {
    }

    public final void b(ComponentFeature r2) {
        BaseContentWidget r3 = (BaseContentWidget) r2;
        Intrinsics.checkNotNullParameter(r3, "feature");
        r3.X2(this.c);
    }
}
