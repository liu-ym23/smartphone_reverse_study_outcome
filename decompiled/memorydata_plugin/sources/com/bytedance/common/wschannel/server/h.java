package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.os.HandlerThread;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f2185a;

    public static b a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (f2185a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2185a != null) goto L9;
        f2185a = b(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f2185a;
    }

    private static b b(Context r9) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        HandlerThread r10 = new HandlerThread("wschannel");
        r10.start();
        a r4 = new a();
        i r7 = new i(r1, r4);
        f r6 = new AnonymousClass1();
        b r8 = new b(r1, r10.getLooper(), new AnonymousClass2(), r4, r7, r6);
        r7.a(r8);
        return r8;
    }
}
