package com.ctc.wstx.exc;

import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: classes2.dex */
public class WstxLazyException extends RuntimeException {
    final XMLStreamException mOrig;

    public WstxLazyException(XMLStreamException r2) {
        super(r2.getMessage(), r2);
        this.mOrig = r2;
    }

    public static void throwLazily(XMLStreamException r1) {
        throw new WstxLazyException(r1);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "[" + getClass().getName() + "] " + this.mOrig.getMessage();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "[" + getClass().getName() + "] " + this.mOrig.toString();
    }
}
