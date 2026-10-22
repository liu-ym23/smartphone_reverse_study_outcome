package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class y implements as {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final y f5048a = null;

    static {
        f5048a = new y();
    }

    private y() {
    }

    public static y a() {
        return f5048a;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.as
    public boolean a(Class<?> r1) {
        return GeneratedMessageLite.class.isAssignableFrom(r1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.as
    public ar b(Class<?> r4) {
        if (GeneratedMessageLite.class.isAssignableFrom(r4) == false) goto L10;
        return (ar) ZeusTransformUtils.preCheckCast(GeneratedMessageLite.getDefaultInstance(r4.asSubclass(GeneratedMessageLite.class)).buildMessageInfo(), ar.class, "com.obric.memorydata.plugin");
    L6:
        e = move-exception;
        throw new RuntimeException("Unable to get message info for " + r4.getName(), e);
    L10:
        throw new IllegalArgumentException("Unsupported message type: " + r4.getName());
    }
}
