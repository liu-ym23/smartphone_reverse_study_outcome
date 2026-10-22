package org.msgpack.core;

/* JADX INFO: loaded from: classes3.dex */
public class MessagePackException extends RuntimeException {
    public static final IllegalStateException UNREACHABLE = null;

    static {
        UNREACHABLE = new IllegalStateException("Cannot reach here");
    }

    public MessagePackException() {
    }

    public MessagePackException(String r10) {
        super(r10);
    }

    public MessagePackException(String r10, Throwable r11) {
        super(r10, r11);
    }

    public MessagePackException(Throwable r10) {
        super(r10);
    }

    public static UnsupportedOperationException UNSUPPORTED(String r10) {
        return new UnsupportedOperationException(r10);
    }
}
