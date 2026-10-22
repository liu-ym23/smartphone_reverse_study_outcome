package androidx.room.jarjarred.org.antlr.v4.tool;

import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;

/* JADX INFO: loaded from: classes.dex */
public interface AttributeResolver {
    Attribute resolveToAttribute(String r5, ActionAST r10);

    Attribute resolveToAttribute(String r5, String r10, ActionAST r11);

    boolean resolvesToAttributeDict(String r5, ActionAST r10);

    boolean resolvesToLabel(String r5, ActionAST r10);

    boolean resolvesToListLabel(String r5, ActionAST r10);

    boolean resolvesToToken(String r5, ActionAST r10);
}
