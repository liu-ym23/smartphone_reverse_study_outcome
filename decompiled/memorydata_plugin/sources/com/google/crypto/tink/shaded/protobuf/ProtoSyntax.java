package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ProtoSyntax extends Enum<ProtoSyntax> {
    private static final /* synthetic */ ProtoSyntax[] $VALUES = null;
    public static final ProtoSyntax PROTO2 = null;
    public static final ProtoSyntax PROTO3 = null;

    static {
        ProtoSyntax r0 = new ProtoSyntax("PROTO2", 0);
        PROTO2 = r0;
        ProtoSyntax r1 = new ProtoSyntax("PROTO3", 1);
        PROTO3 = r1;
        $VALUES = new ProtoSyntax[]{r0, r1};
    }

    private ProtoSyntax(String r1, int r2) {
        super(r1, r2);
    }

    public static ProtoSyntax valueOf(String r2) {
        return (ProtoSyntax) ZeusTransformUtils.preCheckCast(Enum.valueOf(ProtoSyntax.class, r2), ProtoSyntax.class, "com.obric.memorydata.plugin");
    }

    public static ProtoSyntax[] values() {
        return (ProtoSyntax[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ProtoSyntax[].class, "com.obric.memorydata.plugin");
    }
}
