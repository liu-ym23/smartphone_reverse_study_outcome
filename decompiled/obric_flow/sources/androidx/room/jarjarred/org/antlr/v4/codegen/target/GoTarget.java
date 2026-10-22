package androidx.room.jarjarred.org.antlr.v4.codegen.target;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.org.antlr.v4.codegen.CodeGenerator;
import androidx.room.jarjarred.org.antlr.v4.codegen.Target;
import androidx.room.jarjarred.org.antlr.v4.codegen.UnicodeEscapes;
import androidx.room.jarjarred.org.antlr.v4.runtime.RuntimeMetaData;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.room.jarjarred.org.stringtemplate.v4.StringRenderer;
import cn.nubia.neopush.commons.Constant;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class GoTarget extends Target {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean DO_GOFMT = false;
    private static final String[] goKeywords = null;
    private static final String[] goPredeclaredIdentifiers = null;
    private static final String[] goRuleContextInterfaceMethods = null;
    private final Set<String> badWords;

    public static class JavaStringRenderer extends StringRenderer {
        public JavaStringRenderer() {
        }

        @Override // androidx.room.jarjarred.org.stringtemplate.v4.StringRenderer, androidx.room.jarjarred.org.stringtemplate.v4.AttributeRenderer
        public String toString(Object r5, String r10, Locale r11) {
            if ("java-escape".equals(r10) == false) goto L7;
            return ((String) r5).replace("\\u", "\\u005Cu");
        L7:
            return super.toString(r5, r10, r11);
        }
    }

    static {
        goKeywords = new String[]{"break", "default", "func", "interface", "select", "case", "defer", "go", "map", "struct", "chan", "else", "goto", "package", "switch", "const", "fallthrough", "if", "range", "type", "continue", "for", "import", "return", "var"};
        goPredeclaredIdentifiers = new String[]{"bool", "byte", "complex64", "complex128", "error", "float32", "float64", "int", ",int8", "int16", "int32", "int64", "rune", "string", "uint", "uint8", "uint16", "uint32", "uint64", "uintptr", "true", "false", "iota", "nil", "append", "cap", "close", "complex", "copy", Constant.ClientMessageType.DELETE, "imag", "len", "make", "new", "panic", "print", "println", "real", "recover"};
        goRuleContextInterfaceMethods = new String[]{"Accept", "GetAltNumber", "GetBaseRuleContext", "GetChild", "GetChildCount", "GetChildren", "GetInvokingState", "GetParent", "GetPayload", "GetRuleContext", "GetRuleIndex", "GetSourceInterval", "GetText", "IsEmpty", "SetAltNumber", "SetInvokingState", "SetParent", "String"};
        if (Boolean.parseBoolean(System.getenv("ANTLR_GO_DISABLE_GOFMT")) == false) goto L5;
    L7:
        boolean r5 = false;
    L8:
        DO_GOFMT = r5;
        return;
    L5:
        if (Boolean.parseBoolean(System.getProperty("antlr.go.disable-gofmt")) == true) goto L7;
        r5 = true;
        goto L8
    }

    public GoTarget(CodeGenerator r5) {
        super(r5, "Go");
        this.badWords = new HashSet(((goKeywords.length + goPredeclaredIdentifiers.length) + goRuleContextInterfaceMethods.length) + 3);
    }

    private void gofmt(File r5) {
        ProcessBuilder r10 = new ProcessBuilder(new String[]{"gofmt", "-w", "-s", r5.getPath()});     // Catch: InterruptedException -> L8 IOException -> L10
        r10.redirectErrorStream(true);     // Catch: InterruptedException -> L8 IOException -> L10
        Process r11 = r10.start();     // Catch: InterruptedException -> L8 IOException -> L10
        InputStream r12 = r11.getInputStream();     // Catch: InterruptedException -> L8 IOException -> L10
        byte[] r13 = new byte[1024];     // Catch: InterruptedException -> L8 IOException -> L10
        int r14 = 0;
    L4:
        if (r14 <= (-1)) goto L6;
        r14 = r12.read(r13);     // Catch: InterruptedException -> L8 IOException -> L10
        goto L4
    L6:
        r11.waitFor();     // Catch: InterruptedException -> L8 IOException -> L10
        goto L15
    L14:
        return;
    L8:
        Thread.currentThread().interrupt();
        return;
    }

    public void addBadWords() {
        this.badWords.addAll(Arrays.asList(goKeywords));
        this.badWords.addAll(Arrays.asList(goPredeclaredIdentifiers));
        this.badWords.addAll(Arrays.asList(goRuleContextInterfaceMethods));
        this.badWords.add("rule");
        this.badWords.add("parserRule");
        this.badWords.add("action");
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public void appendUnicodeEscapedCodePoint(int r5, StringBuilder r10) {
        UnicodeEscapes.appendPythonStyleEscapedCodePoint(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public String encodeIntAsCharEscape(int r5) {
        return Integer.toString(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public void genFile(Grammar r5, ST r10, String r11) {
        super.genFile(r5, r10, r11);
        if (DO_GOFMT == true) goto L5;
        return;
    L5:
        if (r11.startsWith(".") == false) goto L7;
        return;
    L7:
        if (r11.endsWith(".go") == false) goto L12;
        gofmt(new File(getCodeGenerator().tool.getOutputDirectory(r5.fileName), r11));
        return;
    }

    public Set<String> getBadWords() {
        if (this.badWords.isEmpty() == false) goto L6;
        addBadWords();
    L6:
        return this.badWords;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public String getBaseListenerFileName(boolean r5) {
        return getCodeGenerator().g.name.toLowerCase() + "_base_listener.go";
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public String getBaseVisitorFileName(boolean r5) {
        return getCodeGenerator().g.name.toLowerCase() + "_base_visitor.go";
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public int getInlineTestSetWordSize() {
        return 32;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public String getListenerFileName(boolean r5) {
        return getCodeGenerator().g.name.toLowerCase() + "_listener.go";
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public String getRecognizerFileName(boolean r5) {
        Grammar r10 = getCodeGenerator().g;
        int r11 = r10.getType();
        if (r11 != 31) goto L5;
        boolean r12 = r10.name.endsWith("Lexer");
        String r13 = r10.name;
        if (r12 == false) goto L21;
        r13 = a.n(r13, 5, 0);
    L21:
        return r13.toLowerCase() + "_lexer.go";
    L5:
        if (r11 != 44) goto L7;
        boolean r14 = r10.name.endsWith("Parser");
        String r15 = r10.name;
        if (r14 == false) goto L16;
        r15 = a.n(r15, 6, 0);
    L16:
        return r15.toLowerCase() + "_parser.go";
    L7:
        if (r11 == 81) goto L11;
        return "INVALID_FILE_NAME";
    L11:
        return r10.name.toLowerCase() + "_parser.go";
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public int getSerializedATNSegmentLimit() {
        return 29;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public String getVersion() {
        return RuntimeMetaData.VERSION;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public String getVisitorFileName(boolean r5) {
        return getCodeGenerator().g.name.toLowerCase() + "_visitor.go";
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public STGroup loadTemplates() {
        STGroup r5 = super.loadTemplates();
        r5.registerRenderer(String.class, new JavaStringRenderer(), true);
        return r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public boolean visibleGrammarSymbolCausesIssueInGeneratedCode(GrammarAST r5) {
        return getBadWords().contains(r5.getText());
    }
}
