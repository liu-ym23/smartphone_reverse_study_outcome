package com.ss.android.socialbase.downloader.constants;

/* JADX INFO: loaded from: classes2.dex */
public final enum AsyncHandleStatus extends Enum<AsyncHandleStatus> {
    private static final /* synthetic */ AsyncHandleStatus[] $VALUES = null;
    public static final AsyncHandleStatus ASYNC_HANDLE_DOWNLOADED = null;
    public static final AsyncHandleStatus ASYNC_HANDLE_DOWNLOADING = null;
    public static final AsyncHandleStatus ASYNC_HANDLE_NONE = null;
    public static final AsyncHandleStatus ASYNC_HANDLE_RESTART = null;
    public static final AsyncHandleStatus ASYNC_HANDLE_WAITING = null;

    static {
        AsyncHandleStatus r10 = new AsyncHandleStatus("ASYNC_HANDLE_NONE", 0);
        ASYNC_HANDLE_NONE = r10;
        AsyncHandleStatus r11 = new AsyncHandleStatus("ASYNC_HANDLE_WAITING", 1);
        ASYNC_HANDLE_WAITING = r11;
        AsyncHandleStatus r12 = new AsyncHandleStatus("ASYNC_HANDLE_RESTART", 2);
        ASYNC_HANDLE_RESTART = r12;
        AsyncHandleStatus r13 = new AsyncHandleStatus("ASYNC_HANDLE_DOWNLOADING", 3);
        ASYNC_HANDLE_DOWNLOADING = r13;
        AsyncHandleStatus r14 = new AsyncHandleStatus("ASYNC_HANDLE_DOWNLOADED", 4);
        ASYNC_HANDLE_DOWNLOADED = r14;
        $VALUES = new AsyncHandleStatus[]{r10, r11, r12, r13, r14};
    }

    private AsyncHandleStatus(String r10, int r11) {
        super(r10, r11);
    }

    public static AsyncHandleStatus valueOf(String r10) {
        return (AsyncHandleStatus) Enum.valueOf(AsyncHandleStatus.class, r10);
    }

    public static AsyncHandleStatus[] values() {
        return (AsyncHandleStatus[]) $VALUES.clone();
    }
}
