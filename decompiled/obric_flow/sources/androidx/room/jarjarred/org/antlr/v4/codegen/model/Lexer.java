package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.LexerGrammar;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class Lexer extends Recognizer {

    @ModelElement
    public LinkedHashMap<Rule, RuleActionFunction> actionFuncs;
    public Map<String, Integer> channels;
    public LexerFile file;
    public Collection<String> modes;

    public Lexer(OutputModelFactory r5, LexerFile r10) {
        super(r5);
        this.actionFuncs = new LinkedHashMap();
        this.file = r10;
        Grammar r11 = r5.getGrammar();
        this.channels = new LinkedHashMap(r11.channelNameToValueMap);
        this.modes = ((LexerGrammar) r11).modes.keySet();
    }
}
