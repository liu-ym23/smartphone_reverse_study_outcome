package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum Syntax extends Enum<Syntax> implements ab.c {
    private static final /* synthetic */ Syntax[] $VALUES = null;
    public static final Syntax SYNTAX_EDITIONS = null;
    public static final int SYNTAX_EDITIONS_VALUE = 2;
    public static final Syntax SYNTAX_PROTO2 = null;
    public static final int SYNTAX_PROTO2_VALUE = 0;
    public static final Syntax SYNTAX_PROTO3 = null;
    public static final int SYNTAX_PROTO3_VALUE = 1;
    public static final Syntax UNRECOGNIZED = null;
    private static final ab.d<Syntax> internalValueMap = null;
    private final int value;

    private static final class a implements ab.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ab.e f4928a = null;

        static {
            f4928a = new a();
        }

        private a() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ab.e
        public boolean a(int r1) {
            if (Syntax.forNumber(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        Syntax r0 = new Syntax("SYNTAX_PROTO2", 0, 0);
        SYNTAX_PROTO2 = r0;
        Syntax r1 = new Syntax("SYNTAX_PROTO3", 1, 1);
        SYNTAX_PROTO3 = r1;
        Syntax r3 = new Syntax("SYNTAX_EDITIONS", 2, 2);
        SYNTAX_EDITIONS = r3;
        Syntax r5 = new Syntax("UNRECOGNIZED", 3, -1);
        UNRECOGNIZED = r5;
        $VALUES = new Syntax[]{r0, r1, r3, r5};
        internalValueMap = new AnonymousClass1();
    }

    private Syntax(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static Syntax forNumber(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return SYNTAX_EDITIONS;
    L12:
        return SYNTAX_PROTO3;
    L14:
        return SYNTAX_PROTO2;
    }

    public static ab.d<Syntax> internalGetValueMap() {
        return internalValueMap;
    }

    public static ab.e internalGetVerifier() {
        return a.f4928a;
    }

    @Deprecated
    public static Syntax valueOf(int r0) {
        return forNumber(r0);
    }

    public static Syntax valueOf(String r2) {
        return (Syntax) ZeusTransformUtils.preCheckCast(Enum.valueOf(Syntax.class, r2), Syntax.class, "com.obric.memorydata.plugin");
    }

    public static Syntax[] values() {
        return (Syntax[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Syntax[].class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.c
    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
