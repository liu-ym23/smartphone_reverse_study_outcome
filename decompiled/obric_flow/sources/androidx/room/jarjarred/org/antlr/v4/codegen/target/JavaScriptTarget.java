package androidx.room.jarjarred.org.antlr.v4.codegen.target;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.codegen.CodeGenerator;
import androidx.room.jarjarred.org.antlr.v4.codegen.Target;
import androidx.room.jarjarred.org.antlr.v4.codegen.UnicodeEscapes;
import androidx.room.jarjarred.org.antlr.v4.runtime.RuntimeMetaData;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.room.jarjarred.org.stringtemplate.v4.StringRenderer;
import cn.nubia.neopush.commons.Constant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class JavaScriptTarget extends Target {
    protected static final String[] javaScriptKeywords = null;
    protected final Set<String> badWords;

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
        javaScriptKeywords = new String[]{"break", "case", "class", "catch", "const", "continue", "debugger", "default", Constant.ClientMessageType.DELETE, "do", "else", "export", "extends", "finally", "for", "function", "if", "import", "in", "instanceof", "let", "new", "return", "super", "switch", "this", "throw", "try", "typeof", "var", "void", "while", "with", "yield", "enum", "await", "implements", "package", "protected", "static", "interface", "private", "public", "abstract", "boolean", "byte", "char", "double", "final", "float", "goto", "int", "long", "native", "short", "synchronized", "transient", "volatile", "null", "true", "false"};
    }

    public JavaScriptTarget(CodeGenerator r5) {
        super(r5, "JavaScript");
        this.badWords = new HashSet();
    }

    public void addBadWords() {
        this.badWords.addAll(Arrays.asList(javaScriptKeywords));
        this.badWords.add("rule");
        this.badWords.add("parserRule");
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public void appendUnicodeEscapedCodePoint(int r5, StringBuilder r10) {
        UnicodeEscapes.appendJavaStyleEscapedCodePoint(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public String encodeIntAsCharEscape(int r5) {
        if (r5 < 0) goto L20;
        if (r5 > 65535) goto L20;
        if (r5 < 0) goto L12;
        String[] r10 = this.targetCharValueEscape;
        if (r5 >= r10.length) goto L12;
        String r11 = r10[r5];
        if (r11 == null) goto L12;
        return r11;
    L12:
        if (r5 < 32) goto L18;
        if (r5 >= 127) goto L18;
        return String.valueOf((char) r5);
    L18:
        return j0.C("\\u", Integer.toHexString(65536 | r5).substring(1, 5));
    L20:
        throw new IllegalArgumentException(String.format("Cannot encode the specified value: %d", new Object[]{Integer.valueOf(r5)}));
    }

    public Set<String> getBadWords() {
        if (this.badWords.isEmpty() == false) goto L6;
        addBadWords();
    L6:
        return this.badWords;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public int getInlineTestSetWordSize() {
        return 32;
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
    public STGroup loadTemplates() {
        STGroup r5 = super.loadTemplates();
        r5.registerRenderer(String.class, new JavaStringRenderer(), true);
        return r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public boolean supportsOverloadedMethods() {
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public boolean visibleGrammarSymbolCausesIssueInGeneratedCode(GrammarAST r5) {
        return getBadWords().contains(r5.getText());
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public boolean wantsBaseListener() {
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public boolean wantsBaseVisitor() {
        return false;
    }
}
