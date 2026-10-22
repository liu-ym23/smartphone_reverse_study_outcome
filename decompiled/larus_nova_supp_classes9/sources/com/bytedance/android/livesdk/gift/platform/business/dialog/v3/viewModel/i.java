package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T> implements Predicate {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final boolean test(Object r2) {
        Boolean r3 = (Boolean) r2;
        Intrinsics.checkNotNullParameter(r3, "intercept");
        return !r3.booleanValue();
    }
}
