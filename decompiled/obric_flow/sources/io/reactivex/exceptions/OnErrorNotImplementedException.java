package io.reactivex.exceptions;

/* JADX INFO: loaded from: classes3.dex */
public final class OnErrorNotImplementedException extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    public OnErrorNotImplementedException(String r5, Throwable r10) {
        if (r10 != null) goto L5;
        r10 = new NullPointerException();
    L5:
        super(r5, r10);
    }

    public OnErrorNotImplementedException(Throwable r5) {
        this("The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | " + r5, r5);
    }
}
