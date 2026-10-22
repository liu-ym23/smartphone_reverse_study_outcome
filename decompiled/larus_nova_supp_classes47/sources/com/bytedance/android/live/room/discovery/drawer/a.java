package com.bytedance.android.live.room.discovery.drawer;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import j70.n;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends n<d90.a> {
    public final boolean h() {
        return true;
    }

    public a() {
    }

    public final Class<? extends Widget> c() {
        return NewLiveDrawerEntranceWidget.class;
    }

    public final boolean B(h70.b r6) {
        d90.a r7 = (d90.a) r6;
        Intrinsics.checkNotNullParameter(r7, "layerContext");
        Intrinsics.checkNotNullParameter(r7, "$this$isFromPreviewLiveMix");
        DataCenter r1 = ((d90.d) r7).h;
        boolean r2 = false;
        if (r1 == null) goto L7;
        Boolean r3 = (Boolean) r1.get("data_is_enter_from_preview_live_mix", Boolean.FALSE);
        if (r3 == null) goto L7;
        boolean r4 = r3.booleanValue();
    L8:
        if (r4 == false) goto L11;
    L27:
        return r2;
    L11:
        if (d90.c.l(r7) == false) goto L16;
        if (d90.c.m(r7) == true) goto L16;
        Intrinsics.checkNotNullParameter(r7, "layerContext");
        ((d90.d) r7).f.getClass();
        d90.c.b(r7, d90.d.a.U, false);
    L16:
        if (d90.c.i(r7) == true) goto L18;
    L26:
        Intrinsics.checkNotNullParameter(r7, "layerContext");
        ((d90.d) r7).f.getClass();
        d90.c.b(r7, d90.d.a.U, r2);
        goto L27
    L18:
        if (((IRoomService) k.n(IRoomService.class)).isDrawerEnable(d90.c.q(r7)) == false) goto L26;
        if (d90.e.b(r7) == false) goto L25;
        z70.b r5 = ((h70.b) r7).a;
        if (r5 == null) goto L26;
        ((d90.d) r7).f.getClass();
        if (r5.d(d90.d.a.A2) != true) goto L26;
    L25:
        r2 = true;
    L7:
        r4 = false;
        goto L8
    }

    public final j70.f C(h70.b r2) {
        d90.a r3 = (d90.a) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        ((d90.d) r3).f.getClass();
        return d90.d.a.U;
    }

    public final LayerIndex E(h70.b r2) {
        Intrinsics.checkNotNullParameter((d90.a) r2, "layerContext");
        return LayerIndex.INDEX_2;
    }

    public final double G(h70.b r3) {
        Intrinsics.checkNotNullParameter((d90.a) r3, "layerContext");
        return 1.1d;
    }

    public final double H(h70.b r3) {
        Intrinsics.checkNotNullParameter((d90.a) r3, "layerContext");
        return 1.1d;
    }

    public final ElementConstraint J(h70.b r5) {
        d90.a r6 = (d90.a) r5;
        Intrinsics.checkNotNullParameter(r6, "layerContext");
        ElementConstraint r0 = new ElementConstraint(0.0f, 3);
        ElementConstraint.Side r1 = ElementConstraint.Side.RIGHT;
        r0.d(r1, r1, 0.0f);
        ElementConstraint.Side r2 = ElementConstraint.Side.TOP;
        ((d90.d) r6).f.getClass();
        r0.b(r2, d90.d.a.z2, ElementConstraint.Side.BOTTOM, 0.0f);
        return r0;
    }
}
