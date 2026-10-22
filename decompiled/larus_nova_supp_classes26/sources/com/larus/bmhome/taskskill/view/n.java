package com.larus.bmhome.taskskill.view;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n implements com.larus.platform.api.a {
    public final /* synthetic */ String a;
    public final /* synthetic */ PcConnectionStatusManager b;

    public n(String r1, PcConnectionStatusManager r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onSuccess(String r4, String r5) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[handleConnectionStatusAction][startMfaVerify] success, localPcDeviceId=");
        r1.append(this.a);
        r1.append(", deviceName=");
        bs8.a r2 = this.b.f;
        if (r2 == null) goto L5;
        String r3 = r2.a;
    L6:
        r1.append(r3);
        r1.append(", verifyWay=");
        r1.append(r4);
        r0.i("PcConnectionStatusManager", r1.toString());
        PcConnectionStatusManager r6 = this.b;
        String r7 = this.a;
        if (r7 != null) goto L9;
        r7 = "";
    L9:
        r6.a(r7, r5, false);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void a(int r5, String r6, Throwable r7) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[handleConnectionStatusAction][startMfaVerify] failed, localPcDeviceId=");
        bs8.a r2 = this.b.f;
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.e;
    L6:
        r1.append(r4);
        r1.append(", deviceName=");
        bs8.a r8 = this.b.f;
        if (r8 == null) goto L9;
        r3 = r8.a;
    L9:
        r1.append(r3);
        r1.append(", code=");
        r1.append(r5);
        r1.append(", msg=");
        r1.append(r6);
        r0.w("PcConnectionStatusManager", r1.toString(), r7);
        return;
    L5:
        r4 = null;
        goto L6
    }
}
