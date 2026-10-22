package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Parser extends Recognizer {
    public ParserFile file;

    @ModelElement
    public List<RuleFunction> funcs;

    public Parser(OutputModelFactory r5, ParserFile r10) {
        super(r5);
        this.funcs = new ArrayList();
        this.file = r10;
    }
}
