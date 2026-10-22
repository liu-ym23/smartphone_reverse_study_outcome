package com.bytedance.librarian;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
class LibrarianUnsatisfiedLinkError extends UnsatisfiedLinkError {
    private static final ArrayList<LibrarianUnsatisfiedLinkError> sErrors = null;
    private static final ArrayList<UnsatisfiedLinkError> sOriginErrors = null;

    static {
        sErrors = new ArrayList();
        sOriginErrors = new ArrayList();
    }

    LibrarianUnsatisfiedLinkError(String r1) {
        super(r1);
        ArrayList<LibrarianUnsatisfiedLinkError> r2 = sErrors;
        monitor-enter(r2);
        r2.add(this);     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    LibrarianUnsatisfiedLinkError(String r1, Throwable r2) {
        super(r1);
        initCause(r2);
        ArrayList<LibrarianUnsatisfiedLinkError> r3 = sErrors;
        monitor-enter(r3);
        r3.add(this);     // Catch: Throwable -> L7
        monitor-exit(r3);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static UnsatisfiedLinkError[] getErrors() {
        ArrayList<LibrarianUnsatisfiedLinkError> r0 = sErrors;
        monitor-enter(r0);
        UnsatisfiedLinkError[] r1 = (UnsatisfiedLinkError[]) ZeusTransformUtils.preCheckCast(r0.toArray(new UnsatisfiedLinkError[0]), UnsatisfiedLinkError[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r1;
    L8:
        th = move-exception;
        throw th;
    }

    static UnsatisfiedLinkError[] getOriginErrors() {
        ArrayList<UnsatisfiedLinkError> r0 = sOriginErrors;
        monitor-enter(r0);
        UnsatisfiedLinkError[] r1 = (UnsatisfiedLinkError[]) ZeusTransformUtils.preCheckCast(r0.toArray(new UnsatisfiedLinkError[r0.size()]), UnsatisfiedLinkError[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    static void recordOriginError(UnsatisfiedLinkError r1) {
        ArrayList<UnsatisfiedLinkError> r0 = sOriginErrors;
        monitor-enter(r0);
        r0.add(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
