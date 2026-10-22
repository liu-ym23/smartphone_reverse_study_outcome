package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes.dex */
public final class d extends RuntimeException {
    public d(long r8) {
        Zstd.getErrorCode(r8);
        super(Zstd.getErrorName(r8));
    }
}
