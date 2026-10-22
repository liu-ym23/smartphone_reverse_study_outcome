package androidx.room.compiler.processing;

import com.squareup.javapoet.x;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001b\b \u0018\u0000 #2\u00020\u0001:\u0002#$B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\nJ\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\nJ\u0006\u0010\u0013\u001a\u00020\nJ\u0006\u0010\u0014\u001a\u00020\nJ\u0006\u0010\u0015\u001a\u00020\nJ\u0006\u0010\u0016\u001a\u00020\nJ\u0006\u0010\u0017\u001a\u00020\nJ\u0006\u0010\u0018\u001a\u00020\nJ\u0006\u0010\u0019\u001a\u00020\nJ\u0006\u0010\u001a\u001a\u00020\nJ\u0006\u0010\u001b\u001a\u00020\nJ\u0006\u0010\u001c\u001a\u00020\nJ\u0006\u0010\u001d\u001a\u00020\nJ\u0006\u0010\u001e\u001a\u00020\nJ\u0006\u0010\u001f\u001a\u00020\nJ\u0006\u0010 \u001a\u00020\nJ\u0006\u0010!\u001a\u00020\nJ\u0006\u0010\"\u001a\u00020\nR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006%"}, d2 = {"Landroidx/room/compiler/processing/InternalXAnnotationValue;", "Landroidx/room/compiler/processing/XAnnotationValue;", "()V", "kind", "Landroidx/room/compiler/processing/InternalXAnnotationValue$Kind;", "getKind", "()Landroidx/room/compiler/processing/InternalXAnnotationValue$Kind;", "kind$delegate", "Lkotlin/Lazy;", "hasAnnotationListValue", "", "hasAnnotationValue", "hasBooleanListValue", "hasBooleanValue", "hasByteListValue", "hasByteValue", "hasCharListValue", "hasCharValue", "hasDoubleListValue", "hasDoubleValue", "hasEnumListValue", "hasEnumValue", "hasFloatListValue", "hasFloatValue", "hasIntListValue", "hasIntValue", "hasListValue", "hasLongListValue", "hasLongValue", "hasShortListValue", "hasShortValue", "hasStringListValue", "hasStringValue", "hasTypeListValue", "hasTypeValue", "Companion", "Kind", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class InternalXAnnotationValue implements XAnnotationValue {

    @Deprecated
    private static final x CLASS = null;
    private static final Companion Companion = null;

    @Deprecated
    private static final x KCLASS = null;

    @Deprecated
    private static final x STRING = null;
    private final Lazy kind$delegate;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Landroidx/room/compiler/processing/InternalXAnnotationValue$Companion;", "", "<init>", "()V", "Lcom/squareup/javapoet/x;", "STRING", "Lcom/squareup/javapoet/x;", "getSTRING", "()Lcom/squareup/javapoet/x;", "CLASS", "getCLASS", "KCLASS", "getKCLASS", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final x getCLASS() {
            return InternalXAnnotationValue.access$getCLASS$cp();
        }

        public final x getKCLASS() {
            return InternalXAnnotationValue.access$getKCLASS$cp();
        }

        public final x getSTRING() {
            return InternalXAnnotationValue.access$getSTRING$cp();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0082\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Landroidx/room/compiler/processing/InternalXAnnotationValue$Kind;", "", "(Ljava/lang/String;I)V", "BOOLEAN", "INT", "SHORT", "LONG", "FLOAT", "DOUBLE", "BYTE", "CHAR", "STRING", "ENUM", "ANNOTATION", "TYPE", "Companion", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum Kind extends Enum<Kind> {
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind ANNOTATION = null;
        public static final Kind BOOLEAN = null;
        public static final Kind BYTE = null;
        public static final Kind CHAR = null;
        public static final Companion Companion = null;
        public static final Kind DOUBLE = null;
        public static final Kind ENUM = null;
        public static final Kind FLOAT = null;
        public static final Kind INT = null;
        public static final Kind LONG = null;
        public static final Kind SHORT = null;
        public static final Kind STRING = null;
        public static final Kind TYPE = null;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/compiler/processing/InternalXAnnotationValue$Kind$Companion;", "", "()V", "of", "Landroidx/room/compiler/processing/InternalXAnnotationValue$Kind;", "type", "Landroidx/room/compiler/processing/XType;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r5) {
                this();
            }

            public final Kind of(XType r5) {
                Intrinsics.checkNotNullParameter(r5, "type");
                if (XTypeKt.isArray(r5) == false) goto L7;
                return of(((XArrayType) r5).getComponentType());
            L7:
                if (Intrinsics.areEqual(r5.getTypeName(), x.e) == false) goto L10;
                return Kind.BOOLEAN;
            L10:
                if (Intrinsics.areEqual(r5.getTypeName(), x.f15023h) == false) goto L13;
                return Kind.INT;
            L13:
                if (Intrinsics.areEqual(r5.getTypeName(), x.g) == false) goto L16;
                return Kind.SHORT;
            L16:
                if (Intrinsics.areEqual(r5.getTypeName(), x.f15024i) == false) goto L19;
                return Kind.LONG;
            L19:
                if (Intrinsics.areEqual(r5.getTypeName(), x.f15026k) == false) goto L22;
                return Kind.FLOAT;
            L22:
                if (Intrinsics.areEqual(r5.getTypeName(), x.f15027l) == false) goto L25;
                return Kind.DOUBLE;
            L25:
                if (Intrinsics.areEqual(r5.getTypeName(), x.f) == false) goto L28;
                return Kind.BYTE;
            L28:
                if (Intrinsics.areEqual(r5.getTypeName(), x.f15025j) == false) goto L31;
                return Kind.CHAR;
            L31:
                if (Intrinsics.areEqual(r5.getTypeName(), InternalXAnnotationValue.access$getCompanion$p().getSTRING()) == false) goto L34;
                return Kind.STRING;
            L34:
                if (Intrinsics.areEqual(JavaPoetExtKt.rawTypeName(r5.getTypeName()), InternalXAnnotationValue.access$getCompanion$p().getCLASS()) == false) goto L37;
                return Kind.TYPE;
            L37:
                if (Intrinsics.areEqual(JavaPoetExtKt.rawTypeName(r5.getTypeName()), InternalXAnnotationValue.access$getCompanion$p().getKCLASS()) == true) goto L62;
                XTypeElement r10 = r5.getTypeElement();
                if (r10 != null) goto L42;
            L44:
                XTypeElement r11 = r5.getTypeElement();
                if (r11 == null) goto L51;
                if (r11.isAnnotationClass() != true) goto L51;
                return Kind.ANNOTATION;
            L51:
                throw new IllegalStateException(("Unexpected type: " + r5).toString());
            L42:
                if (XEnumTypeElementKt.isEnum(r10) != true) goto L44;
                return Kind.ENUM;
            L62:
                return Kind.TYPE;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ Kind[] $values() {
            return new Kind[]{BOOLEAN, INT, SHORT, LONG, FLOAT, DOUBLE, BYTE, CHAR, STRING, ENUM, ANNOTATION, TYPE};
        }

        static {
            BOOLEAN = new Kind("BOOLEAN", 0);
            INT = new Kind("INT", 1);
            SHORT = new Kind("SHORT", 2);
            LONG = new Kind("LONG", 3);
            FLOAT = new Kind("FLOAT", 4);
            DOUBLE = new Kind("DOUBLE", 5);
            BYTE = new Kind("BYTE", 6);
            CHAR = new Kind("CHAR", 7);
            STRING = new Kind("STRING", 8);
            ENUM = new Kind("ENUM", 9);
            ANNOTATION = new Kind("ANNOTATION", 10);
            TYPE = new Kind("TYPE", 11);
            $VALUES = $values();
            Companion = new Companion(null);
        }

        private Kind(String r5, int r10) {
            super(r5, r10);
        }

        public static Kind valueOf(String r5) {
            return (Kind) Enum.valueOf(Kind.class, r5);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }
    }

    static {
        Companion = new Companion(null);
        STRING = x.e(String.class);
        CLASS = x.e(Class.class);
        KCLASS = x.e(KClass.class);
    }

    public InternalXAnnotationValue() {
        this.kind$delegate = LazyKt.lazy(new InternalXAnnotationValue$kind$2(this));
    }

    public static final /* synthetic */ x access$getCLASS$cp() {
        return CLASS;
    }

    public static final /* synthetic */ Companion access$getCompanion$p() {
        return Companion;
    }

    public static final /* synthetic */ x access$getKCLASS$cp() {
        return KCLASS;
    }

    public static final /* synthetic */ x access$getSTRING$cp() {
        return STRING;
    }

    private final Kind getKind() {
        return (Kind) this.kind$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasAnnotationListValue() {
        if (getKind() == Kind.ANNOTATION) goto L5;
    L7:
        return false;
    L5:
        if (hasListValue() == false) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasAnnotationValue() {
        if (getKind() == Kind.ANNOTATION) goto L5;
    L7:
        return false;
    L5:
        if (hasListValue() == true) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasBooleanListValue() {
        if (getKind() == Kind.BOOLEAN) goto L5;
    L7:
        return false;
    L5:
        if (hasListValue() == false) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasBooleanValue() {
        if (getKind() == Kind.BOOLEAN) goto L5;
    L7:
        return false;
    L5:
        if (hasListValue() == true) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasByteListValue() {
        if (getKind() == Kind.BYTE) goto L5;
    L7:
        return false;
    L5:
        if (hasListValue() == false) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasByteValue() {
        if (getKind() == Kind.BYTE) goto L5;
    L7:
        return false;
    L5:
        if (hasListValue() == true) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasCharListValue() {
        if (getKind() == Kind.CHAR) goto L5;
    L7:
        return false;
    L5:
        if (hasListValue() == false) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasCharValue() {
        if (getKind() == Kind.CHAR) goto L5;
    L7:
        return false;
    L5:
        if (hasListValue() == true) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasDoubleListValue() {
        if (getKind() == Kind.DOUBLE) goto L5;
    L7:
        return false;
    L5:
        if (hasListValue() == false) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasDoubleValue() {
        if (getKind() == Kind.DOUBLE) goto L5;
    L7:
        return false;
    L5:
        if (hasListValue() == true) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasEnumListValue() {
        if (getKind() == Kind.ENUM) goto L5;
    L7:
        return false;
    L5:
        if (hasListValue() == false) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasEnumValue() {
        if (getKind() == Kind.ENUM) goto L5;
    L7:
        return false;
    L5:
        if (hasListValue() == true) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasFloatListValue() {
        if (getKind() == Kind.FLOAT) goto L5;
    L7:
        return false;
    L5:
        if (hasListValue() == false) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasFloatValue() {
        if (getKind() == Kind.FLOAT) goto L5;
    L7:
        return false;
    L5:
        if (hasListValue() == true) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasIntListValue() {
        if (getKind() == Kind.INT) goto L5;
    L7:
        return false;
    L5:
        if (hasListValue() == false) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasIntValue() {
        if (getKind() == Kind.INT) goto L5;
    L7:
        return false;
    L5:
        if (hasListValue() == true) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasListValue() {
        return XTypeKt.isArray(getValueType());
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasLongListValue() {
        if (getKind() == Kind.LONG) goto L5;
    L7:
        return false;
    L5:
        if (hasListValue() == false) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasLongValue() {
        if (getKind() == Kind.LONG) goto L5;
    L7:
        return false;
    L5:
        if (hasListValue() == true) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasShortListValue() {
        if (getKind() == Kind.SHORT) goto L5;
    L7:
        return false;
    L5:
        if (hasListValue() == false) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasShortValue() {
        if (getKind() == Kind.SHORT) goto L5;
    L7:
        return false;
    L5:
        if (hasListValue() == true) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasStringListValue() {
        if (getKind() == Kind.STRING) goto L5;
    L7:
        return false;
    L5:
        if (hasListValue() == false) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasStringValue() {
        if (getKind() == Kind.STRING) goto L5;
    L7:
        return false;
    L5:
        if (hasListValue() == true) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasTypeListValue() {
        if (getKind() == Kind.TYPE) goto L5;
    L7:
        return false;
    L5:
        if (hasListValue() == false) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public final boolean hasTypeValue() {
        if (getKind() == Kind.TYPE) goto L5;
    L7:
        return false;
    L5:
        if (hasListValue() == true) goto L7;
        return true;
    }
}
