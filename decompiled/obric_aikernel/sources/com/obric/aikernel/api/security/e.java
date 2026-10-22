package com.obric.aikernel.api.security;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class e implements com.obric.aikernel.api.d {
    public e() {
    }

    public void a() {
    }

    public void b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "baseUrl");
    }

    public TlsBootstrapState c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "baseUrl");
        return TlsBootstrapState.NOT_REQUIRED;
    }

    public boolean d(String r10) {
        Intrinsics.checkNotNullParameter(r10, "baseUrl");
        return true;
    }
}
