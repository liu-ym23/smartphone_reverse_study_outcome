package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.s0;
import com.bytedance.android.anya.t0;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.BaseHybridComponentContainer;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftBuffCardItem;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftBuffCardViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIBuffCardTopView extends BaseGiftMVIViewChildNode<GiftTopViewState, GiftBuffCardViewState, GiftAction> {
    public static final /* synthetic */ int p = 0;
    public final Lazy m;
    public zy0.b n;
    public final Lazy o;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return 2131567537;
    }

    public final ViewGroup t() {
        return (ViewGroup) this.o.getValue();
    }

    public final void i() {
        zy0.b r0 = this.n;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        ViewGroup r1 = t();
        if (r1 == null) goto L8;
        r1.removeAllViews();
    L8:
        this.n = null;
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftTopViewState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIBuffCardTopView$bindToParent$1 r0 = GiftMVIBuffCardTopView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public final void k(com.bytedance.android.anya.dsl.a<GiftBuffCardViewState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$registerListAdapters");
        com.bytedance.android.anya.dsl.a.b(r4, this, GiftMVIBuffCardTopView$registerListAdapters$1.INSTANCE, new GiftMVIBuffCardTopView$registerListAdapters$2(this), (RecyclerView) this.m.getValue());
    }

    public final void b(com.bytedance.android.anya.k r6, MVIState r7) {
        GiftBuffCardViewState r8 = (GiftBuffCardViewState) r7;
        Intrinsics.checkNotNullParameter(r6, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r8, "state");
        t0<GiftBuffCardViewState, GiftBuffCardItem> r0 = r8.getBuffCardList();
        Object r1 = r6.c.a(r0);
        if (r1 == null) goto L5;
        r6.b.a.invoke(r0);
        s0 r2 = (s0) r1;
        TuplesKt.to(0, 0);
        ((RecyclerView) this.m.getValue()).setVisibility(0);
    L5:
        com.bytedance.android.anya.internal.c r3 = r8.getSelectedPosition();
        com.bytedance.android.anya.internal.c r9 = r8.getGiftMarketingInfo();
        Object r4 = r6.c.a(r3);
        if (r4 == null) goto L8;
        r6.b.a.invoke(r3);
    L9:
        Object r5 = r6.c.a(r9);
        if (r5 == null) goto L12;
        r6.b.a.invoke(r9);
    L13:
        if (r4 != null) goto L15;
        if (r5 != null) goto L15;
        return;
    L15:
        if (r4 != null) goto L17;
        r4 = r3.c();
    L17:
        if (r5 != null) goto L19;
        r5 = r9.c();
    L19:
        Map r10 = (Map) r5;
        int r11 = ((Number) r4).intValue();
        if (r10.isEmpty() == true) goto L42;
        int r13 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.u.a;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.u.c() == false) goto L42;
        ViewGroup r14 = t();
        if (r14 == null) goto L28;
        r14.setVisibility(0);
    L28:
        if (this.n == null) goto L34;
        HashMap r15 = new HashMap();
        r15.put("eventName", "gift_marketing_data_update");
        r15.put("eventParams", r10);
        zy0.b r16 = this.n;
        if (r16 == null) goto L56;
        xy0.a r17 = r16.g();
        if (r17 == null) goto L56;
        r17.sendJsEvent("H5_webcastNotification", r15);
    L56:
        RecyclerView r18 = (RecyclerView) this.m.getValue();
        if (r18 == null) goto L61;
        r18.scrollToPosition(r11);
        return;
    L61:
        return;
    L34:
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r19 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).J8(getContext(), UriProtector.parse(nz1.a.l().b()), null);
        this.n = r19;
        if (r19 == null) goto L56;
        ViewGroup r20 = t();
        if (r20 == null) goto L39;
        r20.addView((View) ((BaseHybridComponentContainer) r19).d);
    L39:
        xy0.a r21 = r19.g();
        if (r21 == null) goto L56;
        r21.load(null, r10);
    L42:
        ViewGroup r23 = t();
        if (r23 == null) goto L56;
        if (r23.getVisibility() != 0) goto L56;
        ViewGroup r24 = t();
        if (r24 == null) goto L49;
        r24.setVisibility(8);
    L49:
        zy0.b r25 = this.n;
        if (r25 == null) goto L52;
        r25.dispose();
    L52:
        ViewGroup r26 = t();
        if (r26 == null) goto L55;
        r26.removeAllViews();
    L55:
        this.n = null;
        goto L56
    L12:
        r5 = null;
        goto L13
    L8:
        r4 = null;
        goto L9
    }

    public GiftMVIBuffCardTopView(final Context r2, ViewGroup r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        super(r2, r3);
        TuplesKt.to(0, 0);
        this.m = LazyKt.lazy(new GiftMVIBuffCardTopView$mBuffRecyclerView$2(this, r2));
        this.o = LazyKt.lazy(new GiftMVIBuffCardTopView$hybridContainer$2(this));
    }
}
