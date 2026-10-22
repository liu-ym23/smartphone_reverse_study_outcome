package com.larus.community.impl.applet;

import android.app.Activity;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ int a;

    public /* synthetic */ l(int r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = this.a;
        List r1 = AppHost.a.a().g();
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L15;
        Object r4 = r3.next();
        Activity r5 = (Activity) r4;
        if (r5.getTaskId() == r0) goto L8;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        if (r5.isFinishing() == true) goto L12;
        if (r5.isDestroyed() == true) goto L12;
        r6 = true;
        goto L13
    L15:
        Iterator r7 = r2.iterator();
    L17:
        if (r7.hasNext() == false) goto L19;
        Activity r8 = (Activity) r7.next();
        FLogger.a.i("AICreationAppletNavigator", "finish AI creation applet task activity=".concat(r8.getClass().getSimpleName()));
        r8.finish();
        goto L17
    }
}
