package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends BaseMVIDataStore<g> implements com.bytedance.android.scope.o {
    public static final /* synthetic */ KProperty[] j = null;
    public final ReadOnlyProperty e;
    public final com.bytedance.android.anya.t f;
    public int g;
    public final CompositeDisposable h;
    public final ny0.a i;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ g a;

        public b(g r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            final oc6.f r4 = (oc6.f) r3;
            GiftPanelBizBoostUtils.E.getClass();
            if (GiftPanelBizBoostUtils.A.e5() == true) goto L5;
        L7:
            this.a.g("ObserveExpansionControlsViewWidth", new GiftExpansionControlsDataStore$onStart$1$1(this, r4));
            return;
        L5:
            if (this.a.g != r4.a()) goto L7;
        }
    }

    static {
        j = new KProperty[]{Reflection.property1(new PropertyReference1Impl(g.class, sz1.a.KEY_WIDTH, "getWidth()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(g.class, "_width", "get_width()I", 0))};
    }

    public final void onStart() {
        RxUtilKt.c(((oc6.j) ny0.a.a.a(this.i, Reflection.getOrCreateKotlinClass(oc6.j.class))).observeExpansionControlsViewWidth().subscribe(new b(this)), this.h);
    }

    public final void onStop() {
        this.h.clear();
    }

    public g(ny0.a r4) {
        Intrinsics.checkNotNullParameter(r4, "rpcService");
        this.i = r4;
        com.bytedance.android.anya.internal.k r5 = i(133).a();
        KProperty[] r0 = j;
        com.bytedance.android.anya.internal.h r6 = r5.a(r0[0]);
        this.e = r6;
        this.f = (com.bytedance.android.anya.t) r6.getValue(this, r0[0]);
        this.h = new CompositeDisposable();
    }
}
