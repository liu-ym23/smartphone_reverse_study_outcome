package org.checkerframework.checker.formatter.qual;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.StringJoiner;
import kotlin.collections.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum ConversionCategory extends Enum<ConversionCategory> {
    public static final ConversionCategory CHAR = null;
    public static final ConversionCategory CHAR_AND_INT = null;
    public static final ConversionCategory FLOAT = null;
    public static final ConversionCategory GENERAL = null;
    public static final ConversionCategory INT = null;
    public static final ConversionCategory INT_AND_TIME = null;
    public static final ConversionCategory NULL = null;
    public static final ConversionCategory TIME = null;
    public static final ConversionCategory UNUSED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConversionCategory[] f20982a = null;
    public final String chars;
    public final Class<?>[] types;

    static {
        ConversionCategory r5 = new ConversionCategory("GENERAL", 0, "bBhHsS", null);
        GENERAL = r5;
        ConversionCategory r10 = new ConversionCategory("CHAR", 1, "cC", new Class[]{Character.class, Byte.class, Short.class, Integer.class});
        CHAR = r10;
        ConversionCategory r11 = new ConversionCategory("INT", 2, "doxX", new Class[]{Byte.class, Short.class, Integer.class, Long.class, BigInteger.class});
        INT = r11;
        ConversionCategory r12 = new ConversionCategory("FLOAT", 3, "eEfgGaA", new Class[]{Float.class, Double.class, BigDecimal.class});
        FLOAT = r12;
        ConversionCategory r13 = new ConversionCategory("TIME", 4, "tT", new Class[]{Long.class, Calendar.class, Date.class});
        TIME = r13;
        ConversionCategory r14 = new ConversionCategory("CHAR_AND_INT", 5, null, new Class[]{Byte.class, Short.class, Integer.class});
        CHAR_AND_INT = r14;
        ConversionCategory r15 = new ConversionCategory("INT_AND_TIME", 6, null, new Class[]{Long.class});
        INT_AND_TIME = r15;
        ConversionCategory r16 = new ConversionCategory("NULL", 7, null, new Class[0]);
        NULL = r16;
        ConversionCategory r17 = new ConversionCategory("UNUSED", 8, null, null);
        UNUSED = r17;
        f20982a = new ConversionCategory[]{r5, r10, r11, r12, r13, r14, r15, r16, r17};
    }

    public ConversionCategory(String r5, int r10, String r11, Class... r12) {
        super(r5, r10);
        this.chars = r11;
        if (r12 != null) goto L5;
        this.types = r12;
        return;
    L5:
        ArrayList r13 = new ArrayList(r12.length);
        int r14 = r12.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L35;
        Class r16 = r12[r15];
        r13.add(r16);
        if (r16 != Byte.class) goto L11;
        Class r17 = Byte.TYPE;
    L32:
        if (r17 == null) goto L34;
        r13.add(r17);
    L34:
        r15 = r15 + 1;
        goto L6
    L11:
        if (r16 != Character.class) goto L14;
        r17 = Character.TYPE;
        goto L32
    L14:
        if (r16 != Short.class) goto L17;
        r17 = Short.TYPE;
        goto L32
    L17:
        if (r16 != Integer.class) goto L20;
        r17 = Integer.TYPE;
        goto L32
    L20:
        if (r16 != Long.class) goto L23;
        r17 = Long.TYPE;
        goto L32
    L23:
        if (r16 != Float.class) goto L26;
        r17 = Float.TYPE;
        goto L32
    L26:
        if (r16 != Double.class) goto L29;
        r17 = Double.TYPE;
        goto L32
    L29:
        if (r16 != Boolean.class) goto L31;
        r17 = Boolean.TYPE;
        goto L32
    L31:
        r17 = null;
        goto L32
    L35:
        this.types = (Class[]) r13.toArray(new Class[r13.size()]);
    }

    public static HashSet a(Object[] r5) {
        return new HashSet(Arrays.asList(r5));
    }

    public static ConversionCategory fromConversionChar(char r5) {
        ConversionCategory[] r10 = {GENERAL, CHAR, INT, FLOAT, TIME};
        int r11 = 0;
    L4:
        if (r11 >= 5) goto L10;
        ConversionCategory r12 = r10[r11];
        if (r12.chars.contains(String.valueOf(r5)) == true) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return r12;
    L10:
        throw new IllegalArgumentException(a.g("Bad conversion character ", r5));
    }

    public static ConversionCategory intersect(ConversionCategory r10, ConversionCategory r11) {
        ConversionCategory r5 = UNUSED;
        if (r10 != r5) goto L5;
        return r11;
    L5:
        if (r11 != r5) goto L7;
        return r10;
    L7:
        ConversionCategory r12 = GENERAL;
        if (r10 != r12) goto L10;
        return r11;
    L10:
        if (r11 != r12) goto L12;
        return r10;
    L12:
        HashSet r13 = a(r10.types);
        r13.retainAll(a(r11.types));
        ConversionCategory[] r14 = {CHAR, INT, FLOAT, TIME, CHAR_AND_INT, INT_AND_TIME, NULL};
        int r15 = 0;
    L14:
        if (r15 >= 7) goto L20;
        ConversionCategory r16 = r14[r15];
        if (a(r16.types).equals(r13) == true) goto L17;
        r15 = r15 + 1;
        goto L14
    L17:
        return r16;
    L20:
        throw new RuntimeException();
    }

    public static boolean isSubsetOf(ConversionCategory r5, ConversionCategory r10) {
        if (intersect(r5, r10) != r5) goto L5;
        return true;
    L5:
        return false;
    }

    public static ConversionCategory union(ConversionCategory r10, ConversionCategory r11) {
        ConversionCategory r5 = UNUSED;
        if (r10 == r5) goto L28;
        if (r11 == r5) goto L28;
        r5 = GENERAL;
        if (r10 == r5) goto L28;
        if (r11 == r5) goto L28;
        ConversionCategory r12 = CHAR_AND_INT;
        if (r10 == r12) goto L13;
    L14:
        ConversionCategory r13 = INT_AND_TIME;
        if (r10 != r13) goto L19;
        if (r11 != r12) goto L19;
    L18:
        return INT;
    L19:
        HashSet r14 = a(r10.types);
        r14.addAll(a(r11.types));
        ConversionCategory[] r15 = {NULL, r12, r13, CHAR, INT, FLOAT, TIME};
        int r16 = 0;
    L21:
        if (r16 >= 7) goto L27;
        ConversionCategory r17 = r15[r16];
        if (a(r17.types).equals(r14) == true) goto L24;
        r16 = r16 + 1;
        goto L21
    L24:
        return r17;
    L27:
        return GENERAL;
    L13:
        if (r11 == INT_AND_TIME) goto L18;
    L28:
        return r5;
    }

    public static ConversionCategory valueOf(String r5) {
        return (ConversionCategory) Enum.valueOf(ConversionCategory.class, r5);
    }

    public static ConversionCategory[] values() {
        return (ConversionCategory[]) f20982a.clone();
    }

    public boolean isAssignableFrom(Class<?> r10) {
        Class<?>[] r5 = this.types;
        if (r5 != null) goto L6;
        return true;
    L6:
        if (r10 != Void.TYPE) goto L8;
        return true;
    L8:
        int r11 = r5.length;
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L14;
        if (r5[r12].isAssignableFrom(r10) == true) goto L12;
        r12 = r12 + 1;
        goto L9
    L12:
        return true;
    L14:
        return false;
    }

    @Override // java.lang.Enum
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(name());
        r5.append(" conversion category");
        Class<?>[] r10 = this.types;
        if (r10 == null) goto L13;
        if (r10.length == 0) goto L13;
        StringJoiner r11 = new StringJoiner(", ", "(one of: ", ")");
        Class<?>[] r12 = this.types;
        int r13 = r12.length;
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L10;
        r11.add(r12[r14].getSimpleName());
        r14 = r14 + 1;
        goto L8
    L10:
        r5.append(" ");
        r5.append(r11);
        return r5.toString();
    L13:
        return r5.toString();
    }
}
