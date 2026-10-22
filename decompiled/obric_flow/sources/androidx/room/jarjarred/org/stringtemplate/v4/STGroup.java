package androidx.room.jarjarred.org.stringtemplate.v4;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.org.antlr.runtime.ANTLRFileStream;
import androidx.room.jarjarred.org.antlr.runtime.ANTLRInputStream;
import androidx.room.jarjarred.org.antlr.runtime.CharStream;
import androidx.room.jarjarred.org.antlr.runtime.CommonToken;
import androidx.room.jarjarred.org.antlr.runtime.CommonTokenStream;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.CompiledST;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.Compiler;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.FormalArgument;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.GroupLexer;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.GroupParser;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.STException;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.Aggregate;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.AggregateModelAdaptor;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.ErrorManager;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.ErrorType;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.MapModelAdaptor;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.Misc;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.ObjectModelAdaptor;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.STModelAdaptor;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.TypeRegistry;
import androidx.room.solver.CodeGenScope;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public class STGroup {
    public static final ErrorManager DEFAULT_ERR_MGR = null;
    public static final String DEFAULT_KEY = "default";
    public static final String DICT_KEY = "key";
    public static final String GROUP_FILE_EXTENSION = ".stg";
    protected static final CompiledST NOT_FOUND_ST = null;
    public static final String TEMPLATE_FILE_EXTENSION = ".st";
    public static STGroup defaultGroup;
    public static boolean trackCreationEvents;
    public static boolean verbose;
    protected final Map<Class<?>, ModelAdaptor> adaptors;
    public char delimiterStartChar;
    public char delimiterStopChar;
    protected Map<String, Map<String, Object>> dictionaries;
    public String encoding;
    public ErrorManager errMgr;
    protected final List<STGroup> imports;
    protected final List<STGroup> importsToClearOnUnload;
    public boolean iterateAcrossValues;
    protected Map<Class<?>, AttributeRenderer> renderers;
    protected Map<String, CompiledST> templates;

    static {
        NOT_FOUND_ST = new CompiledST();
        DEFAULT_ERR_MGR = new ErrorManager();
        verbose = false;
        trackCreationEvents = false;
        defaultGroup = new STGroup();
    }

    public STGroup() {
        this.encoding = "UTF-8";
        this.imports = Collections.synchronizedList(new ArrayList());
        this.importsToClearOnUnload = Collections.synchronizedList(new ArrayList());
        this.delimiterStartChar = Typography.less;
        this.delimiterStopChar = Typography.greater;
        this.templates = Collections.synchronizedMap(new LinkedHashMap());
        this.dictionaries = Collections.synchronizedMap(new HashMap());
        TypeRegistry r5 = new TypeRegistry();
        r5.put2(Object.class, new ObjectModelAdaptor());
        r5.put2(ST.class, new STModelAdaptor());
        r5.put2(Map.class, new MapModelAdaptor());
        r5.put2(Aggregate.class, new AggregateModelAdaptor());
        this.adaptors = Collections.synchronizedMap(r5);
        this.iterateAcrossValues = false;
        this.errMgr = DEFAULT_ERR_MGR;
    }

    public static String getMangledRegionName(String r5, String r10) {
        if (r5.charAt(0) == '/') goto L6;
        r5 = "/".concat(r5);
    L6:
        return a.p("/region__", r5, CodeGenScope.CLASS_PROPERTY_PREFIX, r10);
    }

    public static String getUnMangledTemplateName(String r5) {
        return a.m(r5.substring(9, r5.lastIndexOf(CodeGenScope.CLASS_PROPERTY_PREFIX)), '.', r5.substring(r5.lastIndexOf(CodeGenScope.CLASS_PROPERTY_PREFIX) + 2, r5.length()));
    }

    public CompiledST compile(String r10, String r11, List<FormalArgument> r12, String r13, Token r14) {
        return new Compiler(this).compile(r10, r11, r12, r13, r14);
    }

    public ST createSingleton(Token r10) {
        if (r10.getType() != 5) goto L6;
        String r5 = Misc.strip(r10.getText(), 2);
    L5:
        String r11 = r5;
        ST r12 = createStringTemplateInternally(compile(getFileName(), null, null, r11, r10));
        r12.groupThatCreatedThisInstance = this;
        CompiledST r13 = r12.impl;
        r13.hasFormalArgs = false;
        r13.name = ST.UNKNOWN_NAME;
        r13.defineImplicitlyDefinedTemplates(this);
        return r12;
    L6:
        r5 = Misc.strip(r10.getText(), 1);
        goto L5
    }

    public ST createStringTemplate(CompiledST r5) {
        ST r10 = new ST();
        r10.impl = r5;
        r10.groupThatCreatedThisInstance = this;
        Map<String, FormalArgument> r11 = r5.formalArguments;
        if (r11 == null) goto L5;
        Object[] r12 = new Object[r11.size()];
        r10.locals = r12;
        Arrays.fill(r12, ST.EMPTY_ATTR);
    L5:
        return r10;
    }

    public ST createStringTemplateInternally(CompiledST r5) {
        ST r10 = createStringTemplate(r5);
        if (trackCreationEvents == false) goto L7;
        ST.DebugState r11 = r10.debugState;
        if (r11 == null) goto L7;
        r11.newSTEvent = null;
    L7:
        return r10;
    }

    public void defineDictionary(String r5, Map<String, Object> r10) {
        this.dictionaries.put(r5, r10);
    }

    public CompiledST defineRegion(String r10, Token r11, String r12, Token r13) {
        String r14 = r11.getText();
        String r5 = Misc.trimOneTrailingNewline(Misc.trimOneStartingNewline(r12));
        CompiledST r15 = compile(getFileName(), r10, null, r5, r13);
        String r16 = getMangledRegionName(r10, r14);
        if (lookupTemplate(r16) != null) goto L6;
        this.errMgr.compileTimeError(ErrorType.NO_SUCH_REGION, r13, r11, r10, r14);
        return new CompiledST();
    L6:
        r15.name = r16;
        r15.isRegion = true;
        r15.regionDefType = ST.RegionType.EXPLICIT;
        r15.templateDefStartToken = r11;
        rawDefineTemplate(r16, r15, r11);
        r15.defineArgDefaultValueTemplates(this);
        r15.defineImplicitlyDefinedTemplates(this);
        return r15;
    }

    public CompiledST defineTemplate(String r10, String r11) {
        if (r10.charAt(0) == '/') goto L5;
        r10 = "/".concat(r10);
    L5:
        String r5 = r10;
        return defineTemplate(r5, new CommonToken(9, r5), null, r11, null);
    L8:
        return null;
    }

    public CompiledST defineTemplateAlias(Token r10, Token r11) {
        String r5 = r10.getText();
        String r12 = r11.getText();
        CompiledST r13 = rawGetTemplate("/" + r12);
        if (r13 != null) goto L6;
        this.errMgr.compileTimeError(ErrorType.ALIAS_TARGET_UNDEFINED, null, r10, r5, r12);
        return null;
    L6:
        rawDefineTemplate("/" + r5, r13, r10);
        return r13;
    }

    public void defineTemplateOrRegion(String r10, String r11, Token r12, String r13, Token r14, List<FormalArgument> r15) {
        if (r11 == null) goto L4;
        defineRegion(r11, r14, r13, r12);     // Catch: STException -> L6
    L7:
        return;
    L4:
        defineTemplate(r10, r14, r15, r13, r12);     // Catch: STException -> L6
    }

    public AttributeRenderer getAttributeRenderer(Class<?> r5) {
        Map<Class<?>, AttributeRenderer> r10 = this.renderers;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.get(r5);
    }

    public ST getEmbeddedInstanceOf(Interpreter r5, InstanceScope r10, String r11) {
        if (r11.charAt(0) == '/') goto L6;
        r11 = j0.q(new StringBuilder(), r10.f675st.impl.prefix, r11);
    L6:
        if (verbose == false) goto L8;
        System.out.println("getEmbeddedInstanceOf(" + r11 + ")");
    L8:
        ST r12 = getInstanceOf(r11);
        if (r12 != null) goto L13;
        this.errMgr.runTimeError(r5, r10, ErrorType.NO_SUCH_TEMPLATE, r11);
        return createStringTemplateInternally(new CompiledST());
    L13:
        if (trackCreationEvents == false) goto L15;
        r12.debugState.newSTEvent = null;
    L15:
        return r12;
    }

    public String getFileName() {
        return null;
    }

    public List<STGroup> getImportedGroups() {
        return this.imports;
    }

    public ST getInstanceOf(String r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (verbose == false) goto L9;
        System.out.println(getName() + ".getInstanceOf(" + r5 + ")");
    L9:
        if (r5.charAt(0) == '/') goto L11;
        r5 = "/".concat(r5);
    L11:
        CompiledST r10 = lookupTemplate(r5);
        if (r10 != null) goto L14;
        return null;
    L14:
        return createStringTemplate(r10);
    }

    public STErrorListener getListener() {
        return this.errMgr.listener;
    }

    public ModelAdaptor getModelAdaptor(Class<?> r5) {
        return this.adaptors.get(r5);
    }

    public String getName() {
        return "<no name>;";
    }

    public URL getRootDirURL() {
        return null;
    }

    public Set<String> getTemplateNames() {
        load();
        HashSet r5 = new HashSet();
        Iterator<Map.Entry<String, CompiledST>> r10 = this.templates.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Map.Entry<String, CompiledST> r11 = r10.next();
        if (r11.getValue() == NOT_FOUND_ST) goto L4;
        r5.add(r11.getKey());
        goto L4
    L8:
        return r5;
    }

    public URL getURL(String r5) {
        URL r10 = Thread.currentThread().getContextClassLoader().getResource(r5);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return getClass().getClassLoader().getResource(r5);
    }

    public void importTemplates(STGroup r5) {
        importTemplates(r5, false);
    }

    public boolean isDefined(String r5) {
        if (lookupTemplate(r5) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isDictionary(String r5) {
        if (this.dictionaries.get(r5) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public CompiledST load(String r5) {
        return null;
    }

    public CompiledST loadAbsoluteTemplateFile(String r5) {
        ANTLRFileStream r10 = new ANTLRFileStream(r5, this.encoding);     // Catch: IOException -> L5
        r10.name = r5;     // Catch: IOException -> L5
        return loadTemplateFile("", r5, r10);
    L5:
        return null;
    }

    public void loadGroupFile(String r5, String r10) {
        if (verbose == false) goto L10;
        System.out.println(getClass().getSimpleName() + ".loadGroupFile(group-file-prefix=" + r5 + ", fileName=" + r10 + ")");
    L10:
        ANTLRInputStream r11 = new ANTLRInputStream(new URL(r10).openStream(), this.encoding);     // Catch: Exception -> L7
        GroupLexer r12 = new GroupLexer(r11);     // Catch: Exception -> L7
        r11.name = r10;     // Catch: Exception -> L7
        new GroupParser(new CommonTokenStream(r12)).group(this, r5);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        this.errMgr.IOError(null, ErrorType.CANT_LOAD_GROUP_FILE, e, r10);
    }

    public CompiledST loadTemplateFile(String r5, String r10, CharStream r11) {
        GroupLexer r12 = new GroupLexer(r11);
        GroupParser r13 = new GroupParser(new CommonTokenStream(r12));
        r13.group = this;
        r12.group = this;
        r13.templateDef(r5);     // Catch: RecognitionException -> L5
    L7:
        String r14 = Misc.getFileNameNoSuffix(r10);
        if (r5 != null) goto L10;
    L12:
        CompiledST r15 = rawGetTemplate(r14);
        r15.prefix = r5;
        return r15;
    L10:
        if (r5.length() <= 0) goto L12;
        r14 = j0.j(r5, r14);
    L5:
        e = move-exception;
        this.errMgr.groupSyntaxError(ErrorType.SYNTAX_ERROR, r10, e, e.getMessage());
        goto L7
    }

    public CompiledST lookupImportedTemplate(String r10) {
        if (this.imports.size() != 0) goto L5;
        return null;
    L5:
        Iterator<STGroup> r5 = this.imports.iterator();
    L7:
        if (r5.hasNext() == false) goto L18;
        STGroup r11 = r5.next();
        if (verbose == false) goto L11;
        System.out.println("checking " + r11.getName() + " for imported " + r10);
    L11:
        CompiledST r12 = r11.lookupTemplate(r10);
        if (r12 == null) goto L7;
        if (verbose == false) goto L16;
        System.out.println(r11.getName() + ".lookupImportedTemplate(" + r10 + ") found");
    L16:
        return r12;
    L18:
        if (verbose == false) goto L20;
        PrintStream r13 = System.out;
        StringBuilder r14 = j0.w(r10, " not found in ");
        r14.append(getName());
        r14.append(" imports");
        r13.println(r14.toString());
    L20:
        return null;
    }

    public CompiledST lookupTemplate(String r10) {
        if (r10.charAt(0) == '/') goto L6;
        r10 = "/".concat(r10);
    L6:
        if (verbose == false) goto L8;
        System.out.println(getName() + ".lookupTemplate(" + r10 + ")");
    L8:
        CompiledST r5 = rawGetTemplate(r10);
        CompiledST r11 = NOT_FOUND_ST;
        if (r5 == r11) goto L11;
        if (r5 != null) goto L17;
        r5 = load(r10);
    L17:
        if (r5 != null) goto L19;
        r5 = lookupImportedTemplate(r10);
    L19:
        if (r5 != null) goto L25;
        if (verbose == false) goto L23;
        System.out.println(r10 + " recorded not found");
    L23:
        this.templates.put(r10, r11);
    L25:
        if (verbose == false) goto L28;
        if (r5 == null) goto L28;
        System.out.println(getName() + ".lookupTemplate(" + r10 + ") found");
    L28:
        return r5;
    L11:
        if (verbose == false) goto L29;
        System.out.println(r10 + " previously seen as not found");
        return null;
    L29:
        return null;
    }

    public void rawDefineTemplate(String r10, CompiledST r11, Token r12) {
        CompiledST r5 = rawGetTemplate(r10);
        if (r5 == null) goto L20;
        boolean r13 = r5.isRegion;
        if (r13 == true) goto L8;
        this.errMgr.compileTimeError(ErrorType.TEMPLATE_REDEFINITION, null, r12);
        return;
    L8:
        if (r13 == false) goto L20;
        ST.RegionType r14 = r11.regionDefType;
        ST.RegionType r15 = ST.RegionType.IMPLICIT;
        if (r14 != r15) goto L12;
    L15:
        if (r14 != r15) goto L17;
    L18:
        this.errMgr.compileTimeError(ErrorType.REGION_REDEFINITION, null, r12, getUnMangledTemplateName(r10));
        return;
    L17:
        if (r5.regionDefType != ST.RegionType.EXPLICIT) goto L20;
    L12:
        if (r5.regionDefType != ST.RegionType.EMBEDDED) goto L15;
        this.errMgr.compileTimeError(ErrorType.EMBEDDED_REGION_REDEFINITION, null, r12, getUnMangledTemplateName(r10));
        return;
    L20:
        r11.nativeGroup = this;
        r11.templateDefStartToken = r12;
        this.templates.put(r10, r11);
    }

    public Map<String, Object> rawGetDictionary(String r5) {
        return this.dictionaries.get(r5);
    }

    public CompiledST rawGetTemplate(String r5) {
        return this.templates.get(r5);
    }

    public void registerModelAdaptor(Class<?> r5, ModelAdaptor r10) {
        if (r5.isPrimitive() == true) goto L7;
        this.adaptors.put(r5, r10);
        return;
    L7:
        throw new IllegalArgumentException("can't register ModelAdaptor for primitive type ".concat(r5.getSimpleName()));
    }

    public void registerRenderer(Class<?> r5, AttributeRenderer r10) {
        registerRenderer(r5, r10, true);
    }

    public void setListener(STErrorListener r5) {
        this.errMgr = new ErrorManager(r5);
    }

    public String show() {
        StringBuilder r5 = new StringBuilder();
        if (this.imports.size() == 0) goto L5;
        r5.append(" : " + this.imports);
    L5:
        Iterator<String> r10 = this.templates.keySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L18;
        String r11 = r10.next();
        CompiledST r12 = rawGetTemplate(r11);
        if (r12.isAnonSubtemplate == true) goto L7;
        if (r12 == NOT_FOUND_ST) goto L7;
        r5.append(r11.substring(r11.lastIndexOf(47) + 1, r11.length()));
        r5.append('(');
        Map<String, FormalArgument> r13 = r12.formalArguments;
        if (r13 == null) goto L16;
        r5.append(Misc.join(r13.values().iterator(), ","));
    L16:
        r5.append(')');
        StringBuilder r14 = new StringBuilder(" ::= <<");
        String r15 = Misc.newline;
        r14.append(r15);
        r5.append(r14.toString());
        r5.append(r12.template + r15);
        StringBuilder r16 = new StringBuilder(">>");
        r16.append(r15);
        r5.append(r16.toString());
        goto L7
    L18:
        return r5.toString();
    }

    public String toString() {
        return getName();
    }

    public void undefineTemplate(String r5) {
        this.templates.remove(r5);
    }

    public synchronized void unload() {
        monitor-enter(this);
        this.templates.clear();     // Catch: Throwable -> L7
        this.dictionaries.clear();     // Catch: Throwable -> L7
        Iterator<STGroup> r5 = this.imports.iterator();     // Catch: Throwable -> L7
    L5:
        if (r5.hasNext() == false) goto L9;
        r5.next().unload();     // Catch: Throwable -> L7
        goto L5
    L9:
        Iterator<STGroup> r10 = this.importsToClearOnUnload.iterator();     // Catch: Throwable -> L7
    L11:
        if (r10.hasNext() == false) goto L13;
        STGroup r11 = r10.next();     // Catch: Throwable -> L7
        this.imports.remove(r11);     // Catch: Throwable -> L7
        goto L11
    L13:
        this.importsToClearOnUnload.clear();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void importTemplates(Token r11) {
        if (verbose == false) goto L5;
        System.out.println("importTemplates(" + r11.getText() + ")");
    L5:
        String r5 = r11.getText();
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.equals("<missing STRING>") == true) goto L52;
        String r10 = Misc.strip(r5, 1);
        boolean r12 = r10.endsWith(GROUP_FILE_EXTENSION);
        boolean r13 = r10.endsWith(TEMPLATE_FILE_EXTENSION);
        if (r12 == true) goto L14;
        if (r13 == true) goto L14;
        boolean r14 = true;
    L15:
        URL r15 = getRootDirURL();
        URL r16 = new URL(r15 + "/" + r10);     // Catch: MalformedURLException -> L43
        if (r13 == false) goto L28;
        STGroup r17 = new STGroup(this.delimiterStartChar, this.delimiterStopChar);
        r17.setListener(getListener());
        if (Misc.urlExists(r16) == true) goto L22;
        r16 = getURL(r10);
    L22:
        if (r16 != null) goto L46;
    L38:
        r17 = null;
    L39:
        if (r17 != null) goto L41;
        this.errMgr.compileTimeError(ErrorType.CANT_IMPORT, null, r11, r10);
        return;
    L41:
        importTemplates(r17, true);
        return;
    L46:
        ANTLRInputStream r18 = new ANTLRInputStream(r16.openStream());     // Catch: IOException -> L26
        r18.name = r10;     // Catch: IOException -> L26
        if (r17.loadTemplateFile("/", r10, r18) != null) goto L39;
    L26:
        e = move-exception;
        this.errMgr.internalError(null, "can't read from " + r16, e);
        goto L38
    L28:
        if (r12 == true) goto L30;
        if (r14 == false) goto L38;
        if (Misc.urlExists(r16) == false) goto L37;
        r17 = new STGroupDir(r16, this.encoding, this.delimiterStartChar, this.delimiterStopChar);
        r17.setListener(getListener());
        goto L39
    L37:
        r17 = new STGroupDir(r10, this.delimiterStartChar, this.delimiterStopChar);
        r17.setListener(getListener());
        goto L39
    L30:
        if (Misc.urlExists(r16) == false) goto L32;
        r17 = new STGroupFile(r16, this.encoding, this.delimiterStartChar, this.delimiterStopChar);
        r17.setListener(getListener());
        goto L39
    L32:
        r17 = new STGroupFile(r10, this.delimiterStartChar, this.delimiterStopChar);
        r17.setListener(getListener());
    L43:
        e = move-exception;
        this.errMgr.internalError(null, "can't build URL for " + r15 + "/" + r10, e);
        return;
    L14:
        r14 = false;
        goto L15
    }

    public void load() {
    }

    public void registerRenderer(Class<?> r5, AttributeRenderer r10, boolean r11) {
        if (r5.isPrimitive() == true) goto L15;
        if (this.renderers != null) goto L7;
        this.renderers = Collections.synchronizedMap(new TypeRegistry());
    L7:
        this.renderers.put(r5, r10);
        if (r11 == false) goto L13;
        load();
        Iterator<STGroup> r12 = this.imports.iterator();
    L11:
        if (r12.hasNext() == false) goto L17;
        r12.next().registerRenderer(r5, r10, true);
        goto L11
    L17:
        return;
    L13:
        return;
    L15:
        throw new IllegalArgumentException("can't register renderer for primitive type ".concat(r5.getSimpleName()));
    }

    public ST createStringTemplateInternally(ST r5) {
        return new ST(r5);
    }

    public CompiledST defineTemplate(String r10, String r11, String r12) {
        int r5 = 0;
        if (r10.charAt(0) == '/') goto L5;
        r10 = "/".concat(r10);
    L5:
        String r13 = r10;
        String[] r14 = r11.split(",");
        ArrayList r15 = new ArrayList();
        int r16 = r14.length;
    L6:
        if (r5 >= r16) goto L9;
        r15.add(new FormalArgument(r14[r5]));
        r5 = r5 + 1;
        goto L6
    L9:
        return defineTemplate(r13, new CommonToken(9, r13), r15, r12, null);
    }

    public CompiledST defineTemplate(String r10, Token r11, List<FormalArgument> r12, String r13, Token r14) {
        if (verbose == false) goto L5;
        System.out.println("defineTemplate(" + r10 + ")");
    L5:
        if (r10 == null) goto L15;
        if (r10.length() == 0) goto L15;
        if (r10.indexOf(46) >= 0) goto L13;
        CompiledST r15 = compile(getFileName(), r10, r12, Misc.trimOneTrailingNewline(Misc.trimOneStartingNewline(r13)), r14);
        r15.name = r10;
        rawDefineTemplate(r10, r15, r11);
        r15.defineArgDefaultValueTemplates(this);
        r15.defineImplicitlyDefinedTemplates(this);
        return r15;
    L13:
        throw new IllegalArgumentException("cannot have '.' in template names");
    L15:
        throw new IllegalArgumentException("empty template name");
    }

    public STGroup(char r5, char r10) {
        this.encoding = "UTF-8";
        this.imports = Collections.synchronizedList(new ArrayList());
        this.importsToClearOnUnload = Collections.synchronizedList(new ArrayList());
        this.delimiterStartChar = Typography.less;
        this.delimiterStopChar = Typography.greater;
        this.templates = Collections.synchronizedMap(new LinkedHashMap());
        this.dictionaries = Collections.synchronizedMap(new HashMap());
        TypeRegistry r11 = new TypeRegistry();
        r11.put2(Object.class, new ObjectModelAdaptor());
        r11.put2(ST.class, new STModelAdaptor());
        r11.put2(Map.class, new MapModelAdaptor());
        r11.put2(Aggregate.class, new AggregateModelAdaptor());
        this.adaptors = Collections.synchronizedMap(r11);
        this.iterateAcrossValues = false;
        this.errMgr = DEFAULT_ERR_MGR;
        this.delimiterStartChar = r5;
        this.delimiterStopChar = r10;
    }

    public void importTemplates(STGroup r5, boolean r10) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.imports.add(r5);
        if (r10 == false) goto L8;
        this.importsToClearOnUnload.add(r5);
        return;
    }
}
