package com.ss.android.socialbase.downloader.constants;

/* JADX INFO: loaded from: classes3.dex */
public final enum AsyncHandleStatus extends Enum<AsyncHandleStatus> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AsyncHandleStatus f15263a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AsyncHandleStatus f15264b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AsyncHandleStatus f15265c = null;
    public static final AsyncHandleStatus d = null;
    public static final AsyncHandleStatus e = null;
    public static final /* synthetic */ AsyncHandleStatus[] f = null;

    static {
        AsyncHandleStatus r5 = new AsyncHandleStatus("ASYNC_HANDLE_NONE", 0);
        f15263a = r5;
        AsyncHandleStatus r10 = new AsyncHandleStatus("ASYNC_HANDLE_WAITING", 1);
        f15264b = r10;
        AsyncHandleStatus r11 = new AsyncHandleStatus("ASYNC_HANDLE_RESTART", 2);
        f15265c = r11;
        AsyncHandleStatus r12 = new AsyncHandleStatus("ASYNC_HANDLE_DOWNLOADING", 3);
        d = r12;
        AsyncHandleStatus r13 = new AsyncHandleStatus("ASYNC_HANDLE_DOWNLOADED", 4);
        e = r13;
        f = new AsyncHandleStatus[]{r5, r10, r11, r12, r13};
    }

    public AsyncHandleStatus(String r5, int r10) {
        super(r5, r10);
    }

    public static AsyncHandleStatus valueOf(String r5) {
        return (AsyncHandleStatus) Enum.valueOf(AsyncHandleStatus.class, r5);
    }

    public static AsyncHandleStatus[] values() {
        return (AsyncHandleStatus[]) f.clone();
    }
}
