package androidx.room.jarjarred.org.antlr.v4.tool;

import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.RuleAST;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class LeftRecursionCyclesMessage extends ANTLRMessage {
    public LeftRecursionCyclesMessage(String r5, Collection<? extends Collection<Rule>> r10) {
        super(ErrorType.LEFT_RECURSION_CYCLES, getStartTokenOfFirstRule(r10), new Object[]{r10});
        this.fileName = r5;
    }

    public static Token getStartTokenOfFirstRule(Collection<? extends Collection<Rule>> r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        Iterator<? extends Collection<Rule>> r10 = r5.iterator();
    L7:
        if (r10.hasNext() == false) goto L18;
        Collection<Rule> r11 = r10.next();
        if (r11 == null) goto L10;
        Iterator<Rule> r12 = r11.iterator();
    L13:
        if (r12.hasNext() == false) goto L7;
        RuleAST r13 = r12.next().ast;
        if (r13 == null) goto L13;
        return r13.getToken();
    L10:
        return null;
    L18:
        return null;
    }
}
