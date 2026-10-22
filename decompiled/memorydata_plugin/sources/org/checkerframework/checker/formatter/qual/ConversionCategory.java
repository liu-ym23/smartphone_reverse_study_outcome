package org.checkerframework.checker.formatter.qual;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: classes7.dex */
public final enum ConversionCategory extends Enum<ConversionCategory> {
    private static final /* synthetic */ ConversionCategory[] $VALUES = null;
    public static final ConversionCategory CHAR = null;
    public static final ConversionCategory CHAR_AND_INT = null;
    public static final ConversionCategory FLOAT = null;
    public static final ConversionCategory GENERAL = null;
    public static final ConversionCategory INT = null;
    public static final ConversionCategory INT_AND_TIME = null;
    public static final ConversionCategory NULL = null;
    public static final ConversionCategory TIME = null;
    public static final ConversionCategory UNUSED = null;
    private static final ConversionCategory[] conversionCategoriesForIntersect = null;
    private static final ConversionCategory[] conversionCategoriesForUnion = null;
    private static final ConversionCategory[] conversionCategoriesWithChar = null;
    public final String chars;
    public final Class<?>[] types;

    private static /* synthetic */ ConversionCategory[] $values() {
        return new ConversionCategory[]{GENERAL, CHAR, INT, FLOAT, TIME, CHAR_AND_INT, INT_AND_TIME, NULL, UNUSED};
    }

    static {
        ConversionCategory r0 = new ConversionCategory("GENERAL", 0, "bBhHsS", (Class[]) ZeusTransformUtils.preCheckCast(null, Class[].class, "com.obric.memorydata.plugin"));
        GENERAL = r0;
        ConversionCategory r1 = new ConversionCategory("CHAR", 1, "cC", new Class[]{Character.class, Byte.class, Short.class, Integer.class});
        CHAR = r1;
        ConversionCategory r6 = new ConversionCategory("INT", 2, "doxX", new Class[]{Byte.class, Short.class, Integer.class, Long.class, BigInteger.class});
        INT = r6;
        ConversionCategory r11 = new ConversionCategory("FLOAT", 3, "eEfgGaA", new Class[]{Float.class, Double.class, BigDecimal.class});
        FLOAT = r11;
        ConversionCategory r12 = new ConversionCategory("TIME", 4, "tT", new Class[]{Long.class, Calendar.class, Date.class});
        TIME = r12;
        ConversionCategory r13 = new ConversionCategory("CHAR_AND_INT", 5, null, new Class[]{Byte.class, Short.class, Integer.class});
        CHAR_AND_INT = r13;
        ConversionCategory r14 = new ConversionCategory("INT_AND_TIME", 6, null, new Class[]{Long.class});
        INT_AND_TIME = r14;
        ConversionCategory r4 = new ConversionCategory("NULL", 7, null, new Class[0]);
        NULL = r4;
        UNUSED = new ConversionCategory("UNUSED", 8, null, (Class[]) ZeusTransformUtils.preCheckCast(null, Class[].class, "com.obric.memorydata.plugin"));
        $VALUES = $values();
        conversionCategoriesWithChar = new ConversionCategory[]{r0, r1, r6, r11, r12};
        conversionCategoriesForIntersect = new ConversionCategory[]{r1, r6, r11, r12, r13, r14, r4};
        conversionCategoriesForUnion = new ConversionCategory[]{r4, r13, r14, r1, r6, r11, r12};
    }

    private ConversionCategory(String r2, int r3, String r4, Class... r5) {
        super(r2, r3);
        this.chars = r4;
        if (r5 != null) goto L5;
        this.types = r5;
        return;
    L5:
        ArrayList r6 = new ArrayList(r5.length);
        int r7 = r5.length;
        int r8 = 0;
    L6:
        if (r8 >= r7) goto L11;
        Class r0 = r5[r8];
        r6.add(r0);
        Class<? extends Object> r1 = unwrapPrimitive(r0);
        if (r1 == null) goto L10;
        r6.add(r1);
    L10:
        r8 = r8 + 1;
        goto L6
    L11:
        this.types = (Class[]) ZeusTransformUtils.preCheckCast(r6.toArray(new Class[r6.size()]), Class[].class, "com.obric.memorydata.plugin");
    }

    private static <E> Set<E> arrayToSet(E[] r1) {
        return new HashSet(Arrays.asList(r1));
    }

