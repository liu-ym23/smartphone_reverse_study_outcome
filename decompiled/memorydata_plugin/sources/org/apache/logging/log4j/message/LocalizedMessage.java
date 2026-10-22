package org.apache.logging.log4j.message;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.apache.logging.log4j.status.StatusLogger;

/* JADX INFO: loaded from: classes6.dex */
public class LocalizedMessage implements Message {
    private static final long serialVersionUID = 3893703791567290742L;
    private transient Object[] argArray;
    private String baseName;
    private String formattedMessage;
    private String key;
    private final Locale locale;
    private transient StatusLogger logger;
    private String loggerName;
    private transient ResourceBundle resourceBundle;
    private String[] stringArgs;
    private transient Throwable throwable;

    public LocalizedMessage(String r5, Object r6) {
        this((ResourceBundle) ZeusTransformUtils.preCheckCast(null, ResourceBundle.class, "com.obric.memorydata.plugin"), (Locale) ZeusTransformUtils.preCheckCast(null, Locale.class, "com.obric.memorydata.plugin"), r5, new Object[]{r6});
    }

    public LocalizedMessage(String r5, Object r6, Object r7) {
        this((ResourceBundle) ZeusTransformUtils.preCheckCast(null, ResourceBundle.class, "com.obric.memorydata.plugin"), (Locale) ZeusTransformUtils.preCheckCast(null, Locale.class, "com.obric.memorydata.plugin"), r5, new Object[]{r6, r7});
    }

    public LocalizedMessage(String r4, String r5, Object r6) {
        this(r4, (Locale) ZeusTransformUtils.preCheckCast(null, Locale.class, "com.obric.memorydata.plugin"), r5, new Object[]{r6});
    }

    public LocalizedMessage(String r4, String r5, Object r6, Object r7) {
        this(r4, (Locale) ZeusTransformUtils.preCheckCast(null, Locale.class, "com.obric.memorydata.plugin"), r5, new Object[]{r6, r7});
    }

    public LocalizedMessage(String r4, String r5, Object[] r6) {
        this(r4, (Locale) ZeusTransformUtils.preCheckCast(null, Locale.class, "com.obric.memorydata.plugin"), r5, r6);
    }

    public LocalizedMessage(String r3, Locale r4, String r5, Object r6) {
        this(r3, r4, r5, new Object[]{r6});
    }

    public LocalizedMessage(String r3, Locale r4, String r5, Object r6, Object r7) {
        this(r3, r4, r5, new Object[]{r6, r7});
    }

    public LocalizedMessage(String r2, Locale r3, String r4, Object[] r5) {
        this.logger = StatusLogger.getLogger();
        this.key = r4;
        this.argArray = r5;
        this.throwable = null;
        this.baseName = r2;
        this.resourceBundle = null;
        this.locale = r3;
    }

    public LocalizedMessage(String r5, Object[] r6) {
        this((ResourceBundle) ZeusTransformUtils.preCheckCast(null, ResourceBundle.class, "com.obric.memorydata.plugin"), (Locale) ZeusTransformUtils.preCheckCast(null, Locale.class, "com.obric.memorydata.plugin"), r5, r6);
    }

    public LocalizedMessage(Locale r4, String r5, Object r6) {
        this((ResourceBundle) ZeusTransformUtils.preCheckCast(null, ResourceBundle.class, "com.obric.memorydata.plugin"), r4, r5, new Object[]{r6});
    }

    public LocalizedMessage(Locale r4, String r5, Object r6, Object r7) {
        this((ResourceBundle) ZeusTransformUtils.preCheckCast(null, ResourceBundle.class, "com.obric.memorydata.plugin"), r4, r5, new Object[]{r6, r7});
    }

