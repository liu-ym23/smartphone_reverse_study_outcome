package com.bytedance.applog.f;

import android.os.Process;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class a implements Thread.UncaughtExceptionHandler {
    private static final com.bytedance.applog.log.b<a> c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArraySet<b> f1588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f1589b;

    static {
        c = new AnonymousClass1();
    }

    private a() {
        this.f1588a = new CopyOnWriteArraySet();
        this.f1589b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /* synthetic */ a(AnonymousClass1 r1) {
        this();
    }

    public static a a() {
        return (a) ZeusTransformUtils.preCheckCast(c.c(new Object[0]), a.class, "com.obric.memorydata.plugin");
    }

    private void a(Thread r1, Throwable r2) {
        Thread.UncaughtExceptionHandler r0 = this.f1589b;
        if (r0 == null) goto L8;
        r0.uncaughtException(r1, r2);
        return;
    L8:
        Process.killProcess(Process.myPid());     // Catch: Throwable -> L7
        System.exit(10);     // Catch: Throwable -> L7
        return;
    }

    public void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        this.f1588a.add(r4);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread r5, Throwable r6) {
        Iterator<b> r0 = this.f1588a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.memorydata.plugin")).a(r5, r6);
        goto L4
    L6:
        a(r5, r6);
    }
}
