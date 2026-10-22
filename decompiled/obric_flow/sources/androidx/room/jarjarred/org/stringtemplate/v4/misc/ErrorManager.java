package androidx.room.jarjarred.org.stringtemplate.v4.misc;

import androidx.room.jarjarred.org.antlr.runtime.CharStream;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.stringtemplate.v4.InstanceScope;
import androidx.room.jarjarred.org.stringtemplate.v4.Interpreter;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.STErrorListener;

/* JADX INFO: loaded from: classes.dex */
public class ErrorManager {
    public static STErrorListener DEFAULT_ERROR_LISTENER;
    public final STErrorListener listener;

    static {
        DEFAULT_ERROR_LISTENER = new AnonymousClass1();
    }

    public ErrorManager() {
        this(DEFAULT_ERROR_LISTENER);
    }

    public void IOError(ST r5, ErrorType r10, Throwable r11) {
        this.listener.IOError(new STMessage(r10, r5, r11));
    }

    public void compileTimeError(ErrorType r10, Token r11, Token r12) {
        CharStream r5 = r12.getInputStream();
        if (r5 == null) goto L8;
        String r13 = r5.getSourceName();
        if (r13 == null) goto L7;
        r13 = Misc.getFileName(r13);
    L7:
        String r14 = r13;
        this.listener.compileTimeError(new STCompiletimeMessage(r10, r14, r11, r12, null, r12.getText()));
        return;
    L8:
        r13 = null;
        goto L7
    }

    public void groupLexerError(ErrorType r10, String r11, RecognitionException r12, String r13) {
        this.listener.compileTimeError(new STGroupCompiletimeMessage(r10, r11, r12.token, r12, r13));
    }

    public void groupSyntaxError(ErrorType r10, String r11, RecognitionException r12, String r13) {
        Token r5 = r12.token;
        this.listener.compileTimeError(new STGroupCompiletimeMessage(r10, r11, r5, r12, r13));
    }

    public void internalError(ST r5, String r10, Throwable r11) {
        this.listener.internalError(new STMessage(ErrorType.INTERNAL_ERROR, r5, r11, r10));
    }

    public void lexerError(String r5, String r10, Token r11, RecognitionException r12) {
        if (r5 == null) goto L4;
        r5 = Misc.getFileName(r5);
    L4:
        this.listener.compileTimeError(new STLexerMessage(r5, r10, r11, r12));
    }

    public void runTimeError(Interpreter r5, InstanceScope r10, ErrorType r11) {
        STErrorListener r12 = this.listener;
        if (r10 == null) goto L5;
        int r13 = r10.f674ip;
    L6:
        r12.runTimeError(new STRuntimeMessage(r5, r11, r13, r10));
        return;
    L5:
        r13 = 0;
        goto L6
    }

    public ErrorManager(STErrorListener r5) {
        this.listener = r5;
    }

    public void IOError(ST r5, ErrorType r10, Throwable r11, Object r12) {
        this.listener.IOError(new STMessage(r10, r5, r11, r12));
    }

    public void runTimeError(Interpreter r10, InstanceScope r11, ErrorType r12, Object r13) {
        STErrorListener r14 = this.listener;
        if (r11 == null) goto L6;
        int r5 = r11.f674ip;
    L7:
        r14.runTimeError(new STRuntimeMessage(r10, r12, r5, r11, r13));
        return;
    L6:
        r5 = 0;
        goto L7
    }

    public void runTimeError(Interpreter r10, InstanceScope r11, ErrorType r12, Throwable r13, Object r14) {
        STErrorListener r15 = this.listener;
        if (r11 == null) goto L6;
        int r5 = r11.f674ip;
    L7:
        r15.runTimeError(new STRuntimeMessage(r10, r12, r5, r11, r13, r14));
        return;
    L6:
        r5 = 0;
        goto L7
    }

    public void runTimeError(Interpreter r10, InstanceScope r11, ErrorType r12, Object r13, Object r14) {
        STErrorListener r15 = this.listener;
        if (r11 == null) goto L6;
        int r5 = r11.f674ip;
    L7:
        r15.runTimeError(new STRuntimeMessage(r10, r12, r5, r11, null, r13, r14));
        return;
    L6:
        r5 = 0;
        goto L7
    }

    public void runTimeError(Interpreter r12, InstanceScope r13, ErrorType r14, Object r15, Object r16, Object r17) {
        STErrorListener r10 = this.listener;
        if (r13 == null) goto L6;
        int r5 = r13.f674ip;
    L7:
        r10.runTimeError(new STRuntimeMessage(r12, r14, r5, r13, null, r15, r16, r17));
        return;
    L6:
        r5 = 0;
        goto L7
    }

    public void compileTimeError(ErrorType r10, Token r11, Token r12, Object r13) {
        String r5 = r12.getInputStream().getSourceName();
        if (r5 == null) goto L5;
        r5 = Misc.getFileName(r5);
    L5:
        this.listener.compileTimeError(new STCompiletimeMessage(r10, r5, r11, r12, null, r13));
    }

    public void compileTimeError(ErrorType r10, Token r11, Token r12, Object r13, Object r14) {
        String r5 = r12.getInputStream().getSourceName();
        if (r5 == null) goto L5;
        r5 = Misc.getFileName(r5);
    L5:
        this.listener.compileTimeError(new STCompiletimeMessage(r10, r5, r11, r12, null, r13, r14));
    }
}
