package com.larus.platform.service;

import com.larus.platform.api.x1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c0 implements x1 {
    public static final c0 a = null;
    public static final Lazy b = null;

    public c0() {
    }

    static {
        a = new c0();
        b = LazyKt.lazy(new b0());
    }

    @Override // com.larus.platform.api.x1
    public final void a(String r3) {
        Intrinsics.checkNotNullParameter("ZlinkSdkManager_dealWithClipboard", "scene");
        x1 r0 = (x1) b.getValue();
        if (r0 == null) goto L6;
        r0.a(r3);
        return;
    }
}
