package com.bytedance.android.live.room.discovery;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l0 extends j70.n<d90.a> {
    public final boolean h() {
        return true;
    }

    public l0() {
    }

    public final Class<? extends Widget> c() {
        return NetSpeedMonitorWidget.class;
    }

    public final boolean B(h70.b r3) {
        d90.a r4 = (d90.a) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        if (jr1.b.a(r4) == true) goto L5;
    L11:
        return false;
    L5:
        if (d90.c.o(r4) != LiveMode.VIDEO) goto L7;
    L10:
        return true;
    L7:
        if (d90.c.o(r4) == LiveMode.SCREEN_RECORD) goto L10;
        if (d90.c.o(r4) != LiveMode.MEDIA) goto L11;
        goto L10
    }

    public final j70.f C(h70.b r2) {
        d90.a r3 = (d90.a) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        ((d90.d) r3).f.getClass();
        return d90.d.a.W;
    }

    public final LayerIndex E(h70.b r2) {
        Intrinsics.checkNotNullParameter((d90.a) r2, "layerContext");
        return LayerIndex.INDEX_2;
    }

    public final double F(h70.b r3) {
        Intrinsics.checkNotNullParameter((d90.a) r3, "layerContext");
        return 1.1d;
    }

    public final ElementConstraint J(h70.b r5) {
        d90.a r6 = (d90.a) r5;
        Intrinsics.checkNotNullParameter(r6, "layerContext");
        ElementConstraint r0 = new ElementConstraint(-1.0f, 22.0f);
        ElementConstraint.Side r1 = ElementConstraint.Side.RIGHT;
        r0.d(r1, r1, 12.0f);
        ElementConstraint.Side r2 = ElementConstraint.Side.TOP;
        ((d90.d) r6).f.getClass();
        r0.b(r2, d90.d.a.z2, ElementConstraint.Side.BOTTOM, 0.0f);
        return r0;
    }
}
