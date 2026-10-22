package com.larus.platform.service;

import com.larus.im.bean.message.Message;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b3 implements com.larus.platform.api.o3 {
    public static final b3 a = null;
    public static final Lazy b = null;

    public b3() {
    }

    static {
        a = new b3();
        b = LazyKt.lazy(new a3());
    }

    public static com.larus.platform.api.o3 e() {
        return (com.larus.platform.api.o3) b.getValue();
    }

    @Override // com.larus.platform.api.o3
    public final boolean a() {
        com.larus.platform.api.o3 r0 = e();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.a() != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.o3
    public final int b(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        com.larus.platform.api.o3 r0 = e();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.b(r2);
    }

    @Override // com.larus.platform.api.o3
    public final int c(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        com.larus.platform.api.o3 r0 = e();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.c(r2);
    }

    @Override // com.larus.platform.api.o3
    public final String d(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        com.larus.platform.api.o3 r0 = e();
        if (r0 == null) goto L6;
        String r3 = r0.d(r2);
        if (r3 == null) goto L6;
        return r3;
    L6:
        return "";
    }
}
