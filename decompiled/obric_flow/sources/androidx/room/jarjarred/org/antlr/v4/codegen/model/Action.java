package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.runtime.CommonToken;
import androidx.room.jarjarred.org.antlr.v4.codegen.ActionTranslator;
import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.ActionChunk;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.ActionTemplate;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.ActionText;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.StructDecl;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Action extends RuleElement {

    @ModelElement
    public List<ActionChunk> chunks;

    public Action(OutputModelFactory r5, ActionAST r10) {
        super(r5, r10);
        RuleFunction r11 = r5.getCurrentRuleFunction();
        if (r10 == null) goto L5;
        this.chunks = ActionTranslator.translateAction(r5, r11, r10.token, r10);
        return;
    L5:
        this.chunks = new ArrayList();
    }

    public Action(OutputModelFactory r5, StructDecl r10, String r11) {
        super(r5, null);
        ActionAST r12 = new ActionAST(new CommonToken(4, r11));
        RuleFunction r13 = r5.getCurrentRuleFunction();
        if (r13 == null) goto L5;
        r12.resolver = r13.rule;
        this.chunks = ActionTranslator.translateActionChunk(r5, r13, r11, r12);
        return;
    L5:
        ArrayList r14 = new ArrayList();
        this.chunks = r14;
        r14.add(new ActionText(r10, r11));
    }

    public Action(OutputModelFactory r5, StructDecl r10, ST r11) {
        super(r5, null);
        ArrayList r12 = new ArrayList();
        this.chunks = r12;
        r12.add(new ActionTemplate(r10, r11));
    }
}
