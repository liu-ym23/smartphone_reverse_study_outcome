package androidx.room.jarjarred.org.antlr.v4.codegen.target;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.codegen.CodeGenerator;
import androidx.room.jarjarred.org.antlr.v4.codegen.Target;
import androidx.room.jarjarred.org.antlr.v4.codegen.UnicodeEscapes;
import androidx.room.jarjarred.org.antlr.v4.runtime.RuntimeMetaData;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.stringtemplate.v4.NumberRenderer;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.room.jarjarred.org.stringtemplate.v4.StringRenderer;
import cn.nubia.neopush.commons.Constant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class CppTarget extends Target {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected static final String[] cppKeywords = null;
    protected final Set<String> badWords;

    static {
        cppKeywords = new String[]{"alignas", "alignof", "and", "and_eq", "asm", "auto", "bitand", "bitor", "bool", "break", "case", "catch", "char", "char16_t", "char32_t", "class", "compl", "concept", "const", "constexpr", "const_cast", "continue", "decltype", "default", Constant.ClientMessageType.DELETE, "do", "double", "dynamic_cast", "else", "enum", "explicit", "export", "extern", "false", "float", "for", "friend", "goto", "if", "inline", "int", "long", "mutable", "namespace", "new", "noexcept", "not", "not_eq", "nullptr", "operator", "or", "or_eq", "private", "protected", "public", "register", "reinterpret_cast", "requires", "return", "short", "signed", "sizeof", "static", "static_assert", "static_cast", "struct", "switch", "template", "this", "thread_local", "throw", "true", "try", "typedef", "typeid", "typename", "union", "unsigned", "using", "virtual", "void", "volatile", "wchar_t", "while", "xor", "xor_eq"};
    }

    public CppTarget(CodeGenerator r5) {
        super(r5, "Cpp");
        this.badWords = new HashSet();
    }

    public void addBadWords() {
        this.badWords.addAll(Arrays.asList(cppKeywords));
        this.badWords.add("rule");
        this.badWords.add("parserRule");
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public void appendUnicodeEscapedCodePoint(int r5, StringBuilder r10) {
        UnicodeEscapes.appendPythonStyleEscapedCodePoint(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public String encodeIntAsCharEscape(int r5) {
        return "0x" + Integer.toHexString(r5) + ", ";
    }

    public Set<String> getBadWords() {
        if (this.badWords.isEmpty() == false) goto L6;
        addBadWords();
    L6:
        return this.badWords;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public String getBaseListenerFileName(boolean r5) {
        STGroup r10 = getTemplates();
        if (r5 == false) goto L5;
        String r11 = "headerFileExtension";
    L6:
        ST r12 = r10.getInstanceOf(r11);
        StringBuilder r13 = j0.u(j0.q(new StringBuilder(), this.gen.g.name, "BaseListener"));
        r13.append(r12.render());
        return r13.toString();
    L5:
        r11 = "codeFileExtension";
        goto L6
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public String getBaseVisitorFileName(boolean r5) {
        STGroup r10 = getTemplates();
        if (r5 == false) goto L5;
        String r11 = "headerFileExtension";
    L6:
        ST r12 = r10.getInstanceOf(r11);
        StringBuilder r13 = j0.u(j0.q(new StringBuilder(), this.gen.g.name, "BaseVisitor"));
        r13.append(r12.render());
        return r13.toString();
    L5:
        r11 = "codeFileExtension";
        goto L6
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public String getListenerFileName(boolean r5) {
        STGroup r10 = getTemplates();
        if (r5 == false) goto L5;
        String r11 = "headerFileExtension";
    L6:
        ST r12 = r10.getInstanceOf(r11);
        StringBuilder r13 = j0.u(j0.q(new StringBuilder(), this.gen.g.name, "Listener"));
        r13.append(r12.render());
        return r13.toString();
    L5:
        r11 = "codeFileExtension";
        goto L6
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public String getRecognizerFileName(boolean r5) {
        STGroup r10 = getTemplates();
        if (r5 == false) goto L5;
        String r11 = "headerFileExtension";
    L6:
        ST r12 = r10.getInstanceOf(r11);
        StringBuilder r13 = j0.u(this.gen.g.getRecognizerName());
        r13.append(r12.render());
        return r13.toString();
    L5:
        r11 = "codeFileExtension";
        goto L6
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public int getSerializedATNSegmentLimit() {
        return 21845;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public String getVersion() {
        return RuntimeMetaData.VERSION;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public String getVisitorFileName(boolean r5) {
        STGroup r10 = getTemplates();
        if (r5 == false) goto L5;
        String r11 = "headerFileExtension";
    L6:
        ST r12 = r10.getInstanceOf(r11);
        StringBuilder r13 = j0.u(j0.q(new StringBuilder(), this.gen.g.name, "Visitor"));
        r13.append(r12.render());
        return r13.toString();
    L5:
        r11 = "codeFileExtension";
        goto L6
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public STGroup loadTemplates() {
        STGroup r5 = super.loadTemplates();
        r5.registerRenderer(Integer.class, new NumberRenderer());
        r5.registerRenderer(String.class, new StringRenderer());
        r5.setListener(new AnonymousClass1(this));
        return r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public boolean needsHeader() {
        return true;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public boolean visibleGrammarSymbolCausesIssueInGeneratedCode(GrammarAST r5) {
        return getBadWords().contains(r5.getText());
    }
}
