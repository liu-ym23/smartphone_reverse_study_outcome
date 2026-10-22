package com.ss.android.lark.forwardv2.dto.template.config;

import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum Condition$ShieldTypeCondition extends Enum<Condition$ShieldTypeCondition> implements Serializable {
    public static final Condition$ShieldTypeCondition ALL = null;
    public static final Condition$ShieldTypeCondition NORMAL = null;
    public static final Condition$ShieldTypeCondition SHIELD = null;
    public static final /* synthetic */ Condition$ShieldTypeCondition[] a = null;
    public static int offset;
    private final int value;

    static {
        Condition$ShieldTypeCondition r0 = new Condition$ShieldTypeCondition("ALL", 0, 0);
        ALL = r0;
        Condition$ShieldTypeCondition r1 = new Condition$ShieldTypeCondition("SHIELD", 1, 1);
        SHIELD = r1;
        Condition$ShieldTypeCondition r3 = new Condition$ShieldTypeCondition("NORMAL", 2, 2);
        NORMAL = r3;
        a = new Condition$ShieldTypeCondition[]{r0, r1, r3};
        offset = 8;
    }

    public static Condition$ShieldTypeCondition[] values() {
        return (Condition$ShieldTypeCondition[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = this.value;
        if (r0 != 0) goto L5;
        return "ALL";
    L5:
        if (r0 != 1) goto L7;
        return "SHIELD";
    L7:
        if (r0 == 2) goto L10;
        return "null";
    L10:
        return "NORMAL";
    }

    public int getValue() {
        return this.value;
    }

    public static Condition$ShieldTypeCondition fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return NORMAL;
    L12:
        return SHIELD;
    L14:
        return ALL;
    }

    public static Condition$ShieldTypeCondition valueOf(String r1) {
        return (Condition$ShieldTypeCondition) a.a(Condition$ShieldTypeCondition.class, r1);
    }

    public Condition$ShieldTypeCondition(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
