package com.bytedance.crash.ensure;

import com.bytedance.services.apm.api.IEnsure;
import oo.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f4026a = false;

    public static void a() {
        if (f4026a == true) goto L11;
        f4026a = true;
        IEnsure r5 = new EnsureInitInner$1();     // Catch: Throwable -> L8
        og.a.f20567a.put(IEnsure.class, r5);     // Catch: Throwable -> L8
        j.f20816a = r5;     // Catch: Throwable -> L8
        return;
    L12:
        return;
    }
}
