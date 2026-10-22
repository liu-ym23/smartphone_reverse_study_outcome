package androidx.room.jarjarred.org.antlr.v4.parse;

import androidx.room.jarjarred.org.antlr.runtime.Token;

/* JADX INFO: loaded from: classes.dex */
public interface ActionSplitterListener {
    void attr(String r5, Token r10);

    void nonLocalAttr(String r5, Token r10, Token r11);

    void qualifiedAttr(String r5, Token r10, Token r11);

    void setAttr(String r5, Token r10, Token r11);

    void setNonLocalAttr(String r5, Token r10, Token r11, Token r12);

    void text(String r5);
}
