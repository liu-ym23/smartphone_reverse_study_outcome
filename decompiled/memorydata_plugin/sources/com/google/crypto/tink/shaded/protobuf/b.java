package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.at;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<MessageType extends at> implements be<MessageType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final q f4970a = null;

    static {
        f4970a = q.a();
    }

    public b() {
    }

    private UninitializedMessageException a(MessageType r2) {
        at r1 = (at) ZeusTransformUtils.wrapperContextForParams(r2, at.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, a.class) == false) goto L7;
        return ((a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.memorydata.plugin")).newUninitializedMessageException();
    L7:
        return new UninitializedMessageException(r1);
    }

    private MessageType b(MessageType r3) {
        MessageType r4 = (MessageType) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
    L9:
        return r4;
    L5:
        if (r4.isInitialized() == true) goto L9;
        throw a(r4).asInvalidProtocolBufferException().setUnfinishedMessage(r4);
    }

    public MessageType a(ByteString r2, q r3) {
        k r4 = r2.newCodedInput();     // Catch: InvalidProtocolBufferException -> L9
        MessageType r1 = (MessageType) ZeusTransformUtils.preCheckCast(b(r4, r3), at.class, "com.obric.memorydata.plugin");     // Catch: InvalidProtocolBufferException -> L9
        r4.a(0);     // Catch: InvalidProtocolBufferException -> L6
        return r1;
    L6:
        e = move-exception;
        throw e.setUnfinishedMessage(r1);     // Catch: InvalidProtocolBufferException -> L9
    L9:
        e = move-exception;
        throw e;
    }

    public MessageType b(ByteString r1, q r2) {
        return (MessageType) b(a(r1, r2));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.be
    public /* synthetic */ Object c(ByteString r1, q r2) {
        return b(r1, r2);
    }
}
