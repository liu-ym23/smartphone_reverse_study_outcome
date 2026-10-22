package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.tool.Alternative;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;

/* JADX INFO: loaded from: classes.dex */
public class CodeBlockForOuterMostAlt extends CodeBlockForAlt {
    public Alternative alt;
    public String altLabel;

    public CodeBlockForOuterMostAlt(OutputModelFactory r5, Alternative r10) {
        super(r5);
        this.alt = r10;
        GrammarAST r11 = r10.ast.altLabel;
        if (r11 == null) goto L5;
        String r12 = r11.getText();
    L6:
        this.altLabel = r12;
        return;
    L5:
        r12 = null;
        goto L6
    }
}
