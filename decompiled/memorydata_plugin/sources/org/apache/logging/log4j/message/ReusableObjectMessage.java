package org.apache.logging.log4j.message;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.util.r;

/* JADX INFO: loaded from: classes6.dex */
public class ReusableObjectMessage implements ReusableMessage, b {
    private static final long serialVersionUID = 6922476812535519960L;
    private transient Object obj;

    public ReusableObjectMessage() {
    }

    @Override // org.apache.logging.log4j.message.b
    public void clear() {
        this.obj = null;
    }

    public <S> void forEachParameter(f<S> r3, S r4) {
        ((f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin")).a(this.obj, 0, r4);
    }

    @Override // org.apache.logging.log4j.util.q
    public void formatTo(StringBuilder r1) {
        r.b(r1, this.obj);
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormat() {
        if (ZeusTransformUtils.instanceOf(this.obj, String.class) == true) goto L7;
        return null;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(this.obj, String.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormattedMessage() {
        return String.valueOf(this.obj);
    }

    public Object getParameter() {
        return this.obj;
    }

    @Override // org.apache.logging.log4j.message.ReusableMessage
    public short getParameterCount() {
        return 1;
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

    @Override // org.apache.logging.log4j.message.ReusableMessage
    public Message memento() {
        return new ObjectMessage(this.obj);
    }

    public void set(Object r1) {
        this.obj = r1;
    }

    @Override // org.apache.logging.log4j.message.ReusableMessage
    public Object[] swapParameters(Object[] r3) {
        if (r3.length != 0) goto L6;
        Object[] r4 = new Object[10];
        r4[0] = this.obj;
        return r4;
    L6:
        r3[0] = this.obj;
        return r3;
    }

    public String toString() {
        return getFormattedMessage();
    }
}
