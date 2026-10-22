package com.bytedance.android.live.recharge.panel.context;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.utils.w;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.panel.aio.IPanelProperties;
import com.bytedance.android.live.recharge.panel.aio.PanelMode;
import com.bytedance.android.live.recharge.utils.k;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class a implements vw0.d {
    public static final /* synthetic */ KProperty[] x = null;
    public final BehaviorSubject<IPanelProperties> h;
    public final b q;
    public final b r;
    public final b s;
    public final b t;
    public final b u;
    public final b v;
    public final c w;

    /* JADX INFO: renamed from: com.bytedance.android.live.recharge.panel.context.a$a, reason: collision with other inner class name */
    public static final class C0067a {
    }

    public final class b<T> {
        public final com.bytedance.android.live.revenue.common.reactive.b<T> a;
        public final /* synthetic */ a b;

        /* JADX INFO: renamed from: com.bytedance.android.live.recharge.panel.context.a$b$a, reason: collision with other inner class name */
        public static final class C0068a<T> implements com.bytedance.android.live.revenue.common.reactive.f {
            public final /* synthetic */ b a;

            public C0068a(b r1) {
                this.a = r1;
            }

            @Override // com.bytedance.android.live.revenue.common.reactive.f
            public final void a(T r2) {
                Intrinsics.checkNotNullParameter(r2, "newValue");
                this.a.b.a();
            }
        }

        public final Object a(KProperty r2) {
            Intrinsics.checkNotNullParameter(r2, "property");
            return this.a.getValue();
        }

        public b(a r2, com.bytedance.android.live.revenue.common.reactive.b<T> r3) {
            Intrinsics.checkNotNullParameter(r3, "target");
            this.b = r2;
            this.a = r3;
            com.bytedance.android.live.recharge.panel.context.b.a(r3.a(new C0068a(this)), r2.w.getCd());
        }

        public final void b(KProperty r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "property");
            if (r3 != null) goto L5;
            return;
        L5:
            this.a.setValue(r3);
        }
    }

    static {
        x = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "isRechargeAgreementAccepted", "isRechargeAgreementAccepted()Ljava/lang/Boolean;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "isCombinedPaySelected", "isCombinedPaySelected()Ljava/lang/Boolean;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "customPrice", "getCustomPrice()Ljava/lang/Long;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "isHidePanel", "isHidePanel()Ljava/lang/Boolean;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "isShowCenterLoading", "isShowCenterLoading()Ljava/lang/Boolean;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "panelMode", "getPanelMode()I", 0))};
    }

    @Override // vw0.d
    public Long getCustomPrice() {
        return (Long) this.s.a(x[2]);
    }

    @Override // vw0.d
    public final int getPanelMode() {
        return ((Number) this.v.a(x[5])).intValue();
    }

    @Override // vw0.d
    public final Boolean isCombinedPaySelected() {
        return (Boolean) this.r.a(x[1]);
    }

    @Override // vw0.d
    public final Boolean isHidePanel() {
        return (Boolean) this.t.a(x[3]);
    }

    @Override // vw0.d
    public Boolean isRechargeAgreementAccepted() {
        return (Boolean) this.q.a(x[0]);
    }

    @Override // vw0.d
    public final Boolean isShowCenterLoading() {
        return (Boolean) this.u.a(x[4]);
    }

    @Override // vw0.d
    public final void setCombinedPaySelected(Boolean r4) {
        this.r.b(x[1], r4);
    }

    @Override // vw0.d
    public void setCustomPrice(Long r4) {
        this.s.b(x[2], r4);
    }

    @Override // vw0.d
    public final void setHidePanel(Boolean r4) {
        this.t.b(x[3], r4);
    }

    @Override // vw0.d
    public final void setPanelMode(int r4) {
        this.v.b(x[5], Integer.valueOf(r4));
    }

    @Override // vw0.d
    public void setRechargeAgreementAccepted(Boolean r4) {
        this.q.b(x[0], r4);
    }

    @Override // vw0.d
    public final void setShowCenterLoading(Boolean r4) {
        this.u.b(x[4], r4);
    }

    public final void a() {
        IPanelProperties r0 = vw0.f.a();
        vw0.e.a(r0, this);
        int r1 = w.a;
        if (v.a() == false) goto L5;
        jy0.b.d("RechargePanelPropertiesProvider", "broadcast: " + r0);
    L5:
        this.h.onNext(r0);
    }

    public a(c r7) {
        Intrinsics.checkNotNullParameter(r7, "panelContext");
        this.w = r7;
        int r0 = com.bytedance.revenue.platform.api.core.rx.c.a;
        this.h = BehaviorSubject.create();
        Boolean r1 = Boolean.FALSE;
        com.bytedance.android.live.revenue.common.reactive.c r2 = new com.bytedance.android.live.revenue.common.reactive.c(r1);
        com.bytedance.android.live.revenue.common.reactive.c r3 = new com.bytedance.android.live.revenue.common.reactive.c(0L);
        com.bytedance.android.live.revenue.common.reactive.c r4 = new com.bytedance.android.live.revenue.common.reactive.c(r1);
        com.bytedance.android.live.revenue.common.reactive.c r5 = new com.bytedance.android.live.revenue.common.reactive.c(r1);
        int r6 = k.a;
        com.bytedance.android.live.recharge.model.d r8 = r7.a();
        Intrinsics.checkNotNullParameter(r8, "entranceParams");
        com.bytedance.android.live.recharge.core.f.g(RechargeServices.b()).T0(r8);
        com.bytedance.android.live.revenue.common.reactive.c r9 = new com.bytedance.android.live.revenue.common.reactive.c(Integer.valueOf(PanelMode.NORMAL_MODE.getMode()));
        KProperty[] r10 = x;
        KProperty r12 = r10[0];
        this.q = b(r2);
        com.bytedance.android.live.recharge.combinedpay.a.C0060a r13 = com.bytedance.android.live.recharge.combinedpay.a.a;
        KProperty r14 = r10[1];
        this.r = b(r13);
        KProperty r15 = r10[2];
        this.s = b(r3);
        KProperty r16 = r10[3];
        this.t = b(r4);
        KProperty r17 = r10[4];
        this.u = b(r5);
        KProperty r18 = r10[5];
        this.v = b(r9);
    }

    public final b b(com.bytedance.android.live.revenue.common.reactive.b r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$provideDelegate");
        return new b(this, r2);
    }
}
