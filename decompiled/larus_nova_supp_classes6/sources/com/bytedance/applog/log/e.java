package com.bytedance.applog.log;

import com.bytedance.bdinstall.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class e implements j {
    public final f0 a;

    public e(f0 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.applog.log.j
    public final void a(k r4) {
        f0 r0 = this.a;
        if (r0 == null) goto L18;
        int r1 = r4.c;
        if (r1 != 1) goto L7;
        r0.d(r4.b(), r4.h);
        return;
    L7:
        if (r1 != 2) goto L9;
        r0.i(r4.b(), r4.h);
        return;
    L9:
        if (r1 != 3) goto L11;
        r0.w(r4.b(), r4.h);
        return;
    L11:
        if (r1 == 4) goto L13;
        r0.v(r4.b(), r4.h);
        return;
    L13:
        r0.e(r4.b(), r4.h);
        return;
    }
}
