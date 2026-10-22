package com.ss.android.lark.forwardv2.dto.template.config;

import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum Condition$GroupChatTypeCondition extends Enum<Condition$GroupChatTypeCondition> implements Serializable {
    public static final Condition$GroupChatTypeCondition ALL_CHAT = null;
    public static final Condition$GroupChatTypeCondition DEFAULT_CHAT = null;
    public static final Condition$GroupChatTypeCondition THREAD_CHAT = null;
    public static final /* synthetic */ Condition$GroupChatTypeCondition[] a = null;
    public static int offset;
    private final int value;

    static {
        Condition$GroupChatTypeCondition r0 = new Condition$GroupChatTypeCondition("ALL_CHAT", 0, 0);
        ALL_CHAT = r0;
        Condition$GroupChatTypeCondition r1 = new Condition$GroupChatTypeCondition("DEFAULT_CHAT", 1, 1);
        DEFAULT_CHAT = r1;
        Condition$GroupChatTypeCondition r3 = new Condition$GroupChatTypeCondition("THREAD_CHAT", 2, 2);
        THREAD_CHAT = r3;
        a = new Condition$GroupChatTypeCondition[]{r0, r1, r3};
        offset = 4;
    }

    public static Condition$GroupChatTypeCondition[] values() {
        return (Condition$GroupChatTypeCondition[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = this.value;
        if (r0 != 0) goto L5;
        return "ALL_CHAT";
    L5:
        if (r0 != 1) goto L7;
        return "DEFAULT_CHAT";
    L7:
        if (r0 == 2) goto L10;
        return "null";
    L10:
        return "THREAD_CHAT";
    }

    public int getValue() {
        return this.value;
    }

    public static Condition$GroupChatTypeCondition fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return THREAD_CHAT;
    L12:
        return DEFAULT_CHAT;
    L14:
        return ALL_CHAT;
    }

    public static Condition$GroupChatTypeCondition valueOf(String r1) {
        return (Condition$GroupChatTypeCondition) a.a(Condition$GroupChatTypeCondition.class, r1);
    }

    public Condition$GroupChatTypeCondition(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
