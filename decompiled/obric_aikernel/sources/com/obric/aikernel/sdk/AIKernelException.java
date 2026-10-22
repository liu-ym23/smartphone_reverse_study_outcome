package com.obric.aikernel.sdk;

import androidx.annotation.Keep;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class AIKernelException extends RuntimeException {
    public static final a Companion = null;
    private final int code;
    private final int papayaCode;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Throwable a(Object r10) {
            Throwable r11 = Result.m35exceptionOrNullimpl(r10);
            if (r11 != null) goto L6;
            String r12 = "call failed but no exception set.";
            return new AIKernelException(108, r12, null, 0, 12, null);
        L6:
            return r11;
        }
    }

    static {
        Companion = new a(null);
    }

    public AIKernelException(int r10, String r11, Throwable r12, int r13) {
        super(r11, r12);
        this.code = r10;
        this.papayaCode = r13;
    }

    public /* synthetic */ AIKernelException(int r10, String r11, Throwable r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = null;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = 0;
    L11:
        this(r10, r11, r12, r13);
    }

    public final int getCode() {
        return this.code;
    }

    public final int getPapayaCode() {
        return this.papayaCode;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append('[');
        r10.append(this.code);
        r10.append('|');
        r10.append(this.papayaCode);
        r10.append("] [");
        r10.append(getMessage());
        r10.append("]:\n ");
        Throwable r11 = getCause();
        if (r11 == null) goto L5;
        String r12 = r11.toString();
    L6:
        r10.append(r12);
        return r10.toString();
    L5:
        r12 = null;
        goto L6
    }
}
