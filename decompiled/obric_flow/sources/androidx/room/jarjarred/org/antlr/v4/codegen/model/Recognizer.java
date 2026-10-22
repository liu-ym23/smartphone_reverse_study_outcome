package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.codegen.CodeGenerator;
import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.ActionChunk;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.ActionText;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class Recognizer extends OutputModelObject {
    public String accessLevel;

    @ModelElement
    public SerializedATN atn;
    public String grammarFileName;
    public String grammarName;
    public List<String> literalNames;
    public String name;
    public Set<String> ruleNames;
    public Collection<Rule> rules;

    @ModelElement
    public LinkedHashMap<Rule, RuleSempredFunction> sempredFuncs;

    @ModelElement
    public ActionChunk superClass;
    public List<String> symbolicNames;

    @Deprecated
    public List<String> tokenNames;
    public Map<String, Integer> tokens;

    public Recognizer(OutputModelFactory r10) {
        super(r10);
        this.sempredFuncs = new LinkedHashMap();
        Grammar r5 = r10.getGrammar();
        this.grammarFileName = new File(r5.fileName).getName();
        this.grammarName = r5.name;
        this.name = r5.getRecognizerName();
        this.accessLevel = r5.getOptionString("accessLevel");
        this.tokens = new LinkedHashMap();
        Iterator<Map.Entry<String, Integer>> r11 = r5.tokenNameToTypeMap.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Map.Entry<String, Integer> r12 = r11.next();
        Integer r13 = r12.getValue();
        if (r13.intValue() <= 0) goto L4;
        this.tokens.put(r12.getKey(), r13);
        goto L4
    L8:
        this.ruleNames = r5.rules.keySet();
        this.rules = r5.rules.values();
        this.atn = new SerializedATN(r10, r5.atn);
        if (r5.getOptionString("superClass") == null) goto L11;
        this.superClass = new ActionText(null, r5.getOptionString("superClass"));
    L12:
        CodeGenerator r14 = r10.getGenerator();
        this.tokenNames = translateTokenStringsToTarget(r5.getTokenDisplayNames(), r14);
        this.literalNames = translateTokenStringsToTarget(r5.getTokenLiteralNames(), r14);
        this.symbolicNames = translateTokenStringsToTarget(r5.getTokenSymbolicNames(), r14);
        return;
    L11:
        this.superClass = null;
        goto L12
    }

    public static String translateTokenStringToTarget(String r5, CodeGenerator r10) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.charAt(0) != '\'') goto L10;
        return j0.k("\"'", r10.getTarget().getTargetStringLiteralFromANTLRStringLiteral(r10, r5, false), "'\"");
    L10:
        return r10.getTarget().getTargetStringLiteralFromString(r5, true);
    }

    public static List<String> translateTokenStringsToTarget(String[] r5, CodeGenerator r10) {
        String[] r11 = (String[]) r5.clone();
        int r12 = 0;
    L4:
        if (r12 >= r5.length) goto L6;
        r11[r12] = translateTokenStringToTarget(r5[r12], r10);
        r12 = r12 + 1;
        goto L4
    L6:
        int r13 = r11.length - 1;
    L7:
        if (r13 < 0) goto L12;
        if (r11[r13] != null) goto L12;
        r13 = r13 - 1;
    L12:
        if (r13 >= (r11.length - 1)) goto L15;
        r11 = (String[]) Arrays.copyOf(r11, r13 + 1);
    L15:
        return Arrays.asList(r11);
    }
}
