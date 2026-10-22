package androidx.room.jarjarred.org.antlr.v4.tool;

import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleAltInfo;
import androidx.room.jarjarred.org.antlr.v4.misc.OrderedHashMap;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Pair;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.AltAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.RuleAST;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LeftRecursiveRule extends Rule {
    public List<Pair<GrammarAST, String>> leftRecursiveRuleRefLabels;
    public RuleAST originalAST;
    public OrderedHashMap<Integer, LeftRecursiveRuleAltInfo> recOpAlts;
    public List<LeftRecursiveRuleAltInfo> recPrimaryAlts;

    public LeftRecursiveRule(Grammar r5, String r10, RuleAST r11) {
        int r12 = 1;
        super(r5, r10, r11, 1);
        this.leftRecursiveRuleRefLabels = new ArrayList();
        this.originalAST = r11;
        this.alt = new Alternative[this.numberOfAlts + 1];
    L4:
        if (r12 > this.numberOfAlts) goto L6;
        this.alt[r12] = new Alternative(this, r12);
        r12 = r12 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.Rule
    public Map<String, List<Pair<Integer, AltAST>>> getAltLabels() {
        HashMap r5 = new HashMap();
        Map<String, List<Pair<Integer, AltAST>>> r10 = super.getAltLabels();
        if (r10 == null) goto L5;
        r5.putAll(r10);
    L5:
        List<LeftRecursiveRuleAltInfo> r11 = this.recPrimaryAlts;
        if (r11 == null) goto L17;
        Iterator<LeftRecursiveRuleAltInfo> r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L17;
        LeftRecursiveRuleAltInfo r13 = r12.next();
        String r14 = r13.altLabel;
        if (r14 == null) goto L9;
        List r15 = (List) r5.get(r14);
        if (r15 != null) goto L15;
        r15 = new ArrayList();
        r5.put(r13.altLabel, r15);
    L15:
        r15.add(new Pair(Integer.valueOf(r13.altNum), r13.originalAltAST));
    L17:
        if (this.recOpAlts == null) goto L29;
        int r16 = 0;
    L20:
        if (r16 >= this.recOpAlts.size()) goto L29;
        LeftRecursiveRuleAltInfo r17 = this.recOpAlts.getElement(r16);
        String r18 = r17.altLabel;
        if (r18 == null) goto L27;
        List r19 = (List) r5.get(r18);
        if (r19 != null) goto L26;
        r19 = new ArrayList();
        r5.put(r17.altLabel, r19);
    L26:
        r19.add(new Pair(Integer.valueOf(r17.altNum), r17.originalAltAST));
    L27:
        r16 = r16 + 1;
    L29:
        if (r5.isEmpty() == false) goto L32;
        return null;
    L32:
        return r5;
    }

    public RuleAST getOriginalAST() {
        return this.originalAST;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.Rule
    public int getOriginalNumberOfAlts() {
        List<LeftRecursiveRuleAltInfo> r5 = this.recPrimaryAlts;
        if (r5 == null) goto L5;
        int r10 = r5.size();
    L6:
        OrderedHashMap<Integer, LeftRecursiveRuleAltInfo> r11 = this.recOpAlts;
        if (r11 != null) goto L9;
        return r10;
    L9:
        return r10 + r11.size();
    L5:
        r10 = 0;
        goto L6
    }

    public int[] getPrimaryAlts() {
        if (this.recPrimaryAlts.size() != 0) goto L6;
        return null;
    L6:
        int[] r5 = new int[this.recPrimaryAlts.size() + 1];
        int r10 = 0;
    L8:
        if (r10 >= this.recPrimaryAlts.size()) goto L10;
        LeftRecursiveRuleAltInfo r11 = this.recPrimaryAlts.get(r10);
        r10 = r10 + 1;
        r5[r10] = r11.altNum;
        goto L8
    L10:
        return r5;
    }

    public int[] getRecursiveOpAlts() {
        if (this.recOpAlts.size() != 0) goto L6;
        return null;
    L6:
        int[] r5 = new int[this.recOpAlts.size() + 1];
        Iterator<LeftRecursiveRuleAltInfo> r10 = this.recOpAlts.values().iterator();
        int r11 = 1;
    L8:
        if (r10.hasNext() == false) goto L10;
        r5[r11] = r10.next().altNum;
        r11 = r11 + 1;
        goto L8
    L10:
        return r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.Rule
    public List<AltAST> getUnlabeledAltASTs() {
        ArrayList r5 = new ArrayList();
        Iterator<LeftRecursiveRuleAltInfo> r10 = this.recPrimaryAlts.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        LeftRecursiveRuleAltInfo r11 = r10.next();
        if (r11.altLabel != null) goto L4;
        r5.add(r11.originalAltAST);
        goto L4
    L8:
        int r12 = 0;
    L10:
        if (r12 >= this.recOpAlts.size()) goto L16;
        LeftRecursiveRuleAltInfo r13 = this.recOpAlts.getElement(r12);
        if (r13.altLabel != null) goto L14;
        r5.add(r13.originalAltAST);
    L14:
        r12 = r12 + 1;
        goto L10
    L16:
        if (r5.isEmpty() == false) goto L19;
        return null;
    L19:
        return r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.Rule
    public boolean hasAltSpecificContexts() {
        if (super.hasAltSpecificContexts() == false) goto L5;
    L8:
        return true;
    L5:
        if (getAltLabels() != null) goto L8;
        return false;
    }
}
