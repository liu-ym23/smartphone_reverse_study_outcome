package com.bytedance.android.live.room.discovery.drawer;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import j70.n;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i extends n<d90.a> {

    public static final class a {
    }

    static {
    }

    public final boolean h() {
        return true;
    }

    public i() {
    }

    public final Class<? extends Widget> c() {
        return VSRoomLandscapeLiveDrawerEntranceWidget.class;
    }

    public final boolean B(h70.b r4) {
        d90.a r5 = (d90.a) r4;
        Intrinsics.checkNotNullParameter(r5, "layerContext");
        boolean r1 = false;
        if (d90.c.f(r5) == true) goto L5;
    L18:
        ALogger.i("VSRoomLandscapeDrawerEntranceDescriptor", "canLoad: " + r1);
        return r1;
    L5:
        if (jr1.b.c(r5) == false) goto L18;
        if (((IRoomService) k.n(IRoomService.class)).isDrawerEnable(d90.c.q(r5)) == false) goto L18;
        if (d90.c.a(r5) == false) goto L18;
        Intrinsics.checkNotNullParameter(r5, "$this$isFromPreviewLiveMix");
        DataCenter r6 = ((d90.d) r5).h;
        if (r6 == null) goto L15;
        Boolean r7 = (Boolean) r6.get("data_is_enter_from_preview_live_mix", Boolean.FALSE);
        if (r7 == null) goto L15;
        boolean r8 = r7.booleanValue();
    L16:
        if (r8 == true) goto L18;
        r1 = true;
    L15:
        r8 = false;
        goto L16
    }

    public final j70.f C(h70.b r2) {
        d90.a r3 = (d90.a) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        ((d90.d) r3).f.getClass();
        return d90.d.a.s2;
    }

    public final LayerIndex E(h70.b r2) {
        Intrinsics.checkNotNullParameter((d90.a) r2, "layerContext");
        return LayerIndex.INDEX_2;
    }

    public final ElementConstraint J(h70.b r2) {
        final d90.a r3 = (d90.a) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        return I(new VSRoomLandscapeDrawerEntranceDescriptor$generateConstraint$1(r3));
    }
}
