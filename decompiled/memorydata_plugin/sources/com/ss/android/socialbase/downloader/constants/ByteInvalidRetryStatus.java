package com.ss.android.socialbase.downloader.constants;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum ByteInvalidRetryStatus extends Enum<ByteInvalidRetryStatus> {
    private static final /* synthetic */ ByteInvalidRetryStatus[] $VALUES = null;
    public static final ByteInvalidRetryStatus BYTE_INVALID_RETRY_STATUS_DOWNLOADED = null;
    public static final ByteInvalidRetryStatus BYTE_INVALID_RETRY_STATUS_DOWNLOADING = null;
    public static final ByteInvalidRetryStatus BYTE_INVALID_RETRY_STATUS_NONE = null;
    public static final ByteInvalidRetryStatus BYTE_INVALID_RETRY_STATUS_RESTART = null;

    static {
        ByteInvalidRetryStatus r0 = new ByteInvalidRetryStatus("BYTE_INVALID_RETRY_STATUS_NONE", 0);
        BYTE_INVALID_RETRY_STATUS_NONE = r0;
        ByteInvalidRetryStatus r1 = new ByteInvalidRetryStatus("BYTE_INVALID_RETRY_STATUS_RESTART", 1);
        BYTE_INVALID_RETRY_STATUS_RESTART = r1;
        ByteInvalidRetryStatus r3 = new ByteInvalidRetryStatus("BYTE_INVALID_RETRY_STATUS_DOWNLOADING", 2);
        BYTE_INVALID_RETRY_STATUS_DOWNLOADING = r3;
        ByteInvalidRetryStatus r5 = new ByteInvalidRetryStatus("BYTE_INVALID_RETRY_STATUS_DOWNLOADED", 3);
        BYTE_INVALID_RETRY_STATUS_DOWNLOADED = r5;
        $VALUES = new ByteInvalidRetryStatus[]{r0, r1, r3, r5};
    }

    private ByteInvalidRetryStatus(String r1, int r2) {
        super(r1, r2);
    }

    public static ByteInvalidRetryStatus valueOf(String r2) {
        return (ByteInvalidRetryStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(ByteInvalidRetryStatus.class, r2), ByteInvalidRetryStatus.class, "com.obric.memorydata.plugin");
    }

    public static ByteInvalidRetryStatus[] values() {
        return (ByteInvalidRetryStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ByteInvalidRetryStatus[].class, "com.obric.memorydata.plugin");
    }
}
