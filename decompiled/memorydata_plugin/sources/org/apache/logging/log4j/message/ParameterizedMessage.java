package org.apache.logging.log4j.message;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import org.apache.logging.log4j.util.q;
import org.apache.logging.log4j.util.r;

/* JADX INFO: loaded from: classes6.dex */
public class ParameterizedMessage implements Message, q {
    private static final int DEFAULT_STRING_BUILDER_SIZE = 255;
    public static final String ERROR_MSG_SEPARATOR = ":";
    public static final String ERROR_PREFIX = "[!!!";
    public static final String ERROR_SEPARATOR = "=>";
    public static final String ERROR_SUFFIX = "!!!]";
    private static final int HASHVAL = 31;
    public static final String RECURSION_PREFIX = "[...";
    public static final String RECURSION_SUFFIX = "...]";
    private static final long serialVersionUID = -665975803997290697L;
    private static ThreadLocal<StringBuilder> threadLocalStringBuilder;
    private transient Object[] argArray;
    private String formattedMessage;
    private int[] indices;
    private String messagePattern;
    private transient Throwable throwable;
    private int usedCount;

    static {
        threadLocalStringBuilder = new ThreadLocal();
    }

    public ParameterizedMessage(String r3, Object r4) {
        this(r3, new Object[]{r4});
    }

    public ParameterizedMessage(String r3, Object r4, Object r5) {
        this(r3, new Object[]{r4, r5});
    }

    public ParameterizedMessage(String r1, Object... r2) {
        this.argArray = r2;
        init(r1);
    }

    public ParameterizedMessage(String r1, Object[] r2, Throwable r3) {
        this.argArray = r2;
        this.throwable = r3;
        init(r1);
    }

    @Deprecated
    public ParameterizedMessage(String r1, String[] r2, Throwable r3) {
        this.argArray = r2;
        this.throwable = r3;
        init(r1);
    }

    public static int countArgumentPlaceholders(String r0) {
        return g.a(r0);
    }

    public static String deepToString(Object r0) {
        return g.a(r0);
    }

    public static String format(String r0, Object[] r1) {
        return g.a(r0, r1);
    }

    private static StringBuilder getThreadLocalStringBuilder() {
        StringBuilder r0 = (StringBuilder) ZeusTransformUtils.preCheckCast(threadLocalStringBuilder.get(), StringBuilder.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new StringBuilder(255);
        threadLocalStringBuilder.set(r0);
    L5:
        r0.setLength(0);
        return r0;
    }

    public static String identityToString(Object r0) {
        return g.b(r0);
    }

    private void init(String r4) {
        this.messagePattern = r4;
        int r0 = 0;
        if (r4 != null) goto L5;
        int r2 = 0;
    L6:
        int[] r1 = new int[Math.max(1, r2)];
        this.indices = r1;
        int r5 = g.a(r4, r1);
        initThrowable(this.argArray, r5);
        Object[] r3 = this.argArray;
        if (r3 == null) goto L10;
        r0 = r3.length;
    L10:
        this.usedCount = Math.min(r5, r0);
        return;
    L5:
        r2 = r4.length() >> 1;
        goto L6
    }

    private void initThrowable(Object[] r3, int r4) {
        if (r3 == null) goto L11;
        int r0 = r3.length;
        if (r4 < r0) goto L6;
        return;
    L6:
        if (this.throwable != null) goto L13;
        int r1 = r0 - 1;
        if (ZeusTransformUtils.instanceOf(r3[r1], Throwable.class) == false) goto L14;
        this.throwable = (Throwable) ZeusTransformUtils.preCheckCast(r3[r1], Throwable.class, "com.obric.memorydata.plugin");
        return;
    L14:
        return;
    L13:
        return;
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
        ParameterizedMessage r6 = (ParameterizedMessage) ZeusTransformUtils.preCheckCast(r5, ParameterizedMessage.class, "com.obric.memorydata.plugin");
        String r2 = this.messagePattern;
        if (r2 == null) goto L16;
        if (r2.equals(r6.messagePattern) == true) goto L19;
    L17:
        return false;
    L19:
        if (Arrays.equals(this.argArray, r6.argArray) == true) goto L21;
        return false;
    L21:
        return true;
    L16:
        if (r6.messagePattern == null) goto L19;
        goto L17
    }

    @Override // org.apache.logging.log4j.util.q
    public void formatTo(StringBuilder r4) {
        String r0 = this.formattedMessage;
        if (r0 == null) goto L5;
        r4.append(r0);
        return;
    L5:
        int[] r1 = this.indices;
        if (r1[0] >= 0) goto L8;
        g.a(r4, this.messagePattern, this.argArray, this.usedCount);
        return;
    L8:
        g.a(r4, this.messagePattern, this.argArray, this.usedCount, r1);
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormat() {
        return this.messagePattern;
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormattedMessage() {
        if (this.formattedMessage != null) goto L6;
        StringBuilder r0 = getThreadLocalStringBuilder();
        formatTo(r0);
        this.formattedMessage = r0.toString();
        r.a(r0, org.apache.logging.log4j.util.c.d);
    L6:
        return this.formattedMessage;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Object[] getParameters() {
        return this.argArray;
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
        Object[] r4 = this.argArray;
        if (r4 == null) goto L10;
        r1 = Arrays.hashCode(r4);
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ParameterizedMessage[messagePattern=" + this.messagePattern + ", stringArgs=" + Arrays.toString(this.argArray) + ", throwable=" + this.throwable + ']';
    }
}
