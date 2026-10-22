package com.bytedance.android.live.core.verify.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements a.d {
    public final /* synthetic */ a.e a;

    public b(a.C0174a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.core.verify.utils.a.d
    public final void a(String r12) {
        String r13 = a.d();
        r13.getClass();
        if (r13.equals("self") == false) goto L5;
        int r4 = 2;
    L9:
        a.C0174a r14 = (a.C0174a) this.a;
        a.o(r14.a, r14.b, r14.c, r14.d, r4, r14.e, true, r14.f, r14.g, false, r14.h);
        return;
    L5:
        if (r13.equals("ali_cloud") == true) goto L7;
        r4 = 0;
        goto L9
    L7:
        r4 = 3;
        goto L9
    }
}
