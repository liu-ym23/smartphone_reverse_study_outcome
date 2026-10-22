package org.checkerframework.checker.i18nformatter.qual;

import ai.j0;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes3.dex */
public final enum I18nConversionCategory extends Enum<I18nConversionCategory> {
    public static final I18nConversionCategory DATE = null;
    public static final I18nConversionCategory GENERAL = null;
    public static final I18nConversionCategory NUMBER = null;
    public static final I18nConversionCategory UNUSED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ I18nConversionCategory[] f20983a = null;
    static I18nConversionCategory[] namedCategories;
    public final String[] strings;
    public final Class<?>[] types;

    static {
        I18nConversionCategory r5 = new I18nConversionCategory("UNUSED", 0, null, null);
        UNUSED = r5;
        I18nConversionCategory r10 = new I18nConversionCategory("GENERAL", 1, null, null);
        GENERAL = r10;
        I18nConversionCategory r11 = new I18nConversionCategory("DATE", 2, new Class[]{Date.class, Number.class}, new String[]{"date", "time"});
        DATE = r11;
        I18nConversionCategory r12 = new I18nConversionCategory("NUMBER", 3, new Class[]{Number.class}, new String[]{"number", "choice"});
        NUMBER = r12;
        f20983a = new I18nConversionCategory[]{r5, r10, r11, r12};
        namedCategories = new I18nConversionCategory[]{r11, r12};
    }

    public I18nConversionCategory(String r5, int r10, Class[] r11, String[] r12) {
        super(r5, r10);
        this.types = r11;
        this.strings = r12;
    }

    public static I18nConversionCategory intersect(I18nConversionCategory r5, I18nConversionCategory r10) {
        I18nConversionCategory r11 = UNUSED;
        if (r5 != r11) goto L5;
        return r10;
    L5:
        if (r10 != r11) goto L7;
        return r5;
    L7:
        I18nConversionCategory r12 = GENERAL;
        if (r5 != r12) goto L10;
        return r10;
    L10:
        if (r10 != r12) goto L12;
        return r5;
    L12:
        HashSet r13 = new HashSet(Arrays.asList(r5.types));
        r13.retainAll(new HashSet(Arrays.asList(r10.types)));
        I18nConversionCategory[] r14 = {DATE, NUMBER};
        int r15 = 0;
    L14:
        if (r15 >= 2) goto L20;
        I18nConversionCategory r16 = r14[r15];
        if (new HashSet(Arrays.asList(r16.types)).equals(r13) == true) goto L17;
        r15 = r15 + 1;
        goto L14
    L17:
        return r16;
    L20:
        throw new RuntimeException();
    }

    public static boolean isSubsetOf(I18nConversionCategory r5, I18nConversionCategory r10) {
        if (intersect(r5, r10) != r5) goto L5;
        return true;
    L5:
        return false;
    }

    public static I18nConversionCategory stringToI18nConversionCategory(String r10) {
        String r11 = r10.toLowerCase();
        I18nConversionCategory[] r5 = namedCategories;
        int r12 = r5.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L12;
        I18nConversionCategory r14 = r5[r13];
        String[] r15 = r14.strings;
        int r16 = r15.length;
        int r17 = 0;
    L5:
        if (r17 >= r16) goto L10;
        if (r15[r17].equals(r11) == true) goto L8;
        r17 = r17 + 1;
        goto L5
    L8:
        return r14;
    L10:
        r13 = r13 + 1;
        goto L3
    L12:
        throw new IllegalArgumentException(j0.C("Invalid format type ", r11));
    }

    public static I18nConversionCategory union(I18nConversionCategory r5, I18nConversionCategory r10) {
        I18nConversionCategory r11 = UNUSED;
        if (r5 == r11) goto L16;
        if (r10 == r11) goto L16;
        r11 = GENERAL;
        if (r5 == r11) goto L16;
        if (r10 == r11) goto L16;
        r11 = DATE;
        if (r5 == r11) goto L16;
        if (r10 == r11) goto L16;
        return NUMBER;
    L16:
        return r11;
    }

    public static I18nConversionCategory valueOf(String r5) {
        return (I18nConversionCategory) Enum.valueOf(I18nConversionCategory.class, r5);
    }

    public static I18nConversionCategory[] values() {
        return (I18nConversionCategory[]) f20983a.clone();
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
        StringBuilder r5 = new StringBuilder(name());
        if (this.types != null) goto L5;
        r5.append(" conversion category (all types)");
    L10:
        return r5.toString();
    L5:
        StringJoiner r10 = new StringJoiner(", ", " conversion category (one of: ", ")");
        Class<?>[] r11 = this.types;
        int r12 = r11.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L8;
        r10.add(r11[r13].getCanonicalName());
        r13 = r13 + 1;
        goto L6
    L8:
        r5.append(r10);
        goto L10
    }
}
