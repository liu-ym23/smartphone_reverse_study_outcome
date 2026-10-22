package com.bytedance.android.live.recharge.widget;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ RechargeNoPasswordWidget a;

    public p(RechargeNoPasswordWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        com.bytedance.android.live.recharge.platform.model.f r12 = (com.bytedance.android.live.recharge.platform.model.f) r10;
        ALogger.d("RechargeNoPasswordWidget", "signInfoDataSubject接口返回: " + r12.a() + " -> " + r12.b() + " -> " + r12.c());
        if (r12.d() == false) goto L52;
        RechargeNoPasswordWidget r0 = this.a;
        List<com.bytedance.android.live.recharge.platform.model.e> r13 = r12.c();
        int r4 = RechargeNoPasswordWidget.O;
        r0.getClass();
        Iterator<T> r14 = r13.iterator();
        int r5 = 0;
    L6:
        if (r14.hasNext() == false) goto L29;
        int r6 = ((com.bytedance.android.live.recharge.platform.model.e) r14.next()).a();
        if (r5 != 0) goto L24;
        if (r6 != 206) goto L16;
        TextView r8 = r0.E;
        if (r8 == null) goto L13;
        r8.setVisibility(0);
    L13:
        TextView r9 = r0.F;
        if (r9 == null) goto L23;
        r9.setVisibility(8);
    L23:
        r0.H = r6;
        goto L24
    L16:
        if (r6 != 201) goto L23;
        TextView r15 = r0.F;
        if (r15 == null) goto L20;
        r15.setVisibility(0);
    L20:
        TextView r16 = r0.E;
        if (r16 == null) goto L23;
        r16.setVisibility(8);
    L24:
        if (r6 != 206) goto L26;
        r0.B = true;
    L26:
        if (r6 != 201) goto L28;
        r0.C = true;
    L28:
        r5 = r5 + 1;
        goto L6
    L29:
        boolean r17 = r0.B;
        if (r17 == true) goto L32;
    L33:
        boolean r2 = r0.C;
        if (r2 == false) goto L39;
        if (r17 == true) goto L39;
    L36:
        if (r17 == false) goto L38;
        r0.Bq();
        return;
    L38:
        r0.Cq();
        return;
    L39:
        if (r17 == false) goto L66;
        if (r2 == true) goto L42;
        return;
    L42:
        if (r0.H != 206) goto L44;
        r0.Bq();
    L45:
        ViewGroup r18 = r0.o;
        if (r18 == null) goto L48;
        r18.setVisibility(0);
    L48:
        ViewGroup r19 = r0.o;
        if (r19 == null) goto L68;
        r19.setOnClickListener(new l(r0));
        return;
    L68:
        return;
    L44:
        r0.Cq();
        goto L45
    L66:
        return;
    L32:
        if (r0.C == false) goto L36;
    L52:
        if (r12.e() == false) goto L70;
        RechargeNoPasswordWidget r110 = this.a;
        int r1 = RechargeNoPasswordWidget.O;
        r110.enableSubWidgetManager();
        ((Widget) r110).subWidgetManager.load(2131383888, new NoPasswordCjComponentWidget(r110.h));
        ViewGroup r111 = this.a.o;
        if (r111 == null) goto L56;
        r111.setVisibility(8);
    L56:
        FrameLayout r112 = this.a.K;
        if (r112 == null) goto L59;
        r112.setVisibility(0);
    L59:
        RechargeNoPasswordWidget r113 = this.a;
        r113.L = true;
        RxUtilKt.c(r113.h.getBtnContent().compose(RxUtil.rxSchedulerHelper()).subscribe(new n(this)), this.a.d);
        RxUtilKt.c(this.a.h.getPkLoadCjComponentFailed().compose(RxUtil.rxSchedulerHelper()).subscribe(new o(this)), this.a.d);
        return;
    }
}
