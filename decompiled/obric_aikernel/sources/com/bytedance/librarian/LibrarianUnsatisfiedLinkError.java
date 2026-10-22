package com.bytedance.librarian;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class LibrarianUnsatisfiedLinkError extends UnsatisfiedLinkError {
    private static final ArrayList<LibrarianUnsatisfiedLinkError> sErrors = null;
    private static final ArrayList<UnsatisfiedLinkError> sOriginErrors = null;

    static {
        sErrors = new ArrayList();
        sOriginErrors = new ArrayList();
    }

    LibrarianUnsatisfiedLinkError(String r10) {
        super(r10);
        ArrayList<LibrarianUnsatisfiedLinkError> r11 = sErrors;
        monitor-enter(r11);
        r11.add(this);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    LibrarianUnsatisfiedLinkError(String r10, Throwable r11) {
        super(r10);
        initCause(r11);
        ArrayList<LibrarianUnsatisfiedLinkError> r12 = sErrors;
        monitor-enter(r12);
        r12.add(this);     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static UnsatisfiedLinkError[] getErrors() {
        ArrayList<LibrarianUnsatisfiedLinkError> r10 = sErrors;
        monitor-enter(r10);
        UnsatisfiedLinkError[] r11 = (UnsatisfiedLinkError[]) r10.toArray(new UnsatisfiedLinkError[0]);     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return r11;
    L8:
        th = move-exception;
        throw th;
    }

    static UnsatisfiedLinkError[] getOriginErrors() {
        ArrayList<UnsatisfiedLinkError> r10 = sOriginErrors;
        monitor-enter(r10);
        UnsatisfiedLinkError[] r11 = (UnsatisfiedLinkError[]) r10.toArray(new UnsatisfiedLinkError[r10.size()]);     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        return r11;
    L9:
        th = move-exception;
        throw th;
    }

    static void recordOriginError(UnsatisfiedLinkError r10) {
        ArrayList<UnsatisfiedLinkError> r11 = sOriginErrors;
        monitor-enter(r11);
        r11.add(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
