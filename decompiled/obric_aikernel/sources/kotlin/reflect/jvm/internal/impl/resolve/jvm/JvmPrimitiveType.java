package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public final enum JvmPrimitiveType extends Enum<JvmPrimitiveType> {
    private static final /* synthetic */ JvmPrimitiveType[] $VALUES = null;
    public static final JvmPrimitiveType BOOLEAN = null;
    public static final JvmPrimitiveType BYTE = null;
    public static final JvmPrimitiveType CHAR = null;
    public static final JvmPrimitiveType DOUBLE = null;
    public static final JvmPrimitiveType FLOAT = null;
    public static final JvmPrimitiveType INT = null;
    public static final JvmPrimitiveType LONG = null;
    public static final JvmPrimitiveType SHORT = null;
    private static final Map<String, JvmPrimitiveType> TYPE_BY_DESC = null;
    private static final Map<String, JvmPrimitiveType> TYPE_BY_NAME = null;
    private static final Map<PrimitiveType, JvmPrimitiveType> TYPE_BY_PRIMITIVE_TYPE = null;
    private static final Set<FqName> WRAPPERS_CLASS_NAMES = null;
    private final String desc;
    private final String name;
    private final PrimitiveType primitiveType;
    private final FqName wrapperFqName;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 2) goto L7;
        if (r10 == 4) goto L7;
        switch(r10) {
            case 10: goto L7;
            case 11: goto L7;
            case 12: goto L7;
            case 13: goto L7;
            default: goto L6;
        };
    L6:
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r10 == 2) goto L12;
        if (r10 == 4) goto L44;
        switch(r10) {
            case 10: goto L45;
            case 11: goto L45;
            case 12: goto L45;
            case 13: goto L45;
            default: goto L11;
        };
    L11:
        int r12 = 3;
    L13:
        Object[] r13 = new Object[r12];
        switch(r10) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L21;
            case 8: goto L18;
            case 9: goto L16;
            case 10: goto L20;
            case 11: goto L20;
            case 12: goto L20;
            case 13: goto L20;
            default: goto L15;
        };
    L15:
        r13[0] = "className";
    L23:
        if (r10 == 2) goto L31;
        if (r10 == 4) goto L31;
        switch(r10) {
            case 10: goto L30;
            case 11: goto L29;
            case 12: goto L28;
            case 13: goto L27;
            default: goto L26;
        };
    L26:
        r13[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
    L32:
        switch(r10) {
            case 1: goto L36;
            case 2: goto L37;
            case 3: goto L36;
            case 4: goto L37;
            case 5: goto L35;
            case 6: goto L34;
            case 7: goto L34;
            case 8: goto L34;
            case 9: goto L34;
            case 10: goto L37;
            case 11: goto L37;
            case 12: goto L37;
            case 13: goto L37;
            default: goto L33;
        };
    L33:
        r13[2] = "isWrapperClassName";
        goto L37
    L34:
        r13[2] = "<init>";
        goto L37
    L35:
        r13[2] = "getByDesc";
        goto L37
    L36:
        r13[2] = "get";
    L37:
        String r14 = String.format(r11, r13);
        if (r10 == 2) goto L43;
        if (r10 == 4) goto L43;
        switch(r10) {
            case 10: goto L43;
            case 11: goto L43;
            case 12: goto L43;
            case 13: goto L43;
            default: goto L46;
        };
    L46:
        throw new IllegalArgumentException(r14);
    L43:
        throw new IllegalStateException(r14);
    L27:
        r13[1] = "getWrapperFqName";
        goto L32
    L28:
        r13[1] = "getDesc";
        goto L32
    L29:
        r13[1] = "getJavaKeywordName";
        goto L32
    L30:
        r13[1] = "getPrimitiveType";
    L31:
        r13[1] = "get";
        goto L32
    L16:
        r13[0] = "wrapperClassName";
        goto L23
    L17:
        r13[0] = "primitiveType";
        goto L23
    L18:
        r13[0] = "desc";
        goto L23
    L19:
        r13[0] = WsConstants.KEY_CONNECTION_TYPE;
        goto L23
    L20:
        r13[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
        goto L23
    L21:
        r13[0] = ActivityLifecycle.NAME;
        goto L23
    L45:
        r12 = 2;
        goto L13
    L44:
        r12 = 2;
        goto L13
    L12:
        r12 = 2;
    L7:
        r11 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    static {
        JvmPrimitiveType r10 = new JvmPrimitiveType("BOOLEAN", 0, PrimitiveType.BOOLEAN, TypedValues.Custom.S_BOOLEAN, "Z", "java.lang.Boolean");
        BOOLEAN = r10;
        JvmPrimitiveType r11 = new JvmPrimitiveType("CHAR", 1, PrimitiveType.CHAR, "char", "C", "java.lang.Character");
        CHAR = r11;
        JvmPrimitiveType r12 = new JvmPrimitiveType("BYTE", 2, PrimitiveType.BYTE, "byte", "B", "java.lang.Byte");
        BYTE = r12;
        JvmPrimitiveType r13 = new JvmPrimitiveType("SHORT", 3, PrimitiveType.SHORT, "short", "S", "java.lang.Short");
        SHORT = r13;
        JvmPrimitiveType r14 = new JvmPrimitiveType("INT", 4, PrimitiveType.INT, "int", "I", "java.lang.Integer");
        INT = r14;
        JvmPrimitiveType r15 = new JvmPrimitiveType("FLOAT", 5, PrimitiveType.FLOAT, TypedValues.Custom.S_FLOAT, "F", "java.lang.Float");
        FLOAT = r15;
        JvmPrimitiveType r16 = new JvmPrimitiveType("LONG", 6, PrimitiveType.LONG, "long", "J", "java.lang.Long");
        LONG = r16;
        JvmPrimitiveType r17 = new JvmPrimitiveType("DOUBLE", 7, PrimitiveType.DOUBLE, "double", "D", "java.lang.Double");
        DOUBLE = r17;
        int r18 = 0;
        $VALUES = new JvmPrimitiveType[]{r10, r11, r12, r13, r14, r15, r16, r17};
        WRAPPERS_CLASS_NAMES = new HashSet();
        TYPE_BY_NAME = new HashMap();
        TYPE_BY_PRIMITIVE_TYPE = new EnumMap(PrimitiveType.class);
        TYPE_BY_DESC = new HashMap();
        JvmPrimitiveType[] r19 = values();
        int r20 = r19.length;
    L3:
        if (r18 >= r20) goto L5;
        JvmPrimitiveType r21 = r19[r18];
        WRAPPERS_CLASS_NAMES.add(r21.getWrapperFqName());
        TYPE_BY_NAME.put(r21.getJavaKeywordName(), r21);
        TYPE_BY_PRIMITIVE_TYPE.put(r21.getPrimitiveType(), r21);
        TYPE_BY_DESC.put(r21.getDesc(), r21);
        r18 = r18 + 1;
        goto L3
    }

    private JvmPrimitiveType(String r10, int r11, PrimitiveType r12, String r13, String r14, String r15) {
        if (r12 != null) goto L4;
        $$$reportNull$$$0(6);
    L4:
        if (r13 != null) goto L6;
        $$$reportNull$$$0(7);
    L6:
        if (r14 != null) goto L8;
        $$$reportNull$$$0(8);
    L8:
        if (r15 != null) goto L10;
        $$$reportNull$$$0(9);
    L10:
        super(r10, r11);
        this.primitiveType = r12;
        this.name = r13;
        this.desc = r14;
        this.wrapperFqName = new FqName(r15);
    }

    public static JvmPrimitiveType get(String r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(1);
    L4:
        JvmPrimitiveType r11 = TYPE_BY_NAME.get(r10);
        if (r11 == null) goto L8;
        return r11;
    L8:
        throw new AssertionError("Non-primitive type name passed: " + r10);
    }

    public static JvmPrimitiveType get(PrimitiveType r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        JvmPrimitiveType r11 = TYPE_BY_PRIMITIVE_TYPE.get(r10);
        if (r11 != null) goto L7;
        $$$reportNull$$$0(4);
    L7:
        return r11;
    }

    public static JvmPrimitiveType valueOf(String r10) {
        return (JvmPrimitiveType) Enum.valueOf(JvmPrimitiveType.class, r10);
    }

    public static JvmPrimitiveType[] values() {
        return (JvmPrimitiveType[]) $VALUES.clone();
    }

    public String getDesc() {
        String r10 = this.desc;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(12);
    L5:
        return r10;
    }

    public String getJavaKeywordName() {
        String r10 = this.name;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(11);
    L5:
        return r10;
    }

    public PrimitiveType getPrimitiveType() {
        PrimitiveType r10 = this.primitiveType;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(10);
    L5:
        return r10;
    }

    public FqName getWrapperFqName() {
        FqName r10 = this.wrapperFqName;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(13);
    L5:
        return r10;
    }
}
