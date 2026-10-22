package g70;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g {
    public static final void a(f r2, j70.f r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$traceFilterDescriptor");
        Intrinsics.checkNotNullParameter(r3, "elementType");
        Intrinsics.checkNotNullParameter(r4, "reason");
        if (r2.a() == false) goto L6;
        r2.log("[" + r2.hashCode() + "]filter descriptor, type is " + r3 + ", reason is " + r4);
        return;
    }
}
