package com.bytedance.compression.zstd;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f2202a = null;

    static {
        f2202a = new c();
    }

    private c() {
    }

    @Override // com.bytedance.compression.zstd.b
    public ByteBuffer a(int r1) {
        return ByteBuffer.allocate(r1);
    }

    @Override // com.bytedance.compression.zstd.b
    public void a(ByteBuffer r1) {
    }
}
