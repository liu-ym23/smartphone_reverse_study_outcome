package n4a;

import android.content.Context;
import android.os.Handler;
import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q3 extends h3<v2> {
    public q3(Context r2, Handler r3) {
        super(r2, "wifiAgee", r3);
    }

    @Override // n4a.h3
    public final long c() {
        return 60000;
    }

    @Override // n4a.h3
    public final long g() {
        return 1000;
    }

    @Override // n4a.h3
    public final String d(v2 r4) {
        v2 r5 = r4;
        if (r5 != null) goto L6;
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        return r5.h + "#" + r5.a;
    }

    @Override // n4a.h3
    public final int f(v2 r1) {
        v2 r2 = r1;
        if (r2 != null) goto L6;
        return -113;
    L6:
        return r2.c;
    }

    @Override // n4a.h3
    public final long h(v2 r3) {
        v2 r4 = r3;
        if (r4 != null) goto L6;
        return 0;
    L6:
        return r4.f;
    }

    @Override // n4a.h3
    public final void a(v2 r1, long r2) {
        v2 r3 = r1;
        if (r3 == null) goto L6;
        r3.f = r2;
        return;
    }
}
