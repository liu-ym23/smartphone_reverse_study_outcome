package com.bytedance.android.live.profit.player;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.ies.sdk.widgets.Widget;
import com.lynx.tasm.LynxView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h extends b7.a {
    public final /* synthetic */ LynxAlphaPlayerWidget a;

    public h(LynxAlphaPlayerWidget r1) {
        this.a = r1;
    }

    public final void onLoadSuccess(View r5) {
        q r6 = this.a.f;
        if (r6 == null) goto L10;
        r6.c = System.currentTimeMillis();
        LynxAlphaPlayerWidget r7 = this.a;
        r7.getClass();
        ca0.q r0 = com.bytedance.android.live.revenue.core.util.f.a(IGiftService.class).getUICanvasMonitor();
        r7.g = r0;
        if (r0 == null) goto L7;
        r0.a();
    L7:
        ca0.q r8 = r7.g;
        if (r8 == null) goto L10;
        r8.start();
    L10:
        LynxAlphaPlayerWidget r9 = this.a;
        r9.getClass();
        ALogger.w("LynxAlphaPlayerWidget", "container loaded");
        HybridCard r1 = r9.a;
        if (r1 == null) goto L19;
        View r2 = ((Widget) r9).contentView;
        if (r2 == null) goto L18;
        ViewGroup r3 = (ViewGroup) r2;
        r3.removeAllViews();
        r1.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        r3.addView(r1);
        r9.wq();
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void onAttachView(View r2, IHybridComponent.HybridType r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "hybridType");
        LynxAlphaPlayerWidget r5 = this.a;
        int r6 = LynxAlphaPlayerWidget.i;
        r5.getClass();
        if (((Boolean) r.e.getValue(null, r.a[3])).booleanValue() == true) goto L6;
        return;
    L6:
        if ((r2 instanceof LynxView) == true) goto L8;
        r2 = null;
    L8:
        LynxView r7 = (LynxView) r2;
        if (r7 == null) goto L12;
        com.bytedance.android.live.revenue.core.util.f.a(IGiftService.class).injectLiveLynxCanvasTTPlayer(r7, r7.getContext(), "lynx_alpha_player");
        return;
    }

    public final void onContainerError(View r1, int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "errorMessage");
        LynxAlphaPlayerWidget r4 = this.a;
        int r5 = LynxAlphaPlayerWidget.i;
        r4.yq(r3);
    }

    public final void onLoadFail(View r1, String r2, String r3) {
        LynxAlphaPlayerWidget r4 = this.a;
        if (r3 != null) goto L5;
        r3 = "loadFail";
    L5:
        int r5 = LynxAlphaPlayerWidget.i;
        r4.yq(r3);
    }
}
