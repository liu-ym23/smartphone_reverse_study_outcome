package org.apache.logging.log4j.message;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Locale;
import org.apache.logging.log4j.status.StatusLogger;

/* JADX INFO: loaded from: classes6.dex */
public class StringFormattedMessage implements Message {
    private static final int HASHVAL = 31;
    private static final org.apache.logging.log4j.c LOGGER = null;
    private static final long serialVersionUID = -665975803997290697L;
    private transient Object[] argArray;
    private transient String formattedMessage;
    private final Locale locale;
    private String messagePattern;
    private String[] stringArgs;
    private transient Throwable throwable;

    static {
        LOGGER = StatusLogger.getLogger();
    }

    public StringFormattedMessage(String r2, Object... r3) {
        this(Locale.getDefault(Locale.Category.FORMAT), r2, r3);
    }

    public StringFormattedMessage(Locale r1, String r2, Object... r3) {
        this.locale = r1;
        this.messagePattern = r2;
        this.argArray = r3;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.length > 0) goto L7;
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r3[r3.length - 1], Throwable.class) == false) goto L12;
        this.throwable = (Throwable) ZeusTransformUtils.preCheckCast(r3[r3.length - 1], Throwable.class, "com.obric.memorydata.plugin");
        return;
    }

    private void readObject(ObjectInputStream r5) {
        r5.defaultReadObject();
        this.formattedMessage = r5.readUTF();
        this.messagePattern = r5.readUTF();
        int r0 = r5.readInt();
        this.stringArgs = new String[r0];
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.stringArgs[r1] = r5.readUTF();
        r1 = r1 + 1;
        goto L3
    }

    private void writeObject(ObjectOutputStream r7) {
        r7.defaultWriteObject();
        getFormattedMessage();
        r7.writeUTF(this.formattedMessage);
        r7.writeUTF(this.messagePattern);
        r7.writeInt(this.argArray.length);
        Object[] r0 = this.argArray;
        this.stringArgs = new String[r0.length];
        int r1 = r0.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L5;
        String r4 = String.valueOf(r0[r2]);
        this.stringArgs[r3] = r4;
        r7.writeUTF(r4);
        r3 = r3 + 1;
        r2 = r2 + 1;
        goto L3
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L20:
        return false;
    L8:
        if (getClass() != r4.getClass()) goto L20;
        StringFormattedMessage r5 = (StringFormattedMessage) ZeusTransformUtils.preCheckCast(r4, StringFormattedMessage.class, "com.obric.memorydata.plugin");
        String r1 = this.messagePattern;
        if (r1 == null) goto L16;
        if (r1.equals(r5.messagePattern) == true) goto L19;
    L17:
        return false;
    L19:
        return Arrays.equals(this.stringArgs, r5.stringArgs);
    L16:
        if (r5.messagePattern == null) goto L19;
        goto L17
    }

    public String formatMessage(String r3, Object... r4) {
        if (r4 != null) goto L4;
    L11:
        return String.format(this.locale, r3, r4);
    L8:
        e = move-exception;
        LOGGER.error("Unable to format msg: " + r3, e);
        return r3;
    L4:
        if (r4.length != 0) goto L11;
        return r3;
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormat() {
        return this.messagePattern;
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormattedMessage() {
        if (this.formattedMessage != null) goto L6;
        this.formattedMessage = formatMessage(this.messagePattern, this.argArray);
    L6:
        return this.formattedMessage;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Object[] getParameters() {
        Object[] r0 = this.argArray;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.stringArgs;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Throwable getThrowable() {
        return this.throwable;
    }

    public int hashCode() {
        String r0 = this.messagePattern;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String[] r4 = this.stringArgs;
        if (r4 == null) goto L10;
        r1 = Arrays.hashCode(r4);
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return getFormattedMessage();
    }
}
