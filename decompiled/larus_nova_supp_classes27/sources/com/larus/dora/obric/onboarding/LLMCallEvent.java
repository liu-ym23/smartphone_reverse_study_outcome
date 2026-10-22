package com.larus.dora.obric.onboarding;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/dora/obric/onboarding/LLMCallEvent;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "START", "QUERY_END", "REPLY", "NEXT", "FINISH", "WEAR", "LINK", "NET", "INVALID", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LLMCallEvent extends Enum<LLMCallEvent> {
    public static final LLMCallEvent FINISH = null;
    public static final LLMCallEvent INVALID = null;
    public static final LLMCallEvent LINK = null;
    public static final LLMCallEvent NET = null;
    public static final LLMCallEvent NEXT = null;
    public static final LLMCallEvent QUERY_END = null;
    public static final LLMCallEvent REPLY = null;
    public static final LLMCallEvent START = null;
    public static final LLMCallEvent UNKNOWN = null;
    public static final LLMCallEvent WEAR = null;
    public static final /* synthetic */ LLMCallEvent[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<LLMCallEvent> getEntries() {
        return b;
    }

    static {
        LLMCallEvent r0 = new LLMCallEvent("UNKNOWN", 0);
        UNKNOWN = r0;
        LLMCallEvent r1 = new LLMCallEvent("START", 1);
        START = r1;
        LLMCallEvent r3 = new LLMCallEvent("QUERY_END", 2);
        QUERY_END = r3;
        LLMCallEvent r5 = new LLMCallEvent("REPLY", 3);
        REPLY = r5;
        LLMCallEvent r7 = new LLMCallEvent("NEXT", 4);
        NEXT = r7;
        LLMCallEvent r9 = new LLMCallEvent("FINISH", 5);
        FINISH = r9;
        LLMCallEvent r11 = new LLMCallEvent("WEAR", 6);
        WEAR = r11;
        LLMCallEvent r13 = new LLMCallEvent("LINK", 7);
        LINK = r13;
        LLMCallEvent r15 = new LLMCallEvent("NET", 8);
        NET = r15;
        LLMCallEvent r14 = new LLMCallEvent("INVALID", 9);
        INVALID = r14;
        LLMCallEvent[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static LLMCallEvent[] values() {
        return (LLMCallEvent[]) a.clone();
    }

    public static LLMCallEvent valueOf(String r1) {
        return (LLMCallEvent) r27.a.a(LLMCallEvent.class, r1);
    }

    public LLMCallEvent(String r1, int r2) {
        super(r1, r2);
    }
}
