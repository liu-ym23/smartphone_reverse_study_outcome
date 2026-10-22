package com.bytedance.librarian;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
class LibrarianUnsatisfiedLinkError extends UnsatisfiedLinkError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList f6773a = null;

    static {
        f6773a = new ArrayList();
    }

    public LibrarianUnsatisfiedLinkError(String r5) {
        super(r5);
        ArrayList r10 = f6773a;
        monitor-enter(r10);
        r10.add(this);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static UnsatisfiedLinkError[] getErrors() {
        ArrayList r5 = f6773a;
        monitor-enter(r5);
        UnsatisfiedLinkError[] r10 = (UnsatisfiedLinkError[]) r5.toArray(new UnsatisfiedLinkError[0]);     // Catch: Throwable -> L8
        monitor-exit(r5);     // Catch: Throwable -> L8
        return r10;
    L8:
        th = move-exception;
        throw th;
    }

    public LibrarianUnsatisfiedLinkError(String r5, Throwable r10) {
        super(r5);
        initCause(r10);
        ArrayList r11 = f6773a;
        monitor-enter(r11);
        r11.add(this);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
