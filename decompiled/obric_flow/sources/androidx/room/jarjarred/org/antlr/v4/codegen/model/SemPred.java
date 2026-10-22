package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.org.antlr.v4.codegen.ActionTranslator;
import androidx.room.jarjarred.org.antlr.v4.codegen.CodeGenerator;
import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.ActionChunk;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SemPred extends Action {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @ModelElement
    public List<ActionChunk> failChunks;
    public String msg;
    public String predicate;

    public SemPred(OutputModelFactory r5, ActionAST r10) {
        super(r5, r10);
        GrammarAST r11 = r10.getOptionAST("fail");
        CodeGenerator r12 = r5.getGenerator();
        String r13 = r10.getText();
        this.predicate = r13;
        if (r13.startsWith("{") == true) goto L5;
    L7:
        this.predicate = r12.getTarget().getTargetStringLiteralFromString(this.predicate);
        if (r11 != null) goto L11;
        return;
    L11:
        if ((r11 instanceof ActionAST) == false) goto L13;
        ActionAST r14 = (ActionAST) r11;
        this.failChunks = ActionTranslator.translateAction(r5, r5.getCurrentRuleFunction(), r14.token, r14);
        return;
    L13:
        this.msg = r12.getTarget().getTargetStringLiteralFromANTLRStringLiteral(r12, r11.getText(), true);
        return;
    L5:
        if (this.predicate.endsWith("}?") == false) goto L7;
        this.predicate = a.n(this.predicate, 2, 1);
        goto L7
    }
}
