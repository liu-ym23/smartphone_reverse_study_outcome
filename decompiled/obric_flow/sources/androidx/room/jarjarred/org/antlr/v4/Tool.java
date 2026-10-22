package androidx.room.jarjarred.org.antlr.v4;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.org.antlr.runtime.ANTLRFileStream;
import androidx.room.jarjarred.org.antlr.runtime.ANTLRStringStream;
import androidx.room.jarjarred.org.antlr.runtime.CharStream;
import androidx.room.jarjarred.org.antlr.runtime.CommonTokenStream;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.v4.analysis.AnalysisPipeline;
import androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory;
import androidx.room.jarjarred.org.antlr.v4.automata.LexerATNFactory;
import androidx.room.jarjarred.org.antlr.v4.automata.ParserATNFactory;
import androidx.room.jarjarred.org.antlr.v4.codegen.CodeGenPipeline;
import androidx.room.jarjarred.org.antlr.v4.codegen.CodeGenerator;
import androidx.room.jarjarred.org.antlr.v4.misc.Graph;
import androidx.room.jarjarred.org.antlr.v4.parse.GrammarASTAdaptor;
import androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor;
import androidx.room.jarjarred.org.antlr.v4.parse.ToolANTLRLexer;
import androidx.room.jarjarred.org.antlr.v4.parse.ToolANTLRParser;
import androidx.room.jarjarred.org.antlr.v4.parse.v3TreeGrammarException;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNSerializer;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.LogManager;
import androidx.room.jarjarred.org.antlr.v4.semantics.SemanticPipeline;
import androidx.room.jarjarred.org.antlr.v4.tool.ANTLRMessage;
import androidx.room.jarjarred.org.antlr.v4.tool.ANTLRToolListener;
import androidx.room.jarjarred.org.antlr.v4.tool.BuildDependencyGenerator;
import androidx.room.jarjarred.org.antlr.v4.tool.DOTGenerator;
import androidx.room.jarjarred.org.antlr.v4.tool.DefaultToolListener;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorManager;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.GrammarTransformPipeline;
import androidx.room.jarjarred.org.antlr.v4.tool.LexerGrammar;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarRootAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.RuleAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.TerminalAST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Tool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final List<String> ALL_GRAMMAR_EXTENSIONS = null;
    public static final String GRAMMAR_EXTENSION = ".g4";
    public static final String LEGACY_GRAMMAR_EXTENSION = ".g";
    public static final String VERSION = "4.7.1";
    public static boolean internalOption_PrintGrammarTree;
    public static boolean internalOption_ShowATNConfigsInDFA;
    public static Option[] optionDefs;
    public boolean ST_inspector_wait_for_close;
    public final String[] args;
    DefaultToolListener defaultListener;
    public ErrorManager errMgr;
    public boolean exact_output_dir;
    public boolean force_atn;
    public String genPackage;
    public boolean gen_dependencies;
    public boolean gen_listener;
    public boolean gen_visitor;
    public boolean generate_ATN_dot;
    public String grammarEncoding;
    protected List<String> grammarFiles;
    public Map<String, String> grammarOptions;
    protected boolean haveOutputDir;
    private final Map<String, Grammar> importedGrammars;
    public File inputDirectory;
    public boolean launch_ST_inspector;
    public String libDirectory;
    List<ANTLRToolListener> listeners;
    public boolean log;
    public LogManager logMgr;
    public boolean longMessages;
    public String msgFormat;
    public String outputDirectory;
    protected boolean return_dont_exit;
    public boolean warnings_are_errors;

    /* JADX INFO: renamed from: androidx.room.jarjarred.org.antlr.v4.Tool$1UndefChecker, reason: invalid class name */
    public class C1UndefChecker extends GrammarTreeVisitor {
        public boolean badref;
        final /* synthetic */ Tool this$0;
        final /* synthetic */ Grammar val$g;
        final /* synthetic */ Map val$ruleToAST;

        public C1UndefChecker(Tool r5, Grammar r10, Map r11) {
            this.this$0 = r5;
            this.val$g = r10;
            this.val$ruleToAST = r11;
            this.badref = false;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
        public ErrorManager getErrorManager() {
            return this.this$0.errMgr;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
        public void ruleRef(GrammarAST r5, ActionAST r10) {
            RuleAST r11 = (RuleAST) this.val$ruleToAST.get(r5.getText());
            String r12 = r5.getToken().getInputStream().getSourceName();
            if (Character.isUpperCase(this.currentRuleName.charAt(0)) == true) goto L5;
        L7:
            if (r11 != null) goto L11;
            this.badref = true;
            this.this$0.errMgr.grammarError(ErrorType.UNDEFINED_RULE_REF, r12, r5.token, new Object[]{r5.getText()});
            return;
        L11:
            return;
        L5:
            if (Character.isLowerCase(r5.getText().charAt(0)) == false) goto L7;
            this.badref = true;
            this.this$0.errMgr.grammarError(ErrorType.PARSER_RULE_REF_IN_LEXER_RULE, r12, r5.getToken(), new Object[]{r5.getText(), this.currentRuleName});
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
        public void tokenRef(TerminalAST r5) {
            if ("EOF".equals(r5.getText()) == false) goto L6;
            return;
        L6:
            if (this.val$g.isLexer() == false) goto L9;
            ruleRef(r5, null);
            return;
        }
    }

    public static class Option {
        OptionArgType argType;
        String description;
        String fieldName;
        String name;

        public Option(String r5, String r10, String r11) {
            this(r5, r10, OptionArgType.NONE, r11);
        }

        public Option(String r5, String r10, OptionArgType r11, String r12) {
            this.fieldName = r5;
            this.name = r10;
            this.argType = r11;
            this.description = r12;
        }
    }

    public static final enum OptionArgType extends Enum<OptionArgType> {
        private static final /* synthetic */ OptionArgType[] $VALUES = null;
        public static final OptionArgType NONE = null;
        public static final OptionArgType STRING = null;

        static {
            OptionArgType r5 = new OptionArgType("NONE", 0);
            NONE = r5;
            OptionArgType r10 = new OptionArgType("STRING", 1);
            STRING = r10;
            $VALUES = new OptionArgType[]{r5, r10};
        }

        private OptionArgType(String r5, int r10) {
            super(r5, r10);
        }

        public static OptionArgType valueOf(String r5) {
            return (OptionArgType) Enum.valueOf(OptionArgType.class, r5);
        }

        public static OptionArgType[] values() {
            return (OptionArgType[]) $VALUES.clone();
        }
    }

    static {
        ALL_GRAMMAR_EXTENSIONS = Collections.unmodifiableList(Arrays.asList(new String[]{GRAMMAR_EXTENSION, LEGACY_GRAMMAR_EXTENSION}));
        OptionArgType r12 = OptionArgType.STRING;
        optionDefs = new Option[]{new Option("outputDirectory", "-o", r12, "specify output directory where all output is generated"), new Option("libDirectory", "-lib", r12, "specify location of grammars, tokens files"), new Option("generate_ATN_dot", "-atn", "generate rule augmented transition network diagrams"), new Option("grammarEncoding", "-encoding", r12, "specify grammar file encoding; e.g., euc-jp"), new Option("msgFormat", "-message-format", r12, "specify output style for messages in antlr, gnu, vs2005"), new Option("longMessages", "-long-messages", "show exception details when available for errors and warnings"), new Option("gen_listener", "-listener", "generate parse tree listener (default)"), new Option("gen_listener", "-no-listener", "don't generate parse tree listener"), new Option("gen_visitor", "-visitor", "generate parse tree visitor"), new Option("gen_visitor", "-no-visitor", "don't generate parse tree visitor (default)"), new Option("genPackage", "-package", r12, "specify a package/namespace for the generated code"), new Option("gen_dependencies", "-depend", "generate file dependencies"), new Option("", "-D<option>=value", "set/override a grammar-level option"), new Option("warnings_are_errors", "-Werror", "treat warnings as errors"), new Option("launch_ST_inspector", "-XdbgST", "launch StringTemplate visualizer on generated code"), new Option("ST_inspector_wait_for_close", "-XdbgSTWait", "wait for STViz to close before continuing"), new Option("force_atn", "-Xforce-atn", "use the ATN simulator for all predictions"), new Option("log", "-Xlog", "dump lots of logging info to antlr-timestamp.log"), new Option("exact_output_dir", "-Xexact-output-dir", "all output goes into -o dir regardless of paths/package")};
        internalOption_PrintGrammarTree = false;
        internalOption_ShowATNConfigsInDFA = false;
    }

    public Tool() {
        this(null);
    }

    public static GrammarAST findOptionValueAST(GrammarRootAST r5, String r10) {
        GrammarAST r11 = (GrammarAST) r5.getFirstChildWithType(42);
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r11.getChildCount() <= 0) goto L23;
        Iterator<? extends Object> r12 = r11.getChildren().iterator();
    L8:
        if (r12.hasNext() == false) goto L24;
        GrammarAST r13 = (GrammarAST) r12.next();
        if (r13.getType() != 10) goto L8;
        if (r13.getChild(0).getText().equals(r10) == false) goto L8;
        return (GrammarAST) r13.getChild(1);
    L24:
        return null;
    L23:
        return null;
    }

    private void generateInterpreterData(Grammar r10) {
        StringBuilder r5 = new StringBuilder("token literal names:\n");
        String[] r11 = r10.getTokenLiteralNames();
        int r12 = r11.length;
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L6;
        r5.append(r11[r13] + "\n");
        r13 = r13 + 1;
        goto L4
    L6:
        r5.append("\ntoken symbolic names:\n");
        String[] r14 = r10.getTokenSymbolicNames();
        int r15 = r14.length;
        int r16 = 0;
    L7:
        if (r16 >= r15) goto L9;
        r5.append(r14[r16] + "\n");
        r16 = r16 + 1;
        goto L7
    L9:
        r5.append("\nrule names:\n");
        String[] r17 = r10.getRuleNames();
        int r18 = r17.length;
        int r19 = 0;
    L10:
        if (r19 >= r18) goto L12;
        r5.append(r17[r19] + "\n");
        r19 = r19 + 1;
        goto L10
    L12:
        r5.append("\n");
        if (r10.isLexer() == false) goto L22;
        r5.append("channel names:\nDEFAULT_TOKEN_CHANNEL\nHIDDEN\n");
        Iterator<String> r20 = r10.channelValueToNameList.iterator();
    L16:
        if (r20.hasNext() == false) goto L18;
        r5.append(r20.next() + "\n");
        goto L16
    L18:
        r5.append("\nmode names:\n");
        Iterator<String> r21 = ((LexerGrammar) r10).modes.keySet().iterator();
    L20:
        if (r21.hasNext() == false) goto L22;
        r5.append(r21.next() + "\n");
    L22:
        r5.append("\natn:\n");
        r5.append(ATNSerializer.getSerialized(r10.atn).toString());
        Writer r22 = getOutputFileWriter(r10, r10.name + ".interp");     // Catch: IOException -> L26
        r22.write(r5.toString());     // Catch: Throwable -> L28
        r22.close();     // Catch: IOException -> L26
        return;
    L28:
        th = move-exception;
        r22.close();     // Catch: IOException -> L26
        throw th;     // Catch: IOException -> L26
    L26:
        e = move-exception;
        this.errMgr.toolError(ErrorType.CANNOT_WRITE_FILE, e, new Object[0]);
    }

    public static void main(String[] r10) {
        Tool r5 = new Tool(r10);
        if (r10.length != 0) goto L28;
        r5.help();
        r5.exit(0);
    L28:
        r5.processGrammarsOnCommandLine();     // Catch: Throwable -> L20
        if (r5.log == false) goto L13;
        String r11 = r5.logMgr.save();     // Catch: IOException -> L10
        System.out.println("wrote " + r11);     // Catch: IOException -> L10
    L10:
        e = move-exception;
        r5.errMgr.toolError(ErrorType.INTERNAL_ERROR, e, new Object[0]);
    L13:
        if (r5.return_dont_exit == false) goto L16;
        return;
    L16:
        if (r5.errMgr.getNumErrors() <= 0) goto L18;
        r5.exit(1);
    L18:
        r5.exit(0);
        return;
    L20:
        th = move-exception;
        if (r5.log == true) goto L32;
    L27:
        throw th;
    L32:
        String r12 = r5.logMgr.save();     // Catch: IOException -> L25
        System.out.println("wrote " + r12);     // Catch: IOException -> L25
    L25:
        e = move-exception;
        r5.errMgr.toolError(ErrorType.INTERNAL_ERROR, e, new Object[0]);
        goto L27
    }

    public void addListener(ANTLRToolListener r5) {
        if (r5 == null) goto L5;
        this.listeners.add(r5);
        return;
    }

    public boolean checkForRuleIssues(Grammar r11) {
        ArrayList r5 = new ArrayList(((GrammarAST) r11.ast.getFirstChildWithType(97)).getAllChildrenWithType(94));
        Iterator<GrammarAST> r10 = r11.ast.getAllChildrenWithType(36).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r5.addAll(r10.next().getAllChildrenWithType(94));
        goto L4
    L6:
        HashMap r12 = new HashMap();
        Iterator r13 = r5.iterator();
        boolean r14 = false;
    L8:
        if (r13.hasNext() == false) goto L13;
        RuleAST r15 = (RuleAST) ((GrammarAST) r13.next());
        GrammarAST r16 = (GrammarAST) r15.getChild(0);
        String r17 = r16.getText();
        RuleAST r18 = (RuleAST) r12.get(r17);
        if (r18 != null) goto L11;
        r12.put(r17, r15);
        goto L8
    L11:
        r11.tool.errMgr.grammarError(ErrorType.RULE_REDEFINITION, r11.fileName, r16.getToken(), new Object[]{r17, Integer.valueOf(((GrammarAST) r18.getChild(0)).getToken().getLine())});
        r14 = true;
        goto L8
    L13:
        C1UndefChecker r19 = new C1UndefChecker(this, r11, r12);
        r19.visitGrammar(r11.ast);
        if (r14 == true) goto L18;
        if (r19.badref == true) goto L18;
        return false;
    L18:
        return true;
    }

    public Grammar createGrammar(GrammarRootAST r5) {
        if (r5.grammarType != 31) goto L5;
        Grammar r10 = new LexerGrammar(this, r5);
    L6:
        GrammarTransformPipeline.setGrammarPtr(r10, r5);
        return r10;
    L5:
        r10 = new Grammar(this, r5);
        goto L6
    }

    public void error(ANTLRMessage r5) {
        if (this.listeners.isEmpty() == false) goto L6;
        this.defaultListener.error(r5);
        return;
    L6:
        Iterator<ANTLRToolListener> r10 = this.listeners.iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        r10.next().error(r5);
        goto L8
    }

    public void exit(int r5) {
        System.exit(r5);
    }

    public void generateATNs(Grammar r10) {
        DOTGenerator r5 = new DOTGenerator(r10);
        ArrayList r11 = new ArrayList();
        r11.add(r10);
        List<Grammar> r12 = r10.getAllImportedGrammars();
        if (r12 == null) goto L5;
        r11.addAll(r12);
    L5:
        Iterator r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L18;
        Iterator<Rule> r14 = ((Grammar) r13.next()).rules.values().iterator();
    L10:
        if (r14.hasNext() == false) goto L7;
        Rule r15 = r14.next();
        String r16 = r5.getDOT(r10.atn.ruleToStartState[r15.index], r10.isLexer());     // Catch: IOException -> L16
        if (r16 == null) goto L10;
        writeDOTFile(r10, r15, r16);     // Catch: IOException -> L16
    L16:
        e = move-exception;
        this.errMgr.toolError(ErrorType.CANNOT_WRITE_FILE, e, new Object[0]);
        goto L10
    }

    public File getImportedGrammarFile(Grammar r5, String r10) {
        File r11 = new File(this.inputDirectory, r10);
        if (r11.exists() == true) goto L10;
        r11 = new File(new File(r5.fileName).getParent(), r10);
        if (r11.exists() == true) goto L10;
        r11 = new File(this.libDirectory, r10);
        if (r11.exists() == true) goto L10;
        return null;
    L10:
        return r11;
    }

    public List<ANTLRToolListener> getListeners() {
        return this.listeners;
    }

    public int getNumErrors() {
        return this.errMgr.getNumErrors();
    }

    public File getOutputDirectory(String r5) {
        if (this.exact_output_dir == true) goto L5;
        char r10 = File.separatorChar;
        if (r5.lastIndexOf(r10) != (-1)) goto L9;
        String r11 = ".";
    L11:
        if (this.haveOutputDir == false) goto L22;
        if (r11 != null) goto L14;
    L18:
        if (r11 == null) goto L25;
        return new File(this.outputDirectory, r11);
    L25:
        return new File(this.outputDirectory);
    L14:
        if (new File(r11).isAbsolute() == true) goto L23;
        if (r11.startsWith("~") == false) goto L18;
    L23:
        return new File(this.outputDirectory);
    L22:
        return new File(r11);
    L9:
        r11 = r5.substring(0, r5.lastIndexOf(r10));
        goto L11
    L5:
        return new_getOutputDirectory(r5);
    }

    public Writer getOutputFileWriter(Grammar r5, String r10) throws IOException {
        if (this.outputDirectory == null) goto L5;
        File r11 = getOutputDirectory(r5.fileName);
        File r12 = new File(r11, r10);
        if (r11.exists() == true) goto L9;
        r11.mkdirs();
    L9:
        FileOutputStream r13 = new FileOutputStream(r12);
        if (this.grammarEncoding == null) goto L12;
        OutputStreamWriter r14 = new OutputStreamWriter(r13, this.grammarEncoding);
    L14:
        return new BufferedWriter(r14);
    L12:
        r14 = new OutputStreamWriter(r13);
        goto L14
    L5:
        return new StringWriter();
    }

    public void handleArgs() {
        int r5 = 0;
    L3:
        String[] r10 = this.args;
        if (r10 == null) goto L37;
        if (r5 >= r10.length) goto L37;
        String r11 = r10[r5];
        r5 = r5 + 1;
        if (r11.startsWith("-D") == true) goto L9;
        if (r11.charAt(0) != '-') goto L13;
        Option[] r12 = optionDefs;
        int r13 = r12.length;
        int r14 = 0;
        boolean r15 = false;
    L16:
        if (r14 >= r13) goto L35;
        Option r16 = r12[r14];
        if (r11.equals(r16.name) == false) goto L34;
        if (r16.argType != OptionArgType.STRING) goto L22;
        String r17 = this.args[r5];
        r5 = r5 + 1;
    L65:
        Field r18 = getClass().getField(r16.fieldName);     // Catch: Exception -> L32
        if (r17 == null) goto L27;
        r18.set(this, r17);     // Catch: Exception -> L32
    L33:
        r15 = true;
        goto L34
    L27:
        if (r11.startsWith("-no-") == false) goto L29;
        r18.setBoolean(this, false);     // Catch: Exception -> L32
        goto L33
    L29:
        r18.setBoolean(this, true);     // Catch: Exception -> L32
    L32:
        this.errMgr.toolError(ErrorType.INTERNAL_ERROR, new Object[]{"can't access field " + r16.fieldName});
        goto L33
    L22:
        r17 = null;
    L34:
        r14 = r14 + 1;
        goto L16
    L35:
        if (r15 == true) goto L3;
        this.errMgr.toolError(ErrorType.INVALID_CMDLINE_ARG, new Object[]{r11});
        goto L3
    L13:
        if (this.grammarFiles.contains(r11) == true) goto L3;
        this.grammarFiles.add(r11);
        goto L3
    L9:
        handleOptionSetArg(r11);
    L37:
        String r19 = this.outputDirectory;
        if (r19 != null) goto L40;
        this.outputDirectory = ".";
    L50:
        String r20 = this.libDirectory;
        if (r20 != null) goto L53;
        this.libDirectory = ".";
    L62:
        if (this.launch_ST_inspector == false) goto L84;
        STGroup.trackCreationEvents = true;
        this.return_dont_exit = true;
        return;
    L84:
        return;
    L53:
        if (r20.endsWith("/") == false) goto L55;
    L56:
        this.libDirectory = a.n(this.libDirectory, 1, 0);
    L58:
        if (new File(this.libDirectory).exists() == true) goto L62;
        this.errMgr.toolError(ErrorType.DIR_NOT_FOUND, new Object[]{this.libDirectory});
        this.libDirectory = ".";
        goto L62
    L55:
        if (this.libDirectory.endsWith("\\") == false) goto L58;
    L40:
        if (r19.endsWith("/") == false) goto L42;
    L43:
        this.outputDirectory = a.n(this.outputDirectory, 1, 0);
    L44:
        File r21 = new File(this.outputDirectory);
        this.haveOutputDir = true;
        if (r21.exists() == false) goto L50;
        if (r21.isDirectory() == true) goto L50;
        this.errMgr.toolError(ErrorType.OUTPUT_DIR_IS_FILE, new Object[]{this.outputDirectory});
        this.outputDirectory = ".";
        goto L50
    L42:
        if (this.outputDirectory.endsWith("\\") == false) goto L44;
        goto L43
    }

    public void handleOptionSetArg(String r5) {
        int r10 = r5.indexOf(61);
        if (r10 > 0) goto L5;
    L20:
        this.errMgr.toolError(ErrorType.BAD_OPTION_SET_SYNTAX, new Object[]{r5});
        return;
    L5:
        if (r5.length() <= 3) goto L20;
        String r11 = r5.substring(2, r10);
        String r12 = r5.substring(r10 + 1);
        if (r12.length() != 0) goto L11;
        this.errMgr.toolError(ErrorType.BAD_OPTION_SET_SYNTAX, new Object[]{r5});
        return;
    L11:
        if (Grammar.parserOptions.contains(r11) == true) goto L17;
        if (Grammar.lexerOptions.contains(r11) == true) goto L17;
        this.errMgr.grammarError(ErrorType.ILLEGAL_OPTION, null, null, new Object[]{r11});
        return;
    L17:
        if (this.grammarOptions != null) goto L19;
        this.grammarOptions = new HashMap();
    L19:
        this.grammarOptions.put(r11, r12);
    }

    public void help() {
        info("ANTLR Parser Generator  Version " + VERSION);
        Option[] r5 = optionDefs;
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        Option r12 = r5[r11];
        StringBuilder r13 = new StringBuilder();
        r13.append(r12.name);
        if (r12.argType == OptionArgType.NONE) goto L7;
        String r14 = " ___";
    L8:
        r13.append(r14);
        info(String.format(" %-19s %s", new Object[]{r13.toString(), r12.description}));
        r11 = r11 + 1;
        goto L3
    L7:
        r14 = "";
        goto L8
    }

    public void info(String r5) {
        if (this.listeners.isEmpty() == false) goto L6;
        this.defaultListener.info(r5);
        return;
    L6:
        Iterator<ANTLRToolListener> r10 = this.listeners.iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        r10.next().info(r5);
        goto L8
    }

    public Grammar loadGrammar(String r5) {
        Grammar r10 = createGrammar(parseGrammar(r5));
        r10.fileName = r5;
        process(r10, false);
        return r10;
    }

    public Grammar loadImportedGrammar(Grammar r10, GrammarAST r11) throws IOException {
        String r5 = r11.getText();
        Grammar r12 = this.importedGrammars.get(r5);
        if (r12 != null) goto L20;
        Tool r13 = r10.tool;
        StringBuilder r14 = j0.x("load ", r5, " from ");
        r14.append(r10.fileName);
        r13.log("grammar", r14.toString());
        Iterator<String> r15 = ALL_GRAMMAR_EXTENSIONS.iterator();
        File r16 = null;
    L6:
        if (r15.hasNext() == false) goto L9;
        r16 = getImportedGrammarFile(r10, r5 + r15.next());
        if (r16 == null) goto L6;
    L9:
        if (r16 != null) goto L12;
        this.errMgr.grammarError(ErrorType.CANNOT_FIND_IMPORTED_GRAMMAR, r10.fileName, r11.getToken(), new Object[]{r5});
        return null;
    L12:
        String r17 = r16.getAbsolutePath();
        GrammarRootAST r18 = parse(r10.fileName, new ANTLRFileStream(r17, this.grammarEncoding));
        if (r18 != null) goto L15;
        return null;
    L15:
        Grammar r19 = createGrammar(r18);
        r19.fileName = r17;
        this.importedGrammars.put(r18.getGrammarName(), r19);
        return r19;
    L20:
        return r12;
    }

    public void log(String r5, String r10) {
        this.logMgr.log(r5, r10);
    }

    public File new_getOutputDirectory(String r5) {
        char r10 = File.separatorChar;
        if (r5.lastIndexOf(r10) != (-1)) goto L5;
        String r11 = ".";
    L7:
        if (this.haveOutputDir == false) goto L10;
        return new File(this.outputDirectory);
    L10:
        return new File(r11);
    L5:
        r11 = r5.substring(0, r5.lastIndexOf(r10));
        goto L7
    }

    public void panic() {
        throw new Error("ANTLR panic");
    }

    public GrammarRootAST parse(String r10, CharStream r11) {
        GrammarASTAdaptor r5 = new GrammarASTAdaptor(r11);     // Catch: RecognitionException -> L23
        ToolANTLRLexer r12 = new ToolANTLRLexer(r11, this);     // Catch: RecognitionException -> L23
        CommonTokenStream r13 = new CommonTokenStream(r12);     // Catch: RecognitionException -> L23
        r12.tokens = r13;     // Catch: RecognitionException -> L23
        ToolANTLRParser r14 = new ToolANTLRParser(r13, this);     // Catch: RecognitionException -> L23
        r14.setTreeAdaptor(r5);     // Catch: RecognitionException -> L23
        GrammarAST r15 = (GrammarAST) r14.grammarSpec().getTree();     // Catch: v3TreeGrammarException -> L13 RecognitionException -> L23
        if ((r15 instanceof GrammarRootAST) == false) goto L22;
        GrammarRootAST r16 = (GrammarRootAST) r15;     // Catch: v3TreeGrammarException -> L13 RecognitionException -> L23
        if (r12.getNumberOfSyntaxErrors() <= 0) goto L10;
    L15:
        boolean r17 = true;
    L16:
        r16.hasErrors = r17;     // Catch: v3TreeGrammarException -> L13 RecognitionException -> L23
        Map<String, String> r18 = this.grammarOptions;     // Catch: v3TreeGrammarException -> L13 RecognitionException -> L23
        if (r18 == null) goto L19;
        ((GrammarRootAST) r15).cmdLineOptions = r18;     // Catch: v3TreeGrammarException -> L13 RecognitionException -> L23
    L19:
        return (GrammarRootAST) r15;
    L10:
        if (r14.getNumberOfSyntaxErrors() > 0) goto L15;
        r17 = false;
    L22:
        return null;
    L13:
        e = move-exception;
        this.errMgr.grammarError(ErrorType.V3_TREE_GRAMMAR, r10, e.location, new Object[0]);     // Catch: RecognitionException -> L23
    L23:
        ErrorManager.internalError("can't generate this message at moment; antlr recovers");
        return null;
    }

    public GrammarRootAST parseGrammar(String r5) {
        File r10 = new File(r5);     // Catch: IOException -> L5
        if (r10.isAbsolute() == true) goto L7;
        r10 = new File(this.inputDirectory, r5);     // Catch: IOException -> L5
    L7:
        return parse(r5, new ANTLRFileStream(r10.getAbsolutePath(), this.grammarEncoding));
    L5:
        e = move-exception;
        this.errMgr.toolError(ErrorType.CANNOT_OPEN_FILE, e, new Object[]{r5});
        return null;
    }

    public GrammarRootAST parseGrammarFromString(String r5) {
        return parse(Grammar.GRAMMAR_FROM_STRING_NAME, new ANTLRStringStream(r5));
    }

    public void process(Grammar r5, boolean r10) {
        r5.loadImportedGrammars();
        GrammarTransformPipeline r11 = new GrammarTransformPipeline(r5, this);
        r11.process();
        GrammarRootAST r12 = r5.ast;
        if (r12 != null) goto L5;
    L14:
        LexerGrammar r13 = r5.implicitLexer;
        if (r13 == null) goto L17;
        r5.importVocab(r13);
    L17:
        processNonCombinedGrammar(r5, r10);
        return;
    L5:
        if (r12.grammarType != 81) goto L14;
        if (r12.hasErrors == true) goto L14;
        GrammarRootAST r14 = r11.extractImplicitLexer(r5);
        if (r14 == null) goto L14;
        Map<String, String> r15 = this.grammarOptions;
        if (r15 == null) goto L13;
        r14.cmdLineOptions = r15;
    L13:
        LexerGrammar r16 = new LexerGrammar(this, r14);
        r16.fileName = r5.fileName;
        r16.originalGrammar = r5;
        r5.implicitLexer = r16;
        r16.implicitLexerOwner = r5;
        processNonCombinedGrammar(r16, r10);
        goto L14
    }

    public void processGrammarsOnCommandLine() {
        Iterator<GrammarRootAST> r5 = sortGrammarByTokenVocab(this.grammarFiles).iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        GrammarRootAST r10 = r5.next();
        Grammar r11 = createGrammar(r10);
        r11.fileName = r10.fileName;
        if (this.gen_dependencies == true) goto L7;
        if (this.errMgr.getNumErrors() != 0) goto L4;
        process(r11, true);
        goto L4
    L7:
        BuildDependencyGenerator r12 = new BuildDependencyGenerator(this, r11);
        System.out.println(r12.getDependencies().render());
        goto L4
    }

    public void processNonCombinedGrammar(Grammar r5, boolean r10) {
        GrammarRootAST r11 = r5.ast;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.hasErrors == false) goto L8;
        return;
    L8:
        if (internalOption_PrintGrammarTree == false) goto L11;
        System.out.println(r11.toStringTree());
    L11:
        if (checkForRuleIssues(r5) == false) goto L13;
        return;
    L13:
        int r12 = this.errMgr.getNumErrors();
        new SemanticPipeline(r5).process();
        String r13 = r5.getOptionString("language");
        if (CodeGenerator.targetExists(r13) == true) goto L18;
        this.errMgr.toolError(ErrorType.CANNOT_CREATE_TARGET_GENERATOR, new Object[]{r13});
        return;
    L18:
        if (this.errMgr.getNumErrors() <= r12) goto L21;
        return;
    L21:
        if (r5.isLexer() == false) goto L23;
        ATNFactory r14 = new LexerATNFactory((LexerGrammar) r5);
    L24:
        r5.atn = r14.createATN();
        if (this.generate_ATN_dot == false) goto L28;
        generateATNs(r5);
    L28:
        if (r5.tool.getNumErrors() != 0) goto L30;
        generateInterpreterData(r5);
    L30:
        new AnalysisPipeline(r5).process();
        if (r5.tool.getNumErrors() <= r12) goto L33;
        return;
    L33:
        if (r10 == false) goto L37;
        new CodeGenPipeline(r5).process();
        return;
    L37:
        return;
    L23:
        r14 = new ParserATNFactory(r5);
        goto L24
    }

    public void removeListener(ANTLRToolListener r5) {
        this.listeners.remove(r5);
    }

    public void removeListeners() {
        this.listeners.clear();
    }

    public List<GrammarRootAST> sortGrammarByTokenVocab(List<String> r10) {
        Graph r5 = new Graph();
        ArrayList r11 = new ArrayList();
        Iterator<String> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L23;
        String r13 = r12.next();
        GrammarRootAST r14 = parseGrammar(r13);
        if (r14 == null) goto L4;
        if (r14.hasErrors == true) goto L4;
        r11.add(r14);
        r14.fileName = r13;
        String r15 = r14.getChild(0).getText();
        GrammarAST r16 = findOptionValueAST(r14, "tokenVocab");
        if (r16 == null) goto L22;
        String r17 = r16.getText();
        int r18 = r17.length();
        char r19 = r17.charAt(0);
        int r20 = r18 - 1;
        char r21 = r17.charAt(r20);
        if (r18 >= 2) goto L15;
    L18:
        int r22 = r17.lastIndexOf(47);
        if (r22 < 0) goto L21;
        r17 = r17.substring(r22 + 1);
    L21:
        r5.addEdge(r15, r17);
        goto L22
    L15:
        if (r19 != '\'') goto L18;
        if (r21 != '\'') goto L18;
        r17 = r17.substring(1, r20);
    L22:
        r5.addEdge(r15, r15);
        goto L4
    L23:
        List r23 = r5.sort();
        ArrayList r110 = new ArrayList();
        Iterator r24 = r23.iterator();
    L25:
        if (r24.hasNext() == false) goto L32;
        String r25 = (String) r24.next();
        Iterator r26 = r11.iterator();
    L28:
        if (r26.hasNext() == false) goto L25;
        GrammarRootAST r27 = (GrammarRootAST) r26.next();
        if (r27.getGrammarName().equals(r25) == false) goto L28;
        r110.add(r27);
        goto L25
    L32:
        return r110;
    }

    public void version() {
        info("ANTLR Parser Generator  Version " + VERSION);
    }

    public void warning(ANTLRMessage r5) {
        if (this.listeners.isEmpty() == false) goto L5;
        this.defaultListener.warning(r5);
    L10:
        if (this.warnings_are_errors == false) goto L14;
        ErrorManager r10 = this.errMgr;
        ErrorType r11 = ErrorType.WARNING_TREATED_AS_ERROR;
        r10.emit(r11, new ANTLRMessage(r11));
        return;
    L14:
        return;
    L5:
        Iterator<ANTLRToolListener> r12 = this.listeners.iterator();
    L7:
        if (r12.hasNext() == false) goto L10;
        r12.next().warning(r5);
        goto L7
    }

    public void writeDOTFile(Grammar r5, Rule r10, String r11) throws IOException {
        writeDOTFile(r5, r10.g.name + "." + r10.name, r11);
    }

    public Tool(String[] r5) {
        this.generate_ATN_dot = false;
        this.grammarEncoding = null;
        this.msgFormat = "antlr";
        this.launch_ST_inspector = false;
        this.ST_inspector_wait_for_close = false;
        this.force_atn = false;
        this.log = false;
        this.gen_listener = true;
        this.gen_visitor = false;
        this.gen_dependencies = false;
        this.genPackage = null;
        this.grammarOptions = null;
        this.warnings_are_errors = false;
        this.longMessages = false;
        this.exact_output_dir = false;
        this.haveOutputDir = false;
        this.return_dont_exit = false;
        this.grammarFiles = new ArrayList();
        this.logMgr = new LogManager();
        this.listeners = new CopyOnWriteArrayList();
        this.defaultListener = new DefaultToolListener(this);
        this.importedGrammars = new HashMap();
        this.args = r5;
        ErrorManager r10 = new ErrorManager(this);
        this.errMgr = r10;
        r10.setFormat("antlr");
        handleArgs();
        this.errMgr.setFormat(this.msgFormat);
    }

    public void log(String r5) {
        log(null, r5);
    }

    public void writeDOTFile(Grammar r5, String r10, String r11) throws IOException {
        Writer r12 = getOutputFileWriter(r5, r10 + ".dot");
        r12.write(r11);     // Catch: Throwable -> L6
        r12.close();
        return;
    L6:
        th = move-exception;
        r12.close();
        throw th;
    }
}
