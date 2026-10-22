package androidx.room.jarjarred.org.antlr.v4.runtime;

import ai.j0;
import java.io.PrintStream;

/* JADX INFO: loaded from: classes.dex */
public class ConsoleErrorListener extends BaseErrorListener {
    public static final ConsoleErrorListener INSTANCE = null;

    static {
        INSTANCE = new ConsoleErrorListener();
    }

    public ConsoleErrorListener() {
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.BaseErrorListener, androidx.room.jarjarred.org.antlr.v4.runtime.ANTLRErrorListener
    public void syntaxError(Recognizer<?, ?> r5, Object r10, int r11, int r12, String r13, RecognitionException r14) {
        PrintStream r15 = System.err;
        StringBuilder r16 = j0.v("line ", r11, r12, ":", " ");
        r16.append(r13);
        r15.println(r16.toString());
    }
}
