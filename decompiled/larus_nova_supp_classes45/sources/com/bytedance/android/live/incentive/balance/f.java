package com.bytedance.android.live.incentive.balance;

import com.bytedance.android.scope.o;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import pa0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements o, d {
    public final HashMap<b, c> a;

    public final void onStop() {
    }

    public final void onStart() {
        if (va0.a.a == false) goto L5;
        a(new pa0.a());
        a(new pa0.d());
        a(new pa0.b());
        return;
    L5:
        a(new pa0.c());
    }

    public f() {
        this.a = new HashMap();
    }

    public final void a(l r3) {
        Intrinsics.checkNotNullParameter(r3, "provider");
        b r0 = r3.a();
        if ((!this.a.containsKey(r0)) == false) goto L7;
        this.a.put(r0, r3);
        return;
    L7:
        throw new IllegalStateException(("Re-register of currency type " + r0).toString());
    }

    @Override // com.bytedance.android.live.incentive.balance.d
    public final Long c(b r2) {
        Intrinsics.checkNotNullParameter(r2, "currencyType");
        c r3 = this.a.get(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.b();
    }

    @Override // com.bytedance.android.live.incentive.balance.d
    public final Completable d(e r4) {
        Intrinsics.checkNotNullParameter(r4, "request");
        HashMap<b, c> r0 = this.a;
        ArrayList r1 = new ArrayList(r0.size());
        Iterator<Map.Entry<b, c>> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        r1.add(r2.next().getValue().c(r4));
        goto L4
    L7:
        return Observable.mergeDelayError(r1).ignoreElements().onErrorComplete();
    }
}
