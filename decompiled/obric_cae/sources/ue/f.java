package ue;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient ae.f f12592a;

    public f(ae.f r8) {
        this.f12592a = r8;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public final String getLocalizedMessage() {
        return this.f12592a.toString();
    }
}
