package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public final enum UnsignedType extends Enum<UnsignedType> {
    private static final /* synthetic */ UnsignedType[] $VALUES = null;
    public static final UnsignedType UBYTE = null;
    public static final UnsignedType UINT = null;
    public static final UnsignedType ULONG = null;
    public static final UnsignedType USHORT = null;
    private final ClassId arrayClassId;
    private final ClassId classId;
    private final Name typeName;

    private static final /* synthetic */ UnsignedType[] $values() {
        return new UnsignedType[]{UBYTE, USHORT, UINT, ULONG};
    }

    static {
        ClassId r10 = ClassId.fromString("kotlin/UByte");
        Intrinsics.checkNotNullExpressionValue(r10, "fromString(\"kotlin/UByte\")");
        UBYTE = new UnsignedType("UBYTE", 0, r10);
        ClassId r11 = ClassId.fromString("kotlin/UShort");
        Intrinsics.checkNotNullExpressionValue(r11, "fromString(\"kotlin/UShort\")");
        USHORT = new UnsignedType("USHORT", 1, r11);
        ClassId r12 = ClassId.fromString("kotlin/UInt");
        Intrinsics.checkNotNullExpressionValue(r12, "fromString(\"kotlin/UInt\")");
        UINT = new UnsignedType("UINT", 2, r12);
        ClassId r13 = ClassId.fromString("kotlin/ULong");
        Intrinsics.checkNotNullExpressionValue(r13, "fromString(\"kotlin/ULong\")");
        ULONG = new UnsignedType("ULONG", 3, r13);
        $VALUES = $values();
    }

    private UnsignedType(String r10, int r11, ClassId r12) {
        super(r10, r11);
        this.classId = r12;
        Name r13 = r12.getShortClassName();
        Intrinsics.checkNotNullExpressionValue(r13, "classId.shortClassName");
        this.typeName = r13;
        this.arrayClassId = new ClassId(r12.getPackageFqName(), Name.identifier(r13.asString() + "Array"));
    }

    public static UnsignedType valueOf(String r10) {
        return (UnsignedType) Enum.valueOf(UnsignedType.class, r10);
    }

    public static UnsignedType[] values() {
        return (UnsignedType[]) $VALUES.clone();
    }

    public final ClassId getArrayClassId() {
        return this.arrayClassId;
    }

    public final ClassId getClassId() {
        return this.classId;
    }

    public final Name getTypeName() {
        return this.typeName;
    }
}
