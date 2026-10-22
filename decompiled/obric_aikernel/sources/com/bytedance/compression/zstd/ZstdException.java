package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes.dex */
public class ZstdException extends RuntimeException {
    private long code;

    public ZstdException(long r10) {
        this(Zstd.getErrorCode(r10), Zstd.getErrorName(r10));
    }

    public ZstdException(long r10, String r11) {
        super(r11);
        this.code = r10;
    }

    public long getErrorCode() {
        return this.code;
    }
}
