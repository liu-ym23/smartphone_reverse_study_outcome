package com.google.gson;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract enum ToNumberPolicy extends Enum<ToNumberPolicy> implements ToNumberStrategy {
    private static final /* synthetic */ ToNumberPolicy[] $VALUES = null;
    public static final ToNumberPolicy BIG_DECIMAL = null;
    public static final ToNumberPolicy DOUBLE = null;
    public static final ToNumberPolicy LAZILY_PARSED_NUMBER = null;
    public static final ToNumberPolicy LONG_OR_DOUBLE = null;

    static {
        final String r1 = "DOUBLE";
        final int r2 = 0;
        ToNumberPolicy r0 = new AnonymousClass1(r1, r2);
        DOUBLE = r0;
        final String r3 = "LAZILY_PARSED_NUMBER";
        final int r4 = 1;
        ToNumberPolicy r5 = new AnonymousClass2(r3, r4);
        LAZILY_PARSED_NUMBER = r5;
        final String r6 = "LONG_OR_DOUBLE";
        final int r7 = 2;
        ToNumberPolicy r8 = new AnonymousClass3(r6, r7);
        LONG_OR_DOUBLE = r8;
        final String r9 = "BIG_DECIMAL";
        final int r10 = 3;
        ToNumberPolicy r11 = new AnonymousClass4(r9, r10);
        BIG_DECIMAL = r11;
        $VALUES = new ToNumberPolicy[]{r0, r5, r8, r11};
    }

    private ToNumberPolicy(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ ToNumberPolicy(String r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    public static ToNumberPolicy valueOf(String r2) {
        return (ToNumberPolicy) ZeusTransformUtils.preCheckCast(Enum.valueOf(ToNumberPolicy.class, r2), ToNumberPolicy.class, "com.obric.memorydata.plugin");
    }

    public static ToNumberPolicy[] values() {
        return (ToNumberPolicy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ToNumberPolicy[].class, "com.obric.memorydata.plugin");
    }
}
