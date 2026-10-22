package com.obric.aiagent.product.platform.impl.pocketmode;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.aiagent.platform.depend.ILogDepend;
import iaa.h;
import kotlin.jvm.internal.Intrinsics;
import ona.a;
import ona.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e implements Runnable {
    public e() {
    }

    public static void a() {
        if (CommonPocketModeDetector.h == true) goto L16;
        int r0 = CommonPocketModeDetector.a;
        Sensor r1 = CommonPocketModeDetector.b.a();
        if (r1 == null) goto L17;
        CommonPocketModeDetector.h = true;
        SensorManager r2 = CommonPocketModeDetector.b.b();
        CommonPocketModeDetector.a r3 = CommonPocketModeDetector.g;
        Handler r4 = h.a;
        int r5 = 0;
        if (fna.g.d() == true) goto L10;
        Boolean r6 = Boolean.valueOf(r2.registerListener(r3, r1, 0, r4));
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Boolean");
        r6.booleanValue();
    L14:
        ILogDepend.a.i("CommonPocketModeDetector", "sensor registered");
        return;
    L10:
        Boolean r7 = Boolean.valueOf(r2.registerListener(r3, r1, 0, r4));
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.Boolean");
        r7.booleanValue();
        if (r3 == null) goto L13;
        r5 = r3.hashCode();
    L13:
        b.a(new a(r5, Integer.valueOf(r1.hashCode())));
        goto L14
    L17:
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
