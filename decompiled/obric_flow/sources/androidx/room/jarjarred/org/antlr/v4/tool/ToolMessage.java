package androidx.room.jarjarred.org.antlr.v4.tool;

import androidx.room.jarjarred.org.antlr.runtime.Token;

/* JADX INFO: loaded from: classes.dex */
public class ToolMessage extends ANTLRMessage {
    public ToolMessage(ErrorType r5) {
        super(r5);
    }

    public ToolMessage(ErrorType r5, Object... r10) {
        super(r5, null, Token.INVALID_TOKEN, r10);
    }

    public ToolMessage(ErrorType r5, Throwable r10, Object... r11) {
        super(r5, r10, Token.INVALID_TOKEN, r11);
    }
}
