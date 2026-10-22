package org.msgpack.core;

/* JADX INFO: loaded from: classes7.dex */
public class MessageSizeException extends MessagePackException {
    private final long size;

    public MessageSizeException(long r1) {
        this.size = r1;
    }

    public MessageSizeException(String r1, long r2) {
        super(r1);
        this.size = r2;
    }

    public long getSize() {
        return this.size;
    }
}
