package com.tencent.wcdb.support;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InterfaceC0846a f15882b;
    private boolean c;

    /* JADX INFO: renamed from: com.tencent.wcdb.support.a$a, reason: collision with other inner class name */
    public interface InterfaceC0846a {
        void c();
    }

    private void c() {
    L3:
        if (this.c == false) goto L6;
        wait();     // Catch: InterruptedException -> L7
        goto L3
    }

    public void a(InterfaceC0846a r3) {
        InterfaceC0846a r4 = (InterfaceC0846a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0846a.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
        c();     // Catch: Throwable -> L17
        if (this.f15882b != r4) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L8:
        this.f15882b = r4;     // Catch: Throwable -> L17
        if (this.f15881a == false) goto L15;
        if (r4 == null) goto L15;
        monitor-exit(this);     // Catch: Throwable -> L17
        r4.c();
        return;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public boolean a() {
        monitor-enter(this);
        boolean r0 = this.f15881a;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void b() {
        if (a() == true) goto L6;
        return;
    L6:
        throw new OperationCanceledException();
    }
}
