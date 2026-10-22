package androidx.room.jarjarred.org.antlr.v4.parse;

import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.ParseCancellationException;

/* JADX INFO: loaded from: classes.dex */
public class v3TreeGrammarException extends ParseCancellationException {
    public Token location;

    public v3TreeGrammarException(Token r5) {
        this.location = r5;
    }
}
