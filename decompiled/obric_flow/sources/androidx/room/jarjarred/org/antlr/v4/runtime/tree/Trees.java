package androidx.room.jarjarred.org.antlr.v4.runtime.tree;

import androidx.room.jarjarred.org.antlr.v4.runtime.CommonToken;
import androidx.room.jarjarred.org.antlr.v4.runtime.Parser;
import androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext;
import androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext;
import androidx.room.jarjarred.org.antlr.v4.runtime.Token;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Predicate;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Trees {
    private Trees() {
    }

    public static void _findAllNodes(ParseTree r5, int r10, boolean r11, List<? super ParseTree> r12) {
        if (r11 == true) goto L4;
    L8:
        if (r11 == false) goto L10;
    L14:
        int r13 = 0;
    L16:
        if (r13 >= r5.getChildCount()) goto L18;
        _findAllNodes(r5.getChild(r13), r10, r11, r12);
        r13 = r13 + 1;
        goto L16
    L18:
        return;
    L10:
        if ((r5 instanceof ParserRuleContext) == false) goto L14;
        if (((ParserRuleContext) r5).getRuleIndex() != r10) goto L14;
        r12.add(r5);
        goto L14
    L4:
        if ((r5 instanceof TerminalNode) == false) goto L8;
        if (((TerminalNode) r5).getSymbol().getType() != r10) goto L14;
        r12.add(r5);
        goto L14
    }

    public static List<ParseTree> descendants(ParseTree r5) {
        return getDescendants(r5);
    }

    public static List<ParseTree> findAllNodes(ParseTree r5, int r10, boolean r11) {
        ArrayList r12 = new ArrayList();
        _findAllNodes(r5, r10, r11, r12);
        return r12;
    }

    public static Collection<ParseTree> findAllRuleNodes(ParseTree r5, int r10) {
        return findAllNodes(r5, r10, false);
    }

    public static Collection<ParseTree> findAllTokenNodes(ParseTree r5, int r10) {
        return findAllNodes(r5, r10, true);
    }

    public static Tree findNodeSuchThat(Tree r5, Predicate<Tree> r10) {
        if (r10.test(r5) == false) goto L6;
        return r5;
    L6:
        if (r5 != null) goto L8;
        return null;
    L8:
        int r11 = r5.getChildCount();
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L14;
        Tree r13 = findNodeSuchThat(r5.getChild(r12), r10);
        if (r13 != null) goto L12;
        r12 = r12 + 1;
        goto L9
    L12:
        return r13;
    L14:
        return null;
    }

    public static List<? extends Tree> getAncestors(Tree r5) {
        if (r5.getParent() == null) goto L5;
        ArrayList r10 = new ArrayList();
        Tree r11 = r5.getParent();
    L7:
        if (r11 == null) goto L9;
        r10.add(0, r11);
        r11 = r11.getParent();
        goto L7
    L9:
        return r10;
    L5:
        return Collections.emptyList();
    }

    public static List<Tree> getChildren(Tree r5) {
        ArrayList r10 = new ArrayList();
        int r11 = 0;
    L4:
        if (r11 >= r5.getChildCount()) goto L6;
        r10.add(r5.getChild(r11));
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    public static List<ParseTree> getDescendants(ParseTree r5) {
        ArrayList r10 = new ArrayList();
        r10.add(r5);
        int r11 = r5.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.addAll(getDescendants(r5.getChild(r12)));
        r12 = r12 + 1;
        goto L3
    L5:
        return r10;
    }

    public static String getNodeText(Tree r5, Parser r10) {
        List r11 = null;
        if (r10 == null) goto L5;
        String[] r12 = r10.getRuleNames();
    L6:
        if (r12 == null) goto L9;
        r11 = Arrays.asList(r12);
    L9:
        return getNodeText(r5, r11);
    L5:
        r12 = null;
        goto L6
    }

    public static ParserRuleContext getRootOfSubtreeEnclosingRegion(ParseTree r5, int r10, int r11) {
        int r12 = r5.getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        ParserRuleContext r14 = getRootOfSubtreeEnclosingRegion(r5.getChild(r13), r10, r11);
        if (r14 != null) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L9:
        if ((r5 instanceof ParserRuleContext) == false) goto L17;
        ParserRuleContext r15 = (ParserRuleContext) r5;
        if (r10 >= r15.getStart().getTokenIndex()) goto L13;
        return null;
    L13:
        if (r15.getStop() != null) goto L15;
    L16:
        return r15;
    L15:
        if (r11 <= r15.getStop().getTokenIndex()) goto L16;
        return null;
    L17:
        return null;
    }

    public static boolean isAncestorOf(Tree r5, Tree r10) {
        if (r5 == null) goto L14;
        if (r10 == null) goto L14;
        if (r5.getParent() == null) goto L14;
        Tree r11 = r10.getParent();
    L9:
        if (r11 == null) goto L14;
        if (r5 == r11) goto L11;
        r11 = r11.getParent();
        goto L9
    L11:
        return true;
    L14:
        return false;
    }

    public static void stripChildrenOutOfRange(ParserRuleContext r5, ParserRuleContext r10, int r11, int r12) {
        if (r5 != null) goto L4;
        return;
    L4:
        int r13 = 0;
    L6:
        if (r13 >= r5.getChildCount()) goto L17;
        ParseTree r14 = r5.getChild(r13);
        Interval r15 = r14.getSourceInterval();
        if ((r14 instanceof ParserRuleContext) == false) goto L16;
        if (r15.f666b < r11) goto L14;
        if (r15.f665a <= r12) goto L16;
    L14:
        if (isAncestorOf(r14, r10) == false) goto L16;
        r5.children.set(r13, new TerminalNodeImpl(new CommonToken(0, "...")));
    L16:
        r13 = r13 + 1;
        goto L6
    }

    public static String toStringTree(Tree r5) {
        return toStringTree(r5, null);
    }

    public static String toStringTree(Tree r5, Parser r10) {
        List r11 = null;
        if (r10 == null) goto L5;
        String[] r12 = r10.getRuleNames();
    L6:
        if (r12 == null) goto L9;
        r11 = Arrays.asList(r12);
    L9:
        return toStringTree(r5, r11);
    L5:
        r12 = null;
        goto L6
    }

    public static String getNodeText(Tree r5, List<String> r10) {
        if (r10 != null) goto L4;
    L20:
        Object r11 = r5.getPayload();
        if ((r11 instanceof Token) == false) goto L25;
        return ((Token) r11).getText();
    L25:
        return r5.getPayload().toString();
    L4:
        if ((r5 instanceof RuleContext) == false) goto L11;
        RuleContext r12 = (RuleContext) r5;
        String r13 = r10.get(r12.getRuleContext().getRuleIndex());
        int r14 = r12.getAltNumber();
        if (r14 != 0) goto L8;
        return r13;
    L8:
        return r13 + ":" + r14;
    L11:
        if ((r5 instanceof ErrorNode) == false) goto L15;
        return r5.toString();
    L15:
        if ((r5 instanceof TerminalNode) == false) goto L20;
        Token r15 = ((TerminalNode) r5).getSymbol();
        if (r15 == null) goto L20;
        return r15.getText();
    }

    public static String toStringTree(Tree r5, List<String> r10) {
        int r11 = 0;
        String r12 = Utils.escapeWhitespace(getNodeText(r5, r10), false);
        if (r5.getChildCount() != 0) goto L5;
        return r12;
    L5:
        StringBuilder r13 = new StringBuilder("(");
        r13.append(Utils.escapeWhitespace(getNodeText(r5, r10), false));
        r13.append(' ');
    L7:
        if (r11 >= r5.getChildCount()) goto L11;
        if (r11 <= 0) goto L10;
        r13.append(' ');
    L10:
        r13.append(toStringTree(r5.getChild(r11), r10));
        r11 = r11 + 1;
        goto L7
    L11:
        r13.append(")");
        return r13.toString();
    }
}
