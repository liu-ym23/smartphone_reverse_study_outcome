package org.apache.commons.io;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class IOIndexedException extends IOException {
    private static final long serialVersionUID = 1;
    private final int index;

    public IOIndexedException(int r2, Throwable r3) {
        super(toMessage(r2, r3), r3);
        this.index = r2;
    }

    public static String toMessage(int r3, Throwable r4) {
        String r0 = "Null";
        if (r4 != null) goto L5;
        String r1 = "Null";
    L6:
        if (r4 == null) goto L10;
        r0 = r4.getMessage();
    L10:
        return String.format("%s #%,d: %s", new Object[]{r1, Integer.valueOf(r3), r0});
    L5:
        r1 = r4.getClass().getSimpleName();
        goto L6
    }

    public int getIndex() {
        return this.index;
    }
}
