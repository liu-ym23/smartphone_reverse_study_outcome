package com.bytedance.android.live.recharge.panel;

import android.content.Context;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.live.datacontext.n;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements com.bytedance.android.live.recharge.panel.context.c {
    public static final /* synthetic */ KProperty[] f = null;
    public final com.bytedance.android.live.revenue.common.reactive.h a;
    public final com.bytedance.android.live.revenue.common.reactive.c b;
    public final com.bytedance.android.live.revenue.common.reactive.c c;
    public final e d;
    public final RechargeDialogContext e;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Unit r3 = (Unit) r2;
            f r4 = this.a;
            r4.b.setValue(r4.getContext().getSelectedDeal());
        }
    }

    static {
        f = new KProperty[]{Reflection.property1(new PropertyReference1Impl(f.class, "dealSet", "getDealSet()Lcom/bytedance/android/live/revenue/common/reactive/Property;", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "currentOrder", "getCurrentOrder()Lcom/bytedance/android/live/revenue/common/reactive/MutableProperty;", 0))};
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final void h() {
        this.e.setTwoFactoryAuthVerifyInfo(null);
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final com.bytedance.android.live.recharge.model.d a() {
        return this.e.getMDialogEntranceParams();
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final com.bytedance.android.live.recharge.panel.context.a b() {
        return this.e.getPanelPropertiesProvider();
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final PublishSubject<Unit> c() {
        return this.e.getClickRechargeBtn();
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final String e() {
        return this.e.getTwoFactoryAuthVerifyInfo();
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final com.bytedance.android.live.revenue.common.reactive.b<Order> f() {
        e r0 = this.d;
        KProperty r1 = f[1];
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "property");
        return r0;
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final com.bytedance.android.live.revenue.common.reactive.e<com.bytedance.android.live.recharge.deal.i> g() {
        com.bytedance.android.live.revenue.common.reactive.h r0 = this.a;
        KProperty r1 = f[0];
        Intrinsics.checkNotNullParameter(r0, "$this$getValue");
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r1, "property");
        return r0;
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final CompositeDisposable getCd() {
        return this.e.getCd();
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final com.bytedance.android.live.recharge.trace.session.a getSession() {
        Object r0 = this.e.getSession().getValue();
        Intrinsics.checkNotNull(r0);
        return (com.bytedance.android.live.recharge.trace.session.a) r0;
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final Context i() {
        WeakReference<Context> r0 = this.e.getOuterContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final com.bytedance.android.live.revenue.common.reactive.c d() {
        return this.c;
    }

    public final RechargeDialogContext getContext() {
        return this.e;
    }

    public f(RechargeDialogContext r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        this.e = r7;
        PropertyOwner r0 = r7.getRepository().C;
        KProperty[] r1 = f;
        KProperty r2 = r1[0];
        Intrinsics.checkNotNullParameter(r0, "$this$provideDelegate");
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r2, "property");
        this.a = new com.bytedance.android.live.revenue.common.reactive.h(r0);
        com.bytedance.android.live.revenue.common.reactive.c r3 = new com.bytedance.android.live.revenue.common.reactive.c(null);
        this.b = r3;
        this.c = r3;
        n<Order> r4 = r7.getOrder();
        KProperty r5 = r1[1];
        Intrinsics.checkNotNullParameter(r4, "$this$provideDelegate");
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r5, "property");
        this.d = new e(r4);
        com.bytedance.revenue.platform.api.core.rx.f.a(r7.getDealsSelectedEvent().subscribe(new a(this)), r7.getCd());
    }
}
