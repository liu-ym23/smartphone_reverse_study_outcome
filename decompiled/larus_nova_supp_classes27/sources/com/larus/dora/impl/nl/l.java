package com.larus.dora.impl.nl;

import android.service.notification.StatusBarNotification;
import pk4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ NLService a;
    public final /* synthetic */ StatusBarNotification b;

    public /* synthetic */ l(NLService r1, StatusBarNotification r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NLService r0 = this.a;
        StatusBarNotification r1 = this.b;
        NLServiceImpl r2 = NLService.g;
        if (r1 == null) goto L32;
        r0.getClass();
        c49.a r3 = NLService.b(r1);
        String r4 = r3.c;
        if (r4 != null) goto L7;
        return;
    L7:
        if (r4.equals(n.c.getPackageName()) == false) goto L35;
        int r5 = kj4.a.g().getDoraState();
        if (r5 == 2) goto L11;
        g49.d.d("ProactiveSummaryRecords", "Abandon this DouBao push title is " + r3.e + " because doraState is " + r5);
        return;
    L11:
        boolean r6 = true;
        if (n.c() == true) goto L14;
    L16:
        boolean r7 = false;
    L18:
        if (((Boolean) DoraUserSettingsManager.o.getValue()).booleanValue() == true) goto L20;
    L22:
        boolean r8 = false;
    L23:
        if (r7 == true) goto L27;
        if (r8 == true) goto L27;
        r6 = false;
    L27:
        if (r6 == false) goto L31;
        NLServiceImpl r9 = NLService.g;
        if (r9 == null) goto L31;
        r9.a(r3);
        return;
    L31:
        g49.d.d("ProactiveSummaryRecords", "Abandon this DouBao push title is " + r3.e + " because isNLOpen is " + r7 + " isAIPushOpen is " + r8 + " doraState is " + r5);
        return;
    L20:
        if (n.a() == false) goto L22;
        r8 = true;
        goto L23
    L14:
        if (n.b() == false) goto L16;
        r7 = true;
        goto L18
    L35:
        return;
    L32:
        r0.getClass();
        g49.d.d("ProactiveSummaryRecords", "Abandon this DouBao push because sbn is null");
    }
}
