package org.apache.logging.log4j.message;

/* JADX INFO: loaded from: classes6.dex */
public final class ParameterizedMessageFactory extends AbstractMessageFactory {
    public static final ParameterizedMessageFactory INSTANCE = null;
    private static final long serialVersionUID = -8970940216592525651L;

    static {
        INSTANCE = new ParameterizedMessageFactory();
    }

    public ParameterizedMessageFactory() {
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r1, Object r2) {
        return new ParameterizedMessage(r1, r2);
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r1, Object r2, Object r3) {
        return new ParameterizedMessage(r1, r2, r3);
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6) {
        return new ParameterizedMessage(r3, new Object[]{r4, r5, r6});
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7) {
        return new ParameterizedMessage(r3, new Object[]{r4, r5, r6, r7});
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7, Object r8) {
        return new ParameterizedMessage(r3, new Object[]{r4, r5, r6, r7, r8});
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9) {
        return new ParameterizedMessage(r3, new Object[]{r4, r5, r6, r7, r8, r9});
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10) {
        return new ParameterizedMessage(r3, new Object[]{r4, r5, r6, r7, r8, r9, r10});
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11) {
        return new ParameterizedMessage(r3, new Object[]{r4, r5, r6, r7, r8, r9, r10, r11});
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12) {
        return new ParameterizedMessage(r3, new Object[]{r4, r5, r6, r7, r8, r9, r10, r11, r12});
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12, Object r13) {
        return new ParameterizedMessage(r3, new Object[]{r4, r5, r6, r7, r8, r9, r10, r11, r12, r13});
    }

    @Override // org.apache.logging.log4j.message.d
    public Message newMessage(String r1, Object... r2) {
        return new ParameterizedMessage(r1, r2);
    }
}
