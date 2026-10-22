package org.slf4j.helpers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.Queue;
import org.slf4j.Marker;
import org.slf4j.event.EventRecordingLogger;
import org.slf4j.event.Level;

/* JADX INFO: loaded from: classes8.dex */
public class h implements org.slf4j.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f20271b;
    private volatile org.slf4j.c c;
    private Boolean d;
    private Method e;
    private EventRecordingLogger f;
    private final Queue<org.slf4j.event.b> g;

    public h(String r3, Queue<org.slf4j.event.b> r4, boolean r5) {
        Queue<org.slf4j.event.b> r6 = (Queue) ZeusTransformUtils.wrapperContextForParams(r4, Queue.class, "com.obric.memorydata.plugin");
        this.f20271b = r3;
        this.g = r6;
        this.f20270a = r5;
    }

    private org.slf4j.c e() {
        if (this.f != null) goto L6;
        this.f = new EventRecordingLogger(this, this.g);
    L6:
        return this.f;
    }

    public org.slf4j.c a() {
        if (this.c == null) goto L7;
        return this.c;
    L7:
        if (this.f20270a == false) goto L11;
        return NOPLogger.NOP_LOGGER;
    L11:
        return e();
    }

    public void a(org.slf4j.c r3) {
        this.c = (org.slf4j.c) ZeusTransformUtils.wrapperContextForParams(r3, org.slf4j.c.class, "com.obric.memorydata.plugin");
    }

    public void a(org.slf4j.event.a r4) {
        org.slf4j.event.a r5 = (org.slf4j.event.a) ZeusTransformUtils.wrapperContextForParams(r4, org.slf4j.event.a.class, "com.obric.memorydata.plugin");
        if (b() == false) goto L9;
        this.e.invoke(this.c, new Object[]{r5});     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    @Override // org.slf4j.c
    public boolean a(Level r1) {
        return a().a(r1);
    }

    public boolean b() {
        Boolean r0 = this.d;
        if (r0 != null) goto L5;
        this.e = this.c.getClass().getMethod("log", new Class[]{org.slf4j.event.a.class});     // Catch: NoSuchMethodException -> L8
        this.d = Boolean.TRUE;     // Catch: NoSuchMethodException -> L8
    L10:
        return this.d.booleanValue();
    L8:
        this.d = Boolean.FALSE;
        goto L10
    L5:
        return r0.booleanValue();
    }

    public boolean c() {
        if (this.c != null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean d() {
        return ZeusTransformUtils.instanceOf(this.c, NOPLogger.class);
    }

    @Override // org.slf4j.c
    public void debug(String r1) {
        a().debug(r1);
    }

    @Override // org.slf4j.c
    public void debug(String r1, Object r2) {
        a().debug(r1, r2);
    }

    @Override // org.slf4j.c
    public void debug(String r1, Object r2, Object r3) {
        a().debug(r1, r2, r3);
    }

    @Override // org.slf4j.c
    public void debug(String r1, Throwable r2) {
        a().debug(r1, r2);
    }

    @Override // org.slf4j.c
    public void debug(String r1, Object... r2) {
        a().debug(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L14:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L14;
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.memorydata.plugin");
        if (this.f20271b.equals(r6.f20271b) == true) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // org.slf4j.c
    public void error(String r1) {
        a().error(r1);
    }

    @Override // org.slf4j.c
    public void error(String r1, Object r2) {
        a().error(r1, r2);
    }

    @Override // org.slf4j.c
    public void error(String r1, Object r2, Object r3) {
        a().error(r1, r2, r3);
    }

    @Override // org.slf4j.c
    public void error(String r1, Throwable r2) {
        a().error(r1, r2);
    }

    @Override // org.slf4j.c
    public void error(String r1, Object... r2) {
        a().error(r1, r2);
    }

    @Override // org.slf4j.c
    public String getName() {
        return this.f20271b;
    }

    public int hashCode() {
        return this.f20271b.hashCode();
    }

    @Override // org.slf4j.c
    public void info(String r1) {
        a().info(r1);
    }

    @Override // org.slf4j.c
    public void info(String r1, Object r2) {
        a().info(r1, r2);
    }

    @Override // org.slf4j.c
    public void info(String r1, Object r2, Object r3) {
        a().info(r1, r2, r3);
    }

    @Override // org.slf4j.c
    public void info(String r1, Throwable r2) {
        a().info(r1, r2);
    }

    @Override // org.slf4j.c
    public void info(String r1, Object... r2) {
        a().info(r1, r2);
    }

    @Override // org.slf4j.c
    public boolean isDebugEnabled() {
        return a().isDebugEnabled();
    }

    @Override // org.slf4j.c
    public boolean isDebugEnabled(Marker r3) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        return a().isDebugEnabled(r4);
    }

    @Override // org.slf4j.c
    public boolean isErrorEnabled() {
        return a().isErrorEnabled();
    }

    @Override // org.slf4j.c
    public boolean isErrorEnabled(Marker r3) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        return a().isErrorEnabled(r4);
    }

    @Override // org.slf4j.c
    public boolean isInfoEnabled() {
        return a().isInfoEnabled();
    }

    @Override // org.slf4j.c
    public boolean isInfoEnabled(Marker r3) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        return a().isInfoEnabled(r4);
    }

    @Override // org.slf4j.c
    public boolean isTraceEnabled() {
        return a().isTraceEnabled();
    }

    @Override // org.slf4j.c
    public boolean isTraceEnabled(Marker r3) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        return a().isTraceEnabled(r4);
    }

    @Override // org.slf4j.c
    public boolean isWarnEnabled() {
        return a().isWarnEnabled();
    }

    @Override // org.slf4j.c
    public boolean isWarnEnabled(Marker r3) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        return a().isWarnEnabled(r4);
    }

    @Override // org.slf4j.c
    public void trace(String r1) {
        a().trace(r1);
    }

    @Override // org.slf4j.c
    public void trace(String r1, Object r2) {
        a().trace(r1, r2);
    }

    @Override // org.slf4j.c
    public void trace(String r1, Object r2, Object r3) {
        a().trace(r1, r2, r3);
    }

    @Override // org.slf4j.c
    public void trace(String r1, Throwable r2) {
        a().trace(r1, r2);
    }

    @Override // org.slf4j.c
    public void trace(String r1, Object... r2) {
        a().trace(r1, r2);
    }

    @Override // org.slf4j.c
    public void warn(String r1) {
        a().warn(r1);
    }

    @Override // org.slf4j.c
    public void warn(String r1, Object r2) {
        a().warn(r1, r2);
    }

    @Override // org.slf4j.c
    public void warn(String r1, Object r2, Object r3) {
        a().warn(r1, r2, r3);
    }

    @Override // org.slf4j.c
    public void warn(String r1, Throwable r2) {
        a().warn(r1, r2);
    }

    @Override // org.slf4j.c
    public void warn(String r1, Object... r2) {
        a().warn(r1, r2);
    }
}
