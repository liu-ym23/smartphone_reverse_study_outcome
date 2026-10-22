package androidx.room.jarjarred.org.antlr.v4.codegen.model.decl;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.ListenerDispatchMethod;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.VisitorDispatchMethod;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AltLabelStructDecl extends StructDecl {
    public int altNum;

    public AltLabelStructDecl(OutputModelFactory r5, Rule r10, int r11, String r12) {
        super(r5, r10);
        this.altNum = r11;
        this.name = r5.getGenerator().getTarget().getAltLabelContextStructName(r12);
        this.derivedFromName = r12;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.StructDecl
    public void addDispatchMethods(Rule r5) {
        this.dispatchMethods = new ArrayList();
        if (this.factory.getGrammar().tool.gen_listener == false) goto L6;
        this.dispatchMethods.add(new ListenerDispatchMethod(this.factory, true));
        this.dispatchMethods.add(new ListenerDispatchMethod(this.factory, false));
    L6:
        if (this.factory.getGrammar().tool.gen_visitor == false) goto L9;
        this.dispatchMethods.add(new VisitorDispatchMethod(this.factory));
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.Decl
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof AltLabelStructDecl) == true) goto L10;
        return false;
    L10:
        return this.name.equals(((AltLabelStructDecl) r5).name);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.Decl
    public int hashCode() {
        return this.name.hashCode();
    }
}
