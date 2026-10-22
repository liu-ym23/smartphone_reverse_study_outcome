package androidx.room.jarjarred.org.antlr.v4.analysis;

import androidx.room.jarjarred.org.antlr.v4.tool.ast.AltAST;

/* JADX INFO: loaded from: classes.dex */
public class LeftRecursiveRuleAltInfo {
    public AltAST altAST;
    public String altLabel;
    public int altNum;
    public String altText;
    public final boolean isListLabel;
    public String leftRecursiveRuleRefLabel;
    public int nextPrec;
    public AltAST originalAltAST;

    public LeftRecursiveRuleAltInfo(int r10, String r11) {
        this(r10, r11, null, null, false, null);
    }

    public LeftRecursiveRuleAltInfo(int r5, String r10, String r11, String r12, boolean r13, AltAST r14) {
        this.altNum = r5;
        this.altText = r10;
        this.leftRecursiveRuleRefLabel = r11;
        this.altLabel = r12;
        this.isListLabel = r13;
        this.originalAltAST = r14;
    }
}
