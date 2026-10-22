package org.apache.commons.io;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class IOExceptionWithCause extends IOException {
    private static final long serialVersionUID = 1;

    public IOExceptionWithCause(String r1, Throwable r2) {
        super(r1, r2);
    }

    public IOExceptionWithCause(Throwable r1) {
        super(r1);
    }
}
