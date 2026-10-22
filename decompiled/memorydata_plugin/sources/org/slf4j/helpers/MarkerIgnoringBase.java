package org.slf4j.helpers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes8.dex */
public abstract class MarkerIgnoringBase extends NamedLoggerBase implements org.slf4j.c {
    private static final long serialVersionUID = 9044267456635152283L;

    public MarkerIgnoringBase() {
    }

    public void debug(Marker r3, String r4) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        debug(r4);
    }

    public void debug(Marker r3, String r4, Object r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        debug(r4, r5);
    }

    public void debug(Marker r3, String r4, Object r5, Object r6) {
        Marker r7 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        debug(r4, r5, r6);
    }

    public void debug(Marker r3, String r4, Throwable r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        debug(r4, r5);
    }

    public void debug(Marker r3, String r4, Object... r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        debug(r4, r5);
    }

    public void error(Marker r3, String r4) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        error(r4);
    }

    public void error(Marker r3, String r4, Object r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        error(r4, r5);
    }

    public void error(Marker r3, String r4, Object r5, Object r6) {
        Marker r7 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        error(r4, r5, r6);
    }

    public void error(Marker r3, String r4, Throwable r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        error(r4, r5);
    }

    public void error(Marker r3, String r4, Object... r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        error(r4, r5);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, org.slf4j.c
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    public void info(Marker r3, String r4) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        info(r4);
    }

    public void info(Marker r3, String r4, Object r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        info(r4, r5);
    }

    public void info(Marker r3, String r4, Object r5, Object r6) {
        Marker r7 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        info(r4, r5, r6);
    }

    public void info(Marker r3, String r4, Throwable r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        info(r4, r5);
    }

    public void info(Marker r3, String r4, Object... r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        info(r4, r5);
    }

    @Override // org.slf4j.c
    public boolean isDebugEnabled(Marker r3) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        return isDebugEnabled();
    }

    @Override // org.slf4j.c
    public boolean isErrorEnabled(Marker r3) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        return isErrorEnabled();
    }

    @Override // org.slf4j.c
    public boolean isInfoEnabled(Marker r3) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        return isInfoEnabled();
    }

    @Override // org.slf4j.c
    public boolean isTraceEnabled(Marker r3) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        return isTraceEnabled();
    }

    @Override // org.slf4j.c
    public boolean isWarnEnabled(Marker r3) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        return isWarnEnabled();
    }

    public String toString() {
        return getClass().getName() + "(" + getName() + ")";
    }

    public void trace(Marker r3, String r4) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        trace(r4);
    }

    public void trace(Marker r3, String r4, Object r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        trace(r4, r5);
    }

    public void trace(Marker r3, String r4, Object r5, Object r6) {
        Marker r7 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        trace(r4, r5, r6);
    }

    public void trace(Marker r3, String r4, Throwable r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        trace(r4, r5);
    }

    public void trace(Marker r3, String r4, Object... r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        trace(r4, r5);
    }

    public void warn(Marker r3, String r4) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        warn(r4);
    }

    public void warn(Marker r3, String r4, Object r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        warn(r4, r5);
    }

    public void warn(Marker r3, String r4, Object r5, Object r6) {
        Marker r7 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        warn(r4, r5, r6);
    }

    public void warn(Marker r3, String r4, Throwable r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        warn(r4, r5);
    }

    public void warn(Marker r3, String r4, Object... r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        warn(r4, r5);
    }
}
