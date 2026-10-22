package com.ss.android.lark.forwardv2.dto.template.config;

import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum Condition$PublicTypeCondition extends Enum<Condition$PublicTypeCondition> implements Serializable {
    public static final Condition$PublicTypeCondition ALL_STATUS = null;
    public static final Condition$PublicTypeCondition PRIVATE = null;
    public static final Condition$PublicTypeCondition PUBLIC = null;
    public static final /* synthetic */ Condition$PublicTypeCondition[] a = null;
    public static int offset;
    private final int value;

    static {
        Condition$PublicTypeCondition r0 = new Condition$PublicTypeCondition("ALL_STATUS", 0, 0);
        ALL_STATUS = r0;
        Condition$PublicTypeCondition r1 = new Condition$PublicTypeCondition("PUBLIC", 1, 1);
        PUBLIC = r1;
        Condition$PublicTypeCondition r3 = new Condition$PublicTypeCondition("PRIVATE", 2, 2);
        PRIVATE = r3;
        a = new Condition$PublicTypeCondition[]{r0, r1, r3};
        offset = 6;
    }

    public static Condition$PublicTypeCondition[] values() {
        return (Condition$PublicTypeCondition[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = this.value;
        if (r0 != 0) goto L5;
        return "ALL_STATUS";
    L5:
        if (r0 != 1) goto L7;
        return "PUBLIC";
    L7:
        if (r0 == 2) goto L10;
        return "null";
    L10:
        return "PRIVATE";
    }

    public int getValue() {
        return this.value;
    }

    public static Condition$PublicTypeCondition fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return PRIVATE;
    L12:
        return PUBLIC;
    L14:
        return ALL_STATUS;
    }

    public static Condition$PublicTypeCondition valueOf(String r1) {
        return (Condition$PublicTypeCondition) a.a(Condition$PublicTypeCondition.class, r1);
    }

    public Condition$PublicTypeCondition(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