    public LocalizedMessage(Locale r4, String r5, Object[] r6) {
        this((ResourceBundle) ZeusTransformUtils.preCheckCast(null, ResourceBundle.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    public LocalizedMessage(ResourceBundle r4, String r5) {
        this(r4, (Locale) ZeusTransformUtils.preCheckCast(null, Locale.class, "com.obric.memorydata.plugin"), r5, new Object[0]);
    }

    public LocalizedMessage(ResourceBundle r4, String r5, Object r6) {
        this(r4, (Locale) ZeusTransformUtils.preCheckCast(null, Locale.class, "com.obric.memorydata.plugin"), r5, new Object[]{r6});
    }

    public LocalizedMessage(ResourceBundle r4, String r5, Object r6, Object r7) {
        this(r4, (Locale) ZeusTransformUtils.preCheckCast(null, Locale.class, "com.obric.memorydata.plugin"), r5, new Object[]{r6, r7});
    }

    public LocalizedMessage(ResourceBundle r4, String r5, Object[] r6) {
        this(r4, (Locale) ZeusTransformUtils.preCheckCast(null, Locale.class, "com.obric.memorydata.plugin"), r5, r6);
    }

    public LocalizedMessage(ResourceBundle r3, Locale r4, String r5, Object r6) {
        this(r3, r4, r5, new Object[]{r6});
    }

    public LocalizedMessage(ResourceBundle r3, Locale r4, String r5, Object r6, Object r7) {
        this(r3, r4, r5, new Object[]{r6, r7});
    }

    public LocalizedMessage(ResourceBundle r2, Locale r3, String r4, Object[] r5) {
        this.logger = StatusLogger.getLogger();
        this.key = r4;
        this.argArray = r5;
        this.throwable = null;
        this.baseName = null;
        this.resourceBundle = r2;
        this.locale = r3;
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        this.formattedMessage = r3.readUTF();
        this.key = r3.readUTF();
        this.baseName = r3.readUTF();
        r3.readInt();
        this.stringArgs = (String[]) ZeusTransformUtils.preCheckCast((String[]) ZeusTransformUtils.preCheckCast(r3.readObject(), String[].class, "com.obric.memorydata.plugin"), String[].class, "com.obric.memorydata.plugin");
        this.logger = StatusLogger.getLogger();
        this.resourceBundle = null;
        this.argArray = null;
    }

    private void writeObject(ObjectOutputStream r7) {
        r7.defaultWriteObject();
        getFormattedMessage();
        r7.writeUTF(this.formattedMessage);
        r7.writeUTF(this.key);
        r7.writeUTF(this.baseName);
        r7.writeInt(this.argArray.length);
        Object[] r0 = this.argArray;
        this.stringArgs = new String[r0.length];
        int r1 = r0.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L5;
        this.stringArgs[r3] = r0[r2].toString();
        r3 = r3 + 1;
        r2 = r2 + 1;
        goto L3
    L5:
        r7.writeObject(this.stringArgs);
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormat() {
        return this.key;
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormattedMessage() {
        String r0 = this.formattedMessage;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ResourceBundle r1 = this.resourceBundle;
        if (r1 != null) goto L12;
        String r2 = this.baseName;
        if (r2 == null) goto L10;
        Locale r3 = this.locale;
        boolean r4 = false;
    L11:
        r1 = getResourceBundle(r2, r3, r4);
        goto L12
    L10:
        r2 = this.loggerName;
        r3 = this.locale;
        r4 = true;
    L12:
        String r5 = getFormat();
        if (r1 != null) goto L15;
    L18:
        Object[] r6 = this.argArray;
        if (r6 != null) goto L21;
        r6 = this.stringArgs;
    L21:
        FormattedMessage r7 = new FormattedMessage(r5, r6);
        this.formattedMessage = r7.getFormattedMessage();
        this.throwable = r7.getThrowable();
        return this.formattedMessage;
    L15:
        if (r1.containsKey(r5) == false) goto L18;
        r5 = r1.getString(r5);
        goto L18
    }

    public String getLoggerName() {
        return this.loggerName;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Object[] getParameters() {
        Object[] r0 = this.argArray;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.stringArgs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ResourceBundle] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.ResourceBundle] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r6v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.ResourceBundle] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.ResourceBundle] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.util.ResourceBundle] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.util.ResourceBundle] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x003d -> B:9:0x0011). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0042 -> B:9:0x0011). Please report as a decompilation issue!!! */
    public ResourceBundle getResourceBundle(String r4, Locale r5, boolean r6) {
        ?? r0 = 0;
        if (r4 != null) goto L23;
        return null;
    L23:
        if (r5 == null) goto L8;
        r6 = ResourceBundle.getBundle(r4, r5);     // Catch: MissingResourceException -> L10
    L9:
        r0 = r6;
    L13:
        if (r0 != 0) goto L22;
        int r7 = r4.lastIndexOf(46);
        if (r7 <= 0) goto L22;
        r4 = r4.substring(0, r7);
        if (r5 == null) goto L19;
        r6 = ResourceBundle.getBundle(r4, r5);     // Catch: MissingResourceException -> L21
    L21:
        this.logger.debug("Unable to locate ResourceBundle " + r4);
        goto L13
    L19:
        r6 = ResourceBundle.getBundle(r4);     // Catch: MissingResourceException -> L21
    L22:
        return r0;
    L8:
        r6 = ResourceBundle.getBundle(r4);     // Catch: MissingResourceException -> L10
    L10:
        if (r6 != 0) goto L13;
        this.logger.debug("Unable to locate ResourceBundle " + r4);
        return r0;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Throwable getThrowable() {
        return this.throwable;
    }

    public void setLoggerName(String r1) {
        this.loggerName = r1;
    }

    public String toString() {
        return getFormattedMessage();
    }
}
