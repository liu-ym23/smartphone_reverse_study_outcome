package org.msgpack.core;

/* JADX INFO: loaded from: classes7.dex */
public class MessagePackException extends RuntimeException {
    public static final IllegalStateException UNREACHABLE = null;

    static {
        UNREACHABLE = new IllegalStateException("Cannot reach here");
    }

    public MessagePackException() {
    }

    public MessagePackException(String r1) {
        super(r1);
    }

    public MessagePackException(String r1, Throwable r2) {
        super(r1, r2);
    }

    public MessagePackException(Throwable r1) {
        super(r1);
    }

    public static UnsupportedOperationException UNSUPPORTED(String r1) {
        return new UnsupportedOperationException(r1);
    }
}
