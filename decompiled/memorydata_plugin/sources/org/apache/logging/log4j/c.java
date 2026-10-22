package org.apache.logging.log4j;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.d;

/* JADX INFO: loaded from: classes6.dex */
public interface c {
    default a atDebug() {
        return a.f17883a;
    }

    default a atError() {
        return a.f17883a;
    }

    default a atInfo() {
        return a.f17883a;
    }

    default a atLevel(Level r1) {
        return a.f17883a;
    }

    default a atTrace() {
        return a.f17883a;
    }

    default a atWarn() {
        return a.f17883a;
    }

    void debug(String r1, Object r2);

    void error(String r1);

    void error(String r1, Object r2);

    void error(String r1, Object r2, Object r3);

    void error(String r1, Object r2, Object r3, Object r4);

    void error(String r1, Throwable r2);

    void fatal(String r1, Throwable r2);

    Level getLevel();

    <MF extends d> MF getMessageFactory();

    String getName();

    void log(Level r1, String r2, Throwable r3);

    default void logMessage(Level r1, Marker r2, String r3, StackTraceElement r4, Message r5, Throwable r6) {
        Marker r0 = (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin");
        Message r7 = (Message) ZeusTransformUtils.wrapperContextForParams(r5, Message.class, "com.obric.memorydata.plugin");
    }

    void warn(String r1);

    void warn(String r1, Object r2);

    void warn(String r1, Object r2, Object r3);

    void warn(String r1, Object r2, Object r3, Object r4);
}
