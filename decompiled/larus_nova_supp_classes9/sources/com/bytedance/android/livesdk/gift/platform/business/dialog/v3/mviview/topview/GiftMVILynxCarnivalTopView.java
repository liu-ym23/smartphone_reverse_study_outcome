package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.BaseHybridComponentContainer;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftMVICarnivalViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVILynxCarnivalTopView extends BaseGiftMVIViewChildNode<GiftTopViewState, GiftMVICarnivalViewState, GiftAction> {
    public ViewGroup m;
    public zy0.b n;

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return 2131567538;
    }

    public final void i() {
        ViewGroup r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        r0.removeAllViews();
        zy0.b r1 = this.n;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    public final void g() {
        this.m = (ViewGroup) r().findViewById(2131373750);
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftTopViewState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVILynxCarnivalTopView$bindToParent$1 r0 = GiftMVILynxCarnivalTopView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public GiftMVILynxCarnivalTopView(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        super(r2, r3);
    }

    public final void b(com.bytedance.android.anya.k r4, MVIState r5) {
        GiftMVICarnivalViewState r6 = (GiftMVICarnivalViewState) r5;
        Intrinsics.checkNotNullParameter(r4, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r6, "state");
        r0<GiftMVICarnivalViewState, Map<String, Object>> r7 = r6.getLynxParams();
        Object r0 = r4.c.a(r7);
        if (r0 == null) goto L25;
        r4.b.a.invoke(r7);
        Map r1 = (Map) r0;
        if (r1.isEmpty() == false) goto L7;
        return;
    L7:
        if (nz1.a.b().a() == false) goto L32;
        zy0.b r8 = this.n;
        if (r8 == null) goto L15;
        xy0.a r9 = r8.g();
        if (r9 == null) goto L27;
        r9.sendJsEvent("event_gift_progress_update", r1);
        return;
    L27:
        return;
    L15:
        if (r1.get("progress_data") == null) goto L29;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r10 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).J8(getContext(), UriProtector.parse(nz1.a.b().b()), null);
        this.n = r10;
        if (r10 == null) goto L30;
        ViewGroup r11 = this.m;
        if (r11 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L21:
        r11.addView((View) ((BaseHybridComponentContainer) r10).d);
        xy0.a r13 = r10.g();
        if (r13 == null) goto L31;
        r13.load(null, r1);
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L32:
        return;
    }
}
