package androidx.room.jarjarred.org.antlr.v4.codegen.model.decl;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;

/* JADX INFO: loaded from: classes.dex */
public class ContextRuleListIndexedGetterDecl extends ContextRuleListGetterDecl {
    public ContextRuleListIndexedGetterDecl(OutputModelFactory r5, String r10, String r11) {
        super(r5, r10, r11);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.ContextGetterDecl
    public String getArgType() {
        return "int";
    }
}
