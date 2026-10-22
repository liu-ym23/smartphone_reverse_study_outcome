package com.bytedance.librarian;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class LibrarianUnsatisfiedLinkError extends UnsatisfiedLinkError {
    public static final ArrayList<LibrarianUnsatisfiedLinkError> a = null;

    static {
        a = new ArrayList();
    }

    public static UnsatisfiedLinkError[] getErrors() {
        ArrayList<LibrarianUnsatisfiedLinkError> r0 = a;
        monitor-enter(r0);
        UnsatisfiedLinkError[] r1 = (UnsatisfiedLinkError[]) r0.toArray(new UnsatisfiedLinkError[0]);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r1;
    L8:
        th = move-exception;
        throw th;
    }

    public LibrarianUnsatisfiedLinkError(String r2) {
        super(r2);
        ArrayList<LibrarianUnsatisfiedLinkError> r3 = a;
        monitor-enter(r3);
        r3.add(this);     // Catch: Throwable -> L7
        monitor-exit(r3);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public LibrarianUnsatisfiedLinkError(String r1, Throwable r2) {
        super(r1);
        initCause(r2);
        ArrayList<LibrarianUnsatisfiedLinkError> r3 = a;
        monitor-enter(r3);
        r3.add(this);     // Catch: Throwable -> L7
        monitor-exit(r3);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
