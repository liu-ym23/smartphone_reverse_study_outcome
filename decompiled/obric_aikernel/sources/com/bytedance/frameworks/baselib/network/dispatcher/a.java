package com.bytedance.frameworks.baselib.network.dispatcher;

import com.bytedance.common.utility.g;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.b0;

/* JADX INFO: loaded from: classes.dex */
public class a extends n2.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Runnable f1556i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final IRequest.Priority f1557j;

    public a(String r10, IRequest.Priority r11, int r12, Runnable r13, boolean r14) {
        this.f1557j = r11;
        if (g.b(r10) == true) goto L5;
    L5:
        this.f11180g = r12;
        this.f1556i = r13;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequest
    public IRequest.Priority a() {
        return this.f1557j;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequest
    public int b() {
        return this.f11181h;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(IRequest r10) {
        return h(r10);
    }

    @Override // n2.a
    public /* bridge */ /* synthetic */ n2.a g(int r10) {
        return j(r10);
    }

    public int h(IRequest r10) {
        IRequest.Priority r11 = a();
        IRequest.Priority r12 = r10.a();
        if (r11 != null) goto L5;
        r11 = IRequest.Priority.NORMAL;
    L5:
        if (r12 != null) goto L7;
        r12 = IRequest.Priority.NORMAL;
    L7:
        if (r11 != r12) goto L9;
        int r13 = b();
        int r14 = r10.b();
    L11:
        return r13 - r14;
    L9:
        r13 = r12.ordinal();
        r14 = r11.ordinal();
        goto L11
    }

    public void i(int r10) {
        Runnable r11 = this.f1556i;
        if ((r11 instanceof b0) == false) goto L8;
        RetrofitMetrics r12 = ((b0) r11).u();
        if (r12 == null) goto L9;
        r12.C0 = r10;
        return;
    L9:
        return;
    }

    public a j(int r10) {
        this.f11181h = r10;
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1556i != null) goto L5;
        return;
    L5:
        if (d() == true) goto L9;
        this.f1556i.run();
        return;
    }
}
