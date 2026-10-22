package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
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
    public boolean isSupported(Class<?> r8) {
        return GeneratedMessageLite.class.isAssignableFrom(r8);
    }

    @Override // com.google.protobuf.MessageInfoFactory
    public MessageInfo messageInfoFor(Class<?> r8) {
        if (GeneratedMessageLite.class.isAssignableFrom(r8) == false) goto L10;
        return (MessageInfo) GeneratedMessageLite.getDefaultInstance(r8.asSubclass(GeneratedMessageLite.class)).buildMessageInfo();
    L6:
        e = move-exception;
        throw new RuntimeException("Unable to get message info for ".concat(r8.getName()), e);
    L10:
        throw new IllegalArgumentException("Unsupported message type: ".concat(r8.getName()));
    }
}
