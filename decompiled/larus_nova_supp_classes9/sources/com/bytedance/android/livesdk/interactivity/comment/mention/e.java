package com.bytedance.android.livesdk.interactivity.comment.mention;

import android.text.TextUtils;
import io.reactivex.functions.BiPredicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T1, T2> implements BiPredicate {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final boolean test(Object r2, Object r3) {
        CharSequence r4 = (CharSequence) r2;
        CharSequence r5 = (CharSequence) r3;
        Intrinsics.checkNotNullParameter(r4, "a");
        Intrinsics.checkNotNullParameter(r5, "b");
        return TextUtils.equals(r4, r5);
    }
}
