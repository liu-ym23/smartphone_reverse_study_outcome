package com.google.common.util.concurrent;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes2.dex */
final class u {
    static void a(Object r2, long r3) {
        LockSupport.parkNanos(r2, Math.min(r3, 2147483647999999999L));
    }
}
