package com.bytedance.android.live.profit.livepet.container;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d extends j70.n<d90.d> {
    public static final d c = null;

    public final boolean h() {
        return true;
    }

    static {
        c = new d();
    }

    public d() {
    }

    public final Class<? extends Widget> c() {
        return LivePetContainerWidget.class;
    }

    public final boolean B(h70.b r2) {
        d90.d r3 = (d90.d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        return d90.f.a(r3);
    }

    public final j70.f C(h70.b r2) {
        d90.d r3 = (d90.d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r3.f.getClass();
        return d90.d.a.w2;
    }

    public final LayerIndex E(h70.b r2) {
        Intrinsics.checkNotNullParameter((d90.d) r2, "layerContext");
        return LayerIndex.INDEX_3;
    }

    public final ElementConstraint J(h70.b r2) {
        Intrinsics.checkNotNullParameter((d90.d) r2, "layerContext");
        ElementConstraint r3 = ElementConstraint.n;
        return ElementConstraint.b.a();
    }
}
