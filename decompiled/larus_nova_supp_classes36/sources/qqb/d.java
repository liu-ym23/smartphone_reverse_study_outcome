package qqb;

import com.suite.component.logger.api.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements f {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final boolean a(com.suite.component.logger.b r3, com.suite.component.logger.c r4) {
        Intrinsics.checkNotNullParameter(r3, "logContext");
        Intrinsics.checkNotNullParameter(r4, "logEntity");
        String r5 = a.d();
        if (Intrinsics.areEqual(r5, "") == true) goto L7;
        r4.b("contextID:" + r5 + ' ' + r4.c);
        return true;
    L7:
        return true;
    }
}
