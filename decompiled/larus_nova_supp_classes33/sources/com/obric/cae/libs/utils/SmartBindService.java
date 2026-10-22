package com.obric.cae.libs.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class SmartBindService {
    public final Context a;
    public final ServiceConnection b;
    public final String c;
    public final String d;

    public void smartBindToService() {
        Context r0 = this.a;
        Intent r1 = new Intent(this.c);
        List<ResolveInfo> r2 = r0.getPackageManager().queryIntentServices(r1, 0);
        if (r2 == null) goto L10;
        Iterator<ResolveInfo> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        String r4 = r3.next().serviceInfo.packageName;
        if (r4.equals(r0.getPackageName()) == true) goto L6;
    L12:
        if (r4 == null) goto L16;
        Intent r5 = new Intent(this.c);
        r5.setPackage(r4);
        this.a.bindService(r5, this.b, 1);     // Catch: Throwable -> L26
        return;
    L38:
        return;
    L16:
        String r6 = this.d;
        if (r6 != null) goto L19;
        return;
    L19:
        if (r6.isEmpty() == true) goto L36;
        ComponentName r7 = new ComponentName(this.a.getPackageName(), this.d);
        Intent r8 = new Intent();
        r8.setComponent(r7);
        r8.setAction(this.c);
        this.a.bindService(r8, this.b, 1);     // Catch: Exception -> L24
        return;
    L25:
        return;
    L36:
        return;
    L10:
        r4 = null;
        goto L12
    }

    public SmartBindService(Context r1, ServiceConnection r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
