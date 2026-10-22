package com.google.gson;

/* JADX INFO: loaded from: classes2.dex */
public abstract enum FieldNamingPolicy extends Enum<FieldNamingPolicy> implements FieldNamingStrategy {
    private static final /* synthetic */ FieldNamingPolicy[] $VALUES = null;
    public static final FieldNamingPolicy IDENTITY = null;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DASHES = null;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DOTS = null;
    public static final FieldNamingPolicy LOWER_CASE_WITH_UNDERSCORES = null;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE = null;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE_WITH_SPACES = null;
    public static final FieldNamingPolicy UPPER_CASE_WITH_UNDERSCORES = null;

    private static /* synthetic */ FieldNamingPolicy[] $values() {
        return new FieldNamingPolicy[]{IDENTITY, UPPER_CAMEL_CASE, UPPER_CAMEL_CASE_WITH_SPACES, UPPER_CASE_WITH_UNDERSCORES, LOWER_CASE_WITH_UNDERSCORES, LOWER_CASE_WITH_DASHES, LOWER_CASE_WITH_DOTS};
    }

    static {
        final String r5 = "IDENTITY";
        final int r10 = 0;
        IDENTITY = new AnonymousClass1(r5, r10);
        final String r11 = "UPPER_CAMEL_CASE";
        final int r12 = 1;
        UPPER_CAMEL_CASE = new AnonymousClass2(r11, r12);
        final String r13 = "UPPER_CAMEL_CASE_WITH_SPACES";
        final int r14 = 2;
        UPPER_CAMEL_CASE_WITH_SPACES = new AnonymousClass3(r13, r14);
        final String r15 = "UPPER_CASE_WITH_UNDERSCORES";
        final int r16 = 3;
        UPPER_CASE_WITH_UNDERSCORES = new AnonymousClass4(r15, r16);
        final String r17 = "LOWER_CASE_WITH_UNDERSCORES";
        final int r18 = 4;
        LOWER_CASE_WITH_UNDERSCORES = new AnonymousClass5(r17, r18);
        final String r19 = "LOWER_CASE_WITH_DASHES";
        final int r20 = 5;
        LOWER_CASE_WITH_DASHES = new AnonymousClass6(r19, r20);
        final String r21 = "LOWER_CASE_WITH_DOTS";
        final int r22 = 6;
        LOWER_CASE_WITH_DOTS = new AnonymousClass7(r21, r22);
        $VALUES = $values();
    }

    private FieldNamingPolicy(String r5, int r10) {
        super(r5, r10);
    }

    public static String separateCamelCase(String r5, char r10) {
        StringBuilder r11 = new StringBuilder();
        int r12 = r5.length();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L11;
        char r14 = r5.charAt(r13);
        if (Character.isUpperCase(r14) == false) goto L9;
        if (r11.length() == 0) goto L9;
        r11.append(r10);
    L9:
        r11.append(r14);
        r13 = r13 + 1;
        goto L3
    L11:
        return r11.toString();
    }

    public static String upperCaseFirstLetter(String r5) {
        int r10 = r5.length();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L16;
        char r12 = r5.charAt(r11);
        if (Character.isLetter(r12) == true) goto L7;
        r11 = r11 + 1;
        goto L3
    L7:
        if (Character.isUpperCase(r12) == false) goto L9;
        return r5;
    L9:
        char r13 = Character.toUpperCase(r12);
        if (r11 != 0) goto L14;
        return r13 + r5.substring(1);
    L14:
        return r5.substring(0, r11) + r13 + r5.substring(r11 + 1);
    L16:
        return r5;
    }

    public static FieldNamingPolicy valueOf(String r5) {
        return (FieldNamingPolicy) Enum.valueOf(FieldNamingPolicy.class, r5);
    }

    public static FieldNamingPolicy[] values() {
        return (FieldNamingPolicy[]) $VALUES.clone();
    }

    public /* synthetic */ FieldNamingPolicy(String r5, int r10, AnonymousClass1 r11) {
        this(r5, r10);
    }
}
