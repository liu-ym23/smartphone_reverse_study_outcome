package androidx.room.jarjarred.org.antlr.v4.codegen;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.gui.STViz;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CodeGenPipeline {
    Grammar g;

    public CodeGenPipeline(Grammar r5) {
        this.g = r5;
    }

    public void process() {
        if (CodeGenerator.targetExists(this.g.getOptionString("language")) == true) goto L5;
        return;
    L5:
        CodeGenerator r5 = new CodeGenerator(this.g);
        IntervalSet r10 = new IntervalSet(new int[0]);
        r10.add(28);
        r10.add(57);
        r10.add(66);
        Iterator<GrammarAST> r11 = this.g.ast.getNodesWithType(r10).iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        GrammarAST r12 = r11.next();
        if (r5.getTarget().grammarSymbolCausesIssueInGeneratedCode(r12) == false) goto L7;
        Grammar r13 = this.g;
        r13.tool.errMgr.grammarError(ErrorType.USE_OF_BAD_WORD, r13.fileName, r12.getToken(), new Object[]{r12.getText()});
        goto L7
    L11:
        int r14 = this.g.tool.errMgr.getNumErrors();
        if (this.g.isLexer() == false) goto L22;
        if (r5.getTarget().needsHeader() == false) goto L18;
        ST r15 = r5.generateLexer(true);
        if (this.g.tool.errMgr.getNumErrors() != r14) goto L18;
        writeRecognizer(r15, r5, true);
    L18:
        ST r16 = r5.generateLexer(false);
        if (this.g.tool.errMgr.getNumErrors() != r14) goto L69;
        writeRecognizer(r16, r5, false);
    L69:
        r5.writeVocabFile();
        return;
    L22:
        if (r5.getTarget().needsHeader() == false) goto L26;
        ST r17 = r5.generateParser(true);
        if (this.g.tool.errMgr.getNumErrors() != r14) goto L26;
        writeRecognizer(r17, r5, true);
    L26:
        ST r18 = r5.generateParser(false);
        if (this.g.tool.errMgr.getNumErrors() != r14) goto L30;
        writeRecognizer(r18, r5, false);
    L30:
        if (this.g.tool.gen_listener == false) goto L50;
        if (r5.getTarget().needsHeader() == false) goto L36;
        ST r19 = r5.generateListener(true);
        if (this.g.tool.errMgr.getNumErrors() != r14) goto L36;
        r5.writeListener(r19, true);
    L36:
        ST r20 = r5.generateListener(false);
        if (this.g.tool.errMgr.getNumErrors() != r14) goto L40;
        r5.writeListener(r20, false);
    L40:
        if (r5.getTarget().needsHeader() == false) goto L45;
        ST r21 = r5.generateBaseListener(true);
        if (this.g.tool.errMgr.getNumErrors() != r14) goto L45;
        r5.writeBaseListener(r21, true);
    L45:
        if (r5.getTarget().wantsBaseListener() == false) goto L50;
        ST r22 = r5.generateBaseListener(false);
        if (this.g.tool.errMgr.getNumErrors() != r14) goto L50;
        r5.writeBaseListener(r22, false);
    L50:
        if (this.g.tool.gen_visitor == false) goto L69;
        if (r5.getTarget().needsHeader() == false) goto L56;
        ST r23 = r5.generateVisitor(true);
        if (this.g.tool.errMgr.getNumErrors() != r14) goto L56;
        r5.writeVisitor(r23, true);
    L56:
        ST r24 = r5.generateVisitor(false);
        if (this.g.tool.errMgr.getNumErrors() != r14) goto L60;
        r5.writeVisitor(r24, false);
    L60:
        if (r5.getTarget().needsHeader() == false) goto L65;
        ST r25 = r5.generateBaseVisitor(true);
        if (this.g.tool.errMgr.getNumErrors() != r14) goto L65;
        r5.writeBaseVisitor(r25, true);
    L65:
        if (r5.getTarget().wantsBaseVisitor() == false) goto L69;
        ST r26 = r5.generateBaseVisitor(false);
        if (this.g.tool.errMgr.getNumErrors() != r14) goto L69;
        r5.writeBaseVisitor(r26, false);
        goto L69
    }

    public void writeRecognizer(ST r5, CodeGenerator r10, boolean r11) {
        if (this.g.tool.launch_ST_inspector == false) goto L10;
        STViz r12 = r5.inspect();
        if (this.g.tool.ST_inspector_wait_for_close == false) goto L10;
        r12.waitForClose();     // Catch: InterruptedException -> L8
    L8:
        e = move-exception;
        this.g.tool.errMgr.toolError(ErrorType.INTERNAL_ERROR, e, new Object[0]);
    L10:
        r10.writeRecognizer(r5, r11);
    }
}
