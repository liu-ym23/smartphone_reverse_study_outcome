package com.bytedance.android.live.draggablecomponent;

import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.config.yo;
import com.bytedance.android.livesdk.config.z2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e extends j70.j<d90.a> {
    @Override // j70.k
    public final Tetris<? extends h70.b> b() {
        return new DraggableComponentTetris();
    }

    public e() {
    }

    @Override // j70.d
    public final boolean B(h70.b r2) {
        Intrinsics.checkNotNullParameter((d90.a) r2, "layerContext");
        int r3 = d.a;
        return Intrinsics.areEqual(((z2) yo.a.getValue()).b(), Boolean.TRUE);
    }

    @Override // j70.d
    public final j70.f C(h70.b r2) {
        d90.a r3 = (d90.a) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r3.f.getClass();
        return d90.d.a.W1;
    }

    @Override // j70.d
    public final LayerIndex E(h70.b r2) {
        Intrinsics.checkNotNullParameter((d90.a) r2, "layerContext");
        return LayerIndex.INDEX_12;
    }

    @Override // j70.h
    public final ElementConstraint J(h70.b r3) {
        Intrinsics.checkNotNullParameter((d90.a) r3, "layerContext");
        ElementConstraint r4 = new ElementConstraint(-1.0f, -1.0f);
        ElementConstraint.Side r0 = ElementConstraint.Side.TOP;
        r4.d(r0, r0, 128.0f);
        ElementConstraint.Side r1 = ElementConstraint.Side.RIGHT;
        r4.d(r1, r1, 0.0f);
        ElementConstraint.Side r2 = ElementConstraint.Side.BOTTOM;
        r4.d(r2, r2, 52.0f);
        return r4;
    }
}
