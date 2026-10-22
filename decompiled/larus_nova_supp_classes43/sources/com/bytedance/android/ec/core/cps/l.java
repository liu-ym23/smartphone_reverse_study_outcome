package com.bytedance.android.ec.core.cps;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l implements k {
    public static final l a = null;

    public l() {
    }

    static {
        a = new l();
    }

    @Override // com.bytedance.android.ec.core.cps.k
    public final String encode(String r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        return j.a(r10, "MD5");
    L5:
        return null;
    }
}
