package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public final enum UnsignedArrayType extends Enum<UnsignedArrayType> {
    private static final /* synthetic */ UnsignedArrayType[] $VALUES = null;
    public static final UnsignedArrayType UBYTEARRAY = null;
    public static final UnsignedArrayType UINTARRAY = null;
    public static final UnsignedArrayType ULONGARRAY = null;
    public static final UnsignedArrayType USHORTARRAY = null;
    private final ClassId classId;
    private final Name typeName;

    private static final /* synthetic */ UnsignedArrayType[] $values() {
        return new UnsignedArrayType[]{UBYTEARRAY, USHORTARRAY, UINTARRAY, ULONGARRAY};
    }

    static {
        ClassId r10 = ClassId.fromString("kotlin/UByteArray");
        Intrinsics.checkNotNullExpressionValue(r10, "fromString(\"kotlin/UByteArray\")");
        UBYTEARRAY = new UnsignedArrayType("UBYTEARRAY", 0, r10);
        ClassId r11 = ClassId.fromString("kotlin/UShortArray");
        Intrinsics.checkNotNullExpressionValue(r11, "fromString(\"kotlin/UShortArray\")");
        USHORTARRAY = new UnsignedArrayType("USHORTARRAY", 1, r11);
        ClassId r12 = ClassId.fromString("kotlin/UIntArray");
        Intrinsics.checkNotNullExpressionValue(r12, "fromString(\"kotlin/UIntArray\")");
        UINTARRAY = new UnsignedArrayType("UINTARRAY", 2, r12);
        ClassId r13 = ClassId.fromString("kotlin/ULongArray");
        Intrinsics.checkNotNullExpressionValue(r13, "fromString(\"kotlin/ULongArray\")");
        ULONGARRAY = new UnsignedArrayType("ULONGARRAY", 3, r13);
        $VALUES = $values();
    }

    private UnsignedArrayType(String r10, int r11, ClassId r12) {
        super(r10, r11);
        this.classId = r12;
        Name r13 = r12.getShortClassName();
        Intrinsics.checkNotNullExpressionValue(r13, "classId.shortClassName");
        this.typeName = r13;
    }

    public static UnsignedArrayType valueOf(String r10) {
        return (UnsignedArrayType) Enum.valueOf(UnsignedArrayType.class, r10);
    }

    public static UnsignedArrayType[] values() {
        return (UnsignedArrayType[]) $VALUES.clone();
    }

    public final Name getTypeName() {
        return this.typeName;
    }
}
