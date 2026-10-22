package org.apache.logging.log4j.message;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Locale;
import org.apache.logging.log4j.status.StatusLogger;

/* JADX INFO: loaded from: classes6.dex */
public class MessageFormatMessage implements Message {
    private static final int HASHVAL = 31;
    private static final org.apache.logging.log4j.c LOGGER = null;
    private static final long serialVersionUID = 1;
    private transient String formattedMessage;
    private final Locale locale;
    private String messagePattern;
    private transient Object[] parameters;
    private String[] serializedParameters;
    private transient Throwable throwable;

    static {
        LOGGER = StatusLogger.getLogger();
    }

    public MessageFormatMessage(String r2, Object... r3) {
        this(Locale.getDefault(Locale.Category.FORMAT), r2, r3);
    }

    public MessageFormatMessage(Locale r2, String r3, Object... r4) {
        this.locale = r2;
        this.messagePattern = r3;
        this.parameters = r4;
        if (r4 != null) goto L5;
        int r5 = 0;
    L6:
        if (r5 <= 0) goto L11;
        int r6 = r5 - 1;
        if (ZeusTransformUtils.instanceOf(r4[r6], Throwable.class) == false) goto L12;
        this.throwable = (Throwable) ZeusTransformUtils.preCheckCast(r4[r6], Throwable.class, "com.obric.memorydata.plugin");
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r5 = r4.length;
        goto L6
    }

    private void readObject(ObjectInputStream r5) {
        this.parameters = null;
        this.throwable = null;
        this.formattedMessage = r5.readUTF();
        this.messagePattern = r5.readUTF();
        int r0 = r5.readInt();
        this.serializedParameters = new String[r0];
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.serializedParameters[r1] = r5.readUTF();
        r1 = r1 + 1;
        goto L3
    }

    private void writeObject(ObjectOutputStream r5) {
        getFormattedMessage();
        r5.writeUTF(this.formattedMessage);
        r5.writeUTF(this.messagePattern);
        Object[] r0 = this.parameters;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        r5.writeInt(r2);
        this.serializedParameters = new String[r2];
        if (r2 <= 0) goto L10;
    L8:
        if (r1 >= r2) goto L12;
        this.serializedParameters[r1] = String.valueOf(this.parameters[r1]);
        r5.writeUTF(this.serializedParameters[r1]);
        r1 = r1 + 1;
        goto L8
    L12:
        return;
    L10:
        return;
    L5:
        r2 = r0.length;
        goto L6
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
        MessageFormatMessage r5 = (MessageFormatMessage) ZeusTransformUtils.preCheckCast(r4, MessageFormatMessage.class, "com.obric.memorydata.plugin");
        String r1 = this.messagePattern;
        if (r1 == null) goto L16;
        if (r1.equals(r5.messagePattern) == true) goto L19;
    L17:
        return false;
    L19:
        return Arrays.equals(this.serializedParameters, r5.serializedParameters);
    L16:
        if (r5.messagePattern == null) goto L19;
        goto L17
    }

    public String formatMessage(String r3, Object... r4) {
        return new MessageFormat(r3, this.locale).format(r4);
    L4:
        e = move-exception;
        LOGGER.error("Unable to format msg: " + r3, e);
        return r3;
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormat() {
        return this.messagePattern;
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormattedMessage() {
        if (this.formattedMessage != null) goto L6;
        this.formattedMessage = formatMessage(this.messagePattern, this.parameters);
    L6:
        return this.formattedMessage;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Object[] getParameters() {
        Object[] r0 = this.parameters;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.serializedParameters;
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
        String[] r4 = this.serializedParameters;
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
