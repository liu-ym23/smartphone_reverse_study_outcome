package androidx.room.jarjarred.org.antlr.v4.runtime;

/* JADX INFO: loaded from: classes.dex */
public class RuleContextWithAltNum extends ParserRuleContext {
    public int altNum;

    public RuleContextWithAltNum() {
        this.altNum = 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
    public int getAltNumber() {
        return this.altNum;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
    public void setAltNumber(int r5) {
        this.altNum = r5;
    }

    public RuleContextWithAltNum(ParserRuleContext r5, int r10) {
        super(r5, r10);
    }
}
