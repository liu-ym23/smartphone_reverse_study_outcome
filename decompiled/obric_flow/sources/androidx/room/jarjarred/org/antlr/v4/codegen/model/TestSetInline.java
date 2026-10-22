package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TestSetInline extends SrcOp {
    public int bitsetWordSize;
    public Bitset[] bitsets;
    public String varName;

    public static final class Bitset {
        public int shift;
        public final List<String> ttypes;

        public Bitset() {
            this.ttypes = new ArrayList();
        }
    }

    public TestSetInline(OutputModelFactory r5, GrammarAST r10, IntervalSet r11, int r12) {
        super(r5, r10);
        this.bitsetWordSize = r12;
        Bitset[] r13 = createBitsets(r5, r11, r12, true);
        Bitset[] r14 = createBitsets(r5, r11, r12, false);
        if (r13.length <= r14.length) goto L6;
        r13 = r14;
    L6:
        this.bitsets = r13;
        this.varName = "_la";
    }

    private static Bitset[] createBitsets(OutputModelFactory r10, IntervalSet r11, int r12, boolean r13) {
        ArrayList r5 = new ArrayList();
        int[] r14 = r11.toArray();
        int r15 = r14.length;
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L21;
        int r17 = r14[r16];
        if (r5.isEmpty() == true) goto L7;
        Bitset r18 = (Bitset) a.h(r5, 1);
    L8:
        if (r18 != null) goto L10;
    L11:
        r18 = new Bitset();
        if (r13 == false) goto L17;
        if (r17 < 0) goto L17;
        if (r17 >= (r12 - 1)) goto L17;
        r18.shift = 0;
    L18:
        r5.add(r18);
    L19:
        r18.ttypes.add(r10.getGenerator().getTarget().getTokenTypeAsTargetLabel(r10.getGrammar(), r17));
        r16 = r16 + 1;
    L17:
        r18.shift = r17;
        goto L18
    L10:
        if (r17 <= ((r18.shift + r12) - 1)) goto L19;
    L7:
        r18 = null;
        goto L8
    L21:
        return (Bitset[]) r5.toArray(new Bitset[r5.size()]);
    }
}
