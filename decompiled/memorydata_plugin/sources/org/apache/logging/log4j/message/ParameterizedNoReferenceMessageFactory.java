package org.apache.logging.log4j.message;

/* JADX INFO: loaded from: classes6.dex */
public final class ParameterizedNoReferenceMessageFactory extends AbstractMessageFactory {
    public static final ParameterizedNoReferenceMessageFactory INSTANCE = null;
    private static final long serialVersionUID = 5027639245636870500L;

    static class StatusMessage implements Message {
        private static final long serialVersionUID = 4199272162767841280L;
        private final String formattedMessage;
        private final Throwable throwable;

        public StatusMessage(String r1, Throwable r2) {
            this.formattedMessage = r1;
            this.throwable = r2;
        }

        @Override // org.apache.logging.log4j.message.Message
        public String getFormat() {
            return this.formattedMessage;
        }

        @Override // org.apache.logging.log4j.message.Message
        public String getFormattedMessage() {
            return this.formattedMessage;
        }

        @Override // org.apache.logging.log4j.message.Message
        public Object[] getParameters() {
            return null;
        }

        @Override // org.apache.logging.log4j.message.Message
        public Throwable getThrowable() {
            return this.throwable;
        }
    }

    static {
        INSTANCE = new ParameterizedNoReferenceMessageFactory();
    }

    public ParameterizedNoReferenceMessageFactory() {
    }

    @Override // org.apache.logging.log4j.message.d
    public Message newMessage(String r1, Object... r2) {
        if (r2 == null) goto L4;
        ParameterizedMessage r0 = new ParameterizedMessage(r1, r2);
        return new StatusMessage(r0.getFormattedMessage(), r0.getThrowable());
    L4:
        return new SimpleMessage(r1);
    }
}
