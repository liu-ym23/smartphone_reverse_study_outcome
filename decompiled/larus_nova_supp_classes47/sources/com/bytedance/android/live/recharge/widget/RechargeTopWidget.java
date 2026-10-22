package com.bytedance.android.live.recharge.widget;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.android.live.recharge.nopassword.NoPasswordScene;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.HybridDialogImpl;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.utils.e4;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/widget/RechargeTopWidget;", "Lcom/bytedance/android/live/recharge/widget/AbsRechargeWidget;", "Landroid/view/View$OnClickListener;", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargeTopWidget extends AbsRechargeWidget implements View.OnClickListener {
    public TextView i;
    public TextView j;
    public TextView k;
    public String l;
    public Long m;
    public ImageView n;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ RechargeTopWidget a;

        public a(RechargeTopWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            if (((com.bytedance.android.live.recharge.platform.model.f) r4).f() == true) goto L5;
            return;
        L5:
            if (this.a.h.getNoPasswordScene() != NoPasswordScene.SCENE_FANS_CLUB_JOIN) goto L7;
        L20:
            this.a.l = s1.B(2131921899);
            return;
        L7:
            if (this.a.h.getNoPasswordScene() == NoPasswordScene.SCENE_FANS_CLUB_SEND_GIFT) goto L20;
            com.bytedance.android.live.recharge.model.b r5 = this.a.h.getMDialogEntranceParams().j;
            if (r5 == null) goto L16;
            long r0 = r5.e;
            IGiftService r6 = jc1.k.f(IGiftService.class);
            if (r6 == null) goto L16;
            h2 r7 = r6.findLiteGiftById(r0);
            if (r7 == null) goto L16;
            String r8 = r7.getName();
        L18:
            if (r2.a(r8) == false) goto L23;
            this.a.l = s1.C(2131919849, new Object[]{r8, r3.c()});
            this.a.zq();
            return;
        L23:
            return;
        L16:
            r8 = null;
            goto L18
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ RechargeTopWidget a;

        public b(RechargeTopWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            final RechargeTopWidget r5 = this.a;
            r5.getClass();
            String r0 = ((com.bytedance.android.live.recharge.config.b) com.bytedance.android.live.recharge.utils.j.F.getValue(null, com.bytedance.android.live.recharge.utils.j.a[29])).b();
            if (r0.length() <= 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L12;
            final boolean r2 = com.bytedance.android.live.recharge.util.d.a();
            zy0.d r3 = com.bytedance.android.live.recharge.util.h.b(((Widget) r5).context, UriProtector.parse(r0));
            if (r3 == null) goto L13;
            HybridDialogImpl r6 = (HybridDialogImpl) r3;
            r6.m1(new RechargeTopWidget$openRechargeSettingPage$1(r5, r2));
            return;
        L13:
            return;
        L12:
            return;
        L5:
            r1 = false;
            goto L6
        }
    }

    public final int getLayoutId() {
        return 2131567272;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
    }

    public final void onUnload() {
    }

    public final void zq() {
        String r0 = this.l;
        if (r0 == null) goto L8;
        TextView r1 = this.i;
        if (r1 == null) goto L9;
        r1.setText(r0);
        return;
    L9:
        return;
    }

    public RechargeTopWidget(RechargeDialogContext r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.m = 0L;
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void onInit(Object[] r1) {
        this.i = (TextView) findViewById(2131388915);
        this.j = (TextView) findViewById(2131368992);
        this.k = (TextView) findViewById(2131365458);
        this.n = (ImageView) findViewById(2131383897);
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void onLoad(Object[] r4) {
        int r0 = com.bytedance.android.live.recharge.util.b.a;
        boolean r1 = this.h.getMDialogEntranceParams().e;
        String r2 = r3.c();
        if (r1 == false) goto L5;
        String r3 = s1.C(2131919848, new Object[]{r2});
    L6:
        this.l = r3;
        com.bytedance.android.live.recharge.panel.context.b.a(this.h.getRepository().H.subscribe(new a(this)), this.d);
        this.m = Long.valueOf(((IRechargeService) com.bytedance.android.live.revenue.core.util.f.a(IRechargeService.class)).rechargeCenter().getAvailableDiamonds());
        super.onLoad(r4);
        zq();
        if (((com.bytedance.android.live.recharge.config.b) com.bytedance.android.live.recharge.utils.j.F.getValue(null, com.bytedance.android.live.recharge.utils.j.a[29])).a() == false) goto L15;
        ImageView r5 = this.n;
        if (r5 == null) goto L11;
        r5.setVisibility(0);
    L11:
        ImageView r6 = this.n;
        if (r6 == null) goto L16;
        r6.setOnClickListener(new b(this));
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r3 = e4.a();
        goto L6
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void xq(com.bytedance.android.live.recharge.deal.i r6) {
        Intrinsics.checkNotNullParameter(r6, "dealSet");
        Boolean r7 = Boolean.valueOf(r6.h());
        if (r7 != null) goto L5;
    L29:
        UIUtils.setViewVisibility(this.k, 8);
        return;
    L5:
        if (r7.booleanValue() == false) goto L29;
        IRechargeService r8 = (IRechargeService) jc1.k.f(IRechargeService.class);
        if (r8 == null) goto L12;
        zv0.f r9 = r8.rechargeCenter();
        if (r9 == null) goto L12;
        Long r10 = Long.valueOf(r9.getAvailableDiamonds());
    L13:
        String r12 = String.valueOf(r10);
        int r0 = ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().getExchangeInfo().getExchangeDiamond();
        UIUtils.setViewVisibility(this.k, 0);
        int r1 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.h("livesdk_exchange_diamond_show", this.g, r12, r0);
        int r2 = com.bytedance.android.live.recharge.util.d.a;
        if (com.bytedance.android.live.incentive.exchange.j.b() == false) goto L23;
        KmpEnv r3 = KmpEnv.a;
        if (KmpEnv.c() == true) goto L23;
        TextView r4 = this.k;
        if (r4 == null) goto L20;
        r4.setText(s1.C(2131917413, new Object[]{r3.c()}));
    L20:
        TextView r5 = this.k;
        if (r5 == null) goto L31;
        r5.setOnClickListener(new y(this, r12, r0));
        return;
    L31:
        return;
    L23:
        TextView r13 = this.k;
        if (r13 == null) goto L26;
        r13.setText(s1.C(2131917412, new Object[]{r3.c()}));
    L26:
        TextView r14 = this.k;
        if (r14 == null) goto L33;
        r14.setOnClickListener(new z(this, r12, r0));
        return;
    L33:
        return;
    L12:
        r10 = null;
        goto L13
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void yq(long r9) {
        Long r10 = Long.valueOf(r9);
        long r4 = 0;
        if (this.c <= 0) goto L10;
        TextView r0 = this.j;
        if (r0 == null) goto L17;
        Object[] r1 = new Object[4];
        if (r10 == null) goto L9;
        r4 = r10.longValue();
    L9:
        r1[0] = Long.valueOf(r4);
        r1[1] = r3.b();
        r1[2] = Long.valueOf(this.c);
        r1[3] = r3.b();
        r0.setText(s1.C(2131921886, r1));
    L17:
        if ((!Intrinsics.areEqual(this.m, r10)) == false) goto L20;
        int r2 = com.bytedance.android.live.recharge.utils.m.a;
        Map r12 = MapsKt.mapOf(new Pair[]{TuplesKt.to("balance_cache", String.valueOf(this.m)), TuplesKt.to("real_balance", String.valueOf(r10)), TuplesKt.to("lack_money", String.valueOf(Long.valueOf(this.c)))});
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r13 = com.bytedance.android.live.recharge.utils.f.a;
        com.bytedance.android.live.recharge.utils.f.d("livesdk_rd_balance_cache_not_accurate", r12, new Class[]{IRoom.class, am2.x.class});
        return;
    L20:
        return;
    L10:
        TextView r3 = this.j;
        if (r3 == null) goto L17;
        Object[] r5 = new Object[2];
        if (r10 == null) goto L15;
        r4 = r10.longValue();
    L15:
        r5[0] = Long.valueOf(r4);
        r5[1] = r3.b();
        r3.setText(s1.C(2131921885, r5));
        goto L17
    }
}
