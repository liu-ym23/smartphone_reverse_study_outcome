package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.BaseHybridComponentContainer;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftDIYViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowCustomDIYPage;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIDIYTopView extends BaseGiftMVIViewChildNode<GiftTopViewState, GiftDIYViewState, GiftAction> {
    public static final /* synthetic */ int r = 0;
    public final Lazy m;
    public zy0.b n;
    public final Lazy o;
    public TextView p;
    public View q;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return 2131567541;
    }

    public final void i() {
        zy0.b r0 = this.n;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        ViewGroup r1 = (ViewGroup) this.o.getValue();
        if (r1 == null) goto L8;
        r1.removeAllViews();
    L8:
        this.n = null;
    }

    public final void g() {
        this.p = (TextView) r().findViewById(2131373690);
        View r0 = r().findViewById(2131373686);
        this.q = r0;
        if (r0 == null) goto L6;
        r0.setOnClickListener(x0.a(new GiftMVIDIYTopView$onAttach$1(this)));
        return;
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftTopViewState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIDIYTopView$bindToParent$1 r0 = GiftMVIDIYTopView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public final boolean d(com.bytedance.android.anya.a0 r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        if ((r3 instanceof ShowCustomDIYPage) == false) goto L6;
        com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class).S2(getContext(), ((ShowCustomDIYPage) r3).getSchemaUrl());
        return true;
    L6:
        return false;
    }

    public final void k(com.bytedance.android.anya.dsl.a<GiftDIYViewState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$registerListAdapters");
        com.bytedance.android.anya.dsl.a.b(r4, this, GiftMVIDIYTopView$registerListAdapters$1.INSTANCE, new GiftMVIDIYTopView$registerListAdapters$2(this), (RecyclerView) this.m.getValue());
    }

    public GiftMVIDIYTopView(final Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        super(r2, r3);
        this.m = LazyKt.lazy(new GiftMVIDIYTopView$recyclerView$2(this, r2));
        this.o = LazyKt.lazy(new GiftMVIDIYTopView$hybridContainer$2(this));
    }

    public final void b(com.bytedance.android.anya.k r7, MVIState r8) {
        GiftDIYViewState r9 = (GiftDIYViewState) r8;
        Intrinsics.checkNotNullParameter(r7, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r9, "state");
        r0<GiftDIYViewState, Boolean> r0 = r9.getButtonVisibility();
        Object r1 = r7.c.a(r0);
        if (r1 == null) goto L18;
        r7.b.a.invoke(r0);
        if (((Boolean) r1).booleanValue() == false) goto L12;
        TextView r2 = this.p;
        if (r2 == null) goto L9;
        r2.setVisibility(0);
    L9:
        View r3 = this.q;
        if (r3 == null) goto L18;
        r3.setVisibility(0);
        goto L18
    L12:
        TextView r4 = this.p;
        if (r4 == null) goto L15;
        r4.setVisibility(8);
    L15:
        View r5 = this.q;
        if (r5 == null) goto L18;
        r5.setVisibility(8);
    L18:
        r0<GiftDIYViewState, String> r6 = r9.getSchema();
        Object r10 = r7.c.a(r6);
        if (r10 == null) goto L21;
        r7.b.a.invoke(r6);
        String r11 = (String) r10;
    L21:
        r0<GiftDIYViewState, a5> r13 = r9.getButtonText();
        Object r14 = r7.c.a(r13);
        if (r14 == null) goto L26;
        r7.b.a.invoke(r13);
        a5 r15 = (a5) r14;
        TextView r16 = this.p;
        if (r16 == null) goto L26;
        r16.setText(vh6.c.b(ur2.a.class).Lf(r15, null));
    L26:
        com.bytedance.android.anya.internal.c r17 = r9.getSelectedPosition();
        com.bytedance.android.anya.internal.c r18 = r9.getGiftMarketingInfo();
        Object r19 = r7.c.a(r17);
        if (r19 == null) goto L29;
        r7.b.a.invoke(r17);
    L30:
        Object r20 = r7.c.a(r18);
        if (r20 == null) goto L33;
        r7.b.a.invoke(r18);
    L34:
        if (r19 != null) goto L36;
        if (r20 != null) goto L36;
        return;
    L36:
        if (r19 != null) goto L38;
        r19 = r17.c();
    L38:
        if (r20 != null) goto L40;
        r20 = r18.c();
    L40:
        Map r21 = (Map) r20;
        int r23 = ((Number) r19).intValue();
        if (r21.isEmpty() == true) goto L63;
        int r24 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.u.a;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.u.c() == false) goto L63;
        ViewGroup r25 = (ViewGroup) this.o.getValue();
        if (r25 == null) goto L49;
        r25.setVisibility(0);
    L49:
        if (this.n == null) goto L55;
        HashMap r26 = new HashMap();
        r26.put("eventName", "gift_marketing_data_update");
        r26.put("eventParams", r21);
        zy0.b r27 = this.n;
        if (r27 == null) goto L73;
        xy0.a r28 = r27.g();
        if (r28 == null) goto L73;
        r28.sendJsEvent("H5_webcastNotification", r26);
    L73:
        ((RecyclerView) this.m.getValue()).scrollToPosition(r23);
        return;
    L55:
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r29 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).J8(getContext(), UriProtector.parse(nz1.a.l().b()), null);
        this.n = r29;
        if (r29 == null) goto L73;
        ViewGroup r30 = (ViewGroup) this.o.getValue();
        if (r30 == null) goto L60;
        r30.addView((View) ((BaseHybridComponentContainer) r29).d);
    L60:
        xy0.a r31 = r29.g();
        if (r31 == null) goto L73;
        r31.load(null, r21);
    L63:
        ViewGroup r33 = (ViewGroup) this.o.getValue();
        if (r33 == null) goto L66;
        r33.setVisibility(8);
    L66:
        zy0.b r34 = this.n;
        if (r34 == null) goto L69;
        r34.dispose();
    L69:
        ViewGroup r35 = (ViewGroup) this.o.getValue();
        if (r35 == null) goto L72;
        r35.removeAllViews();
    L72:
        this.n = null;
        goto L73
    L33:
        r20 = null;
        goto L34
    L29:
        r19 = null;
        goto L30
    }
}
