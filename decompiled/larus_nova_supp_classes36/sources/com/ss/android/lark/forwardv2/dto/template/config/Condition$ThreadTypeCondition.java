package com.ss.android.lark.forwardv2.dto.template.config;

import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum Condition$ThreadTypeCondition extends Enum<Condition$ThreadTypeCondition> implements Serializable {
    public static final Condition$ThreadTypeCondition ALL_THREAD = null;
    public static final Condition$ThreadTypeCondition CHAT_THREAD = null;
    public static final Condition$ThreadTypeCondition MSG_THREAD = null;
    public static final /* synthetic */ Condition$ThreadTypeCondition[] a = null;
    public static int offset;
    private final int value;

    static {
        Condition$ThreadTypeCondition r0 = new Condition$ThreadTypeCondition("ALL_THREAD", 0, 0);
        ALL_THREAD = r0;
        Condition$ThreadTypeCondition r1 = new Condition$ThreadTypeCondition("CHAT_THREAD", 1, 1);
        CHAT_THREAD = r1;
        Condition$ThreadTypeCondition r3 = new Condition$ThreadTypeCondition("MSG_THREAD", 2, 2);
        MSG_THREAD = r3;
        a = new Condition$ThreadTypeCondition[]{r0, r1, r3};
        offset = 10;
    }

    public static Condition$ThreadTypeCondition[] values() {
        return (Condition$ThreadTypeCondition[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = this.value;
        if (r0 != 0) goto L5;
        return "ALL_THREAD";
    L5:
        if (r0 != 1) goto L7;
        return "CHAT_THREAD";
    L7:
        if (r0 == 2) goto L10;
        return "null";
    L10:
        return "MSG_THREAD";
    }

    public int getValue() {
        return this.value;
    }

    public static Condition$ThreadTypeCondition fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return MSG_THREAD;
    L12:
        return CHAT_THREAD;
    L14:
        return ALL_THREAD;
    }

    public static Condition$ThreadTypeCondition valueOf(String r1) {
        return (Condition$ThreadTypeCondition) a.a(Condition$ThreadTypeCondition.class, r1);
    }

    public Condition$ThreadTypeCondition(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
