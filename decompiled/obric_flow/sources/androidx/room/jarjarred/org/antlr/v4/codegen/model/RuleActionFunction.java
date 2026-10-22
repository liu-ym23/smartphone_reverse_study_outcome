package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public class RuleActionFunction extends OutputModelObject {

    @ModelElement
    public LinkedHashMap<Integer, Action> actions;
    public String ctxType;
    public String name;
    public int ruleIndex;

    public RuleActionFunction(OutputModelFactory r5, Rule r10, String r11) {
        super(r5);
        this.actions = new LinkedHashMap();
        this.name = r10.name;
        this.ruleIndex = r10.index;
        this.ctxType = r11;
    }
}
