package org.apache.logging.log4j.message;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.Format;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class FormattedMessage implements Message {
    private static final String FORMAT_SPECIFIER = "%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])";
    private static final int HASHVAL = 31;
    private static final Pattern MSG_PATTERN = null;
    private static final long serialVersionUID = -665975803997290697L;
    private transient Object[] argArray;
    private transient String formattedMessage;
    private final Locale locale;
    private Message message;
    private String messagePattern;
    private String[] stringArgs;
    private final Throwable throwable;

    static {
        MSG_PATTERN = Pattern.compile(FORMAT_SPECIFIER);
    }

    public FormattedMessage(String r3, Object r4) {
        this(r3, new Object[]{r4}, null);
    }

    public FormattedMessage(String r3, Object r4, Object r5) {
        this(r3, new Object[]{r4, r5});
    }

    public FormattedMessage(String r2, Object... r3) {
        this(r2, r3, null);
    }

    public FormattedMessage(String r2, Object[] r3, Throwable r4) {
        this.locale = Locale.getDefault(Locale.Category.FORMAT);
        this.messagePattern = r2;
        this.argArray = r3;
        this.throwable = r4;
    }

    public FormattedMessage(Locale r3, String r4, Object r5) {
        this(r3, r4, new Object[]{r5}, null);
    }

    public FormattedMessage(Locale r3, String r4, Object r5, Object r6) {
        this(r3, r4, new Object[]{r5, r6});
    }

    public FormattedMessage(Locale r2, String r3, Object... r4) {
        this(r2, r3, r4, null);
    }

    public FormattedMessage(Locale r1, String r2, Object[] r3, Throwable r4) {
        this.locale = r1;
        this.messagePattern = r2;
        this.argArray = r3;
        this.throwable = r4;
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

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L22:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L22;
        FormattedMessage r6 = (FormattedMessage) ZeusTransformUtils.preCheckCast(r5, FormattedMessage.class, "com.obric.memorydata.plugin");
        String r2 = this.messagePattern;
        if (r2 == null) goto L16;
        if (r2.equals(r6.messagePattern) == true) goto L19;
    L17:
        return false;
    L19:
        if (Arrays.equals(this.stringArgs, r6.stringArgs) == true) goto L21;
        return false;
    L21:
        return true;
    L16:
        if (r6.messagePattern == null) goto L19;
        goto L17
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormat() {
        return this.messagePattern;
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormattedMessage() {
        if (this.formattedMessage != null) goto L9;
        if (this.message != null) goto L7;
        this.message = getMessage(this.messagePattern, this.argArray, this.throwable);
    L7:
        this.formattedMessage = this.message.getFormattedMessage();
    L9:
        return this.formattedMessage;
    }

    public Message getMessage(String r3, Object[] r4, Throwable r5) {
        Format[] r0 = new MessageFormat(r3).getFormats();     // Catch: Exception -> L14
        if (r0 == null) goto L16;
        if (r0.length <= 0) goto L16;
        return new MessageFormatMessage(this.locale, r3, r4);
    L16:
        if (MSG_PATTERN.matcher(r3).find() == false) goto L13;
        return new StringFormattedMessage(this.locale, r3, r4);
    L13:
        return new ParameterizedMessage(r3, r4, r5);
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
        Throwable r0 = this.throwable;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.message != null) goto L9;
        this.message = getMessage(this.messagePattern, this.argArray, null);
    L9:
        return this.message.getThrowable();
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
