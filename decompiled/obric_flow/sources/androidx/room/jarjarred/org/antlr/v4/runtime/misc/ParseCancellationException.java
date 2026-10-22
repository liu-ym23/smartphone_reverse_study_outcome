package androidx.room.jarjarred.org.antlr.v4.runtime.misc;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public class ParseCancellationException extends CancellationException {
    public ParseCancellationException() {
    }

    public ParseCancellationException(String r5) {
        super(r5);
    }

    public ParseCancellationException(Throwable r5) {
        initCause(r5);
    }

    public ParseCancellationException(String r5, Throwable r10) {
        super(r5);
        initCause(r10);
    }
}
