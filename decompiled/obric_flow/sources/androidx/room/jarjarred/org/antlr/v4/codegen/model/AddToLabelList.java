package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.Decl;

/* JADX INFO: loaded from: classes.dex */
public class AddToLabelList extends SrcOp {
    public Decl label;
    public String listName;

    public AddToLabelList(OutputModelFactory r5, String r10, Decl r11) {
        super(r5);
        this.label = r11;
        this.listName = r10;
    }
}
