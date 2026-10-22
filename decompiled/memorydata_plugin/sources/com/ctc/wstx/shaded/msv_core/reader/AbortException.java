package com.ctc.wstx.shaded.msv_core.reader;

/* JADX INFO: loaded from: classes2.dex */
public class AbortException extends Exception {
    public static final AbortException theInstance = null;

    static {
        theInstance = new AbortException();
    }

    private AbortException() {
        super("aborted. Errors should have been reported");
    }
}
