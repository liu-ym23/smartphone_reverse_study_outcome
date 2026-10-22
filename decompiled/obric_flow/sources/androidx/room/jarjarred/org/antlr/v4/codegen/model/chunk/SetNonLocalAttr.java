package androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk;

import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.StructDecl;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SetNonLocalAttr extends SetAttr {
    public int ruleIndex;
    public String ruleName;

    public SetNonLocalAttr(StructDecl r5, String r10, String r11, int r12, List<ActionChunk> r13) {
        super(r5, r11, r13);
        this.ruleName = r10;
        this.ruleIndex = r12;
    }
}
