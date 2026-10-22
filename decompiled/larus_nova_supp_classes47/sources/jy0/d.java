package jy0;

import com.bytedance.android.scope.m;
import cy0.j;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public static final void a(int r2, String r3, StackTraceElement[] r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        cy0.e.a.getClass();
        j r0 = cy0.e.a.a;
        m.e.getClass();
        Object r1 = m.b(r0).a(Reflection.getOrCreateKotlinClass(c.class));
        Intrinsics.checkNotNull(r1);
        ((c) ((f80.a) r1)).stacktrace(r2, r3, r4);
    }
}
