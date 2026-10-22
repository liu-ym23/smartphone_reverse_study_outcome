package org.apache.logging.log4j.spi;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.message.Message;

/* JADX INFO: loaded from: classes6.dex */
public interface e {
    void logMessage(Level r1, Marker r2, String r3, StackTraceElement r4, Message r5, Throwable r6);
}
