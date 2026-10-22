package androidx.room.jarjarred.org.antlr.v4.codegen.target;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.codegen.CodeGenerator;
import androidx.room.jarjarred.org.antlr.v4.codegen.Target;
import androidx.room.jarjarred.org.antlr.v4.codegen.UnicodeEscapes;
import androidx.room.jarjarred.org.antlr.v4.runtime.RuntimeMetaData;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.stringtemplate.v4.NumberRenderer;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroupFile;
import androidx.room.jarjarred.org.stringtemplate.v4.StringRenderer;

/* JADX INFO: loaded from: classes.dex */
public class CSharpTarget extends Target {
    public CSharpTarget(CodeGenerator r5) {
        super(r5, "CSharp");
        String[] r10 = this.targetCharValueEscape;
        r10[0] = "\\0";
        r10[7] = "\\a";
        r10[11] = "\\v";
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public void appendUnicodeEscapedCodePoint(int r5, StringBuilder r10) {
        UnicodeEscapes.appendPythonStyleEscapedCodePoint(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public String encodeIntAsCharEscape(int r5) {
        if (r5 < 0) goto L32;
        if (r5 > 65535) goto L32;
        if (r5 < 0) goto L12;
        String[] r10 = this.targetCharValueEscape;
        if (r5 >= r10.length) goto L12;
        String r11 = r10[r5];
        if (r11 == null) goto L12;
    L30:
        return j0.k("'", r11, "'");
    L12:
        if (r5 >= 32) goto L14;
    L28:
        r11 = String.format("\\x%X", new Object[]{Integer.valueOf(r5 & 65535)});
        goto L30
    L14:
        if (r5 >= 127) goto L28;
        if (r5 < 48) goto L20;
        if (r5 <= 57) goto L28;
    L20:
        if (r5 < 97) goto L24;
        if (r5 <= 102) goto L28;
    L24:
        if (r5 >= 65) goto L26;
    L27:
        r11 = Character.toString((char) r5);
        goto L30
    L26:
        if (r5 <= 70) goto L28;
    L32:
        throw new IllegalArgumentException(String.format("Cannot encode the specified value: %d", new Object[]{Integer.valueOf(r5)}));
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public String getVersion() {
        return RuntimeMetaData.VERSION;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public STGroup loadTemplates() {
        STGroupFile r5 = new STGroupFile("androidx/room/jarjarred/org/antlr/v4/tool/templates/codegen/CSharp/" + getLanguage() + STGroup.GROUP_FILE_EXTENSION);
        r5.registerRenderer(Integer.class, new NumberRenderer());
        r5.registerRenderer(String.class, new StringRenderer());
        r5.setListener(new AnonymousClass1(this));
        return r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public boolean visibleGrammarSymbolCausesIssueInGeneratedCode(GrammarAST r5) {
        return false;
    }
}
