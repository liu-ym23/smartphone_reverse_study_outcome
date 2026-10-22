package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MemoryChunkUtil {
    public static void a(int r5, int r10, int r11, int r12, int r13) {
        if (r12 < 0) goto L19;
        if (r5 < 0) goto L17;
        if (r11 < 0) goto L15;
        if ((r5 + r12) > r13) goto L13;
        if ((r11 + r12) > r10) goto L11;
        return;
    L11:
        throw new IllegalArgumentException();
    L13:
        throw new IllegalArgumentException();
    L15:
        throw new IllegalArgumentException();
    L17:
        throw new IllegalArgumentException();
    L19:
        throw new IllegalArgumentException();
    }
}
