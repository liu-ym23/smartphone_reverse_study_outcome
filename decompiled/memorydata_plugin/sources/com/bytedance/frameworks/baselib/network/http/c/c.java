package com.bytedance.frameworks.baselib.network.http.c;

import com.bytedance.frameworks.baselib.network.dispatcher.IRequest;
import com.bytedance.frameworks.baselib.network.dispatcher.e;
import com.bytedance.retrofit2.SsRunnable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.bytedance.frameworks.baselib.network.dispatcher.c f2376a;

    static {
    }

    public c() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r8) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r8, Runnable.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L31;
        IRequest.Priority r7 = IRequest.Priority.NORMAL;
        if (ZeusTransformUtils.instanceOf(r5, SsRunnable.class) == false) goto L22;
        int r9 = ((SsRunnable) ZeusTransformUtils.preCheckCast(r5, SsRunnable.class, "com.obric.memorydata.plugin")).priority();
        if (r9 != 0) goto L10;
        IRequest.Priority r10 = IRequest.Priority.LOW;
    L21:
        boolean r1 = ((SsRunnable) ZeusTransformUtils.preCheckCast(r5, SsRunnable.class, "com.obric.memorydata.plugin")).isStreaming();
        IRequest.Priority r3 = r10;
        int r4 = ((SsRunnable) ZeusTransformUtils.preCheckCast(r5, SsRunnable.class, "com.obric.memorydata.plugin")).getRequestDelayTime();
        boolean r11 = r1;
    L24:
        if (f2376a != null) goto L26;
        f2376a = e.b();
    L26:
        com.bytedance.frameworks.baselib.network.dispatcher.a r12 = new com.bytedance.frameworks.baselib.network.dispatcher.a("NetExecutor", r3, r4, r5, r11);
        if (r11 == false) goto L29;
        f2376a.a(r12);
        return;
    L29:
        f2376a.b(r12);
        return;
    L10:
        if (1 != r9) goto L13;
    L11:
        r10 = IRequest.Priority.NORMAL;
        goto L21
    L13:
        if (2 != r9) goto L16;
        r10 = IRequest.Priority.HIGH;
        goto L21
    L16:
        if (3 != r9) goto L19;
        r10 = IRequest.Priority.IMMEDIATE;
        goto L21
    L19:
        if ((-1) != r9) goto L11;
        r10 = IRequest.Priority.LOWEST;
        goto L21
    L22:
        r3 = r7;
        r11 = false;
        r4 = 0;
        goto L24
    }
}
