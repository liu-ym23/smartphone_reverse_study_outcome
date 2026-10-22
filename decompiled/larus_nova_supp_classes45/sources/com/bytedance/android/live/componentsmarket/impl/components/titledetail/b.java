package com.bytedance.android.live.componentsmarket.impl.components.titledetail;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.config.b0;
import com.bytedance.ies.sdk.widgets.Widget;
import j70.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends n<d90.a> {
    @Override // j70.o
    public final boolean h() {
        return true;
    }

    public b() {
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return LiveTitleDetailWidget.class;
    }

    @Override // j70.d
    public final boolean B(h70.b r3) {
        d90.a r4 = (d90.a) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        if (b0.a() == true) goto L5;
    L7:
        boolean r5 = false;
    L9:
        return !r5;
    L5:
        if (d90.c.c(r4) == false) goto L7;
        r5 = true;
        goto L9
    }

    @Override // j70.d
    public final j70.f C(h70.b r2) {
        d90.a r3 = (d90.a) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r3.f.getClass();
        return d90.d.a.i2;
    }

    @Override // j70.d
    public final LayerIndex E(h70.b r2) {
        Intrinsics.checkNotNullParameter((d90.a) r2, "layerContext");
        return LayerIndex.INDEX_12;
    }

    @Override // j70.h
    public final ElementConstraint J(h70.b r2) {
        Intrinsics.checkNotNullParameter((d90.a) r2, "layerContext");
        ElementConstraint r3 = ElementConstraint.n;
        return ElementConstraint.b.a();
    }
}
