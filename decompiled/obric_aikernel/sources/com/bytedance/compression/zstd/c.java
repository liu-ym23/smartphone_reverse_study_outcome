package com.bytedance.compression.zstd;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f1467a = null;

    static {
        f1467a = new c();
    }

    private c() {
    }

    @Override // com.bytedance.compression.zstd.b
    public void a(ByteBuffer r10) {
    }

    @Override // com.bytedance.compression.zstd.b
    public ByteBuffer get(int r10) {
        return ByteBuffer.allocate(r10);
    }
}
