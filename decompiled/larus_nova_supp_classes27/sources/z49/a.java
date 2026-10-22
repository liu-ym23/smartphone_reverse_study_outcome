package z49;

import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final DoraDevice a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        DoraDevice r0 = r2.a;
        if (r0 != null) goto L13;
        r0 = new DoraDevice();
        r0.name = r2.e();
        r0.mac = r2.c();
        r0.sn = r2.h();
        r0.model = r2.d();
        r0.softVersion = r2.i();
        Integer r1 = r2.f();
        if (r1 == null) goto L7;
        int r3 = r1.intValue();
    L8:
        r0.productId = r3;
        Integer r4 = r2.g();
        if (r4 == null) goto L11;
        int r5 = r4.intValue();
    L12:
        r0.sku = r5;
        r0.caseSoftVersion = r2.b();
        goto L13
    L11:
        r5 = 0;
        goto L12
    L7:
        r3 = 1;
    L13:
        return r0;
    }
}
