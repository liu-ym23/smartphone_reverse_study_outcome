package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* JADX INFO: loaded from: classes3.dex */
public abstract class JvmType {
    private static final Primitive BOOLEAN = null;
    private static final Primitive BYTE = null;
    private static final Primitive CHAR = null;
    public static final Companion Companion = null;
    private static final Primitive DOUBLE = null;
    private static final Primitive FLOAT = null;
    private static final Primitive INT = null;
    private static final Primitive LONG = null;
    private static final Primitive SHORT = null;

    public static final class Array extends JvmType {
        private final JvmType elementType;

        public Array(JvmType r10) {
            Intrinsics.checkNotNullParameter(r10, "elementType");
            super(null);
            this.elementType = r10;
        }

        public final JvmType getElementType() {
            return this.elementType;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final Primitive getBOOLEAN$descriptors_jvm() {
            return JvmType.access$getBOOLEAN$cp();
        }

        public final Primitive getBYTE$descriptors_jvm() {
            return JvmType.access$getBYTE$cp();
        }

        public final Primitive getCHAR$descriptors_jvm() {
            return JvmType.access$getCHAR$cp();
        }

        public final Primitive getDOUBLE$descriptors_jvm() {
            return JvmType.access$getDOUBLE$cp();
        }

        public final Primitive getFLOAT$descriptors_jvm() {
            return JvmType.access$getFLOAT$cp();
        }

        public final Primitive getINT$descriptors_jvm() {
            return JvmType.access$getINT$cp();
        }

        public final Primitive getLONG$descriptors_jvm() {
            return JvmType.access$getLONG$cp();
        }

        public final Primitive getSHORT$descriptors_jvm() {
            return JvmType.access$getSHORT$cp();
        }
    }

    public static final class Object extends JvmType {
        private final String internalName;

        public Object(String r10) {
            Intrinsics.checkNotNullParameter(r10, "internalName");
            super(null);
            this.internalName = r10;
        }

        public final String getInternalName() {
            return this.internalName;
        }
    }

    public static final class Primitive extends JvmType {
        private final JvmPrimitiveType jvmPrimitiveType;

        public Primitive(JvmPrimitiveType r10) {
            super(null);
            this.jvmPrimitiveType = r10;
        }

        public final JvmPrimitiveType getJvmPrimitiveType() {
            return this.jvmPrimitiveType;
        }
    }

    static {
        Companion = new Companion(null);
        BOOLEAN = new Primitive(JvmPrimitiveType.BOOLEAN);
        CHAR = new Primitive(JvmPrimitiveType.CHAR);
        BYTE = new Primitive(JvmPrimitiveType.BYTE);
        SHORT = new Primitive(JvmPrimitiveType.SHORT);
        INT = new Primitive(JvmPrimitiveType.INT);
        FLOAT = new Primitive(JvmPrimitiveType.FLOAT);
        LONG = new Primitive(JvmPrimitiveType.LONG);
        DOUBLE = new Primitive(JvmPrimitiveType.DOUBLE);
    }

    private JvmType() {
    }

    public /* synthetic */ JvmType(DefaultConstructorMarker r10) {
        this();
    }

    public static final /* synthetic */ Primitive access$getBOOLEAN$cp() {
        return BOOLEAN;
    }

    public static final /* synthetic */ Primitive access$getBYTE$cp() {
        return BYTE;
    }

    public static final /* synthetic */ Primitive access$getCHAR$cp() {
        return CHAR;
    }

    public static final /* synthetic */ Primitive access$getDOUBLE$cp() {
        return DOUBLE;
    }

    public static final /* synthetic */ Primitive access$getFLOAT$cp() {
        return FLOAT;
    }

    public static final /* synthetic */ Primitive access$getINT$cp() {
        return INT;
    }

    public static final /* synthetic */ Primitive access$getLONG$cp() {
        return LONG;
    }

    public static final /* synthetic */ Primitive access$getSHORT$cp() {
        return SHORT;
    }

    public String toString() {
        return JvmTypeFactoryImpl.INSTANCE.toString2(this);
    }
}
