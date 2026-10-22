package com.google.gson;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public abstract enum FieldNamingPolicy extends Enum<FieldNamingPolicy> implements c {
    private static final /* synthetic */ FieldNamingPolicy[] $VALUES = null;
    public static final FieldNamingPolicy IDENTITY = null;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DASHES = null;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DOTS = null;
    public static final FieldNamingPolicy LOWER_CASE_WITH_UNDERSCORES = null;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE = null;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE_WITH_SPACES = null;
    public static final FieldNamingPolicy UPPER_CASE_WITH_UNDERSCORES = null;

    static {
        final String r10 = "IDENTITY";
        final int r11 = 0;
        FieldNamingPolicy r12 = new AnonymousClass1(r10, r11);
        IDENTITY = r12;
        final String r13 = "UPPER_CAMEL_CASE";
        final int r14 = 1;
        FieldNamingPolicy r15 = new AnonymousClass2(r13, r14);
        UPPER_CAMEL_CASE = r15;
        final String r16 = "UPPER_CAMEL_CASE_WITH_SPACES";
        final int r17 = 2;
        FieldNamingPolicy r18 = new AnonymousClass3(r16, r17);
        UPPER_CAMEL_CASE_WITH_SPACES = r18;
        final String r19 = "UPPER_CASE_WITH_UNDERSCORES";
        final int r20 = 3;
        FieldNamingPolicy r21 = new AnonymousClass4(r19, r20);
        UPPER_CASE_WITH_UNDERSCORES = r21;
        final String r22 = "LOWER_CASE_WITH_UNDERSCORES";
        final int r110 = 4;
        FieldNamingPolicy r23 = new AnonymousClass5(r22, r110);
        LOWER_CASE_WITH_UNDERSCORES = r23;
        final String r111 = "LOWER_CASE_WITH_DASHES";
        final int r112 = 5;
        FieldNamingPolicy r24 = new AnonymousClass6(r111, r112);
        LOWER_CASE_WITH_DASHES = r24;
        final String r113 = "LOWER_CASE_WITH_DOTS";
        final int r114 = 6;
        FieldNamingPolicy r115 = new AnonymousClass7(r113, r114);
        LOWER_CASE_WITH_DOTS = r115;
        $VALUES = new FieldNamingPolicy[]{r12, r15, r18, r21, r23, r24, r115};
    }

    private FieldNamingPolicy(String r10, int r11) {
        super(r10, r11);
    }

    /* synthetic */ FieldNamingPolicy(String r10, int r11, AnonymousClass1 r12) {
        this(r10, r11);
    }

    static String separateCamelCase(String r10, char r11) {
        StringBuilder r12 = new StringBuilder();
        int r13 = r10.length();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L11;
        char r15 = r10.charAt(r14);
        if (Character.isUpperCase(r15) == false) goto L9;
        if (r12.length() == 0) goto L9;
        r12.append(r11);
    L9:
        r12.append(r15);
        r14 = r14 + 1;
        goto L3
    L11:
        return r12.toString();
    }

    static String upperCaseFirstLetter(String r10) {
        int r11 = r10.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L16;
        char r13 = r10.charAt(r12);
        if (Character.isLetter(r13) == true) goto L7;
        r12 = r12 + 1;
        goto L3
    L7:
        if (Character.isUpperCase(r13) == false) goto L9;
        return r10;
    L9:
        char r14 = Character.toUpperCase(r13);
        if (r12 != 0) goto L14;
        return r14 + r10.substring(1);
    L14:
        return r10.substring(0, r12) + r14 + r10.substring(r12 + 1);
    L16:
        return r10;
    }

    public static FieldNamingPolicy valueOf(String r10) {
        return (FieldNamingPolicy) Enum.valueOf(FieldNamingPolicy.class, r10);
    }

    public static FieldNamingPolicy[] values() {
        return (FieldNamingPolicy[]) $VALUES.clone();
    }

    @Override // com.google.gson.c
    public abstract /* synthetic */ String translateName(Field r10);
}
