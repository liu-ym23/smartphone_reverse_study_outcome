package com.bytedance.android.ec.core.cps;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class u implements k {
    public static final u a = null;

    public u() {
    }

    static {
        a = new u();
    }

    @Override // com.bytedance.android.ec.core.cps.k
    public final String encode(String r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        return j.a(r10, "SHA-512");
    L5:
        return null;
    }
}
