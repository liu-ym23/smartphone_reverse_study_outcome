package androidx.room.jarjarred.org.stringtemplate.v4;

import ai.j0;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.CompiledST;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.FormalArgument;
import androidx.room.jarjarred.org.stringtemplate.v4.debug.AddAttributeEvent;
import androidx.room.jarjarred.org.stringtemplate.v4.debug.ConstructionEvent;
import androidx.room.jarjarred.org.stringtemplate.v4.debug.EvalTemplateEvent;
import androidx.room.jarjarred.org.stringtemplate.v4.debug.InterpEvent;
import androidx.room.jarjarred.org.stringtemplate.v4.gui.STViz;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.Aggregate;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.ErrorBuffer;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.ErrorManager;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.MultiMap;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ST {
    public static final Object EMPTY_ATTR = null;
    public static final String IMPLICIT_ARG_NAME = "it";
    public static final String UNKNOWN_NAME = "anonymous";
    public static final String VERSION = "4.0.7-SNAPSHOT";
    public DebugState debugState;
    public STGroup groupThatCreatedThisInstance;
    public CompiledST impl;
    protected Object[] locals;

    public static final class AttributeList extends ArrayList<Object> {
        public AttributeList(int r5) {
            super(r5);
        }

        public AttributeList() {
        }
    }

    public static class DebugState {
        public MultiMap<String, AddAttributeEvent> addAttrEvents;
        public ConstructionEvent newSTEvent;

        public DebugState() {
            this.addAttrEvents = new MultiMap();
        }
    }

    public static final enum RegionType extends Enum<RegionType> {
        private static final /* synthetic */ RegionType[] $VALUES = null;
        public static final RegionType EMBEDDED = null;
        public static final RegionType EXPLICIT = null;
        public static final RegionType IMPLICIT = null;

        static {
            RegionType r5 = new RegionType("IMPLICIT", 0);
            IMPLICIT = r5;
            RegionType r10 = new RegionType("EMBEDDED", 1);
            EMBEDDED = r10;
            RegionType r11 = new RegionType("EXPLICIT", 2);
            EXPLICIT = r11;
            $VALUES = new RegionType[]{r5, r10, r11};
        }

        private RegionType(String r5, int r10) {
            super(r5, r10);
        }

        public static RegionType valueOf(String r5) {
            return (RegionType) Enum.valueOf(RegionType.class, r5);
        }

        public static RegionType[] values() {
            return (RegionType[]) $VALUES.clone();
        }
    }

    static {
        EMPTY_ATTR = new Object();
    }

    public ST() {
        if (STGroup.trackCreationEvents == true) goto L5;
        return;
    L5:
        if (this.debugState != null) goto L7;
        this.debugState = new DebugState();
    L7:
        DebugState r5 = this.debugState;
        r5.newSTEvent = new ConstructionEvent();
    }

    public static AttributeList convertToAttributeList(Object r5) {
        if (r5 != null) goto L5;
        AttributeList r10 = new AttributeList();
        r10.add(r5);
        return r10;
    L5:
        if ((r5 instanceof AttributeList) == false) goto L8;
        return (AttributeList) r5;
    L8:
        if ((r5 instanceof List) == false) goto L11;
        List r11 = (List) r5;
        AttributeList r12 = new AttributeList(r11.size());
        r12.addAll(r11);
        return r12;
    L11:
        if ((r5 instanceof Object[]) == false) goto L14;
        Object[] r13 = (Object[]) r5;
        AttributeList r14 = new AttributeList(r13.length);
        r14.addAll(Arrays.asList(r13));
        return r14;
    L14:
        if (r5.getClass().isArray() == false) goto L19;
        int r15 = Array.getLength(r5);
        AttributeList r16 = new AttributeList(r15);
        int r17 = 0;
    L16:
        if (r17 >= r15) goto L26;
        r16.add(Array.get(r5, r17));
        r17 = r17 + 1;
        goto L16
    L26:
        return r16;
    L19:
        AttributeList r18 = new AttributeList();
        r18.add(r5);
        return r18;
    }

    public static String format(String r5, Object... r10) {
        return format(-1, r5, r10);
    }

    public synchronized ST add(String r5, Object r10) {
        monitor-enter(this);
        if (r5 == null) goto L55;
        if (r5.indexOf(46) >= 0) goto L53;
        if (STGroup.trackCreationEvents == true) goto L11;
    L16:
        CompiledST r11 = this.impl;     // Catch: Throwable -> L13
        FormalArgument r12 = null;
        if (r11.hasFormalArgs == false) goto L25;
        Map<String, FormalArgument> r13 = r11.formalArguments;     // Catch: Throwable -> L13
        if (r13 == null) goto L21;
        r12 = r13.get(r5);     // Catch: Throwable -> L13
    L21:
        if (r12 == null) goto L24;
    L34:
        Object[] r14 = this.locals;     // Catch: Throwable -> L13
        int r15 = r12.index;     // Catch: Throwable -> L13
        Object r16 = r14[r15];     // Catch: Throwable -> L13
        if (r16 != EMPTY_ATTR) goto L39;
        r14[r15] = r10;     // Catch: Throwable -> L13
        monitor-exit(this);
        return this;
    L39:
        AttributeList r17 = convertToAttributeList(r16);     // Catch: Throwable -> L13
        this.locals[r12.index] = r17;     // Catch: Throwable -> L13
        if ((r10 instanceof List) == false) goto L42;
        r17.addAll((List) r10);     // Catch: Throwable -> L13
    L50:
        monitor-exit(this);
        return this;
    L42:
        if (r10 != null) goto L44;
    L49:
        r17.add(r10);     // Catch: Throwable -> L13
        goto L50
    L44:
        if (r10.getClass().isArray() == false) goto L49;
        if ((r10 instanceof Object[]) == false) goto L48;
        r17.addAll(Arrays.asList((Object[]) r10));     // Catch: Throwable -> L13
        goto L50
    L48:
        r17.addAll(convertToAttributeList(r10));     // Catch: Throwable -> L13
        goto L50
    L24:
        throw new IllegalArgumentException("no such attribute: ".concat(r5));     // Catch: Throwable -> L13
    L25:
        Map<String, FormalArgument> r18 = r11.formalArguments;     // Catch: Throwable -> L13
        if (r18 == null) goto L28;
        r12 = r18.get(r5);     // Catch: Throwable -> L13
    L28:
        if (r12 != null) goto L34;
        r12 = new FormalArgument(r5);     // Catch: Throwable -> L13
        this.impl.addArg(r12);     // Catch: Throwable -> L13
        if (this.locals != null) goto L32;
        this.locals = new Object[1];     // Catch: Throwable -> L13
    L33:
        this.locals[r12.index] = EMPTY_ATTR;     // Catch: Throwable -> L13
        goto L34
    L32:
        Object[] r19 = new Object[this.impl.formalArguments.size()];     // Catch: Throwable -> L13
        Object[] r20 = this.locals;     // Catch: Throwable -> L13
        System.arraycopy(r20, 0, r19, 0, Math.min(r20.length, this.impl.formalArguments.size()));     // Catch: Throwable -> L13
        this.locals = r19;     // Catch: Throwable -> L13
        goto L33
    L11:
        if (this.debugState != null) goto L15;
        this.debugState = new DebugState();     // Catch: Throwable -> L13
    L15:
        this.debugState.addAttrEvents.map(r5, new AddAttributeEvent(r5, r10));     // Catch: Throwable -> L13
        goto L16
    L53:
        throw new IllegalArgumentException("cannot have '.' in attribute names");     // Catch: Throwable -> L13
    L55:
        throw new NullPointerException("null attribute name");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized ST addAggr(String r10, Object... r11) {
        monitor-enter(this);
        int r5 = r10.indexOf(".{");     // Catch: Throwable -> L20
        if (r11 == null) goto L32;
        if (r11.length == 0) goto L32;
        int r12 = r10.indexOf(125);     // Catch: Throwable -> L20
        if (r5 < 0) goto L30;
        if (r12 < 0) goto L30;
        int r13 = 0;
        String r14 = r10.substring(0, r5);     // Catch: Throwable -> L20
        String[] r15 = r10.substring(r5 + 2, r10.length() - 1).trim().split("\\ *,\\ *");     // Catch: Throwable -> L20
        if (r15 == null) goto L28;
        if (r15.length == 0) goto L28;
        if (r11.length != r15.length) goto L26;
        Aggregate r16 = new Aggregate();     // Catch: Throwable -> L20
        int r17 = r15.length;     // Catch: Throwable -> L20
        int r18 = 0;
    L18:
        if (r13 >= r17) goto L22;
        int r19 = r18 + 1;     // Catch: Throwable -> L20
        r16.properties.put(r15[r13], r11[r18]);     // Catch: Throwable -> L20
        r13 = r13 + 1;     // Catch: Throwable -> L20
        r18 = r19;
        goto L18
    L22:
        add(r14, r16);     // Catch: Throwable -> L20
        monitor-exit(this);
        return this;
    L26:
        throw new IllegalArgumentException("number of properties and values mismatch for aggregate attribute format: ".concat(r10));     // Catch: Throwable -> L20
    L28:
        throw new IllegalArgumentException("invalid aggregate attribute format: ".concat(r10));     // Catch: Throwable -> L20
    L30:
        throw new IllegalArgumentException("invalid aggregate attribute format: ".concat(r10));     // Catch: Throwable -> L20
    L32:
        throw new IllegalArgumentException("missing values for aggregate attribute format: ".concat(r10));     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public Object getAttribute(String r5) {
        Map<String, FormalArgument> r10 = this.impl.formalArguments;
        if (r10 == null) goto L5;
        FormalArgument r11 = r10.get(r5);
    L6:
        if (r11 == null) goto L12;
        Object r12 = this.locals[r11.index];
        if (r12 != EMPTY_ATTR) goto L11;
        return null;
    L11:
        return r12;
    L12:
        return null;
    L5:
        r11 = null;
        goto L6
    }

    public Map<String, Object> getAttributes() {
        if (this.impl.formalArguments != null) goto L5;
        return null;
    L5:
        HashMap r5 = new HashMap();
        Iterator<FormalArgument> r10 = this.impl.formalArguments.values().iterator();
    L7:
        if (r10.hasNext() == false) goto L12;
        FormalArgument r11 = r10.next();
        Object r12 = this.locals[r11.index];
        if (r12 != EMPTY_ATTR) goto L11;
        r12 = null;
    L11:
        r5.put(r11.name, r12);
        goto L7
    L12:
        return r5;
    }

    public List<InterpEvent> getEvents() {
        return getEvents(Locale.getDefault());
    }

    public String getName() {
        return this.impl.name;
    }

    public STViz inspect() {
        return inspect(Locale.getDefault());
    }

    public boolean isAnonSubtemplate() {
        return this.impl.isAnonSubtemplate;
    }

    public void rawSetAttribute(String r5, Object r10) {
        Map<String, FormalArgument> r11 = this.impl.formalArguments;
        if (r11 == null) goto L11;
        FormalArgument r12 = r11.get(r5);
        if (r12 == null) goto L9;
        this.locals[r12.index] = r10;
        return;
    L9:
        throw new IllegalArgumentException(j0.C("no such attribute: ", r5));
    L11:
        throw new IllegalArgumentException(j0.C("no such attribute: ", r5));
    }

    public void remove(String r5) {
        CompiledST r10 = this.impl;
        Map<String, FormalArgument> r11 = r10.formalArguments;
        if (r11 == null) goto L5;
        FormalArgument r12 = r11.get(r5);
        if (r12 == null) goto L14;
        this.locals[r12.index] = EMPTY_ATTR;
        return;
    L14:
        throw new IllegalArgumentException(j0.C("no such attribute: ", r5));
    L5:
        if (r10.hasFormalArgs == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(j0.C("no such attribute: ", r5));
    }

    public String render() {
        return render(Locale.getDefault());
    }

    public String toString() {
        if (this.impl != null) goto L6;
        return "bad-template()";
    L6:
        String r5 = j0.q(new StringBuilder(), this.impl.name, "()");
        if (this.impl.isRegion == true) goto L9;
        return r5;
    L9:
        return "@" + STGroup.getUnMangledTemplateName(r5);
    }

    public int write(STWriter r5) throws IOException {
        return new Interpreter(this.groupThatCreatedThisInstance, this.impl.nativeGroup.errMgr, false).exec(r5, new InstanceScope(null, this));
    }

    public static String format(int r10, String r11, Object... r12) {
        ST r5 = new ST(r11.replaceAll("%([0-9]+)", "arg$1"));
        int r13 = r12.length;
        int r14 = 0;
        int r15 = 1;
    L3:
        if (r14 >= r13) goto L6;
        r5.add("arg" + r15, r12[r14]);
        r15 = r15 + 1;
        r14 = r14 + 1;
        goto L3
    L6:
        return r5.render(r10);
    }

    public List<InterpEvent> getEvents(int r5) {
        return getEvents(Locale.getDefault(), r5);
    }

    public STViz inspect(int r5) {
        return inspect(this.impl.nativeGroup.errMgr, Locale.getDefault(), r5);
    }

    public String render(int r5) {
        return render(Locale.getDefault(), r5);
    }

    public List<InterpEvent> getEvents(Locale r5) {
        return getEvents(r5, -1);
    }

    public STViz inspect(Locale r5) {
        return inspect(this.impl.nativeGroup.errMgr, r5, -1);
    }

    public String render(Locale r5) {
        return render(r5, -1);
    }

    public List<InterpEvent> getEvents(Locale r5, int r10) {
        AutoIndentWriter r11 = new AutoIndentWriter(new StringWriter());
        r11.setLineWidth(r10);
        Interpreter r12 = new Interpreter(this.groupThatCreatedThisInstance, r5, true);
        r12.exec(r11, new InstanceScope(null, this));
        return r12.getEvents();
    }

    public STViz inspect(ErrorManager r11, Locale r12, int r13) {
        ErrorBuffer r5 = new ErrorBuffer();
        this.impl.nativeGroup.setListener(r5);
        StringWriter r10 = new StringWriter();
        AutoIndentWriter r14 = new AutoIndentWriter(r10);
        r14.setLineWidth(r13);
        Interpreter r15 = new Interpreter(this.groupThatCreatedThisInstance, r12, true);
        r15.exec(r14, new InstanceScope(null, this));
        STViz r16 = new STViz(r11, (EvalTemplateEvent) j0.e(r15.getEvents(), 1), r10.toString(), r15, r15.getExecutionTrace(), r5.errors);
        r16.open();
        return r16;
    }

    public String render(Locale r5, int r10) {
        StringWriter r11 = new StringWriter();
        AutoIndentWriter r12 = new AutoIndentWriter(r11);
        r12.setLineWidth(r10);
        write(r12, r5);
        return r11.toString();
    }

    public int write(STWriter r5, Locale r10) {
        return new Interpreter(this.groupThatCreatedThisInstance, r10, this.impl.nativeGroup.errMgr, false).exec(r5, new InstanceScope(null, this));
    }

    public ST(String r5) {
        this(STGroup.defaultGroup, r5);
    }

    public ST(String r5, char r10, char r11) {
        this(new STGroup(r10, r11), r5);
    }

    public ST(STGroup r10, String r11) {
        this();
        this.groupThatCreatedThisInstance = r10;
        CompiledST r12 = r10.compile(r10.getFileName(), null, null, r11, null);
        this.impl = r12;
        r12.hasFormalArgs = false;
        r12.name = UNKNOWN_NAME;
        r12.defineImplicitlyDefinedTemplates(this.groupThatCreatedThisInstance);
    }

    public int write(STWriter r5, STErrorListener r10) {
        return new Interpreter(this.groupThatCreatedThisInstance, new ErrorManager(r10), false).exec(r5, new InstanceScope(null, this));
    }

    public int write(STWriter r5, Locale r10, STErrorListener r11) {
        return new Interpreter(this.groupThatCreatedThisInstance, r10, new ErrorManager(r11), false).exec(r5, new InstanceScope(null, this));
    }

    public ST(ST r5) {
        CompiledST r10 = r5.impl;
        this.impl = r10;
        Object[] r11 = r5.locals;
        if (r11 == null) goto L5;
        Object[] r12 = new Object[r11.length];
        this.locals = r12;
        Object[] r13 = r5.locals;
        System.arraycopy(r13, 0, r12, 0, r13.length);
    L10:
        this.groupThatCreatedThisInstance = r5.groupThatCreatedThisInstance;
        return;
    L5:
        Map<String, FormalArgument> r14 = r10.formalArguments;
        if (r14 == null) goto L10;
        if (r14.isEmpty() == true) goto L10;
        this.locals = new Object[this.impl.formalArguments.size()];
        goto L10
    }

    public int write(File r10, STErrorListener r11) throws IOException {
        return write(r10, r11, "UTF-8", Locale.getDefault(), -1);
    }

    public int write(File r10, STErrorListener r11, String r12) throws IOException {
        return write(r10, r11, r12, Locale.getDefault(), -1);
    }

    public int write(File r10, STErrorListener r11, String r12, int r13) throws IOException {
        return write(r10, r11, r12, Locale.getDefault(), r13);
    }

    public int write(File r5, STErrorListener r10, String r11, Locale r12, int r13) throws IOException {
        BufferedWriter r14 = null;
        BufferedWriter r15 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(r5), r11));     // Catch: Throwable -> L8
        AutoIndentWriter r16 = new AutoIndentWriter(r15);     // Catch: Throwable -> L6
        r16.setLineWidth(r13);     // Catch: Throwable -> L6
        int r17 = write(r16, r12, r10);     // Catch: Throwable -> L6
        r15.close();     // Catch: Throwable -> L6
        return r17;
    L6:
        th = th;
        r14 = r15;
    L9:
        if (r14 == null) goto L11;
        r14.close();
    L11:
        throw th;
    L8:
        th = th;
        goto L9
    }
}
