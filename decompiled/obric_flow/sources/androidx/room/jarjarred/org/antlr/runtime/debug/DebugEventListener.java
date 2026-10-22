package androidx.room.jarjarred.org.antlr.runtime.debug;

import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;

/* JADX INFO: loaded from: classes.dex */
public interface DebugEventListener {
    public static final int FALSE = 0;
    public static final String PROTOCOL_VERSION = "2";
    public static final int TRUE = 1;

    void LT(int r5, Token r10);

    void LT(int r5, Object r10);

    void addChild(Object r5, Object r10);

    void becomeRoot(Object r5, Object r10);

    void beginBacktrack(int r5);

    void beginResync();

    void commence();

    void consumeHiddenToken(Token r5);

    void consumeNode(Object r5);

    void consumeToken(Token r5);

    void createNode(Object r5);

    void createNode(Object r5, Token r10);

    void endBacktrack(int r5, boolean r10);

    void endResync();

    void enterAlt(int r5);

    void enterDecision(int r5, boolean r10);

    void enterRule(String r5, String r10);

    void enterSubRule(int r5);

    void errorNode(Object r5);

    void exitDecision(int r5);

    void exitRule(String r5, String r10);

    void exitSubRule(int r5);

    void location(int r5, int r10);

    void mark(int r5);

    void nilNode(Object r5);

    void recognitionException(RecognitionException r5);

    void rewind();

    void rewind(int r5);

    void semanticPredicate(boolean r5, String r10);

    void setTokenBoundaries(Object r5, int r10, int r11);

    void terminate();
}
