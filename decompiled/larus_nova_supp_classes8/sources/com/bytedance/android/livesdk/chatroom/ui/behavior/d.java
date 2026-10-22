package com.bytedance.android.livesdk.chatroom.ui.behavior;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d<T> implements Predicate {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final boolean test(Object r2) {
        Boolean r3 = (Boolean) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.booleanValue();
    }
}
