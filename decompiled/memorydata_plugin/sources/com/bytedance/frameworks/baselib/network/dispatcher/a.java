package com.bytedance.frameworks.baselib.network.dispatcher;

import com.bytedance.common.utility.h;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsRunnable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a extends b {
    private final boolean e;
    private final Runnable f;
    private final IRequest.Priority g;
    private final String h;

    public a(String r3, IRequest.Priority r4, int r5, Runnable r6, boolean r7) {
        Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.memorydata.plugin");
        this.g = r4;
        if (h.a(r3) == false) goto L5;
        r3 = getClass().getSimpleName();
    L5:
        this.c = r5;
        this.h = r3;
        this.f = r8;
        this.e = r7;
    }

    public int a(IRequest r3) {
        IRequest r4 = (IRequest) ZeusTransformUtils.wrapperContextForParams(r3, IRequest.class, "com.obric.memorydata.plugin");
        IRequest.Priority r0 = a();
        IRequest.Priority r1 = r4.a();
        if (r0 != null) goto L5;
        r0 = IRequest.Priority.NORMAL;
    L5:
        if (r1 != null) goto L7;
        r1 = IRequest.Priority.NORMAL;
    L7:
        if (r0 != r1) goto L9;
        int r2 = b();
        int r5 = r4.b();
    L11:
        return r2 - r5;
    L9:
        r2 = r1.ordinal();
        r5 = r0.ordinal();
        goto L11
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequest
    public IRequest.Priority a() {
        return this.g;
    }

    public a a(int r1) {
        this.d = r1;
        return this;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequest
    public int b() {
        return this.d;
    }

    public void b(int r3) {
        if (ZeusTransformUtils.instanceOf(this.f, SsRunnable.class) == false) goto L8;
        RetrofitMetrics r2 = ((SsRunnable) ZeusTransformUtils.preCheckCast(this.f, SsRunnable.class, "com.obric.memorydata.plugin")).getRetrofitMetrics();
        if (r2 == null) goto L9;
        r2.setBlockingQueueSize(r3);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.b
    public /* synthetic */ b c(int r1) {
        return a(r1);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(IRequest r3) {
        return a((IRequest) ZeusTransformUtils.preCheckCast(r3, IRequest.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f != null) goto L5;
        return;
    L5:
        if (e() == true) goto L9;
        this.f.run();
        return;
    }
}
