package androidx.room.jarjarred.org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public class ParserRuleReturnScope extends RuleReturnScope {
    public Token start;
    public Token stop;

    public ParserRuleReturnScope() {
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
    public Object getStart() {
        return this.start;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
    public Object getStop() {
        return this.stop;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
    public Object getTree() {
        return null;
    }
}
