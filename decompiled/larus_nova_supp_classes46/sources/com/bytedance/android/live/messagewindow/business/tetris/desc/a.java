package com.bytedance.android.live.messagewindow.business.tetris.desc;

import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.messagewindow.business.tetris.MsgWindowCardTetris;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.vscore_api.tab.MultiTabType;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.MultiTabManagerImpl;
import d90.e;
import j70.j;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import nm1.r;
import pm1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends j<d90.d> implements ru2.a<d90.d> {
    public final Tetris<? extends h70.b> b() {
        return new MsgWindowCardTetris();
    }

    public a() {
    }

    public final boolean A(h70.b r3) {
        d90.d r4 = (d90.d) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        r r0 = f.o();
        if (r0 == null) goto L9;
        r0.a();
        if (MultiTabManagerImpl.e.h(r4.h) != true) goto L9;
        if (e.h(r4) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean B(h70.b r3) {
        d90.d r4 = (d90.d) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        o r5 = z51.a.h(r4.h, 2);
        if (r5 == null) goto L8;
        Map r6 = r5.F2();
        if (r6 == null) goto L8;
        String r7 = (String) r6.put("hasCheckedLoadContainer", "1");
    L8:
        return v71.a.a();
    }

    public final j70.f C(h70.b r2) {
        d90.d r3 = (d90.d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r3.f.getClass();
        return d90.d.a.T1;
    }

    public final LayerIndex E(h70.b r2) {
        d90.d r3 = (d90.d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        if (v71.a.e() == false) goto L9;
        if (e.e(r3) == false) goto L14;
        return LayerIndex.INDEX_6;
    L14:
        return LayerIndex.INDEX_7;
    L9:
        if (e.e(r3) == false) goto L12;
        return LayerIndex.INDEX_5;
    L12:
        return LayerIndex.INDEX_6;
    }

    public final double F(h70.b r3) {
        Intrinsics.checkNotNullParameter((d90.d) r3, "layerContext");
        return 3.1d;
    }

    public final double H(h70.b r3) {
        Intrinsics.checkNotNullParameter((d90.d) r3, "layerContext");
        return 0.1d;
    }

    public final ElementConstraint J(h70.b r2) {
        final d90.d r3 = (d90.d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        if (e.i(r3) == true) goto L5;
    L7:
        ElementConstraint r4 = ElementConstraint.n;
        return ElementConstraint.b.a();
    L5:
        if (e.e(r3) == false) goto L7;
        return I(new MsgWindowCardTetrisDescription$generateConstraint$1(r3));
    }

    public final MultiTabType x(h70.b r2) {
        Intrinsics.checkNotNullParameter((d90.d) r2, "layerContext");
        return MultiTabType.PUBLIC_INTERACT_TAB;
    }
}
