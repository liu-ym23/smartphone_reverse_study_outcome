package com.privacy.azerothprivacy.alarm.receiver;

import android.content.Context;
import android.content.Intent;
import com.privacy.azerothprivacy.AzerothPrivacy;
import toa.a;
import toa.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class KeyAgreementUpdater extends AzerothCustomReceiver {
    @Override // com.privacy.azerothprivacy.alarm.receiver.AzerothCustomReceiver
    public final long a() {
        Context r0 = AzerothPrivacy.getAppContext();
        String r1 = a.a;
        epa.a r2 = epa.a.b(r0);
        String r3 = "KeyExpireTimeInUnixSeconds" + AzerothPrivacy.getAppInfo().e;
        r2.getClass();
        long r4 = epa.a.c(r3);
        long r5 = 10000;
        if (r4 <= 0) goto L8;
        long r6 = (r4 * 1000) - System.currentTimeMillis();
        if (r6 >= 10000) goto L7;
        return 10000;
    L7:
        r5 = r6;
    L8:
        apa.a.a("KeyAgreementUpdater", "get next interval is " + r5);
        return r5;
    }

    public KeyAgreementUpdater() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r2, Intent r3) {
        apa.a.a("KeyAgreementUpdater", "key agreement cron job start");
        d r4 = d.h;
        monitor-enter(r4);
        r4.c(r2, AzerothPrivacy.getAppInfo().e);     // Catch: Throwable -> L7
        monitor-exit(r4);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
