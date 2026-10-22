package kotlin.reflect.jvm.internal.impl.builtins;

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
        UBYTE = new UnsignedType("UBYTE", 0, ClassId.fromString("kotlin/UByte"));
        USHORT = new UnsignedType("USHORT", 1, ClassId.fromString("kotlin/UShort"));
        UINT = new UnsignedType("UINT", 2, ClassId.fromString("kotlin/UInt"));
        ULONG = new UnsignedType("ULONG", 3, ClassId.fromString("kotlin/ULong"));
        $VALUES = $values();
    }

    private UnsignedType(String r5, int r10, ClassId r11) {
        super(r5, r10);
        this.classId = r11;
        Name r12 = r11.getShortClassName();
        this.typeName = r12;
        this.arrayClassId = new ClassId(r11.getPackageFqName(), Name.identifier(r12.asString() + "Array"));
    }

    public static UnsignedType valueOf(String r5) {
        return (UnsignedType) Enum.valueOf(UnsignedType.class, r5);
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
