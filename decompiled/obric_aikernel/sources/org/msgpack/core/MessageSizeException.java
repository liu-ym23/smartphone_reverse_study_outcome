package org.msgpack.core;

/* JADX INFO: loaded from: classes3.dex */
public class MessageSizeException extends MessagePackException {
    private final long size;

    public MessageSizeException(long r10) {
        this.size = r10;
    }

    public MessageSizeException(String r10, long r11) {
        super(r10);
        this.size = r11;
    }

    public long getSize() {
        return this.size;
    }
}
