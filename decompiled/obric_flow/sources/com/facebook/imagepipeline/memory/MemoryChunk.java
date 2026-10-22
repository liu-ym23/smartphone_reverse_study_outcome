package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes2.dex */
public interface MemoryChunk {
    byte a(int r5);

    int a(int r5, byte[] r10, int r11, int r12);

    void a(MemoryChunk r5, int r10);

    boolean a();

    int b(int r5, byte[] r10, int r11, int r12);

    long b();

    int c();

    void close();
}
