package org.ehcache.sizeof;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.net.Proxy;
import java.nio.charset.CodingErrorAction;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: classes7.dex */
abstract enum FlyweightType extends Enum<FlyweightType> {
    private static final /* synthetic */ FlyweightType[] $VALUES = null;
    public static final FlyweightType BIGDECIMAL = null;
    public static final FlyweightType BIGINTEGER = null;
    public static final FlyweightType BOOLEAN = null;
    public static final FlyweightType BYTE = null;
    public static final FlyweightType CHARACTER = null;
    public static final FlyweightType CLASS = null;
    public static final FlyweightType CODINGERRORACTION = null;
    public static final FlyweightType DATATYPECONSTANTS_FIELD = null;
    public static final FlyweightType ENUM = null;
    private static final Set<Locale> GLOBAL_LOCALES = null;
    public static final FlyweightType INTEGER = null;
    public static final FlyweightType LOCALE = null;
    public static final FlyweightType LOGGER = null;
    public static final FlyweightType LONG = null;
    public static final FlyweightType MATHCONTEXT = null;
    public static final FlyweightType MISC = null;
    public static final FlyweightType PROXY = null;
    public static final FlyweightType QNAME = null;
    public static final FlyweightType SHORT = null;
    private static final Map<Class<?>, FlyweightType> TYPE_MAPPINGS = null;
    private final Class<?> clazz;

