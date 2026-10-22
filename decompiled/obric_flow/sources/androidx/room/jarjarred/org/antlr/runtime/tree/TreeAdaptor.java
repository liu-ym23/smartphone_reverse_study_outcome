package androidx.room.jarjarred.org.antlr.runtime.tree;

import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.TokenStream;

/* JADX INFO: loaded from: classes.dex */
public interface TreeAdaptor {
    void addChild(Object r5, Object r10);

    Object becomeRoot(Token r5, Object r10);

    Object becomeRoot(Object r5, Object r10);

    Object create(int r5, Token r10);

    Object create(int r5, Token r10, String r11);

    Object create(int r5, String r10);

    Object create(Token r5);

    Object deleteChild(Object r5, int r10);

    Object dupNode(Object r5);

    Object dupTree(Object r5);

    Object errorNode(TokenStream r5, Token r10, Token r11, RecognitionException r12);

    Object getChild(Object r5, int r10);

    int getChildCount(Object r5);

    int getChildIndex(Object r5);

    Object getParent(Object r5);

    String getText(Object r5);

    Token getToken(Object r5);

    int getTokenStartIndex(Object r5);

    int getTokenStopIndex(Object r5);

    int getType(Object r5);

    int getUniqueID(Object r5);

    boolean isNil(Object r5);

    Object nil();

    void replaceChildren(Object r5, int r10, int r11, Object r12);

    Object rulePostProcessing(Object r5);

    void setChild(Object r5, int r10, Object r11);

    void setChildIndex(Object r5, int r10);

    void setParent(Object r5, Object r10);

    void setText(Object r5, String r10);

    void setTokenBoundaries(Object r5, Token r10, Token r11);

    void setType(Object r5, int r10);
}
