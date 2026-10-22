package org.apache.logging.log4j.spi;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.message.Message;

/* JADX INFO: loaded from: classes6.dex */
public interface c extends org.apache.logging.log4j.c {
    boolean isEnabled(Level r1, Marker r2, CharSequence r3, Throwable r4);

    boolean isEnabled(Level r1, Marker r2, Object r3, Throwable r4);

    boolean isEnabled(Level r1, Marker r2, String r3);

    boolean isEnabled(Level r1, Marker r2, String r3, Object r4);

    boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5);

    boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5, Object r6);

    boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5, Object r6, Object r7);

    boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5, Object r6, Object r7, Object r8);

    boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9);

    boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10);

    boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11);

    boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12);

    boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12, Object r13);

    boolean isEnabled(Level r1, Marker r2, String r3, Throwable r4);

    boolean isEnabled(Level r1, Marker r2, String r3, Object... r4);

    boolean isEnabled(Level r1, Marker r2, Message r3, Throwable r4);

    void logMessage(String r1, Level r2, Marker r3, Message r4, Throwable r5);
}
