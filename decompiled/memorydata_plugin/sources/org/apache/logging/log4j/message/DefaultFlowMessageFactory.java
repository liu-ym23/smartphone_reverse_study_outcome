package org.apache.logging.log4j.message;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class DefaultFlowMessageFactory implements Serializable, c {
    private static final String ENTRY_DEFAULT_PREFIX = "Enter";
    private static final String EXIT_DEFAULT_PREFIX = "Exit";
    private static final long serialVersionUID = 8578655591131397576L;
    private final String entryText;
    private final String exitText;

    private static class AbstractFlowMessage implements FlowMessage {
        private static final long serialVersionUID = 1;
        private final Message message;
        private final String text;

        AbstractFlowMessage(String r3, Message r4) {
            this.message = (Message) ZeusTransformUtils.wrapperContextForParams(r4, Message.class, "com.obric.memorydata.plugin");
            this.text = r3;
        }

        @Override // org.apache.logging.log4j.message.Message
        public String getFormat() {
            if (this.message == null) goto L7;
            return this.text + ": " + this.message.getFormat();
        L7:
            return this.text;
        }

        @Override // org.apache.logging.log4j.message.Message
        public String getFormattedMessage() {
            if (this.message == null) goto L7;
            return this.text + " " + this.message.getFormattedMessage();
        L7:
            return this.text;
        }

        @Override // org.apache.logging.log4j.message.FlowMessage
        public Message getMessage() {
            return this.message;
        }

        @Override // org.apache.logging.log4j.message.Message
        public Object[] getParameters() {
            Message r0 = this.message;
            if (r0 != null) goto L5;
            return null;
        L5:
            return r0.getParameters();
        }

        @Override // org.apache.logging.log4j.message.FlowMessage
        public String getText() {
            return this.text;
        }

        @Override // org.apache.logging.log4j.message.Message
        public Throwable getThrowable() {
            Message r0 = this.message;
            if (r0 != null) goto L5;
            return null;
        L5:
            return r0.getThrowable();
        }
    }

    private static final class SimpleEntryMessage extends AbstractFlowMessage implements EntryMessage {
        private static final long serialVersionUID = 1;

        SimpleEntryMessage(String r3, Message r4) {
            super(r3, (Message) ZeusTransformUtils.wrapperContextForParams(r4, Message.class, "com.obric.memorydata.plugin"));
        }
    }

    private static final class SimpleExitMessage extends AbstractFlowMessage implements ExitMessage {
        private static final long serialVersionUID = 1;
        private final boolean isVoid;
        private final Object result;

        SimpleExitMessage(String r3, Object r4, EntryMessage r5) {
            super(r3, ((EntryMessage) ZeusTransformUtils.wrapperContextForParams(r5, EntryMessage.class, "com.obric.memorydata.plugin")).getMessage());
            this.result = r4;
            this.isVoid = false;
        }

        SimpleExitMessage(String r3, Object r4, Message r5) {
            super(r3, (Message) ZeusTransformUtils.wrapperContextForParams(r5, Message.class, "com.obric.memorydata.plugin"));
            this.result = r4;
            this.isVoid = false;
        }

        SimpleExitMessage(String r3, EntryMessage r4) {
            super(r3, ((EntryMessage) ZeusTransformUtils.wrapperContextForParams(r4, EntryMessage.class, "com.obric.memorydata.plugin")).getMessage());
            this.result = null;
            this.isVoid = true;
        }

        @Override // org.apache.logging.log4j.message.DefaultFlowMessageFactory.AbstractFlowMessage, org.apache.logging.log4j.message.Message
        public String getFormattedMessage() {
            String r0 = super.getFormattedMessage();
            if (this.isVoid == false) goto L6;
            return r0;
        L6:
            return r0 + ": " + this.result;
        }
    }

    public DefaultFlowMessageFactory() {
        this(ENTRY_DEFAULT_PREFIX, EXIT_DEFAULT_PREFIX);
    }

    public DefaultFlowMessageFactory(String r1, String r2) {
        this.entryText = r1;
        this.exitText = r2;
    }

    private Message makeImmutable(Message r2) {
        Message r1 = (Message) ZeusTransformUtils.wrapperContextForParams(r2, Message.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, ReusableMessage.class) == true) goto L6;
        return r1;
    L6:
        return new SimpleMessage(r1.getFormattedMessage());
    }

    public String getEntryText() {
        return this.entryText;
    }

    public String getExitText() {
        return this.exitText;
    }

    @Override // org.apache.logging.log4j.message.c
    public EntryMessage newEntryMessage(Message r3) {
        Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
        return new SimpleEntryMessage(this.entryText, makeImmutable(r4));
    }

    @Override // org.apache.logging.log4j.message.c
    public ExitMessage newExitMessage(Object r3, EntryMessage r4) {
        EntryMessage r5 = (EntryMessage) ZeusTransformUtils.wrapperContextForParams(r4, EntryMessage.class, "com.obric.memorydata.plugin");
        return new SimpleExitMessage(this.exitText, r3, r5);
    }

    @Override // org.apache.logging.log4j.message.c
    public ExitMessage newExitMessage(Object r3, Message r4) {
        Message r5 = (Message) ZeusTransformUtils.wrapperContextForParams(r4, Message.class, "com.obric.memorydata.plugin");
        return new SimpleExitMessage(this.exitText, r3, r5);
    }

    @Override // org.apache.logging.log4j.message.c
    public ExitMessage newExitMessage(EntryMessage r3) {
        EntryMessage r4 = (EntryMessage) ZeusTransformUtils.wrapperContextForParams(r3, EntryMessage.class, "com.obric.memorydata.plugin");
        return new SimpleExitMessage(this.exitText, r4);
    }
}
