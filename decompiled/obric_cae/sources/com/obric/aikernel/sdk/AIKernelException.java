package com.obric.aikernel.sdk;

import androidx.annotation.Keep;
import he.e;

/* JADX INFO: loaded from: classes.dex */
@Keep
public final class AIKernelException extends RuntimeException {
    public static final a Companion = null;
    private final int code;
    private final int papayaCode;

    public static final class a {
    }

    static {
        Companion = new a();
    }

    public AIKernelException(int r8, String r10, Throwable r11, int r12) {
        super(r10, r11);
        this.code = r8;
        this.papayaCode = r12;
    }

    public final int getCode() {
        return this.code;
    }

    public final int getPapayaCode() {
        return this.papayaCode;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder r8 = new StringBuilder("[");
        r8.append(this.code);
        r8.append('|');
        r8.append(this.papayaCode);
        r8.append("] [");
        r8.append(getMessage());
        r8.append("]:\n ");
        Throwable r10 = getCause();
        if (r10 == null) goto L5;
        String r11 = r10.toString();
    L6:
        r8.append(r11);
        return r8.toString();
    L5:
        r11 = null;
        goto L6
    }

    public /* synthetic */ AIKernelException(int r8, String r10, Throwable r11, int r12, int r13, e r14) {
        if ((r13 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 8) == 0) goto L11;
        r12 = 0;
    L11:
        this(r8, r10, r11, r12);
    }
}
