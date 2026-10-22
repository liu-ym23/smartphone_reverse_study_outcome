package com.google.common.util.concurrent;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class CycleDetectingLockFactory$PotentialDeadlockException extends CycleDetectingLockFactory$ExampleStackTrace {
    private final CycleDetectingLockFactory$ExampleStackTrace conflictingStackTrace;

    public CycleDetectingLockFactory$PotentialDeadlockException(final i0 r5, final i0 r10, CycleDetectingLockFactory$ExampleStackTrace r11, g0 r12) {
        super(r5, r10);
        this.conflictingStackTrace = r11;
        initCause(r11);
    }

    public CycleDetectingLockFactory$ExampleStackTrace getConflictingStackTrace() {
        return this.conflictingStackTrace;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String r5 = super.getMessage();
        Objects.requireNonNull(r5);
        StringBuilder r10 = new StringBuilder(r5);
        Throwable r11 = this.conflictingStackTrace;
    L3:
        if (r11 == null) goto L6;
        r10.append(", ");
        r10.append(r11.getMessage());
        r11 = r11.getCause();
        goto L3
    L6:
        return r10.toString();
    }
}
