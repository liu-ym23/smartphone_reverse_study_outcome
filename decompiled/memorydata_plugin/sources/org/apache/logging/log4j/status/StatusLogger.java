package org.apache.logging.log4j.status;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.ParameterizedNoReferenceMessageFactory;
import org.apache.logging.log4j.message.d;
import org.apache.logging.log4j.simple.SimpleLogger;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.apache.logging.log4j.util.s;

/* JADX INFO: loaded from: classes6.dex */
public final class StatusLogger extends AbstractLogger {
    private static final String DEFAULT_STATUS_LEVEL = null;
    public static final String DEFAULT_STATUS_LISTENER_LEVEL = "log4j2.StatusLogger.level";
    private static final int MAX_ENTRIES = 0;
    public static final String MAX_STATUS_ENTRIES = "log4j2.status.entries";
    private static final String NOT_AVAIL = "?";
    private static final PropertiesUtil PROPS = null;
    public static final String STATUS_DATE_FORMAT = "log4j2.StatusLogger.DateFormat";
    private static final StatusLogger STATUS_LOGGER = null;
    private static final long serialVersionUID = 2;
    private final Collection<a> listeners;
    private int listenersLevel;
    private final ReadWriteLock listenersLock;
    private final SimpleLogger logger;
    private final Queue<StatusData> messages;
    private final Lock msgLock;

    private class BoundedQueue<E> extends ConcurrentLinkedQueue<E> {
        private static final long serialVersionUID = -3945953719763255337L;
        private final int size;
        final /* synthetic */ StatusLogger this$0;

        BoundedQueue(StatusLogger r1, int r2) {
            this.this$0 = r1;
            this.size = r2;
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
        public boolean add(E r2) {
            super.add(r2);
        L3:
            int r3 = StatusLogger.access$000(this.this$0).size();
            int r0 = this.size;
            if (r3 <= r0) goto L6;
            StatusLogger.access$000(this.this$0).poll();
            goto L3
        L6:
            if (r0 <= 0) goto L8;
            return true;
        L8:
            return false;
        }
    }

    static {
        PropertiesUtil r0 = new PropertiesUtil("log4j2.StatusLogger.properties");
        PROPS = r0;
        MAX_ENTRIES = r0.a(MAX_STATUS_ENTRIES, 200);
        DEFAULT_STATUS_LEVEL = r0.b(DEFAULT_STATUS_LISTENER_LEVEL);
        STATUS_LOGGER = new StatusLogger(StatusLogger.class.getName(), ParameterizedNoReferenceMessageFactory.INSTANCE);
    }

    private StatusLogger(String r12, d r13) {
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r13, d.class, "com.obric.memorydata.plugin");
        super(r12, r8);
        this.listeners = new CopyOnWriteArrayList();
        this.listenersLock = new ReentrantReadWriteLock();
        this.messages = new BoundedQueue(this, MAX_ENTRIES);
        this.msgLock = new ReentrantLock();
        PropertiesUtil r9 = PROPS;
        String r7 = r9.a(STATUS_DATE_FORMAT, "");
        boolean r5 = !s.a(r7);
        if (isDebugPropertyEnabled() == false) goto L5;
        Level r14 = Level.TRACE;
    L6:
        this.logger = new SimpleLogger("StatusLogger", r14, false, true, r5, false, r7, r8, r9, System.err);
        this.listenersLevel = Level.toLevel(DEFAULT_STATUS_LEVEL, Level.WARN).intLevel();
        return;
    L5:
        r14 = Level.ERROR;
        goto L6
    }

    static /* synthetic */ Queue access$000(StatusLogger r0) {
        return r0.messages;
    }

