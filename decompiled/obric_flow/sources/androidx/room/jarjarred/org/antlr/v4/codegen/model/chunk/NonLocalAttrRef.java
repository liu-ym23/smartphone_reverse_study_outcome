package androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk;

import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.StructDecl;

/* JADX INFO: loaded from: classes.dex */
public class NonLocalAttrRef extends ActionChunk {
    public String name;
    public int ruleIndex;
    public String ruleName;

    public NonLocalAttrRef(StructDecl r5, String r10, String r11, int r12) {
        super(r5);
        this.name = r11;
        this.ruleName = r10;
        this.ruleIndex = r12;
    }
}
