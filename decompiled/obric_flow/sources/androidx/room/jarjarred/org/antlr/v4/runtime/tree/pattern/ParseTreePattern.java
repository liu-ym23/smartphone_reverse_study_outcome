package androidx.room.jarjarred.org.antlr.v4.runtime.tree.pattern;

import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ParseTreePattern {
    private final ParseTreePatternMatcher matcher;
    private final String pattern;
    private final int patternRuleIndex;
    private final ParseTree patternTree;

    public ParseTreePattern(ParseTreePatternMatcher r5, String r10, int r11, ParseTree r12) {
        this.matcher = r5;
        this.patternRuleIndex = r11;
        this.pattern = r10;
        this.patternTree = r12;
    }

    public List<ParseTreeMatch> findAll(ParseTree r5, String r10) {
        Collection<ParseTree> r11 = XPath.findAll(r5, r10, this.matcher.getParser());
        ArrayList r12 = new ArrayList();
        Iterator<ParseTree> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        ParseTreeMatch r14 = match(r13.next());
        if (r14.succeeded() == false) goto L4;
        r12.add(r14);
        goto L4
    L8:
        return r12;
    }

    public ParseTreePatternMatcher getMatcher() {
        return this.matcher;
    }

    public String getPattern() {
        return this.pattern;
    }

    public int getPatternRuleIndex() {
        return this.patternRuleIndex;
    }

    public ParseTree getPatternTree() {
        return this.patternTree;
    }

    public ParseTreeMatch match(ParseTree r5) {
        return this.matcher.match(r5, this);
    }

    public boolean matches(ParseTree r5) {
        return this.matcher.match(r5, this).succeeded();
    }
}
