package com.bytedance.apm.l;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile ExecutorService f1402a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f1404a = null;

        static {
            f1404a = new c(null);
        }
    }

    private c() {
        this.f1402a = Executors.newFixedThreadPool(1, new AnonymousClass1(this));
    }

    /* synthetic */ c(AnonymousClass1 r1) {
        this();
    }

    public static c a() {
        if (com.bytedance.apm.b.l() == true) goto L5;
        return null;
    L5:
        return a.f1404a;
    }

    public void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        this.f1402a.submit(r4);
    }
}
