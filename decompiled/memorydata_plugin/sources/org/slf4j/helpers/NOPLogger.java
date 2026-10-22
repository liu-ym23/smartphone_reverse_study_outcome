package org.slf4j.helpers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes8.dex */
public class NOPLogger extends NamedLoggerBase implements org.slf4j.c {
    public static final NOPLogger NOP_LOGGER = null;
    private static final long serialVersionUID = -517220405410904473L;

    static {
        NOP_LOGGER = new NOPLogger();
    }

    public NOPLogger() {
    }

    @Override // org.slf4j.c
    public final void debug(String r1) {
    }

    @Override // org.slf4j.c
    public final void debug(String r1, Object r2) {
    }

    @Override // org.slf4j.c
    public final void debug(String r1, Object r2, Object r3) {
    }

    @Override // org.slf4j.c
    public final void debug(String r1, Throwable r2) {
    }

    @Override // org.slf4j.c
    public final void debug(String r1, Object... r2) {
    }

    public final void debug(Marker r1, String r2) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }

    public final void debug(Marker r1, String r2, Object r3) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }

    public final void debug(Marker r1, String r2, Object r3, Object r4) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }

    public final void debug(Marker r1, String r2, Throwable r3) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }

    public final void debug(Marker r1, String r2, Object... r3) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }

    @Override // org.slf4j.c
    public final void error(String r1) {
    }

    @Override // org.slf4j.c
    public final void error(String r1, Object r2) {
    }

    @Override // org.slf4j.c
    public final void error(String r1, Object r2, Object r3) {
    }

    @Override // org.slf4j.c
    public final void error(String r1, Throwable r2) {
    }

    @Override // org.slf4j.c
    public final void error(String r1, Object... r2) {
    }

    public final void error(Marker r1, String r2) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }

    public final void error(Marker r1, String r2, Object r3) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }

    public final void error(Marker r1, String r2, Object r3, Object r4) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }

    public final void error(Marker r1, String r2, Throwable r3) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }

    public final void error(Marker r1, String r2, Object... r3) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, org.slf4j.c
    public String getName() {
        return "NOP";
    }

    @Override // org.slf4j.c
    public final void info(String r1) {
    }

    @Override // org.slf4j.c
    public final void info(String r1, Object r2) {
    }

    @Override // org.slf4j.c
    public final void info(String r1, Object r2, Object r3) {
    }

    @Override // org.slf4j.c
    public final void info(String r1, Throwable r2) {
    }

    @Override // org.slf4j.c
    public final void info(String r1, Object... r2) {
    }

    public final void info(Marker r1, String r2) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }

    public final void info(Marker r1, String r2, Object r3) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }

    public final void info(Marker r1, String r2, Object r3, Object r4) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }

    public final void info(Marker r1, String r2, Throwable r3) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }

    public final void info(Marker r1, String r2, Object... r3) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }

    @Override // org.slf4j.c
    public final boolean isDebugEnabled() {
        return false;
    }

    @Override // org.slf4j.c
    public final boolean isDebugEnabled(Marker r2) {
        Marker r1 = (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin");
        return false;
    }

    @Override // org.slf4j.c
    public final boolean isErrorEnabled() {
        return false;
    }

    @Override // org.slf4j.c
    public final boolean isErrorEnabled(Marker r2) {
        Marker r1 = (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin");
        return false;
    }

    @Override // org.slf4j.c
    public final boolean isInfoEnabled() {
        return false;
    }

    @Override // org.slf4j.c
    public boolean isInfoEnabled(Marker r2) {
        Marker r1 = (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin");
        return false;
    }

    @Override // org.slf4j.c
    public final boolean isTraceEnabled() {
        return false;
    }

    @Override // org.slf4j.c
    public final boolean isTraceEnabled(Marker r2) {
        Marker r1 = (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin");
        return false;
    }

    @Override // org.slf4j.c
    public final boolean isWarnEnabled() {
        return false;
    }

    @Override // org.slf4j.c
    public final boolean isWarnEnabled(Marker r2) {
        Marker r1 = (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin");
        return false;
    }

    @Override // org.slf4j.c
    public final void trace(String r1) {
    }

    @Override // org.slf4j.c
    public final void trace(String r1, Object r2) {
    }

    @Override // org.slf4j.c
    public final void trace(String r1, Object r2, Object r3) {
    }

    @Override // org.slf4j.c
    public final void trace(String r1, Throwable r2) {
    }

    @Override // org.slf4j.c
    public final void trace(String r1, Object... r2) {
    }

    public final void trace(Marker r1, String r2) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }

    public final void trace(Marker r1, String r2, Object r3) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }

    public final void trace(Marker r1, String r2, Object r3, Object r4) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }

    public final void trace(Marker r1, String r2, Throwable r3) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }

    public final void trace(Marker r1, String r2, Object... r3) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }

    @Override // org.slf4j.c
    public final void warn(String r1) {
    }

    @Override // org.slf4j.c
    public final void warn(String r1, Object r2) {
    }

    @Override // org.slf4j.c
    public final void warn(String r1, Object r2, Object r3) {
    }

    @Override // org.slf4j.c
    public final void warn(String r1, Throwable r2) {
    }

    @Override // org.slf4j.c
    public final void warn(String r1, Object... r2) {
    }

    public final void warn(Marker r1, String r2) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }

    public final void warn(Marker r1, String r2, Object r3) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }

    public final void warn(Marker r1, String r2, Object r3, Object r4) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }

    public final void warn(Marker r1, String r2, Throwable r3) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }

    public final void warn(Marker r1, String r2, Object... r3) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r1, Marker.class, "com.obric.memorydata.plugin");
    }
}
