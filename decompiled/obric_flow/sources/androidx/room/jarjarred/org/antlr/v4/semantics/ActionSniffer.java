package androidx.room.jarjarred.org.antlr.v4.semantics;

import androidx.room.jarjarred.org.antlr.runtime.ANTLRStringStream;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.v4.parse.ActionSplitter;
import androidx.room.jarjarred.org.antlr.v4.tool.Alternative;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorManager;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ActionSniffer extends BlankActionSplitterListener {
    public Token actionToken;
    public Alternative alt;
    public ErrorManager errMgr;
    public Grammar g;
    public ActionAST node;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Rule f672r;

    public ActionSniffer(Grammar r5, Rule r10, Alternative r11, ActionAST r12, Token r13) {
        this.g = r5;
        this.f672r = r10;
        this.alt = r11;
        this.node = r12;
        this.actionToken = r13;
        this.errMgr = r5.tool.errMgr;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.semantics.BlankActionSplitterListener, androidx.room.jarjarred.org.antlr.v4.parse.ActionSplitterListener
    public void attr(String r5, Token r10) {
        trackRef(r10);
    }

    public void examineAction() {
        ANTLRStringStream r5 = new ANTLRStringStream(this.actionToken.getText());
        r5.setLine(this.actionToken.getLine());
        r5.setCharPositionInLine(this.actionToken.getCharPositionInLine());
        ActionSplitter r10 = new ActionSplitter(r5, this);
        ActionAST r11 = this.node;
        r11.chunks = r10.getActionTokens();
    }

    public void processNested(Token r5) {
        ANTLRStringStream r10 = new ANTLRStringStream(r5.getText());
        r10.setLine(r5.getLine());
        r10.setCharPositionInLine(r5.getCharPositionInLine());
        new ActionSplitter(r10, this).getActionTokens();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.semantics.BlankActionSplitterListener, androidx.room.jarjarred.org.antlr.v4.parse.ActionSplitterListener
    public void qualifiedAttr(String r5, Token r10, Token r11) {
        trackRef(r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.semantics.BlankActionSplitterListener, androidx.room.jarjarred.org.antlr.v4.parse.ActionSplitterListener
    public void setAttr(String r5, Token r10, Token r11) {
        trackRef(r10);
        processNested(r11);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.semantics.BlankActionSplitterListener, androidx.room.jarjarred.org.antlr.v4.parse.ActionSplitterListener
    public void setNonLocalAttr(String r5, Token r10, Token r11, Token r12) {
        processNested(r12);
    }

    public void trackRef(Token r5) {
        if (((List) this.alt.tokenRefs.get(r5.getText())) == null) goto L6;
        this.alt.tokenRefsInActions.map(r5.getText(), this.node);
    L6:
        if (((List) this.alt.ruleRefs.get(r5.getText())) == null) goto L9;
        this.alt.ruleRefsInActions.map(r5.getText(), this.node);
        return;
    }
}
