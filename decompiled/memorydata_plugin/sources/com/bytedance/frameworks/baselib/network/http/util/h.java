package com.bytedance.frameworks.baselib.network.http.util;

import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public class h implements ThreadFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f2547b = "h";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2548a;

    static {
    }

    public h(String r1) {
        this.f2548a = r1;
    }

    static /* synthetic */ String a() {
        return f2547b;
    }

    static /* synthetic */ String a(h r0) {
        return r0.f2548a;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r4) {
        final Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        if (Logger.debug() == false) goto L6;
        Logger.d(f2547b, "creating newThread " + this.f2548a);
    L6:
        return new Thread(new AnonymousClass1(this, r5), this.f2548a);
    }
}
