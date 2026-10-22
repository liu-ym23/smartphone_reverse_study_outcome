package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLiteMap;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum ProtoBuf$Modality extends Enum<ProtoBuf$Modality> implements Internal$EnumLite {
    private static final /* synthetic */ ProtoBuf$Modality[] $VALUES = null;
    public static final ProtoBuf$Modality ABSTRACT = null;
    public static final ProtoBuf$Modality FINAL = null;
    public static final ProtoBuf$Modality OPEN = null;
    public static final ProtoBuf$Modality SEALED = null;
    private static Internal$EnumLiteMap<ProtoBuf$Modality> internalValueMap;
    private final int value;

    static {
        ProtoBuf$Modality r0 = new ProtoBuf$Modality("FINAL", 0, 0, 0);
        FINAL = r0;
        ProtoBuf$Modality r1 = new ProtoBuf$Modality("OPEN", 1, 1, 1);
        OPEN = r1;
        ProtoBuf$Modality r3 = new ProtoBuf$Modality("ABSTRACT", 2, 2, 2);
        ABSTRACT = r3;
        ProtoBuf$Modality r5 = new ProtoBuf$Modality("SEALED", 3, 3, 3);
        SEALED = r5;
        $VALUES = new ProtoBuf$Modality[]{r0, r1, r3, r5};
        internalValueMap = new AnonymousClass1();
    }

    public static ProtoBuf$Modality[] values() {
        return (ProtoBuf$Modality[]) $VALUES.clone();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite
    public final int getNumber() {
        return this.value;
    }

    public static ProtoBuf$Modality valueOf(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return SEALED;
    L14:
        return ABSTRACT;
    L16:
        return OPEN;
    L18:
        return FINAL;
    }

    public static ProtoBuf$Modality valueOf(String r1) {
        return (ProtoBuf$Modality) a.a(ProtoBuf$Modality.class, r1);
    }

    private ProtoBuf$Modality(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.value = r4;
    }
}
