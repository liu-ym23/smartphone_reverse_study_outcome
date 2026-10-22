package com.bytedance.common.wschannel.c;

import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class f implements ThreadFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f2018b = "f";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2019a;

    static {
    }

    public f(String r3) {
        this.f2019a = "WsChannel-" + r3;
    }

    static /* synthetic */ String a() {
        return f2018b;
    }

    static /* synthetic */ String a(f r0) {
        return r0.f2019a;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r4) {
        final Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        if (Logger.debug() == false) goto L6;
        Logger.d(f2018b, "creating newThread " + this.f2019a);
    L6:
        return new Thread(new AnonymousClass1(this, r5), this.f2019a);
    }
}
