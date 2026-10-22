package com.ctc.wstx.shaded.msv_core.grammar.xmlschema;

import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.OtherExp;

/* JADX INFO: loaded from: classes2.dex */
public class OccurrenceExp extends OtherExp {
    private static final long serialVersionUID = 1;
    public final Expression itemExp;
    public final int maxOccurs;
    public final int minOccurs;

    public OccurrenceExp(Expression r1, int r2, int r3, Expression r4) {
        super(r1);
        this.maxOccurs = r2;
        this.minOccurs = r3;
        this.itemExp = r4;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append(this.itemExp.toString()).append("[").append(this.minOccurs).append(",");
        int r2 = this.maxOccurs;
        if (r2 != (-1)) goto L5;
        String r3 = "inf";
    L7:
        return r0.append(r3).append("]").toString();
    L5:
        r3 = String.valueOf(r2);
        goto L7
    }
}
