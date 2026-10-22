package com.ss.android.socialbase.downloader.constants;

/* JADX INFO: loaded from: classes3.dex */
public final enum ByteInvalidRetryStatus extends Enum<ByteInvalidRetryStatus> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ByteInvalidRetryStatus f15266a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ByteInvalidRetryStatus f15267b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ByteInvalidRetryStatus f15268c = null;
    public static final ByteInvalidRetryStatus d = null;
    public static final /* synthetic */ ByteInvalidRetryStatus[] e = null;

    static {
        ByteInvalidRetryStatus r5 = new ByteInvalidRetryStatus("BYTE_INVALID_RETRY_STATUS_NONE", 0);
        f15266a = r5;
        ByteInvalidRetryStatus r10 = new ByteInvalidRetryStatus("BYTE_INVALID_RETRY_STATUS_RESTART", 1);
        f15267b = r10;
        ByteInvalidRetryStatus r11 = new ByteInvalidRetryStatus("BYTE_INVALID_RETRY_STATUS_DOWNLOADING", 2);
        f15268c = r11;
        ByteInvalidRetryStatus r12 = new ByteInvalidRetryStatus("BYTE_INVALID_RETRY_STATUS_DOWNLOADED", 3);
        d = r12;
        e = new ByteInvalidRetryStatus[]{r5, r10, r11, r12};
    }

    public ByteInvalidRetryStatus(String r5, int r10) {
        super(r5, r10);
    }

    public static ByteInvalidRetryStatus valueOf(String r5) {
        return (ByteInvalidRetryStatus) Enum.valueOf(ByteInvalidRetryStatus.class, r5);
    }

    public static ByteInvalidRetryStatus[] values() {
        return (ByteInvalidRetryStatus[]) e.clone();
    }
}
