package com.bytedance.crypto.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile n f2229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f2230b;
    public final Context c;

    public n(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.c = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
        this.f2230b = m.a(r4);
    }

    public static j a(j r2) {
        j r0 = new j();
        r0.f2224a = r2.f2224a;
        r0.f2225b = r2.f2225b;
        r0.c = r2.c;
        r0.d = r2.d;
        r0.e = r2.e;
        r0.f = r2.f;
        r0.g = r2.g;
        r0.h = r2.h;
        r0.i = r2.i;
        r0.j = r2.j;
        r0.k = r2.k;
        r0.l = r2.l;
        r0.m = r2.m;
        return r0;
    }

    public static n a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (f2229a != null) goto L15;
        monitor-enter(n.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2229a != null) goto L9;
        f2229a = new n(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(n.class);     // Catch: Throwable -> L11
    L15:
        return f2229a;
    }
}
