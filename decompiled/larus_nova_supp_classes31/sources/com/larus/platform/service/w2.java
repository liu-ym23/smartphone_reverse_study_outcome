package com.larus.platform.service;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w2 implements com.larus.platform.api.n3 {
    public static final w2 a = null;
    public static final Lazy b = null;

    public w2() {
    }

    static {
        a = new w2();
        b = LazyKt.lazy(new v2());
    }

    @Override // com.larus.platform.api.n3
    public final List k() {
        Intrinsics.checkNotNullParameter("chat_settings", "page");
        com.larus.platform.api.n3 r0 = (com.larus.platform.api.n3) b.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.k();
    }
}
