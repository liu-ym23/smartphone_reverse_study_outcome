package com.bytedance.android.live.room.navi.tetris.desc;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.room.navi.tetris.LandscapeRoomNavigatorTetris;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyContext;
import com.bytedance.android.livesdk.utils.landscape.LandscapePhoneInfoShowUtils;
import j70.f;
import j70.j;
import jc1.k;
import ju1.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d extends j<d90.d> {

    public static final class a {
    }

    static {
    }

    public final Tetris<? extends h70.b> b() {
        return new LandscapeRoomNavigatorTetris();
    }

    public d() {
    }

    public final boolean B(h70.b r3) {
        d90.d r4 = (d90.d) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        boolean r0 = jr1.b.a(r4);
        boolean r1 = d90.e.h(r4);
        boolean r5 = d90.e.d(r4);
        if (r0 == true) goto L7;
        if (r1 == true) goto L7;
        if (r5 == true) goto L7;
        return true;
    L7:
        return false;
    }

    public final f C(h70.b r2) {
        d90.d r3 = (d90.d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r3.f.getClass();
        return d90.d.a.G2;
    }

    public final LayerIndex E(h70.b r2) {
        Intrinsics.checkNotNullParameter((d90.d) r2, "layerContext");
        return LayerIndex.INDEX_2;
    }

    public final double G(h70.b r7) {
        d90.d r8 = (d90.d) r7;
        Intrinsics.checkNotNullParameter(r8, "layerContext");
        Intrinsics.checkNotNullParameter(r8, "$this$loadMiddlewareStrategy");
        IRoomContextService r0 = k.f(IRoomContextService.class);
        int r1 = 0;
        if (r0 == null) goto L16;
        o r2 = IRoomContextService.a.a(r0, r8.h, 0, 2);
        if (r2 == null) goto L16;
        com.bytedance.live.datacontext.j r3 = r2.r2();
        if (r3 == null) goto L16;
        IDynamicStrategyContext r4 = (IDynamicStrategyContext) r3.getValue();
        if (r4 == null) goto L16;
        PropertyOwner r5 = r4.getStrategy("live_component_strategy");
        if (r5 == null) goto L16;
        n r6 = (n) r5.a;
        if (r6 == null) goto L16;
        r1 = r6.b(0);
    L16:
        if (r1 != 101) goto L18;
        return 0.1d;
    L18:
        super/*j70.h*/.G(r8);
        return 3.9d;
    }

    public final ElementConstraint J(h70.b r4) {
        final d90.d r5 = (d90.d) r4;
        Intrinsics.checkNotNullParameter(r5, "layerContext");
        final boolean r0 = LandscapePhoneInfoShowUtils.a(Boolean.valueOf(d90.e.g(r5)));
        if (com.bytedance.android.livesdk.utils.landscape.d.b(d90.e.k(r5)) == true) goto L11;
        ElementConstraint r6 = new ElementConstraint(-1.0f, 52.0f);
        ElementConstraint.Side r1 = ElementConstraint.Side.TOP;
        if (r0 == false) goto L8;
        float r2 = 10.0f;
    L9:
        r6.d(r1, r1, r2);
        return r6;
    L8:
        r2 = 0.0f;
        goto L9
    L11:
        return I(new LandscapeRoomNavigatorTetrisDescriptor$generateConstraint$1(r5, r0));
    }
}
