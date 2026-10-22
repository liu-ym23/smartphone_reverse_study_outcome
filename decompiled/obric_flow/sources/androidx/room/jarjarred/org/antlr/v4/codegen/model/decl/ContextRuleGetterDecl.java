package androidx.room.jarjarred.org.antlr.v4.codegen.model.decl;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;

/* JADX INFO: loaded from: classes.dex */
public class ContextRuleGetterDecl extends ContextGetterDecl {
    public String ctxName;
    public boolean optional;

    public ContextRuleGetterDecl(OutputModelFactory r5, String r10, String r11, boolean r12) {
        super(r5, r10);
        this.ctxName = r11;
        this.optional = r12;
    }
}
