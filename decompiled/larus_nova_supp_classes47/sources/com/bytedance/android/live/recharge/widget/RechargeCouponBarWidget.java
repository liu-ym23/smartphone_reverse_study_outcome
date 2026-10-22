package com.bytedance.android.live.recharge.widget;

import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.android.live.recharge.config.GemExchangeCouponConfig;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/widget/RechargeCouponBarWidget;", "Lcom/bytedance/android/live/recharge/widget/AbsRechargeWidget;", "a", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargeCouponBarWidget extends AbsRechargeWidget {
    public TextView i;
    public TextView j;
    public ConstraintLayout k;
    public zy0.d l;
    public int m;
    public final RechargeDialogContext n;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RechargeCouponBarWidget a;

        public b(RechargeCouponBarWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Unit r4 = (Unit) r3;
            com.bytedance.android.live.recharge.deal.f r5 = this.a.n.getSelectedDeal();
            if (r5 == null) goto L8;
            ConstraintLayout r0 = this.a.k;
            if (r0 == null) goto L9;
            r0.post(new j(r5, this));
            return;
        L9:
            return;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131567260;
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void yq(long r1) {
    }

    public final void onUnload() {
        zy0.d r0 = this.l;
        if (r0 == null) goto L7;
        xy0.a<?> r1 = r0.g();
        if (r1 == null) goto L7;
        r1.dispose();
    L7:
        this.m = 0;
    }

    public RechargeCouponBarWidget(RechargeDialogContext r2) {
        Intrinsics.checkNotNullParameter(r2, "rechargeContext");
        super(r2);
        this.n = r2;
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void onInit(Object[] r1) {
        this.k = findViewById(2131368111);
        this.i = (TextView) findViewById(2131368119);
        this.j = (TextView) findViewById(2131368116);
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void onLoad(Object[] r2) {
        super.onLoad(r2);
        RxUtilKt.c(this.n.getDealsSelectedEvent().subscribe(new b(this)), this.d);
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void xq(com.bytedance.android.live.recharge.deal.i r12) {
        Intrinsics.checkNotNullParameter(r12, "dealSet");
        com.bytedance.android.live.recharge.model.diamond.d r0 = r12.getBizExtra().getGemExchangeCouponInfo();
        Map<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> r1 = r12.getPanelExtraInfo();
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator<Map.Entry<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g>> r3 = r1.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Map.Entry<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> r4 = r3.next();
        if (com.bytedance.android.live.recharge.platform.business.model.diamond.j.a(r4.getValue()) == false) goto L4;
        r2.put(r4.getKey(), r4.getValue());
        goto L4
    L8:
        Object r5 = null;
        if ((!r2.isEmpty()) == false) goto L23;
        this.m = 1;
        Iterator<T> r6 = r12.c().iterator();
    L12:
        if (r6.hasNext() == false) goto L19;
        Object r7 = r6.next();
        if (((com.bytedance.android.live.recharge.deal.u) r7).b != r12.d()) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == false) goto L12;
        r5 = r7;
        goto L19
    L16:
        r8 = false;
    L19:
        com.bytedance.android.live.recharge.deal.u r9 = (com.bytedance.android.live.recharge.deal.u) r5;
        if (r9 == null) goto L58;
        zq(r9);
        return;
    L58:
        return;
    L23:
        if (r0.getCanShow() == true) goto L25;
    L44:
        ConstraintLayout r13 = this.k;
        if (r13 == null) goto L62;
        UtilityKotlinExtentionsKt.z(r13, false);
        return;
    L62:
        return;
    L25:
        if (r0.getMainTitle().length() <= 0) goto L27;
        boolean r10 = true;
    L28:
        if (r10 == false) goto L44;
        this.m = 2;
        com.bytedance.android.live.recharge.model.diamond.d r14 = r12.getBizExtra().getGemExchangeCouponInfo();
        GemExchangeCouponConfig r15 = (GemExchangeCouponConfig) com.bytedance.android.live.recharge.utils.t.p.getValue(null, com.bytedance.android.live.recharge.utils.t.a[14]);
        ConstraintLayout r16 = this.k;
        if (r16 == null) goto L32;
        UtilityKotlinExtentionsKt.z(r16, true);
    L32:
        TextView r17 = this.i;
        if (r17 == null) goto L35;
        r17.setText(r15.getTitle());
    L35:
        TextView r18 = this.j;
        if (r18 == null) goto L38;
        r18.setText(r14.getMainTitle());
    L38:
        TextView r19 = this.j;
        if (r19 == null) goto L41;
        r19.setTextColor(s1.h(2131108126));
    L41:
        ConstraintLayout r20 = this.k;
        if (r20 == null) goto L60;
        r20.setOnClickListener(new k(this, r15, r12));
        return;
    L60:
        return;
    L27:
        r10 = false;
        goto L28
    }

    public final void zq(com.bytedance.android.live.recharge.deal.f r7) {
        Intrinsics.checkNotNullParameter(r7, "deal");
        if (this.m == 1) goto L6;
        return;
    L6:
        if ((r7 instanceof com.bytedance.android.live.recharge.deal.d) == false) goto L11;
        ConstraintLayout r8 = this.k;
        if (r8 == null) goto L82;
        UtilityKotlinExtentionsKt.z(r8, false);
        return;
    L82:
        return;
    L11:
        com.bytedance.android.live.recharge.platform.business.model.diamond.g r0 = com.bytedance.android.live.recharge.deal.g.c(r7);
        if (r0 == null) goto L75;
        com.bytedance.android.live.recharge.platform.business.model.diamond.a r4 = r0.getCouponBarInfo();
        if (r4 == null) goto L16;
        String r5 = r4.getTitle();
    L17:
        if (r5 != null) goto L19;
    L22:
        boolean r6 = true;
    L23:
        if (r6 == true) goto L36;
        com.bytedance.android.live.recharge.platform.business.model.diamond.a r9 = r0.getCouponBarInfo();
        if (r9 == null) goto L27;
        String r10 = r9.getDesc();
    L28:
        if (r10 != null) goto L30;
    L33:
        boolean r12 = true;
    L34:
        if (r12 == true) goto L36;
        boolean r13 = true;
    L37:
        if (r13 == true) goto L40;
        r0 = null;
    L40:
        if (r0 == null) goto L75;
        ConstraintLayout r14 = this.k;
        if (r14 == null) goto L44;
        UtilityKotlinExtentionsKt.z(r14, true);
    L44:
        TextView r15 = this.i;
        if (r15 == null) goto L51;
        com.bytedance.android.live.recharge.platform.business.model.diamond.a r16 = r0.getCouponBarInfo();
        if (r16 == null) goto L49;
        String r17 = r16.getTitle();
    L50:
        r15.setText(r17);
        goto L51
    L49:
        r17 = null;
    L51:
        TextView r18 = this.j;
        if (r18 == null) goto L58;
        com.bytedance.android.live.recharge.platform.business.model.diamond.a r19 = r0.getCouponBarInfo();
        if (r19 == null) goto L56;
        String r20 = r19.getDesc();
    L57:
        r18.setText(r20);
        goto L58
    L56:
        r20 = null;
    L58:
        com.bytedance.android.live.recharge.platform.business.model.diamond.a r1 = r0.getCouponBarInfo();
        if (r1 == null) goto L63;
        Integer r2 = r1.getDescStyle();
        if (r2 == null) goto L63;
        int r3 = r2.intValue();
    L64:
        TextView r22 = this.j;
        if (r22 == null) goto L73;
        if (r3 != 1) goto L68;
        int r23 = s1.h(2131108132);
    L72:
        r22.setTextColor(r23);
        Unit r24 = Unit.INSTANCE;
    L74:
        if (r24 == null) goto L75;
    L78:
        String r25 = (String) com.bytedance.android.live.recharge.util.g.h.getValue(null, com.bytedance.android.live.recharge.util.g.a[6]);
        ConstraintLayout r26 = this.k;
        if (r26 == null) goto L83;
        r26.setOnClickListener(new RechargeCouponBarWidget$onDealSelected$3(this, r25, r7));
        return;
    L83:
        return;
    L68:
        if (r3 == 2) goto L70;
        r23 = s1.h(2131108127);
        goto L72
    L70:
        r23 = s1.h(2131108126);
        goto L72
    L73:
        r24 = null;
    L63:
        r3 = 0;
        goto L64
    L30:
        if (r10.length() == 0) goto L33;
        r12 = false;
        goto L34
    L27:
        r10 = null;
    L36:
        r13 = false;
        goto L37
    L19:
        if (r5.length() == 0) goto L22;
        r6 = false;
        goto L23
    L16:
        r5 = null;
    L75:
        ConstraintLayout r27 = this.k;
        if (r27 == null) goto L78;
        UtilityKotlinExtentionsKt.z(r27, false);
        Unit r28 = Unit.INSTANCE;
        goto L78
    }
}
