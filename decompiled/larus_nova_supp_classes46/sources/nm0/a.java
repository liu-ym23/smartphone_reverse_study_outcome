package nm0;

import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.messagewindow.tempdraggablewindow.TempDraggableTetris;
import d90.d;
import d90.e;
import h70.b;
import j70.f;
import j70.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends j<d> {
    public final Tetris<? extends b> b() {
        return new TempDraggableTetris();
    }

    public a() {
    }

    public final boolean B(b r2) {
        d r3 = (d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        return e.h(r3);
    }

    public final f C(b r2) {
        d r3 = (d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r3.f.getClass();
        return d.a.S1;
    }

    public final LayerIndex E(b r2) {
        Intrinsics.checkNotNullParameter((d) r2, "layerContext");
        return LayerIndex.INDEX_12;
    }

    public final ElementConstraint J(b r3) {
        Intrinsics.checkNotNullParameter((d) r3, "layerContext");
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
