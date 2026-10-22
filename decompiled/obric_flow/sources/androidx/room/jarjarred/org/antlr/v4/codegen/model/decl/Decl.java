package androidx.room.jarjarred.org.antlr.v4.codegen.model.decl;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.SrcOp;

/* JADX INFO: loaded from: classes.dex */
public class Decl extends SrcOp {
    public StructDecl ctx;
    public String decl;
    public boolean isLocal;
    public String name;

    public Decl(OutputModelFactory r5, String r10, String r11) {
        this(r5, r10);
        this.decl = r11;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Decl) == true) goto L9;
        return false;
    L9:
        if ((r5 instanceof ContextGetterDecl) == false) goto L12;
        return false;
    L12:
        return this.name.equals(((Decl) r5).name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public Decl(OutputModelFactory r5, String r10) {
        super(r5);
        this.name = r10;
    }
}
