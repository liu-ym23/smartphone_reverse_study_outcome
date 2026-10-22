package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.os.HandlerThread;
import com.bytedance.common.utility.collection.WeakHandler;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f2188a;

    public static b a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (f2188a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2188a != null) goto L9;
        f2188a = b(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f2188a;
    }

    private static b b(Context r9) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        HandlerThread r10 = new HandlerThread("wschannel");
        r10.start();
        a r4 = new a();
        l r7 = new l(r1, r4);
        k r6 = new k(r1, new WeakHandler(r10.getLooper(), new AnonymousClass1()));
        b r8 = new b(r1, r10.getLooper(), new n(r1), r4, r7, r6);
        r7.a(r8);
        return r8;
    }
}
