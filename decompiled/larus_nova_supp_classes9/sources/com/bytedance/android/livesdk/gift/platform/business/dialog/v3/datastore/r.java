package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Unit;
import oc6.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ u a;

    public r(u r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        ds2.d r5 = (ds2.d) r4;
        BehaviorSubject<m0> r6 = this.a.g;
        m0 r0 = new m0();
        r0.b(this.a.k());
        Unit r1 = Unit.INSTANCE;
        r6.onNext(r0);
        this.a.g("observeLoginEvent", new GiftRechargeDataStore$observeLoginEvent$2$2(this));
    }
}
