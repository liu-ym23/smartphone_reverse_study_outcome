package com.ss.android.socialbase.downloader.utils;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadStenographer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Node f16136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Node f16137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16138c;

    public static class Node {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f16139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f16140b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Node f16141c;
        public Node d;

        public Node() {
        }
    }

    public DownloadStenographer() {
    }

    public final long a(long r11, long r13) {
        monitor-enter(this);
        Node r5 = this.f16136a;     // Catch: Throwable -> L7
        if (r5 != null) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return -1;
    L9:
        Node r10 = null;
        Node r12 = r5;
    L10:
        if (r12 == null) goto L14;
        if (r12.f16140b <= r11) goto L14;
        r10 = r12;
        r12 = r12.f16141c;     // Catch: Throwable -> L7
    L14:
        if (r12 == null) goto L20;
        if (r10 == null) goto L20;
        if (r12 == r10) goto L20;
        if ((r11 - r12.f16140b) >= (r10.f16140b - r11)) goto L20;
    L21:
        if (r12 != null) goto L24;
        monitor-exit(this);     // Catch: Throwable -> L7
        return -1;
    L24:
        long r14 = r5.f16139a - r12.f16139a;     // Catch: Throwable -> L7
        long r15 = r13 - r12.f16140b;     // Catch: Throwable -> L7
        if (r14 >= 0) goto L27;
    L31:
        monitor-exit(this);     // Catch: Throwable -> L7
        return -1;
    L27:
        if (r15 <= 0) goto L31;
        long r16 = r14 / r15;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return r16;
    L20:
        r12 = r10;
    L7:
        th = move-exception;
        throw th;
    }

    public final void b(long r10, long r11) {
        monitor-enter(this);
        Node r5 = this.f16136a;     // Catch: Throwable -> L17
        if (r5 != null) goto L6;
    L21:
        int r12 = this.f16138c;     // Catch: Throwable -> L17
        if (r12 < 10) goto L28;
        Node r13 = this.f16137b;     // Catch: Throwable -> L17
        if (r13 == null) goto L28;
        Node r14 = r13.d;     // Catch: Throwable -> L17
        r13.d = null;     // Catch: Throwable -> L17
        this.f16137b = r14;     // Catch: Throwable -> L17
        if (r14 == null) goto L29;
        r14.f16141c = null;     // Catch: Throwable -> L17
    L29:
        r13.f16139a = r10;     // Catch: Throwable -> L17
        r13.f16140b = r11;     // Catch: Throwable -> L17
        if (r5 == null) goto L32;
        r13.f16141c = r5;     // Catch: Throwable -> L17
        r5.d = r13;     // Catch: Throwable -> L17
    L32:
        this.f16136a = r13;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L28:
        this.f16138c = r12 + 1;     // Catch: Throwable -> L17
        r13 = new Node();     // Catch: Throwable -> L17
        goto L29
    L6:
        if (r10 >= r5.f16139a) goto L8;
    L19:
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L8:
        if (r11 < r5.f16140b) goto L19;
        Node r15 = r5.f16141c;     // Catch: Throwable -> L17
        if (r15 == null) goto L21;
        if ((r11 - r15.f16140b) >= 1000) goto L21;
        r5.f16139a = r10;     // Catch: Throwable -> L17
        r5.f16140b = r11;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }
}
