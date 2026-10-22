package androidx.room.jarjarred.org.antlr.v4.tool;

import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.v4.Tool;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroupFile;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.ErrorBuffer;
import com.bytedance.ai.event.MessageIndication;
import com.lynx.serval.svg.SVGRenderEngine;
import java.io.File;
import java.net.URL;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ErrorManager {
    public static final String FORMATS_DIR = "androidx/room/jarjarred/org/antlr/v4/tool/templates/messages/formats/";
    public Set<ErrorType> errorTypes;
    public int errors;
    STGroup format;
    String formatName;
    ErrorBuffer initSTListener;
    public Tool tool;
    public int warnings;

    /* JADX INFO: renamed from: androidx.room.jarjarred.org.antlr.v4.tool.ErrorManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$antlr$v4$tool$ErrorSeverity = null;

        static {
            int[] r5 = new int[ErrorSeverity.values().length];
            $SwitchMap$org$antlr$v4$tool$ErrorSeverity = r5;
            r5[ErrorSeverity.WARNING_ONE_OFF.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$antlr$v4$tool$ErrorSeverity[ErrorSeverity.WARNING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$antlr$v4$tool$ErrorSeverity[ErrorSeverity.ERROR_ONE_OFF.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$antlr$v4$tool$ErrorSeverity[ErrorSeverity.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public ErrorManager(Tool r5) {
        this.errorTypes = EnumSet.noneOf(ErrorType.class);
        this.initSTListener = new ErrorBuffer();
        this.tool = r5;
    }

    public static void fatalInternalError(String r5, Throwable r10) {
        internalError(r5, r10);
        throw new RuntimeException(r5, r10);
    }

    private static StackTraceElement getLastNonErrorManagerCodeLocation(Throwable r5) {
        StackTraceElement[] r10 = r5.getStackTrace();
        int r11 = 0;
    L4:
        if (r11 >= r10.length) goto L10;
        if (r10[r11].toString().contains("ErrorManager") == false) goto L10;
        r11 = r11 + 1;
    L10:
        return r10[r11];
    }

    public static void internalError(String r5, Throwable r10) {
        internalError("Exception " + r10 + "@" + getLastNonErrorManagerCodeLocation(r10) + ": " + r5);
    }

    public static void rawError(String r5) {
        System.err.println(r5);
    }

    public void emit(ErrorType r5, ANTLRMessage r10) {
        int r11 = AnonymousClass1.$SwitchMap$org$antlr$v4$tool$ErrorSeverity[r5.severity.ordinal()];
        if (r11 == 1) goto L16;
        if (r11 != 2) goto L7;
    L18:
        this.warnings++;
        this.tool.warning(r10);
    L19:
        this.errorTypes.add(r5);
        return;
    L7:
        if (r11 == 3) goto L12;
        if (r11 != 4) goto L19;
    L14:
        this.errors++;
        this.tool.error(r10);
        goto L19
    L12:
        if (this.errorTypes.contains(r5) == false) goto L14;
    L16:
        if (this.errorTypes.contains(r5) == false) goto L18;
        goto L18
    }

    public boolean formatWantsSingleLineMessage() {
        return this.format.getInstanceOf("wantsSingleLineMessage").render().equals("true");
    }

    public ST getLocationFormat() {
        return this.format.getInstanceOf("location");
    }

    public ST getMessageFormat() {
        return this.format.getInstanceOf("message");
    }

    public ST getMessageTemplate(ANTLRMessage r10) {
        ST r5 = r10.getMessageTemplate(this.tool.longMessages);
        ST r11 = getLocationFormat();
        ST r12 = getReportFormat(r10.getErrorType().severity);
        ST r13 = getMessageFormat();
        int r14 = r10.line;
        boolean r15 = true;
        if (r14 == (-1)) goto L5;
        r11.add(SVGRenderEngine.LINE, Integer.valueOf(r14));
        boolean r16 = true;
    L6:
        int r17 = r10.charPosition;
        if (r17 == (-1)) goto L9;
        r11.add("column", Integer.valueOf(r17));
        r16 = true;
    L9:
        String r18 = r10.fileName;
        if (r18 != null) goto L12;
        r15 = r16;
    L18:
        r13.add("id", Integer.valueOf(r10.getErrorType().code));
        r13.add(MessageIndication.CONTENT_TYPE_TEXT, r5);
        if (r15 == false) goto L21;
        r12.add("location", r11);
    L21:
        r12.add("message", r13);
        return r12;
    L12:
        if (this.format.equals("antlr") == false) goto L16;
        File r19 = new File(r10.fileName);
        if (r19.exists() == false) goto L16;
        r18 = r19.getName();
    L16:
        r11.add("file", r18);
        goto L18
    L5:
        r16 = false;
        goto L6
    }

    public int getNumErrors() {
        return this.errors;
    }

    public ST getReportFormat(ErrorSeverity r5) {
        ST r10 = this.format.getInstanceOf("report");
        r10.add("type", r5.getText());
        return r10;
    }

    public void grammarError(ErrorType r5, String r10, Token r11, Object... r12) {
        emit(r5, new GrammarSemanticsMessage(r5, r10, r11, r12));
    }

    public void info(String r5) {
        this.tool.info(r5);
    }

    public void leftRecursionCycles(String r5, Collection<? extends Collection<Rule>> r10) {
        this.errors++;
        this.tool.error(new LeftRecursionCyclesMessage(r5, r10));
    }

    public void panic(ErrorType r5, Object... r10) {
        String r11 = getMessageTemplate(new ToolMessage(r5, r10)).render();
        if (formatWantsSingleLineMessage() == false) goto L5;
        r11 = r11.replace('\n', ' ');
    L5:
        panic(r11);
    }

    public void resetErrorState() {
        this.errors = 0;
        this.warnings = 0;
    }

    public void setFormat(String r5) {
        this.formatName = r5;
        String r10 = FORMATS_DIR + r5 + STGroup.GROUP_FILE_EXTENSION;
        URL r11 = Thread.currentThread().getContextClassLoader().getResource(r10);
        if (r11 != null) goto L6;
        r11 = ErrorManager.class.getClassLoader().getResource(r10);
    L6:
        if (r11 == null) goto L8;
    L10:
        if (r11 != null) goto L13;
        rawError("no such message format file " + r10 + " retrying with default ANTLR format");
        setFormat("antlr");
        return;
    L13:
        STGroupFile r12 = new STGroupFile(r10, "UTF-8");
        this.format = r12;
        r12.load();
        if (this.initSTListener.errors.isEmpty() == true) goto L16;
        rawError("ANTLR installation corrupted; can't load messages format file:\n" + this.initSTListener.toString());
        panic();
    L16:
        boolean r13 = verifyFormat();
        if (r13 == false) goto L19;
    L21:
        if (r13 == true) goto L25;
        setFormat("antlr");
        return;
    L25:
        return;
    L19:
        if (r5.equals("antlr") == false) goto L21;
        rawError("ANTLR installation corrupted; ANTLR messages format file " + r5 + ".stg incomplete");
        panic();
        return;
    L8:
        if (r5.equals("antlr") == false) goto L10;
        rawError("ANTLR installation corrupted; cannot find ANTLR messages format file " + r10);
        panic();
        goto L13
    }

    public void syntaxError(ErrorType r10, String r11, Token r12, RecognitionException r13, Object... r14) {
        emit(r10, new GrammarSyntaxMessage(r10, r11, r12, r13, r14));
    }

    public void toolError(ErrorType r5, Object... r10) {
        toolError(r5, null, r10);
    }

    public boolean verifyFormat() {
        if (this.format.isDefined("location") == true) goto L5;
        System.err.println("Format template 'location' not found in " + this.formatName);
        boolean r5 = false;
    L7:
        if (this.format.isDefined("message") == true) goto L10;
        System.err.println("Format template 'message' not found in " + this.formatName);
        r5 = false;
    L10:
        if (this.format.isDefined("report") == true) goto L13;
        System.err.println("Format template 'report' not found in " + this.formatName);
        return false;
    L13:
        return r5;
    L5:
        r5 = true;
        goto L7
    }

    public static void rawError(String r5, Throwable r10) {
        rawError(r5);
        r10.printStackTrace(System.err);
    }

    public void toolError(ErrorType r5, Throwable r10, Object... r11) {
        emit(r5, new ToolMessage(r5, r10, r11));
    }

    public static void internalError(String r5) {
        String r10 = getLastNonErrorManagerCodeLocation(new Exception()) + ": " + r5;
        System.err.println("internal error: " + r10);
    }

    public static void panic(String r5) {
        rawError(r5);
        panic();
    }

    public static void panic() {
        throw new Error("ANTLR ErrorManager panic");
    }
}
