package com.bytedance.applog.log;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class f implements a {
    public f() {
    }

    @Override // com.bytedance.applog.log.a
    public final void a(String r2, Function0<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "message");
    }

    @Override // com.bytedance.applog.log.a
    public final void b(String r1, Throwable r2, Function0<String> r3) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r3, "message");
    }
}
