package org.apache.logging.log4j.status;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.message.Message;

/* JADX INFO: loaded from: classes6.dex */
public class StatusData implements Serializable {
    private static final long serialVersionUID = -4341916115118014017L;
    private final StackTraceElement caller;
    private final Level level;
    private final Message msg;
    private String threadName;
    private final Throwable throwable;
    private final long timestamp;

    public StatusData(StackTraceElement r3, Level r4, Message r5, Throwable r6, String r7) {
        Message r8 = (Message) ZeusTransformUtils.wrapperContextForParams(r5, Message.class, "com.obric.memorydata.plugin");
        this.timestamp = System.currentTimeMillis();
        this.caller = r3;
        this.level = r4;
        this.msg = r8;
        this.throwable = r6;
        this.threadName = r7;
    }

    public String getFormattedStatus() {
        StringBuilder r0 = new StringBuilder();
        r0.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS").format(new Date(this.timestamp)));
        r0.append(' ');
        r0.append(getThreadName());
        r0.append(' ');
        r0.append(this.level.toString());
        r0.append(' ');
        r0.append(this.msg.getFormattedMessage());
        Object[] r2 = this.msg.getParameters();
        if (this.throwable != null) goto L8;
        if (r2 == null) goto L8;
        if (ZeusTransformUtils.instanceOf(r2[r2.length - 1], Throwable.class) == false) goto L8;
        Throwable r5 = (Throwable) ZeusTransformUtils.preCheckCast(r2[r2.length - 1], Throwable.class, "com.obric.memorydata.plugin");
    L9:
        if (r5 == null) goto L12;
        r0.append(' ');
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        r5.printStackTrace(new PrintStream(r1));
        r0.append(r1.toString());
    L12:
        return r0.toString();
    L8:
        r5 = this.throwable;
        goto L9
    }

    public Level getLevel() {
        return this.level;
    }

    public Message getMessage() {
        return this.msg;
    }

    public StackTraceElement getStackTraceElement() {
        return this.caller;
    }

    public String getThreadName() {
        if (this.threadName != null) goto L6;
        this.threadName = Thread.currentThread().getName();
    L6:
        return this.threadName;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public long getTimestamp() {
        return this.timestamp;
    }
}
