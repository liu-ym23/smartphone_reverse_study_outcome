package com.larus.api.serviceimpl;

import com.bytedance.awemeopen.servicesapi.log.AoLogService;
import com.bytedance.bdinstall.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class AoEventServiceImpl$d implements f0 {
    public final /* synthetic */ AoEventServiceImpl a;

    public AoEventServiceImpl$d(AoEventServiceImpl r1) {
        this.a = r1;
    }

    public final void d(String r3, Throwable r4) {
        AoLogService r0 = this.a.G2();
        StringBuilder r1 = new StringBuilder();
        r1.append(r3);
        if (r4 == null) goto L5;
        String r5 = r4.toString();
    L6:
        r1.append(r5);
        r0.d("AppLog", r1.toString());
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void e(String r3, Throwable r4) {
        AoLogService r0 = this.a.G2();
        StringBuilder r1 = new StringBuilder();
        r1.append(r3);
        if (r4 == null) goto L5;
        String r5 = r4.toString();
    L6:
        r1.append(r5);
        r0.e("AppLog", r1.toString());
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void i(String r3, Throwable r4) {
        AoLogService r0 = this.a.G2();
        StringBuilder r1 = new StringBuilder();
        r1.append(r3);
        if (r4 == null) goto L5;
        String r5 = r4.toString();
    L6:
        r1.append(r5);
        r0.i("AppLog", r1.toString());
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void v(String r3, Throwable r4) {
        AoLogService r0 = this.a.G2();
        StringBuilder r1 = new StringBuilder();
        r1.append(r3);
        if (r4 == null) goto L5;
        String r5 = r4.toString();
    L6:
        r1.append(r5);
        r0.d("AppLog", r1.toString());
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void w(String r3, Throwable r4) {
        AoLogService r0 = this.a.G2();
        StringBuilder r1 = new StringBuilder();
        r1.append(r3);
        if (r4 == null) goto L5;
        String r5 = r4.toString();
    L6:
        r1.append(r5);
        r0.w("AppLog", r1.toString());
        return;
    L5:
        r5 = null;
        goto L6
    }
}
