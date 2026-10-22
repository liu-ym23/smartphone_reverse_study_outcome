package androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk;

import androidx.room.jarjarred.org.antlr.v4.codegen.model.ModelElement;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.StructDecl;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SetAttr extends ActionChunk {
    public String name;

    @ModelElement
    public List<ActionChunk> rhsChunks;

    public SetAttr(StructDecl r5, String r10, List<ActionChunk> r11) {
        super(r5);
        this.name = r10;
        this.rhsChunks = r11;
    }
}
