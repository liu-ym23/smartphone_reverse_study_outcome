package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
final class RawMessageInfo implements MessageInfo {
    private static final int IS_EDITION_BIT = 4;
    private static final int IS_PROTO2_BIT = 1;
    private final MessageLite defaultInstance;
    private final int flags;
    private final String info;
    private final Object[] objects;

    RawMessageInfo(MessageLite r10, String r11, Object[] r12) {
        this.defaultInstance = r10;
        this.info = r11;
        this.objects = r12;
        int r13 = r11.charAt(0);
        if (r13 >= 55296) goto L5;
    L4:
        this.flags = r13;
        return;
    L5:
        int r14 = r13 & 8191;
        int r15 = 13;
        int r16 = 1;
    L6:
        int r17 = r16 + 1;
        char r18 = r11.charAt(r16);
        if (r18 < 55296) goto L9;
        r14 = r14 | ((r18 & 8191) << r15);
        r15 = r15 + 13;
        r16 = r17;
        goto L6
    L9:
        r13 = r14 | (r18 << r15);
        goto L4
    }

    @Override // com.google.protobuf.MessageInfo
    public MessageLite getDefaultInstance() {
        return this.defaultInstance;
    }

    Object[] getObjects() {
        return this.objects;
    }

    String getStringInfo() {
        return this.info;
    }

    @Override // com.google.protobuf.MessageInfo
    public ProtoSyntax getSyntax() {
        int r10 = this.flags;
        if ((r10 & 1) == 0) goto L7;
        return ProtoSyntax.PROTO2;
    L7:
        if ((r10 & 4) != 4) goto L11;
        return ProtoSyntax.EDITIONS;
    L11:
        return ProtoSyntax.PROTO3;
    }

    @Override // com.google.protobuf.MessageInfo
    public boolean isMessageSetWireFormat() {
        if ((this.flags & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }
}
