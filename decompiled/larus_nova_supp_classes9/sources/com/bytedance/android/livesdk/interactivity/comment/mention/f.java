package com.bytedance.android.livesdk.interactivity.comment.mention;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Predicate {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final boolean test(Object r2) {
        CharSequence r3 = (CharSequence) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        if (r3.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
