package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLiteMap;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum ProtoBuf$MemberKind extends Enum<ProtoBuf$MemberKind> implements Internal$EnumLite {
    private static final /* synthetic */ ProtoBuf$MemberKind[] $VALUES = null;
    public static final ProtoBuf$MemberKind DECLARATION = null;
    public static final ProtoBuf$MemberKind DELEGATION = null;
    public static final ProtoBuf$MemberKind FAKE_OVERRIDE = null;
    public static final ProtoBuf$MemberKind SYNTHESIZED = null;
    private static Internal$EnumLiteMap<ProtoBuf$MemberKind> internalValueMap;
    private final int value;

    static {
        ProtoBuf$MemberKind r0 = new ProtoBuf$MemberKind("DECLARATION", 0, 0, 0);
        DECLARATION = r0;
        ProtoBuf$MemberKind r1 = new ProtoBuf$MemberKind("FAKE_OVERRIDE", 1, 1, 1);
        FAKE_OVERRIDE = r1;
        ProtoBuf$MemberKind r3 = new ProtoBuf$MemberKind("DELEGATION", 2, 2, 2);
        DELEGATION = r3;
        ProtoBuf$MemberKind r5 = new ProtoBuf$MemberKind("SYNTHESIZED", 3, 3, 3);
        SYNTHESIZED = r5;
        $VALUES = new ProtoBuf$MemberKind[]{r0, r1, r3, r5};
        internalValueMap = new AnonymousClass1();
    }

    public static ProtoBuf$MemberKind[] values() {
        return (ProtoBuf$MemberKind[]) $VALUES.clone();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite
    public final int getNumber() {
        return this.value;
    }

    public static ProtoBuf$MemberKind valueOf(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return SYNTHESIZED;
    L14:
        return DELEGATION;
    L16:
        return FAKE_OVERRIDE;
    L18:
        return DECLARATION;
    }

    public static ProtoBuf$MemberKind valueOf(String r1) {
        return (ProtoBuf$MemberKind) a.a(ProtoBuf$MemberKind.class, r1);
    }

    private ProtoBuf$MemberKind(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.value = r4;
    }
}
