package com.google.protobuf;

import java.nio.Buffer;

/* JADX INFO: loaded from: classes.dex */
final class Java8Compatibility {
    private Java8Compatibility() {
    }

    public static void clear(Buffer r8) {
        r8.clear();
    }

    public static void flip(Buffer r8) {
        r8.flip();
    }

    public static void limit(Buffer r8, int r10) {
        r8.limit(r10);
    }

    public static void mark(Buffer r8) {
        r8.mark();
    }

    public static void position(Buffer r8, int r10) {
        r8.position(r10);
    }

    public static void reset(Buffer r8) {
        r8.reset();
    }
}
