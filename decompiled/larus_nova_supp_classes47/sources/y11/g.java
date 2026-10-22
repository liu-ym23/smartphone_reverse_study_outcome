package y11;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public final com.bytedance.android.live.revlink.impl.global.c a;
    public final x11.a b;

    public final int a() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.service.internal.a r1 = r0.Do();
    L6:
        if (r1 != null) goto L10;
        return 0;
    L10:
        return r1.getCurrentMode();
    L5:
        r1 = null;
        goto L6
    }

    public g(com.bytedance.android.live.revlink.impl.global.c r2, x11.a r3) {
        Intrinsics.checkNotNullParameter(r3, "internalLinkService");
        this.a = r2;
        this.b = r3;
    }
}
