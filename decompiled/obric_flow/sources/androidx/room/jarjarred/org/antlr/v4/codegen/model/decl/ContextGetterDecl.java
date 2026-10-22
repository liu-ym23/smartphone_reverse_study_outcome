package androidx.room.jarjarred.org.antlr.v4.codegen.model.decl;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.MurmurHash;

/* JADX INFO: loaded from: classes.dex */
public abstract class ContextGetterDecl extends Decl {
    public ContextGetterDecl(OutputModelFactory r5, String r10) {
        super(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.Decl
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ContextGetterDecl) == true) goto L9;
        return false;
    L9:
        if (this.name.equals(((Decl) r5).name) == false) goto L14;
        if (getArgType().equals(((ContextGetterDecl) r5).getArgType()) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public String getArgType() {
        return "";
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.Decl
    public int hashCode() {
        return MurmurHash.finish(MurmurHash.update(MurmurHash.update(MurmurHash.initialize(), this.name), getArgType()), 2);
    }
}
