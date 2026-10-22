package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum JvmPrimitiveType extends Enum<JvmPrimitiveType> {
    private static final /* synthetic */ JvmPrimitiveType[] $VALUES = null;
    public static final JvmPrimitiveType BOOLEAN = null;
    public static final JvmPrimitiveType BYTE = null;
    public static final JvmPrimitiveType CHAR = null;
    public static final JvmPrimitiveType DOUBLE = null;
    public static final JvmPrimitiveType FLOAT = null;
    public static final JvmPrimitiveType INT = null;
    public static final JvmPrimitiveType LONG = null;
    private static final Map<String, String> OWNER_TO_BOXING_METHOD_DESCRIPTOR = null;
    public static final JvmPrimitiveType SHORT = null;
    private static final Map<String, JvmPrimitiveType> TYPE_BY_DESC = null;
    private static final Map<String, JvmPrimitiveType> TYPE_BY_NAME = null;
    private static final Map<PrimitiveType, JvmPrimitiveType> TYPE_BY_PRIMITIVE_TYPE = null;
    private static final Set<String> WRAPPER_CLASS_INTERNAL_NAMES = null;
    private final String desc;
    private final String name;
    private final PrimitiveType primitiveType;
    private final FqName wrapperFqName;

    private static /* synthetic */ void $$$reportNull$$$0(int r8) {
        if (r8 == 4) goto L7;
        if (r8 == 6) goto L7;
        switch(r8) {
            case 12: goto L7;
            case 13: goto L7;
            case 14: goto L7;
            case 15: goto L7;
            default: goto L6;
        };
    L6:
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r8 == 4) goto L13;
        if (r8 == 6) goto L13;
        switch(r8) {
            case 12: goto L13;
            case 13: goto L13;
            case 14: goto L13;
            case 15: goto L13;
            default: goto L12;
        };
    L12:
        int r4 = 3;
    L14:
        Object[] r5 = new Object[r4];
        switch(r8) {
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L21;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L22;
            case 10: goto L19;
            case 11: goto L17;
            case 12: goto L21;
            case 13: goto L21;
            case 14: goto L21;
            case 15: goto L21;
            default: goto L16;
        };
    L16:
        r5[0] = "internalName";
    L26:
        if (r8 == 4) goto L34;
        if (r8 == 6) goto L34;
        switch(r8) {
            case 12: goto L33;
            case 13: goto L32;
            case 14: goto L31;
            case 15: goto L30;
            default: goto L29;
        };
    L29:
        r5[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
    L35:
        switch(r8) {
            case 1: goto L40;
            case 2: goto L40;
            case 3: goto L39;
            case 4: goto L41;
            case 5: goto L39;
            case 6: goto L41;
            case 7: goto L38;
            case 8: goto L37;
            case 9: goto L37;
            case 10: goto L37;
            case 11: goto L37;
            case 12: goto L41;
            case 13: goto L41;
            case 14: goto L41;
            case 15: goto L41;
            default: goto L36;
        };
    L36:
        r5[2] = "isWrapperClassInternalName";
        goto L41
    L37:
        r5[2] = "<init>";
        goto L41
    L38:
        r5[2] = "getByDesc";
        goto L41
    L39:
        r5[2] = "get";
        goto L41
    L40:
        r5[2] = "isBoxingMethodDescriptor";
    L41:
        String r3 = String.format(r2, r5);
        if (r8 == 4) goto L47;
        if (r8 == 6) goto L47;
        switch(r8) {
            case 12: goto L47;
            case 13: goto L47;
            case 14: goto L47;
            case 15: goto L47;
            default: goto L48;
        };
    L48:
        throw new IllegalArgumentException(r3);
    L47:
        throw new IllegalStateException(r3);
    L30:
        r5[1] = "getWrapperFqName";
        goto L35
    L31:
        r5[1] = "getDesc";
        goto L35
    L32:
        r5[1] = "getJavaKeywordName";
        goto L35
    L33:
        r5[1] = "getPrimitiveType";
    L34:
        r5[1] = "get";
        goto L35
    L17:
        r5[0] = "wrapperClassName";
        goto L26
    L18:
        r5[0] = "primitiveType";
        goto L26
    L19:
        r5[0] = "desc";
        goto L26
    L20:
        r5[0] = EffectConfiguration.KEY_TYPE;
        goto L26
    L21:
        r5[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
        goto L26
    L22:
        r5[0] = DBDefinition.NAME;
        goto L26
    L23:
        r5[0] = "methodDescriptor";
        goto L26
    L24:
        r5[0] = "owner";
    L13:
        r4 = 2;
    L7:
        r2 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    static {
        JvmPrimitiveType r7 = new JvmPrimitiveType("BOOLEAN", 0, PrimitiveType.BOOLEAN, "boolean", "Z", "java.lang.Boolean");
        BOOLEAN = r7;
        JvmPrimitiveType r0 = new JvmPrimitiveType("CHAR", 1, PrimitiveType.CHAR, "char", "C", "java.lang.Character");
        CHAR = r0;
        JvmPrimitiveType r1 = new JvmPrimitiveType("BYTE", 2, PrimitiveType.BYTE, "byte", "B", "java.lang.Byte");
        BYTE = r1;
        JvmPrimitiveType r2 = new JvmPrimitiveType("SHORT", 3, PrimitiveType.SHORT, "short", "S", "java.lang.Short");
        SHORT = r2;
        JvmPrimitiveType r3 = new JvmPrimitiveType("INT", 4, PrimitiveType.INT, "int", "I", "java.lang.Integer");
        INT = r3;
        JvmPrimitiveType r4 = new JvmPrimitiveType("FLOAT", 5, PrimitiveType.FLOAT, "float", "F", "java.lang.Float");
        FLOAT = r4;
        JvmPrimitiveType r5 = new JvmPrimitiveType("LONG", 6, PrimitiveType.LONG, "long", "J", "java.lang.Long");
        LONG = r5;
        JvmPrimitiveType r6 = new JvmPrimitiveType("DOUBLE", 7, PrimitiveType.DOUBLE, "double", "D", "java.lang.Double");
        DOUBLE = r6;
        int r9 = 0;
        $VALUES = new JvmPrimitiveType[]{r7, r0, r1, r2, r3, r4, r5, r6};
        TYPE_BY_NAME = new HashMap();
        TYPE_BY_PRIMITIVE_TYPE = new EnumMap(PrimitiveType.class);
        TYPE_BY_DESC = new HashMap();
        WRAPPER_CLASS_INTERNAL_NAMES = new HashSet();
        OWNER_TO_BOXING_METHOD_DESCRIPTOR = new HashMap();
        JvmPrimitiveType[] r8 = values();
        int r10 = r8.length;
    L3:
        if (r9 >= r10) goto L5;
        JvmPrimitiveType r11 = r8[r9];
        TYPE_BY_NAME.put(r11.getJavaKeywordName(), r11);
        TYPE_BY_PRIMITIVE_TYPE.put(r11.getPrimitiveType(), r11);
        TYPE_BY_DESC.put(r11.getDesc(), r11);
        String r12 = r11.wrapperFqName.asString().replace('.', '/');
        WRAPPER_CLASS_INTERNAL_NAMES.add(r12);
        OWNER_TO_BOXING_METHOD_DESCRIPTOR.put(r12, "(" + r11.desc + ")L" + r12 + ";");
        r9 = r9 + 1;
        goto L3
    }

    public static JvmPrimitiveType[] values() {
        return (JvmPrimitiveType[]) $VALUES.clone();
    }

    public String getDesc() {
        String r0 = this.desc;
        if (r0 != null) goto L5;
        $$$reportNull$$$0(14);
    L5:
        return r0;
    }

    public String getJavaKeywordName() {
        String r0 = this.name;
        if (r0 != null) goto L5;
        $$$reportNull$$$0(13);
    L5:
        return r0;
    }

    public PrimitiveType getPrimitiveType() {
        PrimitiveType r0 = this.primitiveType;
        if (r0 != null) goto L5;
        $$$reportNull$$$0(12);
    L5:
        return r0;
    }

    public FqName getWrapperFqName() {
        FqName r0 = this.wrapperFqName;
        if (r0 != null) goto L5;
        $$$reportNull$$$0(15);
    L5:
        return r0;
    }

    public static JvmPrimitiveType get(String r3) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        JvmPrimitiveType r0 = TYPE_BY_NAME.get(r3);
        if (r0 == null) goto L8;
        return r0;
    L8:
        throw new AssertionError("Non-primitive type name passed: " + r3);
    }

    public static JvmPrimitiveType valueOf(String r1) {
        return (JvmPrimitiveType) a.a(JvmPrimitiveType.class, r1);
    }

    public static JvmPrimitiveType get(PrimitiveType r1) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(5);
    L4:
        JvmPrimitiveType r2 = TYPE_BY_PRIMITIVE_TYPE.get(r1);
        if (r2 != null) goto L7;
        $$$reportNull$$$0(6);
    L7:
        return r2;
    }

    private JvmPrimitiveType(String r2, int r3, PrimitiveType r4, String r5, String r6, String r7) {
        if (r4 != null) goto L4;
        $$$reportNull$$$0(8);
    L4:
        if (r5 != null) goto L6;
        $$$reportNull$$$0(9);
    L6:
        if (r6 != null) goto L8;
        $$$reportNull$$$0(10);
    L8:
        if (r7 != null) goto L10;
        $$$reportNull$$$0(11);
    L10:
        super(r2, r3);
        this.primitiveType = r4;
        this.name = r5;
        this.desc = r6;
        this.wrapperFqName = new FqName(r7);
    }
}
