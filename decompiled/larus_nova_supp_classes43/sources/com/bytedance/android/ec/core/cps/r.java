package com.bytedance.android.ec.core.cps;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r implements k {
    public static final r a = null;

    public r() {
    }

    static {
        a = new r();
    }

    @Override // com.bytedance.android.ec.core.cps.k
    public final String encode(String r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        return j.b(r10, 256);
    L5:
        return null;
    }
}
