package com.lynx.tasm.behavior.ui.list.container;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ListContainerProxy {
    public long a;

    public ListContainerProxy() {
    }

    private native long nativeCreate(long r1);

    private native void nativeDestroy(long r1);

    private native void nativeScrollByListContainer(long r1, int r3, float r4, float r5, float r6, float r7);

    private native void nativeScrollStopped(long r1, int r3);

    private native void nativeScrollToPosition(long r1, int r3, int r4, float r5, int r6, boolean r7);

    public final void a() {
        long r0 = this.a;
        if (r0 == 0) goto L6;
        nativeDestroy(r0);
        this.a = 0;
        return;
    }

    public ListContainerProxy(long r1) {
        this.a = nativeCreate(r1);
    }

    public final void c(int r6) {
        long r0 = this.a;
        if (r0 == 0) goto L6;
        nativeScrollStopped(r0, r6);
        return;
    }

    public final void b(int r9, float r10, float r11, float r12, float r13) {
        long r1 = this.a;
        if (r1 == 0) goto L6;
        nativeScrollByListContainer(r1, r9, r10, r11, r12, r13);
        return;
    }

    public final void d(int r9, int r10, float r11, int r12, boolean r13) {
        long r1 = this.a;
        if (r1 == 0) goto L6;
        nativeScrollToPosition(r1, r9, r10, r11, r12, r13);
        return;
    }
}
