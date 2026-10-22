package org.apache.logging.log4j.message;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class ReusableSimpleMessage implements CharSequence, ReusableMessage, b {
    private static final long serialVersionUID = -9199974506498249809L;
    private CharSequence charSequence;

    public ReusableSimpleMessage() {
    }

    @Override // java.lang.CharSequence
    public char charAt(int r1) {
        return this.charSequence.charAt(r1);
    }

    @Override // org.apache.logging.log4j.message.b
    public void clear() {
        this.charSequence = null;
    }

    public <S> void forEachParameter(f<S> r1, S r2) {
        f r0 = (f) ZeusTransformUtils.wrapperContextForParams(r1, f.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.logging.log4j.util.q
    public void formatTo(StringBuilder r1) {
        r1.append(this.charSequence);
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormat() {
        if (ZeusTransformUtils.instanceOf(this.charSequence, String.class) == true) goto L7;
        return null;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(this.charSequence, String.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormattedMessage() {
        return String.valueOf(this.charSequence);
    }

    @Override // org.apache.logging.log4j.message.ReusableMessage
    public short getParameterCount() {
        return 0;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Object[] getParameters() {
        return org.apache.logging.log4j.util.c.e;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Throwable getThrowable() {
        return null;
    }

    @Override // java.lang.CharSequence
    public int length() {
        CharSequence r0 = this.charSequence;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.length();
    }

    @Override // org.apache.logging.log4j.message.ReusableMessage
    public Message memento() {
        return new SimpleMessage(this.charSequence);
    }

    public void set(CharSequence r3) {
        this.charSequence = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
    }

    public void set(String r1) {
        this.charSequence = r1;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int r1, int r2) {
        return this.charSequence.subSequence(r1, r2);
    }

    @Override // org.apache.logging.log4j.message.ReusableMessage
    public Object[] swapParameters(Object[] r1) {
        return r1;
    }
}
