package com.bytedance.android.live.messagewindow.business.tetris.desc;

import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.messagewindow.business.tetris.TopRightWindowCardTetris;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.config.yh0;
import com.bytedance.android.livesdk.vscore_api.tab.MultiTabType;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.MultiTabManagerImpl;
import d90.e;
import j70.j;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import nm1.r;
import pm1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends j<d90.d> implements ru2.a<d90.d> {
    public final Tetris<? extends h70.b> b() {
        return new TopRightWindowCardTetris();
    }

    public c() {
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

    public final boolean B(h70.b r4) {
        d90.d r5 = (d90.d) r4;
        Intrinsics.checkNotNullParameter(r5, "layerContext");
        o r0 = z51.a.h(r5.h, 2);
        if (r0 == null) goto L8;
        Map r1 = r0.F2();
        if (r1 == null) goto L8;
        String r2 = (String) r1.put("hasCheckedLoadContainer", "1");
    L8:
        if (m71.e.d() == true) goto L10;
    L12:
        return false;
    L10:
        if (e.h(r5) == false) goto L12;
        return true;
    }

    public final j70.f C(h70.b r2) {
        d90.d r3 = (d90.d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r3.f.getClass();
        return d90.d.a.V1;
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
        return 2.1d;
    }

    public final double H(h70.b r3) {
        Intrinsics.checkNotNullParameter((d90.d) r3, "layerContext");
        return 0.1d;
    }

    public final ElementConstraint J(h70.b r3) {
        d90.d r4 = (d90.d) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        float r1 = 128.0f;
        if (((Boolean) yh0.a.getValue()).booleanValue() == true) goto L5;
    L11:
        ElementConstraint r5 = new ElementConstraint(-1.0f, -1.0f);
        ElementConstraint.Side r0 = ElementConstraint.Side.TOP;
        r5.d(r0, r0, r1);
        ElementConstraint.Side r2 = ElementConstraint.Side.BOTTOM;
        r5.d(r2, r2, 52.0f);
        return r5;
    L5:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L11;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L11;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L11;
        r1 = 128.0f + UtilityKotlinExtentionsKt.k(StatusBarUtil.getStatusBarHeight(r4.getContext()));
        goto L11
    }

    public final MultiTabType x(h70.b r2) {
        Intrinsics.checkNotNullParameter((d90.d) r2, "layerContext");
        return MultiTabType.PUBLIC_INTERACT_TAB;
    }
}
