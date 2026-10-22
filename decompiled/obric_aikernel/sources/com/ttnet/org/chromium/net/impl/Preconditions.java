package com.ttnet.org.chromium.net.impl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkDirect(ByteBuffer r10) {
        if (r10.isDirect() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("byteBuffer must be a direct ByteBuffer.");
    }

    public static void checkHasRemaining(ByteBuffer r10) {
        if (r10.hasRemaining() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("ByteBuffer is already full.");
    }
}
