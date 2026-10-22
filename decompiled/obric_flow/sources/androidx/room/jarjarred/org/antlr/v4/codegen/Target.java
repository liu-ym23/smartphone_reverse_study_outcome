package androidx.room.jarjarred.org.antlr.v4.codegen;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.Tool;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.RuleFunction;
import androidx.room.jarjarred.org.antlr.v4.misc.CharSupport;
import androidx.room.jarjarred.org.antlr.v4.misc.Utils;
import androidx.room.jarjarred.org.antlr.v4.runtime.RuntimeMetaData;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.stringtemplate.v4.NumberRenderer;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroupFile;
import androidx.room.jarjarred.org.stringtemplate.v4.StringRenderer;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public abstract class Target {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected final CodeGenerator gen;
    private final String language;
    protected String[] targetCharValueEscape;
    private STGroup templates;

    public Target(CodeGenerator r5, String r10) {
        String[] r11 = new String[255];
        this.targetCharValueEscape = r11;
        r11[10] = "\\n";
        r11[13] = "\\r";
        r11[9] = "\\t";
        r11[8] = "\\b";
        r11[12] = "\\f";
        r11[92] = "\\\\";
        r11[39] = "\\'";
        r11[34] = "\\\"";
        this.gen = r5;
        this.language = r10;
    }

    private static boolean shouldUseUnicodeEscapeForCodePointInDoubleQuotedString(int r5) {
        if (r5 >= 32) goto L5;
    L10:
        return true;
    L5:
        if (r5 == 92) goto L10;
        if (r5 >= 127) goto L10;
        return false;
    }

    public abstract void appendUnicodeEscapedCodePoint(int r5, StringBuilder r10);

    public String encodeIntAsCharEscape(int r5) {
        if (r5 < 0) goto L29;
        if (r5 > 65535) goto L29;
        if (r5 < 0) goto L12;
        String[] r10 = this.targetCharValueEscape;
        if (r5 >= r10.length) goto L12;
        String r11 = r10[r5];
        if (r11 == null) goto L12;
        return r11;
    L12:
        if (r5 < 32) goto L22;
        if (r5 >= 127) goto L22;
        if (Character.isDigit(r5) == false) goto L21;
        if (r5 == 56) goto L21;
        if (r5 != 57) goto L22;
    L21:
        return String.valueOf((char) r5);
    L22:
        if (r5 < 0) goto L27;
        if (r5 > 127) goto L27;
        return j0.C("\\", Integer.toOctalString(r5));
    L27:
        return j0.C("\\u", Integer.toHexString(65536 | r5).substring(1, 5));
    L29:
        throw new IllegalArgumentException(String.format("Cannot encode the specified value: %d", new Object[]{Integer.valueOf(r5)}));
    }

    public void genFile(Grammar r5, ST r10, String r11) {
        getCodeGenerator().write(r10, r11);
    }

    public String getAltLabelContextStructName(String r5) {
        return Utils.capitalize(r5) + getTemplates().getInstanceOf("RuleContextNameSuffix").render();
    }

    public String getBaseListenerFileName(boolean r5) {
        ST r10 = getTemplates().getInstanceOf("codeFileExtension");
        StringBuilder r11 = j0.u(j0.q(new StringBuilder(), this.gen.g.name, "BaseListener"));
        r11.append(r10.render());
        return r11.toString();
    }

    public String getBaseVisitorFileName(boolean r5) {
        ST r10 = getTemplates().getInstanceOf("codeFileExtension");
        StringBuilder r11 = j0.u(j0.q(new StringBuilder(), this.gen.g.name, "BaseVisitor"));
        r11.append(r10.render());
        return r11.toString();
    }

    public CodeGenerator getCodeGenerator() {
        return this.gen;
    }

    public String getElementListName(String r5) {
        ST r10 = getTemplates().getInstanceOf("ElementListName");
        r10.add("elemName", getElementName(r5));
        return r10.render();
    }

    public String getElementName(String r5) {
        if (".".equals(r5) == false) goto L7;
        return "_wild";
    L7:
        if (getCodeGenerator().g.getRule(r5) == null) goto L9;
        return r5;
    L9:
        int r10 = getCodeGenerator().g.getTokenType(r5);
        if (r10 != 0) goto L13;
        return r5;
    L13:
        return getTokenTypeAsTargetLabel(getCodeGenerator().g, r10);
    }

    public String getImplicitRuleLabel(String r5) {
        ST r10 = getTemplates().getInstanceOf("ImplicitRuleLabel");
        r10.add("ruleName", r5);
        return r10.render();
    }

    public String getImplicitSetLabel(String r5) {
        ST r10 = getTemplates().getInstanceOf("ImplicitSetLabel");
        r10.add("id", r5);
        return r10.render();
    }

    public String getImplicitTokenLabel(String r5) {
        ST r10 = getTemplates().getInstanceOf("ImplicitTokenLabel");
        int r11 = getCodeGenerator().g.getTokenType(r5);
        if (r5.startsWith("'") == true) goto L5;
        r10.add("tokenName", getTokenTypeAsTargetLabel(getCodeGenerator().g, r11));
        return r10.render();
    L5:
        return j0.g(r11, "s");
    }

    public int getInlineTestSetWordSize() {
        return 64;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getListLabel(String r5) {
        ST r10 = getTemplates().getInstanceOf("ListLabelName");
        r10.add("label", r5);
        return r10.render();
    }

    public String getListenerFileName(boolean r5) {
        ST r10 = getTemplates().getInstanceOf("codeFileExtension");
        StringBuilder r11 = j0.u(j0.q(new StringBuilder(), this.gen.g.name, "Listener"));
        r11.append(r10.render());
        return r11.toString();
    }

    public String getLoopCounter(GrammarAST r5) {
        return "cnt" + r5.token.getTokenIndex();
    }

    public String getLoopLabel(GrammarAST r5) {
        return "loop" + r5.token.getTokenIndex();
    }

    public String getRecognizerFileName(boolean r5) {
        ST r10 = getTemplates().getInstanceOf("codeFileExtension");
        StringBuilder r11 = j0.u(this.gen.g.getRecognizerName());
        r11.append(r10.render());
        return r11.toString();
    }

    public String getRuleFunctionContextStructName(Rule r5) {
        if (r5.g.isLexer() == false) goto L7;
        return getTemplates().getInstanceOf("LexerRuleContext").render();
    L7:
        return Utils.capitalize(r5.name) + getTemplates().getInstanceOf("RuleContextNameSuffix").render();
    }

    public int getSerializedATNSegmentLimit() {
        return Integer.MAX_VALUE;
    }

    public String getTargetStringLiteralFromANTLRStringLiteral(CodeGenerator r10, String r11, boolean r12) {
        StringBuilder r13 = new StringBuilder();
        if (r12 == false) goto L5;
        r13.append(Typography.quote);
    L5:
        int r5 = 1;
    L7:
        if (r5 >= (r11.length() - 1)) goto L47;
        int r14 = r11.codePointAt(r5);
        int r15 = Character.charCount(r14);
        if (r14 != 92) goto L40;
        int r16 = r11.codePointAt(r5 + r15);
        int r17 = r15 + 1;
        if (r16 != 92) goto L13;
    L39:
        r13.append('\\');
        r13.appendCodePoint(r16);
    L38:
        r15 = r17;
    L46:
        r5 = r5 + r15;
        goto L7
    L13:
        if (r16 == 98) goto L39;
        if (r16 == 102) goto L39;
        if (r16 == 110) goto L39;
        if (r16 == 114) goto L39;
        if (r16 == 116) goto L39;
        if (r16 == 117) goto L29;
        if (shouldUseUnicodeEscapeForCodePointInDoubleQuotedString(r16) == false) goto L27;
        appendUnicodeEscapedCodePoint(r16, r13);
        goto L38
    L27:
        r13.appendCodePoint(r16);
        goto L38
    L29:
        if (r11.charAt(r5 + r17) == '{') goto L31;
        r17 = r15 + 5;
    L35:
        int r18 = r5 + r17;
        if (r18 > r11.length()) goto L38;
        appendUnicodeEscapedCodePoint(CharSupport.getCharValueFromCharInGrammarLiteral(r11.substring(r5, r18)), r13);
    L31:
        if (r11.charAt(r5 + r17) == '}') goto L33;
        r17 = r17 + 1;
        goto L31
    L33:
        r17 = r17 + 1;
        goto L35
    L40:
        if (r14 != 34) goto L43;
        r13.append("\\\"");
        goto L46
    L43:
        if (shouldUseUnicodeEscapeForCodePointInDoubleQuotedString(r14) == false) goto L45;
        appendUnicodeEscapedCodePoint(r14, r13);
        goto L46
    L45:
        r13.appendCodePoint(r14);
        goto L46
    L47:
        if (r12 == false) goto L50;
        r13.append(Typography.quote);
    L50:
        return r13.toString();
    }

    public String getTargetStringLiteralFromString(String r10, boolean r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        StringBuilder r5 = new StringBuilder();
        if (r11 == false) goto L8;
        r5.append(Typography.quote);
    L8:
        int r12 = 0;
    L10:
        if (r12 >= r10.length()) goto L23;
        int r13 = r10.codePointAt(r12);
        if (r13 == 39) goto L19;
        String[] r14 = this.targetCharValueEscape;
        if (r13 >= r14.length) goto L19;
        String r15 = r14[r13];
        if (r15 == null) goto L19;
        r5.append(r15);
    L22:
        r12 = r12 + Character.charCount(r13);
    L19:
        if (shouldUseUnicodeEscapeForCodePointInDoubleQuotedString(r13) == false) goto L21;
        appendUnicodeEscapedCodePoint(r12, r5);
        goto L22
    L21:
        r5.appendCodePoint(r13);
        goto L22
    L23:
        if (r11 == false) goto L26;
        r5.append(Typography.quote);
    L26:
        return r5.toString();
    }

    public STGroup getTemplates() {
        if (this.templates != null) goto L11;
        String r5 = getVersion();
        if (r5 != null) goto L7;
    L8:
        this.gen.tool.errMgr.toolError(ErrorType.INCOMPATIBLE_TOOL_AND_TEMPLATES, new Object[]{r5, Tool.VERSION, this.language});
    L9:
        this.templates = loadTemplates();
        goto L11
    L7:
        if (RuntimeMetaData.getMajorMinorVersion(r5).equals(RuntimeMetaData.getMajorMinorVersion(Tool.VERSION)) == true) goto L9;
    L11:
        return this.templates;
    }

    public String getTokenTypeAsTargetLabel(Grammar r5, int r10) {
        String r11 = r5.getTokenName(r10);
        if (Grammar.INVALID_TOKEN_NAME.equals(r11) == true) goto L5;
        return r11;
    L5:
        return String.valueOf(r10);
    }

    public String[] getTokenTypesAsTargetLabels(Grammar r5, int[] r10) {
        String[] r11 = new String[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = getTokenTypeAsTargetLabel(r5, r10[r12]);
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    public abstract String getVersion();

    public String getVisitorFileName(boolean r5) {
        ST r10 = getTemplates().getInstanceOf("codeFileExtension");
        StringBuilder r11 = j0.u(j0.q(new StringBuilder(), this.gen.g.name, "Visitor"));
        r11.append(r10.render());
        return r11.toString();
    }

    public boolean grammarSymbolCausesIssueInGeneratedCode(GrammarAST r5) {
        int r10 = r5.getParent().getType();
        if (r10 != 10) goto L5;
        int r11 = r5.getParent().getParent().getType();
        if (r11 == 42) goto L18;
        if (r11 == 82) goto L18;
    L17:
        return visibleGrammarSymbolCausesIssueInGeneratedCode(r5);
    L18:
        return false;
    L5:
        if (r10 == 11) goto L12;
        if (r10 == 82) goto L12;
        if (r10 != 86) goto L17;
        if (r5.getChildIndex() != 0) goto L17;
    L12:
        return false;
    }

    public STGroup loadTemplates() {
        STGroupFile r5 = new STGroupFile("androidx/room/jarjarred/org/antlr/v4/tool/templates/codegen/" + getLanguage() + "/" + getLanguage() + STGroup.GROUP_FILE_EXTENSION);     // Catch: IllegalArgumentException -> L5
    L7:
        if (r5 != null) goto L9;
        return null;
    L9:
        r5.registerRenderer(Integer.class, new NumberRenderer());
        r5.registerRenderer(String.class, new StringRenderer());
        r5.setListener(new AnonymousClass1(this));
        return r5;
    L5:
        e = move-exception;
        this.gen.tool.errMgr.toolError(ErrorType.MISSING_CODE_GEN_TEMPLATES, e, new Object[]{this.language});
        r5 = null;
        goto L7
    }

    public boolean needsHeader() {
        return false;
    }

    public boolean supportsOverloadedMethods() {
        return true;
    }

    public boolean templatesExist() {
        STGroupFile r5 = new STGroupFile("androidx/room/jarjarred/org/antlr/v4/tool/templates/codegen/" + getLanguage() + "/" + getLanguage() + STGroup.GROUP_FILE_EXTENSION);     // Catch: IllegalArgumentException -> L5
    L6:
        if (r5 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r5 = null;
        goto L6
    }

    public abstract boolean visibleGrammarSymbolCausesIssueInGeneratedCode(GrammarAST r5);

    public boolean wantsBaseListener() {
        return true;
    }

    public boolean wantsBaseVisitor() {
        return true;
    }

    public String getRuleFunctionContextStructName(RuleFunction r5) {
        Rule r10 = r5.rule;
        if (r10.g.isLexer() == false) goto L7;
        return getTemplates().getInstanceOf("LexerRuleContext").render();
    L7:
        return Utils.capitalize(r10.name) + getTemplates().getInstanceOf("RuleContextNameSuffix").render();
    }

    public String getTargetStringLiteralFromString(String r5) {
        return getTargetStringLiteralFromString(r5, true);
    }
}
