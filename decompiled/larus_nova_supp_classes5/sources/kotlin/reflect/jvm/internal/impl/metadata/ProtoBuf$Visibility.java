package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLiteMap;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum ProtoBuf$Visibility extends Enum<ProtoBuf$Visibility> implements Internal$EnumLite {
    private static final /* synthetic */ ProtoBuf$Visibility[] $VALUES = null;
    public static final ProtoBuf$Visibility INTERNAL = null;
    public static final ProtoBuf$Visibility LOCAL = null;
    public static final ProtoBuf$Visibility PRIVATE = null;
    public static final ProtoBuf$Visibility PRIVATE_TO_THIS = null;
    public static final ProtoBuf$Visibility PROTECTED = null;
    public static final ProtoBuf$Visibility PUBLIC = null;
    private static Internal$EnumLiteMap<ProtoBuf$Visibility> internalValueMap;
    private final int value;

    static {
        ProtoBuf$Visibility r0 = new ProtoBuf$Visibility("INTERNAL", 0, 0, 0);
        INTERNAL = r0;
        ProtoBuf$Visibility r1 = new ProtoBuf$Visibility("PRIVATE", 1, 1, 1);
        PRIVATE = r1;
        ProtoBuf$Visibility r3 = new ProtoBuf$Visibility("PROTECTED", 2, 2, 2);
        PROTECTED = r3;
        ProtoBuf$Visibility r5 = new ProtoBuf$Visibility("PUBLIC", 3, 3, 3);
        PUBLIC = r5;
        ProtoBuf$Visibility r7 = new ProtoBuf$Visibility("PRIVATE_TO_THIS", 4, 4, 4);
        PRIVATE_TO_THIS = r7;
        ProtoBuf$Visibility r9 = new ProtoBuf$Visibility("LOCAL", 5, 5, 5);
        LOCAL = r9;
        $VALUES = new ProtoBuf$Visibility[]{r0, r1, r3, r5, r7, r9};
        internalValueMap = new AnonymousClass1();
    }

    public static ProtoBuf$Visibility[] values() {
        return (ProtoBuf$Visibility[]) $VALUES.clone();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite
    public final int getNumber() {
        return this.value;
    }

    public static ProtoBuf$Visibility valueOf(int r1) {
        if (r1 == 0) goto L26;
        if (r1 == 1) goto L24;
        if (r1 == 2) goto L22;
        if (r1 == 3) goto L20;
        if (r1 == 4) goto L18;
        if (r1 == 5) goto L16;
        return null;
    L16:
        return LOCAL;
    L18:
        return PRIVATE_TO_THIS;
    L20:
        return PUBLIC;
    L22:
        return PROTECTED;
    L24:
        return PRIVATE;
    L26:
        return INTERNAL;
    }

    public static ProtoBuf$Visibility valueOf(String r1) {
        return (ProtoBuf$Visibility) a.a(ProtoBuf$Visibility.class, r1);
    }

    private ProtoBuf$Visibility(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.value = r4;
    }
}
