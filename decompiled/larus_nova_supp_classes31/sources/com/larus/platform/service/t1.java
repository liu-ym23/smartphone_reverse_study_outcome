package com.larus.platform.service;

import android.content.Context;
import com.larus.bmhome.chat.map.p;
import com.larus.platform.api.y2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class t1 implements y2 {
    public static final t1 a = null;
    public static final Lazy b = null;

    public t1() {
    }

    static {
        a = new t1();
        b = LazyKt.lazy(new s1());
    }

    @Override // com.larus.platform.api.y2
    public final String c() {
        y2 r0 = (y2) b.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    @Override // com.larus.platform.api.y2
    public final boolean d() {
        y2 r0 = (y2) b.getValue();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.d() != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.y2
    public final wq9.e a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        y2 r0 = (y2) b.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(r2);
    }

    @Override // com.larus.platform.api.y2
    public final void b(Context r2, p r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        y2 r0 = (y2) b.getValue();
        if (r0 == null) goto L6;
        r0.b(r2, r3);
        return;
    }
}
