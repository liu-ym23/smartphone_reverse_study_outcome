package com.ss.android.socialbase.downloader.constants;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum AsyncHandleStatus extends Enum<AsyncHandleStatus> {
    private static final /* synthetic */ AsyncHandleStatus[] $VALUES = null;
    public static final AsyncHandleStatus ASYNC_HANDLE_DOWNLOADED = null;
    public static final AsyncHandleStatus ASYNC_HANDLE_DOWNLOADING = null;
    public static final AsyncHandleStatus ASYNC_HANDLE_NONE = null;
    public static final AsyncHandleStatus ASYNC_HANDLE_RESTART = null;
    public static final AsyncHandleStatus ASYNC_HANDLE_WAITING = null;

    static {
        AsyncHandleStatus r0 = new AsyncHandleStatus("ASYNC_HANDLE_NONE", 0);
        ASYNC_HANDLE_NONE = r0;
        AsyncHandleStatus r1 = new AsyncHandleStatus("ASYNC_HANDLE_WAITING", 1);
        ASYNC_HANDLE_WAITING = r1;
        AsyncHandleStatus r3 = new AsyncHandleStatus("ASYNC_HANDLE_RESTART", 2);
        ASYNC_HANDLE_RESTART = r3;
        AsyncHandleStatus r5 = new AsyncHandleStatus("ASYNC_HANDLE_DOWNLOADING", 3);
        ASYNC_HANDLE_DOWNLOADING = r5;
        AsyncHandleStatus r7 = new AsyncHandleStatus("ASYNC_HANDLE_DOWNLOADED", 4);
        ASYNC_HANDLE_DOWNLOADED = r7;
        $VALUES = new AsyncHandleStatus[]{r0, r1, r3, r5, r7};
    }

    public static AsyncHandleStatus[] values() {
        return (AsyncHandleStatus[]) $VALUES.clone();
    }

    public static AsyncHandleStatus valueOf(String r1) {
        return (AsyncHandleStatus) a.a(AsyncHandleStatus.class, r1);
    }

    private AsyncHandleStatus(String r1, int r2) {
        super(r1, r2);
    }
}
