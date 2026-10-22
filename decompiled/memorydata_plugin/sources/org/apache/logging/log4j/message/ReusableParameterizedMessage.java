package org.apache.logging.log4j.message;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import org.apache.logging.log4j.util.r;

/* JADX INFO: loaded from: classes6.dex */
public class ReusableParameterizedMessage implements ReusableMessage, b {
    private static final int MAX_PARMS = 10;
    private static final int MIN_BUILDER_SIZE = 512;
    private static final long serialVersionUID = 7800075879295123856L;
    private int argCount;
    private transient ThreadLocal<StringBuilder> buffer;
    private final int[] indices;
    private String messagePattern;
    private transient Object[] params;
    transient boolean reserved;
    private transient Throwable throwable;
    private int usedCount;
    private transient Object[] varargs;

    public ReusableParameterizedMessage() {
        this.indices = new int[256];
        this.params = new Object[10];
        this.reserved = false;
    }

    private static int count(String r0, int[] r1) {
        return g.a(r0, r1);
    L5:
        return g.a(r0);
    }

    private StringBuilder getBuffer() {
        if (this.buffer != null) goto L5;
        this.buffer = new ThreadLocal();
    L5:
        StringBuilder r0 = (StringBuilder) ZeusTransformUtils.preCheckCast(this.buffer.get(), StringBuilder.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L12;
        String r1 = this.messagePattern;
        if (r1 != null) goto L10;
        int r2 = 0;
    L11:
        StringBuilder r3 = new StringBuilder(Math.max(512, r2 * 2));
        this.buffer.set(r3);
        r0 = r3;
        goto L12
    L10:
        r2 = r1.length();
    L12:
        r0.setLength(0);
        return r0;
    }

    private Object[] getParams() {
        Object[] r0 = this.varargs;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.params;
    }

    private Object[] getTrimmedParams() {
        Object[] r0 = this.varargs;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return Arrays.copyOf(this.params, this.argCount);
    }

    private void init(String r2, int r3, Object[] r4) {
        this.varargs = null;
        this.messagePattern = r2;
        this.argCount = r3;
        int r5 = count(r2, this.indices);
        initThrowable(r4, r3, r5);
        this.usedCount = Math.min(r5, r3);
    }

    private void initThrowable(Object[] r2, int r3, int r4) {
        if (r4 >= r3) goto L6;
        int r5 = r3 - 1;
        if (ZeusTransformUtils.instanceOf(r2[r5], Throwable.class) == false) goto L6;
        Throwable r6 = (Throwable) ZeusTransformUtils.preCheckCast(r2[r5], Throwable.class, "com.obric.memorydata.plugin");
    L7:
        this.throwable = r6;
        return;
    L6:
        r6 = null;
        goto L7
    }

    @Override // org.apache.logging.log4j.message.b
    public void clear() {
        this.reserved = false;
        this.varargs = null;
        this.messagePattern = null;
        this.throwable = null;
    }

    public <S> void forEachParameter(f<S> r4, S r5) {
        f r6 = (f) ZeusTransformUtils.wrapperContextForParams(r4, f.class, "com.obric.memorydata.plugin");
        Object[] r0 = getParams();
        short r1 = 0;
    L4:
        if (r1 >= this.argCount) goto L6;
        r6.a(r0[r1], r1, r5);
        r1 = (short) (r1 + 1);
        goto L4
    }

    @Override // org.apache.logging.log4j.util.q
    public void formatTo(StringBuilder r4) {
        if (this.indices[0] >= 0) goto L5;
        g.a(r4, this.messagePattern, getParams(), this.argCount);
        return;
    L5:
        g.a(r4, this.messagePattern, getParams(), this.usedCount, this.indices);
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormat() {
        return this.messagePattern;
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormattedMessage() {
        StringBuilder r0 = getBuffer();
        formatTo(r0);
        String r2 = r0.toString();
        r.a(r0, org.apache.logging.log4j.util.c.d);
        return r2;
    }

    @Override // org.apache.logging.log4j.message.ReusableMessage
    public short getParameterCount() {
        return (short) this.argCount;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Object[] getParameters() {
        return getTrimmedParams();
    }

    @Override // org.apache.logging.log4j.message.Message
    public Throwable getThrowable() {
        return this.throwable;
    }

    @Override // org.apache.logging.log4j.message.ReusableMessage
    public Message memento() {
        return new ParameterizedMessage(this.messagePattern, getTrimmedParams());
    }

    ReusableParameterizedMessage reserve() {
        this.reserved = true;
        return this;
    }

    ReusableParameterizedMessage set(String r3, Object r4) {
        Object[] r0 = this.params;
        r0[0] = r4;
        init(r3, 1, r0);
        return this;
    }

    ReusableParameterizedMessage set(String r3, Object r4, Object r5) {
        Object[] r0 = this.params;
        r0[0] = r4;
        r0[1] = r5;
        init(r3, 2, r0);
        return this;
    }

    ReusableParameterizedMessage set(String r3, Object r4, Object r5, Object r6) {
        Object[] r0 = this.params;
        r0[0] = r4;
        r0[1] = r5;
        r0[2] = r6;
        init(r3, 3, r0);
        return this;
    }

    ReusableParameterizedMessage set(String r3, Object r4, Object r5, Object r6, Object r7) {
        Object[] r0 = this.params;
        r0[0] = r4;
        r0[1] = r5;
        r0[2] = r6;
        r0[3] = r7;
        init(r3, 4, r0);
        return this;
    }

    ReusableParameterizedMessage set(String r3, Object r4, Object r5, Object r6, Object r7, Object r8) {
        Object[] r0 = this.params;
        r0[0] = r4;
        r0[1] = r5;
        r0[2] = r6;
        r0[3] = r7;
        r0[4] = r8;
        init(r3, 5, r0);
        return this;
    }

    ReusableParameterizedMessage set(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9) {
        Object[] r0 = this.params;
        r0[0] = r4;
        r0[1] = r5;
        r0[2] = r6;
        r0[3] = r7;
        r0[4] = r8;
        r0[5] = r9;
        init(r3, 6, r0);
        return this;
    }

    ReusableParameterizedMessage set(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10) {
        Object[] r0 = this.params;
        r0[0] = r4;
        r0[1] = r5;
        r0[2] = r6;
        r0[3] = r7;
        r0[4] = r8;
        r0[5] = r9;
        r0[6] = r10;
        init(r3, 7, r0);
        return this;
    }

    ReusableParameterizedMessage set(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11) {
        Object[] r0 = this.params;
        r0[0] = r4;
        r0[1] = r5;
        r0[2] = r6;
        r0[3] = r7;
        r0[4] = r8;
        r0[5] = r9;
        r0[6] = r10;
        r0[7] = r11;
        init(r3, 8, r0);
        return this;
    }

    ReusableParameterizedMessage set(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12) {
        Object[] r0 = this.params;
        r0[0] = r4;
        r0[1] = r5;
        r0[2] = r6;
        r0[3] = r7;
        r0[4] = r8;
        r0[5] = r9;
        r0[6] = r10;
        r0[7] = r11;
        r0[8] = r12;
        init(r3, 9, r0);
        return this;
    }

    ReusableParameterizedMessage set(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12, Object r13) {
        Object[] r0 = this.params;
        r0[0] = r4;
        r0[1] = r5;
        r0[2] = r6;
        r0[3] = r7;
        r0[4] = r8;
        r0[5] = r9;
        r0[6] = r10;
        r0[7] = r11;
        r0[8] = r12;
        r0[9] = r13;
        init(r3, 10, r0);
        return this;
    }

    ReusableParameterizedMessage set(String r2, Object... r3) {
        if (r3 != null) goto L4;
        int r0 = 0;
    L5:
        init(r2, r0, r3);
        this.varargs = r3;
        return this;
    L4:
        r0 = r3.length;
        goto L5
    }

    @Override // org.apache.logging.log4j.message.ReusableMessage
    public Object[] swapParameters(Object[] r6) {
        Object[] r0 = this.varargs;
        int r1 = 0;
        if (r0 != null) goto L15;
        Object[] r2 = this.params;
        if (r6.length < 10) goto L7;
        this.params = r6;
    L22:
        return r2;
    L7:
        int r3 = this.argCount;
        if (r3 > r6.length) goto L13;
        System.arraycopy(r2, 0, r6, 0, r3);
    L11:
        if (r1 >= this.argCount) goto L23;
        this.params[r1] = null;
        r1 = r1 + 1;
        goto L11
    L23:
        return r6;
    L13:
        this.params = new Object[10];
        goto L22
    L15:
        int r5 = this.argCount;
        if (r5 <= r6.length) goto L19;
        r6 = new Object[r5];
    L19:
        System.arraycopy(r0, 0, r6, 0, r5);
        return r6;
    }

    public String toString() {
        return "ReusableParameterizedMessage[messagePattern=" + getFormat() + ", stringArgs=" + Arrays.toString(getParameters()) + ", throwable=" + getThrowable() + ']';
    }
}
