package com.bytedance.forest.model;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q extends p {
    private final a bytesProvider;

    public q(a r5) {
        this.bytesProvider = r5;
    }

    public static /* synthetic */ boolean initCache$forest_release$default(q r5, Integer r10, int r11, Object r12) {
        if (r12 != null) goto L9;
        if ((r11 & 1) == 0) goto L7;
        r10 = null;
    L7:
        return r5.initCache$forest_release(r10);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initCache");
    }

    public abstract int getBytesAtRange$forest_release(int r5, byte[] r10, int r11, int r12, w r13);

    public final a getBytesProvider() {
        return this.bytesProvider;
    }

    public abstract boolean initCache$forest_release(Integer r5);
}
