package com.ctc.wstx.shaded.msv.org_isorelax.verifier;

import java.io.PrintStream;
import java.io.PrintWriter;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes2.dex */
public class VerifierException extends SAXException {
    public VerifierException(Exception r1) {
        super(r1);
    }

    public VerifierException(String r1) {
        super(r1);
    }

    public VerifierException(String r1, Exception r2) {
        super(r1, r2);
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(new PrintWriter(System.err, true));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream r2) {
        printStackTrace(new PrintWriter(r2));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter r3) {
        if (r3 != null) goto L4;
        r3 = new PrintWriter(System.err, true);
    L4:
        super.printStackTrace(r3);
        Exception r2 = super.getException();
        if (r2 == null) goto L8;
        r3.println();
        r3.println("StackTrace of Original Exception:");
        r2.printStackTrace(r3);
        return;
    }
}
