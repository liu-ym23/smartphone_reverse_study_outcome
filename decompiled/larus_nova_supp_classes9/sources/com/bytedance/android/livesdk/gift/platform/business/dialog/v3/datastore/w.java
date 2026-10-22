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
public final class w extends BaseMVIDataStore<w> implements com.bytedance.android.scope.o {
    public static final /* synthetic */ KProperty[] i = null;
    public final ReadOnlyProperty e;
    public final com.bytedance.android.anya.t f;
    public final CompositeDisposable g;
    public final ny0.a h;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ w a;

        public a(w r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            final oc6.b r6 = (oc6.b) r5;
            GiftPanelBizBoostUtils.E.getClass();
            if (GiftPanelBizBoostUtils.A.f8() == false) goto L7;
            w r0 = this.a;
            if (((Number) r0.f.getValue(r0, w.i[1])).intValue() != r6.a()) goto L7;
            return;
        L7:
            this.a.g("ObserveAboveComponentSize_" + r6.a(), new GiftTopPanelDataStore$onStart$1$1(this, r6));
        }
    }

    static {
        i = new KProperty[]{Reflection.property1(new PropertyReference1Impl(w.class, "componentHeight", "getComponentHeight()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(w.class, "_height", "get_height()I", 0))};
    }

    public final void onStart() {
        RxUtilKt.c(((oc6.u) ny0.a.a.a(this.h, Reflection.getOrCreateKotlinClass(oc6.u.class))).observeAboveComponentSize().subscribe(new a(this)), this.g);
    }

    public final void onStop() {
        this.g.clear();
    }

    public w(ny0.a r4) {
        Intrinsics.checkNotNullParameter(r4, "rpcService");
        this.h = r4;
        com.bytedance.android.anya.internal.k r0 = i(0).a();
        KProperty[] r1 = i;
        com.bytedance.android.anya.internal.h r2 = r0.a(r1[0]);
        this.e = r2;
        this.f = (com.bytedance.android.anya.t) r2.getValue(this, r1[0]);
        this.g = new CompositeDisposable();
    }
}
