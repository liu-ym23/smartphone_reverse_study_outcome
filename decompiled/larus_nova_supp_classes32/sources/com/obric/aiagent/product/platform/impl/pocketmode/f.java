package com.obric.aiagent.product.platform.impl.pocketmode;

import android.hardware.SensorManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.aiagent.platform.depend.ILogDepend;
import ona.a;
import ona.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f implements Runnable {
    public f() {
    }

    public static void a() {
        if (CommonPocketModeDetector.h == false) goto L15;
        int r0 = 0;
        CommonPocketModeDetector.h = false;
        int r1 = CommonPocketModeDetector.a;
        if (CommonPocketModeDetector.b.a() == null) goto L16;
        SensorManager r2 = CommonPocketModeDetector.b.b();
        CommonPocketModeDetector.a r3 = CommonPocketModeDetector.g;
        if (fna.g.d() == true) goto L9;
        r2.unregisterListener(r3);
    L13:
        ILogDepend.a.i("CommonPocketModeDetector", "sensor unregistered");
        return;
    L9:
        r2.unregisterListener(r3);
        if (r3 == null) goto L12;
        r0 = r3.hashCode();
    L12:
        b.c(new a(r0, null));
        goto L13
    L16:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
