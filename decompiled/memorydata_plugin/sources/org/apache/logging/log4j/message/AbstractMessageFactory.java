package org.apache.logging.log4j.message;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractMessageFactory implements Serializable, e {
    private static final long serialVersionUID = -1307891137684031187L;

    public AbstractMessageFactory() {
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(CharSequence r2) {
        return new SimpleMessage((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.logging.log4j.message.d
    public Message newMessage(Object r1) {
        return new ObjectMessage(r1);
    }

    @Override // org.apache.logging.log4j.message.d
    public Message newMessage(String r1) {
        return new SimpleMessage(r1);
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4) {
        return newMessage(r3, new Object[]{r4});
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5) {
        return newMessage(r3, new Object[]{r4, r5});
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6) {
        return newMessage(r3, new Object[]{r4, r5, r6});
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7) {
        return newMessage(r3, new Object[]{r4, r5, r6, r7});
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7, Object r8) {
        return newMessage(r3, new Object[]{r4, r5, r6, r7, r8});
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9) {
        return newMessage(r3, new Object[]{r4, r5, r6, r7, r8, r9});
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10) {
        return newMessage(r3, new Object[]{r4, r5, r6, r7, r8, r9, r10});
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11) {
        return newMessage(r3, new Object[]{r4, r5, r6, r7, r8, r9, r10, r11});
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12) {
        return newMessage(r3, new Object[]{r4, r5, r6, r7, r8, r9, r10, r11, r12});
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12, Object r13) {
        return newMessage(r3, new Object[]{r4, r5, r6, r7, r8, r9, r10, r11, r12, r13});
    }
}
