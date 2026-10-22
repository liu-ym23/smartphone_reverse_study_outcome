package com.ctc.wstx.shaded.msv_core.verifier;

import org.xml.sax.SAXParseException;

/* JADX INFO: loaded from: classes2.dex */
public class ValidationUnrecoverableException extends SAXParseException {
    public ValidationUnrecoverableException(SAXParseException r8) {
        super(r8.getMessage(), r8.getPublicId(), r8.getSystemId(), r8.getLineNumber(), r8.getColumnNumber(), r8);
    }
}
