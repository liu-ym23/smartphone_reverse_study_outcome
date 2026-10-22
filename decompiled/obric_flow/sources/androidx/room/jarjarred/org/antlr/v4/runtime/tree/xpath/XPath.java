package androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.runtime.ANTLRInputStream;
import androidx.room.jarjarred.org.antlr.v4.runtime.CommonTokenStream;
import androidx.room.jarjarred.org.antlr.v4.runtime.LexerNoViableAltException;
import androidx.room.jarjarred.org.antlr.v4.runtime.Parser;
import androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext;
import androidx.room.jarjarred.org.antlr.v4.runtime.Token;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class XPath {
    public static final String NOT = "!";
    public static final String WILDCARD = "*";
    protected XPathElement[] elements;
    protected Parser parser;
    protected String path;

    public XPath(Parser r5, String r10) {
        this.parser = r5;
        this.path = r10;
        this.elements = split(r10);
    }

    public static Collection<ParseTree> findAll(ParseTree r5, String r10, Parser r11) {
        return new XPath(r11, r10).evaluate(r5);
    }

    public Collection<ParseTree> evaluate(ParseTree r5) {
        ParserRuleContext r10 = new ParserRuleContext();
        r10.children = Collections.singletonList(r5);
        Set r11 = Collections.singleton(r10);
        int r12 = 0;
    L4:
        if (r12 >= this.elements.length) goto L12;
        LinkedHashSet r13 = new LinkedHashSet();
        Iterator r14 = r11.iterator();
    L7:
        if (r14.hasNext() == false) goto L11;
        ParseTree r15 = (ParseTree) r14.next();
        if (r15.getChildCount() <= 0) goto L7;
        r13.addAll(this.elements[r12].evaluate(r15));
        goto L7
    L11:
        r12 = r12 + 1;
        r11 = r13;
        goto L4
    L12:
        return r11;
    }

    public XPathElement getXPathElement(Token r10, boolean r11) {
        if (r10.getType() == (-1)) goto L29;
        String r5 = r10.getText();
        int r12 = this.parser.getTokenType(r5);
        int r13 = this.parser.getRuleIndex(r5);
        int r14 = r10.getType();
        if (r14 != 1) goto L7;
    L21:
        if (r12 == 0) goto L26;
        if (r11 == false) goto L25;
        return new XPathTokenAnywhereElement(r5, r12);
    L25:
        return new XPathTokenElement(r5, r12);
    L26:
        StringBuilder r15 = j0.w(r5, " at index ");
        r15.append(r10.getStartIndex());
        r15.append(" isn't a valid token name");
        throw new IllegalArgumentException(r15.toString());
    L7:
        if (r14 != 5) goto L9;
        if (r11 == false) goto L20;
        return new XPathWildcardAnywhereElement();
    L20:
        return new XPathWildcardElement();
    L9:
        if (r14 == 8) goto L21;
        if (r13 == (-1)) goto L15;
        if (r11 == false) goto L14;
        return new XPathRuleAnywhereElement(r5, r13);
    L14:
        return new XPathRuleElement(r5, r13);
    L15:
        StringBuilder r16 = j0.w(r5, " at index ");
        r16.append(r10.getStartIndex());
        r16.append(" isn't a valid rule name");
        throw new IllegalArgumentException(r16.toString());
    L29:
        throw new IllegalArgumentException("Missing path element at end of path");
    }

    public XPathElement[] split(String r11) {
        final ANTLRInputStream r5 = new ANTLRInputStream(new StringReader(r11));     // Catch: IOException -> L39
        XPathLexer r10 = new AnonymousClass1(this, r5);
        r10.removeErrorListeners();
        r10.addErrorListener(new XPathLexerErrorListener());
        CommonTokenStream r12 = new CommonTokenStream(r10);
        r12.fill();     // Catch: LexerNoViableAltException -> L36
        List<Token> r13 = r12.getTokens();
        ArrayList r14 = new ArrayList();
        int r15 = r13.size();
        int r16 = 0;
    L6:
        if (r16 >= r15) goto L35;
        Token r17 = r13.get(r16);
        int r18 = r17.getType();
        if (r18 == (-1)) goto L35;
        if (r18 == 1) goto L33;
        if (r18 == 2) goto L33;
        if (r18 == 3) goto L23;
        if (r18 == 4) goto L23;
        if (r18 == 5) goto L33;
        throw new IllegalArgumentException("Unknowth path element " + r17);
    L23:
        if (r17.getType() != 3) goto L25;
        boolean r19 = true;
    L26:
        int r20 = r16 + 1;
        Token r21 = r13.get(r20);
        if (r21.getType() != 6) goto L29;
        boolean r22 = true;
    L30:
        if (r22 == false) goto L32;
        r20 = r16 + 2;
        r21 = r13.get(r20);
    L32:
        XPathElement r23 = getXPathElement(r21, r19);
        r23.invert = r22;
        r14.add(r23);
        r16 = r20 + 1;
        goto L6
    L29:
        r22 = false;
        goto L30
    L25:
        r19 = false;
    L33:
        r14.add(getXPathElement(r17, false));
        r16 = r16 + 1;
    L35:
        return (XPathElement[]) r14.toArray(new XPathElement[0]);
    L36:
        e = move-exception;
        throw new IllegalArgumentException("Invalid tokens or characters at index " + r10.getCharPositionInLine() + " in path '" + r11 + "'", e);
    L39:
        e = move-exception;
        throw new IllegalArgumentException(j0.C("Could not read path: ", r11), e);
    }
}
