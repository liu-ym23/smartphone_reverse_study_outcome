package com.bytedance.android.live.room.navi.tetris.desc;

import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.room.navi.tetris.LandscapeNavigatorTetris;
import com.bytedance.android.livesdk.utils.landscape.LandscapePhoneInfoShowUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import j70.f;
import j70.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends j<d90.d> {
    public final Tetris<? extends h70.b> b() {
        return new LandscapeNavigatorTetris();
    }

    public c() {
    }

    public final boolean B(h70.b r5) {
        d90.d r6 = (d90.d) r5;
        Intrinsics.checkNotNullParameter(r6, "layerContext");
        if (d90.e.e(r6) == true) goto L5;
        return false;
    L5:
        if (com.bytedance.android.livesdk.utils.landscape.d.b(d90.e.k(r6)) == true) goto L15;
        z70.b r0 = ((h70.b) r6).a;
        if (r0 == null) goto L10;
        r6.f.getClass();
        if (r0.d(d90.d.a.B2) == true) goto L15;
    L10:
        Room r7 = d90.e.j(r6);
        if (r7 == null) goto L13;
        boolean r8 = r7.isMediaRoom();
    L14:
        if (r8 == true) goto L15;
        return false;
    L13:
        r8 = false;
    L15:
        return true;
    }

    public final f C(h70.b r2) {
        d90.d r3 = (d90.d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r3.f.getClass();
        return d90.d.a.l0;
    }

    public final LayerIndex E(h70.b r2) {
        Intrinsics.checkNotNullParameter((d90.d) r2, "layerContext");
        return LayerIndex.INDEX_2;
    }

    public final ElementConstraint J(h70.b r5) {
        final d90.d r6 = (d90.d) r5;
        Intrinsics.checkNotNullParameter(r6, "layerContext");
        final boolean r0 = LandscapePhoneInfoShowUtils.a(Boolean.valueOf(d90.e.g(r6)));
        if (d90.e.i(r6) == true) goto L24;
        z70.b r1 = ((h70.b) r6).a;
        if (r1 == null) goto L9;
        r6.f.getClass();
        if (r1.d(d90.d.a.B2) != true) goto L9;
    L15:
        float r2 = 10.0f;
    L17:
        if (d90.e.f(r6) == false) goto L19;
        float r7 = 0.0f;
    L20:
        if (r0 == false) goto L22;
        r2 = 20.0f;
    L22:
        ElementConstraint r3 = new ElementConstraint(0.0f, 3);
        ElementConstraint.Side r4 = ElementConstraint.Side.TOP;
        r3.d(r4, r4, r2);
        ElementConstraint.Side r8 = ElementConstraint.Side.LEFT;
        r3.d(r8, r8, r7);
        return r3;
    L19:
        r7 = 8.0f;
    L9:
        Room r9 = d90.e.j(r6);
        int r10 = com.bytedance.android.livesdk.utils.landscape.d.a;
        if (r9 == null) goto L12;
        boolean r12 = r9.isMediaRoom();
    L13:
        if (r12 == false) goto L15;
        r2 = 12.0f;
        goto L17
    L12:
        r12 = false;
        goto L13
    L24:
        return I(new LandNaviTetrisDescriptor$generateConstraint$1(r6, r0));
    }
}
