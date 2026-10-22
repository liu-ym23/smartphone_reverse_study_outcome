package kotlin.reflect.jvm.internal.impl.builtins;

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
        UBYTEARRAY = new UnsignedArrayType("UBYTEARRAY", 0, ClassId.fromString("kotlin/UByteArray"));
        USHORTARRAY = new UnsignedArrayType("USHORTARRAY", 1, ClassId.fromString("kotlin/UShortArray"));
        UINTARRAY = new UnsignedArrayType("UINTARRAY", 2, ClassId.fromString("kotlin/UIntArray"));
        ULONGARRAY = new UnsignedArrayType("ULONGARRAY", 3, ClassId.fromString("kotlin/ULongArray"));
        $VALUES = $values();
    }

    private UnsignedArrayType(String r5, int r10, ClassId r11) {
        super(r5, r10);
        this.classId = r11;
        this.typeName = r11.getShortClassName();
    }

    public static UnsignedArrayType valueOf(String r5) {
        return (UnsignedArrayType) Enum.valueOf(UnsignedArrayType.class, r5);
    }

    public static UnsignedArrayType[] values() {
        return (UnsignedArrayType[]) $VALUES.clone();
    }

    public final Name getTypeName() {
        return this.typeName;
    }
}