    static {
        final Class<Enum> r1 = Enum.class;
        final String r2 = "ENUM";
        final int r3 = 0;
        FlyweightType r0 = new AnonymousClass1(r2, r3, r1);
        ENUM = r0;
        final Class<Class> r4 = Class.class;
        final String r5 = "CLASS";
        final int r6 = 1;
        FlyweightType r7 = new AnonymousClass2(r5, r6, r4);
        CLASS = r7;
        final Class<Boolean> r8 = Boolean.class;
        final String r9 = "BOOLEAN";
        final int r10 = 2;
        FlyweightType r11 = new AnonymousClass3(r9, r10, r8);
        BOOLEAN = r11;
        final Class<Integer> r12 = Integer.class;
        final String r13 = "INTEGER";
        final int r14 = 3;
        FlyweightType r15 = new AnonymousClass4(r13, r14, r12);
        INTEGER = r15;
        final Class<Short> r16 = Short.class;
        final String r17 = "SHORT";
        final int r18 = 4;
        FlyweightType r19 = new AnonymousClass5(r17, r18, r16);
        SHORT = r19;
        final Class<Byte> r110 = Byte.class;
        final String r111 = "BYTE";
        final int r112 = 5;
        FlyweightType r20 = new AnonymousClass6(r111, r112, r110);
        BYTE = r20;
        final Class<Long> r113 = Long.class;
        final String r114 = "LONG";
        final int r115 = 6;
        FlyweightType r116 = new AnonymousClass7(r114, r115, r113);
        LONG = r116;
        final Class<BigInteger> r117 = BigInteger.class;
        final String r118 = "BIGINTEGER";
        final int r119 = 7;
        FlyweightType r120 = new AnonymousClass8(r118, r119, r117);
        BIGINTEGER = r120;
        final Class<BigDecimal> r121 = BigDecimal.class;
        final String r122 = "BIGDECIMAL";
        final int r123 = 8;
        FlyweightType r124 = new AnonymousClass9(r122, r123, r121);
        BIGDECIMAL = r124;
        final Class<MathContext> r125 = MathContext.class;
        final String r126 = "MATHCONTEXT";
        final int r21 = 9;
        FlyweightType r127 = new AnonymousClass10(r126, r21, r125);
        MATHCONTEXT = r127;
        final Class<Character> r128 = Character.class;
        final String r22 = "CHARACTER";
        final int r23 = 10;
        FlyweightType r129 = new AnonymousClass11(r22, r23, r128);
        CHARACTER = r129;
        final Class<Locale> r130 = Locale.class;
        final String r24 = "LOCALE";
        final int r25 = 11;
        FlyweightType r26 = new AnonymousClass12(r24, r25, r130);
        LOCALE = r26;
        final Class<Logger> r131 = Logger.class;
        final String r27 = "LOGGER";
        final int r28 = 12;
        FlyweightType r29 = new AnonymousClass13(r27, r28, r131);
        LOGGER = r29;
        final Class<Proxy> r132 = Proxy.class;
        final String r30 = "PROXY";
        final int r31 = 13;
        FlyweightType r32 = new AnonymousClass14(r30, r31, r132);
        PROXY = r32;
        final Class<CodingErrorAction> r133 = CodingErrorAction.class;
        final String r33 = "CODINGERRORACTION";
        final int r34 = 14;
        FlyweightType r35 = new AnonymousClass15(r33, r34, r133);
        CODINGERRORACTION = r35;
        final Class<DatatypeConstants.Field> r134 = DatatypeConstants.Field.class;
        final String r36 = "DATATYPECONSTANTS_FIELD";
        final int r37 = 15;
        FlyweightType r38 = new AnonymousClass16(r36, r37, r134);
        DATATYPECONSTANTS_FIELD = r38;
        final Class<QName> r135 = QName.class;
        final String r39 = "QNAME";
        final int r40 = 16;
        FlyweightType r41 = new AnonymousClass17(r39, r40, r135);
        QNAME = r41;
        final Class<Void> r136 = Void.class;
        final String r42 = "MISC";
        final int r43 = 17;
        FlyweightType r44 = new AnonymousClass18(r42, r43, r136);
        MISC = r44;
        $VALUES = new FlyweightType[]{r0, r7, r11, r15, r19, r20, r116, r120, r124, r127, r129, r26, r29, r32, r35, r38, r41, r44};
        TYPE_MAPPINGS = new HashMap();
        FlyweightType[] r45 = values();
        int r46 = r45.length;
        int r47 = 0;
    L3:
        if (r47 >= r46) goto L5;
        FlyweightType r48 = r45[r47];
        TYPE_MAPPINGS.put(r48.clazz, r48);
        r47 = r47 + 1;
        goto L3
    L5:
        IdentityHashMap r49 = new IdentityHashMap();
        Field[] r50 = Locale.class.getFields();
        int r51 = r50.length;
        int r52 = 0;
    L6:
        if (r52 >= r51) goto L16;
        Field r53 = r50[r52];
        int r54 = r53.getModifiers();
        if (Modifier.isPublic(r54) == false) goto L15;
        if (Modifier.isStatic(r54) == false) goto L15;
        if (Locale.class.equals(r53.getType()) == false) goto L15;
        r49.put((Locale) ZeusTransformUtils.preCheckCast(r53.get(null), Locale.class, "com.obric.memorydata.plugin"), null);     // Catch: Throwable -> L18
    L15:
        r52 = r52 + 1;
        goto L6
    L16:
        GLOBAL_LOCALES = r49.keySet();
    }

    private FlyweightType(String r1, int r2, Class r3) {
        super(r1, r2);
        this.clazz = r3;
    }

    /* synthetic */ FlyweightType(String r1, int r2, Class r3, AnonymousClass1 r4) {
        this(r1, r2, r3);
    }

    static /* synthetic */ Set access$100() {
        return GLOBAL_LOCALES;
    }

    static FlyweightType getFlyweightType(Class<?> r2) {
        if (r2.isEnum() == true) goto L15;
        if (r2.getSuperclass() != null) goto L7;
    L9:
        FlyweightType r3 = (FlyweightType) ZeusTransformUtils.preCheckCast(TYPE_MAPPINGS.get(r2), FlyweightType.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L13;
        return r3;
    L13:
        return MISC;
    L7:
        if (r2.getSuperclass().isEnum() == false) goto L9;
    L15:
        return ENUM;
    }

    public static FlyweightType valueOf(String r2) {
        return (FlyweightType) ZeusTransformUtils.preCheckCast(Enum.valueOf(FlyweightType.class, r2), FlyweightType.class, "com.obric.memorydata.plugin");
    }

    public static FlyweightType[] values() {
        return (FlyweightType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FlyweightType[].class, "com.obric.memorydata.plugin");
    }

    abstract boolean isShared(Object r1);
}
