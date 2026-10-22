package com.bytedance.common.utility.a;

import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final AtomicInteger f1972a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ExecutorService f1973b;
    private static ExecutorService c;
    private Runnable d;
    private final boolean e;

    static {
        f1973b = a.a();
        c = a.a();
        f1972a = new AtomicInteger();
    }

    public c() {
        this(false);
    }

    public c(Runnable r2, String r3, boolean r4) {
        this.d = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        this.e = r4;
    }

    public c(String r1) {
        this(false);
    }

    public c(boolean r1) {
        this.e = r1;
    }

    public static void a(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        f1973b.submit(r3);
        return;
    }

    public void a() {
        if (Logger.debug() == false) goto L5;
        Runnable r0 = new AnonymousClass1(this);
    L7:
        if (this.e == false) goto L9;
        ExecutorService r1 = c;
    L10:
        r1.submit(r0);
        return;
    L9:
        r1 = f1973b;
        goto L10
    L5:
        r0 = this;
        goto L7
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable r0 = this.d;
        if (r0 == null) goto L6;
        r0.run();
        return;
    }
}
