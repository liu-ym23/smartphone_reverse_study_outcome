package org.slf4j;

import org.slf4j.event.Level;

/* JADX INFO: loaded from: classes8.dex */
public interface c {
    default boolean a(Level r3) {
        int r0 = r3.toInt();
        if (r0 == 0) goto L23;
        if (r0 == 10) goto L21;
        if (r0 == 20) goto L19;
        if (r0 == 30) goto L17;
        if (r0 != 40) goto L15;
        return isErrorEnabled();
    L15:
        throw new IllegalArgumentException("Level [" + r3 + "] not recognized.");
    L17:
        return isWarnEnabled();
    L19:
        return isInfoEnabled();
    L21:
        return isDebugEnabled();
    L23:
        return isTraceEnabled();
    }

    void debug(String r1);

    void debug(String r1, Object r2);

    void debug(String r1, Object r2, Object r3);

    void debug(String r1, Throwable r2);

    void debug(String r1, Object... r2);

    void error(String r1);

    void error(String r1, Object r2);

    void error(String r1, Object r2, Object r3);

    void error(String r1, Throwable r2);

    void error(String r1, Object... r2);

    String getName();

    void info(String r1);

    void info(String r1, Object r2);

    void info(String r1, Object r2, Object r3);

    void info(String r1, Throwable r2);

    void info(String r1, Object... r2);

    boolean isDebugEnabled();

    boolean isDebugEnabled(Marker r1);

    boolean isErrorEnabled();

    boolean isErrorEnabled(Marker r1);

    boolean isInfoEnabled();

    boolean isInfoEnabled(Marker r1);

    boolean isTraceEnabled();

    boolean isTraceEnabled(Marker r1);

    boolean isWarnEnabled();

    boolean isWarnEnabled(Marker r1);

    void trace(String r1);

    void trace(String r1, Object r2);

    void trace(String r1, Object r2, Object r3);

    void trace(String r1, Throwable r2);

    void trace(String r1, Object... r2);

    void warn(String r1);

    void warn(String r1, Object r2);

    void warn(String r1, Object r2, Object r3);

    void warn(String r1, Throwable r2);

    void warn(String r1, Object... r2);
}
