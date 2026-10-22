package com.larus.dora.impl.frameassembler;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/dora/impl/frameassembler/DoraIncompleteReason;", "", "<init>", "(Ljava/lang/String;I)V", "TIMEOUT", "TOTAL_SEQ_MISMATCH", "RESOURCE_LIMIT", "EXPLICIT_CLOSE", "SEQ_MISMATCH", "UNKNOWN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraIncompleteReason extends Enum<DoraIncompleteReason> {
    public static final DoraIncompleteReason EXPLICIT_CLOSE = null;
    public static final DoraIncompleteReason RESOURCE_LIMIT = null;
    public static final DoraIncompleteReason SEQ_MISMATCH = null;
    public static final DoraIncompleteReason TIMEOUT = null;
    public static final DoraIncompleteReason TOTAL_SEQ_MISMATCH = null;
    public static final DoraIncompleteReason UNKNOWN = null;
    public static final /* synthetic */ DoraIncompleteReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraIncompleteReason> getEntries() {
        return b;
    }

    static {
        DoraIncompleteReason r0 = new DoraIncompleteReason("TIMEOUT", 0);
        TIMEOUT = r0;
        DoraIncompleteReason r1 = new DoraIncompleteReason("TOTAL_SEQ_MISMATCH", 1);
        TOTAL_SEQ_MISMATCH = r1;
        DoraIncompleteReason r3 = new DoraIncompleteReason("RESOURCE_LIMIT", 2);
        RESOURCE_LIMIT = r3;
        DoraIncompleteReason r5 = new DoraIncompleteReason("EXPLICIT_CLOSE", 3);
        EXPLICIT_CLOSE = r5;
        DoraIncompleteReason r7 = new DoraIncompleteReason("SEQ_MISMATCH", 4);
        SEQ_MISMATCH = r7;
        DoraIncompleteReason r9 = new DoraIncompleteReason("UNKNOWN", 5);
        UNKNOWN = r9;
        DoraIncompleteReason[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static DoraIncompleteReason[] values() {
        return (DoraIncompleteReason[]) a.clone();
    }

    public static DoraIncompleteReason valueOf(String r1) {
        return (DoraIncompleteReason) r27.a.a(DoraIncompleteReason.class, r1);
    }

    public DoraIncompleteReason(String r1, int r2) {
        super(r1, r2);
    }
}
