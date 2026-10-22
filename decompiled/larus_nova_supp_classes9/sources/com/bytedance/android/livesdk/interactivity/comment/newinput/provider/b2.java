package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.text.TextUtils;
import io.reactivex.functions.BiPredicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b2<T1, T2> implements BiPredicate {
    public final /* synthetic */ t1.c a;

    public b2(t1.c r1) {
        this.a = r1;
    }

    public final boolean test(Object r3, Object r4) {
        String r5 = (String) r3;
        String r6 = (String) r4;
        Intrinsics.checkNotNullParameter(r5, "a");
        Intrinsics.checkNotNullParameter(r6, "b");
        t1.c r0 = this.a;
        if (r0.l == false) goto L6;
        r0.l = false;
        return false;
    L6:
        return TextUtils.equals(r5, r6);
    }
}
