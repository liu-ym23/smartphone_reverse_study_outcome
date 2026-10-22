package org.apache.logging.log4j.message;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public final class ReusableMessageFactory implements Serializable, e {
    public static final ReusableMessageFactory INSTANCE = null;
    private static final long serialVersionUID = -8970940216592525651L;
    private static ThreadLocal<ReusableObjectMessage> threadLocalObjectMessage;
    private static ThreadLocal<ReusableParameterizedMessage> threadLocalParameterized;
    private static ThreadLocal<ReusableSimpleMessage> threadLocalSimpleMessage;

    static {
        INSTANCE = new ReusableMessageFactory();
        threadLocalParameterized = new ThreadLocal();
        threadLocalSimpleMessage = new ThreadLocal();
        threadLocalObjectMessage = new ThreadLocal();
    }

    public ReusableMessageFactory() {
    }

    private static ReusableObjectMessage getObject() {
        ReusableObjectMessage r0 = (ReusableObjectMessage) ZeusTransformUtils.preCheckCast(threadLocalObjectMessage.get(), ReusableObjectMessage.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        ReusableObjectMessage r1 = new ReusableObjectMessage();
        threadLocalObjectMessage.set(r1);
        return r1;
    L6:
        return r0;
    }

    private static ReusableParameterizedMessage getParameterized() {
        ReusableParameterizedMessage r0 = (ReusableParameterizedMessage) ZeusTransformUtils.preCheckCast(threadLocalParameterized.get(), ReusableParameterizedMessage.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        r0 = new ReusableParameterizedMessage();
        threadLocalParameterized.set(r0);
    L6:
        if (r0.reserved == false) goto L9;
        r0 = new ReusableParameterizedMessage();
    L9:
        return r0.reserve();
    }

    private static ReusableSimpleMessage getSimple() {
        ReusableSimpleMessage r0 = (ReusableSimpleMessage) ZeusTransformUtils.preCheckCast(threadLocalSimpleMessage.get(), ReusableSimpleMessage.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        ReusableSimpleMessage r1 = new ReusableSimpleMessage();
        threadLocalSimpleMessage.set(r1);
        return r1;
    L6:
        return r0;
    }

    public static void release(Message r2) {
        Message r3 = (Message) ZeusTransformUtils.wrapperContextForParams(r2, Message.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, b.class) == false) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin")).clear();
        return;
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(CharSequence r2) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        ReusableSimpleMessage r3 = getSimple();
        r3.set(r1);
        return r3;
    }

    @Override // org.apache.logging.log4j.message.d
    public Message newMessage(Object r1) {
        ReusableObjectMessage r0 = getObject();
        r0.set(r1);
        return r0;
    }

    @Override // org.apache.logging.log4j.message.d
    public Message newMessage(String r1) {
        ReusableSimpleMessage r0 = getSimple();
        r0.set(r1);
        return r0;
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r1, Object r2) {
        return getParameterized().set(r1, r2);
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r1, Object r2, Object r3) {
        return getParameterized().set(r1, r2, r3);
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r1, Object r2, Object r3, Object r4) {
        return getParameterized().set(r1, r2, r3, r4);
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r7, Object r8, Object r9, Object r10, Object r11) {
        return getParameterized().set(r7, r8, r9, r10, r11);
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r8, Object r9, Object r10, Object r11, Object r12, Object r13) {
        return getParameterized().set(r8, r9, r10, r11, r12, r13);
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r9, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15) {
        return getParameterized().set(r9, r10, r11, r12, r13, r14, r15);
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17) {
        return getParameterized().set(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19) {
        return getParameterized().set(r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21) {
        return getParameterized().set(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23) {
        return getParameterized().set(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23);
    }

    @Override // org.apache.logging.log4j.message.d
    public Message newMessage(String r1, Object... r2) {
        return getParameterized().set(r1, r2);
    }
}
