package com.bytedance.android.live.liveinteract.voicechat.util;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements Runnable {
    public static final List<b> a = null;
    public static final Handler b = null;
    public static boolean c;
    public static final c d = null;

    public c() {
    }

    static {
        d = new c();
        a = new ArrayList();
        b = new Handler(Looper.getMainLooper());
    }

    public final void a() {
        ArrayList r0 = new ArrayList();
        r0.addAll(a);
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        ((b) r1.next()).c(1);
        goto L4
    L7:
        if (((ArrayList) a).size() != 0) goto L9;
        b.removeCallbacks(this);
        c = false;
    L9:
        b.postDelayed(this, 1000);
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

    public static void c(b r2) {
        Intrinsics.checkNotNullParameter(r2, "timerCallback");
        ArrayList r0 = (ArrayList) a;
        if (r0.contains(r2) == false) goto L6;
        r0.remove(r2);
        return;
    }

    public final void b(b r3) {
        Intrinsics.checkNotNullParameter(r3, "timerCallback");
        List<b> r0 = a;
        if (((ArrayList) r0).contains(r3) == false) goto L5;
        return;
    L5:
        ((ArrayList) r0).add(r3);
        if (c == true) goto L9;
        Handler r4 = b;
        r4.removeCallbacks(this);
        r4.post(this);
        c = true;
        return;
    }
}