    private static void closeSilently(Closeable r2) {
        ((Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin")).close();     // Catch: IOException -> L5
        return;
    }

    public static StatusLogger getLogger() {
        return STATUS_LOGGER;
    }

    private StackTraceElement getStackTraceElement(String r7, StackTraceElement[] r8) {
        if (r7 != null) goto L5;
        return null;
    L5:
        int r0 = r8.length;
        int r1 = 0;
        boolean r2 = false;
    L6:
        if (r1 >= r0) goto L19;
        StackTraceElement r3 = r8[r1];
        String r4 = r3.getClassName();
        if (r2 == false) goto L13;
        if (r7.equals(r4) == true) goto L13;
        return r3;
    L13:
        if (r7.equals(r4) == false) goto L16;
        r2 = true;
    L18:
        r1 = r1 + 1;
        goto L6
    L16:
        if (NOT_AVAIL.equals(r4) == false) goto L18;
    L19:
        return null;
    }

    private boolean isDebugPropertyEnabled() {
        return PropertiesUtil.a().a("log4j2.debug", false, true);
    }

    public void clear() {
        this.msgLock.lock();
        this.messages.clear();     // Catch: Throwable -> L6
        this.msgLock.unlock();
        return;
    L6:
        th = move-exception;
        this.msgLock.unlock();
        throw th;
    }

    @Override // org.apache.logging.log4j.c
    public Level getLevel() {
        return this.logger.getLevel();
    }

    public Iterable<a> getListeners() {
        return this.listeners;
    }

    public List<StatusData> getStatusData() {
        this.msgLock.lock();
        ArrayList r0 = new ArrayList(this.messages);     // Catch: Throwable -> L6
        this.msgLock.unlock();
        return r0;
    L6:
        th = move-exception;
        this.msgLock.unlock();
        throw th;
    }

    @Override // org.apache.logging.log4j.spi.AbstractLogger
    public boolean isEnabled(Level r3, Marker r4) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r4, Marker.class, "com.obric.memorydata.plugin");
        if (isDebugPropertyEnabled() == false) goto L6;
        return true;
    L6:
        if (this.listeners.size() <= 0) goto L13;
        if (this.listenersLevel >= r3.intLevel()) goto L14;
        return false;
    L14:
        return true;
    L13:
        return this.logger.isEnabled(r3, r5);
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r2, Marker r3, CharSequence r4, Throwable r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        return isEnabled(r2, r6);
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, Object r3, Throwable r4) {
        return isEnabled(r1, (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r2, Marker r3, String r4) {
        return isEnabled(r2, (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, String r3, Object r4) {
        return isEnabled(r1, (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5) {
        return isEnabled(r1, (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5, Object r6) {
        return isEnabled(r1, (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5, Object r6, Object r7) {
        return isEnabled(r1, (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5, Object r6, Object r7, Object r8) {
        return isEnabled(r1, (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9) {
        return isEnabled(r1, (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10) {
        return isEnabled(r1, (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11) {
        return isEnabled(r1, (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12) {
        return isEnabled(r1, (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12, Object r13) {
        return isEnabled(r1, (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, String r3, Throwable r4) {
        return isEnabled(r1, (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, String r3, Object... r4) {
        return isEnabled(r1, (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r2, Marker r3, Message r4, Throwable r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        Message r7 = (Message) ZeusTransformUtils.wrapperContextForParams(r4, Message.class, "com.obric.memorydata.plugin");
        return isEnabled(r2, r6);
    }

    @Override // org.apache.logging.log4j.spi.c
    public void logMessage(String r13, Level r14, Marker r15, Message r16, Throwable r17) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r15, Marker.class, "com.obric.memorydata.plugin");
        Message r11 = (Message) ZeusTransformUtils.wrapperContextForParams(r16, Message.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L5;
        StackTraceElement r2 = getStackTraceElement(r13, Thread.currentThread().getStackTrace());
    L6:
        StatusData r3 = new StatusData(r2, r14, r11, r17, null);
        this.msgLock.lock();
        this.messages.add(r3);     // Catch: Throwable -> L21
        this.msgLock.unlock();
        if (isDebugPropertyEnabled() == false) goto L11;
    L19:
        this.logger.logMessage(r13, r14, r4, r11, r17);
        return;
    L11:
        if (this.listeners.size() <= 0) goto L19;
        Iterator<a> r0 = this.listeners.iterator();
    L15:
        if (r0.hasNext() == false) goto L31;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.memorydata.plugin");
        if (r3.getLevel().isMoreSpecificThan(r1.a()) == false) goto L15;
        r1.a(r3);
        goto L15
    L31:
        return;
    L21:
        th = move-exception;
        this.msgLock.unlock();
        throw th;
    L5:
        r2 = null;
        goto L6
    }

    public void registerListener(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        this.listenersLock.writeLock().lock();
        this.listeners.add(r4);     // Catch: Throwable -> L8
        Level r5 = r4.a();     // Catch: Throwable -> L8
        if (this.listenersLevel >= r5.intLevel()) goto L6;
        this.listenersLevel = r5.intLevel();     // Catch: Throwable -> L8
    L6:
        this.listenersLock.writeLock().unlock();
        return;
    L8:
        th = move-exception;
        this.listenersLock.writeLock().unlock();
        throw th;
    }

    public void removeListener(a r5) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");
        closeSilently(r6);
        this.listenersLock.writeLock().lock();
        this.listeners.remove(r6);     // Catch: Throwable -> L12
        int r7 = Level.toLevel(DEFAULT_STATUS_LEVEL, Level.WARN).intLevel();     // Catch: Throwable -> L12
        Iterator<a> r0 = this.listeners.iterator();     // Catch: Throwable -> L12
    L5:
        if (r0.hasNext() == false) goto L9;
        int r2 = ((a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.memorydata.plugin")).a().intLevel();     // Catch: Throwable -> L12
        if (r7 >= r2) goto L5;
        r7 = r2;
        goto L5
    L9:
        this.listenersLevel = r7;     // Catch: Throwable -> L12
        this.listenersLock.writeLock().unlock();
        return;
    L12:
        th = move-exception;
        this.listenersLock.writeLock().unlock();
        throw th;
    }

    public void reset() {
        this.listenersLock.writeLock().lock();
        Iterator<a> r0 = this.listeners.iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L8;
        closeSilently((a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
        goto L5
    L8:
        this.listeners.clear();
        this.listenersLock.writeLock().unlock();
        clear();
        return;
    L10:
        th = move-exception;
        this.listeners.clear();
        this.listenersLock.writeLock().unlock();
        clear();
        throw th;
    }

    public void setLevel(Level r1) {
        this.logger.setLevel(r1);
    }

    public void updateListenerLevel(Level r3) {
        if (r3.intLevel() <= this.listenersLevel) goto L6;
        this.listenersLevel = r3.intLevel();
        return;
    }
}
