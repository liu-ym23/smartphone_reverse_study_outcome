package androidx.room.jarjarred.org.antlr.v4.codegen;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.Tool;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.OutputModelObject;
import androidx.room.jarjarred.org.antlr.v4.gui.TestRig;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.stringtemplate.v4.AutoIndentWriter;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public class CodeGenerator {
    public static final String DEFAULT_LANGUAGE = "Java";
    public static final String TEMPLATE_ROOT = "androidx/room/jarjarred/org/antlr/v4/tool/templates/codegen";
    public static final String VOCAB_FILE_EXTENSION = ".tokens";
    public static final String vocabFilePattern = "<tokens.keys:{t | <t>=<tokens.(t)>\n}><literals.keys:{t | <t>=<literals.(t)>\n}>";
    public final Grammar g;
    public final String language;
    public int lineWidth;
    private Target target;
    public final Tool tool;

    private CodeGenerator(String r5) {
        this.lineWidth = 72;
        this.g = null;
        this.tool = null;
        this.language = r5;
    }

    private OutputModelController createController() {
        ParserFactory r5 = new ParserFactory(this);
        OutputModelController r10 = new OutputModelController(r5);
        r5.setController(r10);
        return r10;
    }

    public static boolean targetExists(String r5) {
        return ((Target) Class.forName(j0.k("androidx.room.jarjarred.org.antlr.v4.codegen.target.", r5, "Target")).asSubclass(Target.class).getConstructor(new Class[]{CodeGenerator.class}).newInstance(new Object[]{new CodeGenerator(r5)})).templatesExist();
    L5:
        return false;
    }

    private ST walk(OutputModelObject r5, boolean r10) {
        return new OutputModelWalker(this.tool, getTemplates()).walk(r5, r10);
    }

    public ST generateBaseListener() {
        return generateBaseListener(false);
    }

    public ST generateBaseVisitor() {
        return generateBaseVisitor(false);
    }

    public ST generateLexer() {
        return generateLexer(false);
    }

    public ST generateListener() {
        return generateListener(false);
    }

    public ST generateParser() {
        return generateParser(false);
    }

    public ST generateVisitor() {
        return generateVisitor(false);
    }

    public String getBaseListenerFileName() {
        return getBaseListenerFileName(false);
    }

    public String getBaseVisitorFileName() {
        return getBaseVisitorFileName(false);
    }

    public String getHeaderFileName() {
        ST r5 = getTemplates().getInstanceOf("headerFileExtension");
        if (r5 != null) goto L6;
        return null;
    L6:
        StringBuilder r10 = j0.u(this.g.getRecognizerName());
        r10.append(r5.render());
        return r10.toString();
    }

    public String getListenerFileName() {
        return getListenerFileName(false);
    }

    public String getRecognizerFileName() {
        return getRecognizerFileName(false);
    }

    public Target getTarget() {
        if (this.target != null) goto L8;
        if (targetExists(this.language) == false) goto L8;
        loadLanguageTarget(this.language);
    L8:
        return this.target;
    }

    public STGroup getTemplates() {
        Target r5 = getTarget();
        if (r5 != null) goto L6;
        return null;
    L6:
        return r5.getTemplates();
    }

    public ST getTokenVocabOutput() {
        ST r5 = new ST(vocabFilePattern);
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator<String> r11 = this.g.tokenNameToTypeMap.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        String r12 = r11.next();
        Integer r13 = this.g.tokenNameToTypeMap.get(r12);
        if (r13.intValue() < 1) goto L4;
        r10.put(r12, r13);
        goto L4
    L8:
        r5.add(TestRig.LEXER_START_RULE_NAME, r10);
        LinkedHashMap r14 = new LinkedHashMap();
        Iterator<String> r15 = this.g.stringLiteralToTypeMap.keySet().iterator();
    L10:
        if (r15.hasNext() == false) goto L14;
        String r16 = r15.next();
        Integer r17 = this.g.stringLiteralToTypeMap.get(r16);
        if (r17.intValue() < 1) goto L10;
        r14.put(r16, r17);
        goto L10
    L14:
        r5.add("literals", r14);
        return r5;
    }

    public String getVisitorFileName() {
        return getVisitorFileName(false);
    }

    public String getVocabFileName() {
        return j0.q(new StringBuilder(), this.g.name, VOCAB_FILE_EXTENSION);
    }

    public void loadLanguageTarget(String r5) {
        String r10 = j0.k("androidx.room.jarjarred.org.antlr.v4.codegen.target.", r5, "Target");
        this.target = (Target) Class.forName(r10).asSubclass(Target.class).getConstructor(new Class[]{CodeGenerator.class}).newInstance(new Object[]{this});     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        this.tool.errMgr.toolError(ErrorType.CANNOT_CREATE_TARGET_GENERATOR, e, new Object[]{r10});
    }

    public void write(ST r5, String r10) {
        Writer r11 = this.tool.getOutputFileWriter(this.g, r10);     // Catch: IOException -> L4
        AutoIndentWriter r12 = new AutoIndentWriter(r11);     // Catch: IOException -> L4
        r12.setLineWidth(this.lineWidth);     // Catch: IOException -> L4
        r5.write(r12);     // Catch: IOException -> L4
        r11.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        this.tool.errMgr.toolError(ErrorType.CANNOT_WRITE_FILE, e, new Object[]{r10});
    }

    public void writeBaseListener(ST r5, boolean r10) {
        getTarget().genFile(this.g, r5, getBaseListenerFileName(r10));
    }

    public void writeBaseVisitor(ST r5, boolean r10) {
        getTarget().genFile(this.g, r5, getBaseVisitorFileName(r10));
    }

    public void writeListener(ST r5, boolean r10) {
        getTarget().genFile(this.g, r5, getListenerFileName(r10));
    }

    public void writeRecognizer(ST r5, boolean r10) {
        getTarget().genFile(this.g, r5, getRecognizerFileName(r10));
    }

    public void writeVisitor(ST r5, boolean r10) {
        getTarget().genFile(this.g, r5, getVisitorFileName(r10));
    }

    public void writeVocabFile() {
        ST r5 = getTokenVocabOutput();
        String r10 = getVocabFileName();
        if (r10 == null) goto L6;
        getTarget().genFile(this.g, r5, r10);
        return;
    }

    public ST generateBaseListener(boolean r5) {
        return walk(createController().buildBaseListenerOutputModel(r5), r5);
    }

    public ST generateBaseVisitor(boolean r5) {
        return walk(createController().buildBaseVisitorOutputModel(r5), r5);
    }

    public ST generateLexer(boolean r5) {
        return walk(createController().buildLexerOutputModel(r5), r5);
    }

    public ST generateListener(boolean r5) {
        return walk(createController().buildListenerOutputModel(r5), r5);
    }

    public ST generateParser(boolean r5) {
        return walk(createController().buildParserOutputModel(r5), r5);
    }

    public ST generateVisitor(boolean r5) {
        return walk(createController().buildVisitorOutputModel(r5), r5);
    }

    public String getBaseListenerFileName(boolean r5) {
        return getTarget().getBaseListenerFileName(r5);
    }

    public String getBaseVisitorFileName(boolean r5) {
        return getTarget().getBaseVisitorFileName(r5);
    }

    public String getListenerFileName(boolean r5) {
        return getTarget().getListenerFileName(r5);
    }

    public String getRecognizerFileName(boolean r5) {
        return getTarget().getRecognizerFileName(r5);
    }

    public String getVisitorFileName(boolean r5) {
        return getTarget().getVisitorFileName(r5);
    }

    public CodeGenerator(Grammar r5) {
        this(r5.tool, r5, r5.getOptionString("language"));
    }

    public CodeGenerator(Tool r5, Grammar r10, String r11) {
        this.lineWidth = 72;
        this.g = r10;
        this.tool = r5;
        if (r11 != null) goto L6;
        r11 = DEFAULT_LANGUAGE;
    L6:
        this.language = r11;
    }
}
