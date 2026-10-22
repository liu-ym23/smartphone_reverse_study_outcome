package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum PrimitiveType extends Enum<PrimitiveType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PrimitiveType[] $VALUES = null;
    public static final PrimitiveType BOOLEAN = null;
    public static final PrimitiveType BYTE = null;
    public static final PrimitiveType CHAR = null;
    public static final Companion Companion = null;
    public static final PrimitiveType DOUBLE = null;
    public static final PrimitiveType FLOAT = null;
    public static final PrimitiveType INT = null;
    public static final PrimitiveType LONG = null;
    public static final Set<PrimitiveType> NUMBER_TYPES = null;
    public static final PrimitiveType SHORT = null;
    private final Lazy arrayTypeFqName$delegate;
    private final Name arrayTypeName;
    private final Lazy typeFqName$delegate;
    private final Name typeName;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    private static final /* synthetic */ PrimitiveType[] $values() {
        return new PrimitiveType[]{BOOLEAN, CHAR, BYTE, SHORT, INT, FLOAT, LONG, DOUBLE};
    }

    public static /* synthetic */ FqName accessor$PrimitiveType$lambda0(PrimitiveType r0) {
        return typeFqName_delegate$lambda$0(r0);
    }

    public static /* synthetic */ FqName accessor$PrimitiveType$lambda1(PrimitiveType r0) {
        return arrayTypeFqName_delegate$lambda$1(r0);
    }

    static {
        BOOLEAN = new PrimitiveType("BOOLEAN", 0, "Boolean");
        PrimitiveType r0 = new PrimitiveType("CHAR", 1, "Char");
        CHAR = r0;
        PrimitiveType r1 = new PrimitiveType("BYTE", 2, "Byte");
        BYTE = r1;
        PrimitiveType r2 = new PrimitiveType("SHORT", 3, "Short");
        SHORT = r2;
        PrimitiveType r5 = new PrimitiveType("INT", 4, "Int");
        INT = r5;
        PrimitiveType r7 = new PrimitiveType("FLOAT", 5, "Float");
        FLOAT = r7;
        PrimitiveType r9 = new PrimitiveType("LONG", 6, "Long");
        LONG = r9;
        PrimitiveType r11 = new PrimitiveType("DOUBLE", 7, "Double");
        DOUBLE = r11;
        PrimitiveType[] r13 = $values();
        $VALUES = r13;
        $ENTRIES = EnumEntriesKt.enumEntries(r13);
        Companion = new Companion(null);
        NUMBER_TYPES = SetsKt.setOf(new PrimitiveType[]{r0, r1, r2, r5, r7, r9, r11});
    }

    public static PrimitiveType[] values() {
        return (PrimitiveType[]) $VALUES.clone();
    }

    public final FqName getArrayTypeFqName() {
        return (FqName) this.arrayTypeFqName$delegate.getValue();
    }

    public final FqName getTypeFqName() {
        return (FqName) this.typeFqName$delegate.getValue();
    }

    public final Name getArrayTypeName() {
        return this.arrayTypeName;
    }

    public final Name getTypeName() {
        return this.typeName;
    }

    private static final FqName arrayTypeFqName_delegate$lambda$1(PrimitiveType r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(r1.arrayTypeName);
    }

    private static final FqName typeFqName_delegate$lambda$0(PrimitiveType r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(r1.typeName);
    }

    public static PrimitiveType valueOf(String r1) {
        return (PrimitiveType) a.a(PrimitiveType.class, r1);
    }

    private PrimitiveType(String r1, int r2, String r3) {
        super(r1, r2);
        this.typeName = Name.identifier(r3);
        this.arrayTypeName = Name.identifier(r3 + "Array");
        LazyThreadSafetyMode r4 = LazyThreadSafetyMode.PUBLICATION;
        this.typeFqName$delegate = LazyKt.lazy(r4, new PrimitiveType$$Lambda$0(this));
        this.arrayTypeFqName$delegate = LazyKt.lazy(r4, new PrimitiveType$$Lambda$1(this));
    }
}
