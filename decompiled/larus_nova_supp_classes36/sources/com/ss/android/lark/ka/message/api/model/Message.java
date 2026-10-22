package com.ss.android.lark.ka.message.api.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class Message {
    private final IMessageBody messageBody;
    private final MessageType messageType;

    public IMessageBody getMessageBody() {
        return this.messageBody;
    }

    public MessageType getMessageType() {
        return this.messageType;
    }

    public Message(MessageType r1, IMessageBody r2) {
        this.messageType = r1;
        this.messageBody = r2;
    }
}
