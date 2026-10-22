package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.common.p0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.CloseGiftPanelDialog;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftLynxPageConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ModifyDialogHeightEffect;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PagerListData;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVILynxPageView extends com.bytedance.android.anya.c<PagerListData, GiftAction> {
    public final String l;
    public zy0.b m;
    public GiftLynxPageConfig n;
    public final Lazy o;
    public final Context p;

    public final void t() {
        FrameLayout r0 = (FrameLayout) this.o.getValue();
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        zy0.b r1 = this.m;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        this.m = null;
    }

    public final void i() {
        t();
    }

    public final boolean d(com.bytedance.android.anya.a0 r5) {
        Intrinsics.checkNotNullParameter(r5, "e");
        if ((r5 instanceof CloseGiftPanelDialog) == false) goto L6;
        t();
    L17:
        return false;
    L6:
        if ((r5 instanceof ModifyDialogHeightEffect) == false) goto L17;
        FrameLayout r0 = (FrameLayout) this.o.getValue();
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

    public final void s(GiftLynxPageConfig r5) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L20
        jy0.b.d(this.l, "loadSchema start " + r5.getPageType() + ", " + r5.getPageSchema());     // Catch: Throwable -> L20
        Uri r0 = UriProtector.parse(r5.getPageSchema());     // Catch: Throwable -> L20
        if (this.m == null) goto L6;
        t();     // Catch: Throwable -> L20
    L6:
        Unit r3 = null;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r2 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).q8(this.p, r0, null);     // Catch: Throwable -> L20
        this.m = r2;     // Catch: Throwable -> L20
        if (r2 == null) goto L18;
        FrameLayout r4 = (FrameLayout) this.o.getValue();     // Catch: Throwable -> L20
        if (r4 == null) goto L11;
        r4.addView(r2.c);     // Catch: Throwable -> L20
    L11:
        LinkedHashMap r6 = new LinkedHashMap();     // Catch: Throwable -> L20
        Integer r7 = r5.getPageType();     // Catch: Throwable -> L20
        if (r7 == null) goto L14;
        int r8 = r7.intValue();     // Catch: Throwable -> L20
    L15:
        r6.put("page_type", Integer.valueOf(r8));     // Catch: Throwable -> L20
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a.b r9 = r2.d;     // Catch: Throwable -> L20
        if (r9 == null) goto L18;
        r9.load(null, r6);     // Catch: Throwable -> L20
        r3 = Unit.INSTANCE;     // Catch: Throwable -> L20
        goto L18
    L14:
        r8 = 0;
    L18:
        Object r10 = Result.constructor-impl(r3);     // Catch: Throwable -> L20
    L22:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L28;
        jy0.b.d(this.l, "loadSchema error, " + Log.getStackTraceString(r11));
        return;
    L28:
        return;
    L20:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }

    public GiftMVILynxPageView(Context r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "currentContext");
        Intrinsics.checkNotNullParameter(r5, "parent");
        super(LayoutInflater.from(r5.getContext()).inflate(2131567029, r5, false));
        this.p = r4;
        this.l = "GiftMVILynxPageView";
        this.o = LazyKt.lazy(new GiftMVILynxPageView$containerView$2(this));
    }

    public final void b(com.bytedance.android.anya.k r8, MVIState r9) {
        PagerListData r10 = (PagerListData) r9;
        Intrinsics.checkNotNullParameter(r8, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r10, "state");
        r0<PagerListData, GiftLynxPageConfig> r11 = r10.getPageLynxConfig();
        Object r0 = r8.c.a(r11);
        if (r0 == null) goto L25;
        r8.b.a.invoke(r11);
        final GiftLynxPageConfig r1 = (GiftLynxPageConfig) r0;
        String r13 = r1.getPageSchema();
        if (r13 != null) goto L7;
    L10:
        boolean r14 = true;
    L11:
        if (r14 == true) goto L27;
        GiftLynxPageConfig r15 = this.n;
        if (r15 == null) goto L20;
        Intrinsics.checkNotNull(r15);
        if (Intrinsics.areEqual(r15.getPageType(), r1.getPageType()) == false) goto L20;
        GiftLynxPageConfig r16 = this.n;
        Intrinsics.checkNotNull(r16);
        if (Intrinsics.areEqual(r16.getPageSchema(), r1.getPageSchema()) == false) goto L20;
        return;
    L20:
        this.n = r1;
        if (com.bytedance.android.livesdk.gift.platform.core.h.n().l() == false) goto L23;
        jy0.b.d(this.l, "loadSchema now");
        s(r1);
        return;
    L23:
        long r2 = com.bytedance.android.livesdk.gift.platform.core.h.n().k();
        jy0.b.d(this.l, "loadSchema lazy " + r2);
        p0.a(r2, false, false, new GiftMVILynxPageView$handleDiff$$inlined$select$lambda$1(r1, this), 6);
        return;
    L27:
        return;
    L7:
        if (r13.length() == 0) goto L10;
        r14 = false;
        goto L11
    }
}
