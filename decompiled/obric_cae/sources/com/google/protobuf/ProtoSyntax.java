package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final enum ProtoSyntax extends java.lang.Enum<ProtoSyntax> {
    private static final /* synthetic */ ProtoSyntax[] $VALUES = null;
    public static final ProtoSyntax EDITIONS = null;
    public static final ProtoSyntax PROTO2 = null;
    public static final ProtoSyntax PROTO3 = null;

    private static /* synthetic */ ProtoSyntax[] $values() {
        return new ProtoSyntax[]{PROTO2, PROTO3, EDITIONS};
    }

    static {
        PROTO2 = new ProtoSyntax("PROTO2", 0);
        PROTO3 = new ProtoSyntax("PROTO3", 1);
        EDITIONS = new ProtoSyntax("EDITIONS", 2);
        $VALUES = $values();
    }

    private ProtoSyntax(String r8, int r10) {
        super(r8, r10);
    }

    public static ProtoSyntax valueOf(String r8) {
        return (ProtoSyntax) java.lang.Enum.valueOf(ProtoSyntax.class, r8);
    }

    public static ProtoSyntax[] values() {
        return (ProtoSyntax[]) $VALUES.clone();
    }
}
