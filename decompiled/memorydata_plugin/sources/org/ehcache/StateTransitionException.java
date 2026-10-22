package org.ehcache;

/* JADX INFO: loaded from: classes7.dex */
public class StateTransitionException extends RuntimeException {
    private static final long serialVersionUID = 7602752670854885218L;

    public StateTransitionException(Throwable r2) {
        super(r2.getMessage(), r2);
    }
}
