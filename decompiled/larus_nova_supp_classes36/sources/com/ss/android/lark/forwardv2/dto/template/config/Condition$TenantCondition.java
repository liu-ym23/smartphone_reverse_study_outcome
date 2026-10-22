package com.ss.android.lark.forwardv2.dto.template.config;

import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum Condition$TenantCondition extends Enum<Condition$TenantCondition> implements Serializable {
    public static final Condition$TenantCondition ALL_TENANT = null;
    public static final Condition$TenantCondition CROSS_TENANT = null;
    public static final Condition$TenantCondition NOT_CROSS_TENANT = null;
    public static final /* synthetic */ Condition$TenantCondition[] a = null;
    public static int offset;
    private final int value;

    static {
        Condition$TenantCondition r0 = new Condition$TenantCondition("ALL_TENANT", 0, 0);
        ALL_TENANT = r0;
        Condition$TenantCondition r1 = new Condition$TenantCondition("NOT_CROSS_TENANT", 1, 1);
        NOT_CROSS_TENANT = r1;
        Condition$TenantCondition r3 = new Condition$TenantCondition("CROSS_TENANT", 2, 2);
        CROSS_TENANT = r3;
        a = new Condition$TenantCondition[]{r0, r1, r3};
        offset = 0;
    }

    public static Condition$TenantCondition[] values() {
        return (Condition$TenantCondition[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = this.value;
        if (r0 != 0) goto L5;
        return "ALL_TENANT";
    L5:
        if (r0 != 1) goto L7;
        return "NOT_CROSS_TENANT";
    L7:
        if (r0 == 2) goto L10;
        return "null";
    L10:
        return "CROSS_TENANT";
    }

    public int getValue() {
        return this.value;
    }

    public static Condition$TenantCondition fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return CROSS_TENANT;
    L12:
        return NOT_CROSS_TENANT;
    L14:
        return ALL_TENANT;
    }

    public static Condition$TenantCondition valueOf(String r1) {
        return (Condition$TenantCondition) a.a(Condition$TenantCondition.class, r1);
    }

    public Condition$TenantCondition(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
