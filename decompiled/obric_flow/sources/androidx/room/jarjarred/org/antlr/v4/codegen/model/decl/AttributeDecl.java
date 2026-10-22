package androidx.room.jarjarred.org.antlr.v4.codegen.model.decl;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.tool.Attribute;

/* JADX INFO: loaded from: classes.dex */
public class AttributeDecl extends Decl {
    public String initValue;
    public String type;

    public AttributeDecl(OutputModelFactory r5, Attribute r10) {
        super(r5, r10.name, r10.decl);
        this.type = r10.type;
        this.initValue = r10.initValue;
    }
}
