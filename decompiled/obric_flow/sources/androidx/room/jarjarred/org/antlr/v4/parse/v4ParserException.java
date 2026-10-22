package androidx.room.jarjarred.org.antlr.v4.parse;

import androidx.room.jarjarred.org.antlr.runtime.IntStream;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;

/* JADX INFO: loaded from: classes.dex */
public class v4ParserException extends RecognitionException {
    public String msg;

    public v4ParserException() {
    }

    public v4ParserException(String r5, IntStream r10) {
        super(r10);
        this.msg = r5;
    }
}
