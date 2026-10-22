package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.model.ExchangeInfo;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.BaseHybridComponentContainer;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopExchangeAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopExchangeViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.MinorsNoticeChangeLayoutAction;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVITopExchangeView extends com.bytedance.android.anya.d<GiftPanelState, GiftTopExchangeViewState, GiftAction> {
    public zy0.b h;
    public final CompositeDisposable i;
    public int j;
    public final Context k;
    public final ViewGroup l;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ GiftMVITopExchangeView a;

        public a(GiftMVITopExchangeView r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            ExchangeInfo r6 = (ExchangeInfo) r5;
            this.a.o(new GiftTopExchangeAction(r6.getHideCashExchange(), r6.getHideCombineExchange(), r6.getGiftPanelType()));
            this.a.o(new MinorsNoticeChangeLayoutAction());
        }
    }

    public final void g() {
        this.l.setVisibility(8);
        this.i.add(jc1.k.n(IRechargeService.class).rechargeCenter().observeExchangeInfo().subscribe(new a(this)));
    }

    public final void i() {
        ou0.a r0 = yt0.c.d();
        if (r0 == null) goto L5;
        r0.mn();
    L5:
        this.i.clear();
    }

    public final Context getContext() {
        return this.k;
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftPanelState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVITopExchangeView$bindToParent$1 r0 = GiftMVITopExchangeView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public final void b(com.bytedance.android.anya.k r5, MVIState r6) {
        GiftTopExchangeViewState r7 = (GiftTopExchangeViewState) r6;
        Intrinsics.checkNotNullParameter(r5, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r7, "state");
        com.bytedance.android.anya.r0<GiftTopExchangeViewState, Integer> r8 = r7.getGiftPanelType();
        Object r0 = r5.c.a(r8);
        if (r0 == null) goto L51;
        r5.b.a.invoke(r8);
        int r9 = ((Number) r0).intValue();
        if (r9 == 0) goto L56;
        int r10 = this.j;
        if (r9 == r10) goto L10;
    L12:
        int r11 = com.bytedance.android.live.recharge.util.d.a;
        if (com.bytedance.android.live.recharge.util.d.b(this.k) == false) goto L49;
        this.l.removeAllViews();
        this.l.setVisibility(0);
        ou0.a r13 = yt0.c.d();
        if (r13 == null) goto L17;
        r13.mn();
    L17:
        i12.d r14 = i12.m.e2.a();
        if (r14 == null) goto L20;
        Object r15 = com.bytedance.android.scope.m.e.d(r14, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.k.class);
    L21:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.k r16 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.k) r15;
        if (r16 == null) goto L24;
        Integer r17 = Integer.valueOf(r16.c());
    L25:
        if (r17 != null) goto L28;
    L29:
        if (r17 != null) goto L32;
    L33:
        if (r17 != null) goto L36;
    L37:
        if (r17 != null) goto L40;
    L42:
        String r18 = "0";
    L44:
        u6 r19 = new u6((String) com.bytedance.android.live.recharge.util.e.e.getValue(null, com.bytedance.android.live.recharge.util.e.a[3]));
        u6 r2 = r19.d("url");
        r2.b("is_receiver_show", r18);
        r2.b("hide_cash_exchange", String.valueOf(jc1.k.n(IRechargeService.class).rechargeCenter().getExchangeInfo().getHideCashExchange()));
        r2.b("hide_combine_exchange", String.valueOf(jc1.k.n(IRechargeService.class).rechargeCenter().getExchangeInfo().getHideCombineExchange()));
        Intrinsics.checkNotNullParameter("url", "key");
        Intrinsics.checkNotNullParameter(r2, "value");
        r19.a.put("url", r2);
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r20 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).J8(this.k, r19.c(), GiftMVITopExchangeView$handleDiff$1$hybridCard$1.INSTANCE);
        this.h = r20;
        if (r20 == null) goto L53;
        this.l.addView((View) ((BaseHybridComponentContainer) r20).d);
        com.bytedance.android.live.revenue.platform.hybrid.impl.component.b r21 = r20.g();
        if (r21 == null) goto L54;
        r21.load(null, null);
        return;
    L54:
        return;
    L53:
        return;
    L40:
        if (r17.intValue() != 1024) goto L42;
    L43:
        r18 = "1";
        goto L44
    L36:
        if (r17.intValue() == 8) goto L43;
    L32:
        if (r17.intValue() == 4) goto L43;
    L28:
        if (r17.intValue() == 2) goto L43;
    L24:
        r17 = null;
        goto L25
    L20:
        r15 = null;
        goto L21
    L49:
        this.l.setVisibility(8);
        return;
    L10:
        if (r10 != 1) goto L12;
        this.j = r9;
        return;
    L56:
        return;
    }

    public GiftMVITopExchangeView(Context r2, ViewGroup r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.k = r2;
        this.l = r3;
        this.i = new CompositeDisposable();
    }
}
