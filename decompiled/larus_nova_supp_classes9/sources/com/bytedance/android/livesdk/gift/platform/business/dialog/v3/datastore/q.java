package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q<T> implements Predicate {
    public static final q a = null;

    static {
        a = new q();
    }

    public q() {
    }

    public final boolean test(Object r2) {
        ds2.d r3 = (ds2.d) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        if (r3.b != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.a == false) goto L7;
        return true;
    }
}
