package org.apache.logging.log4j.message;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public final class ObjectArrayMessage implements Message {
    private static final long serialVersionUID = -5903272448334166185L;
    private transient Object[] array;
    private transient String arrayString;

    public ObjectArrayMessage(Object... r1) {
        if (r1 != null) goto L5;
        r1 = org.apache.logging.log4j.util.c.e;
    L5:
        this.array = r1;
    }

    private boolean equalObjectsOrStrings(Object[] r1, Object[] r2) {
        if (Arrays.equals(r1, r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (Arrays.toString(r1).equals(Arrays.toString(r2)) == true) goto L8;
        return false;
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        this.array = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r3.readObject(), Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin");
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(this.array);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L18:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L18;
        ObjectArrayMessage r6 = (ObjectArrayMessage) ZeusTransformUtils.preCheckCast(r5, ObjectArrayMessage.class, "com.obric.memorydata.plugin");
        Object[] r2 = this.array;
        if (r2 != null) goto L17;
        if (r6.array != null) goto L19;
        return true;
    L19:
        return false;
    L17:
        return equalObjectsOrStrings(r2, r6.array);
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormat() {
        return getFormattedMessage();
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormattedMessage() {
        if (this.arrayString != null) goto L6;
        this.arrayString = Arrays.toString(this.array);
    L6:
        return this.arrayString;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Object[] getParameters() {
        return this.array;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Throwable getThrowable() {
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.array);
    }

    public String toString() {
        return getFormattedMessage();
    }
}
