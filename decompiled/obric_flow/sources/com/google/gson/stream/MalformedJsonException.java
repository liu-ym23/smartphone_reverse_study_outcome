package com.google.gson.stream;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class MalformedJsonException extends IOException {
    private static final long serialVersionUID = 1;

    public MalformedJsonException(String r5) {
        super(r5);
    }

    public MalformedJsonException(String r5, Throwable r10) {
        super(r5, r10);
    }

    public MalformedJsonException(Throwable r5) {
        super(r5);
    }
}
