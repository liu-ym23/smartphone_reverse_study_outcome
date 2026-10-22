package com.bytedance.android.livesdk.chatroom.widget.landscape;

import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.utils.landscape.LandscapePhoneInfoShowUtils;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s extends j70.j<e0> {
    public final Tetris<? extends h70.b> b() {
        return new LandscapeTopPhoneInfoTetris();
    }

    public s() {
    }

    public final boolean B(h70.b r2) {
        e0 r3 = (e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        if (d90.c.c(r3) == false) goto L5;
    L9:
        return false;
    L5:
        if (d90.c.f(r3) == false) goto L9;
        if (LandscapePhoneInfoShowUtils.a(Boolean.valueOf(d90.c.h(r3))) == false) goto L9;
        return true;
    }

    public final j70.f C(h70.b r2) {
        e0 r3 = (e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        ((d90.d) r3).f.getClass();
        return d90.d.a.n0;
    }

    public final LayerIndex E(h70.b r2) {
        Intrinsics.checkNotNullParameter((e0) r2, "layerContext");
        return LayerIndex.INDEX_2;
    }

    public final double G(h70.b r3) {
        Intrinsics.checkNotNullParameter((e0) r3, "layerContext");
        return 1.1d;
    }

    public final ElementConstraint J(h70.b r4) {
        final e0 r5 = (e0) r4;
        Intrinsics.checkNotNullParameter(r5, "layerContext");
        if (d90.c.k(r5) == false) goto L6;
        return I(new LandscapeTopPhoneInfoDescriptor$generateConstraint$1(r5));
    L6:
        if (d90.e.b(r5) == false) goto L8;
        float r6 = 16.0f;
    L9:
        ElementConstraint r0 = new ElementConstraint(-1.0f, -2.0f);
        ElementConstraint.Side r1 = ElementConstraint.Side.TOP;
        r0.d(r1, r1, 0.0f);
        ElementConstraint.Side r2 = ElementConstraint.Side.LEFT;
        r0.d(r2, r2, r6);
        ElementConstraint.Side r3 = ElementConstraint.Side.RIGHT;
        r0.d(r3, r3, r6);
        return r0;
    L8:
        r6 = 8.0f;
        goto L9
    }
}
