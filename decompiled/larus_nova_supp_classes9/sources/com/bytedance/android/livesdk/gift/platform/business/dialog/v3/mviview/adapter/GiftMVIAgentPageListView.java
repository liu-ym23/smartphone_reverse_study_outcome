package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.CloseGiftPanelDialog;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ModifyDialogHeightEffect;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PagerListData;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIAgentPageListView extends com.bytedance.android.anya.c<PagerListData, GiftAction> {
    public zy0.b l;
    public final Lazy m;
    public final Context n;

    public final void s() {
        FrameLayout r0 = (FrameLayout) this.m.getValue();
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        zy0.b r1 = this.l;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        this.l = null;
    }

    public final void i() {
        s();
    }

    public final boolean d(com.bytedance.android.anya.a0 r5) {
        Intrinsics.checkNotNullParameter(r5, "e");
        if ((r5 instanceof CloseGiftPanelDialog) == false) goto L6;
        s();
    L17:
        return false;
    L6:
        if ((r5 instanceof ModifyDialogHeightEffect) == false) goto L17;
        FrameLayout r0 = (FrameLayout) this.m.getValue();
        if (r0 == null) goto L17;
        Intrinsics.checkNotNullParameter(r0, "$this$layoutMarginBottom");
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L12;
        r2 = null;
    L12:
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        if (r3 == null) goto L15;
        int r4 = r3.bottomMargin;
    L16:
        int r6 = com.bytedance.android.live.revenue.common.i.a;
        ViewUtilsKt.b(r0, r4 + com.bytedance.android.live.revenue.common.i.b(((ModifyDialogHeightEffect) r5).getHeightChange()));
        goto L17
    L15:
        r4 = 0;
        goto L16
    }

    public GiftMVIAgentPageListView(Context r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "currentContext");
        Intrinsics.checkNotNullParameter(r5, "parent");
        super(LayoutInflater.from(r5.getContext()).inflate(2131567027, r5, false));
        this.n = r4;
        this.m = LazyKt.lazy(new GiftMVIAgentPageListView$aiAgentContainerView$2(this));
    }

    public final void b(com.bytedance.android.anya.k r3, MVIState r4) {
        PagerListData r5 = (PagerListData) r4;
        Intrinsics.checkNotNullParameter(r3, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r5, "state");
        r0<PagerListData, Uri> r6 = r5.getPageSchemaUri();
        Object r0 = r3.c.a(r6);
        if (r0 == null) goto L19;
        r3.b.a.invoke(r6);
        Uri r1 = (Uri) r0;
        if (Intrinsics.areEqual(r1, Uri.EMPTY) == false) goto L8;
        return;
    L8:
        if (this.l == null) goto L10;
        s();
    L10:
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r7 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).q8(this.n, r1, null);
        this.l = r7;
        if (r7 == null) goto L20;
        FrameLayout r8 = (FrameLayout) this.m.getValue();
        if (r8 == null) goto L15;
        r8.addView(r7.c);
    L15:
        LinkedHashMap r9 = new LinkedHashMap();
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a.b r10 = r7.d;
        if (r10 == null) goto L21;
        r10.load(null, r9);
        return;
    L21:
        return;
    L20:
        return;
    }
}
