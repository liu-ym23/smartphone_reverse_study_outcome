package org.apache.logging.log4j.spi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LoggingException;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.message.DefaultFlowMessageFactory;
import org.apache.logging.log4j.message.EntryMessage;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.message.ParameterizedMessageFactory;
import org.apache.logging.log4j.message.ReusableMessageFactory;
import org.apache.logging.log4j.message.SimpleMessage;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.apache.logging.log4j.status.StatusLogger;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.apache.logging.log4j.util.s;
import org.apache.logging.log4j.util.t;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractLogger implements Serializable, c, e {
    private static final String CATCHING = "Catching";
    public static final Marker CATCHING_MARKER = null;
    public static final Class<? extends org.apache.logging.log4j.message.c> DEFAULT_FLOW_MESSAGE_FACTORY_CLASS = null;
    public static final Class<? extends org.apache.logging.log4j.message.d> DEFAULT_MESSAGE_FACTORY_CLASS = null;
    public static final Marker ENTRY_MARKER = null;
    public static final Marker EXCEPTION_MARKER = null;
    public static final Marker EXIT_MARKER = null;
    public static final Marker FLOW_MARKER = null;
    private static final String FQCN = null;
    private static final String THROWING = "Throwing";
    public static final Marker THROWING_MARKER = null;
    private static final ThreadLocal<int[]> recursionDepthHolder = null;
    private static final long serialVersionUID = 2;
    private final org.apache.logging.log4j.message.c flowMessageFactory;
    protected final transient ThreadLocal<org.apache.logging.log4j.a.a> logBuilder;
    private final org.apache.logging.log4j.message.e messageFactory;
    protected final String name;

    private class a extends ThreadLocal<org.apache.logging.log4j.a.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractLogger f17894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private AbstractLogger f17895b;

        a(AbstractLogger r1, AbstractLogger r2) {
            this.f17894a = r1;
            this.f17895b = r2;
        }

        public org.apache.logging.log4j.a.a a() {
            return new org.apache.logging.log4j.a.a(this.f17895b);
        }

        @Override // java.lang.ThreadLocal
        public /* synthetic */ org.apache.logging.log4j.a.a initialValue() {
            return a();
        }
    }

    static {
        Marker r0 = MarkerManager.a("FLOW");
        FLOW_MARKER = r0;
        ENTRY_MARKER = MarkerManager.a("ENTER").setParents(new Marker[]{r0});
        EXIT_MARKER = MarkerManager.a("EXIT").setParents(new Marker[]{r0});
        Marker r1 = MarkerManager.a("EXCEPTION");
        EXCEPTION_MARKER = r1;
        THROWING_MARKER = MarkerManager.a("THROWING").setParents(new Marker[]{r1});
        CATCHING_MARKER = MarkerManager.a("CATCHING").setParents(new Marker[]{r1});
        DEFAULT_MESSAGE_FACTORY_CLASS = createClassForProperty("log4j2.messageFactory", ReusableMessageFactory.class, ParameterizedMessageFactory.class);
        DEFAULT_FLOW_MESSAGE_FACTORY_CLASS = createFlowClassForProperty("log4j2.flowMessageFactory", DefaultFlowMessageFactory.class);
        FQCN = AbstractLogger.class.getName();
        recursionDepthHolder = new ThreadLocal();
    }

    public AbstractLogger() {
        this.name = getClass().getName();
        this.messageFactory = createDefaultMessageFactory();
        this.flowMessageFactory = createDefaultFlowMessageFactory();
        this.logBuilder = new a(this, this);
    }

    public AbstractLogger(String r2) {
        this(r2, createDefaultMessageFactory());
    }

    public AbstractLogger(String r3, org.apache.logging.log4j.message.d r4) {
        org.apache.logging.log4j.message.d r5 = (org.apache.logging.log4j.message.d) ZeusTransformUtils.wrapperContextForParams(r4, org.apache.logging.log4j.message.d.class, "com.obric.memorydata.plugin");
        this.name = r3;
        if (r5 != null) goto L5;
        org.apache.logging.log4j.message.e r6 = createDefaultMessageFactory();
    L6:
        this.messageFactory = r6;
        this.flowMessageFactory = createDefaultFlowMessageFactory();
        this.logBuilder = new a(this, this);
        return;
    L5:
        r6 = narrow(r5);
        goto L6
    }

    public static void checkMessageFactory(c r3, org.apache.logging.log4j.message.d r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        org.apache.logging.log4j.message.d r6 = (org.apache.logging.log4j.message.d) ZeusTransformUtils.wrapperContextForParams(r4, org.apache.logging.log4j.message.d.class, "com.obric.memorydata.plugin");
        String r0 = r5.getName();
        org.apache.logging.log4j.message.d r7 = r5.getMessageFactory();
        if (r6 != null) goto L5;
    L7:
        if (r6 != null) goto L13;
        Class<?> r8 = r7.getClass();
        Class<? extends org.apache.logging.log4j.message.d> r1 = DEFAULT_MESSAGE_FACTORY_CLASS;
        if (r8.equals(r1) == true) goto L14;
        StatusLogger.getLogger().warn("The Logger {} was created with the message factory {} and is now requested with a null message factory (defaults to {}), which may create log events with unexpected formatting.", r0, r7, r1.getName());
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (r7.equals(r6) == true) goto L7;
        StatusLogger.getLogger().warn("The Logger {} was created with the message factory {} and is now requested with the message factory {}, which may create log events with unexpected formatting.", r0, r7, r6);
    }

    private static Class<? extends org.apache.logging.log4j.message.d> createClassForProperty(String r1, Class<ReusableMessageFactory> r2, Class<ParameterizedMessageFactory> r3) {
    L8:
        return r3;
    L3:
        if (org.apache.logging.log4j.util.c.f17920b == false) goto L5;
        String r4 = r2.getName();     // Catch: Throwable -> L8
    L6:
        return org.apache.logging.log4j.util.g.a(PropertiesUtil.a().a(r1, r4)).asSubclass(org.apache.logging.log4j.message.d.class);
    L5:
        r4 = r3.getName();     // Catch: Throwable -> L8
        goto L6
    }

    private static org.apache.logging.log4j.message.c createDefaultFlowMessageFactory() {
        return (org.apache.logging.log4j.message.c) ZeusTransformUtils.preCheckCast(DEFAULT_FLOW_MESSAGE_FACTORY_CLASS.newInstance(), org.apache.logging.log4j.message.c.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    private static org.apache.logging.log4j.message.e createDefaultMessageFactory() {
        return narrow((org.apache.logging.log4j.message.d) ZeusTransformUtils.preCheckCast(DEFAULT_MESSAGE_FACTORY_CLASS.newInstance(), org.apache.logging.log4j.message.d.class, "com.obric.memorydata.plugin"));
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    private static Class<? extends org.apache.logging.log4j.message.c> createFlowClassForProperty(String r2, Class<DefaultFlowMessageFactory> r3) {
        return org.apache.logging.log4j.util.g.a(PropertiesUtil.a().a(r2, r3.getName())).asSubclass(org.apache.logging.log4j.message.c.class);
    L4:
        return r3;
    }

    private static void decrementRecursionDepth() {
        int[] r0 = getRecursionDepthHolder();
        int r2 = r0[0] - 1;
        r0[0] = r2;
        if (r2 < 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("Recursion depth became negative: " + r2);
    }

    private StackTraceElement getLocation(String r1) {
        if (requiresLocation() == true) goto L7;
        return null;
    L7:
        return org.apache.logging.log4j.util.p.a(r1);
    }

    private org.apache.logging.log4j.a.a getLogBuilder(Level r4) {
        org.apache.logging.log4j.a.a r0 = (org.apache.logging.log4j.a.a) ZeusTransformUtils.preCheckCast(this.logBuilder.get(), org.apache.logging.log4j.a.a.class, "com.obric.memorydata.plugin");
        if (org.apache.logging.log4j.util.c.f17920b == false) goto L8;
        if (r0.a() == true) goto L8;
        return r0;
    L8:
        return new org.apache.logging.log4j.a.a(this, r4);
    }

    public static int getRecursionDepth() {
        return getRecursionDepthHolder()[0];
    }

    private static int[] getRecursionDepthHolder() {
        ThreadLocal<int[]> r0 = recursionDepthHolder;
        int[] r1 = (int[]) ZeusTransformUtils.preCheckCast(r0.get(), int[].class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        int[] r2 = new int[1];
        r0.set(r2);
        return r2;
    L6:
        return r1;
    }

    private void handleLogMessageException(Throwable r9, String r10, Message r11) {
        Message r8 = (Message) ZeusTransformUtils.wrapperContextForParams(r11, Message.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, LoggingException.class) == true) goto L7;
        StatusLogger.getLogger().warn("{} caught {} logging {}: {}", r10, r9.getClass().getName(), r8.getClass().getSimpleName(), r8.getFormat(), r9);
        return;
    L7:
        throw ((LoggingException) ZeusTransformUtils.preCheckCast(r9, LoggingException.class, "com.obric.memorydata.plugin"));
    }

    private static void incrementRecursionDepth() {
        int[] r0 = getRecursionDepthHolder();
        r0[0] = r0[0] + 1;
    }

    private void logMessageSafely(String r9, Level r10, Marker r11, Message r12, Throwable r13) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r11, Marker.class, "com.obric.memorydata.plugin");
        Message r14 = (Message) ZeusTransformUtils.wrapperContextForParams(r12, Message.class, "com.obric.memorydata.plugin");
        logMessageTrackRecursion(r9, r10, r5, r14, r13);     // Catch: Throwable -> L6
        ReusableMessageFactory.release(r14);
        return;
    L6:
        th = move-exception;
        ReusableMessageFactory.release(r14);
        throw th;
    }

    private void logMessageTrackRecursion(String r10, Level r11, Marker r12, Message r13, Throwable r14) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r12, Marker.class, "com.obric.memorydata.plugin");
        Message r7 = (Message) ZeusTransformUtils.wrapperContextForParams(r13, Message.class, "com.obric.memorydata.plugin");
        incrementRecursionDepth();     // Catch: Throwable -> L6
        tryLogMessage(r10, getLocation(r10), r11, r6, r7, r14);     // Catch: Throwable -> L6
        decrementRecursionDepth();
        return;
    L6:
        th = move-exception;
        decrementRecursionDepth();
        throw th;
    }

    private static org.apache.logging.log4j.message.e narrow(org.apache.logging.log4j.message.d r2) {
        org.apache.logging.log4j.message.d r3 = (org.apache.logging.log4j.message.d) ZeusTransformUtils.wrapperContextForParams(r2, org.apache.logging.log4j.message.d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, org.apache.logging.log4j.message.e.class) == false) goto L7;
        return (org.apache.logging.log4j.message.e) ZeusTransformUtils.preCheckCast(r3, org.apache.logging.log4j.message.e.class, "com.obric.memorydata.plugin");
    L7:
        return new i(r3);
    }

    private void readObject(ObjectInputStream r2) {
        r2.defaultReadObject();
        Field r3 = getClass().getDeclaredField("logBuilder");     // Catch: Throwable -> L5
        r3.setAccessible(true);     // Catch: Throwable -> L5
        r3.set(this, new a(this, this));     // Catch: Throwable -> L5
        return;
    L5:
        StatusLogger.getLogger().warn("Unable to initialize LogBuilder");
    }

    private void tryLogMessage(String r10, StackTraceElement r11, Level r12, Marker r13, Message r14, Throwable r15) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r13, Marker.class, "com.obric.memorydata.plugin");
        Message r16 = (Message) ZeusTransformUtils.wrapperContextForParams(r14, Message.class, "com.obric.memorydata.plugin");
        log(r12, r4, r10, r11, r16, r15);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        handleLogMessageException(th, r10, r16);
    }

    public org.apache.logging.log4j.a always() {
        org.apache.logging.log4j.a.a r0 = (org.apache.logging.log4j.a.a) ZeusTransformUtils.preCheckCast(this.logBuilder.get(), org.apache.logging.log4j.a.a.class, "com.obric.memorydata.plugin");
        if (r0.a() == false) goto L7;
        return new org.apache.logging.log4j.a.a(this);
    L7:
        return r0.a(Level.OFF);
    }

    @Override // org.apache.logging.log4j.c
    public org.apache.logging.log4j.a atDebug() {
        return atLevel(Level.DEBUG);
    }

    @Override // org.apache.logging.log4j.c
    public org.apache.logging.log4j.a atError() {
        return atLevel(Level.ERROR);
    }

    public org.apache.logging.log4j.a atFatal() {
        return atLevel(Level.FATAL);
    }

    @Override // org.apache.logging.log4j.c
    public org.apache.logging.log4j.a atInfo() {
        return atLevel(Level.INFO);
    }

    @Override // org.apache.logging.log4j.c
    public org.apache.logging.log4j.a atLevel(Level r2) {
        if (isEnabled(r2) == false) goto L7;
        return getLogBuilder(r2).a(r2);
    L7:
        return org.apache.logging.log4j.a.f17883a;
    }

    @Override // org.apache.logging.log4j.c
    public org.apache.logging.log4j.a atTrace() {
        return atLevel(Level.TRACE);
    }

    @Override // org.apache.logging.log4j.c
    public org.apache.logging.log4j.a atWarn() {
        return atLevel(Level.WARN);
    }

    public void catching(String r7, Level r8, Throwable r9) {
        Marker r3 = CATCHING_MARKER;
        if (isEnabled(r8, r3, null, null) == false) goto L6;
        logMessageSafely(r7, r8, r3, catchingMsg(r9), r9);
        return;
    }

    public void catching(Throwable r8) {
        Level r0 = Level.ERROR;
        Marker r4 = CATCHING_MARKER;
        if (isEnabled(r0, r4, null, null) == false) goto L6;
        logMessageSafely(FQCN, Level.ERROR, r4, catchingMsg(r8), r8);
        return;
    }

    public void catching(Level r2, Throwable r3) {
        catching(FQCN, r2, r3);
    }

    public Message catchingMsg(Throwable r1) {
        return this.messageFactory.newMessage(CATCHING);
    }

    public void debug(CharSequence r7) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, null, r4, null);
    }

    public void debug(CharSequence r7, Throwable r8) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, null, r4, r8);
    }

    public void debug(Object r7) {
        logIfEnabled(FQCN, Level.DEBUG, null, r7, null);
    }

    public void debug(Object r7, Throwable r8) {
        logIfEnabled(FQCN, Level.DEBUG, null, r7, r8);
    }

    public void debug(String r7) {
        logIfEnabled(FQCN, Level.DEBUG, null, r7, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.logging.log4j.c
    public void debug(String r7, Object r8) {
        logIfEnabled(FQCN, Level.DEBUG, null, r7, r8);
    }

    public void debug(String r8, Object r9, Object r10) {
        logIfEnabled(FQCN, Level.DEBUG, null, r8, r9, r10);
    }

    public void debug(String r9, Object r10, Object r11, Object r12) {
        logIfEnabled(FQCN, Level.DEBUG, null, r9, r10, r11, r12);
    }

    public void debug(String r10, Object r11, Object r12, Object r13, Object r14) {
        logIfEnabled(FQCN, Level.DEBUG, null, r10, r11, r12, r13, r14);
    }

    public void debug(String r11, Object r12, Object r13, Object r14, Object r15, Object r16) {
        logIfEnabled(FQCN, Level.DEBUG, null, r11, r12, r13, r14, r15, r16);
    }

    public void debug(String r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18) {
        logIfEnabled(FQCN, Level.DEBUG, null, r12, r13, r14, r15, r16, r17, r18);
    }

    public void debug(String r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20) {
        logIfEnabled(FQCN, Level.DEBUG, null, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public void debug(String r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22) {
        logIfEnabled(FQCN, Level.DEBUG, null, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public void debug(String r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24) {
        logIfEnabled(FQCN, Level.DEBUG, null, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public void debug(String r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26) {
        logIfEnabled(FQCN, Level.DEBUG, null, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public void debug(String r7, Throwable r8) {
        logIfEnabled(FQCN, Level.DEBUG, null, r7, r8);
    }

    public void debug(String r7, Object... r8) {
        logIfEnabled(FQCN, Level.DEBUG, null, r7, r8);
    }

    public void debug(String r7, t<?>... r8) {
        logIfEnabled(FQCN, Level.DEBUG, null, r7, r8);
    }

    public void debug(Marker r9, CharSequence r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, r5, r6, null);
    }

    public void debug(Marker r9, CharSequence r10, Throwable r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, r5, r6, r11);
    }

    public void debug(Marker r7, Object r8) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, r3, r8, null);
    }

    public void debug(Marker r7, Object r8, Throwable r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, r3, r8, r9);
    }

    public void debug(Marker r9, String r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, r5, r10, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void debug(Marker r7, String r8, Object r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, r3, r8, r9);
    }

    public void debug(Marker r8, String r9, Object r10, Object r11) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r8, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, r3, r9, r10, r11);
    }

    public void debug(Marker r9, String r10, Object r11, Object r12, Object r13) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, r3, r10, r11, r12, r13);
    }

    public void debug(Marker r10, String r11, Object r12, Object r13, Object r14, Object r15) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r10, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, r3, r11, r12, r13, r14, r15);
    }

    public void debug(Marker r12, String r13, Object r14, Object r15, Object r16, Object r17, Object r18) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r12, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, r4, r13, r14, r15, r16, r17, r18);
    }

    public void debug(Marker r13, String r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r13, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, r4, r14, r15, r16, r17, r18, r19, r20);
    }

    public void debug(Marker r14, String r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r14, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, r4, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public void debug(Marker r15, String r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r15, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, r4, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public void debug(Marker r16, String r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r16, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, r4, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public void debug(Marker r17, String r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26, Object r27, Object r28) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r17, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, r4, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    }

    public void debug(Marker r7, String r8, Throwable r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, r3, r8, r9);
    }

    public void debug(Marker r7, String r8, Object... r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, r3, r8, r9);
    }

    public void debug(Marker r7, String r8, t<?>... r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, r3, r8, r9);
    }

    public void debug(Marker r9, Message r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        Message r6 = (Message) ZeusTransformUtils.wrapperContextForParams(r10, Message.class, "com.obric.memorydata.plugin");
        String r3 = FQCN;
        Level r4 = Level.DEBUG;
        if (r6 == null) goto L5;
        Throwable r11 = r6.getThrowable();
    L6:
        logIfEnabled(r3, r4, r5, r6, r11);
        return;
    L5:
        r11 = null;
        goto L6
    }

    public void debug(Marker r9, Message r10, Throwable r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        Message r6 = (Message) ZeusTransformUtils.wrapperContextForParams(r10, Message.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, r5, r6, r11);
    }

    public void debug(Marker r9, org.apache.logging.log4j.util.i r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        org.apache.logging.log4j.util.i r6 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r10, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, r5, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void debug(Marker r9, org.apache.logging.log4j.util.i r10, Throwable r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        org.apache.logging.log4j.util.i r6 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r10, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, r5, r6, r11);
    }

    public void debug(Marker r9, t<?> r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        t<?> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r10, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, r5, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void debug(Marker r9, t<?> r10, Throwable r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        t<?> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r10, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, r5, r6, r11);
    }

    public void debug(Message r7) {
        Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r7, Message.class, "com.obric.memorydata.plugin");
        String r1 = FQCN;
        Level r2 = Level.DEBUG;
        if (r4 == null) goto L5;
        Throwable r8 = r4.getThrowable();
    L6:
        logIfEnabled(r1, r2, null, r4, r8);
        return;
    L5:
        r8 = null;
        goto L6
    }

    public void debug(Message r7, Throwable r8) {
        Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r7, Message.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, null, r4, r8);
    }

    public void debug(org.apache.logging.log4j.util.i r9) {
        org.apache.logging.log4j.util.i r6 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r9, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, null, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void debug(org.apache.logging.log4j.util.i r7, Throwable r8) {
        org.apache.logging.log4j.util.i r4 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r7, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, null, r4, r8);
    }

    public void debug(t<?> r9) {
        t<?> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r9, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, null, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void debug(t<?> r7, Throwable r8) {
        t<?> r4 = (t) ZeusTransformUtils.wrapperContextForParams(r7, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.DEBUG, null, r4, r8);
    }

    public EntryMessage enter(String r8, String r9, Object... r10) {
        Level r0 = Level.TRACE;
        Marker r4 = ENTRY_MARKER;
        if (isEnabled(r0, r4, null, null) == false) goto L6;
        Level r3 = Level.TRACE;
        EntryMessage r11 = entryMsg(r9, r10);
        logMessageSafely(r8, r3, r4, r11, null);
        return r11;
    L6:
        return null;
    }

    @Deprecated
    public EntryMessage enter(String r8, String r9, org.apache.logging.log4j.util.i... r10) {
        Level r0 = Level.TRACE;
        Marker r4 = ENTRY_MARKER;
        if (isEnabled(r0, r4, null, null) == false) goto L6;
        Level r3 = Level.TRACE;
        EntryMessage r11 = entryMsg(r9, r10);
        logMessageSafely(r8, r3, r4, r11, null);
        return r11;
    L6:
        return null;
    }

    public EntryMessage enter(String r8, String r9, t<?>... r10) {
        Level r0 = Level.TRACE;
        Marker r4 = ENTRY_MARKER;
        if (isEnabled(r0, r4, null, null) == false) goto L6;
        Level r3 = Level.TRACE;
        EntryMessage r11 = entryMsg(r9, r10);
        logMessageSafely(r8, r3, r4, r11, null);
        return r11;
    L6:
        return null;
    }

    public EntryMessage enter(String r8, Message r9) {
        Message r10 = (Message) ZeusTransformUtils.wrapperContextForParams(r9, Message.class, "com.obric.memorydata.plugin");
        Level r0 = Level.TRACE;
        Marker r4 = ENTRY_MARKER;
        if (isEnabled(r0, r4, null, null) == false) goto L6;
        Level r3 = Level.TRACE;
        EntryMessage r11 = this.flowMessageFactory.newEntryMessage(r10);
        logMessageSafely(r8, r3, r4, r11, null);
        return r11;
    L6:
        return null;
    }

    @Deprecated
    public EntryMessage enter(String r8, org.apache.logging.log4j.util.i r9) {
        org.apache.logging.log4j.util.i r10 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r9, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        Level r0 = Level.TRACE;
        Marker r4 = ENTRY_MARKER;
        if (isEnabled(r0, r4, null, null) == false) goto L6;
        Level r3 = Level.TRACE;
        EntryMessage r11 = this.flowMessageFactory.newEntryMessage(r10.a());
        logMessageSafely(r8, r3, r4, r11, null);
        return r11;
    L6:
        return null;
    }

    @Deprecated
    public void entry() {
        entry(FQCN, (Object[]) ZeusTransformUtils.preCheckCast(null, Object[].class, "com.obric.memorydata.plugin"));
    }

    public void entry(String r8, Object... r9) {
        Level r0 = Level.TRACE;
        Marker r4 = ENTRY_MARKER;
        if (isEnabled(r0, r4, null, null) == false) goto L10;
        Level r3 = Level.TRACE;
        if (r9 != null) goto L7;
        EntryMessage r5 = entryMsg(null, (t[]) ZeusTransformUtils.preCheckCast(null, t[].class, "com.obric.memorydata.plugin"));
    L8:
        logMessageSafely(r8, r3, r4, r5, null);
        return;
    L7:
        r5 = entryMsg(null, r9);
        goto L8
    }

    public void entry(Object... r2) {
        entry(FQCN, r2);
    }

    public EntryMessage entryMsg(String r6, Object... r7) {
        int r0 = 0;
        if (r7 != null) goto L5;
        int r1 = 0;
    L6:
        if (r1 != 0) goto L13;
        boolean r8 = s.a(r6);
        org.apache.logging.log4j.message.c r5 = this.flowMessageFactory;
        if (r8 == false) goto L12;
        return r5.newEntryMessage(null);
    L12:
        return r5.newEntryMessage(new SimpleMessage(r6));
    L13:
        if (r6 != null) goto L15;
        StringBuilder r9 = new StringBuilder();
        r9.append("params(");
    L17:
        if (r0 >= r1) goto L25;
        if (r0 <= 0) goto L20;
        r9.append(", ");
    L20:
        Object r2 = r7[r0];
        if (ZeusTransformUtils.instanceOf(r2, Message.class) == false) goto L23;
        String r3 = ((Message) ZeusTransformUtils.preCheckCast(r2, Message.class, "com.obric.memorydata.plugin")).getFormattedMessage();
    L24:
        r9.append(r3);
        r0 = r0 + 1;
        goto L17
    L23:
        r3 = String.valueOf(r2);
        goto L24
    L25:
        r9.append(')');
        return this.flowMessageFactory.newEntryMessage(new SimpleMessage(r9));
    L15:
        return this.flowMessageFactory.newEntryMessage(new ParameterizedMessage(r6, r7));
    L5:
        r1 = r7.length;
        goto L6
    }

    public EntryMessage entryMsg(String r7, org.apache.logging.log4j.util.i... r8) {
        int r0 = 0;
        if (r8 != null) goto L5;
        int r1 = 0;
    L6:
        Object[] r2 = new Object[r1];
    L7:
        if (r0 >= r1) goto L14;
        r2[r0] = r8[r0].a();
        if (r2[r0] == null) goto L11;
        String r3 = ((Message) ZeusTransformUtils.preCheckCast(r2[r0], Message.class, "com.obric.memorydata.plugin")).getFormattedMessage();
    L12:
        r2[r0] = r3;
        r0 = r0 + 1;
        goto L7
    L11:
        r3 = null;
        goto L12
    L14:
        return entryMsg(r7, r2);
    L5:
        r1 = r8.length;
        goto L6
    }

    public EntryMessage entryMsg(String r7, t<?>... r8) {
        int r0 = 0;
        if (r8 != null) goto L5;
        int r1 = 0;
    L6:
        Object[] r2 = new Object[r1];
    L7:
        if (r0 >= r1) goto L13;
        r2[r0] = r8[r0].get();
        if (ZeusTransformUtils.instanceOf(r2[r0], Message.class) == false) goto L11;
        r2[r0] = ((Message) ZeusTransformUtils.preCheckCast(r2[r0], Message.class, "com.obric.memorydata.plugin")).getFormattedMessage();
    L11:
        r0 = r0 + 1;
        goto L7
    L13:
        return entryMsg(r7, r2);
    L5:
        r1 = r8.length;
        goto L6
    }

    public void error(CharSequence r7) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, null, r4, null);
    }

    public void error(CharSequence r7, Throwable r8) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, null, r4, r8);
    }

    public void error(Object r7) {
        logIfEnabled(FQCN, Level.ERROR, null, r7, null);
    }

    public void error(Object r7, Throwable r8) {
        logIfEnabled(FQCN, Level.ERROR, null, r7, r8);
    }

    @Override // org.apache.logging.log4j.c
    public void error(String r7) {
        logIfEnabled(FQCN, Level.ERROR, null, r7, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.logging.log4j.c
    public void error(String r7, Object r8) {
        logIfEnabled(FQCN, Level.ERROR, null, r7, r8);
    }

    @Override // org.apache.logging.log4j.c
    public void error(String r8, Object r9, Object r10) {
        logIfEnabled(FQCN, Level.ERROR, null, r8, r9, r10);
    }

    @Override // org.apache.logging.log4j.c
    public void error(String r9, Object r10, Object r11, Object r12) {
        logIfEnabled(FQCN, Level.ERROR, null, r9, r10, r11, r12);
    }

    public void error(String r10, Object r11, Object r12, Object r13, Object r14) {
        logIfEnabled(FQCN, Level.ERROR, null, r10, r11, r12, r13, r14);
    }

    public void error(String r11, Object r12, Object r13, Object r14, Object r15, Object r16) {
        logIfEnabled(FQCN, Level.ERROR, null, r11, r12, r13, r14, r15, r16);
    }

    public void error(String r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18) {
        logIfEnabled(FQCN, Level.ERROR, null, r12, r13, r14, r15, r16, r17, r18);
    }

    public void error(String r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20) {
        logIfEnabled(FQCN, Level.ERROR, null, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public void error(String r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22) {
        logIfEnabled(FQCN, Level.ERROR, null, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public void error(String r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24) {
        logIfEnabled(FQCN, Level.ERROR, null, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public void error(String r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26) {
        logIfEnabled(FQCN, Level.ERROR, null, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    @Override // org.apache.logging.log4j.c
    public void error(String r7, Throwable r8) {
        logIfEnabled(FQCN, Level.ERROR, null, r7, r8);
    }

    public void error(String r7, Object... r8) {
        logIfEnabled(FQCN, Level.ERROR, null, r7, r8);
    }

    public void error(String r7, t<?>... r8) {
        logIfEnabled(FQCN, Level.ERROR, null, r7, r8);
    }

    public void error(Marker r9, CharSequence r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, r5, r6, null);
    }

    public void error(Marker r9, CharSequence r10, Throwable r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, r5, r6, r11);
    }

    public void error(Marker r7, Object r8) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, r3, r8, null);
    }

    public void error(Marker r7, Object r8, Throwable r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, r3, r8, r9);
    }

    public void error(Marker r9, String r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, r5, r10, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void error(Marker r7, String r8, Object r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, r3, r8, r9);
    }

    public void error(Marker r8, String r9, Object r10, Object r11) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r8, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, r3, r9, r10, r11);
    }

    public void error(Marker r9, String r10, Object r11, Object r12, Object r13) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, r3, r10, r11, r12, r13);
    }

    public void error(Marker r10, String r11, Object r12, Object r13, Object r14, Object r15) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r10, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, r3, r11, r12, r13, r14, r15);
    }

    public void error(Marker r12, String r13, Object r14, Object r15, Object r16, Object r17, Object r18) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r12, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, r4, r13, r14, r15, r16, r17, r18);
    }

    public void error(Marker r13, String r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r13, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, r4, r14, r15, r16, r17, r18, r19, r20);
    }

    public void error(Marker r14, String r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r14, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, r4, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public void error(Marker r15, String r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r15, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, r4, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public void error(Marker r16, String r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r16, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, r4, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public void error(Marker r17, String r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26, Object r27, Object r28) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r17, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, r4, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    }

    public void error(Marker r7, String r8, Throwable r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, r3, r8, r9);
    }

    public void error(Marker r7, String r8, Object... r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, r3, r8, r9);
    }

    public void error(Marker r7, String r8, t<?>... r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, r3, r8, r9);
    }

    public void error(Marker r9, Message r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        Message r6 = (Message) ZeusTransformUtils.wrapperContextForParams(r10, Message.class, "com.obric.memorydata.plugin");
        String r3 = FQCN;
        Level r4 = Level.ERROR;
        if (r6 == null) goto L5;
        Throwable r11 = r6.getThrowable();
    L6:
        logIfEnabled(r3, r4, r5, r6, r11);
        return;
    L5:
        r11 = null;
        goto L6
    }

    public void error(Marker r9, Message r10, Throwable r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        Message r6 = (Message) ZeusTransformUtils.wrapperContextForParams(r10, Message.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, r5, r6, r11);
    }

    public void error(Marker r9, org.apache.logging.log4j.util.i r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        org.apache.logging.log4j.util.i r6 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r10, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, r5, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void error(Marker r9, org.apache.logging.log4j.util.i r10, Throwable r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        org.apache.logging.log4j.util.i r6 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r10, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, r5, r6, r11);
    }

    public void error(Marker r9, t<?> r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        t<?> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r10, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, r5, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void error(Marker r9, t<?> r10, Throwable r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        t<?> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r10, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, r5, r6, r11);
    }

    public void error(Message r7) {
        Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r7, Message.class, "com.obric.memorydata.plugin");
        String r1 = FQCN;
        Level r2 = Level.ERROR;
        if (r4 == null) goto L5;
        Throwable r8 = r4.getThrowable();
    L6:
        logIfEnabled(r1, r2, null, r4, r8);
        return;
    L5:
        r8 = null;
        goto L6
    }

    public void error(Message r7, Throwable r8) {
        Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r7, Message.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, null, r4, r8);
    }

    public void error(org.apache.logging.log4j.util.i r9) {
        org.apache.logging.log4j.util.i r6 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r9, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, null, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void error(org.apache.logging.log4j.util.i r7, Throwable r8) {
        org.apache.logging.log4j.util.i r4 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r7, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, null, r4, r8);
    }

    public void error(t<?> r9) {
        t<?> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r9, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, null, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void error(t<?> r7, Throwable r8) {
        t<?> r4 = (t) ZeusTransformUtils.wrapperContextForParams(r7, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.ERROR, null, r4, r8);
    }

    @Deprecated
    public <R> R exit(R r2) {
        return (R) exit(FQCN, r2);
    }

    public <R> R exit(String r8, R r9) {
        Level r0 = Level.TRACE;
        Marker r4 = EXIT_MARKER;
        if (isEnabled(r0, r4, (CharSequence) ZeusTransformUtils.preCheckCast(null, CharSequence.class, "com.obric.memorydata.plugin"), null) == false) goto L5;
        logMessageSafely(r8, Level.TRACE, r4, exitMsg(null, r9), null);
    L5:
        return r9;
    }

    public <R> R exit(String r8, String r9, R r10) {
        Level r0 = Level.TRACE;
        Marker r4 = EXIT_MARKER;
        if (isEnabled(r0, r4, (CharSequence) ZeusTransformUtils.preCheckCast(null, CharSequence.class, "com.obric.memorydata.plugin"), null) == false) goto L5;
        logMessageSafely(r8, Level.TRACE, r4, exitMsg(r9, r10), null);
    L5:
        return r10;
    }

    @Deprecated
    public void exit() {
        exit(FQCN, null);
    }

    public Message exitMsg(String r3, Object r4) {
        org.apache.logging.log4j.message.e r2 = this.messageFactory;
        if (r4 != null) goto L9;
        if (r3 != null) goto L8;
        return r2.newMessage("Exit");
    L8:
        return r2.newMessage("Exit: " + r3);
    L9:
        if (r3 != null) goto L13;
        return r2.newMessage("Exit with(" + r4 + ')');
    L13:
        return r2.newMessage("Exit: " + r3, r4);
    }

    public void fatal(CharSequence r7) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, null, r4, null);
    }

    public void fatal(CharSequence r7, Throwable r8) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, null, r4, r8);
    }

    public void fatal(Object r7) {
        logIfEnabled(FQCN, Level.FATAL, null, r7, null);
    }

    public void fatal(Object r7, Throwable r8) {
        logIfEnabled(FQCN, Level.FATAL, null, r7, r8);
    }

    public void fatal(String r7) {
        logIfEnabled(FQCN, Level.FATAL, null, r7, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void fatal(String r7, Object r8) {
        logIfEnabled(FQCN, Level.FATAL, null, r7, r8);
    }

    public void fatal(String r8, Object r9, Object r10) {
        logIfEnabled(FQCN, Level.FATAL, null, r8, r9, r10);
    }

    public void fatal(String r9, Object r10, Object r11, Object r12) {
        logIfEnabled(FQCN, Level.FATAL, null, r9, r10, r11, r12);
    }

    public void fatal(String r10, Object r11, Object r12, Object r13, Object r14) {
        logIfEnabled(FQCN, Level.FATAL, null, r10, r11, r12, r13, r14);
    }

    public void fatal(String r11, Object r12, Object r13, Object r14, Object r15, Object r16) {
        logIfEnabled(FQCN, Level.FATAL, null, r11, r12, r13, r14, r15, r16);
    }

    public void fatal(String r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18) {
        logIfEnabled(FQCN, Level.FATAL, null, r12, r13, r14, r15, r16, r17, r18);
    }

    public void fatal(String r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20) {
        logIfEnabled(FQCN, Level.FATAL, null, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public void fatal(String r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22) {
        logIfEnabled(FQCN, Level.FATAL, null, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public void fatal(String r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24) {
        logIfEnabled(FQCN, Level.FATAL, null, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public void fatal(String r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26) {
        logIfEnabled(FQCN, Level.FATAL, null, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    @Override // org.apache.logging.log4j.c
    public void fatal(String r7, Throwable r8) {
        logIfEnabled(FQCN, Level.FATAL, null, r7, r8);
    }

    public void fatal(String r7, Object... r8) {
        logIfEnabled(FQCN, Level.FATAL, null, r7, r8);
    }

    public void fatal(String r7, t<?>... r8) {
        logIfEnabled(FQCN, Level.FATAL, null, r7, r8);
    }

    public void fatal(Marker r9, CharSequence r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, r5, r6, null);
    }

    public void fatal(Marker r9, CharSequence r10, Throwable r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, r5, r6, r11);
    }

    public void fatal(Marker r7, Object r8) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, r3, r8, null);
    }

    public void fatal(Marker r7, Object r8, Throwable r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, r3, r8, r9);
    }

    public void fatal(Marker r9, String r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, r5, r10, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void fatal(Marker r7, String r8, Object r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, r3, r8, r9);
    }

    public void fatal(Marker r8, String r9, Object r10, Object r11) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r8, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, r3, r9, r10, r11);
    }

    public void fatal(Marker r9, String r10, Object r11, Object r12, Object r13) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, r3, r10, r11, r12, r13);
    }

    public void fatal(Marker r10, String r11, Object r12, Object r13, Object r14, Object r15) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r10, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, r3, r11, r12, r13, r14, r15);
    }

    public void fatal(Marker r12, String r13, Object r14, Object r15, Object r16, Object r17, Object r18) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r12, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, r4, r13, r14, r15, r16, r17, r18);
    }

    public void fatal(Marker r13, String r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r13, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, r4, r14, r15, r16, r17, r18, r19, r20);
    }

    public void fatal(Marker r14, String r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r14, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, r4, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public void fatal(Marker r15, String r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r15, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, r4, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public void fatal(Marker r16, String r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r16, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, r4, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public void fatal(Marker r17, String r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26, Object r27, Object r28) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r17, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, r4, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    }

    public void fatal(Marker r7, String r8, Throwable r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, r3, r8, r9);
    }

    public void fatal(Marker r7, String r8, Object... r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, r3, r8, r9);
    }

    public void fatal(Marker r7, String r8, t<?>... r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, r3, r8, r9);
    }

    public void fatal(Marker r9, Message r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        Message r6 = (Message) ZeusTransformUtils.wrapperContextForParams(r10, Message.class, "com.obric.memorydata.plugin");
        String r3 = FQCN;
        Level r4 = Level.FATAL;
        if (r6 == null) goto L5;
        Throwable r11 = r6.getThrowable();
    L6:
        logIfEnabled(r3, r4, r5, r6, r11);
        return;
    L5:
        r11 = null;
        goto L6
    }

    public void fatal(Marker r9, Message r10, Throwable r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        Message r6 = (Message) ZeusTransformUtils.wrapperContextForParams(r10, Message.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, r5, r6, r11);
    }

    public void fatal(Marker r9, org.apache.logging.log4j.util.i r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        org.apache.logging.log4j.util.i r6 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r10, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, r5, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void fatal(Marker r9, org.apache.logging.log4j.util.i r10, Throwable r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        org.apache.logging.log4j.util.i r6 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r10, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, r5, r6, r11);
    }

    public void fatal(Marker r9, t<?> r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        t<?> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r10, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, r5, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void fatal(Marker r9, t<?> r10, Throwable r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        t<?> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r10, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, r5, r6, r11);
    }

    public void fatal(Message r7) {
        Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r7, Message.class, "com.obric.memorydata.plugin");
        String r1 = FQCN;
        Level r2 = Level.FATAL;
        if (r4 == null) goto L5;
        Throwable r8 = r4.getThrowable();
    L6:
        logIfEnabled(r1, r2, null, r4, r8);
        return;
    L5:
        r8 = null;
        goto L6
    }

    public void fatal(Message r7, Throwable r8) {
        Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r7, Message.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, null, r4, r8);
    }

    public void fatal(org.apache.logging.log4j.util.i r9) {
        org.apache.logging.log4j.util.i r6 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r9, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, null, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void fatal(org.apache.logging.log4j.util.i r7, Throwable r8) {
        org.apache.logging.log4j.util.i r4 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r7, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, null, r4, r8);
    }

    public void fatal(t<?> r9) {
        t<?> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r9, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, null, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void fatal(t<?> r7, Throwable r8) {
        t<?> r4 = (t) ZeusTransformUtils.wrapperContextForParams(r7, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.FATAL, null, r4, r8);
    }

    @Override // org.apache.logging.log4j.c
    public <MF extends org.apache.logging.log4j.message.d> MF getMessageFactory() {
        return this.messageFactory;
    }

    @Override // org.apache.logging.log4j.c
    public String getName() {
        return this.name;
    }

    public void info(CharSequence r7) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, null, r4, null);
    }

    public void info(CharSequence r7, Throwable r8) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, null, r4, r8);
    }

    public void info(Object r7) {
        logIfEnabled(FQCN, Level.INFO, null, r7, null);
    }

    public void info(Object r7, Throwable r8) {
        logIfEnabled(FQCN, Level.INFO, null, r7, r8);
    }

    public void info(String r7) {
        logIfEnabled(FQCN, Level.INFO, null, r7, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void info(String r7, Object r8) {
        logIfEnabled(FQCN, Level.INFO, null, r7, r8);
    }

    public void info(String r8, Object r9, Object r10) {
        logIfEnabled(FQCN, Level.INFO, null, r8, r9, r10);
    }

    public void info(String r9, Object r10, Object r11, Object r12) {
        logIfEnabled(FQCN, Level.INFO, null, r9, r10, r11, r12);
    }

    public void info(String r10, Object r11, Object r12, Object r13, Object r14) {
        logIfEnabled(FQCN, Level.INFO, null, r10, r11, r12, r13, r14);
    }

    public void info(String r11, Object r12, Object r13, Object r14, Object r15, Object r16) {
        logIfEnabled(FQCN, Level.INFO, null, r11, r12, r13, r14, r15, r16);
    }

    public void info(String r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18) {
        logIfEnabled(FQCN, Level.INFO, null, r12, r13, r14, r15, r16, r17, r18);
    }

    public void info(String r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20) {
        logIfEnabled(FQCN, Level.INFO, null, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public void info(String r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22) {
        logIfEnabled(FQCN, Level.INFO, null, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public void info(String r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24) {
        logIfEnabled(FQCN, Level.INFO, null, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public void info(String r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26) {
        logIfEnabled(FQCN, Level.INFO, null, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public void info(String r7, Throwable r8) {
        logIfEnabled(FQCN, Level.INFO, null, r7, r8);
    }

    public void info(String r7, Object... r8) {
        logIfEnabled(FQCN, Level.INFO, null, r7, r8);
    }

    public void info(String r7, t<?>... r8) {
        logIfEnabled(FQCN, Level.INFO, null, r7, r8);
    }

    public void info(Marker r9, CharSequence r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, r5, r6, null);
    }

    public void info(Marker r9, CharSequence r10, Throwable r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, r5, r6, r11);
    }

    public void info(Marker r7, Object r8) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, r3, r8, null);
    }

    public void info(Marker r7, Object r8, Throwable r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, r3, r8, r9);
    }

    public void info(Marker r9, String r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, r5, r10, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void info(Marker r7, String r8, Object r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, r3, r8, r9);
    }

    public void info(Marker r8, String r9, Object r10, Object r11) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r8, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, r3, r9, r10, r11);
    }

    public void info(Marker r9, String r10, Object r11, Object r12, Object r13) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, r3, r10, r11, r12, r13);
    }

    public void info(Marker r10, String r11, Object r12, Object r13, Object r14, Object r15) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r10, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, r3, r11, r12, r13, r14, r15);
    }

    public void info(Marker r12, String r13, Object r14, Object r15, Object r16, Object r17, Object r18) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r12, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, r4, r13, r14, r15, r16, r17, r18);
    }

    public void info(Marker r13, String r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r13, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, r4, r14, r15, r16, r17, r18, r19, r20);
    }

    public void info(Marker r14, String r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r14, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, r4, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public void info(Marker r15, String r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r15, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, r4, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public void info(Marker r16, String r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r16, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, r4, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public void info(Marker r17, String r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26, Object r27, Object r28) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r17, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, r4, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    }

    public void info(Marker r7, String r8, Throwable r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, r3, r8, r9);
    }

    public void info(Marker r7, String r8, Object... r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, r3, r8, r9);
    }

    public void info(Marker r7, String r8, t<?>... r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, r3, r8, r9);
    }

    public void info(Marker r9, Message r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        Message r6 = (Message) ZeusTransformUtils.wrapperContextForParams(r10, Message.class, "com.obric.memorydata.plugin");
        String r3 = FQCN;
        Level r4 = Level.INFO;
        if (r6 == null) goto L5;
        Throwable r11 = r6.getThrowable();
    L6:
        logIfEnabled(r3, r4, r5, r6, r11);
        return;
    L5:
        r11 = null;
        goto L6
    }

    public void info(Marker r9, Message r10, Throwable r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        Message r6 = (Message) ZeusTransformUtils.wrapperContextForParams(r10, Message.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, r5, r6, r11);
    }

    public void info(Marker r9, org.apache.logging.log4j.util.i r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        org.apache.logging.log4j.util.i r6 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r10, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, r5, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void info(Marker r9, org.apache.logging.log4j.util.i r10, Throwable r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        org.apache.logging.log4j.util.i r6 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r10, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, r5, r6, r11);
    }

    public void info(Marker r9, t<?> r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        t<?> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r10, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, r5, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void info(Marker r9, t<?> r10, Throwable r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        t<?> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r10, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, r5, r6, r11);
    }

    public void info(Message r7) {
        Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r7, Message.class, "com.obric.memorydata.plugin");
        String r1 = FQCN;
        Level r2 = Level.INFO;
        if (r4 == null) goto L5;
        Throwable r8 = r4.getThrowable();
    L6:
        logIfEnabled(r1, r2, null, r4, r8);
        return;
    L5:
        r8 = null;
        goto L6
    }

    public void info(Message r7, Throwable r8) {
        Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r7, Message.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, null, r4, r8);
    }

    public void info(org.apache.logging.log4j.util.i r9) {
        org.apache.logging.log4j.util.i r6 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r9, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, null, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void info(org.apache.logging.log4j.util.i r7, Throwable r8) {
        org.apache.logging.log4j.util.i r4 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r7, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, null, r4, r8);
    }

    public void info(t<?> r9) {
        t<?> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r9, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, null, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void info(t<?> r7, Throwable r8) {
        t<?> r4 = (t) ZeusTransformUtils.wrapperContextForParams(r7, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.INFO, null, r4, r8);
    }

    public boolean isDebugEnabled() {
        return isEnabled(Level.DEBUG, null, null);
    }

    public boolean isDebugEnabled(Marker r3) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        return isEnabled(Level.DEBUG, r4, null, null);
    }

    public boolean isEnabled(Level r2) {
        return isEnabled(r2, null, null, null);
    }

    public boolean isEnabled(Level r3, Marker r4) {
        return isEnabled(r3, (Marker) ZeusTransformUtils.wrapperContextForParams(r4, Marker.class, "com.obric.memorydata.plugin"), null, null);
    }

    public boolean isErrorEnabled() {
        return isEnabled(Level.ERROR, null, null, null);
    }

    public boolean isErrorEnabled(Marker r3) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        return isEnabled(Level.ERROR, r4, null, null);
    }

    public boolean isFatalEnabled() {
        return isEnabled(Level.FATAL, null, null, null);
    }

    public boolean isFatalEnabled(Marker r3) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        return isEnabled(Level.FATAL, r4, null, null);
    }

    public boolean isInfoEnabled() {
        return isEnabled(Level.INFO, null, null, null);
    }

    public boolean isInfoEnabled(Marker r3) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        return isEnabled(Level.INFO, r4, null, null);
    }

    public boolean isTraceEnabled() {
        return isEnabled(Level.TRACE, null, null, null);
    }

    public boolean isTraceEnabled(Marker r3) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        return isEnabled(Level.TRACE, r4, null, null);
    }

    public boolean isWarnEnabled() {
        return isEnabled(Level.WARN, null, null, null);
    }

    public boolean isWarnEnabled(Marker r3) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        return isEnabled(Level.WARN, r4, null, null);
    }

    public void log(Level r7, CharSequence r8) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r7, null, r4, null);
    }

    public void log(Level r7, CharSequence r8, Throwable r9) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r7, null, r4, r9);
    }

    public void log(Level r7, Object r8) {
        logIfEnabled(FQCN, r7, null, r8, null);
    }

    public void log(Level r7, Object r8, Throwable r9) {
        logIfEnabled(FQCN, r7, null, r8, r9);
    }

    public void log(Level r7, String r8) {
        logIfEnabled(FQCN, r7, null, r8, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void log(Level r7, String r8, Object r9) {
        logIfEnabled(FQCN, r7, null, r8, r9);
    }

    public void log(Level r8, String r9, Object r10, Object r11) {
        logIfEnabled(FQCN, r8, null, r9, r10, r11);
    }

    public void log(Level r9, String r10, Object r11, Object r12, Object r13) {
        logIfEnabled(FQCN, r9, null, r10, r11, r12, r13);
    }

    public void log(Level r10, String r11, Object r12, Object r13, Object r14, Object r15) {
        logIfEnabled(FQCN, r10, null, r11, r12, r13, r14, r15);
    }

    public void log(Level r11, String r12, Object r13, Object r14, Object r15, Object r16, Object r17) {
        logIfEnabled(FQCN, r11, null, r12, r13, r14, r15, r16, r17);
    }

    public void log(Level r12, String r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19) {
        logIfEnabled(FQCN, r12, null, r13, r14, r15, r16, r17, r18, r19);
    }

    public void log(Level r13, String r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21) {
        logIfEnabled(FQCN, r13, null, r14, r15, r16, r17, r18, r19, r20, r21);
    }

    public void log(Level r14, String r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23) {
        logIfEnabled(FQCN, r14, null, r15, r16, r17, r18, r19, r20, r21, r22, r23);
    }

    public void log(Level r15, String r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25) {
        logIfEnabled(FQCN, r15, null, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
    }

    public void log(Level r16, String r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26, Object r27) {
        logIfEnabled(FQCN, r16, null, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27);
    }

    @Override // org.apache.logging.log4j.c
    public void log(Level r7, String r8, Throwable r9) {
        logIfEnabled(FQCN, r7, null, r8, r9);
    }

    public void log(Level r7, String r8, Object... r9) {
        logIfEnabled(FQCN, r7, null, r8, r9);
    }

    public void log(Level r7, String r8, t<?>... r9) {
        logIfEnabled(FQCN, r7, null, r8, r9);
    }

    public void log(Level r9, Marker r10, CharSequence r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r10, Marker.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r9, r5, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void log(Level r9, Marker r10, CharSequence r11, Throwable r12) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r10, Marker.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        if (isEnabled(r9, r5, r6, r12) == false) goto L6;
        logMessage(FQCN, r9, r5, r6, r12);
        return;
    }

    public void log(Level r9, Marker r10, Object r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r10, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r9, r5, r11, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void log(Level r7, Marker r8, Object r9, Throwable r10) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r8, Marker.class, "com.obric.memorydata.plugin");
        if (isEnabled(r7, r3, r9, r10) == false) goto L6;
        logMessage(FQCN, r7, r3, r9, r10);
        return;
    }

    public void log(Level r9, Marker r10, String r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r10, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r9, r5, r11, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void log(Level r7, Marker r8, String r9, Object r10) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r8, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r7, r3, r9, r10);
    }

    public void log(Level r8, Marker r9, String r10, Object r11, Object r12) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r8, r3, r10, r11, r12);
    }

    public void log(Level r9, Marker r10, String r11, Object r12, Object r13, Object r14) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r10, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r9, r3, r11, r12, r13, r14);
    }

    public void log(Level r11, Marker r12, String r13, Object r14, Object r15, Object r16, Object r17) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r12, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r11, r4, r13, r14, r15, r16, r17);
    }

    public void log(Level r12, Marker r13, String r14, Object r15, Object r16, Object r17, Object r18, Object r19) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r13, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r12, r4, r14, r15, r16, r17, r18, r19);
    }

    public void log(Level r13, Marker r14, String r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r14, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r13, r4, r15, r16, r17, r18, r19, r20, r21);
    }

    public void log(Level r14, Marker r15, String r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r15, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r14, r4, r16, r17, r18, r19, r20, r21, r22, r23);
    }

    public void log(Level r15, Marker r16, String r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r16, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r15, r4, r17, r18, r19, r20, r21, r22, r23, r24, r25);
    }

    public void log(Level r16, Marker r17, String r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26, Object r27) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r17, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r16, r4, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27);
    }

    public void log(Level r17, Marker r18, String r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26, Object r27, Object r28, Object r29) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r18, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r17, r4, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29);
    }

    public void log(Level r8, Marker r9, String r10, StackTraceElement r11, Message r12, Throwable r13) {
        logMessage(r10, r8, (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin"), (Message) ZeusTransformUtils.wrapperContextForParams(r12, Message.class, "com.obric.memorydata.plugin"), r13);
    }

    public void log(Level r7, Marker r8, String r9, Throwable r10) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r8, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r7, r3, r9, r10);
    }

    public void log(Level r7, Marker r8, String r9, Object... r10) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r8, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r7, r3, r9, r10);
    }

    public void log(Level r7, Marker r8, String r9, t<?>... r10) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r8, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r7, r3, r9, r10);
    }

    public void log(Level r9, Marker r10, Message r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r10, Marker.class, "com.obric.memorydata.plugin");
        Message r6 = (Message) ZeusTransformUtils.wrapperContextForParams(r11, Message.class, "com.obric.memorydata.plugin");
        String r3 = FQCN;
        if (r6 == null) goto L5;
        Throwable r12 = r6.getThrowable();
    L6:
        logIfEnabled(r3, r9, r5, r6, r12);
        return;
    L5:
        r12 = null;
        goto L6
    }

    public void log(Level r9, Marker r10, Message r11, Throwable r12) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r10, Marker.class, "com.obric.memorydata.plugin");
        Message r6 = (Message) ZeusTransformUtils.wrapperContextForParams(r11, Message.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r9, r5, r6, r12);
    }

    public void log(Level r9, Marker r10, org.apache.logging.log4j.util.i r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r10, Marker.class, "com.obric.memorydata.plugin");
        org.apache.logging.log4j.util.i r6 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r11, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r9, r5, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void log(Level r9, Marker r10, org.apache.logging.log4j.util.i r11, Throwable r12) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r10, Marker.class, "com.obric.memorydata.plugin");
        org.apache.logging.log4j.util.i r6 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r11, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r9, r5, r6, r12);
    }

    public void log(Level r9, Marker r10, t<?> r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r10, Marker.class, "com.obric.memorydata.plugin");
        t<?> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r11, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r9, r5, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void log(Level r9, Marker r10, t<?> r11, Throwable r12) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r10, Marker.class, "com.obric.memorydata.plugin");
        t<?> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r11, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r9, r5, r6, r12);
    }

    public void log(Level r7, Message r8) {
        Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r8, Message.class, "com.obric.memorydata.plugin");
        String r1 = FQCN;
        if (r4 == null) goto L5;
        Throwable r9 = r4.getThrowable();
    L6:
        logIfEnabled(r1, r7, null, r4, r9);
        return;
    L5:
        r9 = null;
        goto L6
    }

    public void log(Level r7, Message r8, Throwable r9) {
        Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r8, Message.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r7, null, r4, r9);
    }

    public void log(Level r9, org.apache.logging.log4j.util.i r10) {
        org.apache.logging.log4j.util.i r6 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r10, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r9, null, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void log(Level r7, org.apache.logging.log4j.util.i r8, Throwable r9) {
        org.apache.logging.log4j.util.i r4 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r8, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r7, null, r4, r9);
    }

    public void log(Level r9, t<?> r10) {
        t<?> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r10, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r9, null, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void log(Level r7, t<?> r8, Throwable r9) {
        t<?> r4 = (t) ZeusTransformUtils.wrapperContextForParams(r8, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, r7, null, r4, r9);
    }

    public void logIfEnabled(String r9, Level r10, Marker r11, CharSequence r12, Throwable r13) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r11, Marker.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.memorydata.plugin");
        if (isEnabled(r10, r5, r6, r13) == false) goto L6;
        logMessage(r9, r10, r5, r6, r13);
        return;
    }

    public void logIfEnabled(String r7, Level r8, Marker r9, Object r10, Throwable r11) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        if (isEnabled(r8, r3, r10, r11) == false) goto L6;
        logMessage(r7, r8, r3, r10, r11);
        return;
    }

    public void logIfEnabled(String r3, Level r4, Marker r5, String r6) {
        Marker r7 = (Marker) ZeusTransformUtils.wrapperContextForParams(r5, Marker.class, "com.obric.memorydata.plugin");
        if (isEnabled(r4, r7, r6) == false) goto L6;
        logMessage(r3, r4, r7, r6);
        return;
    }

    public void logIfEnabled(String r7, Level r8, Marker r9, String r10, Object r11) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        if (isEnabled(r8, r3, r10, r11) == false) goto L6;
        logMessage(r7, r8, r3, r10, r11);
        return;
    }

    public void logIfEnabled(String r8, Level r9, Marker r10, String r11, Object r12, Object r13) {
        Marker r14 = (Marker) ZeusTransformUtils.wrapperContextForParams(r10, Marker.class, "com.obric.memorydata.plugin");
        if (isEnabled(r9, r14, r11, r12, r13) == false) goto L6;
        logMessage(r8, r9, r14, r11, r12, r13);
        return;
    }

    public void logIfEnabled(String r9, Level r10, Marker r11, String r12, Object r13, Object r14, Object r15) {
        Marker r16 = (Marker) ZeusTransformUtils.wrapperContextForParams(r11, Marker.class, "com.obric.memorydata.plugin");
        if (isEnabled(r10, r16, r12, r13, r14, r15) == false) goto L6;
        logMessage(r9, r10, r16, r12, r13, r14, r15);
        return;
    }

    public void logIfEnabled(String r11, Level r12, Marker r13, String r14, Object r15, Object r16, Object r17, Object r18) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r13, Marker.class, "com.obric.memorydata.plugin");
        if (isEnabled(r12, r0, r14, r15, r16, r17, r18) == false) goto L6;
        logMessage(r11, r12, r0, r14, r15, r16, r17, r18);
        return;
    }

    public void logIfEnabled(String r12, Level r13, Marker r14, String r15, Object r16, Object r17, Object r18, Object r19, Object r20) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r14, Marker.class, "com.obric.memorydata.plugin");
        if (isEnabled(r13, r0, r15, r16, r17, r18, r19, r20) == false) goto L6;
        logMessage(r12, r13, r0, r15, r16, r17, r18, r19, r20);
        return;
    }

    public void logIfEnabled(String r13, Level r14, Marker r15, String r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r15, Marker.class, "com.obric.memorydata.plugin");
        if (isEnabled(r14, r0, r16, r17, r18, r19, r20, r21, r22) == false) goto L6;
        logMessage(r13, r14, r0, r16, r17, r18, r19, r20, r21, r22);
        return;
    }

    public void logIfEnabled(String r14, Level r15, Marker r16, String r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r16, Marker.class, "com.obric.memorydata.plugin");
        if (isEnabled(r15, r0, r17, r18, r19, r20, r21, r22, r23, r24) == false) goto L6;
        logMessage(r14, r15, r0, r17, r18, r19, r20, r21, r22, r23, r24);
        return;
    }

    public void logIfEnabled(String r15, Level r16, Marker r17, String r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r17, Marker.class, "com.obric.memorydata.plugin");
        if (isEnabled(r16, r0, r18, r19, r20, r21, r22, r23, r24, r25, r26) == false) goto L6;
        logMessage(r15, r16, r0, r18, r19, r20, r21, r22, r23, r24, r25, r26);
        return;
    }

    public void logIfEnabled(String r16, Level r17, Marker r18, String r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26, Object r27, Object r28) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r18, Marker.class, "com.obric.memorydata.plugin");
        if (isEnabled(r17, r0, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28) == false) goto L6;
        logMessage(r16, r17, r0, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
        return;
    }

    public void logIfEnabled(String r17, Level r18, Marker r19, String r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26, Object r27, Object r28, Object r29, Object r30) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r19, Marker.class, "com.obric.memorydata.plugin");
        if (isEnabled(r18, r0, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30) == false) goto L6;
        logMessage(r17, r18, r0, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
        return;
    }

    public void logIfEnabled(String r7, Level r8, Marker r9, String r10, Throwable r11) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        if (isEnabled(r8, r3, r10, r11) == false) goto L6;
        logMessage(r7, r8, r3, r10, r11);
        return;
    }

    public void logIfEnabled(String r7, Level r8, Marker r9, String r10, Object... r11) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        if (isEnabled(r8, r3, r10, r11) == false) goto L6;
        logMessage(r7, r8, r3, r10, r11);
        return;
    }

    public void logIfEnabled(String r7, Level r8, Marker r9, String r10, t<?>... r11) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        if (isEnabled(r8, r3, r10) == false) goto L6;
        logMessage(r7, r8, r3, r10, r11);
        return;
    }

    public void logIfEnabled(String r9, Level r10, Marker r11, Message r12, Throwable r13) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r11, Marker.class, "com.obric.memorydata.plugin");
        Message r6 = (Message) ZeusTransformUtils.wrapperContextForParams(r12, Message.class, "com.obric.memorydata.plugin");
        if (isEnabled(r10, r5, r6, r13) == false) goto L6;
        logMessageSafely(r9, r10, r5, r6, r13);
        return;
    }

    public void logIfEnabled(String r9, Level r10, Marker r11, org.apache.logging.log4j.util.i r12, Throwable r13) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r11, Marker.class, "com.obric.memorydata.plugin");
        org.apache.logging.log4j.util.i r6 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r12, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        if (isEnabled(r10, r5, r6, r13) == false) goto L6;
        logMessage(r9, r10, r5, r6, r13);
        return;
    }

    public void logIfEnabled(String r9, Level r10, Marker r11, t<?> r12, Throwable r13) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r11, Marker.class, "com.obric.memorydata.plugin");
        t<?> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r12, t.class, "com.obric.memorydata.plugin");
        if (isEnabled(r10, r5, r6, r13) == false) goto L6;
        logMessage(r9, r10, r5, r6, r13);
        return;
    }

    public void logMessage(String r9, Level r10, Marker r11, CharSequence r12, Throwable r13) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r11, Marker.class, "com.obric.memorydata.plugin");
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.memorydata.plugin");
        logMessageSafely(r9, r10, r5, this.messageFactory.newMessage(r14), r13);
    }

    public void logMessage(String r7, Level r8, Marker r9, Object r10, Throwable r11) {
        logMessageSafely(r7, r8, (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin"), this.messageFactory.newMessage(r10), r11);
    }

    public void logMessage(String r7, Level r8, Marker r9, String r10) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        Message r4 = this.messageFactory.newMessage(r10);
        logMessageSafely(r7, r8, r3, r4, r4.getThrowable());
    }

    public void logMessage(String r7, Level r8, Marker r9, String r10, Object r11) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        Message r4 = this.messageFactory.newMessage(r10, r11);
        logMessageSafely(r7, r8, r3, r4, r4.getThrowable());
    }

    public void logMessage(String r7, Level r8, Marker r9, String r10, Object r11, Object r12) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        Message r4 = this.messageFactory.newMessage(r10, r11, r12);
        logMessageSafely(r7, r8, r3, r4, r4.getThrowable());
    }

    public void logMessage(String r7, Level r8, Marker r9, String r10, Object r11, Object r12, Object r13) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        Message r4 = this.messageFactory.newMessage(r10, r11, r12, r13);
        logMessageSafely(r7, r8, r3, r4, r4.getThrowable());
    }

    public void logMessage(String r9, Level r10, Marker r11, String r12, Object r13, Object r14, Object r15, Object r16) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r11, Marker.class, "com.obric.memorydata.plugin");
        Message r2 = this.messageFactory.newMessage(r12, r13, r14, r15, r16);
        logMessageSafely(r9, r10, r0, r2, r2.getThrowable());
    }

    public void logMessage(String r10, Level r11, Marker r12, String r13, Object r14, Object r15, Object r16, Object r17, Object r18) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r12, Marker.class, "com.obric.memorydata.plugin");
        Message r2 = this.messageFactory.newMessage(r13, r14, r15, r16, r17, r18);
        logMessageSafely(r10, r11, r0, r2, r2.getThrowable());
    }

    public void logMessage(String r11, Level r12, Marker r13, String r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r13, Marker.class, "com.obric.memorydata.plugin");
        Message r2 = this.messageFactory.newMessage(r14, r15, r16, r17, r18, r19, r20);
        logMessageSafely(r11, r12, r0, r2, r2.getThrowable());
    }

    public void logMessage(String r12, Level r13, Marker r14, String r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r14, Marker.class, "com.obric.memorydata.plugin");
        Message r2 = this.messageFactory.newMessage(r15, r16, r17, r18, r19, r20, r21, r22);
        logMessageSafely(r12, r13, r0, r2, r2.getThrowable());
    }

    public void logMessage(String r13, Level r14, Marker r15, String r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r15, Marker.class, "com.obric.memorydata.plugin");
        Message r2 = this.messageFactory.newMessage(r16, r17, r18, r19, r20, r21, r22, r23, r24);
        logMessageSafely(r13, r14, r0, r2, r2.getThrowable());
    }

    public void logMessage(String r14, Level r15, Marker r16, String r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r16, Marker.class, "com.obric.memorydata.plugin");
        Message r2 = this.messageFactory.newMessage(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
        logMessageSafely(r14, r15, r0, r2, r2.getThrowable());
    }

    public void logMessage(String r15, Level r16, Marker r17, String r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26, Object r27, Object r28) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r17, Marker.class, "com.obric.memorydata.plugin");
        Message r2 = this.messageFactory.newMessage(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
        logMessageSafely(r15, r16, r0, r2, r2.getThrowable());
    }

    public void logMessage(String r7, Level r8, Marker r9, String r10, Throwable r11) {
        logMessageSafely(r7, r8, (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin"), this.messageFactory.newMessage(r10), r11);
    }

    public void logMessage(String r7, Level r8, Marker r9, String r10, Object... r11) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        Message r4 = this.messageFactory.newMessage(r10, r11);
        logMessageSafely(r7, r8, r3, r4, r4.getThrowable());
    }

    public void logMessage(String r7, Level r8, Marker r9, String r10, t<?>... r11) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        Message r4 = this.messageFactory.newMessage(r10, org.apache.logging.log4j.util.f.a(r11));
        logMessageSafely(r7, r8, r3, r4, r4.getThrowable());
    }

    public void logMessage(String r9, Level r10, Marker r11, org.apache.logging.log4j.util.i r12, Throwable r13) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r11, Marker.class, "com.obric.memorydata.plugin");
        Message r6 = org.apache.logging.log4j.util.f.a((org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r12, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin"));
        if (r13 != null) goto L6;
        if (r6 == null) goto L6;
        r13 = r6.getThrowable();
    L6:
        logMessageSafely(r9, r10, r5, r6, r13);
    }

    public void logMessage(String r9, Level r10, Marker r11, t<?> r12, Throwable r13) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r11, Marker.class, "com.obric.memorydata.plugin");
        Message r6 = org.apache.logging.log4j.util.f.a((t) ZeusTransformUtils.wrapperContextForParams(r12, t.class, "com.obric.memorydata.plugin"), this.messageFactory);
        if (r13 != null) goto L6;
        if (r6 == null) goto L6;
        r13 = r6.getThrowable();
    L6:
        logMessageSafely(r9, r10, r5, r6, r13);
    }

    @Override // org.apache.logging.log4j.c, org.apache.logging.log4j.spi.e
    public void logMessage(Level r10, Marker r11, String r12, StackTraceElement r13, Message r14, Throwable r15) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r11, Marker.class, "com.obric.memorydata.plugin");
        Message r16 = (Message) ZeusTransformUtils.wrapperContextForParams(r14, Message.class, "com.obric.memorydata.plugin");
        incrementRecursionDepth();     // Catch: Throwable -> L5
        log(r10, r4, r12, r13, r16, r15);     // Catch: Throwable -> L5
    L4:
        decrementRecursionDepth();
        ReusableMessageFactory.release(r16);
        return;
    L5:
        th = move-exception;
        handleLogMessageException(th, r12, r16);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        decrementRecursionDepth();
        ReusableMessageFactory.release(r16);
        throw th;
    }

    public void printf(Level r8, String r9, Object... r10) {
        if (isEnabled(r8, null, r9, r10) == false) goto L6;
        StringFormattedMessage r5 = new StringFormattedMessage(r9, r10);
        logMessageSafely(FQCN, r8, null, r5, r5.getThrowable());
        return;
    }

    public void printf(Level r7, Marker r8, String r9, Object... r10) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r8, Marker.class, "com.obric.memorydata.plugin");
        if (isEnabled(r7, r3, r9, r10) == false) goto L6;
        StringFormattedMessage r4 = new StringFormattedMessage(r9, r10);
        logMessageSafely(FQCN, r7, r3, r4, r4.getThrowable());
        return;
    }

    public boolean requiresLocation() {
        return false;
    }

    public <T extends Throwable> T throwing(String r7, Level r8, T r9) {
        Marker r3 = THROWING_MARKER;
        if (isEnabled(r8, r3, null, null) == false) goto L5;
        logMessageSafely(r7, r8, r3, throwingMsg(r9), r9);
    L5:
        return r9;
    }

    public <T extends Throwable> T throwing(T r3) {
        return (T) throwing(FQCN, Level.ERROR, r3);
    }

    public <T extends Throwable> T throwing(Level r2, T r3) {
        return (T) throwing(FQCN, r2, r3);
    }

    public Message throwingMsg(Throwable r1) {
        return this.messageFactory.newMessage(THROWING);
    }

    public void trace(CharSequence r7) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, null, r4, null);
    }

    public void trace(CharSequence r7, Throwable r8) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, null, r4, r8);
    }

    public void trace(Object r7) {
        logIfEnabled(FQCN, Level.TRACE, null, r7, null);
    }

    public void trace(Object r7, Throwable r8) {
        logIfEnabled(FQCN, Level.TRACE, null, r7, r8);
    }

    public void trace(String r7) {
        logIfEnabled(FQCN, Level.TRACE, null, r7, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void trace(String r7, Object r8) {
        logIfEnabled(FQCN, Level.TRACE, null, r7, r8);
    }

    public void trace(String r8, Object r9, Object r10) {
        logIfEnabled(FQCN, Level.TRACE, null, r8, r9, r10);
    }

    public void trace(String r9, Object r10, Object r11, Object r12) {
        logIfEnabled(FQCN, Level.TRACE, null, r9, r10, r11, r12);
    }

    public void trace(String r10, Object r11, Object r12, Object r13, Object r14) {
        logIfEnabled(FQCN, Level.TRACE, null, r10, r11, r12, r13, r14);
    }

    public void trace(String r11, Object r12, Object r13, Object r14, Object r15, Object r16) {
        logIfEnabled(FQCN, Level.TRACE, null, r11, r12, r13, r14, r15, r16);
    }

    public void trace(String r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18) {
        logIfEnabled(FQCN, Level.TRACE, null, r12, r13, r14, r15, r16, r17, r18);
    }

    public void trace(String r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20) {
        logIfEnabled(FQCN, Level.TRACE, null, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public void trace(String r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22) {
        logIfEnabled(FQCN, Level.TRACE, null, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public void trace(String r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24) {
        logIfEnabled(FQCN, Level.TRACE, null, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public void trace(String r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26) {
        logIfEnabled(FQCN, Level.TRACE, null, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public void trace(String r7, Throwable r8) {
        logIfEnabled(FQCN, Level.TRACE, null, r7, r8);
    }

    public void trace(String r7, Object... r8) {
        logIfEnabled(FQCN, Level.TRACE, null, r7, r8);
    }

    public void trace(String r7, t<?>... r8) {
        logIfEnabled(FQCN, Level.TRACE, null, r7, r8);
    }

    public void trace(Marker r9, CharSequence r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, r5, r6, null);
    }

    public void trace(Marker r9, CharSequence r10, Throwable r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, r5, r6, r11);
    }

    public void trace(Marker r7, Object r8) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, r3, r8, null);
    }

    public void trace(Marker r7, Object r8, Throwable r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, r3, r8, r9);
    }

    public void trace(Marker r9, String r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, r5, r10, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void trace(Marker r7, String r8, Object r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, r3, r8, r9);
    }

    public void trace(Marker r8, String r9, Object r10, Object r11) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r8, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, r3, r9, r10, r11);
    }

    public void trace(Marker r9, String r10, Object r11, Object r12, Object r13) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, r3, r10, r11, r12, r13);
    }

    public void trace(Marker r10, String r11, Object r12, Object r13, Object r14, Object r15) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r10, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, r3, r11, r12, r13, r14, r15);
    }

    public void trace(Marker r12, String r13, Object r14, Object r15, Object r16, Object r17, Object r18) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r12, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, r4, r13, r14, r15, r16, r17, r18);
    }

    public void trace(Marker r13, String r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r13, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, r4, r14, r15, r16, r17, r18, r19, r20);
    }

    public void trace(Marker r14, String r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r14, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, r4, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public void trace(Marker r15, String r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r15, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, r4, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public void trace(Marker r16, String r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r16, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, r4, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public void trace(Marker r17, String r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26, Object r27, Object r28) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r17, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, r4, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    }

    public void trace(Marker r7, String r8, Throwable r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, r3, r8, r9);
    }

    public void trace(Marker r7, String r8, Object... r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, r3, r8, r9);
    }

    public void trace(Marker r7, String r8, t<?>... r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, r3, r8, r9);
    }

    public void trace(Marker r9, Message r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        Message r6 = (Message) ZeusTransformUtils.wrapperContextForParams(r10, Message.class, "com.obric.memorydata.plugin");
        String r3 = FQCN;
        Level r4 = Level.TRACE;
        if (r6 == null) goto L5;
        Throwable r11 = r6.getThrowable();
    L6:
        logIfEnabled(r3, r4, r5, r6, r11);
        return;
    L5:
        r11 = null;
        goto L6
    }

    public void trace(Marker r9, Message r10, Throwable r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        Message r6 = (Message) ZeusTransformUtils.wrapperContextForParams(r10, Message.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, r5, r6, r11);
    }

    public void trace(Marker r9, org.apache.logging.log4j.util.i r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        org.apache.logging.log4j.util.i r6 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r10, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, r5, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void trace(Marker r9, org.apache.logging.log4j.util.i r10, Throwable r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        org.apache.logging.log4j.util.i r6 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r10, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, r5, r6, r11);
    }

    public void trace(Marker r9, t<?> r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        t<?> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r10, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, r5, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void trace(Marker r9, t<?> r10, Throwable r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        t<?> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r10, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, r5, r6, r11);
    }

    public void trace(Message r7) {
        Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r7, Message.class, "com.obric.memorydata.plugin");
        String r1 = FQCN;
        Level r2 = Level.TRACE;
        if (r4 == null) goto L5;
        Throwable r8 = r4.getThrowable();
    L6:
        logIfEnabled(r1, r2, null, r4, r8);
        return;
    L5:
        r8 = null;
        goto L6
    }

    public void trace(Message r7, Throwable r8) {
        Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r7, Message.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, null, r4, r8);
    }

    public void trace(org.apache.logging.log4j.util.i r9) {
        org.apache.logging.log4j.util.i r6 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r9, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, null, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void trace(org.apache.logging.log4j.util.i r7, Throwable r8) {
        org.apache.logging.log4j.util.i r4 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r7, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, null, r4, r8);
    }

    public void trace(t<?> r9) {
        t<?> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r9, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, null, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void trace(t<?> r7, Throwable r8) {
        t<?> r4 = (t) ZeusTransformUtils.wrapperContextForParams(r7, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.TRACE, null, r4, r8);
    }

    public EntryMessage traceEntry() {
        return enter(FQCN, null, (Object[]) ZeusTransformUtils.preCheckCast(null, Object[].class, "com.obric.memorydata.plugin"));
    }

    public EntryMessage traceEntry(String r2, Object... r3) {
        return enter(FQCN, r2, r3);
    }

    public EntryMessage traceEntry(String r2, t<?>... r3) {
        return enter(FQCN, r2, r3);
    }

    public EntryMessage traceEntry(Message r3) {
        Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
        return enter(FQCN, r4);
    }

    public EntryMessage traceEntry(t<?>... r3) {
        return enter(FQCN, null, r3);
    }

    public <R> R traceExit(R r3) {
        return (R) exit(FQCN, null, r3);
    }

    public <R> R traceExit(String r2, R r3) {
        return (R) exit(FQCN, r2, r3);
    }

    public <R> R traceExit(EntryMessage r8, R r9) {
        EntryMessage r10 = (EntryMessage) ZeusTransformUtils.wrapperContextForParams(r8, EntryMessage.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L7;
        Level r0 = Level.TRACE;
        Marker r4 = EXIT_MARKER;
        if (isEnabled(r0, r4, r10, null) == false) goto L7;
        logMessageSafely(FQCN, Level.TRACE, r4, this.flowMessageFactory.newExitMessage(r9, r10), null);
    L7:
        return r9;
    }

    public <R> R traceExit(Message r8, R r9) {
        Message r10 = (Message) ZeusTransformUtils.wrapperContextForParams(r8, Message.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L7;
        Level r0 = Level.TRACE;
        Marker r4 = EXIT_MARKER;
        if (isEnabled(r0, r4, r10, null) == false) goto L7;
        logMessageSafely(FQCN, Level.TRACE, r4, this.flowMessageFactory.newExitMessage(r9, r10), null);
    L7:
        return r9;
    }

    public void traceExit() {
        exit(FQCN, null, null);
    }

    public void traceExit(EntryMessage r8) {
        EntryMessage r9 = (EntryMessage) ZeusTransformUtils.wrapperContextForParams(r8, EntryMessage.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L8;
        Level r0 = Level.TRACE;
        Marker r4 = EXIT_MARKER;
        if (isEnabled(r0, r4, r9, null) == false) goto L9;
        logMessageSafely(FQCN, Level.TRACE, r4, this.flowMessageFactory.newExitMessage(r9), null);
        return;
    L9:
        return;
    }

    public void warn(CharSequence r7) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, null, r4, null);
    }

    public void warn(CharSequence r7, Throwable r8) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, null, r4, r8);
    }

    public void warn(Object r7) {
        logIfEnabled(FQCN, Level.WARN, null, r7, null);
    }

    public void warn(Object r7, Throwable r8) {
        logIfEnabled(FQCN, Level.WARN, null, r7, r8);
    }

    @Override // org.apache.logging.log4j.c
    public void warn(String r7) {
        logIfEnabled(FQCN, Level.WARN, null, r7, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.logging.log4j.c
    public void warn(String r7, Object r8) {
        logIfEnabled(FQCN, Level.WARN, null, r7, r8);
    }

    @Override // org.apache.logging.log4j.c
    public void warn(String r8, Object r9, Object r10) {
        logIfEnabled(FQCN, Level.WARN, null, r8, r9, r10);
    }

    @Override // org.apache.logging.log4j.c
    public void warn(String r9, Object r10, Object r11, Object r12) {
        logIfEnabled(FQCN, Level.WARN, null, r9, r10, r11, r12);
    }

    public void warn(String r10, Object r11, Object r12, Object r13, Object r14) {
        logIfEnabled(FQCN, Level.WARN, null, r10, r11, r12, r13, r14);
    }

    public void warn(String r11, Object r12, Object r13, Object r14, Object r15, Object r16) {
        logIfEnabled(FQCN, Level.WARN, null, r11, r12, r13, r14, r15, r16);
    }

    public void warn(String r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18) {
        logIfEnabled(FQCN, Level.WARN, null, r12, r13, r14, r15, r16, r17, r18);
    }

    public void warn(String r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20) {
        logIfEnabled(FQCN, Level.WARN, null, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public void warn(String r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22) {
        logIfEnabled(FQCN, Level.WARN, null, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public void warn(String r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24) {
        logIfEnabled(FQCN, Level.WARN, null, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public void warn(String r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26) {
        logIfEnabled(FQCN, Level.WARN, null, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public void warn(String r7, Throwable r8) {
        logIfEnabled(FQCN, Level.WARN, null, r7, r8);
    }

    public void warn(String r7, Object... r8) {
        logIfEnabled(FQCN, Level.WARN, null, r7, r8);
    }

    public void warn(String r7, t<?>... r8) {
        logIfEnabled(FQCN, Level.WARN, null, r7, r8);
    }

    public void warn(Marker r9, CharSequence r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, r5, r6, null);
    }

    public void warn(Marker r9, CharSequence r10, Throwable r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, r5, r6, r11);
    }

    public void warn(Marker r7, Object r8) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, r3, r8, null);
    }

    public void warn(Marker r7, Object r8, Throwable r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, r3, r8, r9);
    }

    public void warn(Marker r9, String r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, r5, r10, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void warn(Marker r7, String r8, Object r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, r3, r8, r9);
    }

    public void warn(Marker r8, String r9, Object r10, Object r11) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r8, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, r3, r9, r10, r11);
    }

    public void warn(Marker r9, String r10, Object r11, Object r12, Object r13) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, r3, r10, r11, r12, r13);
    }

    public void warn(Marker r10, String r11, Object r12, Object r13, Object r14, Object r15) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r10, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, r3, r11, r12, r13, r14, r15);
    }

    public void warn(Marker r12, String r13, Object r14, Object r15, Object r16, Object r17, Object r18) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r12, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, r4, r13, r14, r15, r16, r17, r18);
    }

    public void warn(Marker r13, String r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r13, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, r4, r14, r15, r16, r17, r18, r19, r20);
    }

    public void warn(Marker r14, String r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r14, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, r4, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public void warn(Marker r15, String r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r15, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, r4, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public void warn(Marker r16, String r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r16, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, r4, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public void warn(Marker r17, String r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26, Object r27, Object r28) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r17, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, r4, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    }

    public void warn(Marker r7, String r8, Throwable r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, r3, r8, r9);
    }

    public void warn(Marker r7, String r8, Object... r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, r3, r8, r9);
    }

    public void warn(Marker r7, String r8, t<?>... r9) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, r3, r8, r9);
    }

    public void warn(Marker r9, Message r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        Message r6 = (Message) ZeusTransformUtils.wrapperContextForParams(r10, Message.class, "com.obric.memorydata.plugin");
        String r3 = FQCN;
        Level r4 = Level.WARN;
        if (r6 == null) goto L5;
        Throwable r11 = r6.getThrowable();
    L6:
        logIfEnabled(r3, r4, r5, r6, r11);
        return;
    L5:
        r11 = null;
        goto L6
    }

    public void warn(Marker r9, Message r10, Throwable r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        Message r6 = (Message) ZeusTransformUtils.wrapperContextForParams(r10, Message.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, r5, r6, r11);
    }

    public void warn(Marker r9, org.apache.logging.log4j.util.i r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        org.apache.logging.log4j.util.i r6 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r10, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, r5, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void warn(Marker r9, org.apache.logging.log4j.util.i r10, Throwable r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        org.apache.logging.log4j.util.i r6 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r10, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, r5, r6, r11);
    }

    public void warn(Marker r9, t<?> r10) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        t<?> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r10, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, r5, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void warn(Marker r9, t<?> r10, Throwable r11) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        t<?> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r10, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, r5, r6, r11);
    }

    public void warn(Message r7) {
        Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r7, Message.class, "com.obric.memorydata.plugin");
        String r1 = FQCN;
        Level r2 = Level.WARN;
        if (r4 == null) goto L5;
        Throwable r8 = r4.getThrowable();
    L6:
        logIfEnabled(r1, r2, null, r4, r8);
        return;
    L5:
        r8 = null;
        goto L6
    }

    public void warn(Message r7, Throwable r8) {
        Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r7, Message.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, null, r4, r8);
    }

    public void warn(org.apache.logging.log4j.util.i r9) {
        org.apache.logging.log4j.util.i r6 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r9, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, null, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void warn(org.apache.logging.log4j.util.i r7, Throwable r8) {
        org.apache.logging.log4j.util.i r4 = (org.apache.logging.log4j.util.i) ZeusTransformUtils.wrapperContextForParams(r7, org.apache.logging.log4j.util.i.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, null, r4, r8);
    }

    public void warn(t<?> r9) {
        t<?> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r9, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, null, r6, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void warn(t<?> r7, Throwable r8) {
        t<?> r4 = (t) ZeusTransformUtils.wrapperContextForParams(r7, t.class, "com.obric.memorydata.plugin");
        logIfEnabled(FQCN, Level.WARN, null, r4, r8);
    }
}
