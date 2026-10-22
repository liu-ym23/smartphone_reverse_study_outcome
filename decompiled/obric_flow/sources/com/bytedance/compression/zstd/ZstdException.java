package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes2.dex */
public class ZstdException extends RuntimeException {
    private long code;

    public ZstdException(long r5) {
        this(Zstd.getErrorCode(r5), Zstd.getErrorName(r5));
    }

    public long getErrorCode() {
        return this.code;
    }

    public ZstdException(long r5, String r10) {
        super(r10);
        this.code = r5;
    }
}
