package androidx.room.jarjarred.org.antlr.v4.gui;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.runtime.CharStream;
import androidx.room.jarjarred.org.antlr.v4.runtime.CharStreams;
import androidx.room.jarjarred.org.antlr.v4.runtime.CommonToken;
import androidx.room.jarjarred.org.antlr.v4.runtime.CommonTokenStream;
import androidx.room.jarjarred.org.antlr.v4.runtime.DiagnosticErrorListener;
import androidx.room.jarjarred.org.antlr.v4.runtime.Lexer;
import androidx.room.jarjarred.org.antlr.v4.runtime.Parser;
import androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext;
import androidx.room.jarjarred.org.antlr.v4.runtime.Token;
import androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ParserATNSimulator;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.PredictionMode;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.print.PrintException;

/* JADX INFO: loaded from: classes.dex */
public class TestRig {
    public static final String LEXER_START_RULE_NAME = "tokens";
    protected boolean SLL;
    protected boolean diagnostics;
    protected String encoding;
    protected String grammarName;
    protected boolean gui;
    protected final List<String> inputFiles;
    protected boolean printTree;
    protected String psFile;
    protected boolean showTokens;
    protected String startRuleName;
    protected boolean trace;

    public TestRig(String[] r10) throws Exception {
        this.inputFiles = new ArrayList();
        this.printTree = false;
        this.gui = false;
        this.psFile = null;
        this.showTokens = false;
        this.trace = false;
        this.diagnostics = false;
        this.encoding = null;
        this.SLL = false;
        int r5 = 2;
        if (r10.length >= 2) goto L6;
        PrintStream r11 = System.err;
        r11.println("java org.antlr.v4.gui.TestRig GrammarName startRuleName\n  [-tokens] [-tree] [-gui] [-ps file.ps] [-encoding encodingname]\n  [-trace] [-diagnostics] [-SLL]\n  [input-filename(s)]");
        r11.println("Use startRuleName='tokens' if GrammarName is a lexer grammar.");
        r11.println("Omitting input-filename makes rig read from stdin.");
        return;
    L6:
        this.grammarName = r10[0];
        this.startRuleName = r10[1];
    L8:
        if (r5 >= r10.length) goto L46;
        String r12 = r10[r5];
        int r13 = r5 + 1;
        if (r12.charAt(0) != '-') goto L11;
        if (r12.equals("-tree") == false) goto L17;
        this.printTree = true;
    L17:
        if (r12.equals("-gui") == false) goto L20;
        this.gui = true;
    L20:
        if (r12.equals("-tokens") == true) goto L21;
        if (r12.equals("-trace") == true) goto L24;
        if (r12.equals("-SLL") == true) goto L27;
        if (r12.equals("-diagnostics") == true) goto L30;
        if (r12.equals("-encoding") == true) goto L34;
        if (r12.equals("-ps") == false) goto L12;
        if (r13 >= r10.length) goto L43;
        this.psFile = r10[r13];
    L38:
        r5 = r5 + 2;
        goto L8
    L43:
        System.err.println("missing filename on -ps");
        return;
    L12:
        r5 = r13;
        goto L8
    L34:
        if (r13 >= r10.length) goto L35;
        this.encoding = r10[r13];
        goto L38
    L35:
        System.err.println("missing encoding on -encoding");
        return;
    L30:
        this.diagnostics = true;
        goto L12
    L27:
        this.SLL = true;
        goto L12
    L24:
        this.trace = true;
        goto L12
    L21:
        this.showTokens = true;
        goto L12
    L11:
        this.inputFiles.add(r12);
        goto L12
    }

    public static void main(String[] r5) throws Exception {
        TestRig r10 = new TestRig(r5);
        if (r5.length < 2) goto L6;
        r10.process();
        return;
    }

