package com.squareup.wire;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class Preconditions {
    private Preconditions() {
    }

    static void checkNotNull(Object r10, String r11) {
        Objects.requireNonNull(r10, r11);
    }
}
