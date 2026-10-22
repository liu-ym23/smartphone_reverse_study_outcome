package org.slf4j.helpers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes8.dex */
public abstract class LegacyAbstractLogger extends AbstractLogger {
    private static final long serialVersionUID = -7041884104854048950L;

    public LegacyAbstractLogger() {
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
}
