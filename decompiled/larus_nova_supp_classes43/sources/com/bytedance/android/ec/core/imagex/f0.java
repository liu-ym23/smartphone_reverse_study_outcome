package com.bytedance.android.ec.core.imagex;

import com.bytedance.pitaya.api.feature.IFeatureCore;
import com.bytedance.pitaya.api.feature.IKVStore;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f0 implements Runnable {
    public static final f0 a = null;

    static {
        a = new f0();
    }

    public f0() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        IFeatureCore r0 = j0.a;     // Catch: Throwable -> L18
        IKVStore r1 = j0.b;     // Catch: Throwable -> L18
        Object r10 = null;
        if (r1 == null) goto L5;
        Object r11 = r1.getValueForKey("cache_key_scroll_mode");     // Catch: Throwable -> L18
    L6:
        if (r11 != null) goto L8;
    L16:
        j0.c = System.currentTimeMillis();     // Catch: Throwable -> L18
        return;
    L8:
        if ((r11 instanceof Integer) == false) goto L11;
        r10 = r11;
    L11:
        Integer r12 = (Integer) r10;     // Catch: Throwable -> L18
        if (r12 == null) goto L14;
        int r13 = r12.intValue();     // Catch: Throwable -> L18
    L15:
        int r14 = g0.a;     // Catch: Throwable -> L18
        g0.b = r13;     // Catch: Throwable -> L18
        goto L16
    L14:
        r13 = 0;
        goto L15
    L5:
        r11 = null;
    L18:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L22;
        return;
    L22:
        throw th;
    }
}
