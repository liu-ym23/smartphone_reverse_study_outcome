package com.bytedance.android.live.revlink.link.domain.streammix;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T> implements Comparator {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r5, Object r6) {
        com.bytedance.android.live.revlink.link.domain.service.d r7 = (com.bytedance.android.live.revlink.link.domain.service.d) r5;
        com.bytedance.android.live.revlink.link.domain.service.d r8 = (com.bytedance.android.live.revlink.link.domain.service.d) r6;
        Intrinsics.checkNotNullParameter(r7, "wrapL");
        Intrinsics.checkNotNullParameter(r8, "wrapR");
        if (r7.b.f() == r8.b.f()) goto L8;
        if (r7.b.f() >= r8.b.f()) goto L14;
    L6:
        return -1;
    L14:
        return 1;
    L8:
        if (r7.b.e() != r8.b.e()) goto L10;
        return 0;
    L10:
        if (r7.b.e() < r8.b.e()) goto L6;
        return 1;
    }
}
