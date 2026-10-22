package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
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
    public boolean isSupported(Class<?> r1) {
        return GeneratedMessageLite.class.isAssignableFrom(r1);
    }

    @Override // com.google.protobuf.MessageInfoFactory
    public MessageInfo messageInfoFor(Class<?> r4) {
        if (GeneratedMessageLite.class.isAssignableFrom(r4) == false) goto L10;
        return (MessageInfo) ZeusTransformUtils.preCheckCast(GeneratedMessageLite.getDefaultInstance(r4.asSubclass(GeneratedMessageLite.class)).buildMessageInfo(), MessageInfo.class, "com.obric.memorydata.plugin");
    L6:
        e = move-exception;
        throw new RuntimeException("Unable to get message info for " + r4.getName(), e);
    L10:
        throw new IllegalArgumentException("Unsupported message type: " + r4.getName());
    }
}
