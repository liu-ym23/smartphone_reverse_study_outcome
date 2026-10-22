package com.bytedance.android.live.room.discovery.inspector;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.Widget;
import j70.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m extends n<d90.a> {
    public final boolean h() {
        return false;
    }

    public m() {
    }

    public final f70.b L() {
        return mg2.e.e;
    }

    public final Class<? extends Widget> c() {
        return OfficialInspectorWidget.class;
    }

    public final boolean B(h70.b r2) {
        d90.a r3 = (d90.a) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        if (jr1.b.a(r3) == true) goto L5;
    L7:
        return false;
    L5:
        if (d90.c.o(r3) != LiveMode.VIDEO) goto L7;
        return true;
    }

    public final j70.f C(h70.b r2) {
        d90.a r3 = (d90.a) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        ((d90.d) r3).f.getClass();
        return d90.d.a.I1;
    }

    public final LayerIndex E(h70.b r2) {
        Intrinsics.checkNotNullParameter((d90.a) r2, "layerContext");
        return LayerIndex.INDEX_5;
    }

    public final ElementConstraint J(h70.b r3) {
        Intrinsics.checkNotNullParameter((d90.a) r3, "layerContext");
        ElementConstraint r4 = new ElementConstraint(-2.0f, -2.0f);
        ElementConstraint.Side r0 = ElementConstraint.Side.RIGHT;
        r4.d(r0, r0, 8.0f);
        ElementConstraint.Side r1 = ElementConstraint.Side.TOP;
        r4.d(r1, r1, 0.0f);
        return r4;
    }
}
