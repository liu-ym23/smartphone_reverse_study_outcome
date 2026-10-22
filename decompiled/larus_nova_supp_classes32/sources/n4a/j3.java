package n4a;

import android.content.Context;
import android.os.Handler;
import com.mammon.audiosdk.SAMICoreCode;
import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j3 extends h3<k3> {
    public j3(Context r2, Handler r3) {
        super(r2, "cellAge", r3);
    }

    @Override // n4a.h3
    public final long c() {
        return SAMICoreCode.SAMI_EXTRACTOR_BASE;
    }

    @Override // n4a.h3
    public final long g() {
        return 100;
    }

    @Override // n4a.h3
    public final String d(k3 r1) {
        k3 r2 = r1;
        if (r2 != null) goto L6;
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        return r2.a();
    }

    @Override // n4a.h3
    public final int f(k3 r1) {
        k3 r2 = r1;
        if (r2 != null) goto L6;
        return 99;
    L6:
        return r2.r;
    }

    @Override // n4a.h3
    public final long h(k3 r3) {
        k3 r4 = r3;
        if (r4 != null) goto L6;
        return 0;
    L6:
        return r4.s;
    }

    @Override // n4a.h3
    public final void a(k3 r1, long r2) {
        k3 r3 = r1;
        if (r3 == null) goto L6;
        r3.s = r2;
        return;
    }
}
