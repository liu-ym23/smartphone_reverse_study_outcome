package androidx.room.jarjarred.org.antlr.v4.tool;

import androidx.room.jarjarred.org.antlr.v4.runtime.InterpreterRuleContext;
import androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext;

/* JADX INFO: loaded from: classes.dex */
public class GrammarInterpreterRuleContext extends InterpreterRuleContext {
    protected int outerAltNum;

    public GrammarInterpreterRuleContext(ParserRuleContext r5, int r10, int r11) {
        super(r5, r10, r11);
        this.outerAltNum = 1;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
    public int getAltNumber() {
        return getOuterAltNum();
    }

    public int getOuterAltNum() {
        return this.outerAltNum;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
    public void setAltNumber(int r5) {
        setOuterAltNum(r5);
    }

    public void setOuterAltNum(int r5) {
        this.outerAltNum = r5;
    }
}
