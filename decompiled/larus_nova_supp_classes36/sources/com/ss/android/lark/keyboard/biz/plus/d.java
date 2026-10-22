package com.ss.android.lark.keyboard.biz.plus;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d<T> implements Comparator {
    public static final d<T> a = null;

    static {
        a = new d();
    }

    public d() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r2, Object r3) {
        d5b.a r4 = (d5b.a) r2;
        d5b.a r5 = (d5b.a) r3;
        Intrinsics.checkNotNullParameter(r4, "o1");
        Intrinsics.checkNotNullParameter(r5, "o2");
        return r4.e() - r5.e();
    }
}
