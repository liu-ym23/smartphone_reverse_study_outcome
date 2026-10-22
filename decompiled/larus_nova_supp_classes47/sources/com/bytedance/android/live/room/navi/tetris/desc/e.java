package com.bytedance.android.live.room.navi.tetris.desc;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.room.navi.landtoptool.LandscapeTopToolbarWidget;
import com.bytedance.android.livesdk.utils.landscape.LandscapePhoneInfoShowUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import j70.f;
import j70.g;
import j70.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e extends n<d90.d> {
    public final boolean h() {
        return false;
    }

    public e() {
    }

    public final Class<? extends Widget> c() {
        return LandscapeTopToolbarWidget.class;
    }

    public final boolean B(h70.b r2) {
        d90.d r3 = (d90.d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        if (d90.e.c(r3) == false) goto L5;
    L7:
        return false;
    L5:
        if (d90.e.e(r3) == false) goto L7;
        return true;
    }

    public final f C(h70.b r2) {
        d90.d r3 = (d90.d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r3.f.getClass();
        return d90.d.a.Q0;
    }

    public final LayerIndex E(h70.b r2) {
        d90.d r3 = (d90.d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        if (d90.e.i(r3) == false) goto L6;
        return LayerIndex.INDEX_2;
    L6:
        return LayerIndex.INDEX_4;
    }

    public final ElementConstraint J(h70.b r7) {
        d90.d r8 = (d90.d) r7;
        Intrinsics.checkNotNullParameter(r8, "layerContext");
        boolean r0 = LandscapePhoneInfoShowUtils.a(Boolean.valueOf(d90.e.g(r8)));
        float r2 = 12.0f;
        if (d90.e.i(r8) == false) goto L9;
        ElementConstraint r1 = new ElementConstraint(-2.0f, -2.0f);
        ElementConstraint.Side r3 = ElementConstraint.Side.RIGHT;
        r8.f.getClass();
        g r4 = d90.d.a.f1;
        r1.b(r3, r4, r3, 12.0f);
        ElementConstraint.Side r5 = ElementConstraint.Side.TOP;
        r8.f.getClass();
        if (r0 == false) goto L7;
        float r9 = 16.0f;
    L8:
        r1.b(r5, r4, r5, r9);
    L25:
        return r1;
    L7:
        r9 = 8.0f;
        goto L8
    L9:
        Intrinsics.checkNotNullParameter(r8, "$this$isMiddlewareFromLongerVideoLandscape");
        DataCenter r6 = r8.h;
        if (r6 == null) goto L14;
        Boolean r10 = (Boolean) r6.get("data_longer_video_within_live_type", Boolean.FALSE);
        if (r10 == null) goto L14;
        boolean r12 = r10.booleanValue();
    L15:
        if (r12 == false) goto L18;
    L19:
        float r13 = 0.0f;
    L21:
        r1 = new ElementConstraint(-2.0f, -2.0f);
        ElementConstraint.Side r14 = ElementConstraint.Side.RIGHT;
        r1.d(r14, r14, r13);
        ElementConstraint.Side r15 = ElementConstraint.Side.TOP;
        if (r0 == false) goto L24;
        r2 = 20.0f;
    L24:
        r1.d(r15, r15, r2);
        goto L25
    L18:
        if (d90.e.f(r8) == true) goto L19;
        r13 = 14.0f;
    L14:
        r12 = false;
        goto L15
    }
}
