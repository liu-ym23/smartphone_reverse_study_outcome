package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNState;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;

/* JADX INFO: loaded from: classes.dex */
public class RuleElement extends SrcOp {
    public int stateNumber;

    public RuleElement(OutputModelFactory r5, GrammarAST r10) {
        super(r5, r10);
        if (r10 == null) goto L8;
        ATNState r11 = r10.atnState;
        if (r11 == null) goto L9;
        this.stateNumber = r11.stateNumber;
        return;
    L9:
        return;
    }
}
