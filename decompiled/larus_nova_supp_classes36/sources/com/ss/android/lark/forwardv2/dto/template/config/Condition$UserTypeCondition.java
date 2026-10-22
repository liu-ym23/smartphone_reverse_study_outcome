package com.ss.android.lark.forwardv2.dto.template.config;

import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum Condition$UserTypeCondition extends Enum<Condition$UserTypeCondition> implements Serializable {
    public static final Condition$UserTypeCondition ALL_USER = null;
    public static final Condition$UserTypeCondition OTHERS = null;
    public static final Condition$UserTypeCondition SELF = null;
    public static final /* synthetic */ Condition$UserTypeCondition[] a = null;
    public static int offset;
    private final int value;

    static {
        Condition$UserTypeCondition r0 = new Condition$UserTypeCondition("ALL_USER", 0, 0);
        ALL_USER = r0;
        Condition$UserTypeCondition r1 = new Condition$UserTypeCondition("SELF", 1, 1);
        SELF = r1;
        Condition$UserTypeCondition r3 = new Condition$UserTypeCondition("OTHERS", 2, 2);
        OTHERS = r3;
        a = new Condition$UserTypeCondition[]{r0, r1, r3};
        offset = 2;
    }

    public static Condition$UserTypeCondition[] values() {
        return (Condition$UserTypeCondition[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = this.value;
        if (r0 != 0) goto L5;
        return "ALL_USER";
    L5:
        if (r0 != 1) goto L7;
        return "SELF";
    L7:
        if (r0 == 2) goto L10;
        return "null";
    L10:
        return "OTHERS";
    }

    public int getValue() {
        return this.value;
    }

    public static Condition$UserTypeCondition fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return OTHERS;
    L12:
        return SELF;
    L14:
        return ALL_USER;
    }

    public static Condition$UserTypeCondition valueOf(String r1) {
        return (Condition$UserTypeCondition) a.a(Condition$UserTypeCondition.class, r1);
    }

    public Condition$UserTypeCondition(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
