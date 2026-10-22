package com.bytedance.android.btm.impl.page.lifecycle.layer1_outer;

import android.os.SystemClock;
import com.bytedance.android.btm.api.BtmPageLifecycle;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.model.PageInfoStack;
import com.bytedance.android.btm.impl.page.model.c;
import com.bytedance.android.btm.impl.util.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class NativeStateWriter {
    static {
    }

    public static void b(Object r10) {
        String r0 = BtmPageRecorder.a;
        PageInfoStack r1 = BtmPageRecorder.k(r10);
        if (r1 == null) goto L5;
        r1.setNativeState(BtmPageLifecycle.State.CREATED);
        a("onCreated", r10);
    L5:
        c r11 = BtmPageRecorder.h(r10);
        if (r11 == null) goto L9;
        r11.b = BtmPageLifecycle.State.CREATED;
        return;
    }

    public static void c(Object r10) {
        String r0 = BtmPageRecorder.a;
        PageInfoStack r1 = BtmPageRecorder.k(r10);
        if (r1 == null) goto L5;
        r1.setNativeState(BtmPageLifecycle.State.DESTROYED);
        a("onDestroyed", r10);
    L5:
        if (r10 == null) goto L9;
        BtmPageRecorder.f.remove(new f(r10));
        return;
    }

    public static void d(Object r10) {
        String r0 = BtmPageRecorder.a;
        PageInfoStack r1 = BtmPageRecorder.k(r10);
        if (r1 == null) goto L5;
        r1.setNativeState(BtmPageLifecycle.State.PAUSED);
        a("onPaused", r10);
    L5:
        c r11 = BtmPageRecorder.h(r10);
        if (r11 == null) goto L9;
        r11.b = BtmPageLifecycle.State.PAUSED;
        r11.a = 0;
        return;
    }

    public static void e(Object r10) {
        String r0 = BtmPageRecorder.a;
        PageInfoStack r1 = BtmPageRecorder.k(r10);
        if (r1 == null) goto L5;
        r1.setNativeState(BtmPageLifecycle.State.RESUMED);
        a("onResumed", r10);
    L5:
        c r11 = BtmPageRecorder.h(r10);
        if (r11 == null) goto L9;
        r11.b = BtmPageLifecycle.State.RESUMED;
        r11.a = SystemClock.elapsedRealtime();
        return;
    }

    public static void a(String r10, Object r11) {
        final String r12 = r11.getClass().getCanonicalName();
        ALogger.e(ALogger.d, "NativeStateWriter_".concat(r10), new NativeStateWriter$log$1(r12));
    }
}
