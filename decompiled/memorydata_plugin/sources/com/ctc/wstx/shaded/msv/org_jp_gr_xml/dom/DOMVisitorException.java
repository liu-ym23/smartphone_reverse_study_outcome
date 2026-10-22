package com.ctc.wstx.shaded.msv.org_jp_gr_xml.dom;

import java.io.PrintStream;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class DOMVisitorException extends RuntimeException {
    private Exception cause_;

    public DOMVisitorException(Exception r2) {
        super(r2.getMessage());
        this.cause_ = null;
        this.cause_ = r2;
    }

    public DOMVisitorException(String r1) {
        super(r1);
        this.cause_ = null;
    }

    public DOMVisitorException(String r1, Exception r2) {
        super(r1);
        this.cause_ = null;
        this.cause_ = r2;
    }

    public Exception getCauseException() {
        return this.cause_;
    }

    public Exception getException() {
        Exception r0 = this.cause_;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this;
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
        if (this.cause_ == null) goto L8;
        r3.println();
        r3.println("StackTrace of Original Exception:");
        this.cause_.printStackTrace(r3);
        return;
    }
}
