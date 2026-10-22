package com.bytedance.android.live.room.navi.tetris.desc;

import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.room.navi.tetris.AnchorRoomNavigatorTetris;
import j70.f;
import j70.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends j<d90.d> {

    /* JADX INFO: renamed from: com.bytedance.android.live.room.navi.tetris.desc.a$a, reason: collision with other inner class name */
    public static final class C0210a {
    }

    static {
    }

    public final Tetris<? extends h70.b> b() {
        return new AnchorRoomNavigatorTetris();
    }

    public a() {
    }

    public final boolean B(h70.b r2) {
        d90.d r3 = (d90.d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        if (d90.e.c(r3) == true) goto L5;
    L7:
        return false;
    L5:
        if (d90.e.h(r3) == false) goto L7;
        return true;
    }

    public final f C(h70.b r2) {
        d90.d r3 = (d90.d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r3.f.getClass();
        return d90.d.a.z2;
    }

    public final LayerIndex E(h70.b r2) {
        Intrinsics.checkNotNullParameter((d90.d) r2, "layerContext");
        return LayerIndex.INDEX_2;
    }

    public final double F(h70.b r3) {
        Intrinsics.checkNotNullParameter((d90.d) r3, "layerContext");
        return 0.1d;
    }

    public final ElementConstraint J(h70.b r3) {
        Intrinsics.checkNotNullParameter((d90.d) r3, "layerContext");
        ElementConstraint r4 = new ElementConstraint(-1.0f, 52.0f);
        ElementConstraint.Side r0 = ElementConstraint.Side.TOP;
        r4.d(r0, r0, 0.0f);
        return r4;
    }
}
