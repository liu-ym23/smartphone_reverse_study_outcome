package androidx.room.jarjarred.org.antlr.v4.semantics;

import androidx.room.jarjarred.org.antlr.runtime.ANTLRStringStream;
import androidx.room.jarjarred.org.antlr.v4.parse.ActionSplitter;
import androidx.room.jarjarred.org.antlr.v4.tool.Alternative;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.LexerGrammar;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class UseDefAnalyzer {
    public UseDefAnalyzer() {
    }

    public static boolean actionIsContextDependent(ActionAST r5) {
        ANTLRStringStream r10 = new ANTLRStringStream(r5.token.getText());
        r10.setLine(r5.token.getLine());
        r10.setCharPositionInLine(r5.token.getCharPositionInLine());
        final boolean[] r11 = {false};
        new ActionSplitter(r10, new AnonymousClass1(r11)).getActionTokens();
        return r11[0];
    }

    public static Map<Rule, Set<Rule>> getRuleDependencies(Grammar r5) {
        return getRuleDependencies(r5, r5.rules.values());
    }

    public static void trackTokenRuleRefsInActions(Grammar r12) {
        Iterator<Rule> r5 = r12.rules.values().iterator();
    L4:
        if (r5.hasNext() == false) goto L13;
        Rule r10 = r5.next();
        int r11 = 1;
    L7:
        if (r11 > r10.numberOfAlts) goto L4;
        Alternative r13 = r10.alt[r11];
        Iterator<ActionAST> r14 = r13.actions.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        ActionAST r15 = r14.next();
        new ActionSniffer(r12, r10, r13, r15, r15.token).examineAction();
        goto L10
    L12:
        r11 = r11 + 1;
        goto L7
    }

    public static Map<Rule, Set<Rule>> getRuleDependencies(LexerGrammar r5, String r10) {
        return getRuleDependencies(r5, (Collection) r5.modes.get(r10));
    }

    public static Map<Rule, Set<Rule>> getRuleDependencies(Grammar r5, Collection<Rule> r10) {
        HashMap r11 = new HashMap();
        Iterator<Rule> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L12;
        Rule r13 = r12.next();
        Iterator<GrammarAST> r14 = r13.ast.getNodesWithType(66).iterator();
    L7:
        if (r14.hasNext() == false) goto L4;
        GrammarAST r15 = r14.next();
        Set r16 = (Set) r11.get(r13);
        if (r16 != null) goto L11;
        r16 = new HashSet();
        r11.put(r13, r16);
    L11:
        r16.add(r5.getRule(r15.getText()));
        goto L7
    L12:
        return r11;
    }
}
