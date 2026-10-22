package androidx.room.jarjarred.org.stringtemplate.v4.compiler;

import androidx.room.jarjarred.org.antlr.runtime.ANTLRStringStream;
import androidx.room.jarjarred.org.antlr.runtime.CommonTokenStream;
import androidx.room.jarjarred.org.antlr.runtime.NoViableAltException;
import androidx.room.jarjarred.org.antlr.runtime.Parser;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.TokenStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTreeNodeStream;
import androidx.room.jarjarred.org.stringtemplate.v4.Interpreter;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.ErrorManager;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.ErrorType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class Compiler {
    public static final int NUM_OPTIONS = 0;
    public static final String SUBTEMPLATE_PREFIX = "_sub";
    public static final int TEMPLATE_INITIAL_CODE_SIZE = 15;
    public static final Map<String, String> defaultOptionValues = null;
    public static Map<String, Short> funcs;
    public static int subtemplateCount;
    public static final Map<String, Interpreter.Option> supportedOptions = null;
    public STGroup group;

    static {
        HashMap<String, Interpreter.Option> r5 = new AnonymousClass1();
        supportedOptions = r5;
        NUM_OPTIONS = r5.size();
        defaultOptionValues = new AnonymousClass2();
        funcs = new AnonymousClass3();
        subtemplateCount = 0;
    }

    public Compiler() {
        this(STGroup.defaultGroup);
    }

    public static CompiledST defineBlankRegion(CompiledST r5, Token r10) {
        String r11 = STGroup.getMangledRegionName(r5.name, r10.getText());
        CompiledST r12 = new CompiledST();
        r12.isRegion = true;
        r12.templateDefStartToken = r10;
        r12.regionDefType = ST.RegionType.IMPLICIT;
        r12.name = r11;
        r5.addImplicitlyDefinedTemplate(r12);
        return r12;
    }

    public static String getNewSubtemplateName() {
        subtemplateCount++;
        return SUBTEMPLATE_PREFIX + subtemplateCount;
    }

    public CompiledST compile(String r10) {
        CompiledST r11 = compile(null, null, null, r10, null);
        r11.hasFormalArgs = false;
        return r11;
    }

    public void reportMessageAndThrowSTException(TokenStream r5, Token r10, Parser r11, RecognitionException r12) {
        if (r12.token.getType() != (-1)) goto L5;
        this.group.errMgr.compileTimeError(ErrorType.SYNTAX_ERROR, r10, r12.token, "premature EOF");
    L16:
        throw new STException();
    L5:
        if ((r12 instanceof NoViableAltException) == false) goto L7;
        this.group.errMgr.compileTimeError(ErrorType.SYNTAX_ERROR, r10, r12.token, "'" + r12.token.getText() + "' came as a complete surprise to me");
        goto L16
    L7:
        if (r5.index() != 0) goto L9;
        this.group.errMgr.compileTimeError(ErrorType.SYNTAX_ERROR, r10, r12.token, "this doesn't look like a template: \"" + r5 + "\"");
        goto L16
    L9:
        if (r5.LA(1) != 23) goto L11;
        this.group.errMgr.compileTimeError(ErrorType.SYNTAX_ERROR, r10, r12.token, "doesn't look like an expression");
        goto L16
    L11:
        this.group.errMgr.compileTimeError(ErrorType.SYNTAX_ERROR, r10, r12.token, r11.getErrorMessage(r12, r11.getTokenNames()));
        goto L16
    }

    public Compiler(STGroup r5) {
        this.group = r5;
    }

    public CompiledST compile(String r10, String r11) {
        CompiledST r12 = compile(null, r10, null, r11, null);
        r12.hasFormalArgs = false;
        return r12;
    }

    public CompiledST compile(String r10, String r11, List<FormalArgument> r12, String r13, final Token r14) {
        final ANTLRStringStream r5 = new ANTLRStringStream(r13);
        if (r10 != null) goto L6;
        r10 = r11;
    L6:
        r5.name = r10;
        if (r14 != null) goto L9;
    L11:
        STGroup r15 = this.group;
        STLexer r16 = new STLexer(r15.errMgr, r5, r14, r15.delimiterStartChar, r15.delimiterStopChar);
    L12:
        TokenStream r17 = new CommonTokenStream(r16);
        STParser r18 = new STParser(r17, this.group.errMgr, r14);
        STParser.templateAndEOF_return r19 = r18.templateAndEOF();     // Catch: RecognitionException -> L31
        if (r18.getNumberOfSyntaxErrors() <= 0) goto L17;
    L29:
        CompiledST r20 = new CompiledST();
        r20.defineFormalArgs(r12);
        return r20;
    L17:
        if (r19.getTree() == null) goto L29;
        CommonTreeNodeStream r21 = new CommonTreeNodeStream(r19.getTree());
        r21.setTokenStream(r17);
        CompiledST r110 = new CodeGenerator(r21, this.group.errMgr, r11, r13, r14).template(r11, r12);     // Catch: RecognitionException -> L25
        r110.nativeGroup = this.group;     // Catch: RecognitionException -> L23
        r110.template = r13;     // Catch: RecognitionException -> L23
        CommonTree r111 = r19.getTree();     // Catch: RecognitionException -> L23
        r110.ast = r111;     // Catch: RecognitionException -> L23
        r111.setUnknownTokenBoundaries();     // Catch: RecognitionException -> L23
        r110.tokens = r17;     // Catch: RecognitionException -> L23
    L28:
        return r110;
    L23:
        e = e;
    L27:
        this.group.errMgr.internalError(null, "bad tree structure", e);
    L25:
        e = e;
        r110 = null;
    L31:
        e = move-exception;
        reportMessageAndThrowSTException(r17, r14, r18, e);
        return null;
    L9:
        if (r14.getType() != 6) goto L11;
        STGroup r22 = this.group;
        final ErrorManager r23 = r22.errMgr;
        final char r24 = r22.delimiterStartChar;
        final char r25 = r22.delimiterStopChar;
        r16 = new AnonymousClass4(this, r23, r5, r14, r24, r25);
        goto L12
    }
}
