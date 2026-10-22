package com.google.crypto.tink.shaded.protobuf;

import java.nio.Buffer;

/* JADX INFO: loaded from: classes2.dex */
final class ad {
    static void a(Buffer r0) {
        r0.mark();
    }

    static void a(Buffer r0, int r1) {
        r0.limit(r1);
    }

    static void b(Buffer r0) {
        r0.reset();
    }

    static void b(Buffer r0, int r1) {
        r0.position(r1);
    }
}
