package com.bytedance.apm.agent.instrumentation.io;

import java.util.EventObject;

/* JADX INFO: loaded from: classes2.dex */
public final class StreamCompleteEvent extends EventObject {
    private static final long serialVersionUID = 1;
    private final long bytes;
    private final Exception exception;

    public StreamCompleteEvent(Object r5, long r10, Exception r11) {
        super(r5);
        this.bytes = r10;
        this.exception = r11;
    }

    public long getBytes() {
        return this.bytes;
    }

    public Exception getException() {
        return this.exception;
    }

    public boolean isError() {
        if (this.exception == null) goto L5;
        return true;
    L5:
        return false;
    }

    public StreamCompleteEvent(Object r5, long r10) {
        this(r5, r10, null);
    }
}