    public void process() throws Exception {
        String r5 = j0.q(new StringBuilder(), this.grammarName, "Lexer");
        ClassLoader r10 = Thread.currentThread().getContextClassLoader();
        Class r11 = r10.loadClass(r5).asSubclass(Lexer.class);     // Catch: ClassNotFoundException -> L5
    L7:
        Class<? extends Parser> r12 = null;
        Lexer r13 = (Lexer) r11.getConstructor(new Class[]{CharStream.class}).newInstance(new Object[]{null});
        if (this.startRuleName.equals(LEXER_START_RULE_NAME) == true) goto L10;
        Class<? extends Parser> r14 = r10.loadClass(this.grammarName + "Parser").asSubclass(Parser.class);
        Parser r15 = r14.getConstructor(new Class[]{TokenStream.class}).newInstance(new Object[]{null});
        r12 = r14;
    L11:
        String r16 = this.encoding;
        if (r16 != null) goto L14;
        Charset r17 = Charset.defaultCharset();
    L16:
        if (this.inputFiles.size() != 0) goto L19;
        process(r13, r12, r15, CharStreams.fromStream(System.in, r17));
        return;
    L19:
        Iterator<String> r18 = this.inputFiles.iterator();
    L21:
        if (r18.hasNext() == false) goto L26;
        String r19 = r18.next();
        CharStream r20 = CharStreams.fromPath(Paths.get(r19, new String[0]), r17);
        if (this.inputFiles.size() <= 1) goto L25;
        System.err.println(r19);
    L25:
        process(r13, r12, r15, r20);
        goto L21
    L26:
        return;
    L14:
        r17 = Charset.forName(r16);
        goto L16
    L10:
        r15 = null;
    L5:
        String r21 = this.grammarName;
        r11 = r10.loadClass(r21).asSubclass(Lexer.class);     // Catch: ClassNotFoundException -> L27
    L27:
        System.err.println("Can't load " + r21 + " as lexer or parser");
    }

    public void process(Lexer r5, Class<? extends Parser> r10, Parser r11, CharStream r12) throws IOException, IllegalAccessException, InvocationTargetException, PrintException {
        r5.setInputStream(r12);
        CommonTokenStream r13 = new CommonTokenStream(r5);
        r13.fill();
        if (this.showTokens == false) goto L12;
        Iterator<Token> r14 = r13.getTokens().iterator();
    L6:
        if (r14.hasNext() == false) goto L12;
        Token r15 = r14.next();
        if ((r15 instanceof CommonToken) == true) goto L9;
        System.out.println(r15.toString());
        goto L6
    L9:
        System.out.println(((CommonToken) r15).toString(r5));
    L12:
        if (this.startRuleName.equals(LEXER_START_RULE_NAME) == false) goto L15;
        return;
    L15:
        if (this.diagnostics == false) goto L18;
        r11.addErrorListener(new DiagnosticErrorListener());
        ((ParserATNSimulator) r11.getInterpreter()).setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
    L18:
        if (this.printTree == false) goto L20;
    L23:
        r11.setBuildParseTree(true);
    L25:
        if (this.SLL == false) goto L27;
        ((ParserATNSimulator) r11.getInterpreter()).setPredictionMode(PredictionMode.SLL);
    L27:
        r11.setTokenStream(r13);
        r11.setTrace(this.trace);
        ParserRuleContext r16 = (ParserRuleContext) r10.getMethod(this.startRuleName, null).invoke(r11, null);     // Catch: NoSuchMethodException -> L38
        if (this.printTree == false) goto L32;
        System.out.println(r16.toStringTree(r11));     // Catch: NoSuchMethodException -> L38
    L32:
        if (this.gui == false) goto L34;
        Trees.inspect(r16, r11);     // Catch: NoSuchMethodException -> L38
    L34:
        String r17 = this.psFile;     // Catch: NoSuchMethodException -> L38
        if (r17 == null) goto L48;
        Trees.save(r16, r11, r17);     // Catch: NoSuchMethodException -> L38
        return;
    L48:
        return;
    L38:
        System.err.println("No method for rule " + this.startRuleName + " or it has arguments");
        return;
    L20:
        if (this.gui == true) goto L23;
        if (this.psFile == null) goto L25;
        goto L23
    }
}
