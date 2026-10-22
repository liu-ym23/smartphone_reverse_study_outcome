package androidx.room.jarjarred.org.antlr.v4.codegen.target;

import androidx.room.jarjarred.org.antlr.v4.codegen.CodeGenerator;
import androidx.room.jarjarred.org.antlr.v4.codegen.Target;
import androidx.room.jarjarred.org.antlr.v4.codegen.UnicodeEscapes;
import androidx.room.jarjarred.org.antlr.v4.runtime.RuntimeMetaData;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.room.jarjarred.org.stringtemplate.v4.StringRenderer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class Python2Target extends Target {
    protected static final String[] python2Keywords = null;
    protected final Set<String> badWords;

    public static class PythonStringRenderer extends StringRenderer {
        public PythonStringRenderer() {
        }

        @Override // androidx.room.jarjarred.org.stringtemplate.v4.StringRenderer, androidx.room.jarjarred.org.stringtemplate.v4.AttributeRenderer
        public String toString(Object r5, String r10, Locale r11) {
            return super.toString(r5, r10, r11);
        }
    }

    static {
        python2Keywords = new String[]{"abs", "all", "any", "apply", "as", "bin", "bool", "buffer", "bytearray", "callable", "chr", "classmethod", "coerce", "compile", "complex", "del", "delattr", "dict", "dir", "divmod", "enumerate", "eval", "execfile", "file", "filter", "float", "format", "frozenset", "getattr", "globals", "hasattr", "hash", "help", "hex", "id", "input", "int", "intern", "isinstance", "issubclass", "iter", "len", "list", "locals", "map", "max", "min", "next", "memoryview", "object", "oct", "open", "ord", "pow", "print", "property", "range", "raw_input", "reduce", "reload", "repr", "return", "reversed", "round", "set", "setattr", "slice", "sorted", "staticmethod", "str", "sum", "super", "tuple", "type", "unichr", "unicode", "vars", "with", "xrange", "zip", "__import__", "True", "False", "None"};
    }

    public Python2Target(CodeGenerator r5) {
        super(r5, "Python2");
        this.badWords = new HashSet();
    }

    public void addBadWords() {
        this.badWords.addAll(Arrays.asList(python2Keywords));
        this.badWords.add("rule");
        this.badWords.add("parserRule");
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public void appendUnicodeEscapedCodePoint(int r5, StringBuilder r10) {
        UnicodeEscapes.appendPythonStyleEscapedCodePoint(r5, r10);
    }

    public Set<String> getBadWords() {
        if (this.badWords.isEmpty() == false) goto L6;
        addBadWords();
    L6:
        return this.badWords;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public String getVersion() {
        return RuntimeMetaData.VERSION;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public STGroup loadTemplates() {
        STGroup r5 = super.loadTemplates();
        r5.registerRenderer(String.class, new PythonStringRenderer(), true);
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
