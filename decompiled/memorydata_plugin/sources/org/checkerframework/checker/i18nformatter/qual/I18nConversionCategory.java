package org.checkerframework.checker.i18nformatter.qual;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes7.dex */
public final enum I18nConversionCategory extends Enum<I18nConversionCategory> {
    private static final /* synthetic */ I18nConversionCategory[] $VALUES = null;
    public static final I18nConversionCategory DATE = null;
    public static final I18nConversionCategory GENERAL = null;
    public static final I18nConversionCategory NUMBER = null;
    public static final I18nConversionCategory UNUSED = null;
    private static final I18nConversionCategory[] conversionCategoriesForIntersect = null;
    private static final I18nConversionCategory[] namedCategories = null;
    public final String[] strings;
    public final Class<?>[] types;

    private static /* synthetic */ I18nConversionCategory[] $values() {
        return new I18nConversionCategory[]{UNUSED, GENERAL, DATE, NUMBER};
    }

    static {
        UNUSED = new I18nConversionCategory("UNUSED", 0, null, null);
        GENERAL = new I18nConversionCategory("GENERAL", 1, null, null);
        I18nConversionCategory r0 = new I18nConversionCategory("DATE", 2, new Class[]{Date.class, Number.class}, new String[]{"date", OaidModel.KEY_TIME});
        DATE = r0;
        I18nConversionCategory r3 = new I18nConversionCategory("NUMBER", 3, new Class[]{Number.class}, new String[]{"number", "choice"});
        NUMBER = r3;
        $VALUES = $values();
        namedCategories = new I18nConversionCategory[]{r0, r3};
        conversionCategoriesForIntersect = new I18nConversionCategory[]{r0, r3};
    }

    private I18nConversionCategory(String r1, int r2, Class[] r3, String[] r4) {
        super(r1, r2);
        this.types = r3;
        this.strings = r4;
    }

    private static <E> Set<E> arrayToSet(E[] r1) {
        return new HashSet(Arrays.asList(r1));
    }

    public static I18nConversionCategory intersect(I18nConversionCategory r4, I18nConversionCategory r5) {
        I18nConversionCategory r0 = UNUSED;
        if (r4 != r0) goto L5;
        return r5;
    L5:
        if (r5 != r0) goto L7;
        return r4;
    L7:
        I18nConversionCategory r1 = GENERAL;
        if (r4 != r1) goto L10;
        return r5;
    L10:
        if (r5 != r1) goto L12;
        return r4;
    L12:
        Set r6 = arrayToSet(r4.types);
        r6.retainAll(arrayToSet(r5.types));
        I18nConversionCategory[] r7 = conversionCategoriesForIntersect;
        int r2 = r7.length;
        int r3 = 0;
    L13:
        if (r3 >= r2) goto L19;
        I18nConversionCategory r8 = r7[r3];
        if (arrayToSet(r8.types).equals(r6) == true) goto L16;
        r3 = r3 + 1;
        goto L13
    L16:
        return r8;
    L19:
        throw new RuntimeException();
    }

    public static boolean isSubsetOf(I18nConversionCategory r0, I18nConversionCategory r1) {
        if (intersect(r0, r1) != r0) goto L5;
        return true;
    L5:
        return false;
    }

    public static I18nConversionCategory stringToI18nConversionCategory(String r9) {
        String r10 = r9.toLowerCase();
        I18nConversionCategory[] r0 = namedCategories;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L12;
        I18nConversionCategory r4 = r0[r3];
        String[] r5 = r4.strings;
        int r6 = r5.length;
        int r7 = 0;
    L5:
        if (r7 >= r6) goto L10;
        if (r5[r7].equals(r10) == true) goto L8;
        r7 = r7 + 1;
        goto L5
    L8:
        return r4;
    L10:
        r3 = r3 + 1;
        goto L3
    L12:
        throw new IllegalArgumentException("Invalid format type " + r10);
    }

    public static I18nConversionCategory union(I18nConversionCategory r1, I18nConversionCategory r2) {
        I18nConversionCategory r0 = UNUSED;
        if (r1 == r0) goto L16;
        if (r2 == r0) goto L16;
        r0 = GENERAL;
        if (r1 == r0) goto L16;
        if (r2 == r0) goto L16;
        r0 = DATE;
        if (r1 == r0) goto L16;
        if (r2 == r0) goto L16;
        return NUMBER;
    L16:
        return r0;
    }

    public static I18nConversionCategory valueOf(String r2) {
        return (I18nConversionCategory) ZeusTransformUtils.preCheckCast(Enum.valueOf(I18nConversionCategory.class, r2), I18nConversionCategory.class, "com.obric.memorydata.plugin");
    }

    public static I18nConversionCategory[] values() {
        return (I18nConversionCategory[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), I18nConversionCategory[].class, "com.obric.memorydata.plugin");
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
    public String toString() {
        StringBuilder r0 = new StringBuilder(name());
        if (this.types != null) goto L5;
        r0.append(" conversion category (all types)");
    L10:
        return r0.toString();
    L5:
        StringJoiner r1 = new StringJoiner(", ", " conversion category (one of: ", ")");
        Class<?>[] r5 = this.types;
        int r2 = r5.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        r1.add(r5[r3].getCanonicalName());
        r3 = r3 + 1;
        goto L6
    L8:
        r0.append(r1);
        goto L10
    }
}
