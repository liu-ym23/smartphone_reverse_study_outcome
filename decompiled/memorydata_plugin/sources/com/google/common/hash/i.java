package com.google.common.hash;

import java.nio.Buffer;

/* JADX INFO: loaded from: classes2.dex */
final class i {
    static void a(Buffer r0) {
        r0.clear();
    }

    static void a(Buffer r0, int r1) {
        r0.limit(r1);
    }

    static void b(Buffer r0) {
        r0.flip();
    }

    static void b(Buffer r0, int r1) {
        r0.position(r1);
    }
}
