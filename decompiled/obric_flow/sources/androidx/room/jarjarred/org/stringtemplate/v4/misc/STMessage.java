package androidx.room.jarjarred.org.stringtemplate.v4.misc;

import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes.dex */
public class STMessage {
    public Object arg;
    public Object arg2;
    public Object arg3;
    public Throwable cause;
    public ErrorType error;
    public ST self;

    public STMessage(ErrorType r5) {
        this.error = r5;
    }

    public String toString() {
        StringWriter r5 = new StringWriter();
        PrintWriter r10 = new PrintWriter(r5);
        r10.print(String.format(this.error.message, new Object[]{this.arg, this.arg2, this.arg3}));
        if (this.cause == null) goto L6;
        r10.print("\nCaused by: ");
        this.cause.printStackTrace(r10);
    L6:
        return r5.toString();
    }

    public STMessage(ErrorType r5, ST r10) {
        this(r5);
        this.self = r10;
    }

    public STMessage(ErrorType r5, ST r10, Throwable r11) {
        this(r5, r10);
        this.cause = r11;
    }

    public STMessage(ErrorType r5, ST r10, Throwable r11, Object r12) {
        this(r5, r10, r11);
        this.arg = r12;
    }

    public STMessage(ErrorType r5, ST r10, Throwable r11, Token r12, Object r13) {
        this(r5, r10, r11, r12);
        this.arg = r13;
    }

    public STMessage(ErrorType r5, ST r10, Throwable r11, Object r12, Object r13) {
        this(r5, r10, r11, r12);
        this.arg2 = r13;
    }

    public STMessage(ErrorType r5, ST r10, Throwable r11, Object r12, Object r13, Object r14) {
        this(r5, r10, r11, r12, r13);
        this.arg3 = r14;
    }
}
