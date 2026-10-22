package org.slf4j.helpers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.slf4j.Marker;
import org.slf4j.event.Level;

/* JADX INFO: loaded from: classes8.dex */
public abstract class AbstractLogger implements Serializable, org.slf4j.c {
    private static final long serialVersionUID = -2529255052481744503L;
    protected String name;

    public AbstractLogger() {
    }

    private void handle2ArgsCall(Level r9, Marker r10, String r11, Object r12, Object r13) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r10, Marker.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, Throwable.class) == false) goto L5;
        handleNormalizedLoggingCall(r9, r4, r11, new Object[]{r12}, (Throwable) ZeusTransformUtils.preCheckCast(r13, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        handleNormalizedLoggingCall(r9, r4, r11, new Object[]{r12, r13}, null);
    }

    private void handleArgArrayCall(Level r7, Marker r8, String r9, Object[] r10) {
        Marker r2 = (Marker) ZeusTransformUtils.wrapperContextForParams(r8, Marker.class, "com.obric.memorydata.plugin");
        Throwable r5 = c.a(r10);
        if (r5 == null) goto L5;
        handleNormalizedLoggingCall(r7, r2, r9, c.b(r10), r5);
        return;
    L5:
        handleNormalizedLoggingCall(r7, r2, r9, r10, null);
    }

    private void handle_0ArgsCall(Level r7, Marker r8, String r9, Throwable r10) {
        handleNormalizedLoggingCall(r7, (Marker) ZeusTransformUtils.wrapperContextForParams(r8, Marker.class, "com.obric.memorydata.plugin"), r9, null, r10);
    }

    private void handle_1ArgsCall(Level r7, Marker r8, String r9, Object r10) {
        handleNormalizedLoggingCall(r7, (Marker) ZeusTransformUtils.wrapperContextForParams(r8, Marker.class, "com.obric.memorydata.plugin"), r9, new Object[]{r10}, null);
    }

    @Override // org.slf4j.c
    public void debug(String r3) {
        if (isDebugEnabled() == false) goto L6;
        handle_0ArgsCall(Level.DEBUG, null, r3, null);
        return;
    }

    @Override // org.slf4j.c
    public void debug(String r3, Object r4) {
        if (isDebugEnabled() == false) goto L6;
        handle_1ArgsCall(Level.DEBUG, null, r3, r4);
        return;
    }

    @Override // org.slf4j.c
    public void debug(String r8, Object r9, Object r10) {
        if (isDebugEnabled() == false) goto L6;
        handle2ArgsCall(Level.DEBUG, null, r8, r9, r10);
        return;
    }

    @Override // org.slf4j.c
    public void debug(String r3, Throwable r4) {
        if (isDebugEnabled() == false) goto L6;
        handle_0ArgsCall(Level.DEBUG, null, r3, r4);
        return;
    }

    @Override // org.slf4j.c
    public void debug(String r3, Object... r4) {
        if (isDebugEnabled() == false) goto L6;
        handleArgArrayCall(Level.DEBUG, null, r3, r4);
        return;
    }

    public void debug(Marker r3, String r4) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        if (isDebugEnabled(r5) == false) goto L6;
        handle_0ArgsCall(Level.DEBUG, r5, r4, null);
        return;
    }

    public void debug(Marker r3, String r4, Object r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        if (isDebugEnabled(r6) == false) goto L6;
        handle_1ArgsCall(Level.DEBUG, r6, r4, r5);
        return;
    }

    public void debug(Marker r7, String r8, Object r9, Object r10) {
        Marker r2 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        if (isDebugEnabled(r2) == false) goto L6;
        handle2ArgsCall(Level.DEBUG, r2, r8, r9, r10);
        return;
    }

    public void debug(Marker r3, String r4, Throwable r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        if (isDebugEnabled(r6) == false) goto L6;
        handle_0ArgsCall(Level.DEBUG, r6, r4, r5);
        return;
    }

    public void debug(Marker r3, String r4, Object... r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        if (isDebugEnabled(r6) == false) goto L6;
        handleArgArrayCall(Level.DEBUG, r6, r4, r5);
        return;
    }

    @Override // org.slf4j.c
    public void error(String r3) {
        if (isErrorEnabled() == false) goto L6;
        handle_0ArgsCall(Level.ERROR, null, r3, null);
        return;
    }

    @Override // org.slf4j.c
    public void error(String r3, Object r4) {
        if (isErrorEnabled() == false) goto L6;
        handle_1ArgsCall(Level.ERROR, null, r3, r4);
        return;
    }

    @Override // org.slf4j.c
    public void error(String r8, Object r9, Object r10) {
        if (isErrorEnabled() == false) goto L6;
        handle2ArgsCall(Level.ERROR, null, r8, r9, r10);
        return;
    }

    @Override // org.slf4j.c
    public void error(String r3, Throwable r4) {
        if (isErrorEnabled() == false) goto L6;
        handle_0ArgsCall(Level.ERROR, null, r3, r4);
        return;
    }

    @Override // org.slf4j.c
    public void error(String r3, Object... r4) {
        if (isErrorEnabled() == false) goto L6;
        handleArgArrayCall(Level.ERROR, null, r3, r4);
        return;
    }

    public void error(Marker r3, String r4) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        if (isErrorEnabled(r5) == false) goto L6;
        handle_0ArgsCall(Level.ERROR, r5, r4, null);
        return;
    }

    public void error(Marker r3, String r4, Object r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        if (isErrorEnabled(r6) == false) goto L6;
        handle_1ArgsCall(Level.ERROR, r6, r4, r5);
        return;
    }

    public void error(Marker r7, String r8, Object r9, Object r10) {
        Marker r2 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        if (isErrorEnabled(r2) == false) goto L6;
        handle2ArgsCall(Level.ERROR, r2, r8, r9, r10);
        return;
    }

    public void error(Marker r3, String r4, Throwable r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        if (isErrorEnabled(r6) == false) goto L6;
        handle_0ArgsCall(Level.ERROR, r6, r4, r5);
        return;
    }

    public void error(Marker r3, String r4, Object... r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        if (isErrorEnabled(r6) == false) goto L6;
        handleArgArrayCall(Level.ERROR, r6, r4, r5);
        return;
    }

    public abstract String getFullyQualifiedCallerName();

    public String getName() {
        return this.name;
    }

    public abstract void handleNormalizedLoggingCall(Level r1, Marker r2, String r3, Object[] r4, Throwable r5);

    @Override // org.slf4j.c
    public void info(String r3) {
        if (isInfoEnabled() == false) goto L6;
        handle_0ArgsCall(Level.INFO, null, r3, null);
        return;
    }

    @Override // org.slf4j.c
    public void info(String r3, Object r4) {
        if (isInfoEnabled() == false) goto L6;
        handle_1ArgsCall(Level.INFO, null, r3, r4);
        return;
    }

    @Override // org.slf4j.c
    public void info(String r8, Object r9, Object r10) {
        if (isInfoEnabled() == false) goto L6;
        handle2ArgsCall(Level.INFO, null, r8, r9, r10);
        return;
    }

    @Override // org.slf4j.c
    public void info(String r3, Throwable r4) {
        if (isInfoEnabled() == false) goto L6;
        handle_0ArgsCall(Level.INFO, null, r3, r4);
        return;
    }

    @Override // org.slf4j.c
    public void info(String r3, Object... r4) {
        if (isInfoEnabled() == false) goto L6;
        handleArgArrayCall(Level.INFO, null, r3, r4);
        return;
    }

    public void info(Marker r3, String r4) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        if (isInfoEnabled(r5) == false) goto L6;
        handle_0ArgsCall(Level.INFO, r5, r4, null);
        return;
    }

    public void info(Marker r3, String r4, Object r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        if (isInfoEnabled(r6) == false) goto L6;
        handle_1ArgsCall(Level.INFO, r6, r4, r5);
        return;
    }

    public void info(Marker r7, String r8, Object r9, Object r10) {
        Marker r2 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        if (isInfoEnabled(r2) == false) goto L6;
        handle2ArgsCall(Level.INFO, r2, r8, r9, r10);
        return;
    }

    public void info(Marker r3, String r4, Throwable r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        if (isInfoEnabled(r6) == false) goto L6;
        handle_0ArgsCall(Level.INFO, r6, r4, r5);
        return;
    }

    public void info(Marker r3, String r4, Object... r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        if (isInfoEnabled(r6) == false) goto L6;
        handleArgArrayCall(Level.INFO, r6, r4, r5);
        return;
    }

    public Object readResolve() {
        return org.slf4j.d.a(getName());
    }

    @Override // org.slf4j.c
    public void trace(String r3) {
        if (isTraceEnabled() == false) goto L6;
        handle_0ArgsCall(Level.TRACE, null, r3, null);
        return;
    }

    @Override // org.slf4j.c
    public void trace(String r3, Object r4) {
        if (isTraceEnabled() == false) goto L6;
        handle_1ArgsCall(Level.TRACE, null, r3, r4);
        return;
    }

    @Override // org.slf4j.c
    public void trace(String r8, Object r9, Object r10) {
        if (isTraceEnabled() == false) goto L6;
        handle2ArgsCall(Level.TRACE, null, r8, r9, r10);
        return;
    }

    @Override // org.slf4j.c
    public void trace(String r3, Throwable r4) {
        if (isTraceEnabled() == false) goto L6;
        handle_0ArgsCall(Level.TRACE, null, r3, r4);
        return;
    }

    @Override // org.slf4j.c
    public void trace(String r3, Object... r4) {
        if (isTraceEnabled() == false) goto L6;
        handleArgArrayCall(Level.TRACE, null, r3, r4);
        return;
    }

    public void trace(Marker r3, String r4) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        if (isTraceEnabled(r5) == false) goto L6;
        handle_0ArgsCall(Level.TRACE, r5, r4, null);
        return;
    }

    public void trace(Marker r3, String r4, Object r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        if (isTraceEnabled(r6) == false) goto L6;
        handle_1ArgsCall(Level.TRACE, r6, r4, r5);
        return;
    }

    public void trace(Marker r7, String r8, Object r9, Object r10) {
        Marker r2 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        if (isTraceEnabled(r2) == false) goto L6;
        handle2ArgsCall(Level.TRACE, r2, r8, r9, r10);
        return;
    }

    public void trace(Marker r3, String r4, Throwable r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        if (isTraceEnabled(r6) == false) goto L6;
        handle_0ArgsCall(Level.TRACE, r6, r4, r5);
        return;
    }

    public void trace(Marker r3, String r4, Object... r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        if (isTraceEnabled(r6) == false) goto L6;
        handleArgArrayCall(Level.TRACE, r6, r4, r5);
        return;
    }

    @Override // org.slf4j.c
    public void warn(String r3) {
        if (isWarnEnabled() == false) goto L6;
        handle_0ArgsCall(Level.WARN, null, r3, null);
        return;
    }

    @Override // org.slf4j.c
    public void warn(String r3, Object r4) {
        if (isWarnEnabled() == false) goto L6;
        handle_1ArgsCall(Level.WARN, null, r3, r4);
        return;
    }

    @Override // org.slf4j.c
    public void warn(String r8, Object r9, Object r10) {
        if (isWarnEnabled() == false) goto L6;
        handle2ArgsCall(Level.WARN, null, r8, r9, r10);
        return;
    }

    @Override // org.slf4j.c
    public void warn(String r3, Throwable r4) {
        if (isWarnEnabled() == false) goto L6;
        handle_0ArgsCall(Level.WARN, null, r3, r4);
        return;
    }

    @Override // org.slf4j.c
    public void warn(String r3, Object... r4) {
        if (isWarnEnabled() == false) goto L6;
        handleArgArrayCall(Level.WARN, null, r3, r4);
        return;
    }

    public void warn(Marker r3, String r4) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        if (isWarnEnabled(r5) == false) goto L6;
        handle_0ArgsCall(Level.WARN, r5, r4, null);
        return;
    }

    public void warn(Marker r3, String r4, Object r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        if (isWarnEnabled(r6) == false) goto L6;
        handle_1ArgsCall(Level.WARN, r6, r4, r5);
        return;
    }

    public void warn(Marker r7, String r8, Object r9, Object r10) {
        Marker r2 = (Marker) ZeusTransformUtils.wrapperContextForParams(r7, Marker.class, "com.obric.memorydata.plugin");
        if (isWarnEnabled(r2) == false) goto L6;
        handle2ArgsCall(Level.WARN, r2, r8, r9, r10);
        return;
    }

    public void warn(Marker r3, String r4, Throwable r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        if (isWarnEnabled(r6) == false) goto L6;
        handle_0ArgsCall(Level.WARN, r6, r4, r5);
        return;
    }

    public void warn(Marker r3, String r4, Object... r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        if (isWarnEnabled(r6) == false) goto L6;
        handleArgArrayCall(Level.WARN, r6, r4, r5);
        return;
    }
}
