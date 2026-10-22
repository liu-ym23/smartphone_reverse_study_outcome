package com.ss.android.socialbase.downloader.constants;

/* JADX INFO: loaded from: classes2.dex */
public final enum ByteInvalidRetryStatus extends Enum<ByteInvalidRetryStatus> {
    private static final /* synthetic */ ByteInvalidRetryStatus[] $VALUES = null;
    public static final ByteInvalidRetryStatus BYTE_INVALID_RETRY_STATUS_DOWNLOADED = null;
    public static final ByteInvalidRetryStatus BYTE_INVALID_RETRY_STATUS_DOWNLOADING = null;
    public static final ByteInvalidRetryStatus BYTE_INVALID_RETRY_STATUS_NONE = null;
    public static final ByteInvalidRetryStatus BYTE_INVALID_RETRY_STATUS_RESTART = null;

    static {
        ByteInvalidRetryStatus r10 = new ByteInvalidRetryStatus("BYTE_INVALID_RETRY_STATUS_NONE", 0);
        BYTE_INVALID_RETRY_STATUS_NONE = r10;
        ByteInvalidRetryStatus r11 = new ByteInvalidRetryStatus("BYTE_INVALID_RETRY_STATUS_RESTART", 1);
        BYTE_INVALID_RETRY_STATUS_RESTART = r11;
        ByteInvalidRetryStatus r12 = new ByteInvalidRetryStatus("BYTE_INVALID_RETRY_STATUS_DOWNLOADING", 2);
        BYTE_INVALID_RETRY_STATUS_DOWNLOADING = r12;
        ByteInvalidRetryStatus r13 = new ByteInvalidRetryStatus("BYTE_INVALID_RETRY_STATUS_DOWNLOADED", 3);
        BYTE_INVALID_RETRY_STATUS_DOWNLOADED = r13;
        $VALUES = new ByteInvalidRetryStatus[]{r10, r11, r12, r13};
    }

    private ByteInvalidRetryStatus(String r10, int r11) {
        super(r10, r11);
    }

    public static ByteInvalidRetryStatus valueOf(String r10) {
        return (ByteInvalidRetryStatus) Enum.valueOf(ByteInvalidRetryStatus.class, r10);
    }

    public static ByteInvalidRetryStatus[] values() {
        return (ByteInvalidRetryStatus[]) $VALUES.clone();
    }
}
