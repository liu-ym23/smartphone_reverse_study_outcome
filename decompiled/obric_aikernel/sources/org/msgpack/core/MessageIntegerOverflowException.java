package org.msgpack.core;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class MessageIntegerOverflowException extends MessageTypeException {
    private final BigInteger bigInteger;

    public MessageIntegerOverflowException(long r10) {
        this(BigInteger.valueOf(r10));
    }

    public MessageIntegerOverflowException(String r10, BigInteger r11) {
        super(r10);
        this.bigInteger = r11;
    }

    public MessageIntegerOverflowException(BigInteger r10) {
        this.bigInteger = r10;
    }

    public BigInteger getBigInteger() {
        return this.bigInteger;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.bigInteger.toString();
    }
}
