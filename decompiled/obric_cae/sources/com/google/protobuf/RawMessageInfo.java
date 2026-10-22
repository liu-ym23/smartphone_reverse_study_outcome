package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
final class RawMessageInfo implements MessageInfo {
    private static final int IS_EDITION_BIT = 4;
    private static final int IS_PROTO2_BIT = 1;
    private final MessageLite defaultInstance;
    private final int flags;
    private final String info;
    private final Object[] objects;

    public RawMessageInfo(MessageLite r8, String r10, Object[] r11) {
        this.defaultInstance = r8;
        this.info = r10;
        this.objects = r11;
        int r12 = r10.charAt(0);
        if (r12 >= 55296) goto L5;
    L4:
        this.flags = r12;
        return;
    L5:
        int r13 = r12 & 8191;
        int r14 = 13;
        int r15 = 1;
    L6:
        int r16 = r15 + 1;
        char r17 = r10.charAt(r15);
        if (r17 < 55296) goto L9;
        r13 = r13 | ((r17 & 8191) << r14);
        r14 = r14 + 13;
        r15 = r16;
        goto L6
    L9:
        r12 = r13 | (r17 << r14);
        goto L4
    }

    @Override // com.google.protobuf.MessageInfo
    public MessageLite getDefaultInstance() {
        return this.defaultInstance;
    }

    public Object[] getObjects() {
        return this.objects;
    }

    public String getStringInfo() {
        return this.info;
    }

    @Override // com.google.protobuf.MessageInfo
    public ProtoSyntax getSyntax() {
        int r8 = this.flags;
        if ((r8 & 1) == 0) goto L7;
        return ProtoSyntax.PROTO2;
    L7:
        if ((r8 & 4) != 4) goto L11;
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
