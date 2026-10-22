package com.bytedance.android.live.recharge.panel;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h extends com.bytedance.android.live.recharge.panel.context.a {
    public static final /* synthetic */ KProperty[] B = null;
    public final RechargeDialogContext A;
    public final b y;
    public final b z;

    public static final class a {
    }

    public final class b<T> {
        public final com.bytedance.android.live.core.arch.mvvm.c<T> a;
        public final /* synthetic */ h b;

        public b(h r2, PropertyOwner r3) {
            Intrinsics.checkNotNullParameter(r3, "target");
            this.b = r2;
            this.a = r3;
            com.bytedance.android.live.recharge.panel.context.b.a(r3.subscribe(new i(this)), r2.A.getCd());
        }
    }

    static {
        B = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(h.class, "isRechargeAgreementAccepted", "isRechargeAgreementAccepted()Ljava/lang/Boolean;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(h.class, "customPrice", "getCustomPrice()Ljava/lang/Long;", 0))};
    }

    @Override // com.bytedance.android.live.recharge.panel.context.a, vw0.d
    public final Long getCustomPrice() {
        b r0 = this.z;
        KProperty r1 = B[1];
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "property");
        return (Long) r0.a.getValue();
    }

    @Override // com.bytedance.android.live.recharge.panel.context.a, vw0.d
    public final Boolean isRechargeAgreementAccepted() {
        b r0 = this.y;
        KProperty r1 = B[0];
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "property");
        return (Boolean) r0.a.getValue();
    }

    public h(RechargeDialogContext r5) {
        Intrinsics.checkNotNullParameter(r5, "dialogContext");
        super(r5.getDialogContextProxy());
        this.A = r5;
        PropertyOwner<Boolean> r0 = r5.isAcceptAgreement();
        KProperty[] r1 = B;
        KProperty r2 = r1[0];
        Intrinsics.checkNotNullParameter(r0, "$this$provideDelegate");
        this.y = new b(this, r0);
        PropertyOwner<Long> r6 = r5.getCustomPrice();
        KProperty r3 = r1[1];
        Intrinsics.checkNotNullParameter(r6, "$this$provideDelegate");
        this.z = new b(this, r6);
    }

    @Override // com.bytedance.android.live.recharge.panel.context.a, vw0.d
    public final void setCustomPrice(Long r4) {
        b r0 = this.z;
        KProperty r1 = B[1];
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "property");
        if (r4 == null) goto L7;
        r0.a.a(r4);
        return;
    }

    @Override // com.bytedance.android.live.recharge.panel.context.a, vw0.d
    public final void setRechargeAgreementAccepted(Boolean r4) {
        b r0 = this.y;
        KProperty r1 = B[0];
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "property");
        if (r4 == null) goto L7;
        r0.a.a(r4);
        return;
    }
}
