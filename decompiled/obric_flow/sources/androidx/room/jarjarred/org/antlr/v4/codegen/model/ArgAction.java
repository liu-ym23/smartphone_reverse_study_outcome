package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;

/* JADX INFO: loaded from: classes.dex */
public class ArgAction extends Action {
    public String ctxType;

    public ArgAction(OutputModelFactory r5, ActionAST r10, String r11) {
        super(r5, r10);
        this.ctxType = r11;
    }
}
