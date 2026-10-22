package com.bytedance.monitor.util.thread.a;

import com.bytedance.monitor.util.thread.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2897b;
    private e c;
    private InterfaceC0146a d;

    /* JADX INFO: renamed from: com.bytedance.monitor.util.thread.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0146a {
        void a(long r1);
    }

    public a(String r3) {
        this.f2896a = getClass().getSimpleName();
        this.f2897b = "APM_" + r3;
    }

    static /* synthetic */ InterfaceC0146a a(a r0) {
        return r0.d;
    }

    static /* synthetic */ e b(a r0) {
        return r0.c;
    }

    public void a(InterfaceC0146a r3) {
        this.d = (InterfaceC0146a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0146a.class, "com.obric.memorydata.plugin");
    }

    public void a(e r3) {
        this.c = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r3) {
        final Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        return new Thread(new AnonymousClass1(this, r4), this.f2897b);
    }
}
