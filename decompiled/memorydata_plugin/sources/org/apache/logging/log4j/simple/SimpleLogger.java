package org.apache.logging.log4j.simple;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.d;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.apache.logging.log4j.util.s;

/* JADX INFO: loaded from: classes6.dex */
public class SimpleLogger extends AbstractLogger {
    private static final char SPACE = ' ';
    private static final long serialVersionUID = 1;
    private final DateFormat dateFormatter;
    private Level level;
    private final String logName;
    private final boolean showContextMap;
    private final boolean showDateTime;
    private PrintStream stream;

    public SimpleLogger(String r3, Level r4, boolean r5, boolean r6, boolean r7, boolean r8, String r9, d r10, PropertiesUtil r11, PrintStream r12) {
        super(r3, (d) ZeusTransformUtils.wrapperContextForParams(r10, d.class, "com.obric.memorydata.plugin"));
        this.level = Level.toLevel(r11.b("org.apache.logging.log4j.simplelog." + r3 + ".level"), r4);
        if (r6 == false) goto L9;
        int r13 = r3.lastIndexOf(".");
        if (r13 > 0) goto L7;
    L10:
        this.logName = r3;
    L12:
        this.showDateTime = r7;
        this.showContextMap = r8;
        this.stream = r12;
        if (r7 == true) goto L20;
        this.dateFormatter = null;
        return;
    L20:
        SimpleDateFormat r14 = new SimpleDateFormat(r9);     // Catch: IllegalArgumentException -> L16
    L17:
        this.dateFormatter = r14;
        return;
    L16:
        r14 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS zzz");
        goto L17
    L7:
        if (r13 >= r3.length()) goto L10;
        r3 = r3.substring(r13 + 1);
        goto L10
    L9:
        if (r5 == true) goto L10;
        this.logName = null;
        goto L12
    }

    @Override // org.apache.logging.log4j.c
    public Level getLevel() {
        return this.level;
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r2, Marker r3, CharSequence r4, Throwable r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (this.level.intLevel() < r2.intLevel()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, Object r3, Throwable r4) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin");
        if (this.level.intLevel() < r1.intLevel()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r2, Marker r3, String r4) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        if (this.level.intLevel() < r2.intLevel()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, String r3, Object r4) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin");
        if (this.level.intLevel() < r1.intLevel()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin");
        if (this.level.intLevel() < r1.intLevel()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5, Object r6) {
        Marker r7 = (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin");
        if (this.level.intLevel() < r1.intLevel()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5, Object r6, Object r7) {
        Marker r8 = (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin");
        if (this.level.intLevel() < r1.intLevel()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5, Object r6, Object r7, Object r8) {
        Marker r9 = (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin");
        if (this.level.intLevel() < r1.intLevel()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9) {
        Marker r10 = (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin");
        if (this.level.intLevel() < r1.intLevel()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10) {
        Marker r11 = (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin");
        if (this.level.intLevel() < r1.intLevel()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11) {
        Marker r12 = (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin");
        if (this.level.intLevel() < r1.intLevel()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12) {
        Marker r13 = (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin");
        if (this.level.intLevel() < r1.intLevel()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12, Object r13) {
        Marker r14 = (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin");
        if (this.level.intLevel() < r1.intLevel()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, String r3, Throwable r4) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin");
        if (this.level.intLevel() < r1.intLevel()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r1, Marker r2, String r3, Object... r4) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r2, Marker.class, "com.obric.memorydata.plugin");
        if (this.level.intLevel() < r1.intLevel()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r2, Marker r3, Message r4, Throwable r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        Message r7 = (Message) ZeusTransformUtils.wrapperContextForParams(r4, Message.class, "com.obric.memorydata.plugin");
        if (this.level.intLevel() < r2.intLevel()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.logging.log4j.spi.c
    public void logMessage(String r4, Level r5, Marker r6, Message r7, Throwable r8) {
        Marker r9 = (Marker) ZeusTransformUtils.wrapperContextForParams(r6, Marker.class, "com.obric.memorydata.plugin");
        Message r10 = (Message) ZeusTransformUtils.wrapperContextForParams(r7, Message.class, "com.obric.memorydata.plugin");
        StringBuilder r11 = new StringBuilder();
        if (this.showDateTime == false) goto L12;
        Date r12 = new Date();
        DateFormat r1 = this.dateFormatter;
        monitor-enter(r1);
        String r13 = this.dateFormatter.format(r12);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        r11.append(r13);
        r11.append(SPACE);
    L9:
        th = move-exception;
        throw th;
    L12:
        r11.append(r5.toString());
        r11.append(SPACE);
        if (s.b(this.logName) == false) goto L15;
        r11.append(this.logName);
        r11.append(SPACE);
    L15:
        r11.append(r10.getFormattedMessage());
        if (this.showContextMap == false) goto L20;
        Map<String, String> r14 = ThreadContext.b();
        if (r14.size() <= 0) goto L20;
        r11.append(SPACE);
        r11.append(r14.toString());
        r11.append(SPACE);
    L20:
        Object[] r15 = r10.getParameters();
        if (r8 != null) goto L28;
        if (r15 == null) goto L28;
        if (r15.length <= 0) goto L28;
        if (ZeusTransformUtils.instanceOf(r15[r15.length - 1], Throwable.class) == false) goto L28;
        r8 = (Throwable) ZeusTransformUtils.preCheckCast(r15[r15.length - 1], Throwable.class, "com.obric.memorydata.plugin");
    L28:
        this.stream.println(r11.toString());
        if (r8 == null) goto L34;
        this.stream.print(SPACE);
        r8.printStackTrace(this.stream);
        return;
    }

    public void setLevel(Level r1) {
        if (r1 == null) goto L5;
        this.level = r1;
        return;
    }

    public void setStream(PrintStream r1) {
        this.stream = r1;
    }
}
