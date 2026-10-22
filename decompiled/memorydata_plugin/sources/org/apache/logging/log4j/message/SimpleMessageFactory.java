package org.apache.logging.log4j.message;

/* JADX INFO: loaded from: classes6.dex */
public final class SimpleMessageFactory extends AbstractMessageFactory {
    public static final SimpleMessageFactory INSTANCE = null;
    private static final long serialVersionUID = 4418995198790088516L;

    static {
        INSTANCE = new SimpleMessageFactory();
    }

    public SimpleMessageFactory() {
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r1, Object r2) {
        return new SimpleMessage(r1);
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r1, Object r2, Object r3) {
        return new SimpleMessage(r1);
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r1, Object r2, Object r3, Object r4) {
        return new SimpleMessage(r1);
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r1, Object r2, Object r3, Object r4, Object r5) {
        return new SimpleMessage(r1);
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r1, Object r2, Object r3, Object r4, Object r5, Object r6) {
        return new SimpleMessage(r1);
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r1, Object r2, Object r3, Object r4, Object r5, Object r6, Object r7) {
        return new SimpleMessage(r1);
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r1, Object r2, Object r3, Object r4, Object r5, Object r6, Object r7, Object r8) {
        return new SimpleMessage(r1);
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r1, Object r2, Object r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9) {
        return new SimpleMessage(r1);
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r1, Object r2, Object r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10) {
        return new SimpleMessage(r1);
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r1, Object r2, Object r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11) {
        return new SimpleMessage(r1);
    }

    @Override // org.apache.logging.log4j.message.d
    public Message newMessage(String r1, Object... r2) {
        return new SimpleMessage(r1);
    }
}
