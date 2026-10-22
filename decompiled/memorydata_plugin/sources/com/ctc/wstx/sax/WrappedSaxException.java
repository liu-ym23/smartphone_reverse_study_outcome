package com.ctc.wstx.sax;

import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes2.dex */
public final class WrappedSaxException extends RuntimeException {
    final SAXException mCause;

    public WrappedSaxException(SAXException r1) {
        this.mCause = r1;
    }

    public SAXException getSaxException() {
        return this.mCause;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return this.mCause.toString();
    }
}
