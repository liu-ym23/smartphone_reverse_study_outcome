package ox0;

import com.bytedance.android.live.utils.c;
import com.bytedance.android.livesdk.revenue.service.interact.d;
import kotlin.jvm.internal.Intrinsics;
import y11.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public x11.a a;
    public final d b;

    public final int a() {
        int r0 = this.b.getMultiInteractMode();
        x11.a r1 = this.a;
        if (r1 == null) goto L7;
        g r2 = r1.Dn();
        if (r2 == null) goto L7;
        int r3 = r2.a();
    L8:
        int r4 = c.a;
        return r0 | r3;
    L7:
        r3 = 0;
        goto L8
    }

    public a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "revInternalService");
        this.b = r2;
    }
}