    public static ConversionCategory fromConversionChar(char r6) {
        ConversionCategory[] r0 = conversionCategoriesWithChar;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        ConversionCategory r3 = r0[r2];
        if (r3.chars.contains(String.valueOf(r6)) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new IllegalArgumentException("Bad conversion character " + r6);
    }

    public static ConversionCategory intersect(ConversionCategory r4, ConversionCategory r5) {
        ConversionCategory r0 = UNUSED;
        if (r4 != r0) goto L5;
        return r5;
    L5:
        if (r5 != r0) goto L7;
        return r4;
    L7:
        ConversionCategory r1 = GENERAL;
        if (r4 != r1) goto L10;
        return r5;
    L10:
        if (r5 != r1) goto L12;
        return r4;
    L12:
        Set r6 = arrayToSet(r4.types);
        r6.retainAll(arrayToSet(r5.types));
        ConversionCategory[] r7 = conversionCategoriesForIntersect;
        int r2 = r7.length;
        int r3 = 0;
    L13:
        if (r3 >= r2) goto L19;
        ConversionCategory r8 = r7[r3];
        if (arrayToSet(r8.types).equals(r6) == true) goto L16;
        r3 = r3 + 1;
        goto L13
    L16:
        return r8;
    L19:
        throw new RuntimeException();
    }

    public static boolean isSubsetOf(ConversionCategory r0, ConversionCategory r1) {
        if (intersect(r0, r1) != r0) goto L5;
        return true;
    L5:
        return false;
    }

    public static ConversionCategory union(ConversionCategory r4, ConversionCategory r5) {
        ConversionCategory r0 = UNUSED;
        if (r4 == r0) goto L27;
        if (r5 == r0) goto L27;
        r0 = GENERAL;
        if (r4 == r0) goto L27;
        if (r5 == r0) goto L27;
        ConversionCategory r1 = CHAR_AND_INT;
        if (r4 != r1) goto L15;
        if (r5 != INT_AND_TIME) goto L15;
    L18:
        return INT;
    L15:
        if (r4 != INT_AND_TIME) goto L19;
        if (r5 == r1) goto L18;
    L19:
        Set r6 = arrayToSet(r4.types);
        r6.addAll(arrayToSet(r5.types));
        ConversionCategory[] r7 = conversionCategoriesForUnion;
        int r2 = r7.length;
        int r3 = 0;
    L20:
        if (r3 >= r2) goto L26;
        ConversionCategory r8 = r7[r3];
        if (arrayToSet(r8.types).equals(r6) == true) goto L23;
        r3 = r3 + 1;
        goto L20
    L23:
        return r8;
    L26:
        return GENERAL;
    L27:
        return r0;
    }

    private static Class<? extends Object> unwrapPrimitive(Class<?> r1) {
        if (r1 != Byte.class) goto L7;
        return Byte.TYPE;
    L7:
        if (r1 != Character.class) goto L11;
        return Character.TYPE;
    L11:
        if (r1 != Short.class) goto L15;
        return Short.TYPE;
    L15:
        if (r1 != Integer.class) goto L19;
        return Integer.TYPE;
    L19:
        if (r1 != Long.class) goto L23;
        return Long.TYPE;
    L23:
        if (r1 != Float.class) goto L27;
        return Float.TYPE;
    L27:
        if (r1 != Double.class) goto L31;
        return Double.TYPE;
    L31:
        if (r1 == Boolean.class) goto L33;
        return null;
    L33:
        return Boolean.TYPE;
    }

    public static ConversionCategory valueOf(String r2) {
        return (ConversionCategory) ZeusTransformUtils.preCheckCast(Enum.valueOf(ConversionCategory.class, r2), ConversionCategory.class, "com.obric.memorydata.plugin");
    }

    public static ConversionCategory[] values() {
        return (ConversionCategory[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ConversionCategory[].class, "com.obric.memorydata.plugin");
    }

    public boolean isAssignableFrom(Class<?> r6) {
        if (this.types != null) goto L6;
        return true;
    L6:
        if (r6 != Void.TYPE) goto L8;
        return true;
    L8:
        Class<?>[] r5 = this.types;
        int r0 = r5.length;
        int r3 = 0;
    L9:
        if (r3 >= r0) goto L14;
        if (r5[r3].isAssignableFrom(r6) == true) goto L12;
        r3 = r3 + 1;
        goto L9
    L12:
        return true;
    L14:
        return false;
    }

    @Override // java.lang.Enum
    @Pure
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(name());
        r0.append(" conversion category");
        Class<?>[] r1 = this.types;
        if (r1 == null) goto L13;
        if (r1.length == 0) goto L13;
        StringJoiner r2 = new StringJoiner(", ", "(one of: ", ")");
        Class<?>[] r5 = this.types;
        int r3 = r5.length;
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L10;
        r2.add(r5[r4].getSimpleName());
        r4 = r4 + 1;
        goto L8
    L10:
        r0.append(" ");
        r0.append(r2);
        return r0.toString();
    L13:
        return r0.toString();
    }
}
