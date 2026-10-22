package pe;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public final class f1 extends CancellationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient e1 f10010a;

    public f1(String r8, Throwable r10, e1 r11) {
        super(r8);
        this.f10010a = r11;
        if (r10 == null) goto L6;
        initCause(r10);
        return;
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L4;
    L13:
        return true;
    L4:
        if ((r8 instanceof f1) == false) goto L12;
        f1 r10 = (f1) r8;
        if (he.i.a(r10.getMessage(), getMessage()) == false) goto L12;
        if (he.i.a(r10.f10010a, this.f10010a) == false) goto L12;
        if (he.i.a(r10.getCause(), getCause()) == true) goto L13;
    L12:
        return false;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String r8 = getMessage();
        he.i.c(r8);
        int r10 = r8.hashCode() * 31;
        int r11 = (this.f10010a.hashCode() + r10) * 31;
        Throwable r12 = getCause();
        if (r12 == null) goto L5;
        int r13 = r12.hashCode();
    L7:
        return r11 + r13;
    L5:
        r13 = 0;
        goto L7
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.f10010a;
    }
}
