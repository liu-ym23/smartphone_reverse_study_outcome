package androidx.room.jarjarred.org.antlr.v4.codegen.target;

import androidx.room.jarjarred.org.antlr.v4.Tool;
import androidx.room.jarjarred.org.antlr.v4.codegen.CodeGenerator;
import androidx.room.jarjarred.org.antlr.v4.codegen.Target;
import androidx.room.jarjarred.org.antlr.v4.codegen.UnicodeEscapes;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.room.jarjarred.org.stringtemplate.v4.StringRenderer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class JavaTarget extends Target {
    protected static final String[] javaKeywords = null;
    private static final ThreadLocal<STGroup> targetTemplates = null;
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
        targetTemplates = new ThreadLocal();
        javaKeywords = new String[]{"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "false", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "null", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "true", "try", "void", "volatile", "while"};
    }

    public JavaTarget(CodeGenerator r5) {
        super(r5, CodeGenerator.DEFAULT_LANGUAGE);
        this.badWords = new HashSet();
    }

    public void addBadWords() {
        this.badWords.addAll(Arrays.asList(javaKeywords));
        this.badWords.add("rule");
        this.badWords.add("parserRule");
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public void appendUnicodeEscapedCodePoint(int r5, StringBuilder r10) {
        UnicodeEscapes.appendJavaStyleEscapedCodePoint(r5, r10);
    }

    public Set<String> getBadWords() {
        if (this.badWords.isEmpty() == false) goto L6;
        addBadWords();
    L6:
        return this.badWords;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public int getSerializedATNSegmentLimit() {
        return 21845;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public String getVersion() {
        return Tool.VERSION;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public STGroup loadTemplates() {
        ThreadLocal<STGroup> r5 = targetTemplates;
        STGroup r10 = r5.get();
        if (r10 != null) goto L6;
        STGroup r11 = super.loadTemplates();
        r11.registerRenderer(String.class, new JavaStringRenderer(), true);
        r5.set(r11);
        return r11;
    L6:
        return r10;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public boolean visibleGrammarSymbolCausesIssueInGeneratedCode(GrammarAST r5) {
        return getBadWords().contains(r5.getText());
    }
}
