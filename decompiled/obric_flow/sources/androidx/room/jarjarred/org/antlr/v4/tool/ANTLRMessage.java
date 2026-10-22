package androidx.room.jarjarred.org.antlr.v4.tool;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ANTLRMessage {
    private static final Object[] EMPTY_ARGS = null;
    private final Object[] args;
    public int charPosition;
    private final Throwable e;
    private final ErrorType errorType;
    public String fileName;
    public Grammar g;
    public int line;
    public Token offendingToken;

    static {
        EMPTY_ARGS = new Object[0];
    }

    public ANTLRMessage(ErrorType r5) {
        this(r5, null, Token.INVALID_TOKEN, new Object[0]);
    }

    public Object[] getArgs() {
        Object[] r5 = this.args;
        if (r5 == null) goto L5;
        return r5;
    L5:
        return EMPTY_ARGS;
    }

    public Throwable getCause() {
        return this.e;
    }

    public ErrorType getErrorType() {
        return this.errorType;
    }

    public ST getMessageTemplate(boolean r5) {
        ST r10 = new ST(getErrorType().msg);
        r10.impl.name = this.errorType.name();
        r10.add("verbose", Boolean.valueOf(r5));
        Object[] r11 = getArgs();
        int r12 = 0;
    L4:
        if (r12 >= r11.length) goto L10;
        String r13 = "arg";
        if (r12 <= 0) goto L8;
        r13 = "arg" + (r12 + 1);
    L8:
        r10.add(r13, r11[r12]);
        r12 = r12 + 1;
        goto L4
    L10:
        if (r11.length >= 2) goto L12;
        r10.add("arg2", null);
    L12:
        Throwable r14 = getCause();
        if (r14 == null) goto L15;
        r10.add("exception", r14);
        r10.add("stackTrace", r14.getStackTrace());
    L16:
        return r10;
    L15:
        r10.add("exception", null);
        r10.add("stackTrace", null);
        goto L16
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("Message{errorType=");
        r5.append(getErrorType());
        r5.append(", args=");
        r5.append(Arrays.asList(getArgs()));
        r5.append(", e=");
        r5.append(getCause());
        r5.append(", fileName='");
        r5.append(this.fileName);
        r5.append("', line=");
        r5.append(this.line);
        r5.append(", charPosition=");
        return j0.n(r5, this.charPosition, '}');
    }

    public ANTLRMessage(ErrorType r5, Token r10, Object... r11) {
        this(r5, null, r10, r11);
    }

    public ANTLRMessage(ErrorType r5, Throwable r10, Token r11, Object... r12) {
        this.line = -1;
        this.charPosition = -1;
        this.errorType = r5;
        this.e = r10;
        this.args = r12;
        this.offendingToken = r11;
    }
}
