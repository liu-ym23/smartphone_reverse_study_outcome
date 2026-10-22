package com.google.protobuf;

import java.nio.Buffer;

/* JADX INFO: loaded from: classes2.dex */
final class Java8Compatibility {
    private Java8Compatibility() {
    }

    static void clear(Buffer r10) {
        r10.clear();
    }

    static void flip(Buffer r10) {
        r10.flip();
    }

    static void limit(Buffer r10, int r11) {
        r10.limit(r11);
    }

    static void mark(Buffer r10) {
        r10.mark();
    }

    static void position(Buffer r10, int r11) {
        r10.position(r11);
    }

    static void reset(Buffer r10) {
        r10.reset();
    }
}
