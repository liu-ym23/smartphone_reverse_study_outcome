package com.squareup.wire;

/* JADX INFO: loaded from: classes4.dex */
public interface TagHandler {
    public static final Object UNKNOWN_TAG = null;

    static {
        UNKNOWN_TAG = new Object();
    }

    Object decodeMessage(int r1);
}
