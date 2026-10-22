package com.bytedance.apm.util;

import android.os.Looper;
import com.bytedance.apm.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ib.d f3909a = null;

    static {
        ib.d r5 = new ib.d(4);
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        Throwable r10 = new Throwable("Don't use DeviceInfoUtil on main thread.");
        z6.b.f23409a.d(new b(0, r10));
    L5:
        boolean r11 = j.f3887a;
        f3909a = r5;
    }
}
