package org.apache.logging.log4j.spi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.message.Message;

/* JADX INFO: loaded from: classes6.dex */
public class ExtendedLoggerWrapper extends AbstractLogger {
    private static final long serialVersionUID = 1;
    protected final c logger;

    public ExtendedLoggerWrapper(c r3, String r4, org.apache.logging.log4j.message.d r5) {
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        super(r4, (org.apache.logging.log4j.message.d) ZeusTransformUtils.wrapperContextForParams(r5, org.apache.logging.log4j.message.d.class, "com.obric.memorydata.plugin"));
        this.logger = r6;
    }

    @Override // org.apache.logging.log4j.c
    public Level getLevel() {
        return this.logger.getLevel();
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r3, Marker r4, CharSequence r5, Throwable r6) {
        Marker r7 = (Marker) ZeusTransformUtils.wrapperContextForParams(r4, Marker.class, "com.obric.memorydata.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        return this.logger.isEnabled(r3, r7, r8, r6);
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r3, Marker r4, Object r5, Throwable r6) {
        Marker r7 = (Marker) ZeusTransformUtils.wrapperContextForParams(r4, Marker.class, "com.obric.memorydata.plugin");
        return this.logger.isEnabled(r3, r7, r5, r6);
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r3, Marker r4, String r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r4, Marker.class, "com.obric.memorydata.plugin");
        return this.logger.isEnabled(r3, r6, r5);
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r3, Marker r4, String r5, Object r6) {
        Marker r7 = (Marker) ZeusTransformUtils.wrapperContextForParams(r4, Marker.class, "com.obric.memorydata.plugin");
        return this.logger.isEnabled(r3, r7, r5, r6);
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r7, Marker r8, String r9, Object r10, Object r11) {
        Marker r2 = (Marker) ZeusTransformUtils.wrapperContextForParams(r8, Marker.class, "com.obric.memorydata.plugin");
        return this.logger.isEnabled(r7, r2, r9, r10, r11);
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r8, Marker r9, String r10, Object r11, Object r12, Object r13) {
        Marker r2 = (Marker) ZeusTransformUtils.wrapperContextForParams(r9, Marker.class, "com.obric.memorydata.plugin");
        return this.logger.isEnabled(r8, r2, r10, r11, r12, r13);
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r9, Marker r10, String r11, Object r12, Object r13, Object r14, Object r15) {
        Marker r2 = (Marker) ZeusTransformUtils.wrapperContextForParams(r10, Marker.class, "com.obric.memorydata.plugin");
        return this.logger.isEnabled(r9, r2, r11, r12, r13, r14, r15);
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r11, Marker r12, String r13, Object r14, Object r15, Object r16, Object r17, Object r18) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r12, Marker.class, "com.obric.memorydata.plugin");
        return this.logger.isEnabled(r11, r3, r13, r14, r15, r16, r17, r18);
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r12, Marker r13, String r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r13, Marker.class, "com.obric.memorydata.plugin");
        return this.logger.isEnabled(r12, r3, r14, r15, r16, r17, r18, r19, r20);
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r13, Marker r14, String r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r14, Marker.class, "com.obric.memorydata.plugin");
        return this.logger.isEnabled(r13, r3, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r14, Marker r15, String r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r15, Marker.class, "com.obric.memorydata.plugin");
        return this.logger.isEnabled(r14, r3, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r15, Marker r16, String r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r16, Marker.class, "com.obric.memorydata.plugin");
        return this.logger.isEnabled(r15, r3, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r16, Marker r17, String r18, Object r19, Object r20, Object r21, Object r22, Object r23, Object r24, Object r25, Object r26, Object r27, Object r28) {
        Marker r3 = (Marker) ZeusTransformUtils.wrapperContextForParams(r17, Marker.class, "com.obric.memorydata.plugin");
        return this.logger.isEnabled(r16, r3, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r3, Marker r4, String r5, Throwable r6) {
        Marker r7 = (Marker) ZeusTransformUtils.wrapperContextForParams(r4, Marker.class, "com.obric.memorydata.plugin");
        return this.logger.isEnabled(r3, r7, r5, r6);
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r3, Marker r4, String r5, Object... r6) {
        Marker r7 = (Marker) ZeusTransformUtils.wrapperContextForParams(r4, Marker.class, "com.obric.memorydata.plugin");
        return this.logger.isEnabled(r3, r7, r5, r6);
    }

    @Override // org.apache.logging.log4j.spi.c
    public boolean isEnabled(Level r3, Marker r4, Message r5, Throwable r6) {
        Marker r7 = (Marker) ZeusTransformUtils.wrapperContextForParams(r4, Marker.class, "com.obric.memorydata.plugin");
        Message r8 = (Message) ZeusTransformUtils.wrapperContextForParams(r5, Message.class, "com.obric.memorydata.plugin");
        return this.logger.isEnabled(r3, r7, r8, r6);
    }

    @Override // org.apache.logging.log4j.spi.c
    public void logMessage(String r10, Level r11, Marker r12, Message r13, Throwable r14) {
        Marker r5 = (Marker) ZeusTransformUtils.wrapperContextForParams(r12, Marker.class, "com.obric.memorydata.plugin");
        Message r15 = (Message) ZeusTransformUtils.wrapperContextForParams(r13, Message.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(this.logger, e.class) == true) goto L5;
    L7:
        this.logger.logMessage(r10, r11, r5, r15, r14);
        return;
    L5:
        if (requiresLocation() == false) goto L7;
        ((e) ZeusTransformUtils.preCheckCast(this.logger, e.class, "com.obric.memorydata.plugin")).logMessage(r11, r5, r10, org.apache.logging.log4j.util.p.a(r10), r15, r14);
    }
}
