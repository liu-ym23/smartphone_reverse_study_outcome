package org.apache.logging.log4j.message;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.apache.logging.log4j.util.q;

/* JADX INFO: loaded from: classes6.dex */
public class SimpleMessage implements CharSequence, Message, q {
    private static final long serialVersionUID = -8398002534962715992L;
    private transient CharSequence charSequence;
    private String message;

    public SimpleMessage() {
        this(null);
    }

    public SimpleMessage(CharSequence r3) {
        this.charSequence = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
    }

    public SimpleMessage(String r1) {
        this.message = r1;
        this.charSequence = r1;
    }

    private void readObject(ObjectInputStream r1) {
        r1.defaultReadObject();
        this.charSequence = this.message;
    }

    private void writeObject(ObjectOutputStream r1) {
        getFormattedMessage();
        r1.defaultWriteObject();
    }

    @Override // java.lang.CharSequence
    public char charAt(int r1) {
        return this.charSequence.charAt(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L20:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L20;
        SimpleMessage r6 = (SimpleMessage) ZeusTransformUtils.preCheckCast(r5, SimpleMessage.class, "com.obric.memorydata.plugin");
        CharSequence r4 = this.charSequence;
        if (r4 == null) goto L16;
        if (r4.equals(r6.charSequence) == false) goto L19;
        return true;
    L19:
        return false;
    L16:
        if (r6.charSequence != null) goto L19;
        return true;
    }

    @Override // org.apache.logging.log4j.util.q
    public void formatTo(StringBuilder r2) {
        CharSequence r0 = this.message;
        if (r0 != null) goto L6;
        r0 = this.charSequence;
    L6:
        r2.append(r0);
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormat() {
        return this.message;
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormattedMessage() {
        String r0 = this.message;
        if (r0 != null) goto L5;
        r0 = String.valueOf(this.charSequence);
    L5:
        this.message = r0;
        return r0;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Object[] getParameters() {
        return null;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Throwable getThrowable() {
        return null;
    }

    public int hashCode() {
        CharSequence r0 = this.charSequence;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    @Override // java.lang.CharSequence
    public int length() {
        CharSequence r0 = this.charSequence;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.length();
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int r1, int r2) {
        return this.charSequence.subSequence(r1, r2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return getFormattedMessage();
    }
}
