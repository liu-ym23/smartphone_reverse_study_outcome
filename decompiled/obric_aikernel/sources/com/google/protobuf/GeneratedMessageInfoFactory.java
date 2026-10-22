package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
class GeneratedMessageInfoFactory implements MessageInfoFactory {
    private static final GeneratedMessageInfoFactory instance = null;

    static {
        instance = new GeneratedMessageInfoFactory();
    }

    private GeneratedMessageInfoFactory() {
    }

    public static GeneratedMessageInfoFactory getInstance() {
        return instance;
    }

    @Override // com.google.protobuf.MessageInfoFactory
    public boolean isSupported(Class<?> r10) {
        return GeneratedMessageLite.class.isAssignableFrom(r10);
    }

    @Override // com.google.protobuf.MessageInfoFactory
    public MessageInfo messageInfoFor(Class<?> r10) {
        if (GeneratedMessageLite.class.isAssignableFrom(r10) == false) goto L10;
        return (MessageInfo) GeneratedMessageLite.getDefaultInstance(r10.asSubclass(GeneratedMessageLite.class)).buildMessageInfo();
    L6:
        e = move-exception;
        throw new RuntimeException("Unable to get message info for " + r10.getName(), e);
    L10:
        throw new IllegalArgumentException("Unsupported message type: " + r10.getName());
    }
}
