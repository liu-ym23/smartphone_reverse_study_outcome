package org.msgpack.core;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
public class MessageIntegerOverflowException extends MessageTypeException {
    private final BigInteger bigInteger;

    public MessageIntegerOverflowException(long r1) {
        this(BigInteger.valueOf(r1));
    }

    public MessageIntegerOverflowException(String r1, BigInteger r2) {
        super(r1);
        this.bigInteger = r2;
    }

    public MessageIntegerOverflowException(BigInteger r1) {
        this.bigInteger = r1;
    }

    public BigInteger getBigInteger() {
        return this.bigInteger;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.bigInteger.toString();
    }
}
