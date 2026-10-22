package org.apache.logging.log4j.message;

/* JADX INFO: loaded from: classes6.dex */
public final class StringFormatterMessageFactory extends AbstractMessageFactory {
    public static final StringFormatterMessageFactory INSTANCE = null;
    private static final long serialVersionUID = -1626332412176965642L;

    static {
        INSTANCE = new StringFormatterMessageFactory();
    }

    public StringFormatterMessageFactory() {
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4) {
        return new StringFormattedMessage(r3, new Object[]{r4});
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5) {
        return new StringFormattedMessage(r3, new Object[]{r4, r5});
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6) {
        return new StringFormattedMessage(r3, new Object[]{r4, r5, r6});
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7) {
        return new StringFormattedMessage(r3, new Object[]{r4, r5, r6, r7});
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7, Object r8) {
        return new StringFormattedMessage(r3, new Object[]{r4, r5, r6, r7, r8});
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9) {
        return new StringFormattedMessage(r3, new Object[]{r4, r5, r6, r7, r8, r9});
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10) {
        return new StringFormattedMessage(r3, new Object[]{r4, r5, r6, r7, r8, r9, r10});
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11) {
        return new StringFormattedMessage(r3, new Object[]{r4, r5, r6, r7, r8, r9, r10, r11});
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12) {
        return new StringFormattedMessage(r3, new Object[]{r4, r5, r6, r7, r8, r9, r10, r11, r12});
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12, Object r13) {
        return new StringFormattedMessage(r3, new Object[]{r4, r5, r6, r7, r8, r9, r10, r11, r12, r13});
    }

    @Override // org.apache.logging.log4j.message.d
    public Message newMessage(String r1, Object... r2) {
        return new StringFormattedMessage(r1, r2);
    }
}
