package r31;

import com.bytedance.android.live.revlink.impl.global.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final a a(a.C0307a r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$get");
        c r2 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r2 == null) goto L5;
        a r3 = r2.getLinkNetwork();
    L6:
        if (r3 == null) goto L9;
        return r3;
    L9:
        return new s31.a(null, null);
    L5:
        r3 = null;
        goto L6
    }
}
