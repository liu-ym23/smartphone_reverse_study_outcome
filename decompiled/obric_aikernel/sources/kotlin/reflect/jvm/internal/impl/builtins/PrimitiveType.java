package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public final enum PrimitiveType extends Enum<PrimitiveType> {
    private static final /* synthetic */ PrimitiveType[] $VALUES = null;
    public static final PrimitiveType BOOLEAN = null;
    public static final PrimitiveType BYTE = null;
    public static final PrimitiveType CHAR = null;
    public static final Companion Companion = null;
    public static final PrimitiveType DOUBLE = null;
    public static final PrimitiveType FLOAT = null;
    public static final PrimitiveType INT = null;
    public static final PrimitiveType LONG = null;

    @JvmField
    public static final Set<PrimitiveType> NUMBER_TYPES = null;
    public static final PrimitiveType SHORT = null;
    private final Lazy arrayTypeFqName$delegate;
    private final Name arrayTypeName;
    private final Lazy typeFqName$delegate;
    private final Name typeName;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    private static final /* synthetic */ PrimitiveType[] $values() {
        return new PrimitiveType[]{BOOLEAN, CHAR, BYTE, SHORT, INT, FLOAT, LONG, DOUBLE};
    }

    static {
        BOOLEAN = new PrimitiveType("BOOLEAN", 0, "Boolean");
        PrimitiveType r10 = new PrimitiveType("CHAR", 1, "Char");
        CHAR = r10;
        PrimitiveType r11 = new PrimitiveType("BYTE", 2, "Byte");
        BYTE = r11;
        PrimitiveType r12 = new PrimitiveType("SHORT", 3, "Short");
        SHORT = r12;
        PrimitiveType r13 = new PrimitiveType("INT", 4, "Int");
        INT = r13;
        PrimitiveType r14 = new PrimitiveType("FLOAT", 5, "Float");
        FLOAT = r14;
        PrimitiveType r15 = new PrimitiveType("LONG", 6, "Long");
        LONG = r15;
        PrimitiveType r16 = new PrimitiveType("DOUBLE", 7, "Double");
        DOUBLE = r16;
        $VALUES = $values();
        Companion = new Companion(null);
        NUMBER_TYPES = SetsKt.setOf(new PrimitiveType[]{r10, r11, r12, r13, r14, r15, r16});
    }

    private PrimitiveType(String r10, int r11, String r12) {
        super(r10, r11);
        Name r13 = Name.identifier(r12);
        Intrinsics.checkNotNullExpressionValue(r13, "identifier(typeName)");
        this.typeName = r13;
        Name r14 = Name.identifier(r12 + "Array");
        Intrinsics.checkNotNullExpressionValue(r14, "identifier(\"${typeName}Array\")");
        this.arrayTypeName = r14;
        LazyThreadSafetyMode r15 = LazyThreadSafetyMode.PUBLICATION;
        this.typeFqName$delegate = LazyKt.lazy(r15, new PrimitiveType$typeFqName$2(this));
        this.arrayTypeFqName$delegate = LazyKt.lazy(r15, new PrimitiveType$arrayTypeFqName$2(this));
    }

    public static PrimitiveType valueOf(String r10) {
        return (PrimitiveType) Enum.valueOf(PrimitiveType.class, r10);
    }

    public static PrimitiveType[] values() {
        return (PrimitiveType[]) $VALUES.clone();
    }

    public final FqName getArrayTypeFqName() {
        return (FqName) this.arrayTypeFqName$delegate.getValue();
    }

    public final Name getArrayTypeName() {
        return this.arrayTypeName;
    }

    public final FqName getTypeFqName() {
        return (FqName) this.typeFqName$delegate.getValue();
    }

    public final Name getTypeName() {
        return this.typeName;
    }
}
