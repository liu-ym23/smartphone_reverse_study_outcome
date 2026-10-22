package org.slf4j.event;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Queue;
import org.slf4j.Marker;
import org.slf4j.helpers.LegacyAbstractLogger;
import org.slf4j.helpers.h;

/* JADX INFO: loaded from: classes8.dex */
public class EventRecordingLogger extends LegacyAbstractLogger {
    static final boolean RECORD_ALL_EVENTS = true;
    private static final long serialVersionUID = -176083308134819629L;
    Queue<b> eventQueue;
    h logger;
    String name;

    public EventRecordingLogger(h r3, Queue<b> r4) {
        Queue<b> r5 = (Queue) ZeusTransformUtils.wrapperContextForParams(r4, Queue.class, "com.obric.memorydata.plugin");
        this.logger = r3;
        this.name = r3.getName();
        this.eventQueue = r5;
    }

    @Override // org.slf4j.helpers.AbstractLogger
    public String getFullyQualifiedCallerName() {
        return null;
    }

    @Override // org.slf4j.helpers.AbstractLogger, org.slf4j.c
    public String getName() {
        return this.name;
    }

    @Override // org.slf4j.helpers.AbstractLogger
    public void handleNormalizedLoggingCall(Level r4, Marker r5, String r6, Object[] r7, Throwable r8) {
        Marker r9 = (Marker) ZeusTransformUtils.wrapperContextForParams(r5, Marker.class, "com.obric.memorydata.plugin");
        b r0 = new b();
        r0.a(System.currentTimeMillis());
        r0.a(r4);
        r0.a(this.logger);
        r0.a(this.name);
        if (r9 == null) goto L5;
        r0.a(r9);
    L5:
        r0.b(r6);
        r0.c(Thread.currentThread().getName());
        r0.a(r7);
        r0.a(r8);
        this.eventQueue.add(r0);
    }

    @Override // org.slf4j.c
    public boolean isDebugEnabled() {
        return true;
    }

    @Override // org.slf4j.c
    public boolean isErrorEnabled() {
        return true;
    }

    @Override // org.slf4j.c
    public boolean isInfoEnabled() {
        return true;
    }

    @Override // org.slf4j.c
    public boolean isTraceEnabled() {
        return true;
    }

    @Override // org.slf4j.c
    public boolean isWarnEnabled() {
        return true;
    }
}
