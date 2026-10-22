package org.apache.logging.log4j.message;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.logging.log4j.util.q;
import org.apache.logging.log4j.util.r;

/* JADX INFO: loaded from: classes6.dex */
public class ObjectMessage implements Message, q {
    private static final long serialVersionUID = -5903272448334166185L;
    private transient Object obj;
    private transient String objectString;

    public ObjectMessage(Object r1) {
        if (r1 != null) goto L5;
        r1 = "null";
    L5:
        this.obj = r1;
    }

    private boolean equalObjectsOrStrings(Object r1, Object r2) {
        if (r1.equals(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (String.valueOf(r1).equals(String.valueOf(r2)) == true) goto L8;
        return false;
    }

    private void readObject(ObjectInputStream r1) {
        r1.defaultReadObject();
        this.obj = r1.readObject();
    }

    private void writeObject(ObjectOutputStream r3) {
        r3.defaultWriteObject();
        boolean r0 = ZeusTransformUtils.instanceOf(this.obj, Serializable.class);
        Object r2 = this.obj;
        if (r0 == true) goto L6;
        r2 = String.valueOf(r2);
    L6:
        r3.writeObject(r2);
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
        ObjectMessage r6 = (ObjectMessage) ZeusTransformUtils.preCheckCast(r5, ObjectMessage.class, "com.obric.memorydata.plugin");
        Object r2 = this.obj;
        if (r2 != null) goto L17;
        if (r6.obj != null) goto L19;
        return true;
    L19:
        return false;
    L17:
        return equalObjectsOrStrings(r2, r6.obj);
    }

    @Override // org.apache.logging.log4j.util.q
    public void formatTo(StringBuilder r2) {
        String r0 = this.objectString;
        if (r0 == null) goto L5;
        r2.append(r0);
        return;
    L5:
        r.b(r2, this.obj);
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormat() {
        return getFormattedMessage();
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormattedMessage() {
        if (this.objectString != null) goto L6;
        this.objectString = String.valueOf(this.obj);
    L6:
        return this.objectString;
    }

    public Object getParameter() {
        return this.obj;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Object[] getParameters() {
        return new Object[]{this.obj};
    }

    @Override // org.apache.logging.log4j.message.Message
    public Throwable getThrowable() {
        if (ZeusTransformUtils.instanceOf(this.obj, Throwable.class) == true) goto L7;
        return null;
    L7:
        return (Throwable) ZeusTransformUtils.preCheckCast(this.obj, Throwable.class, "com.obric.memorydata.plugin");
    }

    public int hashCode() {
        Object r0 = this.obj;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return getFormattedMessage();
    }
}
