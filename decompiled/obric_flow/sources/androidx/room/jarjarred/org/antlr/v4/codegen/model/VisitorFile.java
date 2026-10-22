package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Pair;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.AltAST;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class VisitorFile extends OutputFile {
    public String accessLevel;
    public String exportMacro;
    public String genPackage;
    public String grammarName;

    @ModelElement
    public Action header;

    @ModelElement
    public Map<String, Action> namedActions;
    public String parserName;
    public Map<String, String> visitorLabelRuleNames;
    public Set<String> visitorNames;

    public VisitorFile(OutputModelFactory r10, String r11) {
        super(r10, r11);
        this.visitorNames = new LinkedHashSet();
        this.visitorLabelRuleNames = new LinkedHashMap();
        Grammar r12 = r10.getGrammar();
        this.namedActions = buildNamedActions(r12);
        this.parserName = r12.getRecognizerName();
        this.grammarName = r12.name;
        Iterator<Rule> r5 = r12.rules.values().iterator();
    L4:
        if (r5.hasNext() == false) goto L12;
        Rule r13 = r5.next();
        Map<String, List<Pair<Integer, AltAST>>> r14 = r13.getAltLabels();
        if (r14 != null) goto L7;
        this.visitorNames.add(r13.name);
        goto L4
    L7:
        Iterator<Map.Entry<String, List<Pair<Integer, AltAST>>>> r15 = r14.entrySet().iterator();
    L9:
        if (r15.hasNext() == false) goto L4;
        Map.Entry<String, List<Pair<Integer, AltAST>>> r16 = r15.next();
        this.visitorNames.add(r16.getKey());
        this.visitorLabelRuleNames.put(r16.getKey(), r13.name);
        goto L9
    L12:
        ActionAST r17 = r12.namedActions.get("header");
        if (r17 == null) goto L15;
        this.header = new Action(r10, r17);
    L15:
        this.genPackage = r12.tool.genPackage;
        this.accessLevel = r12.getOptionString("accessLevel");
        this.exportMacro = r12.getOptionString("exportMacro");
    }
}
